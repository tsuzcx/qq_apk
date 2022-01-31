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
import android.text.InputFilter;
import android.text.StaticLayout;
import android.view.MotionEvent;
import android.view.View;
import bhlz;
import bhme;
import bhmf;
import bijr;
import bira;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class DynamicTextItem
{
  private static final String jdField_a_of_type_JavaLangString = DynamicTextItem.class.getSimpleName();
  protected int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private volatile bhme<Integer, Boolean> jdField_a_of_type_Bhme = new bhme(Integer.valueOf(-1), Boolean.valueOf(false));
  private DynamicTextItem.TextMap jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap;
  public Stack<Integer> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  protected StaticLayout b;
  private volatile boolean jdField_b_of_type_Boolean;
  private int c;
  protected boolean c;
  public boolean d;
  private volatile boolean e;
  
  public DynamicTextItem(int paramInt, @NonNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilStack = new Stack();
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Int = paramInt;
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
  
  public int a(@NonNull MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, @Nullable bijr parambijr, bira parambira)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "=========================================");
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Touch X: " + paramMotionEvent.getX());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Touch Y: " + paramMotionEvent.getY());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Container W: " + paramFloat1);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Container H: " + paramFloat2);
      if (parambijr != null) {
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text X: " + parambijr.b.x);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text Y: " + parambijr.b.y);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text W: " + parambijr.a.a());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text H: " + parambijr.a.b());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text Scale: " + parambira.a(parambijr));
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text Matrix: " + parambira.a(parambijr));
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text translateX: " + parambijr.s);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text translateY: " + parambijr.t);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "Text rotate: " + parambijr.r);
    }
  }
  
  @NonNull
  public Paint a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint;
  }
  
  public InputFilter a()
  {
    return null;
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
  protected final String a(int paramInt, @Nullable bhmf parambhmf)
  {
    paramInt = a(paramInt);
    String str2 = a(paramInt);
    String str1 = str2;
    if (parambhmf != null) {
      str1 = parambhmf.a(paramInt, str2);
    }
    return a(str1);
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
  
  public String a(String paramString)
  {
    Object localObject = paramString;
    int j;
    if (this.jdField_b_of_type_Int != 0)
    {
      localObject = paramString;
      if (paramString.length() > 20)
      {
        localObject = new StringBuilder();
        i = 0;
        j = 0;
        if ((i < paramString.length()) && (j < 20)) {
          break label99;
        }
        paramString = ((StringBuilder)localObject).toString();
        localObject = paramString;
        if (!paramString.isEmpty()) {
          if (!Character.isHighSurrogate(paramString.charAt(paramString.length() - 1))) {
            break label151;
          }
        }
      }
    }
    label151:
    for (int i = paramString.length() - 1;; i = paramString.length())
    {
      localObject = paramString.substring(0, i);
      return localObject;
      label99:
      ((StringBuilder)localObject).append(paramString.charAt(i));
      int k = j;
      if (paramString.charAt(i) != '\n')
      {
        k = j;
        if (paramString.charAt(i) != '\r') {
          k = j + 1;
        }
      }
      i += 1;
      j = k;
      break;
    }
  }
  
  @NonNull
  public ArrayList<String> a()
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
  
  public void a(int paramInt1, View paramView, boolean paramBoolean, int paramInt2, int paramInt3, Runnable paramRunnable)
  {
    if ((this.jdField_b_of_type_Boolean) || (!a())) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.e = true;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    for (;;)
    {
      int i = 0;
      this.jdField_a_of_type_Bhme.a = Integer.valueOf(paramInt1);
      paramInt1 = i;
      while (paramInt1 < paramInt2 - paramInt3)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new DynamicTextItem.1(this, paramView), paramInt1);
        paramInt1 += paramInt3;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new DynamicTextItem.2(this, paramBoolean, paramView, paramRunnable), paramInt1);
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
    this.jdField_a_of_type_Bhme.a = Integer.valueOf(paramInt);
    this.jdField_a_of_type_Bhme.b = Boolean.valueOf(paramBoolean);
  }
  
  protected abstract void a(Canvas paramCanvas);
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public abstract boolean a();
  
  public boolean a(int paramInt)
  {
    return a(paramInt).equals(bhlz.a(this.jdField_b_of_type_Int, paramInt));
  }
  
  public abstract float b();
  
  public int b()
  {
    if (this.jdField_c_of_type_Int < 0) {
      this.jdField_c_of_type_Int = 0;
    }
    if (this.jdField_c_of_type_Int >= this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap.a()) {
      return 0;
    }
    return this.jdField_c_of_type_Int;
  }
  
  @NonNull
  protected final String b(int paramInt)
  {
    return a(paramInt, null);
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_Bhme.b = Boolean.valueOf(false);
  }
  
  public void b(int paramInt)
  {
    if (c())
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      this.jdField_c_of_type_Int = i;
      return;
    }
    this.jdField_c_of_type_Int = 0;
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
    if ((((Integer)this.jdField_a_of_type_Bhme.a).intValue() == paramInt) || (((Integer)this.jdField_a_of_type_Bhme.a).intValue() == -1)) {
      return ((Boolean)this.jdField_a_of_type_Bhme.b).booleanValue();
    }
    return false;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void c()
  {
    this.e = false;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final boolean c()
  {
    return a() > 1;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean d()
  {
    ArrayList localArrayList = a();
    List localList = bhlz.a(this.jdField_b_of_type_Int);
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
      if (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int) {
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
    return this.e;
  }
  
  public int hashCode()
  {
    int j = this.jdField_b_of_type_Int;
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