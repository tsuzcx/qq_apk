package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnGalleryImageClickListener;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentBig;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentPgcVideo;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentPGCShortContentBig;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentView;
import com.tencent.mobileqq.kandian.biz.pts.data.ProteusItemDataBuilder;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.biz.pts.util.RIJBiuCardUtil;
import com.tencent.mobileqq.kandian.biz.pts.view.BiuCommentView;
import com.tencent.mobileqq.kandian.biz.pts.view.PgcSmallView;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyMiddleBodyView;
import com.tencent.mobileqq.kandian.biz.pts.view.SummaryView;
import com.tencent.mobileqq.kandian.biz.pts.view.helper.BindViewHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeMiddleBodyView;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.repo.account.ArticleInfoHelper;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import org.json.JSONObject;

public class BiuPgcProteusItem
  implements ProteusItem
{
  private void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    int i = a(paramAbsBaseArticleInfo, paramReadInJoyBaseAdapter);
    paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.a().a();
    if (paramReadInJoyBaseAdapter != null) {
      paramReadInJoyBaseAdapter.a(paramContext, paramAbsBaseArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void a(Context paramContext, IReadInJoyModel paramIReadInJoyModel, int paramInt)
  {
    OnGalleryImageClickListener localOnGalleryImageClickListener = ((ReadInJoyBaseAdapter)paramIReadInJoyModel.a()).a().a();
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    if ((paramIReadInJoyModel != null) && (localOnGalleryImageClickListener != null)) {
      localOnGalleryImageClickListener.a(paramContext, paramIReadInJoyModel, 0, paramIReadInJoyModel.innerUniqueID, 6, paramInt, 0);
    }
  }
  
  private void a(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
  {
    if ((paramViewBase != null) && (paramIReadInJoyModel != null))
    {
      if (paramIReadInJoyModel.a() == null) {
        return;
      }
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
      if (paramViewBase != null)
      {
        if (paramViewBase.getNativeView() == null) {
          return;
        }
        ReadInJoyBaseAdapter localReadInJoyBaseAdapter = (ReadInJoyBaseAdapter)paramIReadInJoyModel.a();
        paramViewBase.getNativeView().setOnClickListener(new BiuPgcProteusItem.7(this, localReadInJoyBaseAdapter, paramIReadInJoyModel));
      }
    }
  }
  
  private View b(int paramInt, Context paramContext, IReadInJoyModel paramIReadInJoyModel)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.a();
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a != null) && (paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a.size() > 0) && (ComponentContentGridImage.a(paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a.size(), paramIReadInJoyModel.mSocialFeedInfo.jdField_a_of_type_Int) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void b(int paramInt1, IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.a();
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a != null) && (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a.size() > 0) && (ComponentContentGridImage.a(localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a.size(), localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int) == 1))
    {
      c(paramInt1, paramIReadInJoyModel, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    if ((paramNativeMiddleBodyView.a() instanceof ComponentContentGridImage))
    {
      paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramIReadInJoyModel, paramInt1));
      paramNativeMiddleBodyView.setMIReadInJoyModel(paramIReadInJoyModel);
      paramNativeMiddleBodyView.setGalleryClickListener(new BiuPgcProteusItem.5(this, paramIReadInJoyModel, paramContainer, paramInt2));
      return;
    }
    paramNativeMiddleBodyView = new StringBuilder();
    paramNativeMiddleBodyView.append("[bindGalleryBodyView] unexpected item: ");
    paramNativeMiddleBodyView.append(paramInt1);
    paramNativeMiddleBodyView.append(" ");
    paramNativeMiddleBodyView.append(paramIReadInJoyModel.a());
    QLog.e("BiuPgcProteusItem", 1, paramNativeMiddleBodyView.toString());
  }
  
  private void c(int paramInt1, IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if (!(paramNativeMiddleBodyView.a() instanceof AdapterView)) {
      paramNativeMiddleBodyView.a().setOnClickListener(new BiuPgcProteusItem.6(this, paramIReadInJoyModel, paramContainer, paramInt2));
    }
    ((ComponentView)paramNativeMiddleBodyView.a()).a(paramIReadInJoyModel);
  }
  
  public int a(AbsBaseArticleInfo paramAbsBaseArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    return GalleryReportedUtils.a(paramReadInJoyBaseAdapter.a(), RIJFeedsType.a(paramAbsBaseArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramInt != 27)
    {
      if (paramInt != 28)
      {
        if (paramInt != 33) {
          if (paramInt != 35) {
            if ((paramInt != 49) && (paramInt != 62) && (paramInt != 63)) {
              if ((paramInt == 94) || (paramInt == 95)) {}
            }
          }
        }
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
          case 113: 
            return new ComponentPGCShortContentBig(paramContext);
          case 112: 
            return null;
          }
        case 10: 
        case 12: 
          return new PgcSmallView(paramInt, paramContext);
          return b(paramInt, paramContext, paramIReadInJoyModel);
          return new ComponentContentGridImage(paramContext);
          return new ComponentContentBig(paramContext);
        }
      }
      return new ComponentContentPgcVideo(paramContext);
    }
    return new ComponentContentBig(paramContext);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ProteusItemDataBuilder localProteusItemDataBuilder = new ProteusItemDataBuilder();
    long l;
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null)) {
      l = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.a;
    } else {
      l = 0L;
    }
    if ((paramInt == 35) && (!paramAbsBaseArticleInfo.isPGCShortContent())) {
      localProteusItemDataBuilder.c(paramAbsBaseArticleInfo, HardCodeUtil.a(2131701371));
    }
    if (paramInt == 33) {
      localProteusItemDataBuilder.c(paramAbsBaseArticleInfo, HardCodeUtil.a(2131701372));
    }
    if (paramInt != 33) {
      localProteusItemDataBuilder.A(paramAbsBaseArticleInfo).D(paramAbsBaseArticleInfo).B(paramAbsBaseArticleInfo);
    }
    if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95)) {
      localProteusItemDataBuilder.o(paramAbsBaseArticleInfo);
    } else if ((paramAbsBaseArticleInfo.mSocialFeedInfo.a()) && (!ArticleInfoHelper.b(paramAbsBaseArticleInfo))) {
      localProteusItemDataBuilder.o(paramAbsBaseArticleInfo);
    }
    localProteusItemDataBuilder.a(paramAbsBaseArticleInfo).b(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, l).f(paramAbsBaseArticleInfo).g(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, "Biu了").k(paramAbsBaseArticleInfo).i(paramAbsBaseArticleInfo).j(paramAbsBaseArticleInfo).n(paramAbsBaseArticleInfo).m(paramAbsBaseArticleInfo).C(paramAbsBaseArticleInfo).r(paramAbsBaseArticleInfo).v(paramAbsBaseArticleInfo).w(paramAbsBaseArticleInfo).G(paramAbsBaseArticleInfo).E(paramAbsBaseArticleInfo).s(paramAbsBaseArticleInfo).l(paramAbsBaseArticleInfo).I(paramAbsBaseArticleInfo).t(paramAbsBaseArticleInfo).u(paramAbsBaseArticleInfo);
    if (paramInt != 112) {
      localProteusItemDataBuilder.z(paramAbsBaseArticleInfo);
    }
    if ((paramInt != 10) && (paramInt != 12) && (paramInt != 94) && (paramInt != 95))
    {
      if (RIJBiuCardUtil.a(paramAbsBaseArticleInfo)) {
        localProteusItemDataBuilder.a("RIJ_biu_small_single_img_cell");
      } else {
        localProteusItemDataBuilder.a("RIJ_biu_cell");
      }
    }
    else {
      localProteusItemDataBuilder.a("ReadInjoy_biu_small_pgc_cell");
    }
    return localProteusItemDataBuilder.a();
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    ReadInJoyMiddleBodyView localReadInJoyMiddleBodyView = (ReadInJoyMiddleBodyView)localViewBase.findViewBaseByName("id_middle_body_content");
    if (localReadInJoyMiddleBodyView != null)
    {
      NativeMiddleBodyView localNativeMiddleBodyView = (NativeMiddleBodyView)localReadInJoyMiddleBodyView.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        View localView = a(paramInt1, paramContainer.getContext(), paramIReadInJoyModel);
        if ((localView instanceof PgcSmallView))
        {
          QLog.d("BiuPgcProteusItem", 2, "bindView | setTitleCustomStyle");
          ((PgcSmallView)localView).setTitleCustomStyle(localReadInJoyMiddleBodyView.a(), localReadInJoyMiddleBodyView.b(), localReadInJoyMiddleBodyView.d(), localReadInJoyMiddleBodyView.c());
        }
        if ((localView != null) && ((localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        } else {
          localObject = new RelativeLayout.LayoutParams(-2, -2);
        }
        localReadInJoyMiddleBodyView.a((RelativeLayout.LayoutParams)localObject);
        if (localView != null) {
          localNativeMiddleBodyView.a(localView, (RelativeLayout.LayoutParams)localObject);
        }
      }
      a(paramInt1, paramIReadInJoyModel, localNativeMiddleBodyView, paramInt2, paramContainer);
    }
    BindViewHelper.f(localViewBase, paramIReadInJoyModel);
    Object localObject = (BiuCommentView)localViewBase.findViewBaseByName("id_biu_comment");
    if (localObject != null) {
      ((BiuCommentView)localObject).a(paramIReadInJoyModel);
    }
    localObject = (SummaryView)localViewBase.findViewBaseByName("id_summary");
    if (localObject != null)
    {
      ((SummaryView)localObject).a(paramIReadInJoyModel);
      if ((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) {
        ((SummaryView)localObject).setOnClickListener(new BiuPgcProteusItem.1(this, paramContainer, paramIReadInJoyModel, paramInt2));
      }
    }
    localObject = localViewBase.findViewBaseByName("id_social_bottom");
    if (((paramInt1 == 49) || (paramInt1 == 62) || (paramInt1 == 63)) && (localObject != null) && (((ViewBase)localObject).getNativeView() != null)) {
      ((ViewBase)localObject).getNativeView().setOnClickListener(new BiuPgcProteusItem.2(this, paramContainer, paramIReadInJoyModel, paramInt2));
    }
    BindViewHelper.a(localViewBase, paramIReadInJoyModel.a());
    a(localViewBase, paramIReadInJoyModel);
    Util.a(localViewBase, paramIReadInJoyModel);
    Util.b(localViewBase, paramIReadInJoyModel);
    BindViewHelper.b(localViewBase, paramIReadInJoyModel);
    BindViewHelper.c(localViewBase, paramIReadInJoyModel);
    BindViewHelper.d(localViewBase, paramIReadInJoyModel);
  }
  
  protected void a(int paramInt1, IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if (paramNativeMiddleBodyView.a() != null)
    {
      if (paramIReadInJoyModel.a() == null) {
        return;
      }
      ReadInJoyBaseAdapter localReadInJoyBaseAdapter = (ReadInJoyBaseAdapter)paramIReadInJoyModel.a();
      if ((paramInt1 != 27) && (paramInt1 != 28) && (paramInt1 != 33))
      {
        if (paramInt1 != 35) {
          if ((paramInt1 != 49) && (paramInt1 != 62) && (paramInt1 != 63)) {
            if ((paramInt1 == 94) || (paramInt1 == 95)) {
              break label217;
            }
          }
        }
        switch (paramInt1)
        {
        default: 
          switch (paramInt1)
          {
          default: 
            paramIReadInJoyModel = new StringBuilder();
            paramIReadInJoyModel.append("");
            paramIReadInJoyModel.append(paramInt1);
            throw new IllegalArgumentException(paramIReadInJoyModel.toString());
            b(paramInt1, paramIReadInJoyModel, paramNativeMiddleBodyView, paramInt2, paramContainer);
            return;
          case 114: 
            paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
            paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramIReadInJoyModel, paramInt1));
            paramNativeMiddleBodyView.setMIReadInJoyModel(paramIReadInJoyModel);
            paramNativeMiddleBodyView.setOnNoItemClickListener(new BiuPgcProteusItem.3(this, paramIReadInJoyModel));
            return;
          }
          break;
        }
      }
      label217:
      if ((paramNativeMiddleBodyView.a() instanceof AdapterView))
      {
        paramNativeMiddleBodyView = new StringBuilder();
        paramNativeMiddleBodyView.append(" adapterViewType ");
        paramNativeMiddleBodyView.append(paramInt1);
        paramNativeMiddleBodyView.append(" articleInfo : ");
        paramNativeMiddleBodyView.append(paramIReadInJoyModel.a());
        AIOUtils.a("BiuPgcProteusItem", "", new IllegalArgumentException(paramNativeMiddleBodyView.toString()));
        return;
      }
      paramNativeMiddleBodyView.a().setOnClickListener(new BiuPgcProteusItem.4(this, localReadInJoyBaseAdapter, paramIReadInJoyModel));
      ((ComponentView)paramNativeMiddleBodyView.a()).a(paramIReadInJoyModel);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.BiuPgcProteusItem
 * JD-Core Version:    0.7.0.1
 */