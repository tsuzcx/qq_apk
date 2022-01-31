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

public class pfb
  implements php
{
  private void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, ram paramram)
  {
    int i = a(paramArticleInfo, paramram);
    paramram = paramram.a();
    if (paramram != null) {
      paramram.a(paramContext, paramArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void a(Context paramContext, pau parampau, int paramInt)
  {
    rbo localrbo = parampau.a().a();
    parampau = parampau.a();
    if ((parampau != null) && (localrbo != null)) {
      localrbo.a(paramContext, parampau, 0, parampau.innerUniqueID, 6, paramInt, 0);
    }
  }
  
  private void a(ViewBase paramViewBase, pau parampau)
  {
    if ((paramViewBase == null) || (parampau == null) || (parampau.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    ram localram = parampau.a();
    paramViewBase.getNativeView().setOnClickListener(new pfi(this, localram, parampau));
  }
  
  private View b(int paramInt, Context paramContext, pau parampau)
  {
    parampau = parampau.a();
    if ((parampau != null) && (parampau.mSocialFeedInfo != null) && (parampau.mSocialFeedInfo.jdField_a_of_type_Qcv != null) && (parampau.mSocialFeedInfo.jdField_a_of_type_Qcv.a != null) && (parampau.mSocialFeedInfo.jdField_a_of_type_Qcv.a.size() > 0) && (ComponentContentGridImage.a(parampau.mSocialFeedInfo.jdField_a_of_type_Qcv.a.size(), parampau.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void b(int paramInt1, pau parampau, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = parampau.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.a != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.a.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.a.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, parampau, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    if ((paramNativeMiddleBodyView.a() instanceof ComponentContentGridImage))
    {
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampau, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(parampau);
      paramNativeMiddleBodyView.setGalleryClickListener(new pfg(this, parampau, paramContainer, paramInt2));
      return;
    }
    QLog.e("BiuPgcProteusItem", 1, "[bindGalleryBodyView] unexpected item: " + paramInt1 + " " + parampau.a());
  }
  
  private void c(int paramInt1, pau parampau, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if (!(paramNativeMiddleBodyView.a() instanceof AdapterView)) {
      paramNativeMiddleBodyView.a().setOnClickListener(new pfh(this, parampau, paramContainer, paramInt2));
    }
    ((pqp)paramNativeMiddleBodyView.a()).a(parampau);
  }
  
  public int a(ArticleInfo paramArticleInfo, ram paramram)
  {
    return old.a(paramram.a(), onh.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, pau parampau)
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
      return b(paramInt, paramContext, parampau);
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
    pdm localpdm = new pdm();
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.a;
      }
    }
    if ((paramInt == 35) && (!paramBaseArticleInfo.isPGCShortContent())) {
      localpdm.b(paramBaseArticleInfo, ajya.a(2131701154));
    }
    if (paramInt == 33) {
      localpdm.b(paramBaseArticleInfo, ajya.a(2131701155));
    }
    if (paramInt != 33) {
      localpdm.A(paramBaseArticleInfo).D(paramBaseArticleInfo).B(paramBaseArticleInfo);
    }
    if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95))
    {
      localpdm.o(paramBaseArticleInfo);
      localpdm.a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").k(paramBaseArticleInfo).j(paramBaseArticleInfo).n(paramBaseArticleInfo).m(paramBaseArticleInfo).C(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).G(paramBaseArticleInfo).E(paramBaseArticleInfo).s(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
      if (paramInt != 112) {
        localpdm.z(paramBaseArticleInfo);
      }
      if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95)) {
        break label311;
      }
      localpdm.a("ReadInjoy_biu_small_pgc_cell");
    }
    for (;;)
    {
      return localpdm.a();
      if ((!paramBaseArticleInfo.mSocialFeedInfo.a()) || (okz.b(paramBaseArticleInfo))) {
        break;
      }
      localpdm.o(paramBaseArticleInfo);
      break;
      label311:
      localpdm.a("ReadInjoy_biu_cell");
    }
  }
  
  public void a(int paramInt1, Container paramContainer, pau parampau, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    pli localpli = (pli)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    Object localObject;
    if (localpli != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localpli.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), parampau);
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label329;
        }
        localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      }
    }
    for (;;)
    {
      localpli.a((RelativeLayout.LayoutParams)localObject);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, (RelativeLayout.LayoutParams)localObject);
      }
      a(paramInt1, parampau, localNativeMiddleBodyView, paramInt2, paramContainer);
      localObject = (pju)localViewBase.findViewBaseByName("id_info_avator");
      if (localObject != null) {
        ((pju)localObject).a(parampau);
      }
      localObject = (pjw)localViewBase.findViewBaseByName("id_biu_comment");
      if (localObject != null) {
        ((pjw)localObject).a(parampau);
      }
      localObject = (pmk)localViewBase.findViewBaseByName("id_summary");
      if (localObject != null)
      {
        ((pmk)localObject).a(parampau);
        if ((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) {
          ((pmk)localObject).setOnClickListener(new pfc(this, paramContainer, parampau, paramInt2));
        }
      }
      localObject = localViewBase.findViewBaseByName("id_social_bottom");
      if (((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) && (localObject != null) && (((ViewBase)localObject).getNativeView() != null)) {
        ((ViewBase)localObject).getNativeView().setOnClickListener(new pfd(this, paramContainer, parampau, paramInt2));
      }
      pmo.a(localViewBase, parampau.a());
      a(localViewBase, parampau);
      pek.a(localViewBase, parampau);
      pek.b(localViewBase, parampau);
      pmo.a(localViewBase, parampau);
      pmo.b(localViewBase, parampau);
      pmo.c(localViewBase, parampau);
      return;
      label329:
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).setMargins(bbll.a(12.0F), 0, bbll.a(12.0F), 0);
    }
  }
  
  protected void a(int paramInt1, pau parampau, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampau.a() == null)) {
      return;
    }
    ram localram = parampau.a();
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt1);
    case 35: 
    case 114: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampau, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(parampau);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new pfe(this, parampau));
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
        actj.a("BiuPgcProteusItem", "", new IllegalArgumentException(" adapterViewType " + paramInt1 + " articleInfo : " + parampau.a()));
        return;
      }
      paramNativeMiddleBodyView.a().setOnClickListener(new pff(this, localram, parampau));
      ((pqp)paramNativeMiddleBodyView.a()).a(parampau);
      return;
    }
    b(paramInt1, parampau, paramNativeMiddleBodyView, paramInt2, paramContainer);
  }
  
  public boolean a(int paramInt, Container paramContainer, pau parampau, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pfb
 * JD-Core Version:    0.7.0.1
 */