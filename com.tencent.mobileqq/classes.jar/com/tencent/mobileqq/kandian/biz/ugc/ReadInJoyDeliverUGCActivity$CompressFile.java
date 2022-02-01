package com.tencent.mobileqq.kandian.biz.ugc;

import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadInJoyDeliverUGCActivity$CompressFile
{
  private long jdField_a_of_type_Long;
  private BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options;
  private CompressInfo jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public ReadInJoyDeliverUGCActivity$CompressFile(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity, String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private boolean a(String paramString, CompressInfo paramCompressInfo, boolean paramBoolean, BitmapFactory.Options paramOptions)
  {
    if (paramBoolean)
    {
      if (ReadInJoyDeliverUGCActivity.e(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity))
      {
        paramBoolean = ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(paramCompressInfo);
        if (QLog.isColorLevel())
        {
          paramOptions = new StringBuilder();
          paramOptions.append("compress result= ");
          paramOptions.append(paramBoolean);
          QLog.d("ReadInJoyDeliverUGCActivity", 2, paramOptions.toString());
        }
        if (!paramBoolean) {
          ReadInJoyDeliverUGCActivity.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity, 1001);
        } else {
          ReadInJoyDeliverUGCActivity.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).add(paramCompressInfo.jdField_e_of_type_JavaLangString);
        }
        paramOptions = new StringBuilder();
        paramOptions.append("startUploadPic compressPath=");
        paramOptions.append(paramCompressInfo.jdField_e_of_type_JavaLangString);
        paramOptions.append(", path=");
        paramOptions.append(paramString);
        paramOptions.append(", width=");
        paramOptions.append(paramCompressInfo.d);
        paramOptions.append(", height=");
        paramOptions.append(paramCompressInfo.jdField_e_of_type_Int);
        QLog.d("ReadInJoyDeliverUGCActivity", 2, paramOptions.toString());
      }
      else
      {
        return true;
      }
    }
    else
    {
      paramCompressInfo.d = paramOptions.outWidth;
      paramCompressInfo.jdField_e_of_type_Int = paramOptions.outHeight;
    }
    return false;
  }
  
  private boolean a(String paramString, boolean paramBoolean, BitmapFactory.Options paramOptions)
  {
    try
    {
      paramOptions.inJustDecodeBounds = true;
      ImageUtil.a(paramString, paramOptions);
      int i;
      if (paramOptions.outHeight > paramOptions.outWidth) {
        i = paramOptions.outHeight;
      } else {
        i = paramOptions.outWidth;
      }
      if (i <= 2560) {
        return false;
      }
    }
    catch (Exception paramString)
    {
      paramOptions = new StringBuilder();
      paramOptions.append("isNeedCompress error");
      paramOptions.append(paramString.toString());
      QLog.d("ReadInJoyDeliverUGCActivity", 2, paramOptions.toString());
    }
    return paramBoolean;
  }
  
  public BitmapFactory.Options a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options;
  }
  
  public CompressFile a()
  {
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo = new CompressInfo(this.jdField_a_of_type_JavaLangString, 0);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
    ((CompressInfo)localObject).f = 0;
    ((CompressInfo)localObject).a = 1036;
    this.b = true;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
    this.b = a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("beforeCompress picture: w:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth);
    ((StringBuilder)localObject).append("  h:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight);
    ((StringBuilder)localObject).append(" size:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long / 1024L);
    ((StringBuilder)localObject).append("kb isNeedCompress:");
    ((StringBuilder)localObject).append(this.b);
    QLog.d("ReadInJoyDeliverUGCActivity", 2, ((StringBuilder)localObject).toString());
    if (a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo, this.b, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options))
    {
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public CompressInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.CompressFile
 * JD-Core Version:    0.7.0.1
 */