package com.tencent.tkd.topicsdk.kdcommunity;

import android.widget.TextView;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/kdcommunity/KDCommunityAdapter$CommunityHolder;", "", "communityInfo", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "titleView", "Landroid/widget/TextView;", "description", "(Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;Landroid/widget/TextView;Landroid/widget/TextView;)V", "getCommunityInfo", "()Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "setCommunityInfo", "(Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;)V", "getDescription", "()Landroid/widget/TextView;", "setDescription", "(Landroid/widget/TextView;)V", "getTitleView", "setTitleView", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class KDCommunityAdapter$CommunityHolder
{
  @Nullable
  private CommunityInfo a;
  @NotNull
  private TextView b;
  @NotNull
  private TextView c;
  
  public KDCommunityAdapter$CommunityHolder(@Nullable CommunityInfo paramCommunityInfo, @NotNull TextView paramTextView1, @NotNull TextView paramTextView2)
  {
    this.a = paramCommunityInfo;
    this.b = paramTextView1;
    this.c = paramTextView2;
  }
  
  @Nullable
  public final CommunityInfo a()
  {
    return this.a;
  }
  
  public final void a(@Nullable CommunityInfo paramCommunityInfo)
  {
    this.a = paramCommunityInfo;
  }
  
  @NotNull
  public final TextView b()
  {
    return this.b;
  }
  
  @NotNull
  public final TextView c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CommunityHolder))
      {
        paramObject = (CommunityHolder)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.c;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommunityHolder(communityInfo=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", titleView=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", description=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.kdcommunity.KDCommunityAdapter.CommunityHolder
 * JD-Core Version:    0.7.0.1
 */