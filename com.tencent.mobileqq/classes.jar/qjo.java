import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class qjo
{
  private int jdField_a_of_type_Int;
  public AppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private qiz jdField_a_of_type_Qiz = new qjp(this);
  qjq jdField_a_of_type_Qjq;
  private boolean jdField_a_of_type_Boolean;
  
  public qjo(AppInterface paramAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    if (this.jdField_a_of_type_Qjq != null) {
      this.jdField_a_of_type_Qjq.a(paramInt, paramString, paramBaseResData);
    }
  }
  
  public void a()
  {
    ThreadManager.post(new ReadInjoySkinAndRefreshFacade.1(this), 5, null, true);
  }
  
  public void a(qjq paramqjq)
  {
    this.jdField_a_of_type_Qjq = paramqjq;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Qjq = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Qiz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qjo
 * JD-Core Version:    0.7.0.1
 */