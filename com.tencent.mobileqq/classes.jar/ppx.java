import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class ppx
{
  public static void a(Container paramContainer, pgd parampgd)
  {
    a(paramContainer, parampgd, "id_nickname");
  }
  
  public static void a(Container paramContainer, pgd parampgd, String paramString)
  {
    ArticleInfo localArticleInfo = parampgd.a();
    paramContainer = paramContainer.getVirtualView();
    pqg localpqg = (pqg)paramContainer.findViewBaseByName("id_partner_info_avator");
    if (localpqg != null) {
      localpqg.a(parampgd);
    }
    paramContainer = (pso)paramContainer.findViewBaseByName(paramString);
    if (paramContainer != null)
    {
      long l = 0L;
      if (localArticleInfo.mPartnerAccountInfo != null) {
        l = localArticleInfo.mPartnerAccountInfo.uint64_uin.get();
      }
      paramContainer.a(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ppx
 * JD-Core Version:    0.7.0.1
 */