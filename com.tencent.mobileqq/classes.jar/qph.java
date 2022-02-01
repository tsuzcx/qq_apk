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

public class qph
  extends qpa
{
  private txn jdField_a_of_type_Txn;
  private uuw jdField_a_of_type_Uuw;
  
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
          localObject = pqx.a(paramString, l, i);
          if (QLog.isColorLevel()) {
            QLog.i("PgcShortContentProteusItem", 1, " STR_ID_SHORT_CONTENT_VIDEO_JUMP_CLICK jump, percentage=" + l + ",mute=" + i + ",oldScheme=" + paramString + ",newScheme=" + (String)localObject);
          }
          pqx.a(paramView.getContext(), (String)localObject, null);
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
    String str = pqf.a(paramArticleInfo);
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    olh.a(null, paramArticleInfo.mSubscribeID, "0X800AB52", "0X800AB52", 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str, false);
  }
  
  private void a(ViewBase paramViewBase, qfw paramqfw, Container paramContainer)
  {
    Object localObject = (qut)paramViewBase.findViewBaseByName("id_pgc_short_content_video_view");
    if (localObject == null) {}
    ViewBase localViewBase;
    NativeVideoView localNativeVideoView;
    ViewBean localViewBean;
    do
    {
      return;
      localViewBase = paramViewBase.findViewBaseByName("id_pgc_short_content_video_audio_icon");
      paramViewBase = paramViewBase.findViewBaseByName("id_pgc_float_contain");
      localNativeVideoView = ((qut)localObject).a();
      localViewBean = paramqfw.a().mProteusTemplateBean.getViewBean().findViewFromChild("id_pgc_short_content_video_audio_icon");
    } while ((localViewBase == null) || (paramViewBase == null) || (localNativeVideoView == null) || (localViewBean == null));
    localViewBase.setVisibility(8);
    paramViewBase.setVisibility(0);
    localNativeVideoView.needInterceptGlobalLayoutChanged = true;
    localNativeVideoView.setMute(true);
    localViewBean.putMapValue("pgc_video_content_audio_icon", "video_audio_mute");
    localViewBase.bindDynamicValue(localViewBean);
    localObject = ((qut)localObject).a();
    qpt localqpt = new qpt(this);
    qpy localqpy = new qpy(this, true);
    if ((syq)paramContainer.getTag(2131376197) == null) {
      paramContainer.setTag(2131376197, new qpu(this, (View)localObject, localqpy, localNativeVideoView));
    }
    localNativeVideoView.setOnCheckShownListener(localqpt);
    if (localObject != null) {
      ((View)localObject).addOnAttachStateChangeListener(new qpw(this, paramqfw, localNativeVideoView, localqpy, new qpv(this, localNativeVideoView, localViewBean, localViewBase)));
    }
    localNativeVideoView.setOnProgressChangedListener(new qpj(this, paramViewBase));
    localNativeVideoView.setVideoPlayListener(new qpk(this, localNativeVideoView, localViewBase, paramViewBase));
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 109) && (paramInt != 133) && (paramInt != 134);
  }
  
  private void c(qfw paramqfw, ViewBase paramViewBase)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Activity localActivity = paramqfw.a().a();
    this.jdField_a_of_type_Uuw = new uuw(localActivity, localQQAppInterface, new qpz(this, paramqfw.a(), new WeakReference(localActivity)));
    paramViewBase.getNativeView().addOnAttachStateChangeListener(new qpl(this));
    paramqfw = this.jdField_a_of_type_Uuw.a().getIntent();
    if ((paramqfw != null) && (TextUtils.isEmpty(paramqfw.getStringExtra("big_brother_source_key")))) {
      paramqfw.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    }
    this.jdField_a_of_type_Uuw.a().setActionSheetTitle(anvx.a(2131713041));
    this.jdField_a_of_type_Uuw.a(new List[] { a() }, 13);
  }
  
  protected View a(int paramInt, Context paramContext, qfw paramqfw, qud paramqud)
  {
    paramqfw = paramqfw.a();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 111: 
      return new qpi(this, paramContext, paramqfw);
    case 110: 
      return new qpp(this, paramContext, paramqfw);
    case 132: 
      return new PgcSmallView(132, paramContext);
    }
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    qlk localqlk = new qlk();
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
          localqlk.a(paramBaseArticleInfo, l);
          if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaLangString != null)))) {
            localqlk.p(paramBaseArticleInfo);
          }
          if ((paramInt == 34) || (paramInt == 85)) {
            localqlk.c(paramBaseArticleInfo, anvx.a(2131707434));
          }
          localqlk.i(paramBaseArticleInfo);
          if (a(paramInt)) {
            localqlk.z(paramBaseArticleInfo);
          }
          localqlk.a(paramBaseArticleInfo).b(paramBaseArticleInfo).r(paramBaseArticleInfo).e(paramBaseArticleInfo).d(paramBaseArticleInfo).j(paramBaseArticleInfo).g(paramBaseArticleInfo).k(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).a("ReadInjoy_pgc_shortcontent_cell").E(paramBaseArticleInfo).l(paramBaseArticleInfo).I(paramBaseArticleInfo).t(paramBaseArticleInfo).u(paramBaseArticleInfo);
          if (paramInt == 133) {
            localqlk.Q(paramBaseArticleInfo);
          }
          localqlk.C(paramBaseArticleInfo);
          return localqlk.a();
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
  
  public void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    qvn.f(localViewBase, paramqfw);
    qvn.e(localViewBase, paramqfw);
    qvn.a(localViewBase, paramqfw.a());
    qvn.c(localViewBase, paramqfw);
    c(paramInt1, paramContainer, paramqfw, paramInt2, localViewBase);
    b(paramInt1, paramContainer, paramqfw, paramInt2, localViewBase);
    a(paramInt1, paramContainer, paramqfw, paramInt2, localViewBase);
    qvn.b(localViewBase, paramqfw);
    qvn.d(localViewBase, paramqfw);
  }
  
  protected void a(int paramInt1, qfw paramqfw, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (paramqfw.a() == null)) {}
    for (;;)
    {
      return;
      szd localszd = paramqfw.a();
      switch (paramInt1)
      {
      default: 
        return;
      case 110: 
        rny.a(paramqfw.a());
        paramNativeMiddleBodyView.a().setOnClickListener(new qpr(this, paramqfw, paramContainer, localszd));
        ((rbo)paramNativeMiddleBodyView.a()).a(paramqfw);
        return;
      case 111: 
        rny.a(paramqfw.a());
        paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
        paramContainer = ComponentContentGridImage.a(paramqfw, paramInt1);
        paramNativeMiddleBodyView.setMIReadInJoyModel(paramqfw);
        paramNativeMiddleBodyView.a(paramContainer);
        paramNativeMiddleBodyView.setOnNoItemClickListener(new qpq(this, paramqfw));
        return;
      }
      paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.a();
      rny.a(paramqfw.a());
      paramNativeMiddleBodyView.a(paramqfw);
      try
      {
        if ((paramqfw.a().mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_Boolean) && (paramqfw.a().mSocialFeedInfo.jdField_a_of_type_Rre != null))
        {
          paramNativeMiddleBodyView.setOnClickListener(new qps(this, paramqfw, paramNativeMiddleBodyView, paramContainer));
          return;
        }
      }
      catch (NullPointerException paramqfw)
      {
        QLog.e("PgcShortContentProteusItem", 1, paramqfw.toString());
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, qfw paramqfw, ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    }
    for (;;)
    {
      return super.a(paramInt, paramContainer, paramqfw, paramViewBase);
      paramViewBase.setOnClickListener(new qpm(this, paramqfw));
      return true;
      paramViewBase.setOnClickListener(new qpn(this, paramViewBase, paramqfw));
      continue;
      paramViewBase.setOnClickListener(new qpo(this, paramqfw, paramViewBase));
    }
  }
  
  protected void c(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2, ViewBase paramViewBase)
  {
    super.c(paramInt1, paramContainer, paramqfw, paramInt2, paramViewBase);
    if (paramInt1 == 133) {}
    try
    {
      a(paramViewBase, paramqfw, paramContainer);
      return;
    }
    catch (NullPointerException paramContainer)
    {
      QLog.e("PgcShortContentProteusItem", 1, paramContainer.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qph
 * JD-Core Version:    0.7.0.1
 */