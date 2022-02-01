package com.tencent.mobileqq.kandian.biz.account.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.account.api.ICellFactory;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/account/api/impl/CellFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/account/api/ICellFactory;", "()V", "cellRebuildCompleted", "", "type", "", "getView", "Landroid/view/View;", "position", "model", "", "viewType", "convertView", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/common/baseui/IReadInJoyBaseAdapter;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class CellFactoryImpl
  implements ICellFactory
{
  public boolean cellRebuildCompleted(int paramInt)
  {
    return this.$$delegate_0.cellRebuildCompleted(paramInt);
  }
  
  @Nullable
  public View getView(int paramInt1, @Nullable Object paramObject, int paramInt2, @Nullable View paramView, @NotNull Context paramContext, @Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, @Nullable IFaceDecoder paramIFaceDecoder)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return this.$$delegate_0.getView(paramInt1, paramObject, paramInt2, paramView, paramContext, paramIReadInJoyBaseAdapter, paramIFaceDecoder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.api.impl.CellFactoryImpl
 * JD-Core Version:    0.7.0.1
 */