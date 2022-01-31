package com.tencent.mobileqq.extendfriend;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.bean.GroupInfo;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.ReqBody;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo.RspBody;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.ReqBody;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.RspBody;
import com.tencent.pb.profilecard.EditExtendFriendInfo.ReqBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x5e3.oidb_0xb4a.GroupInfo;
import tencent.im.oidb.cmd0x5e3.oidb_0xb4a.ReqBody;
import tencent.im.oidb.cmd0x5e3.oidb_0xb4a.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ExtendFriendHandler
  extends BusinessHandler
{
  public static String[] a = { "http://img4.duitang.com/uploads/item/201511/26/20151126112617_vUaQf.jpeg", "http://imgsrc.baidu.com/forum/w=580/sign=6ade238c064f78f0800b9afb49300a83/6cbb60d0f703918f31df8012543d269758eec47c.jpg", "http://cdnq.duitang.com/uploads/item/201504/04/20150404H3338_N8Wir.jpeg", "http://up.qqya.com/allimg/201710-t/17-101804_132321.jpg", "http://www.qqzhi.com/uploadpic/2014-05-14/051120936.jpg", "http://f.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=3b3771dd93529822056631c7e2fa57fd/024f78f0f736afc30425727fb019ebc4b74512fa.jpg", "http://www.qqzhi.com/uploadpic/2014-10-05/161337745.jpg" };
  
  public ExtendFriendHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private Card a(String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ExtendFriendHandler", 1, "saveExtendFriendInfo uin is null");
      return null;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    Card localCard = localFriendsManager.b(paramString1);
    localCard.declaration = paramString2;
    localCard.voiceUrl = paramString3;
    if (paramInt1 != 0) {
      localCard.popularity = paramInt1;
    }
    localCard.updateTime = paramLong;
    localCard.extendFriendVoiceDuration = paramInt2;
    localFriendsManager.a(localCard);
    QLog.e("ExtendFriendHandler", 1, new Object[] { "saveExtendFriendInfo uin=%s declaration=%s voiceUrl=%s popularity=%d updateTime=%ld extendFriendVoiceDuration=%d", paramString1, paramString2, paramString3, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) });
    return localCard;
  }
  
  protected Class a()
  {
    return ExtendFriendObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (a(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      return;
      if ("OidbSvc.0xb4b".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb4c".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb51".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xb4a".equals(paramFromServiceMsg.getServiceCmd()));
    e(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    QLog.i("ExtendFriendHandler", 1, String.format("getExtendFriendInfo uin=%s", new Object[] { paramString }));
    try
    {
      Object localObject = new GetExtendFriendInfo.ReqBody();
      ((GetExtendFriendInfo.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString));
      localObject = a("OidbSvc.0xb51", 2897, 0, ((GetExtendFriendInfo.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ExtendFriendHandler", 1, "getExtendFriendInfo exception:" + paramString.getMessage());
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QLog.i("ExtendFriendHandler", 1, String.format("editExtendFriendInfo uin=%s, declaration=%s, url=%s, duration=%d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) }));
    if (!NetworkState.isNetworkConnected(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
    {
      QQToast.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131433213, 0).a();
      a(1, false, null);
      return;
    }
    try
    {
      Object localObject = new EditExtendFriendInfo.ReqBody();
      ((EditExtendFriendInfo.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString1));
      ((EditExtendFriendInfo.ReqBody)localObject).bytes_declaration.set(ByteStringMicro.copyFromUtf8(paramString2));
      ((EditExtendFriendInfo.ReqBody)localObject).bytes_voice_url.set(ByteStringMicro.copyFromUtf8(paramString3));
      ((EditExtendFriendInfo.ReqBody)localObject).uint32_voice_duration.set(paramInt);
      localObject = a("OidbSvc.0xb4b", 2891, 0, ((EditExtendFriendInfo.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString1);
      ((ToServiceMsg)localObject).extraData.putString("declaration", paramString2);
      ((ToServiceMsg)localObject).extraData.putString("url", paramString3);
      ((ToServiceMsg)localObject).extraData.putInt("duration", paramInt);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("ExtendFriendHandler", 1, "editExtendFriendInfo exception:" + paramString1.getMessage());
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, String.format("getSquareStrangerList uin=%s reqCookies=%s reqCount=%s", new Object[] { paramString, paramArrayOfByte, Integer.valueOf(paramInt) }));
    }
    try
    {
      ExtendFriendSquareInfo.ReqBody localReqBody = new ExtendFriendSquareInfo.ReqBody();
      localReqBody.uint64_uin.set(Long.parseLong(paramString));
      if (paramArrayOfByte != null) {
        localReqBody.bytes_req_page_cookies.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      localReqBody.uint32_req_num.set(paramInt);
      paramString = a("OidbSvc.0xb4c", 2892, 0, localReqBody.toByteArray());
      paramString.setTimeout(10000L);
      b(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ExtendFriendHandler", 1, "getSquareStrangerList fail.", paramString);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, String.format("getExtFrdGroupList start=%d count=%d loadMore:%b reqTs:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean2), Long.valueOf(paramLong) }));
    }
    try
    {
      Object localObject = new oidb_0xb4a.ReqBody();
      ((oidb_0xb4a.ReqBody)localObject).start.set(paramInt1);
      ((oidb_0xb4a.ReqBody)localObject).num.set(paramInt2);
      localObject = a("OidbSvc.0xb4a", 2890, 0, ((oidb_0xb4a.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putInt("fetch_start", paramInt1);
      ((ToServiceMsg)localObject).extraData.putInt("fetch_count", paramInt2);
      ((ToServiceMsg)localObject).extraData.putBoolean("fetch_loadmore", paramBoolean2);
      ((ToServiceMsg)localObject).extraData.putLong("fetch_reqTs", paramLong);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendHandler", 1, "getExtFrdGroupList fail.", localException);
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0xb4b");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0xb4c");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0xb4a");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0xb51");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramFromServiceMsg = "success";
      paramObject = paramToServiceMsg.extraData.getString("uin");
      String str1 = paramToServiceMsg.extraData.getString("declaration");
      String str2 = paramToServiceMsg.extraData.getString("url");
      int i = paramToServiceMsg.extraData.getInt("duration");
      a(paramObject, str1, str2, 0, NetConnInfoCenter.getServerTimeMillis(), i);
      bool = true;
      paramToServiceMsg = paramFromServiceMsg;
    }
    for (;;)
    {
      QLog.i("ExtendFriendHandler", 1, String.format("handleEditExtendFriendInfo %s", new Object[] { paramToServiceMsg }));
      a(1, bool, null);
      return;
      paramToServiceMsg = paramFromServiceMsg.getStringForLog();
      bool = false;
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, String.format("handleGetSquareStrangerList resultCode=%s", new Object[] { Integer.valueOf(i) }));
    }
    paramToServiceMsg = new ExtendFriendSquareInfo.RspBody();
    a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    a(2, paramFromServiceMsg.isSuccess(), paramToServiceMsg);
    ExtendFriendReport.a().c(paramFromServiceMsg.isSuccess(), i);
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i = paramFromServiceMsg.getResultCode();
    QLog.i("ExtendFriendHandler", 1, String.format("handleGetExtendFriendInfo resultCode=%d", new Object[] { Integer.valueOf(i) }));
    if (i == 1000)
    {
      Object localObject3 = new oidb_sso.OIDBSSOPkg();
      try
      {
        ((oidb_sso.OIDBSSOPkg)localObject3).mergeFrom((byte[])paramObject);
        label233:
        label254:
        long l;
        if (((oidb_sso.OIDBSSOPkg)localObject3).uint32_result.get() == 0)
        {
          bool = true;
          QLog.i("ExtendFriendHandler", 1, "handleGetExtendFriendInfo isSuccess=" + bool);
          paramFromServiceMsg = localObject2;
          if (bool)
          {
            paramFromServiceMsg = localObject2;
            if (((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.has())
            {
              paramFromServiceMsg = localObject2;
              if (((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.get() != null)
              {
                paramObject = new GetExtendFriendInfo.RspBody();
                paramObject.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.get().toByteArray());
                localObject3 = paramToServiceMsg.extraData.getString("uin");
                paramFromServiceMsg = localObject2;
                if (paramObject.uint64_uin.has())
                {
                  paramFromServiceMsg = localObject2;
                  if (String.valueOf(paramObject.uint64_uin.get()).equals(localObject3))
                  {
                    if (!paramObject.bytes_declaration.has()) {
                      break label362;
                    }
                    paramToServiceMsg = paramObject.bytes_declaration.get().toStringUtf8();
                    if (!paramObject.bytes_voice_url.has()) {
                      break label367;
                    }
                    paramFromServiceMsg = paramObject.bytes_voice_url.get().toStringUtf8();
                    if (!paramObject.uint32_popularity.has()) {
                      break label372;
                    }
                    i = paramObject.uint32_popularity.get();
                    label273:
                    if (!paramObject.uint64_update_time.has()) {
                      break label378;
                    }
                    l = paramObject.uint64_update_time.get();
                    label292:
                    if (((paramObject.uint32_is_show_card.has()) && (paramObject.uint32_is_show_card.get() == 1)) && (!paramObject.uint32_voice_duration.has())) {
                      break label384;
                    }
                  }
                }
              }
            }
          }
        }
        label384:
        for (int j = paramObject.uint32_voice_duration.get();; j = 0)
        {
          paramFromServiceMsg = a((String)localObject3, paramToServiceMsg, paramFromServiceMsg, i, l, j);
          a(3, bool, paramFromServiceMsg);
          return;
          bool = false;
          break;
          label362:
          paramToServiceMsg = null;
          break label233;
          label367:
          paramFromServiceMsg = null;
          break label254;
          label372:
          i = 0;
          break label273;
          label378:
          l = 0L;
          break label292;
        }
        boolean bool = false;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        QLog.e("ExtendFriendHandler", 1, "handleGetExtendFriendInfo exception:" + paramToServiceMsg.getMessage());
      }
    }
    for (;;)
    {
      paramFromServiceMsg = localObject1;
      break;
      QLog.e("ExtendFriendHandler", 1, String.format("handleGetExtendFriendInfo errMsg=%s", new Object[] { paramFromServiceMsg.getStringForLog() }));
    }
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(4, false, null);
      return;
    }
    Object localObject = new oidb_0xb4a.RspBody();
    int j = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    int k = paramToServiceMsg.extraData.getInt("fetch_start", 0);
    int i = paramToServiceMsg.extraData.getInt("fetch_count", 0);
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("fetch_loadmore", false);
    long l = paramToServiceMsg.extraData.getLong("fetch_reqTs", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendHandler", 2, String.format("handleGetExtFrdGroupList result:%s start=%s count=%s loadMore:%s reqTs:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Boolean.valueOf(bool2), Long.valueOf(l) }));
    }
    if (j == 0) {
      if (((oidb_0xb4a.RspBody)localObject).total_count.has())
      {
        i = ((oidb_0xb4a.RspBody)localObject).total_count.get();
        if (!((oidb_0xb4a.RspBody)localObject).group_list.has()) {
          break label310;
        }
        paramToServiceMsg = ((oidb_0xb4a.RspBody)localObject).group_list.get();
        label194:
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() != 0) && (paramToServiceMsg.size() + k < i)) {
          break label491;
        }
      }
    }
    label310:
    label485:
    label491:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
      {
        paramFromServiceMsg = new ArrayList(paramToServiceMsg.size());
        paramToServiceMsg = paramToServiceMsg.iterator();
        for (;;)
        {
          if (paramToServiceMsg.hasNext())
          {
            paramObject = (oidb_0xb4a.GroupInfo)paramToServiceMsg.next();
            localObject = new GroupInfo();
            ((GroupInfo)localObject).parseFromPb(paramObject);
            paramFromServiceMsg.add(localObject);
            continue;
            i = 0;
            break;
            paramToServiceMsg = null;
            break label194;
          }
        }
        paramToServiceMsg = paramFromServiceMsg;
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendHandler", 2, String.format("handleGetExtFrdGroupList loadOver:%b, total:%d size:%d content:", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), Integer.valueOf(paramToServiceMsg.size()), paramToServiceMsg.toString() }));
        }
        a(4, true, new Object[] { paramToServiceMsg, Boolean.valueOf(bool2), Long.valueOf(l), Boolean.valueOf(bool1) });
        paramToServiceMsg = ExtendFriendReport.a();
        if (j != 0) {
          break label485;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        paramToServiceMsg.d(bool1, j);
        return;
        paramToServiceMsg = new ArrayList(1);
        break;
        a(4, false, new Object[] { null, Boolean.valueOf(bool2), Long.valueOf(l), Boolean.valueOf(false) });
        break label412;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendHandler
 * JD-Core Version:    0.7.0.1
 */