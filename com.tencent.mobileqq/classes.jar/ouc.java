import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentPgcVideo;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import org.json.JSONObject;

public class ouc
  implements owa
{
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
      localqpg.a(paramContext, paramopw, 0, paramopw.innerUniqueID, 6, paramInt, 0);
    }
  }
  
  private void a(ViewBase paramViewBase, opw paramopw)
  {
    if ((paramViewBase == null) || (paramopw == null) || (paramopw.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    qoe localqoe = paramopw.a();
    paramViewBase.getNativeView().setOnClickListener(new ouj(this, localqoe, paramopw));
  }
  
  private View b(int paramInt, Context paramContext, opw paramopw)
  {
    paramopw = paramopw.a();
    if ((paramopw != null) && (paramopw.mSocialFeedInfo != null) && (paramopw.mSocialFeedInfo.jdField_a_of_type_Pqz != null) && (paramopw.mSocialFeedInfo.jdField_a_of_type_Pqz.a != null) && (paramopw.mSocialFeedInfo.jdField_a_of_type_Pqz.a.size() > 0) && (ComponentContentGridImage.a(paramopw.mSocialFeedInfo.jdField_a_of_type_Pqz.a.size(), paramopw.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void b(int paramInt1, opw paramopw, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = paramopw.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.a != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.a.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.a.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, paramopw, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    if ((paramNativeMiddleBodyView.a() instanceof ComponentContentGridImage))
    {
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramopw, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(paramopw);
      paramNativeMiddleBodyView.setGalleryClickListener(new ouh(this, paramopw, paramContainer, paramInt2));
      return;
    }
    QLog.e("BiuPgcProteusItem", 1, "[bindGalleryBodyView] unexpected item: " + paramInt1 + " " + paramopw.a());
  }
  
  private void c(int paramInt1, opw paramopw, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if (!(paramNativeMiddleBodyView.a() instanceof AdapterView)) {
      paramNativeMiddleBodyView.a().setOnClickListener(new oui(this, paramopw, paramContainer, paramInt2));
    }
    ((pey)paramNativeMiddleBodyView.a()).a(paramopw);
  }
  
  public int a(ArticleInfo paramArticleInfo, qoe paramqoe)
  {
    return nzv.a(paramqoe.a(), obz.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, opw paramopw)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 35: 
    case 114: 
      return new ComponentContentGridImage(paramContext);
    case 49: 
    case 62: 
    case 63: 
      return b(paramInt, paramContext, paramopw);
    case 10: 
    case 12: 
    case 94: 
    case 95: 
      return new PgcSmallView(paramInt, paramContext);
    case 11: 
    case 28: 
      return new ComponentContentPgcVideo(paramContext);
    case 27: 
      return new ComponentContentBig(paramContext);
    case 113: 
      return new ComponentPGCShortContentBig(paramContext);
    case 33: 
      return new ComponentContentBig(paramContext);
    }
    return null;
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    osn localosn = new osn();
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.a;
      }
    }
    if ((paramInt == 35) && (!paramBaseArticleInfo.isPGCShortContent())) {
      localosn.b(paramBaseArticleInfo, ajjy.a(2131635359));
    }
    if (paramInt == 33) {
      localosn.b(paramBaseArticleInfo, ajjy.a(2131635360));
    }
    if (paramInt != 33) {
      localosn.z(paramBaseArticleInfo).C(paramBaseArticleInfo).A(paramBaseArticleInfo);
    }
    if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95))
    {
      localosn.n(paramBaseArticleInfo);
      localosn.a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).e(paramBaseArticleInfo).f(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").j(paramBaseArticleInfo).i(paramBaseArticleInfo).m(paramBaseArticleInfo).l(paramBaseArticleInfo).B(paramBaseArticleInfo).q(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).F(paramBaseArticleInfo).D(paramBaseArticleInfo).r(paramBaseArticleInfo).k(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).t(paramBaseArticleInfo);
      if (paramInt != 112) {
        localosn.y(paramBaseArticleInfo);
      }
      if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95)) {
        break label311;
      }
      localosn.a("ReadInjoy_biu_small_pgc_cell");
    }
    for (;;)
    {
      return localosn.a();
      if ((!paramBaseArticleInfo.mSocialFeedInfo.a()) || (nzr.b(paramBaseArticleInfo))) {
        break;
      }
      localosn.n(paramBaseArticleInfo);
      break;
      label311:
      localosn.a("ReadInjoy_biu_cell");
    }
  }
  
  public void a(int paramInt1, Container paramContainer, opw paramopw, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    ozt localozt = (ozt)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    Object localObject;
    if (localozt != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localozt.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), paramopw);
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label329;
        }
        localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      }
    }
    for (;;)
    {
      localozt.a((RelativeLayout.LayoutParams)localObject);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, (RelativeLayout.LayoutParams)localObject);
      }
      a(paramInt1, paramopw, localNativeMiddleBodyView, paramInt2, paramContainer);
      localObject = (oyf)localViewBase.findViewBaseByName("id_info_avator");
      if (localObject != null) {
        ((oyf)localObject).a(paramopw);
      }
      localObject = (oyh)localViewBase.findViewBaseByName("id_biu_comment");
      if (localObject != null) {
        ((oyh)localObject).a(paramopw);
      }
      localObject = (pav)localViewBase.findViewBaseByName("id_summary");
      if (localObject != null)
      {
        ((pav)localObject).a(paramopw);
        if ((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) {
          ((pav)localObject).setOnClickListener(new oud(this, paramContainer, paramopw, paramInt2));
        }
      }
      localObject = localViewBase.findViewBaseByName("id_social_bottom");
      if (((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) && (localObject != null) && (((ViewBase)localObject).getNativeView() != null)) {
        ((ViewBase)localObject).getNativeView().setOnClickListener(new oue(this, paramContainer, paramopw, paramInt2));
      }
      paz.a(localViewBase, paramopw.a());
      a(localViewBase, paramopw);
      otl.a(localViewBase, paramopw);
      otl.b(localViewBase, paramopw);
      paz.a(localViewBase, paramopw);
      paz.b(localViewBase, paramopw);
      paz.c(localViewBase, paramopw);
      return;
      label329:
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).setMargins(bajq.a(12.0F), 0, bajq.a(12.0F), 0);
    }
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
    case 35: 
    case 114: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramopw, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(paramopw);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new ouf(this, paramopw));
      return;
    case 10: 
    case 11: 
    case 12: 
    case 27: 
    case 28: 
    case 33: 
    case 94: 
    case 95: 
    case 112: 
    case 113: 
      if ((paramNativeMiddleBodyView.a() instanceof AdapterView))
      {
        aciy.a("BiuPgcProteusItem", "", new IllegalArgumentException(" adapterViewType " + paramInt1 + " articleInfo : " + paramopw.a()));
        return;
      }
      paramNativeMiddleBodyView.a().setOnClickListener(new oug(this, localqoe, paramopw));
      ((pey)paramNativeMiddleBodyView.a()).a(paramopw);
      return;
    }
    b(paramInt1, paramopw, paramNativeMiddleBodyView, paramInt2, paramContainer);
  }
  
  public boolean a(int paramInt, Container paramContainer, opw paramopw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ouc
 * JD-Core Version:    0.7.0.1
 */