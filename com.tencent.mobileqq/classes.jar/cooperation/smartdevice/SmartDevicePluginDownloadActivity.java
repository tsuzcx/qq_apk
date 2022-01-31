package cooperation.smartdevice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import badq;
import bbms;
import befo;
import bgnd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
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
  bbms jdField_a_of_type_Bbms = null;
  
  private void a()
  {
    if (this.jdField_a_of_type_Bbms == null)
    {
      this.jdField_a_of_type_Bbms = new bbms(this, super.getResources().getDimensionPixelSize(2131167766));
      this.jdField_a_of_type_Bbms.c(2131626354);
    }
    this.jdField_a_of_type_Bbms.show();
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing()))
    {
      this.jdField_a_of_type_Bbms.cancel();
      this.jdField_a_of_type_Bbms = null;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (getIntent().getBooleanExtra("KEY_OPENAV_RECEIVE", false))
    {
      paramBundle = getIntent();
      bgnd.a().a(this, this.app, this.app.getAccount(), paramBundle, "com.tencent.device.activities.openav.OpenAVActivity", -1, null, SmartDevicePluginProxyActivity.class);
      finish();
      return false;
    }
    super.setContentView(2131493408);
    super.setTitle(2131625801);
    bgnd.a().addObserver(this);
    this.leftView.setText(2131624770);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131299531));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131299528));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131304797));
    if (!badq.h(this.app.getApp())) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bgnd.a().deleteObserver(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    if (!bgnd.a().a(this.app))
    {
      a();
      bgnd.a().a();
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("nickname", this.app.getCurrentNickname());
    localIntent.putExtra("bitmap", this.app.a(this.app.getCurrentAccountUin(), (byte)2, false));
    localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
    paramView = "com.tencent.device.activities.DeviceSearchActivity";
    localView = paramView;
    try
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4);
      localView = paramView;
      boolean bool = ((SharedPreferences)localObject).getBoolean("enable_public_device_" + this.app.getCurrentAccountUin(), true);
      localView = paramView;
      String str = ((SharedPreferences)localObject).getString("square_url_" + this.app.getCurrentAccountUin(), "");
      if (bool) {
        paramView = "com.tencent.device.activities.DeviceSquareActivity";
      }
      localView = paramView;
      if (!TextUtils.isEmpty(str))
      {
        localView = paramView;
        localIntent.putExtra("url", str);
      }
      localView = paramView;
      bool = ((SharedPreferences)localObject).getBoolean("search_device_enable_https_" + this.app.getCurrentAccountUin(), false);
      localObject = paramView;
      localView = paramView;
      if (befo.d())
      {
        localObject = paramView;
        if (bool)
        {
          localView = paramView;
          localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
          localObject = paramView;
        }
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Object localObject = localView;
      }
    }
    bgnd.a().a(this, this.app, this.app.getAccount(), localIntent, (String)localObject, 0, null, SmartDevicePluginProxyActivity.class);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131626347);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.smartdevice.SmartDevicePluginDownloadActivity
 * JD-Core Version:    0.7.0.1
 */