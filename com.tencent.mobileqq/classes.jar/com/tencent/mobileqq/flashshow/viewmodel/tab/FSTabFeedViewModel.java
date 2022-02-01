package com.tencent.mobileqq.flashshow.viewmodel.tab;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.bean.FSMainTabInfo;
import com.tencent.mobileqq.flashshow.request.feed.FSTabFeedCall;
import com.tencent.mobileqq.flashshow.request.feed.FSTabFeedCall.GetFeedRspListener;
import com.tencent.mobileqq.flashshow.request.feed.FSTabFeedCall.Param;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;

public class FSTabFeedViewModel
  extends BaseViewModel
{
  private final FSMainTabInfo a;
  private final MutableLiveData<UIStateData<List<FSFeedData>>> b = new MutableLiveData();
  private final FSTabFeedCall c = new FSTabFeedCall();
  private final FSTabFeedCall.GetFeedRspListener d = new FSTabFeedViewModel.1(this);
  
  public FSTabFeedViewModel(FSMainTabInfo paramFSMainTabInfo)
  {
    this.a = paramFSMainTabInfo;
  }
  
  public String a()
  {
    return "FSTabFeedViewModel";
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.c.a(FSTabFeedCall.a().a(this.a).a(paramInt).a(paramBoolean).a(this.d));
  }
  
  public MutableLiveData<UIStateData<List<FSFeedData>>> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.tab.FSTabFeedViewModel
 * JD-Core Version:    0.7.0.1
 */