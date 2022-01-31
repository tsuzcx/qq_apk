import android.view.View;
import com.tencent.mobileqq.qipc.QIPCModule;

public class qpc
{
  private static qpc jdField_a_of_type_Qpc;
  private acwb jdField_a_of_type_Acwb;
  private ajxj jdField_a_of_type_Ajxj;
  private View jdField_a_of_type_AndroidViewView;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new qpd(this, "Module_VideoFeedsIPCServer");
  private oee jdField_a_of_type_Oee;
  
  public static qpc a()
  {
    if (jdField_a_of_type_Qpc == null) {}
    try
    {
      jdField_a_of_type_Qpc = new qpc();
      return jdField_a_of_type_Qpc;
    }
    finally {}
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qpc
 * JD-Core Version:    0.7.0.1
 */