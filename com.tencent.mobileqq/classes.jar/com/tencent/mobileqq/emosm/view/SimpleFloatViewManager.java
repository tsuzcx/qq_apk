package com.tencent.mobileqq.emosm.view;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.widget.XListView;

public class SimpleFloatViewManager
  implements DragSortListView.FloatViewManager
{
  private Bitmap a;
  private ImageView b;
  private int c = -16777216;
  private XListView d;
  
  public SimpleFloatViewManager(XListView paramXListView)
  {
    this.d = paramXListView;
  }
  
  public void a(View paramView)
  {
    ((ImageView)paramView).setImageDrawable(null);
    this.a.recycle();
    this.a = null;
  }
  
  public void a(View paramView, Point paramPoint1, Point paramPoint2) {}
  
  public View f(int paramInt)
  {
    Object localObject = this.d;
    localObject = ((XListView)localObject).getChildAt(paramInt + ((XListView)localObject).getHeaderViewsCount() - this.d.getFirstVisiblePosition());
    if (localObject == null) {
      return null;
    }
    ((View)localObject).setPressed(false);
    ((View)localObject).setDrawingCacheEnabled(true);
    if (((View)localObject).getDrawingCache() == null) {
      return null;
    }
    this.a = Bitmap.createBitmap(((View)localObject).getDrawingCache());
    ((View)localObject).setDrawingCacheEnabled(false);
    if (this.b == null) {
      this.b = new ImageView(this.d.getContext());
    }
    this.b.setBackgroundColor(this.c);
    this.b.setPadding(0, 0, 0, 0);
    this.b.setImageBitmap(this.a);
    this.b.setLayoutParams(new ViewGroup.LayoutParams(((View)localObject).getWidth(), ((View)localObject).getHeight()));
    return this.b;
  }
  
  public void g(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.SimpleFloatViewManager
 * JD-Core Version:    0.7.0.1
 */