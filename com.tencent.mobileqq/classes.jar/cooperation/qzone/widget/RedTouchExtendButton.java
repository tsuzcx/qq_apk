package cooperation.qzone.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import anme;

public class RedTouchExtendButton
  extends ExtendButton
{
  private int jdField_a_of_type_Int = a(24);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public Drawable a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RedTouchExtendButton.RedInfo jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton$RedInfo;
  public String a;
  private int jdField_b_of_type_Int = a(10);
  private String jdField_b_of_type_JavaLangString = "";
  private int c = a(10);
  private int d = 100;
  
  public RedTouchExtendButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedTouchExtendButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RedTouchExtendButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private int a()
  {
    return (int)getLayout().getLineRight(0);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (a(this.jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton$RedInfo)) {}
    try
    {
      int j = b() - a(4);
      int i = a() - a(2);
      if (this.d == 0)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130846133);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i, j, this.c + i, this.c + j);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      Object localObject1;
      if (this.d == 4)
      {
        localObject1 = this.jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton$RedInfo.jdField_a_of_type_JavaLangString;
        Paint localPaint = new Paint(1);
        localPaint.setTextSize(a(11));
        localPaint.setTextAlign(Paint.Align.CENTER);
        Object localObject2 = localPaint.getFontMetrics();
        j = a(2) + i;
        int k = getHeight() / 2 - (this.c + a(0) * 2) / 2;
        Rect localRect = new Rect();
        localRect.left = j;
        localRect.top = k;
        int m = this.c + a(0) * 2;
        localRect.bottom = (k + m);
        localRect.right = (m + j);
        float f1 = a(0) + k;
        float f2 = ((Paint.FontMetrics)localObject2).top;
        localObject2 = getResources().getDrawable(2130846133);
        ((Drawable)localObject2).getBounds();
        ((Drawable)localObject2).setBounds(j, k, localRect.right, localRect.bottom);
        ((Drawable)localObject2).draw(paramCanvas);
        localPaint.setColor(-1);
        paramCanvas.drawText((String)localObject1, localRect.left + localRect.width() / 2, f1 - f2, localPaint);
      }
      if (this.d == 3)
      {
        localObject1 = getResources().getDrawable(2130844979);
        i += a(2);
        j = getHeight() / 2 - ((Drawable)localObject1).getIntrinsicHeight() / 2;
        ((Drawable)localObject1).setBounds(i, j, ((Drawable)localObject1).getIntrinsicWidth() + i, ((Drawable)localObject1).getIntrinsicHeight() + j);
        ((Drawable)localObject1).draw(paramCanvas);
      }
      return;
    }
    catch (Exception paramCanvas) {}
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (c() >= this.jdField_a_of_type_Int)
    {
      bool1 = bool2;
      if (d() >= this.jdField_a_of_type_Int + a(2)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(RedTouchExtendButton.RedInfo paramRedInfo)
  {
    if (paramRedInfo == null) {}
    do
    {
      do
      {
        return false;
      } while (!paramRedInfo.jdField_a_of_type_Boolean);
      a(a(), paramRedInfo);
      if (paramRedInfo.jdField_a_of_type_Int == 3)
      {
        if (a())
        {
          this.c = this.jdField_a_of_type_Int;
          this.jdField_a_of_type_JavaLangString = paramRedInfo.jdField_b_of_type_JavaLangString;
          this.d = 3;
          return true;
        }
        if (b())
        {
          this.c = this.jdField_b_of_type_Int;
          this.d = 0;
          return true;
        }
        this.c = 0;
        this.d = 100;
        return false;
      }
      if (paramRedInfo.jdField_a_of_type_Int == 4)
      {
        this.jdField_b_of_type_JavaLangString = paramRedInfo.jdField_a_of_type_JavaLangString;
        if (a(this.jdField_b_of_type_JavaLangString))
        {
          paramRedInfo = new TextPaint();
          paramRedInfo.setTextSize(a(11));
          int i = (int)paramRedInfo.measureText(this.jdField_b_of_type_JavaLangString);
          paramRedInfo = paramRedInfo.getFontMetrics();
          this.c = Math.max(i, (int)(paramRedInfo.bottom - paramRedInfo.top));
          this.d = 4;
          return true;
        }
        if (b())
        {
          this.c = this.jdField_b_of_type_Int;
          this.d = 0;
          return true;
        }
        this.c = 0;
        this.d = 100;
        return false;
      }
    } while (paramRedInfo.jdField_a_of_type_Int != 0);
    if (b())
    {
      this.c = this.jdField_b_of_type_Int;
      this.d = 0;
      return true;
    }
    this.c = 0;
    this.d = 100;
    return false;
  }
  
  private boolean a(RedTouchExtendButton.RedInfo paramRedInfo1, RedTouchExtendButton.RedInfo paramRedInfo2)
  {
    return a(paramRedInfo1, paramRedInfo2);
  }
  
  private boolean a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null)) {}
    while ((paramObject1 != null) && (paramObject1.equals(paramObject2))) {
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return false;
      TextPaint localTextPaint = new TextPaint();
      localTextPaint.setTextSize(a(11));
      i = (int)localTextPaint.measureText(paramString);
      paramString = localTextPaint.getFontMetrics();
      i = Math.max(i, (int)(paramString.bottom - paramString.top));
    } while (d() < i + a(0) * 2 + a(2));
    return true;
  }
  
  private int b()
  {
    Rect localRect = new Rect();
    getLineBounds(0, localRect);
    int i = localRect.top;
    if (i > 0) {
      return i;
    }
    return 0;
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (c() >= this.jdField_b_of_type_Int)
    {
      bool1 = bool2;
      if (d() + a(2) >= this.jdField_b_of_type_Int) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private int c()
  {
    return getHeight();
  }
  
  private int d()
  {
    int i = a();
    return getWidth() - i - a(0);
  }
  
  protected int a(int paramInt)
  {
    Resources localResources = getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }
  
  public RedTouchExtendButton.RedInfo a()
  {
    return this.jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton$RedInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new anme(this));
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setAppInfo(RedTouchExtendButton.RedInfo paramRedInfo)
  {
    this.jdField_a_of_type_CooperationQzoneWidgetRedTouchExtendButton$RedInfo = paramRedInfo;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.widget.RedTouchExtendButton
 * JD-Core Version:    0.7.0.1
 */