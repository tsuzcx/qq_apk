package com.tencent.mobileqq.kandian.biz.feeds.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.OnLastReadRefreshListener;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.CommentInfo;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class ReadInJoyFooterPresenter
  implements IReadInJoyPresenter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ReadInJoyView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  private OnLastReadRefreshListener jdField_a_of_type_ComTencentMobileqqKandianBizPtsOnLastReadRefreshListener;
  private IReadInJoyModel jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
  
  public ReadInJoyFooterPresenter(Context paramContext, OnLastReadRefreshListener paramOnLastReadRefreshListener, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsOnLastReadRefreshListener = paramOnLastReadRefreshListener;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
  }
  
  public static List<articlesummary.PackJumpInfo> a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((articlesummary.SpecialTopicInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).rpt_jumps.get());
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
    }
    if (localArrayList.isEmpty()) {
      QLog.w("ReadInJoyFooterPresenter", 1, "ReadInJoyFooter special topic link list empty");
    }
    return localArrayList;
  }
  
  private void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int i = 0;
    List localList;
    for (;;)
    {
      localList = null;
      if (i >= 4) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setOnClickListener(null);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.h.setOnClickListener(null);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          localList = b(paramAbsBaseArticleInfo);
        }
      }
      else {
        localList = a(paramAbsBaseArticleInfo);
      }
    }
    else {
      a(paramInt, paramAbsBaseArticleInfo, null);
    }
    if ((localList != null) && (localList.size() == 1)) {
      a(paramInt, paramAbsBaseArticleInfo, (articlesummary.PackJumpInfo)localList.get(0));
    }
    if ((localList != null) && (localList.size() > 1))
    {
      i = 0;
      int j = 1;
      while (i < localList.size())
      {
        if (((articlesummary.PackJumpInfo)localList.get(i)).enum_style.get() != 2) {
          j = 0;
        }
        i += 1;
      }
      if (j != 0)
      {
        a(paramInt, paramAbsBaseArticleInfo, (articlesummary.PackJumpInfo)localList.get(0));
        return;
      }
      a(paramInt, paramAbsBaseArticleInfo, localList);
    }
  }
  
  private void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, List<articlesummary.PackJumpInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.h.setOnClickListener(null);
    paramInt = 0;
    int i;
    while (paramInt < 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setVisibility(8);
      i = paramInt - 1;
      if ((i >= 0) && (i <= 1)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidViewView[i].setVisibility(8);
      }
      paramInt += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(8);
    paramAbsBaseArticleInfo = paramList.iterator();
    paramInt = 0;
    Object localObject1;
    while (paramAbsBaseArticleInfo.hasNext())
    {
      localObject1 = (articlesummary.PackJumpInfo)paramAbsBaseArticleInfo.next();
      if (((articlesummary.PackJumpInfo)localObject1).enum_style.get() == 2)
      {
        i = paramInt;
        if (paramInt == 0)
        {
          Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(((articlesummary.PackJumpInfo)localObject1).str_wording.get());
          localObject2 = ((articlesummary.PackJumpInfo)localObject1).str_url.get();
          localObject1 = ((articlesummary.PackJumpInfo)localObject1).str_wording.get();
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(new ReadInJoyFooterPresenter.6(this, (String)localObject1, (String)localObject2));
          i = 1;
        }
        paramAbsBaseArticleInfo.remove();
        paramInt = i;
      }
    }
    paramInt = 0;
    while (paramInt < Math.min(3, paramList.size()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setText(((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get());
      paramAbsBaseArticleInfo = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_url.get();
      localObject1 = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setOnClickListener(new ReadInJoyFooterPresenter.7(this, (String)localObject1, paramAbsBaseArticleInfo));
      i = paramInt - 1;
      if ((i >= 0) && (i <= 1)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidViewView[i].setVisibility(0);
      }
      paramInt += 1;
    }
  }
  
  private void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, articlesummary.PackJumpInfo paramPackJumpInfo)
  {
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(8);
      int j = i - 1;
      if ((j >= 0) && (j <= 1)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidViewView[j].setVisibility(8);
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(8);
    if (paramInt != 1)
    {
      if ((paramInt != 2) && (paramInt != 3)) {
        return;
      }
      paramAbsBaseArticleInfo = new ReadInJoyFooterPresenter.4(this, paramPackJumpInfo);
      if (paramPackJumpInfo.enum_style.get() == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
        localLayoutParams.addRule(11, 0);
        localLayoutParams.addRule(9, -1);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(paramPackJumpInfo.str_wording.get());
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(paramAbsBaseArticleInfo);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.h.setOnClickListener(paramAbsBaseArticleInfo);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setText(paramPackJumpInfo.str_wording.get());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setOnClickListener(paramAbsBaseArticleInfo);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.h.setOnClickListener(paramAbsBaseArticleInfo);
      return;
    }
    paramPackJumpInfo = new ReadInJoyFooterPresenter.5(this, paramAbsBaseArticleInfo);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
    localLayoutParams.addRule(11, 0);
    localLayoutParams.addRule(9, -1);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(paramAbsBaseArticleInfo.mChannelInfoDisplayName);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(paramPackJumpInfo);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.h.setOnClickListener(paramPackJumpInfo);
  }
  
  public static void a(int paramInt, String paramString) {}
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.h != null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.h;
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.b()) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.b();
      a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.b(), paramAbsBaseArticleInfo);
    }
  }
  
  public static List<articlesummary.PackJumpInfo> b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((articlesummary.FriendRecommendInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_jumps.get());
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
    }
    if (localArrayList.isEmpty()) {
      QLog.w("ReadInJoyFooterPresenter", 1, "ReadInJoyFooter friend recommend link list empty");
    }
    return localArrayList;
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.i != null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.i;
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.c()) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.c())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.c();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.c.setText(paramAbsBaseArticleInfo.mArticleFriendLikeText);
      if (paramAbsBaseArticleInfo.mCommentIconType != 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.c.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
      }
      paramAbsBaseArticleInfo = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841850);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.c.setCompoundDrawablesWithIntrinsicBounds(paramAbsBaseArticleInfo, null, null, null);
    }
  }
  
  private void c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.j != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.j;
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.d()) {
        i = 0;
      } else {
        i = 8;
      }
      ((View)localObject1).setVisibility(i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.d())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.d();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.j.setOnClickListener(null);
      localObject1 = (articlesummary.CommentInfo)paramAbsBaseArticleInfo.mCommentsObj.get(0);
      long l = ((articlesummary.CommentInfo)localObject1).uint64_uin.get();
      Object localObject2 = ((articlesummary.CommentInfo)localObject1).str_content.get();
      String str1 = ((articlesummary.CommentInfo)localObject1).str_jump_url.get();
      if (RIJQQAppInterfaceUtil.a()) {
        localObject1 = ContactUtils.d((QQAppInterface)ReadInJoyUtils.a(), String.valueOf(l));
      } else {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(l);
      }
      String str2 = RIJStringUtils.a((String)localObject1);
      if (str2 != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append(":  ");
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = new SpannableString(((StringBuilder)localObject1).toString());
        ((SpannableString)localObject1).setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167333)), 0, str2.length(), 33);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.d.setVisibility(0);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str2);
        localStringBuilder.append(":  ");
        ((TextView)localObject2).setText(localStringBuilder.toString());
      }
      else
      {
        localObject1 = new SpannableString((CharSequence)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.d.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.e.setText((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.e.setOnClickListener(new ReadInJoyFooterPresenter.1(this, str1, paramAbsBaseArticleInfo));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.d.setOnClickListener(new ReadInJoyFooterPresenter.2(this, l, paramAbsBaseArticleInfo));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.f())
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.k.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.k.setVisibility(8);
    }
  }
  
  private void d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.l != null)
    {
      paramAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.l;
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.e()) {
        i = 0;
      } else {
        i = 8;
      }
      paramAbsBaseArticleInfo.setVisibility(i);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.e())
    {
      paramAbsBaseArticleInfo = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.l.getLayoutParams();
      UtilsForComponent.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel, paramAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.l);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.l.setLayoutParams(paramAbsBaseArticleInfo);
    }
  }
  
  private void e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.m != null)
    {
      paramAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.m;
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.g()) {
        i = 0;
      } else {
        i = 8;
      }
      paramAbsBaseArticleInfo.setVisibility(i);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.g()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.m.setOnClickListener(new ReadInJoyFooterPresenter.3(this));
      ReadInJoyLogicEngineEventDispatcher.a().a(null);
    }
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView = paramReadInJoyView;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel = paramIReadInJoyModel;
    paramReadInJoyView = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a();
    if (paramReadInJoyView == null) {
      return;
    }
    a(paramReadInJoyView);
    b(paramReadInJoyView);
    c(paramReadInJoyView);
    d(paramReadInJoyView);
    e(paramReadInJoyView);
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, long paramLong, Bitmap paramBitmap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyFooterPresenter
 * JD-Core Version:    0.7.0.1
 */