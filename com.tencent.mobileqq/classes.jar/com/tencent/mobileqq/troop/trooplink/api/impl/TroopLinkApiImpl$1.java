package com.tencent.mobileqq.troop.trooplink.api.impl;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

class TroopLinkApiImpl$1
  implements Runnable
{
  TroopLinkApiImpl$1(TroopLinkApiImpl paramTroopLinkApiImpl, String paramString) {}
  
  public void run()
  {
    try
    {
      synchronized (this.this$0.mLock)
      {
        if (this.this$0.isUpdateServer) {
          return;
        }
        ??? = new File(this.a);
        if (((File)???).exists())
        {
          JSONObject localJSONObject = new JSONObject(FileUtils.readFileToString((File)???));
          Iterator localIterator = localJSONObject.keys();
          synchronized (this.this$0.mLock)
          {
            while (localIterator.hasNext())
            {
              String str1 = (String)localIterator.next();
              String str2 = localJSONObject.getString(str1);
              TroopLinkApiImpl.urlMaps.put(str1, str2);
            }
            return;
          }
        }
        QLog.e(".troop.trooplink", 1, "config not find!");
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(".troop.trooplink", 1, "readConfig failed!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.trooplink.api.impl.TroopLinkApiImpl.1
 * JD-Core Version:    0.7.0.1
 */