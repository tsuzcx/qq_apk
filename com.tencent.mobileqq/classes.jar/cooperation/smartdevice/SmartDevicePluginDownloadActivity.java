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
import bdee;
import bepp;
import bhou;
import bjxx;
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
  bepp jdField_a_of_type_Bepp = null;
  
  private void a()
  {
    if (this.jdField_a_of_type_Bepp == null)
    {
      this.jdField_a_of_type_Bepp = new bepp(this, super.getResources().getDimensionPixelSize(2131298914));
      this.jdField_a_of_type_Bepp.c(2131691992);
    }
    this.jdField_a_of_type_Bepp.show();
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing()))
    {
      this.jdField_a_of_type_Bepp.cancel();
      this.jdField_a_of_type_Bepp = null;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (getIntent().getBooleanExtra("KEY_OPENAV_RECEIVE", false))
    {
      paramBundle = getIntent();
      bjxx.a().a(this, this.app, this.app.getAccount(), paramBundle, "com.tencent.device.activities.openav.OpenAVActivity", -1, null, SmartDevicePluginProxyActivity.class);
      finish();
      return false;
    }
    super.setContentView(2131559008);
    super.setTitle(2131691430);
    bjxx.a().addObserver(this);
    this.leftView.setText(2131690382);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131365183));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131365180));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370763));
    if (!bdee.h(this.app.getApp())) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bjxx.a().deleteObserver(this);
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    if (!bjxx.a().a(this.app))
    {
      a();
      bjxx.a().a();
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
      if (bhou.d())
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
    bjxx.a().a(this, this.app, this.app.getAccount(), localIntent, (String)localObject, 0, null, SmartDevicePluginProxyActivity.class);
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691985);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.smartdevice.SmartDevicePluginDownloadActivity
 * JD-Core Version:    0.7.0.1
 */