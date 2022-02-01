package com.tencent.mobileqq.msgbackup.tempapi.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.mtt.MttBrowerWrapper;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.TransMsgContext;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.settings.message.ChatHistorySettingFragment;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileDataManager;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.List;
import java.util.UUID;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;

public class MsgBackupTempApiImpl
  implements IMsgBackupTempApi
{
  protected RecentFaceDecoder mFaceDecoder;
  
  private TroopFileInfo getTroopFileInfo(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, MessageForTroopFile paramMessageForTroopFile)
  {
    return TroopFileManager.a((QQAppInterface)paramBaseQQAppInterface, paramLong).b(paramMessageForTroopFile.url, paramMessageForTroopFile.fileName, paramMessageForTroopFile.fileSize, paramMessageForTroopFile.bisID);
  }
  
  private TroopFileTransferManager.Item getTroopFileTransferManagerItem(BaseQQAppInterface paramBaseQQAppInterface, String paramString, MessageForTroopFile paramMessageForTroopFile)
  {
    paramBaseQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
    paramString = TroopFileTransferManager.a(paramBaseQQAppInterface, Long.parseLong(paramString));
    paramBaseQQAppInterface = TroopFileUtils.a(paramBaseQQAppInterface, paramMessageForTroopFile);
    if ((paramString != null) && (paramBaseQQAppInterface != null) && (paramBaseQQAppInterface.jdField_a_of_type_JavaUtilUUID != null)) {
      return paramString.a(paramBaseQQAppInterface.jdField_a_of_type_JavaUtilUUID);
    }
    return null;
  }
  
  public ChatMessage changeRealChatMessage(ChatMessage paramChatMessage)
  {
    return FileManagerUtil.a(paramChatMessage);
  }
  
  public MessageRecord changeRichTextToTextMsg(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord, String paramString, boolean paramBoolean)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getMultiMessageProxy().a(paramMessageRecord, paramString, false);
  }
  
  public msg_svc.PbSendMsgReq createPbSendMsgReq(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, String paramString, TransMsgContext paramTransMsgContext, long paramLong, int paramInt2)
  {
    return MessageProtoCodec.a(paramBaseQQAppInterface, paramInt1, paramString, paramTransMsgContext, paramLong, paramInt2);
  }
  
  public void destoryFaceDecord()
  {
    RecentFaceDecoder localRecentFaceDecoder = this.mFaceDecoder;
    if (localRecentFaceDecoder != null)
    {
      localRecentFaceDecoder.a();
      this.mFaceDecoder = null;
    }
  }
  
  public void fillMsgHeader(BaseQQAppInterface paramBaseQQAppInterface, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, Long paramLong)
  {
    new ProtocolHelper(paramBaseQQAppInterface, 0).fillMsgHeader(paramMsgHeader, paramLong.longValue());
  }
  
  public List getAllMsgTableData(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getMessageFacade().b();
  }
  
  public MqqHandler getConversationHandler(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return paramBaseQQAppInterface.getHandler(Conversation.class);
  }
  
  public String getCreateFileName(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, MessageForTroopFile paramMessageForTroopFile)
  {
    paramBaseQQAppInterface = getTroopFileInfo(paramBaseQQAppInterface, paramLong, paramMessageForTroopFile);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.c;
    }
    return null;
  }
  
  public Drawable getFaceDrawable(BaseQQAppInterface paramBaseQQAppInterface, DecodeTaskCompletionListener paramDecodeTaskCompletionListener, int paramInt, String paramString)
  {
    if (this.mFaceDecoder == null) {
      this.mFaceDecoder = new RecentFaceDecoder((QQAppInterface)paramBaseQQAppInterface, paramDecodeTaskCompletionListener, false);
    }
    return this.mFaceDecoder.a(paramInt, paramString);
  }
  
  public Drawable getFaceDrawable(BaseQQAppInterface paramBaseQQAppInterface, DecodeTaskCompletionListener paramDecodeTaskCompletionListener, RecentBaseData paramRecentBaseData)
  {
    if (this.mFaceDecoder == null) {
      this.mFaceDecoder = new RecentFaceDecoder((QQAppInterface)paramBaseQQAppInterface, paramDecodeTaskCompletionListener, false);
    }
    return this.mFaceDecoder.a(paramRecentBaseData);
  }
  
  public byte[] getFileIdByte(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, MessageForTroopFile paramMessageForTroopFile)
  {
    paramBaseQQAppInterface = getTroopFileInfo(paramBaseQQAppInterface, paramLong, paramMessageForTroopFile);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.b.getBytes();
    }
    return null;
  }
  
  public int getFileImageHeight(BaseQQAppInterface paramBaseQQAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    paramBaseQQAppInterface = getTroopFileStatusInfo(paramBaseQQAppInterface, paramMessageForTroopFile);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.f;
    }
    return 0;
  }
  
  public int getFileImageWidth(BaseQQAppInterface paramBaseQQAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    paramBaseQQAppInterface = getTroopFileStatusInfo(paramBaseQQAppInterface, paramMessageForTroopFile);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.e;
    }
    return 0;
  }
  
  public int getFileType(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramBaseQQAppInterface = getTroopFileStatusInfo(paramBaseQQAppInterface, paramMessageRecord);
    if (paramBaseQQAppInterface != null) {
      return FileManagerUtil.a(paramBaseQQAppInterface.g);
    }
    return 0;
  }
  
  public Pair<Integer, Integer> getHeadIcon(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, String paramString)
  {
    return RecentFaceDecoder.a((QQAppInterface)paramBaseQQAppInterface, paramInt, paramString);
  }
  
  public int getInActionLoginB(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).mAutomator.a();
  }
  
  public String getLargeThumbPath(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramBaseQQAppInterface = getTroopFileStatusInfo(paramBaseQQAppInterface, paramMessageRecord);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.c;
    }
    return null;
  }
  
  public String getLargeThumbPath2(BaseQQAppInterface paramBaseQQAppInterface, String paramString, MessageForTroopFile paramMessageForTroopFile)
  {
    paramBaseQQAppInterface = getTroopFileTransferManagerItem(paramBaseQQAppInterface, paramString, paramMessageForTroopFile);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.largeThumbnailFile;
    }
    return null;
  }
  
  public String getLocalFilePath(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramBaseQQAppInterface = getTroopFileStatusInfo(paramBaseQQAppInterface, paramMessageRecord);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public String getLocalFilePath2(BaseQQAppInterface paramBaseQQAppInterface, String paramString, MessageForTroopFile paramMessageForTroopFile)
  {
    paramBaseQQAppInterface = getTroopFileTransferManagerItem(paramBaseQQAppInterface, paramString, paramMessageForTroopFile);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.LocalFile;
    }
    return null;
  }
  
  public MessageRecord getMessageRecord(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getMessageFacade().a(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public im_msg_body.MsgBody getMultiMsgBody(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getMultiMessageProxy().a(paramMessageRecord, false);
  }
  
  public msg_comm.MsgHead getMultiMsgHead(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord, long paramLong)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getMultiMessageProxy().a(paramMessageRecord, null, false, 0, false);
  }
  
  public String getTroopFileItemFileName(BaseQQAppInterface paramBaseQQAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    paramBaseQQAppInterface = getTroopFileTransferManagerItem(paramBaseQQAppInterface, paramMessageForTroopFile.frienduin, paramMessageForTroopFile);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.FileName;
    }
    return null;
  }
  
  public String getTroopFileItemId(BaseQQAppInterface paramBaseQQAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    paramBaseQQAppInterface = getTroopFileTransferManagerItem(paramBaseQQAppInterface, paramMessageForTroopFile.frienduin, paramMessageForTroopFile);
    if (paramBaseQQAppInterface != null) {
      return paramBaseQQAppInterface.Id.toString();
    }
    return null;
  }
  
  public TroopFileStatusInfo getTroopFileStatusInfo(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.isMultiMsg)
    {
      paramMessageRecord = (MessageForTroopFile)FileManagerUtil.a((ChatMessage)paramMessageRecord);
      return TroopFileUtils.a((QQAppInterface)paramBaseQQAppInterface, paramMessageRecord);
    }
    paramMessageRecord = (MessageForTroopFile)paramMessageRecord;
    return TroopFileUtils.a((QQAppInterface)paramBaseQQAppInterface, paramMessageRecord);
  }
  
  public String getTroopThumbnailFile(long paramLong, String paramString)
  {
    return QFileUtils.a(paramLong, 640, paramString);
  }
  
  public String getTroopThumbnailFilePath(long paramLong, int paramInt, String paramString)
  {
    return QFileUtils.a(paramLong, paramInt, paramString);
  }
  
  public String getUnsupportMsgStr(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    return MultiMsgUtil.a((QQAppInterface)paramBaseQQAppInterface, (ChatMessage)paramMessageRecord);
  }
  
  public boolean getUseNewSettings(AppInterface paramAppInterface)
  {
    return SettingsConfigHelper.a(paramAppInterface);
  }
  
  public void gotoChatHistoryFragment(Context paramContext, Intent paramIntent)
  {
    PublicFragmentActivity.a(paramContext, paramIntent, ChatHistorySettingFragment.class);
  }
  
  public void gotoConversation(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, SplashActivity.class);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    localIntent.putExtra("fragment_id", 1);
    localIntent.setFlags(67108864);
    paramActivity.startActivity(localIntent);
  }
  
  public void gotoQQSettingMsgClearFragment(Context paramContext, Intent paramIntent)
  {
    PublicFragmentActivity.a(paramContext, paramIntent, QQSettingMsgClearFragment.class);
  }
  
  public void gotoWebViewBrowser(Context paramContext, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Object paramObject, String paramString2)
  {
    MttBrowerWrapper.a(paramContext, paramString1, true, true, true, false, null, "biz_src_msg_backup");
  }
  
  public String handleMultiMsg(MessageRecord paramMessageRecord)
  {
    return ((MessageForStructing)paramMessageRecord).structingMsg.mFileName;
  }
  
  public void insertToFMList(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    ((QQAppInterface)paramBaseQQAppInterface).getFileManagerDataCenter().c(paramFileManagerEntity);
  }
  
  public void insertToMemMap(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    ((QQAppInterface)paramBaseQQAppInterface).getFileManagerDataCenter().a(paramFileManagerEntity);
  }
  
  public boolean isAnonymousMsg(MessageRecord paramMessageRecord)
  {
    return AnonymousChatHelper.a(paramMessageRecord);
  }
  
  public boolean isBeancurdMsg(ChatMessage paramChatMessage)
  {
    return BeancurdManager.a(paramChatMessage);
  }
  
  public boolean isMultiMsg(ChatMessage paramChatMessage)
  {
    return MultiMsgUtil.a(paramChatMessage);
  }
  
  public boolean isNeedHandle(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    return getTroopFileStatusInfo(paramBaseQQAppInterface, paramMessageRecord) != null;
  }
  
  public boolean isNeedHandleCreateTroopFileInfo(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, MessageForTroopFile paramMessageForTroopFile)
  {
    return (TroopFileDataManager.a(paramLong) != null) && (getTroopFileInfo(paramBaseQQAppInterface, paramLong, paramMessageForTroopFile) != null);
  }
  
  public boolean isNeedHandleTroopFileRecord(BaseQQAppInterface paramBaseQQAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    return getTroopFileTransferManagerItem(paramBaseQQAppInterface, paramMessageForTroopFile.frienduin, paramMessageForTroopFile) != null;
  }
  
  public boolean isSupportMsgType(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    return MultiMsgUtil.a((QQAppInterface)paramBaseQQAppInterface, (ChatMessage)paramMessageRecord);
  }
  
  public FileManagerEntity queryEntityForDbByFileId(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerProxy().a(paramString);
  }
  
  public FileManagerEntity queryFileEntityByUniseq(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, String paramString, int paramInt)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerDataCenter().a(paramLong, paramString, paramInt);
  }
  
  public FileManagerEntity queryFileManagerEntityByFileUuidForMemory(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    return ((QQAppInterface)paramBaseQQAppInterface).getFileManagerProxy().e(paramString);
  }
  
  public void saveItemLargeThrumbPath(BaseQQAppInterface paramBaseQQAppInterface, MessageForTroopFile paramMessageForTroopFile, String paramString)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a((QQAppInterface)paramBaseQQAppInterface, Long.parseLong(paramMessageForTroopFile.frienduin));
    paramBaseQQAppInterface = getTroopFileTransferManagerItem(paramBaseQQAppInterface, paramMessageForTroopFile.frienduin, paramMessageForTroopFile);
    if (paramBaseQQAppInterface != null)
    {
      paramBaseQQAppInterface.largeThumbnailFile = paramString;
      paramBaseQQAppInterface.HasThumbnailFile_Large = true;
      localTroopFileTransferManager.b(paramBaseQQAppInterface);
    }
  }
  
  public void saveItemRawPath(BaseQQAppInterface paramBaseQQAppInterface, MessageForTroopFile paramMessageForTroopFile, String paramString)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a((QQAppInterface)paramBaseQQAppInterface, Long.parseLong(paramMessageForTroopFile.frienduin));
    paramBaseQQAppInterface = getTroopFileTransferManagerItem(paramBaseQQAppInterface, paramMessageForTroopFile.frienduin, paramMessageForTroopFile);
    if (paramBaseQQAppInterface != null)
    {
      paramBaseQQAppInterface.LocalFile = paramString;
      paramBaseQQAppInterface.Status = 11;
      localTroopFileTransferManager.b(paramBaseQQAppInterface);
    }
  }
  
  public void saveTroopFileInfo(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, MessageForTroopFile paramMessageForTroopFile, String paramString1, String paramString2)
  {
    paramMessageForTroopFile = getTroopFileInfo(paramBaseQQAppInterface, paramLong, paramMessageForTroopFile);
    if (paramMessageForTroopFile != null)
    {
      if (FileUtils.fileExistsAndNotEmpty(paramString1))
      {
        paramMessageForTroopFile.i = paramString1;
        paramMessageForTroopFile.e = 11;
      }
      if (FileUtils.fileExistsAndNotEmpty(paramString2)) {
        paramMessageForTroopFile.k = paramString2;
      }
      TroopFileTransferManager.a((QQAppInterface)paramBaseQQAppInterface, paramLong).a(paramMessageForTroopFile);
    }
  }
  
  public MessageRecord transToMessageRecord(BaseQQAppInterface paramBaseQQAppInterface, byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public void updateFileEntity(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    ((QQAppInterface)paramBaseQQAppInterface).getFileManagerProxy().a(paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.tempapi.impl.MsgBackupTempApiImpl
 * JD-Core Version:    0.7.0.1
 */