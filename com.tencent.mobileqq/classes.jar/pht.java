import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.util.Pair;
import java.util.ArrayList;
import org.json.JSONObject;

public class pht
  implements php
{
  public static Pair<Boolean, String> a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda != null))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        paramArticleInfo = "https://sqimg.qq.com/qq_product_operations/kan/images/super_wenda_default.png";
      }
      for (boolean bool = true;; bool = false)
      {
        Object localObject = paramArticleInfo;
        if (!TextUtils.isEmpty(paramArticleInfo))
        {
          localObject = paramArticleInfo;
          if (paramArticleInfo.contains("https")) {
            localObject = paramArticleInfo.replaceFirst("https", "http");
          }
        }
        return new Pair(Boolean.valueOf(bool), localObject);
        paramArticleInfo = ((qdb)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList.get(0)).c;
      }
    }
    return null;
  }
  
  private void a(ViewBase paramViewBase, pau parampau)
  {
    if ((paramViewBase == null) || (parampau == null) || (parampau.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    paramViewBase.setOnClickListener(new phv(this, paramViewBase.getContext(), parampau.a()));
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    long l = 0L;
    pdm localpdm;
    if (paramInt == 75)
    {
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci != null) {
        l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
      }
      localpdm = new pdm();
      localpdm.a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l).f(paramBaseArticleInfo).g(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).p(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).m(paramBaseArticleInfo).x(paramBaseArticleInfo).C(paramBaseArticleInfo).A(paramBaseArticleInfo).E(paramBaseArticleInfo).B(paramBaseArticleInfo);
      if (paramInt != 75) {
        break label172;
      }
      localpdm.a("ReadInjoy_biu_small_pgc_cell").n(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").G(paramBaseArticleInfo);
    }
    for (;;)
    {
      return localpdm.a();
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null) {
        break;
      }
      l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Long;
      break;
      label172:
      localpdm.a("ReadInjoy_biu_small_pgc_cell").a(paramBaseArticleInfo, ajya.a(2131711233));
    }
  }
  
  protected void a(int paramInt1, Context paramContext, pau parampau, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2)
  {
    paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.setOnClickListener(new phu(this, parampau, paramContext, paramInt1));
    paramNativeMiddleBodyView.a(parampau);
  }
  
  public void a(int paramInt1, Container paramContainer, pau parampau, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    pli localpli = (pli)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    PgcSmallView localPgcSmallView;
    RelativeLayout.LayoutParams localLayoutParams;
    if (localpli != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localpli.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localPgcSmallView = new PgcSmallView(paramInt1, paramContainer.getContext());
        if ((localPgcSmallView == null) || (!(localPgcSmallView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label207;
        }
        localLayoutParams = (RelativeLayout.LayoutParams)localPgcSmallView.getLayoutParams();
      }
    }
    for (;;)
    {
      localpli.a(localLayoutParams);
      if (localPgcSmallView != null) {
        localNativeMiddleBodyView.a(localPgcSmallView, localLayoutParams);
      }
      a(paramInt1, paramContainer.getContext(), parampau, localNativeMiddleBodyView, paramInt2);
      localpli.setVisibility(0);
      paramContainer = (pju)localViewBase.findViewBaseByName("id_info_avator");
      if (paramContainer != null) {
        paramContainer.a(parampau);
      }
      if (paramInt1 == 75)
      {
        paramContainer = (pjw)localViewBase.findViewBaseByName("id_biu_comment");
        if (paramContainer != null) {
          paramContainer.a(parampau);
        }
        pek.b(localViewBase, parampau);
      }
      pmo.a(localViewBase, parampau.a());
      pek.a(localViewBase, parampau);
      a(localViewBase, parampau);
      pmo.b(localViewBase, parampau);
      return;
      label207:
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(bbll.a(12.0F), 0, bbll.a(12.0F), 0);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pau parampau, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pht
 * JD-Core Version:    0.7.0.1
 */