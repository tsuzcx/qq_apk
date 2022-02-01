package com.tencent.mobileqq.studyroom.channel;

import android.content.Context;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.avbiz.IModule.FocusChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.QQConfigAbilityInterface.Callback;
import org.json.JSONException;
import org.json.JSONObject;

public class StudyRoomAVBizHandler
{
  private final String a = "studyroom.StudyRoomAVBizHandler";
  private final String b = "自习室";
  private QQConfigAbilityInterface.Callback<JSONObject> c;
  private final IModule.FocusChangeListener d = new StudyRoomAVBizHandler.1(this);
  
  private int a(String paramString)
  {
    if ("true".equals(paramString)) {
      return 1;
    }
    return 2;
  }
  
  public static StudyRoomAVBizHandler a()
  {
    return StudyRoomAVBizHandler.Holder.a();
  }
  
  private JSONObject a(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("avBizResult", paramInt);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      QLog.i("studyroom.StudyRoomAVBizHandler", 1, "getAVBizResultJsonObj with Exception");
    }
    return localJSONObject;
  }
  
  private IModule c()
  {
    return AVBizModuleFactory.getModuleByName("自习室");
  }
  
  public String a(Context paramContext)
  {
    QLog.i("studyroom.StudyRoomAVBizHandler", 1, "checkAVEnable start");
    if (paramContext == null)
    {
      QLog.i("studyroom.StudyRoomAVBizHandler", 1, "checkAVEnable context == null");
      return "true";
    }
    QLog.i("studyroom.StudyRoomAVBizHandler", 1, "checkAVEnable checkAVFocus");
    return c().checkAVFocus();
  }
  
  public void a(QQConfigAbilityInterface.Callback<JSONObject> paramCallback)
  {
    QLog.i("studyroom.StudyRoomAVBizHandler", 1, "onEnterRoom");
    this.c = paramCallback;
    String str = c().requestAVFocus();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoom requestAVFocus = ");
    localStringBuilder.append(str);
    QLog.i("studyroom.StudyRoomAVBizHandler", 1, localStringBuilder.toString());
    paramCallback.onResult(a(a(str)));
    c().setListener(this.d);
  }
  
  public void b()
  {
    QLog.i("studyroom.StudyRoomAVBizHandler", 1, "onExitRoom");
    c().abandonAVFocus();
    AVBizModuleFactory.removeModuleByName("自习室");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.channel.StudyRoomAVBizHandler
 * JD-Core Version:    0.7.0.1
 */