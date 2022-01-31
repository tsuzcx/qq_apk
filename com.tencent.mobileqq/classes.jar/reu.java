import android.os.Bundle;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.DoraemonBridge.Callback;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;

public class reu
  extends DoraemonBridge.Callback
{
  public reu(UserInfoModule paramUserInfoModule, APICallback paramAPICallback) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, new APIParam(paramBundle));
      return;
    }
    DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, 1, "get user info error, try again");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     reu
 * JD-Core Version:    0.7.0.1
 */