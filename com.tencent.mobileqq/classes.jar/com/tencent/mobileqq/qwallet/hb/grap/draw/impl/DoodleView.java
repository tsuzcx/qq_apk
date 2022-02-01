package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.doodle.DoodleItem;
import com.tencent.mobileqq.activity.aio.doodle.DoodleParam;
import com.tencent.mobileqq.activity.aio.doodle.PathData;
import java.util.List;

public class DoodleView
  extends View
{
  private DoodleView.DoodleViewListener jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView$DoodleViewListener;
  private LineLayer jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer;
  
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer = new LineLayer(this);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer.a();
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer.a(new DoodleView.1(this));
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer.a(LineLayer.a);
    super.requestLayout();
  }
  
  public int a(boolean paramBoolean)
  {
    LineLayer localLineLayer;
    if (!paramBoolean)
    {
      localLineLayer = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer;
      if (localLineLayer != null) {
        return localLineLayer.b();
      }
    }
    else
    {
      localLineLayer = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer;
      if (localLineLayer != null) {
        return localLineLayer.c();
      }
    }
    return 0;
  }
  
  public DoodleItem a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer == null) {
      return null;
    }
    DoodleItem localDoodleItem = new DoodleItem();
    localDoodleItem.a(a(), paramBoolean, true);
    localDoodleItem.a().a(a());
    return localDoodleItem;
  }
  
  public DoodleParam a()
  {
    LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer;
    if (localLineLayer == null) {
      return null;
    }
    return localLineLayer.a();
  }
  
  public List<PathData> a()
  {
    LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer;
    if (localLineLayer != null) {
      return localLineLayer.a();
    }
    return null;
  }
  
  public void a()
  {
    LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer;
    if (localLineLayer != null) {
      localLineLayer.b();
    }
  }
  
  public void a(DoodleView.DoodleViewListener paramDoodleViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView$DoodleViewListener = paramDoodleViewListener;
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer;
    if (localLineLayer != null) {
      localLineLayer.a(paramBoolean);
    }
    super.invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer;
    if (localLineLayer != null) {
      localLineLayer.a(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return;
      }
      LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer;
      if (localLineLayer != null) {
        localLineLayer.a(paramInt1, paramInt2);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer;
    if (localLineLayer != null) {
      return localLineLayer.a(paramMotionEvent);
    }
    return false;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (isShown()) {
      super.invalidate();
    }
    if (paramInt != 0)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer;
      if ((paramView != null) && (paramView.b() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer.a(true);
      }
    }
    else
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer;
      if (paramView != null) {
        paramView.d();
      }
    }
  }
  
  public void setLineColor(int paramInt)
  {
    LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer;
    if (localLineLayer != null) {
      localLineLayer.a(paramInt);
    }
  }
  
  public void setLineTexture(int paramInt)
  {
    LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer;
    if (localLineLayer != null) {
      localLineLayer.b(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DoodleView
 * JD-Core Version:    0.7.0.1
 */