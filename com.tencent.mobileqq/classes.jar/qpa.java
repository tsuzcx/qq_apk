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

public class qpa
  implements qqa
{
  private View a(int paramInt, Context paramContext, qfw paramqfw)
  {
    paramqfw = paramqfw.a();
    if ((paramqfw != null) && (paramqfw.mSocialFeedInfo != null) && (paramqfw.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (paramqfw.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaUtilArrayList != null) && (paramqfw.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(paramqfw.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaUtilArrayList.size(), paramqfw.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, szd paramszd)
  {
    int i = a(paramArticleInfo, paramszd);
    paramszd = paramszd.a().a();
    if (paramszd != null) {
      paramszd.a(paramContext, paramArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void a(Context paramContext, qfw paramqfw, int paramInt)
  {
    pnt localpnt = paramqfw.a().a().a();
    paramqfw = paramqfw.a();
    if ((paramqfw != null) && (localpnt != null)) {
      localpnt.a(paramContext, paramqfw, 0, paramqfw.innerUniqueID, 5, paramInt, 0);
    }
  }
  
  private void b(int paramInt1, qfw paramqfw, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = paramqfw.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaUtilArrayList != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaUtilArrayList.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, paramqfw, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramqfw, paramInt1));
    paramNativeMiddleBodyView.setMIReadInJoyModel(paramqfw);
    paramNativeMiddleBodyView.setGalleryClickListener(new qpf(this, paramqfw, paramContainer, paramInt2));
  }
  
  private void c(int paramInt1, qfw paramqfw, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    paramNativeMiddleBodyView.a().setOnClickListener(new qpg(this, paramqfw, paramContainer, paramInt2));
    ((rbo)paramNativeMiddleBodyView.a()).a(paramqfw);
  }
  
  public int a(ArticleInfo paramArticleInfo, szd paramszd)
  {
    return pih.a(paramszd.a(), pqw.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, qfw paramqfw, qud paramqud)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 34: 
    case 85: 
      paramContext = new ComponentContentGridImage(paramContext);
      if (paramqud.a())
      {
        paramContext.jdField_a_of_type_Int = paramqud.getComPaddingLeft();
        paramContext.b = paramqud.getComPaddingRight();
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
      return a(paramInt, paramContext, paramqfw);
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
    blfz.a("PgcProteusItem.getDataJson");
    long l3 = System.currentTimeMillis();
    qlk localqlk = new qlk();
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
    blfz.a("PgcProteusItem.bindArticleComment");
    if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaLangString != null)))) {
      localqlk.p(paramBaseArticleInfo);
    }
    blfz.a();
    blfz.a("PgcProteusItem.bindReadArticle");
    if ((paramInt == 34) || (paramInt == 85)) {
      localqlk.c(paramBaseArticleInfo, anvx.a(2131707433));
    }
    blfz.a();
    if (paramInt == 29) {
      localqlk.c(paramBaseArticleInfo, anvx.a(2131707432));
    }
    blfz.a("PgcProteusItem.bindTopicCapsule");
    if (paramInt != 29) {
      localqlk.A(paramBaseArticleInfo).D(paramBaseArticleInfo).B(paramBaseArticleInfo);
    }
    blfz.a();
    blfz.a("PgcProteusItem.bindPublicAccountFollowButton");
    blfz.a();
    localqlk.a(paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).d(paramBaseArticleInfo).j(paramBaseArticleInfo).i(paramBaseArticleInfo).g(paramBaseArticleInfo).k(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).C(paramBaseArticleInfo).a("ReadInjoy_original_cell").E(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
    blfz.a("PgcProteusItem.bindMiddleBody");
    localqlk.z(paramBaseArticleInfo);
    blfz.a();
    blfz.a();
    uda.a("PgcProteusItem", String.valueOf(paramInt), "PgcProteusItem.getDataJson", System.currentTimeMillis() - l3);
    return localqlk.a();
  }
  
  public void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2)
  {
    long l = System.currentTimeMillis();
    blfz.a("PgcProteusItem.bindView");
    ViewBase localViewBase = paramContainer.getVirtualView();
    c(paramInt1, paramContainer, paramqfw, paramInt2, localViewBase);
    b(paramqfw, localViewBase);
    a(paramqfw, localViewBase);
    b(paramInt1, paramContainer, paramqfw, paramInt2, localViewBase);
    a(paramInt1, paramContainer, paramqfw, paramInt2, localViewBase);
    blfz.a("PgcProteusItem.bindView.bindJumpChannel");
    qvn.b(localViewBase, paramqfw);
    blfz.a();
    blfz.a("PgcProteusItem.bindView.bindSocialCommon");
    qvn.c(localViewBase, paramqfw);
    blfz.a();
    blfz.a("PgcProteusItem.bindView.bindFlowGuideSperator");
    qvn.d(localViewBase, paramqfw);
    blfz.a();
    blfz.a();
    uda.a("PgcProteusItem", String.valueOf(paramInt1), "PgcProteusItem.bindView", System.currentTimeMillis() - l);
  }
  
  protected void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2, ViewBase paramViewBase)
  {
    blfz.a("PgcProteusItem.bindView.socialBottomBar");
    paramViewBase = paramViewBase.findViewBaseByName("id_social_bottom");
    if (((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) && (paramViewBase != null) && (paramViewBase.getNativeView() != null)) {
      paramViewBase.getNativeView().setOnClickListener(new qpb(this, paramContainer, paramqfw, paramInt2));
    }
    blfz.a();
  }
  
  protected void a(int paramInt1, qfw paramqfw, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (paramqfw.a() == null)) {
      return;
    }
    szd localszd = paramqfw.a();
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt1);
    case 34: 
    case 85: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramqfw, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(paramqfw);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new qpd(this, paramqfw));
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
      paramNativeMiddleBodyView.a().setOnClickListener(new qpe(this, paramqfw, localszd));
      ((rbo)paramNativeMiddleBodyView.a()).a(paramqfw);
      return;
    case 48: 
    case 64: 
    case 65: 
      b(paramInt1, paramqfw, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    ((rbo)paramNativeMiddleBodyView.a()).a(paramqfw);
  }
  
  protected void a(qfw paramqfw, ViewBase paramViewBase)
  {
    blfz.a("PgcProteusItem.bindView.bindBiuTime");
    qvn.a(paramViewBase, paramqfw.a());
    blfz.a();
  }
  
  public boolean a(int paramInt, Container paramContainer, qfw paramqfw, ViewBase paramViewBase)
  {
    return false;
  }
  
  protected void b(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2, ViewBase paramViewBase)
  {
    paramViewBase = (qsu)paramViewBase.findViewBaseByName("id_article_comment");
    blfz.a("PgcProteusItem.bindView.commentView");
    if (paramViewBase != null)
    {
      if ((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) {
        paramViewBase.setOnClickListener(new qpc(this, paramContainer, paramqfw, paramInt2));
      }
      paramViewBase.setVisibility(0);
    }
    if ((paramViewBase != null) && (paramViewBase.isVisible())) {
      paramViewBase.a(paramqfw);
    }
    blfz.a();
  }
  
  protected void b(qfw paramqfw, ViewBase paramViewBase)
  {
    qvn.f(paramViewBase, paramqfw);
  }
  
  protected void c(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2, ViewBase paramViewBase)
  {
    blfz.a("PgcProteusItem.bindView.findViewBaseByName");
    qud localqud = (qud)paramViewBase.findViewBaseByName("id_middle_body_content");
    blfz.a();
    blfz.a("PgcProteusItem.bindView.bodyviewContent");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    if (localqud != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localqud.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), paramqfw, localqud);
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label136;
        }
      }
    }
    label136:
    for (paramViewBase = (RelativeLayout.LayoutParams)localView.getLayoutParams();; paramViewBase = new RelativeLayout.LayoutParams(-2, -2))
    {
      localqud.a(paramViewBase);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, paramViewBase);
      }
      blfz.a("PgcProteusItem.bindView.bindBodyView");
      a(paramInt1, paramqfw, localNativeMiddleBodyView, paramInt2, paramContainer);
      blfz.a();
      blfz.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpa
 * JD-Core Version:    0.7.0.1
 */