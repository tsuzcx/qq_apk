package com.tencent.xaction.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.xaction.api.IMemoryLruCache;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.style.Style;
import com.tencent.xaction.api.util.BitmapUtil;
import com.tencent.xaction.api.util.BitmapUtil.Companion;
import com.tencent.xaction.api.util.FilePathUtil;
import com.tencent.xaction.api.util.FilePathUtil.Companion;
import com.tencent.xaction.api.util.FileUtil;
import com.tencent.xaction.api.util.FileUtil.Companion;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class XAEmptyView$Companion$setBgStyle$1
  implements Runnable
{
  XAEmptyView$Companion$setBgStyle$1(String paramString, XAEngine paramXAEngine, View paramView, ViewData paramViewData, int paramInt) {}
  
  public final void run()
  {
    String str = FilePathUtil.a.a(this.a, "$PARENT_ROOT", (IXAEngine)this.b);
    if (TextUtils.isEmpty((CharSequence)str)) {
      return;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    boolean bool = FileUtil.a.b(str);
    if (bool) {
      localObject = FileUtil.a.a(str);
    } else {
      localObject = str;
    }
    int k = this.c.getWidth();
    int m = this.c.getHeight();
    int j = k;
    int i = m;
    if (k == 0)
    {
      j = k;
      i = m;
      if (m == 0)
      {
        j = ScreenUnit.a.a(this.d.getSt().getW());
        i = ScreenUnit.a.a(this.d.getSt().getH());
      }
    }
    Object localObject = BitmapUtil.a.a(this.c.getResources(), (String)localObject, localOptions, bool, new int[] { j, i });
    if (localObject != null)
    {
      XAEngine.Companion.e().a(str, (Bitmap)localObject);
      XAEngine.Companion.c().post((Runnable)new XAEmptyView.Companion.setBgStyle.1.1(this, (Bitmap)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.view.XAEmptyView.Companion.setBgStyle.1
 * JD-Core Version:    0.7.0.1
 */