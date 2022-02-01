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
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
  private ComponentPolymericView.ReadinjoyHorizontalAdapter a;
  private List<AbsBaseArticleInfo> b = new ArrayList();
  private Boolean[] c;
  private CmpCtxt d;
  private Context e;
  private float f;
  private float g;
  private boolean h;
  private boolean i = false;
  private int j;
  private int k;
  private BezierSideBarView l;
  private boolean m;
  private boolean n;
  
  public ComponentPolymericView(Context paramContext)
  {
    super(paramContext);
    this.e = paramContext;
    b(paramContext);
  }
  
  private void a()
  {
    BezierSideBarView localBezierSideBarView = this.l;
    if ((localBezierSideBarView != null) && (this.i)) {
      localBezierSideBarView.a();
    }
  }
  
  private void a(int paramInt)
  {
    if ((this.l != null) && (this.i))
    {
      int i2 = getMeasuredHeight() / 2;
      int i1 = i2;
      if (!this.m)
      {
        i1 = i2;
        if (!this.n) {
          i1 = i2 - AIOUtils.b(18.0F, getResources());
        }
      }
      this.l.a(paramInt, i1);
    }
  }
  
  public static boolean a(IReadInJoyModel paramIReadInJoyModel)
  {
    return RIJFeedsType.O(paramIReadInJoyModel.k());
  }
  
  public View a(Context paramContext)
  {
    return this;
  }
  
  public void a(View paramView)
  {
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setOverScrollMode(2);
    this.a = new ComponentPolymericView.ReadinjoyHorizontalAdapter(this, null);
    setAdapter(this.a);
    setDividerWidth(AIOUtils.b(3.0F, this.e.getResources()));
    setOnItemClickListener(this);
    setOnItemLongClickListener(this);
    setOnScrollStateChangedListener(this);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  public void a(Object paramObject)
  {
    Object localObject1 = (IReadInJoyModel)paramObject;
    this.d.a((IReadInJoyModel)localObject1);
    paramObject = ((IReadInJoyModel)localObject1).k();
    this.k = RIJBaseItemViewType.c(paramObject);
    this.i = RIJFeedsType.O(paramObject);
    this.m = RIJFeedsType.J(paramObject);
    boolean bool;
    if ((!RIJFeedsType.L(paramObject)) && (!RIJFeedsType.M(paramObject))) {
      bool = false;
    } else {
      bool = true;
    }
    this.n = bool;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ComponentPolymericView bindData mIsNewPolymeric = ");
      ((StringBuilder)localObject2).append(this.i);
      QLog.d("PolymericSmallVideo", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = paramObject.mGroupSubArticleList;
    if ((localObject2 != null) && ((((List)localObject2).size() > 2) || (RIJFeedsType.O(((IReadInJoyModel)localObject1).k())))) {
      setOverScrollMode(0);
    } else {
      setOverScrollMode(2);
    }
    this.b = ((List)localObject2);
    localObject1 = this.b;
    if (localObject1 != null) {
      this.c = new Boolean[((List)localObject1).size()];
    }
    this.a.notifyDataSetChanged();
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
  
  public void b(Context paramContext)
  {
    this.d = new CmpCtxt();
    a(a(paramContext));
    this.j = ((int)DisplayUtils.a(paramContext, 28.0F));
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("ComponentPolymericView init mJumpAccountPageThreshold = ");
      paramContext.append(this.j);
      QLog.d("PolymericSmallVideo", 2, paramContext.toString());
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    Object localObject;
    if (i2 == 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ComponentPolymericView dispatchTouchEvent:ACTION_DOWN. mIsPress=");
        ((StringBuilder)localObject).append(this.h);
        QLog.d("PolymericSmallVideo", 2, ((StringBuilder)localObject).toString());
      }
      this.f = f1;
      this.g = f3;
      getParent().requestDisallowInterceptTouchEvent(true);
      this.h = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    int i1 = 0;
    if (i2 == 2)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ComponentPolymericView dispatchTouchEvent:ACTION_MOVE. mIsPress=");
        ((StringBuilder)localObject).append(this.h);
        QLog.d("PolymericSmallVideo", 2, ((StringBuilder)localObject).toString());
      }
      float f2 = this.f;
      f3 -= this.g;
      if ((this.h) && (Math.abs(f3) * 5.0F > Math.abs(f1 - f2) * 4.0F) && (Math.abs(f3) > DisplayUtil.a(getContext(), 5.0F))) {
        getParent().requestDisallowInterceptTouchEvent(false);
      } else {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      a(getScrollX() - this.j);
    }
    else if ((i2 == 3) || (i2 == 1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ComponentPolymericView dispatchTouchEvent:ACTION_CANCEL or UP. action=");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append(" mIsPress=");
        ((StringBuilder)localObject).append(this.h);
        QLog.d("PolymericSmallVideo", 2, ((StringBuilder)localObject).toString());
      }
      this.h = false;
      localObject = this.l;
      if (localObject != null) {
        i1 = ((BezierSideBarView)localObject).getRadius();
      }
      if ((i2 == 1) && (this.i) && (getScrollX() > this.j + i1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PolymericSmallVideo", 2, "ComponentPolymericView before jump to account page");
        }
        localObject = ComponentPolymericViewJumpUrlGenerator.a(this.k, this.d.a().k());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          ReadInJoyUtils.a(this.e, (String)localObject);
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
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)this.b.get(paramInt);
    ((ReadInJoyBaseAdapter)this.d.a.u()).y().b().a(localAbsBaseArticleInfo, paramView, paramInt, paramLong);
    boolean bool = RIJFeedsType.l(localAbsBaseArticleInfo);
    int i2 = 0;
    if (!bool) {
      paramAdapterView = RIJKanDianFolderStatus.getPolymericCommonR5Report(localAbsBaseArticleInfo.mPolymericInfo);
    }
    for (;;)
    {
      try
      {
        paramAdapterView.put("rowkey", localAbsBaseArticleInfo.innerUniqueID);
        switch (this.a.getItemViewType(paramInt))
        {
        default: 
          paramAdapterView.put("content_type", i1);
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      paramView = new StringBuilder();
      paramView.append(paramInt);
      paramView.append("");
      paramView = paramView.toString();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localAbsBaseArticleInfo.mArticleID);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localAbsBaseArticleInfo.mStrategyId);
      localStringBuilder.append("");
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8008F56", "0X8008F56", 0, 0, paramView, (String)localObject, localStringBuilder.toString(), paramAdapterView.toString(), false);
      if (this.n)
      {
        paramView = new JSONObject();
        try
        {
          localObject = (NewPolymericInfo.PackArticleInfo)localAbsBaseArticleInfo.mNewPolymericInfo.p.get(0);
          paramView.put("channel_id", this.d.a.m());
          if (((NewPolymericInfo.PackArticleInfo)localObject).q != null) {
            paramAdapterView = ((NewPolymericInfo.PackArticleInfo)localObject).q.a;
          } else {
            paramAdapterView = Integer.valueOf(0);
          }
          paramView.put("rowkey", paramAdapterView);
          paramInt = i2;
          if (((NewPolymericInfo.PackArticleInfo)localObject).p != null) {
            paramInt = ((NewPolymericInfo.PackArticleInfo)localObject).p.d;
          }
          paramView.put("topicid", paramInt);
        }
        catch (Exception paramAdapterView)
        {
          paramAdapterView.printStackTrace();
        }
        paramAdapterView = new StringBuilder();
        paramAdapterView.append(localAbsBaseArticleInfo.mFeedId);
        paramAdapterView.append("");
        localObject = paramAdapterView.toString();
        if (RIJFeedsType.L(localAbsBaseArticleInfo)) {
          paramAdapterView = "1";
        } else {
          paramAdapterView = "2";
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localAbsBaseArticleInfo.mStrategyId);
        localStringBuilder.append("");
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800982A", "0X800982A", 0, 0, (String)localObject, paramAdapterView, localStringBuilder.toString(), paramView.toString(), false);
      }
      return;
      int i1 = 0;
      continue;
      i1 = 3;
      continue;
      i1 = 2;
      continue;
      i1 = 1;
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
    a(paramInt1 - this.j);
  }
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097)
    {
      Object localObject = this.d.a();
      if (localObject != null)
      {
        localObject = ((IReadInJoyModel)localObject).k();
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
    this.l = paramBezierSideBarView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentPolymericView
 * JD-Core Version:    0.7.0.1
 */