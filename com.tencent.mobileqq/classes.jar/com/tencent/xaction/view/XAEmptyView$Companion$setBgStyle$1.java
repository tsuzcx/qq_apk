package com.tencent.xaction.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.xaction.api.IMemoryLruCache;
import com.tencent.xaction.api.util.BitmapUtil;
import com.tencent.xaction.api.util.BitmapUtil.Companion;
import com.tencent.xaction.api.util.FilePathUtil;
import com.tencent.xaction.api.util.FilePathUtil.Companion;
import com.tencent.xaction.api.util.FileUtil;
import com.tencent.xaction.api.util.FileUtil.Companion;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class XAEmptyView$Companion$setBgStyle$1
  implements Runnable
{
  XAEmptyView$Companion$setBgStyle$1(String paramString, XAEngine paramXAEngine, View paramView, int paramInt) {}
  
  public final void run()
  {
    Object localObject2 = FilePathUtil.a.a(this.jdField_a_of_type_JavaLangString, "$PARENT_ROOT", (IXAEngine)this.jdField_a_of_type_ComTencentXactionImplXAEngine);
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    Object localObject1 = FileUtil.a;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    boolean bool = ((FileUtil.Companion)localObject1).a((String)localObject2);
    if (bool) {
      localObject1 = FileUtil.a.a((String)localObject2);
    } else {
      localObject1 = localObject2;
    }
    localObject1 = BitmapUtil.a.a(this.jdField_a_of_type_AndroidViewView.getResources(), (String)localObject1, localOptions, bool, new int[] { this.jdField_a_of_type_AndroidViewView.getWidth(), this.jdField_a_of_type_AndroidViewView.getHeight() });
    if (localObject1 != null)
    {
      XAEngine.Companion.a().a((String)localObject2, (Bitmap)localObject1);
      localObject2 = XAEngine.Companion.a();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((Handler)localObject2).post((Runnable)new XAEmptyView.Companion.setBgStyle.1.1(this, (Bitmap)localObject1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.view.XAEmptyView.Companion.setBgStyle.1
 * JD-Core Version:    0.7.0.1
 */