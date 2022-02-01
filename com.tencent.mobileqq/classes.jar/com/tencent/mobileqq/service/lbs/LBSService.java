package com.tencent.mobileqq.service.lbs;

import EncounterSvc.GPS;
import EncounterSvc.ReqGetRecommender;
import EncounterSvc.ReqUserInfo;
import EncounterSvc.RespGetRecommender;
import EncounterSvc.UserData;
import NearbyGroup.ReqGetAreaList;
import NearbyGroup.RspGetAreaList;
import NearbyGroup.RspGetNearbyGroup;
import NeighborComm.LocalInfoType;
import NeighborComm.RespHeader;
import NeighborComm.SOSO_Cell;
import NeighborComm.SOSO_Wifi;
import NeighborSvc.ReqGetSwitches;
import NeighborSvc.ReqSetStateSwitch;
import NeighborSvc.RespGetSwitches;
import NeighborSvc.RespSetStateSwitch;
import QQService.FaceInfo;
import QQService.ReqDelFace;
import QQService.ReqDeleteVisitorRecord;
import QQService.ReqGetCardSwitch;
import QQService.ReqGetFavoriteList;
import QQService.ReqGetVoterList;
import QQService.ReqPicSafetyCheck;
import QQService.ReqSetCardSwitch;
import QQService.RespDelFace;
import QQService.RespDeleteVisitorRecord;
import QQService.RespGetCardSwitch;
import QQService.RespGetFavoriteList;
import QQService.RespGetVoterList;
import QQService.RespHead;
import QQService.RespSetCard;
import QQService.RespSetCardSwitch;
import QQService.UserCntlData;
import SummaryCard.CondFitUser;
import SummaryCard.ReqCondSearch;
import SummaryCard.ReqSearch;
import SummaryCard.ReqSummaryCard;
import SummaryCard.RespCondSearch;
import SummaryCard.RespSearch;
import SummaryCard.RespSummaryCard;
import SummaryCardTaf.SSummaryCardLableRsp;
import SummaryCardTaf.SSummaryCardLikeIt;
import SummaryCardTaf.SSummaryCardSetLabel;
import addcontacts.AccountSearchPb.Location;
import addcontacts.AccountSearchPb.hotwordrecord;
import addcontacts.AccountSearchPb.record;
import addcontacts.AccountSearchPb.search;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.NearbyCmdHelper;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.search.business.addcontact.model.SearchResult;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoCell;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.soso.location.data.SosoWifi;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.LoginSig;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class LBSService
  extends BaseProtocolCoder
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "NeighborSvc", "KQQFS", "MCardSvc", "MobileQQ", "EncounterSvc", "VisitorSvc", "LBS", "SummaryCard", "NearbyGroup", "NeighborRecommender" };
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public UserData[] a;
  
  public LBSService()
  {
    this.jdField_a_of_type_ArrayOfEncounterSvcUserData = new UserData[2];
  }
  
  public static RspGetAreaList a(byte[] paramArrayOfByte)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    try
    {
      localUniPacket.decode(paramArrayOfByte);
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return (RspGetAreaList)localUniPacket.getByClass("RspGetAreaList", new RspGetAreaList());
  }
  
  public static RspGetNearbyGroup a(byte[] paramArrayOfByte)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    try
    {
      localUniPacket.decode(paramArrayOfByte);
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return (RspGetNearbyGroup)localUniPacket.getByClass("RspGetNearbyGroup", new RspGetNearbyGroup());
  }
  
  public static ReqSummaryCard a(ToServiceMsg paramToServiceMsg)
  {
    Object localObject4 = paramToServiceMsg;
    long l3 = ((ToServiceMsg)localObject4).extraData.getLong("selfUin");
    long l4 = ((ToServiceMsg)localObject4).extraData.getLong("targetUin", 0L);
    int n = ((ToServiceMsg)localObject4).extraData.getInt("comeFromType", 0);
    long l5 = ((ToServiceMsg)localObject4).extraData.getLong("qzoneFeedTimeStamp", 0L);
    byte b1 = ((ToServiceMsg)localObject4).extraData.getByte("isFriend");
    long l1 = ((ToServiceMsg)localObject4).extraData.getLong("troopCode", 0L);
    long l6 = ((ToServiceMsg)localObject4).extraData.getLong("troopUin", 0L);
    String str = ((ToServiceMsg)localObject4).extraData.getString("strSearchName");
    long l7 = ((ToServiceMsg)localObject4).extraData.getLong("lGetControl");
    int i1 = ((ToServiceMsg)localObject4).extraData.getInt("bReqCommLabel");
    int i = ((ToServiceMsg)localObject4).extraData.getInt("EAddFriendSource");
    long l8 = ((ToServiceMsg)localObject4).extraData.getLong("tinyId");
    long l9 = ((ToServiceMsg)localObject4).extraData.getLong("likeSource");
    byte b2 = ((ToServiceMsg)localObject4).extraData.getByte("bReqExtendCard");
    Object localObject1 = ((ToServiceMsg)localObject4).extraData.getParcelableArrayList("busiList");
    Object localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = new ArrayList();
    }
    localObject1 = ((ToServiceMsg)localObject4).extraData.getByteArray("vSeed");
    if (localObject1 == null)
    {
      localObject1 = new byte[1];
      localObject1[0] = 0;
    }
    Object localObject5 = ((ToServiceMsg)localObject4).extraData.getByteArray("vSecureSig");
    Object localObject2 = localObject5;
    if (localObject5 == null)
    {
      localObject2 = new byte[1];
      localObject2[0] = 0;
    }
    byte b3 = ((ToServiceMsg)localObject4).extraData.getByte("bReqMedalWallInfo");
    localObject5 = ((ToServiceMsg)localObject4).extraData.getIntegerArrayList("req0x5ebFieldIdList");
    localObject4 = ((ToServiceMsg)localObject4).extraData.getByteArray("vReqTemplateInfo");
    int j;
    try
    {
      j = Integer.parseInt("5295");
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, localNumberFormatException.toString());
      }
      j = 0;
    }
    ArrayList localArrayList = new ArrayList();
    int k = i;
    long l2 = l1;
    if (l4 > 0L)
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      for (;;)
      {
        k = i;
        l2 = l1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        BusinessReqBuffer localBusinessReqBuffer = (BusinessReqBuffer)((Iterator)localObject3).next();
        Object localObject6 = new SummaryCardBusiEntry.comm();
        ((SummaryCardBusiEntry.comm)localObject6).ver.set(1);
        ((SummaryCardBusiEntry.comm)localObject6).seq.set(paramToServiceMsg.getAppSeq());
        ((SummaryCardBusiEntry.comm)localObject6).fromuin.set(l3);
        ((SummaryCardBusiEntry.comm)localObject6).touin.set(l4);
        ((SummaryCardBusiEntry.comm)localObject6).service.set(localBusinessReqBuffer.getBusinessType());
        ((SummaryCardBusiEntry.comm)localObject6).platform.set(2);
        ((SummaryCardBusiEntry.comm)localObject6).qqver.set("8.7.0.5295");
        ((SummaryCardBusiEntry.comm)localObject6).build.set(j);
        if ((localBusinessReqBuffer.getBusinessType() == 17) || (localBusinessReqBuffer.getBusinessType() == 19) || (localBusinessReqBuffer.getBusinessType() == 18))
        {
          ((SummaryCardBusiEntry.comm)localObject6).msg_login_sig.setHasFlag(true);
          ((SummaryCardBusiEntry.comm)localObject6).msg_login_sig.uint32_type.set(8);
          ((SummaryCardBusiEntry.comm)localObject6).msg_login_sig.uint32_appid.set(16);
          localObject7 = paramToServiceMsg.extraData.getString("msg_login_sig");
          if ((!TextUtils.isEmpty((CharSequence)localObject7)) && (!HexUtil.emptybytes.equals(localObject7))) {
            ((SummaryCardBusiEntry.comm)localObject6).msg_login_sig.bytes_sig.set(ByteStringMicro.copyFromUtf8((String)localObject7));
          } else {
            QLog.d("LBSService", 1, "MiniAppSummaryCard buildReqSummaryCard SummaryCardBusiEntry.MINI_APP_SERVICE set A2 failed");
          }
        }
        localObject6 = ((SummaryCardBusiEntry.comm)localObject6).toByteArray();
        int m = localObject6.length;
        if (localBusinessReqBuffer.getBuffer() != null) {
          k = localBusinessReqBuffer.getBuffer().length;
        } else {
          k = 0;
        }
        Object localObject7 = new byte[m + 9 + k + 1];
        localObject7[0] = 40;
        PkgTools.dWord2Byte((byte[])localObject7, 1, m);
        PkgTools.dWord2Byte((byte[])localObject7, 5, k);
        PkgTools.copyData((byte[])localObject7, 9, (byte[])localObject6, m);
        m = 9 + localObject6.length;
        k = m;
        if (localBusinessReqBuffer.getBuffer() != null)
        {
          PkgTools.copyData((byte[])localObject7, m, localBusinessReqBuffer.getBuffer(), localBusinessReqBuffer.getBuffer().length);
          k = m + localBusinessReqBuffer.getBuffer().length;
        }
        localObject7[k] = 41;
        localArrayList.add(localObject7);
      }
    }
    return new ReqSummaryCard(l4, n, l5, b1, l2, l6, (byte[])localObject1, str, l7, k, (byte[])localObject2, null, (byte[])localObject4, null, localArrayList, l8, l9, null, b3, (ArrayList)localObject5, (byte)1, (byte)i1, b2, null, 1L);
  }
  
  private Object a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = (RespSetStateSwitch)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSetStateSwitch", new RespSetStateSwitch());
    if (paramFromServiceMsg != null) {
      return paramFromServiceMsg;
    }
    return null;
  }
  
  public static ArrayList<SearchResult> a(ArrayList<byte[]> paramArrayList)
  {
    ArrayList localArrayList;
    int i;
    Object localObject1;
    int j;
    int k;
    int n;
    int i1;
    byte[] arrayOfByte;
    Object localObject2;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localArrayList = new ArrayList(6);
      int m = paramArrayList.size();
      i = 0;
      if (i < m)
      {
        localObject1 = (byte[])paramArrayList.get(i);
        if (localObject1 == null) {
          j = 0;
        } else {
          j = localObject1.length;
        }
        if (j > 10)
        {
          k = 1;
          int i2 = (int)PkgTools.getLongData((byte[])localObject1, 1);
          n = (int)PkgTools.getLongData((byte[])localObject1, 5);
          if (i2 > 0)
          {
            i1 = 9 + i2;
            if (i1 < j)
            {
              arrayOfByte = new byte[i2];
              PkgTools.copyData(arrayOfByte, 0, (byte[])localObject1, 9, i2);
              localObject2 = new SummaryCardBusiEntry.comm();
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        ((SummaryCardBusiEntry.comm)localObject2).mergeFrom(arrayOfByte);
        j = ((SummaryCardBusiEntry.comm)localObject2).result.get();
        if (j == 0)
        {
          j = ((SummaryCardBusiEntry.comm)localObject2).service.get();
          localObject2 = new byte[n];
          PkgTools.copyData((byte[])localObject2, 0, (byte[])localObject1, i1, n);
          localObject1 = new AccountSearchPb.search();
          ((AccountSearchPb.search)localObject1).mergeFrom((byte[])localObject2);
          localObject2 = new SearchResult();
          ((SearchResult)localObject2).jdField_a_of_type_Int = j;
          ((SearchResult)localObject2).jdField_b_of_type_Int = ((AccountSearchPb.search)localObject1).start.get();
          if (((AccountSearchPb.search)localObject1).end.get() != 1) {
            break label652;
          }
          bool = true;
          ((SearchResult)localObject2).jdField_a_of_type_Boolean = bool;
          ((SearchResult)localObject2).jdField_b_of_type_JavaUtilList = ((AccountSearchPb.search)localObject1).list.get();
          ((SearchResult)localObject2).jdField_a_of_type_JavaUtilList = ((AccountSearchPb.search)localObject1).highlight.get();
          ((SearchResult)localObject2).jdField_a_of_type_JavaLangString = ((AccountSearchPb.search)localObject1).article_more_url.get();
          ((SearchResult)localObject2).jdField_a_of_type_AddcontactsAccountSearchPb$hotwordrecord = ((AccountSearchPb.hotwordrecord)((AccountSearchPb.search)localObject1).hotword_record.get());
          ((SearchResult)localObject2).jdField_c_of_type_JavaUtilList = ((AccountSearchPb.search)localObject1).result_items.get();
          ((SearchResult)localObject2).jdField_b_of_type_Boolean = ((AccountSearchPb.search)localObject1).bool_keyword_suicide.get();
          ((SearchResult)localObject2).jdField_c_of_type_Boolean = ((AccountSearchPb.search)localObject1).bool_exact_search.get();
          if (((((SearchResult)localObject2).jdField_b_of_type_JavaUtilList != null) && (((SearchResult)localObject2).jdField_b_of_type_JavaUtilList.size() > 0)) || ((((SearchResult)localObject2).jdField_c_of_type_JavaUtilList != null) && (((SearchResult)localObject2).jdField_c_of_type_JavaUtilList.size() > 0)) || (((SearchResult)localObject2).jdField_b_of_type_Boolean))
          {
            localArrayList.add(localObject2);
            if (j == 80000000)
            {
              localObject1 = ((AccountSearchPb.search)localObject1).list.get().iterator();
              if (((Iterator)localObject1).hasNext())
              {
                localObject2 = (AccountSearchPb.record)((Iterator)localObject1).next();
                if (((AccountSearchPb.record)localObject2).sign.get() == null) {
                  continue;
                }
                ((AccountSearchPb.record)localObject2).richStatus = RichStatus.parseStatus(((AccountSearchPb.record)localObject2).sign.get().toByteArray());
                continue;
              }
            }
            else if ((j == 80000001) && (((AccountSearchPb.search)localObject1).bool_location_group.has()))
            {
              if (!((AccountSearchPb.search)localObject1).bool_location_group.get()) {
                break label658;
              }
              j = k;
              ((SearchResult)localObject2).jdField_c_of_type_Int = j;
            }
          }
        }
        else if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("busi entry, [");
          ((StringBuilder)localObject1).append(((SummaryCardBusiEntry.comm)localObject2).service.get());
          ((StringBuilder)localObject1).append(",");
          ((StringBuilder)localObject1).append(j);
          ((StringBuilder)localObject1).append(",");
          ((StringBuilder)localObject1).append(((SummaryCardBusiEntry.comm)localObject2).err_msg.get());
          QLog.i("Q.profilecard.SummaryCard", 4, ((StringBuilder)localObject1).toString());
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, localException.toString());
        }
      }
      i += 1;
      break;
      return localArrayList;
      return null;
      label652:
      boolean bool = false;
      continue;
      label658:
      j = 2;
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespGetVoterList)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetVoterList", new RespGetVoterList());
    if (paramToServiceMsg.stHeader.iReplyCode != 0)
    {
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
  }
  
  public static boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    SummaryCard.ReqHead localReqHead = new SummaryCard.ReqHead();
    localReqHead.iVersion = 2;
    paramUniPacket.setServantName("SummaryCardServantObj");
    paramUniPacket.setFuncName("ReqSummaryCard");
    paramUniPacket.put("ReqHead", localReqHead);
    paramUniPacket.put("ReqSummaryCard", a(paramToServiceMsg));
    paramToServiceMsg.setTimeout(30000L);
    paramToServiceMsg.setServiceCmd("SummaryCard.ReqSummaryCard");
    return true;
  }
  
  private Object b(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = (RespGetSwitches)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetSwitches", new RespGetSwitches());
    if (paramFromServiceMsg != null) {
      return paramFromServiceMsg;
    }
    return null;
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespGetFavoriteList)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetFavoriteList", new RespGetFavoriteList());
    if (paramToServiceMsg.stHeader.iReplyCode != 0)
    {
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfuin");
    Object localObject2 = paramToServiceMsg.extraData.getByteArray("filekey");
    long l2 = paramToServiceMsg.extraData.getLong("timestamp");
    Object localObject1 = new QQService.ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)0, (byte)0, null);
    localObject2 = new FaceInfo((byte[])localObject2, 0);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject2);
    localObject1 = new ReqDelFace((QQService.ReqHead)localObject1, (int)l2, localArrayList);
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqDelFace");
    paramUniPacket.put("ReqDelFace", localObject1);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqDelFace");
    return true;
  }
  
  private Object c(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = a(paramFromServiceMsg.getWupBuffer());
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.eReplyCode == 0)) {
      this.jdField_a_of_type_ArrayOfByte = paramFromServiceMsg.vContext;
    }
    return paramFromServiceMsg;
  }
  
  private void c(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespDeleteVisitorRecord)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespDeleteVisitorRecord", new RespDeleteVisitorRecord());
    if (paramToServiceMsg.stHeader.iReplyCode != 0)
    {
      paramFromServiceMsg.setMsgFail();
      return;
    }
    paramFromServiceMsg.setMsgSuccess();
    paramFromServiceMsg.getAttributes().put("result", paramToServiceMsg);
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int i = paramToServiceMsg.extraData.getInt("lat");
    int j = paramToServiceMsg.extraData.getInt("lon");
    int k = paramToServiceMsg.extraData.getInt("radius");
    paramToServiceMsg = new ReqGetAreaList();
    paramToServiceMsg.iLat = i;
    paramToServiceMsg.iLon = j;
    paramToServiceMsg.iRadius = k;
    paramToServiceMsg.vClientVersion = "8.7.0".getBytes();
    paramToServiceMsg.uiClientType = 2L;
    paramUniPacket.setServantName("NearbyGroup");
    paramUniPacket.setFuncName("ReqGetAreaList");
    paramUniPacket.put("ReqGetAreaList", paramToServiceMsg);
    return true;
  }
  
  private Object d(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = a(paramFromServiceMsg.getWupBuffer());
    if (paramFromServiceMsg != null) {
      return paramFromServiceMsg;
    }
    return null;
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return true;
  }
  
  private Object e(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespHeader)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHeader", new RespHeader());
    if ((paramToServiceMsg != null) && (paramToServiceMsg.eReplyCode == 0))
    {
      paramFromServiceMsg = (RespGetRecommender)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetRecommender", new RespGetRecommender());
    }
    else
    {
      if (QLog.isColorLevel())
      {
        if (paramToServiceMsg == null) {
          paramFromServiceMsg = "decodeNearbyRecommender respHeader is null";
        } else {
          paramFromServiceMsg = String.valueOf(paramToServiceMsg.eReplyCode);
        }
        QLog.i("LBS", 2, paramFromServiceMsg);
      }
      paramFromServiceMsg = null;
    }
    return new Object[] { paramToServiceMsg, paramFromServiceMsg };
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSService", 2, "handleGetNearbyRecommender");
    }
    Object localObject2 = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getRawSosoInfo();
    Object localObject1;
    if ((localObject2 != null) && (((SosoLbsInfo)localObject2).mLocation != null) && (((SosoLbsInfo)localObject2).mLocation.mLat84 != 0.0D))
    {
      localObject1 = localObject2;
      if (((SosoLbsInfo)localObject2).mLocation.mLon84 != 0.0D) {}
    }
    else
    {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).reqRawLbsData(60000L, getClass().getSimpleName());
      localObject1 = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getRawSosoInfo();
    }
    if (localObject1 != null)
    {
      localObject2 = new NeighborComm.ReqHeader();
      ((NeighborComm.ReqHeader)localObject2).shVersion = 2;
      ((NeighborComm.ReqHeader)localObject2).lMID = createUserId(Long.parseLong(paramToServiceMsg.getUin()));
      ((NeighborComm.ReqHeader)localObject2).iAppID = AppSetting.a();
      ((NeighborComm.ReqHeader)localObject2).eBusiType = 0;
      ((NeighborComm.ReqHeader)localObject2).eMqqSysType = 2;
      ReqUserInfo localReqUserInfo = new ReqUserInfo();
      localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
      localReqUserInfo.strAuthPassword = "NzVK_qGE";
      localReqUserInfo.eListType = 0;
      localReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_SOSO.value();
      localReqUserInfo.stGps = new GPS((int)(((SosoLbsInfo)localObject1).mLocation.mLat84 * 1000000.0D), (int)(((SosoLbsInfo)localObject1).mLocation.mLon84 * 1000000.0D), -1, 0);
      localReqUserInfo.vSOSOCells = new ArrayList();
      Object localObject3;
      if (((SosoLbsInfo)localObject1).mCells != null)
      {
        localObject3 = ((SosoLbsInfo)localObject1).mCells.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          SosoCell localSosoCell = (SosoCell)((Iterator)localObject3).next();
          localReqUserInfo.vSOSOCells.add(new SOSO_Cell((short)localSosoCell.mMcc, (short)localSosoCell.mMnc, localSosoCell.mLac, localSosoCell.mCellId, (short)localSosoCell.mRss));
        }
      }
      localReqUserInfo.vSOSOMac = new ArrayList();
      if (((SosoLbsInfo)localObject1).mWifis != null)
      {
        localObject1 = ((SosoLbsInfo)localObject1).mWifis.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (SosoWifi)((Iterator)localObject1).next();
          localReqUserInfo.vSOSOMac.add(new SOSO_Wifi(((SosoWifi)localObject3).mMac, (short)((SosoWifi)localObject3).mRssi));
        }
      }
      localObject1 = new ReqGetRecommender();
      ((ReqGetRecommender)localObject1).stUserInfo = localReqUserInfo;
      ((ReqGetRecommender)localObject1).eTimingType = paramToServiceMsg.extraData.getInt("timingType");
      paramUniPacket.setEncodeName("utf-8");
      paramUniPacket.setServantName("EncounterObj");
      paramUniPacket.setFuncName("CMD_GET_RECOMMENDER");
      paramUniPacket.put("ReqHeader", localObject2);
      paramUniPacket.put("ReqGetRecommender", localObject1);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LBSService", 2, "handleGetNearbyRecommender lbsinfo is null");
    }
    paramToServiceMsg.extraData.putBoolean("isLbsInfoNull", true);
    return false;
  }
  
  private Object f(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespSummaryCard)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSummaryCard", new RespSummaryCard());
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new NeighborSvc.ReqHeader();
    ((NeighborSvc.ReqHeader)localObject).shVersion = 2;
    ((NeighborSvc.ReqHeader)localObject).lMID = createUserId(Long.parseLong(paramToServiceMsg.getUin()));
    ((NeighborSvc.ReqHeader)localObject).iAppID = AppSetting.a();
    localObject = new ReqSetStateSwitch((NeighborSvc.ReqHeader)localObject, (byte)paramToServiceMsg.extraData.getBoolean("k_be_share", false));
    paramUniPacket.setServantName("NeighborObj");
    paramUniPacket.setFuncName("CMD_SET_STATE_SWITCH");
    paramUniPacket.put("ReqSetStateSwitch", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("NeighborSvc.ReqSetStateSwitch");
    return true;
  }
  
  private Object g(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    RespSearch localRespSearch = (RespSearch)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSearch", new RespSearch());
    int i = paramToServiceMsg.extraData.getInt("search_version");
    if (i == 2) {
      return localRespSearch;
    }
    paramFromServiceMsg = localRespSearch;
    if (i == 3)
    {
      boolean bool = paramToServiceMsg.extraData.getBoolean("search_decode");
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("decodeSearchFriend | needDecode = ");
        paramFromServiceMsg.append(bool);
        QLog.d("LBSService", 2, paramFromServiceMsg.toString());
      }
      if (bool) {
        return a(localRespSearch.vvRespServices);
      }
      paramFromServiceMsg = localRespSearch.vvRespServices;
    }
    return paramFromServiceMsg;
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new NeighborSvc.ReqHeader();
    ((NeighborSvc.ReqHeader)localObject).shVersion = 2;
    ((NeighborSvc.ReqHeader)localObject).lMID = createUserId(Long.parseLong(paramToServiceMsg.getUin()));
    ((NeighborSvc.ReqHeader)localObject).iAppID = AppSetting.a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(64));
    localObject = new ReqGetSwitches((NeighborSvc.ReqHeader)localObject, localArrayList);
    paramUniPacket.setServantName("NeighborObj");
    paramUniPacket.setFuncName("CMD_GET_SWITCHES");
    paramUniPacket.put("ReqGetSwitches", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("NeighborSvc.ReqGetSwitches");
    return true;
  }
  
  private Object h(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = (RespCondSearch)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespCondSearch", new RespCondSearch());
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.vUserList != null) && (!paramFromServiceMsg.vUserList.isEmpty()))
    {
      int i = 0;
      while (i < paramFromServiceMsg.vUserList.size())
      {
        paramToServiceMsg = (CondFitUser)paramFromServiceMsg.vUserList.get(i);
        String str1 = ConditionSearchManager.a(paramToServiceMsg.dwCountry);
        String str2 = ConditionSearchManager.a(paramToServiceMsg.dwProvince);
        String str3 = ConditionSearchManager.a(paramToServiceMsg.dwCity);
        paramToServiceMsg.locDesc = ((ConditionSearchManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).b(new String[] { str1, str2, str3, "0" });
        i += 1;
      }
    }
    return paramFromServiceMsg;
  }
  
  /* Error */
  private boolean h(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    // Byte code:
    //   0: new 628	QQService/ReqHead
    //   3: dup
    //   4: invokespecial 1025	QQService/ReqHead:<init>	()V
    //   7: astore 8
    //   9: aload 8
    //   11: iconst_2
    //   12: putfield 1026	QQService/ReqHead:shVersion	S
    //   15: aload 8
    //   17: aload_2
    //   18: invokevirtual 631	com/qq/jce/wup/UniPacket:getRequestId	()I
    //   21: putfield 1029	QQService/ReqHead:iSeq	I
    //   24: aload 8
    //   26: aload_1
    //   27: invokevirtual 772	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   30: invokestatic 777	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   33: putfield 1032	QQService/ReqHead:lUIN	J
    //   36: aload_1
    //   37: getfield 104	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   40: ldc_w 1034
    //   43: invokevirtual 148	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   46: istore 4
    //   48: aload_1
    //   49: getfield 104	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   52: ldc_w 1036
    //   55: invokevirtual 131	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   58: istore_3
    //   59: aload_1
    //   60: getfield 104	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   63: ldc_w 1038
    //   66: invokevirtual 171	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   69: astore 9
    //   71: aload_1
    //   72: getfield 104	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   75: ldc_w 1040
    //   78: invokevirtual 171	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   81: astore 10
    //   83: new 1042	java/io/ObjectInputStream
    //   86: dup
    //   87: new 1044	java/io/ByteArrayInputStream
    //   90: dup
    //   91: aload_1
    //   92: getfield 104	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   95: ldc_w 1046
    //   98: invokevirtual 171	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   101: invokespecial 1048	java/io/ByteArrayInputStream:<init>	([B)V
    //   104: invokespecial 1051	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: invokevirtual 1054	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   110: checkcast 164	java/util/ArrayList
    //   113: astore 6
    //   115: new 1042	java/io/ObjectInputStream
    //   118: dup
    //   119: new 1044	java/io/ByteArrayInputStream
    //   122: dup
    //   123: aload_1
    //   124: getfield 104	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   127: ldc_w 1056
    //   130: invokevirtual 171	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   133: invokespecial 1048	java/io/ByteArrayInputStream:<init>	([B)V
    //   136: invokespecial 1051	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   139: invokevirtual 1054	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   142: checkcast 164	java/util/ArrayList
    //   145: astore 5
    //   147: new 1042	java/io/ObjectInputStream
    //   150: dup
    //   151: new 1044	java/io/ByteArrayInputStream
    //   154: dup
    //   155: aload_1
    //   156: getfield 104	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   159: ldc_w 1058
    //   162: invokevirtual 171	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   165: invokespecial 1048	java/io/ByteArrayInputStream:<init>	([B)V
    //   168: invokespecial 1051	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   171: invokevirtual 1054	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   174: checkcast 164	java/util/ArrayList
    //   177: astore 7
    //   179: goto +33 -> 212
    //   182: astore 7
    //   184: goto +20 -> 204
    //   187: astore 7
    //   189: aconst_null
    //   190: astore 5
    //   192: goto +12 -> 204
    //   195: astore 7
    //   197: aconst_null
    //   198: astore 6
    //   200: aload 6
    //   202: astore 5
    //   204: aload 7
    //   206: invokevirtual 1059	java/lang/Exception:printStackTrace	()V
    //   209: aconst_null
    //   210: astore 7
    //   212: new 1061	QQService/ReqSetCard
    //   215: dup
    //   216: aload 8
    //   218: iload 4
    //   220: iload_3
    //   221: aload 6
    //   223: aload 9
    //   225: aload 5
    //   227: aload 7
    //   229: aload 10
    //   231: invokespecial 1064	QQService/ReqSetCard:<init>	(LQQService/ReqHead;IBLjava/util/ArrayList;[BLjava/util/ArrayList;Ljava/util/ArrayList;[B)V
    //   234: astore 5
    //   236: aload_2
    //   237: ldc 19
    //   239: invokevirtual 587	com/qq/jce/wup/UniPacket:setServantName	(Ljava/lang/String;)V
    //   242: aload_2
    //   243: ldc_w 1066
    //   246: invokevirtual 592	com/qq/jce/wup/UniPacket:setFuncName	(Ljava/lang/String;)V
    //   249: aload_2
    //   250: ldc_w 1066
    //   253: aload 5
    //   255: invokevirtual 597	com/qq/jce/wup/UniPacket:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   258: aload_1
    //   259: ldc2_w 647
    //   262: invokevirtual 604	com/tencent/qphone/base/remote/ToServiceMsg:setTimeout	(J)V
    //   265: aload_1
    //   266: ldc_w 1068
    //   269: invokevirtual 609	com/tencent/qphone/base/remote/ToServiceMsg:setServiceCmd	(Ljava/lang/String;)V
    //   272: iconst_1
    //   273: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	LBSService
    //   0	274	1	paramToServiceMsg	ToServiceMsg
    //   0	274	2	paramUniPacket	UniPacket
    //   58	163	3	b	byte
    //   46	173	4	i	int
    //   145	109	5	localObject	Object
    //   113	109	6	localArrayList1	ArrayList
    //   177	1	7	localArrayList2	ArrayList
    //   182	1	7	localException1	Exception
    //   187	1	7	localException2	Exception
    //   195	10	7	localException3	Exception
    //   210	18	7	localArrayList3	ArrayList
    //   7	210	8	localReqHead	QQService.ReqHead
    //   69	155	9	arrayOfByte1	byte[]
    //   81	149	10	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   147	179	182	java/lang/Exception
    //   115	147	187	java/lang/Exception
    //   83	115	195	java/lang/Exception
  }
  
  private Object i(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespSetCard)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSetCard", new RespSetCard());
  }
  
  private boolean i(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    try
    {
      Object localObject = (List)paramToServiceMsg.extraData.getSerializable("labels");
      if (localObject != null)
      {
        SSummaryCardSetLabel localSSummaryCardSetLabel = new SSummaryCardSetLabel();
        localSSummaryCardSetLabel.cmd = 4;
        localSSummaryCardSetLabel.uin = Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        localSSummaryCardSetLabel.version = "8.7.0";
        localSSummaryCardSetLabel.platform = 109L;
        localSSummaryCardSetLabel.labels = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localSSummaryCardSetLabel.labels.add(((Iterator)localObject).next());
        }
        paramUniPacket.setServantName("SummaryCard");
        paramUniPacket.setFuncName("SetLabel");
        paramUniPacket.put("SSummaryCardSetLabel", localSSummaryCardSetLabel);
        paramToServiceMsg.setTimeout(10000L);
        paramToServiceMsg.setServiceCmd("SummaryCard.SetLabel");
        return true;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
    return false;
  }
  
  private Object j(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (SSummaryCardLableRsp)decodePacket(paramFromServiceMsg.getWupBuffer(), "SSummaryCardLableRsp", new SSummaryCardLableRsp());
  }
  
  private boolean j(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    try
    {
      SSummaryCardLikeIt localSSummaryCardLikeIt = new SSummaryCardLikeIt();
      localSSummaryCardLikeIt.cmd = 3;
      localSSummaryCardLikeIt.uin = paramToServiceMsg.extraData.getLong("selfUin");
      localSSummaryCardLikeIt.likeuin = paramToServiceMsg.extraData.getLong("destUin");
      localSSummaryCardLikeIt.label = paramToServiceMsg.extraData.getLong("labelId");
      localSSummaryCardLikeIt.platform = 109L;
      localSSummaryCardLikeIt.version = "8.7.0";
      paramUniPacket.setServantName("SummaryCard");
      paramUniPacket.setFuncName("LikeIt");
      paramUniPacket.put("SSummaryCardLikeIt", localSSummaryCardLikeIt);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("SummaryCard.LikeIt");
      return true;
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
    return false;
  }
  
  private Object k(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (SSummaryCardLableRsp)decodePacket(paramFromServiceMsg.getWupBuffer(), "SSummaryCardLableRsp", new SSummaryCardLableRsp());
  }
  
  private boolean k(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new QQService.ReqHead();
    ((QQService.ReqHead)localObject).shVersion = 2;
    ((QQService.ReqHead)localObject).iSeq = paramUniPacket.getRequestId();
    ((QQService.ReqHead)localObject).lUIN = Long.parseLong(paramToServiceMsg.getUin());
    localObject = new ReqGetCardSwitch((QQService.ReqHead)localObject);
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqGetCardSwitch");
    paramUniPacket.put("ReqGetCardSwitch", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqGetCardSwitch");
    return true;
  }
  
  private Object l(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespSetCardSwitch)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSetCardSwitch", new RespSetCardSwitch());
  }
  
  private boolean l(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new QQService.ReqHead();
    ((QQService.ReqHead)localObject).shVersion = 2;
    ((QQService.ReqHead)localObject).iSeq = paramUniPacket.getRequestId();
    ((QQService.ReqHead)localObject).lUIN = Long.parseLong(paramToServiceMsg.getUin());
    boolean bool = paramToServiceMsg.extraData.getBoolean("modify_switch_for_near_people", true);
    long l = paramToServiceMsg.extraData.getLong("target_value");
    if (bool) {
      localObject = new ReqSetCardSwitch((QQService.ReqHead)localObject, l, 2L);
    } else {
      localObject = new ReqSetCardSwitch((QQService.ReqHead)localObject, 2L, l);
    }
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqSetCardSwitch");
    paramUniPacket.put("ReqSetCardSwitch", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqSetCardSwitch");
    return true;
  }
  
  private Object m(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespGetCardSwitch)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetCardSwitch", new RespGetCardSwitch());
  }
  
  private boolean m(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfUin");
    long l2 = paramToServiceMsg.extraData.getLong("targetUin");
    int i = paramToServiceMsg.extraData.getInt("type");
    ReqDeleteVisitorRecord localReqDeleteVisitorRecord = new ReqDeleteVisitorRecord(new QQService.ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, null), l2, i);
    paramUniPacket.setServantName("VisitorSvc");
    paramUniPacket.setFuncName("ReqDeleteVisitorRecord");
    paramUniPacket.put("ReqDeleteVisitorRecord", localReqDeleteVisitorRecord);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("VisitorSvc.ReqDeleteVisitorRecord");
    return true;
  }
  
  private boolean n(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg.extraData.getLong("selfUin");
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("nextMid");
    int i = paramToServiceMsg.extraData.getInt("pageSize");
    Object localObject = new QQService.ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, null);
    UserCntlData localUserCntlData = new UserCntlData(l2, new byte[0]);
    if (i >= 54) {
      i = 30;
    }
    localObject = new ReqGetVoterList((QQService.ReqHead)localObject, localUserCntlData, i);
    paramUniPacket.setServantName("VisitorSvc");
    paramUniPacket.setFuncName("ReqGetVoterList");
    paramUniPacket.put("ReqGetVoterList", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("VisitorSvc.ReqGetVoterList");
    return true;
  }
  
  private boolean o(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("nextMid");
    int i = paramToServiceMsg.extraData.getInt("pageSize");
    Object localObject = new QQService.ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, null);
    UserCntlData localUserCntlData = new UserCntlData(l2, new byte[0]);
    if (i >= 54) {
      i = 30;
    }
    localObject = new ReqGetFavoriteList((QQService.ReqHead)localObject, localUserCntlData, i);
    paramUniPacket.setServantName("VisitorSvc");
    paramUniPacket.setFuncName("ReqGetFavoriteList");
    paramUniPacket.put("ReqGetFavoriteList", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("VisitorSvc.ReqGetFavoriteList");
    return true;
  }
  
  private boolean p(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("lToUIN");
    int i = paramToServiceMsg.extraData.getInt("iScene");
    ReqPicSafetyCheck localReqPicSafetyCheck = new ReqPicSafetyCheck(new QQService.ReqHead(l, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, null), l, i);
    paramUniPacket.setServantName("MCardSvc");
    paramUniPacket.setFuncName("ReqPicSafetyCheck");
    paramUniPacket.put("ReqPicSafetyCheck", localReqPicSafetyCheck);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("MCardSvc.ReqPicSafetyCheck");
    return true;
  }
  
  private boolean q(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.extraData.getString("param_keyword");
    Object localObject1 = paramToServiceMsg.extraData.getString("param_country_code");
    double d2 = paramToServiceMsg.extraData.getDouble("search_longtitude");
    double d1 = paramToServiceMsg.extraData.getDouble("search_latitude");
    int[] arrayOfInt = paramToServiceMsg.extraData.getIntArray("search_list");
    int j = paramToServiceMsg.extraData.getInt("search_page");
    int n = paramToServiceMsg.extraData.getInt("search_version");
    int i1 = paramToServiceMsg.extraData.getInt("filter_type", 0);
    if ((n != 2) && (n == 3))
    {
      localObject2 = new ArrayList();
      int i;
      try
      {
        i = Integer.parseInt("5295");
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, localNumberFormatException.toString());
        }
        i = 0;
      }
      int k = arrayOfInt.length;
      int m = 0;
      for (;;)
      {
        Object localObject3 = this;
        if (m >= k) {
          break;
        }
        Object localObject4 = new SummaryCardBusiEntry.comm();
        ((SummaryCardBusiEntry.comm)localObject4).ver.set(1);
        ((SummaryCardBusiEntry.comm)localObject4).seq.set(paramToServiceMsg.getAppSeq());
        ((SummaryCardBusiEntry.comm)localObject4).service.set(arrayOfInt[m]);
        if (arrayOfInt[m] == 80000004)
        {
          ((SummaryCardBusiEntry.comm)localObject4).msg_login_sig.setHasFlag(true);
          ((SummaryCardBusiEntry.comm)localObject4).msg_login_sig.uint32_type.set(64);
          localObject5 = (TicketManager)((LBSService)localObject3).jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
          if (localObject5 != null)
          {
            localObject3 = ((TicketManager)localObject5).getA2(((LBSService)localObject3).jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
            if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!HexUtil.emptybytes.equals(localObject3))) {
              ((SummaryCardBusiEntry.comm)localObject4).msg_login_sig.bytes_sig.set(ByteStringMicro.copyFromUtf8((String)localObject3));
            }
          }
        }
        ((SummaryCardBusiEntry.comm)localObject4).platform.set(2);
        ((SummaryCardBusiEntry.comm)localObject4).qqver.set("8.7.0.5295");
        ((SummaryCardBusiEntry.comm)localObject4).build.set(i);
        localObject3 = ((SummaryCardBusiEntry.comm)localObject4).toByteArray();
        int i3 = localObject3.length;
        localObject4 = new AccountSearchPb.search();
        ((AccountSearchPb.search)localObject4).start.set(j);
        if (arrayOfInt[m] == 80000001) {
          ((AccountSearchPb.search)localObject4).count.set(4);
        } else if (arrayOfInt[m] == 80000003) {
          ((AccountSearchPb.search)localObject4).count.set(8);
        }
        ((AccountSearchPb.search)localObject4).keyword.set(str);
        ((AccountSearchPb.search)localObject4).highlight.add(str);
        Object localObject5 = new AccountSearchPb.Location();
        ((AccountSearchPb.Location)localObject5).double_longitude.set(d2);
        ((AccountSearchPb.Location)localObject5).double_latitude.set(d1);
        ((AccountSearchPb.search)localObject4).msg_user_location.set((MessageMicro)localObject5);
        ((AccountSearchPb.search)localObject4).filtertype.set(i1);
        if (QLog.isDevelopLevel())
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("request has set filtertype ");
          ((StringBuilder)localObject5).append(i1);
          QLog.d("LBSService", 4, ((StringBuilder)localObject5).toString());
        }
        localObject4 = ((AccountSearchPb.search)localObject4).toByteArray();
        int i2 = localObject4.length;
        localObject5 = new byte[i3 + 9 + i2 + 1];
        localObject5[0] = 40;
        PkgTools.dWord2Byte((byte[])localObject5, 1, i3);
        PkgTools.dWord2Byte((byte[])localObject5, 5, i2);
        PkgTools.copyData((byte[])localObject5, 9, (byte[])localObject3, i3);
        i3 = 9 + localObject3.length;
        PkgTools.copyData((byte[])localObject5, i3, (byte[])localObject4, i2);
        localObject5[(i3 + i2)] = 41;
        ((ArrayList)localObject2).add(localObject5);
        m += 1;
      }
    }
    else
    {
      localObject2 = null;
    }
    localObject1 = new ReqSearch(str, (String)localObject1, n, (ArrayList)localObject2);
    Object localObject2 = new SummaryCard.ReqHead();
    ((SummaryCard.ReqHead)localObject2).iVersion = 2;
    paramUniPacket.setServantName("SummaryCardServantObj");
    paramUniPacket.setFuncName("ReqSearch");
    paramUniPacket.put("ReqHead", localObject2);
    paramUniPacket.put("ReqSearch", localObject1);
    paramToServiceMsg.setTimeout(30000L);
    paramToServiceMsg.setServiceCmd("SummaryCard.ReqSearch");
    return true;
  }
  
  private boolean r(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int i = paramToServiceMsg.extraData.getInt("param_page");
    long l = paramToServiceMsg.extraData.getLong("param_session_id");
    Object localObject1 = paramToServiceMsg.extraData.getString("param_keyword");
    int j = paramToServiceMsg.extraData.getInt("param_sex_index");
    int k = paramToServiceMsg.extraData.getInt("param_age_index1");
    int m = paramToServiceMsg.extraData.getInt("param_age_index2");
    int n = paramToServiceMsg.extraData.getInt("param_job_index");
    int i1 = paramToServiceMsg.extraData.getInt("param_xingzuo_index");
    Object localObject3 = paramToServiceMsg.extraData.getStringArray("param_loc_code");
    Object localObject2 = paramToServiceMsg.extraData.getStringArray("param_home_code");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(16);
    if ((localObject3 != null) && (localObject3.length == 4))
    {
      localByteBuffer.putInt(ConditionSearchManager.a(localObject3[0]));
      localByteBuffer.putInt(ConditionSearchManager.a(localObject3[1]));
      localByteBuffer.putInt(ConditionSearchManager.a(localObject3[2]));
      localByteBuffer.putInt(ConditionSearchManager.a(localObject3[3]));
    }
    else
    {
      localByteBuffer.putInt(0).putInt(0).putInt(0).putInt(0);
    }
    localObject3 = ByteBuffer.allocate(16);
    if ((localObject2 != null) && (localObject2.length == 4))
    {
      ((ByteBuffer)localObject3).putInt(ConditionSearchManager.a(localObject2[0]));
      ((ByteBuffer)localObject3).putInt(ConditionSearchManager.a(localObject2[1]));
      ((ByteBuffer)localObject3).putInt(ConditionSearchManager.a(localObject2[2]));
      ((ByteBuffer)localObject3).putInt(ConditionSearchManager.a(localObject2[3]));
    }
    else
    {
      ((ByteBuffer)localObject3).putInt(0).putInt(0).putInt(0).putInt(0);
    }
    short s3 = (short)k;
    short s2 = (short)m;
    short s1 = s3;
    if (s3 < 0) {
      s1 = 0;
    }
    if (s1 > s2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LBSService", 2, String.format("handleCondSearchFriend [%s, %s]--[%s, %s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Short.valueOf(s1), Short.valueOf(32767) }));
      }
      s2 = 32767;
    }
    localObject1 = new ReqCondSearch(i, l, 1L, (String)localObject1, (byte)j, localByteBuffer.array(), (short)255, ((ByteBuffer)localObject3).array(), (byte)i1, n, s1, s2);
    localObject2 = new SummaryCard.ReqHead();
    ((SummaryCard.ReqHead)localObject2).iVersion = 2;
    paramUniPacket.setServantName("SummaryCardServantObj");
    paramUniPacket.setFuncName("ReqCondSearch");
    paramUniPacket.put("ReqHead", localObject2);
    paramUniPacket.put("ReqCondSearch", localObject1);
    paramToServiceMsg.setTimeout(15000L);
    paramToServiceMsg.setServiceCmd("SummaryCard.ReqCondSearch");
    return true;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("MCardSvc.ReqDelFace".equals(paramFromServiceMsg.getServiceCmd())) {
      return (RespDelFace)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespDelFace", new RespDelFace());
    }
    if ("MCardSvc.ReqSetCard".equals(paramFromServiceMsg.getServiceCmd())) {
      return i(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.SetLabel".equals(paramFromServiceMsg.getServiceCmd())) {
      return j(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.LikeIt".equals(paramFromServiceMsg.getServiceCmd())) {
      return k(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqGetCardSwitch".equals(paramFromServiceMsg.getServiceCmd())) {
      return m(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("MCardSvc.ReqSetCardSwitch".equals(paramFromServiceMsg.getServiceCmd())) {
      return l(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.ReqSummaryCard".equals(paramFromServiceMsg.getServiceCmd())) {
      return f(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NearbyGroup.GetGroupList".equals(paramFromServiceMsg.getServiceCmd())) {
      return c(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NearbyGroup.ReqGetAreaList".equals(paramFromServiceMsg.getServiceCmd())) {
      return d(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborSvc.ReqSetStateSwitch".equals(paramFromServiceMsg.getServiceCmd())) {
      return a(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborSvc.ReqGetSwitches".equals(paramFromServiceMsg.getServiceCmd())) {
      return b(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborSvc.ReqGetPoint".equals(paramFromServiceMsg.getServiceCmd())) {
      return NearbyCmdHelper.a(this, paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.ReqSearch".equals(paramFromServiceMsg.getServiceCmd())) {
      return g(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("SummaryCard.ReqCondSearch".equals(paramFromServiceMsg.getServiceCmd())) {
      return h(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("NeighborRecommender.ReqGetRecommender".equals(paramFromServiceMsg.getServiceCmd())) {
      return e(paramFromServiceMsg, paramToServiceMsg);
    }
    if ("EncounterSvc.ReqGetEncounter".equals(paramFromServiceMsg.getServiceCmd())) {
      return NearbyCmdHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramFromServiceMsg, paramToServiceMsg, this);
    }
    return super.decode(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void decodeRespMsg(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("VisitorSvc.ReqGetVoterList".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramFromServiceMsg, paramToServiceMsg);
      return;
    }
    if ("VisitorSvc.ReqGetFavoriteList".equals(paramFromServiceMsg.getServiceCmd()))
    {
      b(paramFromServiceMsg, paramToServiceMsg);
      return;
    }
    if ("MCardSvc.ReqPicSafetyCheck".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    if ("VisitorSvc.ReqDeleteVisitorRecord".equals(paramFromServiceMsg.getServiceCmd()))
    {
      c(paramFromServiceMsg, paramToServiceMsg);
      return;
    }
    if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd()))
    {
      NearbyCmdHelper.a(paramFromServiceMsg, paramToServiceMsg);
      return;
    }
    if ("NeighborRecommender.ReqGetRecommender".equals(paramFromServiceMsg.getServiceCmd())) {}
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqDelFace")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqSetCard")) {
      return h(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("SummaryCard.SetLabel")) {
      return i(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("SummaryCard.LikeIt")) {
      return j(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqGetCardSwitch")) {
      return k(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("MCardSvc.ReqSetCardSwitch")) {
      return l(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("VisitorSvc.ReqGetVoterList")) {
      return n(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("VisitorSvc.ReqGetFavoriteList")) {
      return o(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equals("VisitorSvc.ReqDeleteVisitorRecord")) {
      return m(paramToServiceMsg, paramUniPacket);
    }
    if ("MCardSvc.ReqPicSafetyCheck".equals(paramToServiceMsg.getServiceCmd())) {
      return p(paramToServiceMsg, paramUniPacket);
    }
    if ("SummaryCard.ReqSummaryCard".equals(paramToServiceMsg.getServiceCmd())) {
      return a(paramToServiceMsg, paramUniPacket);
    }
    if ("VisitorSvc.ReqFavorite".equals(paramToServiceMsg.getServiceCmd())) {
      return NearbyCmdHelper.a(paramToServiceMsg, paramUniPacket);
    }
    if ("NearbyGroup.GetGroupList".equals(paramToServiceMsg.getServiceCmd())) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    if ("NearbyGroup.ReqGetAreaList".equals(paramToServiceMsg.getServiceCmd())) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if ("NeighborSvc.ReqSetStateSwitch".equals(paramToServiceMsg.getServiceCmd())) {
      return f(paramToServiceMsg, paramUniPacket);
    }
    if ("NeighborSvc.ReqGetSwitches".equals(paramToServiceMsg.getServiceCmd())) {
      return g(paramToServiceMsg, paramUniPacket);
    }
    if ("NeighborSvc.ReqGetPoint".equals(paramToServiceMsg.getServiceCmd())) {
      return NearbyCmdHelper.a(this, paramToServiceMsg, paramUniPacket);
    }
    if ("SummaryCard.ReqSearch".equals(paramToServiceMsg.getServiceCmd())) {
      return q(paramToServiceMsg, paramUniPacket);
    }
    if ("SummaryCard.ReqCondSearch".equals(paramToServiceMsg.getServiceCmd())) {
      return r(paramToServiceMsg, paramUniPacket);
    }
    if ("NeighborRecommender.ReqGetRecommender".equals(paramToServiceMsg.getServiceCmd())) {
      return e(paramToServiceMsg, paramUniPacket);
    }
    if ("EncounterSvc.ReqGetEncounter".equals(paramToServiceMsg.getServiceCmd())) {
      return NearbyCmdHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramToServiceMsg, paramUniPacket, this);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.lbs.LBSService
 * JD-Core Version:    0.7.0.1
 */