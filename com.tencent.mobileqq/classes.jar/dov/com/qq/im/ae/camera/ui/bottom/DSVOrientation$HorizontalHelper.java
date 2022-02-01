package dov.com.qq.im.ae.camera.ui.bottom;

import android.graphics.Point;
import android.view.View;
import com.tencent.biz.videostory.capture.widgets.RecyclerViewProxy;
import dov.com.qq.im.ae.camera.ui.Direction;

public class DSVOrientation$HorizontalHelper
  implements DSVOrientation.Helper
{
  public float a(Point paramPoint, int paramInt1, int paramInt2)
  {
    return paramInt1 - paramPoint.x;
  }
  
  public int a(int paramInt)
  {
    return paramInt;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return paramInt1;
  }
  
  public void a(int paramInt, RecyclerViewProxy paramRecyclerViewProxy)
  {
    paramRecyclerViewProxy.a(paramInt);
  }
  
  public void a(Point paramPoint1, int paramInt, Point paramPoint2)
  {
    paramPoint2.set(paramPoint1.x - paramInt, paramPoint1.y);
  }
  
  public void a(Direction paramDirection, int paramInt, Point paramPoint)
  {
    paramPoint.set(paramPoint.x + paramDirection.a(paramInt), paramPoint.y);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(Point paramPoint, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = paramPoint.x;
    int i = paramPoint.x;
    return (paramInt2 - paramInt1 < paramInt3 + paramInt4) && (i + paramInt1 > -paramInt4);
  }
  
  public boolean a(AEBottomListScrollLayoutManager paramAEBottomListScrollLayoutManager)
  {
    boolean bool = false;
    View localView1 = paramAEBottomListScrollLayoutManager.a();
    View localView2 = paramAEBottomListScrollLayoutManager.b();
    int i = -paramAEBottomListScrollLayoutManager.c();
    int j = paramAEBottomListScrollLayoutManager.getWidth();
    int k = paramAEBottomListScrollLayoutManager.c();
    if ((paramAEBottomListScrollLayoutManager.getDecoratedLeft(localView1) > i) && (paramAEBottomListScrollLayoutManager.getPosition(localView1) > 0))
    {
      i = 1;
      if ((paramAEBottomListScrollLayoutManager.getDecoratedRight(localView2) >= j + k) || (paramAEBottomListScrollLayoutManager.getPosition(localView2) >= paramAEBottomListScrollLayoutManager.getItemCount() - 1)) {
        break label102;
      }
    }
    label102:
    for (j = 1;; j = 0)
    {
      if ((i != 0) || (j != 0)) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }
  
  public int b(int paramInt)
  {
    return 0;
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    return paramInt1;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public int c(int paramInt1, int paramInt2)
  {
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.DSVOrientation.HorizontalHelper
 * JD-Core Version:    0.7.0.1
 */