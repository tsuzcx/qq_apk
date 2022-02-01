package com.tencent.mobileqq.pic.operator;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.compress.AbstractPicType;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import java.util.Arrays;

public class CompressPicOperator
  extends AbstractPicOperator
  implements IPicInfoBuilder.CompressInfoBuilder
{
  public static int[] a(AppInterface paramAppInterface)
  {
    Object localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.picCompressArgConfig.name(), "9|960|960|960|960|960|960|80|70|70");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("compressConfig = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    Logger.a("CompressPicOperator", "getCompressConfigFromServer", ((StringBuilder)localObject2).toString());
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject2 = new Integer[10];
        Arrays.fill((Object[])localObject2, Integer.valueOf(0));
        int i = ((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser((String)localObject1, (Integer[])localObject2);
        paramAppInterface = paramAppInterface.getCurrentUin();
        if ((!TextUtils.isEmpty(paramAppInterface)) && (i >= localObject2.length)) {
          if (Integer.parseInt(String.valueOf(paramAppInterface.charAt(paramAppInterface.length() - 1))) <= localObject2[0].intValue())
          {
            if (localObject2[1].intValue() >= 960) {
              AbstractPicType.d = localObject2[1].intValue();
            }
            if (localObject2[2].intValue() >= 960) {
              AbstractPicType.e = localObject2[2].intValue();
            }
            if (localObject2[3].intValue() >= 960) {
              AbstractPicType.f = localObject2[3].intValue();
            }
            if (localObject2[4].intValue() >= 960) {
              AbstractPicType.g = localObject2[4].intValue();
            }
            if (localObject2[5].intValue() >= 960) {
              AbstractPicType.h = localObject2[5].intValue();
            }
            if (localObject2[6].intValue() >= 960) {
              AbstractPicType.i = localObject2[6].intValue();
            }
            if ((localObject2[7].intValue() > 0) && (localObject2[7].intValue() <= 100)) {
              AbstractPicType.a = localObject2[7].intValue();
            }
            if ((localObject2[8].intValue() > 0) && (localObject2[8].intValue() <= 100)) {
              AbstractPicType.b = localObject2[8].intValue();
            }
            if ((localObject2[9].intValue() > 0) && (localObject2[9].intValue() <= 100)) {
              AbstractPicType.c = localObject2[9].intValue();
            }
          }
          else
          {
            Logger.a("CompressPicOperator", "getCompressConfigFromServer", "current uin do not match");
          }
        }
      }
      catch (NumberFormatException paramAppInterface)
      {
        paramAppInterface.printStackTrace();
      }
    }
    paramAppInterface = new int[9];
    paramAppInterface[0] = AbstractPicType.d;
    paramAppInterface[1] = AbstractPicType.e;
    paramAppInterface[2] = AbstractPicType.f;
    paramAppInterface[3] = AbstractPicType.g;
    paramAppInterface[4] = AbstractPicType.h;
    paramAppInterface[5] = AbstractPicType.i;
    paramAppInterface[6] = AbstractPicType.a;
    paramAppInterface[7] = AbstractPicType.b;
    paramAppInterface[8] = AbstractPicType.c;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("result = ");
    ((StringBuilder)localObject1).append(Arrays.toString(paramAppInterface));
    Logger.a("CompressPicOperator", "getCompressConfigFromServer", ((StringBuilder)localObject1).toString());
    return paramAppInterface;
  }
  
  public CompressInfo a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    int j = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    return new CompressInfo(paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH"), ((ICompressOperator)QRoute.api(ICompressOperator.class)).transformQuality(i), j);
  }
  
  public void a()
  {
    Object localObject = this.a;
    CompressInfo localCompressInfo = ((PicReq)localObject).jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
    CompressOperator.a(localCompressInfo);
    localObject = ((PicReq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoICompressionCallBack;
    if (localObject != null)
    {
      if (localCompressInfo.a) {
        ((ICompressionCallBack)localObject).a(localCompressInfo);
      } else {
        ((ICompressionCallBack)localObject).b(localCompressInfo);
      }
      ((ICompressionCallBack)localObject).c(localCompressInfo);
    }
    CommonImgThumbHelper.initAioThumbSizeByDpc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.CompressPicOperator
 * JD-Core Version:    0.7.0.1
 */