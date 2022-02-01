package com.tencent.mobileqq.troop.filemanager.upload;

import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileGetOneFileInfoObserver;
import com.tencent.biz.troop.file.protocol.TroopFileReqFeedsObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class TroopFileUploadFeedsSender
{
  protected long b;
  protected TroopFileTransferManager.Item c;
  protected String d;
  TroopFileReqFeedsObserver e = new TroopFileUploadFeedsSender.1(this);
  TroopFileGetOneFileInfoObserver f = new TroopFileUploadFeedsSender.2(this);
  
  protected TroopFileUploadFeedsSender(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.b = paramLong;
    this.c = paramItem;
    if (this.c.Id != null) {
      paramItem = this.c.Id.toString();
    } else {
      paramItem = "";
    }
    this.d = paramItem;
  }
  
  public static TroopFileUploadFeedsSender b(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.b, "getSender. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.b, "getSender. item=null");
      return null;
    }
    if (paramItem.Id == null) {
      TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.b, "getSender. item.id=null");
    }
    return new TroopFileUploadFeedsSender(paramLong, paramItem);
  }
  
  public UUID b()
  {
    return this.c.Id;
  }
  
  public void c()
  {
    Object localObject = TroopFileTransferUtil.a();
    if (localObject == null)
    {
      i = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("] reqFeedMsgV2 app=null");
      TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", i, ((StringBuilder)localObject).toString());
      return;
    }
    int i = TroopFileTransferUtil.Log.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("] reqFeedMsgV2");
    TroopFileTransferUtil.Log.c("TroopFileUploadFeedsSender", i, localStringBuilder.toString());
    TroopFileProtocol.a((QQAppInterface)localObject, this.b, this.c, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender
 * JD-Core Version:    0.7.0.1
 */