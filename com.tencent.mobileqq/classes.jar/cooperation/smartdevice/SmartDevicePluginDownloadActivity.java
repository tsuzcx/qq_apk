package cooperation.smartdevice;

import Override;
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
import bisl;
import bmij;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.util.Observable;
import java.util.Observer;

public class SmartDevicePluginDownloadActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, Observer
{
  private static String jdField_a_of_type_JavaLangString = "SmartDevicePluginDownloadActivity";
  protected Button a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  bisl jdField_a_of_type_Bisl = null;
  
  private void a()
  {
    if (this.jdField_a_of_type_Bisl == null)
    {
      this.jdField_a_of_type_Bisl = new bisl(this, super.getResources().getDimensionPixelSize(2131299080));
      this.jdField_a_of_type_Bisl.c(2131691799);
    }
    this.jdField_a_of_type_Bisl.show();
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing()))
    {
      this.jdField_a_of_type_Bisl.cancel();
      this.jdField_a_of_type_Bisl = null;
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (getIntent().getBooleanExtra("KEY_OPENAV_RECEIVE", false))
    {
      paramBundle = getIntent();
      bmij.a().a(this, this.app, this.app.getAccount(), paramBundle, "com.tencent.device.activities.openav.OpenAVActivity", -1, null, SmartDevicePluginProxyActivity.class);
      finish();
      return false;
    }
    super.setContentView(2131559110);
    super.setTitle(2131691338);
    bmij.a().addObserver(this);
    this.leftView.setText(2131690499);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131365594));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131365591));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131371603));
    if (!NetworkUtil.isWifiConnected(this.app.getApp())) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bmij.a().deleteObserver(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    if (!bmij.a().a(this.app))
    {
      a();
      bmij.a().a();
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("nickname", this.app.getCurrentNickname());
    localIntent.putExtra("bitmap", this.app.getFaceBitmap(this.app.getCurrentAccountUin(), (byte)2, false));
    localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
    String str1 = "com.tencent.device.activities.DeviceSearchActivity";
    str2 = str1;
    try
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4);
      str2 = str1;
      boolean bool = ((SharedPreferences)localObject).getBoolean("enable_public_device_" + this.app.getCurrentAccountUin(), true);
      str2 = str1;
      String str3 = ((SharedPreferences)localObject).getString("square_url_" + this.app.getCurrentAccountUin(), "");
      if (bool) {
        str1 = "com.tencent.device.activities.DeviceSquareActivity";
      }
      str2 = str1;
      if (!TextUtils.isEmpty(str3))
      {
        str2 = str1;
        localIntent.putExtra("url", str3);
      }
      str2 = str1;
      bool = ((SharedPreferences)localObject).getBoolean("search_device_enable_https_" + this.app.getCurrentAccountUin(), false);
      localObject = str1;
      str2 = str1;
      if (VersionUtils.isIceScreamSandwich())
      {
        localObject = str1;
        if (bool)
        {
          str2 = str1;
          localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
          localObject = str1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = str2;
      }
    }
    bmij.a().a(this, this.app, this.app.getAccount(), localIntent, (String)localObject, 0, null, SmartDevicePluginProxyActivity.class);
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
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "recv notify : plugin install finished with code " + paramObservable);
      }
      b();
      if (paramObservable.intValue() != 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691789);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.smartdevice.SmartDevicePluginDownloadActivity
 * JD-Core Version:    0.7.0.1
 */