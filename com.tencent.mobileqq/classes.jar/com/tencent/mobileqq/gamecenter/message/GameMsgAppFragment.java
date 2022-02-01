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
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.hippy.qq.fragment.HippyErrorViewWrapper;
import com.tencent.hippy.qq.fragment.HippyProgressBarWrapper;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
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
    boolean bool = false;
    if (this.mHippyQQEngine == null) {
      return;
    }
    HashMap localHashMap1 = generateStepCosts();
    HashMap localHashMap2 = new HashMap();
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
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(null);
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
    paramViewGroup = (FrameLayout)paramViewGroup.findViewById(2131366416);
    if (paramViewGroup.getVisibility() != 0) {
      paramViewGroup.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentHippyQqFragmentHippyErrorViewWrapper.initNetworkErrorView(paramViewGroup, paramOnClickListener);
  }
  
  public JSONObject doBussinessInitData(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject2 = getParameters();
      Object localObject1 = paramJSONObject;
      if (localObject2 != null)
      {
        localObject2 = (SerializableMap)((Bundle)localObject2).getSerializable("js_param_map");
        localObject1 = paramJSONObject;
        if (localObject2 != null)
        {
          localObject2 = HippyAccessHelper.wrapHashMap(paramJSONObject, ((SerializableMap)localObject2).getMap());
          localObject1 = paramJSONObject;
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
        }
      }
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseHippyFragment", 1, "doBussinessInitData:" + localThrowable);
    }
    return paramJSONObject;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
      QLog.d("BaseHippyFragment", 1, "Hippy: load timeout");
    } while (this.mHippyQQEngine == null);
    b();
    return true;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (Build.VERSION.SDK_INT >= 11) {
      a(getActivity(), 16777216);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        a(getActivity(), 16777216);
      }
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131558452, null, false));
      this.b = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368438));
      loadHippy(this.b);
      a(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 10000L);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
    catch (Throwable paramViewGroup)
    {
      for (;;)
      {
        QLog.e("BaseHippyFragment", 1, "onCreateView setWindowFlag e:" + paramViewGroup);
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    super.onDestroy();
  }
  
  public void onLoadHippyError(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    this.jdField_a_of_type_ComTencentHippyQqFragmentHippyProgressBarWrapper.hideProgressBar();
    a(this.jdField_a_of_type_AndroidViewViewGroup, null);
  }
  
  public void onLoadHippySuccess()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgAppFragment
 * JD-Core Version:    0.7.0.1
 */