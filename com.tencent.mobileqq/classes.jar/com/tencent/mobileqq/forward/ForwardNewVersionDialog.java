package com.tencent.mobileqq.forward;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.devicelib.DeviceLib;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.QQCustomDialogWtihForwardAvatar;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.SoftKeyboardHeight;
import com.tencent.mobileqq.utils.SoftKeyboardHeight.OnGetSoftHeightListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.MaxHeightRelativelayout;
import java.lang.ref.SoftReference;
import mqq.app.AppRuntime;

public class ForwardNewVersionDialog
  extends QQCustomDialogWtihForwardAvatar
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  protected ScrollView a;
  SoftKeyboardHeight.OnGetSoftHeightListener b = new ForwardNewVersionDialog.1(this);
  private MaxHeightRelativelayout c;
  private TextView d;
  private SoftReference<Context> e;
  private View f;
  private EditText g;
  private int h = 7;
  private ImageView i = null;
  private LinearLayout j;
  private IEmoticonMainPanel k = null;
  private Handler l = new Handler();
  private Resources m = null;
  private WindowManager n;
  private WindowManager.LayoutParams o;
  private boolean p;
  private int q;
  private SoftKeyboardHeight r;
  private ForwardNewVersionDialog.ForwardWriteTogetherListener s;
  
  public ForwardNewVersionDialog(@NonNull Context paramContext)
  {
    super(paramContext, 2131953338);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (localLayoutParams != null) {
      localLayoutParams.gravity = 17;
    }
    this.e = new SoftReference(paramContext);
    this.m = paramContext.getResources();
    getWindow().setSoftInputMode(19);
    this.n = ((WindowManager)paramContext.getSystemService("window"));
    this.o = new WindowManager.LayoutParams(-1, SoftKeyboardHeight.a(0), 2, 32, -1);
    paramContext = this.o;
    paramContext.gravity = 81;
    paramContext.windowAnimations = 2131952054;
    setContentView(2131624606);
  }
  
  private void a(Context paramContext)
  {
    paramContext = new ForwardNewVersionDialog.6(this);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool2 = localAppRuntime instanceof QQAppInterface;
    boolean bool1 = true;
    if (bool2)
    {
      int i1 = getContext().getResources().getDimensionPixelSize(2131299920);
      paramContext = ((IEmoticonMainPanelService)((QQAppInterface)localAppRuntime).getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(getContext(), 100003).setCallBack(paramContext);
      if (this.h != 7) {
        bool1 = false;
      }
      this.k = paramContext.setOnlySysAndEmoji(bool1).setToastOffset(i1).create();
      this.k.hideAllTabs();
      this.o.height = this.q;
      return;
    }
    QLog.e("Forward.NewVersion.Dialog", 1, "get QQAppInterface fail");
  }
  
  private int b(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  private void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.f.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = -2;
      this.f.requestLayout();
    }
  }
  
  private boolean c()
  {
    Context localContext = (Context)this.e.get();
    return ((localContext instanceof Activity)) && (((Activity)localContext).isFinishing());
  }
  
  public ForwardNewVersionDialog a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramString);
    this.lBtn.setVisibility(0);
    TextView localTextView = this.lBtn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(getContext().getString(2131888061));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.lBtn.setOnClickListener(new ForwardNewVersionDialog.9(this, paramOnClickListener));
    return this;
  }
  
  public void a()
  {
    Object localObject = this.i.getTag();
    if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 2130840447))
    {
      this.i.setImageResource(2130840446);
      this.i.setTag(Integer.valueOf(2130840446));
      b();
      if (this.p)
      {
        this.p = false;
        this.n.removeView(this.k.getView());
      }
    }
  }
  
  public void a(int paramInt)
  {
    setContentView(paramInt);
  }
  
  public void a(View paramView)
  {
    this.c.addView(paramView);
  }
  
  public void a(ForwardNewVersionDialog.ForwardWriteTogetherListener paramForwardWriteTogetherListener)
  {
    this.s = paramForwardWriteTogetherListener;
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.d.setText(paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    this.title.setText(paramString1);
    this.g.setHint(paramString2);
    a(paramString3, paramOnClickListener2);
    b(paramString4, paramOnClickListener1);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.j.setVisibility(8);
      return;
    }
    this.j.setVisibility(0);
  }
  
  public ForwardNewVersionDialog b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramString);
    TextView localTextView = this.rBtn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(getContext().getString(2131888061));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new ForwardNewVersionDialog.10(this, paramOnClickListener));
    return this;
  }
  
  public void b(int paramInt)
  {
    EditText localEditText = this.g;
    if (localEditText != null)
    {
      localEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      this.g.addTextChangedListener(new ForwardNewVersionDialog.5(this, paramInt));
    }
  }
  
  public void c(int paramInt)
  {
    this.c.setMaxHeight(AIOUtils.b(paramInt, getContext().getResources()));
  }
  
  public EditText getEditText()
  {
    return this.g;
  }
  
  public String getInputValue()
  {
    return this.g.getText().toString();
  }
  
  public void hideSoftInputFromWindow()
  {
    if (this.g != null) {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.g.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView.getId() == 2131432400)
    {
      if (this.k != null) {
        if (this.p)
        {
          b();
          this.n.removeView(this.k.getView());
          this.p = false;
          this.i.setImageResource(2130840446);
          this.i.setTag(Integer.valueOf(2130840446));
          this.l.postDelayed(new ForwardNewVersionDialog.7(this), 200L);
          localObject = getWindow().getAttributes();
          ((WindowManager.LayoutParams)localObject).y = 0;
          getWindow().setAttributes((WindowManager.LayoutParams)localObject);
        }
        else
        {
          localObject = this.i.getTag();
          if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 2130840447))
          {
            InputMethodUtil.a(this.g);
            this.i.setImageResource(2130840446);
            this.i.setTag(Integer.valueOf(2130840446));
            this.p = false;
          }
          else
          {
            InputMethodUtil.b(this.g);
            this.i.setImageResource(2130840447);
            this.i.setTag(Integer.valueOf(2130840447));
            this.k.getView().setMinimumHeight(SoftKeyboardHeight.a(0));
            this.l.postDelayed(new ForwardNewVersionDialog.8(this), 200L);
          }
        }
      }
    }
    else
    {
      if (this.p)
      {
        b();
        this.n.removeView(this.k.getView());
        this.p = false;
        localObject = getWindow().getAttributes();
        ((WindowManager.LayoutParams)localObject).y = 0;
        getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      }
      InputMethodUtil.b(this.g);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.k;
    if (paramDialogInterface != null) {
      paramDialogInterface.onDestory();
    }
    paramDialogInterface = this.r;
    if (paramDialogInterface != null) {
      paramDialogInterface.b();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.p)
    {
      this.n.removeView(this.k.getView());
      this.p = false;
      WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
      localLayoutParams.y = 0;
      getWindow().setAttributes(localLayoutParams);
      b();
    }
    InputMethodUtil.b(this.g);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.c = ((MaxHeightRelativelayout)findViewById(2131444933));
    this.d = ((TextView)findViewById(2131449004));
    this.g = ((EditText)findViewById(2131435808));
    this.i = ((ImageView)findViewById(2131432400));
    this.j = ((LinearLayout)findViewById(2131435825));
    this.f = findViewById(2131431871);
    this.i.setOnClickListener(this);
    this.g.setEditableFactory(QQTextBuilder.getCustomSizeEditableFactory(16));
    this.g.setSingleLine(false);
    this.g.setMaxLines(2);
    b(this.m.getInteger(2131492885));
    this.g.setOnTouchListener(new ForwardNewVersionDialog.2(this));
    Object localObject = (Context)this.e.get();
    if (localObject == null) {
      return;
    }
    DeviceLib.a((Context)localObject, this.g);
    this.r = new SoftKeyboardHeight(((ViewGroup)getWindow().getDecorView().findViewById(16908290)).getChildAt(0), this.n.getDefaultDisplay().getHeight(), this.b);
    this.q = this.r.a();
    this.q = SoftKeyboardHeight.a(this.q);
    setOnDismissListener(this);
    a((Context)localObject);
    this.k.setDispatchKeyEventListener(new ForwardNewVersionDialog.3(this));
    localObject = this.f.findViewById(2131445358);
    if ((localObject instanceof ScrollView)) {
      this.a = ((ScrollView)localObject);
    }
    this.f.getViewTreeObserver().addOnGlobalLayoutListener(new ForwardNewVersionDialog.4(this));
    SimpleModeHelper.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog
 * JD-Core Version:    0.7.0.1
 */