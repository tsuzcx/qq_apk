package com.tencent.mobileqq.kandian.biz.account.api;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/account/api/ICellFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "cellRebuildCompleted", "", "type", "", "getView", "Landroid/view/View;", "position", "model", "", "viewType", "convertView", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/common/baseui/IReadInJoyBaseAdapter;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ICellFactory
  extends QRouteApi
{
  public abstract boolean cellRebuildCompleted(int paramInt);
  
  @Nullable
  public abstract View getView(int paramInt1, @Nullable Object paramObject, int paramInt2, @Nullable View paramView, @NotNull Context paramContext, @Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, @Nullable IFaceDecoder paramIFaceDecoder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.api.ICellFactory
 * JD-Core Version:    0.7.0.1
 */