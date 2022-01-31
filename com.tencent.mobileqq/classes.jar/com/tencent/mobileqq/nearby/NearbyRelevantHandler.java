package com.tencent.mobileqq.nearby;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.NearbyCmdHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.FansEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x5fc.ReqBody;
import tencent.im.oidb.cmd0x5fc.RspBody;
import tencent.im.oidb.cmd0x9e4.cmd0x9e4.ReqBody;
import tencent.im.oidb.cmd0x9e4.cmd0x9e4.RspBody;
import tencent.im.oidb.cmd0x9e4.cmd0x9e4.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NearbyRelevantHandler
  extends BusinessHandler
{
  protected Set a;
  
  public NearbyRelevantHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new cmd0x9e4.RspBody();
    if ((a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0) && (paramToServiceMsg.rpt_msg_uin_data.has()) && (paramToServiceMsg.rpt_msg_uin_data.size() > 0))
    {
      paramFromServiceMsg = paramToServiceMsg.rpt_msg_uin_data.get();
      paramToServiceMsg = new ArrayList();
      paramFromServiceMsg = paramFromServiceMsg.iterator();
      while (paramFromServiceMsg.hasNext())
      {
        paramObject = (cmd0x9e4.UdcUinData)paramFromServiceMsg.next();
        FansEntity localFansEntity = new FansEntity();
        localFansEntity.init(paramObject);
        paramToServiceMsg.add(localFansEntity);
      }
      a(5, true, new Object[] { paramToServiceMsg });
      return;
    }
    a(5, false, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    int i;
    label201:
    label215:
    int k;
    int j;
    label222:
    int m;
    int i1;
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
        }
        if (5 > n) {
          break label201;
        }
        i = paramToServiceMsg[4];
        if (7 > n) {
          break label436;
        }
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()))
      {
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.i("NearbyRelevantHandler", 2, "handle_oidb_0x480_9 ret=" + i);
        }
        if ((i == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          int n = paramToServiceMsg.length;
          if (4 <= n)
          {
            paramFromServiceMsg = String.valueOf(PkgTools.a(paramToServiceMsg, 0));
            if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.equals(this.b.getAccount())))
            {
              if (QLog.isColorLevel()) {
                QLog.w("NearbyRelevantHandler", 2, "handle_oidb_0x480_9 uin error");
              }
              return;
            }
          }
          i = PkgTools.a(paramToServiceMsg, 5);
          k = 7;
          j = 0;
          if (j < i)
          {
            m = k;
            if (k + 4 <= n)
            {
              m = PkgTools.a(paramToServiceMsg, k);
              i1 = k + 2;
              k = PkgTools.a(paramToServiceMsg, i1);
              i1 += 2;
              if ((m & 0xFFFF) == 40493) {
                if (k == 0)
                {
                  i = 0;
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label291:
      if (bool1)
      {
        paramToServiceMsg = this.b.a();
        if (i == 0)
        {
          bool2 = true;
          label312:
          paramToServiceMsg.a(bool2);
        }
      }
      else
      {
        if (i != 0) {
          break label421;
        }
      }
      label421:
      for (boolean bool2 = bool3;; bool2 = false)
      {
        a(6, bool1, new Boolean[] { Boolean.valueOf(bool2) });
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("NearbyRelevantHandler", 2, "handle_oidb_0x480_9, isSuccess:" + bool1);
        return;
        i = (byte)PkgTools.a(paramToServiceMsg, i1);
        bool1 = true;
        break label291;
        m = i1 + k;
        j += 1;
        k = m;
        break label222;
        bool2 = false;
        break label312;
      }
      i = 0;
      bool1 = true;
      continue;
      label436:
      i = 0;
      break label215;
      i = 0;
      bool1 = false;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    NearbyCmdHelper.d(this, 7, paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    int j = 0;
    int i = 0;
    int k = 0;
    cmd0x5fc.RspBody localRspBody = new cmd0x5fc.RspBody();
    int m = a(paramFromServiceMsg, paramObject, localRspBody);
    if (m == 0)
    {
      i = j;
      if (localRspBody.rpt_msg_event_list.has())
      {
        paramFromServiceMsg = localRspBody.rpt_msg_event_list.get();
        j = k;
        if (paramFromServiceMsg != null)
        {
          j = k;
          if (paramFromServiceMsg.size() > 0) {
            j = 1;
          }
        }
        i = j;
        if (QLog.isColorLevel())
        {
          NearbyUtils.a("handleGetNearbyUneadMsg", new Object[] { "dating", Long.valueOf(localRspBody.uint64_max_event_id.get()), Integer.valueOf(j), Long.valueOf(paramToServiceMsg.extraData.getLong("dating_lastEventId")), Long.valueOf(paramToServiceMsg.extraData.getLong("dating_readEventId")) });
          i = j;
        }
      }
      j = i;
      if (localRspBody.rpt_msg_nearby_event_list.has())
      {
        paramFromServiceMsg = localRspBody.rpt_msg_nearby_event_list.get();
        k = i;
        if (paramFromServiceMsg != null)
        {
          k = i;
          if (paramFromServiceMsg.size() > 0) {
            k = i | 0x2;
          }
        }
        j = k;
        if (QLog.isColorLevel())
        {
          NearbyUtils.a("handleGetNearbyUneadMsg", new Object[] { "rank", Integer.valueOf(k), Long.valueOf(paramToServiceMsg.extraData.getLong("rank_lastEventId")), Long.valueOf(paramToServiceMsg.extraData.getLong("rank_readEventId")) });
          j = k;
        }
      }
      i = j;
      if (localRspBody.rpt_msg_feed_event_list.has())
      {
        paramFromServiceMsg = localRspBody.rpt_msg_feed_event_list.get();
        k = j;
        if (paramFromServiceMsg != null)
        {
          k = j;
          if (paramFromServiceMsg.size() > 0) {
            k = j | 0x4;
          }
        }
        i = k;
        if (QLog.isColorLevel())
        {
          NearbyUtils.a("handleGetNearbyUneadMsg", new Object[] { "feed", Long.valueOf(localRspBody.uint64_max_fresh_event_id.get()), Integer.valueOf(k), Long.valueOf(paramToServiceMsg.extraData.getLong("feed_lastEventId")), Long.valueOf(paramToServiceMsg.extraData.getLong("feed_readEventId")) });
          i = k;
        }
      }
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("handleGetNearbyUneadMsg", new Object[] { Integer.valueOf(m), Integer.valueOf(i) });
    }
    if (i != 0) {
      this.b.a().a(i);
    }
    NearbyProcessMonitor.b(this.b.getCurrentAccountUin(), i);
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool2;
    boolean bool5;
    boolean bool4;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("NearbyRelevantHandler", 2, "handleSetNotifyOnLikeSwitch success=" + bool1);
      }
      paramFromServiceMsg = (NearByGeneralManager)this.b.getManager(160);
      bool2 = paramFromServiceMsg.a();
      bool5 = bool1;
      if (!bool1) {
        break label663;
      }
      bool4 = bool1;
      bool3 = bool1;
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramObject != null)
        {
          bool4 = bool1;
          bool3 = bool1;
          if (paramObject.uint32_result.get() == 0)
          {
            bool1 = true;
            bool4 = bool1;
            bool3 = bool1;
            if (QLog.isColorLevel())
            {
              bool4 = bool1;
              bool3 = bool1;
              QLog.i("NearbyRelevantHandler", 2, "handleSetNotifyOnLikeSwitch result=" + bool1);
            }
            bool5 = bool1;
            if (!bool1) {
              break label663;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = bool1;
            if (!paramObject.bytes_bodybuffer.has()) {
              break label663;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = bool1;
            if (paramObject.bytes_bodybuffer.get() == null) {
              break label663;
            }
            bool4 = bool1;
            bool3 = bool1;
            l = Utils.a(ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray()).getInt());
            bool4 = bool1;
            bool3 = bool1;
            if (!this.b.getCurrentAccountUin().equals(String.valueOf(l))) {
              continue;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = paramToServiceMsg.extraData.getBoolean("switch");
            bool3 = bool1;
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        long l;
        bool1 = bool4;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool3 = bool1;
          QLog.i("NearbyRelevantHandler", 2, "handleSetNotifyOnLikeSwitch ex", paramFromServiceMsg);
        }
        if (QLog.isColorLevel())
        {
          QLog.i("NearbyRelevantHandler", 2, "handleSetNotifyOnLikeSwitch result=" + false + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = false;
          bool4 = bool2;
          continue;
        }
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyRelevantHandler", 2, "handleSetNotifyOnLikeSwitch result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        }
      }
      try
      {
        paramFromServiceMsg.a(bool5);
        bool1 = bool5;
        bool2 = true;
        bool4 = bool1;
        bool3 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i("NearbyRelevantHandler", 2, "handleSetNotifyOnLikeSwitch result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool2;
          bool4 = bool1;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool2 = bool5;
        continue;
        bool3 = false;
        bool4 = bool2;
        continue;
      }
      a(14, bool3, new Boolean[] { Boolean.valueOf(bool4) });
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool4 = bool1;
      bool3 = bool1;
      if (QLog.isColorLevel())
      {
        bool4 = bool1;
        bool3 = bool1;
        QLog.i("NearbyRelevantHandler", 2, "handleSetNotifyOnLikeSwitch cur:" + this.b.getCurrentAccountUin() + " dwUin:" + l);
      }
      bool1 = bool2;
      bool2 = false;
      continue;
      label663:
      bool1 = bool2;
      bool2 = bool5;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    int i;
    label203:
    label217:
    int k;
    int j;
    label224:
    int m;
    int i1;
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
        }
        if (5 > n) {
          break label203;
        }
        i = paramToServiceMsg[4];
        if (7 > n) {
          break label457;
        }
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()))
      {
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.i("NearbyRelevantHandler", 2, "handleGetNotifyOnLikeSwitch ret=" + i);
        }
        if ((i == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          int n = paramToServiceMsg.length;
          if (4 <= n)
          {
            paramFromServiceMsg = String.valueOf(PkgTools.a(paramToServiceMsg, 0));
            if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.equals(this.b.getAccount())))
            {
              if (QLog.isColorLevel()) {
                QLog.i("NearbyRelevantHandler", 2, "handleGetNotifyOnLikeSwitch uin error");
              }
              return;
            }
          }
          i = PkgTools.a(paramToServiceMsg, 5);
          k = 7;
          j = 0;
          if (j < i)
          {
            m = k;
            if (k + 4 <= n)
            {
              m = PkgTools.a(paramToServiceMsg, k);
              i1 = k + 2;
              k = PkgTools.a(paramToServiceMsg, i1);
              i1 += 2;
              if ((m & 0xFFFF) == 42049) {
                if (k == 0)
                {
                  i = 0;
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label294:
      if (bool1)
      {
        paramToServiceMsg = (NearByGeneralManager)this.b.getManager(160);
        if (i == 0)
        {
          bool2 = true;
          label321:
          paramToServiceMsg.a(bool2);
        }
      }
      else
      {
        if (i != 0) {
          break label442;
        }
      }
      label442:
      for (boolean bool2 = bool3;; bool2 = false)
      {
        a(15, bool1, new Boolean[] { Boolean.valueOf(bool2) });
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("NearbyRelevantHandler", 2, "handleGetNotifyOnLikeSwitch, isSuccess:" + bool1 + ",sessionSwitch=" + i);
        return;
        i = (byte)PkgTools.a(paramToServiceMsg, i1);
        bool1 = true;
        break label294;
        m = i1 + k;
        j += 1;
        k = m;
        break label224;
        bool2 = false;
        break label321;
      }
      i = 0;
      bool1 = true;
      continue;
      label457:
      i = 0;
      break label217;
      i = 0;
      bool1 = false;
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          int i = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("NearbyRelevantHandler", 2, "handle_oidb_0x4ff_41933 ret=" + i);
          }
          if ((i == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
            if (4 <= paramFromServiceMsg.length)
            {
              paramFromServiceMsg = String.valueOf(PkgTools.a(paramFromServiceMsg, 0));
              if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.equals(this.b.getAccount())))
              {
                if (QLog.isColorLevel()) {
                  QLog.w("Q.dating", 2, "handle_oidb_0x4ff_41933 uin error");
                }
                return;
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          paramFromServiceMsg = paramObject;
        }
        bool = true;
      }
    }
    for (;;)
    {
      a(12, bool, Boolean.valueOf(paramToServiceMsg.extraData.getBoolean("freshnews_notify_switch", true)));
      return;
      bool = false;
    }
  }
  
  protected Class a()
  {
    return NearbyRelevantObserver.class;
  }
  
  public void a(byte paramByte)
  {
    NearbyCmdHelper.a(this, paramByte);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    label8:
    String str;
    do
    {
      do
      {
        do
        {
          break label8;
          do
          {
            return;
          } while (a(paramFromServiceMsg.getServiceCmd()));
          str = paramFromServiceMsg.getServiceCmd();
          if ("OidbSvc.0x5fc_0".equals(str))
          {
            e(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x9e4_22".equals(str))
          {
            b(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if (!"OidbSvc.0x480_9".equals(str)) {
            break;
          }
        } while (!paramToServiceMsg.extraData.getBoolean("reqFromDatingHandler", false));
        if (paramToServiceMsg.extraData.getBoolean("getNotifyOnLikeSwitch", false))
        {
          g(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
        if (!"OidbSvc.0x4ff_9".equals(str)) {
          break;
        }
      } while (!paramToServiceMsg.extraData.getBoolean("reqFromDatingHandler", false));
      if (paramToServiceMsg.extraData.getBoolean("setNotifyOnLikeSwitch", false))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    } while (!"OidbSvc.0x4ff_41993".equals(str));
    h(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString1, String paramString2, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("NearbyChatPie", 4, "notifyAutoInput, [" + paramString1 + "," + paramString2 + "," + paramObject + "," + System.currentTimeMillis() + "]");
    }
    a(8, true, new Object[] { paramString1, paramString2, paramObject });
  }
  
  public void a(List paramList)
  {
    cmd0x9e4.ReqBody localReqBody = new cmd0x9e4.ReqBody();
    try
    {
      Long.parseLong(this.b.getAccount());
      localReqBody.rpt_uint64_uins.set(paramList);
      localReqBody.uint32_req_god_flag.set(1);
      localReqBody.uint32_req_profession.set(1);
      localReqBody.uint32_req_age.set(1);
      localReqBody.uint32_req_gender.set(1);
      localReqBody.uint32_req_love_status.set(1);
      localReqBody.uint32_req_constellation.set(1);
      localReqBody.uint32_req_vip_flag.set(1);
      localReqBody.uint32_req_charm_shown.set(1);
      localReqBody.uint32_req_charm_level.set(1);
      localReqBody.uint32_req_common_label.set(1);
      b(a("OidbSvc.0x9e4_22", 2532, 22, localReqBody.toByteArray()));
      return;
    }
    catch (Exception paramList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DatingHandler", 2, "send_oidb_0x9e4_15 error", paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    short s = 0;
    if (QLog.isColorLevel()) {
      QLog.i("NearbyRelevantHandler", 2, "setNotifyOnLikeSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(9);
        long l = Long.parseLong(this.b.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          Object localObject = new byte[13];
          PkgTools.a((byte[])localObject, 0, l);
          localObject[4] = 0;
          PkgTools.a((byte[])localObject, 5, (short)1);
          PkgTools.a((byte[])localObject, 7, 42049);
          PkgTools.a((byte[])localObject, 9, (short)2);
          PkgTools.a((byte[])localObject, 11, s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("setNotifyOnLikeSwitch", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromDatingHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.profilecard.", 2, "setNotifyOnLikeSwitch ex", localException);
      }
      s = 1;
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("OidbSvc.0x9e4_22");
      this.a.add("OidbSvc.0x480_9");
      this.a.add("OidbSvc.0x4ff_9");
      this.a.add("OidbSvc.0x5fc_0");
      this.a.add("OidbSvc.0x4ff_41993");
    }
    return !this.a.contains(paramString);
  }
  
  public void b()
  {
    long l1 = ((Long)NearbySPUtil.a(this.b.getAccount(), "nearby_event_file", 4, "dating_last_event_id", Long.valueOf(0L))).longValue();
    long l2 = ((Long)NearbySPUtil.a(this.b.getAccount(), "nearby_event_file", 4, "dating_read_event_id", Long.valueOf(0L))).longValue();
    long l3 = ((Long)NearbySPUtil.a(this.b.getAccount(), "nearby_event_file", 4, "rank_last_event_seq", Long.valueOf(0L))).longValue();
    long l4 = ((Long)NearbySPUtil.a(this.b.getAccount(), "nearby_event_file", 4, "rank_read_event_seq", Long.valueOf(0L))).longValue();
    long l5 = ((Long)NearbySPUtil.a(this.b.getAccount(), "nearby_event_file", 4, "freshfeed_last_event_seq", Long.valueOf(0L))).longValue();
    long l6 = ((Long)NearbySPUtil.a(this.b.getAccount(), "nearby_event_file", 4, "freshfeed_red_event_seq", Long.valueOf(0L))).longValue();
    Object localObject = new cmd0x5fc.ReqBody();
    ((cmd0x5fc.ReqBody)localObject).uint64_last_event_id.set(l1);
    ((cmd0x5fc.ReqBody)localObject).uint64_read_event_id.set(l2);
    ((cmd0x5fc.ReqBody)localObject).uint32_fetch_count.set(30);
    ((cmd0x5fc.ReqBody)localObject).uint64_last_nearby_event_id.set(l3);
    ((cmd0x5fc.ReqBody)localObject).uint64_read_nearby_event_id.set(l4);
    ((cmd0x5fc.ReqBody)localObject).uint32_fetch_nearby_event_count.set(30);
    if (NearbySPUtil.c(this.b.getAccount()))
    {
      ((cmd0x5fc.ReqBody)localObject).uint64_last_feed_event_id.set(l5);
      ((cmd0x5fc.ReqBody)localObject).uint64_read_feed_event_id.set(l6);
      ((cmd0x5fc.ReqBody)localObject).uint32_fetch_feed_event_count.set(30);
    }
    localObject = a("OidbSvc.0x5fc_0", 1532, 0, ((cmd0x5fc.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("dating_lastEventId", l1);
    ((ToServiceMsg)localObject).extraData.putLong("dating_readEventId", l2);
    ((ToServiceMsg)localObject).extraData.putLong("rank_lastEventId", l3);
    ((ToServiceMsg)localObject).extraData.putLong("rank_readEventId", l4);
    ((ToServiceMsg)localObject).extraData.putLong("feed_lastEventId", l5);
    ((ToServiceMsg)localObject).extraData.putLong("feed_readEventId", l6);
    b((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      NearbyUtils.a("getNearbyUnreadMsg", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6) });
    }
  }
  
  public void c()
  {
    try
    {
      long l = Long.parseLong(this.b.getAccount());
      Object localObject = new byte[9];
      PkgTools.a((byte[])localObject, 0, l);
      localObject[4] = 0;
      PkgTools.a((byte[])localObject, 5, (short)1);
      PkgTools.a((byte[])localObject, 7, 42049);
      localObject = a("OidbSvc.0x480_9", 1152, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromDatingHandler", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("getNotifyOnLikeSwitch", true);
      b((ToServiceMsg)localObject);
      DatingUtil.a("getNotifyOnLikeSwitch...", new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("NearbyRelevantHandler", 2, "getNotifyOnLikeSwitch error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyRelevantHandler
 * JD-Core Version:    0.7.0.1
 */