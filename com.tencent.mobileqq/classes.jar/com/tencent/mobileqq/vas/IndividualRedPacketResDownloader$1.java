package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

class IndividualRedPacketResDownloader$1
  extends CallBacker
{
  IndividualRedPacketResDownloader$1(IndividualRedPacketResDownloader paramIndividualRedPacketResDownloader) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((16L != paramLong) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Object localObject2;
    label94:
    boolean bool;
    label118:
    int i;
    if ((QLog.isColorLevel()) || (paramInt1 != 0))
    {
      localObject2 = new StringBuilder().append("callBacker, from:").append(paramString3).append(",httpCode=").append(paramInt2).append(",errorCode:").append(paramInt1).append(", scid:").append(paramString1).append(", cfgScid:").append(paramString2);
      if (paramInt1 != 0)
      {
        String str1 = ", Error ";
        QLog.d("IndividualRedPacketResDownloader", 2, str1);
      }
    }
    else
    {
      if (paramInt1 != 0) {
        break label328;
      }
      bool = true;
      if (!bool) {
        break label334;
      }
      i = 2;
    }
    label328:
    label334:
    label340:
    String str2;
    for (;;)
    {
      try
      {
        if (!"iRedPacket_v3.json".equals(paramString1)) {
          break label340;
        }
        this.a.a(true, false);
        if (QLog.isColorLevel()) {
          QLog.d("IndividualRedPacketResDownloader", 2, "callBacker, from:" + paramString3 + ",httpCode=" + paramInt2 + ",errorCode:" + paramInt1 + ", scid:" + paramString1 + ", cfgScid:" + paramString2 + ", downloadOK=" + bool);
        }
        if ((TextUtils.isEmpty(paramString3)) || (!paramString3.startsWith("silent_download.redbag"))) {
          break;
        }
        this.a.a();
        return;
      }
      catch (Exception localException)
      {
        QLog.d("IndividualRedPacketResDownloader", 2, "callBacker, from:" + paramString3 + ",httpCode=" + paramInt2 + ",errorCode:" + paramInt1 + ", scid:" + paramString1 + ", cfgScid:" + paramString2, localException);
        return;
      }
      localObject1 = ", ok ";
      break label94;
      bool = false;
      break label118;
      i = -1;
      continue;
      if (!"iRedPacket_v3.char300.json".equals(paramString1)) {
        break label481;
      }
      if (bool)
      {
        localObject1 = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + "iRedPacket_v3.char300.json";
        localObject1 = VasUpdateUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.char300.json", (String)localObject1, false, this.a.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
        this.a.a(true, false, paramString1, (File)localObject1);
      }
      localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str2 = IndividualRedPacketManager.c;
      if (!bool) {
        break label669;
      }
      localObject1 = "1";
      label453:
      ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X800612D", "0X800612D", 0, 0, str2, (String)localObject1, "1", "");
    }
    label481:
    if ("iRedPacket_v3.font.zip".equals(paramString1))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo.e = i;
      if (bool)
      {
        localObject1 = new File(IndividualRedPacketManager.a(null, null, 21, 0, 0));
        this.a.a(true, false, paramString1, (File)localObject1);
      }
      localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str2 = IndividualRedPacketManager.c;
      if (!bool) {
        break label676;
      }
    }
    label669:
    label676:
    for (Object localObject1 = "1";; localObject1 = "0")
    {
      ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X800612C", "0X800612C", 0, 0, str2, (String)localObject1, "1", "");
      break;
      if ("iRedPacket_v3.specialChar.zip".equals(paramString1))
      {
        this.a.b.e = i;
        if (!bool) {
          break;
        }
        localObject1 = new File(IndividualRedPacketManager.a(null, null, 25, 0, 0));
        this.a.a(true, false, paramString1, (File)localObject1);
        break;
      }
      if (!paramString1.startsWith("luckyMoney.item.")) {
        break;
      }
      IndividualRedPacketResDownloader.a(this.a, paramString1, bool);
      break;
      localObject1 = "0";
      break label453;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.1
 * JD-Core Version:    0.7.0.1
 */