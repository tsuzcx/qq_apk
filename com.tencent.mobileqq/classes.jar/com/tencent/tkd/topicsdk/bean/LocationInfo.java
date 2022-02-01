package com.tencent.tkd.topicsdk.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "Ljava/io/Serializable;", "()V", "addr", "", "getAddr", "()Ljava/lang/String;", "setAddr", "(Ljava/lang/String;)V", "isUserSelect", "", "()I", "setUserSelect", "(I)V", "latitude", "", "getLatitude", "()J", "setLatitude", "(J)V", "longitude", "getLongitude", "setLongitude", "name", "getName", "setName", "uid", "getUid", "setUid", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class LocationInfo
  implements Serializable
{
  @NotNull
  private String addr = "";
  private int isUserSelect = 1;
  private long latitude;
  private long longitude;
  @NotNull
  private String name = "";
  @NotNull
  private String uid = "";
  
  @NotNull
  public final String getAddr()
  {
    return this.addr;
  }
  
  public final long getLatitude()
  {
    return this.latitude;
  }
  
  public final long getLongitude()
  {
    return this.longitude;
  }
  
  @NotNull
  public final String getName()
  {
    return this.name;
  }
  
  @NotNull
  public final String getUid()
  {
    return this.uid;
  }
  
  public final int isUserSelect()
  {
    return this.isUserSelect;
  }
  
  public final void setAddr(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.addr = paramString;
  }
  
  public final void setLatitude(long paramLong)
  {
    this.latitude = paramLong;
  }
  
  public final void setLongitude(long paramLong)
  {
    this.longitude = paramLong;
  }
  
  public final void setName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.name = paramString;
  }
  
  public final void setUid(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.uid = paramString;
  }
  
  public final void setUserSelect(int paramInt)
  {
    this.isUserSelect = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.LocationInfo
 * JD-Core Version:    0.7.0.1
 */