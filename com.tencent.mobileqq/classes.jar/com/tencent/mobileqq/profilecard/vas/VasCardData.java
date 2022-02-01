package com.tencent.mobileqq.profilecard.vas;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "", "lCurrentStyleId", "", "lCurrentBgId", "backgroundUrl", "", "backgroundColor", "dynamicCardFlag", "", "strZipUrl", "strActiveUrl", "strDrawerCardUrl", "strWzryHeroUrl", "wzryHonorInfo", "", "strExtInfo", "strCurrentBgUrl", "(JJLjava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()J", "getBackgroundUrl", "()Ljava/lang/String;", "getDynamicCardFlag", "()I", "getLCurrentBgId", "getLCurrentStyleId", "getStrActiveUrl", "getStrCurrentBgUrl", "getStrDrawerCardUrl", "getStrExtInfo", "getStrWzryHeroUrl", "getStrZipUrl", "getWzryHonorInfo", "()[B", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasCardData
{
  private final long backgroundColor;
  @NotNull
  private final String backgroundUrl;
  private final int dynamicCardFlag;
  private final long lCurrentBgId;
  private final long lCurrentStyleId;
  @NotNull
  private final String strActiveUrl;
  @Nullable
  private final String strCurrentBgUrl;
  @NotNull
  private final String strDrawerCardUrl;
  @Nullable
  private final String strExtInfo;
  @NotNull
  private final String strWzryHeroUrl;
  @NotNull
  private final String strZipUrl;
  @Nullable
  private final byte[] wzryHonorInfo;
  
  public VasCardData()
  {
    this(0L, 0L, null, 0L, 0, null, null, null, null, null, null, null, 4095, null);
  }
  
  public VasCardData(long paramLong1, long paramLong2, @NotNull String paramString1, long paramLong3, int paramInt, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @Nullable byte[] paramArrayOfByte, @Nullable String paramString6, @Nullable String paramString7)
  {
    this.lCurrentStyleId = paramLong1;
    this.lCurrentBgId = paramLong2;
    this.backgroundUrl = paramString1;
    this.backgroundColor = paramLong3;
    this.dynamicCardFlag = paramInt;
    this.strZipUrl = paramString2;
    this.strActiveUrl = paramString3;
    this.strDrawerCardUrl = paramString4;
    this.strWzryHeroUrl = paramString5;
    this.wzryHonorInfo = paramArrayOfByte;
    this.strExtInfo = paramString6;
    this.strCurrentBgUrl = paramString7;
  }
  
  public final long component1()
  {
    return this.lCurrentStyleId;
  }
  
  @Nullable
  public final byte[] component10()
  {
    return this.wzryHonorInfo;
  }
  
  @Nullable
  public final String component11()
  {
    return this.strExtInfo;
  }
  
  @Nullable
  public final String component12()
  {
    return this.strCurrentBgUrl;
  }
  
  public final long component2()
  {
    return this.lCurrentBgId;
  }
  
  @NotNull
  public final String component3()
  {
    return this.backgroundUrl;
  }
  
  public final long component4()
  {
    return this.backgroundColor;
  }
  
  public final int component5()
  {
    return this.dynamicCardFlag;
  }
  
  @NotNull
  public final String component6()
  {
    return this.strZipUrl;
  }
  
  @NotNull
  public final String component7()
  {
    return this.strActiveUrl;
  }
  
  @NotNull
  public final String component8()
  {
    return this.strDrawerCardUrl;
  }
  
  @NotNull
  public final String component9()
  {
    return this.strWzryHeroUrl;
  }
  
  @NotNull
  public final VasCardData copy(long paramLong1, long paramLong2, @NotNull String paramString1, long paramLong3, int paramInt, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @Nullable byte[] paramArrayOfByte, @Nullable String paramString6, @Nullable String paramString7)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "backgroundUrl");
    Intrinsics.checkParameterIsNotNull(paramString2, "strZipUrl");
    Intrinsics.checkParameterIsNotNull(paramString3, "strActiveUrl");
    Intrinsics.checkParameterIsNotNull(paramString4, "strDrawerCardUrl");
    Intrinsics.checkParameterIsNotNull(paramString5, "strWzryHeroUrl");
    return new VasCardData(paramLong1, paramLong2, paramString1, paramLong3, paramInt, paramString2, paramString3, paramString4, paramString5, paramArrayOfByte, paramString6, paramString7);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VasCardData))
      {
        paramObject = (VasCardData)paramObject;
        if ((this.lCurrentStyleId == paramObject.lCurrentStyleId) && (this.lCurrentBgId == paramObject.lCurrentBgId) && (Intrinsics.areEqual(this.backgroundUrl, paramObject.backgroundUrl)) && (this.backgroundColor == paramObject.backgroundColor) && (this.dynamicCardFlag == paramObject.dynamicCardFlag) && (Intrinsics.areEqual(this.strZipUrl, paramObject.strZipUrl)) && (Intrinsics.areEqual(this.strActiveUrl, paramObject.strActiveUrl)) && (Intrinsics.areEqual(this.strDrawerCardUrl, paramObject.strDrawerCardUrl)) && (Intrinsics.areEqual(this.strWzryHeroUrl, paramObject.strWzryHeroUrl)) && (Intrinsics.areEqual(this.wzryHonorInfo, paramObject.wzryHonorInfo)) && (Intrinsics.areEqual(this.strExtInfo, paramObject.strExtInfo)) && (Intrinsics.areEqual(this.strCurrentBgUrl, paramObject.strCurrentBgUrl))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final long getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  @NotNull
  public final String getBackgroundUrl()
  {
    return this.backgroundUrl;
  }
  
  public final int getDynamicCardFlag()
  {
    return this.dynamicCardFlag;
  }
  
  public final long getLCurrentBgId()
  {
    return this.lCurrentBgId;
  }
  
  public final long getLCurrentStyleId()
  {
    return this.lCurrentStyleId;
  }
  
  @NotNull
  public final String getStrActiveUrl()
  {
    return this.strActiveUrl;
  }
  
  @Nullable
  public final String getStrCurrentBgUrl()
  {
    return this.strCurrentBgUrl;
  }
  
  @NotNull
  public final String getStrDrawerCardUrl()
  {
    return this.strDrawerCardUrl;
  }
  
  @Nullable
  public final String getStrExtInfo()
  {
    return this.strExtInfo;
  }
  
  @NotNull
  public final String getStrWzryHeroUrl()
  {
    return this.strWzryHeroUrl;
  }
  
  @NotNull
  public final String getStrZipUrl()
  {
    return this.strZipUrl;
  }
  
  @Nullable
  public final byte[] getWzryHonorInfo()
  {
    return this.wzryHonorInfo;
  }
  
  public int hashCode()
  {
    long l = this.lCurrentStyleId;
    int i4 = (int)(l ^ l >>> 32);
    l = this.lCurrentBgId;
    int i5 = (int)(l ^ l >>> 32);
    Object localObject = this.backgroundUrl;
    int i3 = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    l = this.backgroundColor;
    int i6 = (int)(l ^ l >>> 32);
    int i7 = this.dynamicCardFlag;
    localObject = this.strZipUrl;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.strActiveUrl;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.strDrawerCardUrl;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.strWzryHeroUrl;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.wzryHonorInfo;
    int i1;
    if (localObject != null) {
      i1 = Arrays.hashCode((byte[])localObject);
    } else {
      i1 = 0;
    }
    localObject = this.strExtInfo;
    int i2;
    if (localObject != null) {
      i2 = localObject.hashCode();
    } else {
      i2 = 0;
    }
    localObject = this.strCurrentBgUrl;
    if (localObject != null) {
      i3 = localObject.hashCode();
    }
    return ((((((((((i4 * 31 + i5) * 31 + i) * 31 + i6) * 31 + i7) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VasCardData(lCurrentStyleId=");
    localStringBuilder.append(this.lCurrentStyleId);
    localStringBuilder.append(", lCurrentBgId=");
    localStringBuilder.append(this.lCurrentBgId);
    localStringBuilder.append(", backgroundUrl=");
    localStringBuilder.append(this.backgroundUrl);
    localStringBuilder.append(", backgroundColor=");
    localStringBuilder.append(this.backgroundColor);
    localStringBuilder.append(", dynamicCardFlag=");
    localStringBuilder.append(this.dynamicCardFlag);
    localStringBuilder.append(", strZipUrl=");
    localStringBuilder.append(this.strZipUrl);
    localStringBuilder.append(", strActiveUrl=");
    localStringBuilder.append(this.strActiveUrl);
    localStringBuilder.append(", strDrawerCardUrl=");
    localStringBuilder.append(this.strDrawerCardUrl);
    localStringBuilder.append(", strWzryHeroUrl=");
    localStringBuilder.append(this.strWzryHeroUrl);
    localStringBuilder.append(", wzryHonorInfo=");
    localStringBuilder.append(Arrays.toString(this.wzryHonorInfo));
    localStringBuilder.append(", strExtInfo=");
    localStringBuilder.append(this.strExtInfo);
    localStringBuilder.append(", strCurrentBgUrl=");
    localStringBuilder.append(this.strCurrentBgUrl);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.VasCardData
 * JD-Core Version:    0.7.0.1
 */