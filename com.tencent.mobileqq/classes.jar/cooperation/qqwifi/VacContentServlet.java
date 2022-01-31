package cooperation.qqwifi;

import LBS.Cell;
import LBS.GPS;
import LBS.LBSInfo;
import LBS.Wifi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.json.JSONArray;
import org.json.JSONObject;
import qqwifi.MQQ.ContentRequest;
import qqwifi.MQQ.ContentResponse;

public class VacContentServlet
  extends MSFServlet
{
  public static LBSInfo a()
  {
    LBSInfo localLBSInfo = new LBSInfo();
    Object localObject1 = SosoInterface.a();
    if ((localObject1 == null) || (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null))
    {
      SosoInterface.a(60000L, "VacContentServlet");
      localObject1 = SosoInterface.a();
    }
    for (;;)
    {
      if (localObject1 == null) {
        return localLBSInfo;
      }
      Object localObject2;
      if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null)
      {
        localObject2 = new GPS();
        ((GPS)localObject2).eType = 1;
        ((GPS)localObject2).iLat = ((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a * 1000000.0D));
        ((GPS)localObject2).iLon = ((int)(((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b * 1000000.0D));
        localLBSInfo.stGps = ((GPS)localObject2);
      }
      if (((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
      {
        localLBSInfo.vCells = new ArrayList();
        localObject2 = ((SosoInterface.SosoLbsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (SosoInterface.SosoCell)((Iterator)localObject2).next();
          if (localObject3 != null)
          {
            localObject3 = new Cell((short)((SosoInterface.SosoCell)localObject3).jdField_a_of_type_Int, (short)((SosoInterface.SosoCell)localObject3).b, ((SosoInterface.SosoCell)localObject3).c, ((SosoInterface.SosoCell)localObject3).d, (short)((SosoInterface.SosoCell)localObject3).e);
            localLBSInfo.vCells.add(localObject3);
          }
        }
      }
      if (((SosoInterface.SosoLbsInfo)localObject1).b != null)
      {
        localLBSInfo.vWifis = new ArrayList();
        localObject1 = ((SosoInterface.SosoLbsInfo)localObject1).b.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SosoInterface.SosoWifi)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = new Wifi(((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Long, (short)((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Int);
            localLBSInfo.vWifis.add(localObject2);
          }
        }
      }
      return localLBSInfo;
    }
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    Object localObject;
    if (paramFromServiceMsg.isSuccess())
    {
      localObject = (ContentResponse)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new ContentResponse());
      if ((localObject == null) || (((ContentResponse)localObject).ret != 0)) {
        break label232;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VacContentServlet", 2, "onGetQQCardInfo, " + ((ContentResponse)localObject).resource);
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(((ContentResponse)localObject).resource).getJSONArray("resource").getJSONObject(0).toString();
        localBundle.putString("key_data", (String)localObject);
        i = j;
      }
      catch (Exception localException1)
      {
        try
        {
          a("qqcard", (String)localObject);
          i = 0;
          if ((!paramFromServiceMsg.isSuccess()) || (i != 0)) {
            break label237;
          }
          bool = true;
          notifyObserver(paramIntent, 8, bool, localBundle, null);
          return;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            int i;
            boolean bool;
            int j = 0;
          }
        }
        localException1 = localException1;
        j = -1;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("VacContentServlet", 2, "", localException1);
        i = j;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("VacContentServlet", 2, "onReceivePayOrder failed, " + paramFromServiceMsg.getBusinessFailCode() + "," + paramFromServiceMsg.getBusinessFailMsg());
        }
        label232:
        i = -1;
        continue;
        label237:
        bool = false;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localBaseApplication.getSharedPreferences("vac_content", i).edit().putString(paramString1, paramString2).commit();
      return;
    }
  }
  
  private void a(Packet paramPacket)
  {
    ContentRequest localContentRequest = new ContentRequest(8L, a(), "7.6.3");
    paramPacket.setSSOCommand("QQWifiSvc.getContentList");
    paramPacket.setServantName("MQQ.AsyncContentMgrServer.AsyncContentMgrObj");
    paramPacket.setFuncName("getContentList");
    paramPacket.setTimeout(20000L);
    paramPacket.addRequestPacket("req", localContentRequest);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VacContentServlet", 2, "onReceive, " + paramFromServiceMsg.getServiceCmd());
    }
    if (("QQWifiSvc.getContentList".equals(paramFromServiceMsg.getServiceCmd())) && (paramIntent.getIntExtra("content_id", -1) == 8)) {
      a(paramIntent, paramFromServiceMsg);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    switch (paramIntent.getIntExtra("content_id", -1))
    {
    default: 
      return;
    }
    a(paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqwifi.VacContentServlet
 * JD-Core Version:    0.7.0.1
 */