import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.app.AvAddFriendService;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.redpacket.config.AVRedPacketConfigManager;
import com.tencent.av.service.IAVRedPacketCallback;
import com.tencent.av.service.IQQServiceCallback;
import com.tencent.av.service.IQQServiceForAV.Stub;
import com.tencent.av.service.IQQServiceLocationCallback;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.service.UtilsServiceForAV;
import com.tencent.av.utils.UITools;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.QavVideoDownloadHandler;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcall.OpenSDKUtils;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnSwitchConfig;
import com.tencent.mobileqq.qcall.QCallCardHandler;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.qcall.QCallCardManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.TroopGagInfo;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class jpn
  extends IQQServiceForAV.Stub
{
  public jpn(QQServiceForAV paramQQServiceForAV) {}
  
  private String a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("appID", paramAppInfo.uiAppId.get());
      localJSONObject1.put("iNewFlag", paramAppInfo.iNewFlag.get());
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < paramAppInfo.missions.size())
      {
        localJSONArray.put(paramAppInfo.missions.get(i));
        i += 1;
      }
      List localList = paramAppInfo.red_display_info.red_type_info.get();
      JSONObject localJSONObject2 = new JSONObject();
      if (localList != null)
      {
        i = 0;
        while (i < localList.size())
        {
          localJSONObject2.put("red_type", ((BusinessInfoCheckUpdate.RedTypeInfo)localList.get(i)).red_type.get());
          localJSONObject2.put("red_content", ((BusinessInfoCheckUpdate.RedTypeInfo)localList.get(i)).red_content.get());
          localJSONObject2.put("red_desc", ((BusinessInfoCheckUpdate.RedTypeInfo)localList.get(i)).red_desc.get());
          i += 1;
        }
      }
      localJSONObject1.put("red_type_info", localJSONObject2);
      localJSONObject1.put("missions", localJSONArray);
      localJSONObject1.put("type", paramAppInfo.type.get());
      localJSONObject1.put("buffer", paramAppInfo.buffer.get());
      localJSONObject1.put("path", paramAppInfo.path.get());
      localJSONObject1.put("appset", paramAppInfo.appset.get());
      localJSONObject1.put("modify_ts", paramAppInfo.modify_ts.get());
      localJSONObject1.put("num", paramAppInfo.num.get());
      localJSONObject1.put("push_red_ts", paramAppInfo.push_red_ts.get());
      paramAppInfo = localJSONObject1.toString();
      return paramAppInfo;
    }
    catch (Exception paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
    return "";
  }
  
  private void a(IBinder paramIBinder)
  {
    Intent localIntent = new Intent(this.a.getApplicationContext(), UtilsServiceForAV.class);
    this.a.getApplicationContext().stopService(localIntent);
    if (QQServiceForAV.jdField_a_of_type_AndroidOsIBinder == null)
    {
      AVLog.d("QQServiceForAV", "linkToVideoProcessDeath");
      QQServiceForAV.jdField_a_of_type_AndroidOsIBinder = paramIBinder;
    }
    try
    {
      QQServiceForAV.jdField_a_of_type_AndroidOsIBinder.linkToDeath(new jpp(this), 0);
      return;
    }
    catch (RemoteException paramIBinder)
    {
      QQServiceForAV.jdField_a_of_type_AndroidOsIBinder = null;
      AVLog.e("QQServiceForAV", "linkToVideoProcessDeath exception msg = " + paramIBinder.getMessage());
    }
  }
  
  public int a()
  {
    return ((PhoneContactManager)((QQAppInterface)this.a.a()).getManager(10)).c();
  }
  
  public int a(int paramInt, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    int i;
    if (paramInt == 1) {
      i = QAVGroupConfig.c(localQQAppInterface, paramString);
    }
    for (;;)
    {
      QLog.w("QQServiceForAV", 1, "getGroupMemberNum, relationType[" + paramInt + "], uin[" + paramString + "], 成员数[" + i + "]");
      return i;
      if (paramInt == 2) {
        i = ((DiscussionManager)localQQAppInterface.getManager(52)).a(paramString);
      } else {
        i = 0;
      }
    }
  }
  
  public int a(String paramString)
  {
    return ((QQAppInterface)this.a.a()).a().a(paramString);
  }
  
  public long a(String paramString)
  {
    paramString = ((DiscussionManager)((QQAppInterface)this.a.a()).getManager(52)).a(paramString);
    long l = 0L;
    if (paramString != null) {
      l = paramString.mOrigin;
    }
    return l;
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "getFaceBitmap uinType = " + paramInt + ", uin = " + paramString1 + ", extraUin = " + paramString2 + ", isRound = " + paramBoolean1);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    byte b;
    if (paramBoolean1)
    {
      b = 3;
      switch (paramInt)
      {
      default: 
        paramString2 = localQQAppInterface.a(paramString1, b, true);
      }
    }
    for (;;)
    {
      if (paramString2 == null)
      {
        if (!this.a.jdField_b_of_type_JavaUtilArrayList.contains(paramString1)) {
          this.a.jdField_b_of_type_JavaUtilArrayList.add(paramString1);
        }
        localQQAppInterface.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      }
      if ((paramString2 == null) && (paramBoolean2))
      {
        if (QLog.isColorLevel()) {
          QLog.w("QQServiceForAV", 2, "getFaceBitmap failed, use default face!");
        }
        if (paramInt == 1)
        {
          return ImageUtil.f();
          b = 1;
          break;
          paramString2 = localQQAppInterface.a(paramString1, b, true);
          continue;
          paramString2 = localQQAppInterface.a(paramString1, b, false, false);
          continue;
          paramString2 = (BitmapDrawable)((DiscussionHandler)localQQAppInterface.a(6)).a(paramString1, false);
          if (paramString2 == null) {
            break label584;
          }
          paramString2 = paramString2.getBitmap();
          continue;
          if (paramString1.startsWith("+")) {
            break label579;
          }
        }
      }
      for (;;)
      {
        paramString2 = FaceDrawable.b(localQQAppInterface, paramString2, b).a();
        break;
        paramString2 = FaceDrawable.a(localQQAppInterface, 200, paramString1, true).a();
        break;
        paramString2 = ((SmartDeviceProxyMgr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(51)).a(Long.parseLong(paramString1));
        paramString2 = DeviceHeadMgr.getInstance().getDeviceHeadByPID(paramString2.productId);
        break;
        Object localObject = (PhoneContactManager)localQQAppInterface.getManager(10);
        if ((localObject != null) && (paramString2 != null)) {}
        for (localObject = ((PhoneContactManager)localObject).c(paramString2);; localObject = null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQServiceForAV", 2, "getFaceBitmap contact = " + localObject);
          }
          if (localObject != null)
          {
            paramString2 = FaceDrawable.b(localQQAppInterface, paramString2, b).a();
            break;
          }
          paramString2 = localQQAppInterface.a(16, paramString1, (byte)3, true, 16);
          break;
          paramString2 = OpenSDKUtils.a(localQQAppInterface, paramString2);
          break;
          if (paramInt == 3000) {
            return ImageUtil.h();
          }
          return ImageUtil.a();
          return paramString2;
        }
        label579:
        paramString2 = paramString1;
      }
      label584:
      paramString2 = null;
    }
  }
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    boolean bool2 = false;
    boolean bool1;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("requestEvent, mainCmd[").append(paramInt1).append("], subType[").append(paramInt2).append("], seq[").append(paramInt3).append("], buf[");
      if (paramArrayOfByte == null) {
        break label158;
      }
      bool1 = true;
      paramArrayOfByte = localStringBuilder.append(bool1).append("], bundle[");
      bool1 = bool2;
      if (paramBundle != null) {
        bool1 = true;
      }
      QLog.d("QQServiceForAV", 1, bool1 + "]");
      AudioHelper.a("requestEvent", paramBundle);
    }
    switch (paramInt1)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      for (;;)
      {
        return null;
        bool1 = false;
        break;
        new Handler(Looper.getMainLooper()).postDelayed(new jpq(this, paramBundle), 1L);
        continue;
        new Handler(Looper.getMainLooper()).postDelayed(new jpr(this, paramBundle, paramResultReceiver), 1L);
        continue;
        if (paramBundle != null)
        {
          paramArrayOfByte = paramBundle.getString("uin");
          paramResultReceiver = (QQAppInterface)this.a.a();
          bool1 = QAVGroupConfig.a("GetInviteFlag", paramResultReceiver, paramArrayOfByte);
          QAVGroupConfig.a("GetInviteFlag", paramResultReceiver, paramArrayOfByte);
          paramBundle.putBoolean("enableInvite", bool1);
          return paramBundle;
          QAVHrMeeting.a((QQAppInterface)this.a.a(), paramBundle);
        }
      }
    case 5: 
      label158:
      return QAVHrMeeting.a((QQAppInterface)this.a.a(), paramBundle);
    }
    return QAVGroupConfig.a((QQAppInterface)this.a.a(), paramBundle);
  }
  
  public Bundle a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "getDataFromMainProcess cmd = " + paramInt1 + ",subCmd = " + paramInt2 + ",request = " + paramBundle);
    }
    switch (paramInt1)
    {
    default: 
      return null;
    }
    paramBundle = paramBundle.getString("input");
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "getDataFromMainProcess cmd = " + paramInt1 + ",subCmd = " + paramInt2 + ",inputString = " + paramBundle);
    }
    paramBundle = new Bundle();
    paramBundle.putString("output", "msg from main process");
    return paramBundle;
  }
  
  public String a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    return ((TicketManager)localQQAppInterface.getManager(2)).getSkey(localQQAppInterface.getCurrentAccountUin());
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    String str2 = "";
    String str1 = paramString1;
    if (paramString1 != null) {
      str1 = paramString1.trim();
    }
    paramString1 = str2;
    QQAppInterface localQQAppInterface;
    if (!TextUtils.isEmpty(str1))
    {
      localQQAppInterface = (QQAppInterface)this.a.a();
      if (paramInt != 1006) {
        break label120;
      }
    }
    try
    {
      paramString1 = a(localQQAppInterface, str1, paramString2);
      for (;;)
      {
        QLog.w("QQServiceForAV", 1, "getDisplayName, uinType[" + paramInt + "], uin[" + str1 + "], extraUin[" + paramString2 + "], name[" + paramString1 + "]");
        return paramString1;
        label120:
        if (paramInt == 26)
        {
          paramString1 = OpenSDKUtils.a(localQQAppInterface, paramString2);
        }
        else if (paramInt == 25)
        {
          paramString1 = b(localQQAppInterface, str1, paramString2);
        }
        else if (paramInt == 1)
        {
          if (!TextUtils.isEmpty(paramString2)) {
            paramString1 = ContactUtils.g(localQQAppInterface, str1, paramString2);
          } else {
            paramString1 = ContactUtils.a(localQQAppInterface, str1, false);
          }
        }
        else
        {
          if (paramInt != 9500) {
            break;
          }
          paramString1 = ((SmartDeviceProxyMgr)localQQAppInterface.a(51)).a(Long.parseLong(str1));
          if (paramString1 == null) {
            break label459;
          }
          paramString1 = SmartDeviceUtil.a(paramString1);
        }
      }
      int i = ContactUtils.a(paramInt);
      if (i == -1) {}
      for (paramString1 = ContactUtils.b(localQQAppInterface, str1, paramInt);; paramString1 = ContactUtils.a(localQQAppInterface, str1, paramString2, i, 0))
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          str2 = paramString1;
          if (!str1.equals(paramString1)) {}
        }
        else
        {
          str2 = ContactUtils.b(localQQAppInterface, str1, true);
        }
        paramString1 = str2;
        if (TextUtils.isEmpty(str2)) {
          paramString1 = str1;
        }
        localObject = paramString1;
        if (!str1.equals(paramString1)) {
          break;
        }
        localObject = (FriendsManager)localQQAppInterface.getManager(50);
        str2 = paramString1;
        if (localObject != null)
        {
          localObject = ((FriendsManager)localObject).c(str1);
          str2 = paramString1;
          if (localObject != null) {
            str2 = ContactUtils.a((Friends)localObject);
          }
        }
        if (!str1.equals(str2))
        {
          localObject = str2;
          if (!TextUtils.isEmpty(str2)) {
            break;
          }
        }
        paramString1 = (FriendListHandler)localQQAppInterface.a(1);
        localObject = str2;
        if (paramString1 == null) {
          break;
        }
        this.a.jdField_a_of_type_JavaUtilArrayList.add(str1);
        localQQAppInterface.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        paramString1.b(str1);
        localObject = str2;
        break;
      }
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        Object localObject;
        QLog.d("QQServiceForAV", 1, "getDisplayName", paramString1);
        paramString1 = "";
        continue;
        label459:
        paramString1 = str1;
        continue;
        paramString1 = (String)localObject;
      }
    }
  }
  
  String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    String str = "";
    Object localObject1;
    if (!paramString1.startsWith("+"))
    {
      localObject1 = str;
      if (paramString2 != null)
      {
        localObject1 = str;
        if (!paramString2.startsWith("+")) {}
      }
    }
    for (str = paramString2;; str = paramString1)
    {
      localObject1 = (PhoneContactManager)paramQQAppInterface.getManager(10);
      if (localObject1 != null) {}
      for (localObject1 = ((PhoneContactManager)localObject1).c(str);; localObject1 = null)
      {
        if (localObject1 != null)
        {
          localObject1 = ((PhoneContact)localObject1).name;
          return localObject1;
        }
        localObject1 = ContactUtils.g(paramQQAppInterface, str);
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          if (!paramString1.startsWith("+")) {
            break label256;
          }
          if ((paramString2 == null) || (paramString2.startsWith("+"))) {
            break label239;
          }
          paramString1 = paramString2;
        }
        label256:
        for (;;)
        {
          label124:
          localObject2 = paramString1;
          if (paramString1 != null)
          {
            ContactUtils.a(paramQQAppInterface, str, paramString1);
            localObject2 = paramString1;
          }
          if (localObject2 != null)
          {
            paramString1 = (FriendsManager)paramQQAppInterface.getManager(50);
            if (paramString1 == null) {
              break label251;
            }
          }
          label239:
          label251:
          for (paramString1 = paramString1.c((String)localObject2);; paramString1 = null)
          {
            if (paramString1 != null) {}
            for (paramString1 = ContactUtils.a(paramString1);; paramString1 = null)
            {
              if ((paramString1 == null) || (paramString1.equals(localObject2)))
              {
                paramString1 = (FriendListHandler)paramQQAppInterface.a(1);
                localObject1 = str;
                if (paramString1 == null) {
                  break;
                }
                this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
                paramQQAppInterface.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
                paramString1.b((String)localObject2);
                return str;
                paramString1 = null;
                break label124;
              }
              return paramString1;
            }
          }
        }
      }
    }
  }
  
  public String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)((QQAppInterface)this.a.a()).getManager(10);
    if (localPhoneContactManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "getPhoneNameByPhoneNum --> can not get PhoneContactManager");
      }
      return null;
    }
    paramString = localPhoneContactManager.b(paramString);
    if ((paramString == null) || (paramString.name == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "getPhoneNameByPhoneNum --> can not get phoneContact Or Name");
      }
      return null;
    }
    return paramString.name;
  }
  
  public void a()
  {
    Object localObject = new StringBuilder().append("stopPumpMessage, monbind[").append(this.a.jdField_b_of_type_Boolean).append("], IBinder[");
    if (QQServiceForAV.jdField_a_of_type_AndroidOsIBinder != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("QQServiceForAV", 1, bool + "]");
      QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
      localObject = localQQAppInterface;
      if (localQQAppInterface == null) {
        localObject = (QQAppInterface)this.a.a();
      }
      ((QQAppInterface)localObject).a().deleteObserver(this.a);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = (EarlyDownloadManager)QQServiceForAV.d(this.a).getManager(76);
    if (localObject != null)
    {
      QavSoDownloadHandler localQavSoDownloadHandler = (QavSoDownloadHandler)((EarlyDownloadManager)localObject).a(QavSoDownloadHandler.e());
      if (localQavSoDownloadHandler != null) {
        localQavSoDownloadHandler.a(false);
      }
    }
    if (localObject != null)
    {
      localObject = (QavVideoDownloadHandler)((EarlyDownloadManager)localObject).a("qq.android.qav.video");
      if (localObject != null) {
        ((QavVideoDownloadHandler)localObject).a(false);
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    TroopHandler localTroopHandler = (TroopHandler)localQQAppInterface.a(20);
    if (localTroopHandler != null) {}
    while (!QLog.isColorLevel()) {
      try
      {
        QLog.w("QQServiceForAV", 1, "requestGrayVideoWebViewConfig, identity[" + paramInt1 + "], guin[" + paramLong + "], clientId[" + paramInt2 + "], appVersion[" + paramInt3 + "]");
        localQQAppInterface.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        localTroopHandler.a(paramInt1, paramLong);
        return;
      }
      catch (Exception localException)
      {
        do
        {
          localQQAppInterface.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        } while (!QLog.isColorLevel());
        QLog.e("QQServiceForAV", 2, "requestGrayVideoWebViewConfig-->error,e=" + localException.getMessage());
        return;
      }
    }
    QLog.e("QQServiceForAV", 2, "requestGrayVideoWebViewConfig-->can not get TroopHandle");
  }
  
  public void a(int paramInt, String paramString)
  {
    QQAppInterface localQQAppInterface2 = (QQAppInterface)this.a.a();
    QQAppInterface localQQAppInterface1 = localQQAppInterface2;
    if (localQQAppInterface2 == null) {
      localQQAppInterface1 = (QQAppInterface)this.a.a();
    }
    this.a.jdField_a_of_type_Int = paramInt;
    this.a.jdField_b_of_type_JavaLangString = paramString;
    this.a.jdField_b_of_type_Long = MessageCache.a();
    localQQAppInterface1.a().addObserver(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "startPumpMessage uinType = " + paramInt + ", peerUin = " + paramString + ",mStartTime:" + this.a.jdField_b_of_type_Long);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    this.a.jdField_a_of_type_Int = paramInt;
    this.a.jdField_b_of_type_JavaLangString = paramString1;
    this.a.d = paramString2;
    this.a.jdField_b_of_type_Long = MessageCache.a();
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "setPeerInfo uinType = " + paramInt + ", peerUin = " + paramString1 + ", extraUin = " + paramString2 + ",mStartTime:" + this.a.jdField_b_of_type_Long);
    }
  }
  
  public void a(long paramLong)
  {
    ((QQAppInterface)this.a.a()).a().b(paramLong);
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "reportGVideoOnlineTime uin = " + paramLong + " troopuin = " + paramString + " onlineTime" + paramInt);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    localQQAppInterface.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    TroopHandler localTroopHandler = (TroopHandler)localQQAppInterface.a(20);
    if (localTroopHandler != null) {
      try
      {
        localTroopHandler.a(paramLong, Long.parseLong(paramString), paramInt);
        return;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo NumberFormatException !", paramString);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo-->can not get TroopHandle");
    }
    localQQAppInterface.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (localQQAppInterface != null) {
      localQQAppInterface.a().a(paramLong1, paramString, paramLong2);
    }
  }
  
  public void a(IAVRedPacketCallback paramIAVRedPacketCallback)
  {
    ((AVRedPacketConfigManager)QQServiceForAV.b(this.a).getManager(253)).b(paramIAVRedPacketCallback);
  }
  
  public void a(IQQServiceCallback paramIQQServiceCallback)
  {
    if (paramIQQServiceCallback != null) {
      this.a.jdField_a_of_type_AndroidOsRemoteCallbackList.unregister(paramIQQServiceCallback);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "unregisterCallback");
    }
    ((QQAppInterface)this.a.a()).a = null;
  }
  
  public void a(IQQServiceCallback paramIQQServiceCallback, String paramString)
  {
    if (paramIQQServiceCallback != null)
    {
      this.a.jdField_a_of_type_AndroidOsRemoteCallbackList.register(paramIQQServiceCallback, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "registerCallback");
      }
      a(paramIQQServiceCallback.asBinder());
      paramIQQServiceCallback = (QQAppInterface)this.a.a();
      paramIQQServiceCallback.a = null;
      paramIQQServiceCallback.a = new WeakReference(this.a);
    }
  }
  
  public void a(IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    if (paramIQQServiceLocationCallback == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "getAddressConfig IQQServiceLocationCallback is null");
      }
      return;
    }
    Object localObject = (QQAppInterface)this.a.a();
    localObject = (ConditionSearchManager)QQServiceForAV.a(this.a).getManager(58);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "getAddressConfig for IQQServiceLocationCallback");
      }
      if (((ConditionSearchManager)localObject).a() == 1)
      {
        if (((ConditionSearchManager)localObject).a(((ConditionSearchManager)localObject).a(), true) == 0)
        {
          if (QQServiceForAV.a(this.a) == null) {
            QQServiceForAV.a(this.a, new jpl(this, (ConditionSearchManager)localObject, paramIQQServiceLocationCallback));
          }
          for (;;)
          {
            ((ConditionSearchManager)localObject).c(QQServiceForAV.a(this.a));
            return;
            QQServiceForAV.a(this.a).a(paramIQQServiceLocationCallback);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceForAV", 2, "ConditionSearchManager update RESULT_UPDATE_REMOTE fail");
        }
        a(false, paramIQQServiceLocationCallback);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "ConditionSearchManager config exist");
      }
      a(true, paramIQQServiceLocationCallback);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "Get ConditionSearchManager null");
    }
    a(false, paramIQQServiceLocationCallback);
  }
  
  public void a(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    NearbyCardHandler localNearbyCardHandler = (NearbyCardHandler)localQQAppInterface.a(60);
    localQQAppInterface.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardObserver);
    localNearbyCardHandler.a(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    ProtoUtils.a((QQAppInterface)this.a.a(), new jpo(this, paramString, paramInt2), paramArrayOfByte, paramString, paramInt1, paramInt2);
  }
  
  public void a(String paramString, long paramLong)
  {
    Object localObject = (AIOAnimationControlManager)((QQAppInterface)this.a.a()).getManager(222);
    if (localObject != null) {
      ((AIOAnimationControlManager)localObject).a(paramString);
    }
    if ((paramLong > 0L) && ((QQServiceForAV.g(this.a) instanceof QQAppInterface)))
    {
      localObject = (QQAppInterface)QQServiceForAV.h(this.a);
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_JavaLangString = paramString;
      localSessionInfo.jdField_a_of_type_Int = 1;
      ChatActivityFacade.a((QQAppInterface)localObject, localSessionInfo);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "sendMessageToTroop");
    }
    paramString2 = (QQAppInterface)this.a.a();
    if (paramString2 == null)
    {
      paramString1 = (QQAppInterface)this.a.a();
      return;
    }
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    long l = MessageCache.a();
    localMessageRecord.init(paramString2.getCurrentAccountUin(), paramString3, paramString2.getCurrentAccountUin(), paramString1, l, -1000, 1, l);
    localMessageRecord.issend = 1;
    paramString2.a().a(localMessageRecord, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (("1".equals(paramString3)) || ("2".equals(paramString3))) {
      this.a.a(paramString1, paramString2, paramString3, paramInt);
    }
    while (!"3".equals(paramString3)) {
      return;
    }
    this.a.a(paramString1);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "listenTroopListUpdate bListen = " + paramBoolean);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (localQQAppInterface != null)
    {
      if (paramBoolean) {
        localQQAppInterface.addObserver(QQServiceForAV.a(this.a));
      }
    }
    else {
      return;
    }
    localQQAppInterface.removeObserver(QQServiceForAV.a(this.a));
  }
  
  public void a(boolean paramBoolean, IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    }
    try
    {
      for (;;)
      {
        paramIQQServiceLocationCallback.a(i, "admin_region_config");
        return;
        i = -26;
      }
    }
    catch (RemoteException paramIQQServiceLocationCallback)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceForAV", 2, "Call onGetAddressConfig fail", paramIQQServiceLocationCallback);
    }
  }
  
  public void a(long[] paramArrayOfLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "getGVideoLevelInfo uins = " + paramArrayOfLong.toString() + " troopuin = " + paramString);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    localQQAppInterface.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    TroopHandler localTroopHandler = (TroopHandler)localQQAppInterface.a(20);
    if (localTroopHandler != null) {
      try
      {
        localTroopHandler.a(paramArrayOfLong, Long.parseLong(paramString));
        return;
      }
      catch (NumberFormatException paramArrayOfLong)
      {
        QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo NumberFormatException !", paramArrayOfLong);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "getGVideoLevelInfo-->can not get TroopHandle");
    }
    localQQAppInterface.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public boolean a()
  {
    return ((QQAppInterface)this.a.a()).isBackground_Pause;
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return ((QQAppInterface)this.a.a()).a().a(paramInt, paramLong) > 0L;
  }
  
  public boolean a(long paramLong)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    TroopHandler localTroopHandler = (TroopHandler)localQQAppInterface.a(20);
    if (localTroopHandler != null) {
      try
      {
        QLog.w("QQServiceForAV", 1, "getAdminMemberList, troopUin[" + paramLong + "]");
        localQQAppInterface.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        localTroopHandler.a(paramLong, 0L, 2, 0, 0);
        return true;
      }
      catch (Exception localException)
      {
        localQQAppInterface.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        QLog.w("QQServiceForAV", 1, "getAdminMemberList Exception, troopUin[" + paramLong + "]", localException);
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w("QQServiceForAV", 1, "getAdminMemberList null, troopUin[" + paramLong + "]");
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return ((FriendsManager)((QQAppInterface)this.a.a()).getManager(50)).b(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    paramString = ((DiscussionManager)((QQAppInterface)this.a.a()).getManager(52)).a(paramString);
    if (paramString != null)
    {
      paramString.mOrigin = paramInt;
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    FMTransC2CMsgInfo localFMTransC2CMsgInfo = new FMTransC2CMsgInfo();
    localFMTransC2CMsgInfo.subCmd = paramInt2;
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "send0x211C2CMsg");
    }
    return localQQAppInterface.a().a().a(paramString, paramInt1, paramArrayOfByte, localFMTransC2CMsgInfo);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "queryTroopMember troopUin = " + paramString1 + "memUin:" + paramString2);
    }
    Object localObject = (QQAppInterface)this.a.a();
    if (localObject != null)
    {
      localObject = (TroopManager)((QQAppInterface)localObject).getManager(51);
      if ((localObject != null) && (((TroopManager)localObject).b(paramString1, paramString2) == null)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    localQQAppInterface.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    TroopHandler localTroopHandler = (TroopHandler)localQQAppInterface.a(20);
    if (localTroopHandler != null) {
      try
      {
        localTroopHandler.f(paramString, paramBoolean);
        return true;
      }
      catch (Exception paramString)
      {
        localQQAppInterface.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
        QLog.e("QQServiceForAV", 2, "joinOrExitOpenTroop-->error,e=" + paramString.getMessage());
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "joinOrExitOpenTroop-->can not get TroopHandle");
    }
    localQQAppInterface.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    return false;
  }
  
  public int[] a()
  {
    Object localObject = (QQAppInterface)this.a.a();
    int[] arrayOfInt = new int[3];
    localObject = (PstnManager)((QQAppInterface)localObject).getManager(142);
    if (localObject != null)
    {
      arrayOfInt[0] = ((PstnManager)localObject).a().e;
      arrayOfInt[1] = ((PstnManager)localObject).a().f;
      arrayOfInt[2] = ((PstnManager)localObject).a().g;
    }
    return arrayOfInt;
  }
  
  public long[] a(String paramString)
  {
    paramString = ((DiscussionManager)((QQAppInterface)this.a.a()).getManager(52)).a(paramString);
    if (paramString != null)
    {
      int j = paramString.size();
      long[] arrayOfLong = new long[j];
      int i = 0;
      while (i < j)
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramString.get(i);
        if (localDiscussionMemberInfo != null) {
          arrayOfLong[i] = Long.valueOf(localDiscussionMemberInfo.memberUin).longValue();
        }
        i += 1;
      }
      return arrayOfLong;
    }
    return null;
  }
  
  public String[] a(String paramString)
  {
    Object localObject = (QQAppInterface)this.a.a();
    if (localObject != null)
    {
      localObject = (TroopManager)((QQAppInterface)localObject).getManager(51);
      if (localObject != null)
      {
        paramString = ((TroopManager)localObject).a(paramString);
        if (paramString == null) {
          return new String[0];
        }
        if (!TextUtils.isEmpty(paramString.Administrator)) {
          return paramString.Administrator.split("\\|");
        }
      }
    }
    return new String[0];
  }
  
  public int b()
  {
    PstnManager localPstnManager = (PstnManager)((QQAppInterface)this.a.a()).getManager(142);
    if ((localPstnManager != null) && (localPstnManager.a() == 1)) {
      return 1;
    }
    return 0;
  }
  
  public int b(String paramString)
  {
    return ((QQAppInterface)this.a.a()).a().a(paramString);
  }
  
  public long b(String paramString)
  {
    return ((QQAppInterface)this.a.a()).a().a(paramString);
  }
  
  String b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if ((localPhoneContactManager != null) && (paramString2 != null)) {}
    for (paramString2 = localPhoneContactManager.c(paramString2);; paramString2 = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "getDisplayName contact = " + paramString2);
      }
      if (paramString2 != null) {
        return paramString2.name;
      }
      paramString2 = ((QCallCardManager)paramQQAppInterface.getManager(139)).a(paramString1);
      paramQQAppInterface = (QCallCardHandler)paramQQAppInterface.a(79);
      paramQQAppInterface.a(paramString1);
      paramQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqQcallQCallCardHandler$OnGetQCallCardListener);
      if ((paramString2 != null) && (paramString2.nickname != null)) {
        return paramString2.nickname;
      }
      return "";
    }
  }
  
  public String b(String paramString)
  {
    Object localObject = (QQAppInterface)this.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "getTroopOwner mApp = " + localObject);
    }
    if (localObject != null)
    {
      localObject = (TroopManager)((QQAppInterface)localObject).getManager(51);
      if (localObject != null)
      {
        paramString = ((TroopManager)localObject).a(paramString);
        if (paramString == null) {
          return null;
        }
        return paramString.troopowneruin;
      }
    }
    return null;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "avStartAddFriendService");
    }
    ((QQAppInterface)this.a.a()).a();
  }
  
  public void b(int paramInt, String paramString)
  {
    this.a.jdField_a_of_type_JavaLangString = paramString;
    this.a.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(IAVRedPacketCallback paramIAVRedPacketCallback)
  {
    ((AVRedPacketConfigManager)QQServiceForAV.c(this.a).getManager(253)).a(paramIAVRedPacketCallback);
  }
  
  public void b(IQQServiceLocationCallback paramIQQServiceLocationCallback)
  {
    if (paramIQQServiceLocationCallback == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "getUserCurrentLocation IQQServiceLocationCallback is null, no need notify");
      }
    }
    do
    {
      do
      {
        return;
        QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
        if ((localQQAppInterface.getApp() == null) || (!NetworkUtil.d(localQQAppInterface.getApp().getApplicationContext()))) {
          break;
        }
        if (QQServiceForAV.a(this.a) == null) {
          QQServiceForAV.a(this.a, new jpm());
        }
        QQServiceForAV.a(this.a).a(paramIQQServiceLocationCallback);
        if (QQServiceForAV.a(this.a).a() == 1)
        {
          localQQAppInterface.addObserver(QQServiceForAV.a(this.a));
          ((LBSHandler)localQQAppInterface.a(3)).c();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQServiceForAV", 2, "We are waiting getUserCurrentLocation response, so need't request again");
      return;
      try
      {
        paramIQQServiceLocationCallback.a(false, null);
        return;
      }
      catch (RemoteException paramIQQServiceLocationCallback) {}
    } while (!QLog.isColorLevel());
    QLog.e("QQServiceForAV", 2, "Call getUserCurrentLocation fail", paramIQQServiceLocationCallback);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "acceptAddFriend :" + paramString);
    }
    ((QQAppInterface)this.a.a()).a().c(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = ((QQAppInterface)this.a.a()).getApplication().getApplicationContext().getSharedPreferences("qav_SP", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    if (paramBoolean)
    {
      localEditor.putBoolean("qav_random_speakeron", true);
      localEditor.commit();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "qav_random_speakeron: " + localSharedPreferences.getBoolean("qav_random_speakeron", false));
      }
      return;
      localEditor.putBoolean("qav_random_speakeron", false);
      localEditor.commit();
    }
  }
  
  public boolean b()
  {
    return ((QQAppInterface)this.a.a()).a().a();
  }
  
  public boolean b(String paramString)
  {
    return ((QQAppInterface)this.a.a()).a().d(paramString);
  }
  
  public boolean b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "requestDecodeStrangeFace");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(localQQAppInterface.getApp().getApplicationContext(), localQQAppInterface);
      this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener);
    }
    if (paramInt == 25) {
      return this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b(paramString, 16, true, false);
    }
    return this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 200, true, false);
  }
  
  public long[] b(String paramString)
  {
    AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)((QQAppInterface)this.a.a()).getManager(222);
    if (localAIOAnimationControlManager != null) {
      return localAIOAnimationControlManager.a(paramString);
    }
    return null;
  }
  
  public int c()
  {
    Object localObject = (QQAppInterface)this.a.a();
    PstnManager localPstnManager = (PstnManager)((QQAppInterface)localObject).getManager(142);
    if (localPstnManager != null)
    {
      localObject = localPstnManager.a(((QQAppInterface)localObject).getCurrentAccountUin());
      if ((localObject != null) && (localPstnManager.a() == 1))
      {
        if (((PstnCardInfo)localObject).pstn_multi_call_time > 0) {
          return 3;
        }
        if ((localPstnManager.c() == 1) && (((PstnCardInfo)localObject).pstn_multi_try_status == 0)) {
          return 4;
        }
        return 5;
      }
    }
    return 5;
  }
  
  public int c(String paramString)
  {
    int i = -1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (BmqqSegmentUtil.b(paramString)) {
        i = 1025;
      }
    }
    else {
      return i;
    }
    return 1024;
  }
  
  public String c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    paramString = ((PhoneContactManager)QQServiceForAV.e(this.a).getManager(10)).b(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.uin;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "avStopAddFriendService");
    }
    ((QQAppInterface)this.a.a()).k();
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "acceptAddFriend :" + paramString);
    }
    ((QQAppInterface)this.a.a()).a().b(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "playFlowerAnimation play: " + paramBoolean + ", mFlowerAnimationActive: " + this.a.jdField_a_of_type_Boolean);
    }
  }
  
  public boolean c()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (localQQAppInterface.c())
    {
      long l = localQQAppInterface.a().b();
      int i = localQQAppInterface.a().a();
      if (l > 0L)
      {
        int j = localQQAppInterface.a().b(l);
        if ((i == 1) && (j == 2)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean c(String paramString)
  {
    if (!(QQServiceForAV.i(this.a) instanceof QQAppInterface)) {
      return false;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.j(this.a);
    try
    {
      l = Long.parseLong(paramString);
      int i = UITools.a(1);
      l = localQQAppInterface.a().a(i, l);
      TroopGagMgr localTroopGagMgr = (TroopGagMgr)((QQAppInterface)QQServiceForAV.k(this.a)).getManager(47);
      boolean bool1 = localTroopGagMgr.a(paramString, localQQAppInterface.getCurrentAccountUin());
      boolean bool2 = localTroopGagMgr.a(paramString);
      boolean bool3 = localTroopGagMgr.b(paramString);
      paramString = localTroopGagMgr.a(paramString);
      if ((l == 0L) && (((!bool3) && (bool1)) || ((!bool2) && (paramString != null) && (paramString.a > 0L)))) {
        return true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        long l = 0L;
      }
    }
    return false;
  }
  
  public boolean c(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "avAddFriend :" + paramString);
    }
    return ((QQAppInterface)this.a.a()).a().a(paramString, paramInt);
  }
  
  public int d()
  {
    return ((QQAppInterface)this.a.a()).a().a().jdField_b_of_type_Int;
  }
  
  public String d(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    paramString = ((PhoneContactManager)QQServiceForAV.f(this.a).getManager(10)).a(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.mobileNo;
  }
  
  public void d(String paramString)
  {
    RedTouchManager localRedTouchManager = (RedTouchManager)((QQAppInterface)this.a.a()).getManager(35);
    String str = "103100.103400.103410.103411";
    if (!TextUtils.isEmpty(paramString)) {
      str = "103100.103400.103410.103411" + "." + paramString;
    }
    localRedTouchManager.b(str);
  }
  
  public boolean d()
  {
    return AppSetting.jdField_b_of_type_Boolean;
  }
  
  public String e(String paramString)
  {
    RedTouchManager localRedTouchManager = (RedTouchManager)((QQAppInterface)this.a.a()).getManager(35);
    String str = "103100.103400.103410.103411";
    if (!TextUtils.isEmpty(paramString)) {
      str = "103100.103400.103410.103411" + "." + paramString;
    }
    paramString = a(localRedTouchManager.a(str));
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "[red dot] appInfoString = " + paramString);
    }
    return paramString;
  }
  
  public void e(String paramString)
  {
    RedTouchManager localRedTouchManager = (RedTouchManager)((QQAppInterface)this.a.a()).getManager(35);
    String str = "103100.103400.103410.103411";
    if (!TextUtils.isEmpty(paramString)) {
      str = "103100.103400.103410.103411" + "." + paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAVQ.nearby.video_chat", 2, "redTouchManagerDismiss, appId " + paramString);
    }
    localRedTouchManager.c(str);
  }
  
  public boolean e()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    return PtvFilterSoLoad.a(localQQAppInterface, localQQAppInterface.getApplication().getApplicationContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jpn
 * JD-Core Version:    0.7.0.1
 */