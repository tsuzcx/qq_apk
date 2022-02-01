package com.tencent.mobileqq.qqexpand.config;

import android.text.TextUtils;
import com.tencent.mobileqq.qqexpand.bean.chat.LimitChatRes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandConfig
{
  public static final int DEFAULT_SAVE_EMPTY_AIO_NODE = 1;
  public static final int DEFAULT_SEND_PIC_AND_VOICE_MESSAGE_LIMIT_COUNT = 2;
  public String addEntranceLine1;
  public String addEntranceTitle;
  public int androidExpandPlugin = 0;
  public int bLimitchatOpen = 0;
  public int bNuanSSfirstTab = 0;
  public int bSignalBombOpen = 0;
  public int bVoiceMatchOpen = 0;
  public String centerBannerList;
  public int coldPalaceGrayTipPosition = 1;
  public String contactEntranceLine1;
  public String contactEntranceLine2;
  public String contactEntranceTitle;
  public int declerationMinLen;
  public String defaultDecleration;
  public List<String> defaultTags = new ArrayList();
  public String expandExamImg;
  public int exposureTimeLimit = 2;
  public String flutterResMd5;
  public String flutterResUrl;
  public int isExpandEntranceOnTop;
  public int isHasUpgradeIntroduce;
  public HashMap<String, LimitChatRes> limitChatResList = new HashMap();
  public String mBeatWarning;
  public String mResourceMD5;
  public String mResourceURL;
  public int mShowGroup;
  public int matchChatGrayTipsCount = 50;
  public String matchChatGrayTipsLight;
  public String matchChatGrayTipsMsg;
  public int matchChatIceBreakSwitch = 1;
  public int maxPlayers;
  public int maxSlipTimes;
  public int minPlayers;
  public int newUserMoment;
  public int redisplayInterval;
  public int saveEmptyAIONode = 1;
  public String searchHint;
  public List<String> searchTags = new ArrayList();
  public int sendPicAndVoiceMessageLimitCount = 2;
  public boolean showVipIcon = false;
  public int tabIndex = 0;
  public int testId = 0;
  public String testStrId = "";
  public int voiceMaxLength;
  
  public String getTestId()
  {
    if (!TextUtils.isEmpty(this.testStrId)) {
      return this.testStrId;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.testId);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.config.ExpandConfig
 * JD-Core Version:    0.7.0.1
 */