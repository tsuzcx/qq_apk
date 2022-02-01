package com.tencent.mobileqq.vas.adv.web;

import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.Companion;
import java.lang.ref.SoftReference;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VasAdvWebManager$initWebView$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    Object localObject = VasAdvWebManager.a(VasAdvWebManager.a);
    if (localObject != null) {
      localObject = (TouchWebView)((SoftReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      View localView = VasAdvSupport.a.a().d();
      localObject = localView;
      if (!(localView instanceof TouchWebView)) {
        localObject = null;
      }
      localObject = (TouchWebView)localObject;
      if (localObject != null) {
        VasAdvWebManager.a(VasAdvWebManager.a, new SoftReference(localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.web.VasAdvWebManager.initWebView.1
 * JD-Core Version:    0.7.0.1
 */