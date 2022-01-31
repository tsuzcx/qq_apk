import android.os.AsyncTask;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

public final class cs
  implements FMDialogUtil.FMDialogInterface
{
  public cs(AsyncTask paramAsyncTask, int paramInt, FMDialogUtil.FMDialogInterface paramFMDialogInterface) {}
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Integer[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFMDialogUtil$FMDialogInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFMDialogUtil$FMDialogInterface.a();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFMDialogUtil$FMDialogInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFMDialogUtil$FMDialogInterface.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     cs
 * JD-Core Version:    0.7.0.1
 */