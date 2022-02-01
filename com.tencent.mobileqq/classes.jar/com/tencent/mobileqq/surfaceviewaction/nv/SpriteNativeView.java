package com.tencent.mobileqq.surfaceviewaction.nv;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.surfaceviewaction.BaseNode;
import com.tencent.mobileqq.surfaceviewaction.ISpriteView;
import java.util.ArrayList;
import java.util.Iterator;

public class SpriteNativeView
  extends FrameLayout
  implements ISpriteView<Node>, Runnable
{
  private ArrayList<Node> a = new ArrayList(10);
  private Handler b = new Handler(Looper.getMainLooper());
  
  public SpriteNativeView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SpriteNativeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    boolean bool = false;
    while (localIterator.hasNext()) {
      bool |= ((Node)localIterator.next()).k();
    }
    if (bool) {
      this.b.postDelayed(this, 16L);
    }
  }
  
  public void a(int paramInt, Node paramNode)
  {
    if (!this.a.contains(paramNode))
    {
      this.a.add(paramInt, paramNode);
      paramNode.l();
    }
  }
  
  public void a(Node paramNode)
  {
    a(this.a.size(), paramNode);
  }
  
  public void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((BaseNode)localIterator.next()).g();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((BaseNode)localIterator.next()).h();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((BaseNode)localIterator.next()).f();
    }
    this.a.clear();
  }
  
  public int getCurrentVideoTime()
  {
    return 0;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    a();
  }
  
  public void run()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView
 * JD-Core Version:    0.7.0.1
 */