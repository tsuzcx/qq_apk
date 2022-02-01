package com.tencent.mobileqq.wink.editor.sticker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import androidx.core.content.ContextCompat;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;
import com.tencent.mobileqq.wink.editor.text.TextMetaMaterialKt;
import java.util.List;

public class StickerMaterialPanelContentDecoration
  extends RecyclerView.ItemDecoration
{
  private final List<MetaMaterial> a;
  private final int b;
  private final int c;
  private final Paint d;
  
  public StickerMaterialPanelContentDecoration(Context paramContext, List<MetaMaterial> paramList)
  {
    this.a = paramList;
    this.b = DisplayUtil.a(paramContext, 45.0F);
    this.c = DisplayUtil.a(paramContext, 20.0F);
    this.d = new Paint(1);
    this.d.setColor(ContextCompat.getColor(paramContext, 2131165864));
    this.d.setStyle(Paint.Style.FILL);
    this.d.setTextSize(DisplayUtil.a(paramContext, 12.0F));
  }
  
  private int a(RecyclerView paramRecyclerView)
  {
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager)) {
      return ((GridLayoutManager)paramRecyclerView).getSpanCount();
    }
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager)) {
      return ((StaggeredGridLayoutManager)paramRecyclerView).getSpanCount();
    }
    return -1;
  }
  
  private boolean a(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (MetaMaterial)((List)localObject).get(paramInt);
      if (localObject != null) {
        return TextMetaMaterialKt.c((MetaMaterial)localObject);
      }
    }
    return false;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if (a(((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition()))
    {
      paramRect.set(0, this.b, 0, 0);
      return;
    }
    paramRect.set(0, 0, 0, 0);
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int j = paramRecyclerView.getChildCount();
    int k = a(paramRecyclerView);
    int i = 0;
    while (i < j)
    {
      paramState = paramRecyclerView.getChildAt(i);
      int m = paramRecyclerView.getChildAdapterPosition(paramState);
      if ((a(m)) && (m % k == 0)) {
        paramCanvas.drawText(MetaMaterialKt.e((MetaMaterial)this.a.get(m)), paramState.getLeft(), paramState.getTop() - this.c, this.d);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.sticker.StickerMaterialPanelContentDecoration
 * JD-Core Version:    0.7.0.1
 */