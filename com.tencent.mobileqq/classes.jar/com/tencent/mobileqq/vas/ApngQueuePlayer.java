package com.tencent.mobileqq.vas;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.transfile.URLDrawableHelper.Adapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;

public class ApngQueuePlayer
  extends URLDrawableHelper.Adapter
{
  private static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(0);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  URLDrawableDownListener.Adapter jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new ApngQueuePlayer.1(this);
  ApngQueuePlayer.RepeatListener jdField_a_of_type_ComTencentMobileqqVasApngQueuePlayer$RepeatListener = new ApngQueuePlayer.RepeatListener(this);
  private ArrayDeque<ApngQueuePlayer.DrawableBuilder> jdField_a_of_type_JavaUtilArrayDeque = new ArrayDeque();
  private boolean jdField_a_of_type_Boolean = true;
  
  public ApngQueuePlayer(ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    if ((paramImageView instanceof URLImageView)) {
      ((URLImageView)paramImageView).setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
    }
  }
  
  private Drawable a()
  {
    Object localObject = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if (localDrawable != null)
    {
      localObject = localDrawable;
      if ((localDrawable instanceof URLDrawable)) {
        localObject = ((URLDrawable)localDrawable).getCurrDrawable();
      }
      return localObject;
    }
    return localObject;
  }
  
  private void b()
  {
    Object localObject = (ApngQueuePlayer.DrawableBuilder)this.jdField_a_of_type_JavaUtilArrayDeque.poll();
    if (localObject == null) {
      this.jdField_a_of_type_Boolean = true;
    }
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      localObject = ((ApngQueuePlayer.DrawableBuilder)localObject).a(a());
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        b();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    } while ((this.jdField_a_of_type_AndroidWidgetImageView instanceof URLImageView));
    ((URLDrawable)localObject).setURLDrawableListener(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayDeque.clear();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(ApngQueuePlayer.DrawableBuilder paramDrawableBuilder)
  {
    this.jdField_a_of_type_JavaUtilArrayDeque.add(paramDrawableBuilder);
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    a(new ApngQueuePlayer.LocalDrawableBuilder(paramString, paramInt));
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("ApngQueuePlayer", 1, "onLoadFialed: ", paramThrowable);
    b();
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ((ApngDrawable)paramURLDrawable.getCurrDrawable()).getImage();
    if (paramURLDrawable.mFrameCount <= 1)
    {
      b();
      return;
    }
    if ((paramURLDrawable.apngLoop > 0) && (paramURLDrawable.currentApngLoop >= paramURLDrawable.apngLoop)) {
      paramURLDrawable.replay();
    }
    if (paramURLDrawable.apngLoop != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasApngQueuePlayer$RepeatListener.a(paramURLDrawable);
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ApngQueuePlayer
 * JD-Core Version:    0.7.0.1
 */