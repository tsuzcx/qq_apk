import android.graphics.BitmapFactory.Options;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class rub
{
  private long jdField_a_of_type_Long;
  private BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options;
  private CompressInfo jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public rub(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity, String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private boolean a(String paramString, CompressInfo paramCompressInfo, boolean paramBoolean, BitmapFactory.Options paramOptions)
  {
    if (paramBoolean) {
      if (ReadInJoyDeliverUGCActivity.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity))
      {
        paramBoolean = azlg.a(paramCompressInfo);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "compress result= " + paramBoolean);
        }
        if (paramBoolean) {
          break label129;
        }
        ReadInJoyDeliverUGCActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, 1001);
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "startUploadPic compressPath=" + paramCompressInfo.jdField_e_of_type_JavaLangString + ", path=" + paramString + ", width=" + paramCompressInfo.d + ", height=" + paramCompressInfo.jdField_e_of_type_Int);
      }
    }
    for (;;)
    {
      return false;
      return true;
      label129:
      ReadInJoyDeliverUGCActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).add(paramCompressInfo.jdField_e_of_type_JavaLangString);
      break;
      paramCompressInfo.d = paramOptions.outWidth;
      paramCompressInfo.jdField_e_of_type_Int = paramOptions.outHeight;
    }
  }
  
  private boolean a(String paramString, boolean paramBoolean, BitmapFactory.Options paramOptions)
  {
    int i;
    try
    {
      paramOptions.inJustDecodeBounds = true;
      bheg.a(paramString, paramOptions);
      if (paramOptions.outHeight > paramOptions.outWidth) {
        i = paramOptions.outHeight;
      } else {
        i = paramOptions.outWidth;
      }
    }
    catch (Exception paramString)
    {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "isNeedCompress error" + paramString.toString());
      return paramBoolean;
    }
    if (i <= 2560) {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  public BitmapFactory.Options a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options;
  }
  
  public CompressInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
  }
  
  public rub a()
  {
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo = new CompressInfo(this.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.f = 0;
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a = 1036;
    this.b = true;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
    this.b = a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
    QLog.d("ReadInJoyDeliverUGCActivity", 2, "beforeCompress picture: w:" + this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth + "  h:" + this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight + " size:" + this.jdField_a_of_type_Long / 1024L + "kb isNeedCompress:" + this.b);
    if (a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo, this.b, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options))
    {
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rub
 * JD-Core Version:    0.7.0.1
 */