package com.tencent.mobileqq.qqexpand.widget.chat;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class MaskDialog
  extends QQCustomDialog
{
  public MaskDialog(Context paramContext)
  {
    super(paramContext, 2131953338);
    setContentView(2131624611);
    setTitle(null);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
  }
  
  public QQCustomDialog setNegativeButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramString);
    TextView localTextView = this.lBtn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(getContext().getString(2131888061));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new MaskDialog.2(this, paramOnClickListener));
    return this;
  }
  
  public QQCustomDialog setPositiveButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramString);
    TextView localTextView = this.rBtn;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(getContext().getString(2131888061));
    localTextView.setContentDescription(localStringBuilder.toString());
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new MaskDialog.1(this, paramOnClickListener));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.chat.MaskDialog
 * JD-Core Version:    0.7.0.1
 */