package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
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
  private static final long MIN_SHOW_CLICK_GAP = 800L;
  static final String TAG = "QQCustomDialogWtihInput";
  private ClearableEditText inputView;
  private long mInputDialogShowTimeMs;
  private TextWatcher mTextWatcher;
  private SoftReference<Context> softRefContext;
  
  public QQCustomDialogWtihInput(Context paramContext)
  {
    super(paramContext);
    this.softRefContext = new SoftReference(paramContext);
  }
  
  public QQCustomDialogWtihInput(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.softRefContext = new SoftReference(paramContext);
  }
  
  protected QQCustomDialogWtihInput(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
    this.softRefContext = new SoftReference(paramContext);
  }
  
  private boolean isNeedSkipDevices()
  {
    if ("VIVO".equalsIgnoreCase(Build.MANUFACTURER))
    {
      if ((!Build.MODEL.toUpperCase().contains("Y8")) && (!Build.MODEL.toUpperCase().contains("V18"))) {}
    }
    else {
      while (("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.MODEL.toUpperCase().contains("VOG-AL10"))) {
        return true;
      }
    }
    return false;
  }
  
  public String getInputValue()
  {
    return this.inputView.getText().toString();
  }
  
  public EditText getInputView()
  {
    return this.inputView;
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.inputView = ((ClearableEditText)findViewById(2131368750));
  }
  
  public void setInitInputValue(String paramString)
  {
    if (paramString != null) {
      this.inputView.setText(paramString);
    }
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
  
  public QQCustomDialog setPositiveButtonWithoutLogic(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new QQCustomDialogWtihInput.1(this, paramOnClickListener));
    return this;
  }
  
  public void setTextWatcher(TextWatcher paramTextWatcher)
  {
    if (paramTextWatcher != null)
    {
      this.mTextWatcher = paramTextWatcher;
      this.inputView.addTextChangedListener(paramTextWatcher);
    }
  }
  
  public void show()
  {
    super.show();
    Editable localEditable = this.inputView.getText();
    if ((localEditable instanceof Spannable)) {
      Selection.setSelection((Spannable)localEditable, localEditable.length());
    }
    this.mInputDialogShowTimeMs = System.currentTimeMillis();
    if ((this.inputView.isFocusable()) || (this.inputView.isFocusableInTouchMode())) {
      new Timer().schedule(new QQCustomDialogWtihInput.3(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInput
 * JD-Core Version:    0.7.0.1
 */