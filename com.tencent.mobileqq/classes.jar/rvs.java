import android.text.TextUtils;
import com.tencent.common.app.AppInterface;

public class rvs
{
  private ajgs jdField_a_of_type_Ajgs;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public rvs(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Ajgs = new rvt(this);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Ajgs);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Ajgs);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    ajgm localajgm;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null);
      localajgm = (ajgm)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(8);
    } while (localajgm == null);
    this.jdField_a_of_type_JavaLangString = paramString;
    localajgm.a(paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rvs
 * JD-Core Version:    0.7.0.1
 */