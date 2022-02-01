package cooperation.comic;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class BoodoPluginLoadingDialog
  extends ReportDialog
  implements DialogInterface.OnDismissListener
{
  private BoodoPluginLoadingDialog.HippyActivityLaunchReceiver jdField_a_of_type_CooperationComicBoodoPluginLoadingDialog$HippyActivityLaunchReceiver;
  private final VipComicJumpActivity.LoadingCondition jdField_a_of_type_CooperationComicVipComicJumpActivity$LoadingCondition;
  
  public BoodoPluginLoadingDialog(Context paramContext, VipComicJumpActivity.LoadingCondition paramLoadingCondition)
  {
    super(paramContext, 2131755842);
    setContentView(2131559084);
    this.jdField_a_of_type_CooperationComicVipComicJumpActivity$LoadingCondition = paramLoadingCondition;
    a();
  }
  
  private void a()
  {
    setOnDismissListener(this);
    setCanceledOnTouchOutside(false);
    setCancelable(true);
    Object localObject = getWindow();
    ((Window)localObject).setGravity(80);
    if (Build.VERSION.SDK_INT >= 14)
    {
      ((Window)localObject).setDimAmount(0.0F);
      ((Window)localObject).setGravity(17);
    }
    localObject = LayoutInflater.from(getContext()).inflate(2131560844, null);
    ((ImageView)((View)localObject).findViewById(2131374356)).setImageResource(2130851298);
    setContentView((View)localObject);
    if (this.jdField_a_of_type_CooperationComicBoodoPluginLoadingDialog$HippyActivityLaunchReceiver == null)
    {
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("action_hippy_activity_launch");
      this.jdField_a_of_type_CooperationComicBoodoPluginLoadingDialog$HippyActivityLaunchReceiver = new BoodoPluginLoadingDialog.HippyActivityLaunchReceiver(this, null);
      getContext().registerReceiver(this.jdField_a_of_type_CooperationComicBoodoPluginLoadingDialog$HippyActivityLaunchReceiver, (IntentFilter)localObject);
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_CooperationComicBoodoPluginLoadingDialog$HippyActivityLaunchReceiver != null)
    {
      getContext().unregisterReceiver(this.jdField_a_of_type_CooperationComicBoodoPluginLoadingDialog$HippyActivityLaunchReceiver);
      this.jdField_a_of_type_CooperationComicBoodoPluginLoadingDialog$HippyActivityLaunchReceiver = null;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_CooperationComicVipComicJumpActivity$LoadingCondition != null) {
      this.jdField_a_of_type_CooperationComicVipComicJumpActivity$LoadingCondition.b = true;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.BoodoPluginLoadingDialog
 * JD-Core Version:    0.7.0.1
 */