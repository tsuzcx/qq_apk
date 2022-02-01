package dov.com.qq.im.ptv;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import bowj;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class AIOBusinessOperation$1$1
  implements Runnable
{
  AIOBusinessOperation$1$1(AIOBusinessOperation.1 param1, String paramString) {}
  
  public void run()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2;
    if (bowj.a().equalsIgnoreCase(this.a))
    {
      Drawable localDrawable = (Drawable)bowj.a().get(bowj.a());
      if (localDrawable != null) {
        this.this$0.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      }
      l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("AIOBusinessOperation", 2, "updateLightVideoEntry cost:" + (l2 - l1) + " ms");
      }
    }
    do
    {
      return;
      bowj.a().clear();
      if (!"1000".equals(this.a)) {
        break;
      }
      this.this$0.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844449);
      l2 = SystemClock.uptimeMillis();
    } while (!QLog.isColorLevel());
    QLog.i("AIOBusinessOperation", 2, "updateLightVideoEntry total cost:" + (l2 - l1) + " ms");
    return;
    if (this.this$0.jdField_a_of_type_Boolean) {
      bowj.a(this.this$0.jdField_a_of_type_AndroidWidgetImageView, this.a);
    }
    for (;;)
    {
      bowj.a(this.a);
      break;
      bowj.b(this.this$0.jdField_a_of_type_AndroidWidgetImageView, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ptv.AIOBusinessOperation.1.1
 * JD-Core Version:    0.7.0.1
 */