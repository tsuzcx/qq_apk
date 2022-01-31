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
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.service.QQServiceForAV.QQServiceForAVBinder.3;
import com.tencent.av.service.QQServiceForAV.QQServiceForAVBinder.4;
import com.tencent.av.service.UtilsServiceForAV;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FMTransC2CMsgInfo;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class mac
  extends lzh
{
  public mac(QQServiceForAV paramQQServiceForAV) {}
  
  private void a(IBinder paramIBinder)
  {
    Intent localIntent = new Intent(this.a.getApplicationContext(), UtilsServiceForAV.class);
    this.a.getApplicationContext().stopService(localIntent);
    if (QQServiceForAV.jdField_a_of_type_AndroidOsIBinder == null)
    {
      lek.d("QQServiceForAV", "linkToVideoProcessDeath");
      QQServiceForAV.jdField_a_of_type_AndroidOsIBinder = paramIBinder;
    }
    try
    {
      QQServiceForAV.jdField_a_of_type_AndroidOsIBinder.linkToDeath(new mae(this), 0);
      return;
    }
    catch (RemoteException paramIBinder)
    {
      QQServiceForAV.jdField_a_of_type_AndroidOsIBinder = null;
      lek.e("QQServiceForAV", "linkToVideoProcessDeath exception msg = " + paramIBinder.getMessage());
    }
  }
  
  public int a()
  {
    return ((aufv)((QQAppInterface)this.a.a()).getManager(11)).d();
  }
  
  public int a(int paramInt, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      int i = bdjg.a(localQQAppInterface, bool, paramString);
      QLog.w("QQServiceForAV", 1, "getGroupMemberNum, relationType[" + paramInt + "], uin[" + paramString + "], 成员数[" + i + "]");
      return i;
    }
  }
  
  public int a(String paramString)
  {
    return ((QQAppInterface)this.a.a()).a().a(paramString);
  }
  
  public long a(String paramString)
  {
    paramString = ((alrk)((QQAppInterface)this.a.a()).getManager(53)).a(paramString);
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
      b = 4;
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
        localQQAppInterface.addObserver(this.a.jdField_a_of_type_Altm);
      }
      if ((paramString2 == null) && (paramBoolean2))
      {
        if (QLog.isColorLevel()) {
          QLog.w("QQServiceForAV", 2, "getFaceBitmap failed, use default face!");
        }
        if (paramInt == 1)
        {
          return bdhj.f();
          b = 5;
          break;
          paramString2 = localQQAppInterface.a(paramString1, b, true);
          continue;
          paramString2 = localQQAppInterface.a(paramString1, b, false, false);
          continue;
          paramString2 = (BitmapDrawable)((alri)localQQAppInterface.a(6)).a(paramString1, false);
          if (paramString2 == null) {
            break label578;
          }
          paramString2 = paramString2.getBitmap();
          continue;
          if (paramString1.startsWith("+")) {
            break label573;
          }
        }
      }
      for (;;)
      {
        paramString2 = bdbk.b(localQQAppInterface, paramString2, b).a();
        break;
        paramString2 = bdbk.a(localQQAppInterface, 200, paramString1, true).a();
        break;
        paramString2 = ((ztp)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(51)).a(Long.parseLong(paramString1));
        paramString2 = DeviceHeadMgr.getInstance().getDeviceHeadByPID(paramString2.productId);
        break;
        Object localObject = (aufv)localQQAppInterface.getManager(11);
        if ((localObject != null) && (paramString2 != null)) {}
        for (localObject = ((aufv)localObject).c(paramString2);; localObject = null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQServiceForAV", 2, "getFaceBitmap contact = " + localObject);
          }
          if (localObject != null)
          {
            paramString2 = bdbk.b(localQQAppInterface, paramString2, b).a();
            break;
          }
          paramString2 = localQQAppInterface.a(16, paramString1, (byte)3, true, 16);
          break;
          paramString2 = awzw.a(localQQAppInterface, paramString2);
          break;
          if (paramInt == 3000) {
            return bdhj.h();
          }
          return bdhj.a();
          return paramString2;
        }
        label573:
        paramString2 = paramString1;
      }
      label578:
      paramString2 = null;
    }
  }
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    boolean bool2 = false;
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder().append("requestEvent, mainCmd[").append(paramInt1).append("], subType[").append(paramInt2).append("], seq[").append(paramInt3).append("], buf[");
      if (paramArrayOfByte == null) {
        break label131;
      }
    }
    label131:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramArrayOfByte = localStringBuilder.append(bool1).append("], bundle[");
      bool1 = bool2;
      if (paramBundle != null) {
        bool1 = true;
      }
      QLog.d("QQServiceForAV", 1, bool1 + "]");
      AudioHelper.a("requestEvent", paramBundle);
      if (paramBundle != null) {
        break;
      }
      return new Bundle();
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
        new Handler(Looper.getMainLooper()).postDelayed(new QQServiceForAV.QQServiceForAVBinder.3(this, paramBundle), 1L);
        continue;
        new Handler(Looper.getMainLooper()).postDelayed(new QQServiceForAV.QQServiceForAVBinder.4(this, paramBundle, paramResultReceiver), 1L);
        continue;
        paramArrayOfByte = paramBundle.getString("uin");
        paramResultReceiver = (QQAppInterface)this.a.a();
        bool1 = bdjg.a("GetInviteFlag", paramResultReceiver, paramArrayOfByte);
        bdjg.a("GetInviteFlag", paramResultReceiver, paramArrayOfByte);
        paramBundle.putBoolean("enableInvite", bool1);
        return paramBundle;
        bdjn.a((QQAppInterface)this.a.a(), paramBundle);
      }
    case 5: 
      return bdjn.a((QQAppInterface)this.a.a(), paramBundle);
    case 6: 
      return bdjg.a((QQAppInterface)this.a.a(), paramBundle.getString("uin"));
    }
    paramArrayOfByte = paramBundle.getString("red_touch_app_id");
    paramBundle.putParcelable("red_touch_red_app_info", axmc.a(((axlx)((QQAppInterface)this.a.a()).getManager(36)).a(paramArrayOfByte)));
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
        break label121;
      }
    }
    try
    {
      paramString1 = a(localQQAppInterface, str1, paramString2);
      for (;;)
      {
        QLog.w("QQServiceForAV", 1, "getDisplayName, uinType[" + paramInt + "], uin[" + str1 + "], extraUin[" + paramString2 + "], name[" + paramString1 + "]");
        return paramString1;
        label121:
        if (paramInt == 26)
        {
          paramString1 = awzw.a(localQQAppInterface, paramString2);
        }
        else if (paramInt == 25)
        {
          paramString1 = b(localQQAppInterface, str1, paramString2);
        }
        else if (paramInt == 1)
        {
          if (!TextUtils.isEmpty(paramString2)) {
            paramString1 = bdgc.h(localQQAppInterface, str1, paramString2);
          } else {
            paramString1 = bdgc.a(localQQAppInterface, str1, false);
          }
        }
        else
        {
          if (paramInt != 9500) {
            break;
          }
          paramString1 = ((ztp)localQQAppInterface.a(51)).a(Long.parseLong(str1));
          if (paramString1 == null) {
            break label461;
          }
          paramString1 = aagc.a(paramString1);
        }
      }
      int i = bdgc.a(paramInt);
      if (i == -1) {}
      for (paramString1 = bdgc.b(localQQAppInterface, str1, paramInt);; paramString1 = bdgc.a(localQQAppInterface, str1, paramString2, i, 0))
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          str2 = paramString1;
          if (!str1.equals(paramString1)) {}
        }
        else
        {
          str2 = bdgc.b(localQQAppInterface, str1, true);
        }
        paramString1 = str2;
        if (TextUtils.isEmpty(str2)) {
          paramString1 = str1;
        }
        localObject = paramString1;
        if (!str1.equals(paramString1)) {
          break;
        }
        localObject = (alto)localQQAppInterface.getManager(51);
        str2 = paramString1;
        if (localObject != null)
        {
          localObject = ((alto)localObject).e(str1);
          str2 = paramString1;
          if (localObject != null) {
            str2 = bdgc.a((Friends)localObject);
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
        localQQAppInterface.addObserver(this.a.jdField_a_of_type_Altm);
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
        label461:
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
      localObject1 = (aufv)paramQQAppInterface.getManager(11);
      if (localObject1 != null) {}
      label236:
      label248:
      for (localObject1 = ((aufv)localObject1).c(str);; localObject1 = null)
      {
        if (localObject1 != null)
        {
          localObject1 = ((PhoneContact)localObject1).name;
          return localObject1;
        }
        localObject1 = bdgc.e(paramQQAppInterface, str);
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          if (!paramString1.startsWith("+")) {
            break label253;
          }
          if ((paramString2 == null) || (paramString2.startsWith("+"))) {
            break label236;
          }
          paramString1 = paramString2;
        }
        label121:
        label253:
        for (;;)
        {
          localObject2 = paramString1;
          if (paramString1 != null)
          {
            bdgc.a(paramQQAppInterface, str, paramString1);
            localObject2 = paramString1;
          }
          if (localObject2 != null)
          {
            paramString1 = (alto)paramQQAppInterface.getManager(51);
            if (paramString1 == null) {
              break label248;
            }
          }
          for (paramString1 = paramString1.e((String)localObject2);; paramString1 = null)
          {
            if (paramString1 != null) {}
            for (paramString1 = bdgc.a(paramString1);; paramString1 = null)
            {
              if ((paramString1 == null) || (paramString1.equals(localObject2)))
              {
                paramString1 = (FriendListHandler)paramQQAppInterface.a(1);
                localObject1 = str;
                if (paramString1 == null) {
                  break;
                }
                this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
                paramQQAppInterface.addObserver(this.a.jdField_a_of_type_Altm);
                paramString1.b((String)localObject2);
                return str;
                paramString1 = null;
                break label121;
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
    aufv localaufv = (aufv)((QQAppInterface)this.a.a()).getManager(11);
    if (localaufv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "getPhoneNameByPhoneNum --> can not get PhoneContactManager");
      }
      return null;
    }
    paramString = localaufv.b(paramString);
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
    Object localObject = (apks)QQServiceForAV.d(this.a).getManager(77);
    if (localObject != null)
    {
      apls localapls = (apls)((apks)localObject).a(apls.e());
      if (localapls != null) {
        localapls.a(false);
      }
    }
    if (localObject != null)
    {
      localObject = (aplu)((apks)localObject).a("qq.android.qav.video");
      if (localObject != null) {
        ((aplu)localObject).a(false);
      }
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    amdu localamdu = (amdu)localQQAppInterface.a(20);
    if (localamdu != null) {}
    while (!QLog.isColorLevel()) {
      try
      {
        QLog.w("QQServiceForAV", 1, "requestGrayVideoWebViewConfig, identity[" + paramInt1 + "], guin[" + paramLong + "], clientId[" + paramInt2 + "], appVersion[" + paramInt3 + "]");
        localQQAppInterface.addObserver(this.a.jdField_a_of_type_Ameq);
        localamdu.a(paramInt1, paramLong);
        return;
      }
      catch (Exception localException)
      {
        do
        {
          localQQAppInterface.removeObserver(this.a.jdField_a_of_type_Ameq);
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
    this.a.jdField_b_of_type_Long = ayzl.a();
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
    this.a.jdField_b_of_type_Long = ayzl.a();
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
    localQQAppInterface.addObserver(this.a.jdField_a_of_type_Ameq);
    amdu localamdu = (amdu)localQQAppInterface.a(20);
    if (localamdu != null) {
      try
      {
        localamdu.a(paramLong, Long.parseLong(paramString), paramInt);
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
    localQQAppInterface.removeObserver(this.a.jdField_a_of_type_Ameq);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (localQQAppInterface != null) {
      localQQAppInterface.a().a(paramLong1, paramString, paramLong2);
    }
  }
  
  public void a(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    auxh localauxh = (auxh)localQQAppInterface.a(60);
    localQQAppInterface.addObserver(this.a.jdField_a_of_type_Auxl);
    localauxh.a(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    mzy.a((QQAppInterface)this.a.a(), new mad(this, paramString, paramInt2), paramArrayOfByte, paramString, paramInt1, paramInt2);
  }
  
  public void a(String paramString, long paramLong)
  {
    Object localObject = (bcka)((QQAppInterface)this.a.a()).getManager(223);
    if (localObject != null) {
      ((bcka)localObject).a(paramString);
    }
    if ((paramLong > 0L) && ((QQServiceForAV.h(this.a) instanceof QQAppInterface)))
    {
      localObject = (QQAppInterface)QQServiceForAV.i(this.a);
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_JavaLangString = paramString;
      localSessionInfo.jdField_a_of_type_Int = 1;
      acjm.a((QQAppInterface)localObject, localSessionInfo);
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
    MessageRecord localMessageRecord = azaf.a(-1000);
    long l = ayzl.a();
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
  
  public void a(lyu paramlyu)
  {
    ((lwp)QQServiceForAV.b(this.a).getManager(254)).b(paramlyu);
  }
  
  public void a(lzd paramlzd)
  {
    if (paramlzd != null) {
      this.a.jdField_a_of_type_AndroidOsRemoteCallbackList.unregister(paramlzd);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "unregisterCallback");
    }
    ((QQAppInterface)this.a.a()).a = null;
  }
  
  public void a(lzd paramlzd, String paramString)
  {
    if (paramlzd != null)
    {
      this.a.jdField_a_of_type_AndroidOsRemoteCallbackList.register(paramlzd, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "registerCallback");
      }
      a(paramlzd.asBinder());
      paramlzd = (QQAppInterface)this.a.a();
      paramlzd.a = null;
      paramlzd.a = new WeakReference(this.a);
    }
  }
  
  public void a(lzj paramlzj)
  {
    if (paramlzj == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "getAddressConfig IQQServiceLocationCallback is null");
      }
      return;
    }
    Object localObject = (QQAppInterface)this.a.a();
    localObject = (alpy)QQServiceForAV.a(this.a).getManager(59);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "getAddressConfig for IQQServiceLocationCallback");
      }
      if (((alpy)localObject).a() == 1)
      {
        if (((alpy)localObject).a(((alpy)localObject).a(), true) == 0)
        {
          if (QQServiceForAV.a(this.a) == null) {
            QQServiceForAV.a(this.a, new lzy(this, (alpy)localObject, paramlzj));
          }
          for (;;)
          {
            ((alpy)localObject).c(QQServiceForAV.a(this.a));
            return;
            QQServiceForAV.a(this.a).a(paramlzj);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQServiceForAV", 2, "ConditionSearchManager update RESULT_UPDATE_REMOTE fail");
        }
        a(false, paramlzj);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "ConditionSearchManager config exist");
      }
      a(true, paramlzj);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "Get ConditionSearchManager null");
    }
    a(false, paramlzj);
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
  
  public void a(boolean paramBoolean, lzj paramlzj)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    }
    try
    {
      for (;;)
      {
        paramlzj.a(i, "admin_region_config");
        return;
        i = -26;
      }
    }
    catch (RemoteException paramlzj)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQServiceForAV", 2, "Call onGetAddressConfig fail", paramlzj);
    }
  }
  
  public void a(long[] paramArrayOfLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "getGVideoLevelInfo uins = " + paramArrayOfLong.toString() + " troopuin = " + paramString);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    localQQAppInterface.addObserver(this.a.jdField_a_of_type_Ameq);
    amdu localamdu = (amdu)localQQAppInterface.a(20);
    if (localamdu != null) {
      try
      {
        localamdu.a(paramArrayOfLong, Long.parseLong(paramString));
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
    localQQAppInterface.removeObserver(this.a.jdField_a_of_type_Ameq);
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
    amdu localamdu = (amdu)localQQAppInterface.a(20);
    if (localamdu != null) {
      try
      {
        QLog.w("QQServiceForAV", 1, "getAdminMemberList, troopUin[" + paramLong + "]");
        localQQAppInterface.addObserver(this.a.jdField_a_of_type_Ameq);
        localamdu.a(paramLong, 0L, 2, 0, 0);
        return true;
      }
      catch (Exception localException)
      {
        localQQAppInterface.removeObserver(this.a.jdField_a_of_type_Ameq);
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
    return ((alto)((QQAppInterface)this.a.a()).getManager(51)).b(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    paramString = ((alrk)((QQAppInterface)this.a.a()).getManager(53)).a(paramString);
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
      localObject = (TroopManager)((QQAppInterface)localObject).getManager(52);
      if ((localObject != null) && (((TroopManager)localObject).b(paramString1, paramString2) == null)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    localQQAppInterface.addObserver(this.a.jdField_a_of_type_Ameq);
    amdu localamdu = (amdu)localQQAppInterface.a(20);
    if (localamdu != null) {
      try
      {
        localamdu.f(paramString, paramBoolean);
        return true;
      }
      catch (Exception paramString)
      {
        localQQAppInterface.removeObserver(this.a.jdField_a_of_type_Ameq);
        QLog.e("QQServiceForAV", 2, "joinOrExitOpenTroop-->error,e=" + paramString.getMessage());
        return false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "joinOrExitOpenTroop-->can not get TroopHandle");
    }
    localQQAppInterface.removeObserver(this.a.jdField_a_of_type_Ameq);
    return false;
  }
  
  @Deprecated
  public int[] a()
  {
    return new int[3];
  }
  
  public long[] a(String paramString)
  {
    paramString = ((alrk)((QQAppInterface)this.a.a()).getManager(53)).a(paramString);
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
      localObject = (TroopManager)((QQAppInterface)localObject).getManager(52);
      if (localObject != null)
      {
        paramString = ((TroopManager)localObject).b(paramString);
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
  
  @Deprecated
  public int b()
  {
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
    aufv localaufv = (aufv)paramQQAppInterface.getManager(11);
    if ((localaufv != null) && (paramString2 != null)) {}
    for (paramString2 = localaufv.c(paramString2);; paramString2 = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "getDisplayName contact = " + paramString2);
      }
      if (paramString2 != null) {
        return paramString2.name;
      }
      paramString2 = ((axaf)paramQQAppInterface.getManager(140)).a(paramString1);
      paramQQAppInterface = (axac)paramQQAppInterface.a(79);
      paramQQAppInterface.a(paramString1);
      paramQQAppInterface.a(this.a.jdField_a_of_type_Axad);
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
      localObject = (TroopManager)((QQAppInterface)localObject).getManager(52);
      if (localObject != null)
      {
        paramString = ((TroopManager)localObject).b(paramString);
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
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQServiceForAV", 2, "acceptAddFriend :" + paramString);
    }
    ((QQAppInterface)this.a.a()).a().c(paramString);
  }
  
  public void b(lyu paramlyu)
  {
    ((lwp)QQServiceForAV.c(this.a).getManager(254)).a(paramlyu);
  }
  
  public void b(lzj paramlzj)
  {
    if (paramlzj == null) {
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
        if ((localQQAppInterface.getApp() == null) || (!bdin.d(localQQAppInterface.getApp().getApplicationContext()))) {
          break;
        }
        if (QQServiceForAV.a(this.a) == null) {
          QQServiceForAV.a(this.a, new lzz());
        }
        QQServiceForAV.a(this.a).a(paramlzj);
        if (QQServiceForAV.a(this.a).a() == 1)
        {
          localQQAppInterface.addObserver(QQServiceForAV.a(this.a));
          ((alvm)localQQAppInterface.a(3)).b();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQServiceForAV", 2, "We are waiting getUserCurrentLocation response, so need't request again");
      return;
      try
      {
        paramlzj.a(false, null);
        return;
      }
      catch (RemoteException paramlzj) {}
    } while (!QLog.isColorLevel());
    QLog.e("QQServiceForAV", 2, "Call getUserCurrentLocation fail", paramlzj);
  }
  
  public void b(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = bdne.a(((QQAppInterface)this.a.a()).getApplication().getApplicationContext());
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
    if (this.a.jdField_a_of_type_Bdbb == null)
    {
      this.a.jdField_a_of_type_Bdbb = new bdbb(localQQAppInterface.getApp().getApplicationContext(), localQQAppInterface);
      this.a.jdField_a_of_type_Bdbb.a(this.a.jdField_a_of_type_Bdbc);
    }
    if (paramInt == 25) {
      return this.a.jdField_a_of_type_Bdbb.b(paramString, 16, true, false);
    }
    return this.a.jdField_a_of_type_Bdbb.a(paramString, 200, true, false);
  }
  
  public long[] b(String paramString)
  {
    bcka localbcka = (bcka)((QQAppInterface)this.a.a()).getManager(223);
    if (localbcka != null) {
      return localbcka.a(paramString);
    }
    return null;
  }
  
  @Deprecated
  public int c()
  {
    return 0;
  }
  
  public int c(String paramString)
  {
    int i = -1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (nbp.b(paramString)) {
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
    paramString = ((aufv)QQServiceForAV.e(this.a).getManager(11)).b(paramString);
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
    return AppSetting.c;
  }
  
  public boolean c(String paramString)
  {
    if (!(QQServiceForAV.j(this.a) instanceof QQAppInterface)) {
      return false;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)QQServiceForAV.k(this.a);
    try
    {
      l = Long.parseLong(paramString);
      int i = mww.b(1);
      l = localQQAppInterface.a().a(i, l);
      bcnu localbcnu = (bcnu)((QQAppInterface)QQServiceForAV.l(this.a)).getManager(48);
      boolean bool1 = localbcnu.a(paramString, localQQAppInterface.getCurrentAccountUin());
      boolean bool2 = localbcnu.a(paramString);
      boolean bool3 = localbcnu.b(paramString);
      paramString = localbcnu.a(paramString);
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
    return -1;
  }
  
  public String d(String paramString)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    if (TextUtils.isEmpty(paramString)) {
      return localObject3;
    }
    Object localObject2 = (QQAppInterface)this.a.a();
    localObject2 = ((alto)QQServiceForAV.f(this.a).getManager(51)).b(paramString);
    if (localObject2 != null)
    {
      localObject1 = ((Card)localObject2).getCardInfo();
      if ((localObject1 == null) || (((BusinessCard)localObject1).mobilesNum.isEmpty())) {
        break label258;
      }
    }
    label258:
    for (localObject1 = (String)((BusinessCard)localObject1).mobilesNum.get(0);; localObject1 = null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QQServiceForAV", 4, "getPhoneNumByUin in  list-data phoneNumber:=" + (String)localObject1);
      }
      localObject3 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      localObject3 = (PhoneContactManagerImp)QQServiceForAV.g(this.a).getManager(11);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        int i = ((PhoneContactManagerImp)localObject3).d();
        if ((i != 9) && (i != 8) && (i != 4))
        {
          localObject2 = localObject1;
          if (i != 2) {}
        }
        else
        {
          localObject2 = localObject1;
          if (((PhoneContactManagerImp)localObject3).k())
          {
            paramString = ((PhoneContactManagerImp)localObject3).a(paramString);
            localObject2 = localObject1;
            if (paramString != null) {
              localObject2 = paramString.mobileNo;
            }
          }
        }
      }
      localObject3 = localObject2;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w("QQServiceForAV", 4, "getPhoneNumByUin in  PhoneContact phoneNumber:=" + (String)localObject2);
      return localObject2;
    }
  }
  
  public void d(String paramString)
  {
    ((axlx)((QQAppInterface)this.a.a()).getManager(36)).b(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, String.format("keepVideoProcessAlive keepAlive=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    QQServiceForAV.a(this.a, paramBoolean);
  }
  
  public boolean d()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (QQServiceForAV.a(this.a) == null) {
      QQServiceForAV.a(this.a, new mab(this.a));
    }
    boolean bool = azkt.a(localQQAppInterface, localQQAppInterface.getApplication().getApplicationContext(), QQServiceForAV.a(this.a));
    if (QLog.isDevelopLevel()) {
      QLog.w("QQServiceForAV", 4, "getEffectsSoLoadIsOk, ret[" + bool + "]");
    }
    return bool;
  }
  
  public void e(String paramString)
  {
    axlx localaxlx = (axlx)((QQAppInterface)this.a.a()).getManager(36);
    localaxlx.b(localaxlx.a(paramString), "");
  }
  
  public boolean e()
  {
    if (QQServiceForAV.a(this.a) == null) {
      QQServiceForAV.a(this.a, new maa(this.a));
    }
    blap.a().a(blao.c, QQServiceForAV.a(this.a), false);
    if (QLog.isDevelopLevel()) {
      QLog.w("QQServiceForAV", 4, "try download AEKit compenent");
    }
    return false;
  }
  
  public void f(String paramString)
  {
    axlx localaxlx = (axlx)((QQAppInterface)this.a.a()).getManager(36);
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAVQ.nearby.video_chat", 2, "redTouchManagerDismiss, appId " + paramString);
    }
    localaxlx.c(paramString);
  }
  
  public boolean f()
  {
    return ((QQAppInterface)this.a.a()).a().d();
  }
  
  public boolean g()
  {
    return ((QQAppInterface)this.a.a()).a().a();
  }
  
  public boolean h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "call isQQSVIP ");
    }
    return VipUtils.b((QQAppInterface)this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mac
 * JD-Core Version:    0.7.0.1
 */