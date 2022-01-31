import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.AdInfo;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.PhoneInfo;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.ReqBody;

public class nje
{
  private static nje jdField_a_of_type_Nje;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<niv> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private pou jdField_a_of_type_Pou = pou.a();
  
  public static nje a()
  {
    if (jdField_a_of_type_Nje == null) {
      jdField_a_of_type_Nje = new nje();
    }
    return jdField_a_of_type_Nje;
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      long l = System.currentTimeMillis();
      paramToServiceMsg.extraData.putLong("time_stamp", l);
      this.jdField_a_of_type_Pou.a(paramToServiceMsg);
    }
  }
  
  public String a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "getTrueUin uin:" + paramString);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        niv localniv = (niv)localIterator.next();
        if (localniv.jdField_a_of_type_JavaLangString.equals(paramString))
        {
          paramString = localniv.jdField_a_of_type_Nix.jdField_a_of_type_JavaLangString;
          return paramString;
        }
      }
      return null;
    }
  }
  
  public niv a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "getAdvertisementItem uin:" + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          niv localniv = (niv)localIterator.next();
          if (paramString.equals(localniv.jdField_a_of_type_JavaLangString)) {
            return localniv;
          }
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((niv)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt, niv paramniv)
  {
    if ((paramniv == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      oidb_cmd0x886.PhoneInfo localPhoneInfo = njo.a();
      try
      {
        l1 = Long.parseLong(paramAppInterface.getCurrentAccountUin());
        paramAppInterface = paramniv.a(paramInt);
        long l2 = NetConnInfoCenter.getServerTimeMillis();
        String str = bdhv.d(l1 + paramniv.c + paramInt + l2);
        oidb_cmd0x886.ReqBody localReqBody = new oidb_cmd0x886.ReqBody();
        localReqBody.uint64_uin.set(l1);
        localReqBody.msg_phone_info.set(localPhoneInfo);
        localReqBody.msg_ad_info.set(paramAppInterface);
        localReqBody.uint64_client_time.set(l2);
        localReqBody.bytes_uuid.set(ByteStringMicro.copyFromUtf8(str));
        localReqBody.enum_ad_display.set(1);
        a(pow.a("OidbSvc.0x886", 2182, 0, localReqBody.toByteArray()));
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramAppInterface = new StringBuilder("AdReport(");
        paramAppInterface.append(paramInt).append(") msgID=").append(paramniv.c);
        QLog.d("AdvertisementRecentUserManager", 2, paramAppInterface.toString());
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          long l1 = 0L;
          paramAppInterface.printStackTrace();
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if ((paramRecentUser != null) && (paramRecentUser.uin != null)) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        niv localniv = a(paramRecentUser.uin);
        if ((localniv != null) && (NetConnInfoCenter.getServerTimeMillis() - localniv.jdField_a_of_type_Long > 86400000L))
        {
          localObject1 = (ProxyManager)paramQQAppInterface.getManager(18);
          if (localObject1 == null)
          {
            localObject1 = null;
            if (localObject1 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AdvertisementRecentUserManager", 2, "deleteItem uin:" + paramRecentUser.uin);
              }
              ahnn.a().a(paramRecentUser.uin + "-" + paramRecentUser.getType());
              ((aktg)localObject1).b(paramRecentUser);
              ahpf.b(paramQQAppInterface, localniv.jdField_a_of_type_JavaLangString, 1008);
              paramQQAppInterface.a().c(localniv.jdField_a_of_type_JavaLangString, 1008);
            }
            ThreadManager.executeOnFileThread(new AdvertisementRecentUserManager.1(this, localniv));
          }
        }
        else
        {
          return;
        }
        Object localObject1 = ((ProxyManager)localObject1).a();
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "removeUinItem uin:" + paramString);
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        niv localniv = (niv)localIterator.next();
        if (paramString.equals(localniv.jdField_a_of_type_JavaLangString)) {
          localArrayList.add(localniv);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a(niv paramniv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "putAdvertisementItem uin:" + paramniv.jdField_a_of_type_JavaLangString);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramniv);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nje
 * JD-Core Version:    0.7.0.1
 */