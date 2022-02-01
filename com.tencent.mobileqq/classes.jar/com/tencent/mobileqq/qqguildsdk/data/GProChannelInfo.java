package com.tencent.mobileqq.qqguildsdk.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.gprosdk.GProChannel;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import com.tencent.mobileqq.qqguildsdk.util.GProLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class GProChannelInfo
  implements IGProChannelInfo
{
  public static final String TAG = "GProChannelInfo";
  private String channelUin;
  private long mCategoryId = 0L;
  private String mCategoryName = "";
  private GProChannel mChannel;
  
  public GProChannelInfo(GProChannel paramGProChannel)
  {
    this.mChannel = paramGProChannel;
    this.channelUin = GProConvert.a(paramGProChannel.getChannelId());
    GProLog.a("GProChannelInfo", false, "system convert", "GProChannelInfo ", "init by GProChannel(system notify type change)", toString());
  }
  
  public GProChannelInfo(String paramString, ChannelMsgNode paramChannelMsgNode)
  {
    this.mChannel = getDefalutGProChannel(new ChannelCreateInfo.Builder().b(paramString).c(paramChannelMsgNode.a()).a(paramChannelMsgNode.b()).c(paramChannelMsgNode.d()).a(paramChannelMsgNode.c()).a());
    this.channelUin = paramChannelMsgNode.a();
  }
  
  public static GProChannel getDefalutGProChannel(ChannelCreateInfo paramChannelCreateInfo)
  {
    long l1 = GProConvert.a(paramChannelCreateInfo.h());
    long l2 = GProConvert.a(paramChannelCreateInfo.g());
    String str = paramChannelCreateInfo.b();
    int i = paramChannelCreateInfo.a();
    int j = paramChannelCreateInfo.c();
    int k = paramChannelCreateInfo.d();
    int m = paramChannelCreateInfo.e();
    int n = paramChannelCreateInfo.j();
    ArrayList localArrayList = new ArrayList();
    int i1 = paramChannelCreateInfo.f();
    return new GProChannel(l1, l2, str, i, 1L, 1L, j, k, m, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, new byte[0], new byte[0], 1, 0, 0L, 0L, "", 0, n, localArrayList, i1);
  }
  
  public int getBannedSpeak()
  {
    return this.mChannel.getBannedSpeak();
  }
  
  public long getCategoryId()
  {
    return this.mCategoryId;
  }
  
  public String getCategoryName()
  {
    return this.mCategoryName;
  }
  
  public GProChannel getChannel()
  {
    return this.mChannel;
  }
  
  public int getChannelMemberMax()
  {
    return this.mChannel.getChannelMaxMember();
  }
  
  public String getChannelName()
  {
    return this.mChannel.getName();
  }
  
  public String getChannelUin()
  {
    return this.channelUin;
  }
  
  public long getCreateTime()
  {
    return this.mChannel.getCreateTime();
  }
  
  public String getCreatorId()
  {
    return GProConvert.a(this.mChannel.getCreatorTinyId());
  }
  
  public int getFinalMsgNotify()
  {
    return this.mChannel.getFinalNotifyType();
  }
  
  public String getGuildId()
  {
    return GProConvert.a(this.mChannel.getGuildId());
  }
  
  public long getLastCntMsgSeq()
  {
    return this.mChannel.getLastCntMsgSeq();
  }
  
  public long getLastCntMsgTime()
  {
    return this.mChannel.getLastCntMsgTime();
  }
  
  public long getLastMsgSeq()
  {
    return this.mChannel.getLastMsgSeq();
  }
  
  public long getLastMsgTime()
  {
    return this.mChannel.getLastMsgTime();
  }
  
  public long getLiveAnchorTinyId()
  {
    return this.mChannel.getAnchorTinyId();
  }
  
  public long getLiveRoomId()
  {
    return this.mChannel.getRoomId();
  }
  
  public String getLiveRoomName()
  {
    return this.mChannel.getRoomName();
  }
  
  public byte[] getMsgMeta()
  {
    return this.mChannel.getMsgMeta();
  }
  
  public int getMsgNotify()
  {
    return this.mChannel.getMsgNotifyType();
  }
  
  public int getMyMsgNotify()
  {
    return this.mChannel.getMyMsgNotifyType();
  }
  
  public long getReadCntMsgSeq()
  {
    return this.mChannel.getReadCntMsgSeq();
  }
  
  public long getReadCntMsgTime()
  {
    return this.mChannel.getReadCntMsgTime();
  }
  
  public byte[] getReadMsgMeta()
  {
    return this.mChannel.getReadMsgMeta();
  }
  
  public long getReadMsgSeq()
  {
    return this.mChannel.getReadMsgSeq();
  }
  
  public long getReadMsgTime()
  {
    return this.mChannel.getReadMsgTime();
  }
  
  @NotNull
  public List<Integer> getSpecialType()
  {
    return this.mChannel.getSpecialTypes();
  }
  
  public int getTalkPermission()
  {
    return this.mChannel.getTalkPermission();
  }
  
  public int getType()
  {
    return this.mChannel.getType();
  }
  
  public int getVisibleType()
  {
    return this.mChannel.getVisibleType();
  }
  
  public boolean isEqual(IGProChannelInfo paramIGProChannelInfo)
  {
    boolean bool2 = false;
    if (paramIGProChannelInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (getChannelName().equals(paramIGProChannelInfo.getChannelName()))
    {
      bool1 = bool2;
      if (getType() == paramIGProChannelInfo.getType())
      {
        bool1 = bool2;
        if (getTalkPermission() == paramIGProChannelInfo.getTalkPermission())
        {
          bool1 = bool2;
          if (getMyMsgNotify() == paramIGProChannelInfo.getMyMsgNotify())
          {
            bool1 = bool2;
            if (getMsgNotify() == paramIGProChannelInfo.getMsgNotify())
            {
              bool1 = bool2;
              if (getFinalMsgNotify() == paramIGProChannelInfo.getFinalMsgNotify()) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public GProChannelInfo reflash(GProChannel paramGProChannel)
  {
    this.mChannel = paramGProChannel;
    this.channelUin = GProConvert.a(paramGProChannel.getChannelId());
    GProLog.a("GProChannelInfo", false, "cache", "reflash", "GProGuildInfo reflash by ChannelMsgNode", toString());
    return this;
  }
  
  public GProChannelInfo reflash(ChannelMsgNode paramChannelMsgNode)
  {
    if ((!TextUtils.isEmpty(paramChannelMsgNode.b())) && (!paramChannelMsgNode.b().equals(getChannelName()))) {
      this.mChannel.setName(paramChannelMsgNode.b());
    }
    if ((paramChannelMsgNode.d() != -1000) && (this.mChannel.getMyMsgNotifyType() != paramChannelMsgNode.d())) {
      this.mChannel.setMyMsgNotifyType(paramChannelMsgNode.d());
    }
    if ((paramChannelMsgNode.e() != -1000) && (this.mChannel.getFinalNotifyType() != paramChannelMsgNode.e())) {
      this.mChannel.setFinalNotifyType(paramChannelMsgNode.e());
    }
    if ((paramChannelMsgNode.c() != -1000) && (paramChannelMsgNode.c() != 0) && (this.mChannel.getType() != paramChannelMsgNode.c())) {
      this.mChannel.setType(paramChannelMsgNode.c());
    }
    GProLog.a("GProChannelInfo", false, "cache", "reflash", "GProGuildInfo reflash by ChannelMsgNode", toString());
    return this;
  }
  
  public void setBannedSpeak(int paramInt)
  {
    this.mChannel.setBannedSpeak(paramInt);
  }
  
  public void setCategory(long paramLong, String paramString)
  {
    this.mCategoryId = paramLong;
    this.mCategoryName = paramString;
  }
  
  public void setChannelMemberMax(int paramInt)
  {
    this.mChannel.setChannelMaxMember(paramInt);
  }
  
  public void setFinalMsgNotify(int paramInt)
  {
    this.mChannel.setFinalNotifyType(paramInt);
  }
  
  public void setLiveAnchorTinyId(long paramLong)
  {
    this.mChannel.setAnchorTinyId(paramLong);
  }
  
  public void setLiveRoomId(long paramLong)
  {
    this.mChannel.setRoomId(paramLong);
  }
  
  public void setLiveRoomName(String paramString)
  {
    this.mChannel.setRoomName(paramString);
  }
  
  public void setMsgNotify(int paramInt)
  {
    this.mChannel.setMsgNotifyType(paramInt);
  }
  
  public void setMyMsgNotify(int paramInt)
  {
    this.mChannel.setMyMsgNotifyType(paramInt);
  }
  
  public void setName(String paramString)
  {
    this.mChannel.setName(paramString);
  }
  
  public void setTalkPermission(int paramInt)
  {
    this.mChannel.setTalkPermission(paramInt);
  }
  
  public void setType(int paramInt)
  {
    this.mChannel.setType(paramInt);
  }
  
  public void setVisibleType(int paramInt)
  {
    this.mChannel.setVisibleType(paramInt);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProChannelInfo:ID: GuildId:");
    localStringBuilder.append(getGuildId());
    localStringBuilder.append(", chanUin:");
    localStringBuilder.append(getChannelUin());
    localStringBuilder.append(", name:");
    localStringBuilder.append(getChannelName());
    localStringBuilder.append(", type:");
    localStringBuilder.append(getType());
    localStringBuilder.append(", myMsgNotifyType:");
    localStringBuilder.append(getMyMsgNotify());
    localStringBuilder.append(", msgNotifyType:");
    localStringBuilder.append(getMsgNotify());
    localStringBuilder.append(", finalMsgNotifyType:");
    localStringBuilder.append(getFinalMsgNotify());
    localStringBuilder.append(", createTime:");
    localStringBuilder.append(getCreateTime());
    localStringBuilder.append(", channelMemMax:");
    localStringBuilder.append(getChannelMemberMax());
    localStringBuilder.append(", roomId:");
    localStringBuilder.append(getLiveRoomId());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GProChannelInfo
 * JD-Core Version:    0.7.0.1
 */