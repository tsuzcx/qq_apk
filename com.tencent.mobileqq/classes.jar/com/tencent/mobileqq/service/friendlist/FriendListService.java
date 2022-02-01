package com.tencent.mobileqq.service.friendlist;

import BumpSvc.ReqConfirmContactFriend;
import NeighborComm.ReqHeader;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.troop.TroopService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.AddGroup;
import friendlist.CheckFriendReq;
import friendlist.DelFriendReq;
import friendlist.DelFriendResp;
import friendlist.DelGroup;
import friendlist.GetFriendListReq;
import friendlist.GetFriendListResp;
import friendlist.GetFriendsVideoAbiResp;
import friendlist.GetLastLoginInfoReq;
import friendlist.GetLastLoginInfoResp;
import friendlist.GetOnlineInfoReq;
import friendlist.GetOnlineInfoResp;
import friendlist.GetSimpleOnlineFriendInfoReq;
import friendlist.GetSimpleOnlineFriendInfoResp;
import friendlist.LastLoginPageInfo;
import friendlist.MovGroupMem;
import friendlist.MovGroupMemReq;
import friendlist.MovGroupMemResp;
import friendlist.ReSortGroup;
import friendlist.RenameGroup;
import friendlist.SetGroupReq;
import friendlist.SetGroupResp;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50.ReqBody;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b.ReqBody;

