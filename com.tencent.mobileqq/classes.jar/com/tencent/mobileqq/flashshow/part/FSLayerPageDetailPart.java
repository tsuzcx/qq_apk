package com.tencent.mobileqq.flashshow.part;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.flashshow.adapter.FSLayerPageAdapter;
import com.tencent.mobileqq.flashshow.api.bean.FSInitBean;
import com.tencent.mobileqq.flashshow.api.bean.FSLayerPageInitBean;
import com.tencent.mobileqq.flashshow.events.FSFeedEvent;
import com.tencent.mobileqq.flashshow.ioc.IFSFeedIoc;
import com.tencent.mobileqq.flashshow.view.FSPageTurnContainer;
import com.tencent.mobileqq.flashshow.viewmodel.layer.FSLayerDetailViewModel;
import com.tencent.mobileqq.flashshow.viewmodel.layer.FSLayerDetailViewModel.FeedDetailCall;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class FSLayerPageDetailPart
  extends FSLayerBasePart
  implements IFSFeedIoc
{
  private FSLayerPageInitBean g;
  private FSLayerDetailViewModel h;
  
  public FSLayerPageDetailPart(FSLayerPageInitBean paramFSLayerPageInitBean)
  {
    this.g = paramFSLayerPageInitBean;
  }
  
  private void u()
  {
    this.h = new FSLayerDetailViewModel();
    this.h.b().observe(j(), new FSLayerPageDetailPart.1(this));
    this.h.a().observe(j(), new FSLayerPageDetailPart.2(this));
  }
  
  public String a()
  {
    return "FSLayerPageDetailPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    u();
    this.b.a(this);
    this.a.setRefreshEnable(false);
    this.a.setLoadMoreEnable(false);
    b(false);
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
    if (!paramBoolean)
    {
      QLog.d(a(), 1, "requestData  refresh");
      this.h.a(this.g).a();
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSLayerPageDetailPart
 * JD-Core Version:    0.7.0.1
 */