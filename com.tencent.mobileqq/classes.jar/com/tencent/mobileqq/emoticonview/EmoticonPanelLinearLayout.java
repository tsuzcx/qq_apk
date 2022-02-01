package com.tencent.mobileqq.emoticonview;

import afii;
import afim;
import afiw;
import alnr;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import avsq;
import bcef;
import blvr;
import blvv;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerFrameLayout;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.ae.SessionWrap;
import mqq.app.AppRuntime;

public class EmoticonPanelLinearLayout
  extends LinearLayout
{
  public static int PANEL_TYPE_BIG_EMOTION = 1;
  public static int PANEL_TYPE_CAMERA_EMOTION = 5;
  public static int PANEL_TYPE_FAV_EMOTION = 0;
  public static int PANEL_TYPE_HOTPIC_EMOTION = 6;
  public static int PANEL_TYPE_ROAM = 0;
  public static int PANEL_TYPE_SMALL_EMOTION = 2;
  public static int PANEL_TYPE_SYSTEM_AND_EMOJI = 0;
  public static final String TAG = "EmotionPanelLinearLayout";
  public static Rect tmp = new Rect();
  public int businessType = 0;
  public EmoticonCallback callback;
  Context context;
  public int currentChatPieType;
  float density;
  private int emoType;
  private boolean haveRemovedWindowContent = true;
  boolean isDiyEmotion = false;
  boolean isSelfieFaceEmotion = false;
  boolean isSoundEmotion = false;
  volatile long lastJumpCameraTime = 0L;
  float lastTouchX = 0.0F;
  float lastTouchY = 0.0F;
  private ImageView mArrowImageView;
  private BaseChatPie mBaseChatPie;
  public EmoticonPanelLinearLayout.OnClickListener mClickListener;
  private TextView mEmoTitleTv;
  boolean mHasPerformedLongPress;
  EmoticonPanelLinearLayout.CheckForLongPress mPendingCheckForLongPress;
  private EmoticonInfo mPointInfo;
  View mPointView;
  private EmojiStickerManager.StickerFrameLayout mPopupEmo;
  private URLImageView mPopupEmoImage;
  private ViewGroup mRootView;
  private RelativeLayout mShowEmoRlyt;
  private ImageView mStickerCancel;
  private ImageView mStickerConfirm;
  private FrameLayout mWindowContent;
  private int panelType = -1;
  private AudioPlayer player;
  float screenHeight;
  float screenWidth;
  private boolean showSticker;
  private boolean showing;
  private boolean stickerMode;
  
  static
  {
    PANEL_TYPE_FAV_EMOTION = 3;
    PANEL_TYPE_ROAM = 4;
  }
  
  public EmoticonPanelLinearLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public EmoticonPanelLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public EmoticonPanelLinearLayout(Context paramContext, BaseChatPie paramBaseChatPie, int paramInt)
  {
    super(paramContext);
    init(paramContext);
    this.mBaseChatPie = paramBaseChatPie;
    this.businessType = paramInt;
    if (this.mBaseChatPie != null)
    {
      if (!(paramBaseChatPie instanceof afiw)) {
        break label96;
      }
      this.currentChatPieType = 1;
    }
    for (;;)
    {
      this.mRootView = this.mBaseChatPie.mAIORootView;
      return;
      label96:
      if ((paramBaseChatPie instanceof afii)) {
        this.currentChatPieType = 2;
      } else if ((paramBaseChatPie instanceof afim)) {
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
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131378748);
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
    this.mArrowImageView.setImageDrawable(getResources().getDrawable(2130838032));
    paramEmoticonInfo = new LinearLayout.LayoutParams(ViewUtils.dip2px(18.0F), ViewUtils.dip2px(12.0F));
    paramEmoticonInfo.topMargin = (-ViewUtils.dip2px(9.0F));
    paramEmoticonInfo.gravity = 1;
    localLinearLayout.addView(this.mArrowImageView, paramEmoticonInfo);
  }
  
  private void fillPopEmoLayout(RelativeLayout paramRelativeLayout)
  {
    this.mStickerCancel = new ImageView(getContext());
    this.mStickerCancel.setId(2131362361);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 20.0F), (int)(this.density * 20.0F));
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    paramRelativeLayout.addView(this.mStickerCancel, localLayoutParams);
    this.mStickerCancel.setImageDrawable(getResources().getDrawable(2130847079));
    this.mStickerCancel.setVisibility(4);
    this.mStickerConfirm = new ImageView(getContext());
    this.mStickerConfirm.setId(2131362362);
    localLayoutParams = new RelativeLayout.LayoutParams((int)(this.density * 20.0F), (int)(this.density * 20.0F));
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(12);
    paramRelativeLayout.addView(this.mStickerConfirm, localLayoutParams);
    this.mStickerConfirm.setVisibility(4);
    this.mStickerConfirm.setImageDrawable(getResources().getDrawable(2130848481));
  }
  
  private boolean isInvokeSticker(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4)) > 50.0D;
  }
  
  private boolean needShowPopUpEmo(EmoticonInfo paramEmoticonInfo)
  {
    if (("delete".equals(paramEmoticonInfo.action)) || ("setting".equals(paramEmoticonInfo.action)) || ("add".equals(paramEmoticonInfo.action)) || ("cameraJump".equals(paramEmoticonInfo.action)) || ("cameraEdit".equals(paramEmoticonInfo.action)) || (this.panelType == PANEL_TYPE_HOTPIC_EMOTION)) {}
    do
    {
      return false;
      if (!(paramEmoticonInfo instanceof CameraEmoticonInfo)) {
        break;
      }
      paramEmoticonInfo = (CameraEmoticonInfo)paramEmoticonInfo;
    } while ((paramEmoticonInfo.roamingType.equals("failed")) || (paramEmoticonInfo.roamingType.equals("needUpload")) || (paramEmoticonInfo.roamingType.equals("needDel")));
    return true;
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
  
  private void updatePopupEmoLayout(int paramInt, ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    paramMarginLayoutParams.leftMargin = (tmp.left - (paramInt - tmp.width()) / 2);
    if (paramMarginLayoutParams.leftMargin + paramInt >= ViewUtils.getScreenWidth()) {
      paramMarginLayoutParams.leftMargin = (ViewUtils.getScreenWidth() - paramInt);
    }
    while (paramMarginLayoutParams.leftMargin > 0) {
      return;
    }
    paramMarginLayoutParams.leftMargin = 0;
  }
  
  View findPointChild(float paramFloat1, float paramFloat2)
  {
    int i = super.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = super.getChildAt(i);
      float f1 = super.getScrollX() + paramFloat1 - localView.getLeft();
      float f2 = super.getScrollY() + paramFloat2 - localView.getTop();
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
  
  protected TextView getEmoTitleTv(EmoticonInfo paramEmoticonInfo)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText(EmoticonUtils.getSystemAndEmojiEmoticonName(paramEmoticonInfo));
    localTextView.setId(2131378748);
    if (ThemeUtil.isNowThemeIsNight(this.mBaseChatPie.app, false, null)) {}
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
    if ((this.mRootView != null) && (!this.isDiyEmotion) && (this.stickerMode) && (EmojiStickerManager.e))
    {
      this.mRootView.post(new EmoticonPanelLinearLayout.1(this));
      EmojiStickerManager.b = false;
    }
    while ((this.mPopupEmo == null) || (!this.showing) || (this.mWindowContent == null) || (this.haveRemovedWindowContent)) {
      return;
    }
    this.haveRemovedWindowContent = true;
    ((WindowManager)getContext().getSystemService("window")).removeViewImmediate(this.mWindowContent);
    if (this.player != null) {
      this.player.c();
    }
    if (this.callback != null) {
      this.callback.onHidePopup(this.mPointInfo);
    }
    this.showing = false;
  }
  
  public void init(Context paramContext)
  {
    this.context = paramContext;
    super.setOrientation(0);
    this.density = paramContext.getResources().getDisplayMetrics().density;
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.screenHeight = paramContext.heightPixels;
    this.screenWidth = paramContext.widthPixels;
    super.setClickable(true);
    super.setLongClickable(true);
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
          removeCallbacks(this.mPendingCheckForLongPress);
        }
        if ((this.mPointView != null) && (!this.mHasPerformedLongPress)) {
          performClick(this.mPointView);
        }
        if (!this.showSticker) {
          hidePopupWindow();
        }
        this.mPointView = null;
        if ((this.mRootView != null) && (!this.isDiyEmotion) && (EmojiStickerManager.e))
        {
          this.mRootView.onTouchEvent(paramMotionEvent);
          continue;
          this.lastTouchX = paramMotionEvent.getRawX();
          this.lastTouchY = paramMotionEvent.getRawY();
          this.mHasPerformedLongPress = false;
          this.mPointView = findPointChild(paramMotionEvent.getX(), paramMotionEvent.getY());
          if (this.mPointView != null)
          {
            if (this.mPendingCheckForLongPress == null) {
              this.mPendingCheckForLongPress = new EmoticonPanelLinearLayout.CheckForLongPress(this, paramMotionEvent);
            }
            this.mPendingCheckForLongPress.rememberWindowAttachCount();
            postDelayed(this.mPendingCheckForLongPress, ViewConfiguration.getLongPressTimeout());
            continue;
            super.setPressed(false);
            if (this.mPendingCheckForLongPress != null) {
              removeCallbacks(this.mPendingCheckForLongPress);
            }
            if (!this.showSticker) {
              hidePopupWindow();
            }
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
      if ((EmojiStickerManager.e) && (isInvokeSticker(this.lastTouchX, this.lastTouchY, f1, f2)) && (this.mPopupEmo != null))
      {
        if ((this.showSticker) || (!this.stickerMode)) {
          break label1021;
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
            break label991;
          }
          ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)this.screenHeight - ((RelativeLayout.LayoutParams)localObject1).height - ImmersiveUtils.getStatusBarHeight(getContext()));
        }
        label526:
        if ((this.mEmoTitleTv == null) || (this.mArrowImageView == null) || (this.mShowEmoRlyt == null)) {
          break label1010;
        }
        this.mEmoTitleTv.setVisibility(4);
        this.mArrowImageView.setVisibility(4);
        this.mShowEmoRlyt.setBackgroundResource(0);
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelLinearLayout", 4, "emo title is invisible");
        }
        label586:
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
          localObject1 = this.mBaseChatPie.getAnimContainer();
          if (localObject1 != null) {
            ((AIOAnimationConatiner)localObject1).a();
          }
          localObject1 = this.mBaseChatPie.getEmoPanel();
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
    label817:
    label991:
    label1010:
    label1021:
    do
    {
      do
      {
        if ((this.mRootView != null) && (this.showSticker) && (!this.isDiyEmotion) && (this.stickerMode) && (EmojiStickerManager.e)) {
          this.mRootView.onTouchEvent(paramMotionEvent);
        }
        if (((this.showSticker) || (this.mWindowContent == null)) && (EmojiStickerManager.e)) {
          break;
        }
        if ((!this.mHasPerformedLongPress) || ((getChildRect(this.mPointView, tmp)) && (tmp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))) {
          break label1218;
        }
        this.mPointView = findPointChild(paramMotionEvent.getX(), paramMotionEvent.getY());
        if ((this.mPointView == null) || (this.mPointView.getTag() == null)) {
          break label1211;
        }
        if (!needShowPopUpEmo((EmoticonInfo)this.mPointView.getTag())) {
          break;
        }
        showPopupEmo(this.mPointView, (EmoticonInfo)this.mPointView.getTag());
        break;
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)this.screenHeight - ((RelativeLayout.LayoutParams)localObject1).height);
        break label526;
        this.mPopupEmo.setBackgroundResource(0);
        break label586;
      } while (this.stickerMode);
      localObject1 = (EmoticonInfo)this.mPopupEmo.getTag();
    } while (localObject1 == null);
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
      break label817;
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
          label1211:
          hidePopupWindow();
          break;
          label1218:
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
    Object localObject3;
    Object localObject2;
    Object localObject1;
    do
    {
      return;
      localObject3 = paramView.getTag();
      localObject2 = null;
      localObject1 = localObject2;
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
    } while ((this.mClickListener != null) && (this.mClickListener.shouldInterceptClickEvent(paramView, (EmoticonInfo)localObject1)));
    super.sendAccessibilityEvent(1);
    super.playSoundEffect(0);
    if ((!"delete".equals(((EmoticonInfo)localObject1).action)) && (this.callback != null))
    {
      if ("setting".equals(((EmoticonInfo)localObject1).action)) {
        this.callback.setting();
      }
      for (;;)
      {
        label128:
        if ((paramView instanceof EmoticonImageView))
        {
          paramView = (EmoticonImageView)paramView;
          if (!paramView.isNewIconVisible()) {
            break;
          }
          if ((localObject1 instanceof SystemAndEmojiEmoticonInfo)) {
            ApolloUtil.c(((SystemAndEmojiEmoticonInfo)localObject1).code);
          }
          paramView.setNewIconVisible(false);
          if (EmoticonImageView.isNewIconDisable()) {
            break;
          }
          EmoticonImageView.disableNewIcon(true);
          if (this.mBaseChatPie == null) {
            break;
          }
          paramView = this.mBaseChatPie.getEmoPanel();
          if (paramView == null) {
            break;
          }
          paramView.updateSystemAndEmojiPanel();
          return;
          if ("add".equals(((EmoticonInfo)localObject1).action))
          {
            this.callback.emoticonMall();
            bcef.b(((BaseActivity)this.context).app, "CliOper", "", "", "ep_mall", "0X800579C", 0, 0, "", "", "", "");
          }
          else if ("cameraJump".equals(((EmoticonInfo)localObject1).action))
          {
            long l = System.currentTimeMillis();
            if (l - this.lastJumpCameraTime > 1000L)
            {
              this.lastJumpCameraTime = l;
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("AECAMERA_MODE", 202);
              ((Bundle)localObject2).putInt("VIDEO_STORY_FROM_TYPE", blvr.i.a());
              ((Bundle)localObject2).putParcelable("ARG_SESSION_INFO", new SessionWrap(this.mBaseChatPie.sessionInfo.curFriendUin, this.mBaseChatPie.sessionInfo.curFriendNick, this.mBaseChatPie.sessionInfo.curType, this.mBaseChatPie.sessionInfo.troopUin));
              blvv.a((BaseActivity)this.context, 120, (Bundle)localObject2);
              bcef.b(((BaseActivity)this.context).app, "dc00898", "", "", "0X800A36E", "0X800A36E", 0, 0, "", "", "", "");
              bcef.b(((BaseActivity)this.context).app, "dc00898", "", "", "0x800a570", "0x800a570", 0, 0, "", "", "", "");
            }
          }
          else if ("cameraEdit".equals(((EmoticonInfo)localObject1).action))
          {
            localObject2 = new Intent(this.context, FavEmosmManageActivity.class);
            ((Intent)localObject2).putExtra("camera_emo_mode", 1);
            this.context.startActivity((Intent)localObject2);
            bcef.b(((BaseActivity)this.context).app, "dc00898", "", "", "0X800A36F", "0X800A36F", 0, 0, "", "", "", "");
          }
          else if ("favEdit".equals(((EmoticonInfo)localObject1).action))
          {
            localObject2 = new Intent(this.context, FavEmosmManageActivity.class);
            this.context.startActivity((Intent)localObject2);
            bcef.b(((BaseActivity)this.context).app, "CliOper", "", "", "ep_mall", "0X800579E", 0, 0, "", "", "", "");
          }
          else if ("funny_pic".equals(((EmoticonInfo)localObject1).action))
          {
            if (!"8.4.8".equals("7.3.5")) {
              break label1336;
            }
            localObject2 = this.context.getSharedPreferences("funny_pic_info", 0).edit();
            ((SharedPreferences.Editor)localObject2).putBoolean("group_emo_red_show_sp_key_" + ((BaseActivity)this.context).app.getCurrentAccountUin(), false);
            ((SharedPreferences.Editor)localObject2).apply();
            localObject2 = paramView.findViewById(2131366340);
            if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0)) {
              break label1336;
            }
            ((View)localObject2).setVisibility(8);
          }
        }
      }
    }
    label1336:
    for (int i = 1;; i = 0)
    {
      PublicFragmentActivity.a(this.context, EmoticonGroupStoreFragment.class);
      bcef.b(((BaseActivity)this.context).app, "dc00898", "", "", "0x800a56f", "0x800a56f", 0, 0, "", "", "", "");
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickQLin", "0", 1, 0, i, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break label128;
      if ("push".equals(((EmoticonInfo)localObject1).action))
      {
        if ((this.callback instanceof BaseChatPie)) {
          ((BaseChatPie)this.callback).gotoEmoMallPage(9);
        }
        bcef.b(((BaseActivity)this.context).app, "dc00898", "", "", "0x800a571", "0x800a571", 0, 0, "", "", "", "");
        bcef.b(((BaseActivity)this.context).app, "CliOper", "", "", "ep_mall", "0X800579B", 0, 0, "", "", "", "");
        localObject2 = this.context.getSharedPreferences("mobileQQ", 0);
        localObject3 = ((BaseActivity)this.context).app.getCurrentAccountUin();
        if (!((SharedPreferences)localObject2).getBoolean("magic_promotion_is_new_content_" + (String)localObject3, false)) {
          break;
        }
        ImageView localImageView = (ImageView)paramView.findViewById(2131365977);
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelLinearLayout", 2, "emoticonImg:" + localImageView);
        }
        Object localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.context.getResources().getDrawable(2130847023);
        localObject4 = URLDrawable.getDrawable(((SharedPreferences)localObject2).getString("magic_promotion_imgUrl", ""), (URLDrawable.URLDrawableOptions)localObject4);
        if ((localImageView != null) && (localObject4 != null)) {
          localImageView.setImageDrawable((Drawable)localObject4);
        }
        ((SharedPreferences)localObject2).edit().putBoolean("magic_promotion_is_new_content_" + (String)localObject3, false).apply();
        break label128;
      }
      if ((localObject1 instanceof PicEmoticonInfo))
      {
        localObject2 = (PicEmoticonInfo)localObject1;
        ((PicEmoticonInfo)localObject2).stickerInfo = null;
        localObject3 = ((PicEmoticonInfo)localObject2).emoticon;
        ((avsq)((BaseActivity)this.context).app.getManager(14)).a(((Emoticon)localObject3).epId, this.businessType, new EmoticonPanelLinearLayout.2(this, (Emoticon)localObject3, (EmoticonInfo)localObject1, (PicEmoticonInfo)localObject2));
        break label128;
      }
      this.callback.send((EmoticonInfo)localObject1);
      break label128;
      QLog.e("EmotionPanelLinearLayout", 1, "performclick callback = null");
      break label128;
      break;
      QLog.e("EmotionPanelLinearLayout", 1, "performclick info = null");
      return;
    }
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.callback = paramEmoticonCallback;
  }
  
  public void setPanelType(int paramInt)
  {
    this.panelType = paramInt;
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
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if (((localObject2 instanceof QQAppInterface)) && (((PicEmoticonInfo)localObject1).emoticon != null))
      {
        localObject2 = (avsq)((AppRuntime)localObject2).getManager(14);
        if (localObject2 != null)
        {
          localObject2 = ((avsq)localObject2).a(((PicEmoticonInfo)localObject1).emoticon.epId);
          if (localObject2 != null)
          {
            if (((EmoticonPackage)localObject2).subType != 4) {
              break label248;
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
        break label326;
      }
      QLog.e("EmotionPanelLinearLayout", 1, "showpoupemo drawable = null");
      return;
      label248:
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
    label326:
    paramView.getGlobalVisibleRect(tmp);
    int i = paramEmoticonInfo.type;
    label486:
    int k;
    label577:
    int m;
    int j;
    if ((this.mRootView != null) && (!this.isDiyEmotion) && (!this.isSelfieFaceEmotion) && (EmojiStickerManager.e))
    {
      this.mPopupEmo = new EmojiStickerManager.StickerFrameLayout(getContext());
      this.mPopupEmo.setId(2131373968);
      this.mPopupEmo.setTag(paramEmoticonInfo);
      this.mPopupEmo.setTag(2131374004, Integer.valueOf(this.panelType));
      this.mPopupEmoImage = new URLImageView(getContext());
      this.mPopupEmoImage.setId(2131362363);
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
          break label1504;
        }
        this.mPopupEmoImage.setImageDrawable((Drawable)localObject1);
        k = (int)(5.0F * f);
        localObject2 = (RelativeLayout.LayoutParams)this.mPopupEmoImage.getLayoutParams();
        if ((i != 1) && (i != 2) && (i != 7) && (i != 10)) {
          break label1596;
        }
        if (!EmoticonUtils.isShowEmoTitleInPreview(this.mBaseChatPie, paramEmoticonInfo)) {
          break label1530;
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
              this.mShowEmoRlyt.setBackgroundResource(2130838031);
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
        label790:
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(6.0F * f));
        ((RelativeLayout.LayoutParams)localObject2).addRule(14);
        ((RelativeLayout.LayoutParams)localObject2).addRule(15);
        k = j;
        j = i;
        i = k;
        label827:
        if ((this.mRootView == null) || (this.isDiyEmotion) || (!this.stickerMode) || (!EmojiStickerManager.e)) {
          break label1763;
        }
        localObject2 = (RelativeLayout.LayoutParams)this.mPopupEmo.getLayoutParams();
        k = tmp.right - i;
        if (!EmoticonUtils.isShowEmoTitleInPreview(this.mBaseChatPie, paramEmoticonInfo)) {
          break label1701;
        }
        updatePopupEmoLayout(i, (ViewGroup.MarginLayoutParams)localObject2);
        label896:
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (tmp.top - j - (int)(15.0F * f));
        ((RelativeLayout.LayoutParams)localObject2).width = i;
        ((RelativeLayout.LayoutParams)localObject2).height = j;
        updateArrowLayout(paramView, f, i, j, (ViewGroup.MarginLayoutParams)localObject2);
        if (!this.showing) {
          break label1976;
        }
        this.mPopupEmo.requestLayout();
      }
    }
    label1183:
    label1504:
    label1506:
    label1530:
    while (this.mWindowContent == null)
    {
      localObject2 = this.mPointInfo;
      this.mPointInfo = paramEmoticonInfo;
      if ((localObject2 != null) && (((EmoticonInfo)localObject2).type == 6) && ((localObject2 instanceof PicEmoticonInfo)) && (this.player != null)) {
        this.player.c();
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
          this.player.a((String)localObject3);
          PicEmoticonInfo.startSoundDrawablePlay((URLDrawable)localObject1);
        }
        if (2 == paramView.emoticon.jobType) {
          bcef.b(null, "CliOper", "", "", "MbYulan", "MbChangan", 0, 0, paramView.emoticon.epId, "", "", "");
        }
        if (paramView.isNewSoundType())
        {
          if (paramView.emoticon == null) {
            break label2070;
          }
          paramView = paramView.emoticon.epId;
          avsq.a(null, "0X800A938", -1, paramView);
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
            localObject3 = (QQAppInterface)localObject3;
            if (TextUtils.isApolloEmoticon(paramView.code))
            {
              if ((this.mBaseChatPie == null) || (this.mBaseChatPie.sessionInfo == null)) {
                break label2077;
              }
              i = ApolloUtil.b(this.mBaseChatPie.sessionInfo.curType);
              VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "0X800812D", i, 0, new String[] { String.valueOf(paramView.code), String.valueOf(alnr.a((QQAppInterface)localObject3)) });
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
      break label486;
      if (this.mWindowContent == null)
      {
        this.mWindowContent = new FrameLayout(getContext());
        this.mPopupEmo = new EmojiStickerManager.StickerFrameLayout(getContext());
        this.mPopupEmo.setTag(paramEmoticonInfo);
        this.mPopupEmoImage = new URLImageView(getContext());
        this.mPopupEmoImage.setAdjustViewBounds(false);
        this.mPopupEmoImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if (!EmoticonUtils.isShowEmoTitleInPreview(this.mBaseChatPie, paramEmoticonInfo)) {
          break label1506;
        }
        addEmoTitleLayout(paramEmoticonInfo, f);
      }
      for (;;)
      {
        this.mWindowContent.addView(this.mPopupEmo);
        if (this.mEmoTitleTv == null) {
          break label577;
        }
        this.mEmoTitleTv.setText(EmoticonUtils.getSystemAndEmojiEmoticonName(paramEmoticonInfo));
        break label577;
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
      this.mPopupEmo.setBackgroundResource(2130838041);
      break label790;
      i = (int)(110.0F * f);
      j = (int)(110.0F * f);
      this.mPopupEmo.setBackgroundResource(2130838040);
      this.mPopupEmo.setPadding(k, k, k, k);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
      ((RelativeLayout.LayoutParams)localObject2).width = ((int)(100.0F * f));
      ((RelativeLayout.LayoutParams)localObject2).height = ((int)(100.0F * f));
      bcef.b(null, "CliOper", "", "", "ep_mall", "ep_preview", 0, 0, "", "", "", "");
      break label827;
      if (k < 0)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = (tmp.left - (i - tmp.width()) / 2 - k / 2);
        break label896;
      }
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = (tmp.left - (i - tmp.width()) / 2);
      break label896;
      localObject2 = (FrameLayout.LayoutParams)this.mPopupEmo.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject2).gravity = 51;
      k = tmp.left + i - getWidth();
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
    label1283:
    label1596:
    label1763:
    paramView = (WindowManager)getContext().getSystemService("window");
    label1701:
    label1976:
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
      label2070:
      paramView = "";
      break label1183;
      label2077:
      i = -1;
      break label1283;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout
 * JD-Core Version:    0.7.0.1
 */