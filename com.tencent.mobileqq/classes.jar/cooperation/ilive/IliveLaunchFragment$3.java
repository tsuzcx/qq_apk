package cooperation.ilive;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import blul;
import blvl;
import com.tencent.qphone.base.util.QLog;

class IliveLaunchFragment$3
  implements Runnable
{
  IliveLaunchFragment$3(IliveLaunchFragment paramIliveLaunchFragment, Context paramContext, boolean paramBoolean) {}
  
  public void run()
  {
    blvl.a("IliveLaunch executeOnSubThread");
    blul.a().b();
    blul.a().a(this.this$0);
    IliveLaunchFragment.access$102(this.this$0, blul.a().b());
    QLog.e("IliveLaunchActivity", 1, "onCreateView thread isPluginFileExist = " + IliveLaunchFragment.access$100(this.this$0) + " mIsSoLoadSuccess = " + IliveLaunchFragment.access$200(this.this$0));
    if ((IliveLaunchFragment.access$100(this.this$0)) && (IliveLaunchFragment.access$200(this.this$0)))
    {
      IliveLaunchFragment localIliveLaunchFragment = this.this$0;
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      Intent localIntent;
      if (this.jdField_a_of_type_Boolean) {
        localIntent = new Intent();
      }
      for (;;)
      {
        localIliveLaunchFragment.enterPlugin(localContext, localIntent);
        return;
        if (this.this$0.getActivity() == null) {
          localIntent = new Intent();
        } else {
          localIntent = this.this$0.getActivity().getIntent();
        }
      }
    }
    if (!this.jdField_a_of_type_Boolean) {
      IliveLaunchFragment.access$300(this.this$0);
    }
    IliveLaunchFragment.access$400(this.this$0);
    blvl.b("IliveLaunch executeOnSubThread");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.IliveLaunchFragment.3
 * JD-Core Version:    0.7.0.1
 */