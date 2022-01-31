import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import java.io.File;
import java.net.URL;

final class snj
  implements spd
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = System.currentTimeMillis();
  
  snj(KandianUrlImageView paramKandianUrlImageView) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, Throwable paramThrowable)
  {
    sne.d("WeishiUtils", "url = " + paramURL + ", onLoadFailed!!!");
    if (this.jdField_a_of_type_Int < 2)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      sne.d("WeishiUtils", "");
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(paramURL);
      return;
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(URL paramURL, rpg paramrpg)
  {
    sne.b("WeishiUtils", "onLoadSuccess!!!");
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Long > 0L)
    {
      if (paramURL != null)
      {
        skt.b(1, paramURL.toString());
        long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        paramrpg = ayog.a(paramURL.toString());
        if (paramrpg != null)
        {
          String str = paramrpg.getAbsolutePath();
          long l2 = paramrpg.length();
          sne.c("actWsFeedPicReqDuration", "--successTime:" + System.currentTimeMillis() + ", downloadCost:" + l1 + ", length:" + l2 + ", url = " + paramURL.toString() + "\n--absolutePath = " + str);
          smu.a().a(true, l1, l2);
        }
      }
      this.jdField_a_of_type_Long = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     snj
 * JD-Core Version:    0.7.0.1
 */