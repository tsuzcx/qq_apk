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

public class pyp
  implements pye
{
  protected View a(int paramInt, Context paramContext)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 22: 
    case 80: 
      return new ComponentContentUgcImage(paramContext);
    case 36: 
      return new ComponentContentGridImage(paramContext);
    case 23: 
    case 120: 
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
    return new ptl().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).o(paramBaseArticleInfo).g(paramBaseArticleInfo).h(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).B(paramBaseArticleInfo).p(paramBaseArticleInfo).q(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).x(paramBaseArticleInfo).z(paramBaseArticleInfo).A(paramBaseArticleInfo).C(paramBaseArticleInfo).a("ReadInjoy_original_cell").D(paramBaseArticleInfo).G(paramBaseArticleInfo).K(paramBaseArticleInfo).k(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).t(paramBaseArticleInfo).N(paramBaseArticleInfo).O(paramBaseArticleInfo).a();
  }
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    qcb localqcb = (qcb)localViewBase.findViewBaseByName("id_middle_body_content");
    if (localqcb != null)
    {
      NativeMiddleBodyView localNativeMiddleBodyView = (NativeMiddleBodyView)localqcb.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localqcb.a(localLayoutParams);
        paramContainer = a(paramInt1, paramContainer.getContext());
        if (paramContainer != null) {
          localNativeMiddleBodyView.a(paramContainer, localLayoutParams);
        }
      }
      a(paramInt1, paramppu, localNativeMiddleBodyView);
    }
    qdk.e(localViewBase, paramppu);
    paramContainer = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((paramContainer != null) && (paramContainer.getNativeView() != null) && ((paramContainer.getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)paramContainer.getNativeView()).setTextColor(-1);
    }
    paramContainer = (qat)localViewBase.findViewBaseByName("id_article_comment");
    if (paramContainer != null) {
      paramContainer.a(paramppu);
    }
    qdk.a(localViewBase, paramppu.a());
    puo.a(localViewBase, paramppu);
    qdk.a(localViewBase, paramppu);
    qdk.b(localViewBase, paramppu);
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
    case 22: 
    case 80: 
      ((ComponentContentUgcImage)paramNativeMiddleBodyView.a()).a(paramppu);
      return;
    case 36: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setMIReadInJoyModel(paramppu);
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramppu.a()));
      ((ComponentContentGridImage)paramNativeMiddleBodyView).setOnNoItemClickListener(new pyq(this, paramppu, localsel));
      return;
    case 23: 
    case 120: 
      paramNativeMiddleBodyView = (ComponentContentUgcVideo)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(paramppu);
      ((ComponentContentUgcVideo)paramNativeMiddleBodyView).setOnClickListener(new pyr(this, paramInt, localsel, paramppu));
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
 * Qualified Name:     pyp
 * JD-Core Version:    0.7.0.1
 */