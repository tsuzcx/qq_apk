package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.api.IQFileDatalineConfigBean;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

public class QFileAssistantUtils
{
  private static final SparseIntArray a = new SparseIntArray();
  
  static
  {
    a.put(65799, 1);
    a.put(67586, 1);
    a.put(68361, 2);
    a.put(72194, 2);
    a.put(65793, 3);
    a.put(81154, 3);
    a.put(68104, 2);
  }
  
  public static int a()
  {
    return 65799;
  }
  
  public static int a(int paramInt)
  {
    int i = a.get(paramInt, 0);
    paramInt = i;
    if (i == 0) {
      paramInt = 3;
    }
    return paramInt;
  }
  
  public static int a(msg_comm.Msg paramMsg)
  {
    int j = 0;
    int i = j;
    im_msg_body.Elem localElem;
    if (paramMsg.msg_body.has())
    {
      i = j;
      if (paramMsg.msg_body.rich_text.has())
      {
        paramMsg = paramMsg.msg_body.rich_text.elems.get().iterator();
        do
        {
          i = j;
          if (!paramMsg.hasNext()) {
            break;
          }
          localElem = (im_msg_body.Elem)paramMsg.next();
        } while ((!localElem.general_flags.has()) || (!localElem.general_flags.bytes_pb_reserve.has()));
      }
    }
    for (;;)
    {
      try
      {
        generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
        localResvAttr.mergeFrom(localElem.general_flags.bytes_pb_reserve.get().toByteArray());
        if (!localResvAttr.uint32_device_type.has()) {
          break label146;
        }
        i = localResvAttr.uint32_device_type.get();
        return i;
      }
      catch (Exception localException) {}
      break;
      label146:
      i = 0;
    }
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    return ((IQFileDatalineConfigBean)QRoute.api(IQFileDatalineConfigBean.class)).getOnlyOfflineLimitSize();
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    paramInt = a(paramInt);
    String str = paramContext.getString(2131698214);
    if (paramInt == 3) {
      str = paramContext.getString(2131698216);
    }
    while (paramInt != 2) {
      return str;
    }
    return paramContext.getString(2131698215);
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    return "3636666661";
  }
  
