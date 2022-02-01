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

public class qco
  implements qft
{
  private void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, snh paramsnh)
  {
    int i = a(paramArticleInfo, paramsnh);
    paramsnh = paramsnh.a();
    if (paramsnh != null) {
      paramsnh.a(paramContext, paramArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void a(Context paramContext, pxk parampxk, int paramInt)
  {
    soy localsoy = parampxk.a().a();
    parampxk = parampxk.a();
    if ((parampxk != null) && (localsoy != null)) {
      localsoy.a(paramContext, parampxk, 0, parampxk.innerUniqueID, 6, paramInt, 0);
    }
  }
  
  private void a(ViewBase paramViewBase, pxk parampxk)
  {
    if ((paramViewBase == null) || (parampxk == null) || (parampxk.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    snh localsnh = parampxk.a();
    paramViewBase.getNativeView().setOnClickListener(new qcv(this, localsnh, parampxk));
  }
  
  private View b(int paramInt, Context paramContext, pxk parampxk)
  {
    parampxk = parampxk.a();
    if ((parampxk != null) && (parampxk.mSocialFeedInfo != null) && (parampxk.mSocialFeedInfo.jdField_a_of_type_Rhn != null) && (parampxk.mSocialFeedInfo.jdField_a_of_type_Rhn.a != null) && (parampxk.mSocialFeedInfo.jdField_a_of_type_Rhn.a.size() > 0) && (ComponentContentGridImage.a(parampxk.mSocialFeedInfo.jdField_a_of_type_Rhn.a.size(), parampxk.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void b(int paramInt1, pxk parampxk, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = parampxk.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.a != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.a.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.a.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, parampxk, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    if ((paramNativeMiddleBodyView.a() instanceof ComponentContentGridImage))
    {
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampxk, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(parampxk);
      paramNativeMiddleBodyView.setGalleryClickListener(new qct(this, parampxk, paramContainer, paramInt2));
      return;
    }
    QLog.e("BiuPgcProteusItem", 1, "[bindGalleryBodyView] unexpected item: " + paramInt1 + " " + parampxk.a());
  }
  
  private void c(int paramInt1, pxk parampxk, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if (!(paramNativeMiddleBodyView.a() instanceof AdapterView)) {
      paramNativeMiddleBodyView.a().setOnClickListener(new qcu(this, parampxk, paramContainer, paramInt2));
    }
    ((qqs)paramNativeMiddleBodyView.a()).a(parampxk);
  }
  
  public int a(ArticleInfo paramArticleInfo, snh paramsnh)
  {
    return pfe.a(paramsnh.a(), pha.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, pxk parampxk)
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
      return b(paramInt, paramContext, parampxk);
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
    Object localObject = new qba();
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha.a;
      }
    }
    if ((paramInt == 35) && (!paramBaseArticleInfo.isPGCShortContent())) {
      ((qba)localObject).c(paramBaseArticleInfo, anni.a(2131699959));
    }
    if (paramInt == 33) {
      ((qba)localObject).c(paramBaseArticleInfo, anni.a(2131699960));
    }
    if (paramInt != 33) {
      ((qba)localObject).z(paramBaseArticleInfo).C(paramBaseArticleInfo).A(paramBaseArticleInfo);
    }
    if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95))
    {
      ((qba)localObject).n(paramBaseArticleInfo);
      ((qba)localObject).a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").j(paramBaseArticleInfo).h(paramBaseArticleInfo).i(paramBaseArticleInfo).m(paramBaseArticleInfo).l(paramBaseArticleInfo).B(paramBaseArticleInfo).q(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).F(paramBaseArticleInfo).D(paramBaseArticleInfo).r(paramBaseArticleInfo).k(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).t(paramBaseArticleInfo);
      if (paramInt != 112) {
        ((qba)localObject).y(paramBaseArticleInfo);
      }
      if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95)) {
        break label343;
      }
      ((qba)localObject).a("ReadInjoy_biu_small_pgc_cell");
      label282:
      localObject = ((qba)localObject).a();
      if (!((JSONObject)localObject).optString("style_ID").equals("ReadInjoy_biu_cell")) {
        break label377;
      }
      oqp.a(paramBaseArticleInfo, (JSONObject)localObject, 2);
    }
    label343:
    label377:
    while (!((JSONObject)localObject).optString("style_ID").equals("ReadInjoy_biu_small_pgc_cell"))
    {
      return localObject;
      if ((!paramBaseArticleInfo.mSocialFeedInfo.a()) || (pfa.b(paramBaseArticleInfo))) {
        break;
      }
      ((qba)localObject).n(paramBaseArticleInfo);
      break;
      if (qic.a((ArticleInfo)paramBaseArticleInfo))
      {
        ((qba)localObject).a("RIJ_biu_small_single_img_cell");
        break label282;
      }
      ((qba)localObject).a("RIJ_biu_cell");
      break label282;
    }
    oqp.a(paramBaseArticleInfo, (JSONObject)localObject, 1);
    return localObject;
  }
  
  public void a(int paramInt1, Container paramContainer, pxk parampxk, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    qjp localqjp = (qjp)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    if (localqjp != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localqjp.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), parampxk);
        if ((localView instanceof PgcSmallView))
        {
          QLog.d("BiuPgcProteusItem", 2, "bindView | setTitleCustomStyle");
          ((PgcSmallView)localView).setTitleCustomStyle(localqjp.a(), localqjp.b(), localqjp.d(), localqjp.c());
        }
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label364;
        }
      }
    }
    label364:
    for (Object localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();; localObject = new RelativeLayout.LayoutParams(-2, -2))
    {
      localqjp.a((RelativeLayout.LayoutParams)localObject);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, (RelativeLayout.LayoutParams)localObject);
      }
      a(paramInt1, parampxk, localNativeMiddleBodyView, paramInt2, paramContainer);
      qky.e(localViewBase, parampxk);
      localObject = (qil)localViewBase.findViewBaseByName("id_biu_comment");
      if (localObject != null) {
        ((qil)localObject).a(parampxk);
      }
      localObject = (qku)localViewBase.findViewBaseByName("id_summary");
      if (localObject != null)
      {
        ((qku)localObject).a(parampxk);
        if ((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) {
          ((qku)localObject).setOnClickListener(new qcp(this, paramContainer, parampxk, paramInt2));
        }
      }
      localObject = localViewBase.findViewBaseByName("id_social_bottom");
      if (((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) && (localObject != null) && (((ViewBase)localObject).getNativeView() != null)) {
        ((ViewBase)localObject).getNativeView().setOnClickListener(new qcq(this, paramContainer, parampxk, paramInt2));
      }
      qky.a(localViewBase, parampxk.a());
      a(localViewBase, parampxk);
      qcd.a(localViewBase, parampxk);
      qcd.b(localViewBase, parampxk);
      qky.a(localViewBase, parampxk);
      qky.b(localViewBase, parampxk);
      qky.c(localViewBase, parampxk);
      oqp.a(parampxk, localViewBase, paramContainer, paramInt1);
      return;
    }
  }
  
  protected void a(int paramInt1, pxk parampxk, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampxk.a() == null)) {
      return;
    }
    snh localsnh = parampxk.a();
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt1);
    case 35: 
    case 114: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampxk, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(parampxk);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new qcr(this, parampxk));
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
        afur.a("BiuPgcProteusItem", "", new IllegalArgumentException(" adapterViewType " + paramInt1 + " articleInfo : " + parampxk.a()));
        return;
      }
      paramNativeMiddleBodyView.a().setOnClickListener(new qcs(this, localsnh, parampxk));
      ((qqs)paramNativeMiddleBodyView.a()).a(parampxk);
      return;
    }
    b(paramInt1, parampxk, paramNativeMiddleBodyView, paramInt2, paramContainer);
  }
  
  public boolean a(int paramInt, Container paramContainer, pxk parampxk, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qco
 * JD-Core Version:    0.7.0.1
 */