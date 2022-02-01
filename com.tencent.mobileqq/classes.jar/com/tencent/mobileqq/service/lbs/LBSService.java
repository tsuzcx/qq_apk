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
import QQService.ReqSetCard;
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
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResult;
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
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoCell;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.soso.location.data.SosoWifi;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.addcontacts.AccountSearchPb.Location;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.pb.addcontacts.AccountSearchPb.search;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.LoginSig;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
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
    Object localObject = null;
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    try
    {
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = localObject;
      if (localUniPacket != null) {
        paramArrayOfByte = (RspGetAreaList)localUniPacket.getByClass("RspGetAreaList", new RspGetAreaList());
      }
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public static RspGetNearbyGroup a(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    try
    {
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = localObject;
      if (localUniPacket != null) {
        paramArrayOfByte = (RspGetNearbyGroup)localUniPacket.getByClass("RspGetNearbyGroup", new RspGetNearbyGroup());
      }
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public static ReqSummaryCard a(ToServiceMsg paramToServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfUin");
    long l2 = paramToServiceMsg.extraData.getLong("targetUin", 0L);
    int k = paramToServiceMsg.extraData.getInt("comeFromType", 0);
    long l3 = paramToServiceMsg.extraData.getLong("qzoneFeedTimeStamp", 0L);
    byte b1 = paramToServiceMsg.extraData.getByte("isFriend");
    long l4 = paramToServiceMsg.extraData.getLong("troopCode", 0L);
    long l5 = paramToServiceMsg.extraData.getLong("troopUin", 0L);
    String str = paramToServiceMsg.extraData.getString("strSearchName");
    long l6 = paramToServiceMsg.extraData.getLong("lGetControl");
    int m = paramToServiceMsg.extraData.getInt("bReqCommLabel");
    int n = paramToServiceMsg.extraData.getInt("EAddFriendSource");
    long l7 = paramToServiceMsg.extraData.getLong("tinyId");
    long l8 = paramToServiceMsg.extraData.getLong("likeSource");
    byte b2 = paramToServiceMsg.extraData.getByte("bReqExtendCard");
    Object localObject1 = paramToServiceMsg.extraData.getParcelableArrayList("busiList");
    Object localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = new ArrayList();
    }
    Object localObject2 = paramToServiceMsg.extraData.getByteArray("vSeed");
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new byte[1];
      localObject1[0] = 0;
    }
    Object localObject4 = paramToServiceMsg.extraData.getByteArray("vSecureSig");
    localObject2 = localObject4;
    if (localObject4 == null)
    {
      localObject2 = new byte[1];
      localObject2[0] = 0;
    }
    byte b3 = paramToServiceMsg.extraData.getByte("bReqMedalWallInfo");
    localObject4 = paramToServiceMsg.extraData.getIntegerArrayList("req0x5ebFieldIdList");
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("vReqTemplateInfo");
    int j = 0;
    label774:
    for (;;)
    {
      try
      {
        i = Integer.parseInt("5105");
        ArrayList localArrayList = new ArrayList();
        if (l2 > 0L)
        {
          localObject3 = ((ArrayList)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            BusinessReqBuffer localBusinessReqBuffer = (BusinessReqBuffer)((Iterator)localObject3).next();
            Object localObject5 = new SummaryCardBusiEntry.comm();
            ((SummaryCardBusiEntry.comm)localObject5).ver.set(1);
            ((SummaryCardBusiEntry.comm)localObject5).seq.set(paramToServiceMsg.getAppSeq());
            ((SummaryCardBusiEntry.comm)localObject5).fromuin.set(l1);
            ((SummaryCardBusiEntry.comm)localObject5).touin.set(l2);
            ((SummaryCardBusiEntry.comm)localObject5).service.set(localBusinessReqBuffer.getBusinessType());
            ((SummaryCardBusiEntry.comm)localObject5).platform.set(2);
            ((SummaryCardBusiEntry.comm)localObject5).qqver.set("8.5.5.5105");
            ((SummaryCardBusiEntry.comm)localObject5).build.set(i);
            Object localObject6;
            if ((localBusinessReqBuffer.getBusinessType() == 17) || (localBusinessReqBuffer.getBusinessType() == 19) || (localBusinessReqBuffer.getBusinessType() == 18))
            {
              ((SummaryCardBusiEntry.comm)localObject5).msg_login_sig.setHasFlag(true);
              ((SummaryCardBusiEntry.comm)localObject5).msg_login_sig.uint32_type.set(8);
              ((SummaryCardBusiEntry.comm)localObject5).msg_login_sig.uint32_appid.set(16);
              localObject6 = paramToServiceMsg.extraData.getString("msg_login_sig");
              if ((!TextUtils.isEmpty((CharSequence)localObject6)) && (!HexUtil.emptybytes.equals(localObject6))) {
                ((SummaryCardBusiEntry.comm)localObject5).msg_login_sig.bytes_sig.set(ByteStringMicro.copyFromUtf8((String)localObject6));
              }
            }
            else
            {
              localObject5 = ((SummaryCardBusiEntry.comm)localObject5).toByteArray();
              int i1 = localObject5.length;
              j = 0;
              if (localBusinessReqBuffer.getBuffer() != null) {
                j = localBusinessReqBuffer.getBuffer().length;
              }
              localObject6 = new byte[i1 + 9 + j + 1];
              localObject6[0] = 40;
              PkgTools.DWord2Byte((byte[])localObject6, 1, i1);
              PkgTools.DWord2Byte((byte[])localObject6, 5, j);
              PkgTools.copyData((byte[])localObject6, 9, (byte[])localObject5, i1);
              j = localObject5.length + 9;
              if (localBusinessReqBuffer.getBuffer() == null) {
                break label774;
              }
              PkgTools.copyData((byte[])localObject6, j, localBusinessReqBuffer.getBuffer(), localBusinessReqBuffer.getBuffer().length);
              j = localBusinessReqBuffer.getBuffer().length + j;
              localObject6[j] = 41;
              localArrayList.add(localObject6);
              continue;
            }
          }
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i = j;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.SummaryCard", 2, localNumberFormatException.toString());
          i = j;
          continue;
          QLog.d("LBSService", 1, "MiniAppSummaryCard buildReqSummaryCard SummaryCardBusiEntry.MINI_APP_SERVICE set A2 failed");
          continue;
          return new ReqSummaryCard(l2, k, l3, b1, l4, l5, (byte[])localObject1, str, l6, n, (byte[])localObject2, null, arrayOfByte, null, localNumberFormatException, l7, l8, null, b3, (ArrayList)localObject4, (byte)1, (byte)m, b2, null, 1L);
        }
      }
    }
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
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(6);
    int k = paramArrayList.size();
    int i = 0;
    label53:
    label73:
    int n;
    Object localObject2;
    SummaryCardBusiEntry.comm localcomm;
    if (i < k)
    {
      Object localObject1 = (byte[])paramArrayList.get(i);
      if (localObject1 == null)
      {
        j = 0;
        if (j > 10) {
          break label73;
        }
      }
      label509:
      do
      {
        int m;
        do
        {
          i += 1;
          break;
          j = localObject1.length;
          break label53;
          n = (int)PkgTools.getLongData((byte[])localObject1, 1);
          m = (int)PkgTools.getLongData((byte[])localObject1, 5);
        } while ((n <= 0) || (n + 9 >= j));
        localObject2 = new byte[n];
        PkgTools.copyData((byte[])localObject2, 0, (byte[])localObject1, 9, n);
        j = n + 9;
        localcomm = new SummaryCardBusiEntry.comm();
        for (;;)
        {
          try
          {
            localcomm.mergeFrom((byte[])localObject2);
            n = localcomm.result.get();
            if (n != 0) {
              break label556;
            }
            n = localcomm.service.get();
            localObject2 = new byte[m];
            PkgTools.copyData((byte[])localObject2, 0, (byte[])localObject1, j, m);
            localObject1 = new AccountSearchPb.search();
            ((AccountSearchPb.search)localObject1).mergeFrom((byte[])localObject2);
            localObject2 = new SearchResult();
            ((SearchResult)localObject2).jdField_a_of_type_Int = n;
            ((SearchResult)localObject2).jdField_b_of_type_Int = ((AccountSearchPb.search)localObject1).start.get();
            if (((AccountSearchPb.search)localObject1).end.get() != 1) {
              break label509;
            }
            bool = true;
            ((SearchResult)localObject2).jdField_a_of_type_Boolean = bool;
            ((SearchResult)localObject2).jdField_b_of_type_JavaUtilList = ((AccountSearchPb.search)localObject1).list.get();
            ((SearchResult)localObject2).jdField_a_of_type_JavaUtilList = ((AccountSearchPb.search)localObject1).highlight.get();
            ((SearchResult)localObject2).jdField_a_of_type_JavaLangString = ((AccountSearchPb.search)localObject1).article_more_url.get();
            ((SearchResult)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord = ((AccountSearchPb.hotwordrecord)((AccountSearchPb.search)localObject1).hotword_record.get());
            ((SearchResult)localObject2).jdField_c_of_type_JavaUtilList = ((AccountSearchPb.search)localObject1).result_items.get();
            ((SearchResult)localObject2).jdField_b_of_type_Boolean = ((AccountSearchPb.search)localObject1).bool_keyword_suicide.get();
            ((SearchResult)localObject2).jdField_c_of_type_Boolean = ((AccountSearchPb.search)localObject1).bool_exact_search.get();
            if (((((SearchResult)localObject2).jdField_b_of_type_JavaUtilList == null) || (((SearchResult)localObject2).jdField_b_of_type_JavaUtilList.size() <= 0)) && ((((SearchResult)localObject2).jdField_c_of_type_JavaUtilList == null) || (((SearchResult)localObject2).jdField_c_of_type_JavaUtilList.size() <= 0)) && (!((SearchResult)localObject2).jdField_b_of_type_Boolean)) {
              break;
            }
            localArrayList.add(localObject2);
            if (n != 80000000) {
              break label515;
            }
            localObject1 = ((AccountSearchPb.search)localObject1).list.get().iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (AccountSearchPb.record)((Iterator)localObject1).next();
            if (((AccountSearchPb.record)localObject2).sign.get() == null) {
              continue;
            }
            ((AccountSearchPb.record)localObject2).richStatus = RichStatus.parseStatus(((AccountSearchPb.record)localObject2).sign.get().toByteArray());
            continue;
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          catch (Exception localException) {}
          QLog.i("Q.profilecard.SummaryCard", 2, localException.toString());
          break;
          boolean bool = false;
        }
      } while ((n != 80000001) || (!localException.bool_location_group.has()));
      label515:
      if (!localException.bool_location_group.get()) {
        break label630;
      }
    }
    label556:
    label630:
    for (int j = 1;; j = 2)
    {
      ((SearchResult)localObject2).jdField_c_of_type_Int = j;
      break;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("Q.profilecard.SummaryCard", 4, "busi entry, [" + localcomm.service.get() + "," + n + "," + localcomm.err_msg.get());
      break;
      return localArrayList;
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg = (RespGetVoterList)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespGetVoterList", new RespGetVoterList());
    switch (paramToServiceMsg.stHeader.iReplyCode)
    {
    default: 
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
    switch (paramToServiceMsg.stHeader.iReplyCode)
    {
    default: 
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
    switch (paramToServiceMsg.stHeader.iReplyCode)
    {
    default: 
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
    paramToServiceMsg.vClientVersion = "8.5.5".getBytes();
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
      return new Object[] { paramToServiceMsg, paramFromServiceMsg };
    }
    if (QLog.isColorLevel()) {
      if (paramToServiceMsg != null) {
        break label94;
      }
    }
    label94:
    for (paramFromServiceMsg = "decodeNearbyRecommender respHeader is null";; paramFromServiceMsg = String.valueOf(paramToServiceMsg.eReplyCode))
    {
      QLog.i("LBS", 2, paramFromServiceMsg);
      paramFromServiceMsg = null;
      break;
    }
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSService", 2, "handleGetNearbyRecommender");
    }
    Object localObject1 = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getRawSosoInfo();
    if ((localObject1 == null) || (((SosoLbsInfo)localObject1).mLocation == null) || (((SosoLbsInfo)localObject1).mLocation.mLat84 == 0.0D) || (((SosoLbsInfo)localObject1).mLocation.mLon84 == 0.0D))
    {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).reqRawLbsData(60000L, getClass().getSimpleName());
      localObject1 = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getRawSosoInfo();
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        NeighborComm.ReqHeader localReqHeader = new NeighborComm.ReqHeader();
        localReqHeader.shVersion = 2;
        localReqHeader.lMID = createUserId(Long.parseLong(paramToServiceMsg.getUin()));
        localReqHeader.iAppID = AppSetting.a();
        localReqHeader.eBusiType = 0;
        localReqHeader.eMqqSysType = 2;
        ReqUserInfo localReqUserInfo = new ReqUserInfo();
        localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
        localReqUserInfo.strAuthPassword = "NzVK_qGE";
        localReqUserInfo.eListType = 0;
        localReqUserInfo.eLocalInfo = LocalInfoType.LocalInfoType_SOSO.value();
        localReqUserInfo.stGps = new GPS((int)(((SosoLbsInfo)localObject1).mLocation.mLat84 * 1000000.0D), (int)(((SosoLbsInfo)localObject1).mLocation.mLon84 * 1000000.0D), -1, 0);
        localReqUserInfo.vSOSOCells = new ArrayList();
        Object localObject2;
        if (((SosoLbsInfo)localObject1).mCells != null)
        {
          localObject2 = ((SosoLbsInfo)localObject1).mCells.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            SosoCell localSosoCell = (SosoCell)((Iterator)localObject2).next();
            localReqUserInfo.vSOSOCells.add(new SOSO_Cell((short)localSosoCell.mMcc, (short)localSosoCell.mMnc, localSosoCell.mLac, localSosoCell.mCellId, (short)localSosoCell.mRss));
          }
        }
        localReqUserInfo.vSOSOMac = new ArrayList();
        if (((SosoLbsInfo)localObject1).mWifis != null)
        {
          localObject1 = ((SosoLbsInfo)localObject1).mWifis.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SosoWifi)((Iterator)localObject1).next();
            localReqUserInfo.vSOSOMac.add(new SOSO_Wifi(((SosoWifi)localObject2).mMac, (short)((SosoWifi)localObject2).mRssi));
          }
        }
        localObject1 = new ReqGetRecommender();
        ((ReqGetRecommender)localObject1).stUserInfo = localReqUserInfo;
        ((ReqGetRecommender)localObject1).eTimingType = paramToServiceMsg.extraData.getInt("timingType");
        paramUniPacket.setEncodeName("utf-8");
        paramUniPacket.setServantName("EncounterObj");
        paramUniPacket.setFuncName("CMD_GET_RECOMMENDER");
        paramUniPacket.put("ReqHeader", localReqHeader);
        paramUniPacket.put("ReqGetRecommender", localObject1);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LBSService", 2, "handleGetNearbyRecommender lbsinfo is null");
      }
      paramToServiceMsg.extraData.putBoolean("isLbsInfoNull", true);
      return false;
    }
  }
  
  private Object f(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespSummaryCard)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSummaryCard", new RespSummaryCard());
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int i = 0;
    Object localObject = new NeighborSvc.ReqHeader();
    ((NeighborSvc.ReqHeader)localObject).shVersion = 2;
    ((NeighborSvc.ReqHeader)localObject).lMID = createUserId(Long.parseLong(paramToServiceMsg.getUin()));
    ((NeighborSvc.ReqHeader)localObject).iAppID = AppSetting.a();
    if (paramToServiceMsg.extraData.getBoolean("k_be_share", false)) {
      i = 1;
    }
    localObject = new ReqSetStateSwitch((NeighborSvc.ReqHeader)localObject, (byte)i);
    paramUniPacket.setServantName("NeighborObj");
    paramUniPacket.setFuncName("CMD_SET_STATE_SWITCH");
    paramUniPacket.put("ReqSetStateSwitch", localObject);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("NeighborSvc.ReqSetStateSwitch");
    return true;
  }
  
  private Object g(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    paramFromServiceMsg = (RespSearch)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSearch", new RespSearch());
    int i = paramToServiceMsg.extraData.getInt("search_version");
    if (i == 2) {}
    while (i != 3) {
      return paramFromServiceMsg;
    }
    boolean bool = paramToServiceMsg.extraData.getBoolean("search_decode");
    if (QLog.isColorLevel()) {
      QLog.d("LBSService", 2, "decodeSearchFriend | needDecode = " + bool);
    }
    if (bool) {
      return a(paramFromServiceMsg.vvRespServices);
    }
    return paramFromServiceMsg.vvRespServices;
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
  
  private boolean h(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject3 = null;
    QQService.ReqHead localReqHead = new QQService.ReqHead();
    localReqHead.shVersion = 2;
    localReqHead.iSeq = paramUniPacket.getRequestId();
    localReqHead.lUIN = Long.parseLong(paramToServiceMsg.getUin());
    int i = paramToServiceMsg.extraData.getInt("eSubCmd");
    byte b = paramToServiceMsg.extraData.getByte("bIsSingle");
    byte[] arrayOfByte1 = paramToServiceMsg.extraData.getByteArray("vBackground");
    byte[] arrayOfByte2 = paramToServiceMsg.extraData.getByteArray("vReqSetTemplate");
    for (;;)
    {
      try
      {
        Object localObject1 = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(paramToServiceMsg.extraData.getByteArray("vTagsID"))).readObject();
        ArrayList localArrayList2;
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          localArrayList1 = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(paramToServiceMsg.extraData.getByteArray("vDelTags"))).readObject();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject2;
            ArrayList localArrayList1 = null;
          }
        }
        try
        {
          localArrayList2 = (ArrayList)new ObjectInputStream(new ByteArrayInputStream(paramToServiceMsg.extraData.getByteArray("vAddTags"))).readObject();
          localObject1 = new ReqSetCard(localReqHead, i, b, (ArrayList)localObject1, arrayOfByte1, localArrayList1, localArrayList2, arrayOfByte2);
          paramUniPacket.setServantName("MCardSvc");
          paramUniPacket.setFuncName("ReqSetCard");
          paramUniPacket.put("ReqSetCard", localObject1);
          paramToServiceMsg.setTimeout(10000L);
          paramToServiceMsg.setServiceCmd("MCardSvc.ReqSetCard");
          return true;
        }
        catch (Exception localException3)
        {
          break label252;
        }
        localException1 = localException1;
        localArrayList1 = null;
        localObject1 = null;
      }
      label252:
      localObject2 = localObject3;
    }
  }
  
  private Object i(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    return (RespSetCard)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespSetCard", new RespSetCard());
  }
  
  private boolean i(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    SSummaryCardSetLabel localSSummaryCardSetLabel;
    try
    {
      Object localObject = (List)paramToServiceMsg.extraData.getSerializable("labels");
      if (localObject != null)
      {
        localSSummaryCardSetLabel = new SSummaryCardSetLabel();
        localSSummaryCardSetLabel.cmd = 4;
        localSSummaryCardSetLabel.uin = Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        localSSummaryCardSetLabel.version = "8.5.5";
        localSSummaryCardSetLabel.platform = 109L;
        localSSummaryCardSetLabel.labels = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localSSummaryCardSetLabel.labels.add(((Iterator)localObject).next());
        }
      }
      return false;
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
    paramUniPacket.setServantName("SummaryCard");
    paramUniPacket.setFuncName("SetLabel");
    paramUniPacket.put("SSummaryCardSetLabel", localSSummaryCardSetLabel);
    paramToServiceMsg.setTimeout(10000L);
    paramToServiceMsg.setServiceCmd("SummaryCard.SetLabel");
    return true;
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
      localSSummaryCardLikeIt.version = "8.5.5";
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
    if (bool) {}
    for (localObject = new ReqSetCardSwitch((QQService.ReqHead)localObject, l, 2L);; localObject = new ReqSetCardSwitch((QQService.ReqHead)localObject, 2L, l))
    {
      paramUniPacket.setServantName("MCardSvc");
      paramUniPacket.setFuncName("ReqSetCardSwitch");
      paramUniPacket.put("ReqSetCardSwitch", localObject);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("MCardSvc.ReqSetCardSwitch");
      return true;
    }
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
    if (i < 54) {}
    for (;;)
    {
      localObject = new ReqGetVoterList((QQService.ReqHead)localObject, localUserCntlData, i);
      paramUniPacket.setServantName("VisitorSvc");
      paramUniPacket.setFuncName("ReqGetVoterList");
      paramUniPacket.put("ReqGetVoterList", localObject);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("VisitorSvc.ReqGetVoterList");
      return true;
      i = 30;
    }
  }
  
  private boolean o(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("nextMid");
    int i = paramToServiceMsg.extraData.getInt("pageSize");
    Object localObject = new QQService.ReqHead(l1, (short)1, paramUniPacket.getRequestId(), (byte)1, (byte)0, null);
    UserCntlData localUserCntlData = new UserCntlData(l2, new byte[0]);
    if (i < 54) {}
    for (;;)
    {
      localObject = new ReqGetFavoriteList((QQService.ReqHead)localObject, localUserCntlData, i);
      paramUniPacket.setServantName("VisitorSvc");
      paramUniPacket.setFuncName("ReqGetFavoriteList");
      paramUniPacket.put("ReqGetFavoriteList", localObject);
      paramToServiceMsg.setTimeout(10000L);
      paramToServiceMsg.setServiceCmd("VisitorSvc.ReqGetFavoriteList");
      return true;
      i = 30;
    }
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
    Object localObject2 = paramToServiceMsg.extraData.getString("param_keyword");
    String str = paramToServiceMsg.extraData.getString("param_country_code");
    double d1 = paramToServiceMsg.extraData.getDouble("search_longtitude");
    double d2 = paramToServiceMsg.extraData.getDouble("search_latitude");
    int[] arrayOfInt = paramToServiceMsg.extraData.getIntArray("search_list");
    int k = paramToServiceMsg.extraData.getInt("search_page");
    int m = paramToServiceMsg.extraData.getInt("search_version");
    int n = paramToServiceMsg.extraData.getInt("filter_type", 0);
    Object localObject1 = null;
    if (m == 2) {}
    label710:
    for (;;)
    {
      localObject1 = new ReqSearch((String)localObject2, str, m, (ArrayList)localObject1);
      localObject2 = new SummaryCard.ReqHead();
      ((SummaryCard.ReqHead)localObject2).iVersion = 2;
      paramUniPacket.setServantName("SummaryCardServantObj");
      paramUniPacket.setFuncName("ReqSearch");
      paramUniPacket.put("ReqHead", localObject2);
      paramUniPacket.put("ReqSearch", localObject1);
      paramToServiceMsg.setTimeout(30000L);
      paramToServiceMsg.setServiceCmd("SummaryCard.ReqSearch");
      return true;
      if (m == 3)
      {
        localObject1 = new ArrayList();
        try
        {
          i = Integer.parseInt("5105");
          int i1 = arrayOfInt.length;
          j = 0;
          for (;;)
          {
            if (j >= i1) {
              break label710;
            }
            Object localObject3 = new SummaryCardBusiEntry.comm();
            ((SummaryCardBusiEntry.comm)localObject3).ver.set(1);
            ((SummaryCardBusiEntry.comm)localObject3).seq.set(paramToServiceMsg.getAppSeq());
            ((SummaryCardBusiEntry.comm)localObject3).service.set(arrayOfInt[j]);
            if (arrayOfInt[j] == 80000004)
            {
              ((SummaryCardBusiEntry.comm)localObject3).msg_login_sig.setHasFlag(true);
              ((SummaryCardBusiEntry.comm)localObject3).msg_login_sig.uint32_type.set(64);
              localObject4 = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
              if (localObject4 != null)
              {
                localObject4 = ((TicketManager)localObject4).getA2(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
                if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!HexUtil.emptybytes.equals(localObject4))) {
                  ((SummaryCardBusiEntry.comm)localObject3).msg_login_sig.bytes_sig.set(ByteStringMicro.copyFromUtf8((String)localObject4));
                }
              }
            }
            ((SummaryCardBusiEntry.comm)localObject3).platform.set(2);
            ((SummaryCardBusiEntry.comm)localObject3).qqver.set("8.5.5.5105");
            ((SummaryCardBusiEntry.comm)localObject3).build.set(i);
            localObject3 = ((SummaryCardBusiEntry.comm)localObject3).toByteArray();
            int i3 = localObject3.length;
            localObject4 = new AccountSearchPb.search();
            ((AccountSearchPb.search)localObject4).start.set(k);
            if (arrayOfInt[j] != 80000001) {
              break;
            }
            ((AccountSearchPb.search)localObject4).count.set(4);
            ((AccountSearchPb.search)localObject4).keyword.set((String)localObject2);
            ((AccountSearchPb.search)localObject4).highlight.add(localObject2);
            Object localObject5 = new AccountSearchPb.Location();
            ((AccountSearchPb.Location)localObject5).double_longitude.set(d1);
            ((AccountSearchPb.Location)localObject5).double_latitude.set(d2);
            ((AccountSearchPb.search)localObject4).msg_user_location.set((MessageMicro)localObject5);
            ((AccountSearchPb.search)localObject4).filtertype.set(n);
            if (QLog.isDevelopLevel()) {
              QLog.d("LBSService", 4, "request has set filtertype " + n);
            }
            localObject4 = ((AccountSearchPb.search)localObject4).toByteArray();
            int i2 = localObject4.length;
            localObject5 = new byte[i3 + 9 + i2 + 1];
            localObject5[0] = 40;
            PkgTools.DWord2Byte((byte[])localObject5, 1, i3);
            PkgTools.DWord2Byte((byte[])localObject5, 5, i2);
            PkgTools.copyData((byte[])localObject5, 9, (byte[])localObject3, i3);
            i3 = localObject3.length + 9;
            PkgTools.copyData((byte[])localObject5, i3, (byte[])localObject4, i2);
            i2 = i3 + i2;
            localObject5[i2] = 41;
            ((ArrayList)localObject1).add(localObject5);
            j += 1;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            int j;
            Object localObject4;
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.SummaryCard", 2, localNumberFormatException.toString());
            }
            int i = 0;
            continue;
            if (arrayOfInt[j] == 80000003) {
              ((AccountSearchPb.search)localObject4).count.set(8);
            }
          }
        }
      }
    }
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
      localObject3 = ByteBuffer.allocate(16);
      if ((localObject2 == null) || (localObject2.length != 4)) {
        break label485;
      }
      ((ByteBuffer)localObject3).putInt(ConditionSearchManager.a(localObject2[0]));
      ((ByteBuffer)localObject3).putInt(ConditionSearchManager.a(localObject2[1]));
      ((ByteBuffer)localObject3).putInt(ConditionSearchManager.a(localObject2[2]));
      ((ByteBuffer)localObject3).putInt(ConditionSearchManager.a(localObject2[3]));
    }
    for (;;)
    {
      short s2 = (short)k;
      short s3 = (short)m;
      short s1 = s2;
      if (s2 < 0) {
        s1 = 0;
      }
      s2 = s3;
      if (s1 > s3)
      {
        s3 = 32767;
        s2 = s3;
        if (QLog.isColorLevel())
        {
          QLog.i("LBSService", 2, String.format("handleCondSearchFriend [%s, %s]--[%s, %s]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Short.valueOf(s1), Short.valueOf(32767) }));
          s2 = s3;
        }
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
      localByteBuffer.putInt(0).putInt(0).putInt(0).putInt(0);
      break;
      label485:
      ((ByteBuffer)localObject3).putInt(0).putInt(0).putInt(0).putInt(0);
    }
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
    if ("VisitorSvc.ReqGetVoterList".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramFromServiceMsg, paramToServiceMsg);
    }
    do
    {
      do
      {
        return;
        if ("VisitorSvc.ReqGetFavoriteList".equals(paramFromServiceMsg.getServiceCmd()))
        {
          b(paramFromServiceMsg, paramToServiceMsg);
          return;
        }
      } while ("MCardSvc.ReqPicSafetyCheck".equals(paramFromServiceMsg.getServiceCmd()));
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
    } while (!"NeighborRecommender.ReqGetRecommender".equals(paramFromServiceMsg.getServiceCmd()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.lbs.LBSService
 * JD-Core Version:    0.7.0.1
 */