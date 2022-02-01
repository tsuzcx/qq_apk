package com.tencent.mobileqq.extendfriend.apollo.aio;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.vas.avatar.VasAvatarLoader;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.widget.MosaicEffect;
import com.tencent.qphone.base.util.QLog;

public class ApolloVasAvatar
  extends VasAvatar
{
  public ApolloVasAvatar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ApolloVasAvatar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ApolloVasAvatar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setGoneBelow(1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloVasAvatar", 2, "show vas avatar of " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
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
  }
  
  public void setLoader(AvatarLayout paramAvatarLayout, VasAvatarLoader paramVasAvatarLoader)
  {
    super.setLoader(paramAvatarLayout, paramVasAvatarLoader);
  }
  
  public void setMosaicEffect(MosaicEffect paramMosaicEffect) {}
  
  public void superDrawMosaic(Canvas paramCanvas)
  {
    super.superDrawMosaic(paramCanvas);
  }
  
  public void superOnDrawMosaic(Canvas paramCanvas)
  {
    super.superOnDrawMosaic(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.apollo.aio.ApolloVasAvatar
 * JD-Core Version:    0.7.0.1
 */