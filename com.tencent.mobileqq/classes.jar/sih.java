import android.text.TextUtils;
import com.tencent.common.app.AppInterface;

public class sih
{
  private ajut jdField_a_of_type_Ajut;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public sih(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Ajut = new sii(this);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Ajut);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Ajut);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    ajum localajum;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null);
      localajum = (ajum)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(8);
    } while (localajum == null);
    this.jdField_a_of_type_JavaLangString = paramString;
    localajum.a(paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sih
 * JD-Core Version:    0.7.0.1
 */