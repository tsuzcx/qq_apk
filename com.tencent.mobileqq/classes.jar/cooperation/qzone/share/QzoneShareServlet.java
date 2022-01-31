package cooperation.qzone.share;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareData;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QzoneShareServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      QLog.e("QzoneShare.QzoneShareServlet", 1, "QzoneShareServlet onReceive success.");
      return;
    }
    QLog.e("QzoneShare.QzoneShareServlet", 1, "QzoneShareServlet onReceive fail.");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getExtras();
    Object localObject3 = (QZoneShareData)paramIntent.get("sharedata");
    long l = ((QZoneShareData)localObject3).jdField_a_of_type_Long;
    Object localObject1 = ((QZoneShareData)localObject3).e;
    Object localObject2 = ((QZoneShareData)localObject3).b;
    String str1 = ((QZoneShareData)localObject3).c;
    String str2 = ((QZoneShareData)localObject3).d;
    String str3 = ((QZoneShareData)localObject3).g;
    ArrayList localArrayList = ((QZoneShareData)localObject3).jdField_a_of_type_JavaUtilArrayList;
    int i = ((QZoneShareData)localObject3).jdField_a_of_type_Int;
    localObject3 = paramIntent.getString("reason");
    localObject2 = new QzoneShareRequest((String)localObject1, str2, 2020014, paramIntent.getLong("uin"), (String)localObject2, str1, (String)localObject3, localArrayList, l, str3, i);
    localObject1 = ((QzoneShareRequest)localObject2).encode();
    paramIntent = (Intent)localObject1;
    if (localObject1 == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + ((QzoneShareRequest)localObject2).uniKey());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.share.QzoneShareServlet
 * JD-Core Version:    0.7.0.1
 */