import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class qga
{
  public static void a(Container paramContainer, pvc parampvc)
  {
    a(paramContainer, parampvc, "id_nickname");
  }
  
  public static void a(Container paramContainer, pvc parampvc, String paramString)
  {
    ArticleInfo localArticleInfo = parampvc.a();
    paramContainer = paramContainer.getVirtualView();
    qgt localqgt = (qgt)paramContainer.findViewBaseByName("id_partner_info_avator");
    if (localqgt != null) {
      localqgt.a(parampvc);
    }
    paramContainer = (qja)paramContainer.findViewBaseByName(paramString);
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
 * Qualified Name:     qga
 * JD-Core Version:    0.7.0.1
 */