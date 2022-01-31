package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import ajjy;
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
import aosb;
import aosc;
import aosd;
import com.tencent.kwstudio.office.debug.Debugger;
import com.tencent.widget.Switch;

@SuppressLint({"ViewConstructor"})
public final class TdsDebugView
  extends FrameLayout
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final String jdField_a_of_type_JavaLangString = ajjy.a(2131648948);
  private static final String jdField_b_of_type_JavaLangString = ajjy.a(2131648945);
  private static final String jdField_c_of_type_JavaLangString = ajjy.a(2131648942);
  private static final String d = ajjy.a(2131648943);
  private static final String e = ajjy.a(2131648941);
  private static final String f = ajjy.a(2131648944);
  private static final String g = ajjy.a(2131648947);
  private static final String h = ajjy.a(2131648946);
  private static final String i = ajjy.a(2131648949);
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final aosd jdField_a_of_type_Aosd;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  
  public TdsDebugView(Context paramContext, aosd paramaosd)
  {
    super(paramContext.getApplicationContext());
    this.jdField_a_of_type_Aosd = paramaosd;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new aosc(this, null));
    paramContext = LayoutInflater.from(paramContext).inflate(2131496900, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131311502));
    paramContext.findViewById(2131298674).setOnClickListener(this);
    paramContext.findViewById(2131301437).setOnClickListener(this);
    paramContext.findViewById(2131312843).setOnClickListener(this);
    paramContext.findViewById(2131298673).setOnClickListener(this);
    paramContext.findViewById(2131298701).setOnClickListener(this);
    paramContext = (Switch)paramContext.findViewById(2131310950);
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
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j == 2131298674)
    {
      a(jdField_a_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        Debugger.cleanPlugin("11", new aosb(this, null));
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (j == 2131301437)
          {
            a(Debugger.getVersionInfo("11"));
            return;
          }
          if (j != 2131312843) {
            break;
          }
          a(d);
        } while (this.jdField_b_of_type_Boolean);
        this.jdField_b_of_type_Boolean = true;
        Debugger.upgradePlugin("11", new aosb(this, null));
        return;
        if (j != 2131298673) {
          break;
        }
        a(g);
      } while (this.jdField_c_of_type_Boolean);
      this.jdField_c_of_type_Boolean = true;
      Debugger.cleanCache("11", new aosb(this, null));
      return;
    } while ((j != 2131298701) || (this.jdField_a_of_type_Aosd == null));
    this.jdField_a_of_type_Aosd.a();
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0) {
      a("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.TdsDebugView
 * JD-Core Version:    0.7.0.1
 */