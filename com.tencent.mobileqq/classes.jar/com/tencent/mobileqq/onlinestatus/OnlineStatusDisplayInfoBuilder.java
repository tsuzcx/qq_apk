package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.auto.OnlineStatusSmartDisplayInfo;
import com.tencent.mobileqq.onlinestatus.view.OnlineStatusConstellationDisplayInfo;
import com.tencent.mobileqq.onlinestatus.weather.OnlineStatusWeatherDisplayInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class OnlineStatusDisplayInfoBuilder
{
  private BaseOnlineStatusDisplayInfo jdField_a_of_type_ComTencentMobileqqOnlinestatusBaseOnlineStatusDisplayInfo;
  private HashMap<Long, BaseOnlineStatusDisplayInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private BaseOnlineStatusDisplayInfo b(long paramLong, BaseOnlineStatusDisplayInfo.UpdateUIListener paramUpdateUIListener, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    Object localObject = null;
    if (paramLong == 1030L) {
      localObject = new OnlineStatusWeatherDisplayInfo(paramLong, paramUpdateUIListener, paramQQAppInterface, paramBaseActivity);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((BaseOnlineStatusDisplayInfo)localObject).a();
        ((BaseOnlineStatusDisplayInfo)localObject).a(true);
      }
      return localObject;
      if (paramLong == 1040L) {
        localObject = new OnlineStatusConstellationDisplayInfo(paramLong, paramUpdateUIListener, paramQQAppInterface, paramBaseActivity);
      } else if (paramLong > 40000L) {
        localObject = new OnlineStatusSmartDisplayInfo(paramLong, paramUpdateUIListener, paramQQAppInterface, paramBaseActivity);
      }
    }
  }
  
  public BaseOnlineStatusDisplayInfo a(long paramLong, BaseOnlineStatusDisplayInfo.UpdateUIListener paramUpdateUIListener, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBaseOnlineStatusDisplayInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBaseOnlineStatusDisplayInfo.a != paramLong)) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBaseOnlineStatusDisplayInfo.a(false, paramLong);
    }
    BaseOnlineStatusDisplayInfo localBaseOnlineStatusDisplayInfo = (BaseOnlineStatusDisplayInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localBaseOnlineStatusDisplayInfo != null)
    {
      localBaseOnlineStatusDisplayInfo.a(true, paramLong);
      localBaseOnlineStatusDisplayInfo.a();
      localBaseOnlineStatusDisplayInfo.a(false);
      return localBaseOnlineStatusDisplayInfo;
    }
    paramUpdateUIListener = b(paramLong, paramUpdateUIListener, paramQQAppInterface, paramBaseActivity);
    if (paramUpdateUIListener != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramUpdateUIListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBaseOnlineStatusDisplayInfo = paramUpdateUIListener;
    return paramUpdateUIListener;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      BaseOnlineStatusDisplayInfo localBaseOnlineStatusDisplayInfo = (BaseOnlineStatusDisplayInfo)((Map.Entry)localIterator.next()).getValue();
      if (localBaseOnlineStatusDisplayInfo != null) {
        localBaseOnlineStatusDisplayInfo.e();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBaseOnlineStatusDisplayInfo = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusDisplayInfoBuilder
 * JD-Core Version:    0.7.0.1
 */