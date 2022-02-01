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
import java.util.UUID;

public class TroopFileFromTroopForwarder
{
  protected long a;
  protected TroopFileTransferManager.Item b;
  protected String c;
  protected int d;
  TroopFileReqCopyToObserver e = new TroopFileFromTroopForwarder.1(this);
  
  protected TroopFileFromTroopForwarder(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    this.a = paramLong;
    this.b = paramItem;
    if (this.b.Id != null) {
      paramItem = this.b.Id.toString();
    } else {
      paramItem = "";
    }
    this.c = paramItem;
    this.d = paramInt;
  }
  
  public static TroopFileFromTroopForwarder a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.b, "getTroop2WeiyunForwarder. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.b, "getTroop2WeiyunForwarder. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.b, "getTroop2WeiyunForwarder. item.id=null");
      return null;
    }
    if (paramItem.ForwardTroopuin == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.b, "getTroop2WeiyunForwarder. ForwardTroopuin=0");
      return null;
    }
    if (paramItem.BusId != 25)
    {
      int i = TroopFileTransferUtil.Log.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroop2WeiyunForwarder. BusId err:");
      localStringBuilder.append(paramItem.BusId);
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", i, localStringBuilder.toString());
      return null;
    }
    if (TextUtils.isEmpty(paramItem.ForwardPath))
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.b, "get2WeiyunForwarder. ForwardPath=null");
      return null;
    }
    return new TroopFileFromTroopForwarder(paramLong, paramItem, 1);
  }
  
  private final void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if (!paramBoolean)
    {
      ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(-1);
      paramInt1 = TroopFileTransferUtil.Log.b;
      paramString1 = new StringBuilder();
      paramString1.append("[");
      paramString1.append(this.c);
      paramString1.append("] onTroop2weiyunResult isSuccess:false ");
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", paramInt1, paramString1.toString());
      paramString1 = new TroopFileError.SimpleErrorInfo(this.b.FileName, this.a, 5, 601);
      TroopFileDataCenter.a(this.a, this.b, 5, paramString1);
      return;
    }
    paramInt2 = TroopFileTransferUtil.Log.b;
    paramString1 = new StringBuilder();
    paramString1.append("[");
    paramString1.append(this.c);
    paramString1.append("] onTroop2weiyunResult retCode:");
    paramString1.append(paramInt1);
    paramString1.append(" sClientWording:");
    paramString1.append(paramString3);
    TroopFileTransferUtil.Log.c("TroopFileFromTroopForwarder", paramInt2, paramString1.toString());
    ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(paramInt1);
    if (paramInt1 != 0)
    {
      if ((paramInt1 != -20001) && (paramInt1 != -20000)) {
        if (paramInt1 != -6101)
        {
          if (paramInt1 != -403) {
            if (paramInt1 != -30)
            {
              if ((paramInt1 != -25) && (paramInt1 != -22))
              {
                if (paramInt1 != -3)
                {
                  if (paramInt1 != 1053)
                  {
                    if ((paramInt1 == 1054) && (!TextUtils.isEmpty(paramString3)))
                    {
                      paramInt1 = 704;
                      break label323;
                    }
                    paramInt1 = 601;
                    break label323;
                  }
                }
                else
                {
                  paramInt1 = 202;
                  break label323;
                }
              }
              else
              {
                paramInt1 = 701;
                break label323;
              }
            }
            else
            {
              paramInt1 = 705;
              break label323;
            }
          }
        }
        else
        {
          paramInt1 = 703;
          break label323;
        }
      }
      paramInt1 = 702;
      label323:
      paramString1 = new TroopFileError.SimpleErrorInfo(this.b.FileName, this.a, 5, paramInt1, paramString3);
      TroopFileDataCenter.a(this.a, this.b, 5, paramString1);
      return;
    }
    paramString1 = new TroopFileError.SimpleErrorInfo(this.b.FileName, this.a, 5, 602);
    TroopFileDataCenter.a(this.a, this.b, 5, paramString1);
  }
  
  private int c()
  {
    Object localObject = TroopFileTransferUtil.a();
    if (localObject == null)
    {
      i = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] troop2weiyun app=null");
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", i, ((StringBuilder)localObject).toString());
      return -1;
    }
    int i = TroopFileTransferUtil.Log.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] troop2weiyun. BusId:");
    localStringBuilder.append(this.b.BusId);
    localStringBuilder.append(" ForwardBusId:");
    localStringBuilder.append(this.b.ForwardBusId);
    localStringBuilder.append(" ForwardPath:");
    localStringBuilder.append(this.b.ForwardPath);
    TroopFileTransferUtil.Log.c("TroopFileFromTroopForwarder", i, localStringBuilder.toString());
    TroopFileProtocol.a((QQAppInterface)localObject, true, this.a, this.b, ((QQAppInterface)localObject).getLongAccountUin(), 0L, this.e);
    return 0;
  }
  
  public UUID a()
  {
    return this.b.Id;
  }
  
  public int b()
  {
    if (1 == this.d) {
      return c();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.forward.TroopFileFromTroopForwarder
 * JD-Core Version:    0.7.0.1
 */