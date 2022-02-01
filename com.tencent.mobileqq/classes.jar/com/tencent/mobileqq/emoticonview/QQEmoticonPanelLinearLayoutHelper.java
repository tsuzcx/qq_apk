package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerFrameLayout;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerProxy;
import com.tencent.mobileqq.hotpic.HotPicDownLoader;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.entry.AECameraLauncher;
import java.io.File;
import mqq.app.AppRuntime;

public class QQEmoticonPanelLinearLayoutHelper
  implements View.OnClickListener, PopupWindow.OnDismissListener, IEmoticonPanelLinearLayoutHelper
{
  public static final String TAG = "EmotionPanelLinearLayout";
  private static Rect tmp = new Rect();
  private int businessType = 0;
  private EmoticonCallback callback;
  Context context;
  private int currentChatPieType;
  float density;
  private int emoType = 0;
  private boolean haveRemovedWindowContent = true;
  boolean isDiyEmotion = false;
  private boolean isPreviewShowPoping = false;
  boolean isSelfieFaceEmotion = false;
  boolean isSoundEmotion = false;
  volatile long lastJumpCameraTime = 0L;
  float lastTouchX = 0.0F;
  float lastTouchY = 0.0F;
  private QQEmoticonMainPanelApp mApp;
  private ImageView mArrowImageView;
  private BaseChatPie mBaseChatPie;
  private IEmoticonPanelLinearLayoutHelper.OnClickListener mClickListener;
  private EmoticonPanelLinearLayout mCurrentView;
  private TextView mEmoTitleTv;
  boolean mHasPerformedLongPress;
  QQEmoticonPanelLinearLayoutHelper.CheckForLongPress mPendingCheckForLongPress;
  private EmoticonInfo mPointInfo;
  View mPointView;
  private EmojiStickerManager.StickerFrameLayout mPopupEmo;
  private URLImageView mPopupEmoImage;
  private ViewGroup mRootView;
  private RelativeLayout mShowEmoRlyt;
  private ImageView mStickerCancel;
  private ImageView mStickerConfirm;
  private PopupWindow mTipsPopupWindow;
  private FrameLayout mWindowContent;
  private int panelType = -1;
  private AudioPlayer player;
  float screenHeight;
  float screenWidth;
  private boolean showSticker = false;
  private boolean showing = false;
  private boolean stickerMode = false;
  
  public QQEmoticonPanelLinearLayoutHelper(Context paramContext)
  {
    initHelper(paramContext);
  }
  
  public QQEmoticonPanelLinearLayoutHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    initHelper(paramContext);
  }
  
  public QQEmoticonPanelLinearLayoutHelper(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    initHelper(paramContext);
    this.mBaseChatPie = paramBaseChatPie;
    if (this.mBaseChatPie != null)
    {
      if (!(paramBaseChatPie instanceof FriendChatPie)) {
        break label115;
      }
      this.currentChatPieType = 1;
    }
    for (;;)
    {
      this.mRootView = this.mBaseChatPie.c;
      return;
      label115:
      if ((paramBaseChatPie instanceof BaseTroopChatPie)) {
        this.currentChatPieType = 2;
      } else if ((paramBaseChatPie instanceof DiscussChatPie)) {
        this.currentChatPieType = 3;
      }
    }
  }
  
  private void addEmoTitleLayout(EmoticonInfo paramEmoticonInfo, float paramFloat)
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.mShowEmoRlyt = new RelativeLayout(getContext());
    this.mPopupEmo.addView(localLinearLayout);
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    localLinearLayout.addView(this.mShowEmoRlyt, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131379472);
    this.mShowEmoRlyt.addView(this.mPopupEmoImage, (ViewGroup.LayoutParams)localObject);
    fillPopEmoLayout(this.mShowEmoRlyt);
    this.mEmoTitleTv = getEmoTitleTv(paramEmoticonInfo);
    paramEmoticonInfo = new RelativeLayout.LayoutParams(-1, -2);
    paramEmoticonInfo.addRule(14);
    paramEmoticonInfo.addRule(12);
    paramEmoticonInfo.bottomMargin = ((int)(18.0F * paramFloat));
    paramEmoticonInfo.leftMargin = ((int)(12.0F * paramFloat));
    paramEmoticonInfo.rightMargin = ((int)(12.0F * paramFloat));
    this.mShowEmoRlyt.addView(this.mEmoTitleTv, paramEmoticonInfo);
    this.mArrowImageView = new ImageView(getContext());
    this.mArrowImageView.setImageDrawable(this.mCurrentView.getResources().getDrawable(2130838118));
    paramEmoticonInfo = new LinearLayout.LayoutParams(ViewUtils.a(18.0F), ViewUtils.a(12.0F));
    paramEmoticonInfo.topMargin = (-ViewUtils.a(9.0F));
    paramEmoticonInfo.gravity = 1;
    localLinearLayout.addView(this.mArrowImageView, paramEmoticonInfo);
  }
  
  private void addToCustomEmotionForPic(String paramString)
  {
    Object localObject = HotPicDownLoader.a(paramString);
    if ((localObject == null) || (!((File)localObject).exists()))
    {
      QLog.e("EmotionPanelLinearLayout", 4, " add custom fail file no exist");
      return;
    }
    MessageForPic localMessageForPic = (MessageForPic)MessageRecordFactory.a(-2000);
    localMessageForPic.path = ((File)localObject).getAbsolutePath();
    localMessageForPic.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(localMessageForPic.path));
    localMessageForPic.thumbMsgUrl = paramString;
    localMessageForPic.bigMsgUrl = paramString;
    localMessageForPic.imageType = 2000;
    paramString = URLDrawableHelper.getDrawable(paramString);
    paramString.setTag(localMessageForPic);
    localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface))
    {
      QLog.e("EmotionPanelLinearLayout", 2, "addToCustomEmotionForPic cannot get QQAppInterface");
      return;
    }
    AIOGalleryUtils.a(getContext(), (QQAppInterface)localObject, paramString, "", getContext().getResources().getDimensionPixelSize(2131299166), null, localMessageForPic.picExtraData);
  }
  
  private void fillPopEmoLayout(RelativeLayout paramRelativeLayout)
  {
    this.mStickerCancel = new ImageView(getContext());
    this.mStickerCancel.setId(2131362395);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 20.0F), (int)(this.density * 20.0F));
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    paramRelativeLayout.addView(this.mStickerCancel, localLayoutParams);
    this.mStickerCancel.setImageDrawable(this.mCurrentView.getResources().getDrawable(2130847534));
    this.mStickerCancel.setVisibility(4);
    this.mStickerConfirm = new ImageView(getContext());
    this.mStickerConfirm.setId(2131362396);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 20.0F), (int)(this.density * 20.0F));
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(12);
    paramRelativeLayout.addView(this.mStickerConfirm, localLayoutParams);
    this.mStickerConfirm.setVisibility(4);
    this.mStickerConfirm.setImageDrawable(this.mCurrentView.getResources().getDrawable(2130848953));
  }
  
  private int getChildViewIndex(View paramView)
  {
    int j = this.mCurrentView.getChildCount();
    int i = 0;
    while (i < j)
    {
      if (this.mCurrentView.getChildAt(i) == paramView) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void handleLongClick(View paramView, EmoticonInfo paramEmoticonInfo)
  {
    if ((paramView == null) || (paramEmoticonInfo == null)) {
      QLog.e("EmotionPanelLinearLayout", 4, "handleLongClick pointView or info is null.");
    }
    while ((this.panelType != 6) || (!(paramEmoticonInfo instanceof HotPicSearchEmoticonInfo)) || (this.mApp.getQQAppInterface() == null)) {
      return;
    }
    reportHotPicSearchAddFav((HotPicSearchEmoticonInfo)paramEmoticonInfo, false);
    showAddCustomFacePop(paramView, paramEmoticonInfo);
  }
  
  private boolean isInvokeSticker(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4)) > 50.0D;
  }
  
  private boolean needShowPopUpEmo(EmoticonInfo paramEmoticonInfo)
  {
    boolean bool2 = true;
    boolean bool1;
    if (("delete".equals(paramEmoticonInfo.action)) || ("setting".equals(paramEmoticonInfo.action)) || ("add".equals(paramEmoticonInfo.action)) || ("cameraJump".equals(paramEmoticonInfo.action)) || ("cameraEdit".equals(paramEmoticonInfo.action)) || (this.panelType == 6)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramEmoticonInfo instanceof CameraEmoticonInfo));
      paramEmoticonInfo = (CameraEmoticonInfo)paramEmoticonInfo;
      if ((paramEmoticonInfo.roamingType.equals("failed")) || (paramEmoticonInfo.roamingType.equals("needUpload"))) {
        break;
      }
      bool1 = bool2;
    } while (!paramEmoticonInfo.roamingType.equals("needDel"));
    return false;
  }
  
  private void reportHotPicSearchAddFav(HotPicSearchEmoticonInfo paramHotPicSearchEmoticonInfo, boolean paramBoolean)
  {
    int i = 1;
    int j = paramHotPicSearchEmoticonInfo.mPageType;
    String str;
    if (j == 1) {
      if (paramBoolean)
      {
        str = "0X800B535";
        if (!android.text.TextUtils.isEmpty(paramHotPicSearchEmoticonInfo.mSearchWord)) {
          break label81;
        }
        paramHotPicSearchEmoticonInfo = str;
      }
    }
    for (;;)
    {
      if (!android.text.TextUtils.isEmpty(paramHotPicSearchEmoticonInfo)) {
        ReportController.b(null, "dc00898", "", "", paramHotPicSearchEmoticonInfo, paramHotPicSearchEmoticonInfo, i, 0, "", "", "", "");
      }
      return;
      str = "0X800B534";
      break;
      label81:
      i = 2;
      paramHotPicSearchEmoticonInfo = str;
      continue;
      if (j == 2)
      {
        if (paramBoolean) {}
        for (paramHotPicSearchEmoticonInfo = "0X800B537";; paramHotPicSearchEmoticonInfo = "0X800B536")
        {
          i = 0;
          break;
        }
      }
      i = 0;
      paramHotPicSearchEmoticonInfo = "";
    }
  }
  
  private void updateArrowLayout(View paramView, float paramFloat, int paramInt1, int paramInt2, ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    if (this.mArrowImageView != null)
    {
      paramMarginLayoutParams.topMargin = (tmp.top - paramInt2 - (int)(30.0F * paramFloat));
      paramInt1 = (int)((int)(tmp.left + paramView.getWidth() / 2.0F) - (paramMarginLayoutParams.leftMargin + paramInt1 / 2.0F));
      paramView = (LinearLayout.LayoutParams)this.mArrowImageView.getLayoutParams();
      if (paramView != null)
      {
        paramView.leftMargin = paramInt1;
        this.mArrowImageView.setLayoutParams(paramView);
      }
    }
  }
  
  private void updatePointViewAlpha(float paramFloat)
  {
    if ((this.panelType == 6) && (this.mPointView != null)) {
      this.mPointView.setAlpha(paramFloat);
    }
  }
  
  private void updatePopupEmoLayout(int paramInt, ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    paramMarginLayoutParams.leftMargin = (tmp.left - (paramInt - tmp.width()) / 2);
    if (paramMarginLayoutParams.leftMargin + paramInt >= ViewUtils.a()) {
      paramMarginLayoutParams.leftMargin = (ViewUtils.a() - paramInt);
    }
    while (paramMarginLayoutParams.leftMargin > 0) {
      return;
    }
    paramMarginLayoutParams.leftMargin = 0;
  }
  
  public void attachCurrentView(EmoticonPanelLinearLayout paramEmoticonPanelLinearLayout)
  {
    this.mCurrentView = paramEmoticonPanelLinearLayout;
    paramEmoticonPanelLinearLayout.setClickable(true);
    paramEmoticonPanelLinearLayout.setLongClickable(true);
    paramEmoticonPanelLinearLayout.setOrientation(0);
  }
  
  View findPointChild(float paramFloat1, float paramFloat2)
  {
    int i = this.mCurrentView.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.mCurrentView.getChildAt(i);
      float f1 = this.mCurrentView.getScrollX() + paramFloat1 - localView.getLeft();
      float f2 = this.mCurrentView.getScrollY() + paramFloat2 - localView.getTop();
      if ((f1 >= 0.0F) && (f1 <= localView.getWidth()) && (f2 >= 0.0F) && (f2 < localView.getHeight())) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  boolean getChildRect(View paramView, Rect paramRect)
  {
    if (paramView == null) {
      return false;
    }
    paramView.getDrawingRect(paramRect);
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    paramRect.offset(paramView.getLeft() - localViewGroup.getScrollX(), paramView.getTop() - localViewGroup.getScrollY());
    return true;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  protected TextView getEmoTitleTv(EmoticonInfo paramEmoticonInfo)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText(EmoticonUtils.getSystemAndEmojiEmoticonName(paramEmoticonInfo));
    localTextView.setId(2131379472);
    if (ThemeUtil.isNowThemeIsNight(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {}
    for (paramEmoticonInfo = "#8D8D93";; paramEmoticonInfo = "#878B99")
    {
      localTextView.setTextColor(Color.parseColor(paramEmoticonInfo));
      localTextView.setGravity(17);
      localTextView.setSingleLine();
      localTextView.setLines(1);
      localTextView.setTextSize(12.0F);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      return localTextView;
    }
  }
  
  public void hidePopupWindow()
  {
    if ((this.mRootView != null) && (!this.isDiyEmotion) && (this.stickerMode) && (EmojiStickerManager.f)) {
      if (!this.isPreviewShowPoping) {}
    }
    while ((this.mPopupEmo == null) || (!this.showing) || (this.mWindowContent == null) || (this.haveRemovedWindowContent))
    {
      return;
      this.mRootView.post(new QQEmoticonPanelLinearLayoutHelper.1(this));
      EmojiStickerManager.b = false;
      return;
    }
    this.haveRemovedWindowContent = true;
    ((WindowManager)getContext().getSystemService("window")).removeViewImmediate(this.mWindowContent);
    if (this.player != null) {
      this.player.d();
    }
    if (this.callback != null) {
      this.callback.onHidePopup(this.mPointInfo);
    }
    this.showing = false;
  }
  
  public void initHelper(Context paramContext)
  {
    this.context = paramContext;
    this.density = paramContext.getResources().getDisplayMetrics().density;
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.screenHeight = paramContext.heightPixels;
    this.screenWidth = paramContext.widthPixels;
    this.mApp = new QQEmoticonMainPanelApp();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362218)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelLinearLayout", 4, " add_to_custom_face ");
      }
      if ((this.mTipsPopupWindow != null) && (this.mTipsPopupWindow.isShowing())) {
        break label50;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label50:
      EmoticonInfo localEmoticonInfo = (EmoticonInfo)paramView.getTag();
      if (((localEmoticonInfo instanceof HotPicSearchEmoticonInfo)) && (((HotPicSearchEmoticonInfo)localEmoticonInfo).mSearchItem != null))
      {
        addToCustomEmotionForPic(((HotPicSearchEmoticonInfo)localEmoticonInfo).mSearchItem.originalUrl);
        reportHotPicSearchAddFav((HotPicSearchEmoticonInfo)localEmoticonInfo, true);
      }
      this.mTipsPopupWindow.dismiss();
    }
  }
  
  public void onDismiss()
  {
    this.mTipsPopupWindow = null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 1: 
    case 0: 
    case 3: 
      for (;;)
      {
        return true;
        if ((!this.mHasPerformedLongPress) && (this.mPendingCheckForLongPress != null)) {
          this.mCurrentView.removeCallbacks(this.mPendingCheckForLongPress);
        }
        updatePointViewAlpha(1.0F);
        if ((this.mPointView != null) && (!this.mHasPerformedLongPress)) {
          performClick(this.mPointView);
        }
        if (!this.showSticker) {
          hidePopupWindow();
        }
        this.mPointView = null;
        if ((this.mRootView != null) && (!this.isDiyEmotion) && (EmojiStickerManager.f) && (!this.isPreviewShowPoping))
        {
          this.mRootView.onTouchEvent(paramMotionEvent);
          continue;
          this.lastTouchX = paramMotionEvent.getRawX();
          this.lastTouchY = paramMotionEvent.getRawY();
          this.mHasPerformedLongPress = false;
          this.mPointView = findPointChild(paramMotionEvent.getX(), paramMotionEvent.getY());
          if (this.mPointView != null)
          {
            updatePointViewAlpha(0.2F);
            if (this.mPendingCheckForLongPress == null) {
              this.mPendingCheckForLongPress = new QQEmoticonPanelLinearLayoutHelper.CheckForLongPress(this, paramMotionEvent);
            }
            this.mPendingCheckForLongPress.rememberWindowAttachCount();
            this.mCurrentView.postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
            continue;
            this.mCurrentView.setPressed(false);
            if (this.mPendingCheckForLongPress != null) {
              this.mCurrentView.removeCallbacks(this.mPendingCheckForLongPress);
            }
            if (!this.showSticker) {
              hidePopupWindow();
            }
            updatePointViewAlpha(1.0F);
            this.mPointView = null;
          }
        }
      }
    }
    Object localObject1;
    if (this.mHasPerformedLongPress)
    {
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      if ((EmojiStickerManager.f) && (isInvokeSticker(this.lastTouchX, this.lastTouchY, f1, f2)) && (this.mPopupEmo != null))
      {
        if ((this.showSticker) || (!this.stickerMode)) {
          break label1057;
        }
        localObject1 = (RelativeLayout.LayoutParams)this.mPopupEmo.getLayoutParams();
        if ((this.emoType == 1) || (this.emoType == 2) || (this.emoType == 7) || (this.emoType == 10))
        {
          ((RelativeLayout.LayoutParams)localObject1).width = ((int)(110.0F * this.density));
          ((RelativeLayout.LayoutParams)localObject1).height = ((int)(110.0F * this.density));
        }
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)f1 - ((RelativeLayout.LayoutParams)localObject1).width / 2);
        if (((RelativeLayout.LayoutParams)localObject1).leftMargin + ((RelativeLayout.LayoutParams)localObject1).width > this.screenWidth) {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)this.screenWidth - ((RelativeLayout.LayoutParams)localObject1).width);
        }
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)f2 - ((RelativeLayout.LayoutParams)localObject1).height / 2 - ImmersiveUtils.getStatusBarHeight(getContext()));
        if ((this.mRootView != null) && (((RelativeLayout.LayoutParams)localObject1).topMargin + ((RelativeLayout.LayoutParams)localObject1).height > this.mRootView.getMeasuredHeight()))
        {
          if (ImmersiveUtils.isSupporImmersive() != 1) {
            break label1027;
          }
          ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)this.screenHeight - ((RelativeLayout.LayoutParams)localObject1).height - ImmersiveUtils.getStatusBarHeight(getContext()));
        }
        label562:
        if ((this.mEmoTitleTv == null) || (this.mArrowImageView == null) || (this.mShowEmoRlyt == null)) {
          break label1046;
        }
        this.mEmoTitleTv.setVisibility(4);
        this.mArrowImageView.setVisibility(4);
        this.mShowEmoRlyt.setBackgroundResource(0);
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelLinearLayout", 4, "emo title is invisible");
        }
        label622:
        this.mPopupEmo.requestLayout();
        if ((this.mRootView instanceof TopGestureLayout))
        {
          localObject1 = ((TopGestureLayout)this.mRootView).getGestureDetector();
          if ((localObject1 instanceof StickerGestureDetector))
          {
            localObject1 = (StickerGestureDetector)localObject1;
            ((StickerGestureDetector)localObject1).lastX = f1;
            ((StickerGestureDetector)localObject1).lastY = f2;
          }
        }
        if (this.mBaseChatPie != null)
        {
          localObject1 = this.mBaseChatPie.a();
          if (localObject1 != null) {
            ((AIOAnimationConatiner)localObject1).a();
          }
          localObject1 = AIOEmoticonUIHelper.a(this.mBaseChatPie);
          if (localObject1 != null)
          {
            if (((EmoticonMainPanel)localObject1).stickerMaskLayout == null)
            {
              localObject2 = new LinearLayout(getContext());
              ((LinearLayout)localObject2).setBackgroundColor(-1);
              ((LinearLayout)localObject2).getBackground().setAlpha(0);
              ((LinearLayout)localObject2).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
              ((EmoticonMainPanel)localObject1).stickerMaskLayout = ((View)localObject2);
            }
            if (((EmoticonMainPanel)localObject1).stickerMaskLayout.getParent() != localObject1) {
              ((EmoticonMainPanel)localObject1).addView(((EmoticonMainPanel)localObject1).stickerMaskLayout);
            }
            Object localObject2 = PropertyValuesHolder.ofInt("alpha", new int[] { 0, 178 });
            ObjectAnimator.ofPropertyValuesHolder(((EmoticonMainPanel)localObject1).stickerMaskLayout.getBackground(), new PropertyValuesHolder[] { localObject2 }).setDuration(500L).start();
          }
        }
        this.showSticker = true;
      }
    }
    label853:
    do
    {
      do
      {
        if ((this.mRootView != null) && (this.showSticker) && (!this.isDiyEmotion) && (this.stickerMode) && (EmojiStickerManager.f)) {
          this.mRootView.onTouchEvent(paramMotionEvent);
        }
        if (((this.showSticker) || (this.mWindowContent == null)) && (EmojiStickerManager.f)) {
          break;
        }
        if ((!this.mHasPerformedLongPress) || ((getChildRect(this.mPointView, tmp)) && (tmp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))) {
          break label1254;
        }
        this.mPointView = findPointChild(paramMotionEvent.getX(), paramMotionEvent.getY());
        if ((this.mPointView == null) || (this.mPointView.getTag() == null)) {
          break label1247;
        }
        if (!needShowPopUpEmo((EmoticonInfo)this.mPointView.getTag())) {
          break;
        }
        showPopupEmo(this.mPointView, (EmoticonInfo)this.mPointView.getTag());
        break;
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)this.screenHeight - ((RelativeLayout.LayoutParams)localObject1).height);
        break label562;
        this.mPopupEmo.setBackgroundResource(0);
        break label622;
      } while (this.stickerMode);
      localObject1 = (EmoticonInfo)this.mPopupEmo.getTag();
    } while (localObject1 == null);
    label1027:
    label1046:
    label1057:
    int i;
    switch (((EmoticonInfo)localObject1).type)
    {
    case 3: 
    case 8: 
    default: 
      i = 7;
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "Stick", "DragToAIOX", String.valueOf(this.currentChatPieType), 0, 0, 0, "", "", String.valueOf(i), "", "", "", "", 0, 0, 0, 0);
      break label853;
      i = 1;
      continue;
      i = 2;
      continue;
      if (this.isDiyEmotion)
      {
        i = 3;
      }
      else
      {
        if (this.isSoundEmotion)
        {
          i = 6;
          continue;
          i = 4;
          continue;
          i = 5;
          continue;
          label1247:
          hidePopupWindow();
          break;
          label1254:
          if ((this.mHasPerformedLongPress) || (this.mPointView == null) || ((getChildRect(this.mPointView, tmp)) && (tmp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))) {
            break;
          }
          this.mPointView = null;
          break;
        }
        i = -1;
      }
    }
  }
  
  void performClick(View paramView)
  {
    if (paramView.getAlpha() != 1.0F) {}
    label1367:
    for (;;)
    {
      return;
      Object localObject3 = paramView.getTag();
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if ((localObject3 instanceof EmoticonInfo)) {
          localObject1 = (EmoticonInfo)localObject3;
        }
      }
      if (localObject1 == null) {
        break;
      }
      if ((this.mClickListener == null) || (!this.mClickListener.shouldInterceptClickEvent(paramView, (EmoticonInfo)localObject1)))
      {
        this.mCurrentView.sendAccessibilityEvent(1);
        this.mCurrentView.playSoundEffect(0);
        if ((!"delete".equals(((EmoticonInfo)localObject1).action)) && (this.callback != null)) {
          if ("setting".equals(((EmoticonInfo)localObject1).action)) {
            this.callback.setting();
          }
        }
        for (;;)
        {
          if (!(paramView instanceof EmoticonImageView)) {
            break label1367;
          }
          paramView = (EmoticonImageView)paramView;
          if (!paramView.isNewIconVisible()) {
            break;
          }
          if ((localObject1 instanceof SystemAndEmojiEmoticonInfo)) {
            ((IApolloUtil)QRoute.api(IApolloUtil.class)).onNewEmoticonClick(((SystemAndEmojiEmoticonInfo)localObject1).code);
          }
          paramView.setNewIconVisible(false);
          if (EmoticonImageView.isNewIconDisable()) {
            break;
          }
          EmoticonImageView.disableNewIcon(true);
          if (this.mBaseChatPie == null) {
            break;
          }
          paramView = AIOEmoticonUIHelper.a(this.mBaseChatPie);
          if (paramView == null) {
            break;
          }
          paramView.updateSystemAndEmojiPanel();
          return;
          if ("add".equals(((EmoticonInfo)localObject1).action))
          {
            this.callback.emoticonMall();
            ReportController.b(this.mApp.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800579C", 0, 0, "", "", "", "");
          }
          else if ("cameraJump".equals(((EmoticonInfo)localObject1).action))
          {
            if (this.mBaseChatPie == null)
            {
              QLog.e("EmotionPanelLinearLayout", 1, "baseChatPie is null.");
              return;
            }
            long l = System.currentTimeMillis();
            if (l - this.lastJumpCameraTime > 1000L)
            {
              this.lastJumpCameraTime = l;
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("AECAMERA_MODE", 202);
              ((Bundle)localObject2).putInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.i.a());
              ((Bundle)localObject2).putParcelable("ARG_SESSION_INFO", new SessionWrap(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b));
              AECameraLauncher.a((Activity)this.context, 120, (Bundle)localObject2);
              ReportController.b(this.mApp.getQQAppInterface(), "dc00898", "", "", "0X800A36E", "0X800A36E", 0, 0, "", "", "", "");
              ReportController.b(this.mApp.getQQAppInterface(), "dc00898", "", "", "0x800a570", "0x800a570", 0, 0, "", "", "", "");
            }
          }
          else if ("cameraEdit".equals(((EmoticonInfo)localObject1).action))
          {
            localObject2 = new Intent(this.context, FavEmosmManageActivity.class);
            ((Intent)localObject2).putExtra("camera_emo_mode", 1);
            this.context.startActivity((Intent)localObject2);
            ReportController.b(this.mApp.getQQAppInterface(), "dc00898", "", "", "0X800A36F", "0X800A36F", 0, 0, "", "", "", "");
          }
          else if ("favEdit".equals(((EmoticonInfo)localObject1).action))
          {
            localObject2 = new Intent(this.context, FavEmosmManageActivity.class);
            this.context.startActivity((Intent)localObject2);
            ReportController.b(this.mApp.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800579E", 0, 0, "", "", "", "");
            ReportController.b(this.mApp.getQQAppInterface(), "dc00898", "", "", "0X800B8B8", "0X800B8B8", 0, 0, "", "", "", "");
          }
          else if ("funny_pic".equals(((EmoticonInfo)localObject1).action))
          {
            int j = 0;
            int i = j;
            if ("8.5.5".equals("7.3.5"))
            {
              localObject2 = this.context.getSharedPreferences("funny_pic_info", 0).edit();
              ((SharedPreferences.Editor)localObject2).putBoolean("group_emo_red_show_sp_key_" + this.mApp.getCurrentAccountUin(), false);
              ((SharedPreferences.Editor)localObject2).apply();
              localObject2 = paramView.findViewById(2131366618);
              i = j;
              if (localObject2 != null)
              {
                i = j;
                if (((View)localObject2).getVisibility() == 0)
                {
                  i = 1;
                  ((View)localObject2).setVisibility(8);
                }
              }
            }
            PublicFragmentActivity.a(this.context, EmoticonGroupStoreFragment.class);
            ReportController.b(this.mApp.getQQAppInterface(), "dc00898", "", "", "0x800a56f", "0x800a56f", 0, 0, "", "", "", "");
            VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickQLin", "0", 1, 0, i, "", "", "", "", "", "", "", 0, 0, 0, 0);
          }
          else
          {
            if ("push".equals(((EmoticonInfo)localObject1).action))
            {
              if ((this.callback instanceof AIOEmoticonPanelHelper)) {
                ((AIOEmoticonPanelHelper)this.callback).gotoEmoMallPage(9);
              }
              ReportController.b(this.mApp.getQQAppInterface(), "dc00898", "", "", "0x800a571", "0x800a571", 0, 0, "", "", "", "");
              ReportController.b(this.mApp.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800579B", 0, 0, "", "", "", "");
              localObject2 = this.context.getSharedPreferences("mobileQQ", 0);
              localObject3 = this.mApp.getCurrentAccountUin();
              if (!((SharedPreferences)localObject2).getBoolean("magic_promotion_is_new_content_" + (String)localObject3, false)) {
                break;
              }
              ImageView localImageView = (ImageView)paramView.findViewById(2131378813);
              if (QLog.isColorLevel()) {
                QLog.d("EmotionPanelLinearLayout", 2, "emoticonImg:" + localImageView);
              }
              Object localObject4 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.context.getResources().getDrawable(2130847478);
              localObject4 = URLDrawable.getDrawable(((SharedPreferences)localObject2).getString("magic_promotion_imgUrl", ""), (URLDrawable.URLDrawableOptions)localObject4);
              if ((localImageView != null) && (localObject4 != null)) {
                localImageView.setImageDrawable((Drawable)localObject4);
              }
              ((SharedPreferences)localObject2).edit().putBoolean("magic_promotion_is_new_content_" + (String)localObject3, false).apply();
              continue;
            }
            if ((localObject1 instanceof PicEmoticonInfo))
            {
              localObject2 = (PicEmoticonInfo)localObject1;
              ((PicEmoticonInfo)localObject2).stickerInfo = null;
              localObject3 = ((PicEmoticonInfo)localObject2).emoticon;
              ((EmoticonManagerProxy)this.mApp.getManager(QQManagerFactory.EMOTICON_MANAGER)).asyncFindEmoticonPackage(((Emoticon)localObject3).epId, this.businessType, new QQEmoticonPanelLinearLayoutHelper.2(this, (Emoticon)localObject3, (EmoticonInfo)localObject1, (PicEmoticonInfo)localObject2));
            }
            else
            {
              this.callback.send((EmoticonInfo)localObject1);
              continue;
              QLog.e("EmotionPanelLinearLayout", 1, "performclick callback = null");
            }
          }
        }
      }
    }
    QLog.e("EmotionPanelLinearLayout", 1, "performclick info = null");
  }
  
  public void setBusinessType(int paramInt)
  {
    this.businessType = paramInt;
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.callback = paramEmoticonCallback;
  }
  
  public void setInterceptListener(IEmoticonPanelLinearLayoutHelper.OnClickListener paramOnClickListener)
  {
    this.mClickListener = paramOnClickListener;
  }
  
  public void setPanelType(int paramInt)
  {
    this.panelType = paramInt;
  }
  
  public void showAddCustomFacePop(View paramView, EmoticonInfo paramEmoticonInfo)
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(1);
    Object localObject = new TextView(getContext());
    ((TextView)localObject).setId(2131362218);
    ((TextView)localObject).setTag(paramEmoticonInfo);
    ((TextView)localObject).setOnClickListener(this);
    ((TextView)localObject).setTextColor(getContext().getResources().getColor(2131167374));
    ((TextView)localObject).setTextSize(14.0F);
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setText(getContext().getResources().getString(2131693294));
    ((TextView)localObject).setBackgroundResource(2130839044);
    localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(ViewUtils.a(65.0F), ViewUtils.a(46.0F)));
    paramEmoticonInfo = new ImageView(getContext());
    paramEmoticonInfo.setImageDrawable(getContext().getResources().getDrawable(2130839036));
    localLinearLayout.addView(paramEmoticonInfo, new LinearLayout.LayoutParams(ViewUtils.a(20.0F), ViewUtils.a(10.0F)));
    localObject = (LinearLayout.LayoutParams)paramEmoticonInfo.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = (-AIOUtils.a(7.0F, getContext().getResources()));
    ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(3.0F, getContext().getResources());
    paramEmoticonInfo.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mTipsPopupWindow = new PopupWindow(localLinearLayout, -2, -2);
    this.mTipsPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
    this.mTipsPopupWindow.setOutsideTouchable(true);
    this.mTipsPopupWindow.setFocusable(true);
    this.mTipsPopupWindow.setOnDismissListener(this);
    localLinearLayout.measure(0, 0);
    paramView.post(new QQEmoticonPanelLinearLayoutHelper.3(this, paramView, localLinearLayout));
  }
  
  void showPopupEmo(View paramView, EmoticonInfo paramEmoticonInfo)
  {
    if ((paramView == null) || (paramEmoticonInfo == null))
    {
      QLog.e("EmotionPanelLinearLayout", 1, "showpoupemo view or info = null");
      return;
    }
    float f = getContext().getResources().getDisplayMetrics().density;
    this.isDiyEmotion = false;
    this.isSoundEmotion = false;
    this.stickerMode = false;
    this.showSticker = false;
    this.emoType = paramEmoticonInfo.type;
    Object localObject1;
    Object localObject2;
    if ((paramEmoticonInfo instanceof PicEmoticonInfo))
    {
      localObject1 = (PicEmoticonInfo)paramEmoticonInfo;
      if (((PicEmoticonInfo)localObject1).emoticon != null)
      {
        localObject2 = (EmoticonManagerProxy)this.mApp.getManager(QQManagerFactory.EMOTICON_MANAGER);
        if (localObject2 != null)
        {
          localObject2 = ((EmoticonManagerProxy)localObject2).syncFindEmoticonPackageById(((PicEmoticonInfo)localObject1).emoticon.epId);
          if (localObject2 != null)
          {
            if (((EmoticonPackage)localObject2).subType != 4) {
              break label235;
            }
            this.isDiyEmotion = true;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmotionPanelLinearLayout", 2, "showPopupEmo, PicEmoticonInfo isDiyEmotion = " + this.isDiyEmotion + " isSoundEmotion = " + this.isSoundEmotion);
      }
      localObject1 = ((PicEmoticonInfo)localObject1).getLoadingDrawable("fromAIO", true, false, null, (int)(110.0F * f), (int)(110.0F * f));
    }
    for (;;)
    {
      if ((paramEmoticonInfo instanceof CameraEmoticonInfo)) {
        this.isSelfieFaceEmotion = true;
      }
      if (localObject1 != null) {
        break label313;
      }
      QLog.e("EmotionPanelLinearLayout", 1, "showpoupemo drawable = null");
      return;
      label235:
      if (((EmoticonPackage)localObject2).subType != 1) {
        break;
      }
      this.isSoundEmotion = true;
      break;
      if ((paramEmoticonInfo instanceof FavoriteEmoticonInfo))
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmotionPanelLinearLayout", 2, "showPopupEmo, FavoriteEmoticonInfo");
        }
        localObject1 = ((FavoriteEmoticonInfo)paramEmoticonInfo).getBigDrawable(this.context, this.density, 0, 0);
      }
      else
      {
        localObject1 = paramEmoticonInfo.getBigDrawable(this.context, this.density);
      }
    }
    label313:
    paramView.getGlobalVisibleRect(tmp);
    int i = paramEmoticonInfo.type;
    label497:
    int k;
    label588:
    int m;
    int j;
    if ((this.mRootView != null) && (!this.isDiyEmotion) && (!this.isSelfieFaceEmotion) && (EmojiStickerManager.f))
    {
      if (this.mRootView.findViewById(2131374517) != null)
      {
        this.isPreviewShowPoping = true;
        return;
      }
      this.isPreviewShowPoping = false;
      this.mPopupEmo = new EmojiStickerManager.StickerFrameLayout(getContext());
      this.mPopupEmo.setId(2131374517);
      this.mPopupEmo.setTag(paramEmoticonInfo);
      this.mPopupEmo.setTag(2131374553, Integer.valueOf(this.panelType));
      this.mPopupEmoImage = new URLImageView(getContext());
      this.mPopupEmoImage.setId(2131362397);
      this.mPopupEmoImage.setAdjustViewBounds(false);
      this.mPopupEmoImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((Drawable)localObject1).setCallback(this.mPopupEmoImage);
      if (EmoticonUtils.isShowEmoTitleInPreview(this.mBaseChatPie, paramEmoticonInfo))
      {
        addEmoTitleLayout(paramEmoticonInfo, f);
        this.mRootView.addView(this.mPopupEmo);
        this.stickerMode = true;
        if (this.mPopupEmoImage != null)
        {
          this.mPopupEmoImage.setRotation(0.0F);
          this.mPopupEmoImage.setScaleX(1.0F);
          this.mPopupEmoImage.setScaleY(1.0F);
        }
        if (this.mStickerCancel != null) {
          this.mStickerCancel.setVisibility(4);
        }
        if (this.mStickerConfirm != null) {
          this.mStickerConfirm.setVisibility(4);
        }
        this.mWindowContent = null;
        this.showing = false;
        EmojiStickerManager.b = true;
        if (this.mPopupEmo == null) {
          break label1550;
        }
        this.mPopupEmoImage.setImageDrawable((Drawable)localObject1);
        k = (int)(5.0F * f);
        localObject2 = (RelativeLayout.LayoutParams)this.mPopupEmoImage.getLayoutParams();
        if ((i != 1) && (i != 2) && (i != 7) && (i != 10)) {
          break label1642;
        }
        if (!EmoticonUtils.isShowEmoTitleInPreview(this.mBaseChatPie, paramEmoticonInfo)) {
          break label1576;
        }
        k = (int)(94.0F * f);
        m = (int)(97.0F * f);
        ((RelativeLayout.LayoutParams)localObject2).width = ((int)(30.0F * f));
        ((RelativeLayout.LayoutParams)localObject2).height = ((int)(30.0F * f));
        i = m;
        j = k;
        if (this.mShowEmoRlyt != null)
        {
          i = m;
          j = k;
          if (this.mEmoTitleTv != null)
          {
            i = m;
            j = k;
            if (this.mArrowImageView != null)
            {
              this.mEmoTitleTv.setVisibility(0);
              this.mArrowImageView.setVisibility(0);
              this.mShowEmoRlyt.setBackgroundResource(2130838117);
              i = m;
              j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("EmotionPanelLinearLayout", 4, "emo title is visible");
                j = k;
                i = m;
              }
            }
          }
        }
        label801:
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(6.0F * f));
        ((RelativeLayout.LayoutParams)localObject2).addRule(14);
        ((RelativeLayout.LayoutParams)localObject2).addRule(15);
        k = j;
        j = i;
        i = k;
        label838:
        if ((this.mRootView == null) || (this.isDiyEmotion) || (!this.stickerMode) || (!EmojiStickerManager.f)) {
          break label1809;
        }
        localObject2 = (RelativeLayout.LayoutParams)this.mPopupEmo.getLayoutParams();
        k = tmp.right - i;
        if (!EmoticonUtils.isShowEmoTitleInPreview(this.mBaseChatPie, paramEmoticonInfo)) {
          break label1747;
        }
        updatePopupEmoLayout(i, (ViewGroup.MarginLayoutParams)localObject2);
        label907:
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (tmp.top - j - (int)(15.0F * f));
        ((RelativeLayout.LayoutParams)localObject2).width = i;
        ((RelativeLayout.LayoutParams)localObject2).height = j;
        updateArrowLayout(paramView, f, i, j, (ViewGroup.MarginLayoutParams)localObject2);
        if (!this.showing) {
          break label2025;
        }
        this.mPopupEmo.requestLayout();
      }
    }
    label1202:
    label1642:
    while (this.mWindowContent == null)
    {
      localObject2 = this.mPointInfo;
      this.mPointInfo = paramEmoticonInfo;
      if ((localObject2 != null) && (((EmoticonInfo)localObject2).type == 6) && ((localObject2 instanceof PicEmoticonInfo)) && (this.player != null)) {
        this.player.d();
      }
      Object localObject3;
      if ((paramEmoticonInfo.type == 6) && ((paramEmoticonInfo instanceof PicEmoticonInfo)) && ((localObject1 instanceof URLDrawable)))
      {
        paramView = (PicEmoticonInfo)paramEmoticonInfo;
        if (paramView.isSound())
        {
          localObject3 = EmoticonUtils.emoticonSoundPath.replace("[epId]", paramView.emoticon.epId).replace("[eId]", paramView.emoticon.eId);
          if (this.player == null) {
            this.player = new AudioPlayer(getContext(), null);
          }
          this.player.b(5);
          this.player.a((String)localObject3);
          EmotionUtils.startSoundDrawablePlay((URLDrawable)localObject1);
        }
        if (2 == paramView.emoticon.jobType) {
          ReportController.b(null, "CliOper", "", "", "MbYulan", "MbChangan", 0, 0, paramView.emoticon.epId, "", "", "");
        }
        if (paramView.isNewSoundType())
        {
          if (paramView.emoticon == null) {
            break label2119;
          }
          paramView = paramView.emoticon.epId;
          EmoticonManager.a(null, "0X800A938", -1, paramView);
        }
      }
      if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo))
      {
        paramView = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
        localObject3 = BaseApplicationImpl.getApplication();
        if (localObject3 != null)
        {
          localObject3 = ((BaseApplicationImpl)localObject3).getRuntime();
          if ((localObject3 != null) && ((localObject3 instanceof QQAppInterface)))
          {
            QQAppInterface localQQAppInterface = (QQAppInterface)localObject3;
            if (com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(paramView.code))
            {
              if ((this.mBaseChatPie == null) || (this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
                break label2126;
              }
              i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.mBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "0X800812D", i, 0, new String[] { String.valueOf(paramView.code), String.valueOf(((IApolloManagerService)((AppRuntime)localObject3).getRuntimeService(IApolloManagerService.class, "all")).getApolloUserStatus(localQQAppInterface)) });
            }
          }
        }
      }
      if (this.callback == null) {
        break;
      }
      this.callback.onShowPopup((EmoticonInfo)localObject2, paramEmoticonInfo, (Drawable)localObject1);
      return;
      this.mPopupEmo.addView(this.mPopupEmoImage);
      fillPopEmoLayout(this.mPopupEmo);
      this.mEmoTitleTv = null;
      this.mArrowImageView = null;
      break label497;
      if (this.mWindowContent == null)
      {
        this.mWindowContent = new FrameLayout(getContext());
        this.mPopupEmo = new EmojiStickerManager.StickerFrameLayout(getContext());
        this.mPopupEmo.setTag(paramEmoticonInfo);
        this.mPopupEmoImage = new URLImageView(getContext());
        this.mPopupEmoImage.setAdjustViewBounds(false);
        this.mPopupEmoImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if (!EmoticonUtils.isShowEmoTitleInPreview(this.mBaseChatPie, paramEmoticonInfo)) {
          break label1552;
        }
        addEmoTitleLayout(paramEmoticonInfo, f);
      }
      for (;;)
      {
        this.mWindowContent.addView(this.mPopupEmo);
        if (this.mEmoTitleTv == null) {
          break label588;
        }
        this.mEmoTitleTv.setText(EmoticonUtils.getSystemAndEmojiEmoticonName(paramEmoticonInfo));
        break label588;
        break;
        this.mPopupEmo.addView(this.mPopupEmoImage);
        this.mEmoTitleTv = null;
        this.mArrowImageView = null;
      }
      j = (int)(64.0F * f);
      i = (int)(71.0F * f);
      ((RelativeLayout.LayoutParams)localObject2).width = ((int)(28.0F * f));
      ((RelativeLayout.LayoutParams)localObject2).height = ((int)(28.0F * f));
      this.mPopupEmo.setPadding(k, k, k, k);
      this.mPopupEmo.setBackgroundResource(2130838127);
      break label801;
      i = (int)(110.0F * f);
      j = (int)(110.0F * f);
      this.mPopupEmo.setBackgroundResource(2130838126);
      this.mPopupEmo.setPadding(k, k, k, k);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
      ((RelativeLayout.LayoutParams)localObject2).width = ((int)(100.0F * f));
      ((RelativeLayout.LayoutParams)localObject2).height = ((int)(100.0F * f));
      ReportController.b(null, "CliOper", "", "", "ep_mall", "ep_preview", 0, 0, "", "", "", "");
      break label838;
      if (k < 0)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = (tmp.left - (i - tmp.width()) / 2 - k / 2);
        break label907;
      }
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = (tmp.left - (i - tmp.width()) / 2);
      break label907;
      localObject2 = (FrameLayout.LayoutParams)this.mPopupEmo.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject2).gravity = 51;
      k = tmp.left + i - this.mCurrentView.getWidth();
      m = tmp.right - i;
      if (EmoticonUtils.isShowEmoTitleInPreview(this.mBaseChatPie, paramEmoticonInfo)) {
        updatePopupEmoLayout(i, (ViewGroup.MarginLayoutParams)localObject2);
      }
      for (;;)
      {
        ((FrameLayout.LayoutParams)localObject2).topMargin = (tmp.top - j - (int)(15.0F * f));
        ((FrameLayout.LayoutParams)localObject2).width = i;
        ((FrameLayout.LayoutParams)localObject2).height = j;
        updateArrowLayout(paramView, f, i, j, (ViewGroup.MarginLayoutParams)localObject2);
        break;
        if (k > 0) {
          ((FrameLayout.LayoutParams)localObject2).leftMargin = (tmp.left - (i - tmp.width()) / 2 - k / 2);
        } else if (m < 0) {
          ((FrameLayout.LayoutParams)localObject2).leftMargin = (tmp.left - (i - tmp.width()) / 2 - m / 2);
        } else {
          ((FrameLayout.LayoutParams)localObject2).leftMargin = (tmp.left - (i - tmp.width()) / 2);
        }
      }
    }
    label1313:
    label1576:
    label1747:
    label2025:
    paramView = (WindowManager)getContext().getSystemService("window");
    label1550:
    label1552:
    label1809:
    i = 40;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = 67108904;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      i |= 0x8000000;
    }
    for (;;)
    {
      localObject2 = new WindowManager.LayoutParams(-1, -1, 2, i, -3);
      paramView.addView(this.mWindowContent, (ViewGroup.LayoutParams)localObject2);
      this.haveRemovedWindowContent = false;
      this.showing = true;
      break;
      label2119:
      paramView = "";
      break label1202;
      label2126:
      i = -1;
      break label1313;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper
 * JD-Core Version:    0.7.0.1
 */