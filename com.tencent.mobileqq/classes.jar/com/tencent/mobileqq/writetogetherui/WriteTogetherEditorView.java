package com.tencent.mobileqq.writetogetherui;

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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.writetogether.WriteTogetherUtils;
import com.tencent.mobileqq.writetogether.client.IEditorController;
import com.tencent.mobileqq.writetogether.data.InsertDeleteWatcher;
import com.tencent.mobileqq.writetogether.data.UserEditInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WriteTogetherEditorView
  extends EditText
  implements View.OnClickListener, View.OnFocusChangeListener, IEditorView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private IEditorController jdField_a_of_type_ComTencentMobileqqWritetogetherClientIEditorController;
  private WriteTogetherEditorView.OnEditorClickEventListener jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView$OnEditorClickEventListener;
  private List<UserEditInfo> jdField_a_of_type_JavaUtilList;
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
  
  @NonNull
  private String a(String paramString, boolean paramBoolean, TextPaint paramTextPaint, int paramInt)
  {
    if (paramBoolean)
    {
      int i = paramString.lastIndexOf("等");
      String str = paramString.substring(i);
      paramString = paramString.substring(0, i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TextUtils.ellipsize(paramString, paramTextPaint, paramInt - paramTextPaint.measureText(str), TextUtils.TruncateAt.END).toString());
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
    return TextUtils.ellipsize(paramString, paramTextPaint, paramInt, TextUtils.TruncateAt.END).toString();
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = (ClipboardManager)getContext().getSystemService("clipboard");
    ClipboardMonitor.getPrimaryClip((ClipboardManager)localObject1);
    ClipData localClipData = ((ClipboardManager)localObject1).getPrimaryClip();
    int[] arrayOfInt = new int[1];
    if (localClipData != null)
    {
      int m = 0;
      int i = 0;
      Object localObject2;
      int k;
      for (int j = 0; i < localClipData.getItemCount(); j = k)
      {
        if ((paramBoolean) && (Build.VERSION.SDK_INT > 15))
        {
          localObject1 = localClipData.getItemAt(i).coerceToStyledText(getContext());
        }
        else
        {
          localObject2 = localClipData.getItemAt(i).coerceToText(getContext());
          localObject1 = localObject2;
          if ((localObject2 instanceof Spanned)) {
            localObject1 = ((CharSequence)localObject2).toString();
          }
        }
        k = j;
        if (localObject1 != null)
        {
          localObject2 = getEditableText();
          localObject1 = WriteTogetherUtils.a((CharSequence)localObject1);
          arrayOfInt[0] += ((CharSequence)localObject1).length();
          if (j == 0)
          {
            setSelection(paramInt2);
            ((Editable)localObject2).replace(paramInt1, paramInt2, (CharSequence)localObject1);
            k = 1;
          }
          else
          {
            ((Editable)localObject2).insert(getSelectionEnd(), "\n");
            ((Editable)localObject2).insert(getSelectionEnd(), (CharSequence)localObject1);
            k = j;
          }
        }
        i += 1;
      }
      try
      {
        localObject1 = TextView.class.getFields();
        paramInt2 = localObject1.length;
        paramInt1 = m;
        while (paramInt1 < paramInt2)
        {
          localObject2 = localObject1[paramInt1];
          if ("sLastCutCopyOrTextChangedTime".equals(((Field)localObject2).getName()))
          {
            ((Field)localObject2).setLong(null, 0L);
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
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(getResources().getColor(2131167394));
    paramInt = getResources().getDimensionPixelSize(2131299304);
    paramString = a(paramString, paramBoolean, this.jdField_a_of_type_AndroidTextTextPaint, paramInt);
    float f3 = getResources().getDimensionPixelSize(2131299285);
    paramBoolean = a(this.jdField_a_of_type_AndroidTextTextPaint, paramString, paramPoint, getWidth(), f3, f3);
    int j = (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(paramString);
    int k = paramPoint.y;
    int m = (int)f1;
    int n = paramPoint.y;
    int i1 = (int)paramFloat;
    int i2 = getResources().getDimensionPixelSize(2131299303);
    int i;
    if (paramBoolean)
    {
      paramInt = paramPoint.x;
      i = (int)f3 * 2;
      paramInt += i;
      i = paramPoint.x + i + j + i2 * 2;
    }
    else
    {
      paramInt = paramPoint.x;
      i = (int)f3;
      paramInt = paramInt - i - j - i2 * 2;
      i = paramPoint.x - i;
    }
    RectF localRectF = new RectF();
    localRectF.set(paramInt, k + m, i, n + i1 + m);
    f1 = paramPoint.y;
    float f2 = (this.jdField_b_of_type_Float + paramFloat) / 2.0F;
    if (paramBoolean) {
      paramFloat = paramPoint.x + f3 * 2.0F + i2;
    } else {
      paramFloat = paramPoint.x - f3 - j - i2;
    }
    f3 = getResources().getDimensionPixelSize(2131299305);
    paramCanvas.drawRoundRect(localRectF, f3, f3, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawText(paramString, paramFloat, f1 + f2, this.jdField_a_of_type_AndroidTextTextPaint);
  }
  
  private void a(Canvas paramCanvas, List<UserEditInfo> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      UserEditInfo localUserEditInfo = (UserEditInfo)localIterator.next();
      if ((localUserEditInfo != null) && (localUserEditInfo.jdField_c_of_type_Int >= 0))
      {
        Point localPoint = a(localUserEditInfo.jdField_c_of_type_Int);
        if (localPoint != null)
        {
          if (a(localUserEditInfo.jdField_c_of_type_Int) == 0) {
            localPoint.y = this.jdField_c_of_type_Int;
          }
          paramList = (Float)this.jdField_a_of_type_JavaUtilMap.get(localUserEditInfo.jdField_a_of_type_JavaLangString);
          if ((paramList != null) && (paramList.floatValue() < 0.5F)) {
            a(paramCanvas, localPoint, this.jdField_a_of_type_Float, localUserEditInfo.jdField_b_of_type_Int);
          }
          if (localUserEditInfo.jdField_a_of_type_Boolean)
          {
            String str = localUserEditInfo.jdField_b_of_type_JavaLangString;
            paramList = str;
            if (str == null) {
              paramList = "";
            }
            a(paramCanvas, localPoint, this.jdField_a_of_type_Float, paramList, localUserEditInfo.jdField_b_of_type_Int, localUserEditInfo.jdField_b_of_type_Boolean);
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
    float f = paramPaint.measureText(paramString);
    return paramPoint.x + (f + paramFloat2 + paramFloat3) <= paramFloat1;
  }
  
  private void d()
  {
    b();
    e();
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
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(getResources().getColor(2131167394));
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(1);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(1000L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new WriteTogetherEditorView.1(this));
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
    WriteTogetherEditorView.2 local2 = new WriteTogetherEditorView.2(this);
    setCustomSelectionActionModeCallback(local2);
    if (Build.VERSION.SDK_INT >= 23) {
      setCustomInsertionActionModeCallback(local2);
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
  
  public void a(InsertDeleteWatcher paramInsertDeleteWatcher)
  {
    addTextChangedListener(paramInsertDeleteWatcher);
  }
  
  public void a(String paramString)
  {
    Editable localEditable = getEditableText();
    localEditable.replace(0, localEditable.length(), paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Float = getResources().getDimensionPixelSize(2131299302);
    this.jdField_b_of_type_Float = getResources().getDimensionPixelSize(2131299306);
    this.jdField_c_of_type_Float = getLineHeight();
    this.jdField_d_of_type_Float = getResources().getDimensionPixelSize(2131299285);
    this.jdField_c_of_type_Int = getResources().getDimensionPixelSize(2131299291);
    super.setOnClickListener(this);
  }
  
  public void b(InsertDeleteWatcher paramInsertDeleteWatcher)
  {
    removeTextChangedListener(paramInsertDeleteWatcher);
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
    if (localObject == null)
    {
      QLog.e("WriteTogetherEditorView", 1, "[activateEditorAndSetSelToEnd] getText is null");
      return;
    }
    setSelection(((Editable)localObject).length());
    setCursorVisible(true);
    localObject = (InputMethodManager)getContext().getSystemService("input_method");
    if (localObject != null) {
      ((InputMethodManager)localObject).showSoftInput(this, 0);
    }
  }
  
  public boolean isSuggestionsEnabled()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    g();
    f();
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
    WriteTogetherEditorView.OnEditorClickEventListener localOnEditorClickEventListener = this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView$OnEditorClickEventListener;
    if (localOnEditorClickEventListener != null)
    {
      localOnEditorClickEventListener.f();
      setCursorVisible(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return new WriteTogetherEditorView.WtInputConnectionWrapper(this, super.onCreateInputConnection(paramEditorInfo), false);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIEditorController;
    if (localObject != null)
    {
      this.jdField_a_of_type_JavaUtilList = ((IEditorController)localObject).a();
      localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() != 0)) {
        a(paramCanvas, this.jdField_a_of_type_JavaUtilList);
      }
    }
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (this.e)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView$OnEditorClickEventListener;
      if (paramView != null)
      {
        paramView.f();
        setCursorVisible(true);
      }
      this.e = false;
    }
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (paramInt1 != 0) {
      setCursorVisible(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIEditorController != null)
    {
      boolean bool;
      if ((!this.jdField_a_of_type_Boolean) && ((paramInt1 != this.jdField_a_of_type_Int) || (paramInt2 != this.jdField_b_of_type_Int))) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onSelectionChanged] userChangeCursorIndex: ");
        localStringBuilder.append(bool);
        localStringBuilder.append(", selStart: ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(", selEnd: ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(", mSelStart: ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(", mSelEnd: ");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        localStringBuilder.append(", mTyping: ");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        QLog.d("WriteTogetherEditorView", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIEditorController.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt1, paramInt2, bool);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
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
    switch (paramInt)
    {
    default: 
      i = 0;
      break;
    case 16908341: 
      i = 6;
      break;
    case 16908328: 
      i = 1;
      break;
    case 16908322: 
      i = 4;
      break;
    case 16908321: 
      i = 3;
      break;
    case 16908319: 
      i = 2;
    }
    if (i != 0) {
      ReportController.b(null, "dc00898", "", "", "0X800AF34", "0X800AF34", i, 0, "", "", "", "");
    }
    int i = a().length();
    int j;
    if (isFocused())
    {
      i = getSelectionStart();
      int k = getSelectionEnd();
      j = Math.max(0, Math.min(i, k));
      i = Math.max(0, Math.max(i, k));
    }
    else
    {
      j = 0;
    }
    if (paramInt == 16908322)
    {
      a(j, i, true);
      return true;
    }
    if (paramInt == 16908337)
    {
      a(j, i, false);
      return true;
    }
    return super.onTextContextMenuItem(paramInt);
  }
  
  public void setClient(IEditorController paramIEditorController)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientIEditorController = paramIEditorController;
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
  
  public void setOnEditorClickEventListener(WriteTogetherEditorView.OnEditorClickEventListener paramOnEditorClickEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView$OnEditorClickEventListener = paramOnEditorClickEventListener;
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setSelection] start: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", stop: ");
      localStringBuilder.append(paramInt2);
      QLog.d("WriteTogetherEditorView", 2, localStringBuilder.toString());
    }
    super.setSelection(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorView
 * JD-Core Version:    0.7.0.1
 */