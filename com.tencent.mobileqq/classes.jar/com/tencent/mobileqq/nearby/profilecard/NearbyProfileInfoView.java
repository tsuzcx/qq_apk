package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileInfoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "content", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "contentTv", "Landroid/widget/TextView;", "title", "getTitle", "setTitle", "titleTv", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NearbyProfileInfoView
  extends FrameLayout
{
  private final TextView a;
  private final TextView b;
  @Nullable
  private String c;
  @Nullable
  private String d;
  
  @JvmOverloads
  public NearbyProfileInfoView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public NearbyProfileInfoView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public NearbyProfileInfoView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(1946484746, (ViewGroup)this);
    paramContext = findViewById(1946419220);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.person_info_title)");
    this.a = ((TextView)paramContext);
    paramContext = findViewById(1946419221);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.personal_info_content)");
    this.b = ((TextView)paramContext);
  }
  
  @Nullable
  public final String getContent()
  {
    return this.d;
  }
  
  @Nullable
  public final String getTitle()
  {
    return this.c;
  }
  
  public final void setContent(@Nullable String paramString)
  {
    this.d = paramString;
    this.b.setText((CharSequence)this.d);
    paramString = (CharSequence)this.d;
    int i;
    if ((paramString != null) && (paramString.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      setVisibility(8);
    }
  }
  
  public final void setTitle(@Nullable String paramString)
  {
    this.c = paramString;
    this.a.setText((CharSequence)paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileInfoView
 * JD-Core Version:    0.7.0.1
 */