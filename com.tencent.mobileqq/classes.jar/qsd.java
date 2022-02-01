import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class qsd
{
  public static void a(Container paramContainer, qfw paramqfw)
  {
    a(paramContainer, paramqfw, "id_nickname");
  }
  
  public static void a(Container paramContainer, qfw paramqfw, String paramString)
  {
    ArticleInfo localArticleInfo = paramqfw.a();
    paramContainer = paramContainer.getVirtualView();
    qsw localqsw = (qsw)paramContainer.findViewBaseByName("id_partner_info_avator");
    if (localqsw != null) {
      localqsw.a(paramqfw);
    }
    paramContainer = (qve)paramContainer.findViewBaseByName(paramString);
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
 * Qualified Name:     qsd
 * JD-Core Version:    0.7.0.1
 */