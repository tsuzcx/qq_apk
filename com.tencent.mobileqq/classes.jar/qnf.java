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

public class qnf
  implements qqa
{
  private void a(ViewBase paramViewBase, qfw paramqfw)
  {
    if ((paramViewBase == null) || (paramqfw == null) || (paramqfw.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    Context localContext = paramViewBase.getContext();
    paramViewBase.setOnClickListener(new qng(this, paramqfw.a(), localContext));
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
    qlk localqlk = new qlk().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).n(paramBaseArticleInfo).m(paramBaseArticleInfo).C(paramBaseArticleInfo).o(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).x(paramBaseArticleInfo).y(paramBaseArticleInfo).A(paramBaseArticleInfo).D(paramBaseArticleInfo).G(paramBaseArticleInfo).E(paramBaseArticleInfo).B(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).F(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo).O(paramBaseArticleInfo).P(paramBaseArticleInfo);
    if (qsl.a((ArticleInfo)paramBaseArticleInfo)) {
      localqlk.a("RIJ_biu_small_single_img_cell");
    }
    for (;;)
    {
      return localqlk.a();
      localqlk.a("RIJ_biu_cell");
    }
  }
  
  public void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    qud localqud = (qud)localViewBase.findViewBaseByName("id_middle_body_content");
    if (localqud != null)
    {
      NativeMiddleBodyView localNativeMiddleBodyView = (NativeMiddleBodyView)localqud.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localqud.a(localLayoutParams);
        paramContainer = a(paramInt1, paramContainer.getContext());
        if (paramContainer != null) {
          localNativeMiddleBodyView.a(paramContainer, localLayoutParams);
        }
      }
      a(paramInt1, paramqfw, localNativeMiddleBodyView);
    }
    qvn.f(localViewBase, paramqfw);
    paramContainer = (qsy)localViewBase.findViewBaseByName("id_biu_comment");
    if (paramContainer != null) {
      paramContainer.a(paramqfw);
    }
    paramContainer = (qvj)localViewBase.findViewBaseByName("id_summary");
    if (paramContainer != null) {
      paramContainer.a(paramqfw);
    }
    paramContainer = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((paramContainer != null) && (paramContainer.getNativeView() != null) && ((paramContainer.getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)paramContainer.getNativeView()).setTextColor(-1);
    }
    qvn.a(localViewBase, paramqfw.a());
    qmm.a(localViewBase, paramqfw);
    a(localViewBase, paramqfw);
    qmm.b(localViewBase, paramqfw);
    qvn.b(localViewBase, paramqfw);
    qvn.c(localViewBase, paramqfw);
  }
  
  protected void a(int paramInt, qfw paramqfw, NativeMiddleBodyView paramNativeMiddleBodyView)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (paramqfw.a() == null)) {
      return;
    }
    szd localszd = paramqfw.a();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 25: 
    case 81: 
      ((ComponentContentUgcImage)paramNativeMiddleBodyView.a()).a(paramqfw);
      return;
    case 37: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setMIReadInJoyModel(paramqfw);
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramqfw.a()));
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setOnNoItemClickListener(new qnh(this, paramqfw, localszd));
      return;
    case 26: 
      paramNativeMiddleBodyView = (ComponentContentUgcVideo)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(paramqfw);
      ((ComponentContentUgcVideo)paramNativeMiddleBodyView).setOnClickListener(new qni(this, paramqfw, localszd));
      return;
    }
    ((ComponentContentUGCVoice)paramNativeMiddleBodyView.a()).a(paramqfw);
  }
  
  public boolean a(int paramInt, Container paramContainer, qfw paramqfw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnf
 * JD-Core Version:    0.7.0.1
 */