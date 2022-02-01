package cooperation.qzone.share;

import android.app.Activity;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.qzonehub.api.IQzoneShareApi.WXShareListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;

class WXShareFromQZHelper$1
  implements IWXAPIEventHandler
{
  WXShareFromQZHelper$1(WXShareFromQZHelper paramWXShareFromQZHelper) {}
  
  public void onReq(BaseReq paramBaseReq)
  {
    Activity localActivity;
    if (this.this$0.wxEntryActivityRef != null) {
      localActivity = (Activity)this.this$0.wxEntryActivityRef.get();
    } else {
      localActivity = null;
    }
    WXShareFromQZHelper.doParseApp(localActivity, paramBaseReq);
  }
  
  public void onResp(BaseResp paramBaseResp)
  {
    synchronized (WXShareFromQZHelper.access$000(this.this$0))
    {
      Iterator localIterator = WXShareFromQZHelper.access$000(this.this$0).iterator();
      while (localIterator.hasNext()) {
        ((IQzoneShareApi.WXShareListener)localIterator.next()).onWXShareResp(paramBaseResp);
      }
      return;
    }
    for (;;)
    {
      throw paramBaseResp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.share.WXShareFromQZHelper.1
 * JD-Core Version:    0.7.0.1
 */