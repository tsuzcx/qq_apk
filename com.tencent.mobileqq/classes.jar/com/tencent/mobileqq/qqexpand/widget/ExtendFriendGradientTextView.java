package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.AttributeSet;
import com.etrump.mixlayout.ETLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.qqexpand.profilecard.ProfileCardExtendFriendView;
import com.tencent.mobileqq.text.QQText;
import cooperation.qzone.widget.QzoneEmotionUtils;

public class ExtendFriendGradientTextView
  extends ETTextView
{
  int jdField_a_of_type_Int = 10;
  ProfileCardExtendFriendView jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileCardExtendFriendView;
  public String a;
  public boolean a;
  int jdField_b_of_type_Int = 0;
  public String b;
  boolean jdField_b_of_type_Boolean = true;
  
  public ExtendFriendGradientTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public ExtendFriendGradientTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public ExtendFriendGradientTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((getETLayout() != null) && (getETLayout().a() > this.jdField_a_of_type_Int) && (getETLayout().a(0) != null))
    {
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int * getETLayout().a(0).length);
      setShowMoreButton(true);
      return;
    }
    if ((getLayout() != null) && (getLayout().getLineCount() > this.jdField_a_of_type_Int))
    {
      this.jdField_b_of_type_Int = getLayout().getLineStart(this.jdField_a_of_type_Int);
      setShowMoreButton(true);
    }
  }
  
  public void setCardView(ProfileCardExtendFriendView paramProfileCardExtendFriendView)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileCardExtendFriendView = paramProfileCardExtendFriendView;
  }
  
  public void setContent(String paramString)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (str == null) {
      str = "";
    }
    this.jdField_a_of_type_JavaLangString = str;
    if ((paramString != null) && (!this.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      str = this.jdField_b_of_type_JavaLangString;
      if ((str != null) && (this.jdField_b_of_type_Boolean))
      {
        setETContent(str);
        return;
      }
      setETContent(paramString);
    }
  }
  
  public void setETContent(String paramString)
  {
    super.setTextMsg(new QQText(QzoneEmotionUtils.emCodesToQQcodes(paramString), 3, 24));
  }
  
  public void setFold(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      String str2 = this.jdField_b_of_type_JavaLangString;
      String str1 = str2;
      if (str2 == null) {
        str1 = this.jdField_a_of_type_JavaLangString;
      }
      setETContent(str1);
      return;
    }
    setETContent(this.jdField_a_of_type_JavaLangString);
  }
  
  public void setShowMoreButton(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.substring(0, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandProfilecardProfileCardExtendFriendView.a(paramBoolean);
      setETContent(this.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendGradientTextView
 * JD-Core Version:    0.7.0.1
 */