package com.tencent.mobileqq.nearby.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashSet;

@QAPI(process={"all"})
public abstract interface IFaceScoreUtils
  extends QRouteApi
{
  public static final String CONFIG_KEY = "nearby_face_score_config";
  public static final String CONFIG_KEY_BG_COLOR = "entranceBgColor";
  public static final String CONFIG_KEY_EXPIRE_TIME = "expireTime";
  public static final String CONFIG_KEY_JUMP_URL = "entranceJumpUrl";
  public static final String CONFIG_KEY_JUMP_URL_FOR_GUEST = "entranceJumpUrlForGuest";
  public static final String CONFIG_KEY_JUMP_URL_FOR_HOST = "entranceJumpUrlForHost";
  public static final String CONFIG_KEY_SHOW_CARD = "isShowCard";
  public static final String CONFIG_KEY_SHOW_LIST = "isShowList";
  public static final String CONFIG_KEY_WORDING = "entranceWording";
  public static final String FLAG_FACE_SCORE_BUBBLE_MSG = "isFaceScoreBubbleMsg";
  public static final String FLAG_FACE_SCORE_GRAY_TIPS = "isFaceScoreGrayTips";
  public static final String FLAG_FACE_SCORE_SECOND_MEMBER = "isFaceScoreSecondMember";
  public static final String FLAG_FACE_SCORE_SPECIAL_LIKE = "isFaceScoreSpecialLike";
  public static final String FLAG_HAS_INSERT_MSG = "has_insert_face_score_msg";
  public static final String REPORT_FACE_SCORE_DEPARTMENT = "grp_lbs";
  public static final String REPORT_FACE_SCORE_OP_TYPE = "face_score";
  public static final String TAG = "PhotoPreviewActivity";
  public static final HashSet sNeedInsertGrayMsgUins = new HashSet();
  
  public abstract Object getConfig(AppInterface paramAppInterface);
  
  public abstract boolean getFaceScoreFlag(MessageRecord paramMessageRecord, String paramString);
  
  public abstract String getFromArray(int paramInt, String... paramVarArgs);
  
  public abstract boolean getHasInsertMsgFlag(AppInterface paramAppInterface, String paramString);
  
  public abstract void report(String paramString1, String paramString2, String... paramVarArgs);
  
  public abstract void saveConfig(AppInterface paramAppInterface, Object paramObject);
  
  public abstract void setFaceScoreFlag(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean);
  
  public abstract void setHasInsertMsgFlag(AppInterface paramAppInterface, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.IFaceScoreUtils
 * JD-Core Version:    0.7.0.1
 */