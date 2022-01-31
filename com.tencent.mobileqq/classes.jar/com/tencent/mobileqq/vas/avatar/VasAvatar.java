package com.tencent.mobileqq.vas.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import baqk;
import bbkd;
import bbke;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;

public class VasAvatar
  extends URLThemeImageView
  implements bbke
{
  public Drawable a;
  public baqk a;
  private bbkd jdField_a_of_type_Bbkd;
  private AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  private String jdField_a_of_type_JavaLangString;
  
  public VasAvatar(Context paramContext)
  {
    super(paramContext);
  }
  
  public VasAvatar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VasAvatar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "small";
    case 640: 
      return "large";
    }
    return "medium";
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) || (paramInt1 == 103)) {}
    while ((paramInt1 == 32) && (paramInt2 == 200)) {
      return true;
    }
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setGoneBelow(1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.VasFaceManager", 2, "show vas avatar of " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void c(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bbkd != null)
    {
      this.jdField_a_of_type_Bbkd.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bbkd != null)
    {
      this.jdField_a_of_type_Bbkd.b(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
    a();
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if ((ApngDrawable.class.isInstance(paramURLDrawable)) && ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))) {
      VasFaceManager.a(this.jdField_a_of_type_JavaLangString, (ApngDrawable)paramURLDrawable);
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.jdField_a_of_type_Baqk = null;
  }
  
  public void setLoader(AvatarLayout paramAvatarLayout, baqk parambaqk)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = parambaqk.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    parambaqk.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = paramAvatarLayout;
    this.jdField_a_of_type_Baqk = parambaqk;
    this.jdField_a_of_type_JavaLangString = parambaqk.jdField_a_of_type_JavaLangString;
    parambaqk.a(this);
  }
  
  public void setMosaicEffect(bbkd parambbkd)
  {
    if (this.jdField_a_of_type_Bbkd != null) {
      this.jdField_a_of_type_Bbkd.a(null);
    }
    this.jdField_a_of_type_Bbkd = parambbkd;
    if (this.jdField_a_of_type_Bbkd != null) {
      this.jdField_a_of_type_Bbkd.a(this);
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasAvatar
 * JD-Core Version:    0.7.0.1
 */