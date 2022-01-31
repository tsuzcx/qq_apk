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

public class pna
  implements poa
{
  private View a(int paramInt, Context paramContext, pgd parampgd)
  {
    parampgd = parampgd.a();
    if ((parampgd != null) && (parampgd.mSocialFeedInfo != null) && (parampgd.mSocialFeedInfo.jdField_a_of_type_Qmr != null) && (parampgd.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaUtilArrayList != null) && (parampgd.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(parampgd.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaUtilArrayList.size(), parampgd.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, rqj paramrqj)
  {
    int i = a(paramArticleInfo, paramrqj);
    paramrqj = paramrqj.a();
    if (paramrqj != null) {
      paramrqj.a(paramContext, paramArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void a(Context paramContext, pgd parampgd, int paramInt)
  {
    rrl localrrl = parampgd.a().a();
    parampgd = parampgd.a();
    if ((parampgd != null) && (localrrl != null)) {
      localrrl.a(paramContext, parampgd, 0, parampgd.innerUniqueID, 5, paramInt, 0);
    }
  }
  
  private void b(int paramInt1, pgd parampgd, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = parampgd.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaUtilArrayList != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaUtilArrayList.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, parampgd, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampgd, paramInt1));
    paramNativeMiddleBodyView.setMIReadInJoyModel(parampgd);
    paramNativeMiddleBodyView.setGalleryClickListener(new pnf(this, parampgd, paramContainer, paramInt2));
  }
  
  private void c(int paramInt1, pgd parampgd, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    paramNativeMiddleBodyView.a().setOnClickListener(new png(this, parampgd, paramContainer, paramInt2));
    ((pxk)paramNativeMiddleBodyView.a()).a(parampgd);
  }
  
  public int a(ArticleInfo paramArticleInfo, rqj paramrqj)
  {
    return opn.a(paramrqj.a(), ors.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, pgd parampgd, prm paramprm)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 34: 
    case 85: 
      paramContext = new ComponentContentGridImage(paramContext);
      if (paramprm.a())
      {
        paramContext.jdField_a_of_type_Int = paramprm.getComPaddingLeft();
        paramContext.b = paramprm.getComPaddingRight();
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
      return a(paramInt, paramContext, parampgd);
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
    biby.a("PgcProteusItem.getDataJson");
    long l2 = System.currentTimeMillis();
    pjo localpjo = new pjo();
    try
    {
      l1 = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
      biby.a("PgcProteusItem.bindArticleComment");
      if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaLangString != null)))) {
        localpjo.p(paramBaseArticleInfo);
      }
      biby.a();
      biby.a("PgcProteusItem.bindReadArticle");
      if ((paramInt == 34) || (paramInt == 85)) {
        localpjo.c(paramBaseArticleInfo, alud.a(2131708368));
      }
      biby.a();
      if (paramInt == 29) {
        localpjo.c(paramBaseArticleInfo, alud.a(2131708367));
      }
      biby.a("PgcProteusItem.bindTopicCapsule");
      if (paramInt != 29) {
        localpjo.A(paramBaseArticleInfo).D(paramBaseArticleInfo).B(paramBaseArticleInfo);
      }
      biby.a();
      biby.a("PgcProteusItem.bindPublicAccountFollowButton");
      if (((paramBaseArticleInfo instanceof ArticleInfo)) && (rqj.h((ArticleInfo)paramBaseArticleInfo))) {
        localpjo.h(paramBaseArticleInfo);
      }
      biby.a();
      localpjo.a(paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).d(paramBaseArticleInfo).j(paramBaseArticleInfo).g(paramBaseArticleInfo).k(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).C(paramBaseArticleInfo).a("ReadInjoy_original_cell").E(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
      biby.a("PgcProteusItem.bindMiddleBody");
      localpjo.z(paramBaseArticleInfo);
      biby.a();
      biby.a();
      srq.a("PgcProteusItem", String.valueOf(paramInt), "PgcProteusItem.getDataJson", System.currentTimeMillis() - l2);
      return localpjo.a();
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
  
  public void a(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2)
  {
    long l = System.currentTimeMillis();
    biby.a("PgcProteusItem.bindView");
    ViewBase localViewBase = paramContainer.getVirtualView();
    c(paramInt1, paramContainer, parampgd, paramInt2, localViewBase);
    b(parampgd, localViewBase);
    a(parampgd, localViewBase);
    b(paramInt1, paramContainer, parampgd, paramInt2, localViewBase);
    a(paramInt1, paramContainer, parampgd, paramInt2, localViewBase);
    biby.a("PgcProteusItem.bindView.bindJumpChannel");
    psw.a(localViewBase, parampgd);
    biby.a();
    biby.a("PgcProteusItem.bindView.bindSocialCommon");
    psw.b(localViewBase, parampgd);
    biby.a();
    biby.a("PgcProteusItem.bindView.bindFlowGuideSperator");
    psw.c(localViewBase, parampgd);
    biby.a();
    biby.a();
    srq.a("PgcProteusItem", String.valueOf(paramInt1), "PgcProteusItem.bindView", System.currentTimeMillis() - l);
  }
  
  protected void a(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2, ViewBase paramViewBase)
  {
    biby.a("PgcProteusItem.bindView.socialBottomBar");
    paramViewBase = paramViewBase.findViewBaseByName("id_social_bottom");
    if (((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) && (paramViewBase != null) && (paramViewBase.getNativeView() != null)) {
      paramViewBase.getNativeView().setOnClickListener(new pnb(this, paramContainer, parampgd, paramInt2));
    }
    biby.a();
  }
  
  protected void a(int paramInt1, pgd parampgd, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampgd.a() == null)) {
      return;
    }
    rqj localrqj = parampgd.a();
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt1);
    case 34: 
    case 85: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(parampgd, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(parampgd);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new pnd(this, parampgd));
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
      paramNativeMiddleBodyView.a().setOnClickListener(new pne(this, parampgd, localrqj));
      ((pxk)paramNativeMiddleBodyView.a()).a(parampgd);
      return;
    case 48: 
    case 64: 
    case 65: 
      b(paramInt1, parampgd, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    ((pxk)paramNativeMiddleBodyView.a()).a(parampgd);
  }
  
  protected void a(pgd parampgd, ViewBase paramViewBase)
  {
    biby.a("PgcProteusItem.bindView.bindBiuTime");
    psw.a(paramViewBase, parampgd.a());
    biby.a();
  }
  
  public boolean a(int paramInt, Container paramContainer, pgd parampgd, ViewBase paramViewBase)
  {
    return false;
  }
  
  protected void b(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2, ViewBase paramViewBase)
  {
    paramViewBase = (pqe)paramViewBase.findViewBaseByName("id_article_comment");
    biby.a("PgcProteusItem.bindView.commentView");
    if (paramViewBase != null)
    {
      if ((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) {
        paramViewBase.setOnClickListener(new pnc(this, paramContainer, parampgd, paramInt2));
      }
      paramViewBase.setVisibility(0);
    }
    if ((paramViewBase != null) && (paramViewBase.isVisible())) {
      paramViewBase.a(parampgd);
    }
    biby.a();
  }
  
  protected void b(pgd parampgd, ViewBase paramViewBase)
  {
    paramViewBase = (pqg)paramViewBase.findViewBaseByName("id_info_avator");
    if (paramViewBase != null)
    {
      biby.a("PgcProteusItem.bindView. avatar.setModel");
      paramViewBase.a(parampgd);
      biby.a();
    }
  }
  
  protected void c(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2, ViewBase paramViewBase)
  {
    biby.a("PgcProteusItem.bindView.findViewBaseByName");
    prm localprm = (prm)paramViewBase.findViewBaseByName("id_middle_body_content");
    biby.a();
    biby.a("PgcProteusItem.bindView.bodyviewContent");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    if (localprm != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localprm.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), parampgd, localprm);
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label136;
        }
        paramViewBase = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      }
    }
    for (;;)
    {
      localprm.a(paramViewBase);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, paramViewBase);
      }
      biby.a("PgcProteusItem.bindView.bindBodyView");
      a(paramInt1, parampgd, localNativeMiddleBodyView, paramInt2, paramContainer);
      biby.a();
      biby.a();
      return;
      label136:
      paramViewBase = new RelativeLayout.LayoutParams(-2, -2);
      paramViewBase.setMargins(bdoo.a(12.0F), 0, bdoo.a(12.0F), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pna
 * JD-Core Version:    0.7.0.1
 */