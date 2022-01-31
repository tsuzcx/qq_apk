import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.HtmlOffline.6;

public class moi
  implements moc
{
  public moi(HtmlOffline.6 param6) {}
  
  public void loaded(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.a.jdField_a_of_type_Long;
    if (mof.a.a()) {
      mof.a.a("HtmlCheckUpdate", 2, "js call downloadUpdate callback:" + paramInt + ", time:" + l);
    }
    if (paramInt == 0) {
      if (mof.b(this.a.b)) {
        this.a.jdField_a_of_type_Moc.loaded(null, 0);
      }
    }
    for (;;)
    {
      BidDownloader.b(this.a.b);
      mof.a(this.a.b, paramInt, l, mpq.a(this.a.jdField_a_of_type_AndroidContentContext));
      return;
      this.a.jdField_a_of_type_Moc.loaded(null, 6);
      continue;
      this.a.jdField_a_of_type_Moc.loaded(null, 2);
    }
  }
  
  public void progress(int paramInt)
  {
    this.a.jdField_a_of_type_Moc.progress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     moi
 * JD-Core Version:    0.7.0.1
 */