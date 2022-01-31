package cooperation.groupvideo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.format.Time;
import android.widget.TextView;
import bgju;
import bgjv;
import bgjy;
import bgkq;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;

public class GVideoPluginInstallerActivity
  extends IphoneTitleBarActivity
{
  final int jdField_a_of_type_Int = 1;
  Handler jdField_a_of_type_AndroidOsHandler;
  public TextView a;
  bgkq jdField_a_of_type_Bgkq;
  private final OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new bgjv(this);
  private final Runnable jdField_a_of_type_JavaLangRunnable = new GVideoPluginInstallerActivity.3(this);
  public final String a;
  final int jdField_b_of_type_Int = 2;
  public final Handler b;
  final String jdField_b_of_type_JavaLangString = "TroopVideoPluginInstaller";
  final int c = 3;
  final int d = 4;
  
  public GVideoPluginInstallerActivity()
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    this.jdField_b_of_type_AndroidOsHandler = new bgju(this, Looper.getMainLooper());
  }
  
  private String a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label142;
      }
    }
    label142:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  private void a()
  {
    Intent localIntent = super.getIntent();
    if (localIntent == null) {
      return;
    }
    if (this.leftView != null) {
      localIntent.putExtra("leftViewString", this.leftView.getText().toString());
    }
    bgjy.a(this.app, this, localIntent, 1);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131698043));
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      super.finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    super.setContentView(2131560407);
    super.setTitle(getString(2131698045));
    if ((this.leftView != null) && (getIntent() != null)) {
      this.leftView.setText(getIntent().getExtras().getString("leftViewText"));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377043));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131698044));
    this.jdField_a_of_type_Bgkq = ((bgkq)this.app.getManager(27));
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      Looper localLooper = this.jdField_a_of_type_AndroidOsHandler.getLooper();
      if (localLooper != null) {
        localLooper.quit();
      }
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((!paramBoolean) || (this.jdField_a_of_type_Bgkq == null)) {
      return;
    }
    if (this.jdField_a_of_type_Bgkq.isPlugininstalled("group_video_plugin.apk"))
    {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    if (bgjy.a(getApplicationContext()))
    {
      localObject = new Intent("com.tencent.process.exit");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("com.tencent.mobileqq:groupvideo");
      ((Intent)localObject).putStringArrayListExtra("procNameList", localArrayList);
      ((Intent)localObject).putExtra("verify", a(localArrayList, false));
      sendBroadcast((Intent)localObject);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 200L);
      return;
    }
    Object localObject = new HandlerThread("TroopVideoPluginInstaller", 10);
    ((HandlerThread)localObject).start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(((HandlerThread)localObject).getLooper());
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.groupvideo.GVideoPluginInstallerActivity
 * JD-Core Version:    0.7.0.1
 */