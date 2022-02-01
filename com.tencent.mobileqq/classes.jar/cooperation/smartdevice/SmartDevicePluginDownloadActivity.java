package cooperation.smartdevice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.util.Observable;
import java.util.Observer;

public class SmartDevicePluginDownloadActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, Observer
{
  private static String e = "SmartDevicePluginDownloadActivity";
  protected Button a;
  QQProgressDialog b = null;
  LinearLayout c = null;
  TextView d = null;
  
  private void a()
  {
    if (this.b == null)
    {
      this.b = new QQProgressDialog(this, super.getResources().getDimensionPixelSize(2131299920));
      this.b.c(2131888809);
    }
    this.b.show();
  }
  
  private void b()
  {
    QQProgressDialog localQQProgressDialog = this.b;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()))
    {
      this.b.cancel();
      this.b = null;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (getIntent().getBooleanExtra("KEY_OPENAV_RECEIVE", false))
    {
      paramBundle = getIntent();
      SmartDevicePluginLoader.a().a(this, this.app, this.app.getAccount(), paramBundle, "com.tencent.device.activities.openav.OpenAVActivity", -1, null, SmartDevicePluginProxyActivity.class);
      finish();
      return false;
    }
    super.setContentView(2131624698);
    super.setTitle(2131888325);
    SmartDevicePluginLoader.a().addObserver(this);
    this.leftView.setText(2131887440);
    this.a = ((Button)super.findViewById(2131431820));
    this.a.setOnClickListener(this);
    this.c = ((LinearLayout)super.findViewById(2131431817));
    this.d = ((TextView)super.findViewById(2131438913));
    if (!NetworkUtil.isWifiConnected(this.app.getApp())) {
      this.c.setVisibility(0);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    SmartDevicePluginLoader.a().deleteObserver(this);
  }
  
  public void onClick(View paramView)
  {
    this.c.setVisibility(4);
    if (!SmartDevicePluginLoader.a().a(this.app))
    {
      a();
      SmartDevicePluginLoader.a().b();
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("nickname", this.app.getCurrentNickname());
    localIntent.putExtra("bitmap", this.app.getFaceBitmap(this.app.getCurrentAccountUin(), (byte)2, false));
    localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
    String str1 = "com.tencent.device.activities.DeviceSearchActivity";
    str2 = str1;
    try
    {
      localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4);
      str2 = str1;
      Object localObject2 = new StringBuilder();
      str2 = str1;
      ((StringBuilder)localObject2).append("enable_public_device_");
      str2 = str1;
      ((StringBuilder)localObject2).append(this.app.getCurrentAccountUin());
      str2 = str1;
      boolean bool = ((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject2).toString(), true);
      str2 = str1;
      localObject2 = new StringBuilder();
      str2 = str1;
      ((StringBuilder)localObject2).append("square_url_");
      str2 = str1;
      ((StringBuilder)localObject2).append(this.app.getCurrentAccountUin());
      str2 = str1;
      localObject2 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "");
      if (bool) {
        str1 = "com.tencent.device.activities.DeviceSquareActivity";
      }
      str2 = str1;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        str2 = str1;
        localIntent.putExtra("url", (String)localObject2);
      }
      str2 = str1;
      localObject2 = new StringBuilder();
      str2 = str1;
      ((StringBuilder)localObject2).append("search_device_enable_https_");
      str2 = str1;
      ((StringBuilder)localObject2).append(this.app.getCurrentAccountUin());
      str2 = str1;
      bool = ((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject2).toString(), false);
      localObject1 = str1;
      str2 = str1;
      if (VersionUtils.d())
      {
        localObject1 = str1;
        if (bool)
        {
          str2 = str1;
          localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
          localObject1 = str1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1 = str2;
      }
    }
    SmartDevicePluginLoader.a().a(this, this.app, this.app.getAccount(), localIntent, (String)localObject1, 0, null, SmartDevicePluginProxyActivity.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if (QLog.isColorLevel())
      {
        paramObject = e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("recv notify : plugin install finished with code ");
        localStringBuilder.append(paramObservable);
        QLog.d(paramObject, 2, localStringBuilder.toString());
      }
      b();
      if (paramObservable.intValue() != 0)
      {
        this.d.setText(2131888799);
        this.c.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.smartdevice.SmartDevicePluginDownloadActivity
 * JD-Core Version:    0.7.0.1
 */