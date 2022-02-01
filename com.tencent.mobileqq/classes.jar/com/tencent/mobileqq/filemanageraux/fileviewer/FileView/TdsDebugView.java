package com.tencent.mobileqq.filemanageraux.fileviewer.FileView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import anzj;
import ausu;
import ausv;
import ausw;
import com.tencent.kwstudio.office.debug.Debugger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

@SuppressLint({"ViewConstructor"})
public final class TdsDebugView
  extends FrameLayout
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final String jdField_a_of_type_JavaLangString = anzj.a(2131713541);
  private static final String jdField_b_of_type_JavaLangString = anzj.a(2131713538);
  private static final String jdField_c_of_type_JavaLangString = anzj.a(2131713535);
  private static final String d = anzj.a(2131713536);
  private static final String e = anzj.a(2131713534);
  private static final String f = anzj.a(2131713537);
  private static final String g = anzj.a(2131713540);
  private static final String h = anzj.a(2131713539);
  private static final String i = anzj.a(2131713542);
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final ausw jdField_a_of_type_Ausw;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  
  public TdsDebugView(Context paramContext, ausw paramausw)
  {
    super(paramContext.getApplicationContext());
    this.jdField_a_of_type_Ausw = paramausw;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new ausv(this, null));
    paramContext = LayoutInflater.from(paramContext).inflate(2131562993, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131378898));
    paramContext.findViewById(2131364557).setOnClickListener(this);
    paramContext.findViewById(2131367538).setOnClickListener(this);
    paramContext.findViewById(2131380460).setOnClickListener(this);
    paramContext.findViewById(2131364556).setOnClickListener(this);
    paramContext.findViewById(2131364584).setOnClickListener(this);
    paramContext = (Switch)paramContext.findViewById(2131378297);
    paramContext.setOnCheckedChangeListener(this);
    paramContext.setChecked(Debugger.isUserEnable("11"));
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!TextUtils.equals(paramString, "11")) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
    } while (getVisibility() != 0);
    if (paramInt == 0) {}
    for (paramString = jdField_b_of_type_JavaLangString;; paramString = jdField_c_of_type_JavaLangString + paramInt)
    {
      a(paramString);
      return;
    }
  }
  
  public static boolean a(String paramString)
  {
    return (TextUtils.equals(paramString, "TdsDebug.xlsx")) && (TdsReaderGlobal.a());
  }
  
  private void b(String paramString, int paramInt)
  {
    if (!TextUtils.equals(paramString, "11")) {}
    do
    {
      return;
      this.jdField_b_of_type_Boolean = false;
    } while (getVisibility() != 0);
    if (paramInt == 0) {}
    for (paramString = e;; paramString = f + paramInt)
    {
      a(paramString);
      return;
    }
  }
  
  private void c(String paramString, int paramInt)
  {
    if (!TextUtils.equals(paramString, "11")) {}
    do
    {
      return;
      this.jdField_c_of_type_Boolean = false;
    } while (getVisibility() != 0);
    if (paramInt == 0) {}
    for (paramString = h;; paramString = i + paramInt)
    {
      a(paramString);
      return;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Debugger.setUserEnable("11", paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j == 2131364557)
    {
      a(jdField_a_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        Debugger.cleanPlugin("11", new ausu(this, null));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (j == 2131367538)
      {
        a(Debugger.getVersionInfo("11"));
      }
      else if (j == 2131380460)
      {
        a(d);
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          Debugger.upgradePlugin("11", new ausu(this, null));
        }
      }
      else if (j == 2131364556)
      {
        a(g);
        if (!this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = true;
          Debugger.cleanCache("11", new ausu(this, null));
        }
      }
      else if ((j == 2131364584) && (this.jdField_a_of_type_Ausw != null))
      {
        this.jdField_a_of_type_Ausw.a();
      }
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0) {
      a("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsDebugView
 * JD-Core Version:    0.7.0.1
 */