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

public class pyi
  implements pye
{
  public static Pair<Boolean, String> a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl != null))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
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
        paramArticleInfo = ((qym)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_JavaUtilArrayList.get(0)).c;
      }
    }
    return null;
  }
  
  private void a(ViewBase paramViewBase, ppu paramppu)
  {
    if ((paramViewBase == null) || (paramppu == null) || (paramppu.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    paramViewBase.setOnClickListener(new pyk(this, paramViewBase.getContext(), paramppu.a()));
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    long l = 0L;
    ptl localptl;
    if (paramInt == 75)
    {
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt != null) {
        l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.jdField_a_of_type_Long;
      }
      localptl = new ptl();
      localptl.a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l).f(paramBaseArticleInfo).g(paramBaseArticleInfo).h(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).o(paramBaseArticleInfo).q(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).l(paramBaseArticleInfo).w(paramBaseArticleInfo).B(paramBaseArticleInfo).z(paramBaseArticleInfo).D(paramBaseArticleInfo).A(paramBaseArticleInfo);
      if (paramInt != 75) {
        break label172;
      }
      localptl.a("ReadInjoy_biu_small_pgc_cell").m(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").F(paramBaseArticleInfo);
    }
    for (;;)
    {
      return localptl.a();
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl == null) {
        break;
      }
      l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Long;
      break;
      label172:
      localptl.a("ReadInjoy_biu_small_pgc_cell").a(paramBaseArticleInfo, anzj.a(2131710104));
    }
  }
  
  protected void a(int paramInt1, Context paramContext, ppu paramppu, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2)
  {
    paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.setOnClickListener(new pyj(this, paramppu, paramContext, paramInt1));
    paramNativeMiddleBodyView.a(paramppu);
  }
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    qcb localqcb = (qcb)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    PgcSmallView localPgcSmallView;
    if (localqcb != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localqcb.getNativeView();
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
      localqcb.a(localLayoutParams);
      if (localPgcSmallView != null) {
        localNativeMiddleBodyView.a(localPgcSmallView, localLayoutParams);
      }
      a(paramInt1, paramContainer.getContext(), paramppu, localNativeMiddleBodyView, paramInt2);
      localqcb.setVisibility(0);
      qdk.e(localViewBase, paramppu);
      if (paramInt1 == 75)
      {
        paramContainer = (qax)localViewBase.findViewBaseByName("id_biu_comment");
        if (paramContainer != null) {
          paramContainer.a(paramppu);
        }
        puo.b(localViewBase, paramppu);
      }
      qdk.a(localViewBase, paramppu.a());
      puo.a(localViewBase, paramppu);
      a(localViewBase, paramppu);
      qdk.b(localViewBase, paramppu);
      return;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, ppu paramppu, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyi
 * JD-Core Version:    0.7.0.1
 */