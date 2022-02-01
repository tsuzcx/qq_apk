package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.R.styleable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/LimitWordEditText;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "value", "content", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "contentView", "Landroid/widget/EditText;", "getContentView", "()Landroid/widget/EditText;", "setContentView", "(Landroid/widget/EditText;)V", "countChangeListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "count", "", "getCountChangeListener", "()Lkotlin/jvm/functions/Function1;", "setCountChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "countLimit", "getCountLimit", "()I", "setCountLimit", "(I)V", "countView", "Landroid/widget/TextView;", "getCountView", "()Landroid/widget/TextView;", "setCountView", "(Landroid/widget/TextView;)V", "currentWordCount", "getCurrentWordCount", "", "disableManualEnter", "getDisableManualEnter", "()Z", "setDisableManualEnter", "(Z)V", "hint", "getHint", "setHint", "textWatcher", "Landroid/text/TextWatcher;", "title", "getTitle", "setTitle", "titleView", "getTitleView", "setTitleView", "onDetachedFromWindow", "setSelectionEnd", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class LimitWordEditText
  extends LinearLayout
{
  private final String a = "LimitWordEditText";
  private TextWatcher b;
  @NotNull
  private TextView c;
  @NotNull
  private EditText d;
  @NotNull
  private TextView e;
  @Nullable
  private Function1<? super Integer, Unit> f;
  @NotNull
  private String g;
  @NotNull
  private String h;
  private int i;
  @NotNull
  private String j;
  private boolean k;
  
  public LimitWordEditText(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Object localObject = "";
    this.g = "";
    this.h = "";
    this.j = "";
    float f1 = 18.0F;
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.d);
      if (localTypedArray != null)
      {
        if (localTypedArray.getBoolean(R.styleable.h, true)) {
          LayoutInflater.from(paramContext).inflate(R.layout.x, (ViewGroup)this);
        } else {
          LayoutInflater.from(paramContext).inflate(R.layout.w, (ViewGroup)this);
        }
        m = localTypedArray.getInt(R.styleable.f, 12);
        paramContext = localTypedArray.getString(R.styleable.g);
        if (paramContext == null) {
          paramContext = "";
        }
        String str = localTypedArray.getString(R.styleable.i);
        paramAttributeSet = (AttributeSet)localObject;
        if (str != null) {
          paramAttributeSet = str;
        }
        f1 = localTypedArray.getFloat(R.styleable.e, 18.0F);
        localTypedArray.recycle();
        localObject = paramContext;
        paramContext = paramAttributeSet;
        break label189;
      }
    }
    paramContext = "";
    int m = 0;
    label189:
    paramAttributeSet = findViewById(R.id.aH);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "findViewById(R.id.tv_title)");
    this.c = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(R.id.aw);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "findViewById(R.id.tv_content)");
    this.d = ((EditText)paramAttributeSet);
    paramAttributeSet = findViewById(R.id.aE);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "findViewById(R.id.tv_remaining_num)");
    this.e = ((TextView)paramAttributeSet);
    this.b = ((TextWatcher)new LimitWordEditText.1(this));
    this.d.addTextChangedListener(this.b);
    this.d.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(this.i) });
    setCountLimit(m);
    this.e.setText((CharSequence)String.valueOf(this.i));
    setHint((String)localObject);
    setTitle(paramContext);
    if (f1 > 0.0F) {
      this.d.setTextSize(1, f1);
    }
  }
  
  @NotNull
  public final String getContent()
  {
    return this.d.getText().toString();
  }
  
  @NotNull
  public final EditText getContentView()
  {
    return this.d;
  }
  
  @Nullable
  public final Function1<Integer, Unit> getCountChangeListener()
  {
    return this.f;
  }
  
  public final int getCountLimit()
  {
    return this.i;
  }
  
  @NotNull
  public final TextView getCountView()
  {
    return this.e;
  }
  
  public final int getCurrentWordCount()
  {
    return this.d.length();
  }
  
  public final boolean getDisableManualEnter()
  {
    return this.k;
  }
  
  @NotNull
  public final String getHint()
  {
    return this.g;
  }
  
  @NotNull
  public final String getTitle()
  {
    return this.h;
  }
  
  @NotNull
  public final TextView getTitleView()
  {
    return this.c;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.d.removeTextChangedListener(this.b);
  }
  
  public final void setContent(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.j = paramString;
    this.d.setText((CharSequence)paramString);
  }
  
  public final void setContentView(@NotNull EditText paramEditText)
  {
    Intrinsics.checkParameterIsNotNull(paramEditText, "<set-?>");
    this.d = paramEditText;
  }
  
  public final void setCountChangeListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.f = paramFunction1;
  }
  
  public final void setCountLimit(int paramInt)
  {
    if (paramInt > 0)
    {
      this.i = paramInt;
      this.d.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(paramInt) });
      this.e.setText((CharSequence)String.valueOf(paramInt - getContent().length()));
    }
  }
  
  public final void setCountView(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "<set-?>");
    this.e = paramTextView;
  }
  
  public final void setDisableManualEnter(boolean paramBoolean)
  {
    this.k = paramBoolean;
    this.d.setOnEditorActionListener((TextView.OnEditorActionListener)new LimitWordEditText.disableManualEnter.1(paramBoolean));
  }
  
  public final void setHint(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.g = paramString;
    this.d.setHint((CharSequence)paramString);
  }
  
  public final void setSelectionEnd()
  {
    this.d.post((Runnable)new LimitWordEditText.setSelectionEnd.1(this));
  }
  
  public final void setTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.h = paramString;
    paramString = (CharSequence)paramString;
    int m;
    if (paramString.length() == 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0)
    {
      this.c.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
    this.c.setText(paramString);
  }
  
  public final void setTitleView(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "<set-?>");
    this.c = paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.LimitWordEditText
 * JD-Core Version:    0.7.0.1
 */