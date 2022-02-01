package com.tencent.mobileqq.emoticonview;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.emosm.IEmoticonPanelHotPicSearchHelper;
import com.tencent.mobileqq.emosm.IEmotionSearchPanel;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class EmotionSearchPanel
  extends RelativeLayout
  implements View.OnClickListener, IEmotionSearchPanel
{
  private static final int ENTER_EXIT_ANIM_DRAUTION = 200;
  static final float EXIT_ANIM_CRITICAL_SHOW_SEARHCONTAINER = 0.99F;
  private static final float MASK_MAX_ALPHA = 0.71F;
  public static final int STATE_EXIT = 3;
  public static final int STATE_INIT = 1;
  public static final int STATE_NONE = 0;
  public static final int STATE_SOFT_PANEL_SHOW = 2;
  private static final String TAG = "EmotionSearchPanel";
  public static int keyboardHeight;
  BaseAIOContext aioContext;
  BaseQQAppInterface app;
  View decorView;
  TextView emotionCancelBtn;
  EditText emotionInput;
  RelativeLayout emotionInputAnimLayout;
  int emotionPanelState = 0;
  RelativeLayout emotionSearchBar;
  PopupWindow emotionSearchPanelWindow;
  RelativeLayout emotionSearchRoot;
  int exitWidth;
  private int halfcCancelBtnWidth = ScreenUtil.dip2px(60.0F) / 2;
  boolean hasSetVisisble = false;
  boolean hasWord = false;
  EmoticonPanelHotPicSearchHelper helper;
  IPanelInteractionListener interactionListener;
  boolean isClearWord = false;
  boolean isDestory = false;
  private boolean isExitNeedSearch = false;
  boolean isVisiableForLast = false;
  FrameLayout mask;
  View maskBtmView;
  ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = null;
  float screenWidth;
  ImageView searchCleanImg;
  private int searchRootStartBottomMargin;
  private int upAndDownDistance;
  
  public EmotionSearchPanel(Context paramContext)
  {
    super(paramContext, null);
  }
  
  public EmotionSearchPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public EmotionSearchPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void doExit()
  {
    setEmotionStatus(3);
    if (!this.isVisiableForLast) {
      startExitAinm();
    }
    hideSoftInput();
    Object localObject = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
    if (localObject != null)
    {
      localObject = (EmoticonPanelHotPicSearchHelper)((EmoticonMainPanel)localObject).getEmoController().getHelper(7);
      if (this.isExitNeedSearch)
      {
        ((EmoticonPanelHotPicSearchHelper)localObject).setSearchWords(this.emotionInput.getText().toString());
        ((EmoticonPanelHotPicSearchHelper)localObject).setNeedPullUp(true);
      }
      ((EmoticonPanelHotPicSearchHelper)localObject).setSearchContainerVisibility(4);
    }
    ((IEmosmService)QRoute.api(IEmosmService.class)).showEmoticonPanel(this.aioContext, 12);
  }
  
  private int getBgColor()
  {
    if (needSkin()) {
      return getContext().getResources().getColor(2131166015);
    }
    return -1;
  }
  
  private int getEnterTextAnimStartPos()
  {
    return this.exitWidth / 2 - getHalfInputTextLen() - ScreenUtil.dip2px(24.0F);
  }
  
  private int getExitTextAnimEndPos()
  {
    return this.exitWidth / 2 - getHalfInputTextLen();
  }
  
  private int getHalfInputTextLen()
  {
    Object localObject2 = this.emotionInput.getText().toString();
    Object localObject1 = localObject2;
    if (StringUtil.isEmpty((String)localObject2)) {
      localObject1 = this.emotionInput.getHint().toString();
    }
    localObject2 = new Rect();
    this.emotionInput.getPaint().getTextBounds((String)localObject1, 0, ((String)localObject1).length(), (Rect)localObject2);
    return ((Rect)localObject2).width() / 2;
  }
  
  private void hideSoftInput()
  {
    if ((getContext() != null) && (this.emotionInput != null))
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.hideSoftInputFromWindow(this.emotionInput.getWindowToken(), 0);
        if (QLog.isColorLevel()) {
          QLog.d("EmotionSearchPanel", 2, new Object[] { "hideSoftInput, ", this.emotionInput.getWindowToken() });
        }
      }
    }
  }
  
  private void initAnimStartParam(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.screenWidth = ScreenUtil.getRealWidth(getContext());
    this.hasSetVisisble = false;
    this.isExitNeedSearch = false;
    this.isDestory = false;
    if (!StringUtil.isEmpty(paramString))
    {
      this.emotionInput.setText(paramString);
      this.emotionInput.setSelection(paramString.length());
      this.hasWord = true;
      this.searchCleanImg.setVisibility(0);
    }
    else
    {
      this.hasWord = false;
      this.searchCleanImg.setVisibility(8);
    }
    this.exitWidth = paramInt2;
    if ((this.exitWidth <= 0) || (isNeedDoCenterMove(false))) {
      this.exitWidth = ((int)this.screenWidth - this.halfcCancelBtnWidth);
    }
    if (!isNeedDoCenterMove(false))
    {
      setSearchInputLeftMargin(0);
      setSearchInputRootWidth(this.exitWidth);
    }
    this.searchRootStartBottomMargin = (paramInt1 + ScreenUtil.dip2px(10.0F));
    if (keyboardHeight > 0)
    {
      paramString = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
      if (paramString != null)
      {
        paramString = (EmoticonPanelExtendHelper)paramString.getEmoController().getHelper(1);
        this.upAndDownDistance = (keyboardHeight - paramString.getOriginPanelHeight());
      }
    }
    else
    {
      this.upAndDownDistance = (paramInt3 - ScreenUtil.dip2px(12.0F));
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("init initAnimStartParam =");
      paramString.append(this.upAndDownDistance);
      paramString.append(" exitWidth =");
      paramString.append(this.exitWidth);
      QLog.d("EmotionSearchPanel", 2, paramString.toString());
    }
  }
  
  private void initView()
  {
    this.emotionInput = ((EditText)findViewById(2131432485));
    this.emotionCancelBtn = ((TextView)findViewById(2131432484));
    this.emotionSearchRoot = ((RelativeLayout)findViewById(2131432486));
    this.emotionSearchBar = ((RelativeLayout)findViewById(2131432483));
    this.maskBtmView = findViewById(2131437982);
    this.maskBtmView.setBackgroundColor(getBgColor());
    this.emotionSearchBar.setBackgroundColor(getBgColor());
    this.emotionInputAnimLayout = ((RelativeLayout)findViewById(2131432472));
    this.searchCleanImg = ((ImageView)findViewById(2131436558));
    this.searchCleanImg.setOnClickListener(this);
    this.mask = ((FrameLayout)findViewById(2131437976));
    this.emotionCancelBtn.setOnClickListener(this);
    this.mask.setOnClickListener(this);
    this.decorView = ((Activity)getContext()).getWindow().getDecorView();
    this.emotionInput.setBackgroundDrawable(getShapeDrawable(18));
    this.emotionInputAnimLayout.setBackgroundDrawable(getShapeDrawable(18));
    if ((needSkin()) && (ThemeUtil.isNowThemeIsNight(this.app, false, null))) {
      this.emotionInput.setTextColor(Color.parseColor("#B0B3BF"));
    } else {
      this.emotionInput.setTextColor(Color.parseColor("#03081A"));
    }
    this.emotionInput.setOnEditorActionListener(new EmotionSearchPanel.1(this));
    this.emotionInput.addTextChangedListener(new EmotionSearchPanel.2(this));
    if ((this.interactionListener != null) && (((IGuildTempApi)QRoute.api(IGuildTempApi.class)).checkChatPie(this.interactionListener.getBaseChatPie())))
    {
      this.emotionInput.setBackgroundDrawable(ViewUtils.getShapeDrawable(Color.parseColor("#2F3033"), ViewUtils.dip2px(18.0F)));
      this.emotionInput.setHintTextColor(Color.parseColor("#C1C1C1"));
      this.maskBtmView.setBackgroundColor(Color.parseColor("#18191C"));
    }
  }
  
  private boolean isNeedDoCenterMove(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.hasWord) || (this.isExitNeedSearch)) {
        return false;
      }
    }
    else
    {
      if (this.hasWord) {
        break label38;
      }
      if (this.isClearWord) {
        return false;
      }
    }
    return true;
    label38:
    return false;
  }
  
  private void onExitAnimEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, "onExitAnimEnd");
    }
    ((IEmosmService)QRoute.api(IEmosmService.class)).setEmotionSearchPanelVisible(this.aioContext, false, 0, false, null, 0);
    Object localObject = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
    if (localObject != null)
    {
      localObject = (EmoticonPanelHotPicSearchHelper)((EmoticonMainPanel)localObject).getEmoController().getHelper(7);
      if (this.isExitNeedSearch)
      {
        this.isExitNeedSearch = false;
        ((EmoticonPanelHotPicSearchHelper)localObject).startSearch(this.emotionInput.getText().toString());
      }
    }
    this.emotionInput.setText("");
  }
  
  private void removeGlobalistener()
  {
    if (this.decorView != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.decorView.getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        return;
      }
      this.decorView.getViewTreeObserver().removeGlobalOnLayoutListener(this.onGlobalLayoutListener);
    }
  }
  
  private void reportCancel(int paramInt)
  {
    if (StringUtil.isEmpty(this.emotionInput.getText().toString()))
    {
      EmoticonUtils.report("0X800AE27", paramInt);
      return;
    }
    EmoticonUtils.report("0X800AE29", paramInt);
  }
  
  private void setSearchBarBottomMargin(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.emotionSearchBar.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, paramInt);
    this.emotionSearchBar.setLayoutParams(localLayoutParams);
  }
  
  private void setSearchContainerVisiable(float paramFloat)
  {
    if ((paramFloat > 0.99F) && (!this.hasSetVisisble))
    {
      this.hasSetVisisble = true;
      EmoticonMainPanel localEmoticonMainPanel = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
      if (localEmoticonMainPanel != null) {
        ((EmoticonPanelHotPicSearchHelper)localEmoticonMainPanel.getEmoController().getHelper(7)).setSearchContainerVisibility(0);
      }
    }
  }
  
  private void setSearchInputLeftMargin(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.emotionInput.getLayoutParams();
    localLayoutParams.leftMargin = paramInt;
    this.emotionInput.setLayoutParams(localLayoutParams);
  }
  
  private void setSearchInputRootWidth(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.emotionInputAnimLayout.getLayoutParams();
    localLayoutParams.width = paramInt;
    this.emotionInputAnimLayout.setLayoutParams(localLayoutParams);
  }
  
  private void startEnterLeftReduceAnim()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    int i = getEnterTextAnimStartPos();
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new EmotionSearchPanel.3(this, i));
    setSearchInputLeftMargin(i);
    localValueAnimator.start();
  }
  
  private void startExitRightIncreaseAnim()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    int i = this.emotionInput.getWidth();
    int j = ScreenUtil.dip2px(27.0F);
    int k = this.exitWidth;
    int m = getExitTextAnimEndPos();
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new EmotionSearchPanel.4(this, i, k - i, m - j));
    localValueAnimator.addListener(new EmotionSearchPanel.5(this));
    localValueAnimator.start();
  }
  
  public void addOnSoftKeyBoardVisibleListener()
  {
    this.onGlobalLayoutListener = new EmotionSearchPanel.10(this);
    this.decorView.getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, new Object[] { "setEmotionStatus,dispatchKeyEvent code=", Integer.valueOf(paramKeyEvent.getKeyCode()) });
    }
    if (paramKeyEvent.getKeyCode() == 4) {
      doExit();
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void dissmissEmotionSearchWinow()
  {
    PopupWindow localPopupWindow = this.emotionSearchPanelWindow;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
  }
  
  protected Drawable getShapeDrawable(int paramInt)
  {
    String str;
    if ((needSkin()) && (ThemeUtil.isNowThemeIsNight(this.app, false, null))) {
      str = "#1C1C1C";
    } else {
      str = "#F5F6FA";
    }
    return ViewUtils.getShapeDrawable(Color.parseColor(str), ViewUtils.dip2px(paramInt));
  }
  
  public void init(BaseQQAppInterface paramBaseQQAppInterface, IPanelInteractionListener paramIPanelInteractionListener, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, int paramInt3, IEmoticonPanelHotPicSearchHelper paramIEmoticonPanelHotPicSearchHelper)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init start searchRootStartBottomMargin=");
      localStringBuilder.append(this.searchRootStartBottomMargin);
      localStringBuilder.append(" upDis=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" width=");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" hasWord=");
      localStringBuilder.append(this.hasWord);
      localStringBuilder.append(" keyboardHeight= ");
      localStringBuilder.append(keyboardHeight);
      QLog.d("EmotionSearchPanel", 2, localStringBuilder.toString());
    }
    setEmotionStatus(1);
    this.interactionListener = paramIPanelInteractionListener;
    this.aioContext = paramIPanelInteractionListener.getAIOContext();
    this.app = paramBaseQQAppInterface;
    this.isClearWord = paramBoolean;
    initView();
    if (paramBoolean)
    {
      paramString = "";
      this.emotionInput.setText("");
    }
    initAnimStartParam(paramString, paramInt1, paramInt3, paramInt2);
    this.helper = ((EmoticonPanelHotPicSearchHelper)paramIEmoticonPanelHotPicSearchHelper);
    startEntryAinm();
  }
  
  protected boolean needSkin()
  {
    BaseAIOContext localBaseAIOContext = this.aioContext;
    if (localBaseAIOContext == null) {
      return true;
    }
    return localBaseAIOContext.O().a != 10014;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131432484)
    {
      reportCancel(1);
      this.isExitNeedSearch = false;
      doExit();
    }
    else if (i == 2131437976)
    {
      reportCancel(2);
      this.isExitNeedSearch = false;
      doExit();
    }
    else if (i == 2131436558)
    {
      this.emotionInput.setText("");
      this.searchCleanImg.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestory()
  {
    this.isDestory = true;
    removeGlobalistener();
    dissmissEmotionSearchWinow();
    setEmotionStatus(0);
  }
  
  void setEmotionStatus(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, new Object[] { "setEmotionStatus,status ", Integer.valueOf(paramInt) });
    }
    this.emotionPanelState = paramInt;
  }
  
  public void showEmotionSearchWindow()
  {
    if (this.emotionSearchPanelWindow == null) {
      this.emotionSearchPanelWindow = new PopupWindow(this, -1, -1);
    }
    this.emotionSearchPanelWindow.setFocusable(true);
    this.emotionSearchPanelWindow.setSoftInputMode(16);
    try
    {
      if (Build.VERSION.SDK_INT >= 22) {
        this.emotionSearchPanelWindow.setAttachedInDecor(false);
      }
      this.emotionSearchPanelWindow.setClippingEnabled(false);
      this.emotionSearchPanelWindow.showAtLocation(this, 0, 0, 0);
      if (QLog.isColorLevel())
      {
        QLog.d("EmotionSearchPanel", 2, new Object[] { "showEmotionSearchWindow,height ", Integer.valueOf(this.emotionSearchPanelWindow.getHeight()) });
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmotionSearchPanel", 2, localThrowable, new Object[0]);
      }
    }
  }
  
  public void startEntryAinm()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startEntryAinm =");
      ((StringBuilder)localObject).append(this.upAndDownDistance);
      QLog.d("EmotionSearchPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (this.emotionSearchBar.getMeasuredHeight() == 0) {
      this.emotionSearchBar.measure(0, 0);
    }
    Object localObject = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
    if (localObject == null) {
      return;
    }
    int j = this.emotionSearchBar.getMeasuredHeight();
    localObject = (EmoticonPanelExtendHelper)((EmoticonMainPanel)localObject).getEmoController().getHelper(1);
    int i;
    if (((EmoticonPanelExtendHelper)localObject).isPanelOpen())
    {
      i = keyboardHeight;
      if ((i > 0) && (Math.abs(i - ((EmoticonPanelExtendHelper)localObject).getOriginPanelHeight()) > 1)) {
        i = 0;
      } else {
        i = keyboardHeight;
      }
      i = -((EmoticonPanelExtendHelper)localObject).getMaxHeightSubNormalHeight(i) + j;
    }
    else if (keyboardHeight <= 0)
    {
      i = this.upAndDownDistance;
    }
    else
    {
      i = ScreenUtil.dip2px(3.5F) + j;
    }
    localObject = ValueAnimator.ofInt(new int[] { 0, i });
    ((ValueAnimator)localObject).setDuration(200L);
    ((ValueAnimator)localObject).setInterpolator(new LinearInterpolator());
    ((ValueAnimator)localObject).addUpdateListener(new EmotionSearchPanel.6(this));
    ((ValueAnimator)localObject).addListener(new EmotionSearchPanel.7(this));
    ((ValueAnimator)localObject).start();
    if (isNeedDoCenterMove(false)) {
      startEnterLeftReduceAnim();
    }
  }
  
  public void startExitAinm()
  {
    EmoticonMainPanel localEmoticonMainPanel = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(this.interactionListener);
    if (localEmoticonMainPanel == null) {
      return;
    }
    Object localObject = (EmoticonPanelExtendHelper)localEmoticonMainPanel.getEmoController().getHelper(1);
    int j = this.emotionSearchBar.getMeasuredHeight();
    int i;
    if (this.isExitNeedSearch)
    {
      i = keyboardHeight;
      if ((i > 0) && (Math.abs(i - ((EmoticonPanelExtendHelper)localObject).getOriginPanelHeight()) > 1)) {
        i = 0;
      } else {
        i = keyboardHeight;
      }
      i = ((EmoticonPanelExtendHelper)localObject).getMaxHeightSubNormalHeight(i) - j;
    }
    else if (keyboardHeight <= 0)
    {
      i = ((EmoticonPanelExtendHelper)localObject).getOriginPanelHeight() + j;
    }
    else
    {
      i = ScreenUtil.dip2px(3.5F) + j;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startExitAinm isExitNeedSearch =");
      ((StringBuilder)localObject).append(this.isExitNeedSearch);
      ((StringBuilder)localObject).append(" upDis=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" upAndDownDistance=");
      ((StringBuilder)localObject).append(this.upAndDownDistance);
      QLog.d("EmotionSearchPanel", 2, ((StringBuilder)localObject).toString());
    }
    localObject = ValueAnimator.ofInt(new int[] { 0, i });
    ((ValueAnimator)localObject).setDuration(200L);
    ((ValueAnimator)localObject).setInterpolator(new LinearInterpolator());
    ((ValueAnimator)localObject).addUpdateListener(new EmotionSearchPanel.8(this));
    ((ValueAnimator)localObject).addListener(new EmotionSearchPanel.9(this));
    ((ValueAnimator)localObject).start();
    if (this.upAndDownDistance < 0) {
      ((EmoticonPanelHotPicSearchHelper)localEmoticonMainPanel.getEmoController().getHelper(7)).setSearchContainerVisibility(4);
    }
    if (isNeedDoCenterMove(true)) {
      startExitRightIncreaseAnim();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionSearchPanel
 * JD-Core Version:    0.7.0.1
 */