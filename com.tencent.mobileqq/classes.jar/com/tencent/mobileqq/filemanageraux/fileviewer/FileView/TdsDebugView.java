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
import com.tencent.kwstudio.office.debug.Debugger;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

@SuppressLint({"ViewConstructor"})
public final class TdsDebugView
  extends FrameLayout
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131714616);
  private static final String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131714613);
  private static final String jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131714610);
  private static final String d = HardCodeUtil.a(2131714611);
  private static final String e = HardCodeUtil.a(2131714609);
  private static final String f = HardCodeUtil.a(2131714612);
  private static final String g = HardCodeUtil.a(2131714615);
  private static final String h = HardCodeUtil.a(2131714614);
  private static final String i = HardCodeUtil.a(2131714617);
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final TdsDebugView.OnCloseListener jdField_a_of_type_ComTencentMobileqqFilemanagerauxFileviewerFileViewTdsDebugView$OnCloseListener;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  
  public TdsDebugView(Context paramContext, TdsDebugView.OnCloseListener paramOnCloseListener)
  {
    super(paramContext.getApplicationContext());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxFileviewerFileViewTdsDebugView$OnCloseListener = paramOnCloseListener;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new TdsDebugView.InnerCallback(this, null));
    paramContext = LayoutInflater.from(paramContext).inflate(2131563094, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131379394));
    paramContext.findViewById(2131364774).setOnClickListener(this);
    paramContext.findViewById(2131367906).setOnClickListener(this);
    paramContext.findViewById(2131380965).setOnClickListener(this);
    paramContext.findViewById(2131364773).setOnClickListener(this);
    paramContext.findViewById(2131364815).setOnClickListener(this);
    paramContext = (Switch)paramContext.findViewById(2131378781);
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
    if (j == 2131364774)
    {
      a(jdField_a_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        Debugger.cleanPlugin("11", new TdsDebugView.CallbackImpl(this, null));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (j == 2131367906)
      {
        a(Debugger.getVersionInfo("11"));
      }
      else if (j == 2131380965)
      {
        a(d);
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          Debugger.upgradePlugin("11", new TdsDebugView.CallbackImpl(this, null));
        }
      }
      else if (j == 2131364773)
      {
        a(g);
        if (!this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = true;
          Debugger.cleanCache("11", new TdsDebugView.CallbackImpl(this, null));
        }
      }
      else if ((j == 2131364815) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxFileviewerFileViewTdsDebugView$OnCloseListener != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxFileviewerFileViewTdsDebugView$OnCloseListener.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsDebugView
 * JD-Core Version:    0.7.0.1
 */