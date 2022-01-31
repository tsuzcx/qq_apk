package com.tencent.mobileqq.data;

import awge;
import awhp;

public class MayKnowExposure
  extends awge
{
  public static final int EXPOSE_ACTION_CLICK_ADD = 3;
  public static final int EXPOSE_ACTION_CLICK_PROFILE = 2;
  public static final int EXPOSE_ACTION_SHOWUP = 1;
  public static final int EXPOSE_ENTRANCE_BABYQ = 7;
  public static final int EXPOSE_ENTRANCE_CONTACTS_ADDFRIEND = 3;
  public static final int EXPOSE_ENTRANCE_CONTACTS_NEWFRIEND = 2;
  public static final int EXPOSE_ENTRANCE_CONTACT_BANNER = 8;
  public static final int EXPOSE_ENTRANCE_CONVERSATION_ADDFRIEND = 4;
  public static final int EXPOSE_ENTRANCE_CONVERSATION_NEWFRIEND = 1;
  public static final int EXPOSE_ENTRANCE_DEFAULT = 0;
  public static final int EXPOSE_ENTRANCE_NEWFRIEND_ADDFRIEND = 6;
  public static final int EXPOSE_ENTRANCE_PUSH_NOTICE = 9;
  public static final int EXPOSE_ENTRANCE_QZONE = 5;
  public static final int EXPOSE_ENTRANCE_SELECT_FINDNEWFRIEND = 10;
  public static final int EXPOSURE_PAGE_ADDFRIEND = 21;
  public static final int EXPOSURE_PAGE_CONTACT_BANNER = 24;
  public static final int EXPOSURE_PAGE_CONTACT_RECOMMEND_TAB = 20;
  public static final int EXPOSURE_PAGE_CONVERSION_RECOMMEND = 25;
  public static final int EXPOSURE_PAGE_DEFAULT = 0;
  public static final int EXPOSURE_PAGE_FINDNEWFRIEND = 28;
  public static final int EXPOSURE_PAGE_MAYKNOWALL = 3;
  public static final int EXPOSURE_PAGE_NEWFRIEND = 23;
  public static final int EXPOSURE_PAGE_QZONE = 4;
  public byte[] acBuffer;
  public int actionId;
  public byte[] additive;
  public int entranceId;
  public int exposeCnt;
  public int exposeTime;
  public int pageId;
  @awhp
  public long startExploseTime;
  public String uin;
  
  public MayKnowExposure() {}
  
  public MayKnowExposure(String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.uin = paramString;
    this.pageId = paramInt1;
    this.entranceId = paramInt2;
    this.actionId = paramInt3;
    this.acBuffer = paramArrayOfByte1;
    this.additive = paramArrayOfByte2;
  }
  
  public static String generateKey(MayKnowExposure paramMayKnowExposure)
  {
    StringBuffer localStringBuffer = new StringBuffer(20);
    localStringBuffer.append(paramMayKnowExposure.uin);
    localStringBuffer.append("_");
    localStringBuffer.append(paramMayKnowExposure.pageId);
    localStringBuffer.append("_");
    localStringBuffer.append(paramMayKnowExposure.entranceId);
    localStringBuffer.append("_");
    localStringBuffer.append(paramMayKnowExposure.actionId);
    return localStringBuffer.toString();
  }
  
  public static String generateKey(MayKnowRecommend paramMayKnowRecommend, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuffer localStringBuffer = new StringBuffer(20);
    localStringBuffer.append(paramMayKnowRecommend.uin);
    localStringBuffer.append("_");
    localStringBuffer.append(paramInt1);
    localStringBuffer.append("_");
    localStringBuffer.append(paramInt2);
    localStringBuffer.append("_");
    localStringBuffer.append(paramInt3);
    return localStringBuffer.toString();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(20);
    localStringBuffer.append("uin:");
    localStringBuffer.append(this.uin);
    localStringBuffer.append(";pageId:");
    localStringBuffer.append(this.pageId);
    localStringBuffer.append(";entranceId:");
    localStringBuffer.append(this.entranceId);
    localStringBuffer.append(";actionId:");
    localStringBuffer.append(this.actionId);
    localStringBuffer.append(";exposeCnt");
    localStringBuffer.append(this.exposeCnt);
    localStringBuffer.append(";exposeTime");
    localStringBuffer.append(this.exposeTime);
    localStringBuffer.append(";startExploseTime");
    localStringBuffer.append(this.startExploseTime);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MayKnowExposure
 * JD-Core Version:    0.7.0.1
 */