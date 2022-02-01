package com.tencent.mobileqq.utils;

import abem;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import bfzd;
import bfzf;
import bjmm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.SoftReference;
import mqq.app.AppRuntime;

public class QQCustomDialogWtihEmoticonInput
  extends QQCustomDialogWtihForwardAvatar
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  private static final String TAG = "QQCustomDialogWtihEmoticonInput";
  EditText inputView;
  private int keyboardHeight;
  private bfzd keyboardHeightProxy;
  int mEmotionType = 1;
  Handler mHandler = new Handler();
  boolean mIsWindowAdded;
  SystemEmoticonPanel mOldViewEmoSpace = null;
  Resources mResources = null;
  RelativeLayout mRoot;
  protected ScrollView mRootScrollView;
  boolean mSingleLine = false;
  ImageView mViewEmoBtn = null;
  EmoticonMainPanel mViewEmoSpace = null;
  WindowManager mWindowManager;
  WindowManager.LayoutParams mWindowParams;
  bfzf softHeightListener = new QQCustomDialogWtihEmoticonInput.1(this);
  SoftReference<Context> softRefContext;
  boolean useAIOStyle = true;
  
  public QQCustomDialogWtihEmoticonInput(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (localLayoutParams != null) {
      localLayoutParams.gravity = 17;
    }
    this.softRefContext = new SoftReference(paramContext);
    this.mResources = paramContext.getResources();
    getWindow().setSoftInputMode(19);
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    boolean bool;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      bool = true;
      this.useAIOStyle = bool;
      if (!this.useAIOStyle) {
        break label194;
      }
    }
    label194:
    for (paramInt = bfzd.a(0);; paramInt = (int)(150.0F * this.mResources.getDisplayMetrics().density))
    {
      this.mWindowParams = new WindowManager.LayoutParams(-1, paramInt, 2, 32, -1);
      this.mWindowParams.gravity = 81;
      this.mWindowParams.windowAnimations = 2131755186;
      return;
      bool = false;
      break;
    }
  }
  
  private boolean isActivityFinishing()
  {
    Context localContext = (Context)this.softRefContext.get();
    return ((localContext instanceof Activity)) && (((Activity)localContext).isFinishing());
  }
  
  private void resetRootViewHeight()
  {
    ViewGroup.LayoutParams localLayoutParams = this.mRoot.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = -2;
      this.mRoot.requestLayout();
    }
  }
  
  void addEmoticonPanel(Context paramContext)
  {
    QQCustomDialogWtihEmoticonInput.7 local7 = new QQCustomDialogWtihEmoticonInput.7(this);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      int i = getContext().getResources().getDimensionPixelSize(2131299076);
      this.mViewEmoSpace = ((EmoticonMainPanel)View.inflate(getContext(), 2131559130, null));
      this.mViewEmoSpace.setCallBack(local7);
      paramContext = this.mViewEmoSpace;
      if (this.mEmotionType == 7) {}
      for (boolean bool = true;; bool = false)
      {
        paramContext.onlySysAndEmoji = bool;
        this.mViewEmoSpace.init((QQAppInterface)localAppRuntime, 100003, getContext(), i, null, null, false);
        this.mViewEmoSpace.hideAllTabs();
        this.mWindowParams.height = this.keyboardHeight;
        return;
      }
    }
    QLog.e("QQCustomDialogWtihEmoticonInput", 1, "get QQAppInterface fail");
    if (this.mEmotionType == 7)
    {
      this.mOldViewEmoSpace = new SystemAndEmojiEmoticonPanel(paramContext, local7);
      return;
    }
    this.mOldViewEmoSpace = new SystemEmoticonPanel(paramContext, local7);
  }
  
  public String getEditString()
  {
    Object localObject;
    if (this.inputView == null) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = this.inputView.getText().toString();
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return this.inputView.getHint().toString();
  }
  
  public EditText getEditText()
  {
    return this.inputView;
  }
  
  public String getInputValue()
  {
    return this.inputView.getText().toString();
  }
  
  public String getPalinText()
  {
    if (this.inputView == null) {
      return "";
    }
    Object localObject;
    if ((this.inputView.getText() instanceof QzoneTextBuilder))
    {
      localObject = (QzoneTextBuilder)this.inputView.getText();
      if (localObject != null) {
        return ((QzoneTextBuilder)localObject).toPlainText();
      }
    }
    else if ((this.inputView.getText() instanceof QQTextBuilder))
    {
      localObject = (QQTextBuilder)this.inputView.getText();
      if (localObject != null) {
        return ((QQTextBuilder)localObject).toPlainText();
      }
    }
    return this.inputView.getEditableText().toString();
  }
  
  int getScreenYin(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  public void hideSoftInputFromWindow()
  {
    if (this.inputView != null) {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.inputView.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if (this.useAIOStyle)
    {
      localObject1 = this.mViewEmoSpace;
      if (paramView.getId() != 2131365953) {
        break label269;
      }
      if (localObject1 != null)
      {
        if (!this.mIsWindowAdded) {
          break label131;
        }
        resetRootViewHeight();
        this.mWindowManager.removeView((View)localObject1);
        this.mIsWindowAdded = false;
        this.mViewEmoBtn.setImageResource(2130840169);
        this.mViewEmoBtn.setTag(Integer.valueOf(2130840169));
        this.mHandler.postDelayed(new QQCustomDialogWtihEmoticonInput.8(this), 200L);
        localObject1 = getWindow().getAttributes();
        ((WindowManager.LayoutParams)localObject1).y = 0;
        getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = this.mOldViewEmoSpace;
      break;
      label131:
      Object localObject2 = this.mViewEmoBtn.getTag();
      if ((localObject2 != null) && ((localObject2 instanceof Integer)) && (((Integer)localObject2).intValue() == 2130840170))
      {
        bjmm.a(this.inputView);
        this.mViewEmoBtn.setImageResource(2130840169);
        this.mViewEmoBtn.setTag(Integer.valueOf(2130840169));
        this.mIsWindowAdded = false;
      }
      else
      {
        bjmm.b(this.inputView);
        this.mViewEmoBtn.setImageResource(2130840170);
        this.mViewEmoBtn.setTag(Integer.valueOf(2130840170));
        if (this.useAIOStyle) {
          ((View)localObject1).setMinimumHeight(bfzd.a(0));
        }
        this.mHandler.postDelayed(new QQCustomDialogWtihEmoticonInput.9(this, (View)localObject1), 200L);
        continue;
        label269:
        if (this.mIsWindowAdded)
        {
          this.mWindowManager.removeView((View)localObject1);
          this.mIsWindowAdded = false;
          resetRootViewHeight();
        }
        localObject1 = getWindow().getAttributes();
        ((WindowManager.LayoutParams)localObject1).y = 0;
        getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
        bjmm.b(this.inputView);
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.mViewEmoSpace != null) {
      this.mViewEmoSpace.onDestory();
    }
    if (this.keyboardHeightProxy != null) {
      this.keyboardHeightProxy.a();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.mIsWindowAdded)
    {
      if (!this.useAIOStyle) {
        break label86;
      }
      this.mWindowManager.removeView(this.mViewEmoSpace);
    }
    for (;;)
    {
      this.mIsWindowAdded = false;
      WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
      localLayoutParams.y = 0;
      getWindow().setAttributes(localLayoutParams);
      resetRootViewHeight();
      bjmm.b(this.inputView);
      super.onTouchEvent(paramMotionEvent);
      return true;
      label86:
      this.mWindowManager.removeView(this.mOldViewEmoSpace);
    }
  }
  
  @TargetApi(11)
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.mRoot = ((RelativeLayout)findViewById(2131365548));
    this.inputView = ((EditText)findViewById(2131368750));
    this.mViewEmoBtn = ((ImageView)findViewById(2131365953));
    this.mViewEmoBtn.setOnClickListener(this);
    findViewById(2131376867).setOnClickListener(this);
    this.inputView.setEditableFactory(QQTextBuilder.EMOTION_INPUT_FACTORY);
    this.inputView.setSingleLine(this.mSingleLine);
    this.inputView.setOnTouchListener(new QQCustomDialogWtihEmoticonInput.2(this));
    Object localObject = (Context)this.softRefContext.get();
    if (localObject == null) {
      return;
    }
    abem.a((Context)localObject, this.inputView);
    if (this.useAIOStyle)
    {
      this.keyboardHeightProxy = new bfzd(((ViewGroup)getWindow().getDecorView().findViewById(16908290)).getChildAt(0), this.mWindowManager.getDefaultDisplay().getHeight(), this.softHeightListener);
      this.keyboardHeight = this.keyboardHeightProxy.a();
      this.keyboardHeight = bfzd.a(this.keyboardHeight);
      setOnDismissListener(this);
      addEmoticonPanel((Context)localObject);
      this.mViewEmoSpace.setDispatchKeyEventListener(new QQCustomDialogWtihEmoticonInput.3(this));
    }
    for (;;)
    {
      localObject = this.mRoot.findViewById(2131376860);
      if ((localObject instanceof ScrollView)) {
        this.mRootScrollView = ((ScrollView)localObject);
      }
      this.mRoot.getViewTreeObserver().addOnGlobalLayoutListener(new QQCustomDialogWtihEmoticonInput.5(this));
      return;
      addEmoticonPanel((Context)localObject);
      this.mOldViewEmoSpace.setBackgroundResource(2130838034);
      this.mOldViewEmoSpace.setMinimumHeight(AIOUtils.dp2px(150.0F, this.mResources));
      this.mOldViewEmoSpace.setDispatchKeyEventListener(new QQCustomDialogWtihEmoticonInput.4(this));
    }
  }
  
  public void setEditLint(String paramString)
  {
    this.inputView.setHint(paramString);
  }
  
  public void setEmoticonType(int paramInt)
  {
    this.mEmotionType = paramInt;
  }
  
  public void setInitInputValue(String paramString)
  {
    if (paramString != null) {
      this.inputView.setText(paramString);
    }
  }
  
  public void setMaxLength(int paramInt)
  {
    if (this.inputView != null)
    {
      this.inputView.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      this.inputView.addTextChangedListener(new QQCustomDialogWtihEmoticonInput.6(this, paramInt));
    }
  }
  
  public QQCustomDialog setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    hideSoftInputFromWindow();
    this.lBtn.setText(paramInt);
    this.lBtn.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131691002));
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new QQCustomDialogWtihEmoticonInput.10(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public QQCustomDialog setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setContentDescription(getContext().getString(paramInt));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new QQCustomDialogWtihEmoticonInput.11(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public QQCustomDialog setPreviewImage(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    int i = paramDrawable.getIntrinsicWidth();
    Object localObject;
    if (paramDrawable.getIntrinsicHeight() > i)
    {
      localObject = ((URLDrawable)paramDrawable).getCurrDrawable();
      if ((localObject instanceof RegionDrawable))
      {
        localObject = ((RegionDrawable)localObject).getBitmap();
        if (localObject != null)
        {
          Matrix localMatrix = new Matrix();
          localMatrix.postScale(0.5F, 0.5F);
          localObject = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), localMatrix, true);
          if (localObject != null)
          {
            localObject = new BitmapDrawable(this.mResources, (Bitmap)localObject);
            ((BitmapDrawable)localObject).setBounds(0, 0, ((BitmapDrawable)localObject).getIntrinsicWidth(), ((BitmapDrawable)localObject).getIntrinsicHeight());
          }
        }
      }
    }
    for (;;)
    {
      if (localObject == null) {
        return super.setPreviewImage(paramDrawable, paramBoolean1, paramInt, paramBoolean2);
      }
      return super.setPreviewImage((Drawable)localObject, paramBoolean1, paramInt, paramBoolean2);
      localObject = null;
    }
  }
  
  public void setQzoneTextBuilder()
  {
    if (this.inputView != null) {
      this.inputView.setEditableFactory(QzoneTextBuilder.EMOCTATION_FACORY);
    }
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    this.mSingleLine = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput
 * JD-Core Version:    0.7.0.1
 */