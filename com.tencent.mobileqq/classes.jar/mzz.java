import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.avgame.ui.AVGameOverlayFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class mzz
{
  private BroadcastReceiver a;
  public boolean a;
  private boolean b = true;
  
  private mzz()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new naa(this);
  }
  
  public static mzz a()
  {
    return nab.a;
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
  
  public boolean a(int paramInt, String paramString, mze parammze)
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
        parammze = new Intent();
        parammze.putExtra("type", 1);
        parammze.putExtra("tip", paramString);
        parammze.putExtra("public_fragment_window_feature", 1);
        parammze.setFlags(268435456);
        afez.a(BaseApplicationImpl.getContext(), parammze, PublicTransFragmentActivity.class, AVGameOverlayFragment.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mzz
 * JD-Core Version:    0.7.0.1
 */