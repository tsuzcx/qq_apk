package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import alud;
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
import argv;
import argw;
import argx;
import com.tencent.kwstudio.office.debug.Debugger;
import com.tencent.widget.Switch;

@SuppressLint({"ViewConstructor"})
public final class TdsDebugView
  extends FrameLayout
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final String jdField_a_of_type_JavaLangString = alud.a(2131715132);
  private static final String jdField_b_of_type_JavaLangString = alud.a(2131715129);
  private static final String jdField_c_of_type_JavaLangString = alud.a(2131715126);
  private static final String d = alud.a(2131715127);
  private static final String e = alud.a(2131715125);
  private static final String f = alud.a(2131715128);
  private static final String g = alud.a(2131715131);
  private static final String h = alud.a(2131715130);
  private static final String i = alud.a(2131715133);
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final argx jdField_a_of_type_Argx;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  
  public TdsDebugView(Context paramContext, argx paramargx)
  {
    super(paramContext.getApplicationContext());
    this.jdField_a_of_type_Argx = paramargx;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new argw(this, null));
    paramContext = LayoutInflater.from(paramContext).inflate(2131562720, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131377898));
    paramContext.findViewById(2131364298).setOnClickListener(this);
    paramContext.findViewById(2131367184).setOnClickListener(this);
    paramContext.findViewById(2131379348).setOnClickListener(this);
    paramContext.findViewById(2131364297).setOnClickListener(this);
    paramContext.findViewById(2131364327).setOnClickListener(this);
    paramContext = (Switch)paramContext.findViewById(2131377327);
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
    if (j == 2131364298)
    {
      a(jdField_a_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        Debugger.cleanPlugin("11", new argv(this, null));
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (j == 2131367184)
          {
            a(Debugger.getVersionInfo("11"));
            return;
          }
          if (j != 2131379348) {
            break;
          }
          a(d);
        } while (this.jdField_b_of_type_Boolean);
        this.jdField_b_of_type_Boolean = true;
        Debugger.upgradePlugin("11", new argv(this, null));
        return;
        if (j != 2131364297) {
          break;
        }
        a(g);
      } while (this.jdField_c_of_type_Boolean);
      this.jdField_c_of_type_Boolean = true;
      Debugger.cleanCache("11", new argv(this, null));
      return;
    } while ((j != 2131364327) || (this.jdField_a_of_type_Argx == null));
    this.jdField_a_of_type_Argx.a();
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.TdsDebugView
 * JD-Core Version:    0.7.0.1
 */