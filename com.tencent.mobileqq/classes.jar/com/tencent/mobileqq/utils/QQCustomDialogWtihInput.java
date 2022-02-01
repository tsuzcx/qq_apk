package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.widget.ClearableEditText;
import java.lang.ref.SoftReference;
import java.util.Timer;

public class QQCustomDialogWtihInput
  extends QQCustomDialog
{
  private SoftReference<Context> a;
  private ClearableEditText b;
  private TextWatcher c = null;
  private long d;
  
  public QQCustomDialogWtihInput(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.a = new SoftReference(paramContext);
  }
  
  private boolean b()
  {
    if ("VIVO".equalsIgnoreCase(Build.MANUFACTURER))
    {
      if ((Build.MODEL.toUpperCase().contains("Y8")) || (Build.MODEL.toUpperCase().contains("V18"))) {
        return true;
      }
    }
    else if (("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.MODEL.toUpperCase().contains("VOG-AL10"))) {
      return true;
    }
    return false;
  }
  
  public EditText a()
  {
    return this.b;
  }
  
  public void a(TextWatcher paramTextWatcher)
  {
    if (paramTextWatcher != null)
    {
      this.c = paramTextWatcher;
      this.b.addTextChangedListener(paramTextWatcher);
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.b.setText(paramString);
    }
  }
  
  public String getInputValue()
  {
    return this.b.getText().toString();
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.b = ((ClearableEditText)findViewById(2131435808));
  }
  
  public QQCustomDialog setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new QQCustomDialogWtihInput.2(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public void show()
  {
    super.show();
    Editable localEditable = this.b.getText();
    if ((localEditable instanceof Spannable)) {
      Selection.setSelection((Spannable)localEditable, localEditable.length());
    }
    this.d = System.currentTimeMillis();
    if ((this.b.isFocusable()) || (this.b.isFocusableInTouchMode())) {
      new Timer().schedule(new QQCustomDialogWtihInput.3(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInput
 * JD-Core Version:    0.7.0.1
 */