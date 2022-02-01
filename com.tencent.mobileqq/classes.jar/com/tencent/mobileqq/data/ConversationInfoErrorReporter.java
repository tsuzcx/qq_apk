package com.tencent.mobileqq.data;

import com.tencent.TMG.utils.ArrayUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.UinTypesUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class ConversationInfoErrorReporter
{
  @notColumn
  static boolean REPORT_UINTYPE_ERROR;
  static HashMap<String, Boolean> mReportUnreadError;
  @notColumn
  public static boolean publicaccountTypeErrorReported = false;
  
  static
  {
    mReportUnreadError = new HashMap();
    mReportUnreadError.put(" UNREAD ERROR ", Boolean.valueOf(false));
    mReportUnreadError.put(" SUB_ACCOUNT_TROOP_UNREAD ERROR ", Boolean.valueOf(false));
    mReportUnreadError.put(" UNREAD_GIFT_COUNT ERROR ", Boolean.valueOf(false));
    mReportUnreadError.put(" UNREAD_MARK ERROR ", Boolean.valueOf(false));
    mReportUnreadError.put(" UNREAD_RED_PACK ERROR ", Boolean.valueOf(false));
  }
  
  public static boolean reportPublicaccoutTypeError(String paramString, int paramInt)
  {
    if ((paramInt == 1008) && (!publicaccountTypeErrorReported))
    {
      Object localObject = BaseApplicationImpl.getApplication();
      if (localObject != null)
      {
        localObject = ((BaseApplicationImpl)localObject).getRuntime();
        if (localObject != null)
        {
          paramString = ((FriendsManager)((AppRuntime)localObject).getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramString);
          if ((paramString != null) && (paramString.isFriend()))
          {
            publicaccountTypeErrorReported = true;
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static void reportTypeError(int paramInt, String paramString)
  {
    Object localObject = UinTypesUtil.a();
    IllegalStateException localIllegalStateException;
    if ((paramInt == 6) || (!ArrayUtils.contains((int[])localObject, paramInt)))
    {
      localObject = " UIN_TYPE ERROR " + paramString;
      localIllegalStateException = new IllegalStateException((String)localObject);
      if (!REPORT_UINTYPE_ERROR) {
        break label77;
      }
    }
    label77:
    for (paramInt = 0;; paramInt = 1)
    {
      if (paramInt != 0)
      {
        CaughtExceptionReport.a(localIllegalStateException, (String)localObject);
        REPORT_UINTYPE_ERROR = true;
      }
      QLog.e("ConversationInfo_UinType", 1, paramString, localIllegalStateException);
      return;
    }
  }
  
  public static void reportUnreadError(int paramInt, String paramString1, String paramString2)
  {
    String str;
    IllegalStateException localIllegalStateException;
    Boolean localBoolean;
    if (paramInt > 100000)
    {
      str = paramString2 + paramString1;
      localIllegalStateException = new IllegalStateException(str);
      localBoolean = (Boolean)mReportUnreadError.get(paramString2);
      if (localBoolean != null) {}
    }
    else
    {
      return;
    }
    if (localBoolean.booleanValue()) {}
    for (paramInt = 0;; paramInt = 1)
    {
      if (paramInt != 0)
      {
        CaughtExceptionReport.a(localIllegalStateException, str);
        mReportUnreadError.put(paramString2, Boolean.valueOf(true));
      }
      QLog.e("ConversationInfo_" + paramString2, 1, paramString1, localIllegalStateException);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ConversationInfoErrorReporter
 * JD-Core Version:    0.7.0.1
 */