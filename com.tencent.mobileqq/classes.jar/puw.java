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

public class puw
  implements pye
{
  private void a(ViewBase paramViewBase, ppu paramppu, ViewBase.OnClickListener paramOnClickListener)
  {
    if ((paramViewBase == null) || (paramppu == null) || (paramppu.a() == null)) {}
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
    JSONObject localJSONObject = new ptl().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").h(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).m(paramBaseArticleInfo).l(paramBaseArticleInfo).n(paramBaseArticleInfo).q(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).C(paramBaseArticleInfo).B(paramBaseArticleInfo).F(paramBaseArticleInfo).a("ReadInjoy_biu_cell").D(paramBaseArticleInfo).r(paramBaseArticleInfo).H(paramBaseArticleInfo).a();
    if (!oxs.a(paramBaseArticleInfo)) {
      puq.a(paramBaseArticleInfo, anzj.a(2131700065), localJSONObject);
    }
    return localJSONObject;
  }
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject1 = (qcb)localViewBase.findViewBaseByName("id_middle_body_content");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = (NativeMiddleBodyView)((qcb)localObject1).getNativeView();
      if ((localObject2 != null) && (((NativeMiddleBodyView)localObject2).a() == null))
      {
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        LinearLayout localLinearLayout = new LinearLayout(paramContainer.getContext());
        localLinearLayout.setOrientation(1);
        localLinearLayout.addView(new ComponentContentGridImage(paramContainer.getContext()));
        localLinearLayout.addView(new ComponentContentUgcImage(paramContainer.getContext()));
        ((qcb)localObject1).a((RelativeLayout.LayoutParams)localObject3);
        ((NativeMiddleBodyView)localObject2).a(localLinearLayout, (RelativeLayout.LayoutParams)localObject3);
      }
      if (localObject2 != null)
      {
        localObject1 = (ViewGroup)((NativeMiddleBodyView)localObject2).a();
        localObject2 = paramppu.a();
        paramInt1 = puq.a((ArticleInfo)localObject2);
        localObject2 = puq.a((ArticleInfo)localObject2, paramInt1);
        if (paramInt1 != 0) {
          break label341;
        }
        ((ViewGroup)localObject1).setVisibility(8);
      }
    }
    qdk.e(localViewBase, paramppu);
    localObject1 = (qax)localViewBase.findViewBaseByName("id_biu_comment");
    if (localObject1 != null) {
      ((qax)localObject1).a(paramppu);
    }
    localObject1 = (qdg)localViewBase.findViewBaseByName("id_summary");
    paramContainer = new puy(this, paramppu, paramContainer);
    if (localObject1 != null)
    {
      ((qdg)localObject1).a(paramppu);
      ((NativeSummaryView)((qdg)localObject1).getNativeView()).setShouldCallClick(true);
      ((qdg)localObject1).setOnClickListener(paramContainer);
    }
    localObject1 = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((localObject1 != null) && (((NativeButton)localObject1).getNativeView() != null) && ((((NativeButton)localObject1).getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)((NativeButton)localObject1).getNativeView()).setTextColor(-1);
    }
    qdk.a(localViewBase, paramppu.a());
    puo.a(localViewBase, paramppu);
    a(localViewBase, paramppu, paramContainer);
    puo.b(localViewBase, paramppu);
    qdk.b(localViewBase, paramppu);
    return;
    label341:
    ((ViewGroup)localObject1).setVisibility(0);
    Object localObject3 = (ComponentContentGridImage)((ViewGroup)localObject1).getChildAt(0);
    localObject1 = (ComponentContentUgcImage)((ViewGroup)localObject1).getChildAt(1);
    if (paramInt1 == 1)
    {
      ((ComponentContentGridImage)localObject3).setVisibility(8);
      ((ComponentContentUgcImage)localObject1).setVisibility(0);
      ((ComponentContentUgcImage)localObject1).a(paramppu);
    }
    for (;;)
    {
      ((ComponentContentUgcImage)localObject1).setPicClickListener(new pux(this, paramppu));
      break;
      ((ComponentContentGridImage)localObject3).setVisibility(0);
      ((ComponentContentGridImage)localObject3).setMIReadInJoyModel(paramppu);
      ((ComponentContentUgcImage)localObject1).setVisibility(8);
      ((ComponentContentGridImage)localObject3).a(localObject2);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, ppu paramppu, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     puw
 * JD-Core Version:    0.7.0.1
 */