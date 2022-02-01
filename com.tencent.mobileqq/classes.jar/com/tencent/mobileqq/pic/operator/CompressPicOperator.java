package com.tencent.mobileqq.pic.operator;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.pic.compress.PicType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.BinderWarpper;
import java.util.Arrays;

public class CompressPicOperator
  extends AbstractPicOperator
  implements IPicInfoBuilder.CompressInfoBuilder
{
  public static int[] a(QQAppInterface paramQQAppInterface)
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.picCompressArgConfig.name(), "9|960|960|960|960|960|960|80|70|70");
    Logger.a("CompressPicOperator", "getCompressConfigFromServer", "compressConfig = " + str);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Integer[] arrayOfInteger = new Integer[10];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        int i = ((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser(str, arrayOfInteger);
        paramQQAppInterface = paramQQAppInterface.getCurrentUin();
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
            PicType.a = arrayOfInteger[7].intValue();
          }
          if ((arrayOfInteger[8].intValue() > 0) && (arrayOfInteger[8].intValue() <= 100)) {
            PicType.b = arrayOfInteger[8].intValue();
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
      paramQQAppInterface[6] = PicType.a;
      paramQQAppInterface[7] = PicType.b;
      paramQQAppInterface[8] = PicType.c;
      Logger.a("CompressPicOperator", "getCompressConfigFromServer", "result = " + Arrays.toString(paramQQAppInterface));
      return paramQQAppInterface;
      Logger.a("CompressPicOperator", "getCompressConfigFromServer", "current uin do not match");
    }
  }
  
  public CompressInfo a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    int j = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    return new CompressInfo(paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH"), CompressOperator.a(i), j);
  }
  
  public void a()
  {
    int[] arrayOfInt = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    PicReq localPicReq = this.jdField_a_of_type_ComTencentMobileqqPicPicReq;
    Intent localIntent = new Intent(BaseApplication.getContext(), PeakService.class);
    localIntent.putExtra("ServiceAction", 1);
    localIntent.putExtra("CompressInfo", localPicReq.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
    localIntent.putExtra("CompressConfig", arrayOfInt);
    if (localPicReq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoICompressionCallBack != null) {
      localIntent.putExtra("CompressCallback", new BinderWarpper(localPicReq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoICompressionCallBack.asBinder()));
    }
    try
    {
      BaseApplication.getContext().startService(localIntent);
      return;
    }
    catch (Exception localException)
    {
      Logger.a(this.b, this.jdField_a_of_type_JavaLangString, "launch", "error,req == null" + localException.getStackTrace());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.CompressPicOperator
 * JD-Core Version:    0.7.0.1
 */