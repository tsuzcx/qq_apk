package com.tencent.mobileqq.nearby.guide;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationNearby;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.nearby.NearbyFakeActivityUtils;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyProcessMonitor;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.MonitorSizeChangeRelativeLayout;
import com.tencent.mobileqq.widget.MonitorSizeChangeRelativeLayout.ICallback;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.PhotoInfo;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;

@RoutePage(desc="附近引导页面", path="/nearby/guide")
public class NearbyGuideActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, Animation.AnimationListener, TextView.OnEditorActionListener, FaceDrawable.OnLoadingStateChangeListener, MonitorSizeChangeRelativeLayout.ICallback
{
  static final int ANIM_TIME = 400;
  static final int MODE_GUIDE = 2;
  static final int MODE_HELLO = 1;
  static final int MSG_ANIM_END = 4;
  static final int MSG_FADEOUT_END = 6;
  static final int MSG_QUERY_IMPORT_STATUS = 1;
  static final int MSG_TIP_ANIM = 5;
  static final int MSG_UPDATE_AVATAR = 2;
  public static final String PARAM_FROM_WHERE = "FROM_WHERE";
  public static final String PARAM_IS_HAS_REDTOUCH = "IS_HAS_REDTOUCH";
  public static final String PARAM_RANK_BANNER_PUSH = "RANK_BANNER_PUSH";
  public static final String PARAM_SHOW_EDIT_TIP = "SHOW_EDIT_TIP";
  public static final String TAG = "NearbyGuideActivity";
  int mAnimFlag = 0;
  boolean mAnimating = false;
  String mAvatarPhotoPath;
  Button mBtnFinish;
  INearbyCardHandler mCardHandler;
  NearbyCardObserver mCardObserver = new NearbyGuideActivity.3(this);
  Button mClaimOk;
  View mClaimerLayout;
  int mCurMode = 0;
  Animation mEditFadeIn;
  View mEditLine;
  Animation mEditLineTrans;
  EditText mEtNikeName;
  Animation mFadeIn;
  Animation mFadeOut;
  boolean mFirst = true;
  Intent mGetIntent;
  ScrollView mGuideLayout;
  boolean mHasImportQzonePhotoEver = false;
  boolean mHasShowHello = false;
  View mHeadLine;
  Animation mHeadLineTrans;
  CustomImgView mImgvAvatar;
  ImageView mImgvCamera;
  boolean mIsUseImportAvatar = false;
  NearbyCardObserver mNearbyCardObserver = new NearbyGuideActivity.2(this);
  String mNikeName;
  TransProcessorHandler mPicUploadHandler = new NearbyGuideActivity.1(this);
  QQProgressDialog mProgressDialog;
  Dialog mPromptDialog = null;
  MonitorSizeChangeRelativeLayout mRootView;
  TextView mTips;
  int mTitleBarHeight;
  TextView mTxvImport;
  Handler mUiHandler;
  ArrayList<Integer> mUploadPhotoIds = new ArrayList();
  
  public void afterTextChanged(Editable paramEditable)
  {
    NearbyUtils.a(this.mEtNikeName, 36);
    updateFinishBtnStatus();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  void clearImportedQZonePhotoList()
  {
    this.mCardHandler.a(new ArrayList());
  }
  
  void dismissProcessDialog()
  {
    QQProgressDialog localQQProgressDialog = this.mProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.mProgressDialog.dismiss();
    }
  }
  
