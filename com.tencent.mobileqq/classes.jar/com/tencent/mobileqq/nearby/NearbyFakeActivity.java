package com.tencent.mobileqq.nearby;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class NearbyFakeActivity
  extends IphoneTitleBarActivity
{
  private final int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Handler jdField_a_of_type_AndroidOsHandler = new NearbyFakeActivity.1(this);
  NearbyResultReceiver jdField_a_of_type_ComTencentMobileqqNearbyNearbyResultReceiver;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean = false;
  private final int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long = 0L;
  private long c = 0L;
  
  private void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (isFinishing()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("OpenNearbyAct from:");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.i("NearbyFakeActivity", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = this.jdField_a_of_type_AndroidOsHandler;
      boolean bool = false;
      ((Handler)localObject1).removeMessages(0);
      this.jdField_a_of_type_Boolean = true;
      try
      {
        startActivity(this.jdField_a_of_type_AndroidContentIntent);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyFakeActivity", 2, localException.getMessage(), localException);
        }
      }
      overridePendingTransition(0, 0);
      long l = System.currentTimeMillis();
      if (this.jdField_b_of_type_Long <= 0L) {
        this.jdField_b_of_type_Long = (l - this.jdField_a_of_type_Long);
      }
      Object localObject2 = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(NetworkUtil.getSystemNetwork(null));
      localStringBuilder.append("");
      ((HashMap)localObject2).put("param_NetType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(DeviceInfoUtil.f());
      localStringBuilder.append("");
      ((HashMap)localObject2).put("param_DeviceType", localStringBuilder.toString());
      int i;
      if (paramInt == 0) {
        i = 5;
      } else if (paramInt == 1) {
        i = 6;
      } else {
        i = 0;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      ((HashMap)localObject2).put("param_enterType", localStringBuilder.toString());
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(getCurrentAccountUin(), "CMD_PRELOAD_NEARBY", true, this.jdField_b_of_type_Long, this.c, (HashMap)localObject2, "");
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("OpenNearbyAct timeout:");
        if (paramInt == 1) {
          bool = true;
        }
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append(", mPreloadProcTime:");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_Long);
        QLog.i("NearbyFakeActivity", 2, ((StringBuilder)localObject2).toString());
      }
      finish();
    }
  }
  
  private void b()
  {
    setTitle(HardCodeUtil.a(2131707173));
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130840347);
    this.rightViewImg.setEnabled(false);
    Drawable localDrawable = getResources().getDrawable(2130839404);
    TextView localTextView = (TextView)findViewById(2131378460);
    this.centerView.setCompoundDrawablePadding(10);
    this.centerView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    ((Animatable)localDrawable).start();
  }
  
  public void a()
  {
    this.jdField_b_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
    a(0);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559481);
    b();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyResultReceiver = new NearbyResultReceiver(null);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyResultReceiver.a(this);
    this.jdField_a_of_type_AndroidContentIntent = ((Intent)getIntent().getParcelableExtra("intent"));
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = new Intent(this, NearbyReceiver.class);
    paramBundle.putExtra("nearby_preload_from", 2);
    paramBundle.putExtra("resultreceiver_nearbyfakeactivity", this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyResultReceiver);
    BaseApplicationImpl.getContext().sendBroadcast(paramBundle);
    if (QLog.isColorLevel()) {
      NearbyUtils.a("NearbyFakeActivity", "trace", new Object[] { "NearbyFakeActivity.doOnCreate", Long.valueOf(this.jdField_a_of_type_Long) });
    }
    int i = DeviceInfoUtil.f();
    if (i >= 2)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 5000L);
      return true;
    }
    if (i >= 1)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 6000L);
      return true;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 8000L);
    return true;
  }
  
  protected void doOnDestroy()
  {
    NearbyResultReceiver localNearbyResultReceiver = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyResultReceiver;
    if (localNearbyResultReceiver != null) {
      localNearbyResultReceiver.a(null);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFakeActivity
 * JD-Core Version:    0.7.0.1
 */