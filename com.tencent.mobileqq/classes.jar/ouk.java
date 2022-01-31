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

public class ouk
  implements owa
{
  private void a(ViewBase paramViewBase, opw paramopw)
  {
    if ((paramViewBase == null) || (paramopw == null) || (paramopw.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    paramViewBase = paramViewBase.getNativeView();
    Context localContext = paramViewBase.getContext();
    paramViewBase.setOnClickListener(new oul(this, paramopw.a(), localContext));
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
    return new osn().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).e(paramBaseArticleInfo).f(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").h(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).m(paramBaseArticleInfo).l(paramBaseArticleInfo).B(paramBaseArticleInfo).n(paramBaseArticleInfo).q(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).x(paramBaseArticleInfo).z(paramBaseArticleInfo).C(paramBaseArticleInfo).F(paramBaseArticleInfo).a("ReadInjoy_biu_cell").D(paramBaseArticleInfo).A(paramBaseArticleInfo).G(paramBaseArticleInfo).r(paramBaseArticleInfo).E(paramBaseArticleInfo).k(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).t(paramBaseArticleInfo).N(paramBaseArticleInfo).a();
  }
  
  public void a(int paramInt1, Container paramContainer, opw paramopw, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    ozt localozt = (ozt)localViewBase.findViewBaseByName("id_middle_body_content");
    if (localozt != null)
    {
      NativeMiddleBodyView localNativeMiddleBodyView = (NativeMiddleBodyView)localozt.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.setMargins(bajq.a(12.0F), 0, bajq.a(12.0F), 0);
        localozt.a(localLayoutParams);
        paramContainer = a(paramInt1, paramContainer.getContext());
        if (paramContainer != null) {
          localNativeMiddleBodyView.a(paramContainer, localLayoutParams);
        }
      }
      a(paramInt1, paramopw, localNativeMiddleBodyView);
    }
    paramContainer = (oyf)localViewBase.findViewBaseByName("id_info_avator");
    if (paramContainer != null) {
      paramContainer.a(paramopw);
    }
    paramContainer = (oyh)localViewBase.findViewBaseByName("id_biu_comment");
    if (paramContainer != null) {
      paramContainer.a(paramopw);
    }
    paramContainer = (pav)localViewBase.findViewBaseByName("id_summary");
    if (paramContainer != null) {
      paramContainer.a(paramopw);
    }
    paramContainer = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((paramContainer != null) && (paramContainer.getNativeView() != null) && ((paramContainer.getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)paramContainer.getNativeView()).setTextColor(-1);
    }
    paz.a(localViewBase, paramopw.a());
    otl.a(localViewBase, paramopw);
    a(localViewBase, paramopw);
    otl.b(localViewBase, paramopw);
    paz.a(localViewBase, paramopw);
    paz.b(localViewBase, paramopw);
  }
  
  protected void a(int paramInt, opw paramopw, NativeMiddleBodyView paramNativeMiddleBodyView)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (paramopw.a() == null)) {
      return;
    }
    qoe localqoe = paramopw.a();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 25: 
    case 81: 
      ((ComponentContentUgcImage)paramNativeMiddleBodyView.a()).a(paramopw);
      return;
    case 37: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setMIReadInJoyModel(paramopw);
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramopw.a()));
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setOnNoItemClickListener(new oum(this, paramopw, localqoe));
      return;
    case 26: 
      paramNativeMiddleBodyView = (ComponentContentUgcVideo)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(paramopw);
      ((ComponentContentUgcVideo)paramNativeMiddleBodyView).setOnClickListener(new oun(this, paramopw, localqoe));
      return;
    }
    ((ComponentContentUGCVoice)paramNativeMiddleBodyView.a()).a(paramopw);
  }
  
  public boolean a(int paramInt, Container paramContainer, opw paramopw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ouk
 * JD-Core Version:    0.7.0.1
 */