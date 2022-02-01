package com.tencent.mobileqq.kandian.glue.viola.adapter.ui;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaResLoader;
import com.tencent.mobileqq.kandian.glue.viola.ViolaResLoader.Companion;
import com.tencent.viola.ui.component.image.ImageAction;
import java.io.File;

class ComponentAdapter$3
  implements Runnable
{
  ComponentAdapter$3(ComponentAdapter paramComponentAdapter, String paramString, ImageAction paramImageAction, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    String str = ViolaResLoader.a.a().a(this.a);
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists())) {
      ComponentAdapter.a(this.this$0, this.b, str, this.a, this.c, this.d, this.e, this.f);
    }
    if (ComponentAdapter.a(this.this$0, this.b, this.a, this.c, this.d, this.e, this.f)) {
      return;
    }
    if (!this.a.startsWith("http")) {
      return;
    }
    if (ComponentAdapter.a(this.this$0, this.b, this.a, this.c)) {
      return;
    }
    ComponentAdapter.a(this.this$0, this.b, this.a, this.e, this.f, this.d, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.ui.ComponentAdapter.3
 * JD-Core Version:    0.7.0.1
 */