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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import org.json.JSONObject;

public class qat
  implements qdy
{
  private void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, slt paramslt)
  {
    int i = a(paramArticleInfo, paramslt);
    paramslt = paramslt.a().a();
    if (paramslt != null) {
      paramslt.a(paramContext, paramArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void a(Context paramContext, pvc parampvc, int paramInt)
  {
    peq localpeq = parampvc.a().a().a();
    parampvc = parampvc.a();
    if ((parampvc != null) && (localpeq != null)) {
      localpeq.a(paramContext, parampvc, 0, parampvc.innerUniqueID, 6, paramInt, 0);
    }
  }
  
  private void a(ViewBase paramViewBase, pvc parampvc)
  {
    if ((paramViewBase == null) || (parampvc == null) || (parampvc.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    slt localslt = parampvc.a();
    paramViewBase.getNativeView().setOnClickListener(new qba(this, localslt, parampvc));
  }
  
  private View b(int paramInt, Context paramContext, pvc parampvc)
  {
    parampvc = parampvc.a();
    if ((parampvc != null) && (parampvc.mSocialFeedInfo != null) && (parampvc.mSocialFeedInfo.jdField_a_of_type_Rfe != null) && (parampvc.mSocialFeedInfo.jdField_a_of_type_Rfe.a != null) && (parampvc.mSocialFeedInfo.jdField_a_of_type_Rfe.a.size() > 0) && (ComponentContentGridImage.a(parampvc.mSocialFeedInfo.jdField_a_of_type_Rfe.a.size(), parampvc.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void b(int paramInt1, pvc parampvc, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = parampvc.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.a != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.a.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.a.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, parampvc, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    if ((paramNativeMiddleBodyView.a() instanceof ComponentContentGridImage))
    {
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampvc, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(parampvc);
      paramNativeMiddleBodyView.setGalleryClickListener(new qay(this, parampvc, paramContainer, paramInt2));
      return;
    }
    QLog.e("BiuPgcProteusItem", 1, "[bindGalleryBodyView] unexpected item: " + paramInt1 + " " + parampvc.a());
  }
  
  private void c(int paramInt1, pvc parampvc, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if (!(paramNativeMiddleBodyView.a() instanceof AdapterView)) {
      paramNativeMiddleBodyView.a().setOnClickListener(new qaz(this, parampvc, paramContainer, paramInt2));
    }
    ((qpj)paramNativeMiddleBodyView.a()).a(parampvc);
  }
  
  public int a(ArticleInfo paramArticleInfo, slt paramslt)
  {
    return ozb.a(paramslt.a(), pay.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, pvc parampvc)
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
      return b(paramInt, paramContext, parampvc);
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
    pzf localpzf = new pzf();
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.a;
      }
    }
    if ((paramInt == 35) && (!paramBaseArticleInfo.isPGCShortContent())) {
      localpzf.c(paramBaseArticleInfo, amtj.a(2131700301));
    }
    if (paramInt == 33) {
      localpzf.c(paramBaseArticleInfo, amtj.a(2131700302));
    }
    if (paramInt != 33) {
      localpzf.z(paramBaseArticleInfo).C(paramBaseArticleInfo).A(paramBaseArticleInfo);
    }
    if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95))
    {
      localpzf.n(paramBaseArticleInfo);
      localpzf.a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").j(paramBaseArticleInfo).h(paramBaseArticleInfo).i(paramBaseArticleInfo).m(paramBaseArticleInfo).l(paramBaseArticleInfo).B(paramBaseArticleInfo).q(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).F(paramBaseArticleInfo).D(paramBaseArticleInfo).r(paramBaseArticleInfo).k(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).t(paramBaseArticleInfo);
      if (paramInt != 112) {
        localpzf.y(paramBaseArticleInfo);
      }
      if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95)) {
        break label315;
      }
      localpzf.a("ReadInjoy_biu_small_pgc_cell");
    }
    for (;;)
    {
      return localpzf.a();
      if ((!paramBaseArticleInfo.mSocialFeedInfo.a()) || (oyx.b(paramBaseArticleInfo))) {
        break;
      }
      localpzf.n(paramBaseArticleInfo);
      break;
      label315:
      if (qgi.a((ArticleInfo)paramBaseArticleInfo)) {
        localpzf.a("RIJ_biu_small_single_img_cell");
      } else {
        localpzf.a("RIJ_biu_cell");
      }
    }
  }
  
  public void a(int paramInt1, Container paramContainer, pvc parampvc, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    qhz localqhz = (qhz)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    if (localqhz != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localqhz.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), parampvc);
        if ((localView instanceof PgcSmallView))
        {
          QLog.d("BiuPgcProteusItem", 2, "bindView | setTitleCustomStyle");
          ((PgcSmallView)localView).setTitleCustomStyle(localqhz.a(), localqhz.b(), localqhz.d(), localqhz.c());
        }
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label356;
        }
      }
    }
    label356:
    for (Object localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();; localObject = new RelativeLayout.LayoutParams(-2, -2))
    {
      localqhz.a((RelativeLayout.LayoutParams)localObject);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, (RelativeLayout.LayoutParams)localObject);
      }
      a(paramInt1, parampvc, localNativeMiddleBodyView, paramInt2, paramContainer);
      qji.e(localViewBase, parampvc);
      localObject = (qgv)localViewBase.findViewBaseByName("id_biu_comment");
      if (localObject != null) {
        ((qgv)localObject).a(parampvc);
      }
      localObject = (qje)localViewBase.findViewBaseByName("id_summary");
      if (localObject != null)
      {
        ((qje)localObject).a(parampvc);
        if ((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) {
          ((qje)localObject).setOnClickListener(new qau(this, paramContainer, parampvc, paramInt2));
        }
      }
      localObject = localViewBase.findViewBaseByName("id_social_bottom");
      if (((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) && (localObject != null) && (((ViewBase)localObject).getNativeView() != null)) {
        ((ViewBase)localObject).getNativeView().setOnClickListener(new qav(this, paramContainer, parampvc, paramInt2));
      }
      qji.a(localViewBase, parampvc.a());
      a(localViewBase, parampvc);
      qai.a(localViewBase, parampvc);
      qai.b(localViewBase, parampvc);
      qji.a(localViewBase, parampvc);
      qji.b(localViewBase, parampvc);
      qji.c(localViewBase, parampvc);
      return;
    }
  }
  
  protected void a(int paramInt1, pvc parampvc, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampvc.a() == null)) {
      return;
    }
    slt localslt = parampvc.a();
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt1);
    case 35: 
    case 114: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampvc, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(parampvc);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new qaw(this, parampvc));
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
        AIOUtils.catchedExceptionInReleaseV2("BiuPgcProteusItem", "", new IllegalArgumentException(" adapterViewType " + paramInt1 + " articleInfo : " + parampvc.a()));
        return;
      }
      paramNativeMiddleBodyView.a().setOnClickListener(new qax(this, localslt, parampvc));
      ((qpj)paramNativeMiddleBodyView.a()).a(parampvc);
      return;
    }
    b(paramInt1, parampvc, paramNativeMiddleBodyView, paramInt2, paramContainer);
  }
  
  public boolean a(int paramInt, Container paramContainer, pvc parampvc, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qat
 * JD-Core Version:    0.7.0.1
 */