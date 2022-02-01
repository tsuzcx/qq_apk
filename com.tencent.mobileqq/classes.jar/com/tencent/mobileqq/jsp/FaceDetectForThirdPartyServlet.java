package com.tencent.mobileqq.jsp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.identification.AppConf;
import com.tencent.mobileqq.identification.AppConf.AppWordings;
import com.tencent.mobileqq.identification.AppConf.ServiceProtocolSerializable;
import com.tencent.mobileqq.identification.IdentificationConstant;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.Appconf.AppConfRequest;
import face.qqlogin.Appconf.AppConfResponse;
import face.qqlogin.Appconf.ServiceProtocol;
import face.qqlogin.Appconf.Wording;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class FaceDetectForThirdPartyServlet
  extends MSFServlet
{
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      try
      {
        Object localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        localObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg);
        int i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        if (i == 15)
        {
          paramFromServiceMsg = ((oidb_sso.OIDBSSOPkg)localObject).str_error_msg.get();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("sso result error, ret : ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("  error : ");
          ((StringBuilder)localObject).append(paramFromServiceMsg);
          QLog.e("FaceDetectForThirdPartyServlet", 1, ((StringBuilder)localObject).toString());
          notifyObserver(paramIntent, 15, false, null, null);
          return;
        }
        paramFromServiceMsg = b(paramFromServiceMsg);
        if (paramFromServiceMsg == null)
        {
          QLog.e("FaceDetectForThirdPartyServlet", 1, "handleFaceDetectResponse, appconf is null");
          return;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putInt("app_id", paramIntent.getIntExtra("app_id", 0));
        ((Bundle)localObject).putSerializable("FaceRecognition.AppConf", paramFromServiceMsg);
        notifyObserver(paramIntent, 17, true, (Bundle)localObject, null);
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("FaceDetectForThirdPartyServlet", 2, new Object[] { "handleFaceDetectResponse succsss=", paramFromServiceMsg });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        notifyObserver(paramIntent, 17, false, null, null);
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d("FaceDetectForThirdPartyServlet", 2, "handleFaceDetectResponse error=", paramFromServiceMsg);
    }
    else
    {
      notifyObserver(paramIntent, 17, false, null, null);
      if (QLog.isColorLevel()) {
        QLog.d("FaceDetectForThirdPartyServlet", 2, "handleFaceDetectResponse not ok");
      }
    }
  }
  
  private void a(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("app_id", 0);
    Object localObject = paramIntent.getStringExtra("qq_version");
    String str = paramIntent.getStringExtra("light_info");
    paramIntent = paramIntent.getStringExtra("tmp_key");
    Appconf.AppConfRequest localAppConfRequest = new Appconf.AppConfRequest();
    localAppConfRequest.AppID.set(i);
    localAppConfRequest.Platform.set("a");
    localAppConfRequest.QQVersion.set((String)localObject);
    localAppConfRequest.YtSDKEnv.set(str);
    localAppConfRequest.TmpKey.set(paramIntent);
    paramIntent = localAppConfRequest.toByteArray();
    localObject = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject).put(paramIntent);
    paramPacket.setSSOCommand("FaceRecognition.AppConf");
    paramPacket.putSendData(((ByteBuffer)localObject).array());
  }
  
  private static void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, long paramLong, BusinessObserver paramBusinessObserver)
  {
    Appconf.AppConfRequest localAppConfRequest = new Appconf.AppConfRequest();
    localAppConfRequest.support_modes.set(Collections.singletonList(Integer.valueOf(4)));
    localAppConfRequest.AppID.set(paramInt);
    localAppConfRequest.Platform.set("a");
    localAppConfRequest.QQVersion.set(paramString2);
    localAppConfRequest.YtSDKEnv.set(paramString3);
    localAppConfRequest.TmpKey.set(paramString4);
    LoginVerifyServlet.a(paramString1, paramLong, Base64.encodeToString(localAppConfRequest.toByteArray(), 11), new FaceDetectForThirdPartyServlet.1(paramBusinessObserver, paramInt));
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, long paramLong, BusinessObserver paramBusinessObserver)
  {
    if (IdentificationConstant.d.contains(paramString1))
    {
      a(paramString2, paramInt, paramString3, paramString4, paramString5, paramLong, paramBusinessObserver);
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), FaceDetectForThirdPartyServlet.class);
    localNewIntent.putExtra("qq_version", paramString3);
    localNewIntent.putExtra("app_id", paramInt);
    localNewIntent.putExtra("cmd_param", "FaceRecognition.AppConf");
    localNewIntent.putExtra("light_info", paramString4);
    localNewIntent.putExtra("tmp_key", paramString5);
    localNewIntent.putExtra("method", paramString1);
    localNewIntent.putExtra("nonce", paramLong);
    localNewIntent.putExtra("uin", paramString2);
    localNewIntent.setObserver(paramBusinessObserver);
    paramAppRuntime.startServlet(localNewIntent);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder("requestThirdPartyInfo appId=");
      paramAppRuntime.append(paramInt);
      paramAppRuntime.append(" qqVersion=");
      paramAppRuntime.append(paramString3);
      paramAppRuntime.append(" lightInfo=");
      paramAppRuntime.append(paramString4);
      QLog.d("FaceDetectForThirdPartyServlet", 2, paramAppRuntime.toString());
    }
  }
  
  private static int[] a(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      int i = 0;
      if (bool) {
        return new int[0];
      }
      paramString = paramString.split(" ");
      localObject = new int[paramString.length];
      while (i < paramString.length)
      {
        localObject[i] = Integer.parseInt(paramString[i]);
        i += 1;
      }
      return localObject;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseAction error : ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("FaceDetectForThirdPartyServlet", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  private static AppConf b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      QLog.e("FaceDetectForThirdPartyServlet", 1, "getAppConfFromBytes, but data is null");
      return null;
    }
    label522:
    for (;;)
    {
      try
      {
        Object localObject1 = new Appconf.AppConfResponse();
        ((Appconf.AppConfResponse)localObject1).mergeFrom(paramArrayOfByte);
        String str6 = ((Appconf.AppConfResponse)localObject1).AppName.get();
        int i = ((Appconf.AppConfResponse)localObject1).Mode.get();
        String str1 = ((Appconf.AppConfResponse)localObject1).ColorSeq.get().toStringUtf8();
        String str2 = ((Appconf.AppConfResponse)localObject1).Session.get();
        int j = ((Appconf.AppConfResponse)localObject1).Ret.get();
        String str3 = ((Appconf.AppConfResponse)localObject1).select_data.get();
        String str4 = ((Appconf.AppConfResponse)localObject1).ErrMsg.get();
        String str5 = ((Appconf.AppConfResponse)localObject1).ActionSeq.get().toStringUtf8();
        if (QLog.isDevelopLevel())
        {
          paramArrayOfByte = ((Appconf.AppConfResponse)localObject1).Debug.get();
          Object localObject2 = ((Appconf.AppConfResponse)localObject1).Wordings.get();
          ArrayList localArrayList = new ArrayList(3);
          Object localObject3;
          if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
          {
            localObject2 = ((List)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (Appconf.Wording)((Iterator)localObject2).next();
              localArrayList.add(new AppConf.AppWordings(((Appconf.Wording)localObject3).serviceType.get(), ((Appconf.Wording)localObject3).Text.get()));
              continue;
            }
          }
          else if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handleFaceDetectResponse list is null appName =");
            ((StringBuilder)localObject2).append(str6);
            QLog.d("FaceDetectForThirdPartyServlet", 2, ((StringBuilder)localObject2).toString());
          }
          localObject2 = new ArrayList(3);
          localObject1 = ((Appconf.AppConfResponse)localObject1).protocols.get();
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            localObject1 = ((List)localObject1).iterator();
            if (((Iterator)localObject1).hasNext())
            {
              Object localObject4 = (Appconf.ServiceProtocol)((Iterator)localObject1).next();
              localObject3 = ((Appconf.ServiceProtocol)localObject4).name.get();
              localObject4 = ((Appconf.ServiceProtocol)localObject4).url.get();
              QLog.d("FaceDetectForThirdPartyServlet", 1, new Object[] { "handleFaceDetectResponse ServiceProtocol name=", localObject3, ", url=", localObject4 });
              if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject4))) {
                break label522;
              }
              ((List)localObject2).add(new AppConf.ServiceProtocolSerializable((String)localObject3, (String)localObject4));
              break label522;
            }
          }
          else
          {
            QLog.d("FaceDetectForThirdPartyServlet", 1, "handleFaceDetectResponse rspBody.protocols isEmpty");
          }
          localObject1 = new AppConf(str6, localArrayList, i);
          ((AppConf)localObject1).colorSequence = str1;
          ((AppConf)localObject1).session = str2;
          ((AppConf)localObject1).ret = j;
          ((AppConf)localObject1).errMsg = str4;
          ((AppConf)localObject1).actionReq = a(str5);
          ((AppConf)localObject1).debug = paramArrayOfByte;
          ((AppConf)localObject1).serviceProtocols.addAll((Collection)localObject2);
          ((AppConf)localObject1).selectData = str3;
          return localObject1;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.e("FaceDetectForThirdPartyServlet", 1, new Object[] { "appConf merge from data error : ", paramArrayOfByte.getMessage() });
        return null;
      }
      paramArrayOfByte = null;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    if (str2 == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resp:");
      localStringBuilder.append(str2);
      localStringBuilder.append(" is ");
      String str1;
      if (bool) {
        str1 = "";
      } else {
        str1 = "not";
      }
      localStringBuilder.append(str1);
      localStringBuilder.append(" success");
      QLog.d("FaceDetectForThirdPartyServlet", 2, localStringBuilder.toString());
    }
    if ("FaceRecognition.AppConf".equals(str2)) {
      a(paramIntent, paramFromServiceMsg);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("cmd_param");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resp:");
      localStringBuilder.append(str);
      QLog.d("FaceDetectForThirdPartyServlet", 2, localStringBuilder.toString());
    }
    if ("FaceRecognition.AppConf".equals(str)) {
      a(paramIntent, paramPacket);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.FaceDetectForThirdPartyServlet
 * JD-Core Version:    0.7.0.1
 */