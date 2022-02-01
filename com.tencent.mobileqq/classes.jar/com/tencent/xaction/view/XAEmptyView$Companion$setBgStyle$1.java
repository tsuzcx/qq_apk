package com.tencent.xaction.view;

import android.content.res.Resources;
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
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class XAEmptyView$Companion$setBgStyle$1
  implements Runnable
{
  XAEmptyView$Companion$setBgStyle$1(String paramString, XAEngine paramXAEngine, View paramView, int paramInt) {}
  
  public final void run()
  {
    Object localObject1 = FilePathUtil.a.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentXactionImplXAEngine);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = BitmapUtil.a;
      Resources localResources = this.jdField_a_of_type_AndroidViewView.getResources();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject2 = ((BitmapUtil.Companion)localObject2).a(localResources, (String)localObject1, new BitmapFactory.Options(), false, new int[] { this.jdField_a_of_type_AndroidViewView.getWidth(), this.jdField_a_of_type_AndroidViewView.getHeight() });
    } while (localObject2 == null);
    XAEngine.Companion.a().a((String)localObject1, (Bitmap)localObject2);
    localObject1 = this.jdField_a_of_type_ComTencentXactionImplXAEngine.getUiHandler();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    ((Handler)localObject1).post((Runnable)new XAEmptyView.Companion.setBgStyle.1.1(this, (Bitmap)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.view.XAEmptyView.Companion.setBgStyle.1
 * JD-Core Version:    0.7.0.1
 */