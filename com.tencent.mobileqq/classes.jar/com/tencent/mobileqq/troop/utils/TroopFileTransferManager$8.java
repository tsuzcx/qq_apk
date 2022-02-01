package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.troop.file.protocol.TroopFileReqCopyToObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

class TroopFileTransferManager$8
  extends TroopFileReqCopyToObserver
{
  TroopFileTransferManager$8(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    long l = paramBundle.getLong("troopUin");
    for (;;)
    {
      try
      {
        paramString1 = (TroopFileTransferManager)TroopFileTransferManager.a().get(Long.valueOf(l));
        if (paramString1 == null)
        {
          if (QLog.isDevelopLevel())
          {
            paramString1 = new StringBuilder();
            paramString1.append("bad troopUin");
            paramString1.append(l);
            QLog.i("TroopFileTransferManager", 4, paramString1.toString());
          }
          return;
        }
        paramString3 = paramBundle.getString("itemKey");
        if (paramString3 == null) {
          return;
        }
        paramBundle = UUID.fromString(paramString3);
      }
      finally
      {
        continue;
        throw paramString1;
        continue;
        paramInt1 = 1;
        continue;
      }
      try
      {
        paramString2 = (TroopFileTransferManager.Item)paramString1.a.get(paramBundle);
        if (paramString2 == null)
        {
          if (QLog.isDevelopLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("bad item key");
            paramString2.append(paramString3);
            QLog.i("TroopFileTransferManager", 4, paramString2.toString());
          }
          return;
        }
        if (!paramBoolean) {
          return;
        }
        paramBoolean = QLog.isDevelopLevel();
        paramInt2 = 0;
        if (paramBoolean) {
          QLog.e("TroopFileTransferManager", 4, String.format("onCopyToResult - retCode: %d", new Object[] { Integer.valueOf(paramInt1) }));
        }
        if (paramString2.BusId == 25) {
          try
          {
            ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(paramInt1);
            if (paramInt1 == 0) {
              this.a.b.remove(paramBundle);
            } else {
              this.a.b.put(paramBundle, Integer.valueOf(paramInt1));
            }
            if (this.a.b.size() == 0)
            {
              paramString3 = new TroopFileError.SimpleErrorInfo(paramString2.FileName, this.a.e, 5, 604);
              this.a.a(paramString2, 5, paramString3);
            }
            else
            {
              paramString3 = this.a.b.keySet().iterator();
              if (!paramString3.hasNext()) {
                continue;
              }
              paramBundle = (UUID)paramString3.next();
              if (((Integer)this.a.b.get(paramBundle)).intValue() != 2147483647) {
                continue;
              }
              paramInt1 = paramInt2;
              if (paramInt1 != 0)
              {
                paramString3 = new TroopFileError.SimpleErrorInfo(paramString2.FileName, this.a.e, 5, 605);
                this.a.a(paramString2, 5, paramString3);
              }
            }
            return;
          }
          finally {}
        } else {
          return;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.8
 * JD-Core Version:    0.7.0.1
 */