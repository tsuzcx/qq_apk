package com.tencent.mobileqq.flashshow.fragment.tab;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.flashshow.api.events.FSFrameEvent;
import com.tencent.mobileqq.flashshow.bean.FSMainTabInfo;
import com.tencent.mobileqq.flashshow.part.msg.FSTabMsgBubblePart;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class FSRcmdTabFragment
  extends FSBaseTabFragment
{
  protected FSTabMsgBubblePart e;
  
  public FSRcmdTabFragment(FSMainTabInfo paramFSMainTabInfo, int paramInt)
  {
    super(paramFSMainTabInfo, paramInt);
  }
  
  private void a(FSFrameEvent paramFSFrameEvent)
  {
    int i = paramFSFrameEvent.mRefreshTab;
    if ((i != 0) && (i != 1) && (i != 3))
    {
      if (i != 4) {
        return;
      }
      FSThreadUtils.a(new FSRcmdTabFragment.1(this), 300L);
      return;
    }
    k();
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FSRcmdTabFragment");
    localStringBuilder.append(this.b.a());
    return localStringBuilder.toString();
  }
  
  protected int c()
  {
    return 2131624794;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    this.e = new FSTabMsgBubblePart();
    localArrayList.add(this.e);
    localArrayList.addAll(super.d());
    return localArrayList;
  }
  
  public String e()
  {
    if ((this.b != null) && (this.b.a != null)) {
      return this.b.a.dtPgID.get();
    }
    return "";
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList2 = super.getEventClass();
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(FSFrameEvent.class);
    return localArrayList1;
  }
  
  public void onPause()
  {
    QLog.d(b(), 1, "fs_lifecycle onPause");
    super.onPause();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof FSFrameEvent)) {
      a((FSFrameEvent)paramSimpleBaseEvent);
    }
  }
  
  public void onResume()
  {
    QLog.d(b(), 1, "fs_lifecycle onResume");
    super.onResume();
    FSTabMsgBubblePart localFSTabMsgBubblePart = this.e;
    if (localFSTabMsgBubblePart != null) {
      localFSTabMsgBubblePart.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.tab.FSRcmdTabFragment
 * JD-Core Version:    0.7.0.1
 */