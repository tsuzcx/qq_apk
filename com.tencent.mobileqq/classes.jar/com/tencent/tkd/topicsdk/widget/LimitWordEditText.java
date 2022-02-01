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
  private int jdField_a_of_type_Int;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher;
  @NotNull
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  @NotNull
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final String jdField_a_of_type_JavaLangString = "LimitWordEditText";
  @Nullable
  private Function1<? super Integer, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private boolean jdField_a_of_type_Boolean;
  @NotNull
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  @NotNull
  private String jdField_b_of_type_JavaLangString;
  @NotNull
  private String c;
  @NotNull
  private String d;
  
  public LimitWordEditText(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Object localObject = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.c = "";
    this.d = "";
    float f = 18.0F;
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.jdField_c_of_type_ArrayOfInt);
      if (localTypedArray != null)
      {
        if (localTypedArray.getBoolean(R.styleable.e, true)) {
          LayoutInflater.from(paramContext).inflate(R.layout.B, (ViewGroup)this);
        } else {
          LayoutInflater.from(paramContext).inflate(R.layout.A, (ViewGroup)this);
        }
        i = localTypedArray.getInt(R.styleable.jdField_c_of_type_Int, 12);
        paramContext = localTypedArray.getString(R.styleable.d);
        if (paramContext == null) {
          paramContext = "";
        }
        String str = localTypedArray.getString(R.styleable.f);
        paramAttributeSet = (AttributeSet)localObject;
        if (str != null) {
          paramAttributeSet = str;
        }
        f = localTypedArray.getFloat(R.styleable.b, 18.0F);
        localTypedArray.recycle();
        localObject = paramContext;
        paramContext = paramAttributeSet;
        break label189;
      }
    }
    paramContext = "";
    int i = 0;
    label189:
    paramAttributeSet = findViewById(R.id.bi);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "findViewById(R.id.tv_title)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(R.id.aV);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "findViewById(R.id.tv_content)");
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramAttributeSet);
    paramAttributeSet = findViewById(R.id.be);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "findViewById(R.id.tv_remaining_num)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramAttributeSet);
    this.jdField_a_of_type_AndroidTextTextWatcher = ((TextWatcher)new LimitWordEditText.1(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(this.jdField_a_of_type_Int) });
    setCountLimit(i);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)String.valueOf(this.jdField_a_of_type_Int));
    setHint((String)localObject);
    setTitle(paramContext);
    if (f > 0.0F) {
      this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(1, f);
    }
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final EditText a()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText;
  }
  
  @NotNull
  public final TextView a()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
  }
  
  @Nullable
  public final Function1<Integer, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public final int b()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText.length();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  public final void setContent(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.d = paramString;
    this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)paramString);
  }
  
  public final void setContentView(@NotNull EditText paramEditText)
  {
    Intrinsics.checkParameterIsNotNull(paramEditText, "<set-?>");
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  public final void setCountChangeListener(@Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
  
  public final void setCountLimit(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(paramInt) });
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)String.valueOf(paramInt - a().length()));
    }
  }
  
  public final void setCountView(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "<set-?>");
    this.jdField_b_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public final void setDisableManualEnter(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener((TextView.OnEditorActionListener)new LimitWordEditText.disableManualEnter.1(paramBoolean));
  }
  
  public final void setHint(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidWidgetEditText.setHint((CharSequence)paramString);
  }
  
  public final void setSelectionEnd()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.post((Runnable)new LimitWordEditText.setSelectionEnd.1(this));
  }
  
  public final void setTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.c = paramString;
    paramString = (CharSequence)paramString;
    int i;
    if (paramString.length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public final void setTitleView(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "<set-?>");
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.LimitWordEditText
 * JD-Core Version:    0.7.0.1
 */