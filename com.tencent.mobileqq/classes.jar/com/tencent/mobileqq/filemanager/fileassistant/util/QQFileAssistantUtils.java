package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.qfile.IQFileDatalineConfigBean;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm.Msg;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

public class QQFileAssistantUtils
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
    boolean bool = paramMsg.msg_body.has();
    int j = 0;
    int i = j;
    if (bool)
    {
      i = j;
      if (paramMsg.msg_body.rich_text.has()) {
        paramMsg = paramMsg.msg_body.rich_text.elems.get().iterator();
      }
    }
    for (;;)
    {
      i = j;
      im_msg_body.Elem localElem;
      if (paramMsg.hasNext())
      {
        localElem = (im_msg_body.Elem)paramMsg.next();
        if ((!localElem.general_flags.has()) || (!localElem.general_flags.bytes_pb_reserve.has())) {}
      }
      else
      {
        try
        {
          generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
          localResvAttr.mergeFrom(localElem.general_flags.bytes_pb_reserve.get().toByteArray());
          i = j;
          if (localResvAttr.uint32_device_type.has()) {
            i = localResvAttr.uint32_device_type.get();
          }
          return i;
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public static long a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return a(paramBaseQQAppInterface).b();
  }
  
  private static IQFileDatalineConfigBean a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((IQFileConfigManager)paramBaseQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getDatalineConfig();
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    paramInt = a(paramInt);
    String str = paramContext.getString(2131698278);
    if (paramInt == 3) {
      return paramContext.getString(2131698280);
    }
    if (paramInt == 2) {
      str = paramContext.getString(2131698279);
    }
    return str;
  }
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return "3636666661";
  }
  
  public static void a(int paramInt)
  {
    BaseQQAppInterface localBaseQQAppInterface = QQFileManagerUtilImpl.a();
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).setDefaultTarget(localBaseQQAppInterface, paramInt);
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, null);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    String str = ((IQFileConfigManager)QQFileManagerUtilImpl.a().getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin();
    Intent localIntent = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getChatActivityIntent(paramContext);
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
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (a(paramBaseQQAppInterface)) {
      return;
    }
    IQFileDatalineConfigBean localIQFileDatalineConfigBean = a(paramBaseQQAppInterface);
    localIQFileDatalineConfigBean.a(true);
    ThreadManagerV2.executeOnFileThread(new QQFileAssistantUtils.1(localIQFileDatalineConfigBean, paramBaseQQAppInterface));
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, boolean paramBoolean)
  {
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).setFileAssistantOnlineMark(paramBaseQQAppInterface, paramInt, paramBoolean);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, Intent paramIntent, Bundle paramBundle)
  {
    if (!a(paramBaseQQAppInterface)) {
      return;
    }
    String str = paramBundle.getString("uin", "");
    if ((!TextUtils.isEmpty(str)) && (AppConstants.DATALINE_PC_UIN.equals(str)))
    {
      paramBundle.putString("uin", "3636666661");
      paramBundle.putInt("uintype", 0);
      paramBundle.putString("uinname", paramBaseQQAppInterface.getApp().getString(2131698288));
    }
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).setForwardBundle(paramIntent, paramBundle);
  }
  
  public static void a(MessageRecord paramMessageRecord, int paramInt)
  {
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("dataline_msg_device_type");
    if (paramInt != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (Integer.valueOf((String)localObject).intValue() != 0))
    {
      paramMessageRecord.saveExtInfoToExtStr("dataline_msg_device_type", (String)localObject);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveMessageDeviceType: mrType[");
        localStringBuilder.append(paramMessageRecord.msgtype);
        localStringBuilder.append("] deviceType[");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("]");
        QLog.i("QFileAssistantUtils", 1, localStringBuilder.toString());
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(a());
      paramMessageRecord.saveExtInfoToExtStr("dataline_msg_device_type", ((StringBuilder)localObject).toString());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveMessageDeviceType: mrType[");
        ((StringBuilder)localObject).append(paramMessageRecord.msgtype);
        ((StringBuilder)localObject).append("] setDefault deviceType[1]");
        QLog.i("QFileAssistantUtils", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static boolean a()
  {
    Object localObject2 = QQFileManagerUtilImpl.a();
    if ((localObject2 instanceof BaseQQAppInterface)) {
      localObject1 = (BaseQQAppInterface)localObject2;
    } else {
      localObject1 = null;
    }
    if (localObject1 != null) {
      return a((BaseQQAppInterface)localObject1);
    }
    Object localObject1 = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_config_");
    localStringBuilder.append(((AppRuntime)localObject2).getAccount());
    localObject1 = ((BaseApplication)localObject1).getSharedPreferences(localStringBuilder.toString(), 4).getString("file_dataline_key", "{}");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadDatalineConfig: load dataline config. ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("QFileAssistantUtils", 1, ((StringBuilder)localObject2).toString());
      return false;
    }
    localObject1 = ((String)localObject1).toLowerCase();
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      if (!((JSONObject)localObject1).has("switch")) {
        return false;
      }
      boolean bool = ((JSONObject)localObject1).getBoolean("switch");
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QFileAssistantUtils", 1, localException.toString());
    }
    return false;
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramBaseQQAppInterface == null) {
      return false;
    }
    return a(paramBaseQQAppInterface).a();
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    return a(paramBaseQQAppInterface).a() >= paramLong;
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, RecentUser paramRecentUser)
  {
    boolean bool1 = TextUtils.equals(AppConstants.FILE_ASSISTANT_UIN, paramRecentUser.uin);
    int i;
    if ((!TextUtils.equals(AppConstants.DATALINE_PC_UIN, paramRecentUser.uin)) && (!TextUtils.equals(AppConstants.DATALINE_IPAD_UIN, paramRecentUser.uin))) {
      i = 0;
    } else {
      i = 1;
    }
    if ((!bool1) && (i == 0)) {
      return false;
    }
    boolean bool2 = a(paramBaseQQAppInterface);
    if ((bool1) && (!bool2)) {
      return true;
    }
    if ((bool2) && (i != 0)) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("recentUser:");
      paramBaseQQAppInterface.append(paramRecentUser.uin);
      paramBaseQQAppInterface.append(", isNewVer:");
      paramBaseQQAppInterface.append(bool2);
      QLog.i("QFileAssistantUtils", 1, paramBaseQQAppInterface.toString());
    }
    return false;
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool = paramString.equals(((IQFileConfigManager)paramBaseQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin());
    if (bool) {
      a(paramBaseQQAppInterface);
    }
    return bool;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return true;
    }
    return "1".equalsIgnoreCase(paramMessageRecord.getExtInfoFromExtStr("dataline_old_msg"));
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.equals(paramString, AppConstants.FILE_ASSISTANT_UIN)) {
      return false;
    }
    BaseQQAppInterface localBaseQQAppInterface = QQFileManagerUtilImpl.a();
    if (localBaseQQAppInterface == null) {
      return false;
    }
    return a(localBaseQQAppInterface, paramString);
  }
  
  public static int b()
  {
    BaseQQAppInterface localBaseQQAppInterface = (BaseQQAppInterface)QQFileManagerUtilImpl.a();
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getDefaultTarget(localBaseQQAppInterface);
  }
  
  public static int b(int paramInt)
  {
    paramInt = a(paramInt);
    if (paramInt == 3) {
      return 2130844282;
    }
    if (paramInt == 2) {
      return 2130844277;
    }
    return 2130844288;
  }
  
  public static long b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return a(paramBaseQQAppInterface).c();
  }
  
  public static void b(Context paramContext, Intent paramIntent)
  {
    Object localObject = ((IQFileConfigManager)QQFileManagerUtilImpl.a().getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin();
    localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getSplashActivityIntent(paramContext, (String)localObject);
    if (paramIntent != null)
    {
      ((Intent)localObject).setFlags(paramIntent.getFlags());
      ((Intent)localObject).putExtras(paramIntent);
      ((Intent)localObject).setAction(paramIntent.getAction());
      ((Intent)localObject).setType(paramIntent.getType());
    }
    paramContext.startActivity((Intent)localObject);
  }
  
  public static void b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).resetFileAssistantOnlineMark(paramBaseQQAppInterface);
  }
  
  public static boolean b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getIsOnline(paramBaseQQAppInterface);
  }
  
  public static boolean b(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    return a(paramBaseQQAppInterface) >= paramLong;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    int i = a();
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("dataline_msg_device_type");
    boolean bool2 = TextUtils.isEmpty((CharSequence)localObject);
    boolean bool1 = false;
    if (bool2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isMessageSender: device type is null, msgType[");
      ((StringBuilder)localObject).append(paramMessageRecord.msgtype);
      ((StringBuilder)localObject).append("]");
      QLog.i("QFileAssistantUtils", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    if (a(i) == a(Integer.valueOf((String)localObject).intValue())) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static void c(BaseQQAppInterface paramBaseQQAppInterface)
  {
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).notifyUpdateRecentFileAssistant(paramBaseQQAppInterface);
  }
  
  public static boolean c(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).checkNotifyDeviceOnline(paramBaseQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.QQFileAssistantUtils
 * JD-Core Version:    0.7.0.1
 */