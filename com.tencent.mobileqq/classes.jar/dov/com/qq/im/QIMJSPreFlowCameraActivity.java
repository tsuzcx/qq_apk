package dov.com.qq.im;

import Override;
import aluf;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import bodt;
import bplq;
import bpmw;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QIMJSPreFlowCameraActivity
  extends BaseActivity
{
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    Intent localIntent = getIntent();
    paramBundle = localIntent.getStringExtra("videoId");
    if (!TextUtils.isEmpty(paramBundle)) {}
    for (;;)
    {
      try
      {
        Integer.valueOf(paramBundle).intValue();
        super.finish();
        return true;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        continue;
      }
      ((bpmw)bplq.a(5)).g();
      int i = localIntent.getIntExtra("firsttab", 0);
      int j = localIntent.getIntExtra("secondtab", 0);
      String str = localIntent.getStringExtra("itemid");
      int k = localIntent.getIntExtra("type", 0);
      int m = localIntent.getIntExtra("direction", 1);
      int n = localIntent.getIntExtra("WebSceneType", aluf.d);
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
      bodt.a(this, 4, 10007, 7, -1, i, j, paramBundle, 0, true, k, m, n, localIntent.getExtras());
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMJSPreFlowCameraActivity
 * JD-Core Version:    0.7.0.1
 */