package com.tencent.mobileqq.flashshow.part;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.flashshow.adapter.FSLayerPageAdapter;
import com.tencent.mobileqq.flashshow.api.bean.FSInitBean;
import com.tencent.mobileqq.flashshow.api.bean.FSLayerPageInitBean;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.mobileqq.flashshow.events.FSFeedEvent;
import com.tencent.mobileqq.flashshow.ioc.IFSFeedIoc;
import com.tencent.mobileqq.flashshow.view.FSPageTurnContainer;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;

public class FSLayerPageListPart
  extends FSLayerBasePart
  implements IFSFeedIoc
{
  private FSLayerPageInitBean g;
  private IDataDisplaySurface<FSFeedData> h;
  private String i;
  private boolean j = true;
  
  public FSLayerPageListPart(FSLayerPageInitBean paramFSLayerPageInitBean)
  {
    this.g = paramFSLayerPageInitBean;
  }
  
  private void u()
  {
    Object localObject = this.g;
    if ((localObject != null) && (((FSLayerPageInitBean)localObject).getGlobalViewModelKey() != null))
    {
      this.h = FSDataCenter.a().c(this.g.getGlobalViewModelKey());
      if (this.g.getSourceType() == 1)
      {
        this.i = this.g.getPersonFeedType();
        localObject = a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initViewModel  personalFeedType = ");
        localStringBuilder.append(this.i);
        QLog.d((String)localObject, 1, localStringBuilder.toString());
      }
      localObject = this.h;
      if (localObject != null) {
        if (((IDataDisplaySurface)localObject).a(new Object[] { this.i }) != null)
        {
          this.h.a(new Object[] { this.i }).observe(j(), new FSLayerPageListPart.1(this));
          return;
        }
      }
      QLog.e(a(), 1, "initViewModel  mDataDisplaySurface or data == null");
      return;
    }
    QLog.e(a(), 1, "initViewModel  viewModelKey == null");
  }
  
  private void v()
  {
    if (!this.j) {
      return;
    }
    this.j = false;
    int k = w();
    if ((k >= 0) && (this.b.getDataList().size() > k))
    {
      this.a.getViewPager2().setCurrentItem(k, false);
      str = a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("firstEnterSelectPosition  position = ");
      localStringBuilder.append(k);
      QLog.i(str, 1, localStringBuilder.toString());
      return;
    }
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("firstEnterSelectPosition return, list.size = ");
    localStringBuilder.append(this.b.getDataList().size());
    localStringBuilder.append(" , position = ");
    localStringBuilder.append(k);
    QLog.i(str, 1, localStringBuilder.toString());
  }
  
  private int w()
  {
    if ((this.g != null) && (this.b.getDataList() != null) && (this.b.getDataList().size() != 0))
    {
      if (this.b.getDataList().size() <= this.g.getFeedPosition())
      {
        QLog.e(a(), 1, "checkFindRealPosition return unusual position = -1");
        return -1;
      }
      Object localObject1;
      Object localObject2;
      if (TextUtils.equals(this.g.getFeedId(), ((FSFeedData)this.b.getDataList().get(this.g.getFeedPosition())).b().id.get()))
      {
        localObject1 = a();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkFindRealPosition return mInitBean.getFeedPosition() = ");
        ((StringBuilder)localObject2).append(this.g.getFeedPosition());
        QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        return this.g.getFeedPosition();
      }
      int k = 0;
      while (k < this.b.getDataList().size())
      {
        localObject1 = (FSFeedData)this.b.getDataList().get(k);
        if (TextUtils.equals(((FSFeedData)localObject1).b().id.get(), this.g.getFeedId()))
        {
          localObject2 = a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkFindRealPosition return position = ");
          localStringBuilder.append(k);
          localStringBuilder.append(" , feedId = ");
          localStringBuilder.append(((FSFeedData)localObject1).b().id.get());
          QLog.i((String)localObject2, 1, localStringBuilder.toString());
          return k;
        }
        k += 1;
      }
      QLog.i(a(), 1, "checkFindRealPosition return default position = 0");
      return 0;
    }
    QLog.e(a(), 1, "checkFindRealPosition return unusual position = -1");
    return -1;
  }
  
  public String a()
  {
    return "FSLayerPageListPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a.setRefreshEnable(false);
    this.a.setLoadMoreEnable(true);
    this.b.a(this);
    u();
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    PartManager localPartManager = E();
    if (localPartManager == null)
    {
      QLog.d(a(), 1, "[onTabHandlerMessage] manager should not be null.");
      return;
    }
    if (TextUtils.equals(paramString, "event_open_comment"))
    {
      localPartManager.a("comment_panel_show", paramVarArgs[0]);
      return;
    }
    if (TextUtils.equals(paramString, "event_hide_comment"))
    {
      localPartManager.a("comment_panel_dismiss", null);
      return;
    }
    if (TextUtils.equals(paramString, "event_open_comment_input"))
    {
      localPartManager.a("comment_input_window_show", null);
      return;
    }
    if (TextUtils.equals(paramString, "event_open_share")) {
      localPartManager.a("share_action_show_share_sheet", paramVarArgs[0]);
    }
  }
  
  public int b()
  {
    return this.d;
  }
  
  protected void b(FSFeedEvent paramFSFeedEvent)
  {
    super.b(paramFSFeedEvent);
    if ((this.b == null) || (this.b.getDataList() == null) || (this.b.getDataList().isEmpty())) {
      c().onBackPressed();
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    IDataDisplaySurface localIDataDisplaySurface = this.h;
    if (localIDataDisplaySurface == null) {
      return;
    }
    localIDataDisplaySurface.b(new Object[] { this.i });
  }
  
  protected void c(UIStateData<List<FSFeedData>> paramUIStateData)
  {
    if (this.b == null) {
      return;
    }
    this.b.setDatas((ArrayList)paramUIStateData.e());
  }
  
  public int cr_()
  {
    return 0;
  }
  
  public FSInitBean d()
  {
    return this.g;
  }
  
  public int e()
  {
    return 0;
  }
  
  public int f()
  {
    return 0;
  }
  
  protected boolean n()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSLayerPageListPart
 * JD-Core Version:    0.7.0.1
 */