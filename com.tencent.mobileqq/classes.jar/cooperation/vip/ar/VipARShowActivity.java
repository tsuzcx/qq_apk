package cooperation.vip.ar;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;
import bhyi;
import bhyv;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;
import mqq.os.MqqHandler;

public class VipARShowActivity
  extends AppActivity
  implements QQPermissionCallback
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bhyi jdField_a_of_type_Bhyi;
  
  private void a()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      if (checkSelfPermission("android.permission.CAMERA") == 0) {
        break label39;
      }
    }
    label39:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
      }
      return;
    }
  }
  
  private void b()
  {
    if ("value_refer_aio".equalsIgnoreCase(getIntent().getStringExtra("key_refer"))) {
      bhyv.a("ar_aio_click", "1");
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Bhyi = new bhyi(this, this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_Bhyi.a();
    Intent localIntent = getIntent();
    this.jdField_a_of_type_Bhyi.a(localIntent.getStringExtra("modelResUrl"), localIntent.getStringExtra("modelResMd5"));
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    Toast.makeText(this, 2131695951, 0).show();
    ThreadManager.getUIHandler().postDelayed(new VipARShowActivity.1(this), 2000L);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    b();
    setContentView(2131558459);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131362716));
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Bhyi != null) {
      this.jdField_a_of_type_Bhyi.f();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Bhyi != null) {
      this.jdField_a_of_type_Bhyi.c();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Bhyi != null) {
      this.jdField_a_of_type_Bhyi.d();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_Bhyi != null) {
      this.jdField_a_of_type_Bhyi.e();
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Bhyi.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.ar.VipARShowActivity
 * JD-Core Version:    0.7.0.1
 */