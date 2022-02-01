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
      int i = AIOUtils.b(15.0F, this.jdField_a_of_type_AndroidContentResResources);
      int j = paramURLDrawable.getIntrinsicHeight();
      if (j == 0)
      {
        boolean bool = new File(VasApngUtil.getCacheFilePath(this.jdField_a_of_type_JavaLangString)).delete();
        paramURLDrawable = new StringBuilder();
        paramURLDrawable.append("onLoadSuccessed drawableHeight=0, deleteSucc=");
        paramURLDrawable.append(bool);
        paramURLDrawable.append(" url=");
        paramURLDrawable.append(this.jdField_a_of_type_JavaLangString);
        QLog.e("VipUtils", 1, paramURLDrawable.toString());
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
      j = paramURLDrawable.getIntrinsicWidth() * i / j;
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.height = i;
      localLayoutParams.width = j;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramURLDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.5
 * JD-Core Version:    0.7.0.1
 */