public class FriendListService
  extends BaseProtocolCoder
{
  private static final String[] a = { "friendlist", "BumpSvc" };
  private QQAppInterface b = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
  private TroopService c = new TroopService(this.b);
  
  private long a(String paramString)
  {
    long l = 0L;
    if (paramString != null) {
      if (paramString.length() <= 0) {
        return 0L;
      }
    }
    try
    {
      l = Long.parseLong(paramString);
      if (l < 10000L) {
        return 0L;
      }
      return l;
    }
    catch (NumberFormatException paramString) {}
    return 0L;
  }
  
  private Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return paramFromServiceMsg;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    int i = paramToServiceMsg.extraData.getInt("bType");
    long l2 = paramToServiceMsg.extraData.getLong("lToMID");
    long l3 = paramToServiceMsg.extraData.getLong("lFromMobile");
    long l4 = paramToServiceMsg.extraData.getLong("lToMobile");
    Object localObject = paramToServiceMsg.extraData.getByteArray("vSig");
    byte b1 = paramToServiceMsg.extraData.getByte("bGroupId");
    String str = paramToServiceMsg.extraData.getString("strNickName");
    paramToServiceMsg = new ReqHeader();
    paramToServiceMsg.shVersion = 1;
    paramToServiceMsg.lMID = l1;
    paramToServiceMsg.iAppID = AppSetting.d();
    paramToServiceMsg.eBusiType = 1;
    paramToServiceMsg.eMqqSysType = 2;
    localObject = new ReqConfirmContactFriend((byte)i, l2, l3, l4, (byte[])localObject, b1, null, str);
    paramUniPacket.setServantName("BumpSvc");
    paramUniPacket.setFuncName("CMD_CONFIRM_CONTACT_FRIEND");
    paramUniPacket.put("ReqHeader", paramToServiceMsg);
    paramUniPacket.put("ReqConfirmContactFriend", localObject);
    return true;
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
    paramFromServiceMsg = new UniPacket(true);
    paramFromServiceMsg.setEncodeName("utf-8");
    paramFromServiceMsg.decode(paramToServiceMsg);
    if ("GetOnlineInfoReq".equals(paramFromServiceMsg.getFuncName()))
    {
      paramToServiceMsg = (GetOnlineInfoResp)decodePacket(paramToServiceMsg, "GetOnlineInfoResp", new GetOnlineInfoResp());
      if (paramToServiceMsg == null) {
        return null;
      }
      paramToServiceMsg.dwStatus = ((byte)(int)paramToServiceMsg.dwStatus);
      return paramToServiceMsg;
    }
    return null;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = a(paramToServiceMsg.getUin());
    if (l == 0L) {
      return false;
    }
    paramToServiceMsg = new GetSimpleOnlineFriendInfoReq(l, (byte)0, (byte)0, null, paramToServiceMsg.extraData.getByte("ifShowTermType"), 31L, paramToServiceMsg.extraData.getByte("srcType"));
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetSimpleOnlineFriendInfoReq");
    paramUniPacket.put("FSOLREQ", paramToServiceMsg);
    return true;
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
    paramFromServiceMsg = new UniPacket(true);
    paramFromServiceMsg.setEncodeName("utf-8");
    paramFromServiceMsg.decode(paramToServiceMsg);
    paramFromServiceMsg = paramFromServiceMsg.getFuncName();
    if ("GetSimpleOnlineFriendInfoReq".equals(paramFromServiceMsg))
    {
      paramToServiceMsg = (GetSimpleOnlineFriendInfoResp)decodePacket(paramToServiceMsg, "FSOLRESP", new GetSimpleOnlineFriendInfoResp());
      if (paramToServiceMsg == null) {
        return null;
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.result == 1)) {
        return null;
      }
      return paramToServiceMsg;
    }
    if ("GetFriendsVideoAbiResp".equals(paramFromServiceMsg))
    {
      paramToServiceMsg = (GetFriendsVideoAbiResp)decodePacket(paramToServiceMsg, "VABRESP", new GetFriendsVideoAbiResp());
      if ((paramToServiceMsg != null) && (paramToServiceMsg.result == 1)) {
        return null;
      }
      return paramToServiceMsg;
    }
    return null;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("dwReqType");
    if (l == 0L) {
      paramToServiceMsg = new GetOnlineInfoReq(l, paramToServiceMsg.extraData.getLong("dwUin"), null, 31L, true);
    } else {
      paramToServiceMsg = new GetOnlineInfoReq(l, 0L, paramToServiceMsg.extraData.getString("strMobile"), 7L, false);
    }
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetOnlineInfoReq");
    paramUniPacket.put("GetOnlineInfoReq", paramToServiceMsg);
    return true;
  }
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = (DelFriendResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "DFRESP", new DelFriendResp());
    paramToServiceMsg = paramFromServiceMsg;
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    if (l1 == 0L) {
      return false;
    }
    long l2 = a(paramToServiceMsg.extraData.getString("uin"));
    if (l2 == 0L) {
      return false;
    }
    paramToServiceMsg = new CheckFriendReq();
    paramToServiceMsg.uin = l1;
    paramToServiceMsg.fuin = l2;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("CheckFriendReq");
    paramUniPacket.put("CF", paramToServiceMsg);
    return true;
  }
  
  private Object e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = (MovGroupMemResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "MovGroupMemResp", new MovGroupMemResp());
    paramToServiceMsg = paramFromServiceMsg;
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    if (l1 == 0L) {
      return false;
    }
    paramToServiceMsg = paramToServiceMsg.extraData;
    long l2 = a(paramToServiceMsg.getString("uin"));
    if (l2 == 0L) {
      return false;
    }
    if (l1 == l2) {
      return false;
    }
    byte b2 = paramToServiceMsg.getByte("del_type");
    byte b1 = b2;
    if (b2 != 1)
    {
      b1 = b2;
      if (b2 != 2) {
        b1 = 1;
      }
    }
    paramToServiceMsg = new DelFriendReq();
    paramToServiceMsg.uin = l1;
    paramToServiceMsg.deluin = l2;
    paramToServiceMsg.delType = b1;
    paramToServiceMsg.version = 1;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("DelFriendReq");
    paramUniPacket.put("DF", paramToServiceMsg);
    return true;
  }
  
  private Object f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetFriendListResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "FLRESP", new GetFriendListResp());
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Byte localByte = Byte.valueOf(paramToServiceMsg.extraData.getByte("move_fri_type"));
    if (localByte.byteValue() == 0) {
      return g(paramToServiceMsg, paramUniPacket);
    }
    if (localByte.byteValue() == 1) {
      return h(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  private Object g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (GetLastLoginInfoResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "GetLastLoginInfoResp", new GetLastLoginInfoResp());
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = a(paramToServiceMsg.getUin());
    if (l1 == 0L) {
      return false;
    }
    paramToServiceMsg = paramToServiceMsg.extraData;
    long l2 = a(paramToServiceMsg.getString("uin"));
    if (l2 == 0L) {
      return false;
    }
    byte b1 = paramToServiceMsg.getByte("group_id");
    if (b1 < 0) {
      return false;
    }
    paramToServiceMsg = new MovGroupMem();
    paramToServiceMsg.Ver = 1;
    paramToServiceMsg.wReqLen = 5;
    paramToServiceMsg.dwUin = l2;
    paramToServiceMsg.cGroupid = b1;
    paramToServiceMsg.wReserveLen = 0;
    MovGroupMemReq localMovGroupMemReq = new MovGroupMemReq();
    localMovGroupMemReq.uin = l1;
    localMovGroupMemReq.reqtype = 0;
    paramToServiceMsg = null;
    try
    {
      Object localObject = new ByteArrayOutputStream(10);
      DataOutputStream localDataOutputStream = new DataOutputStream((OutputStream)localObject);
      localDataOutputStream.writeByte(1);
      localDataOutputStream.writeShort(5);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.writeByte(b1);
      localDataOutputStream.writeShort(0);
      localDataOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      paramToServiceMsg = (ToServiceMsg)localObject;
    }
    catch (IOException localIOException)
    {
      label186:
      break label186;
    }
    localMovGroupMemReq.vecBody = paramToServiceMsg;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("MovGroupMemReq");
    paramUniPacket.put("MovGroupMemReq", localMovGroupMemReq);
    return true;
  }
  
  private Object h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SetGroupResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "SetGroupResp", new SetGroupResp());
  }
  
  private boolean h(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = a(paramToServiceMsg.getUin());
    if (l == 0L) {
      return false;
    }
    Bundle localBundle = paramToServiceMsg.extraData;
    arrayOfString = localBundle.getStringArray("uins");
    paramToServiceMsg = arrayOfString;
    if (arrayOfString == null) {
      paramToServiceMsg = new String[0];
    }
    MovGroupMemReq localMovGroupMemReq = new MovGroupMemReq();
    localMovGroupMemReq.uin = l;
    localMovGroupMemReq.reqtype = 1;
    arrayOfString = null;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
      localDataOutputStream.writeByte(1);
      localDataOutputStream.writeShort(paramToServiceMsg.length * 5);
      int i = 0;
      while (i < paramToServiceMsg.length)
      {
        l = a(paramToServiceMsg[i]);
        if (l == 0L) {
          break;
        }
        int j = localBundle.getByte("group_id");
        if (j < 0) {
          break;
        }
        localDataOutputStream.writeInt((int)l);
        localDataOutputStream.writeByte(j);
        i += 1;
      }
      localDataOutputStream.writeShort(0);
      localDataOutputStream.close();
      paramToServiceMsg = localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg = arrayOfString;
      }
    }
    localMovGroupMemReq.vecBody = paramToServiceMsg;
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("MovGroupMemReq");
    paramUniPacket.put("MovGroupMemReq", localMovGroupMemReq);
    return true;
  }
  
  private boolean i(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.extraData.getBoolean("getSingleFriend")) {
      return j(paramToServiceMsg, paramUniPacket);
    }
    return k(paramToServiceMsg, paramUniPacket);
  }
  
  private boolean j(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("targetUin");
    if (TextUtils.isEmpty(paramToServiceMsg)) {
      return false;
    }
    GetFriendListReq localGetFriendListReq = new GetFriendListReq();
    localGetFriendListReq.reqtype = 3;
    localGetFriendListReq.ifReflush = 1;
    localGetFriendListReq.ifShowTermType = 1;
    localGetFriendListReq.version = 31L;
    Object localObject = new Oidb_0xd50.ReqBody();
    ((Oidb_0xd50.ReqBody)localObject).appid.set(10002L);
    ((Oidb_0xd50.ReqBody)localObject).req_music_switch.set(1);
    ((Oidb_0xd50.ReqBody)localObject).req_ksing_switch.set(1);
    ((Oidb_0xd50.ReqBody)localObject).req_mutualmark_lbsshare.set(1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListService", 2, "handleGetSingleInfo: invoked. req lbs share profile. ");
    }
    ((Oidb_0xd50.ReqBody)localObject).req_mutualmark_alienation.set(1);
    ((Oidb_0xd50.ReqBody)localObject).req_aio_quick_app.set(1);
    localGetFriendListReq.vec0xd50Req = ((Oidb_0xd50.ReqBody)localObject).toByteArray();
    localGetFriendListReq.vec0xd6bReq = new Oidb_0xd6b.ReqBody().toByteArray();
    localObject = new ArrayList(1);
    try
    {
      localGetFriendListReq.uin = Long.parseLong(this.b.getCurrentAccountUin());
      ((ArrayList)localObject).add(Long.valueOf(Long.parseLong(paramToServiceMsg)));
      localGetFriendListReq.uinList = ((ArrayList)localObject);
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("GetFriendListReq");
      paramUniPacket.put("FL", localGetFriendListReq);
      return true;
    }
    catch (NumberFormatException paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
    return false;
  }
  
  private boolean k(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    short s1 = paramToServiceMsg.extraData.getShort("friendStartIndex");
    short s2 = paramToServiceMsg.extraData.getShort("friendCount");
    byte b1 = paramToServiceMsg.extraData.getByte("groupStartIndex");
    byte b2 = paramToServiceMsg.extraData.getByte("groupCount");
    byte b3 = paramToServiceMsg.extraData.getByte("ifShowTermType");
    int i;
    if (s1 > 0) {
      i = 0;
    } else {
      i = 1;
    }
    Oidb_0xd50.ReqBody localReqBody = new Oidb_0xd50.ReqBody();
    localReqBody.appid.set(10002L);
    localReqBody.req_music_switch.set(1);
    localReqBody.req_ksing_switch.set(1);
    localReqBody.req_mutualmark_lbsshare.set(1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListService", 2, new Object[] { "handleGetAllInfo: invoked. ", " req lbs share profile. " });
    }
    localReqBody.req_mutualmark_alienation.set(1);
    localReqBody.req_aio_quick_app.set(1);
    ArrayList localArrayList = new ArrayList(3);
    localArrayList.add(Long.valueOf(13580L));
    localArrayList.add(Long.valueOf(13581L));
    localArrayList.add(Long.valueOf(13582L));
    Oidb_0xd6b.ReqBody localReqBody1 = new Oidb_0xd6b.ReqBody();
    byte b4 = (byte)i;
    paramToServiceMsg = new GetFriendListReq(3, b4, Long.valueOf(paramToServiceMsg.getUin()).longValue(), s1, s2, (byte)0, b4, b1, b2, (byte)0, b3, 31L, null, 0, (byte)0, (byte)0, localReqBody.toByteArray(), localReqBody1.toByteArray(), localArrayList);
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetFriendListReq");
    paramUniPacket.put("FL", paramToServiceMsg);
    return true;
  }
  
  private boolean l(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("uin");
    long l2 = paramToServiceMsg.extraData.getLong("current_req_uin");
    long l3 = paramToServiceMsg.extraData.getLong("current_req_index");
    paramToServiceMsg = new GetLastLoginInfoReq(l1, new LastLoginPageInfo(paramToServiceMsg.extraData.getLong("total_req_times"), l3, l2));
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetLastLoginInfoReq");
    paramUniPacket.put("GetLastLoginInfoReq", paramToServiceMsg);
    return true;
  }
  
  private boolean m(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("SetGroupReq");
    SetGroupReq localSetGroupReq = new SetGroupReq();
    try
    {
      localSetGroupReq.uin = Long.parseLong(paramToServiceMsg.getUin());
      localSetGroupReq.reqtype = paramToServiceMsg.extraData.getInt("set_type");
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(10);
      DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
      int i = localSetGroupReq.reqtype;
      Object localObject;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              return false;
            }
            localObject = new ReSortGroup();
            ((ReSortGroup)localObject).cGroupId = paramToServiceMsg.extraData.getByteArray("group_id_list");
            ((ReSortGroup)localObject).cSortId = paramToServiceMsg.extraData.getByteArray("sort_id_list");
            ((ReSortGroup)localObject).cNum = ((byte)((ReSortGroup)localObject).cGroupId.length);
            localDataOutputStream.writeByte(((ReSortGroup)localObject).cNum);
            paramToServiceMsg = ((ReSortGroup)localObject).cGroupId;
            localObject = ((ReSortGroup)localObject).cSortId;
            i = 0;
            while (i < paramToServiceMsg.length)
            {
              localDataOutputStream.writeByte(paramToServiceMsg[i]);
              localDataOutputStream.writeByte(localObject[i]);
              i += 1;
            }
          }
          localObject = new DelGroup();
          ((DelGroup)localObject).cGroupId = paramToServiceMsg.extraData.getByte("group_id");
          localDataOutputStream.writeByte(((DelGroup)localObject).cGroupId);
        }
        else
        {
          localObject = new RenameGroup();
          ((RenameGroup)localObject).cGroupId = paramToServiceMsg.extraData.getByte("group_id");
          ((RenameGroup)localObject).sGroupName = paramToServiceMsg.extraData.getString("group_name");
          paramToServiceMsg = ((RenameGroup)localObject).sGroupName.getBytes();
          ((RenameGroup)localObject).cLen = ((byte)paramToServiceMsg.length);
          localDataOutputStream.write(((RenameGroup)localObject).cGroupId);
          localDataOutputStream.writeByte(((RenameGroup)localObject).cLen);
          localDataOutputStream.write(paramToServiceMsg);
        }
      }
      else
      {
        localObject = new AddGroup();
        ((AddGroup)localObject).cSortId = paramToServiceMsg.extraData.getByte("sort_id");
        ((AddGroup)localObject).sGroupName = paramToServiceMsg.extraData.getString("group_name");
        paramToServiceMsg = ((AddGroup)localObject).sGroupName.getBytes();
        ((AddGroup)localObject).cLen = ((byte)paramToServiceMsg.length);
        localDataOutputStream.writeByte(((AddGroup)localObject).cSortId);
        localDataOutputStream.writeByte(((AddGroup)localObject).cLen);
        localDataOutputStream.write(paramToServiceMsg);
      }
      localDataOutputStream.close();
      localSetGroupReq.vecBody = localByteArrayOutputStream.toByteArray();
      paramUniPacket.put("SetGroupReq", localSetGroupReq);
      return true;
    }
    catch (NumberFormatException|IOException paramToServiceMsg) {}
    return false;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return a;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("friendlist.getFriendGroupList".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return f(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetLastLoginInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return g(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.MovGroupMemReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return e(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("BumpSvc.ReqComfirmContactFriend".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return a(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetSimpleOnlineFriendInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return c(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.GetOnlineInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.delFriend".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return d(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("friendlist.SetGroupReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return h(paramToServiceMsg, paramFromServiceMsg);
    }
    if ((!"friendlist.GetTroopListReqV2".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"friendlist.GetMultiTroopInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"friendlist.getTroopRemark".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"friendlist.getTroopMemberList".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"friendlist.ModifyGroupCardReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"friendlist.ModifyGroupInfoReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"friendlist.GetTroopAppointRemarkReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
      return null;
    }
    return this.c.decode(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void decodeRespMsg(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.getFriendGroupList")) {
      return i(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetLastLoginInfoReq")) {
      return l(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.delFriend")) {
      return e(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.checkFriend")) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetSimpleOnlineFriendInfoReq")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetOnlineInfoReq")) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("BumpSvc.ReqComfirmContactFriend")) {
      return a(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.MovGroupMemReq")) {
      return f(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.SetGroupReq")) {
      return m(paramToServiceMsg, paramUniPacket);
    }
    if ((!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetTroopListReqV2")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.getTroopMemberList")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.getTroopRemark")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetMultiTroopInfoReq")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.ModifyGroupCardReq")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetTroopAppointRemarkReq")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.ModifyGroupInfoReq"))) {
      return false;
    }
    return this.c.encodeReqMsg(paramToServiceMsg, paramUniPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.friendlist.FriendListService
 * JD-Core Version:    0.7.0.1
 */