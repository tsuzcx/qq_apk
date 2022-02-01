package com.tencent.mobileqq.friend.data;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/friend/data/FriendListRequestData;", "Ljava/io/Serializable;", "uinList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isRequestSingle", "", "friendStartIndex", "", "friendCount", "groupStartIndex", "groupCount", "timeStamp", "", "totalFriendCount", "showTermType", "isPullRefresh", "(Ljava/util/ArrayList;ZIIIIJIIZ)V", "getFriendCount", "()I", "setFriendCount", "(I)V", "getFriendStartIndex", "setFriendStartIndex", "getGroupCount", "setGroupCount", "getGroupStartIndex", "setGroupStartIndex", "()Z", "setPullRefresh", "(Z)V", "setRequestSingle", "getShowTermType", "setShowTermType", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "getTotalFriendCount", "setTotalFriendCount", "getUinList", "()Ljava/util/ArrayList;", "setUinList", "(Ljava/util/ArrayList;)V", "getIfGetGroupInfoParam", "", "getIfReflushParam", "getSNSTypeList", "getUinListParam", "toString", "Companion", "IMCore_release"}, k=1, mv={1, 1, 16})
public final class FriendListRequestData
  implements Serializable
{
  public static final FriendListRequestData.Companion Companion = new FriendListRequestData.Companion(null);
  public static final int FIRST_GET_FRIEND_NUM = 20;
  public static final int GET_FRIEND_NUM = 200;
  public static final int GET_GROUP_NUM = 100;
  private int friendCount;
  private int friendStartIndex;
  private int groupCount;
  private int groupStartIndex;
  private boolean isPullRefresh;
  private boolean isRequestSingle;
  private int showTermType;
  private long timeStamp;
  private int totalFriendCount;
  @NotNull
  private ArrayList<String> uinList;
  
  public FriendListRequestData()
  {
    this(null, false, 0, 0, 0, 0, 0L, 0, 0, false, 1023, null);
  }
  
  public FriendListRequestData(@NotNull ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, int paramInt5, int paramInt6, boolean paramBoolean2)
  {
    this.uinList = paramArrayList;
    this.isRequestSingle = paramBoolean1;
    this.friendStartIndex = paramInt1;
    this.friendCount = paramInt2;
    this.groupStartIndex = paramInt3;
    this.groupCount = paramInt4;
    this.timeStamp = paramLong;
    this.totalFriendCount = paramInt5;
    this.showTermType = paramInt6;
    this.isPullRefresh = paramBoolean2;
  }
  
  public final int getFriendCount()
  {
    return this.friendCount;
  }
  
  public final int getFriendStartIndex()
  {
    return this.friendStartIndex;
  }
  
  public final int getGroupCount()
  {
    return this.groupCount;
  }
  
  public final int getGroupStartIndex()
  {
    return this.groupStartIndex;
  }
  
  public final byte getIfGetGroupInfoParam()
  {
    if (this.isRequestSingle) {
      return 0;
    }
    if (this.friendStartIndex > 0) {
      return 0;
    }
    return 1;
  }
  
  public final byte getIfReflushParam()
  {
    boolean bool = this.isRequestSingle;
    byte b = 1;
    if (bool) {
      return 1;
    }
    if (this.friendStartIndex > 0) {
      b = 0;
    }
    return b;
  }
  
  @Nullable
  public final ArrayList<Long> getSNSTypeList()
  {
    ArrayList localArrayList = (ArrayList)null;
    if (!this.isRequestSingle)
    {
      localArrayList = new ArrayList(3);
      localArrayList.add(Long.valueOf(13580L));
      localArrayList.add(Long.valueOf(13581L));
      localArrayList.add(Long.valueOf(13582L));
    }
    return localArrayList;
  }
  
  public final int getShowTermType()
  {
    return this.showTermType;
  }
  
  public final long getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public final int getTotalFriendCount()
  {
    return this.totalFriendCount;
  }
  
  @NotNull
  public final ArrayList<String> getUinList()
  {
    return this.uinList;
  }
  
  @Nullable
  public final ArrayList<Long> getUinListParam()
  {
    if (!this.isRequestSingle) {
      return null;
    }
    localArrayList = new ArrayList();
    try
    {
      if ((((Collection)this.uinList).isEmpty() ^ true))
      {
        Iterator localIterator = this.uinList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Intrinsics.checkExpressionValueIsNotNull(str, "uinStr");
          localArrayList.add(Long.valueOf(Long.parseLong(str)));
        }
      }
      return localArrayList;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("FriendListRequestData", 1, "getUinListParam", (Throwable)localNumberFormatException);
    }
  }
  
  public final boolean isPullRefresh()
  {
    return this.isPullRefresh;
  }
  
  public final boolean isRequestSingle()
  {
    return this.isRequestSingle;
  }
  
  public final void setFriendCount(int paramInt)
  {
    this.friendCount = paramInt;
  }
  
  public final void setFriendStartIndex(int paramInt)
  {
    this.friendStartIndex = paramInt;
  }
  
  public final void setGroupCount(int paramInt)
  {
    this.groupCount = paramInt;
  }
  
  public final void setGroupStartIndex(int paramInt)
  {
    this.groupStartIndex = paramInt;
  }
  
  public final void setPullRefresh(boolean paramBoolean)
  {
    this.isPullRefresh = paramBoolean;
  }
  
  public final void setRequestSingle(boolean paramBoolean)
  {
    this.isRequestSingle = paramBoolean;
  }
  
  public final void setShowTermType(int paramInt)
  {
    this.showTermType = paramInt;
  }
  
  public final void setTimeStamp(long paramLong)
  {
    this.timeStamp = paramLong;
  }
  
  public final void setTotalFriendCount(int paramInt)
  {
    this.totalFriendCount = paramInt;
  }
  
  public final void setUinList(@NotNull ArrayList<String> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.uinList = paramArrayList;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FriendListRequest(uinListSize='");
    localStringBuilder.append(this.uinList.size());
    localStringBuilder.append("', ");
    localStringBuilder.append("friendStartIndex=");
    localStringBuilder.append(this.friendStartIndex);
    localStringBuilder.append(", ");
    localStringBuilder.append("friendCount=");
    localStringBuilder.append(this.friendCount);
    localStringBuilder.append(", ");
    localStringBuilder.append("groupStartIndex=");
    localStringBuilder.append(this.groupStartIndex);
    localStringBuilder.append(", ");
    localStringBuilder.append("groupCount=");
    localStringBuilder.append(this.groupCount);
    localStringBuilder.append(", ");
    localStringBuilder.append("timeStamp=");
    localStringBuilder.append(this.timeStamp);
    localStringBuilder.append(", ");
    localStringBuilder.append("totalFriendCount=");
    localStringBuilder.append(this.totalFriendCount);
    localStringBuilder.append(", ");
    localStringBuilder.append("showTermType=");
    localStringBuilder.append(this.showTermType);
    localStringBuilder.append(", ");
    localStringBuilder.append("isPullRefresh=");
    localStringBuilder.append(this.isPullRefresh);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.data.FriendListRequestData
 * JD-Core Version:    0.7.0.1
 */