package com.tencent.rtmp.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.screencapture.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@TargetApi(21)
public class TXScreenCapture$TXScreenCaptureAssistantActivity
  extends Activity
{
  private static final int REQUEST_CODE = 100;
  private static final String TAG = "TXScreenCaptureAssistantActivity";
  private MediaProjectionManager mMediaProjectionManager;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityResult ");
    localStringBuilder.append(this);
    TXCLog.i("TXScreenCaptureAssistantActivity", localStringBuilder.toString());
    paramIntent = this.mMediaProjectionManager.getMediaProjection(paramInt2, paramIntent);
    c.a(this).a(paramIntent);
    finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new StringBuilder();
    paramBundle.append("onCreate ");
    paramBundle.append(this);
    TXCLog.i("TXScreenCaptureAssistantActivity", paramBundle.toString());
    requestWindowFeature(1);
    this.mMediaProjectionManager = ((MediaProjectionManager)getApplicationContext().getSystemService("media_projection"));
    paramBundle = this.mMediaProjectionManager.createScreenCaptureIntent();
    try
    {
      startActivityForResult(paramBundle, 100);
      return;
    }
    catch (Exception paramBundle)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start permission activity failed. ");
      localStringBuilder.append(paramBundle);
      TXCLog.e("TXScreenCaptureAssistantActivity", localStringBuilder.toString());
      c.a(this).a(null);
      finish();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy ");
    localStringBuilder.append(this);
    TXCLog.i("TXScreenCaptureAssistantActivity", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.video.TXScreenCapture.TXScreenCaptureAssistantActivity
 * JD-Core Version:    0.7.0.1
 */