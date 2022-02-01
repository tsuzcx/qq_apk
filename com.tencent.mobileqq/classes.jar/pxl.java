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

public class pxl
  extends pxe
{
  private tfv jdField_a_of_type_Tfv;
  private uak jdField_a_of_type_Uak;
  
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
          localObject = ozs.b(paramString, l, i);
          if (QLog.isColorLevel()) {
            QLog.i("PgcShortContentProteusItem", 1, " STR_ID_SHORT_CONTENT_VIDEO_JUMP_CLICK jump, percentage=" + l + ",mute=" + i + ",oldScheme=" + paramString + ",newScheme=" + (String)localObject);
          }
          ozs.a(paramView.getContext(), (String)localObject, null);
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
    String str = ozs.a(paramArticleInfo);
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    ocd.a(null, paramArticleInfo.mSubscribeID, "0X800AB52", "0X800AB52", 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str, false);
  }
  
  private void a(ViewBase paramViewBase, ppu paramppu, Container paramContainer)
  {
    Object localObject = (qcr)paramViewBase.findViewBaseByName("id_pgc_short_content_video_view");
    if (localObject == null) {}
    ViewBase localViewBase;
    NativeVideoView localNativeVideoView;
    ViewBean localViewBean;
    do
    {
      return;
      localViewBase = paramViewBase.findViewBaseByName("id_pgc_short_content_video_audio_icon");
      paramViewBase = paramViewBase.findViewBaseByName("id_pgc_float_contain");
      localNativeVideoView = ((qcr)localObject).a();
      localViewBean = paramppu.a().mProteusTemplateBean.getViewBean().findViewFromChild("id_pgc_short_content_video_audio_icon");
    } while ((localViewBase == null) || (paramViewBase == null) || (localNativeVideoView == null) || (localViewBean == null));
    localViewBase.setVisibility(8);
    paramViewBase.setVisibility(0);
    localNativeVideoView.needInterceptGlobalLayoutChanged = true;
    localNativeVideoView.setMute(true);
    localViewBean.putMapValue("pgc_video_content_audio_icon", "video_audio_mute");
    localViewBase.bindDynamicValue(localViewBean);
    localObject = ((qcr)localObject).a();
    pxx localpxx = new pxx(this);
    pyc localpyc = new pyc(this, true);
    if ((sdy)paramContainer.getTag(2131376186) == null) {
      paramContainer.setTag(2131376186, new pxy(this, (View)localObject, localpyc, localNativeVideoView));
    }
    localNativeVideoView.setOnCheckShownListener(localpxx);
    if (localObject != null) {
      ((View)localObject).addOnAttachStateChangeListener(new pya(this, paramppu, localNativeVideoView, localpyc, new pxz(this, localNativeVideoView, localViewBean, localViewBase)));
    }
    localNativeVideoView.setOnProgressChangedListener(new pxn(this, paramViewBase));
    localNativeVideoView.setVideoPlayListener(new pxo(this, localNativeVideoView, localViewBase, paramViewBase));
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 109) && (paramInt != 133) && (paramInt != 134);
  }
  
  private void c(ppu paramppu, ViewBase paramViewBase)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Activity localActivity = paramppu.a().a();
    this.jdField_a_of_type_Uak = new uak(localActivity, localQQAppInterface, new pyd(this, paramppu.a(), new WeakReference(localActivity)));
    paramViewBase.getNativeView().addOnAttachStateChangeListener(new pxp(this));
    paramppu = this.jdField_a_of_type_Uak.a().getIntent();
    if ((paramppu != null) && (TextUtils.isEmpty(paramppu.getStringExtra("big_brother_source_key")))) {
      paramppu.putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    }
    this.jdField_a_of_type_Uak.a().setActionSheetTitle(anzj.a(2131712462));
    this.jdField_a_of_type_Uak.a(new List[] { a() }, 13);
  }
  
  protected View a(int paramInt, Context paramContext, ppu paramppu, qcb paramqcb)
  {
    paramppu = paramppu.a();
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("" + paramInt);
    case 111: 
      return new pxm(this, paramContext, paramppu);
    case 110: 
      return new pxt(this, paramContext, paramppu);
    case 132: 
      return new PgcSmallView(132, paramContext);
    }
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    ptl localptl = new ptl();
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
          localptl.a(paramBaseArticleInfo, l);
          if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) || ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_JavaLangString != null)))) {
            localptl.o(paramBaseArticleInfo);
          }
          if ((paramInt == 34) || (paramInt == 85)) {
            localptl.c(paramBaseArticleInfo, anzj.a(2131706855));
          }
          localptl.h(paramBaseArticleInfo);
          if (a(paramInt)) {
            localptl.y(paramBaseArticleInfo);
          }
          localptl.a(paramBaseArticleInfo).b(paramBaseArticleInfo).q(paramBaseArticleInfo).e(paramBaseArticleInfo).d(paramBaseArticleInfo).i(paramBaseArticleInfo).g(paramBaseArticleInfo).j(paramBaseArticleInfo).u(paramBaseArticleInfo).v(paramBaseArticleInfo).a("ReadInjoy_pgc_shortcontent_cell").D(paramBaseArticleInfo).k(paramBaseArticleInfo).H(paramBaseArticleInfo).s(paramBaseArticleInfo).t(paramBaseArticleInfo);
          if (paramInt == 133) {
            localptl.P(paramBaseArticleInfo);
          }
          localptl.B(paramBaseArticleInfo);
          return localptl.a();
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
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    qdk.e(localViewBase, paramppu);
    qdk.d(localViewBase, paramppu);
    qdk.a(localViewBase, paramppu.a());
    qdk.b(localViewBase, paramppu);
    c(paramInt1, paramContainer, paramppu, paramInt2, localViewBase);
    b(paramInt1, paramContainer, paramppu, paramInt2, localViewBase);
    a(paramInt1, paramContainer, paramppu, paramInt2, localViewBase);
    qdk.a(localViewBase, paramppu);
    qdk.c(localViewBase, paramppu);
  }
  
  protected void a(int paramInt1, ppu paramppu, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if ((paramNativeMiddleBodyView.a() == null) || (paramppu.a() == null)) {}
    for (;;)
    {
      return;
      sel localsel = paramppu.a();
      switch (paramInt1)
      {
      default: 
        return;
      case 110: 
        quu.a(paramppu.a());
        paramNativeMiddleBodyView.a().setOnClickListener(new pxv(this, paramppu, paramContainer, localsel));
        ((qjg)paramNativeMiddleBodyView.a()).a(paramppu);
        return;
      case 111: 
        quu.a(paramppu.a());
        paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
        paramContainer = ComponentContentGridImage.a(paramppu, paramInt1);
        paramNativeMiddleBodyView.setMIReadInJoyModel(paramppu);
        paramNativeMiddleBodyView.a(paramContainer);
        paramNativeMiddleBodyView.setOnNoItemClickListener(new pxu(this, paramppu));
        return;
      }
      paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.a();
      quu.a(paramppu.a());
      paramNativeMiddleBodyView.a(paramppu);
      try
      {
        if ((paramppu.a().mSocialFeedInfo.jdField_a_of_type_Qyg.jdField_a_of_type_Boolean) && (paramppu.a().mSocialFeedInfo.jdField_a_of_type_Qxz != null))
        {
          paramNativeMiddleBodyView.setOnClickListener(new pxw(this, paramppu, paramNativeMiddleBodyView, paramContainer));
          return;
        }
      }
      catch (NullPointerException paramppu)
      {
        QLog.e("PgcShortContentProteusItem", 1, paramppu.toString());
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, ppu paramppu, ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    }
    for (;;)
    {
      return super.a(paramInt, paramContainer, paramppu, paramViewBase);
      paramViewBase.setOnClickListener(new pxq(this, paramppu));
      return true;
      paramViewBase.setOnClickListener(new pxr(this, paramViewBase, paramppu));
      continue;
      paramViewBase.setOnClickListener(new pxs(this, paramppu, paramViewBase));
    }
  }
  
  protected void c(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2, ViewBase paramViewBase)
  {
    super.c(paramInt1, paramContainer, paramppu, paramInt2, paramViewBase);
    if (paramInt1 == 133) {}
    try
    {
      a(paramViewBase, paramppu, paramContainer);
      return;
    }
    catch (NullPointerException paramContainer)
    {
      QLog.e("PgcShortContentProteusItem", 1, paramContainer.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxl
 * JD-Core Version:    0.7.0.1
 */