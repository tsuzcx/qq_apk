package com.tencent.mobileqq.jsp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.identification.FaceContext;
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
        localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        localObject = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg);
        int i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        if (i == 15)
        {
          paramFromServiceMsg = ((oidb_sso.OIDBSSOPkg)localObject).str_error_msg.get();
          QLog.e("FaceDetectForThirdPartyServlet", 1, "sso result error, ret : " + i + "  error : " + paramFromServiceMsg);
          notifyObserver(paramIntent, 15, false, null, null);
          return;
        }
        paramFromServiceMsg = b(paramFromServiceMsg);
        if (paramFromServiceMsg != null) {
          break label166;
        }
        QLog.e("FaceDetectForThirdPartyServlet", 1, "handleFaceDetectResponse, appconf is null");
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
      return;
      label166:
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("app_id", paramIntent.getIntExtra("app_id", 0));
      ((Bundle)localObject).putSerializable("FaceRecognition.AppConf", paramFromServiceMsg);
      notifyObserver(paramIntent, 17, true, (Bundle)localObject, null);
      if (QLog.isColorLevel()) {
        QLog.d("FaceDetectForThirdPartyServlet", 2, new Object[] { "handleFaceDetectResponse succsss=", paramFromServiceMsg });
      }
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
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, long paramLong, BusinessObserver paramBusinessObserver)
  {
    if (FaceContext.c.contains(paramString1)) {
      a(paramString2, paramInt, paramString3, paramString4, paramString5, paramLong, paramBusinessObserver);
    }
    do
    {
      return;
      NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), FaceDetectForThirdPartyServlet.class);
      localNewIntent.putExtra("qq_version", paramString3);
      localNewIntent.putExtra("app_id", paramInt);
      localNewIntent.putExtra("cmd_param", "FaceRecognition.AppConf");
      localNewIntent.putExtra("light_info", paramString4);
      localNewIntent.putExtra("tmp_key", paramString5);
      localNewIntent.putExtra("method", paramString1);
      localNewIntent.putExtra("nonce", paramLong);
      localNewIntent.putExtra("uin", paramString2);
      localNewIntent.setObserver(paramBusinessObserver);
      paramQQAppInterface.startServlet(localNewIntent);
    } while (!QLog.isColorLevel());
    QLog.d("FaceDetectForThirdPartyServlet", 2, "requestThirdPartyInfo appId=" + paramInt + " qqVersion=" + paramString3 + " lightInfo=" + paramString4);
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
  
  private static int[] a(String paramString)
  {
    int i = 0;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return new int[0];
      }
      String[] arrayOfString = paramString.split(" ");
      int[] arrayOfInt = new int[arrayOfString.length];
      for (;;)
      {
        paramString = arrayOfInt;
        if (i >= arrayOfString.length) {
          break;
        }
        arrayOfInt[i] = Integer.parseInt(arrayOfString[i]);
        i += 1;
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("FaceDetectForThirdPartyServlet", 1, "parseAction error : " + paramString.getMessage());
      paramString = null;
    }
  }
  
  private static FaceDetectForThirdPartyManager.AppConf b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      QLog.e("FaceDetectForThirdPartyServlet", 1, "getAppConfFromBytes, but data is null");
      return null;
    }
    for (;;)
    {
      int i;
      String str1;
      String str2;
      int j;
      String str3;
      String str4;
      String str5;
      ArrayList localArrayList;
      Object localObject4;
      try
      {
        localObject2 = new Appconf.AppConfResponse();
        ((Appconf.AppConfResponse)localObject2).mergeFrom(paramArrayOfByte);
        localObject1 = ((Appconf.AppConfResponse)localObject2).AppName.get();
        i = ((Appconf.AppConfResponse)localObject2).Mode.get();
        str1 = ((Appconf.AppConfResponse)localObject2).ColorSeq.get().toStringUtf8();
        str2 = ((Appconf.AppConfResponse)localObject2).Session.get();
        j = ((Appconf.AppConfResponse)localObject2).Ret.get();
        str3 = ((Appconf.AppConfResponse)localObject2).select_data.get();
        str4 = ((Appconf.AppConfResponse)localObject2).ErrMsg.get();
        str5 = ((Appconf.AppConfResponse)localObject2).ActionSeq.get().toStringUtf8();
        if (!QLog.isDevelopLevel()) {
          break label532;
        }
        paramArrayOfByte = ((Appconf.AppConfResponse)localObject2).Debug.get();
        localObject3 = ((Appconf.AppConfResponse)localObject2).Wordings.get();
        localArrayList = new ArrayList(3);
        if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
        {
          localObject3 = ((List)localObject3).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label288;
          }
          localObject4 = (Appconf.Wording)((Iterator)localObject3).next();
          localArrayList.add(new FaceDetectForThirdPartyManager.AppWordings(((Appconf.Wording)localObject4).serviceType.get(), ((Appconf.Wording)localObject4).Text.get()));
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label288;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.e("FaceDetectForThirdPartyServlet", 1, new Object[] { "appConf merge from data error : ", paramArrayOfByte.getMessage() });
        return null;
      }
      QLog.d("FaceDetectForThirdPartyServlet", 2, "handleFaceDetectResponse list is null appName =" + (String)localObject1);
      label288:
      Object localObject3 = new ArrayList(3);
      Object localObject2 = ((Appconf.AppConfResponse)localObject2).protocols.get();
      if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
        localObject2 = ((List)localObject2).iterator();
      }
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject5 = (Appconf.ServiceProtocol)((Iterator)localObject2).next();
        localObject4 = ((Appconf.ServiceProtocol)localObject5).name.get();
        localObject5 = ((Appconf.ServiceProtocol)localObject5).url.get();
        QLog.d("FaceDetectForThirdPartyServlet", 1, new Object[] { "handleFaceDetectResponse ServiceProtocol name=", localObject4, ", url=", localObject5 });
        if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
        {
          ((List)localObject3).add(new FaceDetectForThirdPartyManager.ServiceProtocolSerializable((String)localObject4, (String)localObject5));
          continue;
          QLog.d("FaceDetectForThirdPartyServlet", 1, "handleFaceDetectResponse rspBody.protocols isEmpty");
        }
      }
      Object localObject1 = new FaceDetectForThirdPartyManager.AppConf((String)localObject1, localArrayList, i);
      ((FaceDetectForThirdPartyManager.AppConf)localObject1).colorSequence = str1;
      ((FaceDetectForThirdPartyManager.AppConf)localObject1).session = str2;
      ((FaceDetectForThirdPartyManager.AppConf)localObject1).ret = j;
      ((FaceDetectForThirdPartyManager.AppConf)localObject1).errMsg = str4;
      ((FaceDetectForThirdPartyManager.AppConf)localObject1).actionReq = a(str5);
      ((FaceDetectForThirdPartyManager.AppConf)localObject1).debug = paramArrayOfByte;
      ((FaceDetectForThirdPartyManager.AppConf)localObject1).serviceProtocols.addAll((Collection)localObject3);
      ((FaceDetectForThirdPartyManager.AppConf)localObject1).selectData = str3;
      return localObject1;
      label532:
      paramArrayOfByte = null;
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    if (str2 == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      localStringBuilder = new StringBuilder().append("resp:").append(str2).append(" is ");
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (String str1 = "";; str1 = "not")
    {
      QLog.d("FaceDetectForThirdPartyServlet", 2, str1 + " success");
      if (!"FaceRecognition.AppConf".equals(str2)) {
        break;
      }
      a(paramIntent, paramFromServiceMsg);
      return;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("cmd_param");
    if (QLog.isColorLevel()) {
      QLog.d("FaceDetectForThirdPartyServlet", 2, "resp:" + str);
    }
    if ("FaceRecognition.AppConf".equals(str)) {
      a(paramIntent, paramPacket);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.FaceDetectForThirdPartyServlet
 * JD-Core Version:    0.7.0.1
 */