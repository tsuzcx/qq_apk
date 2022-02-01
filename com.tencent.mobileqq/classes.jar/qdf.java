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

public class qdf
  extends qcy
{
  private tjz jdField_a_of_type_Tjz;
  private ugz jdField_a_of_type_Ugz;
  
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
          localObject = pay.b(paramString, l, i);
          if (QLog.isColorLevel()) {
            QLog.i("PgcShortContentProteusItem", 1, " STR_ID_SHORT_CONTENT_VIDEO_JUMP_CLICK jump, percentage=" + l + ",mute=" + i + ",oldScheme=" + paramString + ",newScheme=" + (String)localObject);
          }
          pay.a(paramView.getContext(), (String)localObject, null);
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
    String str = pay.a(paramArticleInfo);
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    odq.a(null, paramArticleInfo.mSubscribeID, "0X800AB52", "0X800AB52", 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str, false);
  }
  
  private void a(ViewBase paramViewBase, pvc parampvc, Container paramContainer)
  {
    Object localObject = (qip)paramViewBase.findViewBaseByName("id_pgc_short_content_video_view");
    if (localObject == null) {}
    ViewBase localViewBase;
    NativeVideoView localNativeVideoView;
    ViewBean localViewBean;
    do
    {
      return;
      localViewBase = paramViewBase.findViewBaseByName("id_pgc_short_content_video_audio_icon");
      paramViewBase = paramViewBase.findViewBaseByName("id_pgc_float_contain");
      localNativeVideoView = ((qip)localObject).a();
      localViewBean = parampvc.a().mProteusTemplateBean.getViewBean().findViewFromChild("id_pgc_short_content_video_audio_icon");
    } while ((localViewBase == null) || (paramViewBase == null) || (localNativeVideoView == null) || (localViewBean == null));
    localViewBase.setVisibility(8);
    paramViewBase.setVisibility(0);
    localNativeVideoView.needInterceptGlobalLayoutChanged = true;
    localNativeVideoView.setMute(true);
    localViewBean.putMapValue("pgc_video_content_audio_icon", "video_audio_mute");
    localViewBase.bindDynamicValue(localViewBean);
    localObject = ((qip)localObject).a();
    qdr localqdr = new qdr(this);
    qdw localqdw = new qdw(this, true);
    if ((slg)paramContainer.getTag(2131375950) == null) {
      paramContainer.setTag(2131375950, new qds(this, (View)localObject, localqdw, localNativeVideoView));
    }
    localNativeVideoView.setOnCheckShownListener(localqdr);
    if (localObject != null) {
      ((View)localObject).addOnAttachStateChangeListener(new qdu(this, parampvc, localNativeVideoView, localqdw, new qdt(this, localNativeVideoView, localViewBean, localViewBase)));
    }
    localNativeVideoView.setOnProgressChangedListener(new qdh(this, paramViewBase));
    localNativeVideoView.setVideoPlayListener(new qdi(this, localNativeVideoView, localViewBase, paramViewBase));
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 109) && (paramInt != 133) && (paramInt != 134);
  }
  
  private void c(pvc parampvc, ViewBase paramViewBase)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Activity localActivity = parampvc.a().a();
    this.jdField_a_of_type_Ugz = new ugz(localActivity, localQQAppInterface, new qdx(this, parampvc.a(), new WeakReference(localActivity)));
    paramViewBase.getNativeView().addOnAttachStateChangeListener(new qdj(this));
    parampvc = this.jdField_a_of_type_Ugz.a().getIntent();
    if ((parampvc != null) && (TextUtils.isEmpty(parampvc.getStringExtra("big_brother_source_key")))) {
      parampvc.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    }
    this.jdField_a_of_type_Ugz.a().setActionSheetTitle(amtj.a(2131712694));
    this.jdField_a_of_type_Ugz.a(new List[] { a() }, 13);
  }
  
  protected View a(int paramInt, Context paramContext, pvc parampvc, qhz paramqhz)
  {
    parampvc = parampvc.a();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 111: 
      return new qdg(this, paramContext, parampvc);
    case 110: 
      return new qdn(this, paramContext, parampvc);
    case 132: 
      return new PgcSmallView(132, paramContext);
    }
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    pzf localpzf = new pzf();
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
          localpzf.a(paramBaseArticleInfo, l);
          if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_JavaLangString != null)))) {
            localpzf.o(paramBaseArticleInfo);
          }
          if ((paramInt == 34) || (paramInt == 85)) {
            localpzf.c(paramBaseArticleInfo, amtj.a(2131707087));
          }
          localpzf.h(paramBaseArticleInfo);
          if (a(paramInt)) {
            localpzf.y(paramBaseArticleInfo);
          }
          localpzf.a(paramBaseArticleInfo).b(paramBaseArticleInfo).q(paramBaseArticleInfo).e(paramBaseArticleInfo).d(paramBaseArticleInfo).i(paramBaseArticleInfo).g(paramBaseArticleInfo).j(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).a("ReadInjoy_pgc_shortcontent_cell").D(paramBaseArticleInfo).k(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).t(paramBaseArticleInfo);
          if (paramInt == 133) {
            localpzf.P(paramBaseArticleInfo);
          }
          localpzf.B(paramBaseArticleInfo);
          return localpzf.a();
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
  
  public void a(int paramInt1, Container paramContainer, pvc parampvc, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    qji.e(localViewBase, parampvc);
    qji.d(localViewBase, parampvc);
    qji.a(localViewBase, parampvc.a());
    qji.b(localViewBase, parampvc);
    c(paramInt1, paramContainer, parampvc, paramInt2, localViewBase);
    b(paramInt1, paramContainer, parampvc, paramInt2, localViewBase);
    a(paramInt1, paramContainer, parampvc, paramInt2, localViewBase);
    qji.a(localViewBase, parampvc);
    qji.c(localViewBase, parampvc);
  }
  
  protected void a(int paramInt1, pvc parampvc, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (parampvc.a() == null)) {}
    for (;;)
    {
      return;
      slt localslt = parampvc.a();
      switch (paramInt1)
      {
      default: 
        return;
      case 110: 
        rbs.a(parampvc.a());
        paramNativeMiddleBodyView.a().setOnClickListener(new qdp(this, parampvc, paramContainer, localslt));
        ((qpj)paramNativeMiddleBodyView.a()).a(parampvc);
        return;
      case 111: 
        rbs.a(parampvc.a());
        paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
        paramContainer = ComponentContentGridImage.a(parampvc, paramInt1);
        paramNativeMiddleBodyView.setMIReadInJoyModel(parampvc);
        paramNativeMiddleBodyView.a(paramContainer);
        paramNativeMiddleBodyView.setOnNoItemClickListener(new qdo(this, parampvc));
        return;
      }
      paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.a();
      rbs.a(parampvc.a());
      paramNativeMiddleBodyView.a(parampvc);
      try
      {
        if ((parampvc.a().mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_Boolean) && (parampvc.a().mSocialFeedInfo.jdField_a_of_type_Rex != null))
        {
          paramNativeMiddleBodyView.setOnClickListener(new qdq(this, parampvc, paramNativeMiddleBodyView, paramContainer));
          return;
        }
      }
      catch (NullPointerException parampvc)
      {
        QLog.e("PgcShortContentProteusItem", 1, parampvc.toString());
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pvc parampvc, ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    }
    for (;;)
    {
      return super.a(paramInt, paramContainer, parampvc, paramViewBase);
      paramViewBase.setOnClickListener(new qdk(this, parampvc));
      return true;
      paramViewBase.setOnClickListener(new qdl(this, paramViewBase, parampvc));
      continue;
      paramViewBase.setOnClickListener(new qdm(this, parampvc, paramViewBase));
    }
  }
  
  protected void c(int paramInt1, Container paramContainer, pvc parampvc, int paramInt2, ViewBase paramViewBase)
  {
    super.c(paramInt1, paramContainer, parampvc, paramInt2, paramViewBase);
    if (paramInt1 == 133) {}
    try
    {
      a(paramViewBase, parampvc, paramContainer);
      return;
    }
    catch (NullPointerException paramContainer)
    {
      QLog.e("PgcShortContentProteusItem", 1, paramContainer.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qdf
 * JD-Core Version:    0.7.0.1
 */