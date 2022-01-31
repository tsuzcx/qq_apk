import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;

class qis
  implements axes
{
  qis(qip paramqip) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", "onConfigResult result=" + paramInt1 + ", serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131707624) + paramInt2 + "]", null);
        axdu.a(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(qip.a(this.a), localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131707621), null);
        ShortVideoResourceManager.a(qip.a(this.a), localArrayList, this.a.a);
        return;
      }
      VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131707622) + paramInt1 + "]", null);
      axdu.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("ReadInJoyDeliverVideoActivity_AvCodecSo", ajya.a(2131707615) + paramInt2 + "]", null);
    axdu.a(1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qis
 * JD-Core Version:    0.7.0.1
 */