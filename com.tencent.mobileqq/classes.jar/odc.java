import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyCutImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

class odc
  implements obc
{
  odc(ocz paramocz) {}
  
  public void a()
  {
    if (ocz.a(this.a).booleanValue())
    {
      if ((ocz.a(this.a).isShown()) && (ocz.a(this.a).getWindowVisibility() == 0))
      {
        ocz.a(this.a, ocz.a(this.a));
        ocz.a(this.a).removeCallbacks(ocz.a(this.a));
        ocz.a(this.a).postDelayed(ocz.a(this.a), ocz.a(this.a).mAdvertisementExtInfo.n);
      }
    }
    else {
      return;
    }
    ocz.a(this.a, Boolean.valueOf(false));
    ocz.a(this.a, ocz.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odc
 * JD-Core Version:    0.7.0.1
 */