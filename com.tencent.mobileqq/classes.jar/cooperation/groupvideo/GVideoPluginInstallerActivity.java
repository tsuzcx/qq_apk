package cooperation.groupvideo;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.format.Time;
import android.view.MotionEvent;
import android.widget.TextView;
import bmei;
import bmej;
import bmem;
import bmgk;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class GVideoPluginInstallerActivity
  extends IphoneTitleBarActivity
{
  final int jdField_a_of_type_Int = 1;
  Handler jdField_a_of_type_AndroidOsHandler;
  public TextView a;
  bmgk jdField_a_of_type_Bmgk;
  private final OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new bmej(this);
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
    this.jdField_b_of_type_AndroidOsHandler = new bmei(this, Looper.getMainLooper());
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
    bmem.a(this.app, this, localIntent, 1);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131697132));
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
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
    super.setContentView(2131560682);
    super.setTitle(getString(2131697134));
    if ((this.leftView != null) && (getIntent() != null)) {
      this.leftView.setText(getIntent().getExtras().getString("leftViewText"));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378617));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131697133));
    this.jdField_a_of_type_Bmgk = ((bmgk)this.app.getManager(27));
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
    if ((!paramBoolean) || (this.jdField_a_of_type_Bmgk == null)) {
      return;
    }
    if (this.jdField_a_of_type_Bmgk.isPlugininstalled("group_video_plugin.apk"))
    {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    if (bmem.a(getApplicationContext()))
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.groupvideo.GVideoPluginInstallerActivity
 * JD-Core Version:    0.7.0.1
 */