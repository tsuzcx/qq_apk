import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import java.io.File;
import java.net.URL;

final class sng
  implements spa
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = System.currentTimeMillis();
  
  sng(KandianUrlImageView paramKandianUrlImageView) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    snb.d("WeishiUtils", "url = " + paramURL + ", onLoadFailed!!!");
    if (this.jdField_a_of_type_Int < 2)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      snb.d("WeishiUtils", "");
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(paramURL);
      return;
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(URL paramURL, rpd paramrpd)
  {
    snb.b("WeishiUtils", "onLoadSuccess!!!");
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Long > 0L)
    {
      if (paramURL != null)
      {
        skq.b(1, paramURL.toString());
        long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        paramrpd = ayoi.a(paramURL.toString());
        if (paramrpd != null)
        {
          String str = paramrpd.getAbsolutePath();
          long l2 = paramrpd.length();
          snb.c("actWsFeedPicReqDuration", "--successTime:" + System.currentTimeMillis() + ", downloadCost:" + l1 + ", length:" + l2 + ", url = " + paramURL.toString() + "\n--absolutePath = " + str);
          smr.a().a(true, l1, l2);
        }
      }
      this.jdField_a_of_type_Long = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sng
 * JD-Core Version:    0.7.0.1
 */