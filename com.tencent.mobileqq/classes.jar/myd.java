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

public class myd
{
  private static myd jdField_a_of_type_Myd;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<mxu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private pdc jdField_a_of_type_Pdc = pdc.a();
  
  public static myd a()
  {
    if (jdField_a_of_type_Myd == null) {
      jdField_a_of_type_Myd = new myd();
    }
    return jdField_a_of_type_Myd;
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      long l = System.currentTimeMillis();
      paramToServiceMsg.extraData.putLong("time_stamp", l);
      this.jdField_a_of_type_Pdc.a(paramToServiceMsg);
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
        mxu localmxu = (mxu)localIterator.next();
        if (localmxu.jdField_a_of_type_JavaLangString.equals(paramString))
        {
          paramString = localmxu.jdField_a_of_type_Mxw.jdField_a_of_type_JavaLangString;
          return paramString;
        }
      }
      return null;
    }
  }
  
  public mxu a(String paramString)
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
          mxu localmxu = (mxu)localIterator.next();
          if (paramString.equals(localmxu.jdField_a_of_type_JavaLangString)) {
            return localmxu;
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
      ((mxu)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt, mxu parammxu)
  {
    if ((parammxu == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      oidb_cmd0x886.PhoneInfo localPhoneInfo = myn.a();
      try
      {
        l1 = Long.parseLong(paramAppInterface.getCurrentAccountUin());
        paramAppInterface = parammxu.a(paramInt);
        long l2 = NetConnInfoCenter.getServerTimeMillis();
        String str = bcdu.d(l1 + parammxu.c + paramInt + l2);
        oidb_cmd0x886.ReqBody localReqBody = new oidb_cmd0x886.ReqBody();
        localReqBody.uint64_uin.set(l1);
        localReqBody.msg_phone_info.set(localPhoneInfo);
        localReqBody.msg_ad_info.set(paramAppInterface);
        localReqBody.uint64_client_time.set(l2);
        localReqBody.bytes_uuid.set(ByteStringMicro.copyFromUtf8(str));
        localReqBody.enum_ad_display.set(1);
        a(pde.a("OidbSvc.0x886", 2182, 0, localReqBody.toByteArray()));
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramAppInterface = new StringBuilder("AdReport(");
        paramAppInterface.append(paramInt).append(") msgID=").append(parammxu.c);
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
        mxu localmxu = a(paramRecentUser.uin);
        if ((localmxu != null) && (NetConnInfoCenter.getServerTimeMillis() - localmxu.jdField_a_of_type_Long > 86400000L))
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
              ahay.a().a(paramRecentUser.uin + "-" + paramRecentUser.getType());
              ((akeu)localObject1).b(paramRecentUser);
              ahcq.b(paramQQAppInterface, localmxu.jdField_a_of_type_JavaLangString, 1008);
              paramQQAppInterface.a().c(localmxu.jdField_a_of_type_JavaLangString, 1008);
            }
            ThreadManager.executeOnFileThread(new AdvertisementRecentUserManager.1(this, localmxu));
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
        mxu localmxu = (mxu)localIterator.next();
        if (paramString.equals(localmxu.jdField_a_of_type_JavaLangString)) {
          localArrayList.add(localmxu);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a(mxu parammxu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "putAdvertisementItem uin:" + parammxu.jdField_a_of_type_JavaLangString);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(parammxu);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     myd
 * JD-Core Version:    0.7.0.1
 */