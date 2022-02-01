package com.tencent.mobileqq.kandian.biz.hippy.provider;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewController;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.app.NSHippyListViewController;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.List;

public class NSHippyProvider
  extends TKDApiProvider
{
  public List<Class<? extends HippyViewController>> getControllers()
  {
    List localList = super.getControllers();
    localList.add(NSHippyListViewController.class);
    localList.remove(HippyTKDListViewController.class);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.provider.NSHippyProvider
 * JD-Core Version:    0.7.0.1
 */