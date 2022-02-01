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
  public VasAvatarLoader b;
  protected AvatarLayout c;
  protected String d;
  protected MosaicEffect e;
  private View.OnLongClickListener f;
  
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
    Object localObject = this.c;
    if (localObject != null) {
      ((AvatarLayout)localObject).setGoneBelow(1);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("show vas avatar of ");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("Q.qqhead.VasFaceManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean b()
  {
    return this.f != null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    MosaicEffect localMosaicEffect = this.e;
    if (localMosaicEffect != null)
    {
      localMosaicEffect.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    MosaicEffect localMosaicEffect = this.e;
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
      VasFaceManager.a(this.d, (ApngDrawable)paramURLDrawable);
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.b = null;
  }
  
  public void setLoader(AvatarLayout paramAvatarLayout, VasAvatarLoader paramVasAvatarLoader)
  {
    this.a = paramVasAvatarLoader.g;
    paramVasAvatarLoader.g = null;
    setImageDrawable(this.a);
    this.c = paramAvatarLayout;
    this.b = paramVasAvatarLoader;
    this.d = paramVasAvatarLoader.b;
    paramVasAvatarLoader.a(this);
  }
  
  public void setLoaderForCmshow(AvatarLayout paramAvatarLayout, VasAvatarLoader paramVasAvatarLoader, int paramInt1, int paramInt2)
  {
    this.a = paramVasAvatarLoader.g;
    paramVasAvatarLoader.g = null;
    setImageDrawable(this.a);
    this.c = paramAvatarLayout;
    this.b = paramVasAvatarLoader;
    this.d = paramVasAvatarLoader.b;
    paramVasAvatarLoader.a(this, paramInt1, paramInt2);
  }
  
  public void setMosaicEffect(MosaicEffect paramMosaicEffect)
  {
    MosaicEffect localMosaicEffect = this.e;
    if (localMosaicEffect != null) {
      localMosaicEffect.a(null);
    }
    this.e = paramMosaicEffect;
    paramMosaicEffect = this.e;
    if (paramMosaicEffect != null) {
      paramMosaicEffect.a(this);
    }
    invalidate();
  }
  
  public void setOnLongClickListener(@android.support.annotation.Nullable @androidx.annotation.Nullable View.OnLongClickListener paramOnLongClickListener)
  {
    super.setOnLongClickListener(paramOnLongClickListener);
    this.f = paramOnLongClickListener;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasAvatar
 * JD-Core Version:    0.7.0.1
 */