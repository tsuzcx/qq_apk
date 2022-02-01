package com.tencent.qflutter;

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
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void onClick(View paramView) {}
  
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
    setContentView(2131296285);
    this.mOpenFlutter = ((TextView)findViewById(2131165343));
    this.mOpenFlutterFragment = ((TextView)findViewById(2131165342));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qflutter.MainActivity
 * JD-Core Version:    0.7.0.1
 */