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
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
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
    LayoutInflater.from(paramContext).inflate(R.layout.A, (ViewGroup)this);
    paramContext = findViewById(R.id.bN);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_tips)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = findViewById(R.id.bR);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_topic)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = findViewById(R.id.bx);
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
    int m = (int)((TextPaint)localObject).measureText(localContext.getResources().getString(R.string.X));
    localObject = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return ((DisplayUtils)localObject).a(localContext) - i * 2 - j - (k + m);
  }
  
  private final void a()
  {
    int j = 0;
    Object localObject1 = (CharSequence)this.d;
    int i;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label170;
      }
      if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
        break label103;
      }
      i = 1;
      label45:
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (i == 0) {
        break label108;
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setVisibility(j);
      if (i != 0)
      {
        if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
          break label114;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)getResources().getString(R.string.e));
      }
      return;
      i = 0;
      break;
      label103:
      i = 0;
      break label45;
      label108:
      j = 8;
    }
    label114:
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)getResources().getString(R.string.c));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)getResources().getString(R.string.d));
    return;
    label170:
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    localObject1 = getResources().getString(R.string.at);
    Object localObject2 = getResources().getString(R.string.au);
    localObject2 = new SpannableString((CharSequence)((String)localObject1 + (String)localObject2));
    ((SpannableString)localObject2).setSpan(new AssociateModuleLayout.refreshTipsView.clickableSpan.1(this), ((String)localObject1).length(), ((SpannableString)localObject2).length(), 33);
    this.jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
  }
  
  private final void b()
  {
    int j = 0;
    Object localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      i = j;
      if (((CharSequence)this.jdField_a_of_type_JavaLangString).length() == 0) {
        i = 1;
      }
      if (i == 0) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)getResources().getString(R.string.X));
      return;
    }
    localObject = getResources().getString(R.string.ap);
    SpannableString localSpannableString = new SpannableString((CharSequence)((String)localObject + ' ' + this.jdField_a_of_type_JavaLangString));
    localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.c)), ((String)localObject).length(), localSpannableString.length(), 33);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localSpannableString);
  }
  
  private final void c()
  {
    int j = 0;
    Object localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    if (this.jdField_b_of_type_Boolean) {}
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      i = j;
      if (((CharSequence)this.jdField_b_of_type_JavaLangString).length() == 0) {
        i = 1;
      }
      if (i == 0) {
        break;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)getResources().getString(R.string.V));
      return;
    }
    localObject = getResources().getString(R.string.l);
    SpannableString localSpannableString = new SpannableString((CharSequence)((String)localObject + ' ' + this.jdField_b_of_type_JavaLangString));
    localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.c)), ((String)localObject).length(), localSpannableString.length(), 33);
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localSpannableString);
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @NotNull
  public final TextView a()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public final void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "config");
    if ((paramGlobalPublisherConfig.getShowTopicSelector()) || (paramGlobalPublisherConfig.getShowCommunitySelector()))
    {
      setVisibility(0);
      if (paramGlobalPublisherConfig.getTopicInfo() != null)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
        setShouldShowCommunity(false);
      }
      while (paramGlobalPublisherConfig.getCommunityInfo() != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(false);
        setShouldShowTopic(false);
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
        setShouldShowCommunity(paramGlobalPublisherConfig.getShowCommunitySelector());
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(true);
      setShouldShowTopic(paramGlobalPublisherConfig.getShowTopicSelector());
      return;
    }
    setVisibility(8);
  }
  
  @NotNull
  public final TextView b()
  {
    return this.jdField_c_of_type_AndroidWidgetTextView;
  }
  
  @Nullable
  public final String b()
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
    if (((CharSequence)paramString).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        setTopicName("");
        this.jdField_a_of_type_Long = 0L;
      }
      c();
      return;
    }
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
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      if (!paramBoolean) {
        setCommunityName("");
      }
      a();
      return;
    }
  }
  
  public final void setShouldShowTopic(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      if (!paramBoolean) {
        setTopicName("");
      }
      a();
      return;
    }
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
    if (((CharSequence)paramString).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        setCommunityName("");
        this.jdField_c_of_type_JavaLangString = "";
      }
      b();
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.AssociateModuleLayout
 * JD-Core Version:    0.7.0.1
 */