import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

class sfy
  implements Runnable
{
  sfy(sfx paramsfx, int paramInt, DevlockInfo paramDevlockInfo) {}
  
  public void run()
  {
    boolean bool2 = true;
    this.jdField_a_of_type_Sfx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.d();
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null))
    {
      ChatHistoryForC2C localChatHistoryForC2C = this.jdField_a_of_type_Sfx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C;
      boolean bool1;
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
      {
        bool1 = true;
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet != 1) {
          break label77;
        }
      }
      for (;;)
      {
        localChatHistoryForC2C.a(bool1, bool2, this.jdField_a_of_type_Sfx.jdField_a_of_type_Boolean);
        return;
        bool1 = false;
        break;
        label77:
        bool2 = false;
      }
    }
    if (1 == this.jdField_a_of_type_Sfx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a.b())
    {
      this.jdField_a_of_type_Sfx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.g();
      return;
    }
    if (!this.jdField_a_of_type_Sfx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a.f())
    {
      this.jdField_a_of_type_Sfx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.b();
      return;
    }
    this.jdField_a_of_type_Sfx.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.b(this.jdField_a_of_type_Sfx.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sfy
 * JD-Core Version:    0.7.0.1
 */