  public static void a(int paramInt)
  {
    ((DataLineHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).e(paramInt);
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, null);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    String str = ((IQFileConfigManager)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin();
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, ChatActivity.class.getName());
    localIntent = AIOUtils.a(localIntent, new int[] { 1 });
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uintype", 0);
    if (paramIntent != null)
    {
      localIntent.setFlags(paramIntent.getFlags());
      localIntent.putExtras(paramIntent);
      localIntent.setAction(paramIntent.getAction());
      localIntent.setType(paramIntent.getType());
    }
    localIntent.putExtra("entrance", 1);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (a(paramQQAppInterface)) {
      return;
    }
    ((IQFileDatalineConfigBean)QRoute.api(IQFileDatalineConfigBean.class)).setFileAssistantSwitch(true);
    ThreadManagerV2.executeOnFileThread(new QFileAssistantUtils.1(paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    paramQQAppInterface = (DataLineHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (paramInt == 0) {
      paramQQAppInterface.a(paramBoolean);
    }
    while (paramInt != 1) {
      return;
    }
    paramQQAppInterface.b(paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, Bundle paramBundle)
  {
    if (!a(paramQQAppInterface)) {}
    do
    {
      return;
      String str = paramBundle.getString("uin", "");
      if ((!TextUtils.isEmpty(str)) && (AppConstants.DATALINE_PC_UIN.equals(str)))
      {
        paramBundle.putString("uin", "3636666661");
        paramBundle.putInt("uintype", 0);
        paramBundle.putString("uinname", paramQQAppInterface.getApp().getString(2131698224));
      }
      paramQQAppInterface = paramBundle.getString("key_direct_show_uin", "");
    } while ((TextUtils.isEmpty(paramQQAppInterface)) || (!AppConstants.DATALINE_PC_UIN.equals(paramQQAppInterface)));
    paramBundle.putString("key_direct_show_uin", "3636666661");
    paramBundle.putInt("key_direct_show_uin_type", 0);
    paramIntent.putExtra("key_direct_show_uin_type", 0);
    paramIntent.putExtra("key_direct_show_uin", "3636666661");
  }
  
  public static void a(MessageRecord paramMessageRecord, int paramInt)
  {
    String str = paramMessageRecord.getExtInfoFromExtStr("dataline_msg_device_type");
    if (paramInt != 0) {
      str = paramInt + "";
    }
    if ((TextUtils.isEmpty(str)) || (Integer.valueOf(str).intValue() == 0))
    {
      paramMessageRecord.saveExtInfoToExtStr("dataline_msg_device_type", "" + a());
      if (QLog.isColorLevel()) {
        QLog.i("QFileAssistantUtils", 1, "saveMessageDeviceType: mrType[" + paramMessageRecord.msgtype + "] setDefault deviceType[1]");
      }
    }
    do
    {
      return;
      paramMessageRecord.saveExtInfoToExtStr("dataline_msg_device_type", str);
    } while (!QLog.isColorLevel());
    QLog.i("QFileAssistantUtils", 1, "saveMessageDeviceType: mrType[" + paramMessageRecord.msgtype + "] deviceType[" + str + "]");
  }
  
  public static boolean a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = null;
    if ((localAppRuntime instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localAppRuntime;
      IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)localQQAppInterface.getRuntimeService(IQFileConfigManager.class);
      localObject = localQQAppInterface;
      if (localIQFileConfigManager.isAppNull())
      {
        localIQFileConfigManager.onAppInit(localAppRuntime);
        localObject = localQQAppInterface;
      }
    }
    if (localObject != null) {
      return a((QQAppInterface)localObject);
    }
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("file_config_" + localAppRuntime.getAccount(), 4).getString("file_dataline_key", "{}");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.i("QFileAssistantUtils", 1, "loadDatalineConfig: load dataline config. " + (String)localObject);
      return false;
    }
    localObject = ((String)localObject).toLowerCase();
    try
    {
      localObject = new JSONObject((String)localObject);
      if (!((JSONObject)localObject).has("switch")) {
        return false;
      }
      boolean bool = ((JSONObject)localObject).getBoolean("switch");
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QFileAssistantUtils", 1, localException.toString());
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (IQFileConfigManager)paramQQAppInterface.getRuntimeService(IQFileConfigManager.class);
    if (paramQQAppInterface.isAppNull()) {
      paramQQAppInterface.onAppInit(BaseApplicationImpl.getApplication().getRuntime());
    }
    return ((IQFileDatalineConfigBean)QRoute.api(IQFileDatalineConfigBean.class)).getFileAssistantSwitch();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return ((IQFileDatalineConfigBean)QRoute.api(IQFileDatalineConfigBean.class)).getOfflineAutoDownload() >= paramLong;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    boolean bool1 = TextUtils.equals(AppConstants.FILE_ASSISTANT_UIN, paramRecentUser.uin);
    int i;
    if ((TextUtils.equals(AppConstants.DATALINE_PC_UIN, paramRecentUser.uin)) || (TextUtils.equals(AppConstants.DATALINE_IPAD_UIN, paramRecentUser.uin)))
    {
      i = 1;
      if ((bool1) || (i != 0)) {
        break label54;
      }
    }
    label54:
    boolean bool2;
    do
    {
      return false;
      i = 0;
      break;
      bool2 = a(paramQQAppInterface);
      if ((bool1) && (!bool2)) {
        return true;
      }
      if ((bool2) && (i != 0)) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QFileAssistantUtils", 1, "recentUser:" + paramRecentUser.uin + ", isNewVer:" + bool2);
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      IQFileConfigManager localIQFileConfigManager = (IQFileConfigManager)paramQQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
      bool2 = paramString.equals(((IQFileConfigManager)paramQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin());
      bool1 = bool2;
    } while (!bool2);
    a(paramQQAppInterface);
    return bool2;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while ("1".equalsIgnoreCase(paramMessageRecord.getExtInfoFromExtStr("dataline_old_msg"))) {
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.equals(paramString, AppConstants.FILE_ASSISTANT_UIN)) {
      return false;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      return false;
    }
    return a(localQQAppInterface, paramString);
  }
  
  public static int b()
  {
    return ((DataLineHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).d();
  }
  
  public static int b(int paramInt)
  {
    int i = a(paramInt);
    paramInt = 2130844382;
    if (i == 3) {
      paramInt = 2130844376;
    }
    while (i != 2) {
      return paramInt;
    }
    return 2130844371;
  }
  
  public static long b(QQAppInterface paramQQAppInterface)
  {
    return ((IQFileDatalineConfigBean)QRoute.api(IQFileDatalineConfigBean.class)).getDelayStartOfflineTime();
  }
  
  public static void b(Context paramContext, Intent paramIntent)
  {
    Object localObject = ((IQFileConfigManager)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin();
    Intent localIntent = new Intent(paramContext, SplashActivity.class);
    localIntent.putExtra("uin", (String)localObject);
    localIntent.putExtra("uintype", 0);
    localObject = AIOUtils.a(localIntent, null);
    if (paramIntent != null)
    {
      ((Intent)localObject).setFlags(paramIntent.getFlags());
      ((Intent)localObject).putExtras(paramIntent);
      ((Intent)localObject).setAction(paramIntent.getAction());
      ((Intent)localObject).setType(paramIntent.getType());
    }
    paramContext.startActivity((Intent)localObject);
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (DataLineHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    paramQQAppInterface.a(false);
    paramQQAppInterface.b(false);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return ((DataLineHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).b(1);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return a(paramQQAppInterface) >= paramLong;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    boolean bool = true;
    int i = a();
    String str = paramMessageRecord.getExtInfoFromExtStr("dataline_msg_device_type");
    if (TextUtils.isEmpty(str))
    {
      QLog.i("QFileAssistantUtils", 1, "isMessageSender: device type is null, msgType[" + paramMessageRecord.msgtype + "]");
      return false;
    }
    if (a(i) == a(Integer.valueOf(str).intValue())) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.getRecentUserProxy();
    RecentUser localRecentUser = localRecentUserProxy.a(a(paramQQAppInterface), 0);
    localRecentUser.lastmsgtime = MessageCache.a();
    localRecentUserProxy.b(localRecentUser);
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1009);
    }
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (DataLineHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    boolean bool1 = paramQQAppInterface.a();
    boolean bool2 = paramQQAppInterface.b();
    return (bool1) && (bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils
 * JD-Core Version:    0.7.0.1
 */