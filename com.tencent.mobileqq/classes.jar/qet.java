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

public class qet
  implements qft
{
  private View a(int paramInt, Context paramContext, pxk parampxk)
  {
    parampxk = parampxk.a();
    if ((parampxk != null) && (parampxk.mSocialFeedInfo != null) && (parampxk.mSocialFeedInfo.jdField_a_of_type_Rhn != null) && (parampxk.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaUtilArrayList != null) && (parampxk.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(parampxk.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaUtilArrayList.size(), parampxk.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, snh paramsnh)
  {
    int i = a(paramArticleInfo, paramsnh);
    paramsnh = paramsnh.a();
    if (paramsnh != null) {
      paramsnh.a(paramContext, paramArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void a(Context paramContext, pxk parampxk, int paramInt)
  {
    soy localsoy = parampxk.a().a();
    parampxk = parampxk.a();
    if ((parampxk != null) && (localsoy != null)) {
      localsoy.a(paramContext, parampxk, 0, parampxk.innerUniqueID, 5, paramInt, 0);
    }
  }
  
  private void b(int paramInt1, pxk parampxk, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = parampxk.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaUtilArrayList != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaUtilArrayList.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, parampxk, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampxk, paramInt1));
    paramNativeMiddleBodyView.setMIReadInJoyModel(parampxk);
    paramNativeMiddleBodyView.setGalleryClickListener(new qey(this, parampxk, paramContainer, paramInt2));
  }
  
  private void c(int paramInt1, pxk parampxk, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    paramNativeMiddleBodyView.a().setOnClickListener(new qez(this, parampxk, paramContainer, paramInt2));
    ((qqs)paramNativeMiddleBodyView.a()).a(parampxk);
  }
  
  public int a(ArticleInfo paramArticleInfo, snh paramsnh)
  {
    return pfe.a(paramsnh.a(), pha.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, pxk parampxk, qjp paramqjp)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 34: 
    case 85: 
      paramContext = new ComponentContentGridImage(paramContext);
      if (paramqjp.a())
      {
        paramContext.jdField_a_of_type_Int = paramqjp.getComPaddingLeft();
        paramContext.b = paramqjp.getComPaddingRight();
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
      return a(paramInt, paramContext, parampxk);
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
    bkpj.a("PgcProteusItem.getDataJson");
    long l3 = System.currentTimeMillis();
    qba localqba = new qba();
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
    bkpj.a("PgcProteusItem.bindArticleComment");
    if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaLangString != null)))) {
      localqba.o(paramBaseArticleInfo);
    }
    bkpj.a();
    bkpj.a("PgcProteusItem.bindReadArticle");
    if ((paramInt == 34) || (paramInt == 85)) {
      localqba.c(paramBaseArticleInfo, anni.a(2131706745));
    }
    bkpj.a();
    if (paramInt == 29) {
      localqba.c(paramBaseArticleInfo, anni.a(2131706744));
    }
    bkpj.a("PgcProteusItem.bindTopicCapsule");
    if (paramInt != 29) {
      localqba.z(paramBaseArticleInfo).C(paramBaseArticleInfo).A(paramBaseArticleInfo);
    }
    bkpj.a();
    bkpj.a("PgcProteusItem.bindPublicAccountFollowButton");
    bkpj.a();
    localqba.a(paramBaseArticleInfo).b(paramBaseArticleInfo).q(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).d(paramBaseArticleInfo).i(paramBaseArticleInfo).h(paramBaseArticleInfo).g(paramBaseArticleInfo).j(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).B(paramBaseArticleInfo).a("ReadInjoy_original_cell").D(paramBaseArticleInfo).k(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).t(paramBaseArticleInfo);
    bkpj.a("PgcProteusItem.bindMiddleBody");
    localqba.y(paramBaseArticleInfo);
    bkpj.a();
    bkpj.a();
    ttf.a("PgcProteusItem", String.valueOf(paramInt), "PgcProteusItem.getDataJson", System.currentTimeMillis() - l3);
    return localqba.a();
  }
  
  public void a(int paramInt1, Container paramContainer, pxk parampxk, int paramInt2)
  {
    long l = System.currentTimeMillis();
    bkpj.a("PgcProteusItem.bindView");
    ViewBase localViewBase = paramContainer.getVirtualView();
    c(paramInt1, paramContainer, parampxk, paramInt2, localViewBase);
    b(parampxk, localViewBase);
    a(parampxk, localViewBase);
    b(paramInt1, paramContainer, parampxk, paramInt2, localViewBase);
    a(paramInt1, paramContainer, parampxk, paramInt2, localViewBase);
    bkpj.a("PgcProteusItem.bindView.bindJumpChannel");
    qky.a(localViewBase, parampxk);
    bkpj.a();
    bkpj.a("PgcProteusItem.bindView.bindSocialCommon");
    qky.b(localViewBase, parampxk);
    bkpj.a();
    bkpj.a("PgcProteusItem.bindView.bindFlowGuideSperator");
    qky.c(localViewBase, parampxk);
    bkpj.a();
    bkpj.a();
    ttf.a("PgcProteusItem", String.valueOf(paramInt1), "PgcProteusItem.bindView", System.currentTimeMillis() - l);
  }
  
  protected void a(int paramInt1, Container paramContainer, pxk parampxk, int paramInt2, ViewBase paramViewBase)
  {
    bkpj.a("PgcProteusItem.bindView.socialBottomBar");
    paramViewBase = paramViewBase.findViewBaseByName("id_social_bottom");
    if (((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) && (paramViewBase != null) && (paramViewBase.getNativeView() != null)) {
      paramViewBase.getNativeView().setOnClickListener(new qeu(this, paramContainer, parampxk, paramInt2));
    }
    bkpj.a();
  }
  
  protected void a(int paramInt1, pxk parampxk, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampxk.a() == null)) {
      return;
    }
    snh localsnh = parampxk.a();
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt1);
    case 34: 
    case 85: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampxk, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(parampxk);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new qew(this, parampxk));
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
      paramNativeMiddleBodyView.a().setOnClickListener(new qex(this, parampxk, localsnh));
      ((qqs)paramNativeMiddleBodyView.a()).a(parampxk);
      return;
    case 48: 
    case 64: 
    case 65: 
      b(paramInt1, parampxk, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    ((qqs)paramNativeMiddleBodyView.a()).a(parampxk);
  }
  
  protected void a(pxk parampxk, ViewBase paramViewBase)
  {
    bkpj.a("PgcProteusItem.bindView.bindBiuTime");
    qky.a(paramViewBase, parampxk.a());
    bkpj.a();
  }
  
  public boolean a(int paramInt, Container paramContainer, pxk parampxk, ViewBase paramViewBase)
  {
    return false;
  }
  
  protected void b(int paramInt1, Container paramContainer, pxk parampxk, int paramInt2, ViewBase paramViewBase)
  {
    paramViewBase = (qih)paramViewBase.findViewBaseByName("id_article_comment");
    bkpj.a("PgcProteusItem.bindView.commentView");
    if (paramViewBase != null)
    {
      if ((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) {
        paramViewBase.setOnClickListener(new qev(this, paramContainer, parampxk, paramInt2));
      }
      paramViewBase.setVisibility(0);
    }
    if ((paramViewBase != null) && (paramViewBase.isVisible())) {
      paramViewBase.a(parampxk);
    }
    bkpj.a();
  }
  
  protected void b(pxk parampxk, ViewBase paramViewBase)
  {
    qky.e(paramViewBase, parampxk);
  }
  
  protected void c(int paramInt1, Container paramContainer, pxk parampxk, int paramInt2, ViewBase paramViewBase)
  {
    bkpj.a("PgcProteusItem.bindView.findViewBaseByName");
    qjp localqjp = (qjp)paramViewBase.findViewBaseByName("id_middle_body_content");
    bkpj.a();
    bkpj.a("PgcProteusItem.bindView.bodyviewContent");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    if (localqjp != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localqjp.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), parampxk, localqjp);
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label136;
        }
      }
    }
    label136:
    for (paramViewBase = (RelativeLayout.LayoutParams)localView.getLayoutParams();; paramViewBase = new RelativeLayout.LayoutParams(-2, -2))
    {
      localqjp.a(paramViewBase);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, paramViewBase);
      }
      bkpj.a("PgcProteusItem.bindView.bindBodyView");
      a(paramInt1, parampxk, localNativeMiddleBodyView, paramInt2, paramContainer);
      bkpj.a();
      bkpj.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qet
 * JD-Core Version:    0.7.0.1
 */