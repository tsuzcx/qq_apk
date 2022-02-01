package com.tencent.mobileqq.kandian.base.view.api.impl;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.kandian.base.view.api.IKanDianOptUtils;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/view/api/impl/KanDianOptUtilsImpl;", "Lcom/tencent/mobileqq/kandian/base/view/api/IKanDianOptUtils;", "()V", "mainFrameIsInInit", "", "generateTabItem", "Landroid/view/View;", "faceId", "", "bgId", "facePressId", "bgPressId", "strId", "animateTag", "apngPlayTag", "isMainFrameInInit", "updateMainFrameInitStatus", "", "isRunning", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KanDianOptUtilsImpl
  implements IKanDianOptUtils
{
  private boolean mainFrameIsInInit;
  
  @Nullable
  public View generateTabItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (BaseApplicationImpl.sApplication == null) {
      return null;
    }
    View localView = View.inflate((Context)BaseApplicationImpl.sApplication, 2131562906, null);
    Object localObject = (DragTextView)localView.findViewById(2131380161);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "tv");
    ((DragTextView)localObject).setDragViewType(2);
    localObject = localView.findViewById(2131378232);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "vTab.findViewById(com.te…leqq.R.id.tab_item_image)");
    ((TabDragAnimationView)localObject).setEmotionDrawable(paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramInt7);
    ((TextView)localView.findViewById(2131379917)).setText(paramInt5);
    return localView;
  }
  
  public boolean isMainFrameInInit()
  {
    return this.mainFrameIsInInit;
  }
  
  public void updateMainFrameInitStatus(boolean paramBoolean)
  {
    this.mainFrameIsInInit = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.api.impl.KanDianOptUtilsImpl
 * JD-Core Version:    0.7.0.1
 */