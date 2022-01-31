package com.tencent.mobileqq.mybusiness;

import LBS.Attr;
import LBS.Cell;
import LBS.GPS;
import LBS.LBSInfo;
import LBS.Wifi;
import MyCarrier.Carrier;
import MyCarrier.MQQ.PreLoadCarrierReq;
import MyCarrier.ReqCarrier;
import MyCarrier.RspCarrier;
import SecurityAccountServer.RespondQueryQQBindingStat;
import aeli;
import android.content.Intent;
import android.os.Bundle;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoAttribute;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class MyBusinessServlet
  extends MSFServlet
{
  private SosoInterface.SosoLbsInfo a;
  
  public QQAppInterface a()
  {
    return (QQAppInterface)getAppRuntime();
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RspCarrier)decodePacket(paramFromServiceMsg.getWupBuffer(), "RspCarrier", new RspCarrier());
      localBundle.putSerializable("result", paramFromServiceMsg.carrrier);
      localBundle.putSerializable("refreshTime", Integer.valueOf(paramFromServiceMsg.refreshTime));
      paramFromServiceMsg = paramFromServiceMsg.carrrier;
      if (QLog.isDevelopLevel())
      {
        QLog.d("MyBusinessServlet", 4, "----->receiveCarrierQuery sucess");
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierCity      " + paramFromServiceMsg.carrierCity);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierExtraInfo " + paramFromServiceMsg.carrierExtraInfo);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierId        " + paramFromServiceMsg.carrierId);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierLogo      " + paramFromServiceMsg.carrierLogo);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierName      " + paramFromServiceMsg.carrierName);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierProvince  " + paramFromServiceMsg.carrierProvince);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery carrierURL       " + paramFromServiceMsg.carrierURL);
        QLog.d("MyBusinessServlet", 4, "----->onCarrierQuery redhotfilter     " + paramFromServiceMsg.redhotfilter);
      }
      notifyObserver(paramIntent, 1, true, localBundle, MyBusinessObserver.class);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MyBusinessServlet", 4, "----->receiveCarrierQuery sucess failed");
    }
    notifyObserver(paramIntent, 1, false, localBundle, MyBusinessObserver.class);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MyBusinessServlet", 4, "......onReceive cmd = " + paramFromServiceMsg.getServiceCmd());
    }
    if ("CarrierEntry.queryCarrier".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramIntent, paramFromServiceMsg);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("cmd_id", -1);
    if (1 == i) {
      try
      {
        localObject2 = paramIntent.getStringExtra("phone_number");
        i = paramIntent.getIntExtra("bind_from", 0);
        str = paramIntent.getStringExtra("opt_info");
        localObject1 = new LBSInfo();
        this.a = SosoInterface.a();
        SosoInterface.a(new aeli(this, 0, false, true, 60000L, false, false, "MyBusinessServlet"));
        if ((this.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null))
        {
          localGPS = new GPS((int)(this.a.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c * 1000000.0D), (int)(this.a.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d * 1000000.0D), -1, 0);
          localArrayList = new ArrayList();
          if (this.a.jdField_a_of_type_JavaUtilArrayList != null)
          {
            localObject1 = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (SosoInterface.SosoCell)((Iterator)localObject1).next();
              localArrayList.add(new Cell((short)((SosoInterface.SosoCell)localObject3).jdField_a_of_type_Int, (short)((SosoInterface.SosoCell)localObject3).b, ((SosoInterface.SosoCell)localObject3).c, ((SosoInterface.SosoCell)localObject3).d, (short)((SosoInterface.SosoCell)localObject3).e));
              continue;
              return;
            }
          }
        }
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("MyBusinessServlet", 2, "send requet is error");
        }
      }
    }
    while (2 != i)
    {
      String str;
      GPS localGPS;
      ArrayList localArrayList;
      Object localObject3 = new ArrayList();
      if (this.a.b != null)
      {
        localObject1 = this.a.b.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          SosoInterface.SosoWifi localSosoWifi = (SosoInterface.SosoWifi)((Iterator)localObject1).next();
          ((ArrayList)localObject3).add(new Wifi(localSosoWifi.jdField_a_of_type_Long, (short)localSosoWifi.jdField_a_of_type_Int));
        }
      }
      localObject1 = null;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute != null) {
        localObject1 = new Attr(this.a.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.a, this.a.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.b, this.a.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.c);
      }
      localObject1 = new LBSInfo(localGPS, (ArrayList)localObject3, localArrayList, (Attr)localObject1);
      for (;;)
      {
        localObject1 = new ReqCarrier((String)localObject2, i, (LBSInfo)localObject1, str, "7.6.3", 1);
        paramPacket.setSSOCommand("CarrierEntry.queryCarrier");
        paramPacket.setServantName("CarrierEntry");
        paramPacket.setFuncName("queryCarrier");
        paramPacket.addRequestPacket("ReqCarrier", (JceStruct)localObject1);
        localObject1 = paramPacket.toMsg();
        if ((localObject1 != null) && (!a().l))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MyBusinessServlet", 2, "send request to msf");
          }
          sendToMSF(paramIntent, (ToServiceMsg)localObject1);
        }
        paramPacket.setSSOCommand(null);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MyBusinessServlet", 2, "lbs cache is null");
        }
      }
    }
    Object localObject1 = "";
    int j = 0;
    Object localObject2 = (PhoneContactManager)a().getManager(10);
    paramIntent = (Intent)localObject1;
    i = j;
    if (((PhoneContactManager)localObject2).g())
    {
      localObject2 = ((PhoneContactManager)localObject2).a();
      paramIntent = (Intent)localObject1;
      i = j;
      if (localObject2 != null)
      {
        i = ((RespondQueryQQBindingStat)localObject2).type;
        paramIntent = ((RespondQueryQQBindingStat)localObject2).mobileNo;
      }
    }
    paramIntent = new PreLoadCarrierReq(paramIntent, i, 1, "7.6.3.3565", NetworkUtil.a(BaseApplication.getContext()));
    paramPacket.setSSOCommand("CarrierBizSvr.preLoadCarrierInfo");
    paramPacket.setServantName("MQQ.CarrierBizServer.CarrierBizObj");
    paramPacket.setFuncName("preLoadCarrierInfo");
    paramPacket.addRequestPacket("req", paramIntent);
    paramPacket.setNoResponse();
    paramPacket.setTimeout(20000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mybusiness.MyBusinessServlet
 * JD-Core Version:    0.7.0.1
 */