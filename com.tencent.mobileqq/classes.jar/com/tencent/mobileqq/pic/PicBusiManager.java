package com.tencent.mobileqq.pic;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.StringToIntParser;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.compress.PicType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.BinderWarpper;
import java.util.ArrayList;
import java.util.Arrays;

public class PicBusiManager
{
  static BasePicOprerator a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    case 1030: 
    default: 
      return null;
    }
    return new AioPicOperator(paramQQAppInterface);
  }
  
  public static CompressInfo a(int paramInt, Intent paramIntent)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramIntent);
  }
  
  static InfoBuilder a(int paramInt)
  {
    switch (paramInt)
    {
    case 1030: 
    default: 
      return null;
    }
    return new AioPicOperator();
  }
  
  public static PicFowardInfo a(int paramInt, Intent paramIntent)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramIntent);
  }
  
  public static PicFowardInfo a(int paramInt1, MessageForPic paramMessageForPic, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    InfoBuilder localInfoBuilder = a(paramInt1);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramMessageForPic, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static PicReq a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, 0, paramInt2);
  }
  
  public static PicReq a(int paramInt1, int paramInt2, int paramInt3)
  {
    PicReq localPicReq = new PicReq();
    localPicReq.jdField_a_of_type_Int = paramInt1;
    localPicReq.c = paramInt2;
    localPicReq.jdField_b_of_type_Int = paramInt3;
    return localPicReq;
  }
  
  public static PicUploadInfo a(int paramInt, Intent paramIntent)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramIntent);
  }
  
  public static ArrayList a(int paramInt1, MessageForMixedMsg paramMessageForMixedMsg, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    InfoBuilder localInfoBuilder = a(paramInt1);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramMessageForMixedMsg, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static void a(PicReq paramPicReq, QQAppInterface paramQQAppInterface)
  {
    if (paramPicReq == null)
    {
      Logger.b("PicBusiManager", "launch", "error,req == null");
      return;
    }
    Object localObject = a(paramPicReq.jdField_b_of_type_Int, paramQQAppInterface);
    if (localObject == null)
    {
      Logger.b("PicBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramPicReq.jdField_b_of_type_Int);
      return;
    }
    ((BasePicOprerator)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ((BasePicOprerator)localObject).jdField_a_of_type_ComTencentMobileqqPicPicReq = paramPicReq;
    ((BasePicOprerator)localObject).jdField_a_of_type_JavaLangString = paramPicReq.jdField_a_of_type_JavaLangString;
    ((BasePicOprerator)localObject).jdField_b_of_type_JavaLangString = paramPicReq.jdField_b_of_type_JavaLangString;
    ((BasePicOprerator)localObject).a(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicUiCallBack);
    Logger.a("PicBusiManager", "launch", "cmd:" + paramPicReq.jdField_a_of_type_Int + ",busiType:" + paramPicReq.jdField_b_of_type_Int + "localUUID:" + paramPicReq.jdField_a_of_type_JavaLangString);
    switch (paramPicReq.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      paramQQAppInterface = a(paramQQAppInterface);
      localObject = new Intent(BaseApplication.getContext(), PeakService.class);
      ((Intent)localObject).putExtra("ServiceAction", 1);
      ((Intent)localObject).putExtra("CompressInfo", paramPicReq.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
      ((Intent)localObject).putExtra("CompressConfig", paramQQAppInterface);
      if (paramPicReq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoICompressionCallBack != null) {
        ((Intent)localObject).putExtra("CompressCallback", new BinderWarpper(paramPicReq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoICompressionCallBack.asBinder()));
      }
      BaseApplication.getContext().startService((Intent)localObject);
      return;
    case 5: 
    case 6: 
    case 7: 
      ((BasePicOprerator)localObject).c(paramPicReq);
      return;
    case 2: 
      ((BasePicOprerator)localObject).a(paramPicReq);
      return;
    case 3: 
      ((BasePicOprerator)localObject).b(paramPicReq);
      return;
    case 4: 
      ((BasePicOprerator)localObject).a(paramPicReq);
      return;
    }
    ((BasePicOprerator)localObject).a(paramPicReq.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface)
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.picCompressArgConfig.name(), "9|960|960|960|960|960|960|80|70|70");
    Logger.a("PicBusiManager", "getCompressConfigFromServer", "compressConfig = " + str);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Integer[] arrayOfInteger = new Integer[10];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        int i = DeviceProfileManager.a(str, arrayOfInteger, new DeviceProfileManager.StringToIntParser());
        paramQQAppInterface = paramQQAppInterface.c();
        if ((!TextUtils.isEmpty(paramQQAppInterface)) && (i >= arrayOfInteger.length))
        {
          if (Integer.parseInt(String.valueOf(paramQQAppInterface.charAt(paramQQAppInterface.length() - 1))) > arrayOfInteger[0].intValue()) {
            continue;
          }
          if (arrayOfInteger[1].intValue() >= 960) {
            PicType.e = arrayOfInteger[1].intValue();
          }
          if (arrayOfInteger[2].intValue() >= 960) {
            PicType.f = arrayOfInteger[2].intValue();
          }
          if (arrayOfInteger[3].intValue() >= 960) {
            PicType.g = arrayOfInteger[3].intValue();
          }
          if (arrayOfInteger[4].intValue() >= 960) {
            PicType.h = arrayOfInteger[4].intValue();
          }
          if (arrayOfInteger[5].intValue() >= 960) {
            PicType.i = arrayOfInteger[5].intValue();
          }
          if (arrayOfInteger[6].intValue() >= 960) {
            PicType.j = arrayOfInteger[6].intValue();
          }
          if ((arrayOfInteger[7].intValue() > 0) && (arrayOfInteger[7].intValue() <= 100)) {
            PicType.jdField_a_of_type_Int = arrayOfInteger[7].intValue();
          }
          if ((arrayOfInteger[8].intValue() > 0) && (arrayOfInteger[8].intValue() <= 100)) {
            PicType.jdField_b_of_type_Int = arrayOfInteger[8].intValue();
          }
          if ((arrayOfInteger[9].intValue() > 0) && (arrayOfInteger[9].intValue() <= 100)) {
            PicType.c = arrayOfInteger[9].intValue();
          }
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        continue;
      }
      paramQQAppInterface = new int[9];
      paramQQAppInterface[0] = PicType.e;
      paramQQAppInterface[1] = PicType.f;
      paramQQAppInterface[2] = PicType.g;
      paramQQAppInterface[3] = PicType.h;
      paramQQAppInterface[4] = PicType.i;
      paramQQAppInterface[5] = PicType.j;
      paramQQAppInterface[6] = PicType.jdField_a_of_type_Int;
      paramQQAppInterface[7] = PicType.jdField_b_of_type_Int;
      paramQQAppInterface[8] = PicType.c;
      Logger.a("PicBusiManager", "getCompressConfigFromServer", "result = " + Arrays.toString(paramQQAppInterface));
      return paramQQAppInterface;
      Logger.a("PicBusiManager", "getCompressConfigFromServer", "current uin do not match");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicBusiManager
 * JD-Core Version:    0.7.0.1
 */