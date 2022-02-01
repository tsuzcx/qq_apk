package com.tencent.mobileqq.kandian.biz.hippy.tuwen.util;

import android.app.Activity;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.ViewManager;
import android.view.ViewParent;
import androidx.core.util.Pools.Pool;
import androidx.core.util.Pools.SimplePool;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.app.TKDTuWenHippyEngine;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TKDTuWenHippyEngineManager
{
  private static final Pools.Pool<TKDTuWenHippyEngineManager.Entry> ENTRY_POOL = new Pools.SimplePool(5);
  public static final int STATUS_FAIL = 2;
  public static final int STATUS_IDEL = 0;
  public static final int STATUS_LOADING = 1;
  public static final int STATUS_SUCCESS = 3;
  private static final String TAG = "TKDTuWenHippyEngineManager";
  private final Activity activity;
  private TKDTuWenHippyEngineManager.Entry entry;
  private boolean preload;
  private TKDTuWenHippyEngineManager.StatusChangeListener statusChangeListener;
  
  private TKDTuWenHippyEngineManager()
  {
    this.activity = null;
    this.preload = true;
    this.entry = ((TKDTuWenHippyEngineManager.Entry)ENTRY_POOL.acquire());
    if (this.entry == null) {
      prepareEntry();
    }
  }
  
  public TKDTuWenHippyEngineManager(Activity paramActivity)
  {
    this.activity = paramActivity;
    this.entry = ((TKDTuWenHippyEngineManager.Entry)ENTRY_POOL.acquire());
    TKDTuWenHippyEngineManager.Entry localEntry = this.entry;
    if (localEntry == null)
    {
      prepareEntry();
      return;
    }
    localEntry.hippyEngine.setActivity(paramActivity);
  }
  
  private void notifyStatusChange(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyStatusChange, old status = ");
    ((StringBuilder)localObject).append(this.entry.status);
    ((StringBuilder)localObject).append(" new status = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("TKDTuWenHippyEngineManager", 1, ((StringBuilder)localObject).toString());
    if (this.entry.status == paramInt) {
      return;
    }
    this.entry.status = paramInt;
    localObject = this.statusChangeListener;
    if (localObject != null) {
      ((TKDTuWenHippyEngineManager.StatusChangeListener)localObject).onStatusChange(paramInt);
    }
  }
  
  public static void preloadUseTopActivity()
  {
    Looper.myQueue().addIdleHandler(new TKDTuWenHippyEngineManager.1());
  }
  
  private void prepareEntry()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("prepareEntry, preload = ");
    localStringBuilder.append(this.preload);
    QLog.d("TKDTuWenHippyEngineManager", 1, localStringBuilder.toString());
    this.entry = new TKDTuWenHippyEngineManager.Entry();
    notifyStatusChange(1);
    this.entry.hippyEngine = new TKDTuWenHippyEngine(this.activity);
    this.entry.hippyEngine.initHippyInContainer(null, new JSONObject(), false, new TKDTuWenHippyEngineManager.MyEngineListener(this));
  }
  
  private void releaseEntry(TKDTuWenHippyEngineManager.Entry paramEntry)
  {
    QLog.d("TKDTuWenHippyEngineManager", 1, "releaseEntry");
    if (TKDTuWenCommentUtil.isTuWenHippyEngineReuseSwitchOn()) {
      ENTRY_POOL.release(paramEntry);
    }
  }
  
  public void destroy()
  {
    HippyRootView localHippyRootView = this.entry.hippyEngine.getHippyRootView();
    if (localHippyRootView != null)
    {
      ViewParent localViewParent = localHippyRootView.getParent();
      if ((localViewParent instanceof ViewManager)) {
        ((ViewManager)localViewParent).removeView(localHippyRootView);
      }
    }
    this.entry.hippyEngine.setActivity(null);
    this.statusChangeListener = null;
    if (this.entry.status == 3) {
      releaseEntry(this.entry);
    }
  }
  
  public TKDTuWenHippyEngine getEngine()
  {
    return this.entry.hippyEngine;
  }
  
  public int getStatus()
  {
    return this.entry.status;
  }
  
  public void setStatusChangeListener(TKDTuWenHippyEngineManager.StatusChangeListener paramStatusChangeListener)
  {
    this.statusChangeListener = paramStatusChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.util.TKDTuWenHippyEngineManager
 * JD-Core Version:    0.7.0.1
 */