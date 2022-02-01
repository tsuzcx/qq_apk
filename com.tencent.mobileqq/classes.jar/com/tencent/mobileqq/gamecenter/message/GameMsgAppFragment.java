package com.tencent.mobileqq.gamecenter.message;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.hippy.qq.fragment.HippyErrorViewWrapper;
import com.tencent.hippy.qq.fragment.HippyProgressBarWrapper;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import org.json.JSONObject;

public class GameMsgAppFragment
  extends BaseHippyFragment
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private HippyErrorViewWrapper jdField_a_of_type_ComTencentHippyQqFragmentHippyErrorViewWrapper = new HippyErrorViewWrapper();
  private HippyProgressBarWrapper jdField_a_of_type_ComTencentHippyQqFragmentHippyProgressBarWrapper = new HippyProgressBarWrapper();
  private ViewGroup b;
  
  private void b()
  {
    if (this.mHippyQQEngine == null) {
      return;
    }
    HashMap localHashMap1 = generateStepCosts();
    HashMap localHashMap2 = new HashMap();
    boolean bool = false;
    localHashMap2.put("ret", Integer.valueOf(0));
    localHashMap2.put("errMsg", getLastStepName());
    if (this.mHippyQQEngine != null) {
      bool = this.mHippyQQEngine.isPreloaded();
    }
    localHashMap2.put("isPreload", Boolean.valueOf(bool));
    localHashMap2.put("from", getParameters().getString("from"));
    HippyReporter.getInstance().reportHippyLoadResult(6, this.mHippyQQEngine.getModuleName(), this.mHippyQQEngine.getModuleVersion(), localHashMap2, localHashMap1);
  }
  
  public void a()
  {
    View.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(null);
    }
  }
  
  protected void a(Activity paramActivity, int paramInt)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null)) {
      paramActivity.getWindow().setFlags(paramInt, paramInt);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if ((this.mHippyQQEngine != null) && (this.mHippyQQEngine.isReady())) {
      return;
    }
    this.jdField_a_of_type_ComTencentHippyQqFragmentHippyProgressBarWrapper.initProgressBar(paramViewGroup);
    this.jdField_a_of_type_ComTencentHippyQqFragmentHippyProgressBarWrapper.startProgressBar();
  }
  
  protected void a(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    paramViewGroup = (FrameLayout)paramViewGroup.findViewById(2131366297);
    if (paramViewGroup.getVisibility() != 0) {
      paramViewGroup.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentHippyQqFragmentHippyErrorViewWrapper.initNetworkErrorView(paramViewGroup, paramOnClickListener);
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
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131558481, null, false));
    this.b = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368190));
    loadHippy(this.b);
    a(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 10000L);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    super.onDestroy();
  }
  
  protected void onLoadHippyError(int paramInt, String paramString)
  {
    paramString = this.jdField_a_of_type_AndroidOsHandler;
    if (paramString != null) {
      paramString.removeMessages(1);
    }
    this.jdField_a_of_type_ComTencentHippyQqFragmentHippyProgressBarWrapper.hideProgressBar();
    a(this.jdField_a_of_type_AndroidViewViewGroup, null);
  }
  
  protected void onLoadHippySuccess()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeMessages(1);
    }
    this.jdField_a_of_type_ComTencentHippyQqFragmentHippyProgressBarWrapper.hideProgressBar();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgAppFragment
 * JD-Core Version:    0.7.0.1
 */