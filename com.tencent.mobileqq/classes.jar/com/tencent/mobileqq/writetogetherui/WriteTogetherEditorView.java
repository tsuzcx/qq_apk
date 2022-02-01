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
  private IEditorController a;
  private float b;
  private float c;
  private float d;
  private int e;
  private int f;
  private float g;
  private int h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l = true;
  private boolean m = true;
  private WriteTogetherEditorView.OnEditorClickEventListener n;
  private TextPaint o;
  private Paint p;
  private Paint q;
  private ValueAnimator r;
  private Map<String, Float> s;
  private List<UserEditInfo> t;
  
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
      int i1 = paramString.lastIndexOf("等");
      String str = paramString.substring(i1);
      paramString = paramString.substring(0, i1);
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
      int i4 = 0;
      int i1 = 0;
      Object localObject2;
      int i3;
      for (int i2 = 0; i1 < localClipData.getItemCount(); i2 = i3)
      {
        if ((paramBoolean) && (Build.VERSION.SDK_INT > 15))
        {
          localObject1 = localClipData.getItemAt(i1).coerceToStyledText(getContext());
        }
        else
        {
          localObject2 = localClipData.getItemAt(i1).coerceToText(getContext());
          localObject1 = localObject2;
          if ((localObject2 instanceof Spanned)) {
            localObject1 = ((CharSequence)localObject2).toString();
          }
        }
        i3 = i2;
        if (localObject1 != null)
        {
          localObject2 = getEditableText();
          localObject1 = WriteTogetherUtils.a((CharSequence)localObject1);
          arrayOfInt[0] += ((CharSequence)localObject1).length();
          if (i2 == 0)
          {
            setSelection(paramInt2);
            ((Editable)localObject2).replace(paramInt1, paramInt2, (CharSequence)localObject1);
            i3 = 1;
          }
          else
          {
            ((Editable)localObject2).insert(getSelectionEnd(), "\n");
            ((Editable)localObject2).insert(getSelectionEnd(), (CharSequence)localObject1);
            i3 = i2;
          }
        }
        i1 += 1;
      }
      try
      {
        localObject1 = TextView.class.getFields();
        paramInt2 = localObject1.length;
        paramInt1 = i4;
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
    float f1 = (this.d - this.b) / 2.0F;
    float f2 = paramPoint.x;
    float f3 = this.g / 2.0F;
    float f4 = paramPoint.y;
    float f5 = paramPoint.x;
    float f6 = this.g / 2.0F;
    float f7 = paramPoint.y;
    this.q.setColor(paramInt);
    paramCanvas.drawLine(f2 + f3, f4 + f1, f5 + f6, f7 + paramFloat + f1, this.q);
  }
  
  private void a(Canvas paramCanvas, Point paramPoint, float paramFloat, String paramString, int paramInt, boolean paramBoolean)
  {
    float f1 = (this.d - this.b) / 2.0F;
    this.p.setColor(paramInt);
    this.o.setColor(getResources().getColor(2131168464));
    paramInt = getResources().getDimensionPixelSize(2131300099);
    paramString = a(paramString, paramBoolean, this.o, paramInt);
    float f3 = getResources().getDimensionPixelSize(2131300080);
    paramBoolean = a(this.o, paramString, paramPoint, getWidth(), f3, f3);
    int i2 = (int)this.o.measureText(paramString);
    int i3 = paramPoint.y;
    int i4 = (int)f1;
    int i5 = paramPoint.y;
    int i6 = (int)paramFloat;
    int i7 = getResources().getDimensionPixelSize(2131300098);
    int i1;
    if (paramBoolean)
    {
      paramInt = paramPoint.x;
      i1 = (int)f3 * 2;
      paramInt += i1;
      i1 = paramPoint.x + i1 + i2 + i7 * 2;
    }
    else
    {
      paramInt = paramPoint.x;
      i1 = (int)f3;
      paramInt = paramInt - i1 - i2 - i7 * 2;
      i1 = paramPoint.x - i1;
    }
    RectF localRectF = new RectF();
    localRectF.set(paramInt, i3 + i4, i1, i5 + i6 + i4);
    f1 = paramPoint.y;
    float f2 = (this.c + paramFloat) / 2.0F;
    if (paramBoolean) {
      paramFloat = paramPoint.x + f3 * 2.0F + i7;
    } else {
      paramFloat = paramPoint.x - f3 - i2 - i7;
    }
    f3 = getResources().getDimensionPixelSize(2131300100);
    paramCanvas.drawRoundRect(localRectF, f3, f3, this.p);
    paramCanvas.drawText(paramString, paramFloat, f1 + f2, this.o);
  }
  
  private void a(Canvas paramCanvas, List<UserEditInfo> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      UserEditInfo localUserEditInfo = (UserEditInfo)localIterator.next();
      if ((localUserEditInfo != null) && (localUserEditInfo.f >= 0))
      {
        Point localPoint = a(localUserEditInfo.f);
        if (localPoint != null)
        {
          if (b(localUserEditInfo.f) == 0) {
            localPoint.y = this.h;
          }
          paramList = (Float)this.s.get(localUserEditInfo.a);
          if ((paramList != null) && (paramList.floatValue() < 0.5F)) {
            a(paramCanvas, localPoint, this.b, localUserEditInfo.d);
          }
          if (localUserEditInfo.e)
          {
            String str = localUserEditInfo.b;
            paramList = str;
            if (str == null) {
              paramList = "";
            }
            a(paramCanvas, localPoint, this.b, paramList, localUserEditInfo.d, localUserEditInfo.h);
          }
        }
      }
    }
  }
  
  private boolean a(Paint paramPaint, String paramString, Point paramPoint, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = paramPaint.measureText(paramString);
    return paramPoint.x + (f1 + paramFloat2 + paramFloat3) <= paramFloat1;
  }
  
  private int b(int paramInt)
  {
    return getLayout().getLineForOffset(paramInt);
  }
  
  private void d()
  {
    b();
    e();
    h();
  }
  
  private void e()
  {
    this.q = new Paint();
    this.q.setStyle(Paint.Style.STROKE);
    this.q.setStrokeCap(Paint.Cap.SQUARE);
    this.q.setStrokeWidth(this.g);
    this.p = new Paint();
    this.p.setStyle(Paint.Style.FILL);
    this.o = new TextPaint();
    this.o.setTextSize(this.c);
    this.o.setColor(getResources().getColor(2131168464));
  }
  
  private void f()
  {
    this.s = new HashMap();
    this.r = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.r.setRepeatMode(1);
    this.r.setRepeatCount(-1);
    this.r.setDuration(1000L);
    this.r.addUpdateListener(new WriteTogetherEditorView.1(this));
    this.r.start();
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
  
  private void setScrollableEnabled(boolean paramBoolean)
  {
    setFocusableInTouchMode(paramBoolean);
    if (!paramBoolean) {
      clearFocus();
    }
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
    this.b = getResources().getDimensionPixelSize(2131300097);
    this.c = getResources().getDimensionPixelSize(2131300101);
    this.d = getLineHeight();
    this.g = getResources().getDimensionPixelSize(2131300080);
    this.h = getResources().getDimensionPixelSize(2131300086);
    super.setOnClickListener(this);
  }
  
  public void b(InsertDeleteWatcher paramInsertDeleteWatcher)
  {
    removeTextChangedListener(paramInsertDeleteWatcher);
  }
  
  public void b(String paramString)
  {
    super.setText(paramString);
    this.j = true;
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
  
  public String getEditorText()
  {
    return getText().toString();
  }
  
  public boolean isSuggestionsEnabled()
  {
    return this.k;
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
    if (this.k)
    {
      setScrollableEnabled(true);
      setFocusable(true);
      setFocusableInTouchMode(true);
      requestFocus();
    }
    WriteTogetherEditorView.OnEditorClickEventListener localOnEditorClickEventListener = this.n;
    if (localOnEditorClickEventListener != null)
    {
      localOnEditorClickEventListener.g();
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
    this.r.removeAllUpdateListeners();
    this.r.removeAllListeners();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject = this.a;
    if (localObject != null)
    {
      this.t = ((IEditorController)localObject).a();
      localObject = this.t;
      if ((localObject != null) && (((List)localObject).size() != 0)) {
        a(paramCanvas, this.t);
      }
    }
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (this.m)
    {
      paramView = this.n;
      if (paramView != null)
      {
        paramView.g();
        setCursorVisible(true);
      }
      this.m = false;
    }
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    if (!this.k) {
      return;
    }
    if (paramInt1 != 0) {
      setCursorVisible(true);
    }
    if (this.a != null)
    {
      boolean bool;
      if ((!this.i) && ((paramInt1 != this.e) || (paramInt2 != this.f))) {
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
        localStringBuilder.append(this.e);
        localStringBuilder.append(", mSelEnd: ");
        localStringBuilder.append(this.f);
        localStringBuilder.append(", mTyping: ");
        localStringBuilder.append(this.i);
        QLog.d("WriteTogetherEditorView", 2, localStringBuilder.toString());
      }
      this.a.a(this.e, this.f, paramInt1, paramInt2, bool);
      this.i = false;
      this.e = paramInt1;
      this.f = paramInt2;
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    this.i = true;
    if (this.j)
    {
      this.i = false;
      this.j = false;
    }
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      i1 = 0;
      break;
    case 16908341: 
      i1 = 6;
      break;
    case 16908328: 
      i1 = 1;
      break;
    case 16908322: 
      i1 = 4;
      break;
    case 16908321: 
      i1 = 3;
      break;
    case 16908319: 
      i1 = 2;
    }
    if (i1 != 0) {
      ReportController.b(null, "dc00898", "", "", "0X800AF34", "0X800AF34", i1, 0, "", "", "", "");
    }
    int i1 = getEditorText().length();
    int i2;
    if (isFocused())
    {
      i1 = getSelectionStart();
      int i3 = getSelectionEnd();
      i2 = Math.max(0, Math.min(i1, i3));
      i1 = Math.max(0, Math.max(i1, i3));
    }
    else
    {
      i2 = 0;
    }
    if (paramInt == 16908322)
    {
      a(i2, i1, true);
      return true;
    }
    if (paramInt == 16908337)
    {
      a(i2, i1, false);
      return true;
    }
    return super.onTextContextMenuItem(paramInt);
  }
  
  public void setClient(IEditorController paramIEditorController)
  {
    this.a = paramIEditorController;
  }
  
  public void setEditorEnabled(boolean paramBoolean)
  {
    setEnabled(paramBoolean);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.k = paramBoolean;
    setScrollableEnabled(paramBoolean);
  }
  
  public void setMySelection(int paramInt1, int paramInt2)
  {
    setSelection(paramInt1, paramInt2);
  }
  
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener) {}
  
  public void setOnEditorClickEventListener(WriteTogetherEditorView.OnEditorClickEventListener paramOnEditorClickEventListener)
  {
    this.n = paramOnEditorClickEventListener;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorView
 * JD-Core Version:    0.7.0.1
 */