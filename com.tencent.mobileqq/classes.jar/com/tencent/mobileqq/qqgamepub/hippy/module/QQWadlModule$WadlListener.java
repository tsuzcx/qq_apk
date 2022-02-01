package com.tencent.mobileqq.qqgamepub.hippy.module;

import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.mtt.hippy.common.HippyArray;
import java.util.ArrayList;
import java.util.Iterator;

abstract class QQWadlModule$WadlListener
  implements WadlProxyServiceCallBackInterface
{
  public void a(WadlResult paramWadlResult)
  {
    a("onWadlTaskStatusChanged", QQWadlModule.toHippyMap(paramWadlResult));
  }
  
  protected abstract void a(String paramString, Object paramObject);
  
  public void a(ArrayList<WadlResult> paramArrayList)
  {
    if (paramArrayList != null)
    {
      HippyArray localHippyArray = new HippyArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localHippyArray.pushMap(QQWadlModule.toHippyMap((WadlResult)paramArrayList.next()));
      }
      a("onQueryCallback", localHippyArray);
    }
  }
  
  public void b(ArrayList<WadlResult> paramArrayList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.module.QQWadlModule.WadlListener
 * JD-Core Version:    0.7.0.1
 */