package com.tencent.mobileqq.vas.adv.qzone.data;

import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.QzoneBusiMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/qzone/data/VasAdMetaParam;", "", "uin", "", "advPos", "", "qzoneBusiInfo", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$QzoneBusiMsg;", "(JILcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$QzoneBusiMsg;)V", "getAdvPos", "()I", "getQzoneBusiInfo", "()Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$QzoneBusiMsg;", "getUin", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public final class VasAdMetaParam
{
  private final int advPos;
  @Nullable
  private final vac_adv_get.QzoneBusiMsg qzoneBusiInfo;
  private final long uin;
  
  public VasAdMetaParam(long paramLong, int paramInt, @Nullable vac_adv_get.QzoneBusiMsg paramQzoneBusiMsg)
  {
    this.uin = paramLong;
    this.advPos = paramInt;
    this.qzoneBusiInfo = paramQzoneBusiMsg;
  }
  
  public final long component1()
  {
    return this.uin;
  }
  
  public final int component2()
  {
    return this.advPos;
  }
  
  @Nullable
  public final vac_adv_get.QzoneBusiMsg component3()
  {
    return this.qzoneBusiInfo;
  }
  
  @NotNull
  public final VasAdMetaParam copy(long paramLong, int paramInt, @Nullable vac_adv_get.QzoneBusiMsg paramQzoneBusiMsg)
  {
    return new VasAdMetaParam(paramLong, paramInt, paramQzoneBusiMsg);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VasAdMetaParam))
      {
        paramObject = (VasAdMetaParam)paramObject;
        if ((this.uin == paramObject.uin) && (this.advPos == paramObject.advPos) && (Intrinsics.areEqual(this.qzoneBusiInfo, paramObject.qzoneBusiInfo))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getAdvPos()
  {
    return this.advPos;
  }
  
  @Nullable
  public final vac_adv_get.QzoneBusiMsg getQzoneBusiInfo()
  {
    return this.qzoneBusiInfo;
  }
  
  public final long getUin()
  {
    return this.uin;
  }
  
  public int hashCode()
  {
    long l = this.uin;
    int j = (int)(l ^ l >>> 32);
    int k = this.advPos;
    vac_adv_get.QzoneBusiMsg localQzoneBusiMsg = this.qzoneBusiInfo;
    int i;
    if (localQzoneBusiMsg != null) {
      i = localQzoneBusiMsg.hashCode();
    } else {
      i = 0;
    }
    return (j * 31 + k) * 31 + i;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VasAdMetaParam(uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", advPos=");
    localStringBuilder.append(this.advPos);
    localStringBuilder.append(", qzoneBusiInfo=");
    localStringBuilder.append(this.qzoneBusiInfo);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaParam
 * JD-Core Version:    0.7.0.1
 */