import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class qhv
{
  public static void a(Container paramContainer, pxk parampxk)
  {
    a(paramContainer, parampxk, "id_nickname");
  }
  
  public static void a(Container paramContainer, pxk parampxk, String paramString)
  {
    ArticleInfo localArticleInfo = parampxk.a();
    paramContainer = paramContainer.getVirtualView();
    qij localqij = (qij)paramContainer.findViewBaseByName("id_partner_info_avator");
    if (localqij != null) {
      localqij.a(parampxk);
    }
    paramContainer = (qkq)paramContainer.findViewBaseByName(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qhv
 * JD-Core Version:    0.7.0.1
 */