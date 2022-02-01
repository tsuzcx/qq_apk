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

public class qfx
  implements qft
{
  public static Pair<Boolean, String> a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs != null))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
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
        paramArticleInfo = ((rht)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.jdField_a_of_type_JavaUtilArrayList.get(0)).c;
      }
    }
    return null;
  }
  
  private void a(ViewBase paramViewBase, pxk parampxk)
  {
    if ((paramViewBase == null) || (parampxk == null) || (parampxk.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    paramViewBase.setOnClickListener(new qfz(this, paramViewBase.getContext(), parampxk.a()));
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    long l = 0L;
    qba localqba;
    if (paramInt == 75)
    {
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha != null) {
        l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha.jdField_a_of_type_Long;
      }
      localqba = new qba();
      localqba.a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l).f(paramBaseArticleInfo).g(paramBaseArticleInfo).h(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).o(paramBaseArticleInfo).q(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).l(paramBaseArticleInfo).w(paramBaseArticleInfo).B(paramBaseArticleInfo).z(paramBaseArticleInfo).D(paramBaseArticleInfo).A(paramBaseArticleInfo);
      if (paramInt != 75) {
        break label172;
      }
      localqba.a("ReadInjoy_biu_small_pgc_cell").m(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").F(paramBaseArticleInfo);
    }
    for (;;)
    {
      return localqba.a();
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs == null) {
        break;
      }
      l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.jdField_a_of_type_Long;
      break;
      label172:
      localqba.a("ReadInjoy_biu_small_pgc_cell").a(paramBaseArticleInfo, anni.a(2131709995));
    }
  }
  
  protected void a(int paramInt1, Context paramContext, pxk parampxk, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2)
  {
    paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.setOnClickListener(new qfy(this, parampxk, paramContext, paramInt1));
    paramNativeMiddleBodyView.a(parampxk);
  }
  
  public void a(int paramInt1, Container paramContainer, pxk parampxk, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    qjp localqjp = (qjp)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    PgcSmallView localPgcSmallView;
    if (localqjp != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localqjp.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localPgcSmallView = new PgcSmallView(paramInt1, paramContainer.getContext());
        if ((localPgcSmallView == null) || (!(localPgcSmallView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label192;
        }
      }
    }
    label192:
    for (RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localPgcSmallView.getLayoutParams();; localLayoutParams = new RelativeLayout.LayoutParams(-2, -2))
    {
      localqjp.a(localLayoutParams);
      if (localPgcSmallView != null) {
        localNativeMiddleBodyView.a(localPgcSmallView, localLayoutParams);
      }
      a(paramInt1, paramContainer.getContext(), parampxk, localNativeMiddleBodyView, paramInt2);
      localqjp.setVisibility(0);
      qky.e(localViewBase, parampxk);
      if (paramInt1 == 75)
      {
        paramContainer = (qil)localViewBase.findViewBaseByName("id_biu_comment");
        if (paramContainer != null) {
          paramContainer.a(parampxk);
        }
        qcd.b(localViewBase, parampxk);
      }
      qky.a(localViewBase, parampxk.a());
      qcd.a(localViewBase, parampxk);
      a(localViewBase, parampxk);
      qky.b(localViewBase, parampxk);
      return;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pxk parampxk, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qfx
 * JD-Core Version:    0.7.0.1
 */