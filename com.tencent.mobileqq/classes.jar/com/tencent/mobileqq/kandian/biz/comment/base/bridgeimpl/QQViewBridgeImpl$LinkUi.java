package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.kandian.biz.comment.base.model.CommentArgumentModel;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentLinkData;
import com.tencent.mobileqq.kandian.biz.comment.event.AddCommentLinkEvent;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.tkd.comment.publisher.qq.model.TkdCommentLinkData;
import com.tencent.tkd.comment.publisher.qq.util.QQViewCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class QQViewBridgeImpl$LinkUi
  implements SimpleEventReceiver<AddCommentLinkEvent>
{
  private List<BaseCommentData.CommentLinkData> b;
  
  private QQViewBridgeImpl$LinkUi(QQViewBridgeImpl paramQQViewBridgeImpl) {}
  
  private void a(Context paramContext)
  {
    SimpleEventBus.getInstance().registerReceiver(this);
    Bundle localBundle = new Bundle();
    int j = QQViewBridgeImpl.b(this.a).b;
    Object localObject = this.b;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((List)localObject).size();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://viola.qq.com/js/commLinkSelector.js?_rij_violaUrl=1&v_tid=6&v_bundleName=commLinkSelector&hideNav=1&v_nav_immer=1&v_bid=3740&remainLinkCount=");
    ((StringBuilder)localObject).append(j - i);
    RIJJumpUtils.a(paramContext, ((StringBuilder)localObject).toString(), localBundle);
  }
  
  private void a(BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    if (paramCommentLinkData == null) {
      return;
    }
    if (this.b == null) {
      this.b = new ArrayList(QQViewBridgeImpl.b(this.a).b);
    }
    this.b.add(paramCommentLinkData);
    TkdCommentLinkData localTkdCommentLinkData = new TkdCommentLinkData();
    localTkdCommentLinkData.type = paramCommentLinkData.type;
    localTkdCommentLinkData.iconUrl = paramCommentLinkData.iconUrl;
    localTkdCommentLinkData.linkUrl = paramCommentLinkData.linkUrl;
    localTkdCommentLinkData.wording = paramCommentLinkData.wording;
    QQViewBridgeImpl.a(this.a).onAddLink(localTkdCommentLinkData);
  }
  
  void a()
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  void b()
  {
    Object localObject = QQViewBridgeImpl.a(this.a).getCommentLinkData();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.b.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TkdCommentLinkData localTkdCommentLinkData = (TkdCommentLinkData)((Iterator)localObject).next();
        BaseCommentData.CommentLinkData localCommentLinkData = new BaseCommentData.CommentLinkData();
        localCommentLinkData.wording = localTkdCommentLinkData.wording;
        localCommentLinkData.iconUrl = localTkdCommentLinkData.iconUrl;
        localCommentLinkData.linkUrl = localTkdCommentLinkData.linkUrl;
        localCommentLinkData.type = localTkdCommentLinkData.type;
        this.b.add(localCommentLinkData);
      }
      return;
    }
    this.b = null;
  }
  
  public ArrayList<Class<AddCommentLinkEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AddCommentLinkEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AddCommentLinkEvent)) {
      a(((AddCommentLinkEvent)paramSimpleBaseEvent).linkData);
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQViewBridgeImpl.LinkUi
 * JD-Core Version:    0.7.0.1
 */