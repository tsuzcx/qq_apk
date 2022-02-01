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

public class qqe
  implements qqa
{
  public static Pair<Boolean, String> a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq != null))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
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
        paramArticleInfo = ((rrr)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_JavaUtilArrayList.get(0)).c;
      }
    }
    return null;
  }
  
  private void a(ViewBase paramViewBase, qfw paramqfw)
  {
    if ((paramViewBase == null) || (paramqfw == null) || (paramqfw.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    paramViewBase.setOnClickListener(new qqg(this, paramViewBase.getContext(), paramqfw.a()));
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    long l = 0L;
    qlk localqlk;
    if (paramInt == 75)
    {
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy != null) {
        l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long;
      }
      localqlk = new qlk();
      localqlk.a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l).f(paramBaseArticleInfo).g(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).p(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).m(paramBaseArticleInfo).x(paramBaseArticleInfo).C(paramBaseArticleInfo).A(paramBaseArticleInfo).E(paramBaseArticleInfo).B(paramBaseArticleInfo);
      if (paramInt != 75) {
        break label172;
      }
      localqlk.a("ReadInjoy_biu_small_pgc_cell").n(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").G(paramBaseArticleInfo);
    }
    for (;;)
    {
      return localqlk.a();
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq == null) {
        break;
      }
      l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Long;
      break;
      label172:
      localqlk.a("ReadInjoy_biu_small_pgc_cell").a(paramBaseArticleInfo, anvx.a(2131710683));
    }
  }
  
  protected void a(int paramInt1, Context paramContext, qfw paramqfw, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2)
  {
    paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.setOnClickListener(new qqf(this, paramqfw, paramContext, paramInt1));
    paramNativeMiddleBodyView.a(paramqfw);
  }
  
  public void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    qud localqud = (qud)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    PgcSmallView localPgcSmallView;
    if (localqud != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localqud.getNativeView();
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
      localqud.a(localLayoutParams);
      if (localPgcSmallView != null) {
        localNativeMiddleBodyView.a(localPgcSmallView, localLayoutParams);
      }
      a(paramInt1, paramContainer.getContext(), paramqfw, localNativeMiddleBodyView, paramInt2);
      localqud.setVisibility(0);
      qvn.f(localViewBase, paramqfw);
      if (paramInt1 == 75)
      {
        paramContainer = (qsy)localViewBase.findViewBaseByName("id_biu_comment");
        if (paramContainer != null) {
          paramContainer.a(paramqfw);
        }
        qmm.b(localViewBase, paramqfw);
      }
      qvn.a(localViewBase, paramqfw.a());
      qmm.a(localViewBase, paramqfw);
      a(localViewBase, paramqfw);
      qvn.c(localViewBase, paramqfw);
      return;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, qfw paramqfw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqe
 * JD-Core Version:    0.7.0.1
 */