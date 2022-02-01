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
  public static int a = 0;
  public static String a;
  public static short a = 0;
  public static int b = 1;
  public static String b = HardCodeUtil.a(2131699756);
  public static int c = 2;
  public static int d = 3;
  public static int e = 4;
  public static int f = 100;
  public static int g = 101;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131699757);
  }
  
  public static void a(AppInterface paramAppInterface, MessageForMarketFace paramMessageForMarketFace)
  {
    MarkFaceMessage localMarkFaceMessage = paramMessageForMarketFace.mMarkFaceMessage;
    if ((localMarkFaceMessage != null) && (localMarkFaceMessage.copywritingType != jdField_a_of_type_Int))
    {
      int i = ((ICommercialDrainageManagerService)paramAppInterface.getRuntimeService(ICommercialDrainageManagerService.class, "")).getShowCount(paramMessageForMarketFace.time, String.valueOf(localMarkFaceMessage.dwTabID), localMarkFaceMessage.copywritingContent, localMarkFaceMessage.copywritingType);
      if (i == 0)
      {
        localMarkFaceMessage.shouldDisplay = true;
      }
      else if ((i == 1) && (localMarkFaceMessage.hasIpProduct))
      {
        localMarkFaceMessage.shouldDisplay = true;
        localMarkFaceMessage.showIpProduct = true;
        localMarkFaceMessage.from = jdField_a_of_type_JavaLangString;
        localMarkFaceMessage.copywritingContent = b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.model.CommercialDrainageManagerConstants
 * JD-Core Version:    0.7.0.1
 */