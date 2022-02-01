package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ListView;

public class QQCustomDialogThreeBtns
  extends ReportDialog
{
  private BaseAdapter adapter = new QQCustomDialogThreeBtns.1(this);
  LinearLayout bodyLayout;
  LayoutInflater inflater;
  String[] items;
  TextView lBtn;
  ListView list;
  TextView mBtn;
  DialogInterface.OnClickListener onArrayItemClick;
  TextView previewImage;
  TextView rBtn;
  TextView text;
  TextView title;
  
  public QQCustomDialogThreeBtns(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQCustomDialogThreeBtns(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected QQCustomDialogThreeBtns(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
  }
  
  private void setDefaultHightLightBtn()
  {
    TextView localTextView = null;
    if (this.rBtn.getVisibility() == 0) {
      localTextView = this.rBtn;
    }
    for (;;)
    {
      if (localTextView != null) {}
      return;
      if (this.mBtn.getVisibility() == 0) {
        localTextView = this.mBtn;
      } else if (this.lBtn.getVisibility() == 0) {
        localTextView = this.lBtn;
      }
    }
  }
  
  private void setSeperatorState()
  {
    setDefaultHightLightBtn();
  }
  
  public QQCustomDialogThreeBtns addView(View paramView)
  {
    this.text.setVisibility(8);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.bodyLayout.addView(paramView, localLayoutParams);
    return this;
  }
  
  protected int customWhichToCallBack(int paramInt)
  {
    return paramInt;
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.title = ((TextView)findViewById(2131365648));
    this.text = ((TextView)findViewById(2131365644));
    this.previewImage = ((TextView)findViewById(2131373129));
    this.lBtn = ((TextView)findViewById(2131365633));
    this.mBtn = ((TextView)findViewById(2131365636));
    this.rBtn = ((TextView)findViewById(2131365639));
    this.lBtn.setVisibility(8);
    this.mBtn.setVisibility(8);
    this.rBtn.setVisibility(8);
    this.bodyLayout = ((LinearLayout)findViewById(2131363664));
    this.list = ((ListView)findViewById(2131370180));
  }
  
  public QQCustomDialogThreeBtns setItems(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = null;
    try
    {
      String[] arrayOfString = getContext().getResources().getStringArray(paramInt);
      localObject = arrayOfString;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        localNotFoundException.printStackTrace();
      }
    }
    return setItems(localObject, paramOnClickListener);
  }
  
  public QQCustomDialogThreeBtns setItems(String[] paramArrayOfString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.items = paramArrayOfString;
    this.text.setVisibility(8);
    this.lBtn.setVisibility(8);
    this.mBtn.setVisibility(8);
    this.rBtn.setVisibility(8);
    this.bodyLayout.setVisibility(8);
    this.onArrayItemClick = paramOnClickListener;
    this.list.setVisibility(0);
    this.list.setAdapter(this.adapter);
    this.list.setDivider(null);
    this.list.setDividerHeight(0);
    return this;
  }
  
  public QQCustomDialogThreeBtns setLeftButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramInt);
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new QQCustomDialogThreeBtns.5(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public QQCustomDialogThreeBtns setLeftButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramString);
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new QQCustomDialogThreeBtns.2(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public QQCustomDialogThreeBtns setMessage(int paramInt)
  {
    this.text.setText(paramInt);
    this.text.setVisibility(0);
    return this;
  }
  
  public QQCustomDialogThreeBtns setMessage(String paramString)
  {
    if (paramString != null)
    {
      this.text.setText(paramString);
      this.text.setVisibility(0);
      return this;
    }
    this.text.setVisibility(8);
    return this;
  }
  
  public QQCustomDialogThreeBtns setMessageMaxLine(int paramInt)
  {
    if (this.text != null)
    {
      this.text.setMaxLines(paramInt);
      this.text.setEllipsize(TextUtils.TruncateAt.END);
    }
    return this;
  }
  
  public QQCustomDialogThreeBtns setMiddleButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.mBtn.setVisibility(8);
      return this;
    }
    this.mBtn.setText(paramInt);
    this.mBtn.setVisibility(0);
    this.mBtn.setOnClickListener(new QQCustomDialogThreeBtns.6(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public QQCustomDialogThreeBtns setMiddleButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.mBtn.setVisibility(8);
      return this;
    }
    this.mBtn.setText(paramString);
    this.mBtn.setVisibility(0);
    this.mBtn.setOnClickListener(new QQCustomDialogThreeBtns.3(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public QQCustomDialogThreeBtns setPreviewImage(Drawable paramDrawable)
  {
    this.previewImage.setPadding(0, 0, 0, 0);
    this.previewImage.setCompoundDrawablePadding(0);
    this.previewImage.setCompoundDrawables(paramDrawable, null, null, null);
    if (paramDrawable != null)
    {
      this.previewImage.setVisibility(0);
      return this;
    }
    this.previewImage.setVisibility(8);
    return this;
  }
  
  public QQCustomDialogThreeBtns setRightButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new QQCustomDialogThreeBtns.7(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public QQCustomDialogThreeBtns setRightButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramString);
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new QQCustomDialogThreeBtns.4(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public QQCustomDialogThreeBtns setText(String paramString, int paramInt)
  {
    if ((findViewById(paramInt) instanceof TextView))
    {
      TextView localTextView = (TextView)findViewById(paramInt);
      if (localTextView != null) {
        localTextView.setText(paramString);
      }
    }
    return this;
  }
  
  public QQCustomDialogThreeBtns setTitle(String paramString)
  {
    if (paramString != null)
    {
      this.title.setText(paramString);
      this.title.setVisibility(0);
      if (this.items == null) {}
      return this;
    }
    this.title.setVisibility(8);
    return this;
  }
  
  public void setTitle(int paramInt)
  {
    this.title.setText(paramInt);
    this.title.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogThreeBtns
 * JD-Core Version:    0.7.0.1
 */