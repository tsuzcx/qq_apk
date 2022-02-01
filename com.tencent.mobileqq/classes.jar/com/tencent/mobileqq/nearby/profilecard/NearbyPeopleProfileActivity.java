package com.tencent.mobileqq.nearby.profilecard;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.jungle.nearby.nio.proto.nearby.Cmd0x1RspBody;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarConfig;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.dating.DatingProxyManager;
import com.tencent.mobileqq.dating.NearbyCGIReporter;
import com.tencent.mobileqq.dating.widget.VoteEventMgr;
import com.tencent.mobileqq.fpsreport.OnDrawCompleteListener;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.NearPeopleFilters;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.api.NearbyProxy;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity;
import com.tencent.mobileqq.nearby.widget.BlueButtonInfo;
import com.tencent.mobileqq.nearby.widget.NearbyCustomDialog;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.OnInterceptTouchEventListener;
import com.tencent.mobileqq.widget.PerfRelativeLayout;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.ProfilePerformanceReport;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

@RoutePage(desc="附近资料卡", path="/nearby/people/profile")
public class NearbyPeopleProfileActivity
  extends BaseActivity
  implements INearbyPeopleProfile, OnInterceptTouchEventListener
{
  public static final String APPOINTED_BACK_PATH_FLAG = "abp_flag";
  public static final String ON_SAVE_NEED_REPORT = "ON_SAVE_NEED_REPORT";
  public static final String TAG = "NearbyPeopleProfileActivity";
  public static HashMap<String, Integer> mBidIsExistMap = new HashMap();
  public static int testGiftCount = 0;
  AllInOne allinone;
  protected AvatarObserver avatarObserver = new NearbyPeopleProfileActivity.12(this);
  int bigImageWidth;
  private int dataReportSource = 6;
  public boolean enteredEditMode = false;
  int fetchFromType;
  protected FriendListObserver friendListObserver = new NearbyPeopleProfileActivity.14(this);
  protected FriendObserver friendObserver = new NearbyPeopleProfileActivity.13(this);
  public int from = 0;
  boolean hasReqLikeLimitInfo = false;
  int imageWidth;
  boolean isFaceInfoChange = false;
  boolean isFriend = false;
  public boolean isHasRequestShowPayFirstTip;
  public boolean mABPFlag = false;
  protected ConditionSearchManager.IConfigListener mAddressListener = new NearbyPeopleProfileActivity.21(this);
  String mAlbumId;
  Dialog mCancelAlertDialog = null;
  private NearbyPeopleCard mCard;
  INearbyCardHandler mCardHandler;
  ConditionSearchManager mConditionSearchManager;
  ConditionSearchManager.IConfigListener mConfigListener = new NearbyPeopleProfileActivity.20(this);
  String mDateId;
  float mDensity;
  private NearbyProfileDisplayBasePanel mDisplayModel;
  private View mDisplayPanel;
  private NearbyPeopleProfileActivity.DownloadHDAvatarRunnable mDownloadHDAvatarRunnable;
  OnDrawCompleteListener mDrawComLis = new NearbyPeopleProfileActivity.26(this);
  private DynamicAvatarDownloadManager mDynamicAvatarDownloadManager;
  public int mDynamicAvatarFPS = 18;
  private DynamicAvatarManager mDynamicAvatarManager;
  private NearbyProfileEditBasePanel mEditModel;
  private View mEditPanel;
  private int mEditSuccessCount = 0;
  int mEnterEidtTimes = 0;
  Intent mEnterProfileIntent;
  String mFromDatingId;
  int mFromDatingSubject;
  String mGetHeadUrl;
  Handler mHandler = new NearbyPeopleProfileActivity.4(this);
  boolean mHasEverVote = false;
  boolean mHasFetchedProfile = false;
  boolean mHasNewPhoto = true;
  int mHeadSize = -1;
  HotChatObserver mHotChatObserver = new NearbyPeopleProfileActivity.16(this);
  boolean mIsForceUpdateOnResume = false;
  boolean mIsFromInterestTest = false;
  public boolean mIsFromWeb = false;
  boolean mIsNeedUpdateProfile = true;
  public boolean mIsPlayDynamicAvatar;
  int mIsProfileOk = 0;
  boolean mIsPub;
  private boolean mIsRefreshStangerFace = false;
  boolean mIsUpdatedHDAvatar = false;
  boolean mIsUsingBigHead = false;
  private boolean mIsWindowFocusChanged = false;
  boolean mLostGodFlag = false;
  int mMode;
  public NearbyCardObserver mNearbyCardObserver = new NearbyPeopleProfileActivity.17(this);
  boolean mNeedClearPhotoWallWhenCancel = false;
  boolean mNeedUpdateProfile = true;
  private long mNowId;
  private int mNowUserType;
  ArrayList<PicInfo> mPicInfo = new ArrayList(13);
  ArrayList<PicInfo> mPicInfoBackup = new ArrayList(13);
  QQProgressDialog mProgressDialog;
  Dialog mPromptDialog = null;
  private Runnable mRefreshStrangerFaceRunnable = null;
  private boolean mResumeFlag;
  private boolean mResumeFromStop = false;
  private ViewGroup mRootContainer;
  public int mSchoolNameValidState;
  StatusManager mStatusManager;
  public long mTinyId;
  private int mTitleBarHeight;
  public TopGestureLayout mTopGestureLayout;
  public String mUin;
  protected DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback mVideoHeadDownloadListener = new NearbyPeopleProfileActivity.19(this);
  PicInfo mVideoInfo;
  public int mVoteBtnClickTimes;
  private boolean needReport = true;
  public URLDrawable voteTipDrawable;
  public volatile boolean waitingForSayhelloLimit = false;
  
  public static boolean isFromTribe(int paramInt)
  {
    if (paramInt == 22) {
      return true;
    }
    return (paramInt >= 7) && (paramInt <= 12) && (paramInt != 11);
  }
  
  private boolean noValidTinyIdAndUin()
  {
    return (this.mTinyId <= 0L) && ("0".equals(this.allinone.uin));
  }
  
  private static void openProfileCard(Context paramContext, AllInOne paramAllInOne, Bundle paramBundle)
  {
    openProfileCard(paramContext, paramAllInOne, paramBundle, 6);
  }
  
  private static void openProfileCard(Context paramContext, AllInOne paramAllInOne, Bundle paramBundle, int paramInt)
  {
    if (paramContext != null) {
      try
      {
        Intent localIntent = new Intent(paramContext, NearbyPeopleProfileActivity.class);
        localIntent.putExtra("AllInOne", paramAllInOne);
        localIntent.putExtras(paramBundle);
        localIntent.putExtra("frome_where", paramInt);
        localIntent.addFlags(536870912);
        if (!(paramContext instanceof Activity)) {
          localIntent.addFlags(268435456);
        }
        paramContext.startActivity(localIntent);
        return;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
        }
      }
    }
  }
  
  public static void openProfileCardForResult(Activity paramActivity, AllInOne paramAllInOne, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    if (paramActivity != null) {
      try
      {
        Intent localIntent = new Intent(paramActivity, NearbyPeopleProfileActivity.class);
        localIntent.putExtra("AllInOne", paramAllInOne);
        localIntent.putExtras(paramBundle);
        localIntent.putExtra("frome_where", paramInt1);
        localIntent.addFlags(536870912);
        if (!(paramActivity instanceof Activity)) {
          localIntent.addFlags(268435456);
        }
        paramActivity.startActivityForResult(localIntent, paramInt2);
        return;
      }
      catch (Exception paramActivity)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, paramActivity.toString());
        }
      }
    }
  }
  
  private void reportProfileCardShow()
  {
    JSONObject localJSONObject;
    if (this.needReport)
    {
      if (noValidTinyIdAndUin()) {
        return;
      }
      localJSONObject = getNearbyReportJson();
      if (localJSONObject == null) {
        return;
      }
    }
    try
    {
      localJSONObject.put("module", "overall_page");
      localJSONObject.put("action", "view");
      this.needReport = false;
      new NearbyCGIReporter().a(localJSONObject);
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  private void reportUploadPic()
  {
    ReportController.b(this.app, "dc00899", "grp_lbs", "", "data_card", "up_pho", 0, 0, "", "", "", "");
  }
  
  protected void backupPhotoWall()
  {
    this.mPicInfoBackup.clear();
    this.mPicInfoBackup.addAll(this.mPicInfo);
  }
  
  public void checkIsFriend()
  {
    boolean bool = this.isFriend;
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager != null) {
      bool = localFriendsManager.b(this.mCard.uin);
    }
    if (bool != this.isFriend)
    {
      this.isFriend = bool;
      runOnUiThread(new NearbyPeopleProfileActivity.15(this));
    }
  }
  
  public NearbyProfileDisplayBasePanel createNearbyDisplayPanel(int paramInt)
  {
    if (isFromTribe(paramInt)) {
      return new NearbyProfileDisplayTribePanel(this);
    }
    return new NearbyProfileDisplayPanel(this);
  }
  
  public NearbyProfileEditBasePanel createNearbyEditPanel(int paramInt)
  {
    if (isFromTribe(paramInt)) {
      return new NearbyProfileEditTribePanel(this);
    }
    return new NearbyProfileEditPanel(this);
  }
  
  void dismissWaittingDialog()
  {
    QQProgressDialog localQQProgressDialog = this.mProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.mProgressDialog.dismiss();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    NearbyProfileEditBasePanel localNearbyProfileEditBasePanel;
    if (paramInt1 == 14)
    {
      localNearbyProfileEditBasePanel = this.mEditModel;
      if (localNearbyProfileEditBasePanel != null)
      {
        localNearbyProfileEditBasePanel.a(paramInt1, paramInt2, paramIntent);
        return;
      }
    }
    if (this.mMode == 1)
    {
      localNearbyProfileEditBasePanel = this.mEditModel;
      if (localNearbyProfileEditBasePanel != null)
      {
        localNearbyProfileEditBasePanel.a(paramInt1, paramInt2, paramIntent);
        return;
      }
    }
    this.mDisplayModel.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    getIntent().putExtra("fling_action_key", 0);
    Object localObject = getIntent().getStringExtra("big_brother_source_key");
    this.dataReportSource = getIntent().getIntExtra("data_report_source", 6);
    boolean bool;
    if ((paramBundle != null) && (!paramBundle.getBoolean("ON_SAVE_NEED_REPORT", true))) {
      bool = false;
    } else {
      bool = true;
    }
    this.needReport = bool;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      getIntent().putExtra("big_brother_source_key", "biz_src_hdsp_nearby");
    }
    localObject = ProfilePerformanceReport.a;
    if ((localObject != null) && (((ProfilePerformanceReport)localObject).a()))
    {
      ((ProfilePerformanceReport)localObject).b(0);
      ((ProfilePerformanceReport)localObject).a(1);
    }
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = true;
    if (paramBundle != null) {
      paramBundle.putParcelable("android:support:fragments", null);
    }
    super.doOnCreate(paramBundle);
    this.app.addObserver(this.mNearbyCardObserver);
    this.mEnterProfileIntent = getIntent();
    if ((this.app.isLogin()) && (this.mEnterProfileIntent != null)) {}
    try
    {
      super.setContentView(2131561212);
      getWindow().setBackgroundDrawable(null);
      this.mDensity = getResources().getDisplayMetrics().density;
      this.mTitleBarHeight = getTitleBarHeight();
      this.imageWidth = (getResources().getDisplayMetrics().widthPixels / 3);
      this.bigImageWidth = getResources().getDisplayMetrics().widthPixels;
      this.mCardHandler = ((INearbyCardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER));
      this.mStatusManager = ((StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER));
      this.mConditionSearchManager = ((ConditionSearchManager)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
      this.mConditionSearchManager.a(this);
      this.mConditionSearchManager.c(this.mAddressListener);
      this.mDynamicAvatarManager = ((DynamicAvatarManager)this.app.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER));
      this.mDynamicAvatarDownloadManager = this.mDynamicAvatarManager.a();
      if ((this.mDynamicAvatarManager.a(4)) && (this.mDynamicAvatarManager.a())) {
        bool = true;
      } else {
        bool = false;
      }
      this.mIsPlayDynamicAvatar = bool;
      if (this.mDynamicAvatarManager.a() != null)
      {
        this.mDynamicAvatarFPS = this.mDynamicAvatarManager.a().d;
        i = this.mDynamicAvatarFPS;
        if ((i < 0) || (i > 30)) {
          this.mDynamicAvatarFPS = 18;
        }
      }
      try
      {
        this.allinone = ((AllInOne)this.mEnterProfileIntent.getParcelableExtra("AllInOne"));
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getIntent() exception:");
          localStringBuilder.append(paramBundle.getMessage());
          QLog.d("Q.nearby_people_card.", 2, localStringBuilder.toString());
        }
      }
      if (this.allinone == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby_people_card.", 2, "passed allinone is null!!");
        }
        finish();
        return true;
      }
      this.from = this.mEnterProfileIntent.getIntExtra("frome_where", 0);
      if (this.from == 35) {
        AlbumUtil.anim(this, false, true);
      }
      if (isFromTribe(this.from))
      {
        this.fetchFromType = 51;
      }
      else
      {
        this.fetchFromType = this.allinone.profileEntryType;
        this.from = getReportTypeFromProfileType(this.allinone.profileEntryType);
      }
      int i = this.mEnterProfileIntent.getIntExtra("param_mode", 0);
      if (((i == 2) || (i == 1)) && (TextUtils.isEmpty(this.allinone.uin))) {
        this.allinone.uin = this.app.getAccount();
      }
      this.mMode = this.mEnterProfileIntent.getIntExtra("param_mode", 0);
      this.mIsFromInterestTest = this.mEnterProfileIntent.getBooleanExtra("param_from_interest_test", false);
      this.mTinyId = this.mEnterProfileIntent.getLongExtra("param_tiny_id", 0L);
      this.mNowId = this.mEnterProfileIntent.getLongExtra("now_id", 0L);
      this.mNowUserType = this.mEnterProfileIntent.getIntExtra("now_id_type", 0);
      this.mRootContainer = ((ViewGroup)findViewById(2131365132));
      if (this.mMode == 1)
      {
        this.mEditModel = createNearbyEditPanel(this.from);
        this.mEditPanel = this.mEditModel.a();
        this.mRootContainer.addView(this.mEditPanel, new FrameLayout.LayoutParams(-1, -1));
        this.mEnterEidtTimes += 1;
        this.enteredEditMode = true;
      }
      else
      {
        this.mFromDatingId = this.mEnterProfileIntent.getStringExtra("param_dating_id");
        this.mFromDatingSubject = this.mEnterProfileIntent.getIntExtra("param_dating_subject", 0);
        this.mIsPub = this.mEnterProfileIntent.getBooleanExtra("param_dating_pub", false);
        this.mDisplayModel = createNearbyDisplayPanel(this.from);
        this.mDisplayPanel = this.mDisplayModel.a();
        this.mDisplayModel.a();
        paramBundle = this.mDisplayPanel;
        if ((paramBundle instanceof PerfRelativeLayout)) {
          ((PerfRelativeLayout)paramBundle).setOnDrawCompleteListener(this.mDrawComLis);
        }
        this.mRootContainer.addView(this.mDisplayPanel, new FrameLayout.LayoutParams(-1, -1));
      }
      paramBundle = this.mDynamicAvatarDownloadManager;
      if (paramBundle != null) {
        paramBundle.a(this.mVideoHeadDownloadListener);
      }
      showWaitingDialog(HardCodeUtil.a(2131707272));
      ThreadManager.post(new NearbyPeopleProfileActivity.1(this), 5, null, false);
      if ((localObject != null) && (((ProfilePerformanceReport)localObject).a())) {
        ((ProfilePerformanceReport)localObject).a(4);
      }
      ThreadManager.post(new NearbyPeopleProfileActivity.2(this, (ProfilePerformanceReport)localObject), 8, null, false);
      paramBundle = (DatingProxyManager)this.app.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
      if (paramBundle.a().a() > 0) {
        paramBundle.a().a();
      }
      paramBundle = this.allinone;
      if ((paramBundle != null) && (paramBundle.profileEntryType != 999)) {
        i = this.allinone.profileEntryType;
      } else {
        i = 30;
      }
      ViewExposeUtil.a(this.app, getClass(), hashCode(), "0X8004CC5", i, String.valueOf(this.mTinyId));
      return true;
    }
    catch (OutOfMemoryError paramBundle)
    {
      label1098:
      break label1098;
    }
    finish();
    return false;
    finish();
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.mNearbyCardObserver);
    Object localObject = this.mHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.mConditionSearchManager;
    if (localObject != null)
    {
      ((ConditionSearchManager)localObject).d(this.mAddressListener);
      this.mConditionSearchManager.d(this.mConfigListener);
      this.mConditionSearchManager.b(this);
    }
    localObject = this.mEditModel;
    if (localObject != null) {
      ((NearbyProfileEditBasePanel)localObject).a();
    }
    localObject = NearbyManagerHelper.a(this.app).a();
    int k = 0;
    int i;
    if (localObject != null) {
      i = NearbyManagerHelper.a(this.app).a().size();
    } else {
      i = 0;
    }
    localObject = this.mDisplayModel;
    int j;
    if (localObject != null)
    {
      j = ((NearbyProfileDisplayBasePanel)localObject).b();
      this.mDisplayModel.g();
    }
    else
    {
      j = 0;
    }
    localObject = (NearbyPeoplePhotoUploadProcessor)((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).findProcessor(null, 0L);
    if (localObject != null) {
      ((NearbyPeoplePhotoUploadProcessor)localObject).cancelTask();
    }
    try
    {
      if (this.mEnterProfileIntent.getIntExtra("frome_where", 0) == -2) {
        if (this.mEditSuccessCount > 0) {
          ReportController.b(this.app, "CliOper", "", "", "0X80059BB", "0X80059BB", 0, 0, "", "", "", "");
        } else {
          ReportController.b(this.app, "CliOper", "", "", "0X80059BC", "0X80059BC", 0, 0, "", "", "", "");
        }
      }
    }
    catch (Exception localException)
    {
      label291:
      int m;
      break label291;
    }
    localObject = this.mDisplayModel;
    if (localObject != null) {
      ((NearbyProfileDisplayBasePanel)localObject).b();
    }
    localObject = ViewExposeUtil.a(getClass(), hashCode());
    if (localObject != null)
    {
      ReportController.b(this.app, "CliOper", "", "", ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_Int, 0, String.valueOf(this.mTinyId), Long.toString(SystemClock.elapsedRealtime() - ((ViewExposeUtil.ViewExposeUnit)localObject).b), "", "");
      m = (int)(SystemClock.elapsedRealtime() - ((ViewExposeUtil.ViewExposeUnit)localObject).b) / 1000;
      if (NearbyProxy.a(this.allinone.profileEntryType, this.mMode)) {
        ((NearbyProxy)NearbyManagerHelper.a(this.app)).a(this.mTinyId, m, i, j);
      }
    }
    if (Build.BRAND.startsWith("samsung")) {
      try
      {
        localObject = Class.forName("android.text.MeasuredText").getDeclaredField("sCached");
        ((Field)localObject).setAccessible(true);
        localObject = (Object[])((Field)localObject).get(null);
        i = k;
        while (i < localObject.length)
        {
          localObject[i] = null;
          i += 1;
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    int i = 0;
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false))
    {
      doOnActivityResult(1000, -1, paramIntent);
      return;
    }
    if (this.mMode == 1)
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      Object localObject;
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        this.mAlbumId = null;
        while (i < paramIntent.size())
        {
          if (this.mPicInfo.size() < NearbyProfileCardConstants.jdField_a_of_type_Int)
          {
            localObject = new PicInfo();
            ((PicInfo)localObject).c = ((String)paramIntent.get(i));
            if (this.mEditModel.a((PicInfo)localObject)) {
              this.mHandler.sendEmptyMessageDelayed(100, 1000L);
            }
          }
          i += 1;
        }
      }
      if (!TextUtils.isEmpty(this.mAlbumId))
      {
        paramIntent = QZoneHelper.UserInfo.getInstance();
        paramIntent.qzone_uin = this.app.getCurrentAccountUin();
        paramIntent.nickname = this.app.getCurrentNickname();
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_title", getString(2131717454));
        ((Bundle)localObject).putInt("key_personal_album_enter_model", 2);
        ((Bundle)localObject).putBoolean("show_album", false);
        ((Bundle)localObject).putString("key_jump_album_id", this.mAlbumId);
        ((Bundle)localObject).putBoolean("key_need_change_to_jpg", true);
        QZoneHelper.forwardToPersonalAlbumSelect(this, paramIntent, (Bundle)localObject, 5);
      }
    }
    else
    {
      NearbyPublishMenuHelper.a(this, 1000, -1, paramIntent);
    }
  }
  
  protected void doOnPause()
  {
    Object localObject = this.mTopGestureLayout;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(true);
    }
    InputMethodUtil.a(this);
    this.app.removeObserver(this.friendListObserver);
    this.app.removeObserver(this.friendObserver);
    this.app.removeObserver(this.avatarObserver);
    this.app.removeObserver(this.mHotChatObserver);
    ApngImage.pauseAll();
    AbstractVideoImage.pauseAll();
    localObject = this.mDisplayModel;
    if (localObject != null) {
      ((NearbyProfileDisplayBasePanel)localObject).e();
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    Object localObject = this.mDisplayModel;
    if (localObject != null) {
      ((NearbyProfileDisplayBasePanel)localObject).d();
    }
    this.app.addObserver(this.friendListObserver);
    this.app.addObserver(this.friendObserver);
    this.app.addObserver(this.avatarObserver);
    this.app.addObserver(this.mHotChatObserver);
    ApngImage.playByTag(15);
    AbstractVideoImage.resumeAll();
    if (getApplication() == null)
    {
      finish();
      return;
    }
    super.doOnResume();
    this.mResumeFlag = true;
    localObject = (INearbyCardManager)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
    NearbyProfileDisplayBasePanel localNearbyProfileDisplayBasePanel = this.mDisplayModel;
    if ((localNearbyProfileDisplayBasePanel != null) && (localNearbyProfileDisplayBasePanel.a))
    {
      ((INearbyCardManager)localObject).a().put(this.app.getCurrentAccountUin(), Integer.valueOf(1));
      this.mDisplayModel.a = false;
    }
    this.mIsNeedUpdateProfile = ((INearbyCardManager)localObject).a(this.mCard);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnResume, isNeedUpdateProfile=");
      ((StringBuilder)localObject).append(this.mIsNeedUpdateProfile);
      ((StringBuilder)localObject).append(", isForceUpdateOnResume=");
      ((StringBuilder)localObject).append(this.mIsForceUpdateOnResume);
      QLog.d("NearbyPeopleProfileActivity", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = this.mIsNeedUpdateProfile;
    if ((!bool) && (!this.mIsForceUpdateOnResume))
    {
      if ((this.mResumeFromStop) && (this.mMode == 3))
      {
        localObject = this.mCard;
        if ((localObject != null) && (bool))
        {
          if (((NearbyPeopleCard)localObject).switchGiftVisible != 0L) {
            return;
          }
          updateProfile();
        }
      }
      this.mResumeFromStop = false;
      return;
    }
    this.mIsForceUpdateOnResume = false;
    updateProfile();
    this.mResumeFromStop = false;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    reportProfileCardShow();
    NearbyProfileDisplayBasePanel localNearbyProfileDisplayBasePanel = this.mDisplayModel;
    if (localNearbyProfileDisplayBasePanel != null) {
      localNearbyProfileDisplayBasePanel.c();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.mResumeFlag = false;
    this.mResumeFromStop = true;
    if (this.mMode == 2)
    {
      localObject = this.mDisplayModel;
      if ((localObject != null) && (((NearbyProfileDisplayBasePanel)localObject).a()))
      {
        this.mDisplayModel.h();
        localObject = this.mCard;
        if ((localObject != null) && (((NearbyPeopleCard)localObject).uRoomid != 0L))
        {
          localObject = this.mDisplayModel;
          if (localObject != null) {
            ((NearbyProfileDisplayBasePanel)localObject).i();
          }
        }
      }
    }
    Object localObject = ProfilePerformanceReport.a;
    if ((localObject != null) && (((ProfilePerformanceReport)localObject).a(true))) {
      ((ProfilePerformanceReport)localObject).a(this.app.getCurrentAccountUin());
    }
    localObject = this.mDisplayModel;
    if (localObject != null) {
      ((NearbyProfileDisplayBasePanel)localObject).f();
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (!this.mIsWindowFocusChanged)
    {
      this.mIsProfileOk = this.app.getPreferences().getInt("nearby_people_profile_ok_new", 0);
      this.mIsFromWeb = this.mEnterProfileIntent.getBooleanExtra("is_from_web", false);
      this.mABPFlag = this.mEnterProfileIntent.getBooleanExtra("abp_flag", false);
      if (this.mEnterProfileIntent.getIntExtra("frome_where", 0) == -1)
      {
        String str2 = this.mEnterProfileIntent.getStringExtra("PUSH_CONTENT");
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        ReportController.b(this.app, "CliOper", "", "", "0X800524A", "0X800524A", 0, 0, "", "", str1, "");
      }
      this.mIsWindowFocusChanged = true;
    }
  }
  
  void downDynamicAvatar(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.app != null)) {
      ThreadManager.post(new NearbyPeopleProfileActivity.23(this, paramString), 5, null, true);
    }
  }
  
  void downloadHDAvatar(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (this.mIsUpdatedHDAvatar)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NearbyPeopleProfileActivity", 2, "downloadHDAvatar is updated HDAvatar true");
      }
      return;
    }
    this.mDownloadHDAvatarRunnable = new NearbyPeopleProfileActivity.DownloadHDAvatarRunnable(this, paramString1, paramInt, paramString2, paramBoolean);
    ThreadManager.post(this.mDownloadHDAvatarRunnable, 5, null, true);
  }
  
  void editNearbyProfileCardResult(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("editNearbyProfileCardResult() called with: isSuccess = [");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append("], card = [");
      ((StringBuilder)localObject).append(paramNearbyPeopleCard);
      ((StringBuilder)localObject).append("], isHeadChanged = [");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append("], errorTips = [");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.i("NearbyPeopleProfileActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("editNearbyProfileCardResult|[");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramNearbyPeopleCard);
      ((StringBuilder)localObject).append("]");
      QLog.d("Q.nearby_people_card.update_profile", 2, ((StringBuilder)localObject).toString());
    }
    dismissWaittingDialog();
    if ((paramBoolean1) && (paramNearbyPeopleCard != null))
    {
      this.mNeedClearPhotoWallWhenCancel = false;
      showToast(2, HardCodeUtil.a(2131707274));
      if (!TextUtils.equals(this.mCard.college, paramNearbyPeopleCard.college))
      {
        ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.app.getCurrentAccountUin(), "school_name", paramNearbyPeopleCard.college);
        ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.app.getCurrentAccountUin(), "school_valid_state", Integer.valueOf(this.mSchoolNameValidState));
      }
      this.mCard = paramNearbyPeopleCard;
      if (this.mLostGodFlag)
      {
        this.mCard.godFlag = false;
        this.mLostGodFlag = false;
      }
      this.mPicInfo.clear();
      if ((this.mCard.picList != null) && (!this.mCard.picList.isEmpty()))
      {
        this.mPicInfo.addAll(this.mCard.picList);
        this.mHasNewPhoto = true;
      }
      this.mVideoInfo = this.mCard.videoInfo;
      if (paramBoolean2) {
        NearbyCardManager.b(this.app);
      }
      if (this.mIsProfileOk != 1) {
        onFirstEditeNearbyProfileSuccess();
      }
      if ((this.mPicInfo.isEmpty()) && (!this.mPicInfoBackup.isEmpty()))
      {
        this.mPicInfo.addAll(this.mPicInfoBackup);
        this.mPicInfoBackup.clear();
      }
      paramNearbyPeopleCard = this.mDisplayModel;
      if (paramNearbyPeopleCard != null) {
        paramNearbyPeopleCard.j();
      }
      this.mEnterProfileIntent.putExtra("param_mode", 2);
      switchToDisplayPanel();
      ThreadManager.post(new NearbyPeopleProfileActivity.25(this), 5, null, true);
      paramNearbyPeopleCard = new Intent();
      paramNearbyPeopleCard.putExtra("param_xuan_yan", this.mCard.xuanYan);
      paramNearbyPeopleCard.putExtra("param_nickname", this.mCard.nickname);
      paramNearbyPeopleCard.putExtra("param_gender", this.mCard.gender);
      paramNearbyPeopleCard.putExtra("param_age", this.mCard.age);
      paramNearbyPeopleCard.putExtra("param_career", this.mCard.job);
      paramNearbyPeopleCard.putExtra("param_constellation", this.mCard.constellation);
      paramNearbyPeopleCard.putExtra("param_marital_status", this.mCard.maritalStatus);
      paramNearbyPeopleCard.putExtra("param_god_flag", this.mCard.godFlag);
      int i = this.mPicInfo.size();
      paramNearbyPeopleCard.putExtra("param_photo_count", i);
      int j = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.app.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
      paramString = this.app;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(j);
      localStringBuilder.append("");
      ReportController.b(paramString, "dc00899", "grp_lbs", "", "data_card", "upload_suc", 0, 0, (String)localObject, localStringBuilder.toString(), "", "");
      setResult(-1, paramNearbyPeopleCard);
      if (this.enteredEditMode)
      {
        notifyWebViewIfNeeded(true);
        finish();
      }
    }
    else
    {
      if (TextUtils.isEmpty(paramString)) {
        showToast(1, HardCodeUtil.a(2131707271));
      } else {
        showToast(1, paramString);
      }
      this.mLostGodFlag = false;
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.mABPFlag) {
      overridePendingTransition(2130772002, 2130772003);
    }
  }
  
  JSONObject getNearbyReportJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("opername", "now#nearby#datacard");
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      localJSONObject.put("fromuin", this.app.getCurrentAccountUin());
      localJSONObject.put("appid", "406");
      long l = this.mTinyId;
      if (l > 0L) {
        localJSONObject.put("touin", String.valueOf(this.mTinyId));
      } else {
        localJSONObject.put("touin", this.allinone.uin);
      }
      localJSONObject.put("d5", String.valueOf(this.dataReportSource));
      return localJSONObject;
    }
    catch (Exception localException)
    {
      label124:
      break label124;
    }
    return null;
  }
  
  protected int getReportTypeFromProfileType(int paramInt)
  {
    int j = 5;
    int i;
    if (paramInt != 5) {
      if (paramInt != 10) {
        if (paramInt != 16) {
          if (paramInt != 99)
          {
            i = j;
            if (paramInt == 20) {
              return i;
            }
            if (paramInt != 21) {
              i = j;
            }
          }
        }
      }
    }
    switch (paramInt)
    {
    default: 
      return 11;
    case 32: 
    case 34: 
    case 35: 
      return 4;
      return 6;
      return 13;
      return 14;
      return 1;
      i = 3;
    }
    return i;
  }
  
  protected void gotoNearbyPeopleListActivity(boolean paramBoolean)
  {
    if (paramBoolean) {
      onFirstEditeNearbyProfileSuccess();
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004A1C", "0X8004A1C", 0, 0, "", "", "", "");
    if (this.mEnterProfileIntent.getBooleanExtra("param_no_miss", false)) {
      ReportController.b(this.app, "CliOper", "", "", "0X8004A1D", "0X8004A1D", 0, 0, "", "", "", "");
    }
  }
  
  protected void handleNearbyProfileCard(NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (this.mMode != 1))
    {
      this.mDisplayModel.b(paramNearbyPeopleCard);
      return;
    }
    this.mCard = paramNearbyPeopleCard;
    this.allinone.uin = this.mCard.uin;
    this.allinone.nickname = this.mCard.nickname;
    if (this.mCard.vTempChatSig != null) {
      this.allinone.chatCookie = this.mCard.vTempChatSig;
    }
    if (this.allinone.distanceTime != null) {
      this.mCard.aioDistanceAndTime = this.allinone.distanceTime;
    }
    if (this.mCard.godFlag) {
      NearbyProfileCardConstants.jdField_a_of_type_Int = 18;
    } else {
      NearbyProfileCardConstants.jdField_a_of_type_Int = 12;
    }
    if (this.mCard.godFlag) {
      if (this.mCard.gender == 0) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005286", "0X8005286", 0, 0, "", "", "", "");
      } else if (this.mCard.gender == 1) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005287", "0X8005287", 0, 0, "", "", "", "");
      }
    }
    this.mVideoInfo = this.mCard.videoInfo;
    if ((this.mCard.picList != null) && (!this.mCard.picList.isEmpty()))
    {
      this.mPicInfo.clear();
      this.mPicInfo.addAll(this.mCard.picList);
      this.mHasNewPhoto = true;
    }
    else if (1 != this.mMode)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "onNearbyCardDownload need to getQzoneCover.");
      }
      this.mHasNewPhoto = false;
    }
    if (this.mMode == 3) {
      if (Utils.a(this.app.getCurrentAccountUin(), this.mCard.getSafetyUin()))
      {
        this.mEnterProfileIntent.putExtra("param_mode", 2);
        this.mMode = 2;
      }
      else if (!TextUtils.isEmpty(this.mCard.getSafetyUin()))
      {
        paramNearbyPeopleCard = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (paramNearbyPeopleCard != null) {
          this.isFriend = paramNearbyPeopleCard.b(this.mCard.getSafetyUin());
        }
      }
    }
    if (this.mMode == 1) {
      this.mEditModel.a(this.mCard);
    } else {
      this.mDisplayModel.a(this.mCard);
    }
    if ((!this.hasReqLikeLimitInfo) && (this.mMode != 1) && (!this.isFriend))
    {
      this.hasReqLikeLimitInfo = true;
      int i;
      if (isFromTribe(this.from)) {
        i = 510;
      } else {
        i = 509;
      }
      this.mCardHandler.a(0L, this.mCard.tinyId, i);
    }
  }
  
  protected boolean isWrapContent()
  {
    return this.mMode != 1;
  }
  
  public void notifyExitProfile(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void notifyWebViewIfNeeded(boolean paramBoolean)
  {
    if (!this.enteredEditMode) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isSuccess", paramBoolean);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("*.qq.com");
      EventApiPlugin.a("nearbyUserSummaryInfoChange", localJSONObject, localArrayList, null);
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyPeopleProfileActivity", 2, localJSONException.toString());
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    int i = this.mEnterProfileIntent.getIntExtra("param_mode", 0);
    if (i == 1)
    {
      showCancelAlertDialog(2131699028);
      return true;
    }
    if ((i == 2) && (this.mMode == 1))
    {
      if (this.mIsProfileOk == 0)
      {
        showCancelAlertDialog(2131699028);
        return true;
      }
      if (this.mEditModel.a())
      {
        showCancelAlertDialog(2131699024);
        return true;
      }
      quitEditWithoutSaving();
      return true;
    }
    if (this.mABPFlag)
    {
      localIntent = new Intent(this, NearbyActivity.class);
      localIntent.putExtra("abp_flag", this.mABPFlag);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    Intent localIntent = new Intent();
    Object localObject = this.mCard;
    if (localObject != null)
    {
      localIntent.putExtra("nearby_profile_nickname", ((NearbyPeopleCard)localObject).nickname);
      localIntent.putExtra("param_gender", this.mCard.gender);
      localIntent.putExtra("param_vote_num", this.mCard.likeCount);
      localIntent.putExtra("param_vote_num_add", this.mCard.likeCountInc);
      localIntent.putExtra("param_level", this.mCard.charmLevel);
    }
    boolean bool;
    if ((getIntent().getBooleanExtra("from_newer_guide", false)) && (this.mCard != null))
    {
      localObject = this.app.getMessageFacade().b(this.mCard.uin, 1001);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((ChatMessage)((Iterator)localObject).next()).isSendFromLocal())
          {
            bool = true;
            break label315;
          }
        }
      }
      bool = false;
      label315:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onBackEvent hasSayHi: ");
        ((StringBuilder)localObject).append(bool);
        QLog.i("NearbyPeopleProfileActivity", 2, ((StringBuilder)localObject).toString());
      }
      localIntent.putExtra("has_operation", bool);
      localIntent.putExtra("uin", String.valueOf(this.mTinyId));
    }
    localIntent.putExtra("intent_key_has_ever_vote", this.mHasEverVote);
    localObject = this.mCard;
    if (localObject != null)
    {
      if ((((NearbyPeopleCard)localObject).videoInfo != null) && (!TextUtils.isEmpty(this.mCard.videoInfo.d))) {
        bool = true;
      } else {
        bool = false;
      }
      localIntent.putExtra("param_real_video_auth", bool);
      localObject = new nearby.Cmd0x1RspBody();
      try
      {
        if (this.mCard.nearbyInfo != null) {
          ((nearby.Cmd0x1RspBody)localObject).mergeFrom(this.mCard.nearbyInfo);
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Cmd0x1RspBody merge error !:");
          localStringBuilder.append(localInvalidProtocolBufferMicroException);
          QLog.e("NearbyPeopleProfileActivity", 2, localStringBuilder.toString());
        }
      }
      localIntent.putExtra("follow_flag", ((nearby.Cmd0x1RspBody)localObject).bool_follow.get());
    }
    setResult(-1, localIntent);
    if (getIntent().getIntExtra("frome_where", 0) == 35) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      finish();
      AlbumUtil.anim(this, false, false);
      return true;
    }
    return super.onBackEvent();
  }
  
  void onEnterChat()
  {
    this.dataReportSource = 5;
    this.needReport = true;
  }
  
  protected void onFirstEditeNearbyProfileSuccess()
  {
    NearPeopleFilters localNearPeopleFilters = new NearPeopleFilters();
    localNearPeopleFilters.a(-1);
    NearPeopleFilters.a(this.app.getCurrentAccountUin(), localNearPeopleFilters);
    this.mIsProfileOk = 1;
    this.app.getPreferences().edit().putInt("nearby_people_profile_ok_new", 1).commit();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    setInterceptTouchFlag(true);
    return false;
  }
  
  public void onSaveInstanceState(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    super.onSaveInstanceState(paramBundle, paramPersistableBundle);
    paramBundle.putBoolean("ON_SAVE_NEED_REPORT", this.needReport);
  }
  
  public boolean picInfoIsEqual(PicInfo paramPicInfo1, PicInfo paramPicInfo2)
  {
    if (paramPicInfo1 != null)
    {
      if (paramPicInfo2 == null) {
        return false;
      }
      return paramPicInfo1.jdField_a_of_type_Int == paramPicInfo2.jdField_a_of_type_Int;
    }
    return false;
  }
  
  void quitEditWithoutSaving()
  {
    InputMethodUtil.a(this);
    this.mPicInfo.clear();
    this.mPicInfo.addAll(this.mPicInfoBackup);
    this.mPicInfoBackup.clear();
    Object localObject = this.mDisplayModel;
    if (localObject != null) {
      ((NearbyProfileDisplayBasePanel)localObject).j();
    }
    if (this.mNeedClearPhotoWallWhenCancel)
    {
      this.mNeedUpdateProfile = false;
      this.mCardHandler.a(new ArrayList());
    }
    int i = this.mEnterProfileIntent.getIntExtra("param_mode", 0);
    if (i == 1)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004A1B", "0X8004A1B", 0, 0, "", "", "", "");
      if (this.mIsFromWeb)
      {
        if (this.mABPFlag)
        {
          localObject = new Intent(this, NearbyActivity.class);
          ((Intent)localObject).putExtra("abp_flag", this.mABPFlag);
          ((Intent)localObject).setFlags(67108864);
          startActivity((Intent)localObject);
        }
        finish();
      }
      else
      {
        gotoNearbyPeopleListActivity(false);
      }
    }
    else if ((i == 2) && (this.mMode == 1))
    {
      switchToDisplayPanel();
    }
    this.mNeedClearPhotoWallWhenCancel = false;
    notifyWebViewIfNeeded(false);
  }
  
  void refreshStrangerFace()
  {
    if ((this.mCard != null) && (!this.mIsRefreshStangerFace))
    {
      if (isFinishing()) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("NearbyPeopleProfileActivity", 2, "refreshStangerFace.");
      }
      this.mIsRefreshStangerFace = true;
      this.mRefreshStrangerFaceRunnable = new NearbyPeopleProfileActivity.24(this);
      ThreadManager.post(this.mRefreshStrangerFaceRunnable, 5, null, true);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    requestWindowFeature(1);
  }
  
  public void selectPhotoFromQZone()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = this.app.getCurrentAccountUin();
    localUserInfo.nickname = this.app.getCurrentNickname();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_title", getString(2131717454));
    localBundle.putInt("key_personal_album_enter_model", 2);
    localBundle.putBoolean("show_album", false);
    localBundle.putBoolean("key_need_change_to_jpg", true);
    QZoneHelper.forwardToPersonalAlbumSelect(this, localUserInfo, localBundle, 5);
    ReportController.b(this.app, "CliOper", "", "", "0X800481F", "0X800481F", 2, 0, "", "", "", "");
  }
  
  public void setInterceptTouchFlag(boolean paramBoolean)
  {
    if (this.mTopGestureLayout == null)
    {
      localObject = getWindow().getDecorView();
      if ((localObject != null) && ((localObject instanceof ViewGroup)))
      {
        localObject = ((ViewGroup)localObject).getChildAt(0);
        if ((localObject != null) && ((localObject instanceof TopGestureLayout))) {
          this.mTopGestureLayout = ((TopGestureLayout)localObject);
        }
      }
    }
    Object localObject = this.mTopGestureLayout;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
  }
  
  void showBigPhoto(int paramInt, Rect paramRect)
  {
    Object localObject = this.mPicInfo;
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      localObject = new Intent(this, NearbyProfilePicBrowserActivity.class);
      ((Intent)localObject).putExtra("intent_param_index", paramInt);
      ((Intent)localObject).putExtra("intent_param_pic_infos", this.mPicInfo);
      ((Intent)localObject).putExtra("report_visited_pic", true);
      ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", paramRect);
      ((Intent)localObject).addFlags(536870912);
      startActivity((Intent)localObject);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showBigPhoto, currentPosition = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", rect = ");
      ((StringBuilder)localObject).append(paramRect);
      ((StringBuilder)localObject).append(", mPicInfo.size = ");
      paramRect = this.mPicInfo;
      if (paramRect == null) {
        paramRect = "null";
      } else {
        paramRect = Integer.valueOf(paramRect.size());
      }
      ((StringBuilder)localObject).append(paramRect);
      QLog.e("NearbyPeopleProfileActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  void showBigPhoto(PicInfo paramPicInfo, Rect paramRect)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramPicInfo);
    paramPicInfo = new Intent(this, NearbyProfilePicBrowserActivity.class);
    paramPicInfo.putExtra("intent_param_index", 0);
    paramPicInfo.putExtra("intent_param_pic_infos", localArrayList);
    paramPicInfo.putExtra("KEY_THUMBNAL_BOUND", paramRect);
    paramPicInfo.addFlags(536870912);
    startActivity(paramPicInfo);
  }
  
  void showBigPhotoWithDelAndSetHeadView(int paramInt, Rect paramRect, ArrayList<PicInfo> paramArrayList)
  {
    Object localObject;
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      localObject = new Intent(this, NearbyProfilePicBrowserActivity.class);
      ((Intent)localObject).putExtra("intent_param_index", paramInt);
      ((Intent)localObject).putExtra("intent_param_pic_infos", paramArrayList);
      ((Intent)localObject).putExtra("report_visited_pic", true);
      ((Intent)localObject).putExtra("intent_param_show_del_pic_and_set_head", true);
      ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", paramRect);
      ((Intent)localObject).addFlags(536870912);
      startActivityForResult((Intent)localObject, 14);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showBigPhotoWithDelAndSetHeadView, currentPosition = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", rect = ");
      ((StringBuilder)localObject).append(paramRect);
      ((StringBuilder)localObject).append(", picInfos.size = ");
      if (paramArrayList == null) {
        paramRect = "null";
      } else {
        paramRect = Integer.valueOf(paramArrayList.size());
      }
      ((StringBuilder)localObject).append(paramRect);
      QLog.e("NearbyPeopleProfileActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  void showCancelAlertDialog(int paramInt)
  {
    this.mCancelAlertDialog = DialogUtil.a(this, 0, getString(paramInt), 2131699023, 2131699022, new NearbyPeopleProfileActivity.5(this), new NearbyPeopleProfileActivity.6(this));
    if ((this.mCancelAlertDialog != null) && (!isFinishing())) {
      this.mCancelAlertDialog.show();
    }
  }
  
  void showPromptDialog()
  {
    this.mPromptDialog = DialogUtil.a(this, 2131699027, getString(2131699026), 2131690728, 2131699025, new NearbyPeopleProfileActivity.7(this), new NearbyPeopleProfileActivity.8(this));
    if ((this.mPromptDialog != null) && (!isFinishing())) {
      this.mPromptDialog.show();
    }
  }
  
  public void showToast(int paramInt, String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).b(this.mTitleBarHeight);
  }
  
  public void showToast(String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramString, 0).b(this.mTitleBarHeight);
  }
  
  void showUploadPhotoActionSheet()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showUploadPhotoActionSheet, isAddPicBtnDownloadAppOpen=");
      ((StringBuilder)localObject1).append(this.mCard.isAddPicBtnDownloadAppOpen());
      ((StringBuilder)localObject1).append(", addPicBtnDownloadAppTips:");
      ((StringBuilder)localObject1).append(this.mCard.addPicBtnDownloadAppTips);
      ((StringBuilder)localObject1).append(", tribeAppDownloadPageUrl=");
      ((StringBuilder)localObject1).append(this.mCard.tribeAppDownloadPageUrl);
      QLog.d("Q.nearby.tribeAppDownload", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = getResources().getStringArray(2130968636);
    Object localObject2 = this.mCard;
    if ((localObject2 != null) && (((NearbyPeopleCard)localObject2).isAddPicBtnDownloadAppOpen()) && (!TextUtils.isEmpty(this.mCard.addPicBtnDownloadAppTips)) && (!TextUtils.isEmpty(this.mCard.tribeAppDownloadPageUrl)))
    {
      NearbyCardManager.a(this, this.mCard.addPicBtnDownloadAppTips, this.mCard.tribeAppDownloadPageUrl, 2);
      return;
    }
    localObject2 = ActionSheet.create(this);
    ((ActionSheet)localObject2).addButton(localObject1[28]);
    ((ActionSheet)localObject2).addButton(localObject1[29]);
    ((ActionSheet)localObject2).addCancelButton(localObject1[16]);
    ((ActionSheet)localObject2).setOnButtonClickListener(new NearbyPeopleProfileActivity.22(this, (ActionSheet)localObject2));
    ((ActionSheet)localObject2).show();
  }
  
  public void showVoteUpdateDialog(ImageView paramImageView, Drawable paramDrawable)
  {
    if (isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.i("NearbyPeopleProfileActivity", 2, "showVoteUpdateDialog invoke, but activity is finishing");
      }
      return;
    }
    paramImageView.setImageDrawable(paramDrawable);
    paramDrawable = (INearbyLikeLimitManager)this.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, UIUtils.a(this, 150.0F));
    new NearbyCustomDialog(this).a(paramImageView, localLayoutParams).a(HardCodeUtil.a(2131707275)).b(paramDrawable.a()).a(new BlueButtonInfo(HardCodeUtil.a(2131707270), new NearbyPeopleProfileActivity.18(this))).show();
    this.voteTipDrawable = null;
    paramDrawable.a();
  }
  
  void showWaitingDialog(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if (this.mProgressDialog == null) {
      this.mProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.mProgressDialog.a(paramString);
    if (isFinishing()) {
      return;
    }
    this.mProgressDialog.show();
  }
  
  protected void switchToDisplayPanel()
  {
    if (this.mMode == 2)
    {
      localObject = this.mDisplayModel;
      if (localObject != null) {
        ((NearbyProfileDisplayBasePanel)localObject).a(this.mCard);
      }
      return;
    }
    this.mMode = 2;
    Object localObject = this.mEditModel;
    if (localObject != null) {
      ((NearbyProfileEditBasePanel)localObject).a = false;
    }
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(300L);
    ((AlphaAnimation)localObject).setInterpolator(new AccelerateInterpolator());
    ((AlphaAnimation)localObject).setAnimationListener(new NearbyPeopleProfileActivity.11(this));
    this.mEditPanel.clearAnimation();
    this.mEditPanel.startAnimation((Animation)localObject);
  }
  
  void switchToEditPanel(long paramLong)
  {
    switchToEditPanel(paramLong, -1, -1);
  }
  
  void switchToEditPanel(long paramLong, int paramInt1, int paramInt2)
  {
    this.mMode = 1;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setDuration(paramLong);
    localAlphaAnimation.setAnimationListener(new NearbyPeopleProfileActivity.9(this));
    Object localObject = this.mEditPanel;
    if (localObject != null) {}
    try
    {
      this.mRootContainer.removeView((View)localObject);
      label67:
      localObject = this.mEditModel;
      if (localObject != null) {
        ((NearbyProfileEditBasePanel)localObject).a();
      }
      this.mEditPanel = null;
      this.mEditModel = null;
      this.mEditModel = createNearbyEditPanel(this.from);
      this.mEditPanel = this.mEditModel.a();
      this.mRootContainer.addView(this.mEditPanel, new FrameLayout.LayoutParams(-1, -1));
      localObject = (BounceScrollView)this.mEditPanel.findViewById(2131366074);
      ((BounceScrollView)localObject).setOnInterceptTouchEventListener(this);
      ((BounceScrollView)localObject).post(new NearbyPeopleProfileActivity.10(this, (BounceScrollView)localObject, this.mDisplayPanel.findViewById(2131363784).getScrollY()));
      this.mEditPanel.startAnimation(localAlphaAnimation);
      backupPhotoWall();
      return;
    }
    catch (Exception localException)
    {
      break label67;
    }
  }
  
  public void updateProfile()
  {
    ThreadManager.post(new NearbyPeopleProfileActivity.3(this), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity
 * JD-Core Version:    0.7.0.1
 */