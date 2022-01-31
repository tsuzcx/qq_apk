import KQQ.ReqItem;
import KQQ.RespItem;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.common.offline.OfflineExpire.OfflineExpireCheckUpdate.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.os.MqqHandler;
import tencent.im.sso.offlinpkg.OfflinePkg.BidPkg;
import tencent.im.sso.offlinpkg.OfflinePkg.ReqBody;
import tencent.im.sso.offlinpkg.OfflinePkg.RspBody;

public class nce
  implements azal
{
  public nce(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface.getLongAccountUin() % 10L == 6L) {}
    for (boolean bool = true;; bool = false)
    {
      nbv.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a(int paramInt)
  {
    if (ncc.jdField_a_of_type_Boolean) {
      return null;
    }
    ncc.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(ncc.jdField_a_of_type_JavaLangString, 2, "getCheckUpdateItemData");
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    ReqItem localReqItem;
    OfflinePkg.ReqBody localReqBody;
    int j;
    String str;
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      localReqItem = new ReqItem();
      localReqItem.cOperType = 1;
      localReqItem.eServiceID = 127;
      localReqBody = new OfflinePkg.ReqBody();
      localReqBody.uint32_cmd.set(2);
      localReqBody.uint32_platform.set(ncc.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d(ncc.jdField_a_of_type_JavaLangString, 1, String.format("OfflineExpireCheckUpdate, check update QQ Version: %s", new Object[] { "8.3.5.4555" }));
      }
      localReqBody.str_qver.set(ByteStringMicro.copyFrom("8.3.5.4555".getBytes()));
      localReqBody.str_osrelease.set(ByteStringMicro.copyFrom(Build.VERSION.RELEASE.getBytes()));
      paramInt = ndk.a(((QQAppInterface)localObject).getApp());
      localReqBody.int32_network.set(paramInt);
      localReqBody.str_from.set(ByteStringMicro.copyFrom("predown".getBytes()));
      localObject = nbv.a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label426;
      }
      String[] arrayOfString = ((String)localObject).split(",");
      int m = arrayOfString.length;
      j = 0;
      if (j >= m) {
        break label426;
      }
      str = arrayOfString[j];
      if (!TextUtils.isEmpty(str)) {
        localObject = str.split("\\|");
      }
    }
    for (;;)
    {
      for (;;)
      {
        int i;
        try
        {
          paramInt = Integer.valueOf(localObject[0]).intValue();
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          int k;
          i = 0;
          localNumberFormatException1.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i(ncc.jdField_a_of_type_JavaLangString, 2, "NumberFormatException:" + str);
          }
          paramInt = 0;
          continue;
        }
        catch (Exception localException1)
        {
          i = 0;
        }
        try
        {
          k = Integer.valueOf(localObject[1]).intValue();
          i = paramInt;
          paramInt = k;
          if (i != 0) {
            break label383;
          }
          j += 1;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            OfflinePkg.BidPkg localBidPkg;
            i = paramInt;
          }
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          label383:
          i = paramInt;
        }
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i(ncc.jdField_a_of_type_JavaLangString, 2, "Exception:" + str);
      }
      paramInt = 0;
      continue;
      localBidPkg = new OfflinePkg.BidPkg();
      localBidPkg.uint32_bid.set(i);
      localBidPkg.uint32_pkg_id.add(Integer.valueOf(paramInt));
      localReqBody.st_bid_pkg.add(localBidPkg);
    }
    label426:
    localReqItem.vecParam = bdpd.a(localReqBody.toByteArray());
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ncc.jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData");
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (paramRespItem.cResult != 2) {
        break label279;
      }
      if (paramRespItem.eServiceID == 127)
      {
        paramRespItem = bdpd.b(paramRespItem.vecUpdate);
        if (paramRespItem != null) {
          localRspBody = new OfflinePkg.RspBody();
        }
      }
    }
    label279:
    while (!QLog.isColorLevel()) {
      try
      {
        OfflinePkg.RspBody localRspBody;
        localRspBody.mergeFrom(paramRespItem);
        ncc.a(new String(localRspBody.str_expire_pkg.get().toByteArray(), "UTF-8"));
        ncc.a(new String(localRspBody.str_predown_pkg_ex.get().toByteArray(), "UTF-8"), (QQAppInterface)localObject, ((QQAppInterface)localObject).getApp().getApplicationContext(), 1);
        ThreadManager.getSubThreadHandler().postDelayed(new OfflineExpire.OfflineExpireCheckUpdate.1(this), 180000L);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramRespItem)
      {
        for (;;)
        {
          paramRespItem.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i(ncc.jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData: " + QLog.getStackTraceString(paramRespItem));
          }
        }
      }
      catch (UnsupportedEncodingException paramRespItem)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i(ncc.jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData: " + QLog.getStackTraceString(paramRespItem));
          }
        }
      }
      catch (Exception paramRespItem)
      {
        for (;;)
        {
          paramRespItem.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i(ncc.jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData: " + QLog.getStackTraceString(paramRespItem));
          }
        }
      }
    }
    QLog.d(ncc.jdField_a_of_type_JavaLangString, 2, "***handleCheckUpdateItemData fail respitem.cResult:" + paramRespItem.cResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nce
 * JD-Core Version:    0.7.0.1
 */