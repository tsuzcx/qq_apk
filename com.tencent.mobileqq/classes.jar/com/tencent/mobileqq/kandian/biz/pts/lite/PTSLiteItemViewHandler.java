package com.tencent.mobileqq.kandian.biz.pts.lite;

import android.content.Context;
import android.view.View;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.core.lite.PTSLiteItemViewManager;

@Deprecated
public class PTSLiteItemViewHandler
{
  private PTSLiteItemViewManager a;
  
  public PTSLiteItemViewHandler(Context paramContext)
  {
    this.a = new PTSLiteItemViewManager(paramContext);
  }
  
  public View a(View paramView, PTSItemData paramPTSItemData)
  {
    PTSLiteItemViewManager localPTSLiteItemViewManager = this.a;
    Object localObject = paramView;
    if (localPTSLiteItemViewManager != null) {
      localObject = localPTSLiteItemViewManager.getView(paramView, paramPTSItemData);
    }
    return localObject;
  }
  
  public void a()
  {
    PTSLiteItemViewManager localPTSLiteItemViewManager = this.a;
    if (localPTSLiteItemViewManager != null) {
      localPTSLiteItemViewManager.destroy();
    }
  }
  
  public void a(IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    PTSLiteItemViewManager localPTSLiteItemViewManager = this.a;
    if (localPTSLiteItemViewManager != null) {
      localPTSLiteItemViewManager.setLiteEventListener(paramIPTSLiteEventListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteItemViewHandler
 * JD-Core Version:    0.7.0.1
 */