package com.tencent.mobileqq.selectmember;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.share.ShareChatReport;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.bless.api.IBlessApi;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qwallet.transaction.IToPayManager;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroop;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroopMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.GameTroopSelectMemberInfo;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService.TroopCreateCallback;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.createtroopblacklist.api.ICreateTroopBlackListUtilApi;
import com.tencent.mobileqq.troop.data.TroopCreateInfo.TroopCreateResult;
import com.tencent.mobileqq.troop.troopcreate.TroopCreateUtils;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.selectmember.ResultRecord;>;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

@RoutePage(desc="选人器", path="/base/selectMember")
public class SelectMemberActivity
  extends QBaseActivity
  implements View.OnClickListener, ContactSearchResultPresenter.OnActionListener, ISelectMemberActivityConstants, ITroopCreateInfoService.TroopCreateCallback
{
  public static final String FRIEND_TEAM_ID = "friend_team_id";
  public static final String GROUP_MEMBER_COUNT = "group_member_type";
  public static final String GROUP_NAME = "group_name";
  public static final String GROUP_TYPE = "group_type";
  public static final String GROUP_UIN = "group_uin";
  public static final int HEADER_TROOP_MEMBER_NOT_ALLOW_CREATE_DISCUSSION = 1000;
  private static final String INDEX_NOT_ADMIN_INVITE_MEMBER_COUNT = "not_admin_invite_member_count";
  private static final int MSG_INIT_DATA = 1000;
  public static final String NEED_CLOSE_WHEN_PSTN_CLOSE = "NEED_CLOSE_WHEN_PSTN_CLOSE";
  private static final int NOT_ADMIN_INVITE_MEMBER_MAX_COUNT = 3;
  static final int PAGE_CONTACTS_LIST = 1;
  public static final int PAGE_DISCUSSION_MEMBER_LIST = 7;
  static final int PAGE_FRIEND_LIST = 5;
  static final int PAGE_FRIEND_TEAM_LIST = 0;
  public static final int PAGE_FRIENT_TEAN_SELECT = 8;
  static final int PAGE_RECENT_MEMBER_LIST = 4;
  public static final int PAGE_TROOP_BATCH_ADD_FRDS_LIST = 9;
  static final int PAGE_TROOP_DISCUSSION_LIST = 3;
  static final int PAGE_TROOP_LIST = 2;
  public static final int PAGE_TROOP_MEMBER_LIST = 6;
  public static final String PARAMR_ADMIN_GVIDEO_ROOM_NUM = "PARAMR_ADMIN_GVIDEO_ROOM_NUM";
  public static final int REQUEST_CODE_QQSTORY_CREATE_SHARE_GROUP = 10001;
  public static final int REQUEST_CODE_UNITED_VERIFY_MSG_EDIT = 10;
  static final String TAG = "SelectMemberActivity";
  protected static final int addReqError = 1;
  protected static final int addReqOK = 0;
  protected static final int refreshGridView = 2;
  public static boolean sNeedBlockDiscussSelfInviteMsg = false;
  protected AppInterface app;
  ContactSearchFragment contactSearchFragment;
  InputMethodManager imm = null;
  boolean isClosed = false;
  public boolean isStoryNotSee = false;
  public boolean isSupportSelectFriendGroup = true;
  long lastCreateTimeStamp = 0L;
  public int lastInerFrame = -1;
  boolean mAddPassedMembersToResultSet;
  private Drawable mAnimationDrawable;
  private AvatarObserver mAvatarObserver;
  int mBackButtonSide;
  protected Button mCreateTroopButton;
  protected View mCreateTroopButtonLayout;
  Bitmap mDefaultAvatar;
  protected float mDensity;
  private DiscussionObserver mDiscussionObserver;
  String mDoneBtnText;
  String mDoneBtnText_x;
  boolean mDonotNeedContacts;
  boolean mDonotNeedDiscussion;
  boolean mDonotNeedTroop;
  int mEnterAnimation;
  protected int mEntrance;
  int mExitAnimation;
  IFaceDecoder mFaceDecoder;
  public boolean mFilterRobot = false;
  protected int mFrom;
  protected TextView mGVideoTextView = null;
  String mGroupCode;
  ArrayList<Entity> mGroupmembers;
  final Handler mHandler = new SelectMemberActivity.17(this, Looper.getMainLooper());
  protected InnerFrameManager mInnerFrameManager;
  protected Intent mIntent;
  protected long mInviteNoAuthLimitNum = 9223372036854775807L;
  String mInviteSuccToastWording = HardCodeUtil.a(2131911213);
  protected List<String> mInvitedUinList = new ArrayList();
  public boolean mIsForbidOnlyChooseMySelf = false;
  protected boolean mIsLimitToInviteByTroopMaxLimit = false;
  public boolean mIsNeedSendIsResumeBroadcast = true;
  public boolean mIsPutMySelfFirst = false;
  protected boolean mIsSelectAllMembers = false;
  boolean mIsSoftInputShowing;
  protected boolean mIsTroopAdmin;
  protected TextView mLeftBackBtn;
  protected TextView mLeftCancelBtn;
  protected LinearLayout mListPanel;
  protected int mMaxSelectNumber;
  protected int mMinSelectNumber;
  private boolean mModeMulti;
  private Button mMultiAddBtn;
  private View mMultiAddContainerV;
  View mMultiSearchView;
  SelectMemberActivity.IOnSelectStateChange mOnSelectStateChangeListener;
  boolean mOnlyDiscussionMember;
  boolean mOnlyFaceToFaceTroop;
  boolean mOnlyFriends;
  boolean mOnlySelectTroopOrDiscussionMember;
  boolean mOnlyTroopMember;
  boolean mOverloadTipsIncludeDefaultCount;
  private long mOverloadToastLastShowTime = 0L;
  protected QQProgressDialog mQQProgressDialog;
  protected QQToastNotifier mQQTH;
  protected ArrayList<ResultRecord> mResultList = new ArrayList();
  protected TextView mRightBtn;
  protected View mSearchResultLayout;
  protected boolean mSearchTextEmpty = true;
  protected SelectedAndSearchBar mSelectedAndSearchBar;
  private SelectedAndSearchBar.ISelectedAndSearchBarCallback mSelectedAndSearchBarCallback = new SelectMemberActivity.9(this);
  protected boolean mShowMyself;
  protected int mSubType;
  protected TextView mTitle;
  protected View mTitleBar;
  String mTitleString;
  private IToPayManager mToPayManagerApi;
  protected View mTooManyMembersTipsBar;
  protected View mTooManyMembersTipsClose;
  public ArrayList<String> mTopayTips;
  protected Bitmap mTransparentFace;
  private TroopManagerBizObserver mTroopManagerBizObserver;
  protected int mTroopMemberNum;
  private TroopMngObserver mTroopMngObserver;
  protected int mType;
  public ArrayList<String> mUinsSelectedDefault;
  public ArrayList<String> mUinsSelectedFriends;
  public ArrayList<String> mUinsToHide;
  private int mUnblessedUinCount = 0;
  private int mWebUinCount = 0;
  String mYellowTipsWording = "";
  boolean needShowYellowTips = false;
  protected Dialog pd;
  protected ProgressBar tipsDialogPb;
  protected TextView tipsDialogText;
  protected ImageView tipsFlagImage;
  private BroadcastReceiver videoMsgReceiver = null;
  
  private void afterCreateTroopSucc(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("afterCreateTroopSucc, troop[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], entrance[");
      ((StringBuilder)localObject).append(this.mEntrance);
      ((StringBuilder)localObject).append("]");
      QLog.i("SelectMemberActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = getTroopInfo(paramString);
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((TroopInfo)localObject).troopname;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mResultList.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.type == 5)
      {
        if (localResultRecord.uin.startsWith("pstn")) {
          localResultRecord.uin = localResultRecord.uin.substring(4);
        }
        localArrayList.add(localResultRecord.uin);
      }
      else if ((localResultRecord.type == 4) && (localResultRecord.uin.startsWith("+")))
      {
        localArrayList.add(localResultRecord.uin);
      }
    }
    this.mIntent.putExtra("roomId", paramString);
    this.mIntent.putExtra("discussName", (String)localObject);
    this.mIntent.putExtra("qqPhoneUserList", localArrayList);
    this.mIntent.putExtra("audioType", 2);
    this.mIntent.putExtra("result_uin", paramString);
    this.mIntent.putExtra("result_uintype", 1);
    this.mIntent.putExtra("result_name", (String)localObject);
    if (this.mEntrance == 12) {
      this.mIntent.putExtra("select_memeber_discussion_memeber_count", this.mResultList.size() + 1);
    }
    this.mIntent.putParcelableArrayListExtra("result_set", this.mResultList);
    setResult(-1, this.mIntent);
    if (this.mEntrance == 27) {
      ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).enterTroopAio(this, paramString, true);
    }
    finish();
  }
  
  private boolean canInvite()
  {
    if (!this.mIsTroopAdmin) {
      getNotAdminInviteMemberCount();
    }
    return true;
  }
  
  private void checkNeedGameInfo(SelectMemberActivity paramSelectMemberActivity, String paramString, int paramInt)
  {
    if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(paramSelectMemberActivity)) {
      ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).onSearchBarDone(this.app, paramSelectMemberActivity, convertToGameTroopSelectMemberInfoList(this.mResultList), paramInt, paramString, getIntent().getStringExtra("group_uin"));
    }
  }
  
  public static int checkPhoneNumber(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    String str = paramString.replace("-", "").replace(" ", "");
    if (str.length() <= 6) {
      return 5;
    }
    if (str.length() > 16) {
      return 4;
    }
    paramString = str;
    if (paramBoolean) {
      if ((!str.startsWith("00")) && (!str.startsWith("+")))
      {
        paramString = str;
        if (!str.startsWith("86")) {}
      }
      else if (str.startsWith("0086"))
      {
        paramString = str.substring(4);
      }
      else if (str.startsWith("+86"))
      {
        paramString = str.substring(3);
      }
      else if (str.startsWith("86"))
      {
        paramString = str.substring(2);
      }
      else
      {
        return 1;
      }
    }
    if (!paramString.startsWith("400"))
    {
      if (paramString.startsWith("800")) {
        return 2;
      }
      if ((!paramString.startsWith("0")) && (paramString.length() <= 9)) {
        return 3;
      }
      if ((paramString.length() != 11) && (paramString.length() != 12)) {
        return 6;
      }
      return 0;
    }
    return 2;
  }
  
  public static ResultRecord constructAResultRecord(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.uin = paramString1;
    localResultRecord.name = paramString2;
    localResultRecord.type = paramInt;
    localResultRecord.groupUin = paramString3;
    return localResultRecord;
  }
  
  static ArrayList<GameTroopSelectMemberInfo> convertToGameTroopSelectMemberInfoList(List<ResultRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)paramList.next();
        localArrayList.add(new GameTroopSelectMemberInfo(localResultRecord.uin, localResultRecord.name, localResultRecord.type, localResultRecord.uinType, localResultRecord.groupUin, localResultRecord.phone, localResultRecord.lastChooseTime, localResultRecord.isNewTroop, localResultRecord.gameLevelIcon));
      }
    }
    return localArrayList;
  }
  
  private Friends findFriendEntityByUin(String paramString)
  {
    if (!Friends.isValidUin(paramString)) {
      return null;
    }
    return ((IFriendDataService)this.app.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true, true);
  }
  
  static String getFromArray(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > paramInt)) {
      return paramVarArgs[paramInt];
    }
    return "";
  }
  
  private void handleTroopInviteGroupFailed(int paramInt)
  {
    String str;
    if (paramInt != 1281)
    {
      if (paramInt != 1286)
      {
        if (paramInt != 1288)
        {
          if (paramInt != 1294)
          {
            int i = this.mEntrance;
            if ((i != 11) && (i != 36)) {
              str = getString(2131891032);
            } else {
              str = getString(2131893342);
            }
          }
          else
          {
            str = getString(2131891030);
          }
        }
        else {
          str = getString(2131891031);
        }
      }
      else {
        str = getString(2131891028);
      }
    }
    else {
      str = getString(2131891029);
    }
    this.mHandler.obtainMessage(1, str).sendToTarget();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleTroopInviteGroupFailed, result[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], errStr[");
    localStringBuilder.append(str);
    localStringBuilder.append("]");
    QLog.w("SelectMemberActivity", 1, localStringBuilder.toString());
  }
  
  private boolean hasAdd2ResultList(String paramString)
  {
    try
    {
      Iterator localIterator = this.mResultList.iterator();
      while (localIterator.hasNext())
      {
        boolean bool = TextUtils.equals(((ResultRecord)localIterator.next()).uin, paramString);
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable paramString)
    {
      label40:
      break label40;
    }
    return false;
  }
  
  private void initObserver()
  {
    this.mDiscussionObserver = new SelectMemberActivity.12(this);
    this.mTroopMngObserver = new SelectMemberActivity.13(this);
    this.mTroopManagerBizObserver = new SelectMemberActivity.14(this);
    this.mAvatarObserver = new SelectMemberActivity.15(this);
    addObserver(this.mDiscussionObserver);
    addObserver(this.mAvatarObserver);
    addObserver(this.mTroopManagerBizObserver);
    addObserver(this.mTroopMngObserver);
  }
  
  private void initOnProgressDialog()
  {
    Dialog localDialog = this.pd;
    if (localDialog != null)
    {
      localDialog.dismiss();
      this.pd = null;
    }
    this.pd = new ReportDialog(this, 2131953338);
    this.pd.setContentView(2131629210);
    this.tipsDialogText = ((TextView)this.pd.findViewById(2131431876));
    this.tipsDialogText.setText(getString(2131916272));
    this.tipsDialogPb = ((ProgressBar)this.pd.findViewById(2131433567));
    this.tipsDialogPb.setVisibility(0);
    this.tipsFlagImage = ((ImageView)this.pd.findViewById(2131449154));
    this.tipsFlagImage.setVisibility(4);
  }
  
  private boolean isNotMaxOfPSTN()
  {
    Iterator localIterator = this.mResultList.iterator();
    boolean bool = false;
    int i = 0;
    int j;
    do
    {
      do
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((ResultRecord)localIterator.next()).type != 5);
      j = i + 1;
      i = j;
    } while (j < 8);
    if (j < 8) {
      bool = true;
    }
    return bool;
  }
  
  static void reportEventByStoryReportor(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    ReportController.b(null, "dc00899", "grp_story", "", paramString1, paramString2, paramInt1, paramInt2, getFromArray(0, paramVarArgs), getFromArray(1, paramVarArgs), getFromArray(2, paramVarArgs), getFromArray(3, paramVarArgs));
  }
  
  private void sendIsResumeBroadcast(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendIsResumeBroadcast isNeedSend = ");
      ((StringBuilder)localObject).append(this.mIsNeedSendIsResumeBroadcast);
      ((StringBuilder)localObject).append(" ,isResume = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("SelectMemberActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (this.mIsNeedSendIsResumeBroadcast)
    {
      localObject = MobileQQ.sMobileQQ;
      SmallScreenUtils.a(MobileQQ.getContext(), paramBoolean);
    }
  }
  
  private void setDoneBtnEnabled(boolean paramBoolean)
  {
    if (this.mIntent.getBooleanExtra("show_invite_entry", false)) {
      return;
    }
    int i = this.mResultList.size();
    Object localObject2;
    Object localObject1;
    if (i <= 1)
    {
      if (this.mSubType == 3)
      {
        localObject2 = this.mDoneBtnText;
        localObject1 = localObject2;
        if (i != 1)
        {
          paramBoolean = false;
          localObject1 = localObject2;
        }
      }
      else if (((this.mEntrance == 25) && (i == 1)) || ((isCreateNewTypeTroop()) && (i == 1)))
      {
        localObject1 = MessageFormat.format(this.mDoneBtnText_x, new Object[] { Integer.valueOf(i) });
      }
      else
      {
        localObject1 = this.mDoneBtnText;
      }
    }
    else if (this.mSubType == 3) {
      localObject1 = this.mDoneBtnText;
    } else {
      localObject1 = MessageFormat.format(this.mDoneBtnText_x, new Object[] { Integer.valueOf(i) });
    }
    if (paramBoolean)
    {
      this.mRightBtn.setEnabled(true);
      if (!"1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
        this.mRightBtn.setAlpha(1.0F);
      }
      this.mRightBtn.setText((CharSequence)localObject1);
    }
    else
    {
      this.mRightBtn.setEnabled(false);
      if (!"1000".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
        this.mRightBtn.setAlpha(0.5F);
      }
      this.mRightBtn.setText((CharSequence)localObject1);
    }
    if (AppSetting.e)
    {
      localObject1 = this.mRightBtn;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.mDoneBtnText);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131911206));
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131911197));
      ((TextView)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
    }
  }
  
  private void showMemberOverloadToast(int paramInt)
  {
    showMemberOverloadToast(getString(paramInt));
  }
  
  private void showMemberOverloadToast(String paramString)
  {
    if (System.currentTimeMillis() - this.mOverloadToastLastShowTime > 2000)
    {
      QQToast.makeText(this, paramString, 2000).show(this.mTitleBar.getHeight());
      this.mOverloadToastLastShowTime = System.currentTimeMillis();
    }
  }
  
  private void startRelationFriendAndTroopSearch(boolean paramBoolean)
  {
    int i = this.mEntrance;
    if ((i == 38) || (i == 29) || (i == 39))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isItemClick：");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.i("SelectMemberActivity", 2, ((StringBuilder)localObject).toString());
      }
      SelectMemberInnerFrame localSelectMemberInnerFrame = (SelectMemberInnerFrame)this.mInnerFrameManager.getChildAt(1);
      if ((paramBoolean) && (this.mInnerFrameManager.getCurrentPage() == 0)) {
        return;
      }
      if ((localSelectMemberInnerFrame instanceof FriendTeamListInnerFrame))
      {
        localObject = null;
        if (this.mResultList.size() > 0)
        {
          localObject = this.mResultList;
          localObject = (ResultRecord)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
        }
        localSelectMemberInnerFrame.a((ResultRecord)localObject, this.mEntrance);
      }
    }
  }
  
  public boolean addFriendResults(List<ResultRecord> paramList, boolean paramBoolean)
  {
    return addFriendResults(paramList, paramBoolean, false);
  }
  
  public boolean addFriendResults(List<ResultRecord> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.mResultList.clear();
    }
    HashSet localHashSet = new HashSet(this.mResultList.size());
    Object localObject = this.mResultList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashSet.add(((ResultRecord)((Iterator)localObject).next()).uin);
    }
    localObject = this.mUinsSelectedDefault;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localHashSet.add((String)((Iterator)localObject).next());
      }
    }
    paramList = paramList.iterator();
    do
    {
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label372;
        }
        localObject = (ResultRecord)paramList.next();
        if (!localHashSet.contains(((ResultRecord)localObject).uin))
        {
          if ((isMemberOverLoad("addFriendResults", paramBoolean2, ((ResultRecord)localObject).uin, ((ResultRecord)localObject).name, ((ResultRecord)localObject).type, ((ResultRecord)localObject).groupUin)) || (isMemberOverload(((ResultRecord)localObject).uin, ((ResultRecord)localObject).name)) || (!preAddPstnNumber(((ResultRecord)localObject).uin, ((ResultRecord)localObject).name, ((ResultRecord)localObject).type, ((ResultRecord)localObject).groupUin))) {
            break;
          }
          this.mResultList.add(localObject);
          updateMultiAddState((ResultRecord)localObject, true);
          if (this.mType == 9003) {
            if ((this.mEntrance == 15) && (!((IBlessApi)QRoute.api(IBlessApi.class)).isUinBlessed(this.app, ((ResultRecord)localObject).uin))) {
              this.mUnblessedUinCount += 1;
            } else if ((this.mEntrance == 32) && (!((IBlessApi)QRoute.api(IBlessApi.class)).isWebUinSended(this.app, ((ResultRecord)localObject).uin))) {
              this.mUnblessedUinCount += 1;
            }
          }
        }
      }
    } while (this.mType == 9003);
    label372:
    this.mSelectedAndSearchBar.a(true);
    setupDoneBtn();
    onResultListChanged();
    return true;
  }
  
  public void adjustGridView(boolean paramBoolean)
  {
    SelectedAndSearchBar localSelectedAndSearchBar = this.mSelectedAndSearchBar;
    if (localSelectedAndSearchBar != null) {
      localSelectedAndSearchBar.a(paramBoolean);
    }
  }
  
  public void afterMemberFilter(int paramInt)
  {
    if (this.mEntrance != 35) {
      return;
    }
    this.mIsSelectAllMembers = false;
    doEnableAllSelect(paramInt);
    showAllSelectBtn();
  }
  
  public ResultRecord constructAResultRecord(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    ResultRecord localResultRecord = new ResultRecord();
    localResultRecord.uin = paramString1;
    localResultRecord.name = paramString2;
    localResultRecord.type = paramInt;
    localResultRecord.groupUin = paramString3;
    localResultRecord.phone = paramString4;
    return localResultRecord;
  }
  
  protected void createNewTypeDiscussion()
  {
    if (System.currentTimeMillis() - this.lastCreateTimeStamp < 1500L) {
      return;
    }
    this.lastCreateTimeStamp = System.currentTimeMillis();
    ITroopCreateService localITroopCreateService = (ITroopCreateService)this.app.getRuntimeService(ITroopCreateService.class, "");
    if (localITroopCreateService != null)
    {
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("group_type", 1);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getAccountNickName(this.app, this.app.getCurrentAccountUin()));
        localStringBuilder.append(HardCodeUtil.a(2131911196));
        ((JSONObject)localObject2).put("name", localStringBuilder.toString());
        ((JSONObject)localObject2).put("classify", 10010);
        if ((this.mEntrance != 12) && (this.mEntrance != 36)) {
          ((JSONObject)localObject2).put("isJumpAio", 1);
        }
        i = this.mEntrance;
        if (i == 12) {
          i = 3;
        } else if (this.mEntrance == 28) {
          i = 5;
        } else if (this.mEntrance == 39) {
          i = 8;
        } else if (this.mEntrance == 29) {
          i = 2;
        } else if (this.mEntrance == 27) {
          i = getIntent().getIntExtra("create_source", 0);
        } else {
          i = 0;
        }
        try
        {
          ((JSONObject)localObject2).put("create_source", i);
        }
        catch (JSONException localJSONException1) {}
        QLog.e("SelectMemberActivity", 1, "createNewTypeDiscussion json error!", localJSONException2);
      }
      catch (JSONException localJSONException2)
      {
        i = 0;
      }
      ((ITroopCreateInfoService)this.app.getRuntimeService(ITroopCreateInfoService.class, "")).refreshCreateInfo(((JSONObject)localObject2).toString(), 5);
      Object localObject1 = this.app;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(i);
      ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_create_new", "", "create_page", "clk_now", 0, 0, "", ((StringBuilder)localObject2).toString(), "", "");
      localObject1 = new ArrayList(this.mResultList.size());
      ((ArrayList)localObject1).addAll(this.mResultList);
      localObject2 = this.mUinsSelectedDefault;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          ResultRecord localResultRecord = new ResultRecord();
          localResultRecord.uin = str;
          localResultRecord.type = 0;
          localResultRecord.groupUin = "-1";
          localResultRecord.name = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getNickName(this.app, localResultRecord.uin, localResultRecord.type);
          ((ArrayList)localObject1).add(localResultRecord);
        }
      }
      localITroopCreateService.startCreateTroop(this, this, (ArrayList)localObject1);
      int i = this.mFrom;
      if (i == 1003)
      {
        ReportController.b(this.app, "dc00899", "Grp_create", "", "choose_cre", "clk_cre_main", 0, 0, "", "", "", "");
        return;
      }
      if (i == 1002) {
        ReportController.b(this.app, "dc00899", "Grp_create", "", "choose_cre", "clk_cre_conta", 0, 0, "", "", "", "");
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  void doEnableAllSelect(int paramInt)
  {
    Object localObject = this.mIntent;
    int j = 0;
    int k = 0;
    if (!((Intent)localObject).getBooleanExtra("param_enable_all_select", false)) {
      return;
    }
    localObject = this.mIntent.getStringExtra("group_uin");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if ((this.mOnlyDiscussionMember) || (this.mOnlyTroopMember))
    {
      int i;
      if (paramInt != -1)
      {
        if (this.mShowMyself) {
          i = paramInt - 1;
        } else {
          i = paramInt;
        }
      }
      else
      {
        if (this.mOnlyDiscussionMember) {}
        for (i = ((IDiscussionService)this.app.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum((String)localObject);; i = ((TroopInfo)localObject).wMemberNum)
        {
          break;
          i = k;
          if (!this.mOnlyTroopMember) {
            break;
          }
          localObject = getTroopInfo((String)localObject);
          i = k;
          if (localObject == null) {
            break;
          }
        }
        k = i - 1;
        j = i;
        i = k;
      }
      if (i <= this.mIntent.getIntExtra("param_all_select_max_num", this.mMaxSelectNumber)) {
        this.mIsSelectAllMembers = true;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isEnableAllSelect, memCount[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], memFromAPI[");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("], finalCount[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("], mIsSelectAllMembers[");
      ((StringBuilder)localObject).append(this.mIsSelectAllMembers);
      ((StringBuilder)localObject).append("], mShowMyself[");
      ((StringBuilder)localObject).append(this.mShowMyself);
      ((StringBuilder)localObject).append("]");
      QLog.w("SelectMemberActivity", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void doInviteTroopMember(ArrayList<ResultRecord> paramArrayList)
  {
    if ((paramArrayList.size() > 0) && (this.mGroupCode.length() > 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("add troop member: troopCode: ");
        ((StringBuilder)localObject).append(this.mGroupCode);
        ((StringBuilder)localObject).append(" member count: ");
        ((StringBuilder)localObject).append(paramArrayList.size());
        QLog.d("SelectMemberActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (!canInvite())
      {
        QQToast.makeText(this, 2131892170, 0).show(getTitleBarHeight());
        return;
      }
      if (this.mTroopMemberNum <= 0)
      {
        localObject = findTroopInfo(this.mGroupCode);
        if (localObject != null) {
          this.mTroopMemberNum = ((TroopInfo)localObject).wMemberNum;
        }
      }
      if ((this.mInviteNoAuthLimitNum > 0L) && (paramArrayList.size() + this.mTroopMemberNum > this.mInviteNoAuthLimitNum))
      {
        paramArrayList = TroopCreateUtils.a(paramArrayList);
        DialogUtil.a(this, HardCodeUtil.a(2131911207), 2131887648, 2131891026, new SelectMemberActivity.7(this, paramArrayList), new DialogUtil.DialogOnClickAdapter()).show();
        reportInviteFriend("exp_msgbox");
        return;
      }
      paramArrayList = TroopCreateUtils.a(paramArrayList);
      Object localObject = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName();
      ((ITroopMngHandler)this.app.getBusinessHandler((String)localObject)).a(this.mGroupCode, paramArrayList, "");
      initOnProgressDialog();
      this.pd.show();
      reportInviteFriend("Clk_invite");
      return;
    }
    finish();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == 10001)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("qqstory create share group result:");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("SelectMemberActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
      }
    }
    else
    {
      localObject = this.mInnerFrameManager;
      if (localObject != null) {
        ((InnerFrameManager)localObject).a(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131952010);
    super.doOnCreate(paramBundle);
    this.app = ((AppInterface)getAppRuntime());
    getIntentExtras();
    setContentLayout();
    this.mToPayManagerApi = ((IToPayManager)QRoute.api(IToPayManager.class));
    int i = this.mEntrance;
    if ((i != 11) && (i != 36)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 1) {
      super.getWindow().addFlags(524288);
    }
    this.mFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.mDensity = getResources().getDisplayMetrics().density;
    findViews();
    initTitleBar();
    initSelectedBar();
    initSearchBar();
    initObserver();
    initInnerFrameManager();
    if ((this.mType == 1) && (this.mSubType == 1))
    {
      paramBundle = findTroopInfo(this.mGroupCode);
      if (paramBundle != null) {
        this.mTroopMemberNum = paramBundle.wMemberNum;
      }
      ThreadManager.post(new SelectMemberActivity.1(this), 8, null, true);
    }
    this.mTransparentFace = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    this.mDefaultAvatar = BaseImageUtil.k();
    if (this.videoMsgReceiver == null)
    {
      this.videoMsgReceiver = new SelectMemberActivity.VideoMsgReceiver(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.av.v2q.StopVideoChat");
      registerReceiver(this.videoMsgReceiver, paramBundle);
    }
    if (this.mFrom == 30) {
      toggleSelectMode(true, true);
    }
    i = this.mType;
    if ((i == 9003) || (8998 == i))
    {
      Object localObject = ((IBlessApi)QRoute.api(IBlessApi.class)).getUinListToSend(this.app);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        paramBundle = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          Friends localFriends = findFriendEntityByUin(str);
          if (localFriends != null) {
            paramBundle.add(constructAResultRecord(str, localFriends.getFriendNick(), 0, "-1"));
          }
        }
        addFriendResults(paramBundle, false);
      }
    }
    paramBundle = getIntent().getParcelableArrayListExtra("param_selected_records_for_create_discussion");
    if (paramBundle != null) {
      addFriendResults(paramBundle, false);
    }
    i = this.mFrom;
    if (i == 1003) {
      ReportController.b(this.app, "dc00899", "Grp_create", "", "f2f", "clk_f2f_main", 0, 0, "", "", "", "");
    } else if (i == 1002) {
      ReportController.b(this.app, "dc00899", "Grp_create", "", "f2f", "clk_f2f_conta", 0, 0, "", "", "", "");
    }
    if (this.mEntrance == 33) {
      ReportController.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.payershowfriendpay.askaio.payershowfriendpay.askaio.payerclickfriendpay.selectpage.show", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.mInnerFrameManager.d();
    removeObserver(this.mDiscussionObserver);
    removeObserver(this.mTroopManagerBizObserver);
    removeObserver(this.mTroopMngObserver);
    removeObserver(this.mAvatarObserver);
    Object localObject = this.pd;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      this.pd.dismiss();
    }
    localObject = this.mFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.videoMsgReceiver;
    if (localObject != null)
    {
      unregisterReceiver((BroadcastReceiver)localObject);
      this.videoMsgReceiver = null;
    }
    localObject = (ITroopCreateService)this.app.getRuntimeService(ITroopCreateService.class, "");
    if (localObject != null) {
      ((ITroopCreateService)localObject).releaseCreateCallback(this);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "doOnNewIntent");
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.mInnerFrameManager.b();
    sendIsResumeBroadcast(false);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.mInnerFrameManager.a();
    sendIsResumeBroadcast(true);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(16);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(48);
    this.mInnerFrameManager.c();
  }
  
  TroopInfo findTroopInfo(String paramString)
  {
    return ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
  }
  
  @TargetApi(14)
  protected void findViews()
  {
    Object localObject = (RelativeLayout)findViewById(2131445137);
    int i = ImmersiveUtils.isSupporImmersive();
    boolean bool = true;
    if (i == 1)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        ((RelativeLayout)localObject).setFitsSystemWindows(true);
      }
      ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.mTitleBar = findViewById(2131447484);
    this.mTitle = ((TextView)findViewById(2131436227));
    this.mLeftBackBtn = ((TextView)findViewById(2131436180));
    this.mLeftCancelBtn = ((TextView)findViewById(2131436182));
    this.mRightBtn = ((TextView)findViewById(2131436211));
    this.mSelectedAndSearchBar = ((SelectedAndSearchBar)findViewById(2131445550));
    this.mListPanel = ((LinearLayout)findViewById(2131437308));
    this.mInnerFrameManager = ((InnerFrameManager)findViewById(2131449816));
    this.mSearchResultLayout = findViewById(2131444724);
    this.mSearchResultLayout.setVisibility(8);
    this.mTooManyMembersTipsBar = findViewById(2131447691);
    localObject = this.mTooManyMembersTipsBar;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      this.mTooManyMembersTipsBar.setOnClickListener(this);
    }
    this.mTooManyMembersTipsClose = findViewById(2131447692);
    localObject = this.mTooManyMembersTipsClose;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(this);
    }
    this.mCreateTroopButtonLayout = findViewById(2131431508);
    if (isShowDoneButtonInBottom())
    {
      this.mCreateTroopButtonLayout.setVisibility(0);
      this.mCreateTroopButton = ((Button)findViewById(2131431507));
      if (this.mEntrance == 35) {
        this.mCreateTroopButton.setText(this.mDoneBtnText);
      } else {
        bool = false;
      }
      if (this.mEntrance == 40) {
        this.mCreateTroopButton.setText(this.mDoneBtnText);
      }
      this.mCreateTroopButton.setOnClickListener(this);
      NewTroopContactView.setCreateTroopButtonEnable(this.mCreateTroopButton, bool);
      if (isCreateNewTroopEntrance())
      {
        i = getIntent().getIntExtra("create_source", 0);
        localObject = this.app;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i);
        ReportController.b((AppRuntime)localObject, "dc00899", "Grp_create_new", "", "create_page", "exp_chose", 0, 0, "", localStringBuilder.toString(), "", "");
      }
      else if (isInviteTroopMember())
      {
        this.mCreateTroopButton.setText(HardCodeUtil.a(2131911177));
        refreshInviteTipsBar();
      }
    }
    this.mMultiSearchView = findViewById(2131445551);
    this.mMultiAddContainerV = findViewById(2131433271);
    this.mMultiAddBtn = ((Button)findViewById(2131429937));
    localObject = this.mMultiAddBtn;
    if (localObject != null) {
      ((Button)localObject).setOnClickListener(this);
    }
  }
  
  public void finish()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("SelectMemberActivity", 1, "finish", new Throwable("打印调用栈"));
    }
    ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).notifyResultReceiver(this.mIntent, this);
    super.finish();
    BroadcastReceiver localBroadcastReceiver = this.videoMsgReceiver;
    if (localBroadcastReceiver != null)
    {
      unregisterReceiver(localBroadcastReceiver);
      this.videoMsgReceiver = null;
    }
    int i = this.mExitAnimation;
    if (i != 1)
    {
      if (i != 2) {
        if (i != 3)
        {
          if (i != 4) {
            overridePendingTransition(0, 2130771995);
          } else {
            overridePendingTransition(0, 0);
          }
        }
        else {
          overridePendingTransition(0, 2130772018);
        }
      }
    }
    else {
      overridePendingTransition(2130772005, 2130772006);
    }
    if (this.mSelectedAndSearchBar.a()) {
      runOnUiThread(new SelectMemberActivity.16(this));
    }
  }
  
  int getCheckPhoneNumberResId(String paramString)
  {
    switch (checkPhoneNumber(paramString.substring(4), true))
    {
    case 0: 
    default: 
      return 0;
    case 6: 
      return 2131916227;
    case 5: 
      return 2131916226;
    case 4: 
      return 2131916225;
    case 3: 
      return 2131916224;
    case 2: 
      return 2131916223;
    case 1: 
      return 2131916222;
    }
    return 2131916228;
  }
  
  public Map<String, List<TroopMemberInfo>> getIndexedFriends()
  {
    InnerFrameManager localInnerFrameManager = this.mInnerFrameManager;
    if ((localInnerFrameManager != null) && ((localInnerFrameManager.getCurrentView() instanceof TroopMemberListInnerFrame))) {
      return ((TroopMemberListInnerFrame)this.mInnerFrameManager.getCurrentView()).getIndexedFriends();
    }
    return null;
  }
  
  protected void getIntentExtras()
  {
    this.mIntent = getIntent();
    this.mType = this.mIntent.getExtras().getInt("param_type");
    this.mSubType = this.mIntent.getExtras().getInt("param_subtype");
    this.mFrom = this.mIntent.getExtras().getInt("param_from");
    this.mEntrance = this.mIntent.getIntExtra("param_entrance", 0);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getIntentExtras mType = ");
      ((StringBuilder)localObject1).append(this.mType);
      ((StringBuilder)localObject1).append(",mSubType = ");
      ((StringBuilder)localObject1).append(this.mSubType);
      ((StringBuilder)localObject1).append(",mFrom = ");
      ((StringBuilder)localObject1).append(this.mFrom);
      ((StringBuilder)localObject1).append(",mEntrance = ");
      ((StringBuilder)localObject1).append(this.mEntrance);
      QLog.i("SelectMemberActivity", 2, ((StringBuilder)localObject1).toString());
    }
    this.mFilterRobot = this.mIntent.getBooleanExtra("filer_robot", false);
    this.mUinsSelectedDefault = this.mIntent.getStringArrayListExtra("param_uins_selected_default");
    this.mUinsSelectedFriends = this.mIntent.getStringArrayListExtra("param_uins_selected_friends");
    this.mUinsToHide = this.mIntent.getStringArrayListExtra("param_uins_hide");
    if (this.mUinsToHide == null) {
      this.mUinsToHide = new ArrayList();
    }
    this.mUinsToHide.add(AppConstants.BABY_Q_UIN);
    Object localObject1 = CommonUtils.a(this.app);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopInfo)((Iterator)localObject1).next();
        if (((TroopInfo)localObject2).isQidianPrivateTroop()) {
          this.mUinsToHide.add(((TroopInfo)localObject2).troopuin);
        }
      }
    }
    this.mGroupCode = this.mIntent.getExtras().getString("param_groupcode");
    this.mIsTroopAdmin = this.mIntent.getExtras().getBoolean("param_is_troop_admin", true);
    this.mMaxSelectNumber = this.mIntent.getIntExtra("param_max", 2147483647);
    if ((!TextUtils.isEmpty(this.mGroupCode)) && (!TextUtils.equals("0", this.mGroupCode)))
    {
      localObject1 = CommonUtils.d(this.app, this.mGroupCode);
      if (localObject1 != null)
      {
        i = ((TroopInfo)localObject1).wMemberMax - ((TroopInfo)localObject1).wMemberNum;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mMaxSelectNumber:");
          ((StringBuilder)localObject2).append(this.mMaxSelectNumber);
          ((StringBuilder)localObject2).append(" remain:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append("  wMemberMax:");
          ((StringBuilder)localObject2).append(((TroopInfo)localObject1).wMemberMax);
          ((StringBuilder)localObject2).append("  wMemberNum:");
          ((StringBuilder)localObject2).append(((TroopInfo)localObject1).wMemberNum);
          ((StringBuilder)localObject2).append("  real mMaxSelectNumber");
          ((StringBuilder)localObject2).append(Math.min(this.mMaxSelectNumber, i));
          QLog.d("SelectMemberActivity", 2, ((StringBuilder)localObject2).toString());
        }
        if ((i > 0) && (this.mMaxSelectNumber > i))
        {
          this.mMaxSelectNumber = i;
          this.mIsLimitToInviteByTroopMaxLimit = true;
        }
      }
    }
    this.mMinSelectNumber = this.mIntent.getIntExtra("param_min", 1);
    this.mShowMyself = this.mIntent.getBooleanExtra("param_show_myself", false);
    this.mDonotNeedContacts = this.mIntent.getBooleanExtra("param_donot_need_contacts", false);
    this.mDonotNeedTroop = this.mIntent.getBooleanExtra("param_donot_need_troop", false);
    this.mDonotNeedDiscussion = this.mIntent.getBooleanExtra("param_donot_need_discussion", false);
    this.mOnlyFriends = this.mIntent.getBooleanExtra("param_only_friends", false);
    this.mOnlyTroopMember = this.mIntent.getBooleanExtra("param_only_troop_member", false);
    this.mOnlyDiscussionMember = this.mIntent.getBooleanExtra("param_only_discussion_member", false);
    this.mOnlySelectTroopOrDiscussionMember = this.mIntent.getBooleanExtra("param_only_troop_or_discussion_member", false);
    this.mOnlyFaceToFaceTroop = this.mIntent.getBooleanExtra("param_face_to_face_troop", false);
    this.mOverloadTipsIncludeDefaultCount = this.mIntent.getBooleanExtra("param_overload_tips_include_default_count", false);
    this.mTitleString = this.mIntent.getStringExtra("param_title");
    if (this.mTitleString == null) {
      this.mTitleString = getString(2131916202);
    }
    this.mDoneBtnText = this.mIntent.getStringExtra("param_done_button_wording");
    if (this.mDoneBtnText == null) {
      this.mDoneBtnText = getString(2131916215);
    }
    this.mDoneBtnText_x = this.mIntent.getStringExtra("param_done_button_highlight_wording");
    if (this.mDoneBtnText_x == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.mDoneBtnText);
      ((StringBuilder)localObject1).append("({0})");
      this.mDoneBtnText_x = ((StringBuilder)localObject1).toString();
    }
    this.mAddPassedMembersToResultSet = this.mIntent.getBooleanExtra("param_add_passed_members_to_result_set", false);
    this.mExitAnimation = this.mIntent.getIntExtra("param_exit_animation", 0);
    this.mBackButtonSide = this.mIntent.getIntExtra("param_back_button_side", 1);
    this.mIsPutMySelfFirst = this.mIntent.getBooleanExtra("is_put_myself_first", false);
    this.mIsForbidOnlyChooseMySelf = this.mIntent.getBooleanExtra("is_forbid_only_choose_myself", false);
    int i = this.mEntrance;
    if ((i != 14) && (i != 21)) {
      if (((i != 32) && (i != 43) && (i != 35)) || ((!this.mOnlyTroopMember) && (!this.mOnlyDiscussionMember)))
      {
        if ((this.mEntrance != 17) || (this.mUinsSelectedFriends == null)) {
          break label1248;
        }
        i = 0;
      }
    }
    while (i < this.mUinsSelectedFriends.size())
    {
      if (!TextUtils.isEmpty((CharSequence)this.mUinsSelectedFriends.get(i)))
      {
        localObject1 = new ResultRecord();
        ((ResultRecord)localObject1).uin = ((String)this.mUinsSelectedFriends.get(i));
        this.mResultList.add(localObject1);
      }
      i += 1;
      continue;
      doEnableAllSelect(-1);
      localObject1 = this.mIntent.getStringExtra("group_uin");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!this.mIsSelectAllMembers) && (this.mUinsSelectedFriends != null))
      {
        i = 0;
        while (i < this.mUinsSelectedFriends.size())
        {
          if (!TextUtils.isEmpty((CharSequence)this.mUinsSelectedFriends.get(i)))
          {
            localObject2 = new ResultRecord();
            ((ResultRecord)localObject2).uin = ((String)this.mUinsSelectedFriends.get(i));
            int j;
            if (this.mOnlyDiscussionMember) {
              j = 2;
            } else {
              j = 1;
            }
            ((ResultRecord)localObject2).type = j;
            ((ResultRecord)localObject2).groupUin = ((String)localObject1);
            this.mResultList.add(localObject2);
          }
          i += 1;
          continue;
          localObject1 = this.mIntent.getParcelableArrayListExtra("param_default_selected_troop_members");
          if (localObject1 != null)
          {
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ResultRecord)((Iterator)localObject1).next();
              this.mResultList.add(localObject2);
            }
          }
        }
      }
    }
    label1248:
    this.isSupportSelectFriendGroup = this.mIntent.getBooleanExtra("is_support_select_from_friend_groups", false);
    QLog.d("SelectMemberActivity", 1, String.format("getIntentExtras [%d,%d,%d,%d,%s]", new Object[] { Integer.valueOf(this.mType), Integer.valueOf(this.mSubType), Integer.valueOf(this.mFrom), Integer.valueOf(this.mEntrance), this.mGroupCode }));
  }
  
  public CharDividedFacePreloadBaseAdapter getMemberListAdapter()
  {
    InnerFrameManager localInnerFrameManager = this.mInnerFrameManager;
    if ((localInnerFrameManager != null) && ((localInnerFrameManager.getCurrentView() instanceof TroopMemberListInnerFrame))) {
      return ((TroopMemberListInnerFrame)this.mInnerFrameManager.getCurrentView()).getMemberListAdapter();
    }
    return null;
  }
  
  int getNotAdminInviteMemberCount()
  {
    long l = Utils.a();
    Object localObject = this.app.getApp();
    String str = this.app.getAccount();
    int j = 0;
    localObject = ((BaseApplication)localObject).getSharedPreferences(str, 0).getString("not_admin_invite_member_count", null);
    int i = j;
    if (localObject != null) {}
    try
    {
      localObject = ((String)localObject).split(":");
      i = j;
      if (Long.parseLong(localObject[0]) == l) {
        i = Integer.parseInt(localObject[1]);
      }
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  ArrayList<ResultRecord> getOutGroupMem()
  {
    if ((this.mEntrance == 11) && (this.mGroupmembers != null))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.mResultList.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (!isGroupMember(localResultRecord.uin)) {
          localArrayList.add(localResultRecord);
        }
      }
      return localArrayList;
    }
    return this.mResultList;
  }
  
  public ArrayList<ResultRecord> getResultRecordList()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mResultList.size())
    {
      localArrayList.add(this.mResultList.get(i));
      i += 1;
    }
    Object localObject = this.mUinsSelectedDefault;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        ResultRecord localResultRecord = new ResultRecord();
        localResultRecord.uin = str;
        localResultRecord.type = 0;
        localResultRecord.groupUin = "-1";
        localResultRecord.name = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getNickName(this.app, localResultRecord.uin, localResultRecord.type);
        localArrayList.add(localResultRecord);
      }
    }
    return localArrayList;
  }
  
  public List<String> getResultUins()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mResultList.size())
    {
      localArrayList.add(((ResultRecord)this.mResultList.get(i)).uin);
      i += 1;
    }
    return localArrayList;
  }
  
  public ArrayList<String> getSelectedUinList()
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    while (i < this.mResultList.size())
    {
      localArrayList1.add(((ResultRecord)this.mResultList.get(i)).uin);
      i += 1;
    }
    ArrayList localArrayList2 = this.mUinsSelectedDefault;
    if (localArrayList2 != null) {
      localArrayList1.addAll(localArrayList2);
    }
    return localArrayList1;
  }
  
  protected String getTroopCodeFromTroopUin(String paramString)
  {
    paramString = findTroopInfo(paramString);
    if (paramString != null) {
      return paramString.troopcode;
    }
    return null;
  }
  
  TroopInfo getTroopInfo(String paramString)
  {
    return ((ITroopInfoService)this.app.getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(paramString);
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  protected void initInnerFrameManager()
  {
    this.mInnerFrameManager.a(this);
    this.mInnerFrameManager.setAppIntf((BaseQQAppInterface)this.app);
    if (this.mFrom == 30)
    {
      this.mInnerFrameManager.a(9, this.mIntent.getExtras());
      return;
    }
    if (this.mOnlyTroopMember)
    {
      this.mInnerFrameManager.a(6, this.mIntent.getExtras());
      return;
    }
    if (this.mOnlyDiscussionMember)
    {
      this.mInnerFrameManager.a(7, this.mIntent.getExtras());
      return;
    }
    if (this.mOnlySelectTroopOrDiscussionMember)
    {
      this.mInnerFrameManager.a(3);
      return;
    }
    this.mInnerFrameManager.a(0);
  }
  
  public void initSearchBar()
  {
    if (this.imm == null) {
      this.imm = ((InputMethodManager)getSystemService("input_method"));
    }
    this.mSearchResultLayout.setOnTouchListener(new SelectMemberActivity.10(this));
  }
  
  @SuppressLint({"NewApi"})
  protected void initSelectedBar()
  {
    if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this)) {
      this.mSelectedAndSearchBar.setIsFrom(1);
    }
    this.mSelectedAndSearchBar.a(this.mResultList, this.mFaceDecoder, this.mSelectedAndSearchBarCallback);
    int i;
    if (this.mResultList.size() != 0)
    {
      i = this.mEntrance;
      if ((i == 14) || (i == 21) || (i == 43)) {}
    }
    else
    {
      if (this.mEntrance != 32) {
        break label247;
      }
    }
    Iterator localIterator = this.mResultList.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      i = this.mEntrance;
      if ((i != 32) && (i != 43)) {
        localResultRecord.name = CommonUtils.a(this.app, localResultRecord.groupUin, localResultRecord.uin);
      } else if (localResultRecord.type == 1) {
        localResultRecord.name = CommonUtils.a(this.app, localResultRecord.groupUin, localResultRecord.uin);
      } else if (localResultRecord.type == 2) {
        localResultRecord.name = ((IDiscussionService)this.app.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberName(localResultRecord.groupUin, localResultRecord.uin);
      }
    }
    this.mSelectedAndSearchBar.a(true);
    checkNeedGameInfo(this, "", 1);
    label247:
    this.mRightBtn.setOnClickListener(new SelectMemberActivity.6(this));
  }
  
  protected void initTitleBar()
  {
    this.mLeftBackBtn.setVisibility(0);
    this.mLeftCancelBtn.setVisibility(8);
    this.mRightBtn.setVisibility(0);
    this.mLeftBackBtn.setText(2131916208);
    this.mLeftBackBtn.setBackgroundResource(0);
    this.mLeftBackBtn.setPadding(0, 0, 0, 0);
    this.mTitle.setText(this.mTitleString);
    if (AppSetting.e)
    {
      this.mTitle.setContentDescription(this.mTitleString);
      this.mLeftBackBtn.setContentDescription(getString(2131916208));
    }
    if (isShowDoneButtonInBottom())
    {
      this.mRightBtn.setVisibility(8);
      if (isCreateNewTroopEntrance())
      {
        this.mLeftBackBtn.setText("");
        this.mLeftBackBtn.setBackgroundResource(2130853297);
      }
      else if (isInviteTroopMember())
      {
        this.mLeftBackBtn.setText(2131887648);
        this.mLeftBackBtn.setBackgroundDrawable(null);
      }
      else
      {
        this.mLeftBackBtn.setText("");
        this.mLeftBackBtn.setBackgroundResource(2130853297);
      }
      this.mLeftCancelBtn.setVisibility(8);
    }
    this.mLeftBackBtn.setOnClickListener(new SelectMemberActivity.5(this));
    setupDoneBtn();
    if (this.mIntent.getBooleanExtra("show_invite_entry", false))
    {
      if (this.mEntrance == 35)
      {
        this.mRightBtn.setText(2131916206);
        ShareChatReport.f();
      }
      else
      {
        this.mRightBtn.setText(2131916207);
      }
      this.mRightBtn.setVisibility(0);
    }
  }
  
  boolean isCreateNewTroopEntrance()
  {
    int i = this.mEntrance;
    return (i == 27) || (i == 28) || (i == 12) || (i == 29) || (i == 39);
  }
  
  boolean isCreateNewTypeTroop()
  {
    boolean bool = isCreateNewTroopEntrance();
    int j = this.mResultList.size();
    ArrayList localArrayList = this.mUinsSelectedDefault;
    int i;
    if (localArrayList != null) {
      i = localArrayList.size();
    } else {
      i = 0;
    }
    return (bool) && (this.mSubType == 0) && (j + i >= 1);
  }
  
  boolean isGroupMember(String paramString)
  {
    Iterator localIterator = this.mGroupmembers.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(((TroopMemberInfo)localIterator.next()).memberuin, paramString)) {
        return true;
      }
    }
    return false;
  }
  
  boolean isInviteTroopMember()
  {
    return (this.mType == 1) && (this.mSubType == 1);
  }
  
  public boolean isInvitedListContainFriend(String paramString)
  {
    int i = 0;
    while (i < this.mInvitedUinList.size())
    {
      if (((String)this.mInvitedUinList.get(i)).equals(paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  boolean isMemberOverLoad(String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    int i = this.mEntrance;
    boolean bool = false;
    if (((i == 32) || (i == 43)) && (paramBoolean) && (this.mIntent.getBooleanExtra("param_enable_all_select", false))) {
      return false;
    }
    i = this.mType;
    if (i == 3000)
    {
      paramInt = this.mResultList.size();
      i = this.mMaxSelectNumber;
      if (paramInt >= i)
      {
        if ((this.mEntrance == 12) && (i == 1))
        {
          showMemberOverloadToast(2131888755);
          return true;
        }
        showMemberOverloadToast(2131888750);
        return true;
      }
    }
    else
    {
      if (i == 1)
      {
        if ((this.mIsLimitToInviteByTroopMaxLimit) && (this.mResultList.size() >= this.mMaxSelectNumber))
        {
          showMemberOverloadToast(HardCodeUtil.a(2131911189));
          return true;
        }
        i = this.mSubType;
        if (i == 0)
        {
          if (this.mResultList.size() < this.mMaxSelectNumber) {
            break label1110;
          }
          showMemberOverloadToast(getString(2131917686));
          return true;
        }
        if (i == 1)
        {
          if (this.mResultList.size() >= this.mMaxSelectNumber)
          {
            showMemberOverloadToast(2131917686);
            return true;
          }
          if (this.mEntrance != 11) {
            break label1110;
          }
          Object localObject = this.mGroupmembers;
          if (localObject == null) {
            break label1110;
          }
          int k = ((ArrayList)localObject).size() + 1;
          localObject = this.mIntent.getStringExtra("group_uin");
          i = getTroopInfo((String)localObject).getMemNumForAutoInviteIntoGroup(this.app.getCurrentUin());
          if (i > k) {
            i -= k;
          } else {
            i = 0;
          }
          int j = getOutGroupMem().size();
          int m = this.mResultList.size();
          paramBoolean = isGroupMember(paramString2);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("isMemberOverLoad[");
            localStringBuilder.append(paramString1);
            localStringBuilder.append("], 可邀请的群外成员到达上限检查, 已经选择群内成员[");
            localStringBuilder.append(m - j);
            localStringBuilder.append("], 当前群成员[");
            localStringBuilder.append(k);
            localStringBuilder.append("], 实际可邀请的群外成员[");
            localStringBuilder.append(i);
            localStringBuilder.append("], 已经选择的群外成员[");
            localStringBuilder.append(j);
            localStringBuilder.append("], 当前选择的是群成员[");
            localStringBuilder.append(paramBoolean);
            localStringBuilder.append("], uin[");
            localStringBuilder.append(paramString2);
            localStringBuilder.append("], name[");
            localStringBuilder.append(paramString3);
            localStringBuilder.append("], type[");
            localStringBuilder.append(paramInt);
            localStringBuilder.append("], fromGroupUin[");
            localStringBuilder.append(paramString4);
            localStringBuilder.append("], mResultList[");
            localStringBuilder.append(this.mResultList.size());
            localStringBuilder.append("], groupUin[");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("], mGroupCode[");
            localStringBuilder.append(this.mGroupCode);
            localStringBuilder.append("]");
            QLog.w("SelectMemberActivity", 1, localStringBuilder.toString());
          }
          paramInt = j;
          if (!paramBoolean) {
            paramInt = j + 1;
          }
          paramBoolean = bool;
          if (paramInt <= i) {
            break label1033;
          }
          showMemberOverloadToast(2131917654);
        }
        else
        {
          if (i == 3)
          {
            if (this.mResultList.size() < this.mMaxSelectNumber) {
              break label1110;
            }
            showMemberOverloadToast(getString(2131917653));
            paramString1 = this.mGroupCode;
            paramString2 = new StringBuilder();
            paramString3 = (ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class);
            paramString4 = this.app;
            paramString2.append(paramString3.getMemberType(paramString4, paramString4.getCurrentAccountUin(), this.mGroupCode));
            paramString2.append("");
            ReportController.b(null, "dc00899", "Grp_video", "", "invite", "toast_over", 0, 0, paramString1, paramString2.toString(), "", "");
            return true;
          }
          if (i == 4)
          {
            paramInt = this.mResultList.size();
            i = this.mMaxSelectNumber;
            if (paramInt < i) {
              break label1110;
            }
            showMemberOverloadToast(getString(2131917402, new Object[] { Integer.valueOf(i) }));
            return true;
          }
          if (this.mResultList.size() < this.mMaxSelectNumber) {
            break label1110;
          }
          if (this.mEntrance == 35)
          {
            showMemberOverloadToast(2131917686);
            return true;
          }
          showMemberOverloadToast(2131917653);
          return true;
        }
      }
      else
      {
        if (i != 9003) {
          break label1035;
        }
        paramInt = this.mEntrance;
        if (paramInt != 15) {
          break label943;
        }
        paramInt = ((IBlessApi)QRoute.api(IBlessApi.class)).getAvailableSendCount(this.app);
        paramBoolean = bool;
        if (this.mResultList.size() < paramInt) {
          break label1033;
        }
        showMemberOverloadToast(String.format(getString(2131887600), new Object[] { Integer.valueOf(((IBlessApi)QRoute.api(IBlessApi.class)).getTotalSendLimit(this.app)) }));
      }
      for (;;)
      {
        paramBoolean = true;
        break;
        label943:
        paramBoolean = bool;
        if (paramInt != 32) {
          break;
        }
        paramInt = ((IBlessApi)QRoute.api(IBlessApi.class)).getWebAvailableSendCount(this.app);
        paramBoolean = bool;
        if (this.mResultList.size() < paramInt) {
          break;
        }
        showMemberOverloadToast(String.format(getString(2131887600), new Object[] { Integer.valueOf(((IBlessApi)QRoute.api(IBlessApi.class)).getWebTotalSendLimit(this.app)) }));
      }
      label1033:
      return paramBoolean;
      label1035:
      if (this.mResultList.size() >= this.mMaxSelectNumber)
      {
        if (this.mOverloadTipsIncludeDefaultCount)
        {
          paramString1 = this.mUinsSelectedDefault;
          if (paramString1 != null)
          {
            paramInt = paramString1.size();
            break label1077;
          }
        }
        paramInt = 0;
        label1077:
        showMemberOverloadToast(String.format(getString(2131892365), new Object[] { Integer.valueOf(paramInt + this.mMaxSelectNumber) }));
        return true;
      }
    }
    label1110:
    return false;
  }
  
  protected boolean isMemberOverload(String paramString1, String paramString2)
  {
    boolean bool2;
    if (this.mType == 9003)
    {
      boolean bool1;
      if ((this.mEntrance == 15) && (!((IBlessApi)QRoute.api(IBlessApi.class)).isUinBlessed(this.app, paramString1)) && (this.mUnblessedUinCount >= ((IBlessApi)QRoute.api(IBlessApi.class)).getAvailableUinCount(this.app)))
      {
        showMemberOverloadToast(String.format(getString(2131887601), new Object[] { Integer.valueOf(((IBlessApi)QRoute.api(IBlessApi.class)).getTotalUinLimit(this.app)) }));
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      bool2 = bool1;
      if (this.mEntrance == 32)
      {
        bool2 = bool1;
        if (!((IBlessApi)QRoute.api(IBlessApi.class)).isWebUinSended(this.app, paramString1))
        {
          bool2 = bool1;
          if (this.mUnblessedUinCount >= ((IBlessApi)QRoute.api(IBlessApi.class)).getWebAvailableUinCount(this.app))
          {
            showMemberOverloadToast(String.format(getString(2131918004), new Object[] { Integer.valueOf(((IBlessApi)QRoute.api(IBlessApi.class)).getWebTotalUinLimit(this.app)) }));
            return true;
          }
        }
      }
    }
    else
    {
      bool2 = false;
    }
    return bool2;
  }
  
  public boolean isResultListContainFriend(String paramString)
  {
    int i = 0;
    while (i < this.mResultList.size())
    {
      if (((ResultRecord)this.mResultList.get(i)).uin.equals(paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  boolean isShowDoneButtonInBottom()
  {
    if (!isCreateNewTroopEntrance())
    {
      if (isInviteTroopMember()) {
        return true;
      }
      int i = this.mEntrance;
      if (i == 35) {
        return true;
      }
      if (i == 40) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberActivity", 2, "isShowDoneButtonInBottom return false");
      }
      return false;
    }
    return true;
  }
  
  public boolean isSoftInputShowing()
  {
    return this.mIsSoftInputShowing;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void notifyListOrSearchChange(boolean paramBoolean)
  {
    InnerFrameManager localInnerFrameManager = this.mInnerFrameManager;
    if ((localInnerFrameManager != null) && ((localInnerFrameManager.getCurrentView() instanceof TroopMemberListInnerFrame))) {
      ((TroopMemberListInnerFrame)this.mInnerFrameManager.getCurrentView()).f();
    }
    if (paramBoolean) {
      adjustGridView(false);
    }
  }
  
  public void onAction(View paramView)
  {
    Object localObject2 = (IContactSearchModel)paramView.getTag(2131449867);
    if (localObject2 == null) {
      return;
    }
    if (this.mEntrance == 33) {
      ReportController.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.selectpage.searchclick", 0, 0, "", "", "", "");
    }
    paramView = ((IContactSearchModel)localObject2).c();
    String str = ((IContactSearchModel)localObject2).d().toString();
    boolean bool1 = localObject2 instanceof ContactSearchModelDiscussionMember;
    Object localObject1;
    if (bool1) {
      localObject1 = ((ContactSearchModelDiscussionMember)localObject2).s();
    } else if ((localObject2 instanceof ContactSearchModelNewTroopMember)) {
      localObject1 = ((ContactSearchModelNewTroopMember)localObject2).a;
    } else {
      localObject1 = "-1";
    }
    boolean bool2 = localObject2 instanceof ContactSearchModelPhoneContact;
    if (bool2)
    {
      paramView = ((ContactSearchModelPhoneContact)localObject2).a;
      if (TextUtils.isEmpty(paramView.uin))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("pstn");
        ((StringBuilder)localObject3).append(paramView.mobileNo);
        paramView = ((StringBuilder)localObject3).toString();
      }
      else if (paramView.uin.equals("0"))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramView.nationCode);
        ((StringBuilder)localObject3).append(paramView.mobileCode);
        paramView = ((StringBuilder)localObject3).toString();
      }
      else
      {
        paramView = paramView.uin;
      }
    }
    if ((localObject2 instanceof ContactSearchModelDiscussion))
    {
      paramView = new Bundle();
      localObject1 = (ContactSearchModelDiscussion)localObject2;
      paramView.putString("group_uin", ((ContactSearchModelDiscussion)localObject1).c());
      paramView.putString("group_name", ((ContactSearchModelDiscussion)localObject1).m());
      this.mInnerFrameManager.a(7, paramView);
      quitSearchState();
      return;
    }
    if ((localObject2 instanceof ContactSearchModelNewTroop))
    {
      paramView = (ContactSearchModelNewTroop)localObject2;
      localObject1 = paramView.t();
      if ((!((TroopInfo)localObject1).isAllowCreateDiscuss()) && (!((TroopInfo)localObject1).isTroopOwner(this.app.getCurrentAccountUin())) && (!((TroopInfo)localObject1).isTroopAdmin(this.app.getCurrentAccountUin())))
      {
        QQToast.makeText(this, 0, getResources().getString(2131895399), 0).show(getResources().getDimensionPixelSize(2131299920));
        return;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("group_uin", paramView.c());
      ((Bundle)localObject1).putString("group_name", paramView.m());
      this.mInnerFrameManager.a(6, (Bundle)localObject1);
      quitSearchState();
      return;
    }
    if ((localObject2 instanceof ContactSearchModelTroop))
    {
      paramView = (ContactSearchModelTroop)localObject2;
      localObject1 = paramView.t();
      if ((!((TroopInfo)localObject1).isAllowCreateDiscuss()) && (!((TroopInfo)localObject1).isTroopOwner(this.app.getCurrentAccountUin())) && (!((TroopInfo)localObject1).isTroopAdmin(this.app.getCurrentAccountUin())))
      {
        QQToast.makeText(this, 0, getResources().getString(2131895399), 0).show(getResources().getDimensionPixelSize(2131299920));
        return;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("group_uin", paramView.c());
      ((Bundle)localObject1).putString("group_name", paramView.m());
      this.mInnerFrameManager.a(6, (Bundle)localObject1);
      quitSearchState();
      return;
    }
    if (isInvitedListContainFriend(paramView))
    {
      QQToast.makeText(this, 1, HardCodeUtil.a(2131911200), 0).show(getTitleBarHeight());
      ReportController.b(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, (String)localObject1, "", "", "");
      return;
    }
    Object localObject3 = this.mUinsSelectedDefault;
    if (((localObject3 == null) || (!((ArrayList)localObject3).contains(paramView))) && (!isResultListContainFriend(paramView)) && (!isMemberOverLoad("onAction", false, paramView, str, -1, (String)localObject1)))
    {
      if (isMemberOverload(paramView, str)) {
        return;
      }
      localObject3 = (SelectMemberInnerFrame)this.mInnerFrameManager.getCurrentView();
      int j = this.mInnerFrameManager.getCurrentPage();
      int i = 5;
      if ((j != 5) && (this.mInnerFrameManager.getCurrentPage() != 0) && (this.mInnerFrameManager.getCurrentPage() != 4) && (this.mInnerFrameManager.getCurrentPage() != 3) && (this.mInnerFrameManager.getCurrentPage() != 8)) {
        if (this.mInnerFrameManager.getCurrentPage() == 6) {
          this.mResultList.add(constructAResultRecord(paramView, str, 1, ((SelectMemberInnerFrame)localObject3).getGroupUin()));
        }
      }
      for (;;)
      {
        break;
        if (this.mInnerFrameManager.getCurrentPage() == 7)
        {
          this.mResultList.add(constructAResultRecord(paramView, str, 2, ((SelectMemberInnerFrame)localObject3).getGroupUin()));
        }
        else if (this.mInnerFrameManager.getCurrentPage() == 1)
        {
          if ((paramView.startsWith("pstn")) && (preAddPstnNumber(paramView, str, 5, ((SelectMemberInnerFrame)localObject3).getGroupUin()))) {
            this.mResultList.add(constructAResultRecord(paramView, str, 5, ((SelectMemberInnerFrame)localObject3).getGroupUin()));
          } else if (paramView.startsWith("+")) {
            this.mResultList.add(constructAResultRecord(paramView, str, 4, ((SelectMemberInnerFrame)localObject3).getGroupUin()));
          } else {
            this.mResultList.add(constructAResultRecord(paramView, str, 0, ((SelectMemberInnerFrame)localObject3).getGroupUin()));
          }
        }
        else if (this.mInnerFrameManager.getCurrentPage() == 9)
        {
          localObject1 = constructAResultRecord(paramView, str, 1, ((SelectMemberInnerFrame)localObject3).getGroupUin());
          localObject2 = new ArrayList(1);
          ((List)localObject2).add(localObject1);
          addFriendResults((List)localObject2, false);
          break;
          if (bool1)
          {
            i = 2;
          }
          else if ((localObject2 instanceof ContactSearchModelNewTroopMember))
          {
            i = 1;
          }
          else
          {
            if ((localObject2 instanceof ContactSearchModelFriend)) {}
            do
            {
              i = 0;
              break label1109;
              if (!bool2) {
                break;
              }
              if ((paramView.startsWith("pstn")) && (preAddPstnNumber(paramView, str, 5, (String)localObject1))) {
                break label1109;
              }
            } while (!paramView.startsWith("+"));
            i = 4;
            break label1109;
            i = -1;
          }
          label1109:
          if (i != -1) {
            this.mResultList.add(constructAResultRecord(paramView, str, i, (String)localObject1));
          }
        }
      }
      onResultListChanged();
      setupDoneBtn();
      ((SelectMemberInnerFrame)localObject3).f();
      this.mSelectedAndSearchBar.a(true);
      this.mSelectedAndSearchBar.b();
      if (this.mType == 9003) {
        if ((this.mEntrance == 15) && (!((IBlessApi)QRoute.api(IBlessApi.class)).isUinBlessed(this.app, paramView))) {
          this.mUnblessedUinCount += 1;
        } else if ((this.mEntrance == 32) && (!((IBlessApi)QRoute.api(IBlessApi.class)).isWebUinSended(this.app, paramView))) {
          this.mUnblessedUinCount += 1;
        }
      }
      startRelationFriendAndTroopSearch(false);
      checkNeedGameInfo(this, paramView, 2);
    }
  }
  
  protected boolean onBackEvent()
  {
    if (!TextUtils.isEmpty(this.mSelectedAndSearchBar.getEditTextContent()))
    {
      quitSearchState();
      return true;
    }
    if (this.mSelectedAndSearchBar.a()) {
      quitSearchState();
    }
    switch (this.mInnerFrameManager.getCurrentPage())
    {
    default: 
      break;
    case 9: 
      finish();
      break;
    case 8: 
      this.mInnerFrameManager.a(0);
      return true;
    case 7: 
      if (this.mOnlyDiscussionMember)
      {
        finish();
        return true;
      }
      stopTitleProgress();
      this.mInnerFrameManager.a(3);
      return true;
    case 6: 
      if (this.mOnlyTroopMember)
      {
        finish();
        return true;
      }
      stopTitleProgress();
      this.mInnerFrameManager.a(3);
      return true;
    case 3: 
      if (this.mOnlySelectTroopOrDiscussionMember)
      {
        if (this.mEntrance == 27)
        {
          this.mIntent.putParcelableArrayListExtra("result_set", this.mResultList);
          ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
          setResult(-1, this.mIntent);
        }
        finish();
        return true;
      }
      stopTitleProgress();
      this.mInnerFrameManager.a(0);
      return true;
    case 1: 
    case 2: 
    case 4: 
    case 5: 
      stopTitleProgress();
      this.mInnerFrameManager.a(0);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (i == 2131447692)
    {
      this.mTooManyMembersTipsBar.setVisibility(8);
      this.isClosed = true;
      localObject1 = this.app;
      localObject2 = this.mGroupCode;
      localObject3 = new StringBuilder();
      localObject4 = (ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class);
      AppInterface localAppInterface = this.app;
      ((StringBuilder)localObject3).append(((ISelectMemberRefatorHelperApi)localObject4).getMemberType(localAppInterface, localAppInterface.getCurrentAccountUin(), this.mGroupCode));
      ((StringBuilder)localObject3).append("");
      ReportController.b((AppRuntime)localObject1, "dc00899", "invite_friend", "", "friend_list", "Clk_close", 0, 0, (String)localObject2, ((StringBuilder)localObject3).toString(), "", "");
    }
    else
    {
      localObject2 = null;
      if (i == 2131431507)
      {
        if (this.mEntrance == 35)
        {
          if (this.mResultList.size() >= 1) {
            localObject1 = "1";
          } else {
            localObject1 = "2";
          }
          ReportController.b(this.app, "CliOper", "", "", "0X8009E2B", "0X8009E2B", 0, 0, (String)localObject1, "", "", "");
        }
        if ((this.mEntrance == 12) && (this.mResultList.size() == 1))
        {
          localObject3 = (ResultRecord)this.mResultList.get(0);
          localObject4 = new Intent();
          ((Intent)localObject4).putExtra("select_memeber_single_friend", true);
          ((Intent)localObject4).putExtra("select_memeber_single_friend_type", ((ResultRecord)localObject3).type);
          i = ((ResultRecord)localObject3).type;
          if (((ResultRecord)localObject3).type == 1)
          {
            i = 1000;
            localObject1 = getTroopCodeFromTroopUin(((ResultRecord)localObject3).groupUin);
          }
          else
          {
            i = 0;
            localObject1 = localObject2;
          }
          if (((ResultRecord)localObject3).type == 2)
          {
            i = 1004;
            localObject1 = ((ResultRecord)localObject3).groupUin;
          }
          if (((ResultRecord)localObject3).type == 3) {
            i = 1021;
          } else if (((ResultRecord)localObject3).type == 4) {
            i = 1006;
          }
          localObject2 = findFriendEntityByUin(((ResultRecord)localObject3).uin);
          int j = i;
          if (localObject2 != null)
          {
            j = i;
            if (((Friends)localObject2).isFriend()) {
              j = 0;
            }
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("uin", ((ResultRecord)localObject3).uin);
          ((Bundle)localObject2).putInt("uintype", j);
          ((Bundle)localObject2).putString("uinname", ((ResultRecord)localObject3).name);
          ((Bundle)localObject2).putString("troop_uin", (String)localObject1);
          ((Intent)localObject4).putExtras((Bundle)localObject2);
          setResult(-1, (Intent)localObject4);
          finish();
        }
        else if (isCreateNewTroopEntrance())
        {
          createNewTypeDiscussion();
        }
        else if (isInviteTroopMember())
        {
          i = this.mEntrance;
          if (i == 11)
          {
            localObject1 = getOutGroupMem();
            if (((ArrayList)localObject1).size() > 0) {
              DialogUtil.a(this, 230, getString(2131893450), getString(2131893325), 2131893167, 2131893180, new SelectMemberActivity.18(this, (ArrayList)localObject1), new SelectMemberActivity.19(this)).show();
            } else {
              afterCreateTroopSucc(this.mIntent.getStringExtra("group_uin"), false);
            }
          }
          else if (i == 37)
          {
            this.mIntent.putParcelableArrayListExtra("result_set", this.mResultList);
            setResult(-1, this.mIntent);
            finish();
          }
          else
          {
            doInviteTroopMember(this.mResultList);
          }
        }
        else
        {
          this.mIntent.putParcelableArrayListExtra("result_set", this.mResultList);
          setResult(-1, this.mIntent);
          finish();
        }
      }
      else if (i == 2131429937)
      {
        quitSearchState();
        if (getResultUins().size() == 1)
        {
          localObject1 = (String)getResultUins().get(0);
          localObject2 = this.mOnSelectStateChangeListener;
          if (localObject2 != null) {
            ((SelectMemberActivity.IOnSelectStateChange)localObject2).a((String)localObject1);
          }
        }
        else
        {
          localObject1 = getIntent().getStringExtra("group_uin");
          ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).startUnitedVerifyMsgEditFragment(this, (String)localObject1, 10);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ThreadManager.post(new SelectMemberActivity.20(this, (String)localObject1), 5, null, true);
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreateTroopCompletely(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString1)))
    {
      ReportController.b(this.app, "dc00899", "Grp_create", "", "choose_cre", "cre_suc", 0, 0, paramString1, "", "", "");
      return;
    }
    int i = TroopCreateInfo.TroopCreateResult.a(paramInt);
    if (i != 0)
    {
      if (((ICreateTroopBlackListUtilApi)QRoute.api(ICreateTroopBlackListUtilApi.class)).checkAndHandleCreateGroupBlackListResult(this, this.app, paramString2, paramInt)) {
        return;
      }
      QQToast.makeText(this, 1, i, 0).show(getTitleBarHeight());
    }
  }
  
  public void onInviteComplete(int paramInt, String paramString)
  {
    boolean bool = QLog.isColorLevel();
    int i = 1;
    if ((bool) || (paramInt != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInviteComplete, retCode[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], troopUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], mSubType[");
      localStringBuilder.append(this.mSubType);
      localStringBuilder.append("], mEntrance[");
      localStringBuilder.append(this.mEntrance);
      localStringBuilder.append("]");
      QLog.w("SelectMemberActivity", 1, localStringBuilder.toString());
    }
    if (paramInt == 0) {
      paramInt = i;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      afterCreateTroopSucc(paramString, false);
      return;
    }
    QQToast.makeText(this, getString(2131888721), 2000).show(this.mTitleBar.getHeight());
  }
  
  boolean onListViewItemClick(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (isResultListContainFriend(paramString1))
    {
      removeFriendFromResultList(paramString1);
    }
    else if ((!isMemberOverLoad("onListViewItemClick1", false, paramString1, paramString2, paramInt, paramString3)) && (!isMemberOverload(paramString1, paramString2)) && (preAddPstnNumber(paramString1, paramString2, paramInt, paramString3)))
    {
      this.mResultList.add(constructAResultRecord(paramString1, paramString2, paramInt, paramString3));
      if (this.mType == 9003) {
        if ((this.mEntrance == 15) && (!((IBlessApi)QRoute.api(IBlessApi.class)).isUinBlessed(this.app, paramString1))) {
          this.mUnblessedUinCount += 1;
        } else if ((this.mEntrance == 32) && (!((IBlessApi)QRoute.api(IBlessApi.class)).isWebUinSended(this.app, paramString1))) {
          this.mUnblessedUinCount += 1;
        }
      }
      bool = true;
      break label173;
    }
    boolean bool = false;
    label173:
    if (isInvitedListContainFriend(paramString1))
    {
      removeFriendFromResultList(paramString1);
      QQToast.makeText(this, 1, HardCodeUtil.a(2131911209), 0).show(getTitleBarHeight());
      ReportController.b(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, paramString3, "", "", "");
      bool = false;
    }
    this.mSelectedAndSearchBar.a(bool);
    setupDoneBtn();
    onResultListChanged();
    startRelationFriendAndTroopSearch(true);
    checkNeedGameInfo(this, paramString1, 3);
    return bool;
  }
  
  boolean onListViewItemClick(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (isResultListContainFriend(paramString1))
    {
      removeFriendFromResultList(paramString1);
    }
    else if ((!isMemberOverLoad("onListViewItemClick2", false, paramString1, paramString2, paramInt, paramString3)) && (preAddPstnNumber(paramString1, paramString2, paramInt, paramString3)))
    {
      this.mResultList.add(constructAResultRecord(paramString1, paramString2, paramInt, paramString3, paramString4));
      bool = true;
      break label72;
    }
    boolean bool = false;
    label72:
    if (isInvitedListContainFriend(paramString1))
    {
      removeFriendFromResultList(paramString1);
      QQToast.makeText(this, 1, HardCodeUtil.a(2131911174), 0).show(getTitleBarHeight());
      ReportController.b(this.app, "dc00899", "invite_friend", "", "friend_list", "exp_toast_tobechecked", 0, 0, paramString3, "", "", "");
      bool = false;
    }
    this.mSelectedAndSearchBar.a(bool);
    setupDoneBtn();
    onResultListChanged();
    return bool;
  }
  
  public void onRelationTroopItemClick(String paramString)
  {
    int i = this.mEntrance;
    if ((i == 38) || (i == 29) || (i == 39))
    {
      if (TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.i("SelectMemberActivity", 2, "onRelationTroopItemClick: empty");
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRelationTroopItemClick: troopUin:");
        localStringBuilder.append(paramString);
        QLog.i("SelectMemberActivity", 2, localStringBuilder.toString());
      }
      onReusedTroop(paramString);
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
  }
  
  protected void onResultListChanged()
  {
    Object localObject2 = this.mResultList.iterator();
    boolean bool = false;
    Object localObject1 = null;
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
      if (localResultRecord.type == 5)
      {
        if (i >= 3)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("…");
          ((StringBuilder)localObject2).toString();
          break;
        }
        if (localObject1 == null)
        {
          localObject1 = localResultRecord.name;
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("、");
          localStringBuilder.append(localResultRecord.name);
          localObject1 = localStringBuilder.toString();
        }
        i += 1;
      }
    }
    localObject1 = this.contactSearchFragment;
    if (localObject1 != null) {
      ((ContactSearchFragment)localObject1).a(getResultUins(), this.mUinsSelectedDefault);
    }
    if (isShowDoneButtonInBottom())
    {
      int j = this.mResultList.size();
      if (j > 0)
      {
        i = this.mEntrance;
        if ((i != 35) && (i != 40))
        {
          if (isCreateNewTroopEntrance()) {
            i = 2131911210;
          } else {
            i = 2131911187;
          }
          localObject1 = MessageFormat.format(HardCodeUtil.a(i), new Object[] { Integer.valueOf(j) });
        }
        else
        {
          localObject1 = MessageFormat.format(this.mDoneBtnText_x, new Object[] { Integer.valueOf(j) });
        }
        this.mCreateTroopButton.setText((CharSequence)localObject1);
        this.mCreateTroopButton.setContentDescription((CharSequence)localObject1);
        NewTroopContactView.setCreateTroopButtonEnable(this.mCreateTroopButton, true);
      }
      else
      {
        i = this.mEntrance;
        if (i == 35)
        {
          localObject1 = this.mDoneBtnText;
          bool = true;
        }
        else if (i == 40)
        {
          localObject1 = this.mDoneBtnText;
        }
        else
        {
          if (isCreateNewTroopEntrance()) {
            i = 2131911178;
          } else {
            i = 2131911212;
          }
          localObject1 = HardCodeUtil.a(i);
        }
        this.mCreateTroopButton.setText((CharSequence)localObject1);
        this.mCreateTroopButton.setContentDescription((CharSequence)localObject1);
        NewTroopContactView.setCreateTroopButtonEnable(this.mCreateTroopButton, bool);
      }
    }
    if (isInviteTroopMember()) {
      refreshInviteTipsBar();
    }
  }
  
  public void onReusedTroop(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReusedTroop,troopUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], mSubType[");
      localStringBuilder.append(this.mSubType);
      localStringBuilder.append("], mEntrance[");
      localStringBuilder.append(this.mEntrance);
      localStringBuilder.append("]");
      QLog.w("SelectMemberActivity", 1, localStringBuilder.toString());
    }
    afterCreateTroopSucc(paramString, true);
  }
  
  boolean preAddPstnNumber(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool = true;
    if (paramInt == 5)
    {
      bool = isNotMaxOfPSTN();
      if (!bool) {
        QQToast.makeText(this, 2131916229, 1).show(getTitleBarHeight());
      }
      int i = getCheckPhoneNumberResId(paramString1);
      if (i == 0) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (paramInt == 0) {
        QQToast.makeText(this, i, 1).show(getTitleBarHeight());
      }
      if ((bool) && (paramInt != 0)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  protected ArrayList<ResultRecord> processResult()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mResultList.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      if (localResultRecord.type == 5)
      {
        if (localResultRecord.uin.startsWith("pstn")) {
          localResultRecord.uin = localResultRecord.uin.substring(4);
        }
        localArrayList.add(localResultRecord);
      }
    }
    return localArrayList;
  }
  
  public void qCircleReport(ArrayList<ResultRecord> paramArrayList, int paramInt)
  {
    if (paramArrayList != null)
    {
      Object localObject1 = null;
      Object localObject2 = paramArrayList.iterator();
      paramArrayList = (ArrayList<ResultRecord>)localObject1;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (ResultRecord)((Iterator)localObject2).next();
        if ((localObject1 != null) && (!TextUtils.isEmpty(((ResultRecord)localObject1).uin))) {
          if (paramArrayList == null)
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append(((ResultRecord)localObject1).uin);
            paramArrayList.append("");
            paramArrayList = new StringBuilder(paramArrayList.toString());
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("|");
            localStringBuilder.append(((ResultRecord)localObject1).uin);
            paramArrayList.append(localStringBuilder.toString());
          }
        }
      }
      if (paramArrayList != null)
      {
        localObject2 = new HashMap();
        if (paramInt == 41) {
          localObject1 = "1";
        } else {
          localObject1 = "2";
        }
        ((HashMap)localObject2).put("ext1", localObject1);
        ((HashMap)localObject2).put("ext6", paramArrayList.toString());
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(41).setSubActionType(1).setThrActionType(2).setExtras((HashMap)localObject2));
      }
    }
  }
  
  void quitSearchState()
  {
    this.imm.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.mSelectedAndSearchBar.b();
    this.mSelectedAndSearchBar.c();
    this.mSearchResultLayout.setVisibility(8);
    this.mIsSoftInputShowing = false;
  }
  
  public void refreshGVideoTextView(boolean paramBoolean, int paramInt)
  {
    if (this.mSubType == 3)
    {
      this.mGVideoTextView = ((TextView)findViewById(2131445525));
      if ((paramBoolean) && (getIntent().getIntExtra("param_member_show_type", 1) == 2))
      {
        this.mGVideoTextView.setVisibility(0);
        this.mGVideoTextView.setText(getString(2131895589, new Object[] { Integer.valueOf(Math.min(paramInt, this.mMaxSelectNumber)) }));
        return;
      }
      this.mGVideoTextView.setVisibility(0);
      this.mGVideoTextView.setText(getString(2131895591, new Object[] { Integer.valueOf(this.mMaxSelectNumber) }));
    }
  }
  
  protected void refreshInviteTipsBar()
  {
    Object localObject = getTroopInfo(this.mGroupCode);
    if (localObject != null)
    {
      if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x6100000) == 0L) {}
      for (;;)
      {
        bool1 = true;
        break label117;
        if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x2000000) == 33554432L)
        {
          if (((TroopInfo)localObject).wMemberNum + this.mResultList.size() <= 50) {
            break label115;
          }
        }
        else
        {
          if ((((TroopInfo)localObject).troopPrivilegeFlag & 0x4000000) != 67108864L) {
            break;
          }
          if (((TroopInfo)localObject).wMemberNum + this.mResultList.size() <= 100) {
            break label115;
          }
        }
      }
      long l = ((TroopInfo)localObject).troopPrivilegeFlag;
      label115:
      boolean bool1 = false;
      label117:
      boolean bool2 = bool1;
      if (bool1) {
        bool2 = ((TroopInfo)localObject).isAdmin() ^ true;
      }
      if ((((TroopInfo)localObject).maxInviteMemNum > 0) && (((TroopInfo)localObject).wMemberNum + this.mResultList.size() > ((TroopInfo)localObject).maxInviteMemNum)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refreshInviteTipsBar needAdminCheck = ");
        ((StringBuilder)localObject).append(bool2);
        ((StringBuilder)localObject).append(" needAgree = ");
        ((StringBuilder)localObject).append(bool1);
        QLog.d("SelectMemberActivity", 2, ((StringBuilder)localObject).toString());
      }
      if ((!bool2) && (!bool1))
      {
        this.needShowYellowTips = false;
        int i = this.mEntrance;
        if ((i != 11) && (i != 36)) {
          this.mInviteSuccToastWording = HardCodeUtil.a(2131911204);
        } else {
          this.mInviteSuccToastWording = getString(2131893343);
        }
      }
      else if ((!bool2) && (bool1))
      {
        this.needShowYellowTips = true;
        this.mYellowTipsWording = HardCodeUtil.a(2131911185);
        this.mInviteSuccToastWording = HardCodeUtil.a(2131911214);
      }
      else if ((bool2) && (bool1))
      {
        this.needShowYellowTips = true;
        this.mYellowTipsWording = HardCodeUtil.a(2131911201);
        this.mInviteSuccToastWording = HardCodeUtil.a(2131911190);
      }
      else if ((bool2) && (!bool1))
      {
        this.needShowYellowTips = true;
        this.mYellowTipsWording = HardCodeUtil.a(2131911181);
        this.mInviteSuccToastWording = HardCodeUtil.a(2131911192);
      }
      if ((!this.isClosed) && (this.needShowYellowTips) && (!TextUtils.isEmpty(this.mYellowTipsWording)))
      {
        this.mTooManyMembersTipsBar.setVisibility(0);
        localObject = (TextView)this.mTooManyMembersTipsBar.findViewById(2131447693);
        ((TextView)localObject).setText(this.mYellowTipsWording);
        ((TextView)localObject).setContentDescription(this.mYellowTipsWording);
        return;
      }
      this.mTooManyMembersTipsBar.setVisibility(8);
    }
  }
  
  public boolean removeAllFriendResult()
  {
    this.mResultList.clear();
    this.mSelectedAndSearchBar.a(false);
    setupDoneBtn();
    onResultListChanged();
    return true;
  }
  
  void removeFriendFromResultList(String paramString)
  {
    int i = 0;
    while (i < this.mResultList.size())
    {
      if (((ResultRecord)this.mResultList.get(i)).uin.equals(paramString))
      {
        this.mResultList.remove(i);
        if (this.mType == 9003) {
          if ((this.mEntrance == 15) && (!((IBlessApi)QRoute.api(IBlessApi.class)).isUinBlessed(this.app, paramString))) {
            this.mUnblessedUinCount -= 1;
          } else if ((this.mEntrance == 32) && (!((IBlessApi)QRoute.api(IBlessApi.class)).isWebUinSended(this.app, paramString))) {
            this.mUnblessedUinCount -= 1;
          }
        }
      }
      i += 1;
    }
    onResultListChanged();
  }
  
  public void reportInviteFriend(String paramString)
  {
    ThreadManagerV2.excute(new SelectMemberActivity.8(this, paramString), 32, null, false);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  protected void sendContactsListBroadcast()
  {
    Object localObject1 = this.mResultList;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      Object localObject2 = processResult();
      localObject1 = new Intent("tencent.video.q2v.SelectMember");
      ((Intent)localObject1).setPackage(this.app.getApplication().getPackageName());
      if (((ArrayList)localObject2).size() > 0) {
        ((Intent)localObject1).putParcelableArrayListExtra("SelectMemberList", (ArrayList)localObject2);
      }
      int i = this.mResultList.size();
      localObject2 = ((ResultRecord)this.mResultList.get(0)).name;
      ((Intent)localObject1).putExtra("InviteCount", i);
      ((Intent)localObject1).putExtra("FirstName", (String)localObject2);
      this.app.getApp().sendBroadcast((Intent)localObject1);
    }
  }
  
  protected void setContentLayout()
  {
    try
    {
      setContentView(2131629266);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QLog.e("SelectMemberActivity", 1, "setContentView IllegalStateException", localIllegalStateException);
    }
  }
  
  public void setGroupMembers(ArrayList<Entity> paramArrayList)
  {
    this.mGroupmembers = paramArrayList;
  }
  
  void setNotAdminInviteMemberCount(int paramInt)
  {
    long l = Utils.a();
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    localEditor.putString("not_admin_invite_member_count", localStringBuilder.toString());
    localEditor.commit();
  }
  
  public void setOnSelectStateChangeListener(SelectMemberActivity.IOnSelectStateChange paramIOnSelectStateChange)
  {
    this.mOnSelectStateChangeListener = paramIOnSelectStateChange;
  }
  
  protected void setupDoneBtn()
  {
    if (this.mFrom == 30) {
      return;
    }
    if (this.mResultList.size() >= this.mMinSelectNumber)
    {
      setDoneBtnEnabled(true);
      return;
    }
    setDoneBtnEnabled(false);
  }
  
  public void setupTitleBar(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      this.mLeftBackBtn.setVisibility(0);
      this.mLeftBackBtn.setText(paramString1);
      this.mLeftBackBtn.setOnClickListener(new SelectMemberActivity.2(this));
      this.mLeftBackBtn.setBackgroundResource(2130853297);
      this.mLeftCancelBtn.setVisibility(8);
      QIphoneTitleBarActivity.setLayerType(this.mLeftBackBtn);
    }
    else
    {
      initTitleBar();
    }
    int i = this.mEntrance;
    if ((i != 14) && (i != 21) && (i != 25) && (i != 35))
    {
      if (this.mSubType == 3)
      {
        this.mTitle.setText(getString(2131895590));
      }
      else if (this.mFrom == 30)
      {
        this.mTitleString = getString(2131886219);
        if (!this.mTitle.getText().equals(this.mTitleString)) {
          this.mTitle.setText(this.mTitleString);
        }
        if (this.mRightBtn.getVisibility() != 0) {
          this.mRightBtn.setVisibility(0);
        }
        if (8 != this.mLeftCancelBtn.getVisibility()) {
          this.mLeftCancelBtn.setVisibility(8);
        }
        this.mLeftBackBtn.setVisibility(0);
        this.mRightBtn.setVisibility(8);
        this.mLeftBackBtn.setOnClickListener(new SelectMemberActivity.3(this));
        if (AppSetting.e)
        {
          this.mTitle.setContentDescription(this.mTitleString);
          this.mLeftBackBtn.setContentDescription(getString(2131916208));
        }
      }
      else
      {
        this.mTitle.setText(paramString2);
      }
    }
    else if (!TextUtils.isEmpty(this.mTitleString)) {
      this.mTitle.setText(this.mTitleString);
    } else {
      this.mTitle.setText(paramString2);
    }
    if (AppSetting.e)
    {
      paramString1 = this.mTitle;
      paramString1.setContentDescription(paramString1.getText());
      paramString2 = this.mLeftBackBtn;
      if (TextUtils.isEmpty(paramString2.getText())) {
        paramString1 = HardCodeUtil.a(2131911202);
      } else {
        paramString1 = this.mLeftBackBtn.getText();
      }
      paramString2.setContentDescription(paramString1);
      this.mLeftBackBtn.postDelayed(new SelectMemberActivity.4(this), 1000L);
    }
  }
  
  void showAllSelectBtn()
  {
    if (this.mEntrance != 35) {
      return;
    }
    Object localObject = this.mIntent;
    int i = 0;
    if (((Intent)localObject).getBooleanExtra("param_enable_all_select", false))
    {
      localObject = (RelativeLayout)findViewById(2131445020);
      if (localObject != null)
      {
        if (!this.mIsSelectAllMembers) {
          i = 8;
        }
        ((RelativeLayout)localObject).setVisibility(i);
      }
    }
  }
  
  protected void startCreateOrAdd()
  {
    if ((this.mType == 3000) && (isCreateNewTypeTroop()))
    {
      createNewTypeDiscussion();
      return;
    }
    int i = this.mType;
    if (i != 1)
    {
      Object localObject2;
      if (i != 3000)
      {
        localObject1 = this.mIntent.getStringExtra("group_uin");
        if (localObject1 != null)
        {
          i = this.mEntrance;
          if (((i == 32) || (i == 43)) && ((this.mOnlyTroopMember) || (this.mOnlyDiscussionMember)))
          {
            this.mIntent.putExtra("group_uin", (String)localObject1);
            if (this.mOnlyTroopMember)
            {
              localObject1 = getTroopInfo((String)localObject1);
              this.mIntent.putExtra("group_type", 4);
              if (localObject1 != null)
              {
                this.mIntent.putExtra("group_name", ((TroopInfo)localObject1).troopname);
                this.mIntent.putExtra("group_member_type", ((TroopInfo)localObject1).wMemberNum);
              }
            }
            else if (this.mOnlyDiscussionMember)
            {
              localObject2 = (DiscussionInfo)((IDiscussionService)this.app.getRuntimeService(IDiscussionService.class, "")).findDiscussionInfoByID((String)localObject1);
              this.mIntent.putExtra("group_type", 8);
              this.mIntent.putExtra("group_member_type", ((IDiscussionService)this.app.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum((String)localObject1));
              if (localObject2 != null) {
                this.mIntent.putExtra("group_name", ((DiscussionInfo)localObject2).discussionName);
              }
            }
            if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this)) {
              ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).fillResultRecordLevelIcon(convertToGameTroopSelectMemberInfoList(this.mResultList));
            }
          }
        }
        i = this.mEntrance;
        if ((i == 42) || (i == 41)) {
          qCircleReport(this.mResultList, this.mEntrance);
        }
        this.mIntent.putParcelableArrayListExtra("result_set", this.mResultList);
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
        setResult(-1, this.mIntent);
        finish();
        return;
      }
      if (this.mAddPassedMembersToResultSet)
      {
        localObject1 = this.mUinsSelectedDefault.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (!hasAdd2ResultList((String)localObject2))
          {
            ResultRecord localResultRecord = new ResultRecord();
            localResultRecord.uin = ((String)localObject2);
            localResultRecord.type = 0;
            localResultRecord.groupUin = "-1";
            this.mResultList.add(localResultRecord);
          }
        }
      }
      this.mResultList.size();
      Object localObject1 = this.mResultList.iterator();
      int j = 0;
      i = 0;
      int k;
      int m;
      do
      {
        do
        {
          k = j;
          m = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ResultRecord)((Iterator)localObject1).next();
          k = j;
          if (((ResultRecord)localObject2).type == 3) {
            k = 1;
          }
          m = i;
          if (((ResultRecord)localObject2).type != 5) {
            m = 1;
          }
          j = k;
          i = m;
        } while (k == 0);
        j = k;
        i = m;
      } while (m == 0);
      if (k != 0) {
        ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "0", "", "", "");
      } else {
        ReportController.b(this.app, "CliOper", "", "", "Network_circle", "Mutichat_start", 0, 0, "1", "", "", "");
      }
      if (this.mSubType == 0) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005446", "0X8005446", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.app, "CliOper", "", "", "0X800674C", "0X800674C", 0, 0, "", "", "", "");
      }
      if (this.mSubType == 0) {
        i = 2131888723;
      } else {
        i = 2131888720;
      }
      this.mQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131299920));
      this.mQQProgressDialog.c(i);
      this.mQQProgressDialog.show();
      if ((this.mSubType == 0) || (m != 0))
      {
        localObject1 = new SelectMemberActivity.11(this);
        ((Thread)localObject1).setName("SelectMemberActivity_addDiscussion");
        ThreadManager.postImmediately((Runnable)localObject1, null, false);
      }
      if (this.mSubType != 0)
      {
        sendContactsListBroadcast();
        if (m == 0) {
          finish();
        }
      }
    }
    else
    {
      doInviteTroopMember(this.mResultList);
    }
  }
  
  public void startTitleProgress()
  {
    if ((this.mTitle != null) && (this.mAnimationDrawable == null))
    {
      this.mAnimationDrawable = getResources().getDrawable(2130839590);
      this.mTitle.setCompoundDrawablePadding(10);
      this.mTitle.setCompoundDrawablesWithIntrinsicBounds(this.mAnimationDrawable, null, null, null);
      ((Animatable)this.mAnimationDrawable).start();
    }
  }
  
  public void stopTitleProgress()
  {
    if (this.mTitle != null)
    {
      Drawable localDrawable = this.mAnimationDrawable;
      if (localDrawable != null)
      {
        ((Animatable)localDrawable).stop();
        this.mAnimationDrawable = null;
        this.mTitle.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  public void toggleSelectMode(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.mModeMulti ^= true;
    }
    Object localObject = this.mMultiSearchView;
    int i;
    if (this.mModeMulti) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    setupTitleBar(false, "", "");
    if (this.mModeMulti)
    {
      this.mMultiAddContainerV.setVisibility(0);
      if (this.mResultList.isEmpty()) {
        localObject = getString(2131888030);
      } else {
        localObject = getString(2131888031, new Object[] { Integer.valueOf(this.mResultList.size()) });
      }
      Button localButton = this.mMultiAddBtn;
      if (localButton != null) {
        localButton.setText((CharSequence)localObject);
      }
    }
    else
    {
      this.mSearchResultLayout.setVisibility(8);
      this.mMultiSearchView.setVisibility(8);
      this.mMultiAddContainerV.setVisibility(8);
    }
    this.mSelectedAndSearchBar.b();
    localObject = this.mMultiAddBtn;
    if (localObject != null) {
      ((Button)localObject).setEnabled(this.mResultList.isEmpty() ^ true);
    }
    localObject = this.mOnSelectStateChangeListener;
    if ((localObject != null) && (!paramBoolean2)) {
      ((SelectMemberActivity.IOnSelectStateChange)localObject).a(true, paramBoolean2);
    }
    if (!paramBoolean1)
    {
      this.mSelectedAndSearchBar.a(true);
      onResultListChanged();
    }
    quitSearchState();
    paramBoolean1 = this.mModeMulti;
    localObject = getIntent().getStringExtra("group_uin");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ThreadManager.post(new SelectMemberActivity.21(this, paramBoolean1, (String)localObject), 5, null, true);
    }
  }
  
  public void updateGameData(Map<String, List<TroopMemberInfo>> paramMap, int[] paramArrayOfInt, String[] paramArrayOfString)
  {
    InnerFrameManager localInnerFrameManager = this.mInnerFrameManager;
    if ((localInnerFrameManager != null) && ((localInnerFrameManager.getCurrentView() instanceof TroopMemberListInnerFrame)))
    {
      ((TroopMemberListInnerFrame)this.mInnerFrameManager.getCurrentView()).a(paramMap, paramArrayOfInt, paramArrayOfString);
      notifyListOrSearchChange(true);
    }
  }
  
  public void updateMultiAddState(ResultRecord paramResultRecord, boolean paramBoolean)
  {
    if (this.mEntrance != 30) {
      return;
    }
    Object localObject = this.mOnSelectStateChangeListener;
    if (localObject != null) {
      ((SelectMemberActivity.IOnSelectStateChange)localObject).a(paramResultRecord, paramBoolean);
    }
    if (this.mResultList.isEmpty()) {
      paramResultRecord = getString(2131888030);
    } else {
      paramResultRecord = getString(2131888031, new Object[] { Integer.valueOf(this.mResultList.size()) });
    }
    localObject = this.mMultiAddBtn;
    if (localObject != null)
    {
      ((Button)localObject).setText(paramResultRecord);
      this.mMultiAddBtn.setEnabled(true ^ this.mResultList.isEmpty());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberActivity
 * JD-Core Version:    0.7.0.1
 */