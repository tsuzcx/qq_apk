import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentPgcVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.ArrayList;
import org.json.JSONObject;

public class qcy
  implements qdy
{
  private View a(int paramInt, Context paramContext, pvc parampvc)
  {
    parampvc = parampvc.a();
    if ((parampvc != null) && (parampvc.mSocialFeedInfo != null) && (parampvc.mSocialFeedInfo.jdField_a_of_type_Rfe != null) && (parampvc.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaUtilArrayList != null) && (parampvc.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(parampvc.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaUtilArrayList.size(), parampvc.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, slt paramslt)
  {
    int i = a(paramArticleInfo, paramslt);
    paramslt = paramslt.a().a();
    if (paramslt != null) {
      paramslt.a(paramContext, paramArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void a(Context paramContext, pvc parampvc, int paramInt)
  {
    peq localpeq = parampvc.a().a().a();
    parampvc = parampvc.a();
    if ((parampvc != null) && (localpeq != null)) {
      localpeq.a(paramContext, parampvc, 0, parampvc.innerUniqueID, 5, paramInt, 0);
    }
  }
  
  private void b(int paramInt1, pvc parampvc, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = parampvc.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaUtilArrayList != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaUtilArrayList.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, parampvc, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampvc, paramInt1));
    paramNativeMiddleBodyView.setMIReadInJoyModel(parampvc);
    paramNativeMiddleBodyView.setGalleryClickListener(new qdd(this, parampvc, paramContainer, paramInt2));
  }
  
  private void c(int paramInt1, pvc parampvc, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    paramNativeMiddleBodyView.a().setOnClickListener(new qde(this, parampvc, paramContainer, paramInt2));
    ((qpj)paramNativeMiddleBodyView.a()).a(parampvc);
  }
  
  public int a(ArticleInfo paramArticleInfo, slt paramslt)
  {
    return ozb.a(paramslt.a(), pay.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, pvc parampvc, qhz paramqhz)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 34: 
    case 85: 
      paramContext = new ComponentContentGridImage(paramContext);
      if (paramqhz.a())
      {
        paramContext.jdField_a_of_type_Int = paramqhz.getComPaddingLeft();
        paramContext.b = paramqhz.getComPaddingRight();
      }
      return paramContext;
    case 16: 
    case 20: 
    case 83: 
    case 86: 
      return new PgcSmallView(paramInt, paramContext);
    case 17: 
    case 19: 
    case 32: 
    case 84: 
      return new ComponentContentPgcVideo(paramContext);
    case 18: 
      return new ComponentContentBig(paramContext);
    case 48: 
    case 64: 
    case 65: 
      return a(paramInt, paramContext, parampvc);
    case 29: 
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentBig(paramContext);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    bjun.a("PgcProteusItem.getDataJson");
    long l3 = System.currentTimeMillis();
    pzf localpzf = new pzf();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    bjun.a("PgcProteusItem.bindArticleComment");
    if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaLangString != null)))) {
      localpzf.o(paramBaseArticleInfo);
    }
    bjun.a();
    bjun.a("PgcProteusItem.bindReadArticle");
    if ((paramInt == 34) || (paramInt == 85)) {
      localpzf.c(paramBaseArticleInfo, amtj.a(2131707086));
    }
    bjun.a();
    if (paramInt == 29) {
      localpzf.c(paramBaseArticleInfo, amtj.a(2131707085));
    }
    bjun.a("PgcProteusItem.bindTopicCapsule");
    if (paramInt != 29) {
      localpzf.z(paramBaseArticleInfo).C(paramBaseArticleInfo).A(paramBaseArticleInfo);
    }
    bjun.a();
    bjun.a("PgcProteusItem.bindPublicAccountFollowButton");
    bjun.a();
    localpzf.a(paramBaseArticleInfo).b(paramBaseArticleInfo).q(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).d(paramBaseArticleInfo).i(paramBaseArticleInfo).h(paramBaseArticleInfo).g(paramBaseArticleInfo).j(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).B(paramBaseArticleInfo).a("ReadInjoy_original_cell").D(paramBaseArticleInfo).k(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).t(paramBaseArticleInfo);
    bjun.a("PgcProteusItem.bindMiddleBody");
    localpzf.y(paramBaseArticleInfo);
    bjun.a();
    bjun.a();
    tpl.a("PgcProteusItem", String.valueOf(paramInt), "PgcProteusItem.getDataJson", System.currentTimeMillis() - l3);
    return localpzf.a();
  }
  
  public void a(int paramInt1, Container paramContainer, pvc parampvc, int paramInt2)
  {
    long l = System.currentTimeMillis();
    bjun.a("PgcProteusItem.bindView");
    ViewBase localViewBase = paramContainer.getVirtualView();
    c(paramInt1, paramContainer, parampvc, paramInt2, localViewBase);
    b(parampvc, localViewBase);
    a(parampvc, localViewBase);
    b(paramInt1, paramContainer, parampvc, paramInt2, localViewBase);
    a(paramInt1, paramContainer, parampvc, paramInt2, localViewBase);
    bjun.a("PgcProteusItem.bindView.bindJumpChannel");
    qji.a(localViewBase, parampvc);
    bjun.a();
    bjun.a("PgcProteusItem.bindView.bindSocialCommon");
    qji.b(localViewBase, parampvc);
    bjun.a();
    bjun.a("PgcProteusItem.bindView.bindFlowGuideSperator");
    qji.c(localViewBase, parampvc);
    bjun.a();
    bjun.a();
    tpl.a("PgcProteusItem", String.valueOf(paramInt1), "PgcProteusItem.bindView", System.currentTimeMillis() - l);
  }
  
  protected void a(int paramInt1, Container paramContainer, pvc parampvc, int paramInt2, ViewBase paramViewBase)
  {
    bjun.a("PgcProteusItem.bindView.socialBottomBar");
    paramViewBase = paramViewBase.findViewBaseByName("id_social_bottom");
    if (((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) && (paramViewBase != null) && (paramViewBase.getNativeView() != null)) {
      paramViewBase.getNativeView().setOnClickListener(new qcz(this, paramContainer, parampvc, paramInt2));
    }
    bjun.a();
  }
  
  protected void a(int paramInt1, pvc parampvc, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampvc.a() == null)) {
      return;
    }
    slt localslt = parampvc.a();
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt1);
    case 34: 
    case 85: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampvc, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(parampvc);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new qdb(this, parampvc));
      return;
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 31: 
    case 32: 
    case 83: 
    case 84: 
    case 86: 
      paramNativeMiddleBodyView.a().setOnClickListener(new qdc(this, parampvc, localslt));
      ((qpj)paramNativeMiddleBodyView.a()).a(parampvc);
      return;
    case 48: 
    case 64: 
    case 65: 
      b(paramInt1, parampvc, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    ((qpj)paramNativeMiddleBodyView.a()).a(parampvc);
  }
  
  protected void a(pvc parampvc, ViewBase paramViewBase)
  {
    bjun.a("PgcProteusItem.bindView.bindBiuTime");
    qji.a(paramViewBase, parampvc.a());
    bjun.a();
  }
  
  public boolean a(int paramInt, Container paramContainer, pvc parampvc, ViewBase paramViewBase)
  {
    return false;
  }
  
  protected void b(int paramInt1, Container paramContainer, pvc parampvc, int paramInt2, ViewBase paramViewBase)
  {
    paramViewBase = (qgr)paramViewBase.findViewBaseByName("id_article_comment");
    bjun.a("PgcProteusItem.bindView.commentView");
    if (paramViewBase != null)
    {
      if ((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) {
        paramViewBase.setOnClickListener(new qda(this, paramContainer, parampvc, paramInt2));
      }
      paramViewBase.setVisibility(0);
    }
    if ((paramViewBase != null) && (paramViewBase.isVisible())) {
      paramViewBase.a(parampvc);
    }
    bjun.a();
  }
  
  protected void b(pvc parampvc, ViewBase paramViewBase)
  {
    qji.e(paramViewBase, parampvc);
  }
  
  protected void c(int paramInt1, Container paramContainer, pvc parampvc, int paramInt2, ViewBase paramViewBase)
  {
    bjun.a("PgcProteusItem.bindView.findViewBaseByName");
    qhz localqhz = (qhz)paramViewBase.findViewBaseByName("id_middle_body_content");
    bjun.a();
    bjun.a("PgcProteusItem.bindView.bodyviewContent");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    if (localqhz != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localqhz.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), parampvc, localqhz);
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label136;
        }
      }
    }
    label136:
    for (paramViewBase = (RelativeLayout.LayoutParams)localView.getLayoutParams();; paramViewBase = new RelativeLayout.LayoutParams(-2, -2))
    {
      localqhz.a(paramViewBase);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, paramViewBase);
      }
      bjun.a("PgcProteusItem.bindView.bindBodyView");
      a(paramInt1, parampvc, localNativeMiddleBodyView, paramInt2, paramContainer);
      bjun.a();
      bjun.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qcy
 * JD-Core Version:    0.7.0.1
 */