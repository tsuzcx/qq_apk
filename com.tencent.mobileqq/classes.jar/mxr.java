import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.qphone.base.util.QLog;

public class mxr
  extends CountDownTimer
{
  int jdField_a_of_type_Int = 1;
  Resources jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  
  public mxr(ChildLockCircle paramChildLockCircle, long paramLong1, long paramLong2, Context paramContext)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, ChildLockCircle.b(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle));
    ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, 0);
    this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.postInvalidate();
    ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle);
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    if (ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle) != null)
    {
      ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle).cancel();
      ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, null);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChildLockCircle", 2, "LockAnimation,CountDownTimer finish");
    }
  }
  
  public void onTick(long paramLong)
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.a(this.jdField_a_of_type_AndroidContentResResources, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        ChildLockCircle.a(this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle, this.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.postInvalidate();
      }
      this.jdField_a_of_type_Int += 1;
      if (QLog.isColorLevel()) {
        QLog.d("ChildLockCircle", 2, "LockAnimation, i[" + this.jdField_a_of_type_Int + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mxr
 * JD-Core Version:    0.7.0.1
 */