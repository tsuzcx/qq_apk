package com.tencent.mobileqq.kandian.biz.feeds.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyView;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderFriendRecommend;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.KandianNegativeWindow;
import com.tencent.widget.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class ReadInJoyHeaderPresenter
  implements View.OnClickListener, IReadInJoyPresenter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private ReadInJoyView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  private IReadInJoyModel jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
  private KandianNegativeWindow jdField_a_of_type_ComTencentWidgetKandianNegativeWindow;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  
  public ReadInJoyHeaderPresenter(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, ListView paramListView, KandianNegativeWindow paramKandianNegativeWindow)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    this.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow = paramKandianNegativeWindow;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
  }
  
  private String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    try
    {
      paramAbsBaseArticleInfo = ((articlesummary.SpecialTopicInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
      paramAbsBaseArticleInfo = null;
    }
    if (TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
      QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic title empty");
    }
    return paramAbsBaseArticleInfo;
  }
  
  private URL a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.mHeaderIconUrl == null)
    {
      try
      {
        String str = ((articlesummary.SpecialTopicInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_icon_url.get();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject = null;
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic icon url empty");
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return null;
      }
      Object localObject = RIJConvertString2URL.a((String)localObject);
      paramAbsBaseArticleInfo.mHeaderIconUrl = ((URL)localObject);
      return localObject;
    }
    return paramAbsBaseArticleInfo.mHeaderIconUrl;
  }
  
  private List<Long> a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((articlesummary.FriendRecommendInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
    }
    if (localArrayList.isEmpty()) {
      QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader friend recommend uin list empty");
    }
    return localArrayList;
  }
  
  private void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int k = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131380884);
      ReadInJoyView localReadInJoyView = (ReadInJoyView)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag(2131380889);
      if ((localIReadInJoyModel != null) && (localReadInJoyView != null) && (paramIReadInJoyModel.a().mGroupId == localIReadInJoyModel.a().mGroupId))
      {
        localArrayList1.add(localReadInJoyView);
        localArrayList2.add(localIReadInJoyModel);
      }
      i += 1;
    }
    paramReadInJoyView = new ReadInJoyHeaderPresenter.3(this, paramReadInJoyView, localArrayList2, paramArrayList, paramInt, paramObject);
    paramInt = j;
    while (paramInt < localArrayList1.size())
    {
      paramIReadInJoyModel = (Animation)((ReadInJoyView)localArrayList1.get(paramInt)).a().getTag(2131369613);
      if (paramInt != 0) {
        paramIReadInJoyModel.setAnimationListener(null);
      } else {
        paramIReadInJoyModel.setAnimationListener(paramReadInJoyView);
      }
      ((ReadInJoyView)localArrayList1.get(paramInt)).a().startAnimation(paramIReadInJoyModel);
      paramInt += 1;
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = RIJTransMergeKanDianReport.a();
      localJSONObject.put("feeds_source", paramString);
      localJSONObject.put("kandian_mode", RIJAppSetting.a());
      IReadInJoyModel localIReadInJoyModel = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
      String str = "0X800744D";
      paramString = str;
      if (localIReadInJoyModel != null)
      {
        paramString = str;
        if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.c())) {
          paramString = "0X8009357";
        }
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramBoolean)
    {
      localObject1 = a(paramAbsBaseArticleInfo);
      if ((localObject1 != null) && (((List)localObject1).size() == 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 1);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_AndroidWidgetTextView.setTypeface(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_AndroidWidgetTextView.getTypeface(), 0);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.c.setVisibility(0);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
    int k = 8;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    ((KandianUrlImageView)localObject1).setVisibility(i);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setOnClickListener(this);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView;
    int m = localObject1.length;
    int i = 0;
    while (i < m)
    {
      Object localObject2 = localObject1[i];
      int j;
      if (paramBoolean) {
        j = 0;
      } else {
        j = 8;
      }
      localObject2.setVisibility(j);
      i += 1;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_AndroidWidgetTextView;
    if ((paramBoolean) && (a(paramAbsBaseArticleInfo).size() != 1)) {
      i = 8;
    } else {
      i = 0;
    }
    ((TextView)localObject1).setVisibility(i);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_b_of_type_AndroidWidgetTextView;
    i = k;
    if (paramBoolean) {
      i = 0;
    }
    paramAbsBaseArticleInfo.setVisibility(i);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.d.setVisibility(0);
  }
  
  private String b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    try
    {
      paramAbsBaseArticleInfo = ((articlesummary.SpecialTopicInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_jump_url.get();
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
      paramAbsBaseArticleInfo = null;
    }
    if (TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
      QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic url empty");
    }
    return paramAbsBaseArticleInfo;
  }
  
  private String c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    try
    {
      paramAbsBaseArticleInfo = ((articlesummary.FriendRecommendInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).str_header_title.get();
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
      paramAbsBaseArticleInfo = null;
    }
    if (TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
      QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader friend recommend description empty");
    }
    return paramAbsBaseArticleInfo;
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel)
  {
    paramReadInJoyView = paramIReadInJoyModel.a();
    paramIReadInJoyModel = a(paramReadInJoyView);
    int i = 0;
    while (i < Math.min(4, paramIReadInJoyModel.size()))
    {
      if (RIJQQAppInterfaceUtil.a()) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageDrawable(SearchUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, String.valueOf(paramIReadInJoyModel.get(i)), 1));
      } else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageBitmap(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(((Long)paramIReadInJoyModel.get(i)).longValue()));
      }
      String str = String.valueOf(paramIReadInJoyModel.get(i));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setOnClickListener(new ReadInJoyHeaderPresenter.2(this, str, paramReadInJoyView));
      i += 1;
    }
    i = Math.min(4, paramIReadInJoyModel.size());
    while (i < 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setVisibility(8);
      i += 1;
    }
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView = paramReadInJoyView;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel = paramIReadInJoyModel;
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_b_of_type_AndroidViewView;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a()) {
        paramInt = 0;
      } else {
        paramInt = 8;
      }
      ((View)localObject).setVisibility(paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.a();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a() == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.f.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.g != null) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.g.setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderFriendRecommend.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderFriendRecommend.setLogic(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderFriendRecommend.a(paramIReadInJoyModel);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderFriendRecommend.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramInt = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a();
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          this.jdField_a_of_type_Boolean = true;
          a(true, localAbsBaseArticleInfo);
          a(paramReadInJoyView, paramIReadInJoyModel);
          localObject = a(localAbsBaseArticleInfo);
          if (((List)localObject).size() == 1)
          {
            if (RIJQQAppInterfaceUtil.a()) {
              localObject = ContactUtils.d((QQAppInterface)ReadInJoyUtils.a(), String.valueOf(((List)localObject).get(0)));
            } else {
              localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(((Long)((List)localObject).get(0)).longValue());
            }
            this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_AndroidWidgetTextView.setText(RIJStringUtils.a((String)localObject));
          }
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_b_of_type_AndroidWidgetTextView.setText(c(localAbsBaseArticleInfo));
        }
      }
      else
      {
        this.jdField_a_of_type_Boolean = false;
        a(false, localAbsBaseArticleInfo);
        localObject = a(localAbsBaseArticleInfo);
        if (localObject == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.c.setVisibility(8);
        }
        else
        {
          ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, (URL)localObject, this.jdField_a_of_type_AndroidContentContext);
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_AndroidWidgetTextView.setText(a(localAbsBaseArticleInfo));
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.d.setOnClickListener(new ReadInJoyHeaderPresenter.1(this, paramIReadInJoyModel, paramReadInJoyView));
    }
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, long paramLong, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a() == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderFriendRecommend.a(paramLong, paramBitmap);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a() != 2) {
        return;
      }
      if (RIJQQAppInterfaceUtil.a())
      {
        paramReadInJoyView = a(paramIReadInJoyModel.a());
        if ((paramReadInJoyView.size() > 0) && (paramReadInJoyView.contains(Long.valueOf(paramLong))))
        {
          int i = paramReadInJoyView.indexOf(Long.valueOf(paramLong));
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfComTencentWidgetFixSizeImageView[i].setImageBitmap(paramBitmap);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    StringBuilder localStringBuilder;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131376031: 
      if (!this.jdField_a_of_type_Boolean)
      {
        paramView = b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a());
        if (!TextUtils.isEmpty(paramView)) {
          ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, paramView);
        }
      }
      else
      {
        paramView = a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a());
        if (!paramView.isEmpty())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(ReadInJoyConstants.g);
          localStringBuilder.append(Base64Util.encodeToString(String.valueOf(paramView.get(0)).getBytes(), 2));
          paramView = localStringBuilder.toString();
          ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, paramView);
        }
      }
      break;
    case 2131363005: 
    case 2131376019: 
    case 2131376040: 
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a());
        if ((paramView != null) && (paramView.size() == 1))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(ReadInJoyConstants.g);
          localStringBuilder.append(Base64Util.encodeToString(String.valueOf(paramView.get(0)).getBytes(), 2));
          paramView = localStringBuilder.toString();
          ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, paramView);
        }
      }
      else
      {
        paramView = b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a());
        if (!TextUtils.isEmpty(paramView)) {
          ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, paramView);
        }
      }
      break;
    }
    a(RIJFeedsType.c(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyHeaderPresenter
 * JD-Core Version:    0.7.0.1
 */