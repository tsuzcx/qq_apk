package com.tencent.mobileqq.profilecard.vas;

import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "", "mCurUseStyleId", "", "mCurUseTemplateVersion", "currentTemplate", "Lcom/tencent/mobileqq/profilecard/template/ProfileCardTemplate;", "cardData", "Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "diyData", "Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;", "diyTextData", "Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;", "(JJLcom/tencent/mobileqq/profilecard/template/ProfileCardTemplate;Lcom/tencent/mobileqq/profilecard/vas/VasCardData;Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;)V", "getCardData", "()Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "getCurrentTemplate", "()Lcom/tencent/mobileqq/profilecard/template/ProfileCardTemplate;", "getDiyData", "()Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;", "getDiyTextData", "()Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;", "getMCurUseStyleId", "()J", "getMCurUseTemplateVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasProfileData
{
  @NotNull
  private final VasCardData cardData;
  @Nullable
  private final ProfileCardTemplate currentTemplate;
  @Nullable
  private final VasDiyData diyData;
  @NotNull
  private final VasDiyTextData diyTextData;
  private final long mCurUseStyleId;
  private final long mCurUseTemplateVersion;
  
  public VasProfileData()
  {
    this(0L, 0L, null, null, null, null, 63, null);
  }
  
  public VasProfileData(long paramLong1, long paramLong2, @Nullable ProfileCardTemplate paramProfileCardTemplate, @NotNull VasCardData paramVasCardData, @Nullable VasDiyData paramVasDiyData, @NotNull VasDiyTextData paramVasDiyTextData)
  {
    this.mCurUseStyleId = paramLong1;
    this.mCurUseTemplateVersion = paramLong2;
    this.currentTemplate = paramProfileCardTemplate;
    this.cardData = paramVasCardData;
    this.diyData = paramVasDiyData;
    this.diyTextData = paramVasDiyTextData;
  }
  
  public final long component1()
  {
    return this.mCurUseStyleId;
  }
  
  public final long component2()
  {
    return this.mCurUseTemplateVersion;
  }
  
  @Nullable
  public final ProfileCardTemplate component3()
  {
    return this.currentTemplate;
  }
  
  @NotNull
  public final VasCardData component4()
  {
    return this.cardData;
  }
  
  @Nullable
  public final VasDiyData component5()
  {
    return this.diyData;
  }
  
  @NotNull
  public final VasDiyTextData component6()
  {
    return this.diyTextData;
  }
  
  @NotNull
  public final VasProfileData copy(long paramLong1, long paramLong2, @Nullable ProfileCardTemplate paramProfileCardTemplate, @NotNull VasCardData paramVasCardData, @Nullable VasDiyData paramVasDiyData, @NotNull VasDiyTextData paramVasDiyTextData)
  {
    Intrinsics.checkParameterIsNotNull(paramVasCardData, "cardData");
    Intrinsics.checkParameterIsNotNull(paramVasDiyTextData, "diyTextData");
    return new VasProfileData(paramLong1, paramLong2, paramProfileCardTemplate, paramVasCardData, paramVasDiyData, paramVasDiyTextData);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VasProfileData))
      {
        paramObject = (VasProfileData)paramObject;
        if ((this.mCurUseStyleId == paramObject.mCurUseStyleId) && (this.mCurUseTemplateVersion == paramObject.mCurUseTemplateVersion) && (Intrinsics.areEqual(this.currentTemplate, paramObject.currentTemplate)) && (Intrinsics.areEqual(this.cardData, paramObject.cardData)) && (Intrinsics.areEqual(this.diyData, paramObject.diyData)) && (Intrinsics.areEqual(this.diyTextData, paramObject.diyTextData))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final VasCardData getCardData()
  {
    return this.cardData;
  }
  
  @Nullable
  public final ProfileCardTemplate getCurrentTemplate()
  {
    return this.currentTemplate;
  }
  
  @Nullable
  public final VasDiyData getDiyData()
  {
    return this.diyData;
  }
  
  @NotNull
  public final VasDiyTextData getDiyTextData()
  {
    return this.diyTextData;
  }
  
  public final long getMCurUseStyleId()
  {
    return this.mCurUseStyleId;
  }
  
  public final long getMCurUseTemplateVersion()
  {
    return this.mCurUseTemplateVersion;
  }
  
  public int hashCode()
  {
    long l = this.mCurUseStyleId;
    int n = (int)(l ^ l >>> 32);
    l = this.mCurUseTemplateVersion;
    int i1 = (int)(l ^ l >>> 32);
    Object localObject = this.currentTemplate;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.cardData;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.diyData;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.diyTextData;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return ((((n * 31 + i1) * 31 + i) * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VasProfileData(mCurUseStyleId=");
    localStringBuilder.append(this.mCurUseStyleId);
    localStringBuilder.append(", mCurUseTemplateVersion=");
    localStringBuilder.append(this.mCurUseTemplateVersion);
    localStringBuilder.append(", currentTemplate=");
    localStringBuilder.append(this.currentTemplate);
    localStringBuilder.append(", cardData=");
    localStringBuilder.append(this.cardData);
    localStringBuilder.append(", diyData=");
    localStringBuilder.append(this.diyData);
    localStringBuilder.append(", diyTextData=");
    localStringBuilder.append(this.diyTextData);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.VasProfileData
 * JD-Core Version:    0.7.0.1
 */