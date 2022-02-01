package com.tencent.mobileqq.troop.filemanager.download;

import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.ITroopFileProtoReq;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class TroopFilePreviewWorker
{
  protected long a;
  protected TroopFileTransferManager.Item b;
  protected String c;
  protected ITroopFileProtoReq d;
  TroopFileReqDownloadFileObserver e = new TroopFilePreviewWorker.1(this);
  
  private TroopFilePreviewWorker(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.a = paramLong;
    this.b = paramItem;
    if (this.b.Id != null) {
      paramItem = this.b.Id.toString();
    } else {
      paramItem = "";
    }
    this.c = paramItem;
  }
  
  public static TroopFilePreviewWorker a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFilePreviewWorker", TroopFileTransferUtil.Log.b, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("TroopFilePreviewWorker", TroopFileTransferUtil.Log.b, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopFilePreviewWorker", TroopFileTransferUtil.Log.b, "getWoker. item.id=null");
      return null;
    }
    return new TroopFilePreviewWorker(paramLong, paramItem);
  }
  
  public UUID a()
  {
    return this.b.Id;
  }
  
  public boolean b()
  {
    Object localObject = TroopFileTransferUtil.a();
    if (localObject == null)
    {
      i = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] getPreviewInfo app=null");
      TroopFileTransferUtil.Log.a("TroopFilePreviewWorker", i, ((StringBuilder)localObject).toString());
      return false;
    }
    int i = TroopFileTransferUtil.Log.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] getPreviewInfo");
    TroopFileTransferUtil.Log.c("TroopFilePreviewWorker", i, localStringBuilder.toString());
    this.d = TroopFileProtocol.a((QQAppInterface)localObject, this.a, this.b, 0, true, false, this.e);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFilePreviewWorker
 * JD-Core Version:    0.7.0.1
 */