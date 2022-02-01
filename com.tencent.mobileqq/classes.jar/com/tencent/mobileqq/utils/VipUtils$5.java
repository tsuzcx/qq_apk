package com.tencent.mobileqq.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class VipUtils$5
  implements URLDrawable.URLDrawableListener
{
  VipUtils$5(Resources paramResources, String paramString, ImageView paramImageView, Drawable paramDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      int i = AIOUtils.b(15.0F, this.a);
      int j = paramURLDrawable.getIntrinsicHeight();
      if (j == 0)
      {
        boolean bool = new File(VasApngUtil.getCacheFilePath(this.b)).delete();
        paramURLDrawable = new StringBuilder();
        paramURLDrawable.append("onLoadSuccessed drawableHeight=0, deleteSucc=");
        paramURLDrawable.append(bool);
        paramURLDrawable.append(" url=");
        paramURLDrawable.append(this.b);
        QLog.e("VipUtils", 1, paramURLDrawable.toString());
        this.c.setImageDrawable(this.d);
        return;
      }
      j = paramURLDrawable.getIntrinsicWidth() * i / j;
      ViewGroup.LayoutParams localLayoutParams = this.c.getLayoutParams();
      localLayoutParams.height = i;
      localLayoutParams.width = j;
      this.c.setImageDrawable(null);
      this.c.setImageDrawable(paramURLDrawable);
      this.c.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.5
 * JD-Core Version:    0.7.0.1
 */