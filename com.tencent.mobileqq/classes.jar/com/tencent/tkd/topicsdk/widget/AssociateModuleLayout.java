package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.tkd.R.color;
import com.tencent.tkd.R.dimen;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/AssociateModuleLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "communityId", "", "getCommunityId", "()Ljava/lang/String;", "setCommunityId", "(Ljava/lang/String;)V", "value", "communityName", "getCommunityName", "setCommunityName", "communityView", "Landroid/widget/TextView;", "getCommunityView", "()Landroid/widget/TextView;", "setCommunityView", "(Landroid/widget/TextView;)V", "", "shouldShowCommunity", "getShouldShowCommunity", "()Z", "setShouldShowCommunity", "(Z)V", "shouldShowTopic", "getShouldShowTopic", "setShouldShowTopic", "tipsView", "getTipsView", "setTipsView", "topicId", "", "getTopicId", "()J", "setTopicId", "(J)V", "topicName", "getTopicName", "setTopicName", "topicView", "getTopicView", "setTopicView", "userProtocolUrl", "getUserProtocolUrl", "setUserProtocolUrl", "getItemMaxWidth", "", "initFromConfig", "", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "refreshCommunityView", "refreshTipsView", "refreshTopicView", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class AssociateModuleLayout
  extends LinearLayout
{
  public static final AssociateModuleLayout.Companion a;
  private long jdField_a_of_type_Long;
  @NotNull
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @NotNull
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  @NotNull
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  @NotNull
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  @NotNull
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  @NotNull
  private String jdField_c_of_type_JavaLangString = "";
  @Nullable
  private String d;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkWidgetAssociateModuleLayout$Companion = new AssociateModuleLayout.Companion(null);
  }
  
  public AssociateModuleLayout(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.z, (ViewGroup)this);
    paramContext = findViewById(R.id.bh);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_tips)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = findViewById(R.id.bl);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_topic)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = findViewById(R.id.aS);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_community)");
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    if (!isInEditMode())
    {
      a();
      b();
      c();
      this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(a());
      this.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth(a());
    }
  }
  
  private final int a()
  {
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    int i = (int)((Context)localObject).getResources().getDimension(R.dimen.a);
    localObject = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int j = ((DisplayUtils)localObject).a(localContext, 16.0F);
    localObject = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int k = ((DisplayUtils)localObject).a(localContext, 38.0F);
    localObject = this.jdField_b_of_type_AndroidWidgetTextView.getPaint();
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int m = (int)((TextPaint)localObject).measureText(localContext.getResources().getString(R.string.T));
    localObject = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return ((DisplayUtils)localObject).a(localContext) - i * 2 - j - (k + m);
  }
  
  private final void a()
  {
    Object localObject1 = (CharSequence)this.d;
    int k = 1;
    int j = 0;
    int i;
    if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      i = k;
      if (!this.jdField_a_of_type_Boolean) {
        if (this.jdField_b_of_type_Boolean) {
          i = k;
        } else {
          i = 0;
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (i == 0) {
        j = 8;
      }
      ((TextView)localObject1).setVisibility(j);
      if (i != 0)
      {
        if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)getResources().getString(R.string.d));
          return;
        }
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)getResources().getString(R.string.b));
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)getResources().getString(R.string.c));
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = getResources().getString(R.string.aj);
      Object localObject2 = getResources().getString(R.string.ak);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append((String)localObject2);
      localObject2 = new SpannableString((CharSequence)localStringBuilder.toString());
      ((SpannableString)localObject2).setSpan(new AssociateModuleLayout.refreshTipsView.clickableSpan.1(this), ((String)localObject1).length(), ((SpannableString)localObject2).length(), 33);
      this.jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    }
  }
  
  private final void b()
  {
    Object localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
    boolean bool = this.jdField_a_of_type_Boolean;
    int j = 0;
    if (bool) {
      i = 0;
    } else {
      i = 8;
    }
    ((TextView)localObject1).setVisibility(i);
    int i = j;
    if (((CharSequence)this.jdField_a_of_type_JavaLangString).length() == 0) {
      i = 1;
    }
    if (i != 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)getResources().getString(R.string.T));
      return;
    }
    localObject1 = getResources().getString(R.string.ag);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(' ');
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    localObject2 = new SpannableString((CharSequence)((StringBuilder)localObject2).toString());
    ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(getResources().getColor(R.color.c)), ((String)localObject1).length(), ((SpannableString)localObject2).length(), 33);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
  }
  
  private final void c()
  {
    Object localObject1 = this.jdField_c_of_type_AndroidWidgetTextView;
    boolean bool = this.jdField_b_of_type_Boolean;
    int j = 0;
    if (bool) {
      i = 0;
    } else {
      i = 8;
    }
    ((TextView)localObject1).setVisibility(i);
    int i = j;
    if (((CharSequence)this.jdField_b_of_type_JavaLangString).length() == 0) {
      i = 1;
    }
    if (i != 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)getResources().getString(R.string.R));
      return;
    }
    localObject1 = getResources().getString(R.string.j);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(' ');
    ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
    localObject2 = new SpannableString((CharSequence)((StringBuilder)localObject2).toString());
    ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(getResources().getColor(R.color.c)), ((String)localObject1).length(), ((SpannableString)localObject2).length(), 33);
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
  }
  
  @Nullable
  public final String a()
  {
    return this.d;
  }
  
  public final void setCommunityId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public final void setCommunityName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.jdField_b_of_type_JavaLangString = paramString;
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      setTopicName("");
      this.jdField_a_of_type_Long = 0L;
    }
    c();
  }
  
  public final void setCommunityView(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "<set-?>");
    this.jdField_c_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public final void setShouldShowCommunity(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
    if (!paramBoolean) {
      setCommunityName("");
    }
    a();
  }
  
  public final void setShouldShowTopic(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
    if (!paramBoolean) {
      setTopicName("");
    }
    a();
  }
  
  public final void setTipsView(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "<set-?>");
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public final void setTopicId(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public final void setTopicName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.jdField_a_of_type_JavaLangString = paramString;
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      setCommunityName("");
      this.jdField_c_of_type_JavaLangString = "";
    }
    b();
  }
  
  public final void setTopicView(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "<set-?>");
    this.jdField_b_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public final void setUserProtocolUrl(@Nullable String paramString)
  {
    this.d = paramString;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.AssociateModuleLayout
 * JD-Core Version:    0.7.0.1
 */