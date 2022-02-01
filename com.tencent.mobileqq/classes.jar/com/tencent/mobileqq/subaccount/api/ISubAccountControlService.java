package com.tencent.mobileqq.subaccount.api;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.util.Pair;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ISubAccountControlService
  extends IRuntimeService
{
  public static final int ACT_BINDED = 1;
  public static final int ACT_CANCEL_TOP = 5;
  public static final int ACT_DEMAND = 7;
  public static final int ACT_GET_BINDED = 2;
  public static final String ACT_GET_THIRD_QQ_UNREAD_NUM = "getThirdQQUnreadNum";
  public static final int ACT_NEW_MSG = 6;
  public static final int ACT_SET_TOP = 4;
  public static final int ACT_UNBIND = 3;
  public static final int ACT_UNCHANGED = 0;
  public static final String ASSOCIATED_QQ_CACHE_SP = "qq_subaccount_associated_cache";
  public static final long DELAY_TIME = 300L;
  public static final String FAIL_LOCATION = "fail_location";
  public static final String FAIL_STEP = "fail_step";
  public static final int FETCH_C2C_MSG_SCHEDULE_TIME = 1;
  public static final int FETCH_DEFAULT_MSG_SCHEDULE_TIME = 0;
  public static final int FETCH_TROOP_MSG_SCHEDULE_TIME = 2;
  public static final int HINT_BIND_N_QQ = 2;
  public static final int HINT_BIND_QQ_AGAIN = 3;
  public static final int HINT_NOTHING = 0;
  public static final int HINT_SHOW_BIND_DIALOG = 1;
  public static final boolean IS_OPEN_UPLOAD_DATA = true;
  public static final int MAX_SUB_ACCOUNT_NUMBER = 2;
  public static final String PARAM_FAILCODE = "param_FailCode";
  public static final int REQUEST_TIMEOUT = 60000;
  public static final long THIRDQQ_UNREAD_NUM_DELAY_MAX_TIME = 86400L;
  public static final long THIRDQQ_UNREAD_NUM_DELAY_MIN_TIME = 60L;
  public static final long THIRDQQ_UNREAD_NUM_DELAY_TIME = 300L;
  public static final String TVALUE_ACCOUNT_ASSOCIATE = "0X800AC3A";
  public static final String TVALUE_BIND_QQ = "0X8007149";
  public static final String TVALUE_CLEAN_INFO = "0X8007148";
  public static final String TVALUE_CLICK_SUB_ACCOUNT = "0X800714A";
  public static final String TVALUE_MANAGE_ACCOUNT = "0X8007145";
  public static final String TVALUE_SWITCH_ACCOUNT = "0X8007141";
  public static final String TVALUE_SWITCH_ACCOUNT_BY_MSG = "0X8007140";
  public static final String TVALUE_SWITCH_SUB_ACCOUNT = "0X800713F";
  public static final String TVALUE_TOP_RIGHT_MANAGE = "0X8007144";
  public static final String UIN_ALL = "sub.uin.all";
  public static final String UIN_DEFAULT = "sub.uin.default";
  
  public abstract Pair<String, Integer> addHintPair(String paramString, int paramInt);
  
  public abstract void bindRecentItem(AppInterface paramAppInterface, String paramString, int paramInt);
  
  public abstract void cancelHintDialog(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract void cancelTimedMsgTask(AppInterface paramAppInterface, int paramInt);
  
  public abstract void clearAllData(AppInterface paramAppInterface, String paramString);
  
  public abstract String dealSysMsgContent(AppInterface paramAppInterface, String paramString1, int paramInt, String paramString2);
  
  public abstract void destoryHintDialog(Activity paramActivity);
  
  public abstract int getAssociatedQQCacheInt(String paramString);
  
  public abstract String getAssociatedQQCacheString(String paramString);
  
  public abstract String getDateFormate();
  
  public abstract boolean getIsThirdUnreadReqSkip();
  
  public abstract long getLastSpecialCareRequestTime();
  
  public abstract int getReqSubAccountSpecialCareListSysTime(AppInterface paramAppInterface, String paramString1, String paramString2);
  
  public abstract long getSpecialCareReqAdviseGap();
  
  public abstract void getSubAccountSpecialCareList(ArrayList<String> paramArrayList, String paramString);
  
  public abstract byte[] getThirdQQUnreadNumReqCookie(AppInterface paramAppInterface, String paramString);
  
  public abstract long getsTroopDelayTime();
  
  public abstract boolean handleListWaittingHint(String paramString);
  
  public abstract boolean isHeadIconLongClickFunc(boolean paramBoolean);
  
  public abstract void launchTimedMsgTask(AppInterface paramAppInterface, int paramInt);
  
  public abstract void launchTimedThirdQQUnreadNumTask(AppInterface paramAppInterface);
  
  public abstract ArrayList<Pair<String, Integer>> popWaittingHintPair(String paramString);
  
  public abstract boolean putAssociatedQQCache(String paramString, Object paramObject);
  
  public abstract void setBindUinStatus(AppInterface paramAppInterface, byte paramByte, String paramString);
  
  public abstract void setDateFormate(String paramString);
  
  public abstract void setIsThirdUnreadReqSkip(boolean paramBoolean);
  
  public abstract void setLastSpecialCareRequestTime(long paramLong);
  
  public abstract void setTroopDelayTime(long paramLong);
  
  public abstract void showHintDialog(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity, Pair<String, Integer> paramPair, DialogInterface.OnClickListener paramOnClickListener);
  
  public abstract boolean startGetThirdQQUnreadNum(boolean paramBoolean);
  
  public abstract void storeSubAccountSpecialCareList(String paramString1, String paramString2, ArrayList<String> paramArrayList, int paramInt1, int paramInt2);
  
  public abstract void storeThirdQQUnreadInfo(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void storeThirdQQUnreadMsgNumInterval(AppInterface paramAppInterface, String paramString, int paramInt);
  
  public abstract void updateThirdQQUnreadDelayTime(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.ISubAccountControlService
 * JD-Core Version:    0.7.0.1
 */