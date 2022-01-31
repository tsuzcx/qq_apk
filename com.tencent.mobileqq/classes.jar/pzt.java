import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class pzt
{
  private int jdField_a_of_type_Int;
  public AppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private pze jdField_a_of_type_Pze = new pzu(this);
  pzv jdField_a_of_type_Pzv;
  private boolean jdField_a_of_type_Boolean;
  
  public pzt(AppInterface paramAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    if (this.jdField_a_of_type_Pzv != null) {
      this.jdField_a_of_type_Pzv.a(paramInt, paramString, paramBaseResData);
    }
  }
  
  public void a()
  {
    ThreadManager.post(new ReadInjoySkinAndRefreshFacade.1(this), 5, null, true);
  }
  
  public void a(pzv parampzv)
  {
    this.jdField_a_of_type_Pzv = parampzv;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Pzv = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Pze);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     pzt
 * JD-Core Version:    0.7.0.1
 */