import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;

public class onz
  extends onp
{
  public int a(BaseData paramBaseData)
  {
    int i = -1;
    if ((paramBaseData instanceof ProteusBannerTriplePicItemData)) {
      i = opz.a((ProteusBannerTriplePicItemData)paramBaseData);
    }
    return i;
  }
  
  protected syj a(View paramView, BaseData paramBaseData)
  {
    return new ooa(this, paramView, paramBaseData, this.a);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData != null) && (paramBaseData.t == 24);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     onz
 * JD-Core Version:    0.7.0.1
 */