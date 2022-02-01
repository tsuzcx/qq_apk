package com.tencent.mobileqq.togetherui.writetogether;

import android.animation.ValueAnimator;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import bcef;
import bdgn;
import bdgy;
import bdhu;
import bdhy;
import bdjw;
import bdkw;
import bdkx;
import bdky;
import bdkz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class WriteTogetherEditorView
  extends EditText
  implements View.OnClickListener, View.OnFocusChangeListener, bdjw
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private bdgy jdField_a_of_type_Bdgy;
  private bdky jdField_a_of_type_Bdky;
  private List<bdhy> jdField_a_of_type_JavaUtilList;
  private Map<String, Float> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e = true;
  
  public WriteTogetherEditorView(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public WriteTogetherEditorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  public WriteTogetherEditorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private int a(int paramInt)
  {
    return getLayout().getLineForOffset(paramInt);
  }
  
  private Point a(int paramInt)
  {
    Layout localLayout = getLayout();
    Rect localRect = new Rect();
    localLayout.getLineBounds(localLayout.getLineForOffset(paramInt), localRect);
    Point localPoint = new Point();
    if (paramInt <= localLayout.getText().length())
    {
      localPoint.x = ((int)localLayout.getPrimaryHorizontal(paramInt));
      localPoint.y = localRect.top;
      return localPoint;
    }
    return null;
  }
  
  @NotNull
  private String a(String paramString, boolean paramBoolean, TextPaint paramTextPaint, int paramInt)
  {
    if (paramBoolean)
    {
      int i = paramString.lastIndexOf("等");
      String str = paramString.substring(i);
      paramString = paramString.substring(0, i);
      return TextUtils.ellipsize(paramString, paramTextPaint, paramInt - paramTextPaint.measureText(str), TextUtils.TruncateAt.END).toString() + str;
    }
    return TextUtils.ellipsize(paramString, paramTextPaint, paramInt, TextUtils.TruncateAt.END).toString();
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int m = 0;
    ClipData localClipData = ((ClipboardManager)getContext().getSystemService("clipboard")).getPrimaryClip();
    int[] arrayOfInt = new int[1];
    Object localObject1;
    label74:
    Object localObject2;
    if (localClipData != null)
    {
      int i = 0;
      int j = 0;
      if (i < localClipData.getItemCount())
      {
        if ((paramBoolean) && (Build.VERSION.SDK_INT > 15))
        {
          localObject1 = localClipData.getItemAt(i).coerceToStyledText(getContext());
          k = j;
          if (localObject1 != null)
          {
            localObject2 = getEditableText();
            localObject1 = bdgn.a((CharSequence)localObject1);
            arrayOfInt[0] += ((CharSequence)localObject1).length();
            if (j != 0) {
              break label190;
            }
            setSelection(paramInt2);
            ((Editable)localObject2).replace(paramInt1, paramInt2, (CharSequence)localObject1);
          }
        }
        for (int k = 1;; k = j)
        {
          i += 1;
          j = k;
          break;
          localObject2 = localClipData.getItemAt(i).coerceToText(getContext());
          localObject1 = localObject2;
          if (!(localObject2 instanceof Spanned)) {
            break label74;
          }
          localObject1 = ((CharSequence)localObject2).toString();
          break label74;
          label190:
          ((Editable)localObject2).insert(getSelectionEnd(), "\n");
          ((Editable)localObject2).insert(getSelectionEnd(), (CharSequence)localObject1);
        }
      }
    }
    try
    {
      localObject1 = TextView.class.getFields();
      paramInt2 = localObject1.length;
      paramInt1 = m;
      for (;;)
      {
        if (paramInt1 < paramInt2)
        {
          localObject2 = localObject1[paramInt1];
          if ("sLastCutCopyOrTextChangedTime".equals(((Field)localObject2).getName())) {
            ((Field)localObject2).setLong(null, 0L);
          }
        }
        else
        {
          return;
        }
        paramInt1 += 1;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WriteTogetherEditorView", 1, "[paste] reflect failed: ", localThrowable);
    }
  }
  
  private void a(Canvas paramCanvas, Point paramPoint, float paramFloat, int paramInt)
  {
    float f1 = (this.jdField_c_of_type_Float - this.jdField_a_of_type_Float) / 2.0F;
    float f2 = paramPoint.x;
    float f3 = this.jdField_d_of_type_Float / 2.0F;
    float f4 = paramPoint.y;
    float f5 = paramPoint.x;
    float f6 = this.jdField_d_of_type_Float / 2.0F;
    float f7 = paramPoint.y;
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
    paramCanvas.drawLine(f2 + f3, f4 + f1, f5 + f6, f7 + paramFloat + f1, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  private void a(Canvas paramCanvas, Point paramPoint, float paramFloat, String paramString, int paramInt, boolean paramBoolean)
  {
    float f1 = (this.jdField_c_of_type_Float - this.jdField_a_of_type_Float) / 2.0F;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(getResources().getColor(2131167337));
    paramInt = getResources().getDimensionPixelSize(2131299201);
    paramString = a(paramString, paramBoolean, this.jdField_a_of_type_AndroidTextTextPaint, paramInt);
    float f3 = getResources().getDimensionPixelSize(2131299185);
    paramBoolean = a(this.jdField_a_of_type_AndroidTextTextPaint, paramString, paramPoint, getWidth(), f3, f3);
    int j = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(paramString);
    int k = paramPoint.y;
    int m = (int)f1;
    int n = paramPoint.y;
    int i1 = (int)paramFloat;
    int i2 = (int)f1;
    int i3 = getResources().getDimensionPixelSize(2131299200);
    int i;
    RectF localRectF;
    float f2;
    if (paramBoolean)
    {
      paramInt = paramPoint.x;
      i = (int)f3 * 2 + paramInt;
      paramInt = paramPoint.x + (int)f3 * 2 + j + i3 * 2;
      localRectF = new RectF();
      localRectF.set(i, k + m, paramInt, n + i1 + i2);
      f1 = paramPoint.y;
      f2 = (this.jdField_b_of_type_Float + paramFloat) / 2.0F;
      if (!paramBoolean) {
        break label340;
      }
    }
    label340:
    for (paramFloat = paramPoint.x + 2.0F * f3 + i3;; paramFloat = paramPoint.x - f3 - j - i3)
    {
      f3 = getResources().getDimensionPixelSize(2131299202);
      paramCanvas.drawRoundRect(localRectF, f3, f3, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawText(paramString, paramFloat, f2 + f1, this.jdField_a_of_type_AndroidTextTextPaint);
      return;
      i = paramPoint.x - (int)f3 - j - i3 * 2;
      paramInt = paramPoint.x - (int)f3;
      break;
    }
  }
  
  private void a(Canvas paramCanvas, List<bdhy> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      bdhy localbdhy = (bdhy)localIterator.next();
      if ((localbdhy != null) && (localbdhy.jdField_c_of_type_Int >= 0))
      {
        Point localPoint = a(localbdhy.jdField_c_of_type_Int);
        if (localPoint != null)
        {
          if (a(localbdhy.jdField_c_of_type_Int) == 0) {
            localPoint.y = this.jdField_c_of_type_Int;
          }
          paramList = (Float)this.jdField_a_of_type_JavaUtilMap.get(localbdhy.jdField_a_of_type_JavaLangString);
          if ((paramList != null) && (paramList.floatValue() < 0.5F)) {
            a(paramCanvas, localPoint, this.jdField_a_of_type_Float, localbdhy.jdField_b_of_type_Int);
          }
          if (localbdhy.jdField_a_of_type_Boolean)
          {
            String str = localbdhy.jdField_b_of_type_JavaLangString;
            paramList = str;
            if (str == null) {
              paramList = "";
            }
            a(paramCanvas, localPoint, this.jdField_a_of_type_Float, paramList, localbdhy.jdField_b_of_type_Int, localbdhy.jdField_b_of_type_Boolean);
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    setFocusableInTouchMode(paramBoolean);
    if (!paramBoolean) {
      clearFocus();
    }
  }
  
  private boolean a(Paint paramPaint, String paramString, Point paramPoint, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramPaint.measureText(paramString) + paramFloat2 + paramFloat3 + paramPoint.x <= paramFloat1;
  }
  
  private void d()
  {
    b();
    e();
    f();
    h();
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.SQUARE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_d_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(getResources().getColor(2131167337));
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(1);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(1000L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bdkw(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void g()
  {
    ((ViewGroup)getParent()).setFocusable(true);
    setFocusable(false);
    clearFocus();
    setOnFocusChangeListener(this);
    setCursorVisible(false);
  }
  
  private void h()
  {
    bdkx localbdkx = new bdkx(this);
    setCustomSelectionActionModeCallback(localbdkx);
    if (Build.VERSION.SDK_INT >= 23) {
      setCustomInsertionActionModeCallback(localbdkx);
    }
  }
  
  public String a()
  {
    return getText().toString();
  }
  
  public void a()
  {
    invalidate();
  }
  
  public void a(bdhu parambdhu)
  {
    addTextChangedListener(parambdhu);
  }
  
  public void a(String paramString)
  {
    Editable localEditable = getEditableText();
    localEditable.replace(0, localEditable.length(), paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Float = getResources().getDimensionPixelSize(2131299199);
    this.jdField_b_of_type_Float = getResources().getDimensionPixelSize(2131299203);
    this.jdField_c_of_type_Float = getLineHeight();
    this.jdField_d_of_type_Float = getResources().getDimensionPixelSize(2131299185);
    this.jdField_c_of_type_Int = getResources().getDimensionPixelSize(2131299191);
    super.setOnClickListener(this);
  }
  
  public void b(bdhu parambdhu)
  {
    removeTextChangedListener(parambdhu);
  }
  
  public void b(String paramString)
  {
    super.setText(paramString);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void c()
  {
    setFocusable(true);
    setEnabled(true);
    requestFocus();
    Object localObject = getText();
    if (localObject == null) {
      QLog.e("WriteTogetherEditorView", 1, "[activateEditorAndSetSelToEnd] getText is null");
    }
    do
    {
      return;
      setSelection(((Editable)localObject).length());
      setCursorVisible(true);
      localObject = (InputMethodManager)getContext().getSystemService("input_method");
    } while (localObject == null);
    ((InputMethodManager)localObject).showSoftInput(this, 0);
  }
  
  public boolean isSuggestionsEnabled()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    g();
  }
  
  public void onClick(View paramView)
  {
    QLog.d("WriteTogetherEditorView", 1, "[onClick] This is click");
    if (this.jdField_c_of_type_Boolean)
    {
      a(true);
      setFocusable(true);
      setFocusableInTouchMode(true);
      requestFocus();
    }
    if (this.jdField_a_of_type_Bdky != null)
    {
      this.jdField_a_of_type_Bdky.f();
      setCursorVisible(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return new bdkz(this, super.onCreateInputConnection(paramEditorInfo), false);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Bdgy != null)
    {
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Bdgy.a();
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0)) {
        a(paramCanvas, this.jdField_a_of_type_JavaUtilList);
      }
    }
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (this.e)
    {
      if (this.jdField_a_of_type_Bdky != null)
      {
        this.jdField_a_of_type_Bdky.f();
        setCursorVisible(true);
      }
      this.e = false;
    }
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    super.onSelectionChanged(paramInt1, paramInt2);
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      if (paramInt1 != 0) {
        setCursorVisible(true);
      }
    } while (this.jdField_a_of_type_Bdgy == null);
    if (!this.jdField_a_of_type_Boolean)
    {
      bool1 = bool2;
      if (paramInt1 == this.jdField_a_of_type_Int) {
        if (paramInt2 == this.jdField_b_of_type_Int) {
          break label189;
        }
      }
    }
    label189:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WriteTogetherEditorView", 2, "[onSelectionChanged] userChangeCursorIndex: " + bool1 + ", selStart: " + paramInt1 + ", selEnd: " + paramInt2 + ", mSelStart: " + this.jdField_a_of_type_Int + ", mSelEnd: " + this.jdField_b_of_type_Int + ", mTyping: " + this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_Bdgy.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt1, paramInt2, bool1);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      return;
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    int i;
    int j;
    switch (paramInt)
    {
    default: 
      i = 0;
      if (i != 0) {
        bcef.b(null, "dc00898", "", "", "0X800AF34", "0X800AF34", i, 0, "", "", "", "");
      }
      i = a().length();
      if (isFocused())
      {
        i = getSelectionStart();
        int k = getSelectionEnd();
        j = Math.max(0, Math.min(i, k));
        i = Math.max(0, Math.max(i, k));
      }
      break;
    }
    for (;;)
    {
      if (paramInt == 16908322)
      {
        a(j, i, true);
        return true;
        i = 1;
        break;
        i = 2;
        break;
        i = 3;
        break;
        i = 4;
        break;
        i = 6;
        break;
      }
      if (paramInt == 16908337)
      {
        a(j, i, false);
        return true;
      }
      return super.onTextContextMenuItem(paramInt);
      j = 0;
    }
  }
  
  public void setClient(bdgy parambdgy)
  {
    this.jdField_a_of_type_Bdgy = parambdgy;
  }
  
  public void setEditorEnabled(boolean paramBoolean)
  {
    setEnabled(paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    a(paramBoolean);
  }
  
  public void setMySelection(int paramInt1, int paramInt2)
  {
    setSelection(paramInt1, paramInt2);
  }
  
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener) {}
  
  public void setOnEditorClickEventListener(bdky parambdky)
  {
    this.jdField_a_of_type_Bdky = parambdky;
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherEditorView", 2, "[setSelection] start: " + paramInt1 + ", stop: " + paramInt2);
    }
    super.setSelection(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.togetherui.writetogether.WriteTogetherEditorView
 * JD-Core Version:    0.7.0.1
 */