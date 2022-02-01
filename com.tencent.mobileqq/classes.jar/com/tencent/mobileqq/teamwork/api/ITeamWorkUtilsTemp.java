package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import java.util.List;
import mqq.os.MqqHandler;

@QAPI(process={"all"})
public abstract interface ITeamWorkUtilsTemp
  extends QRouteApi
{
  public abstract void addTeamWorkGrayTips(AppInterface paramAppInterface, String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2, String paramString3);
  
  public abstract void configHistoryTabEmptyTips(TextView paramTextView, View.OnClickListener paramOnClickListener);
  
  public abstract List<ChatMessage> createChatMsgListFromTencentDocs(List<TencentDocData> paramList, String paramString1, String paramString2);
  
  public abstract void forwardTencentDoc(Activity paramActivity, FileManagerEntity paramFileManagerEntity);
  
  public abstract String getTeamWorkHandlerName();
  
  public abstract String getTroopFormGrayParameter(AppInterface paramAppInterface, String paramString, int paramInt);
  
  public abstract void insertTroopFormGrayTips(AppInterface paramAppInterface, MessageMicro paramMessageMicro);
  
  public abstract void insertTroopFormGrayTips(AppInterface paramAppInterface, MessageMicro paramMessageMicro, String paramString);
  
  public abstract boolean isPreloadToolProcess(AppInterface paramAppInterface);
  
  public abstract boolean isTeamWorkStructMsg(MessageRecord paramMessageRecord);
  
  public abstract boolean isTencentDocsAssistantEnable(AppInterface paramAppInterface);
  
  public abstract void onGetGroupAuthDocsGrayTipsInfo(AppInterface paramAppInterface, Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean, Object[] paramArrayOfObject);
  
  public abstract void onGetUserAuthDocsGrayTipsInfo(AppInterface paramAppInterface, Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean, Object[] paramArrayOfObject);
  
  public abstract void onSetGroupAuthDocsGrayTipsInfo(AppInterface paramAppInterface, Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean, Object[] paramArrayOfObject);
  
  public abstract void onSetUserAuthDocsGrayTipsInfo(AppInterface paramAppInterface, Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean, Object[] paramArrayOfObject);
  
  public abstract void openTroopTemplatePreviewUrlWithCheck(AppInterface paramAppInterface, Activity paramActivity, int paramInt, String paramString, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void processTDDocFileUrl(String paramString);
  
  public abstract void processTDDocFileUrl(String paramString, ChatMessage paramChatMessage);
  
  public abstract void scheduleAddTDFileMessageRecord(AppInterface paramAppInterface);
  
  public abstract void sendDocCooperationShare(AppInterface paramAppInterface, Activity paramActivity, TencentDocData paramTencentDocData, TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract void sendTDoc2Chat(AppInterface paramAppInterface, FileManagerEntity paramFileManagerEntity, String paramString, int paramInt);
  
  public abstract void setPreloadToolProcess(AppInterface paramAppInterface, boolean paramBoolean);
  
  public abstract void setTencentDocsAssitantEnable(AppInterface paramAppInterface, boolean paramBoolean);
  
  public abstract void tryAddTDFileMessageRecord(AppInterface paramAppInterface, MessageRecord paramMessageRecord);
  
  public abstract void tryProcessTDDocMessageRecord(MessageRecord paramMessageRecord, AppInterface paramAppInterface);
  
  public abstract void tryProcessTDDocMessageRecordAsync(MessageRecord paramMessageRecord, AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp
 * JD-Core Version:    0.7.0.1
 */