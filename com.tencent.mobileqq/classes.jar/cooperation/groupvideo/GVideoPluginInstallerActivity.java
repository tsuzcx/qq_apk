package cooperation.groupvideo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.format.Time;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.qphone.base.util.MD5;
import cooperation.plugin.IPluginManager;
import java.util.ArrayList;

@RoutePage(desc="群视频插件安装页面", path="/gvideo/plugin/installer")
public class GVideoPluginInstallerActivity
  extends IphoneTitleBarActivity
{
  final String HT_INSTALL_THREAD_NAME = "TroopVideoPluginInstaller";
  final int MSG_OPEN_TROOP_VIDEO = 1;
  final int MSG_PLUGIN_INSTALL_ERROR = 3;
  final int MSG_QUIT = 4;
  final int MSG_SET_TEXT = 2;
  final String TAG = getClass().getSimpleName();
  private final Runnable mInstallRunnable = new GVideoPluginInstallerActivity.3(this);
  Handler mInstallTreadHandler;
  final Handler mMainThreadHandler = new GVideoPluginInstallerActivity.1(this, Looper.getMainLooper());
  private final OnPluginInstallListener mPluginInstallListener = new GVideoPluginInstallerActivity.2(this);
  IPluginManager mPluginManager;
  TextView mTextView;
  
  private void enterTroopVideo()
  {
    Intent localIntent = super.getIntent();
    if (localIntent == null) {
      return;
    }
    if (this.leftView != null) {
      localIntent.putExtra("leftViewString", this.leftView.getText().toString());
    }
    GroupVideoHelper.a(this.app, this, localIntent, 1);
  }
  
  private String getLocalVerify(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(((Time)localObject).year);
    localStringBuilder.append(((Time)localObject).month + 1);
    localStringBuilder.append(((Time)localObject).monthDay);
    localStringBuilder.append(((Time)localObject).hour);
    if (paramBoolean) {
      localStringBuilder.append(((Time)localObject).minute - 1);
    } else {
      localStringBuilder.append(((Time)localObject).minute);
    }
    if (paramArrayList == null) {
      paramArrayList = "null";
    } else {
      paramArrayList = paramArrayList.toString();
    }
    localStringBuilder.append(paramArrayList);
    paramArrayList = MD5.toMD5(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramArrayList);
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    return MD5.toMD5(((StringBuilder)localObject).toString());
  }
  
  private void onPluginInstallError()
  {
    this.mTextView.setText(getString(2131697811));
    this.mMainThreadHandler.sendEmptyMessageDelayed(4, 1000L);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      super.finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    super.setContentView(2131560710);
    super.setTitle(getString(2131697813));
    if ((this.leftView != null) && (getIntent() != null)) {
      this.leftView.setText(getIntent().getExtras().getString("leftViewText"));
    }
    this.mTextView = ((TextView)findViewById(2131378475));
    this.mTextView.setText(getString(2131697812));
    this.mPluginManager = ((IPluginManager)this.app.getManager(QQManagerFactory.MGR_PLUGIN));
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.mMainThreadHandler.removeCallbacksAndMessages(null);
    Object localObject = this.mInstallTreadHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      localObject = this.mInstallTreadHandler.getLooper();
      if (localObject != null) {
        ((Looper)localObject).quit();
      }
    }
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      Object localObject = this.mPluginManager;
      if (localObject == null) {
        return;
      }
      if (((IPluginManager)localObject).isPlugininstalled("group_video_plugin.apk"))
      {
        this.mMainThreadHandler.sendEmptyMessageDelayed(1, 1000L);
        return;
      }
      if (GroupVideoHelper.a(getApplicationContext()))
      {
        localObject = new Intent("com.tencent.process.exit");
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("com.tencent.mobileqq:groupvideo");
        ((Intent)localObject).putStringArrayListExtra("procNameList", localArrayList);
        ((Intent)localObject).putExtra("verify", getLocalVerify(localArrayList, false));
        sendBroadcast((Intent)localObject);
        this.mMainThreadHandler.sendEmptyMessageDelayed(3, 200L);
        return;
      }
      localObject = new HandlerThread("TroopVideoPluginInstaller", 10);
      ((HandlerThread)localObject).start();
      this.mInstallTreadHandler = new Handler(((HandlerThread)localObject).getLooper());
      this.mInstallTreadHandler.postDelayed(this.mInstallRunnable, 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.groupvideo.GVideoPluginInstallerActivity
 * JD-Core Version:    0.7.0.1
 */