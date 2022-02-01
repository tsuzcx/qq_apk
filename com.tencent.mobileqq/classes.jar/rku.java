import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;

class rku
  implements bcxy
{
  rku(rkr paramrkr) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", "onConfigResult result=" + paramInt1 + ", serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", anzj.a(2131706492) + paramInt2 + "]", null);
        bcwy.a(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(rkr.a(this.a), localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", anzj.a(2131706489), null);
        ShortVideoResourceManager.a(rkr.a(this.a), localArrayList, this.a.a);
        return;
      }
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", anzj.a(2131706490) + paramInt1 + "]", null);
      bcwy.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", anzj.a(2131706483) + paramInt2 + "]", null);
    bcwy.a(1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rku
 * JD-Core Version:    0.7.0.1
 */