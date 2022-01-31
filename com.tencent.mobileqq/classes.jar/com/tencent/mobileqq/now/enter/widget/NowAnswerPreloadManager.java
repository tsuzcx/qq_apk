package com.tencent.mobileqq.now.enter.widget;

import afnl;
import afnm;
import afnn;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.now.enter.NowEnterManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class NowAnswerPreloadManager
{
  private static long jdField_a_of_type_Long;
  private static NowEnterManager jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager;
  private static boolean jdField_a_of_type_Boolean;
  private static long jdField_b_of_type_Long;
  private static boolean jdField_b_of_type_Boolean;
  
  public static void a()
  {
    ThreadManager.getUIHandler().post(new afnl());
  }
  
  private static void a(long paramLong)
  {
    QLog.i("NowAnswerPreloadManager", 3, "openAnswerRoom---");
    if (jdField_b_of_type_Boolean)
    {
      QLog.i("NowAnswerPreloadManager", 3, "openAnswerRoom---Already Open Room");
      return;
    }
    jdField_b_of_type_Boolean = true;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null);
    if (jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager == null) {
      jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager = (NowEnterManager)localQQAppInterface.getManager(264);
    }
    if (jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager.a())
    {
      QLog.i("NowAnswerPreloadManager", 3, "openAnswerRoom---Allow Auto Enter Room");
      if ((NetworkUtil.b(BaseApplicationImpl.getContext())) && (!jdField_a_of_type_ComTencentMobileqqNowEnterNowEnterManager.b()))
      {
        QLog.i("NowAnswerPreloadManager", 3, "openAnswerRoom---Mobile Network is not allow auto enter room");
        return;
      }
      ThreadManager.getUIHandler().post(new afnn(paramLong, localQQAppInterface));
      return;
    }
    QLog.i("NowAnswerPreloadManager", 3, "openAnswerRoom---NO Allow Auto Enter Room");
  }
  
  public static void a(boolean paramBoolean)
  {
    QLog.i("NowAnswerPreloadManager", 3, "setNowMiddleOrH5ActivityCreated----");
    jdField_a_of_type_Boolean = paramBoolean;
    if ((jdField_a_of_type_Boolean) && (!jdField_b_of_type_Boolean) && (jdField_a_of_type_Long != 0L)) {
      a(jdField_a_of_type_Long);
    }
  }
  
  public static void b()
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    QLog.i("NowAnswerPreloadManager", 3, "reqNowLiveStatusAndOpenRoom----");
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getContext().getApplicationContext(), ProtoServlet.class);
    localNewIntent.putExtra("cmd", "MQUpdateSvc_com_qq_now.web.GetHomePage");
    WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
    localWebSsoRequestBody.type.set(0);
    localWebSsoRequestBody.data.set("{\"subcmd\":\"GetHomePage\",\"need_follow\":1,\"frchannel\":8888}");
    localNewIntent.putExtra("data", localWebSsoRequestBody.toByteArray());
    localNewIntent.setObserver(new afnm());
    BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
  }
  
  private static void b(JSONObject paramJSONObject)
  {
    QLog.i("NowAnswerPreloadManager", 3, "parseResponse----");
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        if (paramJSONObject.getInt("retcode") == 0)
        {
          paramJSONObject = new JSONObject(paramJSONObject.getString("data")).getJSONObject("result");
          if ((paramJSONObject != null) && (paramJSONObject.getInt("ret_code") == 0))
          {
            int i = paramJSONObject.getInt("act_status");
            if ((i == 0) || (i == 5))
            {
              jdField_a_of_type_Long = paramJSONObject.getInt("act_room");
              jdField_b_of_type_Long = paramJSONObject.getInt("act_anchor");
              QLog.i("NowAnswerPreloadManager", 3, "parseResponse----will start Now Room Activity, roomid = " + jdField_a_of_type_Long + ", anchorid = " + jdField_b_of_type_Long);
              if (jdField_a_of_type_Boolean)
              {
                a(jdField_a_of_type_Long);
                return;
              }
            }
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.i("NowAnswerPreloadManager", 3, "parseResponse----JSON Exception e = " + paramJSONObject.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.now.enter.widget.NowAnswerPreloadManager
 * JD-Core Version:    0.7.0.1
 */