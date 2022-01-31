package me.ele.uetool.view;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import me.ele.uetool.base.DimenUtil;

class BaseLineView$3
  extends Paint
{
  BaseLineView$3(BaseLineView paramBaseLineView, int paramInt)
  {
    super(paramInt);
    setColor(Color.parseColor("#5F80E3"));
    setStyle(Paint.Style.FILL);
    setStrokeWidth(DimenUtil.dip2px(2.0F));
    setTextSize(DimenUtil.dip2px(12.0F));
    setFlags(32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.view.BaseLineView.3
 * JD-Core Version:    0.7.0.1
 */