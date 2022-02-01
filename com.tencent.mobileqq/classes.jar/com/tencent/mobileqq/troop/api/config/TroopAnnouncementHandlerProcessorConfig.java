package com.tencent.mobileqq.troop.api.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi.FeedItem;
import com.tencent.mobileqq.troop.api.config.extension.BizTroopCustomizedProcessorRegister;
import com.tencent.qphone.base.util.QLog;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class TroopAnnouncementHandlerProcessorConfig
{
  private static ArrayList<AbsTroopAnnouncementProcessor> a = new ArrayList();
  private static TroopAnnouncementHandlerProcessorConfig b;
  
  private TroopAnnouncementHandlerProcessorConfig()
  {
    b();
  }
  
  public static TroopAnnouncementHandlerProcessorConfig a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new TroopAnnouncementHandlerProcessorConfig();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void a(AppInterface paramAppInterface, long paramLong1, long paramLong2, int paramInt, ITroopAnnouncementHelperApi.FeedItem paramFeedItem, String paramString)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopAnnouncementProcessor)localIterator.next()).a(paramAppInterface, paramLong1, paramLong2, paramInt, paramFeedItem, paramString);
    }
  }
  
  public void a(AppInterface paramAppInterface, long paramLong1, long paramLong2, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, DataInputStream paramDataInputStream)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopAnnouncementProcessor)localIterator.next()).a(paramAppInterface, paramLong1, paramLong2, paramInt1, paramString, paramInt2, paramBoolean, paramDataInputStream);
    }
  }
  
  void b()
  {
    if (BizTroopCustomizedProcessorRegister.e != null)
    {
      Iterator localIterator = BizTroopCustomizedProcessorRegister.e.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsTroopAnnouncementProcessor)((Class)localObject).newInstance();
          a.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("TroopAnnouncementHandlerProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopAnnouncementHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */