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

public class owe
  implements owa
{
  public static Pair<Boolean, String> a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre != null))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
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
        paramArticleInfo = ((prf)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_JavaUtilArrayList.get(0)).c;
      }
    }
    return null;
  }
  
  private void a(ViewBase paramViewBase, opw paramopw)
  {
    if ((paramViewBase == null) || (paramopw == null) || (paramopw.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    paramViewBase.setOnClickListener(new owg(this, paramViewBase.getContext(), paramopw.a()));
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    long l = 0L;
    osn localosn;
    if (paramInt == 75)
    {
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo != null) {
        l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
      }
      localosn = new osn();
      localosn.a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l).e(paramBaseArticleInfo).f(paramBaseArticleInfo).h(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).o(paramBaseArticleInfo).q(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).l(paramBaseArticleInfo).w(paramBaseArticleInfo).B(paramBaseArticleInfo).z(paramBaseArticleInfo).D(paramBaseArticleInfo).A(paramBaseArticleInfo);
      if (paramInt != 75) {
        break label172;
      }
      localosn.a("ReadInjoy_biu_small_pgc_cell").m(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").F(paramBaseArticleInfo);
    }
    for (;;)
    {
      return localosn.a();
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null) {
        break;
      }
      l = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Long;
      break;
      label172:
      localosn.a("ReadInjoy_biu_small_pgc_cell").a(paramBaseArticleInfo, ajjy.a(2131645434));
    }
  }
  
  protected void a(int paramInt1, Context paramContext, opw paramopw, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2)
  {
    paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.setOnClickListener(new owf(this, paramopw, paramContext, paramInt1));
    paramNativeMiddleBodyView.a(paramopw);
  }
  
  public void a(int paramInt1, Container paramContainer, opw paramopw, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    ozt localozt = (ozt)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    PgcSmallView localPgcSmallView;
    RelativeLayout.LayoutParams localLayoutParams;
    if (localozt != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localozt.getNativeView();
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
      localozt.a(localLayoutParams);
      if (localPgcSmallView != null) {
        localNativeMiddleBodyView.a(localPgcSmallView, localLayoutParams);
      }
      a(paramInt1, paramContainer.getContext(), paramopw, localNativeMiddleBodyView, paramInt2);
      localozt.setVisibility(0);
      paramContainer = (oyf)localViewBase.findViewBaseByName("id_info_avator");
      if (paramContainer != null) {
        paramContainer.a(paramopw);
      }
      if (paramInt1 == 75)
      {
        paramContainer = (oyh)localViewBase.findViewBaseByName("id_biu_comment");
        if (paramContainer != null) {
          paramContainer.a(paramopw);
        }
        otl.b(localViewBase, paramopw);
      }
      paz.a(localViewBase, paramopw.a());
      otl.a(localViewBase, paramopw);
      a(localViewBase, paramopw);
      paz.b(localViewBase, paramopw);
      return;
      label207:
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(bajq.a(12.0F), 0, bajq.a(12.0F), 0);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, opw paramopw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owe
 * JD-Core Version:    0.7.0.1
 */