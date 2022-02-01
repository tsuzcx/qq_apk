package com.tencent.mobileqq.troop.api.essence.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.essence.data.TroopCardEssenceMsg;
import com.tencent.mobileqq.troop.api.essence.data.TroopCardEssenceMsg.EssenceMsgContent;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.observer.TroopApiObserver;
import com.tencent.mobileqq.troop.utils.TroopApiConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0xeac.oidb_0xeac.BatchReqBody;
import tencent.im.oidb.cmd0xeac.oidb_0xeac.BatchRspBody;
import tencent.im.oidb.cmd0xeac.oidb_0xeac.MsgInfo;
import tencent.im.oidb.cmd0xeac.oidb_0xeac.ReqBody;
import tencent.im.oidb.cmd0xeac.oidb_0xeac.RspBody;
import tencent.im.oidb.cmd0xf00.oidb_0xf00.GroupInfoExt;
import tencent.im.oidb.cmd0xf00.oidb_0xf00.ReqBody;
import tencent.im.oidb.cmd0xf00.oidb_0xf00.RspBody;
import tencent.im.oidb.cmd0xf10.oidb_0xf10.MsgContent;
import tencent.im.oidb.cmd0xf10.oidb_0xf10.MsgInfo;
import tencent.im.oidb.cmd0xf10.oidb_0xf10.ReqBody;
import tencent.im.oidb.cmd0xf10.oidb_0xf10.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopEssenceMsgHandler
  extends BusinessHandler
{
  protected Set<String> a;
  
  public TroopEssenceMsgHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(long paramLong, ArrayList<TroopEssenceMsgItem> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
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
  
  public void a(TroopEssenceMsgItem paramTroopEssenceMsgItem, int paramInt)
  {
    if (paramTroopEssenceMsgItem == null) {}
    for (;;)
    {
      return;
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
      }
      while (localObject != null)
      {
        ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
        ((ToServiceMsg)localObject).setTimeout(5000L);
        ((ToServiceMsg)localObject).extraData.putSerializable("extdata", paramTroopEssenceMsgItem);
        ((ToServiceMsg)localObject).extraData.putInt("from", paramInt);
        sendPbReq((ToServiceMsg)localObject);
        return;
        if (paramTroopEssenceMsgItem.opType == 2) {
          localObject = createToServiceMsg("OidbSvc.0xeac_2");
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(TroopApiConstants.a, false, new Object[] { Integer.valueOf(0), null, Integer.valueOf(-1) });
      return;
    }
    oidb_0xeac.RspBody localRspBody = new oidb_0xeac.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (i == 0)
    {
      notifyUI(TroopApiConstants.a, true, new Object[] { paramToServiceMsg.extraData.getSerializable("extdata"), localRspBody, Integer.valueOf(i) });
      return;
    }
    QLog.i("TroopEssenceMsgHandler", 2, "handleSetTroopEssenceMsg failed result:" + i);
    notifyUI(TroopApiConstants.a, false, new Object[] { paramToServiceMsg.extraData.getSerializable("extdata"), localRspBody, Integer.valueOf(i) });
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEssenceMsgHandler", 2, "getEssenceMsgList：" + paramString + " " + paramInt);
    }
    try
    {
      Object localObject = new oidb_0xf10.ReqBody();
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
    if (QLog.isColorLevel()) {
      QLog.i("TroopEssenceMsgHandler", 1, "setEssenceMsgShowInCardSwitch troopUin=" + paramString + ",isChecked" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        Object localObject = new oidb_0xf00.ReqBody();
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
        QLog.e("TroopEssenceMsgHandler", 1, "setEssenceMsgShowInCardSwitch Exception e:" + paramString.getClass().getSimpleName());
        paramString.printStackTrace();
        return;
      }
      int i = 0;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(TroopApiConstants.b, false, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(-1) });
      return;
    }
    oidb_0xeac.BatchRspBody localBatchRspBody = new oidb_0xeac.BatchRspBody();
    long l = paramToServiceMsg.extraData.getLong("troopUin");
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localBatchRspBody);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopEssenceMsgHandler", 2, "handleBatchSetTroopEssenceMsgs failed result:" + i);
      }
      notifyUI(TroopApiConstants.b, false, new Object[] { Long.valueOf(l), paramToServiceMsg.extraData.getSerializable("extdata"), localBatchRspBody, Integer.valueOf(i) });
      return;
    }
    notifyUI(TroopApiConstants.b, true, new Object[] { Long.valueOf(l), paramToServiceMsg.extraData.getSerializable("extdata"), localBatchRspBody, Integer.valueOf(i) });
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEssenceMsgHandler", 2, "handleGetEssenceMsgListResp resp == null || res == null");
      }
      notifyUI(TroopApiConstants.c, false, null);
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopUin");
    int i = paramToServiceMsg.extraData.getInt("source");
    Object localObject;
    try
    {
      localObject = new oidb_0xf10.RspBody();
      j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopEssenceMsgHandler", 2, "handleGetEssenceMsgListResp failed, result: " + j);
        }
        notifyUI(TroopApiConstants.c, false, null);
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      notifyUI(TroopApiConstants.c, false, new Object[] { str, Integer.valueOf(i), null });
      paramToServiceMsg.printStackTrace();
      return;
    }
    int j = ((oidb_0xf10.RspBody)localObject).total_count.get();
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
    notifyUI(TroopApiConstants.c, true, new Object[] { str, Integer.valueOf(i), paramFromServiceMsg, Integer.valueOf(j) });
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 1;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      QLog.e("TroopEssenceMsgHandler", 2, "handleSettEssenceMsgShowInCardSwitchResp resp == null || res == null");
      notifyUI(TroopApiConstants.d, false, null);
      return;
    }
    int j;
    try
    {
      localObject = new oidb_0xf00.RspBody();
      j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      if (j != 0)
      {
        QLog.e("TroopEssenceMsgHandler", 2, "handleSettEssenceMsgShowInCardSwitchResp resp result：" + j);
        notifyUI(TroopApiConstants.d, false, null);
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      notifyUI(TroopApiConstants.d, false, null);
      QLog.e("TroopEssenceMsgHandler", 2, "handleSettEssenceMsgShowInCardSwitchResp resp e：" + paramToServiceMsg.getClass().getSimpleName());
      paramToServiceMsg.printStackTrace();
      return;
    }
    boolean bool = paramToServiceMsg.extraData.getBoolean("isChecked", false);
    paramToServiceMsg = String.valueOf(((oidb_0xf00.RspBody)localObject).uint64_group_code.get());
    if (((oidb_0xf00.RspBody)localObject).int32_result.get() != 0)
    {
      QLog.e("TroopEssenceMsgHandler", 2, "handleSettEssenceMsgShowInCardSwitchResp resp rs：" + j);
      notifyUI(TroopApiConstants.d, false, new Object[] { paramToServiceMsg, Boolean.valueOf(bool) });
      return;
    }
    paramFromServiceMsg = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    paramObject = paramFromServiceMsg.findTroopInfo(paramToServiceMsg);
    Object localObject = paramObject.mTroopInfoExtObj;
    if (bool) {}
    for (;;)
    {
      ((TroopInfoExt)localObject).essenceSwitch = i;
      paramFromServiceMsg.saveTroopInfo(paramObject);
      notifyUI(TroopApiConstants.d, true, new Object[] { paramToServiceMsg, Boolean.valueOf(bool) });
      return;
      i = 0;
    }
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
    }
    return this.a;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return TroopApiObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEssenceMsgHandler", 2, "onReceive,resp == null");
      }
    }
    do
    {
      String str;
      do
      {
        return;
        str = paramFromServiceMsg.getServiceCmd();
        if (!msgCmdFilter(str)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopEssenceMsgHandler", 2, "cmdfilter error=" + str);
      return;
      if (("OidbSvc.0xeac_1".equals(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0xeac_2".equals(paramFromServiceMsg.getServiceCmd())))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
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
    } while (!"OidbSvc.0xf00_3".equals(paramFromServiceMsg.getServiceCmd()));
    d(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.essence.handler.TroopEssenceMsgHandler
 * JD-Core Version:    0.7.0.1
 */