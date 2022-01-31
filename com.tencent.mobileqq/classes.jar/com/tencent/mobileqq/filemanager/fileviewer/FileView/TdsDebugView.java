package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import alpo;
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
import arcm;
import arcn;
import arco;
import com.tencent.kwstudio.office.debug.Debugger;
import com.tencent.widget.Switch;

@SuppressLint({"ViewConstructor"})
public final class TdsDebugView
  extends FrameLayout
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final String jdField_a_of_type_JavaLangString = alpo.a(2131715120);
  private static final String jdField_b_of_type_JavaLangString = alpo.a(2131715117);
  private static final String jdField_c_of_type_JavaLangString = alpo.a(2131715114);
  private static final String d = alpo.a(2131715115);
  private static final String e = alpo.a(2131715113);
  private static final String f = alpo.a(2131715116);
  private static final String g = alpo.a(2131715119);
  private static final String h = alpo.a(2131715118);
  private static final String i = alpo.a(2131715121);
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final arco jdField_a_of_type_Arco;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  
  public TdsDebugView(Context paramContext, arco paramarco)
  {
    super(paramContext.getApplicationContext());
    this.jdField_a_of_type_Arco = paramarco;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new arcn(this, null));
    paramContext = LayoutInflater.from(paramContext).inflate(2131562702, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131377844));
    paramContext.findViewById(2131364296).setOnClickListener(this);
    paramContext.findViewById(2131367174).setOnClickListener(this);
    paramContext.findViewById(2131379290).setOnClickListener(this);
    paramContext.findViewById(2131364295).setOnClickListener(this);
    paramContext.findViewById(2131364325).setOnClickListener(this);
    paramContext = (Switch)paramContext.findViewById(2131377273);
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
    if (j == 2131364296)
    {
      a(jdField_a_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        Debugger.cleanPlugin("11", new arcm(this, null));
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (j == 2131367174)
          {
            a(Debugger.getVersionInfo("11"));
            return;
          }
          if (j != 2131379290) {
            break;
          }
          a(d);
        } while (this.jdField_b_of_type_Boolean);
        this.jdField_b_of_type_Boolean = true;
        Debugger.upgradePlugin("11", new arcm(this, null));
        return;
        if (j != 2131364295) {
          break;
        }
        a(g);
      } while (this.jdField_c_of_type_Boolean);
      this.jdField_c_of_type_Boolean = true;
      Debugger.cleanCache("11", new arcm(this, null));
      return;
    } while ((j != 2131364325) || (this.jdField_a_of_type_Arco == null));
    this.jdField_a_of_type_Arco.a();
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