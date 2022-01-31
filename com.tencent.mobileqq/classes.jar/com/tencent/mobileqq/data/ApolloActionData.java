package com.tencent.mobileqq.data;

import android.text.TextUtils;
import atmo;
import atnz;
import atoc;
import banq;
import java.io.Serializable;

public class ApolloActionData
  extends atmo
  implements Serializable
{
  public static final int ACTION_HIDE = 0;
  public static final int ACTION_ID_3D_SEGMENT = 300000;
  public static final int ACTION_SHOW = 1;
  public static final int CURRENCY_TYPE_GOLD = 1;
  public static final int MAIN_ACTION = 1;
  public static final int POST_ACTION = 2;
  public static final int PRE_ACTION = 0;
  @atoc
  public int actionId;
  public float actionMoveDis;
  public String actionName;
  public int actionType;
  public int activeValue;
  public String anmiName;
  @atnz
  public String atNickName;
  public String boy1;
  public String bubbleText;
  public int compoundType;
  public int currencyNum;
  public int currencyType;
  public String description;
  public long endTime;
  public String extraWording;
  public int feeType;
  public int gameId;
  public String gameName;
  public boolean hasExtraAction;
  public boolean hasSound;
  public int icon;
  public String iconUrl;
  @atnz
  public String inputText;
  public int isShow;
  public String keywords;
  public long limitEnd;
  public int limitFree;
  public long limitStart;
  public String maxVer;
  public String minVer;
  public long obtainedTime;
  public float peerMoveDis;
  public String peerUin;
  public int personNum;
  public String pk3DIds;
  public String pkIds;
  public int playArea;
  public int sessionType;
  public int slaveActionId;
  public int soundType;
  public String soundURL;
  public long startTime;
  public int status;
  public String textImg;
  public String url;
  public long version;
  public String vibrate;
  public int vipLevel;
  
  public static String getModelString(int paramInt)
  {
    if (isAction3DModel(paramInt)) {
      return "3D";
    }
    return "2D";
  }
  
  public static boolean isAction3DModel(int paramInt)
  {
    return paramInt >= 300000;
  }
  
  public boolean isHasPostAction()
  {
    return (this.compoundType & 0x5) == 5;
  }
  
  public boolean isHasPreAction()
  {
    return (this.compoundType & 0x4) == 4;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("actionId:").append(this.actionId).append(",actionName:").append(this.actionName).append(",freeType:").append(this.feeType).append(",isShow:").append(this.isShow).append("limitFree:").append(this.limitFree).append(",startTime:").append(this.startTime);
    return localStringBuilder.toString();
  }
  
  public boolean verifyVersion(String paramString)
  {
    return (TextUtils.isEmpty(this.minVer)) || (TextUtils.isEmpty(this.maxVer)) || ((banq.a(this.minVer, paramString)) && (banq.a(paramString, this.maxVer)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloActionData
 * JD-Core Version:    0.7.0.1
 */