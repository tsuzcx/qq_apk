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

public class qec
  implements qdy
{
  public static Pair<Boolean, String> a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj != null))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
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
        paramArticleInfo = ((rfk)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_JavaUtilArrayList.get(0)).c;
      }
    }
    return null;
  }
  
  private void a(ViewBase paramViewBase, pvc parampvc)
  {
    if ((paramViewBase == null) || (parampvc == null) || (parampvc.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    paramViewBase.setOnClickListener(new qee(this, paramViewBase.getContext(), parampvc.a()));
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    long l = 0L;
    pzf localpzf;
    if (paramInt == 75)
    {
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer != null) {
        l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long;
      }
      localpzf = new pzf();
      localpzf.a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l).f(paramBaseArticleInfo).g(paramBaseArticleInfo).h(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).o(paramBaseArticleInfo).q(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).l(paramBaseArticleInfo).w(paramBaseArticleInfo).B(paramBaseArticleInfo).z(paramBaseArticleInfo).D(paramBaseArticleInfo).A(paramBaseArticleInfo);
      if (paramInt != 75) {
        break label172;
      }
      localpzf.a("ReadInjoy_biu_small_pgc_cell").m(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").F(paramBaseArticleInfo);
    }
    for (;;)
    {
      return localpzf.a();
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj == null) {
        break;
      }
      l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Long;
      break;
      label172:
      localpzf.a("ReadInjoy_biu_small_pgc_cell").a(paramBaseArticleInfo, amtj.a(2131710336));
    }
  }
  
  protected void a(int paramInt1, Context paramContext, pvc parampvc, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2)
  {
    paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.setOnClickListener(new qed(this, parampvc, paramContext, paramInt1));
    paramNativeMiddleBodyView.a(parampvc);
  }
  
  public void a(int paramInt1, Container paramContainer, pvc parampvc, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    qhz localqhz = (qhz)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    PgcSmallView localPgcSmallView;
    if (localqhz != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localqhz.getNativeView();
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
      localqhz.a(localLayoutParams);
      if (localPgcSmallView != null) {
        localNativeMiddleBodyView.a(localPgcSmallView, localLayoutParams);
      }
      a(paramInt1, paramContainer.getContext(), parampvc, localNativeMiddleBodyView, paramInt2);
      localqhz.setVisibility(0);
      qji.e(localViewBase, parampvc);
      if (paramInt1 == 75)
      {
        paramContainer = (qgv)localViewBase.findViewBaseByName("id_biu_comment");
        if (paramContainer != null) {
          paramContainer.a(parampvc);
        }
        qai.b(localViewBase, parampvc);
      }
      qji.a(localViewBase, parampvc.a());
      qai.a(localViewBase, parampvc);
      a(localViewBase, parampvc);
      qji.b(localViewBase, parampvc);
      return;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pvc parampvc, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qec
 * JD-Core Version:    0.7.0.1
 */