package com.tencent.mobileqq.emoticonview;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
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
import android.text.TextUtils.TruncateAt;
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
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.StickerFrameLayout;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.popanim.PopOutEmoticonGesture;
import com.tencent.mobileqq.popanim.util.PopOutEmoticonUtil;
import com.tencent.mobileqq.popanim.view.PopOutAnimViewHelper;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VasVipUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;

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
  private boolean hasReportPressMove;
  private boolean haveRemovedWindowContent = true;
  boolean isDiyEmotion = false;
  private boolean isPreviewShowPoping = false;
  boolean isSelfieFaceEmotion = false;
  boolean isSoundEmotion = false;
  volatile long lastJumpCameraTime = 0L;
  float lastRelativeTouchX = 0.0F;
  float lastRelativeTouchY = 0.0F;
  float lastTouchX = 0.0F;
  float lastTouchY = 0.0F;
  private QQEmoticonMainPanelApp mApp;
  private ImageView mArrowImageView;
  private IEmoticonPanelLinearLayoutHelper.OnClickListener mClickListener;
  private EmoticonPanelLinearLayout mCurrentView;
  private TextView mEmoTitleTv;
  private EmoticonInfo mEmocInfo;
  boolean mHasPerformedLongPress;
  private IPanelInteractionListener mInteractionListener;
  QQEmoticonPanelLinearLayoutHelper.CheckForLongPress mPendingCheckForLongPress;
  private EmoticonInfo mPointInfo;
  View mPointView;
  protected PopOutEmoticonGesture mPopOutEmoticonGesture;
  public StickerFrameLayout mPopupEmo;
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
  
  public QQEmoticonPanelLinearLayoutHelper(Context paramContext, IPanelInteractionListener paramIPanelInteractionListener)
  {
    initHelper(paramContext);
    this.mInteractionListener = paramIPanelInteractionListener;
    paramContext = this.mInteractionListener;
    if (paramContext != null)
    {
      this.currentChatPieType = paramContext.getPanelChatPieType();
      this.mRootView = this.mInteractionListener.getAIORootView();
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
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131374398);
    this.mShowEmoRlyt.addView(this.mPopupEmoImage, (ViewGroup.LayoutParams)localObject);
    fillPopEmoLayout(this.mShowEmoRlyt);
    this.mEmoTitleTv = getEmoTitleTv(paramEmoticonInfo);
    paramEmoticonInfo = new RelativeLayout.LayoutParams(-1, -2);
    paramEmoticonInfo.addRule(14);
    paramEmoticonInfo.addRule(12);
    paramEmoticonInfo.bottomMargin = ((int)(paramFloat * 18.0F));
    int i = (int)(paramFloat * 12.0F);
    paramEmoticonInfo.leftMargin = i;
    paramEmoticonInfo.rightMargin = i;
    this.mShowEmoRlyt.addView(this.mEmoTitleTv, paramEmoticonInfo);
    this.mArrowImageView = new ImageView(getContext());
    this.mArrowImageView.setImageDrawable(this.mCurrentView.getResources().getDrawable(2130837967));
    paramEmoticonInfo = new LinearLayout.LayoutParams(ViewUtils.a(18.0F), ViewUtils.a(12.0F));
    paramEmoticonInfo.topMargin = (-ViewUtils.a(9.0F));
    paramEmoticonInfo.gravity = 1;
    localLinearLayout.addView(this.mArrowImageView, paramEmoticonInfo);
  }
  
  private void addToCustomEmotionForPic(String paramString)
  {
    ((IEmosmService)QRoute.api(IEmosmService.class)).addToCustomEmotionForPic(getContext(), paramString, true);
  }
  
  private void fillPopEmoLayout(RelativeLayout paramRelativeLayout)
  {
    this.mStickerCancel = new ImageView(getContext());
    this.mStickerCancel.setId(2131362351);
    float f = this.density;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(f * 20.0F), (int)(f * 20.0F));
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    paramRelativeLayout.addView(this.mStickerCancel, localLayoutParams);
    this.mStickerCancel.setImageDrawable(this.mCurrentView.getResources().getDrawable(2130847402));
    this.mStickerCancel.setVisibility(4);
    this.mStickerConfirm = new ImageView(getContext());
    this.mStickerConfirm.setId(2131362352);
    f = this.density;
    localLayoutParams = new RelativeLayout.LayoutParams((int)(f * 20.0F), (int)(f * 20.0F));
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(12);
    paramRelativeLayout.addView(this.mStickerConfirm, localLayoutParams);
    this.mStickerConfirm.setVisibility(4);
    this.mStickerConfirm.setImageDrawable(this.mCurrentView.getResources().getDrawable(2130848833));
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
  
  private int getEmoticonReportType(EmoticonInfo paramEmoticonInfo)
  {
    switch (paramEmoticonInfo.type)
    {
    case 3: 
    case 8: 
    default: 
      return 7;
    case 10: 
      return 2;
    case 9: 
      return 4;
    case 6: 
      if (this.isDiyEmotion) {
        return 3;
      }
      if (this.isSoundEmotion) {
        return 6;
      }
      return -1;
    case 4: 
    case 5: 
      return 5;
    }
    return 1;
  }
  
  private void handleLongClick(View paramView, EmoticonInfo paramEmoticonInfo)
  {
    if ((paramView != null) && (paramEmoticonInfo != null))
    {
      if ((this.panelType == 6) && ((paramEmoticonInfo instanceof HotPicSearchEmoticonInfo)) && (this.mApp.getQQAppInterface() != null))
      {
        reportHotPicSearchAddFav((HotPicSearchEmoticonInfo)paramEmoticonInfo, false);
        showAddCustomFacePop(paramView, paramEmoticonInfo);
      }
      return;
    }
    QLog.e("EmotionPanelLinearLayout", 4, "handleLongClick pointView or info is null.");
  }
  
  private boolean isInvokeSticker(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2) > 50.0D;
  }
  
  private boolean needShowPopUpEmo(EmoticonInfo paramEmoticonInfo)
  {
    boolean bool1 = "delete".equals(paramEmoticonInfo.action);
    boolean bool2 = false;
    if ((!bool1) && (!"setting".equals(paramEmoticonInfo.action)) && (!"add".equals(paramEmoticonInfo.action)) && (!"cameraJump".equals(paramEmoticonInfo.action)) && (!"cameraEdit".equals(paramEmoticonInfo.action)))
    {
      if (this.panelType == 6) {
        return false;
      }
      if ((paramEmoticonInfo instanceof CameraEmoticonInfo))
      {
        paramEmoticonInfo = (CameraEmoticonInfo)paramEmoticonInfo;
        bool1 = bool2;
        if (!paramEmoticonInfo.roamingType.equals("failed"))
        {
          bool1 = bool2;
          if (!paramEmoticonInfo.roamingType.equals("needUpload"))
          {
            bool1 = bool2;
            if (!paramEmoticonInfo.roamingType.equals("needDel")) {
              bool1 = true;
            }
          }
        }
        return bool1;
      }
      return true;
    }
    return false;
  }
  
  private void reportHotPicSearchAddFav(HotPicSearchEmoticonInfo paramHotPicSearchEmoticonInfo, boolean paramBoolean)
  {
    int i = paramHotPicSearchEmoticonInfo.mPageType;
    if (i == 1)
    {
      String str;
      if (paramBoolean) {
        str = "0X800B535";
      } else {
        str = "0X800B534";
      }
      if (android.text.TextUtils.isEmpty(paramHotPicSearchEmoticonInfo.mSearchWord))
      {
        paramHotPicSearchEmoticonInfo = str;
        i = 1;
      }
      else
      {
        paramHotPicSearchEmoticonInfo = str;
        i = 2;
      }
    }
    else
    {
      if (i == 2)
      {
        if (paramBoolean) {
          paramHotPicSearchEmoticonInfo = "0X800B537";
        } else {
          paramHotPicSearchEmoticonInfo = "0X800B536";
        }
      }
      else {
        paramHotPicSearchEmoticonInfo = "";
      }
      i = 0;
    }
    if (!android.text.TextUtils.isEmpty(paramHotPicSearchEmoticonInfo)) {
      ReportController.b(null, "dc00898", "", "", paramHotPicSearchEmoticonInfo, paramHotPicSearchEmoticonInfo, i, 0, "", "", "", "");
    }
  }
  
  private void updateArrowLayout(View paramView, float paramFloat, int paramInt1, int paramInt2, ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    if (this.mArrowImageView != null)
    {
      paramMarginLayoutParams.topMargin = (tmp.top - paramInt2 - (int)(paramFloat * 30.0F));
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
    if (this.panelType == 6)
    {
      View localView = this.mPointView;
      if (localView != null) {
        localView.setAlpha(paramFloat);
      }
    }
  }
  
  private void updatePopupEmoLayout(int paramInt, ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    paramMarginLayoutParams.leftMargin = (tmp.left - (paramInt - tmp.width()) / 2);
    if (paramMarginLayoutParams.leftMargin + paramInt >= ViewUtils.a())
    {
      paramMarginLayoutParams.leftMargin = (ViewUtils.a() - paramInt);
      return;
    }
    if (paramMarginLayoutParams.leftMargin <= 0) {
      paramMarginLayoutParams.leftMargin = 0;
    }
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
  
  public int getCurrentPointViewIndex()
  {
    View localView = this.mPointView;
    if (localView != null) {
      return getChildViewIndex(localView);
    }
    return -1;
  }
  
  protected TextView getEmoTitleTv(EmoticonInfo paramEmoticonInfo)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText(EmoticonUtils.getSystemAndEmojiEmoticonName(paramEmoticonInfo));
    localTextView.setId(2131374398);
    if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.waitAppRuntime(null), false, null)) {
      paramEmoticonInfo = "#8D8D93";
    } else {
      paramEmoticonInfo = "#878B99";
    }
    localTextView.setTextColor(Color.parseColor(paramEmoticonInfo));
    localTextView.setGravity(17);
    localTextView.setSingleLine();
    localTextView.setLines(1);
    localTextView.setTextSize(12.0F);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    return localTextView;
  }
  
  public void hidePopupWindow()
  {
    if ((this.mRootView != null) && (!this.isDiyEmotion) && (this.stickerMode) && (((IEmosmService)QRoute.api(IEmosmService.class)).getEmojiStickerSwitch()))
    {
      if (this.isPreviewShowPoping) {
        return;
      }
      this.mRootView.post(new QQEmoticonPanelLinearLayoutHelper.1(this));
      ((IEmosmService)QRoute.api(IEmosmService.class)).setEmojiStickerMode(false);
      return;
    }
    if ((this.mPopupEmo != null) && (this.showing) && (this.mWindowContent != null) && (!this.haveRemovedWindowContent))
    {
      this.haveRemovedWindowContent = true;
      ((WindowManager)getContext().getSystemService("window")).removeViewImmediate(this.mWindowContent);
      Object localObject = this.player;
      if (localObject != null) {
        ((AudioPlayer)localObject).c();
      }
      localObject = this.callback;
      if (localObject != null) {
        ((EmoticonCallback)localObject).onHidePopup(this.mPointInfo);
      }
      this.showing = false;
    }
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
    if (paramView.getId() == 2131362241)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelLinearLayout", 4, " add_to_custom_face ");
      }
      Object localObject = this.mTipsPopupWindow;
      if ((localObject != null) && (((PopupWindow)localObject).isShowing()))
      {
        localObject = (EmoticonInfo)paramView.getTag();
        if ((localObject instanceof HotPicSearchEmoticonInfo))
        {
          localObject = (HotPicSearchEmoticonInfo)localObject;
          if (((HotPicSearchEmoticonInfo)localObject).mSearchItem != null)
          {
            addToCustomEmotionForPic(((HotPicSearchEmoticonInfo)localObject).mSearchItem.originalUrl);
            reportHotPicSearchAddFav((HotPicSearchEmoticonInfo)localObject, true);
          }
        }
        this.mTipsPopupWindow.dismiss();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      Object localObject;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
          this.mCurrentView.setPressed(false);
          localObject = this.mPendingCheckForLongPress;
          if (localObject != null) {
            this.mCurrentView.removeCallbacks((Runnable)localObject);
          }
          if (!this.showSticker) {
            hidePopupWindow();
          }
          updatePointViewAlpha(1.0F);
          this.mPointView = null;
          localObject = this.mPopOutEmoticonGesture;
          if ((localObject != null) && (((PopOutEmoticonGesture)localObject).a()))
          {
            this.mPopOutEmoticonGesture.a(paramMotionEvent);
            return true;
          }
        }
        else
        {
          if (this.mHasPerformedLongPress)
          {
            float f1 = paramMotionEvent.getRawX();
            float f2 = paramMotionEvent.getRawY();
            if (this.mPopupEmo != null) {
              i = 1;
            } else {
              i = 0;
            }
            boolean bool = isInvokeSticker(this.lastTouchX, this.lastTouchY, f1, f2);
            localObject = this.mPopOutEmoticonGesture;
            int j;
            if ((localObject != null) && (((PopOutEmoticonGesture)localObject).a())) {
              j = 1;
            } else {
              j = 0;
            }
            if ((j != 0) && (i != 0) && (bool))
            {
              if (this.mPointView == null) {
                this.mPointView = findPointChild(this.lastRelativeTouchX, this.lastRelativeTouchY);
              }
              this.mPopOutEmoticonGesture.a(paramMotionEvent);
              return true;
            }
            if ((((IEmosmService)QRoute.api(IEmosmService.class)).getEmojiStickerSwitch()) && (i != 0) && (bool))
            {
              if ((!this.showSticker) && (this.stickerMode))
              {
                localObject = (RelativeLayout.LayoutParams)this.mPopupEmo.getLayoutParams();
                EmoticonInfo localEmoticonInfo = this.mEmocInfo;
                if ((localEmoticonInfo != null) && ((localEmoticonInfo.type == 1) || (this.mEmocInfo.type == 2) || (this.mEmocInfo.type == 7) || (this.mEmocInfo.type == 10)))
                {
                  f3 = this.density;
                  ((RelativeLayout.LayoutParams)localObject).width = ((int)(f3 * 110.0F));
                  ((RelativeLayout.LayoutParams)localObject).height = ((int)(f3 * 110.0F));
                }
                ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)f1 - ((RelativeLayout.LayoutParams)localObject).width / 2);
                float f3 = ((RelativeLayout.LayoutParams)localObject).leftMargin + ((RelativeLayout.LayoutParams)localObject).width;
                float f4 = this.screenWidth;
                if (f3 > f4) {
                  ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)f4 - ((RelativeLayout.LayoutParams)localObject).width);
                }
                ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)f2 - ((RelativeLayout.LayoutParams)localObject).height / 2 - ImmersiveUtils.getStatusBarHeight(getContext()));
                if ((this.mRootView != null) && (((RelativeLayout.LayoutParams)localObject).topMargin + ((RelativeLayout.LayoutParams)localObject).height > this.mRootView.getMeasuredHeight())) {
                  if (ImmersiveUtils.isSupporImmersive() == 1) {
                    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)this.screenHeight - ((RelativeLayout.LayoutParams)localObject).height - ImmersiveUtils.getStatusBarHeight(getContext()));
                  } else {
                    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)this.screenHeight - ((RelativeLayout.LayoutParams)localObject).height);
                  }
                }
                localObject = this.mEmoTitleTv;
                if ((localObject != null) && (this.mArrowImageView != null) && (this.mShowEmoRlyt != null))
                {
                  ((TextView)localObject).setVisibility(4);
                  this.mArrowImageView.setVisibility(4);
                  this.mShowEmoRlyt.setBackgroundResource(0);
                  if (QLog.isColorLevel()) {
                    QLog.d("EmotionPanelLinearLayout", 4, "emo title is invisible");
                  }
                }
                else
                {
                  this.mPopupEmo.setBackgroundResource(0);
                }
                this.mPopupEmo.requestLayout();
                localObject = this.mRootView;
                if ((localObject instanceof TopGestureLayout))
                {
                  localObject = ((TopGestureLayout)localObject).getGestureDetector();
                  if ((localObject instanceof IStickerGestureDetector))
                  {
                    localObject = (IStickerGestureDetector)localObject;
                    ((IStickerGestureDetector)localObject).setLastX(f1);
                    ((IStickerGestureDetector)localObject).setLastY(f2);
                  }
                }
                localObject = this.mInteractionListener;
                if ((localObject != null) && (((IPanelInteractionListener)localObject).getBaseChatPie() != null))
                {
                  localObject = this.mInteractionListener;
                  if (localObject != null) {
                    ((IPanelInteractionListener)localObject).stopAnimationConatiner();
                  }
                  showStickerMaskOnPanel();
                }
                this.showSticker = true;
              }
              else if (!this.stickerMode)
              {
                localObject = (EmoticonInfo)this.mPopupEmo.getTag();
                if (localObject != null)
                {
                  i = getEmoticonReportType((EmoticonInfo)localObject);
                  VasWebviewUtil.a("", "Stick", "DragToAIOX", String.valueOf(this.currentChatPieType), 0, 0, 0, "", "", String.valueOf(i), "", "", "", "", 0, 0, 0, 0);
                }
              }
              if ((this.mRootView != null) && (this.showSticker) && (!this.isDiyEmotion) && (this.stickerMode) && (((IEmosmService)QRoute.api(IEmosmService.class)).getEmojiStickerSwitch())) {
                this.mRootView.onTouchEvent(paramMotionEvent);
              }
              if ((PopOutEmoticonUtil.a(this.panelType, this.mEmocInfo)) && (!this.hasReportPressMove))
              {
                this.hasReportPressMove = true;
                PopOutAnimViewHelper.a("0X800BB9F", this.mEmocInfo);
              }
            }
          }
          if (((!this.showSticker) && (this.mWindowContent != null)) || (!((IEmosmService)QRoute.api(IEmosmService.class)).getEmojiStickerSwitch())) {
            if ((this.mHasPerformedLongPress) && ((!getChildRect(this.mPointView, tmp)) || (!tmp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
            {
              this.mPointView = findPointChild(paramMotionEvent.getX(), paramMotionEvent.getY());
              paramMotionEvent = this.mPointView;
              if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
              {
                paramMotionEvent = (EmoticonInfo)this.mPointView.getTag();
                if (needShowPopUpEmo(paramMotionEvent))
                {
                  showPopupEmo(this.mPointView, paramMotionEvent);
                  return true;
                }
              }
              else
              {
                hidePopupWindow();
                return true;
              }
            }
            else if (!this.mHasPerformedLongPress)
            {
              localObject = this.mPointView;
              if ((localObject != null) && ((!getChildRect((View)localObject, tmp)) || (!tmp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
              {
                this.mPointView = null;
                return true;
              }
            }
          }
        }
      }
      else
      {
        if (!this.mHasPerformedLongPress)
        {
          localObject = this.mPendingCheckForLongPress;
          if (localObject != null) {
            this.mCurrentView.removeCallbacks((Runnable)localObject);
          }
        }
        updatePointViewAlpha(1.0F);
        localObject = this.mPointView;
        if ((localObject != null) && (!this.mHasPerformedLongPress))
        {
          performClick((View)localObject);
          this.mPointView.callOnClick();
        }
        this.mPointView = null;
        if (!this.showSticker) {
          hidePopupWindow();
        }
        localObject = this.mPopOutEmoticonGesture;
        if ((localObject != null) && (((PopOutEmoticonGesture)localObject).a()))
        {
          this.mPopOutEmoticonGesture.a(paramMotionEvent);
          return true;
        }
        if ((this.mRootView != null) && (!this.isDiyEmotion) && (((IEmosmService)QRoute.api(IEmosmService.class)).getEmojiStickerSwitch()) && (!this.isPreviewShowPoping))
        {
          this.mRootView.onTouchEvent(paramMotionEvent);
          return true;
        }
      }
    }
    else
    {
      this.lastTouchX = paramMotionEvent.getRawX();
      this.lastTouchY = paramMotionEvent.getRawY();
      this.lastRelativeTouchX = paramMotionEvent.getX();
      this.lastRelativeTouchY = paramMotionEvent.getY();
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
      }
    }
    return true;
  }
  
  void performClick(View paramView)
  {
    if (paramView.getAlpha() != 1.0F) {
      return;
    }
    Object localObject1 = paramView.getTag();
    if ((localObject1 != null) && ((localObject1 instanceof EmoticonInfo))) {
      localObject1 = (EmoticonInfo)localObject1;
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      Object localObject2 = this.mClickListener;
      if ((localObject2 != null) && (((IEmoticonPanelLinearLayoutHelper.OnClickListener)localObject2).shouldInterceptClickEvent(paramView, (EmoticonInfo)localObject1))) {
        return;
      }
      this.mCurrentView.sendAccessibilityEvent(1);
      this.mCurrentView.playSoundEffect(0);
      if ((!"delete".equals(((EmoticonInfo)localObject1).action)) && (this.callback != null))
      {
        if ("setting".equals(((EmoticonInfo)localObject1).action))
        {
          this.callback.setting();
        }
        else if ("add".equals(((EmoticonInfo)localObject1).action))
        {
          this.callback.emoticonMall();
          ReportController.b(this.mApp.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800579C", 0, 0, "", "", "", "");
        }
        else if ("cameraJump".equals(((EmoticonInfo)localObject1).action))
        {
          localObject2 = this.mInteractionListener;
          if ((localObject2 != null) && (((IPanelInteractionListener)localObject2).getBaseChatPie() != null))
          {
            long l = System.currentTimeMillis();
            if (l - this.lastJumpCameraTime > 1000L)
            {
              this.lastJumpCameraTime = l;
              ((IEmosmService)QRoute.api(IEmosmService.class)).launchAECameraUnit(this.context, this.mInteractionListener.getBaseChatPie());
              ReportController.b(this.mApp.getQQAppInterface(), "dc00898", "", "", "0X800A36E", "0X800A36E", 0, 0, "", "", "", "");
              ReportController.b(this.mApp.getQQAppInterface(), "dc00898", "", "", "0x800a570", "0x800a570", 0, 0, "", "", "", "");
            }
          }
          else
          {
            QLog.e("EmotionPanelLinearLayout", 1, "baseChatPie is null.");
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
          ((IEmosmService)QRoute.api(IEmosmService.class)).startEmoticonGroupStoreFragment(this.context);
          ReportController.b(this.mApp.getQQAppInterface(), "dc00898", "", "", "0x800a56f", "0x800a56f", 0, 0, "", "", "", "");
          VasWebviewUtil.a("", "QLbq", "ClickQLin", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
        else
        {
          Object localObject3;
          if ("push".equals(((EmoticonInfo)localObject1).action))
          {
            ((IEmosmService)QRoute.api(IEmosmService.class)).gotoEmoMallPage(this.callback);
            ReportController.b(this.mApp.getQQAppInterface(), "dc00898", "", "", "0x800a571", "0x800a571", 0, 0, "", "", "", "");
            ReportController.b(this.mApp.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800579B", 0, 0, "", "", "", "");
            localObject3 = this.context.getSharedPreferences("mobileQQ", 0);
            localObject2 = this.mApp.getCurrentAccountUin();
            Object localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("magic_promotion_is_new_content_");
            ((StringBuilder)localObject4).append((String)localObject2);
            if (!((SharedPreferences)localObject3).getBoolean(((StringBuilder)localObject4).toString(), false)) {
              return;
            }
            localObject4 = (ImageView)paramView.findViewById(2131378202);
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("emoticonImg:");
              ((StringBuilder)localObject5).append(localObject4);
              QLog.d("EmotionPanelLinearLayout", 2, ((StringBuilder)localObject5).toString());
            }
            Object localObject5 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = this.context.getResources().getDrawable(2130847348);
            localObject5 = URLDrawable.getDrawable(((SharedPreferences)localObject3).getString("magic_promotion_imgUrl", ""), (URLDrawable.URLDrawableOptions)localObject5);
            if ((localObject4 != null) && (localObject5 != null)) {
              ((ImageView)localObject4).setImageDrawable((Drawable)localObject5);
            }
            localObject3 = ((SharedPreferences)localObject3).edit();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("magic_promotion_is_new_content_");
            ((StringBuilder)localObject4).append((String)localObject2);
            ((SharedPreferences.Editor)localObject3).putBoolean(((StringBuilder)localObject4).toString(), false).apply();
          }
          else if ((localObject1 instanceof PicEmoticonInfo))
          {
            localObject2 = (PicEmoticonInfo)localObject1;
            ((PicEmoticonInfo)localObject2).stickerInfo = null;
            localObject3 = ((PicEmoticonInfo)localObject2).emoticon;
            ((EmoticonManagerServiceProxy)this.mApp.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(((Emoticon)localObject3).epId, this.businessType, new QQEmoticonPanelLinearLayoutHelper.2(this, (Emoticon)localObject3, (EmoticonInfo)localObject1, (PicEmoticonInfo)localObject2));
          }
          else
          {
            this.callback.send((EmoticonInfo)localObject1);
          }
        }
      }
      else {
        QLog.e("EmotionPanelLinearLayout", 1, "performclick callback = null");
      }
      if ((paramView instanceof EmoticonImageView))
      {
        paramView = (EmoticonImageView)paramView;
        if (paramView.isNewIconVisible())
        {
          if ((localObject1 instanceof SystemAndEmojiEmoticonInfo)) {
            ((IApolloUtil)QRoute.api(IApolloUtil.class)).onNewEmoticonClick(((SystemAndEmojiEmoticonInfo)localObject1).code);
          }
          paramView.setNewIconVisible(false);
          if (!EmoticonImageView.isNewIconDisable())
          {
            EmoticonImageView.disableNewIcon(true);
            paramView = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.mInteractionListener);
            if (paramView != null) {
              paramView.updateSystemAndEmojiPanel();
            }
          }
        }
      }
    }
    else
    {
      QLog.e("EmotionPanelLinearLayout", 1, "performclick info = null");
    }
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
    ((TextView)localObject).setId(2131362241);
    ((TextView)localObject).setTag(paramEmoticonInfo);
    ((TextView)localObject).setOnClickListener(this);
    ((TextView)localObject).setTextColor(getContext().getResources().getColor(2131167394));
    ((TextView)localObject).setTextSize(14.0F);
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setText(getContext().getResources().getString(2131699745));
    ((TextView)localObject).setBackgroundResource(2130838897);
    localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(ViewUtils.a(65.0F), ViewUtils.a(46.0F)));
    paramEmoticonInfo = new ImageView(getContext());
    paramEmoticonInfo.setImageDrawable(getContext().getResources().getDrawable(2130838864));
    localLinearLayout.addView(paramEmoticonInfo, new LinearLayout.LayoutParams(ViewUtils.a(20.0F), ViewUtils.a(10.0F)));
    localObject = (LinearLayout.LayoutParams)paramEmoticonInfo.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).topMargin = (-com.tencent.mobileqq.EmotionUtils.a(7.0F, getContext().getResources()));
    ((LinearLayout.LayoutParams)localObject).bottomMargin = com.tencent.mobileqq.EmotionUtils.a(3.0F, getContext().getResources());
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
    if ((paramView != null) && (paramEmoticonInfo != null))
    {
      float f = getContext().getResources().getDisplayMetrics().density;
      this.isDiyEmotion = false;
      this.isSoundEmotion = false;
      this.stickerMode = false;
      this.showSticker = false;
      this.mEmocInfo = paramEmoticonInfo;
      boolean bool = paramEmoticonInfo instanceof PicEmoticonInfo;
      Object localObject1;
      if (bool)
      {
        localObject1 = (PicEmoticonInfo)paramEmoticonInfo;
        if (((PicEmoticonInfo)localObject1).emoticon != null)
        {
          localObject2 = (EmoticonManagerServiceProxy)this.mApp.getRuntimeService(IEmoticonManagerService.class);
          if (localObject2 != null)
          {
            localObject2 = ((EmoticonManagerServiceProxy)localObject2).syncFindEmoticonPackageById(((PicEmoticonInfo)localObject1).emoticon.epId);
            if (localObject2 != null) {
              if (((EmoticonPackage)localObject2).subType == 4) {
                this.isDiyEmotion = true;
              } else if (((EmoticonPackage)localObject2).subType == 1) {
                this.isSoundEmotion = true;
              }
            }
          }
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("showPopupEmo, PicEmoticonInfo isDiyEmotion = ");
          ((StringBuilder)localObject2).append(this.isDiyEmotion);
          ((StringBuilder)localObject2).append(" isSoundEmotion = ");
          ((StringBuilder)localObject2).append(this.isSoundEmotion);
          QLog.i("EmotionPanelLinearLayout", 2, ((StringBuilder)localObject2).toString());
        }
        i = (int)(f * 110.0F);
        localObject1 = ((PicEmoticonInfo)localObject1).getLoadingDrawable("fromAIO", true, false, null, i, i);
      }
      else if ((paramEmoticonInfo instanceof FavoriteEmoticonInfo))
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
      if ((paramEmoticonInfo instanceof CameraEmoticonInfo)) {
        this.isSelfieFaceEmotion = true;
      }
      if (localObject1 == null)
      {
        QLog.e("EmotionPanelLinearLayout", 1, "showpoupemo drawable = null");
        return;
      }
      paramView.getGlobalVisibleRect(tmp);
      int i = paramEmoticonInfo.type;
      if ((this.mRootView != null) && (!this.isDiyEmotion) && (!this.isSelfieFaceEmotion) && (((IEmosmService)QRoute.api(IEmosmService.class)).getEmojiStickerSwitch()))
      {
        if (this.mRootView.findViewById(2131374055) != null)
        {
          this.isPreviewShowPoping = true;
          return;
        }
        this.isPreviewShowPoping = false;
        this.mPopupEmo = new StickerFrameLayout(getContext());
        this.mPopupEmo.setId(2131374055);
        this.mPopupEmo.setTag(paramEmoticonInfo);
        this.mPopupEmo.setTag(2131374091, Integer.valueOf(this.panelType));
        this.mPopupEmoImage = new URLImageView(getContext());
        this.mPopupEmoImage.setId(2131362353);
        this.mPopupEmoImage.setAdjustViewBounds(false);
        this.mPopupEmoImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ((Drawable)localObject1).setCallback(this.mPopupEmoImage);
        localObject2 = this.mInteractionListener;
        if (localObject2 != null) {
          localObject2 = ((IPanelInteractionListener)localObject2).getBaseChatPie();
        } else {
          localObject2 = null;
        }
        if (EmoticonUtils.isShowEmoTitleInPreview(localObject2, paramEmoticonInfo))
        {
          addEmoTitleLayout(paramEmoticonInfo, f);
        }
        else
        {
          this.mPopupEmo.addView(this.mPopupEmoImage);
          fillPopEmoLayout(this.mPopupEmo);
          this.mEmoTitleTv = null;
          this.mArrowImageView = null;
        }
        this.mRootView.addView(this.mPopupEmo);
        this.stickerMode = true;
        localObject2 = this.mPopupEmoImage;
        if (localObject2 != null)
        {
          ((URLImageView)localObject2).setRotation(0.0F);
          this.mPopupEmoImage.setScaleX(1.0F);
          this.mPopupEmoImage.setScaleY(1.0F);
        }
        localObject2 = this.mStickerCancel;
        if (localObject2 != null) {
          ((ImageView)localObject2).setVisibility(4);
        }
        localObject2 = this.mStickerConfirm;
        if (localObject2 != null) {
          ((ImageView)localObject2).setVisibility(4);
        }
        this.mWindowContent = null;
        this.showing = false;
        ((IEmosmService)QRoute.api(IEmosmService.class)).setEmojiStickerMode(true);
      }
      else
      {
        if (this.mWindowContent == null)
        {
          this.mWindowContent = new FrameLayout(getContext());
          this.mPopupEmo = new StickerFrameLayout(getContext());
          this.mPopupEmo.setTag(paramEmoticonInfo);
          this.mPopupEmoImage = new URLImageView(getContext());
          this.mPopupEmoImage.setAdjustViewBounds(false);
          this.mPopupEmoImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localObject2 = this.mInteractionListener;
          if (localObject2 != null) {
            localObject2 = ((IPanelInteractionListener)localObject2).getBaseChatPie();
          } else {
            localObject2 = null;
          }
          if (EmoticonUtils.isShowEmoTitleInPreview(localObject2, paramEmoticonInfo))
          {
            addEmoTitleLayout(paramEmoticonInfo, f);
          }
          else
          {
            this.mPopupEmo.addView(this.mPopupEmoImage);
            this.mEmoTitleTv = null;
            this.mArrowImageView = null;
          }
          this.mWindowContent.addView(this.mPopupEmo);
        }
        localObject2 = this.mEmoTitleTv;
        if (localObject2 != null) {
          ((TextView)localObject2).setText(EmoticonUtils.getSystemAndEmojiEmoticonName(paramEmoticonInfo));
        }
      }
      if (this.mPopupEmo == null) {
        return;
      }
      this.mPopupEmoImage.setImageDrawable((Drawable)localObject1);
      int k = (int)(5.0F * f);
      Object localObject3 = (RelativeLayout.LayoutParams)this.mPopupEmoImage.getLayoutParams();
      int j;
      int m;
      if ((i != 1) && (i != 2) && (i != 7) && (i != 10))
      {
        i = (int)(f * 110.0F);
        this.mPopupEmo.setBackgroundResource(2130837975);
        this.mPopupEmo.setPadding(k, k, k, k);
        ((RelativeLayout.LayoutParams)localObject3).bottomMargin = 0;
        j = (int)(100.0F * f);
        ((RelativeLayout.LayoutParams)localObject3).width = j;
        ((RelativeLayout.LayoutParams)localObject3).height = j;
        ReportController.b(null, "CliOper", "", "", "ep_mall", "ep_preview", 0, 0, "", "", "", "");
        j = i;
      }
      else
      {
        localObject2 = this.mInteractionListener;
        if (localObject2 != null) {
          localObject2 = ((IPanelInteractionListener)localObject2).getBaseChatPie();
        } else {
          localObject2 = null;
        }
        if (EmoticonUtils.isShowEmoTitleInPreview(localObject2, paramEmoticonInfo))
        {
          j = (int)(94.0F * f);
          i = (int)(97.0F * f);
          k = (int)(30.0F * f);
          ((RelativeLayout.LayoutParams)localObject3).width = k;
          ((RelativeLayout.LayoutParams)localObject3).height = k;
          if (this.mShowEmoRlyt != null)
          {
            localObject2 = this.mEmoTitleTv;
            if ((localObject2 != null) && (this.mArrowImageView != null))
            {
              ((TextView)localObject2).setVisibility(0);
              this.mArrowImageView.setVisibility(0);
              this.mShowEmoRlyt.setBackgroundResource(2130837966);
              if (QLog.isColorLevel()) {
                QLog.d("EmotionPanelLinearLayout", 4, "emo title is visible");
              }
            }
          }
        }
        else
        {
          j = (int)(64.0F * f);
          i = (int)(71.0F * f);
          m = (int)(28.0F * f);
          ((RelativeLayout.LayoutParams)localObject3).width = m;
          ((RelativeLayout.LayoutParams)localObject3).height = m;
          this.mPopupEmo.setPadding(k, k, k, k);
          this.mPopupEmo.setBackgroundResource(2130837976);
        }
        ((RelativeLayout.LayoutParams)localObject3).bottomMargin = ((int)(6.0F * f));
        ((RelativeLayout.LayoutParams)localObject3).addRule(14);
        ((RelativeLayout.LayoutParams)localObject3).addRule(15);
        k = j;
        j = i;
        i = k;
      }
      if ((this.mRootView != null) && (!this.isDiyEmotion) && (this.stickerMode) && (((IEmosmService)QRoute.api(IEmosmService.class)).getEmojiStickerSwitch()))
      {
        localObject3 = (RelativeLayout.LayoutParams)this.mPopupEmo.getLayoutParams();
        k = tmp.right - i;
        localObject2 = this.mInteractionListener;
        if (localObject2 != null) {
          localObject2 = ((IPanelInteractionListener)localObject2).getBaseChatPie();
        } else {
          localObject2 = null;
        }
        if (EmoticonUtils.isShowEmoTitleInPreview(localObject2, paramEmoticonInfo)) {
          updatePopupEmoLayout(i, (ViewGroup.MarginLayoutParams)localObject3);
        } else if (k < 0) {
          ((RelativeLayout.LayoutParams)localObject3).leftMargin = (tmp.left - (i - tmp.width()) / 2 - k / 2);
        } else {
          ((RelativeLayout.LayoutParams)localObject3).leftMargin = (tmp.left - (i - tmp.width()) / 2);
        }
        ((RelativeLayout.LayoutParams)localObject3).topMargin = (tmp.top - j - (int)(15.0F * f));
        ((RelativeLayout.LayoutParams)localObject3).width = i;
        ((RelativeLayout.LayoutParams)localObject3).height = j;
        updateArrowLayout(paramView, f, i, j, (ViewGroup.MarginLayoutParams)localObject3);
      }
      else
      {
        localObject3 = (FrameLayout.LayoutParams)this.mPopupEmo.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject3).gravity = 51;
        k = tmp.left + i - this.mCurrentView.getWidth();
        m = tmp.right - i;
        localObject2 = this.mInteractionListener;
        if (localObject2 != null) {
          localObject2 = ((IPanelInteractionListener)localObject2).getBaseChatPie();
        } else {
          localObject2 = null;
        }
        if (EmoticonUtils.isShowEmoTitleInPreview(localObject2, paramEmoticonInfo)) {
          updatePopupEmoLayout(i, (ViewGroup.MarginLayoutParams)localObject3);
        } else if (k > 0) {
          ((FrameLayout.LayoutParams)localObject3).leftMargin = (tmp.left - (i - tmp.width()) / 2 - k / 2);
        } else if (m < 0) {
          ((FrameLayout.LayoutParams)localObject3).leftMargin = (tmp.left - (i - tmp.width()) / 2 - m / 2);
        } else {
          ((FrameLayout.LayoutParams)localObject3).leftMargin = (tmp.left - (i - tmp.width()) / 2);
        }
        ((FrameLayout.LayoutParams)localObject3).topMargin = (tmp.top - j - (int)(15.0F * f));
        ((FrameLayout.LayoutParams)localObject3).width = i;
        ((FrameLayout.LayoutParams)localObject3).height = j;
        updateArrowLayout(paramView, f, i, j, (ViewGroup.MarginLayoutParams)localObject3);
      }
      if (this.showing)
      {
        this.mPopupEmo.requestLayout();
      }
      else if (this.mWindowContent != null)
      {
        paramView = (WindowManager)getContext().getSystemService("window");
        i = 40;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          i = 67108904;
        }
        j = i;
        if (Build.VERSION.SDK_INT >= 19) {
          j = i | 0x8000000;
        }
        localObject2 = new WindowManager.LayoutParams(-1, -1, 2, j, -3);
        paramView.addView(this.mWindowContent, (ViewGroup.LayoutParams)localObject2);
        this.haveRemovedWindowContent = false;
        this.showing = true;
      }
      Object localObject2 = this.mPointInfo;
      this.mPointInfo = paramEmoticonInfo;
      if ((localObject2 != null) && (((EmoticonInfo)localObject2).type == 6) && ((localObject2 instanceof PicEmoticonInfo)))
      {
        paramView = this.player;
        if (paramView != null) {
          paramView.c();
        }
      }
      if ((paramEmoticonInfo.type == 6) && (bool) && ((localObject1 instanceof URLDrawable)))
      {
        paramView = (PicEmoticonInfo)paramEmoticonInfo;
        if (paramView.isSound())
        {
          localObject3 = EmotionPanelConstans.emoticonSoundPath.replace("[epId]", paramView.emoticon.epId).replace("[eId]", paramView.emoticon.eId);
          if (this.player == null) {
            this.player = new AudioPlayer(getContext(), null);
          }
          this.player.a(5);
          this.player.a((String)localObject3);
          EmotionUtils.startSoundDrawablePlay((URLDrawable)localObject1);
        }
        if (2 == paramView.emoticon.jobType) {
          ReportController.b(null, "CliOper", "", "", "MbYulan", "MbChangan", 0, 0, paramView.emoticon.epId, "", "", "");
        }
        if (paramView.isNewSoundType())
        {
          if (paramView.emoticon != null) {
            paramView = paramView.emoticon.epId;
          } else {
            paramView = "";
          }
          EmoticonOperateReport.reportNewSoundEvent(null, "0X800A938", -1, paramView);
        }
      }
      if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo))
      {
        paramView = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
        if (MobileQQ.getContext() != null)
        {
          localObject3 = MobileQQ.sMobileQQ.waitAppRuntime(null);
          if ((localObject3 != null) && ((localObject3 instanceof BaseQQAppInterface)))
          {
            localObject3 = (BaseQQAppInterface)localObject3;
            if (com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(paramView.code))
            {
              IPanelInteractionListener localIPanelInteractionListener = this.mInteractionListener;
              if (localIPanelInteractionListener != null) {
                i = localIPanelInteractionListener.getCurType();
              } else {
                i = -1;
              }
              VasVipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "0X800812D", i, 0, new String[] { String.valueOf(paramView.code), String.valueOf(((IApolloManagerService)((BaseQQAppInterface)localObject3).getRuntimeService(IApolloManagerService.class)).getApolloUserStatus()) });
            }
          }
        }
      }
      paramView = this.callback;
      if (paramView != null) {
        paramView.onShowPopup((EmoticonInfo)localObject2, paramEmoticonInfo, (Drawable)localObject1);
      }
      return;
    }
    QLog.e("EmotionPanelLinearLayout", 1, "showpoupemo view or info = null");
  }
  
  public void showStickerMaskOnPanel()
  {
    EmoticonMainPanel localEmoticonMainPanel = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.mInteractionListener);
    if (localEmoticonMainPanel == null) {
      return;
    }
    if (localEmoticonMainPanel.stickerMaskLayout == null)
    {
      localObject = new LinearLayout(getContext());
      ((LinearLayout)localObject).setBackgroundColor(-1);
      ((LinearLayout)localObject).getBackground().setAlpha(0);
      ((LinearLayout)localObject).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      localEmoticonMainPanel.stickerMaskLayout = ((View)localObject);
    }
    if (localEmoticonMainPanel.stickerMaskLayout.getParent() != localEmoticonMainPanel) {
      localEmoticonMainPanel.addView(localEmoticonMainPanel.stickerMaskLayout);
    }
    Object localObject = PropertyValuesHolder.ofInt("alpha", new int[] { 0, 178 });
    ObjectAnimator.ofPropertyValuesHolder(localEmoticonMainPanel.stickerMaskLayout.getBackground(), new PropertyValuesHolder[] { localObject }).setDuration(500L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper
 * JD-Core Version:    0.7.0.1
 */