import UserGrowth.stFollowFeedsRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import java.util.ArrayList;

public class tbc
  implements tcm
{
  public tbc(WSFollowFragment paramWSFollowFragment) {}
  
  public void a(JceStruct paramJceStruct)
  {
    if (!(paramJceStruct instanceof stFollowFeedsRsp)) {}
    do
    {
      return;
      paramJceStruct = (stFollowFeedsRsp)paramJceStruct;
    } while (tlf.a(paramJceStruct.feeds));
    tlo.b("WSFollowFragment", "load cache data for follow page, size: " + paramJceStruct.feeds.size());
    this.a.a(paramJceStruct.feeds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tbc
 * JD-Core Version:    0.7.0.1
 */