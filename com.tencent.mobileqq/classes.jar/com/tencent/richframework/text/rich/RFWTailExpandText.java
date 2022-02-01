package com.tencent.richframework.text.rich;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.text.DynamicLayout;
import android.text.DynamicLayout.Builder;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.biz.richframework.text.R.styleable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;

public class RFWTailExpandText
  extends AppCompatTextView
{
  private static final String a = HardCodeUtil.a(2131915709);
  private static final String b = HardCodeUtil.a(2131915710);
  private static final int c = 2131167879;
  private int d;
  private String e = "...";
  private String f = b;
  private String g = a;
  private int h;
  private boolean i;
  private int j;
  private int k;
  private boolean l;
  private RFWTailExpandText.OnExpandCallback m;
  private int n;
  private boolean o;
  private CharSequence p;
  private CharSequence q;
  private int r;
  private int s;
  private boolean t;
  
  public RFWTailExpandText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RFWTailExpandText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RFWTailExpandText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  @RequiresApi(api=16)
  private DynamicLayout a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      paramSpannableStringBuilder = DynamicLayout.Builder.obtain(paramSpannableStringBuilder, getPaint(), this.h);
      paramSpannableStringBuilder.setAlignment(Layout.Alignment.ALIGN_NORMAL).setBreakStrategy(getBreakStrategy()).setUseLineSpacingFromFallbacks(true).setHyphenationFrequency(getHyphenationFrequency()).setIncludePad(true).setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier());
      return paramSpannableStringBuilder.build();
    }
    return new DynamicLayout(paramSpannableStringBuilder, getPaint(), this.h, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), true);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.i = false;
    this.l = false;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.d);
      setLimitLine(paramAttributeSet.getInt(R.styleable.l, 7));
      int i2 = ImmersiveUtils.dpToPx(paramAttributeSet.getDimension(R.styleable.o, 0.0F));
      int i1 = i2;
      if (i2 == 0) {
        i1 = ImmersiveUtils.getScreenWidth();
      }
      a(i1);
      if (paramAttributeSet.getString(R.styleable.g) == null) {
        paramContext = b;
      } else {
        paramContext = paramAttributeSet.getString(R.styleable.g);
      }
      setCloseEndText(paramContext);
      if (paramAttributeSet.getString(R.styleable.m) == null) {
        paramContext = a;
      } else {
        paramContext = paramAttributeSet.getString(R.styleable.m);
      }
      setOpenEndText(paramContext);
      if (paramAttributeSet.getString(R.styleable.j) == null) {
        paramContext = "...";
      } else {
        paramContext = paramAttributeSet.getString(R.styleable.j);
      }
      setEllipseText(paramContext);
      setOpen(paramAttributeSet.getBoolean(R.styleable.i, false));
      setAnimDuring(paramAttributeSet.getInt(R.styleable.f, 400));
      setAllowAnim(paramAttributeSet.getBoolean(R.styleable.e, true));
      setOpenTextColor(paramAttributeSet.getResourceId(R.styleable.n, c));
      setCloseTextColor(paramAttributeSet.getResourceId(R.styleable.h, c));
      setEndTextBold(paramAttributeSet.getBoolean(R.styleable.k, true));
      paramAttributeSet.recycle();
    }
  }
  
  @RequiresApi(api=16)
  private void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    Object localObject = this.p;
    if ((localObject == null) || (!localObject.equals(paramCharSequence)))
    {
      this.p = paramCharSequence;
      this.j = 0;
      this.k = 0;
    }
    localObject = a(new SpannableStringBuilder(paramCharSequence));
    int i1 = ((DynamicLayout)localObject).getLineCount();
    int i2 = this.d;
    if (i1 <= i2)
    {
      setText(paramCharSequence);
      setHeight(((DynamicLayout)localObject).getHeight() + getPaddingTop() + getPaddingBottom());
      return;
    }
    if (!this.i)
    {
      if (this.j == 0)
      {
        i1 = ((DynamicLayout)localObject).getLineEnd(i2);
        this.q = paramCharSequence.toString().substring(0, i1);
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.q).append(this.e).append(getEndSpannable());
        localObject = a(localSpannableStringBuilder);
        getLayout();
        while (((DynamicLayout)localObject).getLineCount() > this.d)
        {
          i1 -= 1;
          this.q = paramCharSequence.toString().substring(0, i1);
          localSpannableStringBuilder.clear();
          localSpannableStringBuilder.append(this.q).append(this.e).append(getEndSpannable());
          localObject = a(localSpannableStringBuilder);
        }
        this.j = (((DynamicLayout)localObject).getHeight() + getPaddingTop() + getPaddingBottom());
      }
      paramCharSequence = new SpannableStringBuilder(this.q).append(this.e).append(getEndSpannable());
      if ((this.o) && (paramBoolean))
      {
        c(paramCharSequence);
        return;
      }
      setText(paramCharSequence);
      setHeight(this.j);
      return;
    }
    paramCharSequence = new SpannableStringBuilder(paramCharSequence).append("\n").append(getEndSpannable());
    if (this.k == 0) {
      this.k = (a(paramCharSequence).getHeight() + getPaddingTop() + getPaddingBottom());
    }
    if ((this.o) && (paramBoolean))
    {
      b(paramCharSequence);
      return;
    }
    setText(paramCharSequence);
    setHeight(this.k);
  }
  
  @RequiresApi(api=16)
  private void a(boolean paramBoolean)
  {
    if ((this.o) && (this.l)) {
      return;
    }
    this.l = true;
    setOpen(paramBoolean);
    RFWTailExpandText.OnExpandCallback localOnExpandCallback = this.m;
    if (localOnExpandCallback != null) {
      localOnExpandCallback.a(paramBoolean);
    }
    a(this.p, this.o);
  }
  
  private void b(SpannableStringBuilder paramSpannableStringBuilder)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.j, this.k });
    localValueAnimator.setDuration(this.n);
    localValueAnimator.addUpdateListener(new RFWTailExpandText.2(this));
    localValueAnimator.addListener(new RFWTailExpandText.3(this, paramSpannableStringBuilder));
    localValueAnimator.start();
  }
  
  private void c(SpannableStringBuilder paramSpannableStringBuilder)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.k, this.j });
    localValueAnimator.setDuration(this.n);
    localValueAnimator.addUpdateListener(new RFWTailExpandText.4(this));
    localValueAnimator.addListener(new RFWTailExpandText.5(this, paramSpannableStringBuilder));
    localValueAnimator.start();
  }
  
  private SpannableString getEndSpannable()
  {
    if (this.i) {
      localObject = this.g;
    } else {
      localObject = this.f;
    }
    Object localObject = new SpannableString((CharSequence)localObject);
    int i1;
    if (this.i) {
      i1 = this.s;
    } else {
      i1 = this.r;
    }
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(i1);
    setHighlightColor(0);
    ((SpannableString)localObject).setSpan(new RFWTailExpandText.1(this), 0, ((SpannableString)localObject).length(), 17);
    setMovementMethod(LinkMovementMethod.getInstance());
    ((SpannableString)localObject).setSpan(localForegroundColorSpan, 0, ((SpannableString)localObject).length(), 17);
    return localObject;
  }
  
  public void a(int paramInt)
  {
    this.h = (paramInt - getPaddingLeft() - getPaddingRight());
  }
  
  public void scrollTo(int paramInt1, int paramInt2) {}
  
  public void setAllowAnim(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setAnimDuring(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setCloseEndText(String paramString)
  {
    this.f = paramString;
  }
  
  public void setCloseTextColor(int paramInt)
  {
    this.r = paramInt;
  }
  
  @RequiresApi(api=16)
  public void setContent(String paramString)
  {
    a(paramString, false);
  }
  
  public void setEllipseText(String paramString)
  {
    this.e = paramString;
  }
  
  public void setEndTextBold(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void setLimitLine(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setOnExpandCallback(RFWTailExpandText.OnExpandCallback paramOnExpandCallback)
  {
    this.m = paramOnExpandCallback;
  }
  
  public void setOpen(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setOpenEndText(String paramString)
  {
    this.g = paramString;
  }
  
  public void setOpenTextColor(int paramInt)
  {
    this.s = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.RFWTailExpandText
 * JD-Core Version:    0.7.0.1
 */