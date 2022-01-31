import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mea
  extends mef
{
  public mea(AVActivity paramAVActivity, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.h != paramInt)
    {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiAVActivity.b, 1, "onVideoOrientationChanged, mRotationAngle[" + this.jdField_a_of_type_ComTencentAvUiAVActivity.h + "->" + paramInt + "], seq[" + l + "], isFinishing[" + this.jdField_a_of_type_ComTencentAvUiAVActivity.isFinishing() + "]");
      if (AudioHelper.d())
      {
        Display localDisplay = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay();
        QLog.w(this.jdField_a_of_type_ComTencentAvUiAVActivity.b, 1, "onVideoOrientationChanged, Display.getRotation[" + localDisplay.getRotation() + "], seq[" + l + "]");
      }
    }
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity.isFinishing()) {
      return;
    }
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentAvUiAVActivity.a(l, 270, paramBoolean);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiAVActivity.a(l, paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mea
 * JD-Core Version:    0.7.0.1
 */