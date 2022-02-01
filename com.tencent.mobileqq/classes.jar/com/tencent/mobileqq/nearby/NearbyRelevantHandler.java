package com.tencent.mobileqq.nearby;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.NearbyCmdHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.FansEntity;
import com.tencent.mobileqq.nearby.api.INearbyProcessMonitor;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
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
  implements INearbyRelevantHandler
{
  public static final String a = "com.tencent.mobileqq.nearby.NearbyRelevantHandler";
  private QQAppInterface a;
  protected Set<String> a;
  
  public NearbyRelevantHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new cmd0x9e4.RspBody();
    if ((parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0) && (paramToServiceMsg.rpt_msg_uin_data.has()) && (paramToServiceMsg.rpt_msg_uin_data.size() > 0))
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
      notifyUI(5, true, new Object[] { paramToServiceMsg });
      return;
    }
    notifyUI(5, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
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
        paramFromServiceMsg.printStackTrace();
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()))
      {
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handle_oidb_0x480_9 ret=");
          paramFromServiceMsg.append(i);
          QLog.i("NearbyRelevantHandler", 2, paramFromServiceMsg.toString());
        }
        if ((i == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          int n = paramToServiceMsg.length;
          if (4 <= n)
          {
            paramFromServiceMsg = String.valueOf(PkgTools.getLongData(paramToServiceMsg, 0));
            if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
            {
              if (QLog.isColorLevel()) {
                QLog.w("NearbyRelevantHandler", 2, "handle_oidb_0x480_9 uin error");
              }
              return;
            }
          }
          if (5 <= n) {
            i = paramToServiceMsg[4];
          }
          if (7 <= n) {
            i = PkgTools.getShortData(paramToServiceMsg, 5);
          } else {
            i = 0;
          }
          int j = 0;
          int m;
          for (int k = 7; j < i; k = m)
          {
            m = k;
            if (k + 4 <= n)
            {
              m = PkgTools.getShortData(paramToServiceMsg, k);
              int i1 = k + 2;
              k = PkgTools.getShortData(paramToServiceMsg, i1);
              i1 += 2;
              if ((m & 0xFFFF) == 40493)
              {
                if (k == 0) {
                  break;
                }
                i = (byte)PkgTools.getShortData(paramToServiceMsg, i1);
                bool1 = true;
                break label347;
              }
              m = i1 + k;
            }
            j += 1;
          }
          bool1 = true;
          break label344;
        }
      }
    }
    boolean bool1 = false;
    label344:
    int i = 0;
    label347:
    boolean bool2;
    if (bool1)
    {
      paramToServiceMsg = NearbyManagerHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (i == 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      paramToServiceMsg.a(bool2);
    }
    if (i == 0) {
      bool2 = bool3;
    } else {
      bool2 = false;
    }
    notifyUI(6, bool1, new Boolean[] { Boolean.valueOf(bool2) });
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle_oidb_0x480_9, isSuccess:");
      paramToServiceMsg.append(bool1);
      QLog.d("NearbyRelevantHandler", 2, paramToServiceMsg.toString());
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    NearbyCmdHelper.d(this, 7, paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      cmd0x5fc.RspBody localRspBody = new cmd0x5fc.RspBody();
      int m = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      int k;
      if (m == 0)
      {
        int j;
        if (localRspBody.rpt_msg_event_list.has())
        {
          paramFromServiceMsg = localRspBody.rpt_msg_event_list.get();
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0)) {
            i = 1;
          } else {
            i = 0;
          }
          j = i;
          if (QLog.isColorLevel())
          {
            NearbyUtils.a("handleGetNearbyUneadMsg", new Object[] { "dating", Long.valueOf(localRspBody.uint64_max_event_id.get()), Integer.valueOf(i), Long.valueOf(paramToServiceMsg.extraData.getLong("dating_lastEventId")), Long.valueOf(paramToServiceMsg.extraData.getLong("dating_readEventId")) });
            j = i;
          }
        }
        else
        {
          j = 0;
        }
        int i = j;
        if (localRspBody.rpt_msg_nearby_event_list.has())
        {
          paramFromServiceMsg = localRspBody.rpt_msg_nearby_event_list.get();
          k = j;
          if (paramFromServiceMsg != null)
          {
            k = j;
            if (paramFromServiceMsg.size() > 0) {
              k = j | 0x2;
            }
          }
          i = k;
          if (QLog.isColorLevel())
          {
            NearbyUtils.a("handleGetNearbyUneadMsg", new Object[] { "rank", Integer.valueOf(k), Long.valueOf(paramToServiceMsg.extraData.getLong("rank_lastEventId")), Long.valueOf(paramToServiceMsg.extraData.getLong("rank_readEventId")) });
            i = k;
          }
        }
        k = i;
        if (localRspBody.rpt_msg_feed_event_list.has())
        {
          paramFromServiceMsg = localRspBody.rpt_msg_feed_event_list.get();
          j = i;
          if (paramFromServiceMsg != null)
          {
            j = i;
            if (paramFromServiceMsg.size() > 0) {
              j = i | 0x4;
            }
          }
          k = j;
          if (QLog.isColorLevel())
          {
            NearbyUtils.a("handleGetNearbyUneadMsg", new Object[] { "feed", Long.valueOf(localRspBody.uint64_max_fresh_event_id.get()), Integer.valueOf(j), Long.valueOf(paramToServiceMsg.extraData.getLong("feed_lastEventId")), Long.valueOf(paramToServiceMsg.extraData.getLong("feed_readEventId")) });
            k = j;
          }
        }
      }
      else
      {
        k = 0;
      }
      if (QLog.isColorLevel()) {
        NearbyUtils.a("handleGetNearbyUneadMsg", new Object[] { Integer.valueOf(m), Integer.valueOf(k) });
      }
      if (k != 0) {
        NearbyManagerHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(k);
      }
      ((INearbyProcessMonitor)QRoute.api(INearbyProcessMonitor.class)).reportCheckNearbyUnreadFlag(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), k);
    }
  }
  
  /* Error */
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 316	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_3
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore 5
    //   14: goto +6 -> 20
    //   17: iconst_0
    //   18: istore 5
    //   20: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +36 -> 59
    //   26: new 125	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   33: astore_2
    //   34: aload_2
    //   35: ldc_w 318
    //   38: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: iload 5
    //   45: invokevirtual 211	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: ldc 137
    //   51: iconst_2
    //   52: aload_2
    //   53: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 145	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: getfield 23	com/tencent/mobileqq/nearby/NearbyRelevantHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   63: getstatic 324	com/tencent/mobileqq/app/QQManagerFactory:NEARBY_GENERAL_MANAGER	I
    //   66: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   69: checkcast 330	com/tencent/mobileqq/nearby/INearByGeneralManager
    //   72: astore_2
    //   73: aload_2
    //   74: invokeinterface 332 1 0
    //   79: istore 10
    //   81: iload 10
    //   83: istore 6
    //   85: iload 5
    //   87: istore 4
    //   89: iload 5
    //   91: ifeq +670 -> 761
    //   94: iload 5
    //   96: istore 8
    //   98: iload 10
    //   100: istore 7
    //   102: iload 5
    //   104: istore 9
    //   106: new 97	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   109: dup
    //   110: invokespecial 98	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   113: aload_3
    //   114: checkcast 334	[B
    //   117: checkcast 334	[B
    //   120: invokevirtual 106	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   123: checkcast 97	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   126: astore_3
    //   127: aload_3
    //   128: ifnull +732 -> 860
    //   131: iload 5
    //   133: istore 8
    //   135: iload 10
    //   137: istore 7
    //   139: iload 5
    //   141: istore 9
    //   143: aload_3
    //   144: getfield 113	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   147: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   150: ifne +710 -> 860
    //   153: iconst_1
    //   154: istore 5
    //   156: goto +3 -> 159
    //   159: iload 5
    //   161: istore 8
    //   163: iload 10
    //   165: istore 7
    //   167: iload 5
    //   169: istore 9
    //   171: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +88 -> 262
    //   177: iload 5
    //   179: istore 8
    //   181: iload 10
    //   183: istore 7
    //   185: iload 5
    //   187: istore 9
    //   189: new 125	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   196: astore 13
    //   198: iload 5
    //   200: istore 8
    //   202: iload 10
    //   204: istore 7
    //   206: iload 5
    //   208: istore 9
    //   210: aload 13
    //   212: ldc_w 336
    //   215: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: iload 5
    //   221: istore 8
    //   223: iload 10
    //   225: istore 7
    //   227: iload 5
    //   229: istore 9
    //   231: aload 13
    //   233: iload 5
    //   235: invokevirtual 211	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: iload 5
    //   241: istore 8
    //   243: iload 10
    //   245: istore 7
    //   247: iload 5
    //   249: istore 9
    //   251: ldc 137
    //   253: iconst_2
    //   254: aload 13
    //   256: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 145	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: iload 10
    //   264: istore 6
    //   266: iload 5
    //   268: istore 4
    //   270: iload 5
    //   272: ifeq +489 -> 761
    //   275: iload 5
    //   277: istore 8
    //   279: iload 10
    //   281: istore 7
    //   283: iload 5
    //   285: istore 9
    //   287: iload 10
    //   289: istore 6
    //   291: iload 5
    //   293: istore 4
    //   295: aload_3
    //   296: getfield 149	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   299: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   302: ifeq +459 -> 761
    //   305: iload 5
    //   307: istore 8
    //   309: iload 10
    //   311: istore 7
    //   313: iload 5
    //   315: istore 9
    //   317: iload 10
    //   319: istore 6
    //   321: iload 5
    //   323: istore 4
    //   325: aload_3
    //   326: getfield 149	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   329: invokevirtual 155	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   332: ifnull +429 -> 761
    //   335: iload 5
    //   337: istore 8
    //   339: iload 10
    //   341: istore 7
    //   343: iload 5
    //   345: istore 9
    //   347: aload_3
    //   348: getfield 149	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   351: invokevirtual 155	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   354: invokevirtual 160	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   357: invokestatic 342	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   360: invokevirtual 345	java/nio/ByteBuffer:getInt	()I
    //   363: invokestatic 350	com/tencent/mobileqq/util/Utils:a	(I)J
    //   366: lstore 11
    //   368: iload 5
    //   370: istore 8
    //   372: iload 10
    //   374: istore 7
    //   376: iload 5
    //   378: istore 9
    //   380: aload_0
    //   381: getfield 23	com/tencent/mobileqq/nearby/NearbyRelevantHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   384: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   387: lload 11
    //   389: invokestatic 172	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   392: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   395: ifeq +53 -> 448
    //   398: iload 5
    //   400: istore 8
    //   402: iload 10
    //   404: istore 7
    //   406: iload 5
    //   408: istore 9
    //   410: aload_1
    //   411: getfield 256	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   414: ldc_w 352
    //   417: invokevirtual 356	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   420: istore 6
    //   422: iload 5
    //   424: istore 8
    //   426: iload 6
    //   428: istore 7
    //   430: iload 5
    //   432: istore 9
    //   434: aload_2
    //   435: iload 6
    //   437: invokeinterface 357 2 0
    //   442: iconst_1
    //   443: istore 4
    //   445: goto +316 -> 761
    //   448: iload 5
    //   450: istore 8
    //   452: iload 10
    //   454: istore 7
    //   456: iload 5
    //   458: istore 9
    //   460: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   463: ifeq +128 -> 591
    //   466: iload 5
    //   468: istore 8
    //   470: iload 10
    //   472: istore 7
    //   474: iload 5
    //   476: istore 9
    //   478: new 125	java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   485: astore_2
    //   486: iload 5
    //   488: istore 8
    //   490: iload 10
    //   492: istore 7
    //   494: iload 5
    //   496: istore 9
    //   498: aload_2
    //   499: ldc_w 359
    //   502: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: iload 5
    //   508: istore 8
    //   510: iload 10
    //   512: istore 7
    //   514: iload 5
    //   516: istore 9
    //   518: aload_2
    //   519: aload_0
    //   520: getfield 23	com/tencent/mobileqq/nearby/NearbyRelevantHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   523: invokevirtual 306	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   526: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: iload 5
    //   532: istore 8
    //   534: iload 10
    //   536: istore 7
    //   538: iload 5
    //   540: istore 9
    //   542: aload_2
    //   543: ldc_w 361
    //   546: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: iload 5
    //   552: istore 8
    //   554: iload 10
    //   556: istore 7
    //   558: iload 5
    //   560: istore 9
    //   562: aload_2
    //   563: lload 11
    //   565: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: iload 5
    //   571: istore 8
    //   573: iload 10
    //   575: istore 7
    //   577: iload 5
    //   579: istore 9
    //   581: ldc 137
    //   583: iconst_2
    //   584: aload_2
    //   585: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 145	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   591: iconst_0
    //   592: istore 4
    //   594: iload 10
    //   596: istore 6
    //   598: goto +163 -> 761
    //   601: astore_2
    //   602: goto +95 -> 697
    //   605: astore_2
    //   606: iload 9
    //   608: istore 8
    //   610: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   613: ifeq +17 -> 630
    //   616: iload 9
    //   618: istore 8
    //   620: ldc 137
    //   622: iconst_2
    //   623: ldc_w 366
    //   626: aload_2
    //   627: invokestatic 369	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   630: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   633: ifeq +58 -> 691
    //   636: new 125	java/lang/StringBuilder
    //   639: dup
    //   640: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   643: astore_2
    //   644: aload_2
    //   645: ldc_w 336
    //   648: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: aload_2
    //   653: iconst_0
    //   654: invokevirtual 211	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: aload_2
    //   659: ldc_w 371
    //   662: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: aload_2
    //   667: aload_1
    //   668: getfield 256	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   671: ldc_w 352
    //   674: invokevirtual 356	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   677: invokevirtual 211	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: ldc 137
    //   683: iconst_2
    //   684: aload_2
    //   685: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 145	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   691: iconst_0
    //   692: istore 5
    //   694: goto +145 -> 839
    //   697: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   700: ifeq +59 -> 759
    //   703: new 125	java/lang/StringBuilder
    //   706: dup
    //   707: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   710: astore_3
    //   711: aload_3
    //   712: ldc_w 336
    //   715: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload_3
    //   720: iload 8
    //   722: invokevirtual 211	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload_3
    //   727: ldc_w 371
    //   730: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: pop
    //   734: aload_3
    //   735: aload_1
    //   736: getfield 256	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   739: ldc_w 352
    //   742: invokevirtual 356	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   745: invokevirtual 211	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: ldc 137
    //   751: iconst_2
    //   752: aload_3
    //   753: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   756: invokestatic 145	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   759: aload_2
    //   760: athrow
    //   761: iload 6
    //   763: istore 7
    //   765: iload 4
    //   767: istore 5
    //   769: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   772: ifeq +67 -> 839
    //   775: new 125	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   782: astore_2
    //   783: aload_2
    //   784: ldc_w 336
    //   787: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: pop
    //   791: aload_2
    //   792: iload 4
    //   794: invokevirtual 211	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   797: pop
    //   798: aload_2
    //   799: ldc_w 371
    //   802: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: pop
    //   806: aload_2
    //   807: aload_1
    //   808: getfield 256	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   811: ldc_w 352
    //   814: invokevirtual 356	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   817: invokevirtual 211	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   820: pop
    //   821: ldc 137
    //   823: iconst_2
    //   824: aload_2
    //   825: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: invokestatic 145	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   831: iload 4
    //   833: istore 5
    //   835: iload 6
    //   837: istore 7
    //   839: aload_0
    //   840: bipush 14
    //   842: iload 5
    //   844: iconst_1
    //   845: anewarray 203	java/lang/Boolean
    //   848: dup
    //   849: iconst_0
    //   850: iload 7
    //   852: invokestatic 206	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   855: aastore
    //   856: invokevirtual 87	com/tencent/mobileqq/nearby/NearbyRelevantHandler:notifyUI	(IZLjava/lang/Object;)V
    //   859: return
    //   860: iconst_0
    //   861: istore 5
    //   863: goto -704 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	866	0	this	NearbyRelevantHandler
    //   0	866	1	paramToServiceMsg	ToServiceMsg
    //   0	866	2	paramFromServiceMsg	FromServiceMsg
    //   0	866	3	paramObject	Object
    //   87	745	4	bool1	boolean
    //   12	850	5	bool2	boolean
    //   83	753	6	bool3	boolean
    //   100	751	7	bool4	boolean
    //   96	625	8	bool5	boolean
    //   104	513	9	bool6	boolean
    //   79	516	10	bool7	boolean
    //   366	198	11	l	long
    //   196	59	13	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   106	127	601	finally
    //   143	153	601	finally
    //   171	177	601	finally
    //   189	198	601	finally
    //   210	219	601	finally
    //   231	239	601	finally
    //   251	262	601	finally
    //   295	305	601	finally
    //   325	335	601	finally
    //   347	368	601	finally
    //   380	398	601	finally
    //   410	422	601	finally
    //   434	442	601	finally
    //   460	466	601	finally
    //   478	486	601	finally
    //   498	506	601	finally
    //   518	530	601	finally
    //   542	550	601	finally
    //   562	569	601	finally
    //   581	591	601	finally
    //   610	616	601	finally
    //   620	630	601	finally
    //   106	127	605	java/lang/Exception
    //   143	153	605	java/lang/Exception
    //   171	177	605	java/lang/Exception
    //   189	198	605	java/lang/Exception
    //   210	219	605	java/lang/Exception
    //   231	239	605	java/lang/Exception
    //   251	262	605	java/lang/Exception
    //   295	305	605	java/lang/Exception
    //   325	335	605	java/lang/Exception
    //   347	368	605	java/lang/Exception
    //   380	398	605	java/lang/Exception
    //   410	422	605	java/lang/Exception
    //   434	442	605	java/lang/Exception
    //   460	466	605	java/lang/Exception
    //   478	486	605	java/lang/Exception
    //   498	506	605	java/lang/Exception
    //   518	530	605	java/lang/Exception
    //   542	550	605	java/lang/Exception
    //   562	569	605	java/lang/Exception
    //   581	591	605	java/lang/Exception
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
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
        paramFromServiceMsg.printStackTrace();
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()))
      {
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleGetNotifyOnLikeSwitch ret=");
          paramFromServiceMsg.append(i);
          QLog.i("NearbyRelevantHandler", 2, paramFromServiceMsg.toString());
        }
        if ((i == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          int n = paramToServiceMsg.length;
          if (4 <= n)
          {
            paramFromServiceMsg = String.valueOf(PkgTools.getLongData(paramToServiceMsg, 0));
            if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
            {
              if (QLog.isColorLevel()) {
                QLog.i("NearbyRelevantHandler", 2, "handleGetNotifyOnLikeSwitch uin error");
              }
              return;
            }
          }
          if (5 <= n) {
            i = paramToServiceMsg[4];
          }
          if (7 <= n) {
            i = PkgTools.getShortData(paramToServiceMsg, 5);
          } else {
            i = 0;
          }
          int j = 0;
          int m;
          for (int k = 7; j < i; k = m)
          {
            m = k;
            if (k + 4 <= n)
            {
              m = PkgTools.getShortData(paramToServiceMsg, k);
              int i1 = k + 2;
              k = PkgTools.getShortData(paramToServiceMsg, i1);
              i1 += 2;
              if ((m & 0xFFFF) == 42049)
              {
                if (k == 0) {
                  break;
                }
                i = (byte)PkgTools.getShortData(paramToServiceMsg, i1);
                bool1 = true;
                break label350;
              }
              m = i1 + k;
            }
            j += 1;
          }
          bool1 = true;
          break label347;
        }
      }
    }
    boolean bool1 = false;
    label347:
    int i = 0;
    label350:
    boolean bool2;
    if (bool1)
    {
      paramToServiceMsg = (INearByGeneralManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER);
      if (i == 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      paramToServiceMsg.a(bool2);
    }
    if (i == 0) {
      bool2 = bool3;
    } else {
      bool2 = false;
    }
    notifyUI(15, bool1, new Boolean[] { Boolean.valueOf(bool2) });
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetNotifyOnLikeSwitch, isSuccess:");
      paramToServiceMsg.append(bool1);
      paramToServiceMsg.append(",sessionSwitch=");
      paramToServiceMsg.append(i);
      QLog.i("NearbyRelevantHandler", 2, paramToServiceMsg.toString());
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFromServiceMsg != null)
    {
      bool1 = bool2;
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        paramObject = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
          paramFromServiceMsg = paramObject;
        }
        bool1 = bool2;
        if (paramFromServiceMsg != null)
        {
          bool1 = bool2;
          if (paramFromServiceMsg.uint32_result.has())
          {
            int i = paramFromServiceMsg.uint32_result.get();
            if (QLog.isColorLevel())
            {
              paramObject = new StringBuilder();
              paramObject.append("handle_oidb_0x4ff_41933 ret=");
              paramObject.append(i);
              QLog.i("NearbyRelevantHandler", 2, paramObject.toString());
            }
            bool1 = bool2;
            if (i == 0)
            {
              bool1 = bool2;
              if (paramFromServiceMsg.bytes_bodybuffer.has())
              {
                bool1 = bool2;
                if (paramFromServiceMsg.bytes_bodybuffer.get() != null)
                {
                  paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
                  if (4 <= paramFromServiceMsg.length)
                  {
                    paramFromServiceMsg = String.valueOf(PkgTools.getLongData(paramFromServiceMsg, 0));
                    if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.w("Q.dating", 2, "handle_oidb_0x4ff_41933 uin error");
                      }
                      return;
                    }
                  }
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    notifyUI(12, bool1, Boolean.valueOf(paramToServiceMsg.extraData.getBoolean("freshnews_notify_switch", true)));
  }
  
  public void a()
  {
    Object localObject = (INearbySPUtil)QRoute.api(INearbySPUtil.class);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    Long localLong = Long.valueOf(0L);
    long l2 = ((Long)((INearbySPUtil)localObject).getValue(str, "nearby_event_file", 4, "dating_last_event_id", localLong)).longValue();
    long l3 = ((Long)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "nearby_event_file", 4, "dating_read_event_id", localLong)).longValue();
    long l4 = ((Long)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "nearby_event_file", 4, "rank_last_event_seq", localLong)).longValue();
    long l5 = ((Long)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "nearby_event_file", 4, "rank_read_event_seq", localLong)).longValue();
    long l1 = ((Long)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "nearby_event_file", 4, "freshfeed_last_event_seq", localLong)).longValue();
    long l6 = ((Long)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "nearby_event_file", 4, "freshfeed_red_event_seq", localLong)).longValue();
    localObject = new cmd0x5fc.ReqBody();
    ((cmd0x5fc.ReqBody)localObject).uint64_last_event_id.set(l2);
    ((cmd0x5fc.ReqBody)localObject).uint64_read_event_id.set(l3);
    ((cmd0x5fc.ReqBody)localObject).uint32_fetch_count.set(30);
    ((cmd0x5fc.ReqBody)localObject).uint64_last_nearby_event_id.set(l4);
    ((cmd0x5fc.ReqBody)localObject).uint64_read_nearby_event_id.set(l5);
    ((cmd0x5fc.ReqBody)localObject).uint32_fetch_nearby_event_count.set(30);
    if (((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getNotifySwitchState(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()))
    {
      ((cmd0x5fc.ReqBody)localObject).uint64_last_feed_event_id.set(l1);
      ((cmd0x5fc.ReqBody)localObject).uint64_read_feed_event_id.set(l6);
      ((cmd0x5fc.ReqBody)localObject).uint32_fetch_feed_event_count.set(30);
    }
    localObject = makeOIDBPkg("OidbSvc.0x5fc_0", 1532, 0, ((cmd0x5fc.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("dating_lastEventId", l2);
    ((ToServiceMsg)localObject).extraData.putLong("dating_readEventId", l3);
    ((ToServiceMsg)localObject).extraData.putLong("rank_lastEventId", l4);
    ((ToServiceMsg)localObject).extraData.putLong("rank_readEventId", l5);
    ((ToServiceMsg)localObject).extraData.putLong("feed_lastEventId", l1);
    ((ToServiceMsg)localObject).extraData.putLong("feed_readEventId", l6);
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      NearbyUtils.a("getNearbyUnreadMsg", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l1), Long.valueOf(l6) });
    }
  }
  
  public void a(byte paramByte)
  {
    NearbyCmdHelper.a(this, paramByte);
  }
  
  public void a(String paramString1, String paramString2, Object paramObject)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyAutoInput, [");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(",");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("]");
      QLog.i("NearbyChatPie", 4, localStringBuilder.toString());
    }
    notifyUI(8, true, new Object[] { paramString1, paramString2, paramObject });
  }
  
  public void a(List<Long> paramList)
  {
    cmd0x9e4.ReqBody localReqBody = new cmd0x9e4.ReqBody();
    try
    {
      Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
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
      sendPbReq(makeOIDBPkg("OidbSvc.0x9e4_22", 2532, 22, localReqBody.toByteArray()));
      return;
    }
    catch (Exception paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DatingHandler", 2, "send_oidb_0x9e4_15 error", paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setNotifyOnLikeSwitch OPEN=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.i("NearbyRelevantHandler", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          s = 0;
          Object localObject2 = new byte[13];
          PkgTools.dWord2Byte((byte[])localObject2, 0, l);
          localObject2[4] = 0;
          PkgTools.word2Byte((byte[])localObject2, 5, (short)1);
          PkgTools.dWordTo2Bytes((byte[])localObject2, 7, 42049);
          PkgTools.word2Byte((byte[])localObject2, 9, (short)2);
          PkgTools.word2Byte((byte[])localObject2, 11, s);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject2));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject2).extraData.putBoolean("setNotifyOnLikeSwitch", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromDatingHandler", true);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, "setNotifyOnLikeSwitch ex", localException);
        }
        return;
      }
      short s = 1;
    }
  }
  
  public void b()
  {
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      Object localObject = new byte[9];
      PkgTools.dWord2Byte((byte[])localObject, 0, l);
      localObject[4] = 0;
      PkgTools.word2Byte((byte[])localObject, 5, (short)1);
      PkgTools.dWordTo2Bytes((byte[])localObject, 7, 42049);
      localObject = makeOIDBPkg("OidbSvc.0x480_9", 1152, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromDatingHandler", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("getNotifyOnLikeSwitch", true);
      sendPbReq((ToServiceMsg)localObject);
      DatingUtil.a("getNotifyOnLikeSwitch...", new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NearbyRelevantHandler", 2, "getNotifyOnLikeSwitch error", localException);
      }
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9e4_22");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x480_9");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x4ff_9");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5fc_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x4ff_41993");
    }
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return NearbyRelevantObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
        return;
      }
      String str = paramFromServiceMsg.getServiceCmd();
      if ("OidbSvc.0x5fc_0".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9e4_22".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x480_9".equals(str))
      {
        if (paramToServiceMsg.extraData.getBoolean("reqFromDatingHandler", false))
        {
          if (paramToServiceMsg.extraData.getBoolean("getNotifyOnLikeSwitch", false))
          {
            f(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
      else if ("OidbSvc.0x4ff_9".equals(str))
      {
        if (paramToServiceMsg.extraData.getBoolean("reqFromDatingHandler", false))
        {
          if (paramToServiceMsg.extraData.getBoolean("setNotifyOnLikeSwitch", false))
          {
            e(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
      else if ("OidbSvc.0x4ff_41993".equals(str)) {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyRelevantHandler
 * JD-Core Version:    0.7.0.1
 */