package com.tencent.mobileqq.qqlive.anchor.room.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorThirdPushRoom;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.datareport.ReportTask;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class QQLiveAnchorHelperFastResume
{
  private static final int a = QQLiveAnchorStreamRecordType.CAMERA.ordinal();
  private static final int b = QQLiveAnchorStreamRecordType.SCREEN.ordinal();
  private static final int c = QQLiveAnchorStreamRecordType.THIRD_PUSH.ordinal();
  private static long d = 0L;
  private boolean e = false;
  
  public static IQQLiveAnchorRoom a(IQQLiveSDK paramIQQLiveSDK, QQLiveAnchorRecord paramQQLiveAnchorRecord, IQQLiveAnchorRoomCallback paramIQQLiveAnchorRoomCallback)
  {
    QQLiveAnchorRoomConfig localQQLiveAnchorRoomConfig = new QQLiveAnchorRoomConfig();
    localQQLiveAnchorRoomConfig.streamRecordType = paramQQLiveAnchorRecord.streamType;
    paramIQQLiveSDK = paramIQQLiveSDK.getAnchorModule().createRoom(paramIQQLiveSDK.getAppRuntime().getApplicationContext(), localQQLiveAnchorRoomConfig, paramIQQLiveAnchorRoomCallback);
    paramIQQLiveAnchorRoomCallback = (QQLiveAnchorRoom)paramIQQLiveSDK;
    paramIQQLiveAnchorRoomCallback.setAnchorRoomInfo(paramQQLiveAnchorRecord.roomInfo);
    paramIQQLiveAnchorRoomCallback.setAnchorRoomConfig(paramQQLiveAnchorRecord.roomConfig);
    paramIQQLiveAnchorRoomCallback.setEnterRoomTime(paramQQLiveAnchorRecord.enterRoomTime);
    return paramIQQLiveSDK;
  }
  
  private static QQLiveAnchorStreamRecordType a(int paramInt)
  {
    if (paramInt == a) {
      return QQLiveAnchorStreamRecordType.CAMERA;
    }
    if (paramInt == b) {
      return QQLiveAnchorStreamRecordType.SCREEN;
    }
    if (paramInt == c) {
      return QQLiveAnchorStreamRecordType.THIRD_PUSH;
    }
    return null;
  }
  
  public static QQLiveAnchorRecord a(Context paramContext, String paramString, IQQLiveSDK paramIQQLiveSDK)
  {
    Object localObject1 = paramContext.getSharedPreferences("qqlive_fastresume_record", 4);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("anchor_record_");
    ((StringBuilder)localObject2).append(paramString);
    localObject2 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), null);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("anchor_record_heart_");
    ((StringBuilder)localObject3).append(paramString);
    localObject3 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject3).toString(), null);
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
    {
      try
      {
        localObject1 = new QQLiveAnchorRecord();
        localObject2 = new JSONObject(URLDecoder.decode((String)localObject2, "UTF-8"));
        ((QQLiveAnchorRecord)localObject1).uid = ((JSONObject)localObject2).optLong("uid", 0L);
        ((QQLiveAnchorRecord)localObject1).roomId = ((JSONObject)localObject2).optLong("roomId", 0L);
        ((QQLiveAnchorRecord)localObject1).programId = ((JSONObject)localObject2).optString("programId", "");
        ((QQLiveAnchorRecord)localObject1).streamType = a(((JSONObject)localObject2).optInt("streamType", -1));
        ((QQLiveAnchorRecord)localObject1).recordTime = ((JSONObject)localObject2).optLong("recordTime", 0L);
        ((QQLiveAnchorRecord)localObject1).roomInfo = ((QQLiveAnchorRoomInfo)new Gson().fromJson(((JSONObject)localObject2).optString("roomInfo", "{}"), QQLiveAnchorRoomInfo.class));
        ((QQLiveAnchorRecord)localObject1).roomConfig = ((QQLiveAnchorRoomConfig)new Gson().fromJson(((JSONObject)localObject2).optString("roomConfig", "{}"), QQLiveAnchorRoomConfig.class));
        ((QQLiveAnchorRecord)localObject1).enterRoomTime = ((JSONObject)localObject2).optLong("enterRoomTime", 0L);
        localObject2 = new JSONObject(URLDecoder.decode((String)localObject3, "UTF-8"));
        long l1 = ((JSONObject)localObject2).optLong("uid", 0L);
        long l2 = ((JSONObject)localObject2).optLong("roomId", 0L);
        localObject3 = ((JSONObject)localObject2).optString("programId", "");
        long l3 = ((JSONObject)localObject2).optLong("lastHeartTime", 0L);
        if ((((QQLiveAnchorRecord)localObject1).uid == l1) && (((QQLiveAnchorRecord)localObject1).roomId == l2) && (TextUtils.equals((CharSequence)localObject3, ((QQLiveAnchorRecord)localObject1).programId)))
        {
          ((QQLiveAnchorRecord)localObject1).lastHeartTime = l3;
          if (a((QQLiveAnchorRecord)localObject1))
          {
            a(paramIQQLiveSDK, true, false);
            return localObject1;
          }
          a(paramIQQLiveSDK, true, true);
          a(paramContext, paramString);
        }
        else
        {
          QLog.e("QQLiveAnchor_fastResume", 1, "heart info error");
          a(paramIQQLiveSDK, true, true);
          return null;
        }
      }
      catch (Throwable paramContext)
      {
        QLog.e("QQLiveAnchor_fastResume", 1, "getRecord error: ", paramContext);
      }
      return null;
    }
    a(paramIQQLiveSDK, false, true);
    return null;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("qqlive_fastresume_record", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("anchor_record_");
    localStringBuilder.append(paramString);
    paramContext.remove(localStringBuilder.toString()).apply();
  }
  
  public static void a(IQQLiveSDK paramIQQLiveSDK, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        Object localObject = paramIQQLiveSDK.getDataReportModule();
        if (localObject == null) {
          return;
        }
        try
        {
          LoginInfo localLoginInfo = paramIQQLiveSDK.getLoginModule().getLoginInfo();
          if (localLoginInfo != null) {
            ((IDataReportModule)localObject).setLoginInfo(localLoginInfo);
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("QQLiveAnchor_fastResume", 1, localThrowable, new Object[0]);
        }
        localObject = ((IDataReportModule)localObject).newReportTask().setEventName("anchor_room_fast_resume").addKeyValue("networkType", NetworkUtil.getNetWorkType()).addKeyValue("sdkVersion", "1.0.0");
        if (paramIQQLiveSDK.getAppRuntime() == null) {
          paramIQQLiveSDK = "";
        } else {
          paramIQQLiveSDK = paramIQQLiveSDK.getAppRuntime().getCurrentUin();
        }
        paramIQQLiveSDK = ((ReportTask)localObject).addKeyValue("qqUin", paramIQQLiveSDK);
        if (paramBoolean1)
        {
          i = 1;
          paramIQQLiveSDK = paramIQQLiveSDK.addKeyValue("hasRecord", i);
          if (!paramBoolean2) {
            break label197;
          }
          i = 1;
          paramIQQLiveSDK.addKeyValue("isExpired", i).send();
          return;
        }
      }
      catch (Throwable paramIQQLiveSDK)
      {
        QLog.e("QQLiveAnchor_fastResume", 1, paramIQQLiveSDK, new Object[0]);
        return;
      }
      int i = 0;
      continue;
      label197:
      i = 0;
    }
  }
  
  private static boolean a(QQLiveAnchorRecord paramQQLiveAnchorRecord)
  {
    if (paramQQLiveAnchorRecord == null)
    {
      QLog.e("QQLiveAnchor_fastResume", 1, "checkValid: record is null");
      return false;
    }
    if (paramQQLiveAnchorRecord.uid <= 0L)
    {
      QLog.e("QQLiveAnchor_fastResume", 1, "checkValid: uid <= 0");
      return false;
    }
    if (paramQQLiveAnchorRecord.roomId <= 0L)
    {
      QLog.e("QQLiveAnchor_fastResume", 1, "checkValid: roomId <= 0");
      return false;
    }
    if (TextUtils.isEmpty(paramQQLiveAnchorRecord.programId))
    {
      QLog.e("QQLiveAnchor_fastResume", 1, "checkValid: programId empty");
      return false;
    }
    if (paramQQLiveAnchorRecord.streamType == null)
    {
      QLog.e("QQLiveAnchor_fastResume", 1, "checkValid: streamType is null");
      return false;
    }
    if (paramQQLiveAnchorRecord.enterRoomTime <= 0L)
    {
      QLog.e("QQLiveAnchor_fastResume", 1, "checkValid: enterRoomTime valid");
      return false;
    }
    if (paramQQLiveAnchorRecord.recordTime <= 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkValid: time invalid, ");
      localStringBuilder.append(paramQQLiveAnchorRecord.recordTime);
      QLog.e("QQLiveAnchor_fastResume", 1, localStringBuilder.toString());
      return false;
    }
    if ((paramQQLiveAnchorRecord.lastHeartTime > 0L) && (System.currentTimeMillis() - paramQQLiveAnchorRecord.lastHeartTime < 120000L))
    {
      if ((paramQQLiveAnchorRecord.roomInfo != null) && (paramQQLiveAnchorRecord.roomInfo.roomData != null))
      {
        if ((paramQQLiveAnchorRecord.roomInfo.roomData.id == paramQQLiveAnchorRecord.roomId) && (TextUtils.equals(paramQQLiveAnchorRecord.roomInfo.roomData.programId, paramQQLiveAnchorRecord.programId))) {
          return true;
        }
        QLog.e("QQLiveAnchor_fastResume", 1, "checkValid: id diff");
        return false;
      }
      QLog.e("QQLiveAnchor_fastResume", 1, "checkValid: roomInfo or roomData is null ");
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkValid: lastHeartTime invalid, ");
    localStringBuilder.append(paramQQLiveAnchorRecord.lastHeartTime);
    QLog.e("QQLiveAnchor_fastResume", 1, localStringBuilder.toString());
    return false;
  }
  
  public void a(Context paramContext, QQLiveAnchorRoom paramQQLiveAnchorRoom)
  {
    ThreadManager.getFileThreadHandler().post(new QQLiveAnchorHelperFastResume.1(this, paramContext, paramQQLiveAnchorRoom));
  }
  
  public void a(QQLiveAnchorRoom paramQQLiveAnchorRoom, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback)
  {
    if ((paramQQLiveAnchorRoom != null) && (paramIQQLiveAnchorRoomThirdPushCallback != null))
    {
      paramQQLiveAnchorRoom.a(new QQLiveAnchorHelperFastResume.2(this, paramQQLiveAnchorRoom, paramIQQLiveAnchorRoomThirdPushCallback));
      if (paramQQLiveAnchorRoom.isInited()) {
        b(paramQQLiveAnchorRoom, paramIQQLiveAnchorRoomThirdPushCallback);
      }
      return;
    }
    QLog.e("QQLiveAnchor_fastResume", 1, "fastResume, something is null");
  }
  
  public void b(Context paramContext, QQLiveAnchorRoom paramQQLiveAnchorRoom)
  {
    if ((paramContext != null) && (paramQQLiveAnchorRoom != null) && (!paramQQLiveAnchorRoom.isExitRoom()))
    {
      if (paramQQLiveAnchorRoom.isDestroyed()) {
        return;
      }
      long l = System.currentTimeMillis();
      if (l - d < 3000L) {
        return;
      }
      d = l;
      l = d;
      ThreadManager.getFileThreadHandler().post(new -..Lambda.QQLiveAnchorHelperFastResume.M46NnQ0Q3RgXu0UySwZcJdtl2XU(paramContext, paramQQLiveAnchorRoom, l));
    }
  }
  
  public void b(QQLiveAnchorRoom paramQQLiveAnchorRoom, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback)
  {
    if (paramQQLiveAnchorRoom.isDestroyed()) {
      return;
    }
    if (this.e) {
      return;
    }
    try
    {
      if (this.e) {
        return;
      }
      this.e = true;
      paramIQQLiveAnchorRoomThirdPushCallback.l();
      if (QLog.isColorLevel()) {
        QLog.i("QQLiveAnchor_fastResume", 1, "startAfterInited");
      }
      if (paramQQLiveAnchorRoom.getRoomConfig().streamRecordType == QQLiveAnchorStreamRecordType.THIRD_PUSH)
      {
        if ((paramQQLiveAnchorRoom instanceof QQLiveAnchorThirdPushRoom))
        {
          paramIQQLiveAnchorRoomThirdPushCallback = new QQLiveAnchorAutoCheckPullPlayParams();
          paramIQQLiveAnchorRoomThirdPushCallback.autoCheckPullPlay = true;
          ((QQLiveAnchorThirdPushRoom)paramQQLiveAnchorRoom).getRtmpPullUrl(paramIQQLiveAnchorRoomThirdPushCallback);
        }
      }
      else {
        paramQQLiveAnchorRoom.enterRoom();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperFastResume
 * JD-Core Version:    0.7.0.1
 */