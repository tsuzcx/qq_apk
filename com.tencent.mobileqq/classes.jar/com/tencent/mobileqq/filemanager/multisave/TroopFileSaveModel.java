package com.tencent.mobileqq.filemanager.multisave;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;

public class TroopFileSaveModel
  extends QFileSaveModel
{
  private MessageForTroopFile d = (MessageForTroopFile)this.b;
  
  public TroopFileSaveModel(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    super(paramQQAppInterface, paramChatMessage);
  }
  
  public boolean a()
  {
    Object localObject1 = TroopFileUtils.a(this.a, this.d);
    long l = Long.parseLong(this.d.frienduin);
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doDownload : file info is null. uniseq[");
      ((StringBuilder)localObject1).append(this.d.uniseq);
      ((StringBuilder)localObject1).append("]");
      QLog.i("TroopFileSaveModel<QFile>", 1, ((StringBuilder)localObject1).toString());
      return false;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("doDownload: uniseq[");
    ((StringBuilder)localObject2).append(this.d.uniseq);
    ((StringBuilder)localObject2).append("] fileId[");
    ((StringBuilder)localObject2).append(((TroopFileStatusInfo)localObject1).r);
    ((StringBuilder)localObject2).append("]");
    QLog.i("TroopFileSaveModel<QFile>", 1, ((StringBuilder)localObject2).toString());
    localObject2 = TroopFileTransferManager.a(this.a, l);
    ((TroopFileTransferManager)localObject2).a(((TroopFileStatusInfo)localObject1).r, ((TroopFileStatusInfo)localObject1).t, ((TroopFileStatusInfo)localObject1).i, ((TroopFileStatusInfo)localObject1).u);
    if ((((TroopFileStatusInfo)localObject1).e != 10) && (((TroopFileStatusInfo)localObject1).e != 9))
    {
      if (((TroopFileStatusInfo)localObject1).e == 7)
      {
        ((TroopFileTransferManager)localObject2).a(((TroopFileStatusInfo)localObject1).r, ((TroopFileStatusInfo)localObject1).t, ((TroopFileStatusInfo)localObject1).i, ((TroopFileStatusInfo)localObject1).u);
        return true;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doDownload : can not handle file info status[");
      ((StringBuilder)localObject2).append(((TroopFileStatusInfo)localObject1).e);
      ((StringBuilder)localObject2).append(",download error");
      QLog.i("TroopFileSaveModel<QFile>", 1, ((StringBuilder)localObject2).toString());
      return false;
    }
    if (((TroopFileStatusInfo)localObject1).a != null)
    {
      ((TroopFileTransferManager)localObject2).d(((TroopFileStatusInfo)localObject1).a);
      return true;
    }
    QLog.i("TroopFileSaveModel<QFile>", 1, "doDownload : resumeDownload error, infoId is null");
    return false;
  }
  
  public boolean b()
  {
    Object localObject = TroopFileUtils.a(this.a, this.d);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopDownload : file info is null. uniseq[");
      ((StringBuilder)localObject).append(this.d.uniseq);
      ((StringBuilder)localObject).append("]");
      QLog.i("TroopFileSaveModel<QFile>", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    if ((((TroopFileStatusInfo)localObject).e != 8) && (((TroopFileStatusInfo)localObject).e != 9) && (((TroopFileStatusInfo)localObject).e != 10)) {
      return false;
    }
    long l = Long.parseLong(this.d.frienduin);
    TroopFileTransferManager.a(this.a, l).e(((TroopFileStatusInfo)localObject).a);
    return true;
  }
  
  public String c()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.a, this.d);
    if (localTroopFileStatusInfo != null) {
      return localTroopFileStatusInfo.k;
    }
    return "";
  }
  
  public boolean d()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.a, this.d);
    return (localTroopFileStatusInfo != null) && (localTroopFileStatusInfo.e == 8);
  }
  
  public QFileControlReq e()
  {
    TroopFileControlReq localTroopFileControlReq = new TroopFileControlReq(TroopFileUtils.a(this.a, this.d));
    localTroopFileControlReq.a(new TroopFileSaveModel.1(this));
    return localTroopFileControlReq;
  }
  
  public String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d.frienduin);
    localStringBuilder.append(this.d.uniseq);
    return localStringBuilder.toString();
  }
  
  public long g()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.a, this.d);
    if (localTroopFileStatusInfo == null) {
      return 0L;
    }
    return localTroopFileStatusInfo.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.TroopFileSaveModel
 * JD-Core Version:    0.7.0.1
 */