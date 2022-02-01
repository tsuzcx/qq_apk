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

public class puz
  implements pye
{
  private void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, sel paramsel)
  {
    int i = a(paramArticleInfo, paramsel);
    paramsel = paramsel.a();
    if (paramsel != null) {
      paramsel.a(paramContext, paramArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void a(Context paramContext, ppu paramppu, int paramInt)
  {
    sgc localsgc = paramppu.a().a();
    paramppu = paramppu.a();
    if ((paramppu != null) && (localsgc != null)) {
      localsgc.a(paramContext, paramppu, 0, paramppu.innerUniqueID, 6, paramInt, 0);
    }
  }
  
  private void a(ViewBase paramViewBase, ppu paramppu)
  {
    if ((paramViewBase == null) || (paramppu == null) || (paramppu.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    sel localsel = paramppu.a();
    paramViewBase.getNativeView().setOnClickListener(new pvg(this, localsel, paramppu));
  }
  
  private View b(int paramInt, Context paramContext, ppu paramppu)
  {
    paramppu = paramppu.a();
    if ((paramppu != null) && (paramppu.mSocialFeedInfo != null) && (paramppu.mSocialFeedInfo.jdField_a_of_type_Qyg != null) && (paramppu.mSocialFeedInfo.jdField_a_of_type_Qyg.a != null) && (paramppu.mSocialFeedInfo.jdField_a_of_type_Qyg.a.size() > 0) && (ComponentContentGridImage.a(paramppu.mSocialFeedInfo.jdField_a_of_type_Qyg.a.size(), paramppu.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void b(int paramInt1, ppu paramppu, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = paramppu.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.a != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.a.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.a.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, paramppu, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    if ((paramNativeMiddleBodyView.a() instanceof ComponentContentGridImage))
    {
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramppu, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(paramppu);
      paramNativeMiddleBodyView.setGalleryClickListener(new pve(this, paramppu, paramContainer, paramInt2));
      return;
    }
    QLog.e("BiuPgcProteusItem", 1, "[bindGalleryBodyView] unexpected item: " + paramInt1 + " " + paramppu.a());
  }
  
  private void c(int paramInt1, ppu paramppu, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if (!(paramNativeMiddleBodyView.a() instanceof AdapterView)) {
      paramNativeMiddleBodyView.a().setOnClickListener(new pvf(this, paramppu, paramContainer, paramInt2));
    }
    ((qjg)paramNativeMiddleBodyView.a()).a(paramppu);
  }
  
  public int a(ArticleInfo paramArticleInfo, sel paramsel)
  {
    return oxw.a(paramsel.a(), ozs.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, ppu paramppu)
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
      return b(paramInt, paramContext, paramppu);
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
    Object localObject = new ptl();
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.a;
      }
    }
    if ((paramInt == 35) && (!paramBaseArticleInfo.isPGCShortContent())) {
      ((ptl)localObject).c(paramBaseArticleInfo, anzj.a(2131700066));
    }
    if (paramInt == 33) {
      ((ptl)localObject).c(paramBaseArticleInfo, anzj.a(2131700067));
    }
    if (paramInt != 33) {
      ((ptl)localObject).z(paramBaseArticleInfo).C(paramBaseArticleInfo).A(paramBaseArticleInfo);
    }
    if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95))
    {
      ((ptl)localObject).n(paramBaseArticleInfo);
      ((ptl)localObject).a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").j(paramBaseArticleInfo).h(paramBaseArticleInfo).i(paramBaseArticleInfo).m(paramBaseArticleInfo).l(paramBaseArticleInfo).B(paramBaseArticleInfo).q(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).F(paramBaseArticleInfo).D(paramBaseArticleInfo).r(paramBaseArticleInfo).k(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).t(paramBaseArticleInfo);
      if (paramInt != 112) {
        ((ptl)localObject).y(paramBaseArticleInfo);
      }
      if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95)) {
        break label343;
      }
      ((ptl)localObject).a("ReadInjoy_biu_small_pgc_cell");
      label282:
      localObject = ((ptl)localObject).a();
      if (!((JSONObject)localObject).optString("style_ID").equals("ReadInjoy_biu_cell")) {
        break label377;
      }
      tqg.a(paramBaseArticleInfo, (JSONObject)localObject, 2);
    }
    label343:
    label377:
    while (!((JSONObject)localObject).optString("style_ID").equals("ReadInjoy_biu_small_pgc_cell"))
    {
      return localObject;
      if ((!paramBaseArticleInfo.mSocialFeedInfo.a()) || (oxs.b(paramBaseArticleInfo))) {
        break;
      }
      ((ptl)localObject).n(paramBaseArticleInfo);
      break;
      if (qao.a((ArticleInfo)paramBaseArticleInfo))
      {
        ((ptl)localObject).a("RIJ_biu_small_single_img_cell");
        break label282;
      }
      ((ptl)localObject).a("RIJ_biu_cell");
      break label282;
    }
    tqg.a(paramBaseArticleInfo, (JSONObject)localObject, 1);
    return localObject;
  }
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    qcb localqcb = (qcb)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    if (localqcb != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localqcb.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), paramppu);
        if ((localView instanceof PgcSmallView))
        {
          QLog.d("BiuPgcProteusItem", 2, "bindView | setTitleCustomStyle");
          ((PgcSmallView)localView).setTitleCustomStyle(localqcb.a(), localqcb.b(), localqcb.d(), localqcb.c());
        }
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label364;
        }
      }
    }
    label364:
    for (Object localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();; localObject = new RelativeLayout.LayoutParams(-2, -2))
    {
      localqcb.a((RelativeLayout.LayoutParams)localObject);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, (RelativeLayout.LayoutParams)localObject);
      }
      a(paramInt1, paramppu, localNativeMiddleBodyView, paramInt2, paramContainer);
      qdk.e(localViewBase, paramppu);
      localObject = (qax)localViewBase.findViewBaseByName("id_biu_comment");
      if (localObject != null) {
        ((qax)localObject).a(paramppu);
      }
      localObject = (qdg)localViewBase.findViewBaseByName("id_summary");
      if (localObject != null)
      {
        ((qdg)localObject).a(paramppu);
        if ((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) {
          ((qdg)localObject).setOnClickListener(new pva(this, paramContainer, paramppu, paramInt2));
        }
      }
      localObject = localViewBase.findViewBaseByName("id_social_bottom");
      if (((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) && (localObject != null) && (((ViewBase)localObject).getNativeView() != null)) {
        ((ViewBase)localObject).getNativeView().setOnClickListener(new pvb(this, paramContainer, paramppu, paramInt2));
      }
      qdk.a(localViewBase, paramppu.a());
      a(localViewBase, paramppu);
      puo.a(localViewBase, paramppu);
      puo.b(localViewBase, paramppu);
      qdk.a(localViewBase, paramppu);
      qdk.b(localViewBase, paramppu);
      qdk.c(localViewBase, paramppu);
      tqg.a(paramppu, localViewBase, paramContainer, paramInt1);
      return;
    }
  }
  
  protected void a(int paramInt1, ppu paramppu, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (paramppu.a() == null)) {
      return;
    }
    sel localsel = paramppu.a();
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt1);
    case 35: 
    case 114: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramppu, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(paramppu);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new pvc(this, paramppu));
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
        agej.a("BiuPgcProteusItem", "", new IllegalArgumentException(" adapterViewType " + paramInt1 + " articleInfo : " + paramppu.a()));
        return;
      }
      paramNativeMiddleBodyView.a().setOnClickListener(new pvd(this, localsel, paramppu));
      ((qjg)paramNativeMiddleBodyView.a()).a(paramppu);
      return;
    }
    b(paramInt1, paramppu, paramNativeMiddleBodyView, paramInt2, paramContainer);
  }
  
  public boolean a(int paramInt, Container paramContainer, ppu paramppu, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     puz
 * JD-Core Version:    0.7.0.1
 */