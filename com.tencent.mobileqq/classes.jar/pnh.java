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
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class pnh
  extends pna
{
  private spp jdField_a_of_type_Spp;
  private syq jdField_a_of_type_Syq;
  
  private List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(new sps("qq_friend", 2, false).a));
    localArrayList.add(Integer.valueOf(new sps("qzone", 3, false).a));
    localArrayList.add(Integer.valueOf(new sps("we_chat", 4, false).a));
    localArrayList.add(Integer.valueOf(new sps("we_chat_circle", 5, false).a));
    return localArrayList;
  }
  
  private void a(View paramView, String paramString)
  {
    if ((paramView instanceof VideoView))
    {
      Object localObject = (VideoView)paramView;
      long l = ((VideoView)localObject).a();
      int i;
      if (((VideoView)localObject).b()) {
        i = 0;
      }
      try
      {
        for (;;)
        {
          localObject = ors.b(paramString, l, i);
          if (QLog.isColorLevel()) {
            QLog.i("PgcShortContentProteusItem", 1, " STR_ID_SHORT_CONTENT_VIDEO_JUMP_CLICK jump, percentage=" + l + ",mute=" + i + ",oldScheme=" + paramString + ",newScheme=" + (String)localObject);
          }
          ors.a(paramView.getContext(), (String)localObject, null);
          return;
          i = 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("PgcShortContentProteusItem", 1, "buildNewScheme exception, e=" + localException.getMessage());
          String str = paramString;
        }
      }
    }
    QLog.e("PgcShortContentProteusItem", 1, "handleJumpScheme failed, view is not VideoView");
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    String str = ors.a(paramArticleInfo);
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    nrt.a(null, paramArticleInfo.mSubscribeID, "0X800AB52", "0X800AB52", 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str, false);
  }
  
  private void a(ViewBase paramViewBase, pgd parampgd, Container paramContainer)
  {
    Object localObject = (psd)paramViewBase.findViewBaseByName("id_pgc_short_content_video_view");
    if (localObject == null) {}
    ViewBase localViewBase;
    NativeVideoView localNativeVideoView;
    ViewBean localViewBean;
    do
    {
      return;
      localViewBase = paramViewBase.findViewBaseByName("id_pgc_short_content_video_audio_icon");
      paramViewBase = paramViewBase.findViewBaseByName("id_pgc_float_contain");
      localNativeVideoView = ((psd)localObject).a();
      localViewBean = parampgd.a().mProteusTemplateBean.getViewBean().findViewFromChild("id_pgc_short_content_video_audio_icon");
    } while ((localViewBase == null) || (paramViewBase == null) || (localNativeVideoView == null) || (localViewBean == null));
    localViewBase.setVisibility(8);
    paramViewBase.setVisibility(0);
    localNativeVideoView.jdField_a_of_type_Boolean = true;
    localNativeVideoView.setMute(true);
    localViewBean.putMapValue("pgc_video_content_audio_icon", "video_audio_mute");
    localViewBase.bindDynamicValue(localViewBean);
    localObject = ((psd)localObject).a();
    pnt localpnt = new pnt(this);
    pny localpny = new pny(this, true);
    if ((rpw)paramContainer.getTag(2131375271) == null) {
      paramContainer.setTag(2131375271, new pnu(this, (View)localObject, localpny, localNativeVideoView));
    }
    localNativeVideoView.setOnCheckShownListener(localpnt);
    if (localObject != null) {
      ((View)localObject).addOnAttachStateChangeListener(new pnw(this, parampgd, localNativeVideoView, localpny, new pnv(this, localNativeVideoView, localViewBean, localViewBase)));
    }
    localNativeVideoView.setOnProgressChangedListener(new pnj(this, paramViewBase));
    localNativeVideoView.setVideoPlayListener(new pnk(this, localNativeVideoView, localViewBase, paramViewBase));
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 109) && (paramInt != 133) && (paramInt != 134);
  }
  
  private void c(pgd parampgd, ViewBase paramViewBase)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.jdField_a_of_type_Syq == null)
    {
      this.jdField_a_of_type_Syq = new syq((Activity)paramViewBase.getNativeView().getContext(), localQQAppInterface, null, new pnz(this, parampgd.a(), new WeakReference((Activity)paramViewBase.getNativeView().getContext())));
      paramViewBase.getNativeView().addOnAttachStateChangeListener(new pnl(this));
    }
    this.jdField_a_of_type_Syq.a.setActionSheetTitle(alpo.a(2131713962));
    this.jdField_a_of_type_Syq.a(new List[] { a() });
  }
  
  protected View a(int paramInt, Context paramContext, pgd parampgd, prm paramprm)
  {
    parampgd = parampgd.a();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 111: 
      return new pni(this, paramContext, parampgd);
    case 110: 
      return new pnp(this, paramContext, parampgd);
    case 132: 
      return new PgcSmallView(132, paramContext);
    }
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    pjo localpjo = new pjo();
    label256:
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
          localpjo.a(paramBaseArticleInfo, l);
          if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_JavaLangString != null)))) {
            localpjo.p(paramBaseArticleInfo);
          }
          if ((paramInt == 34) || (paramInt == 85)) {
            localpjo.c(paramBaseArticleInfo, alpo.a(2131708357));
          }
          localpjo.h(paramBaseArticleInfo);
          if (a(paramInt)) {
            localpjo.z(paramBaseArticleInfo);
          }
          localpjo.a(paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).e(paramBaseArticleInfo).d(paramBaseArticleInfo).j(paramBaseArticleInfo).g(paramBaseArticleInfo).k(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).C(paramBaseArticleInfo).a("ReadInjoy_pgc_shortcontent_cell").E(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
          if (paramInt == 133) {
            localpjo.Q(paramBaseArticleInfo);
          }
          return localpjo.a();
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          break label256;
        }
        localNumberFormatException1 = localNumberFormatException1;
        l = 0L;
      }
    }
  }
  
  public void a(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    pqg localpqg = (pqg)localViewBase.findViewBaseByName("id_info_avator");
    if (localpqg != null) {
      localpqg.a(parampgd);
    }
    psw.d(localViewBase, parampgd);
    psw.b(localViewBase, parampgd);
    c(paramInt1, paramContainer, parampgd, paramInt2, localViewBase);
    b(paramInt1, paramContainer, parampgd, paramInt2, localViewBase);
    a(paramInt1, paramContainer, parampgd, paramInt2, localViewBase);
    psw.a(localViewBase, parampgd);
    psw.c(localViewBase, parampgd);
  }
  
  protected void a(int paramInt1, pgd parampgd, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampgd.a() == null)) {}
    for (;;)
    {
      return;
      rqj localrqj = parampgd.a();
      switch (paramInt1)
      {
      default: 
        return;
      case 110: 
        qjy.a(parampgd.a());
        paramNativeMiddleBodyView.a().setOnClickListener(new pnr(this, parampgd, paramContainer, localrqj));
        ((pxk)paramNativeMiddleBodyView.a()).a(parampgd);
        return;
      case 111: 
        qjy.a(parampgd.a());
        paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
        paramContainer = ComponentContentGridImage.a(parampgd, paramInt1);
        paramNativeMiddleBodyView.setMIReadInJoyModel(parampgd);
        paramNativeMiddleBodyView.a(paramContainer);
        paramNativeMiddleBodyView.setOnNoItemClickListener(new pnq(this, parampgd));
        return;
      }
      paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.a();
      qjy.a(parampgd.a());
      paramNativeMiddleBodyView.a(parampgd);
      try
      {
        if ((parampgd.a().mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_Boolean) && (parampgd.a().mSocialFeedInfo.jdField_a_of_type_Qmk != null))
        {
          paramNativeMiddleBodyView.setOnClickListener(new pns(this, parampgd, paramNativeMiddleBodyView, paramContainer));
          return;
        }
      }
      catch (NullPointerException parampgd)
      {
        QLog.e("PgcShortContentProteusItem", 1, parampgd.toString());
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pgd parampgd, ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    }
    for (;;)
    {
      return super.a(paramInt, paramContainer, parampgd, paramViewBase);
      paramViewBase.setOnClickListener(new pnm(this, parampgd));
      return true;
      paramViewBase.setOnClickListener(new pnn(this, paramViewBase, parampgd));
      continue;
      paramViewBase.setOnClickListener(new pno(this, parampgd, paramViewBase));
    }
  }
  
  protected void c(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2, ViewBase paramViewBase)
  {
    super.c(paramInt1, paramContainer, parampgd, paramInt2, paramViewBase);
    if (paramInt1 == 133) {}
    try
    {
      a(paramViewBase, parampgd, paramContainer);
      return;
    }
    catch (NullPointerException paramContainer)
    {
      QLog.e("PgcShortContentProteusItem", 1, paramContainer.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pnh
 * JD-Core Version:    0.7.0.1
 */