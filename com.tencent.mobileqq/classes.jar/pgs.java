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

public class pgs
  implements phs
{
  private View a(int paramInt, Context paramContext, pax parampax)
  {
    parampax = parampax.a();
    if ((parampax != null) && (parampax.mSocialFeedInfo != null) && (parampax.mSocialFeedInfo.jdField_a_of_type_Qcy != null) && (parampax.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaUtilArrayList != null) && (parampax.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(parampax.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaUtilArrayList.size(), parampax.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, rap paramrap)
  {
    int i = a(paramArticleInfo, paramrap);
    paramrap = paramrap.a();
    if (paramrap != null) {
      paramrap.a(paramContext, paramArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void a(Context paramContext, pax parampax, int paramInt)
  {
    rbr localrbr = parampax.a().a();
    parampax = parampax.a();
    if ((parampax != null) && (localrbr != null)) {
      localrbr.a(paramContext, parampax, 0, parampax.innerUniqueID, 5, paramInt, 0);
    }
  }
  
  private void b(int paramInt1, pax parampax, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = parampax.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaUtilArrayList != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaUtilArrayList.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, parampax, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampax, paramInt1));
    paramNativeMiddleBodyView.setMIReadInJoyModel(parampax);
    paramNativeMiddleBodyView.setGalleryClickListener(new pgx(this, parampax, paramContainer, paramInt2));
  }
  
  private void c(int paramInt1, pax parampax, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    paramNativeMiddleBodyView.a().setOnClickListener(new pgy(this, parampax, paramContainer, paramInt2));
    ((pqs)paramNativeMiddleBodyView.a()).a(parampax);
  }
  
  public int a(ArticleInfo paramArticleInfo, rap paramrap)
  {
    return olg.a(paramrap.a(), onk.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, pax parampax, pll parampll)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 34: 
    case 85: 
      paramContext = new ComponentContentGridImage(paramContext);
      if (parampll.a())
      {
        paramContext.jdField_a_of_type_Int = parampll.getComPaddingLeft();
        paramContext.b = parampll.getComPaddingRight();
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
      return a(paramInt, paramContext, parampax);
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
    bfwd.a("PgcProteusItem.getDataJson");
    long l2 = System.currentTimeMillis();
    pdp localpdp = new pdp();
    try
    {
      l1 = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
      bfwd.a("PgcProteusItem.bindArticleComment");
      if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaLangString != null)))) {
        localpdp.p(paramBaseArticleInfo);
      }
      bfwd.a();
      bfwd.a("PgcProteusItem.bindReadArticle");
      if ((paramInt == 34) || (paramInt == 85)) {
        localpdp.b(paramBaseArticleInfo, ajyc.a(2131707973));
      }
      bfwd.a();
      if (paramInt == 29) {
        localpdp.b(paramBaseArticleInfo, ajyc.a(2131707972));
      }
      bfwd.a("PgcProteusItem.bindTopicCapsule");
      if (paramInt != 29) {
        localpdp.A(paramBaseArticleInfo).D(paramBaseArticleInfo).B(paramBaseArticleInfo);
      }
      bfwd.a();
      bfwd.a("PgcProteusItem.bindPublicAccountFollowButton");
      if (((paramBaseArticleInfo instanceof ArticleInfo)) && (rap.h((ArticleInfo)paramBaseArticleInfo))) {
        localpdp.h(paramBaseArticleInfo);
      }
      bfwd.a();
      localpdp.a(paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).d(paramBaseArticleInfo).j(paramBaseArticleInfo).g(paramBaseArticleInfo).k(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).C(paramBaseArticleInfo).a("ReadInjoy_original_cell").E(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
      bfwd.a("PgcProteusItem.bindMiddleBody");
      localpdp.z(paramBaseArticleInfo);
      bfwd.a();
      bfwd.a();
      sai.a("PgcProteusItem", String.valueOf(paramInt), "PgcProteusItem.getDataJson", System.currentTimeMillis() - l2);
      return localpdp.a();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
        long l1 = 0L;
      }
    }
  }
  
  public void a(int paramInt1, Container paramContainer, pax parampax, int paramInt2)
  {
    long l = System.currentTimeMillis();
    bfwd.a("PgcProteusItem.bindView");
    ViewBase localViewBase = paramContainer.getVirtualView();
    c(paramInt1, paramContainer, parampax, paramInt2, localViewBase);
    b(parampax, localViewBase);
    a(parampax, localViewBase);
    b(paramInt1, paramContainer, parampax, paramInt2, localViewBase);
    a(paramInt1, paramContainer, parampax, paramInt2, localViewBase);
    bfwd.a("PgcProteusItem.bindView.bindJumpChannel");
    pmr.a(localViewBase, parampax);
    bfwd.a();
    bfwd.a("PgcProteusItem.bindView.bindSocialCommon");
    pmr.b(localViewBase, parampax);
    bfwd.a();
    bfwd.a("PgcProteusItem.bindView.bindFlowGuideSperator");
    pmr.c(localViewBase, parampax);
    bfwd.a();
    bfwd.a();
    sai.a("PgcProteusItem", String.valueOf(paramInt1), "PgcProteusItem.bindView", System.currentTimeMillis() - l);
  }
  
  protected void a(int paramInt1, Container paramContainer, pax parampax, int paramInt2, ViewBase paramViewBase)
  {
    bfwd.a("PgcProteusItem.bindView.socialBottomBar");
    paramViewBase = paramViewBase.findViewBaseByName("id_social_bottom");
    if (((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) && (paramViewBase != null) && (paramViewBase.getNativeView() != null)) {
      paramViewBase.getNativeView().setOnClickListener(new pgt(this, paramContainer, parampax, paramInt2));
    }
    bfwd.a();
  }
  
  protected void a(int paramInt1, pax parampax, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampax.a() == null)) {
      return;
    }
    rap localrap = parampax.a();
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt1);
    case 34: 
    case 85: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampax, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(parampax);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new pgv(this, parampax));
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
      paramNativeMiddleBodyView.a().setOnClickListener(new pgw(this, parampax, localrap));
      ((pqs)paramNativeMiddleBodyView.a()).a(parampax);
      return;
    case 48: 
    case 64: 
    case 65: 
      b(paramInt1, parampax, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    ((pqs)paramNativeMiddleBodyView.a()).a(parampax);
  }
  
  protected void a(pax parampax, ViewBase paramViewBase)
  {
    bfwd.a("PgcProteusItem.bindView.bindBiuTime");
    pmr.a(paramViewBase, parampax.a());
    bfwd.a();
  }
  
  public boolean a(int paramInt, Container paramContainer, pax parampax, ViewBase paramViewBase)
  {
    return false;
  }
  
  protected void b(int paramInt1, Container paramContainer, pax parampax, int paramInt2, ViewBase paramViewBase)
  {
    paramViewBase = (pjv)paramViewBase.findViewBaseByName("id_article_comment");
    bfwd.a("PgcProteusItem.bindView.commentView");
    if (paramViewBase != null)
    {
      if ((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) {
        paramViewBase.setOnClickListener(new pgu(this, paramContainer, parampax, paramInt2));
      }
      paramViewBase.setVisibility(0);
    }
    if ((paramViewBase != null) && (paramViewBase.isVisible())) {
      paramViewBase.a(parampax);
    }
    bfwd.a();
  }
  
  protected void b(pax parampax, ViewBase paramViewBase)
  {
    paramViewBase = (pjx)paramViewBase.findViewBaseByName("id_info_avator");
    if (paramViewBase != null)
    {
      bfwd.a("PgcProteusItem.bindView. avatar.setModel");
      paramViewBase.a(parampax);
      bfwd.a();
    }
  }
  
  protected void c(int paramInt1, Container paramContainer, pax parampax, int paramInt2, ViewBase paramViewBase)
  {
    bfwd.a("PgcProteusItem.bindView.findViewBaseByName");
    pll localpll = (pll)paramViewBase.findViewBaseByName("id_middle_body_content");
    bfwd.a();
    bfwd.a("PgcProteusItem.bindView.bodyviewContent");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    if (localpll != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localpll.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), parampax, localpll);
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label136;
        }
        paramViewBase = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      }
    }
    for (;;)
    {
      localpll.a(paramViewBase);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, paramViewBase);
      }
      bfwd.a("PgcProteusItem.bindView.bindBodyView");
      a(paramInt1, parampax, localNativeMiddleBodyView, paramInt2, paramContainer);
      bfwd.a();
      bfwd.a();
      return;
      label136:
      paramViewBase = new RelativeLayout.LayoutParams(-2, -2);
      paramViewBase.setMargins(bbkx.a(12.0F), 0, bbkx.a(12.0F), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgs
 * JD-Core Version:    0.7.0.1
 */