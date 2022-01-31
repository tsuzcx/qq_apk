import com.tencent.av.ui.EffectSettingUi;
import com.tencent.qphone.base.util.QLog;

class jtu
  implements Runnable
{
  jtu(jts paramjts, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Jts.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Jts.a.jdField_a_of_type_AndroidWidgetLinearLayout == null);
      this.jdField_a_of_type_Jts.a.a("onStatusChanged", false);
      bool = this.jdField_a_of_type_Jts.a.isShown();
      if ((this.jdField_a_of_type_Boolean) && (bool)) {
        this.jdField_a_of_type_Jts.a.a(true);
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("AVRedBag", 1, "onStatusChanged, remoteHasVideo[" + this.b + "], peerSupportRedBag[" + this.c + "], isInGameMode[" + this.jdField_a_of_type_Boolean + "], isshow[" + bool + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jtu
 * JD-Core Version:    0.7.0.1
 */