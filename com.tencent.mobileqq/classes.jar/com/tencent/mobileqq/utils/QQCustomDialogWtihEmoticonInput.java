package com.tencent.mobileqq.utils;

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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.devicelib.DeviceLib;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import java.lang.ref.SoftReference;
import mqq.app.AppRuntime;

public class QQCustomDialogWtihEmoticonInput
  extends QQCustomDialogWtihForwardAvatar
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  private int a;
  private SoftKeyboardHeight b;
  SoftReference<Context> k;
  EditText l;
  boolean m;
  boolean n;
  int o;
  ImageView p;
  SystemEmoticonPanel q;
  IEmoticonMainPanel r;
  Handler s;
  Resources t;
  WindowManager u;
  WindowManager.LayoutParams v;
  boolean w;
  RelativeLayout x;
  protected ScrollView y;
  SoftKeyboardHeight.OnGetSoftHeightListener z;
  
  public QQCustomDialogWtihEmoticonInput(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    boolean bool = true;
    this.m = true;
    this.n = false;
    this.o = 1;
    this.p = null;
    this.q = null;
    this.r = null;
    this.s = new Handler();
    this.t = null;
    this.z = new QQCustomDialogWtihEmoticonInput.1(this);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (localLayoutParams != null) {
      localLayoutParams.gravity = 17;
    }
    this.k = new SoftReference(paramContext);
    this.t = paramContext.getResources();
    getWindow().setSoftInputMode(19);
    this.u = ((WindowManager)paramContext.getSystemService("window"));
    if (BaseApplicationImpl.sProcessId != 1) {
      bool = false;
    }
    this.m = bool;
    if (this.m) {
      paramInt = SoftKeyboardHeight.a(0);
    } else {
      paramInt = (int)(this.t.getDisplayMetrics().density * 150.0F);
    }
    this.v = new WindowManager.LayoutParams(-1, paramInt, 2, 32, -1);
    paramContext = this.v;
    paramContext.gravity = 81;
    paramContext.windowAnimations = 2131952054;
  }
  
  private void a()
  {
    ViewGroup.LayoutParams localLayoutParams = this.x.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = -2;
      this.x.requestLayout();
    }
  }
  
  private boolean e()
  {
    Context localContext = (Context)this.k.get();
    return ((localContext instanceof Activity)) && (((Activity)localContext).isFinishing());
  }
  
  int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  void a(Context paramContext)
  {
    QQCustomDialogWtihEmoticonInput.7 local7 = new QQCustomDialogWtihEmoticonInput.7(this);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool2 = localAppRuntime instanceof QQAppInterface;
    boolean bool1 = true;
    if (bool2)
    {
      int i = getContext().getResources().getDimensionPixelSize(2131299920);
      paramContext = ((IEmoticonMainPanelService)((QQAppInterface)localAppRuntime).getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(getContext(), 100003).setCallBack(local7);
      if (this.o != 7) {
        bool1 = false;
      }
      this.r = paramContext.setOnlySysAndEmoji(bool1).setToastOffset(i).create();
      this.r.hideAllTabs();
      this.v.height = this.a;
      return;
    }
    QLog.e("QQCustomDialogWtihEmoticonInput", 1, "get QQAppInterface fail");
    if (this.o == 7)
    {
      this.q = new SystemAndEmojiEmoticonPanel(paramContext, local7);
      return;
    }
    this.q = new SystemEmoticonPanel(paramContext, local7);
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void b()
  {
    EditText localEditText = this.l;
    if (localEditText != null) {
      localEditText.setEditableFactory(QzoneTextBuilder.a);
    }
  }
  
  public void b(int paramInt)
  {
    this.o = paramInt;
  }
  
  public String c()
  {
    Object localObject = this.l;
    if (localObject == null) {
      return "";
    }
    if ((((EditText)localObject).getText() instanceof QzoneTextBuilder))
    {
      localObject = (QzoneTextBuilder)this.l.getText();
      if (localObject != null) {
        return ((QzoneTextBuilder)localObject).toPlainText();
      }
    }
    else if ((this.l.getText() instanceof QQTextBuilder))
    {
      localObject = (QQTextBuilder)this.l.getText();
      if (localObject != null) {
        return ((QQTextBuilder)localObject).toPlainText();
      }
    }
    return this.l.getEditableText().toString();
  }
  
  public void c(int paramInt)
  {
    EditText localEditText = this.l;
    if (localEditText != null)
    {
      localEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      this.l.addTextChangedListener(new QQCustomDialogWtihEmoticonInput.6(this, paramInt));
    }
  }
  
  public void d(String paramString)
  {
    if (paramString != null) {
      this.l.setText(paramString);
    }
  }
  
  public String getEditString()
  {
    Object localObject = this.l;
    if (localObject == null) {
      return null;
    }
    String str = ((EditText)localObject).getText().toString();
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.l.getHint().toString();
    }
    return localObject;
  }
  
  public EditText getEditText()
  {
    return this.l;
  }
  
  public String getInputValue()
  {
    return this.l.getText().toString();
  }
  
  public void hideSoftInputFromWindow()
  {
    if (this.l != null) {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.l.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if (this.m) {
      localObject1 = this.r.getView();
    } else {
      localObject1 = this.q;
    }
    if (paramView.getId() == 2131432400)
    {
      if (localObject1 != null) {
        if (this.w)
        {
          a();
          this.u.removeView((View)localObject1);
          this.w = false;
          this.p.setImageResource(2130840446);
          this.p.setTag(Integer.valueOf(2130840446));
          this.s.postDelayed(new QQCustomDialogWtihEmoticonInput.8(this), 200L);
          localObject1 = getWindow().getAttributes();
          ((WindowManager.LayoutParams)localObject1).y = 0;
          getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
        }
        else
        {
          Object localObject2 = this.p.getTag();
          if ((localObject2 != null) && ((localObject2 instanceof Integer)) && (((Integer)localObject2).intValue() == 2130840447))
          {
            InputMethodUtil.a(this.l);
            this.p.setImageResource(2130840446);
            this.p.setTag(Integer.valueOf(2130840446));
            this.w = false;
          }
          else
          {
            InputMethodUtil.b(this.l);
            this.p.setImageResource(2130840447);
            this.p.setTag(Integer.valueOf(2130840447));
            if (this.m) {
              ((View)localObject1).setMinimumHeight(SoftKeyboardHeight.a(0));
            }
            this.s.postDelayed(new QQCustomDialogWtihEmoticonInput.9(this, (View)localObject1), 200L);
          }
        }
      }
    }
    else
    {
      if (this.w)
      {
        this.u.removeView((View)localObject1);
        this.w = false;
        a();
      }
      localObject1 = getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject1).y = 0;
      getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
      InputMethodUtil.b(this.l);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.r;
    if (paramDialogInterface != null) {
      paramDialogInterface.onDestory();
    }
    paramDialogInterface = this.b;
    if (paramDialogInterface != null) {
      paramDialogInterface.b();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.w)
    {
      if (this.m) {
        this.u.removeView(this.r.getView());
      } else {
        this.u.removeView(this.q);
      }
      this.w = false;
      WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
      localLayoutParams.y = 0;
      getWindow().setAttributes(localLayoutParams);
      a();
    }
    InputMethodUtil.b(this.l);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  @TargetApi(11)
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.x = ((RelativeLayout)findViewById(2131431871));
    this.l = ((EditText)findViewById(2131435808));
    this.p = ((ImageView)findViewById(2131432400));
    this.p.setOnClickListener(this);
    findViewById(2131445367).setOnClickListener(this);
    this.l.setEditableFactory(QQTextBuilder.EMOTION_INPUT_FACTORY);
    this.l.setSingleLine(this.n);
    this.l.setOnTouchListener(new QQCustomDialogWtihEmoticonInput.2(this));
    Object localObject = (Context)this.k.get();
    if (localObject == null) {
      return;
    }
    DeviceLib.a((Context)localObject, this.l);
    if (this.m)
    {
      this.b = new SoftKeyboardHeight(((ViewGroup)getWindow().getDecorView().findViewById(16908290)).getChildAt(0), this.u.getDefaultDisplay().getHeight(), this.z);
      this.a = this.b.a();
      this.a = SoftKeyboardHeight.a(this.a);
      setOnDismissListener(this);
      a((Context)localObject);
      this.r.setDispatchKeyEventListener(new QQCustomDialogWtihEmoticonInput.3(this));
    }
    else
    {
      a((Context)localObject);
      this.q.setBackgroundResource(2130837993);
      this.q.setMinimumHeight(AIOUtils.b(150.0F, this.t));
      this.q.setDispatchKeyEventListener(new QQCustomDialogWtihEmoticonInput.4(this));
    }
    localObject = this.x.findViewById(2131445358);
    if ((localObject instanceof ScrollView)) {
      this.y = ((ScrollView)localObject);
    }
    this.x.getViewTreeObserver().addOnGlobalLayoutListener(new QQCustomDialogWtihEmoticonInput.5(this));
  }
  
  public void setEditLint(String paramString)
  {
    this.l.setHint(paramString);
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
    TextView localTextView = this.lBtn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getContext().getString(paramInt));
    localStringBuilder.append(getContext().getString(2131888061));
    localTextView.setContentDescription(localStringBuilder.toString());
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
            localObject = new BitmapDrawable(this.t, (Bitmap)localObject);
            ((BitmapDrawable)localObject).setBounds(0, 0, ((BitmapDrawable)localObject).getIntrinsicWidth(), ((BitmapDrawable)localObject).getIntrinsicHeight());
            break label133;
          }
        }
      }
    }
    Object localObject = null;
    label133:
    if (localObject == null) {
      return super.setPreviewImage(paramDrawable, paramBoolean1, paramInt, paramBoolean2);
    }
    return super.setPreviewImage((Drawable)localObject, paramBoolean1, paramInt, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput
 * JD-Core Version:    0.7.0.1
 */