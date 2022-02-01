import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager.1;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.AdInfo;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.PhoneInfo;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.ReqBody;

public class oez
{
  private static oez jdField_a_of_type_Oez;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<oeq> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private qxn jdField_a_of_type_Qxn = qxn.a();
  
  public static oez a()
  {
    if (jdField_a_of_type_Oez == null) {
      jdField_a_of_type_Oez = new oez();
    }
    return jdField_a_of_type_Oez;
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      long l = System.currentTimeMillis();
      paramToServiceMsg.extraData.putLong("time_stamp", l);
      this.jdField_a_of_type_Qxn.a(paramToServiceMsg);
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
        oeq localoeq = (oeq)localIterator.next();
        if (localoeq.jdField_a_of_type_JavaLangString.equals(paramString))
        {
          paramString = localoeq.jdField_a_of_type_Oes.jdField_a_of_type_JavaLangString;
          return paramString;
        }
      }
      return null;
    }
  }
  
  public oeq a(String paramString)
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
          oeq localoeq = (oeq)localIterator.next();
          if (paramString.equals(localoeq.jdField_a_of_type_JavaLangString)) {
            return localoeq;
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
      ((oeq)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt, oeq paramoeq)
  {
    if ((paramoeq == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      oidb_cmd0x886.PhoneInfo localPhoneInfo = ofj.a();
      try
      {
        l1 = Long.parseLong(paramAppInterface.getCurrentAccountUin());
        paramAppInterface = paramoeq.a(paramInt);
        long l2 = NetConnInfoCenter.getServerTimeMillis();
        String str = MD5Utils.toMD5(l1 + paramoeq.c + paramInt + l2);
        oidb_cmd0x886.ReqBody localReqBody = new oidb_cmd0x886.ReqBody();
        localReqBody.uint64_uin.set(l1);
        localReqBody.msg_phone_info.set(localPhoneInfo);
        localReqBody.msg_ad_info.set(paramAppInterface);
        localReqBody.uint64_client_time.set(l2);
        localReqBody.bytes_uuid.set(ByteStringMicro.copyFromUtf8(str));
        localReqBody.enum_ad_display.set(1);
        a(qxp.a("OidbSvc.0x886", 2182, 0, localReqBody.toByteArray()));
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramAppInterface = new StringBuilder("AdReport(");
        paramAppInterface.append(paramInt).append(") msgID=").append(paramoeq.c);
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
        oeq localoeq = a(paramRecentUser.uin);
        if ((localoeq != null) && (NetConnInfoCenter.getServerTimeMillis() - localoeq.jdField_a_of_type_Long > 86400000L))
        {
          localObject1 = (ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER);
          if (localObject1 == null)
          {
            localObject1 = null;
            if (localObject1 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AdvertisementRecentUserManager", 2, "deleteItem uin:" + paramRecentUser.uin);
              }
              algs.a().a(paramRecentUser.uin + "-" + paramRecentUser.getType());
              ((aoxz)localObject1).delRecentUser(paramRecentUser);
              alik.b(paramQQAppInterface, localoeq.jdField_a_of_type_JavaLangString, 1008);
              paramQQAppInterface.getMessageFacade().setReaded(localoeq.jdField_a_of_type_JavaLangString, 1008);
            }
            ThreadManager.executeOnFileThread(new AdvertisementRecentUserManager.1(this, localoeq));
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
        oeq localoeq = (oeq)localIterator.next();
        if (paramString.equals(localoeq.jdField_a_of_type_JavaLangString)) {
          localArrayList.add(localoeq);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a(oeq paramoeq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "putAdvertisementItem uin:" + paramoeq.jdField_a_of_type_JavaLangString);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramoeq);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oez
 * JD-Core Version:    0.7.0.1
 */