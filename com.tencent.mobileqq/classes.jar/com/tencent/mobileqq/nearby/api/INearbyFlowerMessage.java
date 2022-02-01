package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface INearbyFlowerMessage
  extends QRouteApi
{
  public static final String FLOWER_TYPE_DATING = "2";
  public static final String FLOWER_TYPE_HOTCHAT = "3";
  public static final String FLOWER_TYPE_NEARBY = "1";
  public static final String FLOWER_TYPE_RANDOM = "4";
  
  public abstract void bind(Object paramObject1, Object paramObject2);
  
  public abstract String getBgPic();
  
  public abstract String getBrief();
  
  public abstract String getCommon();
  
  public abstract int getFlowerServiceId();
  
  public abstract String getFrienduin();
  
  public abstract String getFromName();
  
  public abstract String getFromUrl();
  
  public abstract String getGroupCode();
  
  public abstract long getMsgTime();
  
  public abstract int getScore();
  
  public abstract int getServiceID();
  
  public abstract long getTime();
  
  public abstract String getToName();
  
  public abstract String getToUrl();
  
  public abstract String getVersion();
  
  public abstract String getcMean();
  
  public abstract String getfCount();
  
  public abstract String getfMean();
  
  public abstract String getfPic();
  
  public abstract String getpID();
  
  public abstract String getpURL();
  
  public abstract String getrNick();
  
  public abstract String getrUin();
  
  public abstract String getsID();
  
  public abstract String getsNick();
  
  public abstract String getsUin();
  
  public abstract void init(Object paramObject1, Object paramObject2);
  
  public abstract boolean isAnonymous();
  
  public abstract boolean isIs1v1();
  
  public abstract boolean isRead();
  
  public abstract boolean isReceive();
  
  public abstract boolean isSend();
  
  public abstract void setAnonymous(boolean paramBoolean);
  
  public abstract void setBgPic(String paramString);
  
  public abstract void setBrief(String paramString);
  
  public abstract void setCommon(String paramString);
  
  public abstract void setFrienduin(String paramString);
  
  public abstract void setFromName(String paramString);
  
  public abstract void setFromUrl(String paramString);
  
  public abstract void setGroupCode(String paramString);
  
  public abstract void setIs1v1(boolean paramBoolean);
  
  public abstract void setMsgTime(long paramLong);
  
  public abstract void setRead(boolean paramBoolean);
  
  public abstract void setReceive(boolean paramBoolean);
  
  public abstract void setScore(int paramInt);
  
  public abstract void setSend(boolean paramBoolean);
  
  public abstract void setServiceID(int paramInt);
  
  public abstract void setTime(long paramLong);
  
  public abstract void setToName(String paramString);
  
  public abstract void setToUrl(String paramString);
  
  public abstract void setVersion(String paramString);
  
  public abstract void setcMean(String paramString);
  
  public abstract void setfCount(String paramString);
  
  public abstract void setfMean(String paramString);
  
  public abstract void setfPic(String paramString);
  
  public abstract void setpID(String paramString);
  
  public abstract void setpURL(String paramString);
  
  public abstract void setrNick(String paramString);
  
  public abstract void setrUin(String paramString);
  
  public abstract void setsID(String paramString);
  
  public abstract void setsNick(String paramString);
  
  public abstract void setsUin(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.INearbyFlowerMessage
 * JD-Core Version:    0.7.0.1
 */