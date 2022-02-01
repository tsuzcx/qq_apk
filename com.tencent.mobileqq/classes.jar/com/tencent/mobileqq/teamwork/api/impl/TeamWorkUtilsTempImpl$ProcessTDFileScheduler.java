package com.tencent.mobileqq.teamwork.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

class TeamWorkUtilsTempImpl$ProcessTDFileScheduler
{
  private static ProcessTDFileScheduler jdField_a_of_type_ComTencentMobileqqTeamworkApiImplTeamWorkUtilsTempImpl$ProcessTDFileScheduler;
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private ConcurrentLinkedQueue<MessageRecord> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  private TeamWorkUtilsTempImpl$ProcessTDFileScheduler(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
  }
  
  public static ProcessTDFileScheduler a(AppInterface paramAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqTeamworkApiImplTeamWorkUtilsTempImpl$ProcessTDFileScheduler == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqTeamworkApiImplTeamWorkUtilsTempImpl$ProcessTDFileScheduler == null) {
          jdField_a_of_type_ComTencentMobileqqTeamworkApiImplTeamWorkUtilsTempImpl$ProcessTDFileScheduler = new ProcessTDFileScheduler(paramAppInterface);
        }
      }
      finally {}
    }
    jdField_a_of_type_ComTencentMobileqqTeamworkApiImplTeamWorkUtilsTempImpl$ProcessTDFileScheduler.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    return jdField_a_of_type_ComTencentMobileqqTeamworkApiImplTeamWorkUtilsTempImpl$ProcessTDFileScheduler;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() <= 0) {
      return;
    }
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localAppInterface != null) && ((localAppInterface instanceof QQAppInterface)))
    {
      if (((QQAppInterface)localAppInterface).mAutomator.a() != 1) {
        return;
      }
      ThreadManager.postImmediately(new TeamWorkUtilsTempImpl.ProcessTDFileScheduler.1(this, localAppInterface), null, true);
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Object localObject1;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      localObject1 = (MessageForStructing)paramMessageRecord;
      if (((MessageForStructing)localObject1).structingMsg != null)
      {
        if (TextUtils.isEmpty(((MessageForStructing)localObject1).structingMsg.mMsgUrl)) {
          return;
        }
        if (!FMConstants.a(((MessageForStructing)localObject1).structingMsg.mMsgUrl)) {
          return;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramMessageRecord);
      }
    }
    else if ((paramMessageRecord instanceof MessageForArkApp))
    {
      localObject1 = (MessageForArkApp)paramMessageRecord;
      Object localObject2 = ((MessageForArkApp)localObject1).ark_app_message.metaList;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        boolean bool = "com.tencent.miniapp_01".equals(((MessageForArkApp)localObject1).ark_app_message.appName);
        if (bool)
        {
          if (!((JSONObject)localObject2).has("detail_1")) {
            return;
          }
          localObject2 = ((JSONObject)localObject2).optJSONObject("detail_1");
          if (localObject2 == null) {
            return;
          }
          localObject1 = ((JSONObject)localObject2).optString("appid");
          localObject2 = ((JSONObject)localObject2).optString("qqdocurl");
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)) || ((!((String)localObject1).equals("1108338344")) && (!((String)localObject1).equals("1108961705"))) || (!FMConstants.a((String)localObject2))) {
            return;
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramMessageRecord);
          return;
        }
        if ("com.tencent.miniapp".equals(((MessageForArkApp)localObject1).ark_app_message.appName))
        {
          if (!((JSONObject)localObject2).has("detail")) {
            return;
          }
          localObject2 = ((JSONObject)localObject2).optJSONObject("detail");
          if (localObject2 == null) {
            return;
          }
          localObject1 = ((JSONObject)localObject2).optString("appid");
          localObject2 = ((JSONObject)localObject2).optString("qqdocurl");
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)) || ((!((String)localObject1).equals("1108338344")) && (!((String)localObject1).equals("1108961705"))) || (!FMConstants.a((String)localObject2))) {
            return;
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramMessageRecord);
          return;
        }
        if ((!"com.tencent.structmsg".equals(((MessageForArkApp)localObject1).ark_app_message.appName)) || (!((JSONObject)localObject2).has("news"))) {
          return;
        }
        localObject2 = ((JSONObject)localObject2).getJSONObject("news");
        if (localObject2 == null) {
          return;
        }
        localObject1 = ((JSONObject)localObject2).optString("appid");
        localObject2 = ((JSONObject)localObject2).optString("jumpUrl");
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject1).equals(String.valueOf(101458937L))) || (!FMConstants.a((String)localObject2))) {
          return;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramMessageRecord);
        return;
      }
      catch (JSONException paramMessageRecord)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.e(TeamWorkConstants.i, 2, paramMessageRecord.getMessage());
    }
    else if (((paramMessageRecord instanceof MessageForText)) && (FMConstants.a(((MessageForText)paramMessageRecord).msg)))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkUtilsTempImpl.ProcessTDFileScheduler
 * JD-Core Version:    0.7.0.1
 */