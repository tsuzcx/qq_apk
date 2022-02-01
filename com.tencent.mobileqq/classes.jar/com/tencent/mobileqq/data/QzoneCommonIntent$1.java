package com.tencent.mobileqq.data;

import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneCommonRequest;
import cooperation.qzone.util.ProtocolUtils;
import mqq.app.MSFServlet;

final class QzoneCommonIntent$1
  implements RespProcessor
{
  public void a(MSFServlet paramMSFServlet, QzoneCommonIntent paramQzoneCommonIntent, FromServiceMsg paramFromServiceMsg)
  {
    QZoneCommonRequest localQZoneCommonRequest = paramQzoneCommonIntent.getRequest();
    Object localObject = localQZoneCommonRequest.uniKey();
    int i = localQZoneCommonRequest.getType();
    int[] arrayOfInt = new int[1];
    String[] arrayOfString = new String[1];
    if (!paramFromServiceMsg.isSuccess())
    {
      arrayOfInt[0] = (paramFromServiceMsg.getResultCode() + 300000);
      arrayOfString[0] = paramFromServiceMsg.getBusinessFailMsg();
      paramFromServiceMsg = null;
    }
    else
    {
      paramFromServiceMsg = ProtocolUtils.decode(paramFromServiceMsg.getWupBuffer(), (String)localObject, arrayOfInt, arrayOfString);
    }
    if (QLog.isColorLevel()) {
      QLog.i("QzoneCommonIntent", 2, String.format("cmd :%s, success:%b,code:%d, msg:%s", new Object[] { localQZoneCommonRequest.getCmdString(), Boolean.valueOf(QzoneCommonIntent.succeeded(arrayOfInt[0])), Integer.valueOf(arrayOfInt[0]), arrayOfString[0] }));
    }
    Bundle localBundle = paramQzoneCommonIntent.getExtras();
    localObject = localBundle;
    if (localBundle == null) {
      localObject = new Bundle();
    }
    ((Bundle)localObject).putSerializable("key_response", paramFromServiceMsg);
    ((Bundle)localObject).putInt("key_response_code", arrayOfInt[0]);
    ((Bundle)localObject).putString("key_response_msg", arrayOfString[0]);
    if (paramQzoneCommonIntent.getObserver() == null) {
      QLog.e("QzoneCommonIntent", 1, "observer ==null,无法回调，请检查是否有调用setObserver");
    }
    boolean bool;
    if ((paramFromServiceMsg != null) && (QzoneCommonIntent.succeeded(arrayOfInt[0]))) {
      bool = true;
    } else {
      bool = false;
    }
    paramMSFServlet.notifyObserver(paramQzoneCommonIntent, i, bool, (Bundle)localObject, null);
    if (arrayOfInt[0] != 1000006) {
      QzoneCommonIntent.access$000(localQZoneCommonRequest, arrayOfInt[0], arrayOfString[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QzoneCommonIntent.1
 * JD-Core Version:    0.7.0.1
 */