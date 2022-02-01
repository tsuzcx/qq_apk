package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import android.text.TextUtils;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.IFileHttpBase;
import com.tencent.mobileqq.filemanager.fileassistant.data.FileAssistantResultCallbak;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class FileAssistantRecver$2
  extends DataLineObserver
{
  FileAssistantRecver$2(FileAssistantRecver paramFileAssistantRecver) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (FileAssistantRecver.a(this.a).nSessionId != paramLong) {}
    do
    {
      return;
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "onWlanConnect:" + paramLong + ", try cancel offline download!");
      if (this.a.a != null) {
        this.a.a.d();
      }
      FileAssistantRecver.a(this.a).status = 2;
      FileAssistantRecver.a(this.a).isStartWlan = true;
    } while (FileAssistantRecver.a(this.a).getFileManagerDataCenter().b(FileAssistantRecver.a(this.a).nSessionId));
    FileAssistantRecver.a(this.a).getFileManagerDataCenter().b(FileAssistantRecver.a(this.a).nSessionId);
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "MsgRecord is not exsited, addAIOMsg");
    String str = ((IQFileConfigManager)FileAssistantRecver.a(this.a).getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin();
    paramInt1 = ((Integer)FileAssistantRecver.a(this.a).mContext).intValue();
    FileAssistantRecver.a(this.a).mContext = null;
    FileAssistantRecver.a(this.a).getFileManagerDataCenter().a(str, str, false, paramInt1, FileAssistantRecver.a(this.a));
  }
  
  public void a(Session paramSession, float paramFloat)
  {
    if (FileAssistantRecver.a(this.a).nSessionId != paramSession.uSessionID) {
      return;
    }
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "onServiceSessionProgress:" + FileAssistantRecver.a(this.a).nSessionId + ", fProgress:" + paramFloat);
    FileAssistantRecver.a(this.a).fProgress = paramFloat;
    FileAssistantRecver.a(this.a).getFileManagerNotifyCenter().a(FileAssistantRecver.a(this.a).uniseq, FileAssistantRecver.a(this.a).nSessionId, FileAssistantRecver.a(this.a).peerUin, FileAssistantRecver.a(this.a).peerType, 16, null, 0, null);
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    if (!paramSession.isFileAssist) {
      break label7;
    }
    label7:
    while (paramSession.uSessionID != FileAssistantRecver.a(this.a).nSessionId) {
      return;
    }
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "onServiceSessionComplete:" + FileAssistantRecver.a(this.a).nSessionId + ", isSucc:" + paramBoolean);
    if (this.a.a != null) {
      this.a.a.d();
    }
    if (paramBoolean)
    {
      FileAssistantRecver.a(this.a).status = 1;
      FileAssistantRecver.a(this.a).cloudType = 3;
      if (!FileAssistantRecver.a(this.a).getFileManagerDataCenter().b(FileAssistantRecver.a(this.a).nSessionId))
      {
        FileAssistantRecver.a(this.a).getFileManagerDataCenter().b(FileAssistantRecver.a(this.a).nSessionId);
        paramSession = ((IQFileConfigManager)FileAssistantRecver.a(this.a).getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin();
        int i = ((Integer)FileAssistantRecver.a(this.a).mContext).intValue();
        FileAssistantRecver.a(this.a).mContext = null;
        FileAssistantRecver.a(this.a).getFileManagerDataCenter().a(paramSession, paramSession, false, i, FileAssistantRecver.a(this.a));
      }
    }
    for (;;)
    {
      ((DataLineHandler)FileAssistantRecver.a(this.a).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(3, paramBoolean, new Object[] { Long.valueOf(0L), Long.valueOf(FileAssistantRecver.a(this.a).nSessionId), FileAssistantRecver.a(this.a).getFilePath() });
      FileAssistantRecver.a(this.a).getFileManagerDataCenter().c(FileAssistantRecver.a(this.a));
      FileAssistantRecver.a(this.a).getFileManagerNotifyCenter().a(FileAssistantRecver.a(this.a).uniseq, FileAssistantRecver.a(this.a).nSessionId, FileAssistantRecver.a(this.a).peerUin, FileAssistantRecver.a(this.a).peerType, 14, new Object[] { FileAssistantRecver.a(this.a).strFilePath, Long.valueOf(FileAssistantRecver.a(this.a).fileSize), Boolean.valueOf(true), "" }, 0, null);
      paramSession = (FileAssistantResultCallbak)FileAssistantRecver.a(this.a).get();
      if (paramSession == null) {
        break;
      }
      paramSession.a(this.a);
      return;
      FileAssistantRecver.a(this.a).status = 0;
    }
  }
  
  public void b(Session paramSession)
  {
    if (FileAssistantRecver.a(this.a).nSessionId != paramSession.uSessionID) {
      return;
    }
    if (this.a.a != null)
    {
      this.a.a.d();
      FileAssistantRecver.a(this.a, false);
    }
    FileAssistantRecver.a(this.a).status = 2;
    FileAssistantRecver.b(this.a, true);
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "onServiceSessionStart:" + paramSession.uSessionID);
    FileAssistantRecver.a(this.a).strFilePath = paramSession.strFilePathSrc;
    FileAssistantRecver.a(this.a).strMiddleThumPath = paramSession.strFilePathThumb;
    FileAssistantRecver.a(this.a).fileName = paramSession.strFileNameSrc;
    if (TextUtils.isEmpty(FileAssistantRecver.a(this.a).strFileMd5)) {
      FileAssistantRecver.a(this.a).strFileMd5 = HexUtil.bytes2HexStr(paramSession.vFileMD5Src);
    }
    FileAssistantRecver.a(this.a).fileSize = paramSession.uFileSizeSrc;
    FileAssistantRecver.a(this.a).getFileManagerDataCenter().c(FileAssistantRecver.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantRecver.2
 * JD-Core Version:    0.7.0.1
 */