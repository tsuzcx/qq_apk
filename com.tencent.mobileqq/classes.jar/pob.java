import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class pob
{
  private int jdField_a_of_type_Int;
  public AppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private pnm jdField_a_of_type_Pnm = new poc(this);
  pod jdField_a_of_type_Pod;
  private boolean jdField_a_of_type_Boolean;
  
  public pob(AppInterface paramAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    if (this.jdField_a_of_type_Pod != null) {
      this.jdField_a_of_type_Pod.a(paramInt, paramString, paramBaseResData);
    }
  }
  
  public void a()
  {
    ThreadManager.post(new ReadInjoySkinAndRefreshFacade.1(this), 5, null, true);
  }
  
  public void a(pod parampod)
  {
    this.jdField_a_of_type_Pod = parampod;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Pod = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Pnm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     pob
 * JD-Core Version:    0.7.0.1
 */