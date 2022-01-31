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

public class ovq
  implements owa
{
  private View a(int paramInt, Context paramContext, opw paramopw)
  {
    paramopw = paramopw.a();
    if ((paramopw != null) && (paramopw.mSocialFeedInfo != null) && (paramopw.mSocialFeedInfo.jdField_a_of_type_Pqz != null) && (paramopw.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList != null) && (paramopw.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(paramopw.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList.size(), paramopw.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, qoe paramqoe)
  {
    int i = a(paramArticleInfo, paramqoe);
    paramqoe = paramqoe.a();
    if (paramqoe != null) {
      paramqoe.a(paramContext, paramArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void a(Context paramContext, opw paramopw, int paramInt)
  {
    qpg localqpg = paramopw.a().a();
    paramopw = paramopw.a();
    if ((paramopw != null) && (localqpg != null)) {
      localqpg.a(paramContext, paramopw, 0, paramopw.innerUniqueID, 5, paramInt, 0);
    }
  }
  
  private void b(int paramInt1, opw paramopw, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = paramopw.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaUtilArrayList.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, paramopw, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
    paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramopw, paramInt1));
    paramNativeMiddleBodyView.setMIReadInJoyModel(paramopw);
    paramNativeMiddleBodyView.setGalleryClickListener(new ovv(this, paramopw, paramContainer, paramInt2));
  }
  
  private void c(int paramInt1, opw paramopw, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    paramNativeMiddleBodyView.a().setOnClickListener(new ovw(this, paramopw, paramContainer, paramInt2));
    ((pey)paramNativeMiddleBodyView.a()).a(paramopw);
  }
  
  public int a(ArticleInfo paramArticleInfo, qoe paramqoe)
  {
    return nzv.a(paramqoe.a(), obz.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, opw paramopw, ozt paramozt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 34: 
    case 85: 
      paramContext = new ComponentContentGridImage(paramContext);
      if (paramozt.a())
      {
        paramContext.jdField_a_of_type_Int = paramozt.getComPaddingLeft();
        paramContext.b = paramozt.getComPaddingRight();
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
      return a(paramInt, paramContext, paramopw);
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
    beoj.a("PgcProteusItem.getDataJson");
    long l2 = System.currentTimeMillis();
    osn localosn = new osn();
    try
    {
      l1 = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
      beoj.a("PgcProteusItem.bindArticleComment");
      if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.jdField_a_of_type_JavaLangString != null)))) {
        localosn.o(paramBaseArticleInfo);
      }
      beoj.a();
      beoj.a("PgcProteusItem.bindReadArticle");
      if ((paramInt == 34) || (paramInt == 85)) {
        localosn.b(paramBaseArticleInfo, ajjy.a(2131642188));
      }
      beoj.a();
      if (paramInt == 29) {
        localosn.b(paramBaseArticleInfo, ajjy.a(2131642187));
      }
      beoj.a("PgcProteusItem.bindTopicCapsule");
      if (paramInt != 29) {
        localosn.z(paramBaseArticleInfo).C(paramBaseArticleInfo).A(paramBaseArticleInfo);
      }
      beoj.a();
      beoj.a("PgcProteusItem.bindPublicAccountFollowButton");
      if (((paramBaseArticleInfo instanceof ArticleInfo)) && (qoe.h((ArticleInfo)paramBaseArticleInfo))) {
        localosn.g(paramBaseArticleInfo);
      }
      beoj.a();
      localosn.a(paramBaseArticleInfo).b(paramBaseArticleInfo).q(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).d(paramBaseArticleInfo).i(paramBaseArticleInfo).f(paramBaseArticleInfo).j(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).B(paramBaseArticleInfo).a("ReadInjoy_original_cell").D(paramBaseArticleInfo).k(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).t(paramBaseArticleInfo);
      beoj.a("PgcProteusItem.bindMiddleBody");
      localosn.y(paramBaseArticleInfo);
      beoj.a();
      beoj.a();
      rnr.a("PgcProteusItem", String.valueOf(paramInt), "PgcProteusItem.getDataJson", System.currentTimeMillis() - l2);
      return localosn.a();
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
  
  public void a(int paramInt1, Container paramContainer, opw paramopw, int paramInt2)
  {
    long l = System.currentTimeMillis();
    beoj.a("PgcProteusItem.bindView");
    ViewBase localViewBase = paramContainer.getVirtualView();
    c(paramInt1, paramContainer, paramopw, paramInt2, localViewBase);
    b(paramopw, localViewBase);
    a(paramopw, localViewBase);
    b(paramInt1, paramContainer, paramopw, paramInt2, localViewBase);
    a(paramInt1, paramContainer, paramopw, paramInt2, localViewBase);
    beoj.a("PgcProteusItem.bindView.bindJumpChannel");
    paz.a(localViewBase, paramopw);
    beoj.a();
    beoj.a("PgcProteusItem.bindView.bindSocialCommon");
    paz.b(localViewBase, paramopw);
    beoj.a();
    beoj.a("PgcProteusItem.bindView.bindFlowGuideSperator");
    paz.c(localViewBase, paramopw);
    beoj.a();
    beoj.a();
    rnr.a("PgcProteusItem", String.valueOf(paramInt1), "PgcProteusItem.bindView", System.currentTimeMillis() - l);
  }
  
  protected void a(int paramInt1, Container paramContainer, opw paramopw, int paramInt2, ViewBase paramViewBase)
  {
    beoj.a("PgcProteusItem.bindView.socialBottomBar");
    paramViewBase = paramViewBase.findViewBaseByName("id_social_bottom");
    if (((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) && (paramViewBase != null) && (paramViewBase.getNativeView() != null)) {
      paramViewBase.getNativeView().setOnClickListener(new ovr(this, paramContainer, paramopw, paramInt2));
    }
    beoj.a();
  }
  
  protected void a(int paramInt1, opw paramopw, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (paramopw.a() == null)) {
      return;
    }
    qoe localqoe = paramopw.a();
    switch (paramInt1)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt1);
    case 34: 
    case 85: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramopw, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(paramopw);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new ovt(this, paramopw));
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
      paramNativeMiddleBodyView.a().setOnClickListener(new ovu(this, paramopw, localqoe));
      ((pey)paramNativeMiddleBodyView.a()).a(paramopw);
      return;
    case 48: 
    case 64: 
    case 65: 
      b(paramInt1, paramopw, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    ((pey)paramNativeMiddleBodyView.a()).a(paramopw);
  }
  
  protected void a(opw paramopw, ViewBase paramViewBase)
  {
    beoj.a("PgcProteusItem.bindView.bindBiuTime");
    paz.a(paramViewBase, paramopw.a());
    beoj.a();
  }
  
  public boolean a(int paramInt, Container paramContainer, opw paramopw, ViewBase paramViewBase)
  {
    return false;
  }
  
  protected void b(int paramInt1, Container paramContainer, opw paramopw, int paramInt2, ViewBase paramViewBase)
  {
    paramViewBase = (oyd)paramViewBase.findViewBaseByName("id_article_comment");
    beoj.a("PgcProteusItem.bindView.commentView");
    if (paramViewBase != null)
    {
      if ((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) {
        paramViewBase.setOnClickListener(new ovs(this, paramContainer, paramopw, paramInt2));
      }
      paramViewBase.setVisibility(0);
    }
    if ((paramViewBase != null) && (paramViewBase.isVisible())) {
      paramViewBase.a(paramopw);
    }
    beoj.a();
  }
  
  protected void b(opw paramopw, ViewBase paramViewBase)
  {
    paramViewBase = (oyf)paramViewBase.findViewBaseByName("id_info_avator");
    if (paramViewBase != null)
    {
      beoj.a("PgcProteusItem.bindView. avatar.setModel");
      paramViewBase.a(paramopw);
      beoj.a();
    }
  }
  
  protected void c(int paramInt1, Container paramContainer, opw paramopw, int paramInt2, ViewBase paramViewBase)
  {
    beoj.a("PgcProteusItem.bindView.findViewBaseByName");
    ozt localozt = (ozt)paramViewBase.findViewBaseByName("id_middle_body_content");
    beoj.a();
    beoj.a("PgcProteusItem.bindView.bodyviewContent");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    if (localozt != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localozt.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), paramopw, localozt);
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label136;
        }
        paramViewBase = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      }
    }
    for (;;)
    {
      localozt.a(paramViewBase);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, paramViewBase);
      }
      beoj.a("PgcProteusItem.bindView.bindBodyView");
      a(paramInt1, paramopw, localNativeMiddleBodyView, paramInt2, paramContainer);
      beoj.a();
      beoj.a();
      return;
      label136:
      paramViewBase = new RelativeLayout.LayoutParams(-2, -2);
      paramViewBase.setMargins(bajq.a(12.0F), 0, bajq.a(12.0F), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovq
 * JD-Core Version:    0.7.0.1
 */