  void doClickReport(String paramString)
  {
    ThreadManager.post(new NearbyGuideActivity.11(this, paramString), 5, null, true);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 10) {
      return;
    }
    if (paramInt2 == -1)
    {
      if (paramIntent == null) {
        return;
      }
      Object localObject = paramIntent.getStringExtra("key_cover_selected_img_path");
      if (StringUtil.a((String)localObject)) {
        return;
      }
      paramIntent = new Intent(this, PhotoCropActivity.class);
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", getClass().getName());
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
      paramIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
      paramIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
      ((StringBuilder)localObject).append("nearby_people_photo/");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(".jpg");
      paramIntent.putExtra("PhotoConst.TARGET_PATH", localStringBuilder.toString());
      paramIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
      paramIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
      paramIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
      paramIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
      paramIntent.putExtra("PhotoConst.QZONE_COVER_CROP_LEFT_TITLE", HardCodeUtil.a(2131707224));
      startActivity(paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    if (this.mIsUseImportAvatar) {
      clearImportedQZonePhotoList();
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    setContentView(2131561185);
    initViews();
    getWindow().setBackgroundDrawable(null);
    try
    {
      ReportController.b(null, "dc00899", "grp_lbs", "", "entry", "open_nearby_guide_act_tmp", 0, 0, Build.MODEL, Build.VERSION.SDK, "", "");
      return bool;
    }
    catch (Exception paramBundle) {}
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.mNearbyCardObserver);
    removeObserver(this.mCardObserver);
    removePicUploadHandler();
    Handler localHandler = this.mUiHandler;
    if ((localHandler != null) && (localHandler.hasMessages(1))) {
      this.mUiHandler.removeMessages(1);
    }
    updateAvatar(null);
    ((INearbyProcessMonitor)QRoute.api(INearbyProcessMonitor.class)).reportSessionEnd(2);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent == null) {
      return;
    }
    this.mAvatarPhotoPath = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("doOnNewIntent path is: ");
      paramIntent.append(this.mAvatarPhotoPath);
      QLog.e("NearbyGuideActivity", 2, paramIntent.toString());
    }
    if (!TextUtils.isEmpty(this.mAvatarPhotoPath))
    {
      updateAvatar(true, this.mAvatarPhotoPath);
      if (this.mIsUseImportAvatar)
      {
        clearImportedQZonePhotoList();
        this.mIsUseImportAvatar = false;
      }
      if (this.mUploadPhotoIds.isEmpty()) {
        this.mUploadPhotoIds.add(Integer.valueOf(-1));
      } else {
        this.mUploadPhotoIds.set(0, Integer.valueOf(-1));
      }
    }
    updateFinishBtnStatus();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.mFirst))
    {
      this.mFirst = false;
      ((INearbyProcessMonitor)QRoute.api(INearbyProcessMonitor.class)).startNearbyProcess(this.app.getAccount(), 2);
    }
  }
  
  TopGestureLayout getGestureLayout()
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    Object localObject = localViewGroup;
    if (localView != null)
    {
      localObject = localViewGroup;
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
    }
    localObject = ((ViewGroup)localObject).getChildAt(0);
    if ((localObject instanceof TopGestureLayout)) {
      return (TopGestureLayout)localObject;
    }
    return null;
  }
  
  void gotoNearbyBaseActivity(boolean paramBoolean)
  {
    ((INearbyProcessMonitor)QRoute.api(INearbyProcessMonitor.class)).reportSessionHit(2);
    Intent localIntent = new Intent(this, NearbyActivity.class);
    localIntent.putExtra("ENTER_TIME", System.currentTimeMillis());
    localIntent.putExtra("FROM_WHERE", getIntent().getIntExtra("FROM_WHERE", -1));
    localIntent.putExtra("SHOW_EDIT_TIP", paramBoolean);
    localIntent.putExtra("IS_HAS_REDTOUCH", this.mGetIntent.getBooleanExtra("IS_HAS_REDTOUCH", false));
    localIntent.putExtra("RANK_BANNER_PUSH", this.mGetIntent.getStringExtra("RANK_BANNER_PUSH"));
    startActivity(localIntent);
    overridePendingTransition(17432576, 17432577);
    finish();
  }
  
  void gotoPhotoListActivity()
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this, "/base/album/photolist");
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", getClass().getName());
    localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", getPackageName());
    localActivityURIRequest.extra().putInt("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_MODE", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localActivityURIRequest.extra().putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("nearby_people_photo/");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".jpg");
    localObject = localStringBuilder.toString();
    localActivityURIRequest.extra().putString("PhotoConst.TARGET_PATH", (String)localObject);
    localActivityURIRequest.extra().putInt("PhotoConst.CLIP_WIDTH", 640);
    localActivityURIRequest.extra().putInt("PhotoConst.CLIP_HEIGHT", 640);
    localActivityURIRequest.extra().putInt("PhotoConst.TARGET_WIDTH", 640);
    localActivityURIRequest.extra().putInt("PhotoConst.TARGET_HEIGHT", 640);
    localActivityURIRequest.extra().putInt("enter_from", 30);
    localActivityURIRequest.extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationNearby.a);
    QRoute.startUri(localActivityURIRequest);
    AlbumUtil.anim(this, false, true);
  }
  
  void gotoQZoneAlbumActivity()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = this.app.getCurrentAccountUin();
    localUserInfo.nickname = this.app.getCurrentNickname();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_title", getString(2131717454));
    localBundle.putInt("key_personal_album_enter_model", 2);
    localBundle.putBoolean("show_album", false);
    localBundle.putBoolean("key_need_change_to_jpg", true);
    QZoneHelper.forwardToPersonalAlbumSelect(this, localUserInfo, localBundle, 10);
  }
  
  void handleImportQzonePhotoList(boolean paramBoolean, int paramInt, ArrayList<UpdatePhotoList.HeadInfo> paramArrayList)
  {
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleImportQZonePhotoList ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" ");
      if (paramArrayList == null) {
        i = -1;
      } else {
        i = paramArrayList.size();
      }
      ((StringBuilder)localObject).append(i);
      QLog.i("NearbyGuideActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean) && ((paramInt == 0) || (paramInt == 1)))
    {
      if (paramInt == 0)
      {
        if (paramArrayList == null) {
          paramInt = 0;
        } else {
          paramInt = paramArrayList.size();
        }
        ArrayList localArrayList = new ArrayList();
        i = 0;
        while (i < paramInt)
        {
          localObject = (UpdatePhotoList.HeadInfo)paramArrayList.get(i);
          if ((localObject != null) && (((UpdatePhotoList.HeadInfo)localObject).uint32_headid.has()) && (((UpdatePhotoList.HeadInfo)localObject).uint32_headid.get() >= 0))
          {
            localArrayList.add(Integer.valueOf(((UpdatePhotoList.HeadInfo)localObject).uint32_headid.get()));
            if (i == 0)
            {
              if (((UpdatePhotoList.HeadInfo)localObject).str_headurl.has()) {
                localObject = ((UpdatePhotoList.HeadInfo)localObject).str_headurl.get();
              } else {
                localObject = "";
              }
              this.mAvatarPhotoPath = ((String)localObject);
            }
          }
          i += 1;
        }
        dismissProcessDialog();
        if (localArrayList.size() <= 0)
        {
          showToast(HardCodeUtil.a(2131707215));
          return;
        }
        this.mUploadPhotoIds.clear();
        this.mUploadPhotoIds.addAll(localArrayList);
        showToast(2, HardCodeUtil.a(2131707213));
        updateAvatar(false, null);
        paramArrayList = this.app.getCurrentNickname();
        this.mEtNikeName.setText(paramArrayList);
        if (paramArrayList.length() > 0) {
          this.mEtNikeName.setSelection(paramArrayList.length());
        }
        this.mIsUseImportAvatar = true;
        this.mHasImportQzonePhotoEver = true;
        updateFinishBtnStatus();
        return;
      }
      if (paramInt == 1)
      {
        this.mUiHandler.removeMessages(1);
        this.mUiHandler.sendEmptyMessageDelayed(1, 2000L);
      }
    }
    else
    {
      dismissProcessDialog();
      showToast(HardCodeUtil.a(2131707211));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i != 5)
          {
            if (i != 6) {
              return false;
            }
            if (QLog.isDevelopLevel()) {
              NearbyUtils.a("NearbyGuideActivity", "MSG_FADEOUT_END", new Object[] { Integer.valueOf(this.mCurMode), Integer.valueOf(this.mRootView.getChildCount()) });
            }
            paramMessage = null;
            i = this.mCurMode;
            if (i == 1) {
              paramMessage = this.mGuideLayout;
            } else if (i == 2) {
              paramMessage = this.mClaimerLayout;
            }
            i = 0;
            while ((paramMessage != null) && (i < this.mRootView.getChildCount()))
            {
              if (this.mRootView.getChildAt(i) == paramMessage)
              {
                if (QLog.isDevelopLevel()) {
                  NearbyUtils.a("NearbyGuideActivity", "MSG_FADEOUT_END", new Object[] { "find child index", Integer.valueOf(i) });
                }
                this.mRootView.removeViewAt(i);
                return false;
              }
              i += 1;
            }
          }
          if (QLog.isDevelopLevel()) {
            NearbyUtils.a("NearbyGuideActivity", "MSG_TIP_ANIM", new Object[] { this.mTips });
          }
          if (this.mTips != null)
          {
            paramMessage = new TranslateAnimation(0.0F, 0.0F, 0.0F, -25.0F);
            paramMessage.setInterpolator(new CycleInterpolator(2.0F));
            paramMessage.setFillAfter(false);
            paramMessage.setDuration(1300L);
            this.mTips.startAnimation(paramMessage);
            return false;
          }
        }
        else
        {
          this.mAnimating = false;
          this.mUiHandler.removeMessages(4);
          this.mHeadLine.clearAnimation();
          this.mEditLine.clearAnimation();
          this.mEtNikeName.clearAnimation();
          i = (int)(this.mDensity * 15.0F + 0.5F);
          int j = (int)(this.mDensity * 15.0F + 0.5F);
          this.mHeadLine.setPadding(0, i, 0, j);
          i = (int)(this.mDensity * 5.0F + 0.5F);
          j = (int)(this.mDensity * 5.0F + 0.5F);
          this.mEditLine.setPadding(0, i, 0, j);
          this.mBtnFinish.setText(2131695129);
          this.mBtnFinish.setContentDescription(getString(2131695129));
          updateFinishBtnStatus();
          if (QLog.isDevelopLevel())
          {
            NearbyUtils.a("NearbyGuideActivity", "MSG_ANIM_END", new Object[] { Integer.valueOf(this.mAnimFlag), Integer.valueOf(paramMessage.arg1) });
            return false;
          }
        }
      }
      else
      {
        this.mUiHandler.removeMessages(2);
        if ((paramMessage.obj instanceof Bitmap)) {
          updateAvatar(new BitmapDrawable(getResources(), (Bitmap)paramMessage.obj));
        }
        showEditLine();
        return false;
      }
    }
    else
    {
      if (this.mCardHandler == null) {
        this.mCardHandler = ((INearbyCardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER));
      }
      this.mCardHandler.a();
    }
    return false;
  }
  
  void importFromQQ()
  {
    InputMethodUtil.b(this.mEtNikeName);
    if (this.mIsUseImportAvatar)
    {
      showToast(2, HardCodeUtil.a(2131707206));
      this.mEtNikeName.setText(this.app.getCurrentNickname());
      updateFinishBtnStatus();
      return;
    }
    if (!NetworkUtil.isNetSupport(this.app.getApp()))
    {
      showToast(HardCodeUtil.a(2131707217));
      return;
    }
    showPromptDialog();
  }
  
  void initData()
  {
    this.mTitleBarHeight = getTitleBarHeight();
    this.mGetIntent = getIntent();
    if (getIntent() == null)
    {
      ((INearbyProcessMonitor)QRoute.api(INearbyProcessMonitor.class)).reportSessionHit(2);
      NearbyFakeActivityUtils.a(this, new Intent(this, NearbyActivity.class));
      finish();
    }
    this.mUiHandler = new Handler(Looper.getMainLooper(), this);
    if (!((Boolean)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.app.getAccount(), "nearby_people_disclaimer_ok_5.8.0", Boolean.valueOf(false))).booleanValue()) {
      showClaimerLayout(0L);
    } else {
      showGuideLayout(0L);
    }
    this.mPicUploadHandler.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).addHandle(this.mPicUploadHandler);
  }
  
  void initTitle()
  {
    int i = getResources().getColor(2131166454);
    if (this.mTitleContainer == null) {
      this.mTitleContainer = findViewById(2131376636);
    }
    this.mTitleContainer.setBackgroundColor(i);
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.setStatusColor(i);
    }
    if ((this.centerView instanceof TextView)) {
      this.centerView.setTextColor(-1);
    }
    if ((this.leftView instanceof TextView))
    {
      this.leftView.setTextColor(-1);
      this.leftView.setBackgroundResource(2130845719);
      this.leftView.setOnClickListener(this);
    }
    if (this.mCurMode == 1)
    {
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setVisibility(8);
      setTitle(HardCodeUtil.a(2131707220));
      if ((this.leftView instanceof TextView))
      {
        String str1 = null;
        if (getIntent() != null) {
          str1 = getIntent().getExtras().getString("leftViewText");
        }
        String str2 = str1;
        if (TextUtils.isEmpty(str1)) {
          str2 = getString(2131690529);
        }
        this.leftView.setText(str2);
      }
    }
    else
    {
      setTitle(HardCodeUtil.a(2131707216));
      if ((this.leftView instanceof TextView)) {
        this.leftView.setText(2131690529);
      }
      this.rightViewText.setVisibility(0);
      this.rightViewImg.setVisibility(8);
      this.rightViewText.setText(HardCodeUtil.a(2131707208));
      this.rightViewText.setTextColor(-1);
      this.rightViewText.setOnClickListener(this);
    }
  }
  
  public void initViews()
  {
    this.mRootView = ((MonitorSizeChangeRelativeLayout)findViewById(2131376732));
    initData();
    this.app.addObserver(this.mNearbyCardObserver, true);
    this.app.addObserver(this.mCardObserver, true);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.mFadeIn)
    {
      if (this.mCurMode == 2) {
        this.mUiHandler.sendEmptyMessageDelayed(5, 100L);
      }
    }
    else
    {
      if (paramAnimation == this.mFadeOut)
      {
        this.mUiHandler.sendEmptyMessage(6);
        return;
      }
      if (paramAnimation == this.mEditLineTrans)
      {
        this.mAnimFlag |= 0x1;
        if ((this.mAnimFlag & 0x7) == 7) {
          this.mUiHandler.sendEmptyMessage(4);
        }
      }
      else if (paramAnimation == this.mHeadLineTrans)
      {
        this.mAnimFlag |= 0x2;
        if ((this.mAnimFlag & 0x7) == 7) {
          this.mUiHandler.sendEmptyMessage(4);
        }
      }
      else if (paramAnimation == this.mEditFadeIn)
      {
        this.mAnimFlag |= 0x4;
        if ((this.mAnimFlag & 0x7) == 7) {
          this.mUiHandler.sendEmptyMessage(4);
        }
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = this.leftView;
    Object localObject1 = Boolean.valueOf(true);
    int i;
    if (paramView == localObject2)
    {
      i = this.mCurMode;
      if (i == 2)
      {
        if (this.mHasShowHello)
        {
          paramView = this.mEtNikeName;
          if (paramView != null) {
            ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mEtNikeName.getWindowToken(), 0);
          }
          if (this.mFadeOut == null)
          {
            this.mFadeOut = new AlphaAnimation(1.0F, 0.0F);
            this.mFadeOut.setDuration(400L);
            this.mFadeOut.setAnimationListener(this);
          }
          this.mGuideLayout.startAnimation(this.mFadeOut);
          showClaimerLayout(400L);
          return;
        }
        if (this.mIsUseImportAvatar) {
          clearImportedQZonePhotoList();
        }
        finish();
        return;
      }
      if (i == 1)
      {
        if (this.mIsUseImportAvatar) {
          clearImportedQZonePhotoList();
        }
        finish();
      }
    }
    else if (paramView == this.rightViewText)
    {
      if (this.mCurMode == 2)
      {
        if (this.mIsUseImportAvatar) {
          clearImportedQZonePhotoList();
        }
        gotoNearbyBaseActivity(false);
        ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.app.getAccount(), "sp_key_user_skip_guide", localObject1);
        doClickReport("0X8005D91");
      }
    }
    else
    {
      if (paramView == this.mTxvImport)
      {
        importFromQQ();
        doClickReport("0X8005908");
        return;
      }
      localObject2 = this.mBtnFinish;
      if (paramView == localObject2)
      {
        if (this.mAnimating) {
          return;
        }
        paramView = ((Button)localObject2).getText().toString();
        localObject1 = getString(2131699034);
        if ((localObject1 != null) && (((String)localObject1).equals(paramView)))
        {
          showChangePhotoActionSheet();
          return;
        }
        if (!NetworkUtil.isNetSupport(this.app.getApp()))
        {
          showToast(HardCodeUtil.a(2131707210));
          return;
        }
        showProcessDialog(HardCodeUtil.a(2131707219));
        if (((Integer)this.mUploadPhotoIds.get(0)).intValue() == -1) {
          uploadPhoto(this.mAvatarPhotoPath);
        } else {
          saveProfileInfo(this.mUploadPhotoIds);
        }
        if (this.mHasImportQzonePhotoEver)
        {
          if ((this.mNikeName.equals(this.app.getCurrentNickname())) && (this.mIsUseImportAvatar)) {
            i = 2;
          } else {
            i = 3;
          }
        }
        else {
          i = 1;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8005D92", "0X8005D92", i, 0, "", "", "", "");
        return;
      }
      if (paramView == this.mImgvAvatar)
      {
        if (TextUtils.isEmpty(this.mAvatarPhotoPath))
        {
          showChangePhotoActionSheet();
          return;
        }
        paramView = (ActionSheet)ActionSheetHelper.a(this, null);
        paramView.addButton(HardCodeUtil.a(2131707207));
        paramView.addButton(HardCodeUtil.a(2131707221));
        paramView.addCancelButton(2131690728);
        paramView.setOnButtonClickListener(new NearbyGuideActivity.4(this, paramView));
        paramView.show();
        return;
      }
      if (paramView == this.mClaimOk)
      {
        ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.app.getAccount(), "nearby_people_disclaimer_ok_5.8.0", localObject1);
        if (this.mFadeOut == null)
        {
          this.mFadeOut = new AlphaAnimation(1.0F, 0.0F);
          this.mFadeOut.setDuration(400L);
          this.mFadeOut.setAnimationListener(this);
        }
        this.mClaimerLayout.startAnimation(this.mFadeOut);
        showGuideLayout(400L);
        doClickReport("0X8005902");
        return;
      }
      if (paramView.getId() == 2131378987)
      {
        paramView = this.mEtNikeName;
        if (paramView != null) {
          ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mEtNikeName.getWindowToken(), 0);
        }
      }
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("NearbyGuideActivity", "onEditorAction", new Object[] { Integer.valueOf(paramInt) });
    }
    if (paramInt == 6)
    {
      if (TextUtils.isEmpty(this.mEtNikeName.getText().toString()))
      {
        showToast(HardCodeUtil.a(2131707212));
        return true;
      }
      onClick(this.mBtnFinish);
    }
    return true;
  }
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 1) || (paramInt2 == 2)) {
      this.mUiHandler.sendEmptyMessage(2);
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == paramInt3) && (paramInt2 > 0) && (paramInt4 > 0) && (paramInt2 < paramInt4)) {
      this.mGuideLayout.postDelayed(new NearbyGuideActivity.5(this), 300L);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() == 0) {
      this.mEtNikeName.setSelection(0);
    }
  }
  
  void removePicUploadHandler()
  {
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).removeHandle(this.mPicUploadHandler);
  }
  
  void saveProfileInfo(ArrayList<Integer> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_nearby_people_card", true);
    localBundle.putShort("key_new_profile_modified_flag", (short)1);
    localBundle.putString("key_new_nickname", this.mNikeName);
    INearbyCardHandler localINearbyCardHandler = (INearbyCardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
    if (localINearbyCardHandler != null)
    {
      ThreadManager.post(new NearbyGuideActivity.7(this, paramArrayList, localINearbyCardHandler, localBundle), 5, null, true);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("NearbyGuideActivity", 4, "NearbyCardHandler is null");
    }
  }
  
  void showBigPhoto(String paramString)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = this.app.getCurrentAccountUin();
    localUserInfo.nickname = this.app.getCurrentNickname();
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    PhotoInfo localPhotoInfo = new PhotoInfo();
    localPhotoInfo.bigUrl = paramString;
    localArrayList.add(localPhotoInfo);
    localBundle.putSerializable("picturelist", localArrayList);
    localBundle.putInt("curindex", 0);
    localBundle.putInt("mode", 0);
    localBundle.putBoolean("need_clear_cache", true);
    QZoneHelper.forwardToPictureViewer(this, localUserInfo, localBundle, 6);
  }
  
  void showChangePhotoActionSheet()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.addButton(HardCodeUtil.a(2131707203));
    localActionSheet.addButton(HardCodeUtil.a(2131707214));
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new NearbyGuideActivity.6(this, localActionSheet));
    localActionSheet.show();
  }
  
  void showClaimerLayout(long paramLong)
  {
    this.mHasShowHello = true;
    this.mCurMode = 1;
    initTitle();
    if (this.mClaimerLayout == null)
    {
      this.mClaimerLayout = LayoutInflater.from(this).inflate(2131561174, null);
      if (Build.VERSION.SDK_INT >= 9) {
        this.mClaimerLayout.setOverScrollMode(2);
      }
      this.mClaimOk = ((Button)this.mClaimerLayout.findViewById(2131371730));
      this.mClaimOk.setOnClickListener(this);
      doClickReport("0X8005901");
    }
    if (this.mClaimerLayout.getParent() == null) {
      this.mRootView.addView(this.mClaimerLayout, new RelativeLayout.LayoutParams(-1, -1));
    }
    if (paramLong > 0L)
    {
      if (this.mFadeIn == null)
      {
        this.mFadeIn = new AlphaAnimation(0.0F, 1.0F);
        this.mFadeIn.setDuration(400L);
        this.mFadeIn.setAnimationListener(this);
      }
      this.mClaimerLayout.startAnimation(this.mFadeIn);
    }
  }
  
  void showEditLine()
  {
    Object localObject = this.mEtNikeName;
    if ((localObject != null) && (((EditText)localObject).getVisibility() != 0))
    {
      this.mEtNikeName.setVisibility(0);
      this.mAnimFlag = 0;
      this.mAnimating = true;
      if (this.mEditLineTrans == null)
      {
        this.mEditLineTrans = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(int)(this.mDensity * 5.0F + 0.5F));
        this.mEditLineTrans.setDuration(1300);
        this.mEditLineTrans.setFillAfter(true);
        this.mEditLineTrans.setAnimationListener(this);
      }
      this.mEditLine.startAnimation(this.mEditLineTrans);
      if (this.mEditFadeIn == null)
      {
        this.mEditFadeIn = new AlphaAnimation(0.5F, 1.0F);
        this.mEditFadeIn.setDuration(1300);
        this.mEditFadeIn.setAnimationListener(this);
        this.mEditFadeIn.setFillAfter(true);
      }
      this.mEtNikeName.startAnimation(this.mEditFadeIn);
      if (this.mHeadLineTrans == null)
      {
        this.mHeadLineTrans = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(int)(this.mDensity * 25.0F + 0.5F));
        this.mHeadLineTrans.setDuration(1300);
        this.mHeadLineTrans.setAnimationListener(this);
        this.mHeadLineTrans.setFillAfter(true);
      }
      this.mHeadLine.startAnimation(this.mHeadLineTrans);
      localObject = Message.obtain();
      ((Message)localObject).arg1 = 1;
      ((Message)localObject).what = 4;
      this.mUiHandler.sendMessageDelayed((Message)localObject, 1310);
    }
  }
  
  @TargetApi(9)
  void showGuideLayout(long paramLong)
  {
    this.mCurMode = 2;
    initTitle();
    Object localObject = getGestureLayout();
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(false);
    }
    if (this.mGuideLayout == null)
    {
      this.mGuideLayout = ((ScrollView)LayoutInflater.from(this).inflate(2131561186, null));
      if (Build.VERSION.SDK_INT >= 9) {
        this.mGuideLayout.setOverScrollMode(2);
      }
      this.mGuideLayout.findViewById(2131378987).setOnClickListener(this);
      this.mHeadLine = this.mGuideLayout.findViewById(2131368069);
      this.mEditLine = this.mGuideLayout.findViewById(2131366051);
      this.mTips = ((TextView)this.mGuideLayout.findViewById(2131380093));
      this.mImgvAvatar = ((CustomImgView)this.mGuideLayout.findViewById(2131368718));
      this.mEtNikeName = ((EditText)this.mGuideLayout.findViewById(2131366325));
      this.mBtnFinish = ((Button)this.mGuideLayout.findViewById(2131363935));
      this.mTxvImport = ((TextView)this.mGuideLayout.findViewById(2131380071));
      this.mImgvAvatar.setBackgroundDrawable(getResources().getDrawable(2130845060));
      this.mImgvAvatar.setImageDrawable(getResources().getDrawable(2130845589));
      this.mImgvCamera = ((ImageView)this.mGuideLayout.findViewById(2131368722));
      this.mEtNikeName.setSelection(0);
      this.mEtNikeName.setVisibility(4);
      this.mEtNikeName.setOnEditorActionListener(this);
      this.mBtnFinish.setText(2131699034);
      this.mBtnFinish.setContentDescription(getString(2131699034));
      updateAvatar(this.mIsUseImportAvatar ^ true, this.mAvatarPhotoPath);
      updateFinishBtnStatus();
      doClickReport("0X8005903");
      this.mEtNikeName.addTextChangedListener(this);
      this.mRootView.setCallBack(this);
      this.mTxvImport.setOnClickListener(this);
      this.mBtnFinish.setOnClickListener(this);
      this.mImgvAvatar.setOnClickListener(this);
      int i = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.app.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("qqAvatarType is: ");
        ((StringBuilder)localObject).append(i);
        QLog.i("NearbyGuideActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (i != 1)
      {
        this.mTxvImport.setText("");
        this.mTxvImport.setOnClickListener(null);
      }
    }
    if (this.mGuideLayout.getParent() == null) {
      this.mRootView.addView(this.mGuideLayout, new RelativeLayout.LayoutParams(-1, -1));
    }
    if (paramLong > 0L)
    {
      if (this.mFadeIn == null)
      {
        this.mFadeIn = new AlphaAnimation(0.0F, 1.0F);
        this.mFadeIn.setDuration(400L);
        this.mFadeIn.setAnimationListener(this);
      }
      this.mGuideLayout.startAnimation(this.mFadeIn);
      return;
    }
    this.mUiHandler.sendEmptyMessageDelayed(5, 100L);
  }
  
  void showProcessDialog(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if (this.mProgressDialog == null) {
      this.mProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.mProgressDialog.a(paramString);
    this.mProgressDialog.show();
  }
  
  void showPromptDialog()
  {
    this.mPromptDialog = DialogUtil.a(this, 2131699032, getString(2131699031), 2131699029, 2131699030, new NearbyGuideActivity.9(this), new NearbyGuideActivity.10(this), false, true);
    if ((this.mPromptDialog != null) && (!isFinishing())) {
      this.mPromptDialog.show();
    }
  }
  
  void showToast(int paramInt, String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).b(this.mTitleBarHeight);
  }
  
  void showToast(String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramString, 0).b(this.mTitleBarHeight);
  }
  
  public void updateAvatar(Drawable paramDrawable)
  {
    Object localObject = this.mImgvAvatar;
    if (localObject != null)
    {
      localObject = ((CustomImgView)localObject).a();
      this.mImgvAvatar.setImageDrawable(paramDrawable);
      if ((localObject != paramDrawable) && ((localObject instanceof FaceDrawable))) {
        ((FaceDrawable)localObject).cancel();
      }
    }
  }
  
  void updateAvatar(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean)
    {
      updateAvatar(FaceDrawable.getStrangerFaceDrawable(this.app, 200, this.app.getCurrentAccountUin(), 3, this));
      this.mUiHandler.sendEmptyMessageDelayed(2, 3000L);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      updateAvatar(getResources().getDrawable(2130845589));
      this.mImgvCamera.setVisibility(0);
      return;
    }
    ThreadManager.postImmediately(new NearbyGuideActivity.8(this, paramString), null, true);
  }
  
  void updateFinishBtnStatus()
  {
    String str1 = this.mBtnFinish.getText().toString();
    String str2 = getString(2131699034);
    if ((str2 != null) && (str2.equals(str1)))
    {
      this.mBtnFinish.setEnabled(true);
      return;
    }
    if (this.mEtNikeName.getText() == null) {
      str1 = "";
    } else {
      str1 = this.mEtNikeName.getText().toString();
    }
    this.mNikeName = str1;
    this.mNikeName = NearbyUtils.a(this.mNikeName);
    if (TextUtils.isEmpty(this.mNikeName))
    {
      this.mBtnFinish.setEnabled(false);
      return;
    }
    if ((TextUtils.isEmpty(this.mAvatarPhotoPath)) && (!this.mIsUseImportAvatar))
    {
      this.mBtnFinish.setEnabled(false);
      return;
    }
    this.mBtnFinish.setEnabled(true);
  }
  
  void uploadPhoto(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("NearbyGuideActivity", 2, "uploadPhoto filePath is empty.");
      }
      return;
    }
    paramString = new CompressInfo(paramString, 0);
    paramString.f = 0;
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(paramString);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Q.nearby_people_card..uploadPhoto(), img_path = ");
      ((StringBuilder)localObject).append(paramString.e);
      QLog.d("Q.nearby_people_card.upload_local_photo", 2, ((StringBuilder)localObject).toString());
    }
    if (!StringUtil.a(paramString.e))
    {
      localObject = new TransferRequest();
      ((TransferRequest)localObject).mIsUp = true;
      ((TransferRequest)localObject).mLocalPath = paramString.e;
      ((TransferRequest)localObject).mFileType = 8;
      ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject);
      return;
    }
    dismissProcessDialog();
    showToast(1, HardCodeUtil.a(2131707205));
    updateAvatar(true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity
 * JD-Core Version:    0.7.0.1
 */