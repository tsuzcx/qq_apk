package com.tencent.mobileqq.kandian.biz.pts.view.polymeric;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.mobileqq.kandian.base.view.widget.BezierSideBarView;
import com.tencent.qphone.base.util.QLog;

public class SideBarView
  extends BezierSideBarView
{
  private String a;
  
  public SideBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SideBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SideBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected int a()
  {
    int j = super.a();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return i;
  }
  
  protected int b()
  {
    int j = super.b();
    int i = j;
    if (j > getMeasuredHeight()) {
      i = getMeasuredHeight();
    }
    return i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
    }
    super.onDraw(paramCanvas);
  }
  
  public void setBgColor(String paramString)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      int i = Color.parseColor(paramString);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("ProteusRecycleView", 1, "", paramString);
    }
  }
  
  public void setPath(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if ((paramString != null) && (!paramString.equals("-1"))) {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount")))
      {
        paramString = ImageCommon.getDrawableResourceId(paramString);
        if (paramString == null) {
          break label111;
        }
        QLog.d("ProteusRecycleView", 2, "loadImage: cant find in offline dir, try to load from resources");
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(paramString.intValue());
      return;
    }
    catch (Resources.NotFoundException paramString)
    {
      label75:
      Drawable localDrawable;
      break label75;
    }
    QLog.d("ProteusRecycleView", 2, "loadImage: cant find in resources dir, do nothing");
    return;
    localDrawable = getContext().getResources().getDrawable(2130843404);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = DrawableUtil.getDrawable(getContext(), paramString, localDrawable, localDrawable);
    label111:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.SideBarView
 * JD-Core Version:    0.7.0.1
 */