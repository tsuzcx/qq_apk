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
  Object a = new Object();
  NearbyResultReceiver b;
  private Intent c;
  private boolean d = false;
  private long e = 0L;
  private long f = 0L;
  private long g = 0L;
  private final int h = 0;
  private final int i = 1;
  private Handler j = new NearbyFakeActivity.1(this);
  
  private void a(int paramInt)
  {
    if (!this.d)
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
      Object localObject1 = this.j;
      boolean bool = false;
      ((Handler)localObject1).removeMessages(0);
      this.d = true;
      try
      {
        startActivity(this.c);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyFakeActivity", 2, localException.getMessage(), localException);
        }
      }
      overridePendingTransition(0, 0);
      long l = System.currentTimeMillis();
      if (this.f <= 0L) {
        this.f = (l - this.e);
      }
      Object localObject2 = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(NetworkUtil.getSystemNetwork(null));
      localStringBuilder.append("");
      ((HashMap)localObject2).put("param_NetType", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(DeviceInfoUtil.O());
      localStringBuilder.append("");
      ((HashMap)localObject2).put("param_DeviceType", localStringBuilder.toString());
      int k;
      if (paramInt == 0) {
        k = 5;
      } else if (paramInt == 1) {
        k = 6;
      } else {
        k = 0;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(k);
      localStringBuilder.append("");
      ((HashMap)localObject2).put("param_enterType", localStringBuilder.toString());
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(getCurrentAccountUin(), "CMD_PRELOAD_NEARBY", true, this.f, this.g, (HashMap)localObject2, "");
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("OpenNearbyAct timeout:");
        if (paramInt == 1) {
          bool = true;
        }
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append(", mPreloadProcTime:");
        ((StringBuilder)localObject2).append(this.f);
        QLog.i("NearbyFakeActivity", 2, ((StringBuilder)localObject2).toString());
      }
      finish();
    }
  }
  
  private void b()
  {
    setTitle(HardCodeUtil.a(2131905006));
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130841087);
    this.rightViewImg.setEnabled(false);
    Drawable localDrawable = getResources().getDrawable(2130839588);
    TextView localTextView = (TextView)findViewById(2131447062);
    this.centerView.setCompoundDrawablePadding(10);
    this.centerView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    ((Animatable)localDrawable).start();
  }
  
  public void a()
  {
    this.f = (System.currentTimeMillis() - this.e);
    a(0);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131625501);
    b();
    this.b = new NearbyResultReceiver(null);
    this.b.a(this);
    this.c = ((Intent)getIntent().getParcelableExtra("intent"));
    this.e = System.currentTimeMillis();
    paramBundle = new Intent(this, NearbyReceiver.class);
    paramBundle.putExtra("nearby_preload_from", 2);
    paramBundle.putExtra("resultreceiver_nearbyfakeactivity", this.b);
    BaseApplicationImpl.getContext().sendBroadcast(paramBundle);
    if (QLog.isColorLevel()) {
      NearbyUtils.a("NearbyFakeActivity", "trace", new Object[] { "NearbyFakeActivity.doOnCreate", Long.valueOf(this.e) });
    }
    int k = DeviceInfoUtil.O();
    if (k >= 2)
    {
      this.j.sendEmptyMessageDelayed(0, 5000L);
      return true;
    }
    if (k >= 1)
    {
      this.j.sendEmptyMessageDelayed(0, 6000L);
      return true;
    }
    this.j.sendEmptyMessageDelayed(0, 8000L);
    return true;
  }
  
  protected void doOnDestroy()
  {
    NearbyResultReceiver localNearbyResultReceiver = this.b;
    if (localNearbyResultReceiver != null) {
      localNearbyResultReceiver.a(null);
    }
    this.j.removeCallbacksAndMessages(null);
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFakeActivity
 * JD-Core Version:    0.7.0.1
 */