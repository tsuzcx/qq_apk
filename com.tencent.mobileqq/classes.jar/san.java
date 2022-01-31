import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import java.io.File;
import java.net.URL;

final class san
  implements sch
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = System.currentTimeMillis();
  
  san(KandianUrlImageView paramKandianUrlImageView) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    sai.d("WeishiUtils", "url = " + paramURL + ", onLoadFailed!!!");
    if (this.jdField_a_of_type_Int < 2)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      sai.d("WeishiUtils", "");
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(paramURL);
      return;
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(URL paramURL, rcs paramrcs)
  {
    sai.b("WeishiUtils", "onLoadSuccess!!!");
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Long > 0L)
    {
      if (paramURL != null)
      {
        rxx.b(1, paramURL.toString());
        long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        paramrcs = axoa.a(paramURL.toString());
        if (paramrcs != null)
        {
          String str = paramrcs.getAbsolutePath();
          long l2 = paramrcs.length();
          sai.c("actWsFeedPicReqDuration", "--successTime:" + System.currentTimeMillis() + ", downloadCost:" + l1 + ", length:" + l2 + ", url = " + paramURL.toString() + "\n--absolutePath = " + str);
          rzy.a().a(true, l1, l2);
        }
      }
      this.jdField_a_of_type_Long = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     san
 * JD-Core Version:    0.7.0.1
 */