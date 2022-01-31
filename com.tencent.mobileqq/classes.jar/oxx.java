import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class oxx
{
  public static void a(Container paramContainer, opw paramopw)
  {
    a(paramContainer, paramopw, "id_nickname");
  }
  
  public static void a(Container paramContainer, opw paramopw, String paramString)
  {
    ArticleInfo localArticleInfo = paramopw.a();
    paramContainer = paramContainer.getVirtualView();
    oyf localoyf = (oyf)paramContainer.findViewBaseByName("id_partner_info_avator");
    if (localoyf != null) {
      localoyf.a(paramopw);
    }
    paramContainer = (par)paramContainer.findViewBaseByName(paramString);
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
 * Qualified Name:     oxx
 * JD-Core Version:    0.7.0.1
 */