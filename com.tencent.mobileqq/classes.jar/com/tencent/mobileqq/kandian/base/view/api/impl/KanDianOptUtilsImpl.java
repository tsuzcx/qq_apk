package com.tencent.mobileqq.kandian.base.view.api.impl;

import android.view.View;
import com.tencent.mobileqq.kandian.base.view.api.IKanDianOptUtils;
import com.tencent.mobileqq.widget.QQTabHost;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/view/api/impl/KanDianOptUtilsImpl;", "Lcom/tencent/mobileqq/kandian/base/view/api/IKanDianOptUtils;", "()V", "generateTabItem", "Landroid/view/View;", "faceId", "", "bgId", "facePressId", "bgPressId", "strId", "animateTag", "apngPlayTag", "isMainFrameInInit", "", "reportTabInfo", "", "tabHost", "Lcom/tencent/mobileqq/widget/QQTabHost;", "updateMainFrameInitStatus", "isRunning", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KanDianOptUtilsImpl
  implements IKanDianOptUtils
{
  @Nullable
  public View generateTabItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    return this.$$delegate_0.generateTabItem(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public boolean isMainFrameInInit()
  {
    return this.$$delegate_0.isMainFrameInInit();
  }
  
  public void reportTabInfo(@Nullable QQTabHost paramQQTabHost)
  {
    this.$$delegate_0.reportTabInfo(paramQQTabHost);
  }
  
  public void updateMainFrameInitStatus(boolean paramBoolean)
  {
    this.$$delegate_0.updateMainFrameInitStatus(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.api.impl.KanDianOptUtilsImpl
 * JD-Core Version:    0.7.0.1
 */