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

public class pgp
  implements php
{
  private View a(int paramInt, Context paramContext, pau parampau)
  {
    parampau = parampau.a();
    if ((parampau != null) && (parampau.mSocialFeedInfo != null) && (parampau.mSocialFeedInfo.jdField_a_of_type_Qcv != null) && (parampau.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaUtilArrayList != null) && (parampau.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(parampau.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaUtilArrayList.size(), parampau.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, ram paramram)
  {
    int i = a(paramArticleInfo, paramram);
    paramram = paramram.a();
    if (paramram != null) {
      paramram.a(paramContext, paramArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void a(Context paramContext, pau parampau, int paramInt)
  {
    rbo localrbo = parampau.a().a();
    parampau = parampau.a();
    if ((parampau != null) && (localrbo != null)) {
      localrbo.a(paramContext, parampau, 0, parampau.innerUniqueID, 5, paramInt, 0);
    }
  }
  
  private void b(int paramInt1, pau parampau, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = parampau.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaUtilArrayList != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaUtilArrayList.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, parampau, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampau, paramInt1));
    paramNativeMiddleBodyView.setMIReadInJoyModel(parampau);
    paramNativeMiddleBodyView.setGalleryClickListener(new pgu(this, parampau, paramContainer, paramInt2));
  }
  
  private void c(int paramInt1, pau parampau, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    paramNativeMiddleBodyView.a().setOnClickListener(new pgv(this, parampau, paramContainer, paramInt2));
    ((pqp)paramNativeMiddleBodyView.a()).a(parampau);
  }
  
  public int a(ArticleInfo paramArticleInfo, ram paramram)
  {
    return old.a(paramram.a(), onh.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, pau parampau, pli parampli)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 34: 
    case 85: 
      paramContext = new ComponentContentGridImage(paramContext);
      if (parampli.a())
      {
        paramContext.jdField_a_of_type_Int = parampli.getComPaddingLeft();
        paramContext.b = parampli.getComPaddingRight();
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
      return a(paramInt, paramContext, parampau);
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
    bfwu.a("PgcProteusItem.getDataJson");
    long l2 = System.currentTimeMillis();
    pdm localpdm = new pdm();
    try
    {
      l1 = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
      bfwu.a("PgcProteusItem.bindArticleComment");
      if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaLangString != null)))) {
        localpdm.p(paramBaseArticleInfo);
      }
      bfwu.a();
      bfwu.a("PgcProteusItem.bindReadArticle");
      if ((paramInt == 34) || (paramInt == 85)) {
        localpdm.b(paramBaseArticleInfo, ajya.a(2131707984));
      }
      bfwu.a();
      if (paramInt == 29) {
        localpdm.b(paramBaseArticleInfo, ajya.a(2131707983));
      }
      bfwu.a("PgcProteusItem.bindTopicCapsule");
      if (paramInt != 29) {
        localpdm.A(paramBaseArticleInfo).D(paramBaseArticleInfo).B(paramBaseArticleInfo);
      }
      bfwu.a();
      bfwu.a("PgcProteusItem.bindPublicAccountFollowButton");
      if (((paramBaseArticleInfo instanceof ArticleInfo)) && (ram.h((ArticleInfo)paramBaseArticleInfo))) {
        localpdm.h(paramBaseArticleInfo);
      }
      bfwu.a();
      localpdm.a(paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).d(paramBaseArticleInfo).j(paramBaseArticleInfo).g(paramBaseArticleInfo).k(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).C(paramBaseArticleInfo).a("ReadInjoy_original_cell").E(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
      bfwu.a("PgcProteusItem.bindMiddleBody");
      localpdm.z(paramBaseArticleInfo);
      bfwu.a();
      bfwu.a();
      saf.a("PgcProteusItem", String.valueOf(paramInt), "PgcProteusItem.getDataJson", System.currentTimeMillis() - l2);
      return localpdm.a();
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
  
  public void a(int paramInt1, Container paramContainer, pau parampau, int paramInt2)
  {
    long l = System.currentTimeMillis();
    bfwu.a("PgcProteusItem.bindView");
    ViewBase localViewBase = paramContainer.getVirtualView();
    c(paramInt1, paramContainer, parampau, paramInt2, localViewBase);
    b(parampau, localViewBase);
    a(parampau, localViewBase);
    b(paramInt1, paramContainer, parampau, paramInt2, localViewBase);
    a(paramInt1, paramContainer, parampau, paramInt2, localViewBase);
    bfwu.a("PgcProteusItem.bindView.bindJumpChannel");
    pmo.a(localViewBase, parampau);
    bfwu.a();
    bfwu.a("PgcProteusItem.bindView.bindSocialCommon");
    pmo.b(localViewBase, parampau);
    bfwu.a();
    bfwu.a("PgcProteusItem.bindView.bindFlowGuideSperator");
    pmo.c(localViewBase, parampau);
    bfwu.a();
    bfwu.a();
    saf.a("PgcProteusItem", String.valueOf(paramInt1), "PgcProteusItem.bindView", System.currentTimeMillis() - l);
  }
  
  protected void a(int paramInt1, Container paramContainer, pau parampau, int paramInt2, ViewBase paramViewBase)
  {
    bfwu.a("PgcProteusItem.bindView.socialBottomBar");
    paramViewBase = paramViewBase.findViewBaseByName("id_social_bottom");
    if (((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) && (paramViewBase != null) && (paramViewBase.getNativeView() != null)) {
      paramViewBase.getNativeView().setOnClickListener(new pgq(this, paramContainer, parampau, paramInt2));
    }
    bfwu.a();
  }
  
  protected void a(int paramInt1, pau parampau, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampau.a() == null)) {
      return;
    }
    ram localram = parampau.a();
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt1);
    case 34: 
    case 85: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampau, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(parampau);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new pgs(this, parampau));
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
      paramNativeMiddleBodyView.a().setOnClickListener(new pgt(this, parampau, localram));
      ((pqp)paramNativeMiddleBodyView.a()).a(parampau);
      return;
    case 48: 
    case 64: 
    case 65: 
      b(paramInt1, parampau, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    ((pqp)paramNativeMiddleBodyView.a()).a(parampau);
  }
  
  protected void a(pau parampau, ViewBase paramViewBase)
  {
    bfwu.a("PgcProteusItem.bindView.bindBiuTime");
    pmo.a(paramViewBase, parampau.a());
    bfwu.a();
  }
  
  public boolean a(int paramInt, Container paramContainer, pau parampau, ViewBase paramViewBase)
  {
    return false;
  }
  
  protected void b(int paramInt1, Container paramContainer, pau parampau, int paramInt2, ViewBase paramViewBase)
  {
    paramViewBase = (pjs)paramViewBase.findViewBaseByName("id_article_comment");
    bfwu.a("PgcProteusItem.bindView.commentView");
    if (paramViewBase != null)
    {
      if ((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) {
        paramViewBase.setOnClickListener(new pgr(this, paramContainer, parampau, paramInt2));
      }
      paramViewBase.setVisibility(0);
    }
    if ((paramViewBase != null) && (paramViewBase.isVisible())) {
      paramViewBase.a(parampau);
    }
    bfwu.a();
  }
  
  protected void b(pau parampau, ViewBase paramViewBase)
  {
    paramViewBase = (pju)paramViewBase.findViewBaseByName("id_info_avator");
    if (paramViewBase != null)
    {
      bfwu.a("PgcProteusItem.bindView. avatar.setModel");
      paramViewBase.a(parampau);
      bfwu.a();
    }
  }
  
  protected void c(int paramInt1, Container paramContainer, pau parampau, int paramInt2, ViewBase paramViewBase)
  {
    bfwu.a("PgcProteusItem.bindView.findViewBaseByName");
    pli localpli = (pli)paramViewBase.findViewBaseByName("id_middle_body_content");
    bfwu.a();
    bfwu.a("PgcProteusItem.bindView.bodyviewContent");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    if (localpli != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localpli.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), parampau, localpli);
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label136;
        }
        paramViewBase = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      }
    }
    for (;;)
    {
      localpli.a(paramViewBase);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, paramViewBase);
      }
      bfwu.a("PgcProteusItem.bindView.bindBodyView");
      a(paramInt1, parampau, localNativeMiddleBodyView, paramInt2, paramContainer);
      bfwu.a();
      bfwu.a();
      return;
      label136:
      paramViewBase = new RelativeLayout.LayoutParams(-2, -2);
      paramViewBase.setMargins(bbll.a(12.0F), 0, bbll.a(12.0F), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgp
 * JD-Core Version:    0.7.0.1
 */