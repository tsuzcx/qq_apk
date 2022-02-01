import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.HtmlOffline.6;
import com.tencent.biz.common.util.NetworkUtil;

public class nvc
  implements nuw
{
  public nvc(HtmlOffline.6 param6) {}
  
  public void loaded(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.a.jdField_a_of_type_Long;
    if (nuz.a.a()) {
      nuz.a.a("HtmlCheckUpdate", 2, "js call downloadUpdate callback:" + paramInt + ", time:" + l);
    }
    if (paramInt == 0) {
      if (nuz.b(this.a.b)) {
        this.a.jdField_a_of_type_Nuw.loaded(null, 0);
      }
    }
    for (;;)
    {
      BidDownloader.b(this.a.b);
      nuz.a(this.a.b, paramInt, l, NetworkUtil.getNetworkType(this.a.jdField_a_of_type_AndroidContentContext));
      return;
      this.a.jdField_a_of_type_Nuw.loaded(null, 6);
      continue;
      this.a.jdField_a_of_type_Nuw.loaded(null, 2);
    }
  }
  
  public void progress(int paramInt)
  {
    this.a.jdField_a_of_type_Nuw.progress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nvc
 * JD-Core Version:    0.7.0.1
 */