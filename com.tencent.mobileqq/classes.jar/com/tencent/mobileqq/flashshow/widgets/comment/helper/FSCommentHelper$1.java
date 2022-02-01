package com.tencent.mobileqq.flashshow.widgets.comment.helper;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.mobileqq.flashshow.model.comment.FSCommentManager;
import com.tencent.mobileqq.flashshow.model.comment.IFSCommentManager;
import com.tencent.mobileqq.flashshow.model.comment.bean.FSAddCommentReplyBean;
import com.tencent.mobileqq.flashshow.model.comment.bean.FSAddFeedCommentBean;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002.DataBuilder;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.flashshow.utils.FSToastUtil;
import com.tencent.mobileqq.flashshow.widgets.comment.FSBaseInputPopupWindow.EventListener;
import com.tencent.mobileqq.flashshow.widgets.comment.FSCommentInputPopupWindow;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.event.QCircleFuelAnimationEvent;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.lang.ref.WeakReference;

class FSCommentHelper$1
  implements FSBaseInputPopupWindow.EventListener
{
  FSCommentHelper$1(FSCommentHelper paramFSCommentHelper, Activity paramActivity, FSCommentInputPopupWindow paramFSCommentInputPopupWindow, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, boolean paramBoolean1, FSReportBean paramFSReportBean, int paramInt, boolean paramBoolean2) {}
  
  public void a()
  {
    QLog.d("FSC-FSCommentHelper", 1, "onClickSend()");
    if (this.a.isFinishing())
    {
      QLog.d("FSC-FSCommentHelper", 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    Object localObject2 = this.b.g();
    if (TextUtils.isEmpty(((String)localObject2).trim()))
    {
      FSToastUtil.a(this.a.getString(2131889527), 0);
      return;
    }
    if (!HostNetworkUtils.isNetworkAvailable())
    {
      FSToastUtil.a(FSToastUtil.c, this.a.getString(2131892113), 0);
      return;
    }
    if (this.c == null)
    {
      QLog.e("FSC-FSCommentHelper", 1, "feed is null");
      return;
    }
    Object localObject1;
    if (FSCommentHelper.a(this.j) != null) {
      localObject1 = (FSCommentHelper.CommentInputListener)FSCommentHelper.a(this.j).get();
    } else {
      localObject1 = null;
    }
    Object localObject3;
    PBStringField localPBStringField;
    StringBuilder localStringBuilder;
    int k;
    if (this.d != null)
    {
      localObject3 = new FeedCloudMeta.StReply();
      localPBStringField = ((FeedCloudMeta.StReply)localObject3).id;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fakeId_");
      localStringBuilder.append(System.currentTimeMillis());
      localPBStringField.set(localStringBuilder.toString());
      ((FeedCloudMeta.StReply)localObject3).content.set((String)localObject2);
      ((FeedCloudMeta.StReply)localObject3).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((FeedCloudMeta.StReply)localObject3).postUser.set(FSCommonUtil.b());
      int m = 11;
      localObject2 = this.e;
      k = m;
      if (localObject2 != null)
      {
        k = m;
        if (!TextUtils.isEmpty(((FeedCloudMeta.StReply)localObject2).postUser.id.get()))
        {
          ((FeedCloudMeta.StReply)localObject3).targetUser.set(this.e.postUser.get());
          ((FeedCloudMeta.StReply)localObject3).targetReplyID.set(this.e.id.get());
          k = 12;
        }
      }
      if (localObject1 != null)
      {
        QLog.d("FSC-FSCommentHelper", 1, "addFakeReply commentInputListener callback success");
        ((FSCommentHelper.CommentInputListener)localObject1).a((FeedCloudMeta.StReply)localObject3);
      }
      else
      {
        QLog.e("FSC-FSCommentHelper", 1, "addFakeReply commentInputListener null");
      }
      localObject1 = FSAddCommentReplyBean.a();
      ((FSAddCommentReplyBean)localObject1).a(this.c);
      ((FSAddCommentReplyBean)localObject1).a(this.d);
      ((FSAddCommentReplyBean)localObject1).a((FeedCloudMeta.StReply)localObject3);
      ((FSAddCommentReplyBean)localObject1).a(this.a.hashCode());
      ((FSAddCommentReplyBean)localObject1).a(this.f);
      FSCommentManager.a().a((FSAddCommentReplyBean)localObject1);
      FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(this.c, this.g).a(k).b(3).a(FSCommentHelper.a(this.j, this.d)));
    }
    else
    {
      localObject3 = new FeedCloudMeta.StComment();
      localPBStringField = ((FeedCloudMeta.StComment)localObject3).id;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fakeId_");
      localStringBuilder.append(System.currentTimeMillis());
      localPBStringField.set(localStringBuilder.toString());
      ((FeedCloudMeta.StComment)localObject3).content.set((String)localObject2);
      ((FeedCloudMeta.StComment)localObject3).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((FeedCloudMeta.StComment)localObject3).postUser.set(FSCommonUtil.b());
      if (localObject1 != null)
      {
        QLog.d("FSC-FSCommentHelper", 1, "addFakeComment commentInputListener callback success");
        ((FSCommentHelper.CommentInputListener)localObject1).a((FeedCloudMeta.StComment)localObject3);
      }
      else
      {
        QLog.e("FSC-FSCommentHelper", 1, "addFakeComment commentInputListener null");
      }
      if (this.h == 103)
      {
        k = this.a.getIntent().getIntExtra("contextHashCode", 0);
        localObject1 = FSAddFeedCommentBean.a();
        ((FSAddFeedCommentBean)localObject1).a(this.c);
        ((FSAddFeedCommentBean)localObject1).a((FeedCloudMeta.StComment)localObject3);
        ((FSAddFeedCommentBean)localObject1).a(k);
        ((FSAddFeedCommentBean)localObject1).a(this.f);
        ((FSAddFeedCommentBean)localObject1).b(true);
        FSCommentManager.a().a((FSAddFeedCommentBean)localObject1);
      }
      else
      {
        k = this.a.hashCode();
        localObject1 = FSAddFeedCommentBean.a();
        ((FSAddFeedCommentBean)localObject1).a(this.c);
        ((FSAddFeedCommentBean)localObject1).a((FeedCloudMeta.StComment)localObject3);
        ((FSAddFeedCommentBean)localObject1).a(k);
        ((FSAddFeedCommentBean)localObject1).a(this.f);
        ((FSAddFeedCommentBean)localObject1).b(false);
        FSCommentManager.a().a((FSAddFeedCommentBean)localObject1);
      }
      if (this.i) {
        FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(this.c, this.g).a(60).b(3).a(FSCommentHelper.a(this.j, this.c)));
      } else {
        FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(this.c, this.g).a(135).b(3).a(FSCommentHelper.a(this.j, this.c)));
      }
    }
    this.b.a("");
    this.b.b(null);
    this.b.dismiss();
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFuelAnimationEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper.1
 * JD-Core Version:    0.7.0.1
 */