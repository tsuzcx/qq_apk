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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import org.json.JSONObject;

public class qmx
  implements qqa
{
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
      localpnt.a(paramContext, paramqfw, 0, paramqfw.innerUniqueID, 6, paramInt, 0);
    }
  }
  
  private void a(ViewBase paramViewBase, qfw paramqfw)
  {
    if ((paramViewBase == null) || (paramqfw == null) || (paramqfw.a() == null)) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
    } while ((paramViewBase == null) || (paramViewBase.getNativeView() == null));
    szd localszd = paramqfw.a();
    paramViewBase.getNativeView().setOnClickListener(new qne(this, localszd, paramqfw));
  }
  
  private View b(int paramInt, Context paramContext, qfw paramqfw)
  {
    paramqfw = paramqfw.a();
    if ((paramqfw != null) && (paramqfw.mSocialFeedInfo != null) && (paramqfw.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (paramqfw.mSocialFeedInfo.jdField_a_of_type_Rrl.a != null) && (paramqfw.mSocialFeedInfo.jdField_a_of_type_Rrl.a.size() > 0) && (ComponentContentGridImage.a(paramqfw.mSocialFeedInfo.jdField_a_of_type_Rrl.a.size(), paramqfw.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void b(int paramInt1, qfw paramqfw, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    ArticleInfo localArticleInfo = paramqfw.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a.size() > 0) && (ComponentContentGridImage.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a.size(), localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, paramqfw, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    if ((paramNativeMiddleBodyView.a() instanceof ComponentContentGridImage))
    {
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramqfw, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(paramqfw);
      paramNativeMiddleBodyView.setGalleryClickListener(new qnc(this, paramqfw, paramContainer, paramInt2));
      return;
    }
    QLog.e("BiuPgcProteusItem", 1, "[bindGalleryBodyView] unexpected item: " + paramInt1 + " " + paramqfw.a());
  }
  
  private void c(int paramInt1, qfw paramqfw, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if (!(paramNativeMiddleBodyView.a() instanceof AdapterView)) {
      paramNativeMiddleBodyView.a().setOnClickListener(new qnd(this, paramqfw, paramContainer, paramInt2));
    }
    ((rbo)paramNativeMiddleBodyView.a()).a(paramqfw);
  }
  
  public int a(ArticleInfo paramArticleInfo, szd paramszd)
  {
    return pih.a(paramszd.a(), pqw.a(paramArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, qfw paramqfw)
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
      return b(paramInt, paramContext, paramqfw);
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
    qlk localqlk = new qlk();
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.a;
      }
    }
    if ((paramInt == 35) && (!paramBaseArticleInfo.isPGCShortContent())) {
      localqlk.c(paramBaseArticleInfo, anvx.a(2131700652));
    }
    if (paramInt == 33) {
      localqlk.c(paramBaseArticleInfo, anvx.a(2131700653));
    }
    if (paramInt != 33) {
      localqlk.A(paramBaseArticleInfo).D(paramBaseArticleInfo).B(paramBaseArticleInfo);
    }
    if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95))
    {
      localqlk.o(paramBaseArticleInfo);
      localqlk.a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).a(paramBaseArticleInfo, "Biu了").k(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).n(paramBaseArticleInfo).m(paramBaseArticleInfo).C(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).G(paramBaseArticleInfo).E(paramBaseArticleInfo).s(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
      if (paramInt != 112) {
        localqlk.z(paramBaseArticleInfo);
      }
      if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95)) {
        break label315;
      }
      localqlk.a("ReadInjoy_biu_small_pgc_cell");
    }
    for (;;)
    {
      return localqlk.a();
      if ((!paramBaseArticleInfo.mSocialFeedInfo.a()) || (pid.b(paramBaseArticleInfo))) {
        break;
      }
      localqlk.o(paramBaseArticleInfo);
      break;
      label315:
      if (qsl.a((ArticleInfo)paramBaseArticleInfo)) {
        localqlk.a("RIJ_biu_small_single_img_cell");
      } else {
        localqlk.a("RIJ_biu_cell");
      }
    }
  }
  
  public void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    qud localqud = (qud)localViewBase.findViewBaseByName("id_middle_body_content");
    NativeMiddleBodyView localNativeMiddleBodyView;
    View localView;
    if (localqud != null)
    {
      localNativeMiddleBodyView = (NativeMiddleBodyView)localqud.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        localView = a(paramInt1, paramContainer.getContext(), paramqfw);
        if ((localView instanceof PgcSmallView))
        {
          QLog.d("BiuPgcProteusItem", 2, "bindView | setTitleCustomStyle");
          ((PgcSmallView)localView).setTitleCustomStyle(localqud.a(), localqud.b(), localqud.d(), localqud.c());
        }
        if ((localView == null) || (!(localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          break label356;
        }
      }
    }
    label356:
    for (Object localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();; localObject = new RelativeLayout.LayoutParams(-2, -2))
    {
      localqud.a((RelativeLayout.LayoutParams)localObject);
      if (localView != null) {
        localNativeMiddleBodyView.a(localView, (RelativeLayout.LayoutParams)localObject);
      }
      a(paramInt1, paramqfw, localNativeMiddleBodyView, paramInt2, paramContainer);
      qvn.f(localViewBase, paramqfw);
      localObject = (qsy)localViewBase.findViewBaseByName("id_biu_comment");
      if (localObject != null) {
        ((qsy)localObject).a(paramqfw);
      }
      localObject = (qvj)localViewBase.findViewBaseByName("id_summary");
      if (localObject != null)
      {
        ((qvj)localObject).a(paramqfw);
        if ((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) {
          ((qvj)localObject).setOnClickListener(new qmy(this, paramContainer, paramqfw, paramInt2));
        }
      }
      localObject = localViewBase.findViewBaseByName("id_social_bottom");
      if (((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) && (localObject != null) && (((ViewBase)localObject).getNativeView() != null)) {
        ((ViewBase)localObject).getNativeView().setOnClickListener(new qmz(this, paramContainer, paramqfw, paramInt2));
      }
      qvn.a(localViewBase, paramqfw.a());
      a(localViewBase, paramqfw);
      qmm.a(localViewBase, paramqfw);
      qmm.b(localViewBase, paramqfw);
      qvn.b(localViewBase, paramqfw);
      qvn.c(localViewBase, paramqfw);
      qvn.d(localViewBase, paramqfw);
      return;
    }
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
    case 35: 
    case 114: 
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramqfw, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(paramqfw);
      paramNativeMiddleBodyView.setOnNoItemClickListener(new qna(this, paramqfw));
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
        AIOUtils.catchedExceptionInReleaseV2("BiuPgcProteusItem", "", new IllegalArgumentException(" adapterViewType " + paramInt1 + " articleInfo : " + paramqfw.a()));
        return;
      }
      paramNativeMiddleBodyView.a().setOnClickListener(new qnb(this, localszd, paramqfw));
      ((rbo)paramNativeMiddleBodyView.a()).a(paramqfw);
      return;
    }
    b(paramInt1, paramqfw, paramNativeMiddleBodyView, paramInt2, paramContainer);
  }
  
  public boolean a(int paramInt, Container paramContainer, qfw paramqfw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmx
 * JD-Core Version:    0.7.0.1
 */