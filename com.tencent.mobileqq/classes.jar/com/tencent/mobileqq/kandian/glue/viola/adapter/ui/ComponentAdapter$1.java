package com.tencent.mobileqq.kandian.glue.viola.adapter.ui;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaResLoader;
import com.tencent.mobileqq.kandian.glue.viola.ViolaResLoader.Companion;
import com.tencent.viola.commons.ImageAdapterHolder.ImgSpanListener;
import java.io.File;

class ComponentAdapter$1
  implements Runnable
{
  ComponentAdapter$1(ComponentAdapter paramComponentAdapter, ImageAdapterHolder.ImgSpanListener paramImgSpanListener, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    ComponentAdapter.ImageSpanAction localImageSpanAction = new ComponentAdapter.ImageSpanAction(this.a, this.b);
    String str = ViolaResLoader.a.a().a(this.b);
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
    {
      ComponentAdapter.a(this.this$0, localImageSpanAction, str, this.b, false, false, this.c, this.d);
      return;
    }
    ComponentAdapter.a(this.this$0, localImageSpanAction, this.b, this.c, this.d, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.ui.ComponentAdapter.1
 * JD-Core Version:    0.7.0.1
 */