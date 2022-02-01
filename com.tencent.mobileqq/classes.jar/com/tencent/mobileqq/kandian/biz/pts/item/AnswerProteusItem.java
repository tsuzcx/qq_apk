package com.tencent.mobileqq.kandian.biz.pts.item;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButtonImp;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.view.widget.SquareCornerTextImageView.PicInfo;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage.Model;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage.Model.Builder;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUgcImage;
import com.tencent.mobileqq.kandian.biz.pts.data.ProteusItemDataBuilder;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.biz.pts.view.ArticleCommentView;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyMiddleBodyView;
import com.tencent.mobileqq.kandian.biz.pts.view.helper.BindViewHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeCommentView;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeMiddleBodyView;
import com.tencent.mobileqq.kandian.repo.account.ArticleInfoHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class AnswerProteusItem
  implements ProteusItem
{
  public static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList != null)) {
      return paramAbsBaseArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public static ComponentContentGridImage.Model a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (paramInt == 0) {
      return new ComponentContentGridImage.Model.Builder().a();
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    UGCPicInfo localUGCPicInfo;
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList.size() >= 1))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (paramAbsBaseArticleInfo.hasNext()) {
        localUGCPicInfo = (UGCPicInfo)paramAbsBaseArticleInfo.next();
      }
    }
    for (;;)
    {
      try
      {
        if (localArrayList1.size() == paramInt) {
          break label263;
        }
        int i = localUGCPicInfo.a;
        int j = localUGCPicInfo.jdField_b_of_type_Int;
        localObject = new URL(localUGCPicInfo.jdField_c_of_type_JavaLangString);
        if (localUGCPicInfo.jdField_c_of_type_Int != 1) {
          break label284;
        }
        bool = true;
        localArrayList1.add(new SquareCornerTextImageView.PicInfo(i, j, (URL)localObject, bool));
        localArrayList2.add(new URL(localUGCPicInfo.jdField_b_of_type_JavaLangString));
      }
      catch (MalformedURLException localMalformedURLException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Malformed URL: ");
      ((StringBuilder)localObject).append(localMalformedURLException.getMessage());
      QLog.d("AnswerProteusItem", 2, ((StringBuilder)localObject).toString());
      break;
      label263:
      return new ComponentContentGridImage.Model.Builder().a(localArrayList1).b(localArrayList2).a();
      label284:
      boolean bool = false;
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, JSONObject paramJSONObject)
  {
    int i = paramAbsBaseArticleInfo.mSocialFeedInfo.j;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    if (!bool)
    {
      paramAbsBaseArticleInfo = new JSONObject();
      paramAbsBaseArticleInfo.put("read_article", paramString);
      paramJSONObject.put("id_read_article", paramAbsBaseArticleInfo);
      paramJSONObject.put("id_read_article_wrapper", new JSONObject());
      return;
    }
    if (QLog.isColorLevel())
    {
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("bindReadArticle isDeleted +");
      paramAbsBaseArticleInfo.append(bool);
      QLog.i("AnswerProteusItem", 2, paramAbsBaseArticleInfo.toString());
    }
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    long l;
    if (paramAbsBaseArticleInfo.mSocialFeedInfo.a != null) {
      l = paramAbsBaseArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Long;
    } else {
      l = 0L;
    }
    JSONObject localJSONObject = new ProteusItemDataBuilder().a(paramAbsBaseArticleInfo).b(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, l).f(paramAbsBaseArticleInfo).g(paramAbsBaseArticleInfo).i(paramAbsBaseArticleInfo).j(paramAbsBaseArticleInfo).k(paramAbsBaseArticleInfo).p(paramAbsBaseArticleInfo).r(paramAbsBaseArticleInfo).v(paramAbsBaseArticleInfo).w(paramAbsBaseArticleInfo).x(paramAbsBaseArticleInfo).A(paramAbsBaseArticleInfo).B(paramAbsBaseArticleInfo).D(paramAbsBaseArticleInfo).C(paramAbsBaseArticleInfo).a("ReadInjoy_original_cell").E(paramAbsBaseArticleInfo).I(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, HardCodeUtil.a(2131700493)).a();
    if (!ArticleInfoHelper.a(paramAbsBaseArticleInfo)) {
      a(paramAbsBaseArticleInfo, HardCodeUtil.a(2131700492), localJSONObject);
    }
    return localJSONObject;
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject1 = (ReadInJoyMiddleBodyView)localViewBase.findViewBaseByName("id_middle_body_content");
    AnswerProteusItem.1 local1 = new AnswerProteusItem.1(this, paramIReadInJoyModel, paramContainer);
    if (localObject1 != null)
    {
      Object localObject2 = (NativeMiddleBodyView)((ReadInJoyMiddleBodyView)localObject1).getNativeView();
      Object localObject3;
      if ((localObject2 != null) && (((NativeMiddleBodyView)localObject2).a() == null))
      {
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        LinearLayout localLinearLayout = new LinearLayout(paramContainer.getContext());
        localLinearLayout.setOrientation(1);
        localLinearLayout.addView(new ComponentContentGridImage(paramContainer.getContext()));
        localLinearLayout.addView(new ComponentContentUgcImage(paramContainer.getContext()));
        ((ReadInJoyMiddleBodyView)localObject1).a((RelativeLayout.LayoutParams)localObject3);
        ((NativeMiddleBodyView)localObject2).a(localLinearLayout, (RelativeLayout.LayoutParams)localObject3);
      }
      if (localObject2 != null)
      {
        paramContainer = (ViewGroup)((NativeMiddleBodyView)localObject2).a();
        localObject2 = paramIReadInJoyModel.a();
        paramInt1 = a((AbsBaseArticleInfo)localObject2);
        localObject2 = a((AbsBaseArticleInfo)localObject2, paramInt1);
        if (paramInt1 == 0)
        {
          paramContainer.setVisibility(8);
        }
        else
        {
          paramContainer.setVisibility(0);
          localObject3 = (ComponentContentGridImage)paramContainer.getChildAt(0);
          paramContainer = (ComponentContentUgcImage)paramContainer.getChildAt(1);
          if (paramInt1 == 1)
          {
            ((ComponentContentGridImage)localObject3).setVisibility(8);
            paramContainer.setVisibility(0);
            paramContainer.a(paramIReadInJoyModel);
          }
          else
          {
            ((ComponentContentGridImage)localObject3).setVisibility(0);
            ((ComponentContentGridImage)localObject3).setMIReadInJoyModel(paramIReadInJoyModel);
            paramContainer.setVisibility(8);
            ((ComponentContentGridImage)localObject3).a(localObject2);
          }
          paramContainer.setPicClickListener(new AnswerProteusItem.2(this, paramIReadInJoyModel));
        }
        ((ReadInJoyMiddleBodyView)localObject1).setOnClickListener(local1);
      }
    }
    BindViewHelper.a(localViewBase, paramIReadInJoyModel.a());
    BindViewHelper.f(localViewBase, paramIReadInJoyModel);
    paramContainer = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((paramContainer != null) && (paramContainer.getNativeView() != null) && ((paramContainer.getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)paramContainer.getNativeView()).setTextColor(-1);
    }
    paramContainer = (ArticleCommentView)localViewBase.findViewBaseByName("id_article_comment");
    if (paramContainer != null)
    {
      localObject1 = (NativeCommentView)paramContainer.getNativeView();
      ((NativeCommentView)localObject1).b = true;
      paramContainer.a(paramIReadInJoyModel);
      ((NativeCommentView)localObject1).setShouldCallClick(true);
      paramContainer.setOnClickListener(local1);
    }
    Util.a(localViewBase, paramIReadInJoyModel);
    BindViewHelper.c(localViewBase, paramIReadInJoyModel);
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.AnswerProteusItem
 * JD-Core Version:    0.7.0.1
 */