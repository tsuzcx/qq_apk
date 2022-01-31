import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class pgz
  extends pgs
{
  private rym jdField_a_of_type_Rym;
  private sgy jdField_a_of_type_Sgy;
  
  private List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(new ryp("qq_friend", 2, false).a));
    localArrayList.add(Integer.valueOf(new ryp("qzone", 3, false).a));
    localArrayList.add(Integer.valueOf(new ryp("we_chat", 4, false).a));
    localArrayList.add(Integer.valueOf(new ryp("we_chat_circle", 5, false).a));
    return localArrayList;
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    String str = onk.a(paramArticleInfo);
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    noo.a(null, paramArticleInfo.mSubscribeID, "0X800AB52", "0X800AB52", 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str, false);
  }
  
  private void a(ViewBase paramViewBase, pax parampax, Container paramContainer)
  {
    Object localObject = (pmb)paramViewBase.findViewBaseByName("id_pgc_short_content_video_view");
    if (localObject == null) {}
    ViewBase localViewBase;
    NativeVideoView localNativeVideoView;
    ViewBean localViewBean;
    do
    {
      return;
      localViewBase = paramViewBase.findViewBaseByName("id_pgc_short_content_video_audio_icon");
      paramViewBase = paramViewBase.findViewBaseByName("id_pgc_float_contain");
      localNativeVideoView = ((pmb)localObject).a();
      localViewBean = parampax.a().mProteusTemplateBean.getViewBean().findViewFromChild("id_pgc_short_content_video_audio_icon");
    } while ((localViewBase == null) || (paramViewBase == null) || (localNativeVideoView == null) || (localViewBean == null));
    localViewBase.setVisibility(8);
    paramViewBase.setVisibility(0);
    localNativeVideoView.jdField_a_of_type_Boolean = true;
    localNativeVideoView.setMute(true);
    localViewBean.putMapValue("pgc_video_content_audio_icon", "video_audio_mute");
    localViewBase.bindDynamicValue(localViewBean);
    localObject = ((pmb)localObject).a();
    phl localphl = new phl(this);
    phq localphq = new phq(this, true);
    if ((rac)paramContainer.getTag(2131374806) == null) {
      paramContainer.setTag(2131374806, new phm(this, (View)localObject, localphq, localNativeVideoView));
    }
    localNativeVideoView.setOnCheckShownListener(localphl);
    if (localObject != null) {
      ((View)localObject).addOnAttachStateChangeListener(new pho(this, parampax, localNativeVideoView, localphq, new phn(this, localNativeVideoView, localViewBean, localViewBase)));
    }
    localNativeVideoView.setOnProgressChangedListener(new phb(this, paramViewBase));
    localNativeVideoView.setVideoPlayListener(new phc(this, localNativeVideoView, localViewBase, paramViewBase));
  }
  
  private void c(pax parampax, ViewBase paramViewBase)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.jdField_a_of_type_Sgy == null)
    {
      this.jdField_a_of_type_Sgy = new sgy((Activity)paramViewBase.getNativeView().getContext(), localQQAppInterface, null, new phr(this, parampax.a(), new WeakReference((Activity)paramViewBase.getNativeView().getContext())));
      paramViewBase.getNativeView().addOnAttachStateChangeListener(new phd(this));
    }
    this.jdField_a_of_type_Sgy.a.a(ajyc.a(2131713579));
    this.jdField_a_of_type_Sgy.a(new List[] { a() });
  }
  
  protected View a(int paramInt, Context paramContext, pax parampax, pll parampll)
  {
    parampax = parampax.a();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 111: 
      return new pha(this, paramContext, parampax);
    case 110: 
      return new phh(this, paramContext, parampax);
    case 132: 
      return new PgcSmallView(132, paramContext);
    }
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    pdp localpdp = new pdp();
    label254:
    for (;;)
    {
      try
      {
        long l = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
        localNumberFormatException1.printStackTrace();
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          ReadInJoyUserInfoModule.a(l, null);
          localpdp.a(paramBaseArticleInfo, l);
          if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_JavaLangString != null)))) {
            localpdp.p(paramBaseArticleInfo);
          }
          if ((paramInt == 34) || (paramInt == 85)) {
            localpdp.b(paramBaseArticleInfo, ajyc.a(2131707974));
          }
          localpdp.h(paramBaseArticleInfo);
          if (paramInt != 109) {
            localpdp.z(paramBaseArticleInfo);
          }
          localpdp.a(paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).e(paramBaseArticleInfo).d(paramBaseArticleInfo).j(paramBaseArticleInfo).g(paramBaseArticleInfo).k(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).C(paramBaseArticleInfo).a("ReadInjoy_pgc_shortcontent_cell").E(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
          if (paramInt == 133) {
            localpdp.Q(paramBaseArticleInfo);
          }
          return localpdp.a();
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          break label254;
        }
        localNumberFormatException1 = localNumberFormatException1;
        l = 0L;
      }
    }
  }
  
  public void a(int paramInt1, Container paramContainer, pax parampax, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    pjx localpjx = (pjx)localViewBase.findViewBaseByName("id_info_avator");
    if (localpjx != null) {
      localpjx.a(parampax);
    }
    pmr.d(localViewBase, parampax);
    pmr.b(localViewBase, parampax);
    c(paramInt1, paramContainer, parampax, paramInt2, localViewBase);
    b(paramInt1, paramContainer, parampax, paramInt2, localViewBase);
    a(paramInt1, paramContainer, parampax, paramInt2, localViewBase);
    pmr.a(localViewBase, parampax);
    pmr.c(localViewBase, parampax);
  }
  
  protected void a(int paramInt1, pax parampax, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampax.a() == null)) {}
    for (;;)
    {
      return;
      rap localrap = parampax.a();
      switch (paramInt1)
      {
      default: 
        return;
      case 110: 
        qag.a(parampax.a());
        paramNativeMiddleBodyView.a().setOnClickListener(new phj(this, parampax, paramContainer, localrap));
        ((pqs)paramNativeMiddleBodyView.a()).a(parampax);
        return;
      case 111: 
        qag.a(parampax.a());
        paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
        paramContainer = ComponentContentGridImage.a(parampax, paramInt1);
        paramNativeMiddleBodyView.setMIReadInJoyModel(parampax);
        paramNativeMiddleBodyView.a(paramContainer);
        paramNativeMiddleBodyView.setOnNoItemClickListener(new phi(this, parampax));
        return;
      }
      paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.a();
      qag.a(parampax.a());
      paramNativeMiddleBodyView.a(parampax);
      try
      {
        if ((parampax.a().mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_Boolean) && (parampax.a().mSocialFeedInfo.jdField_a_of_type_Qcr != null))
        {
          paramNativeMiddleBodyView.setOnClickListener(new phk(this, parampax, paramContainer, paramNativeMiddleBodyView));
          return;
        }
      }
      catch (NullPointerException parampax)
      {
        QLog.e("PgcShortContentProteusItem", 1, parampax.toString());
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pax parampax, ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    }
    for (;;)
    {
      return super.a(paramInt, paramContainer, parampax, paramViewBase);
      paramViewBase.setOnClickListener(new phe(this, parampax));
      return true;
      paramViewBase.setOnClickListener(new phf(this, paramViewBase, parampax));
      continue;
      paramViewBase.setOnClickListener(new phg(this, parampax, paramViewBase));
    }
  }
  
  protected void c(int paramInt1, Container paramContainer, pax parampax, int paramInt2, ViewBase paramViewBase)
  {
    super.c(paramInt1, paramContainer, parampax, paramInt2, paramViewBase);
    if (paramInt1 == 133) {}
    try
    {
      a(paramViewBase, parampax, paramContainer);
      return;
    }
    catch (NullPointerException paramContainer)
    {
      QLog.e("PgcShortContentProteusItem", 1, paramContainer.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgz
 * JD-Core Version:    0.7.0.1
 */