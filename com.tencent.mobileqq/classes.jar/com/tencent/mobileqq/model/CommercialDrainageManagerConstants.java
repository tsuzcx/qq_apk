package com.tencent.mobileqq.model;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.model.api.ICommercialDrainageManagerService;
import com.tencent.qphone.base.util.QLog;

public class CommercialDrainageManagerConstants
{
  public static short a = 0;
  public static int b = 0;
  public static int c = 1;
  public static int d = 2;
  public static int e = 3;
  public static int f = 4;
  public static int g = 100;
  public static int h = 101;
  public static String i = HardCodeUtil.a(2131897790);
  public static String j = HardCodeUtil.a(2131897789);
  
  public static void a(AppInterface paramAppInterface, MessageForMarketFace paramMessageForMarketFace)
  {
    MarkFaceMessage localMarkFaceMessage = paramMessageForMarketFace.mMarkFaceMessage;
    if ((localMarkFaceMessage != null) && (localMarkFaceMessage.copywritingType != b))
    {
      int k = ((ICommercialDrainageManagerService)paramAppInterface.getRuntimeService(ICommercialDrainageManagerService.class, "")).getShowCount(paramMessageForMarketFace.time, String.valueOf(localMarkFaceMessage.dwTabID), localMarkFaceMessage.copywritingContent, localMarkFaceMessage.copywritingType);
      if (k == 0)
      {
        localMarkFaceMessage.shouldDisplay = true;
      }
      else if ((k == 1) && (localMarkFaceMessage.hasIpProduct))
      {
        localMarkFaceMessage.shouldDisplay = true;
        localMarkFaceMessage.showIpProduct = true;
        localMarkFaceMessage.from = i;
        localMarkFaceMessage.copywritingContent = j;
      }
      else
      {
        localMarkFaceMessage.shouldDisplay = false;
      }
      try
      {
        paramMessageForMarketFace.msgData = MessagePkgUtils.a(localMarkFaceMessage);
        return;
      }
      catch (Exception paramAppInterface)
      {
        QLog.e("MessageForMarketFace", 1, "decodeC2CUinPairPackage: ", paramAppInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.model.CommercialDrainageManagerConstants
 * JD-Core Version:    0.7.0.1
 */