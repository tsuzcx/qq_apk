package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentPolymericPullAnimatorView;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentPolymericView;
import com.tencent.mobileqq.kandian.biz.pts.data.ProteusItemDataBuilder;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyMiddleBodyView;
import com.tencent.mobileqq.kandian.biz.pts.view.helper.BindViewHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeMiddleBodyView;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.RvPolymericContainer;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PackProteusItem
  implements ProteusItem
{
  private ProteusItemDataBuilder a(ProteusItemDataBuilder paramProteusItemDataBuilder, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = paramProteusItemDataBuilder;
    ProteusItemDataBuilder localProteusItemDataBuilder;
    if (paramAbsBaseArticleInfo != null)
    {
      localObject = paramProteusItemDataBuilder;
      if (paramAbsBaseArticleInfo.mGroupSubArticleList != null)
      {
        localObject = paramProteusItemDataBuilder;
        if (paramAbsBaseArticleInfo.mGroupSubArticleList.size() > 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mGroupSubArticleList: ");
          ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mGroupSubArticleList.size());
          QLog.d("PackProteusItem", 2, ((StringBuilder)localObject).toString());
          localObject = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.mGroupSubArticleList.get(0);
          int i = RIJItemViewTypeUtils.G((AbsBaseArticleInfo)localObject);
          localObject = a((AbsBaseArticleInfo)localObject, paramInt);
          try
          {
            paramProteusItemDataBuilder.a("jump_url", localObject);
          }
          catch (JSONException localJSONException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[buildProteusCollectionView], e = ");
            localStringBuilder.append(localJSONException);
            QLog.e("PackProteusItem", 1, localStringBuilder.toString());
          }
          if (i == 1) {
            return b(paramProteusItemDataBuilder, paramInt, paramAbsBaseArticleInfo);
          }
          localProteusItemDataBuilder = paramProteusItemDataBuilder;
          if (i == 2) {
            localProteusItemDataBuilder = c(paramProteusItemDataBuilder, paramInt, paramAbsBaseArticleInfo);
          }
        }
      }
    }
    return localProteusItemDataBuilder;
  }
  
  private String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    Object localObject3 = "";
    if (paramAbsBaseArticleInfo == null)
    {
      QLog.i("PackProteusItem", 1, "[getJumpUrl], articleInfo is null.");
      return "";
    }
    long l2 = 0L;
    Object localObject1;
    long l1;
    Object localObject2;
    if ((!RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.g(paramAbsBaseArticleInfo)) && (paramInt != 77) && (paramInt != 78))
    {
      if (!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo))
      {
        localObject1 = localObject3;
        l1 = l2;
        if (paramInt != 76) {}
      }
      else
      {
        localObject1 = localObject3;
        l1 = l2;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
        {
          localObject1 = localObject3;
          l1 = l2;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null)
          {
            l1 = paramAbsBaseArticleInfo.mSocialFeedInfo.s.e;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(ReadInJoyConstants.h);
            ((StringBuilder)localObject1).append(Base64Util.encodeToString(String.valueOf(l1).getBytes(), 2));
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
      }
    }
    else
    {
      localObject1 = localObject3;
      l1 = l2;
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeID))
      {
        try
        {
          l1 = Long.parseLong(paramAbsBaseArticleInfo.mSubscribeID);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[getJumpUrl], e = ");
          ((StringBuilder)localObject3).append(localNumberFormatException);
          QLog.i("PackProteusItem", 1, ((StringBuilder)localObject3).toString());
          l1 = l2;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(ReadInJoyConstants.l);
        ((StringBuilder)localObject2).append(Base64Util.encodeToString(String.valueOf(l1).getBytes(), 2));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    localObject3 = localObject2;
    l2 = l1;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeID))
      {
        try
        {
          l2 = Long.parseLong(paramAbsBaseArticleInfo.mSubscribeID);
          l1 = l2;
        }
        catch (NumberFormatException paramAbsBaseArticleInfo)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[getJumpUrl], e = ");
          ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo);
          QLog.i("PackProteusItem", 1, ((StringBuilder)localObject2).toString());
        }
        paramAbsBaseArticleInfo = new StringBuilder();
        paramAbsBaseArticleInfo.append(ReadInJoyConstants.l);
        paramAbsBaseArticleInfo.append(Base64Util.encodeToString(String.valueOf(l1).getBytes(), 2));
        localObject3 = paramAbsBaseArticleInfo.toString();
        l2 = l1;
      }
      else if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null))
      {
        l2 = paramAbsBaseArticleInfo.mSocialFeedInfo.s.e;
        paramAbsBaseArticleInfo = new StringBuilder();
        paramAbsBaseArticleInfo.append(ReadInJoyConstants.h);
        paramAbsBaseArticleInfo.append(Base64Util.encodeToString(String.valueOf(l2).getBytes(), 2));
        localObject3 = paramAbsBaseArticleInfo.toString();
      }
      else
      {
        localObject3 = localObject2;
        l2 = l1;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
        {
          localObject3 = localObject2;
          l2 = l1;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null)
          {
            l2 = paramAbsBaseArticleInfo.mSocialFeedInfo.c.a;
            paramAbsBaseArticleInfo = new StringBuilder();
            paramAbsBaseArticleInfo.append(ReadInJoyConstants.h);
            paramAbsBaseArticleInfo.append(Base64Util.encodeToString(String.valueOf(l2).getBytes(), 2));
            localObject3 = paramAbsBaseArticleInfo.toString();
          }
        }
      }
    }
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("[getJumpUlr], url = ");
    paramAbsBaseArticleInfo.append((String)localObject3);
    paramAbsBaseArticleInfo.append(", uin = ");
    paramAbsBaseArticleInfo.append(l2);
    QLog.i("PackProteusItem", 1, paramAbsBaseArticleInfo.toString());
    return localObject3;
  }
  
  private void a(ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramViewBase != null) && (paramIReadInJoyModel != null))
    {
      paramViewBase = (RvPolymericContainer)paramViewBase.findViewBaseByName("id_proteus_collection_view");
      if (paramViewBase == null)
      {
        QLog.i("PackProteusItem", 1, "[bindItemClickListener], proteus_collection_view is null.");
        return;
      }
      List localList = paramAbsBaseArticleInfo.mGroupSubArticleList;
      if ((localList != null) && (!localList.isEmpty()))
      {
        paramViewBase.a(new PackProteusItem.2(this, localList, paramAbsBaseArticleInfo, paramIReadInJoyModel));
        return;
      }
      QLog.i("PackProteusItem", 1, "[bindItemClickListener], dataList is empty");
      return;
    }
    QLog.i("PackProteusItem", 1, "[bindItemClickListener], articleInfo or parent is null.");
  }
  
  private void a(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
  {
    if ((paramViewBase != null) && (paramIReadInJoyModel != null))
    {
      if (paramIReadInJoyModel.k() == null) {
        return;
      }
      paramViewBase = paramViewBase.findViewBaseByName("id_topic_avator");
      if (paramViewBase != null)
      {
        if (paramViewBase.getNativeView() == null) {
          return;
        }
        paramViewBase = paramViewBase.getNativeView();
        Context localContext = paramViewBase.getContext();
        paramViewBase.setOnClickListener(new PackProteusItem.1(this, paramIReadInJoyModel.k(), localContext));
      }
    }
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel, Context paramContext, ComponentPolymericView paramComponentPolymericView)
  {
    if (paramIReadInJoyModel.m() == 56)
    {
      paramComponentPolymericView.setDividerWidth(AIOUtils.b(3.0F, paramContext.getResources()));
      paramComponentPolymericView.setPadding(DisplayUtil.a(paramContext, 6.0F), 0, DisplayUtil.a(paramContext, 6.0F), DisplayUtil.a(paramContext, 5.0F));
    }
    else
    {
      paramComponentPolymericView.setDividerWidth(AIOUtils.b(3.0F, paramContext.getResources()));
      if (RIJFeedsType.J(paramIReadInJoyModel.k())) {
        paramComponentPolymericView.setPadding(DisplayUtil.a(paramContext, 6.0F), 0, DisplayUtil.a(paramContext, 12.0F), DisplayUtil.a(paramContext, 2.0F));
      } else {
        paramComponentPolymericView.setPadding(DisplayUtil.a(paramContext, 6.0F), 0, DisplayUtil.a(paramContext, 12.0F), 0);
      }
    }
    paramComponentPolymericView.setClipToPadding(false);
    paramComponentPolymericView.setClipChildren(false);
  }
  
  private ProteusItemDataBuilder b(ProteusItemDataBuilder paramProteusItemDataBuilder, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Util.a(paramAbsBaseArticleInfo, paramInt, localJSONArray);
      paramProteusItemDataBuilder.a("datas", localJSONArray);
      return paramProteusItemDataBuilder;
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      QLog.e("PackProteusItem", 2, paramAbsBaseArticleInfo.getMessage());
    }
    return paramProteusItemDataBuilder;
  }
  
  private ProteusItemDataBuilder c(ProteusItemDataBuilder paramProteusItemDataBuilder, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Util.b(paramAbsBaseArticleInfo, paramInt, localJSONArray);
      paramProteusItemDataBuilder.a("datas", localJSONArray);
      return paramProteusItemDataBuilder;
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      QLog.e("PackProteusItem", 2, paramAbsBaseArticleInfo.getMessage());
    }
    return paramProteusItemDataBuilder;
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = new ProteusItemDataBuilder();
    if (paramAbsBaseArticleInfo == null)
    {
      QLog.e("PackProteusItem", 2, "newpolymeric getDataJson info = null");
      return null;
    }
    long l1 = 0L;
    if (paramInt == 79) {
      return ((ProteusItemDataBuilder)localObject).c(paramAbsBaseArticleInfo).j(paramAbsBaseArticleInfo).r(paramAbsBaseArticleInfo).z(paramAbsBaseArticleInfo).a("ReadInjoy_pack_topic_cell").a();
    }
    if ((!RIJFeedsType.L(paramAbsBaseArticleInfo)) && (!RIJFeedsType.M(paramAbsBaseArticleInfo)))
    {
      long l2;
      if (paramInt == 76)
      {
        l2 = l1;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
        {
          l2 = l1;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null) {
            l2 = paramAbsBaseArticleInfo.mSocialFeedInfo.s.e;
          }
        }
        paramAbsBaseArticleInfo = a((ProteusItemDataBuilder)localObject, paramInt, paramAbsBaseArticleInfo).b(paramAbsBaseArticleInfo).r(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, l2).g(paramAbsBaseArticleInfo).f(paramAbsBaseArticleInfo).i(paramAbsBaseArticleInfo).j(paramAbsBaseArticleInfo).k(paramAbsBaseArticleInfo).z(paramAbsBaseArticleInfo).a("ReadInjoy_pack_cell").a();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("result is ");
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo);
        QLog.d("PackProteusItem", 2, ((StringBuilder)localObject).toString());
        return paramAbsBaseArticleInfo;
      }
      if ((paramInt != 77) && (paramInt != 78))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("newpolymeric card wrong articleinfo and viewType articleinfo = ");
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo);
        QLog.e("PackProteusItem", 2, ((StringBuilder)localObject).toString());
        return null;
      }
      try
      {
        l2 = Long.parseLong(paramAbsBaseArticleInfo.mSubscribeID);
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("newpolymeric card pgc parse uin error uin = ");
        localStringBuilder.append(0L);
        localStringBuilder.append(" error = ");
        localStringBuilder.append(localNumberFormatException);
        QLog.e("PackProteusItem", 2, localStringBuilder.toString());
      }
      paramAbsBaseArticleInfo = a((ProteusItemDataBuilder)localObject, paramInt, paramAbsBaseArticleInfo).b(paramAbsBaseArticleInfo).r(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, l1).g(paramAbsBaseArticleInfo).d(paramAbsBaseArticleInfo).i(paramAbsBaseArticleInfo).j(paramAbsBaseArticleInfo).k(paramAbsBaseArticleInfo).z(paramAbsBaseArticleInfo).a("ReadInjoy_pack_cell").a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("result is ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo);
      QLog.d("PackProteusItem", 2, ((StringBuilder)localObject).toString());
      return paramAbsBaseArticleInfo;
    }
    return ((ProteusItemDataBuilder)localObject).r(paramAbsBaseArticleInfo).z(paramAbsBaseArticleInfo).a("ReadInjoy_pack_cell").a();
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject1 = (ReadInJoyMiddleBodyView)localViewBase.findViewBaseByName("id_middle_body_content");
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = (NativeMiddleBodyView)((ReadInJoyMiddleBodyView)localObject1).getNativeView();
      if (((NativeMiddleBodyView)localObject2).getContent() == null)
      {
        localObject3 = new ComponentPolymericPullAnimatorView(paramContainer.getContext(), paramIReadInJoyModel);
        if ((((View)localObject3).getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
          localObject1 = (RelativeLayout.LayoutParams)((View)localObject3).getLayoutParams();
        } else {
          localObject1 = new RelativeLayout.LayoutParams(-1, -2);
        }
        a(paramIReadInJoyModel, paramContainer.getContext(), ((ComponentPolymericPullAnimatorView)localObject3).getPolyMericView());
        ((NativeMiddleBodyView)localObject2).a((View)localObject3, (RelativeLayout.LayoutParams)localObject1);
      }
      a(paramIReadInJoyModel, (NativeMiddleBodyView)localObject2);
    }
    localObject1 = paramIReadInJoyModel.k();
    if (!RIJFeedsType.S((AbsBaseArticleInfo)localObject1))
    {
      BindViewHelper.f(localViewBase, paramIReadInJoyModel);
      BindViewHelper.a(localViewBase, paramIReadInJoyModel.k());
      if (paramInt1 == 76) {
        Util.a(localViewBase, paramIReadInJoyModel);
      }
    }
    else
    {
      a(localViewBase, paramIReadInJoyModel);
      localObject3 = (NativeText)localViewBase.findViewBaseByName("id_topic_recommend_biu_time");
      if ((localObject3 != null) && (((AbsBaseArticleInfo)localObject1).mTopicRecommendFeedsInfo != null) && (((AbsBaseArticleInfo)localObject1).mTopicRecommendFeedsInfo.g != null) && (((AbsBaseArticleInfo)localObject1).mTopicRecommendFeedsInfo.g.size() > 0))
      {
        localObject2 = (TopicRecommendFeedsInfo.TopicRecommendInfo)((AbsBaseArticleInfo)localObject1).mTopicRecommendFeedsInfo.g.get(0);
        ((NativeText)localObject3).setText(String.format(paramContainer.getContext().getString(2131915541), new Object[] { ReadInJoyHelper.d(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).e) }));
        if (QLog.isColorLevel())
        {
          paramContainer = new StringBuilder();
          paramContainer.append("PackProteusItem update articleInfo UI articleID = ");
          paramContainer.append(((AbsBaseArticleInfo)localObject1).mArticleID);
          paramContainer.append(", mRecommendSeq =");
          paramContainer.append(((AbsBaseArticleInfo)localObject1).mRecommendSeq);
          paramContainer.append("，followType=");
          paramContainer.append(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).g);
          QLog.d("PackProteusItem", 2, paramContainer.toString());
        }
      }
    }
    paramContainer = localViewBase.findViewBaseByName("id_proteus_collection_view");
    if ((paramContainer instanceof RvPolymericContainer)) {
      ((RvPolymericContainer)paramContainer).a(paramIReadInJoyModel);
    }
    a(localViewBase, (AbsBaseArticleInfo)localObject1, paramIReadInJoyModel);
  }
  
  protected void a(IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView)
  {
    if (paramNativeMiddleBodyView.getContent() != null)
    {
      if (paramIReadInJoyModel.u() == null) {
        return;
      }
      paramNativeMiddleBodyView = (ComponentPolymericPullAnimatorView)paramNativeMiddleBodyView.getContent();
      paramNativeMiddleBodyView.a();
      paramNativeMiddleBodyView.getPolyMericView().a(paramIReadInJoyModel);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PackProteusItem
 * JD-Core Version:    0.7.0.1
 */