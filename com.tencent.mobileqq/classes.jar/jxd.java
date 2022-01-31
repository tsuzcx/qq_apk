import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class jxd
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString = null;
  
  public jxd(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a.get();
    if (localAVActivity != null) {
      localAVActivity.runOnUiThread(new jxe(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.c, 2, "onInviteUserNotice-->Can not get AVActivity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jxd
 * JD-Core Version:    0.7.0.1
 */