package com.tencent.mobileqq.nearby.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.nearby.api.INearbyFlowerMessage;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public class NearbyFlowerMessageImpl
  implements INearbyFlowerMessage, Serializable
{
  public static final int FLOWER_SERVICE_ID = 52;
  public static final String URL_FOR_HEAD_PREFIX = "voice_hall_avatar_";
  private static final long serialVersionUID = 1L;
  public String bgPic = "";
  public String brief = "";
  public String cMean = "";
  public String common = "";
  public String fCount = "";
  public String fMean = "";
  public String fPic = "";
  public String frienduin;
  public String fromName = "";
  public String fromUrl = "";
  public String groupCode;
  public boolean is1v1 = false;
  public boolean isAnonymous = false;
  public boolean isRead = false;
  public boolean isReceive = false;
  public boolean isSend = false;
  public long msgTime;
  public String pID = "";
  public String pURL = "";
  public String rNick = "";
  public String rUin = "";
  public String sID = "";
  public String sNick = "";
  public String sUin = "";
  public int score = 0;
  public int serviceID = -1;
  public long time;
  public String toName = "";
  public String toUrl = "";
  public String version = "";
  
  public NearbyFlowerMessageImpl() {}
  
  public NearbyFlowerMessageImpl(AppInterface paramAppInterface, MessageForStructing paramMessageForStructing)
  {
    init(paramAppInterface, paramMessageForStructing);
  }
  
  public static String getFlowerMsgVersion(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
    {
      paramMessageForStructing = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
      if ((paramMessageForStructing.mMsgServiceID == 52) && (paramMessageForStructing.getItemCount() > 0))
      {
        paramMessageForStructing = paramMessageForStructing.getItemByIndex(0);
        if ((paramMessageForStructing instanceof StructMsgItemLayout12))
        {
          paramMessageForStructing = (StructMsgItemLayout12)paramMessageForStructing;
          if (!paramMessageForStructing.aB) {
            paramMessageForStructing.f();
          }
          paramMessageForStructing = paramMessageForStructing.az.getString("version");
          if (paramMessageForStructing != null) {
            break label83;
          }
        }
      }
    }
    paramMessageForStructing = "";
    label83:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("version: ");
      localStringBuilder.append(paramMessageForStructing);
      QLog.i("NearbyFlowerMessage", 2, localStringBuilder.toString());
    }
    return paramMessageForStructing;
  }
  
  public void bind(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (QQAppInterface)paramObject1;
    paramObject2 = (MessageForStructing)paramObject2;
    if (paramObject2 == null) {
      return;
    }
    this.time = System.currentTimeMillis();
    this.frienduin = paramObject2.frienduin;
    this.isRead = paramObject2.isread;
    this.msgTime = paramObject2.time;
    if ((paramObject2.structingMsg instanceof StructMsgForGeneralShare))
    {
      paramObject2 = (StructMsgForGeneralShare)paramObject2.structingMsg;
      this.serviceID = paramObject2.mMsgServiceID;
      if (this.serviceID != 52) {
        return;
      }
      if (paramObject2.getItemCount() > 0)
      {
        paramObject2 = paramObject2.getItemByIndex(0);
        if ((paramObject2 instanceof StructMsgItemLayout12))
        {
          paramObject2 = (StructMsgItemLayout12)paramObject2;
          if (!paramObject2.aB)
          {
            if (QLog.isColorLevel()) {
              QLog.i("NearbyFlowerMessage", 2, "need init data.");
            }
            paramObject2.f();
          }
          this.version = paramObject2.az.getString("version");
          this.bgPic = paramObject2.az.getString("bgPic");
          this.fPic = paramObject2.az.getString("fPic");
          this.sNick = paramObject2.az.getString("sNick");
          this.rNick = paramObject2.az.getString("rNick");
          this.common = paramObject2.az.getString("common");
          this.fMean = paramObject2.az.getString("fMean");
          this.cMean = paramObject2.az.getString("cMean");
          this.pID = paramObject2.az.getString("pID");
          this.pURL = paramObject2.az.getString("pURL");
          this.fCount = paramObject2.az.getString("fCount");
          this.sUin = paramObject2.az.getString("sUin");
          this.rUin = paramObject2.az.getString("rUin");
          this.groupCode = paramObject2.az.getString("groupCode");
          localObject1 = paramObject2.az.getString("score");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        }
      }
    }
    try
    {
      this.score = Integer.parseInt((String)localObject1);
    }
    catch (Throwable localThrowable)
    {
      label345:
      Object localObject2;
      int i;
      StringBuilder localStringBuilder;
      break label345;
    }
    this.score = 0;
    this.sID = paramObject2.az.getString("sID");
    this.isSend = paramObject2.az.getBoolean("isSend", false);
    this.isReceive = paramObject2.az.getBoolean("isReceive", false);
    Object localObject1 = paramObject2.az.getString("anonyInfo");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ((String)localObject1).split("\\|");
      if ((localObject1.length > 0) && (!TextUtils.isEmpty(localObject1[0])))
      {
        localObject2 = paramObject1.getAVNotifyCenter().d(this.sUin);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          i = ((String)localObject2).lastIndexOf("voice_hall_avatar_");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((String)localObject2).substring(0, i));
          localStringBuilder.append("voice_hall_avatar_");
          localStringBuilder.append(localObject1[0]);
          this.fromUrl = localStringBuilder.toString();
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("voice_hall_avatar_");
          ((StringBuilder)localObject2).append(localObject1[0]);
          this.fromUrl = ((StringBuilder)localObject2).toString();
        }
      }
      if (localObject1.length > 1) {
        this.fromName = localObject1[1];
      }
      if ((localObject1.length > 2) && (!TextUtils.isEmpty(localObject1[2])))
      {
        localObject2 = paramObject1.getAVNotifyCenter().d(this.rUin);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          i = ((String)localObject2).lastIndexOf("voice_hall_avatar_");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((String)localObject2).substring(0, i));
          localStringBuilder.append("voice_hall_avatar_");
          localStringBuilder.append(localObject1[2]);
          this.toUrl = localStringBuilder.toString();
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("voice_hall_avatar_");
          ((StringBuilder)localObject2).append(localObject1[2]);
          this.toUrl = ((StringBuilder)localObject2).toString();
        }
      }
      if (localObject1.length > 3) {
        this.toName = localObject1[3];
      }
      if (localObject1.length > 4) {
        this.is1v1 = "1".equals(localObject1[4]);
      }
      this.isAnonymous = true;
    }
    if (this.isAnonymous)
    {
      if (this.is1v1)
      {
        if (this.isSend)
        {
          paramObject1 = new StringBuilder();
          paramObject1.append(HardCodeUtil.a(2131905016));
          paramObject1.append(this.toName);
          paramObject1.append(HardCodeUtil.a(2131905021));
          this.brief = paramObject1.toString();
        }
        else if (this.isReceive)
        {
          if ((TextUtils.isEmpty(this.fromName)) || (TextUtils.equals(this.fromName, "null"))) {
            this.fromName = paramObject1.getAVNotifyCenter().c(this.sUin);
          }
          paramObject1 = new StringBuilder();
          paramObject1.append(this.fromName);
          paramObject1.append(HardCodeUtil.a(2131905020));
          paramObject1.append(HardCodeUtil.a(2131905013));
          this.brief = paramObject1.toString();
        }
      }
      else
      {
        paramObject1 = new StringBuilder();
        paramObject1.append(this.fromName);
        paramObject1.append(HardCodeUtil.a(2131905012));
        paramObject1.append(this.toName);
        paramObject1.append(HardCodeUtil.a(2131905017));
        this.brief = paramObject1.toString();
      }
    }
    else
    {
      paramObject1 = new StringBuilder();
      paramObject1.append(this.sNick);
      paramObject1.append(HardCodeUtil.a(2131905019));
      paramObject1.append(this.rNick);
      paramObject1.append(HardCodeUtil.a(2131905022));
      this.brief = paramObject1.toString();
    }
    if (QLog.isColorLevel()) {
      QLog.i("NearbyFlowerMessage", 2, paramObject2.az.toString());
    }
    if (QLog.isColorLevel())
    {
      paramObject1 = new StringBuilder();
      paramObject1.append("isAnonymous: ");
      paramObject1.append(this.isAnonymous);
      paramObject1.append(", fromUrl: ");
      paramObject1.append(this.fromUrl);
      paramObject1.append(", fromName: ");
      paramObject1.append(this.fromName);
      paramObject1.append(", toUrl: ");
      paramObject1.append(this.toUrl);
      paramObject1.append(", toName: ");
      paramObject1.append(this.toName);
      paramObject1.append(", brief: ");
      paramObject1.append(this.brief);
      QLog.i("NearbyFlowerMessage", 2, paramObject1.toString());
    }
  }
  
  public String getBgPic()
  {
    return this.bgPic;
  }
  
  public String getBrief()
  {
    return this.brief;
  }
  
  public String getCommon()
  {
    return this.common;
  }
  
  public int getFlowerServiceId()
  {
    return 52;
  }
  
  public String getFrienduin()
  {
    return this.frienduin;
  }
  
  public String getFromName()
  {
    return this.fromName;
  }
  
  public String getFromUrl()
  {
    return this.fromUrl;
  }
  
  public String getGroupCode()
  {
    return this.groupCode;
  }
  
  public long getMsgTime()
  {
    return this.msgTime;
  }
  
  public int getScore()
  {
    return this.score;
  }
  
  public int getServiceID()
  {
    return this.serviceID;
  }
  
  public long getTime()
  {
    return this.time;
  }
  
  public String getToName()
  {
    return this.toName;
  }
  
  public String getToUrl()
  {
    return this.toUrl;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public String getcMean()
  {
    return this.cMean;
  }
  
  public String getfCount()
  {
    return this.fCount;
  }
  
  public String getfMean()
  {
    return this.fMean;
  }
  
  public String getfPic()
  {
    return this.fPic;
  }
  
  public String getpID()
  {
    return this.pID;
  }
  
  public String getpURL()
  {
    return this.pURL;
  }
  
  public String getrNick()
  {
    return this.rNick;
  }
  
  public String getrUin()
  {
    return this.rUin;
  }
  
  public String getsID()
  {
    return this.sID;
  }
  
  public String getsNick()
  {
    return this.sNick;
  }
  
  public String getsUin()
  {
    return this.sUin;
  }
  
  public void init(Object paramObject1, Object paramObject2)
  {
    paramObject2 = (MessageForStructing)paramObject2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgType: ");
      localStringBuilder.append(paramObject2.msgtype);
      localStringBuilder.append(", uinType: ");
      localStringBuilder.append(paramObject2.istroop);
      localStringBuilder.append(", selfUin: ");
      localStringBuilder.append(paramObject2.selfuin);
      localStringBuilder.append(", senderUin: ");
      localStringBuilder.append(paramObject2.senderuin);
      localStringBuilder.append(", friendUin: ");
      localStringBuilder.append(paramObject2.frienduin);
      QLog.d("NearbyFlowerMessage", 2, localStringBuilder.toString());
    }
    bind(paramObject1, paramObject2);
  }
  
  public boolean isAnonymous()
  {
    return this.isAnonymous;
  }
  
  public boolean isIs1v1()
  {
    return this.is1v1;
  }
  
  public boolean isRead()
  {
    return this.isRead;
  }
  
  public boolean isReceive()
  {
    return this.isReceive;
  }
  
  public boolean isSend()
  {
    return this.isSend;
  }
  
  public void setAnonymous(boolean paramBoolean)
  {
    this.isAnonymous = paramBoolean;
  }
  
  public void setBgPic(String paramString)
  {
    this.bgPic = paramString;
  }
  
  public void setBrief(String paramString)
  {
    this.brief = paramString;
  }
  
  public void setCommon(String paramString)
  {
    this.common = paramString;
  }
  
  public void setFrienduin(String paramString)
  {
    this.frienduin = paramString;
  }
  
  public void setFromName(String paramString)
  {
    this.fromName = paramString;
  }
  
  public void setFromUrl(String paramString)
  {
    this.fromUrl = paramString;
  }
  
  public void setGroupCode(String paramString)
  {
    this.groupCode = paramString;
  }
  
  public void setIs1v1(boolean paramBoolean)
  {
    this.is1v1 = paramBoolean;
  }
  
  public void setMsgTime(long paramLong)
  {
    this.msgTime = paramLong;
  }
  
  public void setRead(boolean paramBoolean)
  {
    this.isRead = paramBoolean;
  }
  
  public void setReceive(boolean paramBoolean)
  {
    this.isReceive = paramBoolean;
  }
  
  public void setScore(int paramInt)
  {
    this.score = paramInt;
  }
  
  public void setSend(boolean paramBoolean)
  {
    this.isSend = paramBoolean;
  }
  
  public void setServiceID(int paramInt)
  {
    this.serviceID = paramInt;
  }
  
  public void setTime(long paramLong)
  {
    this.time = paramLong;
  }
  
  public void setToName(String paramString)
  {
    this.toName = paramString;
  }
  
  public void setToUrl(String paramString)
  {
    this.toUrl = paramString;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
  
  public void setcMean(String paramString)
  {
    this.cMean = paramString;
  }
  
  public void setfCount(String paramString)
  {
    this.fCount = paramString;
  }
  
  public void setfMean(String paramString)
  {
    this.fMean = paramString;
  }
  
  public void setfPic(String paramString)
  {
    this.fPic = paramString;
  }
  
  public void setpID(String paramString)
  {
    this.pID = paramString;
  }
  
  public void setpURL(String paramString)
  {
    this.pURL = paramString;
  }
  
  public void setrNick(String paramString)
  {
    this.rNick = paramString;
  }
  
  public void setrUin(String paramString)
  {
    this.rUin = paramString;
  }
  
  public void setsID(String paramString)
  {
    this.sID = paramString;
  }
  
  public void setsNick(String paramString)
  {
    this.sNick = paramString;
  }
  
  public void setsUin(String paramString)
  {
    this.sUin = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isAnonymous: ");
    localStringBuilder.append(this.isAnonymous);
    localStringBuilder.append(", isSend: ");
    localStringBuilder.append(this.isSend);
    localStringBuilder.append(", isReceive: ");
    localStringBuilder.append(this.isReceive);
    localStringBuilder.append(", fromUrl: ");
    localStringBuilder.append(this.fromUrl);
    localStringBuilder.append(", fromName: ");
    localStringBuilder.append(this.fromName);
    localStringBuilder.append(", toUrl: ");
    localStringBuilder.append(this.toUrl);
    localStringBuilder.append(", toName: ");
    localStringBuilder.append(this.toName);
    localStringBuilder.append(", brief: ");
    localStringBuilder.append(this.brief);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbyFlowerMessageImpl
 * JD-Core Version:    0.7.0.1
 */