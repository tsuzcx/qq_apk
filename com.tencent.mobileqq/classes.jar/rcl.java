import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialView;

public class rcl
  implements oki
{
  public rcl(ReadInJoyFastWebBottomSocialView paramReadInJoyFastWebBottomSocialView) {}
  
  public void a(int paramInt)
  {
    boolean bool = true;
    ReadInJoyFastWebBottomSocialView localReadInJoyFastWebBottomSocialView;
    if (paramInt != 2)
    {
      if ((!ReadInJoyFastWebBottomSocialView.a(this.a)) || (ReadInJoyFastWebBottomSocialView.a(this.a).fusionBiuInfo == null)) {
        break label62;
      }
      localReadInJoyFastWebBottomSocialView = this.a;
      if (ReadInJoyFastWebBottomSocialView.a(this.a).fusionBiuInfo.b) {
        break label57;
      }
    }
    for (;;)
    {
      ReadInJoyFastWebBottomSocialView.a(localReadInJoyFastWebBottomSocialView, bool);
      return;
      label57:
      bool = false;
    }
    label62:
    ReadInJoyFastWebBottomSocialView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rcl
 * JD-Core Version:    0.7.0.1
 */