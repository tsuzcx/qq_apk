package com.tencent.mtt.hippy.views.textinput;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.text.TextWatcher;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.common.CommonBackgroundDrawable;
import com.tencent.mtt.hippy.views.common.CommonBorder;
import java.lang.reflect.Field;

public class HippyTextInput
  extends EditText
  implements View.OnFocusChangeListener, TextView.OnEditorActionListener, HippyViewBase, CommonBorder
{
  public boolean bUserSetValue = false;
  ViewTreeObserver.OnGlobalLayoutListener globaListener = new HippyTextInput.1(this);
  private int mDefaultGravityHorizontal;
  private int mDefaultGravityVertical;
  boolean mHasAddWatcher = false;
  boolean mHasSetOnSelectListener = false;
  HippyEngineContext mHippyContext;
  private boolean mIsKeyBoardShow = false;
  private Rect mLastRect = new Rect();
  private int mLastRootViewVisibleHeight = -1;
  private String mPreviousText;
  private CommonBackgroundDrawable mReactBackgroundDrawable;
  private HippyTextInput.ReactContentSizeWatcher mReactContentSizeWatcher = null;
  private Rect mRect = new Rect();
  private boolean mTextInputed = false;
  TextWatcher mTextWatcher = null;
  private String mValidator = "";
  private String sRegrexValidBefore = "";
  private String sRegrexValidRepeat = "";
  
  public HippyTextInput(Context paramContext)
  {
    super(paramContext);
    this.mHippyContext = ((HippyInstanceContext)paramContext).getEngineContext();
    setFocusable(true);
    setFocusableInTouchMode(true);
    setOverScrollMode(1);
    this.mDefaultGravityHorizontal = (getGravity() & 0x800007);
    this.mDefaultGravityVertical = (getGravity() & 0x70);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setPadding(0, 0, 0, 0);
  }
  
  private CommonBackgroundDrawable getOrCreateReactViewBackground()
  {
    if (this.mReactBackgroundDrawable == null)
    {
      this.mReactBackgroundDrawable = new CommonBackgroundDrawable();
      Drawable localDrawable = getBackground();
      super.setBackgroundDrawable(null);
      if (localDrawable == null) {
        super.setBackgroundDrawable(this.mReactBackgroundDrawable);
      } else {
        super.setBackgroundDrawable(new LayerDrawable(new Drawable[] { this.mReactBackgroundDrawable, localDrawable }));
      }
    }
    return this.mReactBackgroundDrawable;
  }
  
  private int getRootViewHeight()
  {
    View localView = getRootView();
    if (localView == null) {
      return -1;
    }
    try
    {
      localView.getWindowVisibleDisplayFrame(this.mRect);
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getWindowVisibleDisplayFrame failed !");
      localStringBuilder.append(localThrowable);
      LogUtils.d("InputMethodStatusMonitor:", localStringBuilder.toString());
      localThrowable.printStackTrace();
    }
    int i = this.mRect.bottom - this.mRect.top;
    if (i < 0) {
      return -1;
    }
    return i;
  }
  
  private int getScreenHeight()
  {
    try
    {
      WindowManager localWindowManager = (WindowManager)ContextHolder.getAppContext().getSystemService("window");
      if (localWindowManager.getDefaultDisplay() != null)
      {
        int i = Math.max(localWindowManager.getDefaultDisplay().getWidth(), localWindowManager.getDefaultDisplay().getHeight());
        return i;
      }
    }
    catch (SecurityException localSecurityException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getScreenHeight: ");
      localStringBuilder.append(localSecurityException.getMessage());
      LogUtils.d("HippyTextInput", localStringBuilder.toString());
    }
    return -1;
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return null;
  }
  
  public InputMethodManager getInputMethodManager()
  {
    return (InputMethodManager)getContext().getSystemService("input_method");
  }
  
  public void hideInputMethod()
  {
    InputMethodManager localInputMethodManager = getInputMethodManager();
    if ((localInputMethodManager != null) && (localInputMethodManager.isActive(this))) {
      try
      {
        localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public HippyMap jsGetValue()
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("text", getText().toString());
    return localHippyMap;
  }
  
  public void jsSetValue(String paramString, int paramInt)
  {
    this.bUserSetValue = true;
    setText(paramString);
    if (paramString != null)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = paramString.length();
      }
      paramInt = i;
      if (i >= paramString.length()) {
        paramInt = paramString.length();
      }
      setSelection(paramInt);
    }
    this.bUserSetValue = false;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((getRootView() != null) && (Build.VERSION.SDK_INT >= 16)) {
      getRootView().getViewTreeObserver().addOnGlobalLayoutListener(this.globaListener);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((getRootView() != null) && (Build.VERSION.SDK_INT >= 16)) {
      getRootView().getViewTreeObserver().removeOnGlobalLayoutListener(this.globaListener);
    }
  }
  
  public void onEditorAction(int paramInt)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("actionCode", paramInt);
    localHippyMap.pushString("text", getText().toString());
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknown";
    }
    for (;;)
    {
      localHippyMap.pushString("actionName", str);
      break;
      str = "previous";
      continue;
      str = "done";
      continue;
      str = "next";
      continue;
      str = "send";
      continue;
      str = "search";
      continue;
      str = "go";
      continue;
      str = "none";
    }
    ((EventDispatcher)this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(getId(), "onEditorAction", localHippyMap);
    super.onEditorAction(paramInt);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (((paramInt & 0xFF) > 0) || (paramInt == 0))
    {
      paramTextView = new HippyMap();
      paramTextView.pushString("text", getText().toString());
      ((EventDispatcher)this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(getId(), "onEndEditing", paramTextView);
    }
    return false;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("text", getText().toString());
    EventDispatcher localEventDispatcher;
    int i;
    if (paramBoolean)
    {
      localEventDispatcher = (EventDispatcher)this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class);
      i = getId();
      paramView = "onFocus";
    }
    else
    {
      localEventDispatcher = (EventDispatcher)this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class);
      i = getId();
      paramView = "onBlur";
    }
    localEventDispatcher.receiveUIComponentEvent(i, paramView, localHippyMap);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    HippyTextInput.ReactContentSizeWatcher localReactContentSizeWatcher = this.mReactContentSizeWatcher;
    if (localReactContentSizeWatcher != null) {
      localReactContentSizeWatcher.onLayout();
    }
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    if (this.mHasSetOnSelectListener)
    {
      HippyMap localHippyMap1 = new HippyMap();
      localHippyMap1.pushInt("start", paramInt1);
      localHippyMap1.pushInt("end", paramInt2);
      HippyMap localHippyMap2 = new HippyMap();
      localHippyMap2.pushMap("selection", localHippyMap1);
      ((EventDispatcher)this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(getId(), "onSelectionChange", localHippyMap2);
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    paramCharSequence = this.mReactContentSizeWatcher;
    if (paramCharSequence != null) {
      paramCharSequence.onLayout();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    int i = getPaddingBottom();
    int j = getPaddingTop();
    int k = getPaddingLeft();
    int m = getPaddingRight();
    if ((paramInt != 0) || (this.mReactBackgroundDrawable != null)) {
      getOrCreateReactViewBackground().setBackgroundColor(paramInt);
    }
    setPadding(k, j, m, i);
  }
  
  public void setBlurOrOnFocus(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setOnFocusChangeListener(this);
      return;
    }
    setOnFocusChangeListener(null);
  }
  
  public void setBorderColor(int paramInt1, int paramInt2)
  {
    getOrCreateReactViewBackground().setBorderColor(paramInt1, paramInt2);
  }
  
  public void setBorderRadius(float paramFloat, int paramInt)
  {
    getOrCreateReactViewBackground().setBorderRadius(paramFloat, paramInt);
  }
  
  public void setBorderStyle(int paramInt) {}
  
  public void setBorderWidth(float paramFloat, int paramInt)
  {
    getOrCreateReactViewBackground().setBorderWidth(paramFloat, paramInt);
  }
  
  public void setCursorColor(int paramInt)
  {
    do
    {
      try
      {
        localObject1 = TextView.class.getDeclaredField("mCursorDrawableRes");
        ((Field)localObject1).setAccessible(true);
        int i = ((Field)localObject1).getInt(this);
        localObject1 = TextView.class.getDeclaredField("mEditor");
        ((Field)localObject1).setAccessible(true);
        localObject3 = ((Field)localObject1).get(this);
        localObject1 = null;
        j = Build.VERSION.SDK_INT;
        if (j >= 21) {
          localObject1 = getContext().getDrawable(i);
        } else if (j >= 16) {
          localObject1 = getContext().getResources().getDrawable(i);
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject1;
        Object localObject3;
        int j;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setCursorColor: ");
        ((StringBuilder)localObject2).append(localThrowable1.getMessage());
        LogUtils.d("HippyTextInput", ((StringBuilder)localObject2).toString());
      }
      ((Drawable)localObject1).setColorFilter(paramInt, PorterDuff.Mode.SRC_IN);
      localObject2 = localObject3.getClass();
      for (;;)
      {
        if (localObject2 != null)
        {
          if (j >= 28) {}
          try
          {
            localField = ((Class)localObject2).getDeclaredField("mDrawableForCursor");
            localField.setAccessible(true);
            localField.set(localObject3, localObject1);
            return;
          }
          catch (Throwable localThrowable2)
          {
            Field localField;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("setCursorColor: ");
            localStringBuilder.append(localThrowable2.getMessage());
            LogUtils.d("HippyTextInput", localStringBuilder.toString());
            localObject2 = ((Class)localObject2).getSuperclass();
          }
          localField = ((Class)localObject2).getDeclaredField("mCursorDrawable");
          localField.setAccessible(true);
          localField.set(localObject3, new Drawable[] { localObject1, localObject1 });
          return;
        }
        else
        {
          return;
        }
      }
    } while (localThrowable1 != null);
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher) {}
  
  void setGravityHorizontal(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = this.mDefaultGravityHorizontal;
    }
    setGravity(i | getGravity() & 0xFFFFFFF8 & 0xFF7FFFF8);
  }
  
  void setGravityVertical(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = this.mDefaultGravityVertical;
    }
    setGravity(i | getGravity() & 0xFFFFFF8F);
  }
  
  public void setOnChangeListener(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mHasAddWatcher) {
        return;
      }
      this.mTextWatcher = new HippyTextInput.2(this);
      this.mHasAddWatcher = true;
      addTextChangedListener(this.mTextWatcher);
      return;
    }
    this.mHasAddWatcher = false;
    removeTextChangedListener(this.mTextWatcher);
  }
  
  public void setOnContentSizeChange(boolean paramBoolean)
  {
    HippyTextInput.ReactContentSizeWatcher localReactContentSizeWatcher;
    if (paramBoolean == true) {
      localReactContentSizeWatcher = new HippyTextInput.ReactContentSizeWatcher(this, this, this.mHippyContext);
    } else {
      localReactContentSizeWatcher = null;
    }
    this.mReactContentSizeWatcher = localReactContentSizeWatcher;
  }
  
  public void setOnEndEditingListener(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setOnEditorActionListener(this);
      return;
    }
    setOnEditorActionListener(null);
  }
  
  public void setOnSelectListener(boolean paramBoolean)
  {
    this.mHasSetOnSelectListener = paramBoolean;
  }
  
  public void setReturnKeyType(String paramString) {}
  
  public void setValidator(String paramString)
  {
    this.mValidator = paramString;
  }
  
  public void showInputMethodManager()
  {
    InputMethodManager localInputMethodManager = getInputMethodManager();
    try
    {
      localInputMethodManager.showSoftInput(this, 0, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.textinput.HippyTextInput
 * JD-Core Version:    0.7.0.1
 */