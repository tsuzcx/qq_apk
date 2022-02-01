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
  public static final AssociateModuleLayout.Companion a = new AssociateModuleLayout.Companion(null);
  @NotNull
  private TextView b;
  @NotNull
  private TextView c;
  @NotNull
  private TextView d;
  @NotNull
  private String e = "";
  private long f;
  @NotNull
  private String g = "";
  @NotNull
  private String h = "";
  private boolean i;
  private boolean j;
  @Nullable
  private String k;
  
  public AssociateModuleLayout(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.u, (ViewGroup)this);
    paramContext = findViewById(R.id.aG);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_tips)");
    this.b = ((TextView)paramContext);
    paramContext = findViewById(R.id.aJ);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_topic)");
    this.c = ((TextView)paramContext);
    paramContext = findViewById(R.id.at);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_community)");
    this.d = ((TextView)paramContext);
    if (!isInEditMode())
    {
      a();
      b();
      c();
      this.c.setMaxWidth(getItemMaxWidth());
      this.d.setMaxWidth(getItemMaxWidth());
    }
  }
  
  private final void a()
  {
    Object localObject1 = (CharSequence)this.k;
    int i1 = 1;
    int n = 0;
    int m;
    if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
      m = 0;
    } else {
      m = 1;
    }
    if (m != 0)
    {
      m = i1;
      if (!this.i) {
        if (this.j) {
          m = i1;
        } else {
          m = 0;
        }
      }
      localObject1 = this.b;
      if (m == 0) {
        n = 8;
      }
      ((TextView)localObject1).setVisibility(n);
      if (m != 0)
      {
        if ((this.i) && (!this.j))
        {
          this.b.setText((CharSequence)getResources().getString(R.string.d));
          return;
        }
        if ((!this.i) && (this.j))
        {
          this.b.setText((CharSequence)getResources().getString(R.string.b));
          return;
        }
        this.b.setText((CharSequence)getResources().getString(R.string.c));
      }
    }
    else
    {
      this.b.setVisibility(0);
      localObject1 = getResources().getString(R.string.V);
      Object localObject2 = getResources().getString(R.string.W);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append((String)localObject2);
      localObject2 = new SpannableString((CharSequence)localStringBuilder.toString());
      ((SpannableString)localObject2).setSpan(new AssociateModuleLayout.refreshTipsView.clickableSpan.1(this), ((String)localObject1).length(), ((SpannableString)localObject2).length(), 33);
      this.b.setHighlightColor(0);
      this.b.setMovementMethod(LinkMovementMethod.getInstance());
      this.b.setText((CharSequence)localObject2);
    }
  }
  
  private final void b()
  {
    Object localObject1 = this.c;
    boolean bool = this.i;
    int n = 0;
    if (bool) {
      m = 0;
    } else {
      m = 8;
    }
    ((TextView)localObject1).setVisibility(m);
    int m = n;
    if (((CharSequence)this.e).length() == 0) {
      m = 1;
    }
    if (m != 0)
    {
      this.c.setText((CharSequence)getResources().getString(R.string.J));
      return;
    }
    localObject1 = getResources().getString(R.string.U);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(' ');
    ((StringBuilder)localObject2).append(this.e);
    localObject2 = new SpannableString((CharSequence)((StringBuilder)localObject2).toString());
    ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(getResources().getColor(R.color.c)), ((String)localObject1).length(), ((SpannableString)localObject2).length(), 33);
    this.c.setText((CharSequence)localObject2);
  }
  
  private final void c()
  {
    Object localObject1 = this.d;
    boolean bool = this.j;
    int n = 0;
    if (bool) {
      m = 0;
    } else {
      m = 8;
    }
    ((TextView)localObject1).setVisibility(m);
    int m = n;
    if (((CharSequence)this.g).length() == 0) {
      m = 1;
    }
    if (m != 0)
    {
      this.d.setText((CharSequence)getResources().getString(R.string.H));
      return;
    }
    localObject1 = getResources().getString(R.string.j);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(' ');
    ((StringBuilder)localObject2).append(this.g);
    localObject2 = new SpannableString((CharSequence)((StringBuilder)localObject2).toString());
    ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(getResources().getColor(R.color.c)), ((String)localObject1).length(), ((SpannableString)localObject2).length(), 33);
    this.d.setText((CharSequence)localObject2);
  }
  
  private final int getItemMaxWidth()
  {
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    int m = (int)((Context)localObject).getResources().getDimension(R.dimen.a);
    localObject = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int n = ((DisplayUtils)localObject).a(localContext, 16.0F);
    localObject = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i1 = ((DisplayUtils)localObject).a(localContext, 38.0F);
    localObject = this.c.getPaint();
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i2 = (int)((TextPaint)localObject).measureText(localContext.getResources().getString(R.string.J));
    localObject = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return ((DisplayUtils)localObject).a(localContext) - m * 2 - n - (i1 + i2);
  }
  
  @NotNull
  public final String getCommunityId()
  {
    return this.h;
  }
  
  @NotNull
  public final String getCommunityName()
  {
    return this.g;
  }
  
  @NotNull
  public final TextView getCommunityView()
  {
    return this.d;
  }
  
  public final boolean getShouldShowCommunity()
  {
    return this.j;
  }
  
  public final boolean getShouldShowTopic()
  {
    return this.i;
  }
  
  @NotNull
  public final TextView getTipsView()
  {
    return this.b;
  }
  
  public final long getTopicId()
  {
    return this.f;
  }
  
  @NotNull
  public final String getTopicName()
  {
    return this.e;
  }
  
  @NotNull
  public final TextView getTopicView()
  {
    return this.c;
  }
  
  @Nullable
  public final String getUserProtocolUrl()
  {
    return this.k;
  }
  
  public final void setCommunityId(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.h = paramString;
  }
  
  public final void setCommunityName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.g = paramString;
    int m;
    if (((CharSequence)paramString).length() > 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0)
    {
      setTopicName("");
      this.f = 0L;
    }
    c();
  }
  
  public final void setCommunityView(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "<set-?>");
    this.d = paramTextView;
  }
  
  public final void setShouldShowCommunity(boolean paramBoolean)
  {
    this.j = paramBoolean;
    TextView localTextView = this.d;
    int m;
    if (paramBoolean) {
      m = 0;
    } else {
      m = 8;
    }
    localTextView.setVisibility(m);
    if (!paramBoolean) {
      setCommunityName("");
    }
    a();
  }
  
  public final void setShouldShowTopic(boolean paramBoolean)
  {
    this.i = paramBoolean;
    TextView localTextView = this.c;
    int m;
    if (paramBoolean) {
      m = 0;
    } else {
      m = 8;
    }
    localTextView.setVisibility(m);
    if (!paramBoolean) {
      setTopicName("");
    }
    a();
  }
  
  public final void setTipsView(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "<set-?>");
    this.b = paramTextView;
  }
  
  public final void setTopicId(long paramLong)
  {
    this.f = paramLong;
  }
  
  public final void setTopicName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.e = paramString;
    int m;
    if (((CharSequence)paramString).length() > 0) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0)
    {
      setCommunityName("");
      this.h = "";
    }
    b();
  }
  
  public final void setTopicView(@NotNull TextView paramTextView)
  {
    Intrinsics.checkParameterIsNotNull(paramTextView, "<set-?>");
    this.c = paramTextView;
  }
  
  public final void setUserProtocolUrl(@Nullable String paramString)
  {
    this.k = paramString;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.AssociateModuleLayout
 * JD-Core Version:    0.7.0.1
 */