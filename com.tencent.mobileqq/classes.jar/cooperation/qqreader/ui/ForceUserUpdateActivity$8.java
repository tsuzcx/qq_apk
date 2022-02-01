package cooperation.qqreader.ui;

import android.content.Intent;
import bmgm;

class ForceUserUpdateActivity$8
  implements Runnable
{
  ForceUserUpdateActivity$8(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void run()
  {
    Intent localIntent1 = this.this$0.getIntent();
    if (localIntent1 != null)
    {
      localIntent1 = (Intent)localIntent1.getParcelableExtra("origin_intent");
      bmgm.d("ForceUserUpdateActivity", "finishForceUpdateIfNeeded: finish");
      Intent localIntent2 = new Intent();
      if (localIntent1 != null) {
        localIntent2.putExtras(localIntent1);
      }
      localIntent2.setClass(this.this$0, ReaderHomePageActivity.class);
      localIntent2.putExtra("extra_key_is_from_force_activity", true);
      localIntent2.putExtra("params_remote_connect_at_launch", true);
      this.this$0.startActivity(localIntent2);
      ForceUserUpdateActivity.a(this.this$0, true);
    }
    for (;;)
    {
      this.this$0.finish();
      return;
      bmgm.a("ForceUserUpdateActivity", "finishForceUpdateIfNeeded: currentIntent = null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.ui.ForceUserUpdateActivity.8
 * JD-Core Version:    0.7.0.1
 */