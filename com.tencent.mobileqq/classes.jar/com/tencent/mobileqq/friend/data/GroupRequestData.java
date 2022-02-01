package com.tencent.mobileqq.friend.data;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/friend/data/GroupRequestData;", "Ljava/io/Serializable;", "reqType", "", "groupId", "", "sortId", "groupIdList", "", "sortIdList", "name", "", "(IBB[B[BLjava/lang/String;)V", "getGroupId", "()B", "setGroupId", "(B)V", "getGroupIdList", "()[B", "setGroupIdList", "([B)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getReqType", "()I", "setReqType", "(I)V", "getSortId", "setSortId", "getSortIdList", "setSortIdList", "toString", "Companion", "IMCore_release"}, k=1, mv={1, 1, 16})
public final class GroupRequestData
  implements Serializable
{
  public static final GroupRequestData.Companion Companion = new GroupRequestData.Companion(null);
  public static final int TYPE_ADD = 0;
  public static final int TYPE_DELETE = 2;
  public static final int TYPE_RENAME = 1;
  public static final int TYPE_SORT = 3;
  private byte groupId;
  @NotNull
  private byte[] groupIdList;
  @NotNull
  private String name;
  private int reqType;
  private byte sortId;
  @NotNull
  private byte[] sortIdList;
  
  public GroupRequestData()
  {
    this(0, (byte)0, (byte)0, null, null, null, 63, null);
  }
  
  public GroupRequestData(int paramInt, byte paramByte1, byte paramByte2, @NotNull byte[] paramArrayOfByte1, @NotNull byte[] paramArrayOfByte2, @NotNull String paramString)
  {
    this.reqType = paramInt;
    this.groupId = paramByte1;
    this.sortId = paramByte2;
    this.groupIdList = paramArrayOfByte1;
    this.sortIdList = paramArrayOfByte2;
    this.name = paramString;
  }
  
  public final byte getGroupId()
  {
    return this.groupId;
  }
  
  @NotNull
  public final byte[] getGroupIdList()
  {
    return this.groupIdList;
  }
  
  @NotNull
  public final String getName()
  {
    return this.name;
  }
  
  public final int getReqType()
  {
    return this.reqType;
  }
  
  public final byte getSortId()
  {
    return this.sortId;
  }
  
  @NotNull
  public final byte[] getSortIdList()
  {
    return this.sortIdList;
  }
  
  public final void setGroupId(byte paramByte)
  {
    this.groupId = paramByte;
  }
  
  public final void setGroupIdList(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "<set-?>");
    this.groupIdList = paramArrayOfByte;
  }
  
  public final void setName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.name = paramString;
  }
  
  public final void setReqType(int paramInt)
  {
    this.reqType = paramInt;
  }
  
  public final void setSortId(byte paramByte)
  {
    this.sortId = paramByte;
  }
  
  public final void setSortIdList(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "<set-?>");
    this.sortIdList = paramArrayOfByte;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GroupRequestData(reqType=");
    localStringBuilder.append(this.reqType);
    localStringBuilder.append(", groupId=");
    localStringBuilder.append(this.groupId);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append("')");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.data.GroupRequestData
 * JD-Core Version:    0.7.0.1
 */