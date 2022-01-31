import android.text.TextUtils;
import com.tencent.common.app.AppInterface;

public class tac
{
  private almg jdField_a_of_type_Almg;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public tac(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Almg = new tad(this);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Almg);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Almg);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    allz localallz;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null);
      localallz = (allz)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(8);
    } while (localallz == null);
    this.jdField_a_of_type_JavaLangString = paramString;
    localallz.a(paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tac
 * JD-Core Version:    0.7.0.1
 */