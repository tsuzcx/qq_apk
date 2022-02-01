import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class qfa
  extends qet
{
  private tpa jdField_a_of_type_Tpa;
  private uai jdField_a_of_type_Uai;
  
  private List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(13));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(9));
    localArrayList.add(Integer.valueOf(10));
    return localArrayList;
  }
  
  private void a(View paramView, String paramString)
  {
    if ((paramView instanceof VideoView))
    {
      Object localObject = (VideoView)paramView;
      long l = ((VideoView)localObject).getPercentage();
      int i;
      if (((VideoView)localObject).isMute()) {
        i = 0;
      }
      try
      {
        for (;;)
        {
          localObject = pha.b(paramString, l, i);
          if (QLog.isColorLevel()) {
            QLog.i("PgcShortContentProteusItem", 1, " STR_ID_SHORT_CONTENT_VIDEO_JUMP_CLICK jump, percentage=" + l + ",mute=" + i + ",oldScheme=" + paramString + ",newScheme=" + (String)localObject);
          }
          pha.a(paramView.getContext(), (String)localObject, null);
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
    String str = pha.a(paramArticleInfo);
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    oat.a(null, paramArticleInfo.mSubscribeID, "0X800AB52", "0X800AB52", 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str, false);
  }
  
  private void a(ViewBase paramViewBase, pxk parampxk, Container paramContainer)
  {
    Object localObject = (qkf)paramViewBase.findViewBaseByName("id_pgc_short_content_video_view");
    if (localObject == null) {}
    ViewBase localViewBase;
    NativeVideoView localNativeVideoView;
    ViewBean localViewBean;
    do
    {
      return;
      localViewBase = paramViewBase.findViewBaseByName("id_pgc_short_content_video_audio_icon");
      paramViewBase = paramViewBase.findViewBaseByName("id_pgc_float_contain");
      localNativeVideoView = ((qkf)localObject).a();
      localViewBean = parampxk.a().mProteusTemplateBean.getViewBean().findViewFromChild("id_pgc_short_content_video_audio_icon");
    } while ((localViewBase == null) || (paramViewBase == null) || (localNativeVideoView == null) || (localViewBean == null));
    localViewBase.setVisibility(8);
    paramViewBase.setVisibility(0);
    localNativeVideoView.needInterceptGlobalLayoutChanged = true;
    localNativeVideoView.setMute(true);
    localViewBean.putMapValue("pgc_video_content_audio_icon", "video_audio_mute");
    localViewBase.bindDynamicValue(localViewBean);
    localObject = ((qkf)localObject).a();
    qfm localqfm = new qfm(this);
    qfr localqfr = new qfr(this, true);
    if ((smu)paramContainer.getTag(2131376046) == null) {
      paramContainer.setTag(2131376046, new qfn(this, (View)localObject, localqfr, localNativeVideoView));
    }
    localNativeVideoView.setOnCheckShownListener(localqfm);
    if (localObject != null) {
      ((View)localObject).addOnAttachStateChangeListener(new qfp(this, parampxk, localNativeVideoView, localqfr, new qfo(this, localNativeVideoView, localViewBean, localViewBase)));
    }
    localNativeVideoView.setOnProgressChangedListener(new qfc(this, paramViewBase));
    localNativeVideoView.setVideoPlayListener(new qfd(this, localNativeVideoView, localViewBase, paramViewBase));
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 109) && (paramInt != 133) && (paramInt != 134);
  }
  
  private void c(pxk parampxk, ViewBase paramViewBase)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.jdField_a_of_type_Uai == null)
    {
      Activity localActivity = parampxk.a().a();
      this.jdField_a_of_type_Uai = new uai(localActivity, localQQAppInterface, new qfs(this, parampxk.a(), new WeakReference(localActivity)));
      paramViewBase.getNativeView().addOnAttachStateChangeListener(new qfe(this));
    }
    parampxk = this.jdField_a_of_type_Uai.a().getIntent();
    if ((parampxk != null) && (TextUtils.isEmpty(parampxk.getStringExtra("big_brother_source_key")))) {
      parampxk.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    }
    this.jdField_a_of_type_Uai.a().setActionSheetTitle(anni.a(2131712353));
    this.jdField_a_of_type_Uai.a(new List[] { a() }, 13);
  }
  
  protected View a(int paramInt, Context paramContext, pxk parampxk, qjp paramqjp)
  {
    parampxk = parampxk.a();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 111: 
      return new qfb(this, paramContext, parampxk);
    case 110: 
      return new qfi(this, paramContext, parampxk);
    case 132: 
      return new PgcSmallView(132, paramContext);
    }
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    qba localqba = new qba();
    label259:
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
          localqba.a(paramBaseArticleInfo, l);
          if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_JavaLangString != null)))) {
            localqba.o(paramBaseArticleInfo);
          }
          if ((paramInt == 34) || (paramInt == 85)) {
            localqba.c(paramBaseArticleInfo, anni.a(2131706746));
          }
          localqba.h(paramBaseArticleInfo);
          if (a(paramInt)) {
            localqba.y(paramBaseArticleInfo);
          }
          localqba.a(paramBaseArticleInfo).b(paramBaseArticleInfo).q(paramBaseArticleInfo).e(paramBaseArticleInfo).d(paramBaseArticleInfo).i(paramBaseArticleInfo).g(paramBaseArticleInfo).j(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).a("ReadInjoy_pgc_shortcontent_cell").D(paramBaseArticleInfo).k(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).t(paramBaseArticleInfo);
          if (paramInt == 133) {
            localqba.P(paramBaseArticleInfo);
          }
          localqba.B(paramBaseArticleInfo);
          return localqba.a();
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          break label259;
        }
        localNumberFormatException1 = localNumberFormatException1;
        l = 0L;
      }
    }
  }
  
  public void a(int paramInt1, Container paramContainer, pxk parampxk, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    qky.e(localViewBase, parampxk);
    qky.d(localViewBase, parampxk);
    qky.a(localViewBase, parampxk.a());
    qky.b(localViewBase, parampxk);
    c(paramInt1, paramContainer, parampxk, paramInt2, localViewBase);
    b(paramInt1, paramContainer, parampxk, paramInt2, localViewBase);
    a(paramInt1, paramContainer, parampxk, paramInt2, localViewBase);
    qky.a(localViewBase, parampxk);
    qky.c(localViewBase, parampxk);
  }
  
  protected void a(int paramInt1, pxk parampxk, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampxk.a() == null)) {}
    for (;;)
    {
      return;
      snh localsnh = parampxk.a();
      switch (paramInt1)
      {
      default: 
        return;
      case 110: 
        reb.a(parampxk.a());
        paramNativeMiddleBodyView.a().setOnClickListener(new qfk(this, parampxk, paramContainer, localsnh));
        ((qqs)paramNativeMiddleBodyView.a()).a(parampxk);
        return;
      case 111: 
        reb.a(parampxk.a());
        paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
        paramContainer = ComponentContentGridImage.a(parampxk, paramInt1);
        paramNativeMiddleBodyView.setMIReadInJoyModel(parampxk);
        paramNativeMiddleBodyView.a(paramContainer);
        paramNativeMiddleBodyView.setOnNoItemClickListener(new qfj(this, parampxk));
        return;
      }
      paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.a();
      reb.a(parampxk.a());
      paramNativeMiddleBodyView.a(parampxk);
      try
      {
        if ((parampxk.a().mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_Boolean) && (parampxk.a().mSocialFeedInfo.jdField_a_of_type_Rhg != null))
        {
          paramNativeMiddleBodyView.setOnClickListener(new qfl(this, parampxk, paramNativeMiddleBodyView, paramContainer));
          return;
        }
      }
      catch (NullPointerException parampxk)
      {
        QLog.e("PgcShortContentProteusItem", 1, parampxk.toString());
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pxk parampxk, ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    }
    for (;;)
    {
      return super.a(paramInt, paramContainer, parampxk, paramViewBase);
      paramViewBase.setOnClickListener(new qff(this, parampxk));
      return true;
      paramViewBase.setOnClickListener(new qfg(this, paramViewBase, parampxk));
      continue;
      paramViewBase.setOnClickListener(new qfh(this, parampxk, paramViewBase));
    }
  }
  
  protected void c(int paramInt1, Container paramContainer, pxk parampxk, int paramInt2, ViewBase paramViewBase)
  {
    super.c(paramInt1, paramContainer, parampxk, paramInt2, paramViewBase);
    if (paramInt1 == 133) {}
    try
    {
      a(paramViewBase, parampxk, paramContainer);
      return;
    }
    catch (NullPointerException paramContainer)
    {
      QLog.e("PgcShortContentProteusItem", 1, paramContainer.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qfa
 * JD-Core Version:    0.7.0.1
 */