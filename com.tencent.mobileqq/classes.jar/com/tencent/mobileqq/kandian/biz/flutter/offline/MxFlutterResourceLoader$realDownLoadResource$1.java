package com.tencent.mobileqq.kandian.biz.flutter.offline;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import java.util.List;
import kotlin.Metadata;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MxFlutterResourceLoader$realDownLoadResource$1
  implements Runnable
{
  MxFlutterResourceLoader$realDownLoadResource$1(String paramString, MxFlutterResourceLoadListener paramMxFlutterResourceLoadListener, boolean paramBoolean, AppRuntime paramAppRuntime) {}
  
  public final void run()
  {
    if (MxFlutterResourceLoader.a.c())
    {
      MxFlutterResourceLoader.a(MxFlutterResourceLoader.a, this.a, this.b);
      return;
    }
    MxFlutterResourceLoader.realDownLoadResource.1.downloadCallback.1 local1 = new MxFlutterResourceLoader.realDownLoadResource.1.downloadCallback.1(this);
    MxFlutterResourceLoader.a.b().add(local1);
    HtmlOffline.b(this.a, this.d, (AsyncBack)local1, true, 0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.flutter.offline.MxFlutterResourceLoader.realDownLoadResource.1
 * JD-Core Version:    0.7.0.1
 */