package com.tencent.mobileqq.kandian.biz.video.column;

import android.content.Context;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VideoColumnDataManager$fetchVideoColumnList$2
  implements Runnable
{
  VideoColumnDataManager$fetchVideoColumnList$2(VideoColumnDataManager paramVideoColumnDataManager, String paramString1, String paramString2, QQAppInterface paramQQAppInterface) {}
  
  public final void run()
  {
    NewIntent localNewIntent = new NewIntent((Context)BaseApplicationImpl.context, ProtoServlet.class);
    localNewIntent.putExtra("cmd", "MQUpdateSvc_com_qq_kandian.web.JsOidbProxy.oidb_0xdd7_1");
    localNewIntent.putExtra("data", VideoColumnDataManager.a(this.this$0, this.a, this.b).toByteArray());
    localNewIntent.setObserver((BusinessObserver)new VideoColumnBusinessObserver(this.this$0, this.a, this.b));
    this.c.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.column.VideoColumnDataManager.fetchVideoColumnList.2
 * JD-Core Version:    0.7.0.1
 */