package dov.com.qq.im.ptv;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import bhwy;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.HashMap;

class AIOBusinessOperation$2$1
  implements Runnable
{
  AIOBusinessOperation$2$1(AIOBusinessOperation.2 param2, Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      if (this.jdField_a_of_type_Boolean) {}
      for (Object localObject = new SkinnableBitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap);; localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap))
      {
        this.this$0.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        bhwy.a().put(this.this$0.jdField_a_of_type_JavaLangString, localObject);
        return;
      }
    }
    bhwy.a().put(this.this$0.jdField_a_of_type_JavaLangString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ptv.AIOBusinessOperation.2.1
 * JD-Core Version:    0.7.0.1
 */