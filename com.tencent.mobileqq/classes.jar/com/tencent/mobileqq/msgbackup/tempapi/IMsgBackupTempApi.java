package com.tencent.mobileqq.msgbackup.tempapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.service.message.TransMsgContext;
import java.util.List;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;

@QAPI(process={"all"})
public abstract interface IMsgBackupTempApi
  extends QRouteApi
{
  public abstract ChatMessage changeRealChatMessage(ChatMessage paramChatMessage);
  
  public abstract MessageRecord changeRichTextToTextMsg(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord, String paramString, boolean paramBoolean);
  
  public abstract msg_svc.PbSendMsgReq createPbSendMsgReq(BaseQQAppInterface paramBaseQQAppInterface, int paramInt1, String paramString, TransMsgContext paramTransMsgContext, long paramLong, int paramInt2);
  
  public abstract void destoryFaceDecord();
  
  public abstract void fillMsgHeader(BaseQQAppInterface paramBaseQQAppInterface, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, Long paramLong);
  
  public abstract List getAllMsgTableData(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract MqqHandler getConversationHandler(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract String getCreateFileName(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, MessageForTroopFile paramMessageForTroopFile);
  
  public abstract Drawable getFaceDrawable(BaseQQAppInterface paramBaseQQAppInterface, DecodeTaskCompletionListener paramDecodeTaskCompletionListener, int paramInt, String paramString);
  
  public abstract Drawable getFaceDrawable(BaseQQAppInterface paramBaseQQAppInterface, DecodeTaskCompletionListener paramDecodeTaskCompletionListener, RecentBaseData paramRecentBaseData);
  
  public abstract byte[] getFileIdByte(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, MessageForTroopFile paramMessageForTroopFile);
  
  public abstract int getFileImageHeight(BaseQQAppInterface paramBaseQQAppInterface, MessageForTroopFile paramMessageForTroopFile);
  
  public abstract int getFileImageWidth(BaseQQAppInterface paramBaseQQAppInterface, MessageForTroopFile paramMessageForTroopFile);
  
  public abstract int getFileType(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord);
  
  public abstract Pair<Integer, Integer> getHeadIcon(BaseQQAppInterface paramBaseQQAppInterface, int paramInt, String paramString);
  
  public abstract int getInActionLoginB(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract String getLargeThumbPath(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord);
  
  public abstract String getLargeThumbPath2(BaseQQAppInterface paramBaseQQAppInterface, String paramString, MessageForTroopFile paramMessageForTroopFile);
  
  public abstract String getLocalFilePath(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord);
  
  public abstract String getLocalFilePath2(BaseQQAppInterface paramBaseQQAppInterface, String paramString, MessageForTroopFile paramMessageForTroopFile);
  
  public abstract MessageRecord getMessageRecord(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt1, long paramLong, int paramInt2);
  
  public abstract im_msg_body.MsgBody getMultiMsgBody(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord);
  
  public abstract msg_comm.MsgHead getMultiMsgHead(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord, long paramLong);
  
  public abstract String getTroopFileItemFileName(BaseQQAppInterface paramBaseQQAppInterface, MessageForTroopFile paramMessageForTroopFile);
  
  public abstract String getTroopFileItemId(BaseQQAppInterface paramBaseQQAppInterface, MessageForTroopFile paramMessageForTroopFile);
  
  public abstract String getTroopThumbnailFile(long paramLong, String paramString);
  
  public abstract String getTroopThumbnailFilePath(long paramLong, int paramInt, String paramString);
  
  public abstract String getUnsupportMsgStr(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord);
  
  public abstract boolean getUseNewSettings(AppInterface paramAppInterface);
  
  public abstract void gotoChatHistoryFragment(Context paramContext, Intent paramIntent);
  
  public abstract void gotoConversation(Activity paramActivity);
  
  public abstract void gotoQQSettingMsgClearFragment(Context paramContext, Intent paramIntent);
  
  public abstract void gotoWebViewBrowser(Context paramContext, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Object paramObject, String paramString2);
  
  public abstract String handleMultiMsg(MessageRecord paramMessageRecord);
  
  public abstract void insertToFMList(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity);
  
  public abstract void insertToMemMap(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity);
  
  public abstract boolean isAnonymousMsg(MessageRecord paramMessageRecord);
  
  public abstract boolean isBeancurdMsg(ChatMessage paramChatMessage);
  
  public abstract boolean isMultiMsg(ChatMessage paramChatMessage);
  
  public abstract boolean isNeedHandle(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord);
  
  public abstract boolean isNeedHandleCreateTroopFileInfo(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, MessageForTroopFile paramMessageForTroopFile);
  
  public abstract boolean isNeedHandleTroopFileRecord(BaseQQAppInterface paramBaseQQAppInterface, MessageForTroopFile paramMessageForTroopFile);
  
  public abstract boolean isSupportMsgType(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord);
  
  public abstract FileManagerEntity queryEntityForDbByFileId(BaseQQAppInterface paramBaseQQAppInterface, String paramString);
  
  public abstract FileManagerEntity queryFileEntityByUniseq(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, String paramString, int paramInt);
  
  public abstract FileManagerEntity queryFileManagerEntityByFileUuidForMemory(BaseQQAppInterface paramBaseQQAppInterface, String paramString);
  
  public abstract void saveItemLargeThrumbPath(BaseQQAppInterface paramBaseQQAppInterface, MessageForTroopFile paramMessageForTroopFile, String paramString);
  
  public abstract void saveItemRawPath(BaseQQAppInterface paramBaseQQAppInterface, MessageForTroopFile paramMessageForTroopFile, String paramString);
  
  public abstract void saveTroopFileInfo(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, MessageForTroopFile paramMessageForTroopFile, String paramString1, String paramString2);
  
  public abstract MessageRecord transToMessageRecord(BaseQQAppInterface paramBaseQQAppInterface, byte[] paramArrayOfByte);
  
  public abstract void updateFileEntity(BaseQQAppInterface paramBaseQQAppInterface, FileManagerEntity paramFileManagerEntity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi
 * JD-Core Version:    0.7.0.1
 */