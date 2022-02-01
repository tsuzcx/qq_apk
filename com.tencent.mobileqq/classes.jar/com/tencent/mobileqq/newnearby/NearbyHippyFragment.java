package com.tencent.mobileqq.newnearby;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.hippy.qq.fragment.HippyErrorViewWrapper;
import com.tencent.hippy.qq.fragment.HippyProgressBarWrapper;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.newnearby.impl.NearbyReportHelperImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class NearbyHippyFragment
  extends BaseHippyFragment
  implements Handler.Callback
{
  private ViewGroup a;
  private ViewGroup b;
  private HippyProgressBarWrapper c = new HippyProgressBarWrapper();
  private HippyErrorViewWrapper d = new HippyErrorViewWrapper();
  private Handler e;
  private boolean f = false;
  
  private void b()
  {
    Object localObject = QBaseActivity.sTopActivity;
    if ((localObject instanceof NearbyActivity)) {
      NearbyReportHelperImpl.reportLoadHippyError((NearbyActivity)localObject);
    }
    if (this.mHippyQQEngine == null) {
      return;
    }
    localObject = generateStepCosts();
    HashMap localHashMap = new HashMap();
    boolean bool = false;
    localHashMap.put("ret", Integer.valueOf(0));
    localHashMap.put("errMsg", getLastStepName());
    if (this.mHippyQQEngine != null) {
      bool = this.mHippyQQEngine.isPreloaded();
    }
    localHashMap.put("isPreload", Boolean.valueOf(bool));
    localHashMap.put("from", getParameters().getString("from"));
    HippyReporter.getInstance().reportHippyLoadResult(6, this.mHippyQQEngine.getModuleName(), this.mHippyQQEngine.getModuleVersion(), localHashMap, (HashMap)localObject);
  }
  
  protected void a()
  {
    if (getParameters().getBoolean("isTransparent")) {
      this.a.setBackgroundColor(0);
    }
    this.b = ((ViewGroup)this.a.findViewById(2131435055));
  }
  
  protected void a(Activity paramActivity, int paramInt)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null)) {
      paramActivity.getWindow().setFlags(paramInt, paramInt);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if ((this.mHippyQQEngine != null) && (this.mHippyQQEngine.isReady())) {
      return;
    }
    this.c.initProgressBar(paramViewGroup);
    this.c.startProgressBar();
  }
  
  protected JSONObject doBussinessInitData(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = getParameters();
      if (localObject != null)
      {
        localObject = (SerializableMap)((Bundle)localObject).getSerializable("js_param_map");
        if (localObject != null)
        {
          localObject = ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).wrapHashMap(paramJSONObject, ((SerializableMap)localObject).getMap());
          if (localObject != null) {
            paramJSONObject = (JSONObject)localObject;
          }
          return paramJSONObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doBussinessInitData:");
      localStringBuilder.append(localThrowable);
      QLog.e("BaseHippyFragment", 1, localStringBuilder.toString());
    }
    return paramJSONObject;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    QLog.d("BaseHippyFragment", 1, "Hippy: load timeout");
    if (this.mHippyQQEngine != null) {
      b();
    }
    return true;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (Build.VERSION.SDK_INT >= 11) {
      a(getQBaseActivity(), 16777216);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        a(getQBaseActivity(), 16777216);
      }
    }
    catch (Throwable paramViewGroup)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCreateView setWindowFlag e:");
      paramBundle.append(paramViewGroup);
      QLog.e("BaseHippyFragment", 1, paramBundle.toString());
    }
    this.e = new Handler(this);
    this.a = ((ViewGroup)paramLayoutInflater.inflate(2131624025, null, false));
    this.b = ((ViewGroup)this.a.findViewById(2131435055));
    a();
    loadHippy(this.b);
    a(this.a);
    paramLayoutInflater = this.e;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.removeMessages(1);
      this.e.sendEmptyMessageDelayed(1, 30000L);
    }
    if (this.mHippyQQEngine != null) {
      this.f = this.mHippyQQEngine.isPreloaded();
    }
    paramLayoutInflater = new StringBuilder();
    paramLayoutInflater.append("begin load hippy, isPreloaded:");
    paramLayoutInflater.append(this.f);
    QLog.i("NearbyHippyFragment", 1, paramLayoutInflater.toString());
    return this.a;
  }
  
  public void onDestroy()
  {
    Handler localHandler = this.e;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    super.onDestroy();
  }
  
  protected void onLoadHippyError(int paramInt, String paramString)
  {
    paramString = this.e;
    if (paramString != null) {
      paramString.removeMessages(1);
    }
    this.c.hideProgressBar();
    paramString = QBaseActivity.sTopActivity;
    if ((paramString instanceof NearbyActivity)) {
      NearbyReportHelperImpl.reportLoadHippyError((NearbyActivity)paramString);
    }
  }
  
  protected void onLoadHippySuccess()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((Handler)localObject).removeMessages(1);
    }
    this.c.hideProgressBar();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Load Hippy Success, isPreloaded:");
    ((StringBuilder)localObject).append(this.f);
    QLog.i("NearbyHippyFragment", 1, ((StringBuilder)localObject).toString());
    localObject = QBaseActivity.sTopActivity;
    if (((localObject instanceof NearbyActivity)) && (!NearbyActivityController.b))
    {
      NearbyActivityController.b = true;
      NearbyReportHelperImpl.reportBeginLoadHippy((NearbyActivity)localObject, this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.NearbyHippyFragment
 * JD-Core Version:    0.7.0.1
 */