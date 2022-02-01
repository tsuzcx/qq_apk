package com.tencent.mobileqq.filemanageraux.fileviewer.FileView;

import amtj;
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
import atfc;
import atfd;
import atfe;
import com.tencent.kwstudio.office.debug.Debugger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

@SuppressLint({"ViewConstructor"})
public final class TdsDebugView
  extends FrameLayout
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final String jdField_a_of_type_JavaLangString = amtj.a(2131713773);
  private static final String jdField_b_of_type_JavaLangString = amtj.a(2131713770);
  private static final String jdField_c_of_type_JavaLangString = amtj.a(2131713767);
  private static final String d = amtj.a(2131713768);
  private static final String e = amtj.a(2131713766);
  private static final String f = amtj.a(2131713769);
  private static final String g = amtj.a(2131713772);
  private static final String h = amtj.a(2131713771);
  private static final String i = amtj.a(2131713774);
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final atfe jdField_a_of_type_Atfe;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  
  public TdsDebugView(Context paramContext, atfe paramatfe)
  {
    super(paramContext.getApplicationContext());
    this.jdField_a_of_type_Atfe = paramatfe;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new atfd(this, null));
    paramContext = LayoutInflater.from(paramContext).inflate(2131562872, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131378669));
    paramContext.findViewById(2131364578).setOnClickListener(this);
    paramContext.findViewById(2131367567).setOnClickListener(this);
    paramContext.findViewById(2131380184).setOnClickListener(this);
    paramContext.findViewById(2131364577).setOnClickListener(this);
    paramContext.findViewById(2131364615).setOnClickListener(this);
    paramContext = (Switch)paramContext.findViewById(2131378066);
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
    if (j == 2131364578)
    {
      a(jdField_a_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        Debugger.cleanPlugin("11", new atfc(this, null));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (j == 2131367567)
      {
        a(Debugger.getVersionInfo("11"));
      }
      else if (j == 2131380184)
      {
        a(d);
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          Debugger.upgradePlugin("11", new atfc(this, null));
        }
      }
      else if (j == 2131364577)
      {
        a(g);
        if (!this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = true;
          Debugger.cleanCache("11", new atfc(this, null));
        }
      }
      else if ((j == 2131364615) && (this.jdField_a_of_type_Atfe != null))
      {
        this.jdField_a_of_type_Atfe.a();
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