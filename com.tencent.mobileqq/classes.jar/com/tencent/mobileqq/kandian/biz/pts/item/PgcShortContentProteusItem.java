package com.tencent.mobileqq.kandian.biz.pts.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.view.widget.IReadInJoyListItemAutoPlayCallback;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentView;
import com.tencent.mobileqq.kandian.biz.pts.data.ProteusItemDataBuilder;
import com.tencent.mobileqq.kandian.biz.pts.view.PgcSmallView;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyMiddleBodyView;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyVideoView;
import com.tencent.mobileqq.kandian.biz.pts.view.helper.BindViewHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeMiddleBodyView;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeVideoView;
import com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.viola.modules.QShareUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ShortWithLongContentUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class PgcShortContentProteusItem
  extends PgcProteusItem
{
  private ReadInJoyShareHelperV2 a;
  private QShareUtils b;
  
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
      int i = ((VideoView)localObject).isMute() ^ true;
      StringBuilder localStringBuilder;
      String str;
      try
      {
        localObject = RIJJumpUtils.a(paramString, l, i);
      }
      catch (Exception localException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("buildNewScheme exception, e=");
        localStringBuilder.append(localException.getMessage());
        QLog.e("PgcShortContentProteusItem", 1, localStringBuilder.toString());
        str = paramString;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" STR_ID_SHORT_CONTENT_VIDEO_JUMP_CLICK jump, percentage=");
        localStringBuilder.append(l);
        localStringBuilder.append(",mute=");
        localStringBuilder.append(i);
        localStringBuilder.append(",oldScheme=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",newScheme=");
        localStringBuilder.append(str);
        QLog.i("PgcShortContentProteusItem", 1, localStringBuilder.toString());
      }
      RIJJumpUtils.a(paramView.getContext(), str, null);
      return;
    }
    QLog.e("PgcShortContentProteusItem", 1, "handleJumpScheme failed, view is not VideoView");
  }
  
  private void a(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel, Container paramContainer)
  {
    Object localObject = (ReadInJoyVideoView)paramViewBase.findViewBaseByName("id_pgc_short_content_video_view");
    if (localObject == null) {
      return;
    }
    ViewBase localViewBase = paramViewBase.findViewBaseByName("id_pgc_short_content_video_audio_icon");
    paramViewBase = paramViewBase.findViewBaseByName("id_pgc_float_contain");
    NativeVideoView localNativeVideoView = ((ReadInJoyVideoView)localObject).a();
    ViewBean localViewBean = paramIReadInJoyModel.k().mProteusTemplateBean.getViewBean().findViewFromChild("id_pgc_short_content_video_audio_icon");
    if ((localViewBase != null) && (paramViewBase != null) && (localNativeVideoView != null))
    {
      if (localViewBean == null) {
        return;
      }
      localViewBase.setVisibility(8);
      paramViewBase.setVisibility(0);
      localNativeVideoView.needInterceptGlobalLayoutChanged = true;
      localNativeVideoView.setMute(true);
      localViewBean.putMapValue("pgc_video_content_audio_icon", "video_audio_mute");
      localViewBase.bindDynamicValue(localViewBean);
      localObject = ((ReadInJoyVideoView)localObject).a();
      PgcShortContentProteusItem.6 local6 = new PgcShortContentProteusItem.6(this);
      PgcShortContentProteusItem.Bool localBool = new PgcShortContentProteusItem.Bool(this, true);
      if ((IReadInJoyListItemAutoPlayCallback)paramContainer.getTag(2131444293) == null) {
        paramContainer.setTag(2131444293, new PgcShortContentProteusItem.7(this, (View)localObject, localBool, localNativeVideoView));
      }
      localNativeVideoView.setOnCheckShownListener(local6);
      if (localObject != null) {
        ((View)localObject).addOnAttachStateChangeListener(new PgcShortContentProteusItem.9(this, paramIReadInJoyModel, localNativeVideoView, localBool, new PgcShortContentProteusItem.8(this, localNativeVideoView, localViewBean, localViewBase)));
      }
      localNativeVideoView.setOnProgressChangedListener(new PgcShortContentProteusItem.10(this, paramViewBase));
      localNativeVideoView.setVideoPlayListener(new PgcShortContentProteusItem.11(this, localNativeVideoView, localViewBase, paramViewBase));
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str1 = RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo);
    Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo;
    String str2 = paramAbsBaseArticleInfo.mSubscribeID;
    long l1 = ((SocializeFeedsInfo)localObject).a;
    long l2 = paramAbsBaseArticleInfo.mArticleID;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
    PublicAccountReportUtils.a(null, str2, "0X800AB52", "0X800AB52", 0, 0, String.valueOf(l1), String.valueOf(l2), ((StringBuilder)localObject).toString(), str1, false);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 109) && (paramInt != 133) && (paramInt != 134);
  }
  
  private void c(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Activity localActivity = paramIReadInJoyModel.u().a();
    this.a = new ReadInJoyShareHelperV2(localActivity, (AppInterface)localObject, new PgcShortContentProteusItem.PgcShortContentProteusItemSheetClickProcessor(this, paramIReadInJoyModel.k(), new WeakReference(localActivity)));
    paramViewBase.getNativeView().addOnAttachStateChangeListener(new PgcShortContentProteusItem.12(this));
    localObject = this.a.f().getIntent();
    if ((localObject != null) && (TextUtils.isEmpty(((Intent)localObject).getStringExtra("big_brother_source_key")))) {
      ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    }
    this.a.a().setActionSheetTitle(HardCodeUtil.a(2131911054));
    if (paramViewBase.getName().equals("id_share_button_style_a"))
    {
      paramViewBase = this.a;
      localObject = a();
      paramIReadInJoyModel = paramIReadInJoyModel.k().innerUniqueID;
      paramViewBase.a(new List[] { localObject }, 22, paramIReadInJoyModel);
      return;
    }
    paramViewBase = this.a;
    localObject = a();
    paramIReadInJoyModel = paramIReadInJoyModel.k().innerUniqueID;
    paramViewBase.a(new List[] { localObject }, 13, paramIReadInJoyModel);
  }
  
  protected View a(int paramInt, Context paramContext, IReadInJoyModel paramIReadInJoyModel, ReadInJoyMiddleBodyView paramReadInJoyMiddleBodyView)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.k();
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        paramContext = new StringBuilder();
        paramContext.append("");
        paramContext.append(paramInt);
        throw new IllegalArgumentException(paramContext.toString());
      case 132: 
        return new PgcSmallView(132, paramContext);
      }
    case 111: 
      return new PgcShortContentProteusItem.1(this, paramContext, paramIReadInJoyModel);
    case 110: 
      return new PgcShortContentProteusItem.2(this, paramContext, paramIReadInJoyModel);
    }
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ProteusItemDataBuilder localProteusItemDataBuilder = new ProteusItemDataBuilder();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramAbsBaseArticleInfo.mSubscribeID);
      l1 = l2;
      ReadInJoyUserInfoModule.a(l2, null);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    localProteusItemDataBuilder.a(paramAbsBaseArticleInfo, l1);
    if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mTitle)) || ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.c != null)))) {
      localProteusItemDataBuilder.p(paramAbsBaseArticleInfo);
    }
    if ((paramInt == 34) || (paramInt == 85)) {
      localProteusItemDataBuilder.c(paramAbsBaseArticleInfo, HardCodeUtil.a(2131905790));
    }
    localProteusItemDataBuilder.i(paramAbsBaseArticleInfo);
    if (a(paramInt)) {
      localProteusItemDataBuilder.z(paramAbsBaseArticleInfo);
    }
    localProteusItemDataBuilder.a(paramAbsBaseArticleInfo).b(paramAbsBaseArticleInfo).r(paramAbsBaseArticleInfo).e(paramAbsBaseArticleInfo).d(paramAbsBaseArticleInfo).j(paramAbsBaseArticleInfo).g(paramAbsBaseArticleInfo).k(paramAbsBaseArticleInfo).v(paramAbsBaseArticleInfo).w(paramAbsBaseArticleInfo).a("ReadInjoy_pgc_shortcontent_cell").E(paramAbsBaseArticleInfo).l(paramAbsBaseArticleInfo).I(paramAbsBaseArticleInfo).t(paramAbsBaseArticleInfo).u(paramAbsBaseArticleInfo);
    if (paramInt == 133) {
      localProteusItemDataBuilder.Q(paramAbsBaseArticleInfo);
    }
    localProteusItemDataBuilder.C(paramAbsBaseArticleInfo);
    return localProteusItemDataBuilder.a();
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    BindViewHelper.f(localViewBase, paramIReadInJoyModel);
    BindViewHelper.e(localViewBase, paramIReadInJoyModel);
    BindViewHelper.a(localViewBase, paramIReadInJoyModel.k());
    BindViewHelper.c(localViewBase, paramIReadInJoyModel);
    c(paramInt1, paramContainer, paramIReadInJoyModel, paramInt2, localViewBase);
    b(paramInt1, paramContainer, paramIReadInJoyModel, paramInt2, localViewBase);
    a(paramInt1, paramContainer, paramIReadInJoyModel, paramInt2, localViewBase);
    BindViewHelper.b(localViewBase, paramIReadInJoyModel);
    BindViewHelper.d(localViewBase, paramIReadInJoyModel);
  }
  
  protected void a(int paramInt1, IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if (paramNativeMiddleBodyView.getContent() != null)
    {
      if (paramIReadInJoyModel.u() == null) {
        return;
      }
      ReadInJoyBaseAdapter localReadInJoyBaseAdapter = (ReadInJoyBaseAdapter)paramIReadInJoyModel.u();
      if (paramInt1 != 110)
      {
        if (paramInt1 != 111)
        {
          if (paramInt1 != 132) {
            return;
          }
          paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.getContent();
          ShortWithLongContentUtil.a(paramIReadInJoyModel.k());
          paramNativeMiddleBodyView.a(paramIReadInJoyModel);
          try
          {
            if ((!paramIReadInJoyModel.k().mSocialFeedInfo.t.f) || (paramIReadInJoyModel.k().mSocialFeedInfo.L == null)) {
              return;
            }
            paramNativeMiddleBodyView.setOnClickListener(new PgcShortContentProteusItem.5(this, paramIReadInJoyModel, paramNativeMiddleBodyView, paramContainer));
            return;
          }
          catch (NullPointerException paramIReadInJoyModel)
          {
            QLog.e("PgcShortContentProteusItem", 1, paramIReadInJoyModel.toString());
            return;
          }
        }
        else
        {
          ShortWithLongContentUtil.a(paramIReadInJoyModel.k());
          paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.getContent();
          paramContainer = ComponentContentGridImage.a(paramIReadInJoyModel, paramInt1);
          paramNativeMiddleBodyView.setMIReadInJoyModel(paramIReadInJoyModel);
          paramNativeMiddleBodyView.a(paramContainer);
          paramNativeMiddleBodyView.setOnNoItemClickListener(new PgcShortContentProteusItem.3(this, paramIReadInJoyModel));
        }
      }
      else
      {
        ShortWithLongContentUtil.a(paramIReadInJoyModel.k());
        paramNativeMiddleBodyView.getContent().setOnClickListener(new PgcShortContentProteusItem.4(this, paramIReadInJoyModel, paramContainer, localReadInJoyBaseAdapter));
        ((ComponentView)paramNativeMiddleBodyView.getContent()).a(paramIReadInJoyModel);
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    if (i != 1158)
    {
      if (i != 1175)
      {
        if (i == 1176) {
          paramViewBase.setOnClickListener(new PgcShortContentProteusItem.15(this, paramIReadInJoyModel, paramViewBase));
        }
      }
      else {
        paramViewBase.setOnClickListener(new PgcShortContentProteusItem.14(this, paramViewBase, paramIReadInJoyModel));
      }
      return super.a(paramInt, paramContainer, paramIReadInJoyModel, paramViewBase);
    }
    paramViewBase.setOnClickListener(new PgcShortContentProteusItem.13(this, paramIReadInJoyModel));
    return true;
  }
  
  protected void c(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2, ViewBase paramViewBase)
  {
    super.c(paramInt1, paramContainer, paramIReadInJoyModel, paramInt2, paramViewBase);
    if (paramInt1 == 133) {
      try
      {
        a(paramViewBase, paramIReadInJoyModel, paramContainer);
        return;
      }
      catch (NullPointerException paramContainer)
      {
        QLog.e("PgcShortContentProteusItem", 1, paramContainer.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcShortContentProteusItem
 * JD-Core Version:    0.7.0.1
 */