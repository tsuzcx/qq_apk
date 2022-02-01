package cooperation.qqfav.forward;

import android.content.Context;
import android.os.Looper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import java.util.UUID;
import mqq.manager.Manager;

public class QfavFileForwardManager
  implements Manager
{
  public Context a;
  public String b;
  private QQAppInterface c;
  private QfavFileForwardHandler d;
  private QfavOnlineFileForwardObserver e = new QfavOnlineFileForwardObserver(new QfavFileForwardManager.1(this, Looper.getMainLooper()));
  
  public QfavFileForwardManager(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
    this.a = this.c.getApplication();
    this.b = this.c.getCurrentAccountUin();
    this.c.addObserver(this.e);
    this.d = ((QfavFileForwardHandler)this.c.getBusinessHandler(BusinessHandlerFactory.FAV_ONLINE_FILE_FORWARD_HANDLER));
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel())
      {
        paramFileManagerEntity = new StringBuilder();
        paramFileManagerEntity.append("insertWeiYun2OfflineEntity : entity is null, peerUin[");
        paramFileManagerEntity.append(FileManagerUtil.k(paramString2));
        paramFileManagerEntity.append("], peerType[");
        paramFileManagerEntity.append(paramInt1);
        paramFileManagerEntity.append("]");
        QLog.e("QfavFileForwardManager", 2, paramFileManagerEntity.toString());
      }
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    String str2 = TransfileUtile.makeTransFileProtocolData(localFileManagerEntity.getFilePath(), localFileManagerEntity.fileSize, 0, true);
    long l = MessageRecordFactory.a(-1000).uniseq;
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.setCloudType(10);
    localFileManagerEntity.nOpType = 37;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.c, paramString2, null, paramInt1);
    localFileManagerEntity.peerType = paramInt1;
    localFileManagerEntity.selfUin = this.c.getAccount();
    localFileManagerEntity.srvTime = (MessageCache.c() * 1000L);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.msgSeq = FileManagerUtil.f();
    localFileManagerEntity.msgUid = FileManagerUtil.g();
    if (paramInt2 != 0) {
      ForwardOrderManager.a().a(l, 0L, paramInt2);
    }
    this.c.getFileManagerDataCenter().a(localFileManagerEntity);
    String str1 = this.c.getAccount();
    if ((paramInt1 != 1004) && (paramInt1 != 1000))
    {
      if (paramInt1 != 1006) {
        break label299;
      }
      localFileManagerEntity.tmpSessionFromPhone = paramString1;
      localFileManagerEntity.tmpSessionToPhone = paramString2;
    }
    str1 = paramString1;
    label299:
    localFileManagerEntity.strThumbPath = paramFileManagerEntity.strThumbPath;
    localFileManagerEntity.strMiddleThumPath = paramFileManagerEntity.strMiddleThumPath;
    this.c.getFileManagerDataCenter().a(paramString2, str1, true, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, true, paramInt1, str2, localFileManagerEntity.msgSeq, l, localFileManagerEntity.msgUid, -1L, MessageCache.c());
    if (QLog.isColorLevel())
    {
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append("insertWeiYun2OfflineEntity peerType[");
      paramFileManagerEntity.append(paramInt1);
      paramFileManagerEntity.append("],FileManagerEntity:");
      paramFileManagerEntity.append(FileManagerUtil.c(localFileManagerEntity));
      QLog.d("QfavFileForwardManager", 2, paramFileManagerEntity.toString());
    }
    return localFileManagerEntity;
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, long paramLong1, long paramLong2, int paramInt)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.c, Long.valueOf(paramLong1).longValue());
    if (localTroopFileTransferManager == null) {
      return;
    }
    int i = Math.abs(new Random().nextInt());
    TroopFileStatusInfo localTroopFileStatusInfo = localTroopFileTransferManager.a(paramFileManagerEntity, 102, i, Long.parseLong(this.c.getCurrentUin()));
    if (localTroopFileStatusInfo == null) {
      return;
    }
    QQAppInterface localQQAppInterface = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong1);
    TroopFileUtils.a(localQQAppInterface, localStringBuilder.toString(), paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, localTroopFileStatusInfo.a.toString(), i, null, paramFileManagerEntity.nSessionId, paramLong2, paramInt);
    paramFileManagerEntity.strTroopFileUuid = localTroopFileStatusInfo.a.toString();
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      paramFileManagerEntity.isReaded = false;
      localTroopFileTransferManager.a(localTroopFileStatusInfo.a, -1, null, HardCodeUtil.a(2131913839));
      if (QLog.isColorLevel()) {
        QLog.i("QfavFileForwardManager", 2, "forwardToTroop : network error");
      }
      return;
    }
    this.d.a(1, paramFileManagerEntity, paramLong1);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject1 = this.c.getCurrentAccountUin();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramLong1);
    ((StringBuilder)localObject2).append("");
    paramFileManagerEntity = a(paramFileManagerEntity, (String)localObject1, ((StringBuilder)localObject2).toString(), paramFileManagerEntity.peerType, paramInt);
    FileManagerUtil.b(paramFileManagerEntity.nSessionId);
    localObject1 = this.c;
    localObject2 = ((QQAppInterface)localObject1).getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("");
    FileManagerUtil.a((QQAppInterface)localObject1, (String)localObject2, localStringBuilder.toString(), paramFileManagerEntity);
    paramFileManagerEntity.status = 2;
    paramFileManagerEntity.fProgress = 0.0F;
    this.d.a(2, paramFileManagerEntity, paramLong1);
  }
  
  public void c(FileManagerEntity paramFileManagerEntity, long paramLong1, long paramLong2, int paramInt)
  {
    if (this.c == null)
    {
      QLog.e("QfavFileForwardManager", 1, "insertFav2OfflineEntity mApp=null");
      return;
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.selfuin = this.c.getCurrentUin();
    localDataLineMsgRecord.filename = paramFileManagerEntity.fileName;
    localDataLineMsgRecord.filesize = paramFileManagerEntity.fileSize;
    localDataLineMsgRecord.busId = 236;
    localDataLineMsgRecord.fileFrom = 6;
    localDataLineMsgRecord.nOpType = 38;
    localDataLineMsgRecord.istroop = 0;
    DataLineHandler localDataLineHandler = (DataLineHandler)this.c.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    localDataLineMsgRecord.sessionid = localDataLineHandler.a(0, 0).longValue();
    localDataLineMsgRecord.msg = "";
    localDataLineMsgRecord.issend = 1;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    ((ISVIPHandler)this.c.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localDataLineMsgRecord);
    localDataLineMsgRecord.time = MessageCache.c();
    localDataLineMsgRecord.progress = 0.2F;
    localDataLineMsgRecord.fileMsgStatus = 0L;
    localDataLineMsgRecord.msgtype = DataLineHandler.b(0);
    localDataLineMsgRecord.bIsTransfering = true;
    localDataLineMsgRecord.bNoInsertFm = true;
    localDataLineMsgRecord.entityID = paramFileManagerEntity.nSessionId;
    localDataLineMsgRecord.thumbPath = paramFileManagerEntity.strThumbPath;
    this.c.getMessageFacade().d(DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid)).a(localDataLineMsgRecord, true);
    localDataLineHandler.a(7, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf((byte)DataLineHandler.c(localDataLineMsgRecord.msgtype)), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(localDataLineMsgRecord.filesize) });
    this.d.a(3, paramFileManagerEntity, paramLong1, localDataLineMsgRecord.sessionid);
  }
  
  public void onDestroy()
  {
    this.e.a();
    this.c.removeObserver(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.forward.QfavFileForwardManager
 * JD-Core Version:    0.7.0.1
 */