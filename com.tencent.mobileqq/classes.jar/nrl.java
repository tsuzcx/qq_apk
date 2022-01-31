import com.tencent.biz.pubaccount.PublicAccountManager.4;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

public class nrl
  extends ampt
{
  public nrl(PublicAccountManager.4 param4, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2, boolean paramBoolean5)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null)) {}
    try
    {
      if (paramSosoLbsInfo.a != null)
      {
        double d1 = paramSosoLbsInfo.a.jdField_a_of_type_Double;
        double d2 = paramSosoLbsInfo.a.jdField_b_of_type_Double;
        String str1 = "";
        if (paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString != null) {
          str1 = "" + paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString;
        }
        String str2 = str1;
        if (paramSosoLbsInfo.a.jdField_a_of_type_JavaLangString != null) {
          str2 = str1 + paramSosoLbsInfo.a.jdField_a_of_type_JavaLangString;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager$4.this$0.a(true, d1, d2, str2, null, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
      }
      return;
    }
    catch (Exception paramSosoLbsInfo)
    {
      paramSosoLbsInfo.printStackTrace();
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager$4.this$0.a(false, 0.0D, 0.0D, null, null, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nrl
 * JD-Core Version:    0.7.0.1
 */