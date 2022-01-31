import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.Comparator;

class ozl
  implements Comparator<AdvertisementInfo>
{
  ozl(ozk paramozk) {}
  
  public int a(AdvertisementInfo paramAdvertisementInfo1, AdvertisementInfo paramAdvertisementInfo2)
  {
    return paramAdvertisementInfo1.mAdKdPos - paramAdvertisementInfo2.mAdKdPos;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozl
 * JD-Core Version:    0.7.0.1
 */