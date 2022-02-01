import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUGCVoice;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButtonImp;
import org.json.JSONObject;

public class qcw
  implements qft
{
  private void a(ViewBase paramViewBase, pxk parampxk)
  {
    if ((paramViewBase == null) || (parampxk == null) || (parampxk.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    Context localContext = paramViewBase.getContext();
    paramViewBase.setOnClickListener(new qcx(this, parampxk.a(), localContext));
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
    Object localObject = new qba().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").h(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).m(paramBaseArticleInfo).l(paramBaseArticleInfo).B(paramBaseArticleInfo).n(paramBaseArticleInfo).q(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).x(paramBaseArticleInfo).z(paramBaseArticleInfo).C(paramBaseArticleInfo).F(paramBaseArticleInfo).D(paramBaseArticleInfo).A(paramBaseArticleInfo).G(paramBaseArticleInfo).r(paramBaseArticleInfo).E(paramBaseArticleInfo).k(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).t(paramBaseArticleInfo).N(paramBaseArticleInfo).O(paramBaseArticleInfo);
    if (qic.a((ArticleInfo)paramBaseArticleInfo)) {
      ((qba)localObject).a("RIJ_biu_small_single_img_cell");
    }
    for (;;)
    {
      localObject = ((qba)localObject).a();
      oqp.a(paramBaseArticleInfo, (JSONObject)localObject, 2);
      return localObject;
      ((qba)localObject).a("RIJ_biu_cell");
    }
  }
  
  public void a(int paramInt1, Container paramContainer, pxk parampxk, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject2 = (qjp)localViewBase.findViewBaseByName("id_middle_body_content");
    if (localObject2 != null)
    {
      localObject1 = (NativeMiddleBodyView)((qjp)localObject2).getNativeView();
      if (((NativeMiddleBodyView)localObject1).a() == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        ((qjp)localObject2).a(localLayoutParams);
        localObject2 = a(paramInt1, paramContainer.getContext());
        if (localObject2 != null) {
          ((NativeMiddleBodyView)localObject1).a((View)localObject2, localLayoutParams);
        }
      }
      a(paramInt1, parampxk, (NativeMiddleBodyView)localObject1);
    }
    qky.e(localViewBase, parampxk);
    Object localObject1 = (qil)localViewBase.findViewBaseByName("id_biu_comment");
    if (localObject1 != null) {
      ((qil)localObject1).a(parampxk);
    }
    localObject1 = (qku)localViewBase.findViewBaseByName("id_summary");
    if (localObject1 != null) {
      ((qku)localObject1).a(parampxk);
    }
    localObject1 = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((localObject1 != null) && (((NativeButton)localObject1).getNativeView() != null) && ((((NativeButton)localObject1).getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)((NativeButton)localObject1).getNativeView()).setTextColor(-1);
    }
    qky.a(localViewBase, parampxk.a());
    qcd.a(localViewBase, parampxk);
    a(localViewBase, parampxk);
    qcd.b(localViewBase, parampxk);
    qky.a(localViewBase, parampxk);
    qky.b(localViewBase, parampxk);
    oqp.a(parampxk, localViewBase, paramContainer, paramInt1);
  }
  
  protected void a(int paramInt, pxk parampxk, NativeMiddleBodyView paramNativeMiddleBodyView)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampxk.a() == null)) {
      return;
    }
    snh localsnh = parampxk.a();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 25: 
    case 81: 
      ((ComponentContentUgcImage)paramNativeMiddleBodyView.a()).a(parampxk);
      return;
    case 37: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setMIReadInJoyModel(parampxk);
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampxk.a()));
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setOnNoItemClickListener(new qcy(this, parampxk, localsnh));
      return;
    case 26: 
      paramNativeMiddleBodyView = (ComponentContentUgcVideo)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(parampxk);
      ((ComponentContentUgcVideo)paramNativeMiddleBodyView).setOnClickListener(new qcz(this, parampxk, localsnh));
      return;
    }
    ((ComponentContentUGCVoice)paramNativeMiddleBodyView.a()).a(parampxk);
  }
  
  public boolean a(int paramInt, Container paramContainer, pxk parampxk, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qcw
 * JD-Core Version:    0.7.0.1
 */