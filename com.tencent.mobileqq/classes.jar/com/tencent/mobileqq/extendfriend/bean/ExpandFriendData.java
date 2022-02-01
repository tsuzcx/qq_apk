package com.tencent.mobileqq.extendfriend.bean;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ExpandFriendData
  extends Entity
{
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
  public boolean hasEnterAIO;
  public boolean hasShowIcebreakerTopic;
  public int matchSrc;
  @unique
  public String matchUin;
  
  public ExpandFriendData() {}
  
  public ExpandFriendData(String paramString)
  {
    this.matchUin = paramString;
  }
  
  public static Object getAttribute(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.w("ExpandFriendData", 1, "getAttribute matchUin or app is null");
      return null;
    }
    paramQQAppInterface = (ExtendFriendLimitChatManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.a(paramString, paramInt);
    }
    QLog.w("ExpandFriendData", 1, "getAttribute ExtendFriendLimitChatManager is null");
    return null;
  }
  
  public static void updateAttribute(QQAppInterface paramQQAppInterface, String paramString, int paramInt, Object paramObject)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.w("ExpandFriendData", 1, "updateAttribute matchUin or app is null");
      return;
    }
    paramQQAppInterface = (ExtendFriendLimitChatManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.a(paramString, paramInt, paramObject);
      return;
    }
    QLog.w("ExpandFriendData", 1, "updateAttribute ExtendFriendLimitChatManager is null");
  }
  
  public Object getAttribute(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case -1: 
      return sMatchSrcMap.get(Integer.valueOf(this.matchSrc));
    case 0: 
      return Integer.valueOf(this.matchSrc);
    case 1: 
      return Boolean.valueOf(this.hasEnterAIO);
    }
    return Boolean.valueOf(this.hasShowIcebreakerTopic);
  }
  
  public void setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.matchSrc = ((Integer)paramObject).intValue();
      return;
    case 1: 
      this.hasEnterAIO = ((Boolean)paramObject).booleanValue();
      return;
    }
    this.hasShowIcebreakerTopic = ((Boolean)paramObject).booleanValue();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("matchUin:").append(this.matchUin).append(",");
    localStringBuilder.append("matchSrc:").append(this.matchSrc).append(",");
    localStringBuilder.append("hasEnterAIO:").append(this.hasEnterAIO).append(",");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.ExpandFriendData
 * JD-Core Version:    0.7.0.1
 */