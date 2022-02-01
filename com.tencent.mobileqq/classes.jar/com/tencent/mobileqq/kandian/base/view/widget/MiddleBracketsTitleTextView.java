package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class MiddleBracketsTitleTextView
  extends TextView
{
  private int a = 0;
  private Paint b;
  private boolean c;
  private int d = 2;
  private String e;
  
  public MiddleBracketsTitleTextView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public MiddleBracketsTitleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public MiddleBracketsTitleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void a(Canvas paramCanvas)
  {
    for (;;)
    {
      int j;
      try
      {
        this.a = (getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
        if (this.b.measureText(this.e) > this.d * this.a)
        {
          float f1 = this.b.measureText("...]");
          float f2 = this.d * this.a;
          i = 0;
          if (i < this.e.length())
          {
            Object localObject = this.e;
            j = i + 1;
            localObject = ((String)localObject).substring(0, j);
            if (this.b.measureText((String)localObject) <= f2 - f1 * 1.8F) {
              break label201;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.e.substring(0, i));
            ((StringBuilder)localObject).append("...]");
            this.e = ((StringBuilder)localObject).toString();
            setText(this.e);
          }
        }
        else
        {
          super.onDraw(paramCanvas);
          return;
        }
      }
      catch (Exception localException)
      {
        super.onDraw(paramCanvas);
        if (QLog.isColorLevel()) {
          QLog.d("MiddleBracketsTitleTextView", 2, "drawTitle", localException);
        }
      }
      return;
      label201:
      int i = j;
    }
  }
  
  private void b()
  {
    this.b = getPaint();
    this.b.setTextSize(getTextSize());
    this.b.setColor(getCurrentTextColor());
    this.b.setAntiAlias(true);
    this.b.setTextAlign(Paint.Align.LEFT);
    this.b.setStyle(Paint.Style.STROKE);
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      Object localObject = getClass().getSuperclass().getDeclaredField("mLayout");
      ((Field)localObject).setAccessible(true);
      localObject = (Layout)((Field)localObject).get(this);
      if (localObject == null) {
        return false;
      }
      int i = ((Layout)localObject).getEllipsisCount(this.d - 1);
      if (i > 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiddleBracketsTitleTextView", 2, "checkOverLine", localException);
      }
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.e != null) && (getText() != null) && (this.c) && (a()))
    {
      a(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setNeedAddBrackets(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setTitle(String paramString)
  {
    this.e = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.MiddleBracketsTitleTextView
 * JD-Core Version:    0.7.0.1
 */