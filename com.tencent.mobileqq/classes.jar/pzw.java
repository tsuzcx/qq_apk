import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class pzw
{
  private int jdField_a_of_type_Int;
  public AppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private pzh jdField_a_of_type_Pzh = new pzx(this);
  pzy jdField_a_of_type_Pzy;
  private boolean jdField_a_of_type_Boolean;
  
  public pzw(AppInterface paramAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    if (this.jdField_a_of_type_Pzy != null) {
      this.jdField_a_of_type_Pzy.a(paramInt, paramString, paramBaseResData);
    }
  }
  
  public void a()
  {
    ThreadManager.post(new ReadInjoySkinAndRefreshFacade.1(this), 5, null, true);
  }
  
  public void a(pzy parampzy)
  {
    this.jdField_a_of_type_Pzy = parampzy;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Pzy = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Pzh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     pzw
 * JD-Core Version:    0.7.0.1
 */