package com.tencent.qflutter;

import Override;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qflutter.utils.FLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import io.flutter.app.FlutterActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class MainActivity
  extends FlutterActivity
  implements View.OnClickListener
{
  public static WeakReference<MainActivity> sRef;
  private TextView mOpenFlutter;
  private TextView mOpenFlutterFragment;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("test1", "v_test1");
    localHashMap.put("test2", "v_test2");
    if (paramView == this.mOpenFlutter) {
      PageRouter.openPageByUrl(this, "qflutter://home_page", localHashMap);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.mOpenFlutterFragment) {
        PageRouter.openPageByUrl(this, "qflutter://color_list", localHashMap);
      }
    }
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
    sRef = new WeakReference(this);
    setContentView(2131296284);
    this.mOpenFlutter = ((TextView)findViewById(2131165303));
    this.mOpenFlutterFragment = ((TextView)findViewById(2131165302));
    this.mOpenFlutter.setOnClickListener(this);
    this.mOpenFlutterFragment.setOnClickListener(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (sRef != null)
    {
      sRef.clear();
      sRef = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResume: ");
    localStringBuilder.append(hashCode());
    FLog.i("QFlutter", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qflutter.MainActivity
 * JD-Core Version:    0.7.0.1
 */