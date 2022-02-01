package com.tencent.mobileqq.troop.essence.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.essence.api.ITroopEssenceHandler;
import com.tencent.mobileqq.troop.essence.data.TroopCardEssenceMsg;
import com.tencent.mobileqq.troop.essence.data.TroopCardEssenceMsg.EssenceMsgContent;
import com.tencent.mobileqq.troop.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.observer.TroopEssenceMsgObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.cmd0xeac.oidb_0xeac.BatchReqBody;
import tencent.im.oidb.cmd0xeac.oidb_0xeac.BatchRspBody;
import tencent.im.oidb.cmd0xeac.oidb_0xeac.MsgInfo;
import tencent.im.oidb.cmd0xeac.oidb_0xeac.ReqBody;
import tencent.im.oidb.cmd0xeac.oidb_0xeac.RspBody;
import tencent.im.oidb.cmd0xef0.oidb_0xef0.GroupInfoExt;
import tencent.im.oidb.cmd0xf00.oidb_0xf00.GroupInfoExt;
import tencent.im.oidb.cmd0xf00.oidb_0xf00.ReqBody;
import tencent.im.oidb.cmd0xf00.oidb_0xf00.RspBody;
import tencent.im.oidb.cmd0xf10.oidb_0xf10.MsgContent;
import tencent.im.oidb.cmd0xf10.oidb_0xf10.MsgInfo;
import tencent.im.oidb.cmd0xf10.oidb_0xf10.ReqBody;
import tencent.im.oidb.cmd0xf10.oidb_0xf10.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopEssenceMsgHandler
  extends TroopBaseHandler
  implements ITroopEssenceHandler
{
  protected Set<String> a;
  
  public TroopEssenceMsgHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("troop_uin", 0L);
    int i = paramFromServiceMsg.getResultCode();
    TroopInfo localTroopInfo = null;
    paramFromServiceMsg = null;
    Object localObject;
    if (i == 1000)
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handle_oidb_0x88d_1_2|oidb_sso parseFrom byte ");
          ((StringBuilder)localObject).append(paramObject.toString());
          QLog.d("Q.troopdisband.", 2, ((StringBuilder)localObject).toString());
        }
        paramObject.printStackTrace();
      }
      if (paramToServiceMsg != null)
      {
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handle_oidb_0x88d_10|oidb_sso.OIDBSSOPkg.result ");
          paramObject.append(i);
          QLog.d("TroopEssenceMsgHandler", 2, paramObject.toString());
        }
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      }
    }
    for (;;)
    {
      int j;
      try
      {
        paramObject = new oidb_0x88d.RspBody();
        paramObject.mergeFrom(paramToServiceMsg);
        localObject = paramObject.stzrspgroupinfo.get();
        if (localObject == null) {
          i = 0;
        } else {
          i = ((List)localObject).size();
        }
      }
      catch (Exception paramToServiceMsg)
      {
        oidb_0x88d.RspGroupInfo localRspGroupInfo;
        paramFromServiceMsg = null;
        bool = false;
      }
      if ((paramObject == null) && (j < i))
      {
        localRspGroupInfo = (oidb_0x88d.RspGroupInfo)((List)localObject).get(j);
        paramToServiceMsg = paramObject;
        if (localRspGroupInfo != null) {
          if (localRspGroupInfo.uint64_group_code.get() != l)
          {
            paramToServiceMsg = paramObject;
          }
          else
          {
            paramToServiceMsg = paramObject;
            if (localRspGroupInfo.uint32_result.get() == 0)
            {
              paramToServiceMsg = paramObject;
              if (localRspGroupInfo.stgroupinfo.has()) {
                paramToServiceMsg = (oidb_0x88d.GroupInfo)localRspGroupInfo.stgroupinfo.get();
              }
            }
          }
        }
        j += 1;
        paramObject = paramToServiceMsg;
      }
      else
      {
        boolean bool;
        if (paramObject != null)
        {
          paramToServiceMsg = paramFromServiceMsg;
          try
          {
            paramFromServiceMsg = ((ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(l));
            paramToServiceMsg = paramFromServiceMsg;
            if (paramFromServiceMsg == null) {}
            try
            {
              localTroopInfo = new TroopInfo();
              paramToServiceMsg = localTroopInfo;
              localTroopInfo.troopuin = String.valueOf(l);
              paramToServiceMsg = localTroopInfo;
              paramFromServiceMsg = paramToServiceMsg;
              if (paramObject.st_group_info_ext.has())
              {
                paramFromServiceMsg = paramToServiceMsg;
                paramToServiceMsg.mTroopInfoExtObj = TroopInfoExt.parseFromGroupInfoExt((oidb_0xef0.GroupInfoExt)paramObject.st_group_info_ext.get());
              }
              bool = true;
            }
            catch (Exception paramToServiceMsg) {}
            bool = true;
          }
          catch (Exception paramObject)
          {
            paramFromServiceMsg = paramToServiceMsg;
            paramToServiceMsg = paramObject;
          }
          if (QLog.isColorLevel()) {
            QLog.i("TroopEssenceMsgHandler", 2, paramToServiceMsg.toString());
          }
          paramToServiceMsg = paramFromServiceMsg;
        }
        else
        {
          bool = false;
          paramToServiceMsg = localTroopInfo;
        }
        notifyUI(TroopEssenceMsgObserver.f, bool, new Object[] { String.valueOf(l), paramToServiceMsg });
        return;
        paramObject = null;
        j = 0;
      }
    }
  }
  
  public void a(long paramLong, ArrayList<TroopEssenceMsgItem> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      Object localObject1 = new oidb_0xeac.BatchReqBody();
      ((oidb_0xeac.BatchReqBody)localObject1).group_code.set(paramLong);
      Object localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        TroopEssenceMsgItem localTroopEssenceMsgItem = (TroopEssenceMsgItem)((Iterator)localObject2).next();
        oidb_0xeac.MsgInfo localMsgInfo = new oidb_0xeac.MsgInfo();
        localMsgInfo.msg_seq.set((int)localTroopEssenceMsgItem.msgSeq & 0xFFFFFFFF);
        localMsgInfo.msg_random.set(localTroopEssenceMsgItem.msgRandom);
        ((oidb_0xeac.BatchReqBody)localObject1).msgs.add(localMsgInfo);
      }
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(3756);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(4);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xeac.BatchReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("OidbSvc.0xeac_4");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putLong("troopUin", paramLong);
      ((ToServiceMsg)localObject1).extraData.putSerializable("extdata", paramArrayList);
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      sendPbReq((ToServiceMsg)localObject1);
    }
  }
  
  public void a(TroopEssenceMsgItem paramTroopEssenceMsgItem, int paramInt)
  {
    if (paramTroopEssenceMsgItem == null) {
      return;
    }
    Object localObject = new oidb_0xeac.ReqBody();
    ((oidb_0xeac.ReqBody)localObject).group_code.set(paramTroopEssenceMsgItem.troopUin);
    ((oidb_0xeac.ReqBody)localObject).msg_seq.set((int)paramTroopEssenceMsgItem.msgSeq & 0xFFFFFFFF);
    ((oidb_0xeac.ReqBody)localObject).msg_random.set(paramTroopEssenceMsgItem.msgRandom);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(3756);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(paramTroopEssenceMsgItem.opType);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xeac.ReqBody)localObject).toByteArray()));
    localObject = null;
    if (paramTroopEssenceMsgItem.opType == 1) {
      localObject = createToServiceMsg("OidbSvc.0xeac_1");
    } else if (paramTroopEssenceMsgItem.opType == 2) {
      localObject = createToServiceMsg("OidbSvc.0xeac_2");
    }
    if (localObject != null)
    {
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(5000L);
      ((ToServiceMsg)localObject).extraData.putSerializable("extdata", paramTroopEssenceMsgItem);
      ((ToServiceMsg)localObject).extraData.putInt("from", paramInt);
      sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      oidb_0xeac.RspBody localRspBody = new oidb_0xeac.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      if (i == 0)
      {
        notifyUI(TroopEssenceMsgObserver.b, true, new Object[] { paramToServiceMsg.extraData.getSerializable("extdata"), localRspBody, Integer.valueOf(i) });
        return;
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleSetTroopEssenceMsg failed result:");
      paramFromServiceMsg.append(i);
      QLog.i("TroopEssenceMsgHandler", 2, paramFromServiceMsg.toString());
      notifyUI(TroopEssenceMsgObserver.b, false, new Object[] { paramToServiceMsg.extraData.getSerializable("extdata"), localRspBody, Integer.valueOf(i) });
      return;
    }
    notifyUI(TroopEssenceMsgObserver.b, false, new Object[] { Integer.valueOf(0), null, Integer.valueOf(-1) });
  }
  
  public void a(String paramString)
  {
    Object localObject1 = new oidb_0x88d.GroupInfo();
    Object localObject2 = new oidb_0xef0.GroupInfoExt();
    ((oidb_0xef0.GroupInfoExt)localObject2).uint32_essential_msg_switch.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).st_group_info_ext.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set((MessageMicro)localObject1);
    localObject1 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(this.appRuntime.getAppid());
    ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0x88d_1_2");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString));
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getEssenceMsgList：");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TroopEssenceMsgHandler", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new oidb_0xf10.ReqBody();
      ((oidb_0xf10.ReqBody)localObject).group_code.set(Long.valueOf(paramString).longValue());
      ((oidb_0xf10.ReqBody)localObject).source.set(paramInt);
      localObject = makeOIDBPkg("OidbSvc.0xf10", 3856, 0, ((oidb_0xf10.ReqBody)localObject).toByteArray(), 30000L);
      ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
      ((ToServiceMsg)localObject).extraData.putInt("source", paramInt);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("TroopEssenceMsgHandler", 1, "setEssenceMsgShowInCardSwitch troopUin is null");
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setEssenceMsgShowInCardSwitch troopUin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",isChecked");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("TroopEssenceMsgHandler", 1, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        localObject = new oidb_0xf00.ReqBody();
        ((oidb_0xf00.ReqBody)localObject).uint64_group_code.set(Long.parseLong(paramString));
        oidb_0xf00.GroupInfoExt localGroupInfoExt = new oidb_0xf00.GroupInfoExt();
        PBUInt32Field localPBUInt32Field = localGroupInfoExt.uint32_essential_msg_switch;
        if (paramBoolean)
        {
          i = 1;
          localPBUInt32Field.set(i);
          ((oidb_0xf00.ReqBody)localObject).msg_group_info_ext.set(localGroupInfoExt);
          localObject = makeOIDBPkg("OidbSvc.0xf00_3", 3840, 3, ((oidb_0xf00.ReqBody)localObject).toByteArray(), 30000L);
          ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
          ((ToServiceMsg)localObject).extraData.putBoolean("isChecked", paramBoolean);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setEssenceMsgShowInCardSwitch Exception e:");
        ((StringBuilder)localObject).append(paramString.getClass().getSimpleName());
        QLog.e("TroopEssenceMsgHandler", 1, ((StringBuilder)localObject).toString());
        paramString.printStackTrace();
        return;
      }
      int i = 0;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      oidb_0xeac.BatchRspBody localBatchRspBody = new oidb_0xeac.BatchRspBody();
      long l = paramToServiceMsg.extraData.getLong("troopUin");
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localBatchRspBody);
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleBatchSetTroopEssenceMsgs failed result:");
          paramFromServiceMsg.append(i);
          QLog.i("TroopEssenceMsgHandler", 2, paramFromServiceMsg.toString());
        }
        notifyUI(TroopEssenceMsgObserver.c, false, new Object[] { Long.valueOf(l), paramToServiceMsg.extraData.getSerializable("extdata"), localBatchRspBody, Integer.valueOf(i) });
        return;
      }
      notifyUI(TroopEssenceMsgObserver.c, true, new Object[] { Long.valueOf(l), paramToServiceMsg.extraData.getSerializable("extdata"), localBatchRspBody, Integer.valueOf(i) });
      return;
    }
    notifyUI(TroopEssenceMsgObserver.c, false, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(-1) });
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      String str = paramToServiceMsg.extraData.getString("troopUin");
      int i = paramToServiceMsg.extraData.getInt("source");
      try
      {
        Object localObject = new oidb_0xf10.RspBody();
        int j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
        if (j != 0)
        {
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handleGetEssenceMsgListResp failed, result: ");
            paramToServiceMsg.append(j);
            QLog.d("TroopEssenceMsgHandler", 2, paramToServiceMsg.toString());
          }
          notifyUI(TroopEssenceMsgObserver.d, false, null);
          return;
        }
        j = ((oidb_0xf10.RspBody)localObject).total_count.get();
        paramToServiceMsg = ((oidb_0xf10.RspBody)localObject).jump_url.get();
        paramFromServiceMsg = new ArrayList();
        paramObject = ((oidb_0xf10.RspBody)localObject).msg_list.get().iterator();
        while (paramObject.hasNext())
        {
          localObject = (oidb_0xf10.MsgInfo)paramObject.next();
          if (localObject != null)
          {
            TroopCardEssenceMsg localTroopCardEssenceMsg = new TroopCardEssenceMsg();
            localTroopCardEssenceMsg.troopUin = str;
            localTroopCardEssenceMsg.jumpUrl = paramToServiceMsg;
            if (localTroopCardEssenceMsg.msgContent == null) {
              localTroopCardEssenceMsg.msgContent = new ArrayList();
            }
            Iterator localIterator = ((oidb_0xf10.MsgInfo)localObject).msg_content.get().iterator();
            while (localIterator.hasNext())
            {
              oidb_0xf10.MsgContent localMsgContent = (oidb_0xf10.MsgContent)localIterator.next();
              if (localMsgContent != null)
              {
                localTroopCardEssenceMsg.getClass();
                TroopCardEssenceMsg.EssenceMsgContent localEssenceMsgContent = new TroopCardEssenceMsg.EssenceMsgContent(localTroopCardEssenceMsg);
                localEssenceMsgContent.msgType = localMsgContent.msg_type.get();
                localEssenceMsgContent.text = localMsgContent.text.get();
                localEssenceMsgContent.faceIndext = localMsgContent.face_index.get();
                localEssenceMsgContent.faceText = localMsgContent.face_text.get();
                localEssenceMsgContent.imageUrl = localMsgContent.image_url.get();
                localEssenceMsgContent.imageThumbnailUrl = localMsgContent.image_thumbnail_url.get();
                localEssenceMsgContent.shareTitle = localMsgContent.share_title.get();
                localEssenceMsgContent.shareSummary = localMsgContent.share_summary.get();
                localEssenceMsgContent.shareBrief = localMsgContent.share_brief.get();
                localEssenceMsgContent.shareUrl = localMsgContent.share_url.get();
                localEssenceMsgContent.shareAction = localMsgContent.share_action.get();
                localEssenceMsgContent.shareSource = localMsgContent.share_source.get();
                localEssenceMsgContent.shareImageUrl = localMsgContent.share_image_url.get();
                localEssenceMsgContent.fileThumbnailUrl = localMsgContent.file_thumbnail_url.get();
                localEssenceMsgContent.fileSize = localMsgContent.file_size.get();
                localEssenceMsgContent.fileName = localMsgContent.file_name.get();
                localEssenceMsgContent.jumpUrlForMore = ((oidb_0xf10.MsgInfo)localObject).jump_url.get();
                localTroopCardEssenceMsg.msgContent.add(localEssenceMsgContent);
              }
            }
            paramFromServiceMsg.add(localTroopCardEssenceMsg);
          }
        }
        notifyUI(TroopEssenceMsgObserver.d, true, new Object[] { str, Integer.valueOf(i), paramFromServiceMsg, Integer.valueOf(j) });
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        notifyUI(TroopEssenceMsgObserver.d, false, new Object[] { str, Integer.valueOf(i), null });
        paramToServiceMsg.printStackTrace();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopEssenceMsgHandler", 2, "handleGetEssenceMsgListResp resp == null || res == null");
    }
    notifyUI(TroopEssenceMsgObserver.d, false, null);
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null)) {}
    for (;;)
    {
      try
      {
        Object localObject = new oidb_0xf00.RspBody();
        i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
        if (i != 0)
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleSettEssenceMsgShowInCardSwitchResp resp result：");
          paramToServiceMsg.append(i);
          QLog.e("TroopEssenceMsgHandler", 2, paramToServiceMsg.toString());
          notifyUI(TroopEssenceMsgObserver.e, false, null);
          return;
        }
        boolean bool = paramToServiceMsg.extraData.getBoolean("isChecked", false);
        paramToServiceMsg = String.valueOf(((oidb_0xf00.RspBody)localObject).uint64_group_code.get());
        if (((oidb_0xf00.RspBody)localObject).int32_result.get() != 0)
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleSettEssenceMsgShowInCardSwitchResp resp rs：");
          paramFromServiceMsg.append(i);
          QLog.e("TroopEssenceMsgHandler", 2, paramFromServiceMsg.toString());
          notifyUI(TroopEssenceMsgObserver.e, false, new Object[] { paramToServiceMsg, Boolean.valueOf(bool) });
          return;
        }
        paramFromServiceMsg = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
        paramObject = paramFromServiceMsg.findTroopInfo(paramToServiceMsg);
        localObject = paramObject.mTroopInfoExtObj;
        if (!bool) {
          break label322;
        }
        i = 1;
        ((TroopInfoExt)localObject).essenceSwitch = i;
        paramFromServiceMsg.saveTroopInfo(paramObject);
        notifyUI(TroopEssenceMsgObserver.e, true, new Object[] { paramToServiceMsg, Boolean.valueOf(bool) });
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        notifyUI(TroopEssenceMsgObserver.e, false, null);
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleSettEssenceMsgShowInCardSwitchResp resp e：");
        paramFromServiceMsg.append(paramToServiceMsg.getClass().getSimpleName());
        QLog.e("TroopEssenceMsgHandler", 2, paramFromServiceMsg.toString());
        paramToServiceMsg.printStackTrace();
        return;
      }
      QLog.e("TroopEssenceMsgHandler", 2, "handleSettEssenceMsgShowInCardSwitchResp resp == null || res == null");
      notifyUI(TroopEssenceMsgObserver.e, false, null);
      return;
      label322:
      int i = 0;
    }
  }
  
  protected String dv_()
  {
    return "TroopEssenceMsgHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("OidbSvc.0xeac_1");
      this.a.add("OidbSvc.0xeac_2");
      this.a.add("OidbSvc.0xeac_4");
      this.a.add("OidbSvc.0xf10");
      this.a.add("OidbSvc.0xf00_3");
      this.a.add("OidbSvc.0x88d_1_2");
    }
    return this.a;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopEssenceMsgObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEssenceMsgHandler", 2, "onReceive,resp == null");
      }
      return;
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(str);
        QLog.d("TroopEssenceMsgHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if (!dv_().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("REQ_TAG doesn't match. cmd:  ");
        paramToServiceMsg.append(str);
        QLog.d("TroopEssenceMsgHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if ((!"OidbSvc.0xeac_1".equals(paramFromServiceMsg.getServiceCmd())) && (!"OidbSvc.0xeac_2".equals(paramFromServiceMsg.getServiceCmd())))
    {
      if ("OidbSvc.0xeac_4".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xf10".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xf00_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x88d_1_2".equals(paramFromServiceMsg.getServiceCmd())) {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    else
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.essence.handler.TroopEssenceMsgHandler
 * JD-Core Version:    0.7.0.1
 */