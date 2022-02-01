package me.ele.uetool.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.ele.uetool.UETool;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.base.Element;

class EditAttrLayout$MoveMode
  implements EditAttrLayout.IMode
{
  private static final int NOT_ADSORP = -1;
  private float DetachThreshold = 20.0F;
  private float Threshold = 10.0F;
  private List<Integer> adsorpPointX;
  private List<Integer> adsorpPointY;
  private float adsorpX = -1.0F;
  private int adsorpXPoint = -1;
  private float adsorpY = -1.0F;
  private int adsorpYPoint = -1;
  private ViewParent originParent;
  
  EditAttrLayout$MoveMode(EditAttrLayout paramEditAttrLayout)
  {
    init();
  }
  
  private void init()
  {
    this.adsorpPointX = new ArrayList(64);
    this.adsorpPointY = new ArrayList(64);
    Iterator localIterator = this.this$0.elements.iterator();
    while (localIterator.hasNext())
    {
      Rect localRect = ((Element)localIterator.next()).getRect();
      this.adsorpPointX.add(Integer.valueOf(localRect.left));
      this.adsorpPointX.add(Integer.valueOf(localRect.right));
      this.adsorpPointX.add(Integer.valueOf(localRect.centerX()));
      this.adsorpPointY.add(Integer.valueOf(localRect.top));
      this.adsorpPointY.add(Integer.valueOf(localRect.bottom));
      this.adsorpPointY.add(Integer.valueOf(localRect.centerY()));
    }
    Collections.sort(this.adsorpPointX);
    Collections.sort(this.adsorpPointY);
  }
  
  public void getXY()
  {
    BaseLineView localBaseLineView = UETool.getInstance().getBaseLineView();
    if (localBaseLineView != null)
    {
      this.adsorpX = localBaseLineView.getLastX();
      this.adsorpY = localBaseLineView.getLastY();
      return;
    }
    this.adsorpY = -1.0F;
    this.adsorpX = -1.0F;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    getXY();
    Rect localRect1 = EditAttrLayout.access$300(this.this$0).getRect();
    Rect localRect2 = EditAttrLayout.access$300(this.this$0).getOriginRect();
    paramCanvas.drawRect(localRect2, this.this$0.dashLinePaint);
    Object localObject = EditAttrLayout.access$300(this.this$0).getParentElement();
    if (localObject != null)
    {
      localObject = ((Element)localObject).getRect();
      int i = localRect1.left + localRect1.width() / 2;
      int j = localRect1.top + localRect1.height() / 2;
      this.this$0.drawLineWithText(paramCanvas, localRect1.left, j, ((Rect)localObject).left, j, DimenUtil.dip2px(2.0F));
      this.this$0.drawLineWithText(paramCanvas, i, localRect1.top, i, ((Rect)localObject).top, DimenUtil.dip2px(2.0F));
      this.this$0.drawLineWithText(paramCanvas, localRect1.right, j, ((Rect)localObject).right, j, DimenUtil.dip2px(2.0F));
      this.this$0.drawLineWithText(paramCanvas, i, localRect1.bottom, i, ((Rect)localObject).bottom, DimenUtil.dip2px(2.0F));
    }
    if (EditAttrLayout.access$400(this.this$0) != null) {
      EditAttrLayout.access$400(this.this$0).showOffset("Offset:\nx -> " + DimenUtil.px2dip(localRect1.left - localRect2.left, true) + " y -> " + DimenUtil.px2dip(localRect1.top - localRect2.top, true));
    }
  }
  
  public void triggerActionLong(MotionEvent paramMotionEvent) {}
  
  public void triggerActionMove(MotionEvent paramMotionEvent)
  {
    int j = 1;
    View localView;
    float f3;
    float f4;
    int k;
    int i;
    float f2;
    if (EditAttrLayout.access$300(this.this$0) != null)
    {
      localView = EditAttrLayout.access$300(this.this$0).getView();
      int[] arrayOfInt = new int[2];
      f3 = paramMotionEvent.getX() - EditAttrLayout.access$000(this.this$0);
      f4 = paramMotionEvent.getY() - EditAttrLayout.access$100(this.this$0);
      if (UETool.getInstance().getBaseLineView() == null) {
        break label446;
      }
      localView.getLocationOnScreen(arrayOfInt);
      int m = arrayOfInt[0];
      k = arrayOfInt[1];
      if (Build.VERSION.SDK_INT > 19) {
        break label439;
      }
      i = k - DimenUtil.getStatusBarHeight();
      int n = localView.getWidth() + m;
      k += localView.getHeight();
      if ((Math.abs(this.adsorpY - i) > this.Threshold) || (Math.abs(f4) >= this.DetachThreshold)) {
        break label433;
      }
      f2 = this.adsorpY - i;
      label163:
      float f1 = f2;
      if (Math.abs(this.adsorpY - k) <= this.Threshold)
      {
        f1 = f2;
        if (Math.abs(f2) < this.DetachThreshold) {
          f1 = this.adsorpY - k;
        }
      }
      if ((Math.abs(this.adsorpX - m) > this.Threshold) || (Math.abs(f3) >= this.DetachThreshold)) {
        break label427;
      }
      f2 = this.adsorpX - m;
      label248:
      f4 = f1;
      f3 = f2;
      if (Math.abs(this.adsorpX - n) <= this.Threshold)
      {
        f4 = f1;
        f3 = f2;
        if (Math.abs(f2) < this.DetachThreshold)
        {
          f3 = this.adsorpX - n;
          f4 = f1;
        }
      }
    }
    label427:
    label433:
    label439:
    label446:
    for (;;)
    {
      if (Math.abs(f3) >= EditAttrLayout.access$500(this.this$0))
      {
        localView.setTranslationX(f3 + localView.getTranslationX());
        EditAttrLayout.access$002(this.this$0, paramMotionEvent.getX());
      }
      for (i = 1;; i = 0)
      {
        if (Math.abs(f4) >= EditAttrLayout.access$500(this.this$0))
        {
          localView.setTranslationY(f4 + localView.getTranslationY());
          EditAttrLayout.access$102(this.this$0, paramMotionEvent.getY());
          i = j;
        }
        for (;;)
        {
          if (i != 0)
          {
            EditAttrLayout.access$300(this.this$0).reset();
            this.this$0.invalidate();
          }
          return;
        }
      }
      f2 = f3;
      break label248;
      f2 = f4;
      break label163;
      i = k;
      break;
    }
  }
  
  public void triggerActionUp(MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.view.EditAttrLayout.MoveMode
 * JD-Core Version:    0.7.0.1
 */