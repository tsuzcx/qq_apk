import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import oicq.wlogin_sdk.tools.util;

class rci
  implements Runnable
{
  rci(rch paramrch, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {}
  
  public void run()
  {
    UserInfoModule.a(this.jdField_a_of_type_Rch.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule, null);
    if (this.jdField_a_of_type_Int == 0)
    {
      String str1 = util.buf_to_string(this.jdField_a_of_type_ArrayOfByte);
      String str2 = util.buf_to_string(this.b);
      rcj localrcj = new rcj();
      localrcj.a = str1.toUpperCase();
      localrcj.b = str2.toUpperCase();
      UserInfoModule.a(this.jdField_a_of_type_Rch.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule, localrcj);
      DoraemonUtil.a(this.jdField_a_of_type_Rch.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, localrcj.a());
      return;
    }
    DoraemonUtil.a(this.jdField_a_of_type_Rch.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -12, "get login result error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rci
 * JD-Core Version:    0.7.0.1
 */