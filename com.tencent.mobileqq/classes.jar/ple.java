import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentPgcVideo;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import org.json.JSONObject;

public class ple
  implements poa
{
  private void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, rqj paramrqj)
  {
    int i = a(paramArticleInfo, paramrqj);
    paramrqj = paramrqj.a();
    if (paramrqj != null) {
      paramrqj.a(paramContext, paramArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void a(Context paramContext, pgd parampgd, int paramInt)
  {
    rrl localrrl = parampgd.a().a();
    parampgd = parampgd.a();
    if ((parampgd != null) && (localrrl != null)) {
      localrrl.a(paramContext, parampgd, 0, parampgd.innerUniqueID, 6, paramInt, 0);
    }
  }
  
  private void a(ViewBase paramViewBase, pgd parampgd)
  {
    if ((paramViewBase == null) || (parampgd == null) || (parampgd.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    rqj localrqj = parampgd.a();
    paramViewBase.getNativeView().setOnClickListener(new pll(this, localrqj, parampgd));
  }
  
  private View b(int paramInt, Context paramContext, pgd parampgd)
  {
    parampgd = parampgd.a();
    if ((parampgd != null) && (parampgd.mSocialFeedInfo != null) && (parampgd.mSocialFeedInfo.jdField_a_of_type_Qmr != null) && (parampgd.mSocialFeedInfo.jdField_a_of_type_Qmr.a != null) && (parampgd.mSocialFeedInfo.jdField_a_of_type_Qmr.a.size() > 0) && (ComponentContentGridImage.a(parampgd.mSocialFeedInfo.jdField_a_of_type_Qmr.a.size(), parampgd.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void b(int paramInt1, pgd parampgd, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = parampgd.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.a != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.a.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.a.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, parampgd, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    if ((paramNativeMiddleBodyView.a() instanceof ComponentContentGridImage))
    {
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampgd, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(parampgd);
      paramNativeMiddleBodyView.setGalleryClickListener(new plj(this, parampgd, paramContainer, paramInt2));
      return;
    }
    QLog.e("BiuPgcProteusItem", 1, "[bindGalleryBodyView] unexpected item: " + paramInt1 + " " + parampgd.a());
  }
  
  private void c(int paramInt1, pgd parampgd, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if (!(paramNativeMiddleBodyView.a() instanceof AdapterView)) {
      paramNativeMiddleBodyView.a().setOnClickListener(new plk(this, parampgd, paramContainer, paramInt2));
    }
    ((pxk)paramNativeMiddleBodyView.a()).a(parampgd);
  }
  
  public int a(ArticleInfo paramArticleInfo, rqj paramrqj)
  {
    return opn.a(paramrqj.a(), ors.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, pgd parampgd)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 35: 
    case 114: 
      return new ComponentContentGridImage(paramContext);
    case 49: 
    case 62: 
    case 63: 
      return b(paramInt, paramContext, parampgd);
    case 10: 
    case 12: 
    case 94: 
    case 95: 
      return new PgcSmallView(paramInt, paramContext);
    case 11: 
    case 28: 
      return new ComponentContentPgcVideo(paramContext);
    case 27: 
      return new ComponentContentBig(paramContext);
    case 113: 
      return new ComponentPGCShortContentBig(paramContext);
    case 33: 
      return new ComponentContentBig(paramContext);
    }
    return null;
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    pjo localpjo = new pjo();
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.a;
      }
    }
    if ((paramInt == 35) && (!paramBaseArticleInfo.isPGCShortContent())) {
      localpjo.c(paramBaseArticleInfo, alpo.a(2131701523));
    }
    if (paramInt == 33) {
      localpjo.c(paramBaseArticleInfo, alpo.a(2131701524));
    }
    if (paramInt != 33) {
      localpjo.A(paramBaseArticleInfo).D(paramBaseArticleInfo).B(paramBaseArticleInfo);
    }
    if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95))
    {
      localpjo.o(paramBaseArticleInfo);
      localpjo.a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").k(paramBaseArticleInfo).j(paramBaseArticleInfo).n(paramBaseArticleInfo).m(paramBaseArticleInfo).C(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).G(paramBaseArticleInfo).E(paramBaseArticleInfo).s(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
      if (paramInt != 112) {
        localpjo.z(paramBaseArticleInfo);
      }
      if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95)) {
        break label311;
      }
      localpjo.a("ReadInjoy_biu_small_pgc_cell");
    }
    for (;;)
    {
      return localpjo.a();
      if ((!paramBaseArticleInfo.mSocialFeedInfo.a()) || (opj.b(paramBaseArticleInfo))) {
        break;
      }
      localpjo.o(paramBaseArticleInfo);
      break;
      label311:
      localpjo.a("ReadInjoy_biu_cell");
    }
  }
  
  public void a(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    prm localprm = (prm)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    Object localObject;
    if (localprm != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localprm.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), parampgd);
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label329;
        }
        localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      }
    }
    for (;;)
    {
      localprm.a((RelativeLayout.LayoutParams)localObject);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, (RelativeLayout.LayoutParams)localObject);
      }
      a(paramInt1, parampgd, localNativeMiddleBodyView, paramInt2, paramContainer);
      localObject = (pqg)localViewBase.findViewBaseByName("id_info_avator");
      if (localObject != null) {
        ((pqg)localObject).a(parampgd);
      }
      localObject = (pqi)localViewBase.findViewBaseByName("id_biu_comment");
      if (localObject != null) {
        ((pqi)localObject).a(parampgd);
      }
      localObject = (pss)localViewBase.findViewBaseByName("id_summary");
      if (localObject != null)
      {
        ((pss)localObject).a(parampgd);
        if ((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) {
          ((pss)localObject).setOnClickListener(new plf(this, paramContainer, parampgd, paramInt2));
        }
      }
      localObject = localViewBase.findViewBaseByName("id_social_bottom");
      if (((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) && (localObject != null) && (((ViewBase)localObject).getNativeView() != null)) {
        ((ViewBase)localObject).getNativeView().setOnClickListener(new plg(this, paramContainer, parampgd, paramInt2));
      }
      psw.a(localViewBase, parampgd.a());
      a(localViewBase, parampgd);
      pkm.a(localViewBase, parampgd);
      pkm.b(localViewBase, parampgd);
      psw.a(localViewBase, parampgd);
      psw.b(localViewBase, parampgd);
      psw.c(localViewBase, parampgd);
      return;
      label329:
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).setMargins(bdkf.a(12.0F), 0, bdkf.a(12.0F), 0);
    }
  }
  
  protected void a(int paramInt1, pgd parampgd, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampgd.a() == null)) {
      return;
    }
    rqj localrqj = parampgd.a();
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt1);
    case 35: 
    case 114: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampgd, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(parampgd);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new plh(this, parampgd));
      return;
    case 10: 
    case 11: 
    case 12: 
    case 27: 
    case 28: 
    case 33: 
    case 94: 
    case 95: 
    case 112: 
    case 113: 
      if ((paramNativeMiddleBodyView.a() instanceof AdapterView))
      {
        aekt.a("BiuPgcProteusItem", "", new IllegalArgumentException(" adapterViewType " + paramInt1 + " articleInfo : " + parampgd.a()));
        return;
      }
      paramNativeMiddleBodyView.a().setOnClickListener(new pli(this, localrqj, parampgd));
      ((pxk)paramNativeMiddleBodyView.a()).a(parampgd);
      return;
    }
    b(paramInt1, parampgd, paramNativeMiddleBodyView, paramInt2, paramContainer);
  }
  
  public boolean a(int paramInt, Container paramContainer, pgd parampgd, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ple
 * JD-Core Version:    0.7.0.1
 */