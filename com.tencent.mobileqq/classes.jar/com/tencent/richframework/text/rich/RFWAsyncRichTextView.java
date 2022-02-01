package com.tencent.richframework.text.rich;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView.BufferType;
import androidx.annotation.RequiresApi;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.text.R.styleable;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig.TextAtConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig.TextHashTagConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig.TextImageSpanConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.event.RichTextPreloadEvent;
import com.tencent.richframework.text.rich.parser.Patterns;
import com.tencent.richframework.text.rich.parser.RFWParseRichTextManager;
import com.tencent.richframework.text.rich.parser.RFWPreloadParseRichTextHelper;
import com.tencent.richframework.text.rich.parser.RichTextHashTagParser;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RFWAsyncRichTextView
  extends RFWSafeTextView
  implements SimpleEventReceiver
{
  private double a;
  public int b = 2131167878;
  protected int c;
  private double d;
  private RFWAsyncRichTextView.OnClickAtTextListener e;
  private RFWAsyncRichTextView.OnClickHashTagTextListener f;
  private boolean g;
  private boolean h;
  private ArrayList<String> i;
  private CharSequence j;
  private double k = 1.0D;
  private boolean l = false;
  private boolean m;
  private RFWAsyncRichTextView.OnTriggerEllipseListener n;
  private boolean o;
  private RichTextPreloadParserInfo p;
  
  public RFWAsyncRichTextView(Context paramContext)
  {
    super(paramContext, null);
    a(paramContext, null);
  }
  
  public RFWAsyncRichTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    try
    {
      a(paramContext, paramAttributeSet);
      return;
    }
    catch (Throwable paramContext)
    {
      label29:
      break label29;
    }
    Log.d("RFWAsyncRichTextView", "RFWAsyncRichTextView: ");
  }
  
  public RFWAsyncRichTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private int a(ImageSpan[] paramArrayOfImageSpan)
  {
    int i1;
    if ((paramArrayOfImageSpan.length > 0) && (paramArrayOfImageSpan[0].getDrawable() != null)) {
      i1 = paramArrayOfImageSpan[0].getDrawable().getIntrinsicWidth();
    } else {
      i1 = 0;
    }
    return 0 + i1;
  }
  
  private Spannable a(CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder;
    if ((paramCharSequence instanceof SpannableStringBuilder)) {
      localSpannableStringBuilder = (SpannableStringBuilder)paramCharSequence;
    } else {
      localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence.toString());
    }
    Object localObject = this.p;
    if ((localObject != null) && (TextUtils.isEmpty(((RichTextPreloadParserInfo)localObject).b())))
    {
      this.p.a(localSpannableStringBuilder);
      this.p.a(null);
    }
    localObject = b(paramCharSequence);
    if (localObject != null) {
      return localObject;
    }
    if (TextUtils.isEmpty(paramCharSequence)) {
      return localSpannableStringBuilder;
    }
    QLog.i("RFWAsyncRichTextView", 1, "parserText  now parser");
    paramCharSequence = this.p;
    if (paramCharSequence != null) {
      paramCharSequence = paramCharSequence.b();
    } else {
      paramCharSequence = "";
    }
    this.p = new RichTextPreloadParserInfo(paramCharSequence, localSpannableStringBuilder);
    paramCharSequence = RFWParseRichTextManager.a(this.p, getDefaultRichTextConfig());
    if (paramCharSequence != null) {
      RFWPreloadParseRichTextHelper.a().a(this.p.c(), paramCharSequence);
    }
    if (paramCharSequence != null) {
      return paramCharSequence;
    }
    return localSpannableStringBuilder;
  }
  
  private SpannableStringBuilder a(int paramInt, Spanned paramSpanned, CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramInt > 0) && (paramCharSequence != null) && (paramCharSequence.toString().length() >= paramInt)) {
      localSpannableStringBuilder.append(paramCharSequence.subSequence(0, paramInt));
    }
    localSpannableStringBuilder.append(paramSpanned);
    return localSpannableStringBuilder;
  }
  
  private CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = getTextSize();
    int i1 = 0;
    int i3 = paramInt3;
    int i2 = paramInt2;
    Object localObject;
    int i4;
    do
    {
      localObject = paramCharSequence;
      if (i3 >= paramInt1) {
        break;
      }
      if (paramCharSequence.toString().endsWith("[/em]"))
      {
        localObject = Patterns.k.matcher(paramCharSequence);
        do
        {
          paramInt2 = i2;
          paramInt3 = i3;
          if (!((Matcher)localObject).find()) {
            break;
          }
          paramInt2 = ((Matcher)localObject).start();
          paramInt3 = ((Matcher)localObject).end();
        } while ((paramInt2 >= i2) || (paramInt3 != i2));
        paramInt3 = (int)(i3 + f1);
      }
      else
      {
        paramInt2 = i2;
        paramInt3 = i3;
        if (i2 > 0)
        {
          paramInt3 = i3 + (int)Math.floor(getPaint().measureText(paramCharSequence.subSequence(i2 - 1, i2).toString()));
          paramInt2 = i2 - 1;
        }
      }
      localObject = paramCharSequence;
      if (paramInt2 >= 0) {
        localObject = paramCharSequence.subSequence(0, paramInt2);
      }
      i4 = i1 + 1;
      i1 = i4;
      paramCharSequence = (CharSequence)localObject;
      i2 = paramInt2;
      i3 = paramInt3;
    } while (i4 <= 1000);
    return localObject;
  }
  
  private CharSequence a(CharSequence paramCharSequence, ImageSpan[] paramArrayOfImageSpan)
  {
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    paramCharSequence.append("...");
    if (paramArrayOfImageSpan.length > 0)
    {
      paramCharSequence.append(" ");
      paramCharSequence.setSpan(paramArrayOfImageSpan[0], paramCharSequence.length() - 1, paramCharSequence.length(), 33);
    }
    return paramCharSequence;
  }
  
  private void a()
  {
    setRichText(this.j);
  }
  
  private void a(int paramInt, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return;
    }
    if (TextUtils.isEmpty(getText())) {
      return;
    }
    if (getMaxLines() < 2) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(getText());
    ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])localSpannableStringBuilder.getSpans(getLayout().getLineStart(getMaxLines() - 2), getText().length(), ClickableSpan.class);
    int i3 = arrayOfClickableSpan.length;
    int i1 = 0;
    while (i1 < i3)
    {
      ClickableSpan localClickableSpan = arrayOfClickableSpan[i1];
      int i4 = localSpannableStringBuilder.getSpanStart(localClickableSpan);
      int i2 = localSpannableStringBuilder.getSpanEnd(localClickableSpan);
      if ((paramInt > i4) && (paramInt < i2))
      {
        paramInt = i2;
        if (i2 > paramSpannableStringBuilder.length()) {
          paramInt = paramSpannableStringBuilder.length();
        }
        paramSpannableStringBuilder.setSpan(localClickableSpan, i4, paramInt, 33);
        return;
      }
      i1 += 1;
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.a);
    try
    {
      this.k = paramContext.getFloat(R.styleable.c, 1.0F);
      if ((this.k <= 0.1D) || (this.k >= 10.0D)) {
        this.k = 1.0D;
      }
      this.c = paramContext.getInt(R.styleable.b, 0);
      paramContext.recycle();
      SimpleEventBus.getInstance().registerReceiver(this);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private Spannable b(CharSequence paramCharSequence)
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((RichTextPreloadParserInfo)localObject).c())) {
        return null;
      }
      localObject = RFWPreloadParseRichTextHelper.a().b(this.p.c());
      if ((localObject != null) && (paramCharSequence != null))
      {
        int i1 = paramCharSequence.toString().indexOf(this.p.a().toString());
        localObject = a(i1, (Spanned)localObject, paramCharSequence);
        if (paramCharSequence.length() > this.p.a().length() + i1) {
          ((SpannableStringBuilder)localObject).append(paramCharSequence.subSequence(i1 + this.p.a().length(), paramCharSequence.length()));
        }
        paramCharSequence = new StringBuilder();
        paramCharSequence.append("parserText  haveCache FromCachePool , cacheKey = ");
        paramCharSequence.append(this.p.c());
        QLog.i("RFWAsyncRichTextView", 1, paramCharSequence.toString());
        return localObject;
      }
    }
    return null;
  }
  
  private CharSequence c(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (this.m)
    {
      paramCharSequence = e(paramCharSequence);
      localObject = new SpannableStringBuilder(getText());
      ImageSpan[] arrayOfImageSpan = (ImageSpan[])((SpannableStringBuilder)localObject).getSpans(((SpannableStringBuilder)localObject).length() - 1, ((SpannableStringBuilder)localObject).length(), ImageSpan.class);
      int i1 = a(arrayOfImageSpan);
      localObject = paramCharSequence;
      if (i1 > 0)
      {
        paramCharSequence = d(paramCharSequence);
        i1 += (int)(this.d - this.a) + ViewUtils.a(5.0F);
        int i2 = paramCharSequence.length();
        double d1 = Math.ceil(getPaint().measureText(paramCharSequence.toString()));
        double d2 = getWidth() - getPaddingLeft() - getPaddingRight();
        Double.isNaN(d2);
        int i3 = (int)(d2 - d1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("nowFreeWidth = ");
        ((StringBuilder)localObject).append(i3);
        ((StringBuilder)localObject).append(" , needCutWidth = ");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(" , nowStringLength = ");
        ((StringBuilder)localObject).append(d1);
        ((StringBuilder)localObject).append(" , lastLine = ");
        ((StringBuilder)localObject).append(paramCharSequence);
        QLog.i("RFWAsyncRichTextView", 1, ((StringBuilder)localObject).toString());
        localObject = a(a(paramCharSequence, i1, i2, i3), arrayOfImageSpan);
      }
    }
    return localObject;
  }
  
  private void c(String paramString)
  {
    setIsSpanClick(true);
    RFWAsyncRichTextView.OnClickAtTextListener localOnClickAtTextListener = this.e;
    if (localOnClickAtTextListener != null) {
      localOnClickAtTextListener.onClick(paramString);
    }
  }
  
  private CharSequence d(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return "";
    }
    Object localObject = paramCharSequence;
    if (paramCharSequence.toString().endsWith("…")) {
      if (paramCharSequence.length() > 0) {
        localObject = paramCharSequence.subSequence(0, paramCharSequence.length() - 1);
      } else {
        localObject = "";
      }
    }
    double d2 = this.d;
    double d1 = d2;
    if (d2 == 0.0D) {
      d1 = Math.ceil(getPaint().measureText("..."));
    }
    this.d = d1;
    d2 = this.a;
    d1 = d2;
    if (d2 == 0.0D) {
      d1 = Math.ceil(getPaint().measureText("…"));
    }
    this.a = d1;
    return localObject;
  }
  
  private void d(String paramString)
  {
    setIsSpanClick(true);
    RFWAsyncRichTextView.OnClickHashTagTextListener localOnClickHashTagTextListener = this.f;
    if (localOnClickHashTagTextListener != null) {
      localOnClickHashTagTextListener.onClick(paramString);
    }
  }
  
  private CharSequence e(CharSequence paramCharSequence)
  {
    String str = paramCharSequence.toString();
    Object localObject = paramCharSequence;
    if (!TextUtils.isEmpty(str))
    {
      localObject = paramCharSequence;
      if (str.contains("\n")) {
        localObject = str.substring(0, str.indexOf("\n"));
      }
    }
    return localObject;
  }
  
  private RichTextPreloadConfig getDefaultRichTextConfig()
  {
    RichTextPreloadConfig.TextImageSpanConfig localTextImageSpanConfig = new RichTextPreloadConfig.TextImageSpanConfig();
    double d1 = getTextSize();
    double d2 = this.k;
    Double.isNaN(d1);
    localTextImageSpanConfig = localTextImageSpanConfig.a((int)(d1 * d2)).a(this.c);
    RichTextPreloadConfig.TextAtConfig localTextAtConfig = new RichTextPreloadConfig.TextAtConfig().a(this.b).a(this.g);
    RichTextPreloadConfig.TextHashTagConfig localTextHashTagConfig = new RichTextPreloadConfig.TextHashTagConfig().a(this.b).a(this.g);
    return new RichTextPreloadConfig().a(localTextImageSpanConfig).a(localTextAtConfig).a(localTextHashTagConfig);
  }
  
  private void setRichText(CharSequence paramCharSequence)
  {
    this.j = paramCharSequence;
    setMovementMethod(getDefaultMovementMethod());
    super.setText(a(paramCharSequence), null);
    this.i = null;
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  protected boolean b()
  {
    return this.h;
  }
  
  @RequiresApi(api=16)
  protected void c()
  {
    if (Build.VERSION.SDK_INT < 16) {
      return;
    }
    this.o = false;
    if ((getEllipsize() == TextUtils.TruncateAt.END) && (getLayout() != null) && (getLineCount() > getMaxLines()) && (getMaxLines() > 0))
    {
      int i1 = getLayout().getLineStart(getMaxLines() - 1);
      Object localObject = a(i1, new SpannedString(c(TextUtils.ellipsize(getText().subSequence(i1, getText().length()), getPaint(), getWidth() - getPaddingLeft() - getPaddingRight(), TextUtils.TruncateAt.END))), getText());
      a(i1, (SpannableStringBuilder)localObject);
      super.setText(new QQText((CharSequence)localObject, 3, 16), null);
      localObject = this.n;
      if (localObject != null) {
        ((RFWAsyncRichTextView.OnTriggerEllipseListener)localObject).a();
      }
      this.o = true;
    }
  }
  
  protected MovementMethod getDefaultMovementMethod()
  {
    return LinkMovementMethod.getInstance();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(RichTextPreloadEvent.class);
    return localArrayList;
  }
  
  public List<String> getHashTagList()
  {
    Object localObject = this.i;
    if (localObject != null) {
      return localObject;
    }
    localObject = RFWParseRichTextManager.a();
    if (localObject == null) {
      return new ArrayList();
    }
    this.i = ((RichTextHashTagParser)localObject).a(new SpannableStringBuilder(this.j), new RichTextPreloadConfig.TextHashTagConfig(), null);
    return this.i;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    CharSequence localCharSequence = getText();
    if ((localCharSequence instanceof SpannableStringBuilder)) {
      ((SpannableStringBuilder)localCharSequence).clearSpans();
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  @RequiresApi(api=16)
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.l) && (Build.VERSION.SDK_INT > 16))
    {
      c();
      this.l = false;
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof RichTextPreloadEvent))
    {
      paramSimpleBaseEvent = (RichTextPreloadEvent)paramSimpleBaseEvent;
      RichTextPreloadParserInfo localRichTextPreloadParserInfo = this.p;
      if ((localRichTextPreloadParserInfo != null) && (TextUtils.equals(localRichTextPreloadParserInfo.c(), paramSimpleBaseEvent.cacheKey)))
      {
        int i1 = paramSimpleBaseEvent.eventType;
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3) {
              return;
            }
            d(paramSimpleBaseEvent.tagName);
            return;
          }
          c(paramSimpleBaseEvent.uin);
          return;
        }
        RFThreadManager.getUIHandler().post(new RFWAsyncRichTextView.1(this));
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    setFocusable(false);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  protected void setIsSpanClick(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setNeedSpecialAreaBold(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setOnClickAtTextListener(RFWAsyncRichTextView.OnClickAtTextListener paramOnClickAtTextListener)
  {
    this.e = paramOnClickAtTextListener;
  }
  
  public void setOnClickHashTagTextListener(RFWAsyncRichTextView.OnClickHashTagTextListener paramOnClickHashTagTextListener)
  {
    this.f = paramOnClickHashTagTextListener;
  }
  
  public void setOnTriggerEllipseListener(RFWAsyncRichTextView.OnTriggerEllipseListener paramOnTriggerEllipseListener)
  {
    this.n = paramOnTriggerEllipseListener;
  }
  
  public void setPreloadText(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      this.p = new RichTextPreloadParserInfo(paramString1, new SpannedString(paramString2));
      return;
    }
    this.p = null;
  }
  
  public void setSpecialClickAreaColor(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    this.l = true;
    setRichText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.RFWAsyncRichTextView
 * JD-Core Version:    0.7.0.1
 */