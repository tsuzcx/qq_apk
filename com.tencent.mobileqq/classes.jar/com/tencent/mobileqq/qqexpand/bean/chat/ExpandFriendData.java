package com.tencent.mobileqq.qqexpand.bean.chat;

import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;

public class ExpandFriendData
  extends Entity
{
  public static final int ATTRIBUTE_ID_ADVERTISE_DATE = 3;
  public static final int ATTRIBUTE_ID_HAS_ENTER_AIO = 1;
  public static final int ATTRIBUTE_ID_HAS_SHOW_ICEBREAKER_TOPIC = 2;
  public static final int ATTRIBUTE_ID_MATCH_SRC = 0;
  public static final int ATTRIBUTE_ID_MATCH_SRC_DESCRIPTION = -1;
  private static final String MATCH_SRC_APPLETS_DESCRIPTION = "小程序";
  public static final int MATCH_SRC_APPLETS_ID = 9;
  private static final String MATCH_SRC_BOTH_LIKE_DESCRIPTION = "找同好";
  public static final int MATCH_SRC_BOTH_LIKE_ID = 3;
  private static final String MATCH_SRC_DEFAULT_DESCRIPTION = "扩列匹配";
  public static final int MATCH_SRC_DEFAULT_ID = 0;
  private static final String MATCH_SRC_EXPAND_SQUARE_DESCRIPTION = "暖说说";
  public static final int MATCH_SRC_EXPAND_SQUARE_ID = 6;
  private static final String MATCH_SRC_FIND_TEAMMATES_DESCRIPTION = "找队友";
  public static final int MATCH_SRC_FIND_TEAMMATES_ID = 1;
  private static final String MATCH_SRC_MAKE_FRIEND_DESCRIPTION = "处q友";
  public static final int MATCH_SRC_MAKE_FRIEND_ID = 4;
  private static final String MATCH_SRC_TREE_HOLE_DESCRIPTION = "找树洞";
  public static final int MATCH_SRC_TREE_HOLE_ID = 2;
  private static final String MATCH_SRC_VOICE_LINK_DESCRIPTION = "语音连麦";
  public static final int MATCH_SRC_VOICE_LINK_ID = 5;
  private static final String TAG = "ExpandFriendData";
  public static final int THEME_BLIND_BOX_END = 200;
  public static final int THEME_BLIND_BOX_START = 100;
  private static final HashMap<Integer, String> sMatchSrcMap = new ExpandFriendData.1();
  public long advertiseDate;
  public boolean hasEnterAIO;
  public boolean hasShowIcebreakerTopic;
  public int matchSrc;
  @unique
  public String matchUin;
  public String nickName;
  
  public ExpandFriendData() {}
  
  public ExpandFriendData(String paramString)
  {
    this.matchUin = paramString;
  }
  
  public static long getAdvertiseDate(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    paramBaseQQAppInterface = getInstance(paramBaseQQAppInterface, paramString);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.advertiseDate;
    }
    return 0L;
  }
  
  public static boolean getHasEnterAIO(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    paramBaseQQAppInterface = getInstance(paramBaseQQAppInterface, paramString);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.hasEnterAIO;
    }
    return false;
  }
  
  public static boolean getHasShowIcebreakerTopic(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    paramBaseQQAppInterface = getInstance(paramBaseQQAppInterface, paramString);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.hasShowIcebreakerTopic;
    }
    return false;
  }
  
  public static ExpandFriendData getInstance(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    return ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).getInstance(paramBaseQQAppInterface, paramString);
  }
  
  public static int getMatchSrc(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    paramBaseQQAppInterface = getInstance(paramBaseQQAppInterface, paramString);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.matchSrc;
    }
    return 0;
  }
  
  public static String getMatchSrcDes(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    int i = getMatchSrc(paramBaseQQAppInterface, paramString);
    return (String)sMatchSrcMap.get(Integer.valueOf(i));
  }
  
  public static String getNickName(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    paramBaseQQAppInterface = getInstance(paramBaseQQAppInterface, paramString);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.nickName;
    }
    return "";
  }
  
  public static void setAdvertiseDate(BaseQQAppInterface paramBaseQQAppInterface, String paramString, long paramLong)
  {
    paramString = getInstance(paramBaseQQAppInterface, paramString);
    if (paramString != null)
    {
      paramString.advertiseDate = paramLong;
      updateInstance(paramBaseQQAppInterface, paramString);
    }
  }
  
  public static void setHasEnterAIO(BaseQQAppInterface paramBaseQQAppInterface, String paramString, boolean paramBoolean)
  {
    paramString = getInstance(paramBaseQQAppInterface, paramString);
    if (paramString != null)
    {
      paramString.hasEnterAIO = paramBoolean;
      updateInstance(paramBaseQQAppInterface, paramString);
    }
  }
  
  public static void setHasShowIcebreakerTopic(BaseQQAppInterface paramBaseQQAppInterface, String paramString, boolean paramBoolean)
  {
    paramString = getInstance(paramBaseQQAppInterface, paramString);
    if (paramString != null)
    {
      paramString.hasShowIcebreakerTopic = paramBoolean;
      updateInstance(paramBaseQQAppInterface, paramString);
    }
  }
  
  public static void setMatchSrc(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt)
  {
    paramString = getInstance(paramBaseQQAppInterface, paramString);
    if (paramString != null)
    {
      paramString.matchSrc = paramInt;
      updateInstance(paramBaseQQAppInterface, paramString);
    }
  }
  
  public static void setNickName(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2)
  {
    paramString1 = getInstance(paramBaseQQAppInterface, paramString1);
    if (paramString1 != null)
    {
      paramString1.nickName = paramString2;
      updateInstance(paramBaseQQAppInterface, paramString1);
    }
  }
  
  public static void updateInstance(BaseQQAppInterface paramBaseQQAppInterface, ExpandFriendData paramExpandFriendData)
  {
    ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).updateInstance(paramBaseQQAppInterface, paramExpandFriendData);
  }
  
  public Object getAttribute(int paramInt)
  {
    if (paramInt != -1)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              return null;
            }
            return Long.valueOf(this.advertiseDate);
          }
          return Boolean.valueOf(this.hasShowIcebreakerTopic);
        }
        return Boolean.valueOf(this.hasEnterAIO);
      }
      return Integer.valueOf(this.matchSrc);
    }
    return sMatchSrcMap.get(Integer.valueOf(this.matchSrc));
  }
  
  public void setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          this.advertiseDate = ((Long)paramObject).longValue();
          return;
        }
        this.hasShowIcebreakerTopic = ((Boolean)paramObject).booleanValue();
        return;
      }
      this.hasEnterAIO = ((Boolean)paramObject).booleanValue();
      return;
    }
    this.matchSrc = ((Integer)paramObject).intValue();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("matchUin:");
    localStringBuilder.append(this.matchUin);
    localStringBuilder.append(",");
    localStringBuilder.append("matchSrc:");
    localStringBuilder.append(this.matchSrc);
    localStringBuilder.append(",");
    localStringBuilder.append("hasEnterAIO:");
    localStringBuilder.append(this.hasEnterAIO);
    localStringBuilder.append(",");
    localStringBuilder.append("hasShowIcebreakerTopic:");
    localStringBuilder.append(this.hasShowIcebreakerTopic);
    localStringBuilder.append(",");
    localStringBuilder.append("advertiseData:");
    localStringBuilder.append(this.advertiseDate);
    localStringBuilder.append(",");
    localStringBuilder.append("nickName:");
    localStringBuilder.append(this.nickName);
    localStringBuilder.append(",");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData
 * JD-Core Version:    0.7.0.1
 */