import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import eipc.EIPCResult;

class pva
  implements pyb
{
  pva(puy parampuy, int paramInt) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    paramString1 = new Bundle();
    paramString1.putString("action_get_user_info", tym.a(paramString2));
    paramString1 = EIPCResult.createResult(0, paramString1);
    this.jdField_a_of_type_Puy.callbackResult(this.jdField_a_of_type_Int, paramString1);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    paramString = new Bundle();
    paramString.putString("action_get_user_info", tym.a(paramReadInJoyUserInfo));
    paramString = EIPCResult.createResult(0, paramString);
    this.jdField_a_of_type_Puy.callbackResult(this.jdField_a_of_type_Int, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pva
 * JD-Core Version:    0.7.0.1
 */