package com.tencent.mobileqq.dating;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class SayHelloMsgListActivity
  extends BaseMsgBoxActivity
{
  NearbyRelevantObserver a = new SayHelloMsgListActivity.1(this);
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setTitle(2131699017);
    this.app.addObserver(this.a, true);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.a);
  }
  
  public void finish()
  {
    if ((this.mBoxMsgType == 1001) && (AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(this.mBoxUIN)))
    {
      this.app.getPreferences().edit().putLong("sp_key_say_hello_msg_clean_unread_time", NetConnInfoCenter.getServerTime()).commit();
      this.app.getConversationFacade().a(this.mBoxUIN, this.mBoxMsgType, true);
    }
    super.finish();
  }
  
  protected List<RecentBaseData> makeRecetBaseData(List<MessageRecord> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      long l2;
      if (localIterator.hasNext())
      {
        paramList = (MessageRecord)localIterator.next();
        String str = paramList.senderuin;
        l2 = System.currentTimeMillis();
        if (this.mMsgItemCache.containsKey(str))
        {
          paramList = (RecentBaseData)this.mMsgItemCache.get(str);
        }
        else
        {
          paramList = new RecentSayHelloListItem(paramList);
          this.mMsgItemCache.put(str, paramList);
        }
      }
      try
      {
        localArrayList2.add(Long.valueOf(paramList.getRecentUserUin()));
        label131:
        paramList.update(this.app, BaseApplication.getContext());
        localArrayList1.add(paramList);
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        paramList = new StringBuilder();
        paramList.append("item update time cost = ");
        paramList.append(System.currentTimeMillis() - l2);
        QLog.d("Q.msg_box", 4, paramList.toString());
        continue;
        if (!localArrayList2.isEmpty()) {
          ThreadManager.getFileThreadHandler().post(new SayHelloMsgListActivity.2(this, localArrayList2));
        }
        if (QLog.isDevelopLevel())
        {
          l2 = System.currentTimeMillis();
          paramList = new StringBuilder();
          paramList.append("makeRecetBaseData |start cost time:");
          paramList.append(l2 - l1);
          QLog.d("Q.msg_box", 4, paramList.toString());
        }
        return localArrayList1;
      }
      catch (Exception localException)
      {
        break label131;
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void preProcessMessageList(List<MessageRecord> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    Object localObject2 = null;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.SayHelloMsgListActivity
 * JD-Core Version:    0.7.0.1
 */