package dov.com.qq.im.ptv;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import bowj;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.theme.SkinnableBitmapDrawable;
import mqq.os.MqqHandler;

public final class AIOBusinessOperation$2
  implements Runnable
{
  public AIOBusinessOperation$2(String paramString, ImageView paramImageView) {}
  
  public void run()
  {
    int i = bowj.a(this.jdField_a_of_type_JavaLangString);
    if (i == 0)
    {
      bowj.a(this.jdField_a_of_type_AndroidWidgetImageView.getResources(), this.jdField_a_of_type_JavaLangString);
      i = bowj.a(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130844449);
      boolean bool;
      if ((localObject instanceof BitmapDrawable))
      {
        localObject = ((BitmapDrawable)localObject).getBitmap();
        bool = false;
      }
      for (;;)
      {
        if (localObject != null)
        {
          localObject = bowj.a((Bitmap)localObject, i);
          ThreadManager.getUIHandler().post(new AIOBusinessOperation.2.1(this, (Bitmap)localObject, bool));
        }
        return;
        if ((localObject instanceof SkinnableBitmapDrawable))
        {
          localObject = ((SkinnableBitmapDrawable)localObject).getBitmap();
          bool = true;
        }
        else
        {
          bool = false;
          localObject = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ptv.AIOBusinessOperation.2
 * JD-Core Version:    0.7.0.1
 */