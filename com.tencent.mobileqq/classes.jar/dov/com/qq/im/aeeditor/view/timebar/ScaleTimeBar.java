package dov.com.qq.im.aeeditor.view.timebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import boer;
import boes;
import java.util.List;
import zpz;

public class ScaleTimeBar
  extends ScaleView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 2147483647L;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private String jdField_a_of_type_JavaLangString = "";
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private int jdField_c_of_type_Int = 3;
  private Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint();
  private int d;
  
  public ScaleTimeBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScaleTimeBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScaleTimeBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.d = getResources().getDimensionPixelSize(2131296302);
    this.jdField_c_of_type_Int = getResources().getDimensionPixelSize(2131296283);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.d);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131165240));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(zpz.a(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.d);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131165241));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(zpz.a(getContext(), "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf"));
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(this.d);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131165240));
  }
  
  private int b()
  {
    return getMeasuredWidth() / 2;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boer == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_Int = b();
      }
      if (this.jdField_b_of_type_Int == 0) {
        this.jdField_b_of_type_Int = (getHeight() / 2);
      }
    } while (this.jdField_a_of_type_Boer.a() == null);
    boes localboes = null;
    int j = this.jdField_a_of_type_Boer.a().size();
    Object localObject = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
    float f1 = this.jdField_b_of_type_Int + (((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top) / 2.0F - ((Paint.FontMetrics)localObject).bottom;
    int i = 0;
    label110:
    float f2;
    if (i < j)
    {
      localObject = (boes)this.jdField_a_of_type_Boer.a().get(i);
      f2 = this.jdField_a_of_type_Int + this.jdField_a_of_type_Boer.a() * ((boes)localObject).a();
      if (this.jdField_a_of_type_Boer.a((boes)localObject) == this.jdField_a_of_type_Long)
      {
        if (i >= j - 1) {
          break label516;
        }
        localboes = (boes)this.jdField_a_of_type_Boer.a().get(i + 1);
      }
    }
    label516:
    for (;;)
    {
      if (this.jdField_a_of_type_Float == 0.0F) {
        this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPaint.measureText("a");
      }
      float f3 = this.jdField_a_of_type_Float * 5.0F;
      if ((f2 < getScrollX() - f3) || (f2 > f3 + (getScrollX() + getWidth()))) {}
      for (;;)
      {
        i += 1;
        break label110;
        if (this.jdField_a_of_type_Boer.a((boes)localObject) <= this.jdField_a_of_type_Long) {
          break label516;
        }
        if (localboes == null) {
          break;
        }
        f2 = this.jdField_a_of_type_Int;
        f3 = this.jdField_a_of_type_Boer.a();
        float f4 = localboes.a();
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break;
        }
        i = this.jdField_a_of_type_JavaLangString.length();
        paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, 0, i, f2 + f4 * f3, f1, this.jdField_c_of_type_AndroidGraphicsPaint);
        return;
        f3 = this.jdField_b_of_type_Int;
        if (((boes)localObject).b() == 1)
        {
          paramCanvas.drawCircle(f2, f3, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        else if (((boes)localObject).b() == 0)
        {
          String str = this.jdField_a_of_type_Boer.a((boes)localObject);
          if (!TextUtils.isEmpty(str))
          {
            int k = str.length();
            if ((this.jdField_a_of_type_Boer.a((boes)localObject) == this.jdField_a_of_type_Long) && (i < j - 1)) {
              paramCanvas.drawText(str, 0, k, f2 - this.jdField_a_of_type_Float * k / 2.0F, f1, this.jdField_b_of_type_AndroidGraphicsPaint);
            } else {
              paramCanvas.drawText(str, 0, k, f2 - this.jdField_a_of_type_Float * k / 2.0F, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
            }
          }
        }
      }
    }
  }
  
  public void setMaxDurationLimit(long paramLong)
  {
    if (paramLong > 0L) {
      this.jdField_a_of_type_Long = paramLong;
    }
  }
  
  public void setMaxDurationLimitTip(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setTextSize(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.timebar.ScaleTimeBar
 * JD-Core Version:    0.7.0.1
 */