package com.tencent.mobileqq.pic.api.impl;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.haoliyou.JumpShareUtils;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.pic.api.IDep;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager.ConfigType;
import msf.msgsvc.msg_ctrl.MsgCtrl;

public class DepImpl
  implements IDep
{
  public void addWaitingEssenceMsg(String paramString, long paramLong)
  {
    ((TroopEssenceMsgManager)((QQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime()).getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).a(paramString, paramLong);
  }
  
  public void bindAnonymousInfo(MessageRecord paramMessageRecord)
  {
    AnonymousChatHelper.a().a(paramMessageRecord);
  }
  
  public void consumeAllThumbsInPendingQueue()
  {
    ShortVideoPreDownloader localShortVideoPreDownloader = (ShortVideoPreDownloader)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getManager(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER);
    if (localShortVideoPreDownloader != null) {
      localShortVideoPreDownloader.d();
    }
  }
  
  public void fillStickInfo(MessageForPic paramMessageForPic, PicMessageExtraData paramPicMessageExtraData)
  {
    if (paramPicMessageExtraData.stickerInfo != null) {
      paramMessageForPic.saveExtInfoToExtStr("sticker_info", paramPicMessageExtraData.stickerInfo.toJsonString());
    }
    if (!TextUtils.isEmpty(paramMessageForPic.getExtInfoFromExtStr("sticker_info")))
    {
      EmojiStickerManager.a(paramMessageForPic, null);
      EmojiStickerManager.a().a(paramMessageForPic);
    }
  }
  
  public msg_ctrl.MsgCtrl getMsgCtrlForPicMsg(String paramString)
  {
    return JumpShareUtils.a(paramString);
  }
  
  public subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf getPicDownEncryptConf()
  {
    return FMTSrvAddrProvider.getInstance().getPicDownEncryptConf();
  }
  
  public String getServerConfigValue(AppInterface paramAppInterface, ServerConfigManager.ConfigType paramConfigType, String paramString)
  {
    return ((QQAppInterface)paramAppInterface).getServerConfigValue(ServerConfigManager.ConfigType.common, paramString);
  }
  
  public String getZhituText()
  {
    return ZhituManager.a((QQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime()).b();
  }
  
  public void reportEmotionPicMonitor(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean)
  {
    boolean bool = EmoticonPanelUtils.b(paramMessageRecord);
    int i = 2;
    int j = 1;
    if (bool)
    {
      EmoticonOperateReport.reportAIOEmoticonMonitorReceiveStatus("0", 3);
      i = 3;
    }
    else if (EmoticonPanelUtils.a(paramMessageRecord))
    {
      EmoticonOperateReport.reportAIOEmoticonMonitorReceiveStatus("0", 2);
    }
    else
    {
      i = 0;
      j = 0;
    }
    if (j != 0)
    {
      paramMessageRecord = paramString;
      if (paramString == null) {
        paramMessageRecord = "0";
      }
      paramString = null;
      MessageRecord localMessageRecord;
      if (paramBoolean)
      {
        localMessageRecord = paramMessageRecord;
      }
      else
      {
        localMessageRecord = null;
        paramString = paramMessageRecord;
      }
      EmoticonOperateReport.reportAIOEmoticonMonitor(paramString, localMessageRecord, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.impl.DepImpl
 * JD-Core Version:    0.7.0.1
 */