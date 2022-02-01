package com.tencent.mobileqq.troop.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ImagePreviewAnimationUtil;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.kandian.base.utils.TimeUtil;
import com.tencent.mobileqq.kandian.biz.account.api.IFastModule;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import com.tencent.mobileqq.troop.viewmodel.MainPictureShowActionNotifier;
import com.tencent.mobileqq.troop.viewmodel.PictureShowViewModel;
import com.tencent.mobileqq.troop.viewmodel.PictureShowViewModelFactory;
import com.tencent.mobileqq.troop.viewmodel.SocialBottomBarData;
import com.tencent.mobileqq.troop.viewmodel.ToolPictureShowActionNotifier;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.ImageAnimationView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Gallery;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@RoutePage(desc="大图展示 TroopAvatarWallPreviewActivity", path="/base/troop/activity/TroopAvatarWallPreviewActivity")
public class TroopAvatarWallPreviewActivity
  extends BaseActivity
{
  public static final String CURTYPE_KEY = "curType";
  public static final String FACE_ID_KEY = "faceid";
  public static final String FRIEND_UIN_KEY = "friendUin";
  public static final String ID_KEY = "_id";
  public static final String INDEX_KEY = "index";
  public static final String KANDIAN_IMAGE_SID = "4";
  public static final String KEY_ACTICLE_INFO_ROWKEY = "acticle_info_rowkey";
  public static final String KEY_BTN_TEXT = "btntext";
  public static final String KEY_BUNDLE_DATA_EXTRA = "bundle_data_extra";
  public static final String KEY_CALLBACK_SEQ = "callback_seq";
  public static final String KEY_DEFAULT_AVATOR_INDEX = "default_avator_index";
  public static final String KEY_DT_PG_ID = "dt_page_id";
  public static final String KEY_DT_PG_PARAMS = "dt_page_params";
  public static final String KEY_EXTEND_FRIEND_DELETE_PATH_LIST = "extend_friend_delete_path_list";
  public static final String KEY_FROM_EXTEND_FRIEND_EDIT = "from_extend_Friend_edit";
  public static final String KEY_FROM_PERSONALITY_LABEL = "from_personality_label";
  public static final String KEY_FROM_TYPE = "from_type";
  public static final String KEY_IS_FROM_TOOL_PROCESS = "is_from_tool_process";
  public static final String KEY_IS_NOT_SHOW_INDEX = "is_not_show_index";
  public static final String KEY_NEED_TO_AIO = "is_need_to_aio";
  public static final String KEY_ORIGIN_LIST = "origin_list";
  public static final String KEY_ORIGIN_SIZE_LIST = "origin_size_list";
  public static final String KEY_SAVE_INTENT_TO_FILE = "save_intent_to_file";
  public static final String KEY_SEQ_NUM = "seqNum";
  public static final String KEY_SHOW_SOCIAL_BOTTOM_BAR = "show_social_bottom_bar";
  public static final String KEY_SHOW_SOCIAL_BOTTOM_BAR_DATA = "show_social_bottom_bar_data";
  public static final String KEY_SHOW_TITLE_BAR = "show_title_bar";
  public static final String KEY_SRC_ID = "src_id";
  public static final String KEY_STR_DATA_EXTRA = "str_data_extra";
  public static final String KEY_THUMBNAL_BOUND = "KEY_THUMBNAL_BOUND";
  public static final String NEARBY_WEB = "5";
  public static final String PUBLIC_ACCOUNT_IMAGE_SID = "2000";
  public static final String READINJOY_PIC_GALLERY_DETAIL = "6";
  public static final String REQUEST_TYPE_KEY = "requestTypeKey";
  public static final String TAG = "TroopAvatarWallPreviewActivity";
  public static final String TRIBE_IMAGE_SID = "2";
  public static final String URL_KEY = "url";
  static boolean mIsOpen = false;
  static Object sLock = new Object();
  boolean animated = false;
  private ArrayList<String> extendFriendDeletePathList = new ArrayList();
  protected ImageView imageView;
  protected boolean isFromPlugin = false;
  protected boolean isGridImageReport = false;
  protected boolean isNeedToAio = true;
  protected boolean isShowContentUrl = false;
  protected TroopAvatarBigPhotoAdapter mAdapter;
  protected ImageAnimationView mAnimationView;
  protected View mBgView;
  protected View mBottomBar;
  protected View mBottomBarSwitch;
  protected RelativeLayout mBottomBlock;
  private TranslateAnimation mBottomLayoutTranslateDownAnimation;
  private TranslateAnimation mBottomLayoutTranslateUpAnimation;
  protected View.OnClickListener mClickLis = new TroopAvatarWallPreviewActivity.32(this);
  protected ImageView mCommentBtn;
  protected View mContentUrlLayout;
  CookieManager mCookieMgr;
  protected List<String> mDelList;
  protected ImageButton mDelbtn;
  protected boolean mDeleteAbility = false;
  protected ArrayList<String> mDescs;
  protected TextView mDetailBtn;
  protected long mEnterAnimationDuring = 300L;
  private Bundle mExtras;
  protected String mExtrasStr;
  protected Gallery mGallery;
  protected int mIndex;
  private boolean mIsBottomBarUp = true;
  protected boolean mIsEdit = false;
  protected boolean mIsFromPhotoWall;
  protected boolean mIsNotShowIndex;
  protected boolean mIsShowAction;
  protected boolean mIsShowMenu;
  protected boolean mIsTroopMember = false;
  protected ImageView mLikeBtn;
  protected boolean[] mLikes;
  protected ImageView mMenuBtn;
  protected boolean mNeedBottomBar = false;
  protected ArrayList<String> mOriginList;
  protected TextView mOriginPicBtn;
  protected ArrayList<String> mOriginSizeList;
  PersonalityLabelObserver mPersonalityLabelObserver = new TroopAvatarWallPreviewActivity.35(this);
  protected TextView mPhotoDesc;
  protected ArrayList<String> mPhotoIds;
  protected ArrayList<String> mPhotoTimes;
  protected ArrayList<Integer> mPreviewPhotoLocation;
  QQProgressDialog mProgressDialog;
  private PublicAccountShowPictureReport mPublicAccountShowPictureReport = new PublicAccountShowPictureReport();
  private BroadcastReceiver mReceiver = new TroopAvatarWallPreviewActivity.31(this);
  protected RelativeLayout mRoot;
  protected FrameLayout mRootParent;
  private TroopAvatarWallPreviewActivity.RotationObserver mRotationObserver;
  protected int mSeqListLength;
  protected List<String> mSeqNumList;
  protected String mSrcId;
  protected TextView mTextView;
  protected ArrayList<Rect> mThumbRect;
  protected String mTroopUin;
  private View.OnClickListener operateBarListener = new TroopAvatarWallPreviewActivity.15(this);
  private PictureShowViewModel pictureShowViewModel;
  Runnable setAnimateFlagRunnable = null;
  private View socialBottomBar;
  String tempPath;
  private TextView titleBarTitle;
  
  private boolean applyExitAnimation()
  {
    Object localObject1 = this.mGallery.getSelectedView();
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = ((ImageView)((View)localObject1).findViewById(2131435357)).getDrawable();
    if ((localObject2 != null) && ((localObject2 instanceof URLDrawable)))
    {
      if (((URLDrawable)localObject2).getStatus() != 1) {
        return false;
      }
    }
    else if (localObject2 == null) {
      return false;
    }
    this.mRootParent.setVisibility(0);
    this.mAnimationView.setVisibility(0);
    localObject1 = new Rect();
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    Rect localRect3 = new Rect();
    localObject2 = makeAnimationRect(localRect2, localRect3, (Rect)localObject1, localRect1, (Drawable)localObject2, localObject2 instanceof URLDrawable);
    if (localObject2 == null) {
      return false;
    }
    this.animated = true;
    this.mAnimationView.a((Bitmap)localObject2, localRect3, localRect2, localRect1, (Rect)localObject1, this.mEnterAnimationDuring);
    this.mAnimationView.setInterpolator(new DecelerateInterpolator());
    this.mAnimationView.setAnimationListener(new TroopAvatarWallPreviewActivity.27(this));
    this.mAnimationView.a();
    this.mRootParent.postDelayed(new TroopAvatarWallPreviewActivity.28(this), this.mEnterAnimationDuring);
    localObject1 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject1).setInterpolator(new DecelerateInterpolator());
    ((AlphaAnimation)localObject1).setDuration(500L);
    ((AlphaAnimation)localObject1).setFillAfter(true);
    this.mBgView.startAnimation((Animation)localObject1);
    return true;
  }
  
  private void configDtReportParam()
  {
    Object localObject = getIntent();
    if (localObject == null) {
      return;
    }
    String str = ((Intent)localObject).getStringExtra("dt_page_id");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    VideoReport.addToDetectionWhitelist(this);
    VideoReport.setPageId(this, str);
    localObject = ((Intent)localObject).getSerializableExtra("dt_page_params");
    if ((localObject instanceof Map)) {
      VideoReport.setPageParams(this, new PageParams((HashMap)localObject));
    }
  }
  
  private void deleteExtendFriendPhotoWall(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.mAdapter.getCount() - 1)) {
      return;
    }
    DialogUtil.a(this, 230).setTitle(getString(2131896842)).setPositiveButton(getString(2131892267), new TroopAvatarWallPreviewActivity.26(this)).setNegativeButton(getString(2131887648), new TroopAvatarWallPreviewActivity.25(this)).show();
  }
  
  private void deletePernalityLabelPhoto(int paramInt, Bundle paramBundle)
  {
    if ((paramInt >= 0) && (paramInt <= this.mAdapter.getCount() - 1))
    {
      ArrayList localArrayList = this.mPhotoIds;
      if (localArrayList != null)
      {
        if (paramInt > localArrayList.size() - 1) {
          return;
        }
        ReportController.b(this.app, "dc00898", "", "", "0X8007FD5", "0X8007FD5", 0, 0, "0", "0", "", "");
        DialogUtil.a(this, 230).setTitle(getString(2131897160)).setPositiveButton(getString(2131892267), new TroopAvatarWallPreviewActivity.34(this, paramBundle, paramInt)).setNegativeButton(getString(2131887648), new TroopAvatarWallPreviewActivity.33(this)).show();
      }
    }
  }
  
  private void dismissWaittingDialog()
  {
    QQProgressDialog localQQProgressDialog = this.mProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.mProgressDialog.dismiss();
    }
  }
  
  private void downloadOrgImage()
  {
    ArrayList localArrayList = this.mOriginList;
    if ((localArrayList != null) && (this.mIndex < localArrayList.size()) && (!TextUtils.isEmpty((CharSequence)this.mOriginList.get(this.mIndex))))
    {
      this.mAdapter.d(true);
      this.mAdapter.a(this.mOriginPicBtn);
      this.mAdapter.notifyDataSetChanged();
      LpReportInfo_pf00064.allReport(301, 34, 2);
    }
  }
  
  private void handleShowContentUrl(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAvatarWallPreviewActivity", 2, "ReadInJoy Grid Images isShowContentUrl: true");
    }
    String str2 = paramBundle.getString("article_title", "");
    String str1 = paramBundle.getString("article_url", "");
    int i = paramBundle.getInt("channel_id", 0);
    long l = paramBundle.getLong("articleSeq", 0L);
    AbsBaseArticleInfo localAbsBaseArticleInfo = ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(i, l);
    Object localObject = this.mTextView;
    if ((localObject != null) && ((((TextView)localObject).getParent() instanceof RelativeLayout)))
    {
      localObject = (RelativeLayout.LayoutParams)this.mTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, 0);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, AIOUtils.b(20.0F, getResources()), 0, 0);
      this.mTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    paramBundle = paramBundle.getString("btntext", "");
    if (!TextUtils.isEmpty(str1))
    {
      this.mContentUrlLayout = ((ViewStub)findViewById(2131446486)).inflate();
      this.mContentUrlLayout.setVisibility(0);
      localObject = this.mContentUrlLayout;
      if ((localObject != null) && ((localObject instanceof LinearLayout)))
      {
        localObject = (TextView)((View)localObject).findViewById(2131447463);
        if (!TextUtils.isEmpty(str2)) {
          ((TextView)localObject).setText(str2);
        }
        localObject = (Button)this.mContentUrlLayout.findViewById(2131444203);
        if (!TextUtils.isEmpty(paramBundle)) {
          ((Button)localObject).setText(paramBundle);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("init,btnText:");
        localStringBuilder.append(paramBundle);
        localStringBuilder.append(" articleTitle:");
        localStringBuilder.append(str2);
        localStringBuilder.append(" articleUrl:");
        localStringBuilder.append(str1);
        QLog.d("TroopAvatarWallPreviewActivity", 1, localStringBuilder.toString());
        paramBundle = new GradientDrawable();
        paramBundle.setStroke(AIOUtils.b(1.0F, getResources()), -1996488705);
        ((Button)localObject).setBackgroundDrawable(paramBundle);
        ((Button)localObject).setOnClickListener(new TroopAvatarWallPreviewActivity.12(this, localAbsBaseArticleInfo, str1));
      }
    }
  }
  
  private void init()
  {
    if (isFinishing()) {
      return;
    }
    this.imageView = ((ImageView)findViewById(2131435357));
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    this.mPublicAccountShowPictureReport.parse(localBundle.getString("PublicAccountShowPictureReport"));
    if (this.mPublicAccountShowPictureReport.isReport) {
      this.mPublicAccountShowPictureReport.showStart();
    }
    this.mGallery = ((Gallery)findViewById(2131433934));
    this.mGallery.setVisibility(0);
    this.mTextView = ((TextView)findViewById(2131447062));
    this.mRoot = ((RelativeLayout)findViewById(2131445137));
    this.mBottomBlock = ((RelativeLayout)findViewById(2131429644));
    this.mBgView = findViewById(2131429234);
    this.mRootParent = ((FrameLayout)findViewById(2131445141));
    this.mDelbtn = ((ImageButton)findViewById(2131431689));
    this.mBgView.setBackgroundColor(-16777216);
    this.mAnimationView = ((ImageAnimationView)findViewById(2131428368));
    this.mMenuBtn = ((ImageView)findViewById(2131427966));
    this.mBottomBarSwitch = findViewById(2131439675);
    this.mOriginPicBtn = ((TextView)findViewById(2131439700));
    this.mOriginPicBtn.setOnClickListener(this.mClickLis);
    this.mPhotoDesc = ((TextView)findViewById(2131440272));
    this.mRootParent.setVisibility(0);
    this.mIsEdit = localBundle.getBoolean("IS_EDIT");
    if (this.mIsEdit)
    {
      this.mDelbtn.setVisibility(0);
      this.mDelbtn.setOnClickListener(this.mClickLis);
    }
    else
    {
      this.mDelbtn.setVisibility(4);
    }
    this.mIsShowMenu = localBundle.getBoolean("SHOW_MENU");
    if (this.mIsShowMenu)
    {
      this.mMenuBtn.setImageResource(2130838020);
      this.mMenuBtn.setOnClickListener(this.mClickLis);
      this.mMenuBtn.setVisibility(0);
    }
    else
    {
      this.mMenuBtn.setVisibility(4);
    }
    this.mBottomBarSwitch.setOnClickListener(this.operateBarListener);
    this.mThumbRect = localBundle.getParcelableArrayList("KEY_THUMBNAL_BOUND");
    this.mIsShowAction = localBundle.getBoolean("is_show_action", true);
    this.isNeedToAio = localBundle.getBoolean("is_need_to_aio", true);
    this.isFromPlugin = localBundle.getBoolean("is_from_plugin", false);
    this.mNeedBottomBar = localBundle.getBoolean("needBottomBar");
    if (this.mNeedBottomBar)
    {
      localObject = ((ViewStub)findViewById(2131446489)).inflate();
      this.mBottomBar = ((View)localObject).findViewById(2131439642);
      this.mLikeBtn = ((ImageView)((View)localObject).findViewById(2131439643));
      this.mCommentBtn = ((ImageView)((View)localObject).findViewById(2131439640));
      this.mDetailBtn = ((TextView)((View)localObject).findViewById(2131439641));
      this.mBottomBar.setBackgroundResource(2130842519);
      this.mLikeBtn.setOnClickListener(this.operateBarListener);
      this.mCommentBtn.setOnClickListener(this.operateBarListener);
      this.mDetailBtn.setOnClickListener(this.operateBarListener);
      this.mBottomBar.setVisibility(0);
      this.mBottomBarSwitch.setVisibility(0);
      ((ImageView)this.mBottomBarSwitch).setImageResource(2130850535);
      localObject = new IntentFilter("cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete");
      registerReceiver(this.mReceiver, (IntentFilter)localObject);
    }
    else
    {
      this.mBottomBarSwitch.setVisibility(8);
    }
    this.mLikes = localBundle.getBooleanArray("likes");
    this.mAdapter = new TroopAvatarBigPhotoAdapter(this, this.app);
    this.mTroopUin = localBundle.getString("troop_uin");
    this.mIsTroopMember = localBundle.getBoolean("troop_info_is_member");
    this.mSeqNumList = localBundle.getStringArrayList("seqNum");
    this.mPreviewPhotoLocation = localBundle.getIntegerArrayList("mPreviewPhotoLocation");
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable;
    ArrayList localArrayList = this.mPreviewPhotoLocation;
    if (localArrayList != null)
    {
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((Integer)localArrayList.get(2)).intValue();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((Integer)this.mPreviewPhotoLocation.get(3)).intValue();
    }
    if ((QLog.isColorLevel()) && (!this.mSeqNumList.isEmpty()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Clicl Big Data: first img url:");
      ((StringBuilder)localObject).append((String)this.mSeqNumList.get(0));
      QLog.d("TroopAvatarWallPreviewActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.mDescs = localBundle.getStringArrayList("descs");
    this.mPhotoIds = localBundle.getStringArrayList("photoIds");
    this.mPhotoTimes = localBundle.getStringArrayList("photoTimes");
    this.mDeleteAbility = localBundle.getBoolean("delete_ability");
    this.mIsNotShowIndex = localBundle.getBoolean("is_not_show_index", true);
    this.mSrcId = localBundle.getString("src_id");
    this.mExtras = localBundle.getBundle("bundle_data_extra");
    this.mExtrasStr = localBundle.getString("str_data_extra", "");
    this.mOriginList = localBundle.getStringArrayList("origin_list");
    this.mOriginSizeList = localBundle.getStringArrayList("origin_size_list");
    this.mIsFromPhotoWall = localBundle.getBoolean("from_photo_wall", false);
    if ((this.mOriginList == null) && (!this.mIsFromPhotoWall)) {
      this.mOriginPicBtn.setVisibility(0);
    }
    if (this.mSrcId != null) {
      ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer", "open", 0, 0, this.mSrcId, "", "", "");
    }
    localObject = this.mSeqNumList;
    if (localObject != null) {
      this.mSeqListLength = ((List)localObject).size();
    }
    if (this.mIsNotShowIndex)
    {
      this.mTextView.setVisibility(4);
    }
    else
    {
      this.mTextView.setVisibility(0);
      if (localBundle.getBoolean("is_index_show_bottom", false))
      {
        localObject = this.mTextView;
        if ((localObject != null) && ((((TextView)localObject).getParent() instanceof RelativeLayout)))
        {
          localObject = (RelativeLayout.LayoutParams)this.mTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).addRule(10);
          ((RelativeLayout.LayoutParams)localObject).addRule(12, 0);
          ((RelativeLayout.LayoutParams)localObject).setMargins(0, AIOUtils.b(20.0F, getResources()), 0, 0);
          this.mTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    this.isShowContentUrl = localBundle.getBoolean("is_show_content_url", false);
    this.isGridImageReport = localBundle.getBoolean("is_grid_image_report", false);
    if (this.isShowContentUrl) {
      handleShowContentUrl(localBundle);
    }
    if (this.mIsFromPhotoWall) {
      initGallery(localBundle);
    }
    ThreadManager.post(new TroopAvatarWallPreviewActivity.2(this, localBundle), 8, null, true);
    if (isSrcIdSupportRotate())
    {
      this.mRotationObserver = new TroopAvatarWallPreviewActivity.RotationObserver(this, new Handler());
      this.mRotationObserver.a();
      if (Settings.System.getInt(getContentResolver(), "accelerometer_rotation", -1) == 1) {
        setRequestedOrientation(4);
      }
    }
    configDtReportParam();
    if (localBundle.getBoolean("show_title_bar")) {
      initTitleBar(this.mIndex, this.mSeqListLength);
    }
    initSocialBottomBar(localBundle);
  }
  
  private void initFooterAnimation(boolean paramBoolean)
  {
    View localView = this.mBottomBar;
    if (localView != null)
    {
      if (paramBoolean)
      {
        this.mBottomLayoutTranslateDownAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, localView.getHeight());
        this.mBottomLayoutTranslateDownAnimation.setDuration(300L);
        this.mBottomLayoutTranslateDownAnimation.setAnimationListener(new TroopAvatarWallPreviewActivity.13(this));
        return;
      }
      this.mBottomLayoutTranslateUpAnimation = new TranslateAnimation(0.0F, 0.0F, localView.getHeight(), 0.0F);
      this.mBottomLayoutTranslateUpAnimation.setDuration(300L);
      this.mBottomLayoutTranslateUpAnimation.setAnimationListener(new TroopAvatarWallPreviewActivity.14(this));
    }
  }
  
  private void initSocialBottomBar(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    boolean bool = paramBundle.getBoolean("show_social_bottom_bar");
    Object localObject1 = paramBundle.getString("show_social_bottom_bar_data");
    if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      try
      {
        Object localObject2 = paramBundle.getString("acticle_info_rowkey", "");
        String str1 = paramBundle.getString("callback_seq", "");
        localObject1 = new JSONObject((String)localObject1);
        String str2 = ((JSONObject)localObject1).optString("commentNum", "0");
        String str3 = ((JSONObject)localObject1).optString("likeNum", "0");
        String str4 = ((JSONObject)localObject1).optString("shareNum", "0");
        bool = ((JSONObject)localObject1).optBoolean("liked", false);
        this.socialBottomBar = ((ViewStub)findViewById(2131446132)).inflate();
        localObject1 = this.socialBottomBar.findViewById(2131446133);
        View localView1 = this.socialBottomBar.findViewById(2131446135);
        View localView2 = this.socialBottomBar.findViewById(2131446138);
        TextView localTextView1 = (TextView)this.socialBottomBar.findViewById(2131446134);
        TextView localTextView2 = (TextView)this.socialBottomBar.findViewById(2131446137);
        ImageView localImageView = (ImageView)this.socialBottomBar.findViewById(2131446136);
        TextView localTextView3 = (TextView)this.socialBottomBar.findViewById(2131446139);
        localObject2 = new SocialBottomBarData((String)localObject2, str1, str2, str3, str4, bool);
        if (paramBundle.getBoolean("is_from_tool_process", false)) {
          paramBundle = new ToolPictureShowActionNotifier(getAppRuntime());
        } else {
          paramBundle = new MainPictureShowActionNotifier();
        }
        this.pictureShowViewModel = ((PictureShowViewModel)new ViewModelProvider(this, new PictureShowViewModelFactory((SocialBottomBarData)localObject2, paramBundle)).get(PictureShowViewModel.class));
        this.pictureShowViewModel.a().observe(this, new TroopAvatarWallPreviewActivity.4(this, localTextView1));
        this.pictureShowViewModel.b().observe(this, new TroopAvatarWallPreviewActivity.5(this, localTextView2));
        this.pictureShowViewModel.c().observe(this, new TroopAvatarWallPreviewActivity.6(this, localTextView3));
        this.pictureShowViewModel.d().observe(this, new TroopAvatarWallPreviewActivity.7(this, localImageView));
        paramBundle = new TroopAvatarWallPreviewActivity.8(this);
        ((View)localObject1).setOnClickListener(paramBundle);
        localView1.setOnClickListener(paramBundle);
        localView2.setOnClickListener(paramBundle);
        return;
      }
      catch (JSONException paramBundle)
      {
        QLog.e("TroopAvatarWallPreviewActivity", 2, paramBundle, new Object[0]);
      }
    }
  }
  
  private void initTitleBar(int paramInt1, int paramInt2)
  {
    int i = ImmersiveUtils.getStatusBarHeight(this);
    Object localObject = ((ViewStub)findViewById(2131447484)).inflate();
    ((RelativeLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = i;
    View localView = ((View)localObject).findViewById(2131447486);
    this.titleBarTitle = ((TextView)((View)localObject).findViewById(2131447495));
    localView.setOnClickListener(new TroopAvatarWallPreviewActivity.3(this));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1 + 1);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramInt2);
    localObject = ((StringBuilder)localObject).toString();
    this.titleBarTitle.setText((CharSequence)localObject);
  }
  
  private boolean isSrcIdSupportRotate()
  {
    return ("2".equals(this.mSrcId)) || ("4".equals(this.mSrcId));
  }
  
  private Bitmap makeAnimationRect(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, Drawable paramDrawable, boolean paramBoolean)
  {
    Object localObject = this.mThumbRect;
    if (localObject != null)
    {
      Rect localRect = (Rect)((ArrayList)localObject).get(this.mIndex);
      localObject = getThumbPath(paramBoolean);
      if (localObject != null)
      {
        if (localRect == null) {
          return null;
        }
        String str = getBigPath(paramBoolean);
        Drawable localDrawable;
        if (((String)localObject).equals(AvatarInfo.a)) {
          localDrawable = paramDrawable;
        } else {
          localDrawable = getDrawable(paramBoolean, (String)localObject);
        }
        if (localDrawable == null) {
          return null;
        }
        if ((paramDrawable == null) && ((!paramBoolean) || (localDrawable == null))) {
          return null;
        }
        int k = 1;
        localObject = paramDrawable;
        if (paramDrawable == null) {
          if (!TextUtils.isEmpty(str))
          {
            if (str.equals(AvatarInfo.a)) {
              return null;
            }
            localObject = getDrawable(paramBoolean, str);
            if (localObject == null) {
              return null;
            }
            ((URLDrawable)localObject).setAutoDownload(true);
          }
          else
          {
            return null;
          }
        }
        int n = this.mGallery.getWidth();
        int i1 = this.mGallery.getHeight();
        if (localDrawable.getIntrinsicWidth() == 0) {
          i = 1;
        } else {
          i = localDrawable.getIntrinsicWidth();
        }
        if (localDrawable.getIntrinsicHeight() == 0) {
          j = 1;
        } else {
          j = localDrawable.getIntrinsicHeight();
        }
        paramDrawable = com.tencent.common.galleryactivity.AnimationUtils.a(this.mGallery);
        if (paramDrawable != null) {
          localRect.offset(paramDrawable.left, -paramDrawable.top);
        }
        paramRect3.set(localRect);
        int m;
        if ((paramBoolean) && (((URLDrawable)localObject).getStatus() == 1))
        {
          if (((Drawable)localObject).getIntrinsicWidth() == 0) {
            m = 1;
          } else {
            m = ((Drawable)localObject).getIntrinsicWidth();
          }
          if (((Drawable)localObject).getIntrinsicHeight() != 0) {
            k = ((Drawable)localObject).getIntrinsicHeight();
          }
        }
        else
        {
          k = j;
          m = i;
        }
        float f = ImagePreviewAnimationUtil.a(m, k);
        paramRect1.set(ImagePreviewAnimationUtil.a(i, j, m, k));
        paramRect2.set(ImagePreviewAnimationUtil.b(m, k, n, i1));
        paramRect4.set(ImagePreviewAnimationUtil.c(m, k, n, i1));
        ImagePreviewAnimationUtil.a(paramRect1, f);
        ImagePreviewAnimationUtil.a(paramRect2, f);
        int i = (int)(m * f);
        int j = (int)(k * f);
        try
        {
          paramRect3 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
          paramRect4 = new Canvas(paramRect3);
          paramDrawable = new Rect(0, 0, m, k);
          ImagePreviewAnimationUtil.a(paramDrawable, f);
          ((Drawable)localObject).setBounds(paramDrawable);
          paramRect4.clipRect(ImagePreviewAnimationUtil.a(paramRect1, paramRect2));
          ((Drawable)localObject).draw(paramRect4);
          return paramRect3;
        }
        catch (Throwable paramRect1)
        {
          if (QLog.isColorLevel())
          {
            paramRect2 = new StringBuilder();
            paramRect2.append("makeAnimationRect ");
            paramRect2.append(paramRect1.getMessage());
            QLog.e("ImagePreveiew", 2, paramRect2.toString());
          }
        }
      }
    }
    return null;
  }
  
  private void onBottomBarSwitchClick()
  {
    if (this.mBottomBar.getVisibility() == 0)
    {
      ((ImageView)this.mBottomBarSwitch).setImageResource(2130850535);
      if (this.mBottomLayoutTranslateDownAnimation == null) {
        initFooterAnimation(true);
      }
      this.mBottomBar.startAnimation(this.mBottomLayoutTranslateDownAnimation);
      this.mIsBottomBarUp = false;
      return;
    }
    ((ImageView)this.mBottomBarSwitch).setImageResource(2130850536);
    if (this.mBottomLayoutTranslateUpAnimation == null) {
      initFooterAnimation(false);
    }
    this.mBottomBar.startAnimation(this.mBottomLayoutTranslateUpAnimation);
    this.mIsBottomBarUp = true;
  }
  
  private void onCommentClick()
  {
    Intent localIntent = new Intent("android.intent.action.WEBJSCALL");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{op:1,index:");
    localStringBuilder.append(this.mIndex);
    localStringBuilder.append("}");
    localIntent.putExtra("callback", localStringBuilder.toString());
    sendBroadcast(localIntent);
  }
  
  private void onDetailClick()
  {
    Intent localIntent = new Intent("android.intent.action.WEBJSCALL");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{op:3,index:");
    localStringBuilder.append(this.mIndex);
    localStringBuilder.append("}");
    localIntent.putExtra("callback", localStringBuilder.toString());
    sendBroadcast(localIntent);
  }
  
  private void onLikeClick()
  {
    Object localObject = this.mLikes;
    if (localObject != null)
    {
      int i = localObject.length;
      int j = this.mIndex;
      if (i <= j) {
        return;
      }
      if (localObject[j] == 0)
      {
        this.mLikeBtn.setImageResource(2130850541);
        localObject = android.view.animation.AnimationUtils.loadAnimation(this, 2130772430);
        this.mLikeBtn.startAnimation((Animation)localObject);
      }
      else
      {
        this.mLikeBtn.setImageResource(2130850544);
      }
      localObject = this.mLikes;
      i = this.mIndex;
      localObject[i] ^= 0x1;
      localObject = new Intent("android.intent.action.WEBJSCALL");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{op:2,index:");
      localStringBuilder.append(this.mIndex);
      localStringBuilder.append("}");
      ((Intent)localObject).putExtra("callback", localStringBuilder.toString());
      sendBroadcast((Intent)localObject);
    }
  }
  
  private void openFastWeb(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    TimeUtil.b("fast_web_show_light_house_1");
    ((IFastModule)QRoute.api(IFastModule.class)).getArticleContent(paramString, String.valueOf(paramAbsBaseArticleInfo.innerUniqueID), paramAbsBaseArticleInfo.mSubscribeID, 1, null);
    startWebFastActivity(paramAbsBaseArticleInfo, null);
  }
  
  private void reportGridImageScroll()
  {
    if (getIntent() != null)
    {
      if (getIntent().getExtras() == null) {
        return;
      }
      Object localObject = getIntent().getExtras();
      if (this.isGridImageReport)
      {
        String str1 = ((Bundle)localObject).getString("article_id", "");
        String str2 = ((Bundle)localObject).getString("to_uin", "");
        String str3 = ((Bundle)localObject).getString("feeds_id", "");
        String str4 = ((Bundle)localObject).getString("scroll_image_r5", "");
        String str5 = ((Bundle)localObject).getString("strategy_id", "");
        long l = ((Bundle)localObject).getLong("channel_id", 0L);
        if (((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).isKanDianSubscribe(l)) {
          localObject = "0X8009364";
        } else {
          localObject = "0X800888B";
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", str2, (String)localObject, (String)localObject, 0, 0, str3, str1, str5, str4, false);
        if (QLog.isColorLevel()) {
          QLog.d("TroopAvatarWallPreviewActivity", 2, new Object[] { "scroll Image report(in TroopAvatarWallPreviewActivity) toUin: ", str2, ", r2(feedsId): ", str3, ", r3(articleId): ", str1, " r4(imagePos): ", Integer.valueOf(this.mIndex + 1), ", r5: ", str4 });
        }
      }
    }
  }
  
  private void reportPhotoWallAction(String paramString1, String paramString2)
  {
    if (getIntent().getBooleanExtra("from_photo_wall", false))
    {
      if (getIntent().getBooleanExtra("delete_ability", false))
      {
        ReportController.b(this.app, "CliOper", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.app, "CliOper", "", "", paramString2, paramString2, 0, 0, "", "", "", "");
    }
  }
  
  private void reportReadArticleClick()
  {
    if (getIntent() != null)
    {
      if (getIntent().getExtras() == null) {
        return;
      }
      Object localObject = getIntent().getExtras();
      if (this.isGridImageReport)
      {
        String str1 = ((Bundle)localObject).getString("to_uin", "");
        String str2 = ((Bundle)localObject).getString("feeds_id", "");
        String str3 = ((Bundle)localObject).getString("article_id", "");
        String str4 = ((Bundle)localObject).getString("read_article_r5", "");
        String str5 = ((Bundle)localObject).getString("strategy_id", "");
        long l = ((Bundle)localObject).getLong("channel_id", 0L);
        if (((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).isKanDianSubscribe(l)) {
          localObject = "0X8009365";
        } else {
          localObject = "0X80088A8";
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", str1, (String)localObject, (String)localObject, 0, 0, str2, str3, str5, str4, false);
        if (QLog.isColorLevel()) {
          QLog.d("TroopAvatarWallPreviewActivity", 2, new Object[] { "readArticle click report(in TroopAvatarWallPreviewActivity) toUin: ", str1, ", r2(feedsId): ", str2, ", r3(articleId): ", str3, " r4(imagePos): ", Integer.valueOf(this.mIndex + 1), ", r5: ", str4 });
        }
      }
    }
  }
  
  private void savePhoto(URLDrawable paramURLDrawable, String paramString)
  {
    new TroopAvatarWallPreviewActivity.22(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void savePic(URLDrawable paramURLDrawable)
  {
    savePicWithPermission(paramURLDrawable);
  }
  
  private void savePicWithPermission(URLDrawable paramURLDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        requestPermissions(new TroopAvatarWallPreviewActivity.19(this, paramURLDrawable), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      savePicWithOverwrite(paramURLDrawable);
      return;
    }
    savePicWithOverwrite(paramURLDrawable);
  }
  
  private void setOriginButton(int paramInt)
  {
    ArrayList localArrayList = this.mOriginList;
    if ((localArrayList != null) && (paramInt < localArrayList.size()) && (!TextUtils.isEmpty((CharSequence)this.mOriginList.get(paramInt))) && (AbsDownloader.getFile((String)this.mOriginList.get(paramInt)) == null))
    {
      long l2 = -1L;
      localArrayList = this.mOriginSizeList;
      long l1 = l2;
      if (localArrayList != null)
      {
        l1 = l2;
        if (!TextUtils.isEmpty((CharSequence)localArrayList.get(paramInt))) {
          try
          {
            paramInt = Integer.parseInt((String)this.mOriginSizeList.get(paramInt));
            l1 = paramInt;
          }
          catch (Exception localException)
          {
            QLog.e("TroopAvatarWallPreviewActivity", 2, "setOriginButton exception", localException);
            l1 = l2;
          }
        }
      }
      if (l1 > 0L) {
        this.mOriginPicBtn.setText(String.format(Locale.CHINA, getResources().getString(2131892727), new Object[] { FileUtil.a(l1) }));
      } else {
        this.mOriginPicBtn.setText(2131892724);
      }
      this.mOriginPicBtn.setVisibility(0);
      LpReportInfo_pf00064.allReport(301, 34, 1);
      return;
    }
    this.mOriginPicBtn.setVisibility(8);
  }
  
  private void showActionSheet()
  {
    Object localObject = this.mGallery;
    if (localObject == null)
    {
      QQToast.makeText(this, getString(2131890214), 0).show();
      return;
    }
    localObject = ((Gallery)localObject).getSelectedView();
    if (localObject == null)
    {
      QQToast.makeText(this, getString(2131890214), 0).show();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131435357)).getDrawable();
    ActionSheet localActionSheet;
    if ((localObject != null) && ((localObject instanceof URLDrawable)))
    {
      localObject = (URLDrawable)localObject;
      if (((URLDrawable)localObject).getStatus() != 1)
      {
        QQToast.makeText(this, getString(2131890214), 0).show();
        return;
      }
      if ("5".equals(this.mSrcId))
      {
        showNearbyActionSheet((URLDrawable)localObject);
        return;
      }
      localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
      if (this.mIsShowAction)
      {
        localActionSheet.addButton(2131890804, 1);
        localActionSheet.addButton(2131890810, 1);
        if (!getIntent().getBooleanExtra("from_photo_wall", false)) {
          ThreadManagerV2.excute(new TroopAvatarWallPreviewActivity.16(this, (URLDrawable)localObject, localActionSheet), 128, null, false);
        }
      }
      if ((this.mDeleteAbility) && (canDelete(this.mIndex))) {
        localActionSheet.addButton(2131890801, 1);
      }
      if (this.mIsEdit)
      {
        localActionSheet.addButton(2131895534, 5);
        localActionSheet.addButton(2131890801, 3);
      }
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new TroopAvatarWallPreviewActivity.17(this, localActionSheet, (URLDrawable)localObject));
    }
    try
    {
      localActionSheet.show();
      return;
    }
    catch (Exception localException) {}
    QQToast.makeText(this, getString(2131890214), 0).show();
    return;
  }
  
  private void showToast(String paramString)
  {
    QQToast.makeText(BaseApplication.getContext(), paramString, 0).show(getTitleBarHeight());
  }
  
  private void showWaitingDialog(String paramString)
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
  
  private void startChatAndSendMsg(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    if ((!this.mPublicAccountShowPictureReport.isReport) && (!"2".equals(this.mSrcId)) && (!"6".equals(this.mSrcId)) && (!"4".equals(this.mSrcId))) {
      startActivity(localIntent);
    } else {
      ForwardUtils.a(this.app, this, this, localIntent, null);
    }
    finish();
  }
  
  private void startWebFastActivity(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).startWebFastActivity(this, paramAbsBaseArticleInfo);
  }
  
  private void updateOperateBar(int paramInt)
  {
    Object localObject1 = this.mDescs;
    Object localObject2;
    if ((localObject1 != null) && (paramInt < ((ArrayList)localObject1).size()))
    {
      localObject1 = (String)this.mDescs.get(paramInt);
      this.mPhotoDesc.setText(QzoneContactsFeedUtils.a((String)localObject1, this.app));
      localObject2 = this.mPhotoDesc;
      int i;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        i = 8;
      } else {
        i = 0;
      }
      ((TextView)localObject2).setVisibility(i);
    }
    else
    {
      this.mPhotoDesc.setVisibility(8);
    }
    localObject1 = this.mLikes;
    if (localObject1 != null)
    {
      if (localObject1.length <= paramInt) {
        return;
      }
      localObject2 = this.mLikeBtn;
      if (localObject1[paramInt] != 0) {
        paramInt = 2130850541;
      } else {
        paramInt = 2130850544;
      }
      ((ImageView)localObject2).setImageResource(paramInt);
      this.mIsBottomBarUp = LocalMultiProcConfig.getBool("BasePictureViewController#mIsBottomBarUp", true);
      if (this.mIsBottomBarUp)
      {
        if (!TextUtils.isEmpty(this.mPhotoDesc.getText())) {
          this.mPhotoDesc.setVisibility(0);
        }
        this.mBottomBar.setVisibility(0);
        ((ImageView)this.mBottomBarSwitch).setImageResource(2130850536);
        return;
      }
      this.mPhotoDesc.setVisibility(8);
      this.mBottomBar.setVisibility(8);
      ((ImageView)this.mBottomBarSwitch).setImageResource(2130850535);
    }
  }
  
  void back()
  {
    this.mPublicAccountShowPictureReport.leave_mode = 1;
    if (!this.animated)
    {
      Gallery localGallery = this.mGallery;
      if ((localGallery != null) && (!localGallery.resetScale(false))) {
        if ((this.mThumbRect != null) && (this.mGallery.getSelectedItemId() == this.mIndex))
        {
          if (!applyExitAnimation()) {
            scaleExit();
          }
        }
        else {
          scaleExit();
        }
      }
    }
  }
  
  boolean canDelete(int paramInt)
  {
    Object localObject = this.mPhotoIds;
    if ((localObject != null) && (paramInt <= ((ArrayList)localObject).size() - 1))
    {
      localObject = this.mExtras;
      if ((localObject != null) && (((Bundle)localObject).getBoolean("from_personality_label", false))) {
        return true;
      }
    }
    localObject = this.mExtras;
    if ((localObject != null) && (((Bundle)localObject).getBoolean("from_extend_Friend_edit", false))) {
      return true;
    }
    localObject = this.mPhotoIds;
    if ((localObject != null) && (this.mPhotoTimes != null) && (paramInt <= ((ArrayList)localObject).size() - 1))
    {
      if (paramInt > this.mPhotoTimes.size() - 1) {
        return false;
      }
      return !TextUtils.isEmpty((String)this.mPhotoIds.get(paramInt));
    }
    return false;
  }
  
  void deletePhotoWall(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.mAdapter.getCount() - 1)) {
      return;
    }
    ArrayList localArrayList = this.mPhotoIds;
    if ((localArrayList != null) && (this.mPhotoTimes != null) && (paramInt <= localArrayList.size() - 1))
    {
      if (paramInt > this.mPhotoTimes.size() - 1) {
        return;
      }
      DialogUtil.a(this, 230).setTitle(getString(2131892872)).setPositiveButton(getString(2131892267), new TroopAvatarWallPreviewActivity.24(this, paramInt)).setNegativeButton(getString(2131887648), new TroopAvatarWallPreviewActivity.23(this)).show();
      reportPhotoWallAction("0X8006A83", "");
    }
  }
  
  void deletePic(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.mAdapter.getCount() - 1)) {
      return;
    }
    if ((this.mAdapter.getCount() == 2) && (this.mAdapter.a(0) != null) && (this.mAdapter.a(0).equals(AvatarInfo.a)))
    {
      back();
      return;
    }
    if (this.mAdapter.getCount() > 1)
    {
      if (this.mDelList == null) {
        this.mDelList = new ArrayList();
      }
      List localList = this.mDelList;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt);
      localList.add(localStringBuilder.toString());
      if (this.mDelList != null)
      {
        getIntent().putStringArrayListExtra("del_list", (ArrayList)this.mDelList);
        setResult(-1, getIntent());
      }
      finish();
      return;
    }
    QQToast.makeText(this, getString(2131893837), 1).show(getTitleBarHeight());
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle arg1)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(???);
    synchronized (sLock)
    {
      if (mIsOpen)
      {
        super.finish();
        return false;
      }
      mIsOpen = true;
      if ((this.app != null) && (!TextUtils.isEmpty(this.app.getAccount()))) {
        try
        {
          setContentView(2131625166);
          ThreadManager.post(new TroopAvatarWallPreviewActivity.1(this), 8, null, true);
          return true;
        }
        catch (IllegalStateException ???)
        {
          QLog.e("TroopAvatarWallPreviewActivity", 1, "setContentView IllegalStateException", ???);
          return false;
        }
      }
      finish();
      return false;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.mNeedBottomBar)
    {
      LocalMultiProcConfig.putBool("BasePictureViewController#mIsBottomBarUp", this.mIsBottomBarUp);
      unregisterReceiver(this.mReceiver);
    }
    if (this.mPublicAccountShowPictureReport.isReport)
    {
      this.mPublicAccountShowPictureReport.showEnd();
      this.mPublicAccountShowPictureReport.report(this.app);
    }
    Object localObject = this.mGallery;
    if (localObject != null)
    {
      Runnable localRunnable = this.setAnimateFlagRunnable;
      if (localRunnable != null) {
        ((Gallery)localObject).removeCallbacks(localRunnable);
      }
    }
    localObject = this.mRotationObserver;
    if (localObject != null) {
      ((TroopAvatarWallPreviewActivity.RotationObserver)localObject).b();
    }
    localObject = this.pictureShowViewModel;
    if (localObject != null) {
      ((PictureShowViewModel)localObject).h();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.finish();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  void forward(URLDrawable paramURLDrawable, String paramString)
  {
    if (this.mSrcId != null) {
      ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_share", 0, 0, this.mSrcId, "", "", "");
    }
    new TroopAvatarWallPreviewActivity.ForwardAsyncTask(this, this.mTroopUin, this.isFromPlugin, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  public String getBigPath(boolean paramBoolean)
  {
    if (this.mIndex >= this.mSeqNumList.size())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("picIndex");
        ((StringBuilder)localObject).append(this.mIndex);
        ((StringBuilder)localObject).append(",mSeqNumList.size()");
        ((StringBuilder)localObject).append(this.mSeqNumList.size());
        QLog.d("TroopAvatarWallPreviewActivity", 2, ((StringBuilder)localObject).toString());
      }
      return null;
    }
    Object localObject = (String)this.mSeqNumList.get(this.mIndex);
    if (paramBoolean)
    {
      if ((localObject != null) && (((String)localObject).equals(AvatarInfo.a))) {
        return AvatarInfo.a;
      }
      ITroopAvatarUtilApi localITroopAvatarUtilApi = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
      return localITroopAvatarUtilApi.getArtWork(localITroopAvatarUtilApi.getAvatarAddress((String)localObject, this.mTroopUin, 1));
    }
    return localObject;
  }
  
  Drawable getDrawable(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      paramString = URLDrawable.getDrawable(NearbyImgDownloader.convertURL(paramString));
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      BitmapFactory.Options localOptions;
      return null;
    }
    localOptions = ImageUtil.a(paramString, 100);
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return new BitmapDrawable(paramString);
    }
    catch (OutOfMemoryError paramString)
    {
      label36:
      break label36;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAvatarWallPreviewActivity", 2, "getDrawable out off memory");
    }
    System.gc();
    return null;
  }
  
  public String getThumbPath(boolean paramBoolean)
  {
    if (this.mIndex >= this.mSeqNumList.size())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("picIndex");
        ((StringBuilder)localObject).append(this.mIndex);
        ((StringBuilder)localObject).append(",mSeqNumList.size()");
        ((StringBuilder)localObject).append(this.mSeqNumList.size());
        QLog.d("TroopAvatarWallPreviewActivity", 2, ((StringBuilder)localObject).toString());
      }
      return null;
    }
    Object localObject = (String)this.mSeqNumList.get(this.mIndex);
    if (paramBoolean)
    {
      if ((localObject != null) && (((String)localObject).equals(AvatarInfo.a))) {
        return AvatarInfo.a;
      }
      ITroopAvatarUtilApi localITroopAvatarUtilApi = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
      return localITroopAvatarUtilApi.getThumbPhoto(localITroopAvatarUtilApi.getAvatarAddress((String)localObject, this.mTroopUin, 1));
    }
    return localObject;
  }
  
  void initGallery(Bundle paramBundle)
  {
    this.mAdapter.a(this.mSrcId);
    this.mAdapter.a(this.mSeqNumList);
    this.mAdapter.a(this.mIsFromPhotoWall);
    ArrayList localArrayList = this.mPreviewPhotoLocation;
    if (localArrayList != null) {
      this.mAdapter.a(localArrayList);
    }
    this.mAdapter.notifyDataSetChanged();
    localArrayList = this.mOriginList;
    if (localArrayList != null) {
      this.mAdapter.b(localArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAvatarWallPreviewActivity", 2, " [updateAdapter] 传入链接");
    }
    this.mAdapter.b(paramBundle.getBoolean("from_photo_wall", false) ^ true);
    this.mAdapter.c(paramBundle.getBoolean("is_use_path", false));
    this.mIndex = paramBundle.getInt("index", -1);
    this.mGallery.setAdapter(this.mAdapter);
    if (QLog.isColorLevel()) {
      QLog.d("TroopAvatarWallPreviewActivity", 2, " [updateAdapter] 传入adapter");
    }
    this.mGallery.setSpacing(getResources().getDimensionPixelSize(2131297535));
    this.mGallery.setSelection(this.mIndex);
    this.mGallery.setOnItemClickListener(new TroopAvatarWallPreviewActivity.9(this));
    this.mGallery.setOnItemSelectedListener(new TroopAvatarWallPreviewActivity.10(this));
    this.mGallery.setOnItemLongClickListener(new TroopAvatarWallPreviewActivity.11(this));
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21) && (this.isNeedToAio)) {
      startChatAndSendMsg(paramIntent.getExtras());
    }
    if ((paramInt1 == 10922) && (paramInt2 == -10069))
    {
      paramIntent = getIntent().getExtras().getString("article_url", "");
      ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).jumpTo(getActivity(), paramIntent);
      if (this.isGridImageReport) {
        reportReadArticleClick();
      }
    }
  }
  
  public void onBackPressed()
  {
    back();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    synchronized (sLock)
    {
      mIsOpen = false;
      removeObserver(this.mPersonalityLabelObserver);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((82 == paramKeyEvent.getKeyCode()) && (this.mIsShowMenu))
    {
      showActionSheet();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), false);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  void onQRDecodeSucceed(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("fromPicQRDecode", true);
    localIntent.putExtra("report_params", ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, paramString2, null, null, null, 7));
    RouteUtils.a(this, localIntent, "/qrscan/scanner");
  }
  
  protected void onResume()
  {
    super.onResume();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), true);
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
  }
  
  void savePicWithOverwrite(URLDrawable paramURLDrawable)
  {
    if (this.mSrcId != null) {
      ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_save", 0, 0, this.mSrcId, "", "", "");
    }
    if (paramURLDrawable.getStatus() != 1) {
      return;
    }
    new File(AppConstants.SDCARD_IMG_SAVE).mkdirs();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_IMG_SAVE);
    ((StringBuilder)localObject1).append(this.mTroopUin);
    ((StringBuilder)localObject1).append(Utils.Crc64String(paramURLDrawable.getURL().toString()));
    localObject1 = ((StringBuilder)localObject1).toString();
    if (((String)localObject1).indexOf(".") == -1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(".gif");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = localObject1;
    }
    if (((String)localObject1).indexOf(".") == -1)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(".jpg");
      localObject3 = ((StringBuilder)localObject3).toString();
    }
    else
    {
      localObject3 = localObject1;
    }
    Object localObject2 = new File((String)localObject2);
    Object localObject3 = new File((String)localObject3);
    if ((!((File)localObject2).exists()) && (!((File)localObject3).exists())) {
      savePhoto(paramURLDrawable, (String)localObject1);
    } else {
      DialogUtil.a(this, 230).setTitle(getString(2131915885)).setMessage(getString(2131892633)).setPositiveButton(getString(2131915687), new TroopAvatarWallPreviewActivity.21(this, paramURLDrawable, (String)localObject1)).setNegativeButton(getString(2131892140), new TroopAvatarWallPreviewActivity.20(this)).show();
    }
    reportPhotoWallAction("0X8006A82", "0X8006A96");
  }
  
  public void scaleExit()
  {
    Object localObject = this.mPreviewPhotoLocation;
    int j = 0;
    int i;
    int k;
    int m;
    if (localObject != null)
    {
      j = ((Integer)((ArrayList)localObject).get(0)).intValue();
      i = ((Integer)this.mPreviewPhotoLocation.get(1)).intValue();
      k = ((Integer)this.mPreviewPhotoLocation.get(2)).intValue();
      m = ((Integer)this.mPreviewPhotoLocation.get(3)).intValue();
    }
    else
    {
      i = 0;
      k = 0;
      m = 0;
    }
    this.mTextView.setVisibility(4);
    this.mDelbtn.setVisibility(4);
    this.mMenuBtn.setVisibility(4);
    localObject = this.socialBottomBar;
    if (localObject != null) {
      ((View)localObject).setVisibility(4);
    }
    this.animated = true;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    if (this.mIsFromPhotoWall)
    {
      float f = j;
      localObject = new ScaleAnimation(1.0F, 0.2F, 1.0F, 0.2F, 0, k / 2.0F + f, 0, i + m / 2.0F);
      ((ScaleAnimation)localObject).setDuration(400L);
      localAlphaAnimation.setDuration(400L);
    }
    else
    {
      localObject = new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject).setDuration(500L);
    }
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    if (!"5".equals(this.mSrcId)) {
      localAnimationSet.addAnimation((Animation)localObject);
    }
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new TroopAvatarWallPreviewActivity.29(this));
    if (this.setAnimateFlagRunnable == null) {
      this.setAnimateFlagRunnable = new TroopAvatarWallPreviewActivity.30(this);
    }
    this.mGallery.postDelayed(this.setAnimateFlagRunnable, 500L);
    if (this.mIsFromPhotoWall) {
      this.mGallery.animate().translationX(j).translationY(i);
    }
    this.mGallery.startAnimation(localAnimationSet);
    this.mBgView.startAnimation(localAlphaAnimation);
    if (this.isShowContentUrl)
    {
      localObject = this.mContentUrlLayout;
      if (localObject != null) {
        ((View)localObject).setVisibility(4);
      }
    }
  }
  
  void setDefaultAvatar(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.mAdapter.getCount() - 1)) {
      return;
    }
    getIntent().putExtra("default_avator_index", paramInt);
    setResult(-1, getIntent());
    finish();
  }
  
  protected void showNearbyActionSheet(URLDrawable paramURLDrawable)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showNearbyActionSheet: extra=");
      ((StringBuilder)localObject1).append(this.mExtrasStr);
      QLog.d("TroopAvatarWallPreviewActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if (TextUtils.isEmpty(this.mExtrasStr)) {
      return;
    }
    try
    {
      Object localObject2 = new JSONObject(this.mExtrasStr);
      ((JSONObject)localObject2).optString("feedId");
      localObject1 = ((JSONObject)localObject2).optString("tinyId");
      ((JSONObject)localObject2).optString("reason");
      localObject2 = ((JSONObject)localObject2).optString("uin");
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
      localActionSheet.addButton(2131890810, 1);
      if (!this.app.getCurrentAccountUin().equals(localObject2)) {
        localActionSheet.addButton(HardCodeUtil.a(2131912485), 0);
      }
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new TroopAvatarWallPreviewActivity.18(this, localActionSheet, paramURLDrawable, (String)localObject1, (String)localObject2));
      localActionSheet.show();
      return;
    }
    catch (Exception paramURLDrawable)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopAvatarWallPreviewActivity", 2, "showNearbyActionSheet err:", paramURLDrawable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity
 * JD-Core Version:    0.7.0.1
 */