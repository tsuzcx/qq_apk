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
  private static TroopAnnouncementHandlerProcessorConfig jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopAnnouncementHandlerProcessorConfig;
  private static ArrayList<AbsTroopAnnouncementProcessor> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private TroopAnnouncementHandlerProcessorConfig()
  {
    a();
  }
  
  public static TroopAnnouncementHandlerProcessorConfig a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopAnnouncementHandlerProcessorConfig == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopAnnouncementHandlerProcessorConfig == null) {
          jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopAnnouncementHandlerProcessorConfig = new TroopAnnouncementHandlerProcessorConfig();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopAnnouncementHandlerProcessorConfig;
  }
  
  void a()
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
          jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("TroopAnnouncementHandlerProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, long paramLong1, long paramLong2, int paramInt, ITroopAnnouncementHelperApi.FeedItem paramFeedItem, String paramString)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopAnnouncementProcessor)localIterator.next()).a(paramAppInterface, paramLong1, paramLong2, paramInt, paramFeedItem, paramString);
    }
  }
  
  public void a(AppInterface paramAppInterface, long paramLong1, long paramLong2, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, DataInputStream paramDataInputStream)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopAnnouncementProcessor)localIterator.next()).a(paramAppInterface, paramLong1, paramLong2, paramInt1, paramString, paramInt2, paramBoolean, paramDataInputStream);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopAnnouncementHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */