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

public class phw
  implements phs
{
  public static Pair<Boolean, String> a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd != null))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
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
        paramArticleInfo = ((qde)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.jdField_a_of_type_JavaUtilArrayList.get(0)).c;
      }
    }
    return null;
  }
  
  private void a(ViewBase paramViewBase, pax parampax)
  {
    if ((paramViewBase == null) || (parampax == null) || (parampax.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    paramViewBase.setOnClickListener(new phy(this, paramViewBase.getContext(), parampax.a()));
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    long l = 0L;
    pdp localpdp;
    if (paramInt == 75)
    {
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl != null) {
        l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl.jdField_a_of_type_Long;
      }
      localpdp = new pdp();
      localpdp.a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l).f(paramBaseArticleInfo).g(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).p(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).m(paramBaseArticleInfo).x(paramBaseArticleInfo).C(paramBaseArticleInfo).A(paramBaseArticleInfo).E(paramBaseArticleInfo).B(paramBaseArticleInfo);
      if (paramInt != 75) {
        break label172;
      }
      localpdp.a("ReadInjoy_biu_small_pgc_cell").n(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").G(paramBaseArticleInfo);
    }
    for (;;)
    {
      return localpdp.a();
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd == null) {
        break;
      }
      l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.jdField_a_of_type_Long;
      break;
      label172:
      localpdp.a("ReadInjoy_biu_small_pgc_cell").a(paramBaseArticleInfo, ajyc.a(2131711222));
    }
  }
  
  protected void a(int paramInt1, Context paramContext, pax parampax, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2)
  {
    paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.setOnClickListener(new phx(this, parampax, paramContext, paramInt1));
    paramNativeMiddleBodyView.a(parampax);
  }
  
  public void a(int paramInt1, Container paramContainer, pax parampax, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    pll localpll = (pll)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    PgcSmallView localPgcSmallView;
    RelativeLayout.LayoutParams localLayoutParams;
    if (localpll != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localpll.getNativeView();
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
      localpll.a(localLayoutParams);
      if (localPgcSmallView != null) {
        localNativeMiddleBodyView.a(localPgcSmallView, localLayoutParams);
      }
      a(paramInt1, paramContainer.getContext(), parampax, localNativeMiddleBodyView, paramInt2);
      localpll.setVisibility(0);
      paramContainer = (pjx)localViewBase.findViewBaseByName("id_info_avator");
      if (paramContainer != null) {
        paramContainer.a(parampax);
      }
      if (paramInt1 == 75)
      {
        paramContainer = (pjz)localViewBase.findViewBaseByName("id_biu_comment");
        if (paramContainer != null) {
          paramContainer.a(parampax);
        }
        pen.b(localViewBase, parampax);
      }
      pmr.a(localViewBase, parampax.a());
      pen.a(localViewBase, parampax);
      a(localViewBase, parampax);
      pmr.b(localViewBase, parampax);
      return;
      label207:
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(bbkx.a(12.0F), 0, bbkx.a(12.0F), 0);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pax parampax, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phw
 * JD-Core Version:    0.7.0.1
 */