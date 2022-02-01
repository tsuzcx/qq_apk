package com.tencent.open.wadl;

import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class WadlMainBridgeCallBack
  extends WadlJsBridgeCallBack
{
  private WeakReference<WadlMainBridgeCallBack.WadlTaskCallback> a;
  
  public WadlMainBridgeCallBack()
  {
    super(false, null);
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    super.onQueryCallback(paramArrayList);
    if ((this.a != null) && (this.a.get() != null)) {
      ((WadlMainBridgeCallBack.WadlTaskCallback)this.a.get()).a(paramArrayList);
    }
  }
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    super.onWadlTaskStatusChanged(paramWadlResult);
    if ((paramWadlResult == null) || (paramWadlResult.a == null)) {}
    int i;
    do
    {
      return;
      i = WadlJsBridgeUtil.a(paramWadlResult.b);
    } while ((this.a == null) || (this.a.get() == null));
    ((WadlMainBridgeCallBack.WadlTaskCallback)this.a.get()).a(i, paramWadlResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.wadl.WadlMainBridgeCallBack
 * JD-Core Version:    0.7.0.1
 */