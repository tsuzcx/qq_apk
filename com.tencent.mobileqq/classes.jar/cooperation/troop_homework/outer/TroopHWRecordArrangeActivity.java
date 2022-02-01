package cooperation.troop_homework.outer;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TroopHWRecordArrangeActivity
  extends TroopHWRecordBaseActivity
{
  private String f = null;
  private int g = 20;
  private Handler h = new TroopHWRecordArrangeActivity.1(this);
  
  protected void a()
  {
    this.a = ((CommonRecordSoundPanel)LayoutInflater.from(this).inflate(2131625892, null));
    this.a.setPresenter(((IAudioPanelPresenterCreater)QRoute.api(IAudioPanelPresenterCreater.class)).createCommonRecordSoundPanelPresenter(this.a));
    this.b.addView(this.a);
    this.a.a(getAppRuntime(), this, this.h, 0);
    this.a.e();
    this.a.setTimeOutTime(360000);
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
    boolean bool = super.doOnCreate(paramBundle);
    if (getIntent() != null) {
      this.f = getIntent().getStringExtra("webid");
    }
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.outer.TroopHWRecordArrangeActivity
 * JD-Core Version:    0.7.0.1
 */