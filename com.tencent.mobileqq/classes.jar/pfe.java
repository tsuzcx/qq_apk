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

public class pfe
  implements phs
{
  private void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, rap paramrap)
  {
    int i = a(paramArticleInfo, paramrap);
    paramrap = paramrap.a();
    if (paramrap != null) {
      paramrap.a(paramContext, paramArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void a(Context paramContext, pax parampax, int paramInt)
  {
    rbr localrbr = parampax.a().a();
    parampax = parampax.a();
    if ((parampax != null) && (localrbr != null)) {
      localrbr.a(paramContext, parampax, 0, parampax.innerUniqueID, 6, paramInt, 0);
    }
  }
  
  private void a(ViewBase paramViewBase, pax parampax)
  {
    if ((paramViewBase == null) || (parampax == null) || (parampax.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    rap localrap = parampax.a();
    paramViewBase.getNativeView().setOnClickListener(new pfl(this, localrap, parampax));
  }
  
  private View b(int paramInt, Context paramContext, pax parampax)
  {
    parampax = parampax.a();
    if ((parampax != null) && (parampax.mSocialFeedInfo != null) && (parampax.mSocialFeedInfo.jdField_a_of_type_Qcy != null) && (parampax.mSocialFeedInfo.jdField_a_of_type_Qcy.a != null) && (parampax.mSocialFeedInfo.jdField_a_of_type_Qcy.a.size() > 0) && (ComponentContentGridImage.a(parampax.mSocialFeedInfo.jdField_a_of_type_Qcy.a.size(), parampax.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void b(int paramInt1, pax parampax, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = parampax.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.a != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.a.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.a.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, parampax, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    if ((paramNativeMiddleBodyView.a() instanceof ComponentContentGridImage))
    {
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampax, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(parampax);
      paramNativeMiddleBodyView.setGalleryClickListener(new pfj(this, parampax, paramContainer, paramInt2));
      return;
    }
    QLog.e("BiuPgcProteusItem", 1, "[bindGalleryBodyView] unexpected item: " + paramInt1 + " " + parampax.a());
  }
  
  private void c(int paramInt1, pax parampax, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if (!(paramNativeMiddleBodyView.a() instanceof AdapterView)) {
      paramNativeMiddleBodyView.a().setOnClickListener(new pfk(this, parampax, paramContainer, paramInt2));
    }
    ((pqs)paramNativeMiddleBodyView.a()).a(parampax);
  }
  
  public int a(ArticleInfo paramArticleInfo, rap paramrap)
  {
    return olg.a(paramrap.a(), onk.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, pax parampax)
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
      return b(paramInt, paramContext, parampax);
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
    pdp localpdp = new pdp();
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl.a;
      }
    }
    if ((paramInt == 35) && (!paramBaseArticleInfo.isPGCShortContent())) {
      localpdp.b(paramBaseArticleInfo, ajyc.a(2131701143));
    }
    if (paramInt == 33) {
      localpdp.b(paramBaseArticleInfo, ajyc.a(2131701144));
    }
    if (paramInt != 33) {
      localpdp.A(paramBaseArticleInfo).D(paramBaseArticleInfo).B(paramBaseArticleInfo);
    }
    if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95))
    {
      localpdp.o(paramBaseArticleInfo);
      localpdp.a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").k(paramBaseArticleInfo).j(paramBaseArticleInfo).n(paramBaseArticleInfo).m(paramBaseArticleInfo).C(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).G(paramBaseArticleInfo).E(paramBaseArticleInfo).s(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
      if (paramInt != 112) {
        localpdp.z(paramBaseArticleInfo);
      }
      if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95)) {
        break label311;
      }
      localpdp.a("ReadInjoy_biu_small_pgc_cell");
    }
    for (;;)
    {
      return localpdp.a();
      if ((!paramBaseArticleInfo.mSocialFeedInfo.a()) || (olc.b(paramBaseArticleInfo))) {
        break;
      }
      localpdp.o(paramBaseArticleInfo);
      break;
      label311:
      localpdp.a("ReadInjoy_biu_cell");
    }
  }
  
  public void a(int paramInt1, Container paramContainer, pax parampax, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    pll localpll = (pll)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    Object localObject;
    if (localpll != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localpll.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), parampax);
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label329;
        }
        localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      }
    }
    for (;;)
    {
      localpll.a((RelativeLayout.LayoutParams)localObject);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, (RelativeLayout.LayoutParams)localObject);
      }
      a(paramInt1, parampax, localNativeMiddleBodyView, paramInt2, paramContainer);
      localObject = (pjx)localViewBase.findViewBaseByName("id_info_avator");
      if (localObject != null) {
        ((pjx)localObject).a(parampax);
      }
      localObject = (pjz)localViewBase.findViewBaseByName("id_biu_comment");
      if (localObject != null) {
        ((pjz)localObject).a(parampax);
      }
      localObject = (pmn)localViewBase.findViewBaseByName("id_summary");
      if (localObject != null)
      {
        ((pmn)localObject).a(parampax);
        if ((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) {
          ((pmn)localObject).setOnClickListener(new pff(this, paramContainer, parampax, paramInt2));
        }
      }
      localObject = localViewBase.findViewBaseByName("id_social_bottom");
      if (((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) && (localObject != null) && (((ViewBase)localObject).getNativeView() != null)) {
        ((ViewBase)localObject).getNativeView().setOnClickListener(new pfg(this, paramContainer, parampax, paramInt2));
      }
      pmr.a(localViewBase, parampax.a());
      a(localViewBase, parampax);
      pen.a(localViewBase, parampax);
      pen.b(localViewBase, parampax);
      pmr.a(localViewBase, parampax);
      pmr.b(localViewBase, parampax);
      pmr.c(localViewBase, parampax);
      return;
      label329:
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).setMargins(bbkx.a(12.0F), 0, bbkx.a(12.0F), 0);
    }
  }
  
  protected void a(int paramInt1, pax parampax, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampax.a() == null)) {
      return;
    }
    rap localrap = parampax.a();
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt1);
    case 35: 
    case 114: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampax, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(parampax);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new pfh(this, parampax));
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
        actn.a("BiuPgcProteusItem", "", new IllegalArgumentException(" adapterViewType " + paramInt1 + " articleInfo : " + parampax.a()));
        return;
      }
      paramNativeMiddleBodyView.a().setOnClickListener(new pfi(this, localrap, parampax));
      ((pqs)paramNativeMiddleBodyView.a()).a(parampax);
      return;
    }
    b(paramInt1, parampax, paramNativeMiddleBodyView, paramInt2, paramContainer);
  }
  
  public boolean a(int paramInt, Container paramContainer, pax parampax, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pfe
 * JD-Core Version:    0.7.0.1
 */