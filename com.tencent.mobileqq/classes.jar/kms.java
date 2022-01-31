import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public final class kms
  implements TroopMemberApiClient.Callback
{
  public kms(Activity paramActivity, boolean paramBoolean, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle.getInt("currentFragment", -1) == 2)
    {
      paramBundle = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
      paramBundle.setFlags(67108864);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramBundle);
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      paramBundle = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      paramBundle.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      paramBundle.putExtra("uintype", 1);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramBundle);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.setResult(4660);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kms
 * JD-Core Version:    0.7.0.1
 */