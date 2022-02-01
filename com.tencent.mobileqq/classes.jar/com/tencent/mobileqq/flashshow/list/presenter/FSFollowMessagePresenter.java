package com.tencent.mobileqq.flashshow.list.presenter;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001;
import com.tencent.mobileqq.flashshow.widgets.common.FSAsyncTextView;
import com.tencent.mobileqq.flashshow.widgets.common.FSFollowView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;

public class FSFollowMessagePresenter
  extends FSBaseMessagePresenter
{
  private FSFollowView q;
  private FeedCloudMeta.StUser r;
  
  public FSFollowMessagePresenter(int paramInt)
  {
    super(paramInt);
  }
  
  private void a(int paramInt)
  {
    if (this.r == null) {
      return;
    }
    DataBuilder localDataBuilder = new DataBuilder(e()).setActionType(17);
    if (b(paramInt)) {
      paramInt = 5;
    } else {
      paramInt = 4;
    }
    FSLpReportDc11001.a(localDataBuilder.setSubActionType(paramInt).setThrActionType(0).setToUin(this.r.id.get()).setExt2(String.valueOf(this.l)));
  }
  
  private boolean b(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1)
    {
      if (paramInt == 3) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  void b(Context paramContext, View paramView)
  {
    this.q = ((FSFollowView)paramView.findViewById(2131433849));
    this.q.setReportListener(new FSFollowMessagePresenter.1(this));
  }
  
  void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    this.r = ((FeedCloudMeta.StUser)paramStNotice.operation.opUser.get());
    paramStNotice = this.r;
    if (paramStNotice != null) {
      this.q.setUserData(paramStNotice);
    }
  }
  
  void c()
  {
    if (this.j != null)
    {
      if (this.a != null) {
        this.a.setOnClickListener(this.j);
      }
      if (this.h != null) {
        this.h.setOnClickListener(this.j);
      }
    }
  }
  
  protected String f()
  {
    return "FSFollowMessagePresenter";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSFollowMessagePresenter
 * JD-Core Version:    0.7.0.1
 */