package dov.com.qq.im.capture.text;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.StaticLayout;
import android.view.MotionEvent;
import android.view.View;
import anwi;
import anwj;
import anwk;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;
import java.util.ArrayList;
import java.util.List;

public abstract class DynamicTextItem
{
  private static final String jdField_a_of_type_JavaLangString = DynamicTextItem.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Handler jdField_a_of_type_AndroidOsHandler;
  StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
  private volatile DynamicTextItem.Pair jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$Pair = new DynamicTextItem.Pair(Integer.valueOf(-1), Boolean.valueOf(false));
  private DynamicTextItem.TextMap jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile boolean c;
  
  public DynamicTextItem(int paramInt, @NonNull List paramList)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap = new DynamicTextItem.TextMap(paramList);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#12b7f5"));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(new DashPathEffect(new float[] { 6.0F, 7.0F }, 1.0F));
  }
  
  private int a(int paramInt)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt < a()) {}
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  public abstract float a();
  
  public float a(StaticLayout paramStaticLayout)
  {
    float f1 = 0.0F;
    float f2 = 0.0F;
    if (paramStaticLayout == null) {
      return f2;
    }
    int i = 0;
    for (;;)
    {
      f2 = f1;
      if (i >= paramStaticLayout.getLineCount()) {
        break;
      }
      f1 = Math.max(f1, paramStaticLayout.getLineWidth(i));
      i += 1;
    }
  }
  
  public abstract int a();
  
  public int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return -1;
  }
  
  public int a(@NonNull MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, @Nullable TextLayer.TextItem paramTextItem, GestureHelper paramGestureHelper)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "=========================================");
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Touch X: " + paramMotionEvent.getX());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Touch Y: " + paramMotionEvent.getY());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Container W: " + paramFloat1);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Container H: " + paramFloat2);
      if (paramTextItem != null) {
        break label208;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text Zoom info is null, use default info");
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text W: " + a());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text H: " + b());
    }
    for (;;)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "=========================================");
      return -1;
      label208:
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text X: " + paramTextItem.jdField_a_of_type_AndroidGraphicsPointF.x);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text Y: " + paramTextItem.jdField_a_of_type_AndroidGraphicsPointF.y);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text W: " + paramTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text H: " + paramTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text Scale: " + paramGestureHelper.a(paramTextItem));
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text Matrix: " + paramGestureHelper.a(paramTextItem));
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text translateX: " + paramTextItem.s);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text translateY: " + paramTextItem.t);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text rotate: " + paramTextItem.r);
    }
  }
  
  @NonNull
  public Paint a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint;
  }
  
  @NonNull
  public DynamicTextItem.TextMap a()
  {
    return this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap.a(b());
  }
  
  @NonNull
  public String a(int paramInt)
  {
    int i = paramInt;
    if (paramInt != a(paramInt))
    {
      String str = "getText index out of bound, support size is " + a() + ", current index is " + paramInt;
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException(str);
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, localIndexOutOfBoundsException, new Object[] { str });
      }
      i = 0;
    }
    return this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap.a(i);
  }
  
  @NonNull
  protected final String a(int paramInt, @Nullable anwk paramanwk)
  {
    paramInt = a(paramInt);
    String str2 = a(paramInt);
    String str1 = str2;
    if (paramanwk != null) {
      str1 = paramanwk.a(paramInt, str2);
    }
    paramanwk = str1;
    int i;
    if (this.jdField_a_of_type_Int != 0)
    {
      paramanwk = str1;
      if (str1.length() > 20)
      {
        paramanwk = new StringBuilder();
        paramInt = 0;
        i = 0;
        if ((paramInt < str1.length()) && (i < 20)) {
          break label126;
        }
        paramanwk = paramanwk.toString();
        if (paramanwk.isEmpty()) {
          return paramanwk;
        }
        if (!Character.isHighSurrogate(paramanwk.charAt(paramanwk.length() - 1))) {
          break label180;
        }
      }
    }
    label180:
    for (paramInt = paramanwk.length() - 1;; paramInt = paramanwk.length())
    {
      paramanwk = paramanwk.substring(0, paramInt);
      return paramanwk;
      label126:
      paramanwk.append(str1.charAt(paramInt));
      int j = i;
      if (str1.charAt(paramInt) != '\n')
      {
        j = i;
        if (str1.charAt(paramInt) != '\r') {
          j = i + 1;
        }
      }
      paramInt += 1;
      i = j;
      break;
    }
    return paramanwk;
  }
  
  public String a(int paramInt, String paramString)
  {
    if (paramString.length() <= paramInt) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    int i = 0;
    if (k < paramString.length())
    {
      if (paramString.charAt(k) == ' ') {}
      for (int j = i + 1;; j = 0)
      {
        localStringBuilder.append(paramString.charAt(k));
        i = j;
        if (j == paramInt)
        {
          i = j;
          if (k + 1 <= paramString.length() - 1)
          {
            i = j;
            if (paramString.charAt(k + 1) == ' ')
            {
              localStringBuilder.append("\r\n");
              i = 0;
            }
          }
        }
        k += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  @NonNull
  public ArrayList a()
  {
    return new ArrayList(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap.a());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    if (c())
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      this.jdField_b_of_type_Int = i;
      return;
    }
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(int paramInt1, View paramView, boolean paramBoolean, int paramInt2, int paramInt3, Runnable paramRunnable)
  {
    if ((this.jdField_b_of_type_Boolean) || (!a())) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.c = true;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    for (;;)
    {
      int i = 0;
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$Pair.a = Integer.valueOf(paramInt1);
      paramInt1 = i;
      while (paramInt1 < paramInt2 - paramInt3)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new anwi(this, paramView), paramInt1);
        paramInt1 += paramInt3;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new anwj(this, paramBoolean, paramView, paramRunnable), paramInt1);
  }
  
  public void a(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int i = paramInt;
    if (paramInt != a(paramInt))
    {
      paramString = "setText index out of bound, support size is " + a() + ", current index is " + paramInt;
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException(paramString);
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, localIndexOutOfBoundsException, new Object[] { paramString });
      }
      i = 0;
    }
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap.a(i, str);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a();
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$Pair.a = Integer.valueOf(paramInt);
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$Pair.b = Boolean.valueOf(paramBoolean);
  }
  
  protected abstract void a(Canvas paramCanvas);
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public abstract boolean a();
  
  public boolean a(int paramInt)
  {
    return a(paramInt).equals(DynamicTextBuilder.a(this.jdField_a_of_type_Int, paramInt));
  }
  
  public abstract float b();
  
  public int b()
  {
    if (this.jdField_b_of_type_Int < 0) {
      this.jdField_b_of_type_Int = 0;
    }
    if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap.a()) {
      return 0;
    }
    return this.jdField_b_of_type_Int;
  }
  
  @NonNull
  protected final String b(int paramInt)
  {
    return a(paramInt, null);
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$Pair.b = Boolean.valueOf(false);
  }
  
  public final void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(-a() / 2.0F, -b() / 2.0F);
    a(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap.a(0, a());
  }
  
  public boolean b(int paramInt)
  {
    if ((((Integer)this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$Pair.a).intValue() == paramInt) || (((Integer)this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$Pair.a).intValue() == -1)) {
      return ((Boolean)this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$Pair.b).booleanValue();
    }
    return false;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void c()
  {
    this.c = false;
  }
  
  public final boolean c()
  {
    return a() > 1;
  }
  
  public boolean d()
  {
    ArrayList localArrayList = a();
    List localList = DynamicTextBuilder.a(this.jdField_a_of_type_Int);
    if (localList == null) {}
    int i;
    String str;
    do
    {
      do
      {
        return false;
      } while (localArrayList.size() < localList.size());
      i = 0;
      if (i >= localList.size()) {
        break label97;
      }
      str = (String)localList.get(i);
      if (str != null) {
        break;
      }
    } while (localArrayList.get(i) != null);
    while (str.equals(localArrayList.get(i)))
    {
      i += 1;
      break;
    }
    return false;
    label97:
    return true;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (DynamicTextItem)paramObject;
      if (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) {
        return false;
      }
      if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap != null) {
        return this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap.equals(paramObject.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap);
      }
    } while (paramObject.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap == null);
    return false;
  }
  
  public boolean f()
  {
    return this.c;
  }
  
  public int hashCode()
  {
    int j = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap != null) {}
    for (int i = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap.hashCode();; i = 0) {
      return i + j * 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextItem
 * JD-Core Version:    0.7.0.1
 */