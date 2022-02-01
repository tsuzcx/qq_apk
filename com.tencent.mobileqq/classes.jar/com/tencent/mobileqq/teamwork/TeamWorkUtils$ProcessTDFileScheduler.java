package com.tencent.mobileqq.teamwork;

import android.text.TextUtils;
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
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class TeamWorkUtils$ProcessTDFileScheduler
{
  public static ProcessTDFileScheduler a;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private ConcurrentLinkedQueue<MessageRecord> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  private TeamWorkUtils$ProcessTDFileScheduler(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public static ProcessTDFileScheduler a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkUtils$ProcessTDFileScheduler == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkUtils$ProcessTDFileScheduler == null) {
        jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkUtils$ProcessTDFileScheduler = new ProcessTDFileScheduler(paramQQAppInterface);
      }
      jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkUtils$ProcessTDFileScheduler.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
      return jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkUtils$ProcessTDFileScheduler;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() <= 0) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localQQAppInterface == null) || (localQQAppInterface.mAutomator.a() != 1));
    ThreadManager.postImmediately(new TeamWorkUtils.ProcessTDFileScheduler.1(this, localQQAppInterface), null, true);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    label213:
    do
    {
      Object localObject1;
      Object localObject2;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    for (;;)
                    {
                      return;
                      if ((paramMessageRecord instanceof MessageForStructing))
                      {
                        localObject1 = (MessageForStructing)paramMessageRecord;
                        if ((((MessageForStructing)localObject1).structingMsg != null) && (!TextUtils.isEmpty(((MessageForStructing)localObject1).structingMsg.mMsgUrl)) && (FMConstants.a(((MessageForStructing)localObject1).structingMsg.mMsgUrl))) {
                          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramMessageRecord);
                        }
                      }
                      else
                      {
                        if (!(paramMessageRecord instanceof MessageForArkApp)) {
                          break label404;
                        }
                        localObject1 = (MessageForArkApp)paramMessageRecord;
                        localObject2 = ((MessageForArkApp)localObject1).ark_app_message.metaList;
                        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                          try
                          {
                            localObject2 = new JSONObject((String)localObject2);
                            if (!"com.tencent.miniapp_01".equals(((MessageForArkApp)localObject1).ark_app_message.appName)) {
                              break label213;
                            }
                            if (((JSONObject)localObject2).has("detail_1"))
                            {
                              localObject2 = ((JSONObject)localObject2).optJSONObject("detail_1");
                              if (localObject2 != null)
                              {
                                localObject1 = ((JSONObject)localObject2).optString("appid");
                                localObject2 = ((JSONObject)localObject2).optString("qqdocurl");
                                if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject1).equals("1108338344")) || (((String)localObject1).equals("1108961705"))) && (FMConstants.a((String)localObject2)))
                                {
                                  this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramMessageRecord);
                                  return;
                                }
                              }
                            }
                          }
                          catch (JSONException paramMessageRecord) {}
                        }
                      }
                    }
                  } while (!QLog.isColorLevel());
                  QLog.e(TeamWorkConstants.i, 2, paramMessageRecord.getMessage());
                  return;
                  if (!"com.tencent.miniapp".equals(((MessageForArkApp)localObject1).ark_app_message.appName)) {
                    break;
                  }
                } while (!((JSONObject)localObject2).has("detail"));
                localObject2 = ((JSONObject)localObject2).optJSONObject("detail");
              } while (localObject2 == null);
              localObject1 = ((JSONObject)localObject2).optString("appid");
              localObject2 = ((JSONObject)localObject2).optString("qqdocurl");
            } while ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)) || ((!((String)localObject1).equals("1108338344")) && (!((String)localObject1).equals("1108961705"))) || (!FMConstants.a((String)localObject2)));
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramMessageRecord);
            return;
          } while ((!"com.tencent.structmsg".equals(((MessageForArkApp)localObject1).ark_app_message.appName)) || (!((JSONObject)localObject2).has("news")));
          localObject2 = ((JSONObject)localObject2).getJSONObject("news");
        } while (localObject2 == null);
        localObject1 = ((JSONObject)localObject2).optString("appid");
        localObject2 = ((JSONObject)localObject2).optString("jumpUrl");
      } while ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject1).equals(String.valueOf(TeamWorkUtils.a))) || (!FMConstants.a((String)localObject2)));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramMessageRecord);
      return;
    } while ((!(paramMessageRecord instanceof MessageForText)) || (!FMConstants.a(((MessageForText)paramMessageRecord).msg)));
    label404:
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkUtils.ProcessTDFileScheduler
 * JD-Core Version:    0.7.0.1
 */