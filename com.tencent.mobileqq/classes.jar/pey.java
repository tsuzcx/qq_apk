import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcImage;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButtonImp;
import org.json.JSONObject;

public class pey
  implements php
{
  private void a(ViewBase paramViewBase, pau parampau, ViewBase.OnClickListener paramOnClickListener)
  {
    if ((paramViewBase == null) || (parampau == null) || (parampau.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase.setOnClickListener(paramOnClickListener);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    long l = 0L;
    if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
      l = paramBaseArticleInfo.mSocialFeedInfo.a.a;
    }
    JSONObject localJSONObject = new pdm().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).n(paramBaseArticleInfo).m(paramBaseArticleInfo).o(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).x(paramBaseArticleInfo).D(paramBaseArticleInfo).C(paramBaseArticleInfo).G(paramBaseArticleInfo).a("ReadInjoy_biu_cell").E(paramBaseArticleInfo).s(paramBaseArticleInfo).I(paramBaseArticleInfo).a();
    if (!okz.a(paramBaseArticleInfo)) {
      pet.a(paramBaseArticleInfo, ajya.a(2131701153), localJSONObject);
    }
    return localJSONObject;
  }
  
  public void a(int paramInt1, Container paramContainer, pau parampau, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject1 = (pli)localViewBase.findViewBaseByName("id_middle_body_content");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (NativeMiddleBodyView)((pli)localObject1).getNativeView();
      if ((localObject2 != null) && (((NativeMiddleBodyView)localObject2).a() == null))
      {
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        LinearLayout localLinearLayout = new LinearLayout(paramContainer.getContext());
        localLinearLayout.setOrientation(1);
        localLinearLayout.addView(new ComponentContentGridImage(paramContainer.getContext()));
        localLinearLayout.addView(new ComponentContentUgcImage(paramContainer.getContext()));
        paramInt1 = actj.a(12.0F, paramContainer.getContext().getResources());
        ((RelativeLayout.LayoutParams)localObject3).setMargins(paramInt1, 0, paramInt1, 0);
        ((pli)localObject1).a((RelativeLayout.LayoutParams)localObject3);
        ((NativeMiddleBodyView)localObject2).a(localLinearLayout, (RelativeLayout.LayoutParams)localObject3);
      }
      if (localObject2 != null)
      {
        localObject1 = (ViewGroup)((NativeMiddleBodyView)localObject2).a();
        localObject2 = parampau.a();
        paramInt1 = pet.a((ArticleInfo)localObject2);
        localObject2 = pet.a((ArticleInfo)localObject2, paramInt1);
        if (paramInt1 != 0) {
          break label381;
        }
        ((ViewGroup)localObject1).setVisibility(8);
      }
    }
    localObject1 = (pju)localViewBase.findViewBaseByName("id_info_avator");
    if (localObject1 != null) {
      ((pju)localObject1).a(parampau);
    }
    localObject1 = (pjw)localViewBase.findViewBaseByName("id_biu_comment");
    if (localObject1 != null) {
      ((pjw)localObject1).a(parampau);
    }
    localObject1 = (pmk)localViewBase.findViewBaseByName("id_summary");
    paramContainer = new pfa(this, parampau, paramContainer);
    if (localObject1 != null)
    {
      ((pmk)localObject1).a(parampau);
      ((NativeSummaryView)((pmk)localObject1).getNativeView()).setShouldCallClick(true);
      ((pmk)localObject1).setOnClickListener(paramContainer);
    }
    localObject1 = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((localObject1 != null) && (((NativeButton)localObject1).getNativeView() != null) && ((((NativeButton)localObject1).getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)((NativeButton)localObject1).getNativeView()).setTextColor(-1);
    }
    pmo.a(localViewBase, parampau.a());
    pek.a(localViewBase, parampau);
    a(localViewBase, parampau, paramContainer);
    pek.b(localViewBase, parampau);
    pmo.b(localViewBase, parampau);
    return;
    label381:
    ((ViewGroup)localObject1).setVisibility(0);
    Object localObject3 = (ComponentContentGridImage)((ViewGroup)localObject1).getChildAt(0);
    localObject1 = (ComponentContentUgcImage)((ViewGroup)localObject1).getChildAt(1);
    if (paramInt1 == 1)
    {
      ((ComponentContentGridImage)localObject3).setVisibility(8);
      ((ComponentContentUgcImage)localObject1).setVisibility(0);
      ((ComponentContentUgcImage)localObject1).a(parampau);
    }
    for (;;)
    {
      ((ComponentContentUgcImage)localObject1).setPicClickListener(new pez(this, parampau));
      break;
      ((ComponentContentGridImage)localObject3).setVisibility(0);
      ((ComponentContentGridImage)localObject3).setMIReadInJoyModel(parampau);
      ((ComponentContentUgcImage)localObject1).setVisibility(8);
      ((ComponentContentGridImage)localObject3).a(localObject2);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pau parampau, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pey
 * JD-Core Version:    0.7.0.1
 */