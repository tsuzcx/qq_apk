package com.tencent.mobileqq.leba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LebaTopEntryView
  extends LinearLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  
  public LebaTopEntryView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public LebaTopEntryView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public FrameLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  protected void a()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    if (localLayoutInflater != null) {
      localLayoutInflater.inflate(2130970387, this);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366363));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370330));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131370333));
    this.b = ((TextView)findViewById(2131370332));
  }
  
  public TextView b()
  {
    return this.b;
  }
  
  public void setIconByResourceId(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  public void setPluginNameView(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.LebaTopEntryView
 * JD-Core Version:    0.7.0.1
 */