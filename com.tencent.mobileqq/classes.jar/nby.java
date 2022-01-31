import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.HtmlOffline.6;

public class nby
  implements nbs
{
  public nby(HtmlOffline.6 param6) {}
  
  public void loaded(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.a.jdField_a_of_type_Long;
    if (nbv.a.a()) {
      nbv.a.a("HtmlCheckUpdate", 2, "js call downloadUpdate callback:" + paramInt + ", time:" + l);
    }
    if (paramInt == 0) {
      if (nbv.b(this.a.b)) {
        this.a.jdField_a_of_type_Nbs.loaded(null, 0);
      }
    }
    for (;;)
    {
      BidDownloader.b(this.a.b);
      nbv.a(this.a.b, paramInt, l, ndk.a(this.a.jdField_a_of_type_AndroidContentContext));
      return;
      this.a.jdField_a_of_type_Nbs.loaded(null, 6);
      continue;
      this.a.jdField_a_of_type_Nbs.loaded(null, 2);
    }
  }
  
  public void progress(int paramInt)
  {
    this.a.jdField_a_of_type_Nbs.progress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nby
 * JD-Core Version:    0.7.0.1
 */