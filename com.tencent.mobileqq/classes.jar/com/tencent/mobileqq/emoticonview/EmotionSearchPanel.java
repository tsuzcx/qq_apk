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
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class EmotionSearchPanel
  extends RelativeLayout
  implements View.OnClickListener
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
  QQAppInterface app;
  BaseChatPie chatPie;
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
  boolean isClearWord = false;
  boolean isDestory = false;
  private boolean isExitNeedSearch;
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
    EmoticonPanelHotPicSearchHelper localEmoticonPanelHotPicSearchHelper = (EmoticonPanelHotPicSearchHelper)this.chatPie.getEmoPanel().getEmoController().getHelper(7);
    if (this.isExitNeedSearch)
    {
      localEmoticonPanelHotPicSearchHelper.setSearchWords(this.emotionInput.getText().toString());
      localEmoticonPanelHotPicSearchHelper.setNeedPullUp(true);
    }
    localEmoticonPanelHotPicSearchHelper.setSearchContainerVisibility(4);
    this.chatPie.showEmoticonPanel(12);
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
      this.exitWidth = paramInt2;
      if ((this.exitWidth <= 0) || (isNeedDoCenterMove(false))) {
        this.exitWidth = ((int)this.screenWidth - this.halfcCancelBtnWidth);
      }
      if (!isNeedDoCenterMove(false))
      {
        setSearchInputLeftMargin(0);
        setSearchInputRootWidth(this.exitWidth);
      }
      this.searchRootStartBottomMargin = (ScreenUtil.dip2px(10.0F) + paramInt1);
      if (keyboardHeight <= 0) {
        break label235;
      }
      paramString = (EmoticonPanelExtendHelper)this.chatPie.getEmoPanel().getEmoController().getHelper(1);
    }
    label235:
    for (this.upAndDownDistance = (keyboardHeight - paramString.getOriginPanelHeight());; this.upAndDownDistance = (paramInt3 - ScreenUtil.dip2px(12.0F)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchPanel", 2, "init initAnimStartParam =" + this.upAndDownDistance + " exitWidth =" + this.exitWidth);
      }
      return;
      this.hasWord = false;
      this.searchCleanImg.setVisibility(8);
      break;
    }
  }
  
  private void initView()
  {
    this.emotionInput = ((EditText)findViewById(2131366137));
    this.emotionCancelBtn = ((TextView)findViewById(2131366136));
    this.emotionSearchRoot = ((RelativeLayout)findViewById(2131366138));
    this.emotionSearchBar = ((RelativeLayout)findViewById(2131366135));
    this.maskBtmView = findViewById(2131370790);
    this.maskBtmView.setBackgroundColor(getContext().getResources().getColor(2131165637));
    this.emotionSearchBar.setBackgroundColor(getContext().getResources().getColor(2131165637));
    this.emotionInputAnimLayout = ((RelativeLayout)findViewById(2131366124));
    this.searchCleanImg = ((ImageView)findViewById(2131369534));
    this.searchCleanImg.setOnClickListener(this);
    this.mask = ((FrameLayout)findViewById(2131370784));
    this.emotionCancelBtn.setOnClickListener(this);
    this.mask.setOnClickListener(this);
    this.decorView = ((Activity)getContext()).getWindow().getDecorView();
    this.emotionInput.setBackgroundDrawable(getShapeDrawable(18));
    this.emotionInputAnimLayout.setBackgroundDrawable(getShapeDrawable(18));
    if (ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
      this.emotionInput.setTextColor(Color.parseColor("#B0B3BF"));
    }
    for (;;)
    {
      this.emotionInput.setOnEditorActionListener(new EmotionSearchPanel.1(this));
      this.emotionInput.addTextChangedListener(new EmotionSearchPanel.2(this));
      return;
      this.emotionInput.setTextColor(Color.parseColor("#03081A"));
    }
  }
  
  private boolean isNeedDoCenterMove(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((!this.hasWord) && (!this.isExitNeedSearch)) {}
    }
    else {
      while ((this.hasWord) || (this.isClearWord)) {
        return false;
      }
    }
    return true;
  }
  
  private void onExitAnimEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, "onExitAnimEnd");
    }
    this.chatPie.setEmotionSearchPanelVisible(false, 0, false, null, 0);
    EmoticonPanelHotPicSearchHelper localEmoticonPanelHotPicSearchHelper = (EmoticonPanelHotPicSearchHelper)this.chatPie.getEmoPanel().getEmoController().getHelper(7);
    if (this.isExitNeedSearch)
    {
      this.isExitNeedSearch = false;
      localEmoticonPanelHotPicSearchHelper.startSearch(this.emotionInput.getText().toString());
    }
    this.emotionInput.setText("");
  }
  
  private void removeGlobalistener()
  {
    if (this.decorView != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.decorView.getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
      }
    }
    else {
      return;
    }
    this.decorView.getViewTreeObserver().removeGlobalOnLayoutListener(this.onGlobalLayoutListener);
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
      ((EmoticonPanelHotPicSearchHelper)this.chatPie.getEmoPanel().getEmoController().getHelper(7)).setSearchContainerVisibility(0);
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
    if (this.emotionSearchPanelWindow != null) {
      this.emotionSearchPanelWindow.dismiss();
    }
  }
  
  protected Drawable getShapeDrawable(int paramInt)
  {
    if (ThemeUtil.isNowThemeIsNight(this.app, false, null)) {}
    for (String str = "#1C1C1C";; str = "#F5F6FA") {
      return ViewUtils.getShapeDrawable(Color.parseColor(str), ViewUtils.dip2px(paramInt));
    }
  }
  
  public void init(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, int paramInt3, EmoticonPanelHotPicSearchHelper paramEmoticonPanelHotPicSearchHelper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, "init start searchRootStartBottomMargin=" + this.searchRootStartBottomMargin + " upDis=" + paramInt2 + " width=" + paramInt3 + " hasWord=" + this.hasWord + " keyboardHeight= " + keyboardHeight);
    }
    setEmotionStatus(1);
    this.chatPie = paramBaseChatPie;
    this.app = paramQQAppInterface;
    this.isClearWord = paramBoolean;
    initView();
    if (paramBoolean)
    {
      paramString = "";
      this.emotionInput.setText("");
    }
    initAnimStartParam(paramString, paramInt1, paramInt3, paramInt2);
    this.helper = paramEmoticonPanelHotPicSearchHelper;
    startEntryAinm();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      reportCancel(1);
      this.isExitNeedSearch = false;
      doExit();
      continue;
      reportCancel(2);
      this.isExitNeedSearch = false;
      doExit();
      continue;
      this.emotionInput.setText("");
      this.searchCleanImg.setVisibility(8);
    }
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
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchPanel", 2, new Object[] { "showEmotionSearchWindow,height ", Integer.valueOf(this.emotionSearchPanelWindow.getHeight()) });
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmotionSearchPanel", 2, localThrowable, new Object[0]);
    }
  }
  
  public void startEntryAinm()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchPanel", 2, "startEntryAinm =" + this.upAndDownDistance);
    }
    if (this.emotionSearchBar.getMeasuredHeight() == 0) {
      this.emotionSearchBar.measure(0, 0);
    }
    int j = this.emotionSearchBar.getMeasuredHeight();
    Object localObject = (EmoticonPanelExtendHelper)this.chatPie.getEmoPanel().getEmoController().getHelper(1);
    int i;
    if (((EmoticonPanelExtendHelper)localObject).isPanelOpen()) {
      if ((keyboardHeight > 0) && (Math.abs(keyboardHeight - ((EmoticonPanelExtendHelper)localObject).getOriginPanelHeight()) > 1))
      {
        i = 0;
        i = -((EmoticonPanelExtendHelper)localObject).getMaxHeightSubNormalHeight(i) + j;
      }
    }
    for (;;)
    {
      localObject = ValueAnimator.ofInt(new int[] { 0, i });
      ((ValueAnimator)localObject).setDuration(200L);
      ((ValueAnimator)localObject).setInterpolator(new LinearInterpolator());
      ((ValueAnimator)localObject).addUpdateListener(new EmotionSearchPanel.6(this));
      ((ValueAnimator)localObject).addListener(new EmotionSearchPanel.7(this));
      ((ValueAnimator)localObject).start();
      if (isNeedDoCenterMove(false)) {
        startEnterLeftReduceAnim();
      }
      return;
      i = keyboardHeight;
      break;
      if (keyboardHeight <= 0) {
        i = this.upAndDownDistance;
      } else {
        i = ScreenUtil.dip2px(3.5F) + j;
      }
    }
  }
  
  public void startExitAinm()
  {
    Object localObject = (EmoticonPanelExtendHelper)this.chatPie.getEmoPanel().getEmoController().getHelper(1);
    int j = this.emotionSearchBar.getMeasuredHeight();
    int i;
    if (this.isExitNeedSearch) {
      if ((keyboardHeight > 0) && (Math.abs(keyboardHeight - ((EmoticonPanelExtendHelper)localObject).getOriginPanelHeight()) > 1))
      {
        i = 0;
        i = ((EmoticonPanelExtendHelper)localObject).getMaxHeightSubNormalHeight(i) - j;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchPanel", 2, "startExitAinm isExitNeedSearch =" + this.isExitNeedSearch + " upDis=" + i + " upAndDownDistance=" + this.upAndDownDistance);
      }
      localObject = ValueAnimator.ofInt(new int[] { 0, i });
      ((ValueAnimator)localObject).setDuration(200L);
      ((ValueAnimator)localObject).setInterpolator(new LinearInterpolator());
      ((ValueAnimator)localObject).addUpdateListener(new EmotionSearchPanel.8(this));
      ((ValueAnimator)localObject).addListener(new EmotionSearchPanel.9(this));
      ((ValueAnimator)localObject).start();
      if (this.upAndDownDistance < 0) {
        ((EmoticonPanelHotPicSearchHelper)this.chatPie.getEmoPanel().getEmoController().getHelper(7)).setSearchContainerVisibility(4);
      }
      if (isNeedDoCenterMove(true)) {
        startExitRightIncreaseAnim();
      }
      return;
      i = keyboardHeight;
      break;
      if (keyboardHeight <= 0) {
        i = ((EmoticonPanelExtendHelper)localObject).getOriginPanelHeight() + j;
      } else {
        i = ScreenUtil.dip2px(3.5F) + j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionSearchPanel
 * JD-Core Version:    0.7.0.1
 */