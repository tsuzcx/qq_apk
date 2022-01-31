package com.tencent.mobileqq.nearby;

import aelv;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class NearbyFakeActivity
  extends IphoneTitleBarActivity
{
  private final int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Handler jdField_a_of_type_AndroidOsHandler = new aelv(this);
  NearbyResultReceiver jdField_a_of_type_ComTencentMobileqqNearbyNearbyResultReceiver;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private long c;
  
  private void a(int paramInt)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Boolean) || (isFinishing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NearbyFakeActivity", 2, "OpenNearbyAct from:" + paramInt);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_Boolean = true;
    try
    {
      startActivity(this.jdField_a_of_type_AndroidContentIntent);
      overridePendingTransition(0, 0);
      long l = System.currentTimeMillis();
      if (this.jdField_b_of_type_Long <= 0L) {
        this.jdField_b_of_type_Long = (l - this.jdField_a_of_type_Long);
      }
      Object localObject = new HashMap();
      ((HashMap)localObject).put("param_NetType", NetworkUtil.a(null) + "");
      ((HashMap)localObject).put("param_DeviceType", StatisticConstants.a() + "");
      if (paramInt == 0)
      {
        i = 5;
        ((HashMap)localObject).put("param_enterType", i + "");
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(getCurrentAccountUin(), "CMD_PRELOAD_NEARBY", true, this.jdField_b_of_type_Long, this.c, (HashMap)localObject, "");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("OpenNearbyAct timeout:");
          if (paramInt != 1) {
            break label321;
          }
          QLog.i("NearbyFakeActivity", 2, bool + ", mPreloadProcTime:" + this.jdField_b_of_type_Long);
        }
        finish();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.i("NearbyFakeActivity", 2, localException.getMessage(), localException);
          continue;
          if (paramInt == 1)
          {
            i = 6;
            continue;
            label321:
            bool = false;
          }
          else
          {
            i = 0;
          }
        }
      }
    }
  }
  
  @TargetApi(11)
  public static void a(Context paramContext, Intent paramIntent)
  {
    boolean bool = a();
    if (QLog.isColorLevel()) {
      QLog.i("NearbyFakeActivity", 2, "openNearbyActWithPreLoad, isNearbyProcessExist=" + bool);
    }
    if (bool)
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    Intent localIntent = new Intent(paramContext, NearbyFakeActivity.class);
    localIntent.putExtra("intent", paramIntent);
    paramContext.startActivity(localIntent);
  }
  
  public static boolean a()
  {
    return PreloadProcHitSession.a("com.tencent.mobileqq:tool");
  }
  
  private void b()
  {
    setTitle("附近");
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130839147);
    this.rightViewImg.setEnabled(false);
    Drawable localDrawable = getResources().getDrawable(2130838598);
    TextView localTextView = (TextView)findViewById(2131363632);
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
    setContentView(2130969114);
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
    int i = StatisticConstants.a();
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
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyResultReceiver != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyResultReceiver.a(null);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFakeActivity
 * JD-Core Version:    0.7.0.1
 */