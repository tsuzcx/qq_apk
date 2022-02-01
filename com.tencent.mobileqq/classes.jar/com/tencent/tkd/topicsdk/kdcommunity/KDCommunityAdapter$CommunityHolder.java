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
  @NotNull
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @Nullable
  private CommunityInfo jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo;
  @NotNull
  private TextView b;
  
  public KDCommunityAdapter$CommunityHolder(@Nullable CommunityInfo paramCommunityInfo, @NotNull TextView paramTextView1, @NotNull TextView paramTextView2)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo = paramCommunityInfo;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView1;
    this.b = paramTextView2;
  }
  
  @NotNull
  public final TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  @Nullable
  public final CommunityInfo a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo;
  }
  
  public final void a(@Nullable CommunityInfo paramCommunityInfo)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo = paramCommunityInfo;
  }
  
  @NotNull
  public final TextView b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CommunityHolder))
      {
        paramObject = (CommunityHolder)paramObject;
        if ((Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo)) && (Intrinsics.areEqual(this.jdField_a_of_type_AndroidWidgetTextView, paramObject.jdField_a_of_type_AndroidWidgetTextView)) && (Intrinsics.areEqual(this.b, paramObject.b))) {}
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
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo;
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.b;
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
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanCommunityInfo);
    localStringBuilder.append(", titleView=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidWidgetTextView);
    localStringBuilder.append(", description=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.kdcommunity.KDCommunityAdapter.CommunityHolder
 * JD-Core Version:    0.7.0.1
 */