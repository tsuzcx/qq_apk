package com.tencent.mobileqq.data;

import com.tencent.TMG.utils.ArrayUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.UinTypesUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class ConversationInfoErrorReporter
{
  @notColumn
  static boolean REPORT_UINTYPE_ERROR = false;
  static HashMap<String, Boolean> mReportUnreadError = new HashMap();
  @notColumn
  public static boolean publicaccountTypeErrorReported = false;
  
  static
  {
    HashMap localHashMap = mReportUnreadError;
    Boolean localBoolean = Boolean.valueOf(false);
    localHashMap.put(" UNREAD ERROR ", localBoolean);
    mReportUnreadError.put(" SUB_ACCOUNT_TROOP_UNREAD ERROR ", localBoolean);
    mReportUnreadError.put(" UNREAD_GIFT_COUNT ERROR ", localBoolean);
    mReportUnreadError.put(" UNREAD_MARK ERROR ", localBoolean);
    mReportUnreadError.put(" UNREAD_RED_PACK ERROR ", localBoolean);
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
    if ((paramInt == 6) || (!ArrayUtils.contains((int[])localObject, paramInt)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" UIN_TYPE ERROR ");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
      IllegalStateException localIllegalStateException = new IllegalStateException((String)localObject);
      if ((REPORT_UINTYPE_ERROR ^ true))
      {
        CaughtExceptionReport.a(localIllegalStateException, (String)localObject);
        REPORT_UINTYPE_ERROR = true;
      }
      QLog.e("ConversationInfo_UinType", 1, paramString, localIllegalStateException);
    }
  }
  
  public static void reportUnreadError(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt > 100000)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(paramString1);
      Object localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = new IllegalStateException((String)localObject2);
      Boolean localBoolean = (Boolean)mReportUnreadError.get(paramString2);
      if (localBoolean == null) {
        return;
      }
      if ((localBoolean.booleanValue() ^ true))
      {
        CaughtExceptionReport.a((Throwable)localObject1, (String)localObject2);
        mReportUnreadError.put(paramString2, Boolean.valueOf(true));
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ConversationInfo_");
      ((StringBuilder)localObject2).append(paramString2);
      QLog.e(((StringBuilder)localObject2).toString(), 1, paramString1, (Throwable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.ConversationInfoErrorReporter
 * JD-Core Version:    0.7.0.1
 */