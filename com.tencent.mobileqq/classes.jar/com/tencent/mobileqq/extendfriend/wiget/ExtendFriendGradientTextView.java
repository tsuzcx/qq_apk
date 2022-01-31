package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.AttributeSet;
import baig;
import bjwp;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView;
import fj;

public class ExtendFriendGradientTextView
  extends ETTextView
{
  int jdField_a_of_type_Int = 10;
  ProfileCardExtendFriendView jdField_a_of_type_ComTencentMobileqqWidgetProfileCardExtendFriendView;
  public String a;
  public boolean a;
  int jdField_b_of_type_Int = 0;
  public String b;
  boolean jdField_b_of_type_Boolean = true;
  
  public ExtendFriendGradientTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ExtendFriendGradientTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ExtendFriendGradientTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((getETLayout() != null) && (getETLayout().a() > this.jdField_a_of_type_Int))
    {
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int * getETLayout().a(0).length);
      setShowMoreButton(true);
    }
    while ((getLayout() == null) || (getLayout().getLineCount() <= this.jdField_a_of_type_Int)) {
      return;
    }
    this.jdField_b_of_type_Int = getLayout().getLineStart(this.jdField_a_of_type_Int);
    setShowMoreButton(true);
  }
  
  public void setCardView(ProfileCardExtendFriendView paramProfileCardExtendFriendView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardExtendFriendView = paramProfileCardExtendFriendView;
  }
  
  public void setContent(String paramString)
  {
    if (this.jdField_a_of_type_JavaLangString != null) {}
    for (String str = this.jdField_a_of_type_JavaLangString;; str = "")
    {
      this.jdField_a_of_type_JavaLangString = str;
      if ((paramString != null) && (!this.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        if ((this.jdField_b_of_type_JavaLangString == null) || (!this.jdField_b_of_type_Boolean)) {
          break;
        }
        setETContent(this.jdField_b_of_type_JavaLangString);
      }
      return;
    }
    setETContent(paramString);
  }
  
  public void setETContent(String paramString)
  {
    super.setTextMsg(new baig(bjwp.d(paramString), 3, 24));
  }
  
  public void setFold(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_JavaLangString == null) {}
      for (String str = this.jdField_a_of_type_JavaLangString;; str = this.jdField_b_of_type_JavaLangString)
      {
        setETContent(str);
        return;
      }
    }
    setETContent(this.jdField_a_of_type_JavaLangString);
  }
  
  public void setShowMoreButton(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.substring(0, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardExtendFriendView.a(paramBoolean);
      setETContent(this.jdField_b_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendGradientTextView
 * JD-Core Version:    0.7.0.1
 */