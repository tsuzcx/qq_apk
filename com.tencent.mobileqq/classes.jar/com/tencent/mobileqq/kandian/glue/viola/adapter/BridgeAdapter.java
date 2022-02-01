package com.tencent.mobileqq.kandian.glue.viola.adapter;

import com.tencent.mobileqq.kandian.biz.viola.api.OnTitleChangeListener;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.viola.adapter.IBridgeAdapter;
import com.tencent.viola.adapter.IBridgeAdapter.OnInovkeCallback;
import com.tencent.viola.core.ViolaInstance;
import java.util.ArrayList;

public class BridgeAdapter
  implements IBridgeAdapter
{
  public BridgeAdapter()
  {
    registerModuleFunction();
  }
  
  public ArrayList<String> getAdapterUnRegisterFunction()
  {
    return null;
  }
  
  public void registerModuleFunction() {}
  
  public void titleUiInvoke(String paramString, Object paramObject, IBridgeAdapter.OnInovkeCallback paramOnInovkeCallback, ViolaInstance paramViolaInstance)
  {
    if (paramViolaInstance == null) {
      return;
    }
    if (("change_title_transparent".equals(paramString)) && ((paramObject instanceof Boolean)))
    {
      paramOnInovkeCallback = paramViolaInstance.getFragment();
      if (paramOnInovkeCallback == null) {
        return;
      }
      paramString = null;
      if ((paramOnInovkeCallback instanceof ViolaFragment)) {
        paramString = ((ViolaFragment)paramOnInovkeCallback).getTtileChangelistener();
      }
      if (paramString != null) {
        paramString.a(((Boolean)paramObject).booleanValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.BridgeAdapter
 * JD-Core Version:    0.7.0.1
 */