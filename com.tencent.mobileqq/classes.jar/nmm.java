import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.HtmlOffline.6;

public class nmm
  implements nmg
{
  public nmm(HtmlOffline.6 param6) {}
  
  public void loaded(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.a.jdField_a_of_type_Long;
    if (nmj.a.a()) {
      nmj.a.a("HtmlCheckUpdate", 2, "js call downloadUpdate callback:" + paramInt + ", time:" + l);
    }
    if (paramInt == 0) {
      if (nmj.b(this.a.b)) {
        this.a.jdField_a_of_type_Nmg.loaded(null, 0);
      }
    }
    for (;;)
    {
      BidDownloader.b(this.a.b);
      nmj.a(this.a.b, paramInt, l, nny.a(this.a.jdField_a_of_type_AndroidContentContext));
      return;
      this.a.jdField_a_of_type_Nmg.loaded(null, 6);
      continue;
      this.a.jdField_a_of_type_Nmg.loaded(null, 2);
    }
  }
  
  public void progress(int paramInt)
  {
    this.a.jdField_a_of_type_Nmg.progress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nmm
 * JD-Core Version:    0.7.0.1
 */