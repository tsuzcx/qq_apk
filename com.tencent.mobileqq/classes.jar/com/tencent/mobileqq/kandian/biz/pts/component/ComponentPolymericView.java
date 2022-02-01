package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.view.widget.BezierSideBarView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnHorizontalSubArticleClick;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackQuestionAnswerExtraInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackTopicExtraInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ComponentPolymericView
  extends HorizontalListView
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, ComponentInheritView, HorizontalListView.OnScrollStateChangedListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private BezierSideBarView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBezierSideBarView;
  private CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  private ComponentPolymericView.ReadinjoyHorizontalAdapter jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView$ReadinjoyHorizontalAdapter;
  private List<AbsBaseArticleInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private Boolean[] jdField_a_of_type_ArrayOfJavaLangBoolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c;
  private boolean d;
  
  public ComponentPolymericView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
  }
  
  private void a()
  {
    BezierSideBarView localBezierSideBarView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBezierSideBarView;
    if ((localBezierSideBarView != null) && (this.jdField_b_of_type_Boolean)) {
      localBezierSideBarView.a();
    }
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBezierSideBarView != null) && (this.jdField_b_of_type_Boolean))
    {
      int j = getMeasuredHeight() / 2;
      int i = j;
      if (!this.c)
      {
        i = j;
        if (!this.d) {
          i = j - AIOUtils.b(18.0F, getResources());
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBezierSideBarView.a(paramInt, i);
    }
  }
  
  public static boolean a(IReadInJoyModel paramIReadInJoyModel)
  {
    return RIJFeedsType.I(paramIReadInJoyModel.a());
  }
  
  public View a(Context paramContext)
  {
    return this;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    a(a(paramContext));
    this.jdField_a_of_type_Int = ((int)DisplayUtils.a(paramContext, 28.0F));
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("ComponentPolymericView init mJumpAccountPageThreshold = ");
      paramContext.append(this.jdField_a_of_type_Int);
      QLog.d("PolymericSmallVideo", 2, paramContext.toString());
    }
  }
  
  public void a(View paramView)
  {
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView$ReadinjoyHorizontalAdapter = new ComponentPolymericView.ReadinjoyHorizontalAdapter(this, null);
    setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView$ReadinjoyHorizontalAdapter);
    setDividerWidth(AIOUtils.b(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    setOnItemClickListener(this);
    setOnItemLongClickListener(this);
    setOnScrollStateChangedListener(this);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  public void a(Object paramObject)
  {
    Object localObject1 = (IReadInJoyModel)paramObject;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a((IReadInJoyModel)localObject1);
    paramObject = ((IReadInJoyModel)localObject1).a();
    this.jdField_b_of_type_Int = RIJBaseItemViewType.a(paramObject);
    this.jdField_b_of_type_Boolean = RIJFeedsType.I(paramObject);
    this.c = RIJFeedsType.D(paramObject);
    boolean bool;
    if ((!RIJFeedsType.F(paramObject)) && (!RIJFeedsType.G(paramObject))) {
      bool = false;
    } else {
      bool = true;
    }
    this.d = bool;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ComponentPolymericView bindData mIsNewPolymeric = ");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Boolean);
      QLog.d("PolymericSmallVideo", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = paramObject.mGroupSubArticleList;
    if ((localObject2 != null) && ((((List)localObject2).size() > 2) || (RIJFeedsType.I(((IReadInJoyModel)localObject1).a())))) {
      setOverScrollMode(0);
    } else {
      setOverScrollMode(2);
    }
    this.jdField_a_of_type_JavaUtilList = ((List)localObject2);
    localObject1 = this.jdField_a_of_type_JavaUtilList;
    if (localObject1 != null) {
      this.jdField_a_of_type_ArrayOfJavaLangBoolean = new Boolean[((List)localObject1).size()];
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView$ReadinjoyHorizontalAdapter.notifyDataSetChanged();
    resetCurrentX(paramObject.mCurrentX);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("articleID = ");
      ((StringBuilder)localObject1).append(paramObject.mArticleID);
      ((StringBuilder)localObject1).append("bindData resetCurrentX currentX = ");
      ((StringBuilder)localObject1).append(paramObject.mCurrentX);
      QLog.d("PolymericSmallVideo", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    Object localObject;
    if (j == 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ComponentPolymericView dispatchTouchEvent:ACTION_DOWN. mIsPress=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        QLog.d("PolymericSmallVideo", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f3;
      getParent().requestDisallowInterceptTouchEvent(true);
      this.jdField_a_of_type_Boolean = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    int i = 0;
    if (j == 2)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ComponentPolymericView dispatchTouchEvent:ACTION_MOVE. mIsPress=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        QLog.d("PolymericSmallVideo", 2, ((StringBuilder)localObject).toString());
      }
      float f2 = this.jdField_a_of_type_Float;
      f3 -= this.jdField_b_of_type_Float;
      if ((this.jdField_a_of_type_Boolean) && (Math.abs(f3) * 5.0F > Math.abs(f1 - f2) * 4.0F) && (Math.abs(f3) > DisplayUtil.a(getContext(), 5.0F))) {
        getParent().requestDisallowInterceptTouchEvent(false);
      } else {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      a(getScrollX() - this.jdField_a_of_type_Int);
    }
    else if ((j == 3) || (j == 1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ComponentPolymericView dispatchTouchEvent:ACTION_CANCEL or UP. action=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" mIsPress=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        QLog.d("PolymericSmallVideo", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_Boolean = false;
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBezierSideBarView;
      if (localObject != null) {
        i = ((BezierSideBarView)localObject).c();
      }
      if ((j == 1) && (this.jdField_b_of_type_Boolean) && (getScrollX() > this.jdField_a_of_type_Int + i))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView before jump to account page");
        }
        localObject = ComponentPolymericViewJumpUrlGenerator.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a().a());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("ComponentPolymericView jump to person page url =");
            localStringBuilder.append((String)localObject);
            QLog.d("PolymericSmallVideo", 2, localStringBuilder.toString());
          }
        }
      }
      a();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ((ReadInJoyBaseAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a()).a().a().a(localAbsBaseArticleInfo, paramView, paramInt, paramLong);
    boolean bool = RIJFeedsType.h(localAbsBaseArticleInfo);
    int j = 0;
    if (!bool) {
      paramAdapterView = RIJKanDianFolderStatus.getPolymericCommonR5Report(localAbsBaseArticleInfo.mPolymericInfo);
    }
    for (;;)
    {
      try
      {
        paramAdapterView.put("rowkey", localAbsBaseArticleInfo.innerUniqueID);
        switch (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentPolymericView$ReadinjoyHorizontalAdapter.getItemViewType(paramInt))
        {
        default: 
          paramAdapterView.put("content_type", i);
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      paramView = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localAbsBaseArticleInfo.mArticleID);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localAbsBaseArticleInfo.mStrategyId);
      localStringBuilder.append("");
      paramView.publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8008F56", "0X8008F56", 0, 0, (String)localObject1, (String)localObject2, localStringBuilder.toString(), paramAdapterView.toString(), false);
      if (this.d)
      {
        paramView = new JSONObject();
        try
        {
          localObject1 = (NewPolymericInfo.PackArticleInfo)localAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
          paramView.put("channel_id", this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c());
          if (((NewPolymericInfo.PackArticleInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackQuestionAnswerExtraInfo != null) {
            paramAdapterView = ((NewPolymericInfo.PackArticleInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackQuestionAnswerExtraInfo.a;
          } else {
            paramAdapterView = Integer.valueOf(0);
          }
          paramView.put("rowkey", paramAdapterView);
          paramInt = j;
          if (((NewPolymericInfo.PackArticleInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo != null) {
            paramInt = ((NewPolymericInfo.PackArticleInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo.jdField_b_of_type_Int;
          }
          paramView.put("topicid", paramInt);
        }
        catch (Exception paramAdapterView)
        {
          paramAdapterView.printStackTrace();
        }
        localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        paramAdapterView = new StringBuilder();
        paramAdapterView.append(localAbsBaseArticleInfo.mFeedId);
        paramAdapterView.append("");
        localObject2 = paramAdapterView.toString();
        if (RIJFeedsType.F(localAbsBaseArticleInfo)) {
          paramAdapterView = "1";
        } else {
          paramAdapterView = "2";
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localAbsBaseArticleInfo.mStrategyId);
        localStringBuilder.append("");
        ((IPublicAccountReportUtils)localObject1).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800982A", "0X800982A", 0, 0, (String)localObject2, paramAdapterView, localStringBuilder.toString(), paramView.toString(), false);
      }
      return;
      int i = 0;
      continue;
      i = 3;
      continue;
      i = 2;
      continue;
      i = 1;
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ComponentPolymericView scrollx");
      localStringBuilder.append(paramInt1);
      QLog.d("PolymericSmallVideo", 2, localStringBuilder.toString());
    }
    if (paramInt1 <= 2)
    {
      a();
      return;
    }
    a(paramInt1 - this.jdField_a_of_type_Int);
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a();
      if (localObject != null)
      {
        localObject = ((IReadInJoyModel)localObject).a();
        paramInt = getCurrentX();
        ((AbsBaseArticleInfo)localObject).mCurrentX = paramInt;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("articleID = ");
          localStringBuilder.append(((AbsBaseArticleInfo)localObject).mArticleID);
          localStringBuilder.append("onScrollStateChanged currentX = ");
          localStringBuilder.append(paramInt);
          QLog.d("PolymericSmallVideo", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void setSideBarView(BezierSideBarView paramBezierSideBarView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBezierSideBarView = paramBezierSideBarView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentPolymericView
 * JD-Core Version:    0.7.0.1
 */