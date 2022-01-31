import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;

public class rwt
  implements rwn
{
  public rwt(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void a(bequ<stSimpleMetaFeed> parambequ)
  {
    int i;
    if (WSRecommendFragment.d(this.a))
    {
      i = parambequ.getAdapterPosition();
      parambequ = (stSimpleMetaFeed)WSRecommendFragment.a(this.a).a(i);
      if (parambequ != null) {}
    }
    else
    {
      return;
    }
    WSRecommendFragment.a(this.a, parambequ, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rwt
 * JD-Core Version:    0.7.0.1
 */