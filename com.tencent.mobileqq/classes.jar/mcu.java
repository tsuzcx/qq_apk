import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI.RecordInfo.1;
import com.tencent.qphone.base.util.QLog;

public class mcu
{
  private int jdField_a_of_type_Int = 0;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private AVActivity jdField_a_of_type_ComTencentAvUiAVActivity;
  public Runnable a;
  private int b;
  private int c = 2130841691;
  
  private mcu()
  {
    this.jdField_a_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.RecordInfo.1(this);
  }
  
  public void a()
  {
    this.c = 2130841691;
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvUiAVActivity = null;
  }
  
  void a(long paramLong)
  {
    QLog.w("RecordInfo", 1, "onClick_Record, cancel, seq[" + paramLong + "]");
    a();
  }
  
  public void a(long paramLong, VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    if (this.jdField_a_of_type_Int == 0) {
      a(paramLong, paramAVActivity);
    }
    while (this.jdField_a_of_type_Int != 1) {
      return;
    }
    a(paramLong);
  }
  
  void a(long paramLong, AVActivity paramAVActivity)
  {
    QLog.w("RecordInfo", 1, "onClick_Record, start, seq[" + paramLong + "]");
    this.jdField_a_of_type_Int = 1;
    this.c = 2130841694;
    this.jdField_a_of_type_ComTencentAvUiAVActivity = paramAVActivity;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mcu
 * JD-Core Version:    0.7.0.1
 */