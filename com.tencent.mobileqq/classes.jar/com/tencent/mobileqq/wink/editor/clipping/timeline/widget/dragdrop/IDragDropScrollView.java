package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragDropScrollView;", "", "trackModels", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/TrackModel;", "Lkotlin/collections/ArrayList;", "getTrackModels", "()Ljava/util/ArrayList;", "getAttractPoints", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/AttractPoint;", "id", "", "getHalfScreenWidth", "", "getHorizontalScrollX", "getLeftSidePositionByMargin", "leftMargin", "getMaxCanScrollPx", "getMaxPosition", "getMaxSpace", "getMinAttractDistance", "", "getRightSidePositionByMargin", "rightMargin", "getStartPosition", "onSliderDown", "", "onSliderUp", "positionOffset", "view", "Landroid/view/View;", "refreshSingleDragView", "iDragView", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/IDragView;", "scrollToX", "x", "y", "setAdsorbedPoint", "startPoint", "endPoint", "updateSelectState", "dragView", "isSelected", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IDragDropScrollView
{
  @NotNull
  public abstract List<AttractPoint> a(@NotNull String paramString);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt, @NotNull View paramView);
  
  public abstract void a(@Nullable IDragView paramIDragView, boolean paramBoolean);
  
  public abstract int b(int paramInt);
  
  public abstract void b(@NotNull IDragView paramIDragView);
  
  public abstract int c(int paramInt);
  
  public abstract void e();
  
  public abstract int getHalfScreenWidth();
  
  public abstract int getHorizontalScrollX();
  
  public abstract int getMaxCanScrollPx();
  
  public abstract int getMaxPosition();
  
  public abstract int getMaxSpace();
  
  public abstract float getMinAttractDistance();
  
  @NotNull
  public abstract ArrayList<TrackModel> getTrackModels();
  
  public abstract void setAdsorbedPoint(@Nullable AttractPoint paramAttractPoint1, @Nullable AttractPoint paramAttractPoint2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.IDragDropScrollView
 * JD-Core Version:    0.7.0.1
 */