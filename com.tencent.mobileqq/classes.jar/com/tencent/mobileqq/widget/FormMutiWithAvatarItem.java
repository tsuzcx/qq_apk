package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bfvh;
import com.tencent.mobileqq.activity.contact.connections.OverlappingImgLayout;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qphone.base.util.QLog;

public class FormMutiWithAvatarItem
  extends FormMutiItem
{
  protected OverlappingImgLayout a;
  protected LinearLayout b;
  protected TextView c;
  protected CharSequence c;
  protected int j = 2;
  
  public FormMutiWithAvatarItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormMutiWithAvatarItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private void d()
  {
    this.b = new LinearLayout(getContext());
    this.b.setId(2131367088);
    this.b.setOrientation(0);
    this.b.setGravity(16);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(0, 2131367089);
    localLayoutParams.addRule(15);
    addView(this.b, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(1, 2131367087);
    localLayoutParams.addRule(0, 2131367088);
    localLayoutParams.addRule(15);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout.getChildCount() != 0);
  }
  
  public void setOverimgLayout(int paramInt1, int paramInt2, String[] paramArrayOfString, FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout.a(paramInt1, paramInt2, paramArrayOfString, paramFaceDecoder);
  }
  
  public void setOverloading()
  {
    this.jdField_c_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_c_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(b(getResources(), this.j));
    int i = getResources().getDimensionPixelSize(2131296772);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(0, i);
    this.jdField_c_of_type_AndroidWidgetTextView.setGravity(21);
    this.jdField_c_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_c_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(true);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = ((int)bfvh.a(getContext(), 5.0F));
    this.b.addView(this.jdField_c_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout = new OverlappingImgLayout(getContext());
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout.setGravity(21);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = ((int)bfvh.a(getContext(), 12.0F));
    this.b.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout, localLayoutParams);
    if (QLog.isColorLevel()) {
      QLog.d("FormMutiWithAvatarItem", 2, "setOverloading, run ");
    }
  }
  
  public void setPeopleText(String paramString)
  {
    this.jdField_c_of_type_JavaLangCharSequence = paramString;
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangCharSequence);
  }
  
  public void setPeopleTextColor(int paramInt)
  {
    this.j = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormMutiWithAvatarItem
 * JD-Core Version:    0.7.0.1
 */