package com.tencent.mobileqq.kandian.biz.flutter.offline;

import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MxFlutterResourceLoader$checkMxFlutterBundleUpdateAsync$1
  implements Runnable
{
  MxFlutterResourceLoader$checkMxFlutterBundleUpdateAsync$1(String paramString, MxFlutterResourceLoadListener paramMxFlutterResourceLoadListener) {}
  
  public final void run()
  {
    QLog.d("MxFlutterResourceLoader", 1, "#checkMxFlutterBundleUpdateAsync: switch to file thread");
    boolean bool = MxFlutterResourceLoader.a(MxFlutterResourceLoader.a, this.a);
    MxFlutterResourceLoadListener localMxFlutterResourceLoadListener = this.b;
    if (localMxFlutterResourceLoadListener != null) {
      UiThreadUtil.a((Runnable)new MxFlutterResourceLoader.checkMxFlutterBundleUpdateAsync.1..special..inlined.apply.lambda.1(localMxFlutterResourceLoadListener, bool));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.flutter.offline.MxFlutterResourceLoader.checkMxFlutterBundleUpdateAsync.1
 * JD-Core Version:    0.7.0.1
 */