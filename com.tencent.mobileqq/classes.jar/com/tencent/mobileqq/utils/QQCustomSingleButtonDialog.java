package com.tencent.mobileqq.utils;

import ajrb;
import ajrc;
import ajrd;
import ajre;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.text.QQText;

public class QQCustomSingleButtonDialog
  extends Dialog
{
  public DialogInterface.OnClickListener a;
  public LayoutInflater a;
  View jdField_a_of_type_AndroidViewView;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new ajrb(this);
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  ListView jdField_a_of_type_AndroidWidgetListView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public String[] a;
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  TextView f;
  TextView g;
  
  public QQCustomSingleButtonDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public int a(int paramInt)
  {
    return paramInt;
  }
  
  public QQCustomSingleButtonDialog a(int paramInt)
  {
    this.b.setText(paramInt);
    this.b.setContentDescription(getContext().getString(paramInt));
    this.b.setVisibility(0);
    return this;
  }
  
  public QQCustomSingleButtonDialog a(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return this;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(paramInt1);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getContext().getString(paramInt2));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ajrd(this, paramOnClickListener));
    a();
    return this;
  }
  
  public QQCustomSingleButtonDialog a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setContentDescription(getContext().getString(paramInt));
    this.d.setVisibility(0);
    this.d.setOnClickListener(new ajre(this, paramOnClickListener));
    a();
    return this;
  }
  
  public QQCustomSingleButtonDialog a(String paramString)
  {
    if (paramString != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(new QQText(paramString, 5, 24));
      this.b.setContentDescription(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {}
      return this;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    return this;
  }
  
  public QQCustomSingleButtonDialog a(String paramString, float paramFloat)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.b.setText(new QQText(paramString, 5, 20));
      this.b.setContentDescription(paramString);
      this.b.setVisibility(0);
      return this;
    }
    this.b.setVisibility(8);
    return this;
  }
  
  public QQCustomSingleButtonDialog a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(new QQText(paramString, 5, 20));
    this.d.setContentDescription(paramString);
    this.d.setVisibility(0);
    this.d.setOnClickListener(new ajrc(this, paramOnClickListener));
    a();
    return this;
  }
  
  protected void a() {}
  
  public QQCustomSingleButtonDialog b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.b.setText(paramString);
      this.b.setContentDescription(paramString);
      this.b.setVisibility(0);
      return this;
    }
    this.b.setVisibility(8);
    return this;
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364010));
    this.b = ((TextView)findViewById(2131362758));
    this.c = ((TextView)findViewById(2131364027));
    this.e = ((TextView)findViewById(2131364043));
    this.g = ((TextView)findViewById(2131364023));
    this.f = ((TextView)findViewById(2131364024));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364026));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364025);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364013));
    this.d = ((TextView)findViewById(2131364014));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363771));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131364021));
  }
  
  public void setTitle(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    this.b.setContentDescription(getContext().getString(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomSingleButtonDialog
 * JD-Core Version:    0.7.0.1
 */