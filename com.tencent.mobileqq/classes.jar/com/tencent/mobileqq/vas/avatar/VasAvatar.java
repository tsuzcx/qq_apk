package com.tencent.mobileqq.vas.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.OnLongClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.MosaicEffect;
import com.tencent.mobileqq.widget.MosaicEffect.IMosaicEffect;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;

public class VasAvatar
  extends URLThemeImageView
  implements MosaicEffect.IMosaicEffect
{
  public Drawable a;
  private View.OnLongClickListener a;
  protected AvatarLayout a;
  public VasAvatarLoader a;
  protected MosaicEffect a;
  protected String a;
  
  public VasAvatar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VasAvatar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public VasAvatar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSupportMaskView(false);
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 200)
    {
      if (paramInt != 640) {
        return "small";
      }
      return "large";
    }
    return "medium";
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 == 103) {
        return true;
      }
      return (paramInt1 == 32) && (paramInt2 == 200);
    }
    return true;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
    if (localObject != null) {
      ((AvatarLayout)localObject).setGoneBelow(1);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("show vas avatar of ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("Q.qqhead.VasFaceManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewView$OnLongClickListener != null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    MosaicEffect localMosaicEffect = this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect;
    if (localMosaicEffect != null)
    {
      localMosaicEffect.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    MosaicEffect localMosaicEffect = this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect;
    if (localMosaicEffect != null)
    {
      localMosaicEffect.b(paramCanvas);
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
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatarLoader = null;
  }
  
  public void setLoader(AvatarLayout paramAvatarLayout, VasAvatarLoader paramVasAvatarLoader)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramVasAvatarLoader.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramVasAvatarLoader.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = paramAvatarLayout;
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatarLoader = paramVasAvatarLoader;
    this.jdField_a_of_type_JavaLangString = paramVasAvatarLoader.jdField_a_of_type_JavaLangString;
    paramVasAvatarLoader.a(this);
  }
  
  public void setLoaderForCmshow(AvatarLayout paramAvatarLayout, VasAvatarLoader paramVasAvatarLoader, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramVasAvatarLoader.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramVasAvatarLoader.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = paramAvatarLayout;
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatarLoader = paramVasAvatarLoader;
    this.jdField_a_of_type_JavaLangString = paramVasAvatarLoader.jdField_a_of_type_JavaLangString;
    paramVasAvatarLoader.a(this, paramInt1, paramInt2);
  }
  
  public void setMosaicEffect(MosaicEffect paramMosaicEffect)
  {
    MosaicEffect localMosaicEffect = this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect;
    if (localMosaicEffect != null) {
      localMosaicEffect.a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect = paramMosaicEffect;
    paramMosaicEffect = this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect;
    if (paramMosaicEffect != null) {
      paramMosaicEffect.a(this);
    }
    invalidate();
  }
  
  public void setOnLongClickListener(@android.support.annotation.Nullable @androidx.annotation.Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    super.setOnLongClickListener(paramOnLongClickListener);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
  }
  
  public void superDrawMosaic(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void superOnDrawMosaic(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasAvatar
 * JD-Core Version:    0.7.0.1
 */