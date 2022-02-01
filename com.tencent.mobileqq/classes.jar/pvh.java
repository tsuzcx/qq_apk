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

public class pvh
  implements pye
{
  private void a(ViewBase paramViewBase, ppu paramppu)
  {
    if ((paramViewBase == null) || (paramppu == null) || (paramppu.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    Context localContext = paramViewBase.getContext();
    paramViewBase.setOnClickListener(new pvi(this, paramppu.a(), localContext));
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
    Object localObject = new ptl().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").h(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).m(paramBaseArticleInfo).l(paramBaseArticleInfo).B(paramBaseArticleInfo).n(paramBaseArticleInfo).q(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).x(paramBaseArticleInfo).z(paramBaseArticleInfo).C(paramBaseArticleInfo).F(paramBaseArticleInfo).D(paramBaseArticleInfo).A(paramBaseArticleInfo).G(paramBaseArticleInfo).r(paramBaseArticleInfo).E(paramBaseArticleInfo).k(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).t(paramBaseArticleInfo).N(paramBaseArticleInfo).O(paramBaseArticleInfo);
    if (qao.a((ArticleInfo)paramBaseArticleInfo)) {
      ((ptl)localObject).a("RIJ_biu_small_single_img_cell");
    }
    for (;;)
    {
      localObject = ((ptl)localObject).a();
      tqg.a(paramBaseArticleInfo, (JSONObject)localObject, 2);
      return localObject;
      ((ptl)localObject).a("RIJ_biu_cell");
    }
  }
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject2 = (qcb)localViewBase.findViewBaseByName("id_middle_body_content");
    if (localObject2 != null)
    {
      localObject1 = (NativeMiddleBodyView)((qcb)localObject2).getNativeView();
      if (((NativeMiddleBodyView)localObject1).a() == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        ((qcb)localObject2).a(localLayoutParams);
        localObject2 = a(paramInt1, paramContainer.getContext());
        if (localObject2 != null) {
          ((NativeMiddleBodyView)localObject1).a((View)localObject2, localLayoutParams);
        }
      }
      a(paramInt1, paramppu, (NativeMiddleBodyView)localObject1);
    }
    qdk.e(localViewBase, paramppu);
    Object localObject1 = (qax)localViewBase.findViewBaseByName("id_biu_comment");
    if (localObject1 != null) {
      ((qax)localObject1).a(paramppu);
    }
    localObject1 = (qdg)localViewBase.findViewBaseByName("id_summary");
    if (localObject1 != null) {
      ((qdg)localObject1).a(paramppu);
    }
    localObject1 = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((localObject1 != null) && (((NativeButton)localObject1).getNativeView() != null) && ((((NativeButton)localObject1).getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)((NativeButton)localObject1).getNativeView()).setTextColor(-1);
    }
    qdk.a(localViewBase, paramppu.a());
    puo.a(localViewBase, paramppu);
    a(localViewBase, paramppu);
    puo.b(localViewBase, paramppu);
    qdk.a(localViewBase, paramppu);
    qdk.b(localViewBase, paramppu);
    tqg.a(paramppu, localViewBase, paramContainer, paramInt1);
  }
  
  protected void a(int paramInt, ppu paramppu, NativeMiddleBodyView paramNativeMiddleBodyView)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (paramppu.a() == null)) {
      return;
    }
    sel localsel = paramppu.a();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 25: 
    case 81: 
      ((ComponentContentUgcImage)paramNativeMiddleBodyView.a()).a(paramppu);
      return;
    case 37: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setMIReadInJoyModel(paramppu);
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramppu.a()));
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setOnNoItemClickListener(new pvj(this, paramppu, localsel));
      return;
    case 26: 
      paramNativeMiddleBodyView = (ComponentContentUgcVideo)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(paramppu);
      ((ComponentContentUgcVideo)paramNativeMiddleBodyView).setOnClickListener(new pvk(this, paramppu, localsel));
      return;
    }
    ((ComponentContentUGCVoice)paramNativeMiddleBodyView.a()).a(paramppu);
  }
  
  public boolean a(int paramInt, Container paramContainer, ppu paramppu, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvh
 * JD-Core Version:    0.7.0.1
 */