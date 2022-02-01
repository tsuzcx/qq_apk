import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;

class sej
  implements bcyc
{
  sej(seg paramseg) {}
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", "onConfigResult result=" + paramInt1 + ", serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", anvx.a(2131707074) + paramInt2 + "]", null);
        bcxc.a(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(seg.a(this.a), localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", anvx.a(2131707071), null);
        ShortVideoResourceManager.a(seg.a(this.a), localArrayList, this.a.a);
        return;
      }
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", anvx.a(2131707072) + paramInt1 + "]", null);
      bcxc.a(1, paramInt1);
      return;
    }
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", anvx.a(2131707065) + paramInt2 + "]", null);
    bcxc.a(1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sej
 * JD-Core Version:    0.7.0.1
 */