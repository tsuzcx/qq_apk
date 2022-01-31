package com.tencent.mobileqq.dating;

import acft;
import acfu;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class SayHelloMsgListActivity
  extends BaseMsgBoxActivity
{
  NearbyRelevantObserver a;
  
  public SayHelloMsgListActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver = new acft(this);
  }
  
  protected List a(List paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    long l2;
    if (localIterator.hasNext())
    {
      paramList = (MessageRecord)localIterator.next();
      String str = paramList.senderuin;
      l2 = System.currentTimeMillis();
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(str)) {
        paramList = (RecentBaseData)this.jdField_a_of_type_JavaUtilMap.get(str);
      }
      for (;;)
      {
        paramList.a(this.app, BaseApplication.getContext());
        localArrayList1.add(paramList);
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("Q.msg_box", 4, "item update time cost = " + (System.currentTimeMillis() - l2));
        break;
        paramList = new RecentSayHelloListItem(paramList);
        this.jdField_a_of_type_JavaUtilMap.put(str, paramList);
        try
        {
          localArrayList2.add(Long.valueOf(paramList.a()));
        }
        catch (Exception localException) {}
      }
    }
    if (!localArrayList2.isEmpty()) {
      ThreadManager.getFileThreadHandler().post(new acfu(this, localArrayList2));
    }
    if (QLog.isDevelopLevel())
    {
      l2 = System.currentTimeMillis();
      QLog.d("Q.msg_box", 4, "makeRecetBaseData |start cost time:" + (l2 - l1));
    }
    return localArrayList1;
  }
  
  protected void b(List paramList)
  {
    Object localObject2 = null;
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (TextUtils.isEmpty(localMessageRecord.senderuin))
      {
        localIterator.remove();
      }
      else if (DatingUtil.b(this.app, localMessageRecord.senderuin, localMessageRecord.istroop))
      {
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new ArrayList();
        }
        localIterator.remove();
        ((List)localObject3).add(localMessageRecord);
        localObject1 = localObject3;
      }
      else if (DatingUtil.a(this.app, localMessageRecord.senderuin, localMessageRecord.istroop))
      {
        localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = new ArrayList();
        }
        localIterator.remove();
        ((List)localObject3).add(localMessageRecord);
        localObject2 = localObject3;
      }
    }
    Object localObject3 = new ArrayList();
    if ((localObject2 != null) && (!localObject2.isEmpty())) {
      ((List)localObject3).addAll(localObject2);
    }
    if ((localObject1 != null) && (!localObject1.isEmpty())) {
      ((List)localObject3).addAll(localObject1);
    }
    paramList.addAll(0, (Collection)localObject3);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setTitle(2131437972);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver, true);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver);
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_Int == 1001) && (AppConstants.ae.equals(this.jdField_a_of_type_JavaLangString)))
    {
      this.app.getPreferences().edit().putLong("sp_key_say_hello_msg_clean_unread_time", NetConnInfoCenter.getServerTime()).commit();
      this.app.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true);
    }
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.dating.SayHelloMsgListActivity
 * JD-Core Version:    0.7.0.1
 */