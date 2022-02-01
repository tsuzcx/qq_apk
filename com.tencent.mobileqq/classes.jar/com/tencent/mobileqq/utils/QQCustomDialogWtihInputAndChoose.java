package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.devicelib.DeviceLib;
import com.tencent.mobileqq.qwallet.widget.MyLinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class QQCustomDialogWtihInputAndChoose
  extends QQCustomDialogWtihForwardAvatar
  implements View.OnClickListener
{
  public static final Integer p = Integer.valueOf(1);
  public static final Integer q = Integer.valueOf(2);
  SoftReference<Context> a;
  boolean b = false;
  EditText c;
  ImageView d;
  MyLinearLayout e;
  Handler f = new Handler();
  WindowManager g;
  WindowManager.LayoutParams h;
  boolean i;
  RelativeLayout j;
  final float k = 267.0F;
  final float l = 45.5F;
  final float m = 39.0F;
  boolean n = true;
  ArrayList<String> o = new ArrayList();
  protected View r;
  protected View.OnClickListener s = new QQCustomDialogWtihInputAndChoose.2(this);
  
  public QQCustomDialogWtihInputAndChoose(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.a = new SoftReference(paramContext);
    getWindow().setSoftInputMode(19);
    this.g = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  public void a()
  {
    if (this.i)
    {
      this.g.removeView(this.e);
      this.i = false;
      WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
      localLayoutParams.y = 0;
      getWindow().setAttributes(localLayoutParams);
    }
  }
  
  public void a(int paramInt)
  {
    EditText localEditText = this.c;
    if (localEditText != null)
    {
      localEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      this.c.addTextChangedListener(new QQCustomDialogWtihInputAndChoose.3(this, paramInt));
    }
  }
  
  void a(Context paramContext)
  {
    this.e = ((MyLinearLayout)View.inflate(paramContext, 2131624629, null));
    this.e.findViewById(2131437279).setOnClickListener(this);
    this.e.setDispatchKeyEventListener(new QQCustomDialogWtihInputAndChoose.4(this));
  }
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      this.c.setText(paramString);
      paramString = this.c;
      paramString.setSelection(paramString.getText().length());
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return;
      }
      this.o = paramArrayList;
      float f1 = getContext().getResources().getDisplayMetrics().density;
      LinearLayout localLinearLayout = (LinearLayout)this.e.findViewById(2131437275);
      localLinearLayout.removeAllViews();
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        View localView = View.inflate(getContext(), 2131624630, null);
        localView.setTag(Integer.valueOf(i1));
        localView.setClickable(true);
        localView.setOnClickListener(this.s);
        ((TextView)localView.findViewById(2131437274)).setText((CharSequence)paramArrayList.get(i1));
        localLinearLayout.addView(localView, new LinearLayout.LayoutParams(-1, (int)(45.5F * f1)));
        i1 += 1;
      }
      if (paramArrayList.size() >= 5) {
        this.h = new WindowManager.LayoutParams(-1, (int)(f1 * 267.0F), 2, 32, -1);
      } else {
        this.h = new WindowManager.LayoutParams(-1, (int)((paramArrayList.size() * 45.5F + 39.0F + 2.0F) * f1), 2, 32, -1);
      }
      this.h.gravity = 81;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public EditText getEditText()
  {
    return this.c;
  }
  
  public String getInputValue()
  {
    return this.c.getText().toString();
  }
  
  public void hideSoftInputFromWindow()
  {
    if (this.c != null) {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.c.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131435823)
    {
      if (this.e != null) {
        if (this.i)
        {
          a();
          this.d.setImageResource(2130849197);
          this.d.setTag(Integer.valueOf(2130849197));
          this.f.postDelayed(new QQCustomDialogWtihInputAndChoose.5(this), 200L);
        }
        else
        {
          Object localObject = this.d.getTag();
          if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 2130849799))
          {
            InputMethodUtil.a(this.c);
            this.d.setImageResource(2130849197);
            this.d.setTag(Integer.valueOf(2130849197));
            this.i = false;
          }
          else
          {
            InputMethodUtil.b(this.c);
            this.d.setImageResource(2130849799);
            this.d.setTag(Integer.valueOf(2130849799));
            this.f.postDelayed(new QQCustomDialogWtihInputAndChoose.6(this), 200L);
          }
        }
      }
    }
    else if (paramView.getId() == 2131437279)
    {
      a();
    }
    else
    {
      a();
      InputMethodUtil.b(this.c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    a();
    InputMethodUtil.b(this.c);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  @TargetApi(11)
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.j = ((RelativeLayout)findViewById(2131431871));
    this.c = ((EditText)findViewById(2131435808));
    this.d = ((ImageView)findViewById(2131435823));
    this.d.setOnClickListener(this);
    findViewById(2131445367).setOnClickListener(this);
    this.c.setSingleLine(this.b);
    this.c.setOnTouchListener(new QQCustomDialogWtihInputAndChoose.1(this));
    Context localContext = (Context)this.a.get();
    if (localContext == null) {
      return;
    }
    DeviceLib.a(localContext, this.c);
    a(localContext);
  }
  
  public void setEditLint(String paramString)
  {
    this.c.setHint(paramString);
  }
  
  public QQCustomDialog setMessage(CharSequence paramCharSequence)
  {
    TextView localTextView = (TextView)findViewById(2131431851);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      localTextView.setText(paramCharSequence);
      localTextView.setContentDescription(paramCharSequence);
      localTextView.setVisibility(0);
      return this;
    }
    localTextView.setVisibility(8);
    return this;
  }
  
  public QQCustomDialog setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramInt);
    TextView localTextView = this.lBtn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getContext().getString(paramInt));
    localStringBuilder.append(getContext().getString(2131888061));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new QQCustomDialogWtihInputAndChoose.7(this, paramOnClickListener));
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
    this.rBtn.setOnClickListener(new QQCustomDialogWtihInputAndChoose.8(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose
 * JD-Core Version:    0.7.0.1
 */