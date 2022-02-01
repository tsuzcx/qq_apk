import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.avgame.ui.AVGameOverlayFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class nba
{
  private BroadcastReceiver a;
  public boolean a;
  private boolean b = true;
  
  private nba()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new nbb(this);
  }
  
  public static nba a()
  {
    return nbc.a;
  }
  
  private void c()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    c();
  }
  
  public boolean a(int paramInt, String paramString, naf paramnaf)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("GlobalExitRoomManagement", 2, "onRoomSelfExit: exitType:" + paramInt + "  exitRoomTip:" + paramString);
    }
    switch (paramInt)
    {
    case 0: 
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      if ((paramInt != 0) && (!this.jdField_a_of_type_Boolean) && (this.b))
      {
        paramnaf = new Intent();
        paramnaf.putExtra("type", 1);
        paramnaf.putExtra("tip", paramString);
        paramnaf.putExtra("public_fragment_window_feature", 1);
        paramnaf.setFlags(268435456);
        adxr.a(BaseApplicationImpl.getContext(), paramnaf, PublicTransFragmentActivity.class, AVGameOverlayFragment.class);
      }
      return bool;
      paramInt = 0;
      continue;
      bool = true;
      paramInt = 1;
      continue;
      paramInt = 1;
      continue;
      paramInt = 0;
    }
  }
  
  public void b()
  {
    BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nba
 * JD-Core Version:    0.7.0.1
 */