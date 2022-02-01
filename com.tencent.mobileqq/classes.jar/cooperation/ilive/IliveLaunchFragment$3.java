package cooperation.ilive;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.util.ElapseStat;

class IliveLaunchFragment$3
  implements Runnable
{
  IliveLaunchFragment$3(IliveLaunchFragment paramIliveLaunchFragment, Context paramContext, boolean paramBoolean) {}
  
  public void run()
  {
    ElapseStat.a("IliveLaunch executeOnSubThread");
    IlivePluginDownloadManager.a().b();
    IlivePluginDownloadManager.a().a(this.this$0);
    IliveLaunchFragment.access$102(this.this$0, IlivePluginDownloadManager.a().b());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreateView thread isPluginFileExist = ");
    ((StringBuilder)localObject).append(IliveLaunchFragment.access$100(this.this$0));
    ((StringBuilder)localObject).append(" mIsSoLoadSuccess = ");
    ((StringBuilder)localObject).append(IliveLaunchFragment.access$200(this.this$0));
    QLog.e("IliveLaunchActivity", 1, ((StringBuilder)localObject).toString());
    if ((IliveLaunchFragment.access$100(this.this$0)) && (IliveLaunchFragment.access$200(this.this$0)))
    {
      IliveLaunchFragment localIliveLaunchFragment = this.this$0;
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      if (this.jdField_a_of_type_Boolean) {
        localObject = new Intent();
      } else if (localIliveLaunchFragment.getBaseActivity() == null) {
        localObject = new Intent();
      } else {
        localObject = this.this$0.getBaseActivity().getIntent();
      }
      localIliveLaunchFragment.enterPlugin(localContext, (Intent)localObject);
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      IliveLaunchFragment.access$300(this.this$0);
    }
    IliveLaunchFragment.access$400(this.this$0);
    ElapseStat.b("IliveLaunch executeOnSubThread");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.IliveLaunchFragment.3
 * JD-Core Version:    0.7.0.1
 */