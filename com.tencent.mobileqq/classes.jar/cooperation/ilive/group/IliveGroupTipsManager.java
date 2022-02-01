package cooperation.ilive.group;

import android.os.Handler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x857.TroopTips0x857.QQVaLiveNotifyMsg;

public class IliveGroupTipsManager
  implements Manager
{
  public static String a = "source_resume";
  public static String b = "source_push";
  public static String c = "source_loop";
  private QQAppInterface d;
  private IliveGroupObserver e;
  private HashMap<Long, Boolean> f = new HashMap();
  
  public IliveGroupTipsManager(QQAppInterface paramQQAppInterface)
  {
    this.d = paramQQAppInterface;
  }
  
  private void a(long paramLong, boolean paramBoolean, String paramString)
  {
    if (this.e == null) {
      return;
    }
    long l;
    if (paramBoolean) {
      l = 3000L;
    } else {
      l = 0L;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new IliveGroupTipsManager.1(this, paramBoolean, paramString, paramLong), l);
  }
  
  public static boolean a()
  {
    return QzoneConfig.getInstance().getConfig("qqLive", "iliveTopsLoopEnable", 1) == 1;
  }
  
  public void a(IliveGroupObserver paramIliveGroupObserver)
  {
    this.e = paramIliveGroupObserver;
    this.d.addObserver(paramIliveGroupObserver);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ((IliveCommonHandler)this.d.getBusinessHandler(BusinessHandlerFactory.ILIVE_COMMON_HANDLER)).a("", paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    ((IliveCommonHandler)this.d.getBusinessHandler(BusinessHandlerFactory.ILIVE_COMMON_HANDLER)).a(paramString1, paramString2, paramString3);
  }
  
  public void a(TroopTips0x857.QQVaLiveNotifyMsg paramQQVaLiveNotifyMsg, long paramLong)
  {
    if (paramQQVaLiveNotifyMsg == null) {
      return;
    }
    boolean bool3 = paramQQVaLiveNotifyMsg.notify_type.has();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (paramQQVaLiveNotifyMsg.notify_type.get() == 1) {
        bool1 = true;
      }
    }
    if (paramQQVaLiveNotifyMsg.bytes_uid.has()) {
      paramQQVaLiveNotifyMsg = paramQQVaLiveNotifyMsg.bytes_uid.get().toStringUtf8();
    } else {
      paramQQVaLiveNotifyMsg = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handlePushLiveData isLive = ");
    localStringBuilder.append(bool1);
    localStringBuilder.append(" puid = ");
    localStringBuilder.append(paramQQVaLiveNotifyMsg);
    localStringBuilder.append(" troopUin = ");
    localStringBuilder.append(paramLong);
    QLog.d("IliveGroupTipsManager", 1, localStringBuilder.toString());
    this.f.put(Long.valueOf(paramLong), Boolean.valueOf(bool1));
    ((TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER)).f(String.valueOf(paramLong)).setIsTroopLive(bool1);
    if (this.e != null) {
      a(paramLong, bool1, paramQQVaLiveNotifyMsg);
    }
  }
  
  public void b(IliveGroupObserver paramIliveGroupObserver)
  {
    this.d.removeObserver(paramIliveGroupObserver);
    this.e = null;
  }
  
  public void onDestroy()
  {
    IliveGroupObserver localIliveGroupObserver = this.e;
    if (localIliveGroupObserver != null)
    {
      QQAppInterface localQQAppInterface = this.d;
      if (localQQAppInterface != null) {
        localQQAppInterface.removeObserver(localIliveGroupObserver);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.group.IliveGroupTipsManager
 * JD-Core Version:    0.7.0.1
 */