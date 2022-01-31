package dov.com.qq.im.aeeditor.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class NumberIndicator
  extends TextView
{
  private int a;
  private int b;
  
  public NumberIndicator(Context paramContext)
  {
    super(paramContext);
  }
  
  public NumberIndicator(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NumberIndicator(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    setText(this.a + " / " + this.b);
  }
  
  public void setCurrentIndex(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.b)) {
      throw new IllegalArgumentException("currentIndex not valid, out of range");
    }
    this.a = paramInt;
    a();
  }
  
  public void setTotalCount(int paramInt)
  {
    if (paramInt < this.a) {
      throw new IllegalArgumentException("totalCount not valid, totalCount < currentIndex");
    }
    this.b = paramInt;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.NumberIndicator
 * JD-Core Version:    0.7.0.1
 */