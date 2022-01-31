import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class pjm
{
  public static void a(Container paramContainer, pau parampau)
  {
    a(paramContainer, parampau, "id_nickname");
  }
  
  public static void a(Container paramContainer, pau parampau, String paramString)
  {
    ArticleInfo localArticleInfo = parampau.a();
    paramContainer = paramContainer.getVirtualView();
    pju localpju = (pju)paramContainer.findViewBaseByName("id_partner_info_avator");
    if (localpju != null) {
      localpju.a(parampau);
    }
    paramContainer = (pmg)paramContainer.findViewBaseByName(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pjm
 * JD-Core Version:    0.7.0.1
 */