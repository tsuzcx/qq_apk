package cooperation.troop_homework.outer;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;

public class TroopHWRecordBaseActivity
  extends QBaseActivity
{
  protected CommonRecordSoundPanel a;
  protected RelativeLayout b;
  protected View c;
  protected AudioInfo d;
  protected boolean e = false;
  private View.OnClickListener f = new TroopHWRecordBaseActivity.1(this);
  
  private void a(Resources paramResources, View paramView)
  {
    paramResources = paramResources.getDrawable(2130852413);
    if ((paramResources instanceof BitmapDrawable)) {
      paramResources = ((BitmapDrawable)paramResources).getBitmap();
    } else if ((paramResources instanceof SkinnableBitmapDrawable)) {
      paramResources = ((SkinnableBitmapDrawable)paramResources).getBitmap();
    } else {
      paramResources = null;
    }
    paramResources = new BitmapDrawable(paramResources);
    paramResources.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    paramResources.setDither(true);
    paramView.setBackgroundDrawable(paramResources);
  }
  
  private void b()
  {
    this.c = findViewById(2131447813);
    this.c.setBackgroundColor(1291845632);
    this.c.setOnClickListener(this.f);
    this.b = ((RelativeLayout)findViewById(2131444487));
    a(getResources(), this.b);
    a();
  }
  
  protected void a() {}
  
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
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    setContentView(2131626714);
    b();
    return true;
  }
  
  public void finish()
  {
    super.finish();
    this.c.setBackgroundResource(2130853313);
  }
  
  public boolean onBackEvent()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onBackEvent() is called,isRecording is:");
      localStringBuilder.append(this.a.a());
      QLog.d("TroopHomeworkRecordActivity", 2, localStringBuilder.toString());
    }
    this.a.b();
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordPanel.onDestroy() is called,isRecording is:");
      localStringBuilder.append(this.a.a());
      QLog.d("TroopHomeworkRecordActivity", 2, localStringBuilder.toString());
    }
    this.a.d();
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordPanel.onPause() is called,isRecording is:");
      localStringBuilder.append(this.a.a());
      QLog.d("TroopHomeworkRecordActivity", 2, localStringBuilder.toString());
    }
    this.a.c();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.outer.TroopHWRecordBaseActivity
 * JD-Core Version:    0.7.0.1
 */