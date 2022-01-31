import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUGCVoice;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButtonImp;
import org.json.JSONObject;

public class pfj
  implements php
{
  private void a(ViewBase paramViewBase, pau parampau)
  {
    if ((paramViewBase == null) || (parampau == null) || (parampau.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    Context localContext = paramViewBase.getContext();
    paramViewBase.setOnClickListener(new pfk(this, parampau.a(), localContext));
  }
  
  protected View a(int paramInt, Context paramContext)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 25: 
    case 81: 
      return new ComponentContentUgcImage(paramContext);
    case 37: 
      return new ComponentContentGridImage(paramContext);
    case 26: 
      return new ComponentContentUgcVideo(paramContext);
    }
    return new ComponentContentUGCVoice(paramContext);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.a.a;
      }
    }
    return new pdm().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).n(paramBaseArticleInfo).m(paramBaseArticleInfo).C(paramBaseArticleInfo).o(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).x(paramBaseArticleInfo).y(paramBaseArticleInfo).A(paramBaseArticleInfo).D(paramBaseArticleInfo).G(paramBaseArticleInfo).a("ReadInjoy_biu_cell").E(paramBaseArticleInfo).B(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).F(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo).O(paramBaseArticleInfo).P(paramBaseArticleInfo).a();
  }
  
  public void a(int paramInt1, Container paramContainer, pau parampau, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    pli localpli = (pli)localViewBase.findViewBaseByName("id_middle_body_content");
    if (localpli != null)
    {
      NativeMiddleBodyView localNativeMiddleBodyView = (NativeMiddleBodyView)localpli.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.setMargins(bbll.a(12.0F), 0, bbll.a(12.0F), 0);
        localpli.a(localLayoutParams);
        paramContainer = a(paramInt1, paramContainer.getContext());
        if (paramContainer != null) {
          localNativeMiddleBodyView.a(paramContainer, localLayoutParams);
        }
      }
      a(paramInt1, parampau, localNativeMiddleBodyView);
    }
    paramContainer = (pju)localViewBase.findViewBaseByName("id_info_avator");
    if (paramContainer != null) {
      paramContainer.a(parampau);
    }
    paramContainer = (pjw)localViewBase.findViewBaseByName("id_biu_comment");
    if (paramContainer != null) {
      paramContainer.a(parampau);
    }
    paramContainer = (pmk)localViewBase.findViewBaseByName("id_summary");
    if (paramContainer != null) {
      paramContainer.a(parampau);
    }
    paramContainer = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((paramContainer != null) && (paramContainer.getNativeView() != null) && ((paramContainer.getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)paramContainer.getNativeView()).setTextColor(-1);
    }
    pmo.a(localViewBase, parampau.a());
    pek.a(localViewBase, parampau);
    a(localViewBase, parampau);
    pek.b(localViewBase, parampau);
    pmo.a(localViewBase, parampau);
    pmo.b(localViewBase, parampau);
  }
  
  protected void a(int paramInt, pau parampau, NativeMiddleBodyView paramNativeMiddleBodyView)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampau.a() == null)) {
      return;
    }
    ram localram = parampau.a();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 25: 
    case 81: 
      ((ComponentContentUgcImage)paramNativeMiddleBodyView.a()).a(parampau);
      return;
    case 37: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setMIReadInJoyModel(parampau);
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampau.a()));
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setOnNoItemClickListener(new pfl(this, parampau, localram));
      return;
    case 26: 
      paramNativeMiddleBodyView = (ComponentContentUgcVideo)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(parampau);
      ((ComponentContentUgcVideo)paramNativeMiddleBodyView).setOnClickListener(new pfm(this, parampau, localram));
      return;
    }
    ((ComponentContentUGCVoice)paramNativeMiddleBodyView.a()).a(parampau);
  }
  
  public boolean a(int paramInt, Container paramContainer, pau parampau, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pfj
 * JD-Core Version:    0.7.0.1
 */