package com.tencent.mobileqq.dating;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import appoint.define.appoint_define.AppointID;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ProfilePerformanceReport;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NearByMessageType;

public class DatingUtil
{
  public static Intent a;
  public static String a = "";
  public static String b = "";
  
  public static String a(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = Long.valueOf(NetConnInfoCenter.getServerTimeMillis());
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeInMillis(((Long)localObject1).longValue());
    Object localObject3 = Long.valueOf(paramLong * 1000L);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(((Long)localObject3).longValue());
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(1970, 0, 1, 0, 0, 0);
    long l = localCalendar2.getTime().getTime() - 1000L;
    paramLong = (((Long)localObject1).longValue() - l) / 1000L / 86400L;
    l = (((Long)localObject3).longValue() - l) / 1000L / 86400L;
    int j = 0;
    int i = 0;
    if (l == paramLong)
    {
      i = 2131719716;
    }
    else if (l == paramLong + 1L)
    {
      i = 2131719718;
    }
    else if (l == paramLong + 2L)
    {
      i = 2131689789;
    }
    else if (l == paramLong - 1L)
    {
      i = 2131720491;
    }
    else if (l == paramLong - 2L)
    {
      i = 2131690631;
    }
    else
    {
      j = i;
      if (localCalendar1.get(1) == ((Calendar)localObject2).get(1)) {
        j = 1;
      }
      i = -1;
    }
    if (paramInt == 5)
    {
      if (i != -1) {
        return BaseApplication.getContext().getResources().getString(i);
      }
      if (j == 0)
      {
        if (paramBoolean) {
          localObject1 = "yyyy年M月d日";
        } else {
          localObject1 = "yyyy-MM-dd";
        }
        localObject1 = new SimpleDateFormat((String)localObject1);
      }
      else
      {
        if (paramBoolean) {
          localObject1 = "M月d日";
        } else {
          localObject1 = "MM-dd";
        }
        localObject1 = new SimpleDateFormat((String)localObject1);
      }
      return ((SimpleDateFormat)localObject1).format(localCalendar1.getTime());
    }
    if (i != -1)
    {
      localObject2 = BaseApplication.getContext();
      if (paramBoolean) {
        localObject1 = ",H点m分";
      } else {
        localObject1 = " HH:mm";
      }
      localObject1 = new SimpleDateFormat((String)localObject1);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((Context)localObject2).getResources().getString(i));
      ((StringBuilder)localObject3).append(((SimpleDateFormat)localObject1).format(localCalendar1.getTime()));
      return ((StringBuilder)localObject3).toString();
    }
    if (j == 0)
    {
      if (paramBoolean) {
        localObject1 = "yyyy年M月d日,HH点mm分";
      } else {
        localObject1 = "yyyy-MM-dd HH:mm";
      }
      localObject1 = new SimpleDateFormat((String)localObject1);
    }
    else
    {
      if (paramBoolean) {
        localObject1 = "M月d日,H点m分";
      } else {
        localObject1 = "MM-dd HH:mm";
      }
      localObject1 = new SimpleDateFormat((String)localObject1);
    }
    return ((SimpleDateFormat)localObject1).format(localCalendar1.getTime());
  }
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    paramLong *= 1000L;
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    int i = (int)(l1 / 86400000L);
    int j = (int)(paramLong / 86400000L);
    long l2 = l1 - paramLong;
    int k = (int)l2 / 86400000;
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(l1);
    String str1 = "yyyy年M月d日 H点m分";
    if (k < 0)
    {
      if (!paramBoolean) {
        str1 = "yyyy-MM-dd HH:mm";
      }
      return new SimpleDateFormat(str1).format(localCalendar1.getTime());
    }
    if (k == 0)
    {
      i = (int)(l2 / 3600000L);
      if (i <= 0) {
        return HardCodeUtil.a(2131703027);
      }
      return String.format("%d小时前", new Object[] { Integer.valueOf(i) });
    }
    String str2 = "H点m分";
    if (i == j + 1)
    {
      if (!paramBoolean) {
        str2 = "HH:mm";
      }
      str1 = new SimpleDateFormat(str2).format(localCalendar1.getTime());
      return String.format(HardCodeUtil.a(2131703028), new Object[] { str1 });
    }
    if (i == j + 2)
    {
      if (!paramBoolean) {
        str2 = "HH:mm";
      }
      str1 = new SimpleDateFormat(str2).format(localCalendar1.getTime());
      return String.format(HardCodeUtil.a(2131703029), new Object[] { str1 });
    }
    if (localCalendar1.get(1) == localCalendar2.get(1))
    {
      if (paramBoolean) {
        str1 = "M月d日 H点m分";
      } else {
        str1 = "MM-dd HH:mm";
      }
      return new SimpleDateFormat(str1).format(localCalendar1.getTime());
    }
    if (!paramBoolean) {
      str1 = "yyyy-MM-dd HH:mm";
    }
    return new SimpleDateFormat(str1).format(localCalendar1.getTime());
  }
  
  public static String a(appoint_define.AppointID paramAppointID)
  {
    if ((paramAppointID != null) && (paramAppointID.str_request_id != null) && (paramAppointID.str_request_id.has())) {
      return paramAppointID.str_request_id.get();
    }
    return null;
  }
  
  public static im_msg_body.Elem a(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord.istroop == 1010) || (paramMessageRecord.istroop == 1001)) && ((paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -2000)) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("nearby_clearing_msg"))))
    {
      im_msg_body.NearByMessageType localNearByMessageType = new im_msg_body.NearByMessageType();
      if (paramMessageRecord.msgtype == -1000)
      {
        localNearByMessageType.uint32_type.set(1);
      }
      else
      {
        if (paramMessageRecord.msgtype != -2000) {
          break label117;
        }
        localNearByMessageType.uint32_type.set(2);
      }
      paramMessageRecord = new im_msg_body.Elem();
      paramMessageRecord.near_by_msg.set(localNearByMessageType);
      return paramMessageRecord;
    }
    label117:
    return null;
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    paramActivity.runOnUiThread(new DatingUtil.1(paramActivity, paramString));
  }
  
  public static void a(Context paramContext, long paramLong, String paramString1, byte[] paramArrayOfByte, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    a("openDatingProfileCard", new Object[] { paramContext, Long.valueOf(paramLong), paramString1, paramArrayOfByte, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    ProfilePerformanceReport.a();
    AllInOne localAllInOne = new AllInOne(String.valueOf(0), 75);
    localAllInOne.nickname = paramString2;
    localAllInOne.age = paramInt2;
    localAllInOne.gender = ((byte)paramInt3);
    localAllInOne.chatCookie = paramArrayOfByte;
    localAllInOne.profileEntryType = paramInt1;
    paramArrayOfByte = new Intent();
    paramArrayOfByte.putExtra("AllInOne", localAllInOne);
    paramArrayOfByte.putExtra("param_mode", 3);
    paramArrayOfByte.putExtra("param_tiny_id", paramLong);
    paramArrayOfByte.putExtra("param_dating_id", paramString1);
    paramArrayOfByte.putExtra("param_dating_subject", paramInt4);
    paramArrayOfByte.putExtra("param_dating_pub", paramBoolean);
    paramContext.startActivity(paramArrayOfByte);
    RouteUtils.a(paramContext, paramArrayOfByte, "/nearby/people/profile");
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    if (((paramMessageRecord.istroop == 1010) || (paramMessageRecord.istroop == 1001)) && ((paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -2000)))
    {
      paramMessageRecord.saveExtInfoToExtStr("nearby_clearing_msg", "true");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setClearingMessage|istroop:");
        localStringBuilder.append(paramMessageRecord.istroop);
        localStringBuilder.append(",msgType:");
        localStringBuilder.append(paramMessageRecord.msgtype);
        QLog.d("Q.nearby_bank", 2, localStringBuilder.toString());
      }
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs) {}
  
  public static boolean a()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    TelephonyManager localTelephonyManager = (TelephonyManager)localBaseApplication.getSystemService("phone");
    if (localTelephonyManager != null) {}
    try
    {
      localCellLocation = localTelephonyManager.getCellLocation();
      i = localTelephonyManager.getSimState();
      if (i == 5) {
        i = 1;
      } else {
        i = 0;
      }
    }
    catch (Exception localException1)
    {
      CellLocation localCellLocation;
      int i;
      boolean bool;
      int j;
      label60:
      return true;
    }
    try
    {
      bool = TextUtils.isEmpty(DeviceInfoUtil.b());
      j = bool ^ true;
    }
    catch (Exception localException2)
    {
      break label60;
    }
    j = 1;
    if ((i != 0) && (j != 0) && (localCellLocation == null))
    {
      bool = a(localBaseApplication);
      if (!bool) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    try
    {
      i = Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on");
      if (i == 1) {
        bool = true;
      }
      return bool;
    }
    catch (Settings.SettingNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    String str = paramMessage.extStr;
    boolean bool3 = false;
    boolean bool1;
    if (str != null) {
      try
      {
        bool1 = new JSONObject(paramMessage.extStr).optBoolean("one_way");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    } else {
      bool1 = false;
    }
    paramQQAppInterface = paramQQAppInterface.getConversationFacade();
    boolean bool2 = bool3;
    if (paramQQAppInterface != null)
    {
      bool2 = bool3;
      if (paramQQAppInterface.a(paramMessage.istroop) > 0)
      {
        bool2 = bool3;
        if (bool1) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return true;
    }
    return paramQQAppInterface.getMessageFacade().getLastMessage(paramString, 1010).hasReply;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramQQAppInterface = paramQQAppInterface.getConversationFacade();
    return (paramQQAppInterface != null) && (paramQQAppInterface.f(paramString, paramInt) > 0);
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(", [");
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramVarArgs[i]);
        localStringBuilder.append(",");
        i += 1;
      }
      localStringBuilder.append("]");
      QLog.i("Q.dating", 2, localStringBuilder.toString());
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramString = paramQQAppInterface.getHotChatMng(true).a(paramString);
    if (paramString != null)
    {
      paramQQAppInterface = ((WerewolvesHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a("");
      if ((paramString.isGameRoom) || (paramString.troopUin.equals(paramQQAppInterface.a))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramQQAppInterface = paramQQAppInterface.getConversationFacade();
    return (paramQQAppInterface != null) && (paramQQAppInterface.e(paramString, paramInt) > 0);
  }
  
  public static void c(String paramString, Object... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingUtil
 * JD-Core Version:    0.7.0.1
 */