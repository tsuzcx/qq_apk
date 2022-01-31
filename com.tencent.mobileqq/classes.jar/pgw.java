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

public class pgw
  extends pgp
{
  private ryj jdField_a_of_type_Ryj;
  private sgv jdField_a_of_type_Sgv;
  
  private List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(new rym("qq_friend", 2, false).a));
    localArrayList.add(Integer.valueOf(new rym("qzone", 3, false).a));
    localArrayList.add(Integer.valueOf(new rym("we_chat", 4, false).a));
    localArrayList.add(Integer.valueOf(new rym("we_chat_circle", 5, false).a));
    return localArrayList;
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    String str = onh.a(paramArticleInfo);
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    nol.a(null, paramArticleInfo.mSubscribeID, "0X800AB52", "0X800AB52", 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str, false);
  }
  
  private void a(ViewBase paramViewBase, pau parampau, Container paramContainer)
  {
    Object localObject = (ply)paramViewBase.findViewBaseByName("id_pgc_short_content_video_view");
    if (localObject == null) {}
    ViewBase localViewBase;
    NativeVideoView localNativeVideoView;
    ViewBean localViewBean;
    do
    {
      return;
      localViewBase = paramViewBase.findViewBaseByName("id_pgc_short_content_video_audio_icon");
      paramViewBase = paramViewBase.findViewBaseByName("id_pgc_float_contain");
      localNativeVideoView = ((ply)localObject).a();
      localViewBean = parampau.a().mProteusTemplateBean.getViewBean().findViewFromChild("id_pgc_short_content_video_audio_icon");
    } while ((localViewBase == null) || (paramViewBase == null) || (localNativeVideoView == null) || (localViewBean == null));
    localViewBase.setVisibility(8);
    paramViewBase.setVisibility(0);
    localNativeVideoView.jdField_a_of_type_Boolean = true;
    localNativeVideoView.setMute(true);
    localViewBean.putMapValue("pgc_video_content_audio_icon", "video_audio_mute");
    localViewBase.bindDynamicValue(localViewBean);
    localObject = ((ply)localObject).a();
    phi localphi = new phi(this);
    phn localphn = new phn(this, true);
    if ((qzz)paramContainer.getTag(2131374808) == null) {
      paramContainer.setTag(2131374808, new phj(this, (View)localObject, localphn, localNativeVideoView));
    }
    localNativeVideoView.setOnCheckShownListener(localphi);
    if (localObject != null) {
      ((View)localObject).addOnAttachStateChangeListener(new phl(this, parampau, localNativeVideoView, localphn, new phk(this, localNativeVideoView, localViewBean, localViewBase)));
    }
    localNativeVideoView.setOnProgressChangedListener(new pgy(this, paramViewBase));
    localNativeVideoView.setVideoPlayListener(new pgz(this, localNativeVideoView, localViewBase, paramViewBase));
  }
  
  private void c(pau parampau, ViewBase paramViewBase)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.jdField_a_of_type_Sgv == null)
    {
      this.jdField_a_of_type_Sgv = new sgv((Activity)paramViewBase.getNativeView().getContext(), localQQAppInterface, null, new pho(this, parampau.a(), new WeakReference((Activity)paramViewBase.getNativeView().getContext())));
      paramViewBase.getNativeView().addOnAttachStateChangeListener(new pha(this));
    }
    this.jdField_a_of_type_Sgv.a.a(ajya.a(2131713590));
    this.jdField_a_of_type_Sgv.a(new List[] { a() });
  }
  
  protected View a(int paramInt, Context paramContext, pau parampau, pli parampli)
  {
    parampau = parampau.a();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 111: 
      return new pgx(this, paramContext, parampau);
    case 110: 
      return new phe(this, paramContext, parampau);
    case 132: 
      return new PgcSmallView(132, paramContext);
    }
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    pdm localpdm = new pdm();
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
          localpdm.a(paramBaseArticleInfo, l);
          if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_JavaLangString != null)))) {
            localpdm.p(paramBaseArticleInfo);
          }
          if ((paramInt == 34) || (paramInt == 85)) {
            localpdm.b(paramBaseArticleInfo, ajya.a(2131707985));
          }
          localpdm.h(paramBaseArticleInfo);
          if (paramInt != 109) {
            localpdm.z(paramBaseArticleInfo);
          }
          localpdm.a(paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).e(paramBaseArticleInfo).d(paramBaseArticleInfo).j(paramBaseArticleInfo).g(paramBaseArticleInfo).k(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).C(paramBaseArticleInfo).a("ReadInjoy_pgc_shortcontent_cell").E(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
          if (paramInt == 133) {
            localpdm.Q(paramBaseArticleInfo);
          }
          return localpdm.a();
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
  
  public void a(int paramInt1, Container paramContainer, pau parampau, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    pju localpju = (pju)localViewBase.findViewBaseByName("id_info_avator");
    if (localpju != null) {
      localpju.a(parampau);
    }
    pmo.d(localViewBase, parampau);
    pmo.b(localViewBase, parampau);
    c(paramInt1, paramContainer, parampau, paramInt2, localViewBase);
    b(paramInt1, paramContainer, parampau, paramInt2, localViewBase);
    a(paramInt1, paramContainer, parampau, paramInt2, localViewBase);
    pmo.a(localViewBase, parampau);
    pmo.c(localViewBase, parampau);
  }
  
  protected void a(int paramInt1, pau parampau, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampau.a() == null)) {}
    for (;;)
    {
      return;
      ram localram = parampau.a();
      switch (paramInt1)
      {
      default: 
        return;
      case 110: 
        qad.a(parampau.a());
        paramNativeMiddleBodyView.a().setOnClickListener(new phg(this, parampau, paramContainer, localram));
        ((pqp)paramNativeMiddleBodyView.a()).a(parampau);
        return;
      case 111: 
        qad.a(parampau.a());
        paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
        paramContainer = ComponentContentGridImage.a(parampau, paramInt1);
        paramNativeMiddleBodyView.setMIReadInJoyModel(parampau);
        paramNativeMiddleBodyView.a(paramContainer);
        paramNativeMiddleBodyView.setOnNoItemClickListener(new phf(this, parampau));
        return;
      }
      paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.a();
      qad.a(parampau.a());
      paramNativeMiddleBodyView.a(parampau);
      try
      {
        if ((parampau.a().mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_Boolean) && (parampau.a().mSocialFeedInfo.jdField_a_of_type_Qco != null))
        {
          paramNativeMiddleBodyView.setOnClickListener(new phh(this, parampau, paramContainer, paramNativeMiddleBodyView));
          return;
        }
      }
      catch (NullPointerException parampau)
      {
        QLog.e("PgcShortContentProteusItem", 1, parampau.toString());
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pau parampau, ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    }
    for (;;)
    {
      return super.a(paramInt, paramContainer, parampau, paramViewBase);
      paramViewBase.setOnClickListener(new phb(this, parampau));
      return true;
      paramViewBase.setOnClickListener(new phc(this, paramViewBase, parampau));
      continue;
      paramViewBase.setOnClickListener(new phd(this, parampau, paramViewBase));
    }
  }
  
  protected void c(int paramInt1, Container paramContainer, pau parampau, int paramInt2, ViewBase paramViewBase)
  {
    super.c(paramInt1, paramContainer, parampau, paramInt2, paramViewBase);
    if (paramInt1 == 133) {}
    try
    {
      a(paramViewBase, parampau, paramContainer);
      return;
    }
    catch (NullPointerException paramContainer)
    {
      QLog.e("PgcShortContentProteusItem", 1, paramContainer.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgw
 * JD-Core Version:    0.7.0.1
 */