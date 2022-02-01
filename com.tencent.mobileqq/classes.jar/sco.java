import com.tencent.image.AbsThirdDataSourceAdapter;
import com.tencent.image.AbsThirdDataSourceAdapter.OnPreparedCallback;

public class sco
  extends AbsThirdDataSourceAdapter
{
  int jdField_a_of_type_Int = 2;
  private AbsThirdDataSourceAdapter.OnPreparedCallback jdField_a_of_type_ComTencentImageAbsThirdDataSourceAdapter$OnPreparedCallback;
  private String jdField_a_of_type_JavaLangString = "";
  private int b = 0;
  private int c = 0;
  
  public sco(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int getPlayType()
  {
    return this.c;
  }
  
  public int getStaus()
  {
    return this.b;
  }
  
  public String getURL()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void requestPrepare(String paramString, AbsThirdDataSourceAdapter.OnPreparedCallback paramOnPreparedCallback)
  {
    this.jdField_a_of_type_ComTencentImageAbsThirdDataSourceAdapter$OnPreparedCallback = paramOnPreparedCallback;
    this.b = 1;
    paramOnPreparedCallback = scq.a();
    scp localscp = new scp(this);
    if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 6)) {
      paramOnPreparedCallback.a(paramString, localscp);
    }
    while (this.jdField_a_of_type_Int != 4) {
      return;
    }
    paramOnPreparedCallback.a(paramString, "SQQShopAdSvr.GetUrlByVid", localscp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sco
 * JD-Core Version:    0.7.0.1
 */