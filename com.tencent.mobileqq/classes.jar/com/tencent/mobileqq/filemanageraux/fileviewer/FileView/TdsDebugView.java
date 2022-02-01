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
import anvx;
import aujj;
import aujk;
import aujl;
import com.tencent.kwstudio.office.debug.Debugger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

@SuppressLint({"ViewConstructor"})
public final class TdsDebugView
  extends FrameLayout
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final String jdField_a_of_type_JavaLangString = anvx.a(2131714120);
  private static final String jdField_b_of_type_JavaLangString = anvx.a(2131714117);
  private static final String jdField_c_of_type_JavaLangString = anvx.a(2131714114);
  private static final String d = anvx.a(2131714115);
  private static final String e = anvx.a(2131714113);
  private static final String f = anvx.a(2131714116);
  private static final String g = anvx.a(2131714119);
  private static final String h = anvx.a(2131714118);
  private static final String i = anvx.a(2131714121);
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final aujl jdField_a_of_type_Aujl;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  
  public TdsDebugView(Context paramContext, aujl paramaujl)
  {
    super(paramContext.getApplicationContext());
    this.jdField_a_of_type_Aujl = paramaujl;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new aujk(this, null));
    paramContext = LayoutInflater.from(paramContext).inflate(2131562943, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131378963));
    paramContext.findViewById(2131364660).setOnClickListener(this);
    paramContext.findViewById(2131367699).setOnClickListener(this);
    paramContext.findViewById(2131380519).setOnClickListener(this);
    paramContext.findViewById(2131364659).setOnClickListener(this);
    paramContext.findViewById(2131364699).setOnClickListener(this);
    paramContext = (Switch)paramContext.findViewById(2131378354);
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
    if (j == 2131364660)
    {
      a(jdField_a_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        Debugger.cleanPlugin("11", new aujj(this, null));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (j == 2131367699)
      {
        a(Debugger.getVersionInfo("11"));
      }
      else if (j == 2131380519)
      {
        a(d);
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          Debugger.upgradePlugin("11", new aujj(this, null));
        }
      }
      else if (j == 2131364659)
      {
        a(g);
        if (!this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = true;
          Debugger.cleanCache("11", new aujj(this, null));
        }
      }
      else if ((j == 2131364699) && (this.jdField_a_of_type_Aujl != null))
      {
        this.jdField_a_of_type_Aujl.a();
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