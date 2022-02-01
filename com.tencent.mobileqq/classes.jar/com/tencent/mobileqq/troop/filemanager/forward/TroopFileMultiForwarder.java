package com.tencent.mobileqq.troop.filemanager.forward;

import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqCopyToObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class TroopFileMultiForwarder
{
  protected long a;
  protected Map<UUID, TroopFileTransferManager.Item> b = new HashMap();
  protected Map<UUID, Integer> c = new HashMap();
  protected int d;
  TroopFileReqCopyToObserver e = new TroopFileMultiForwarder.1(this);
  
  protected TroopFileMultiForwarder(long paramLong, List<TroopFileTransferManager.Item> paramList, int paramInt)
  {
    this.a = paramLong;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)paramList.next();
      this.b.put(localItem.Id, localItem);
    }
    this.d = paramInt;
  }
  
  public static TroopFileMultiForwarder a(long paramLong, List<TroopFileTransferManager.Item> paramList)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.b, "getTroop2WeiyunForwarder. troopuin=0");
      return null;
    }
    if (paramList == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.b, "getTroop2WeiyunForwarder. item=null");
      return null;
    }
    return new TroopFileMultiForwarder(paramLong, paramList, 1);
  }
  
  private final void a(TroopFileTransferManager.Item paramItem, boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if (!paramBoolean) {}
    try
    {
      ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(-1);
      this.c.put(paramItem.Id, Integer.valueOf(-1));
      paramInt1 = TroopFileTransferUtil.Log.b;
      paramString1 = new StringBuilder();
      paramString1.append("[");
      paramString1.append(paramItem.Id.toString());
      paramString1.append("] onRspMultiCopyToWeiyun fail. isSuc:");
      paramString1.append(paramBoolean);
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", paramInt1, paramString1.toString());
      return;
    }
    finally
    {
      break label384;
    }
    paramInt2 = TroopFileTransferUtil.Log.b;
    paramString1 = new StringBuilder();
    paramString1.append("[");
    paramString1.append(paramItem.Id.toString());
    paramString1.append("] onRspMultiCopyToWeiyun retCode:");
    paramString1.append(paramInt1);
    TroopFileTransferUtil.Log.c("TroopFileFromTroopForwarder", paramInt2, paramString1.toString());
    ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(paramInt1);
    if (paramInt1 == 0) {
      this.c.remove(paramItem.Id);
    } else {
      this.c.put(paramItem.Id, Integer.valueOf(paramInt1));
    }
    if (this.c.size() == 0)
    {
      paramString1 = new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.a, 5, 604);
      TroopFileDataCenter.a(this.a, paramItem, 5, paramString1);
    }
    else
    {
      paramString1 = this.c.keySet();
      paramInt2 = 1;
      paramString1 = paramString1.iterator();
      do
      {
        paramInt1 = paramInt2;
        if (!paramString1.hasNext()) {
          break;
        }
        paramString2 = (UUID)paramString1.next();
      } while (((Integer)this.c.get(paramString2)).intValue() != 2147483647);
      paramInt1 = 0;
      if (paramInt1 != 0)
      {
        paramString1 = new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.a, 5, 605);
        TroopFileDataCenter.a(this.a, paramItem, 5, paramString1);
      }
    }
    return;
    label384:
    for (;;)
    {
      throw paramItem;
    }
  }
  
  private int b()
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.b, "multiTroop2weiyun app=null");
      return -1;
    }
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
      if (localItem.Id == null)
      {
        TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.b, "multiTroop2weiyun. item.id=null");
      }
      else if (localItem.ForwardTroopuin == 0L)
      {
        TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.b, "multiTroop2weiyun. ForwardTroopuin=0");
      }
      else
      {
        int i;
        StringBuilder localStringBuilder;
        if (localItem.BusId != 25)
        {
          i = TroopFileTransferUtil.Log.b;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("multiTroop2weiyun. BusId err:");
          localStringBuilder.append(localItem.BusId);
          TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", i, localStringBuilder.toString());
        }
        else if (TextUtils.isEmpty(localItem.ForwardPath))
        {
          TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.b, "multiTroop2weiyun. ForwardPath=null");
        }
        else
        {
          i = TroopFileTransferUtil.Log.b;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[");
          localStringBuilder.append(localItem.Id.toString());
          localStringBuilder.append("] multiTroop2weiyun. BusId:");
          localStringBuilder.append(localItem.BusId);
          localStringBuilder.append(" ForwardBusId:");
          localStringBuilder.append(localItem.ForwardBusId);
          localStringBuilder.append(" ForwardPath:");
          localStringBuilder.append(localItem.ForwardPath);
          TroopFileTransferUtil.Log.c("TroopFileFromTroopForwarder", i, localStringBuilder.toString());
          try
          {
            this.c.put(localItem.Id, Integer.valueOf(2147483647));
            TroopFileProtocol.a(localQQAppInterface, true, this.a, localItem, localQQAppInterface.getLongAccountUin(), 0L, this.e);
          }
          finally {}
        }
      }
    }
    return 0;
  }
  
  public int a()
  {
    if (1 == this.d) {
      return b();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.forward.TroopFileMultiForwarder
 * JD-Core Version:    0.7.0.1
 */