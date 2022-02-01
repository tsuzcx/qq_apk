package com.tencent.mobileqq.kandian.base.view.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.widget.QQTabHost;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/view/api/IKanDianOptUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "generateTabItem", "Landroid/view/View;", "faceId", "", "bgId", "facePressId", "bgPressId", "strId", "animateTag", "apngPlayTag", "isMainFrameInInit", "", "reportTabInfo", "", "tabHost", "Lcom/tencent/mobileqq/widget/QQTabHost;", "updateMainFrameInitStatus", "isRunning", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IKanDianOptUtils
  extends QRouteApi
{
  @Nullable
  public abstract View generateTabItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  public abstract boolean isMainFrameInInit();
  
  public abstract void reportTabInfo(@Nullable QQTabHost paramQQTabHost);
  
  public abstract void updateMainFrameInitStatus(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.api.IKanDianOptUtils
 * JD-Core Version:    0.7.0.1
 */