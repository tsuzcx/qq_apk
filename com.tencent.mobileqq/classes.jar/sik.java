import android.text.TextUtils;
import com.tencent.common.app.AppInterface;

public class sik
{
  private ajuv jdField_a_of_type_Ajuv;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public sik(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Ajuv = new sil(this);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Ajuv);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Ajuv);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    ajuo localajuo;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null);
      localajuo = (ajuo)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(8);
    } while (localajuo == null);
    this.jdField_a_of_type_JavaLangString = paramString;
    localajuo.a(paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sik
 * JD-Core Version:    0.7.0.1
 */