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

public class pxe
  implements pye
{
  private View a(int paramInt, Context paramContext, ppu paramppu)
  {
    paramppu = paramppu.a();
    if ((paramppu != null) && (paramppu.mSocialFeedInfo != null) && (paramppu.mSocialFeedInfo.jdField_a_of_type_Qyg != null) && (paramppu.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaUtilArrayList != null) && (paramppu.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(paramppu.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaUtilArrayList.size(), paramppu.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, sel paramsel)
  {
    int i = a(paramArticleInfo, paramsel);
    paramsel = paramsel.a();
    if (paramsel != null) {
      paramsel.a(paramContext, paramArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void a(Context paramContext, ppu paramppu, int paramInt)
  {
    sgc localsgc = paramppu.a().a();
    paramppu = paramppu.a();
    if ((paramppu != null) && (localsgc != null)) {
      localsgc.a(paramContext, paramppu, 0, paramppu.innerUniqueID, 5, paramInt, 0);
    }
  }
  
  private void b(int paramInt1, ppu paramppu, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = paramppu.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaUtilArrayList != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaUtilArrayList.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, paramppu, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramppu, paramInt1));
    paramNativeMiddleBodyView.setMIReadInJoyModel(paramppu);
    paramNativeMiddleBodyView.setGalleryClickListener(new pxj(this, paramppu, paramContainer, paramInt2));
  }
  
  private void c(int paramInt1, ppu paramppu, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    paramNativeMiddleBodyView.a().setOnClickListener(new pxk(this, paramppu, paramContainer, paramInt2));
    ((qjg)paramNativeMiddleBodyView.a()).a(paramppu);
  }
  
  public int a(ArticleInfo paramArticleInfo, sel paramsel)
  {
    return oxw.a(paramsel.a(), ozs.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, ppu paramppu, qcb paramqcb)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 34: 
    case 85: 
      paramContext = new ComponentContentGridImage(paramContext);
      if (paramqcb.a())
      {
        paramContext.jdField_a_of_type_Int = paramqcb.getComPaddingLeft();
        paramContext.b = paramqcb.getComPaddingRight();
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
      return a(paramInt, paramContext, paramppu);
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
    blqm.a("PgcProteusItem.getDataJson");
    long l3 = System.currentTimeMillis();
    ptl localptl = new ptl();
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
    blqm.a("PgcProteusItem.bindArticleComment");
    if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaLangString != null)))) {
      localptl.o(paramBaseArticleInfo);
    }
    blqm.a();
    blqm.a("PgcProteusItem.bindReadArticle");
    if ((paramInt == 34) || (paramInt == 85)) {
      localptl.c(paramBaseArticleInfo, anzj.a(2131706854));
    }
    blqm.a();
    if (paramInt == 29) {
      localptl.c(paramBaseArticleInfo, anzj.a(2131706853));
    }
    blqm.a("PgcProteusItem.bindTopicCapsule");
    if (paramInt != 29) {
      localptl.z(paramBaseArticleInfo).C(paramBaseArticleInfo).A(paramBaseArticleInfo);
    }
    blqm.a();
    blqm.a("PgcProteusItem.bindPublicAccountFollowButton");
    blqm.a();
    localptl.a(paramBaseArticleInfo).b(paramBaseArticleInfo).q(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).d(paramBaseArticleInfo).i(paramBaseArticleInfo).h(paramBaseArticleInfo).g(paramBaseArticleInfo).j(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).B(paramBaseArticleInfo).a("ReadInjoy_original_cell").D(paramBaseArticleInfo).k(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).t(paramBaseArticleInfo);
    blqm.a("PgcProteusItem.bindMiddleBody");
    localptl.y(paramBaseArticleInfo);
    blqm.a();
    blqm.a();
    tkb.a("PgcProteusItem", String.valueOf(paramInt), "PgcProteusItem.getDataJson", System.currentTimeMillis() - l3);
    return localptl.a();
  }
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    long l = System.currentTimeMillis();
    blqm.a("PgcProteusItem.bindView");
    ViewBase localViewBase = paramContainer.getVirtualView();
    c(paramInt1, paramContainer, paramppu, paramInt2, localViewBase);
    b(paramppu, localViewBase);
    a(paramppu, localViewBase);
    b(paramInt1, paramContainer, paramppu, paramInt2, localViewBase);
    a(paramInt1, paramContainer, paramppu, paramInt2, localViewBase);
    blqm.a("PgcProteusItem.bindView.bindJumpChannel");
    qdk.a(localViewBase, paramppu);
    blqm.a();
    blqm.a("PgcProteusItem.bindView.bindSocialCommon");
    qdk.b(localViewBase, paramppu);
    blqm.a();
    blqm.a("PgcProteusItem.bindView.bindFlowGuideSperator");
    qdk.c(localViewBase, paramppu);
    blqm.a();
    blqm.a();
    tkb.a("PgcProteusItem", String.valueOf(paramInt1), "PgcProteusItem.bindView", System.currentTimeMillis() - l);
  }
  
  protected void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2, ViewBase paramViewBase)
  {
    blqm.a("PgcProteusItem.bindView.socialBottomBar");
    paramViewBase = paramViewBase.findViewBaseByName("id_social_bottom");
    if (((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) && (paramViewBase != null) && (paramViewBase.getNativeView() != null)) {
      paramViewBase.getNativeView().setOnClickListener(new pxf(this, paramContainer, paramppu, paramInt2));
    }
    blqm.a();
  }
  
  protected void a(int paramInt1, ppu paramppu, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (paramppu.a() == null)) {
      return;
    }
    sel localsel = paramppu.a();
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt1);
    case 34: 
    case 85: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramppu, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(paramppu);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new pxh(this, paramppu));
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
      paramNativeMiddleBodyView.a().setOnClickListener(new pxi(this, paramppu, localsel));
      ((qjg)paramNativeMiddleBodyView.a()).a(paramppu);
      return;
    case 48: 
    case 64: 
    case 65: 
      b(paramInt1, paramppu, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    ((qjg)paramNativeMiddleBodyView.a()).a(paramppu);
  }
  
  protected void a(ppu paramppu, ViewBase paramViewBase)
  {
    blqm.a("PgcProteusItem.bindView.bindBiuTime");
    qdk.a(paramViewBase, paramppu.a());
    blqm.a();
  }
  
  public boolean a(int paramInt, Container paramContainer, ppu paramppu, ViewBase paramViewBase)
  {
    return false;
  }
  
  protected void b(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2, ViewBase paramViewBase)
  {
    paramViewBase = (qat)paramViewBase.findViewBaseByName("id_article_comment");
    blqm.a("PgcProteusItem.bindView.commentView");
    if (paramViewBase != null)
    {
      if ((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) {
        paramViewBase.setOnClickListener(new pxg(this, paramContainer, paramppu, paramInt2));
      }
      paramViewBase.setVisibility(0);
    }
    if ((paramViewBase != null) && (paramViewBase.isVisible())) {
      paramViewBase.a(paramppu);
    }
    blqm.a();
  }
  
  protected void b(ppu paramppu, ViewBase paramViewBase)
  {
    qdk.e(paramViewBase, paramppu);
  }
  
  protected void c(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2, ViewBase paramViewBase)
  {
    blqm.a("PgcProteusItem.bindView.findViewBaseByName");
    qcb localqcb = (qcb)paramViewBase.findViewBaseByName("id_middle_body_content");
    blqm.a();
    blqm.a("PgcProteusItem.bindView.bodyviewContent");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    if (localqcb != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localqcb.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), paramppu, localqcb);
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label136;
        }
      }
    }
    label136:
    for (paramViewBase = (RelativeLayout.LayoutParams)localView.getLayoutParams();; paramViewBase = new RelativeLayout.LayoutParams(-2, -2))
    {
      localqcb.a(paramViewBase);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, paramViewBase);
      }
      blqm.a("PgcProteusItem.bindView.bindBodyView");
      a(paramInt1, paramppu, localNativeMiddleBodyView, paramInt2, paramContainer);
      blqm.a();
      blqm.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxe
 * JD-Core Version:    0.7.0.1
 */