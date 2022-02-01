package com.tencent.mobileqq.flashshow.part;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter.LoadMoreViewHolder;
import com.tencent.biz.richframework.part.utils.RFWViewUtils;
import com.tencent.mobileqq.flashshow.api.bean.FSInitBean;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.mobileqq.flashshow.api.instance.FSFolderFragmentManager;
import com.tencent.mobileqq.flashshow.bean.FSCommentInfo;
import com.tencent.mobileqq.flashshow.bean.FSEvilReportInfo.Builder;
import com.tencent.mobileqq.flashshow.bean.FSEvilReportInfo.ContentIdBuilder;
import com.tencent.mobileqq.flashshow.bean.FSFeedCommentInfo;
import com.tencent.mobileqq.flashshow.config.FSConfig;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.mobileqq.flashshow.events.FSAddCommentEvent;
import com.tencent.mobileqq.flashshow.events.FSAddReplyCommentEvent;
import com.tencent.mobileqq.flashshow.events.FSAtUpdateEvent;
import com.tencent.mobileqq.flashshow.events.FSCloseBarrageEvent;
import com.tencent.mobileqq.flashshow.events.FSCommentPraiseUpdateEvent;
import com.tencent.mobileqq.flashshow.events.FSDeleteCommentEvent;
import com.tencent.mobileqq.flashshow.events.FSDeleteReplyCommentEvent;
import com.tencent.mobileqq.flashshow.events.FSGetCommentEvent;
import com.tencent.mobileqq.flashshow.events.FSOpenBarrageEvent;
import com.tencent.mobileqq.flashshow.events.FSOpenH5Event;
import com.tencent.mobileqq.flashshow.events.FSUpdateCommentTotalEvent;
import com.tencent.mobileqq.flashshow.fragment.FSBlockContainer;
import com.tencent.mobileqq.flashshow.helper.FSGlobalInfoHelper;
import com.tencent.mobileqq.flashshow.helper.FSPopupWindowHelper;
import com.tencent.mobileqq.flashshow.helper.FSPopupWindowHelper.MenuClickListener;
import com.tencent.mobileqq.flashshow.helper.FSPopupWindowHelper.MenuType;
import com.tencent.mobileqq.flashshow.model.comment.FSCommentManager;
import com.tencent.mobileqq.flashshow.model.comment.IFSCommentManager;
import com.tencent.mobileqq.flashshow.model.comment.bean.FSDeleteCommentReplyBean;
import com.tencent.mobileqq.flashshow.model.comment.bean.FSDeleteFeedCommentBean;
import com.tencent.mobileqq.flashshow.model.comment.bean.FSLoadCommentListBean;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002.DataBuilder;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.flashshow.utils.FSEvilReportUtils;
import com.tencent.mobileqq.flashshow.utils.FSHardCodeUtil;
import com.tencent.mobileqq.flashshow.utils.FSToastUtil;
import com.tencent.mobileqq.flashshow.widgets.comment.FSCommentItemView;
import com.tencent.mobileqq.flashshow.widgets.comment.FSPanelLoadingView;
import com.tencent.mobileqq.flashshow.widgets.comment.FSReplyItemView;
import com.tencent.mobileqq.flashshow.widgets.comment.FSSlidBottomView;
import com.tencent.mobileqq.flashshow.widgets.comment.OnCommentElementClickListener;
import com.tencent.mobileqq.flashshow.widgets.comment.adapter.FSCommentPanelBlock;
import com.tencent.mobileqq.flashshow.widgets.comment.dialog.SoftKeyboardStateHelper;
import com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper;
import com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper.CommentInputListener;
import com.tencent.mobileqq.flashshow.widgets.common.FSCustomDialog;
import com.tencent.mobileqq.flashshow.widgets.fault.FSCommentPanelHintView;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class FSCommentPanelPart
  extends FSBasePart
  implements View.OnClickListener, SimpleEventReceiver, OnCommentElementClickListener
{
  private RelativeLayout a;
  private FSSlidBottomView b;
  private FSBlockContainer c;
  private FSCommentPanelBlock d;
  private FSPanelLoadingView e;
  private FrameLayout f;
  private ImageView g;
  private FSCommentInfo h;
  private TextView i;
  private TextView j;
  private RelativeLayout k;
  private FSCommentPanelHintView l;
  private List<FeedCloudMeta.StComment> m;
  private FeedCloudMeta.StFeed n;
  private FeedCloudMeta.StComment o;
  private FeedCloudMeta.StReply p;
  private SoftKeyboardStateHelper q;
  private FSCommentHelper.CommentInputListener r;
  private ViewStub s;
  private ImageView t;
  
  private FeedCloudMeta.StFeed A()
  {
    FSCommentInfo localFSCommentInfo = this.h;
    if ((localFSCommentInfo != null) && (localFSCommentInfo.a != null)) {
      return this.h.a;
    }
    return new FeedCloudMeta.StFeed();
  }
  
  private void B()
  {
    Object localObject = b(A());
    localObject = FSCommentManager.a().b((String)localObject);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      a((List)localObject);
    } else {
      H();
    }
    b((List)localObject);
    I();
  }
  
  private void H()
  {
    FeedCloudMeta.StFeed localStFeed = A();
    if (localStFeed == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[showFeedDefCommentData] feed should not be null.");
      return;
    }
    this.m = localStFeed.vecComment.get();
    a(this.m);
  }
  
  private void I()
  {
    Object localObject = this.l;
    if (localObject == null) {
      return;
    }
    ((FSCommentPanelHintView)localObject).c();
    localObject = this.c;
    if (localObject != null) {
      ((FSBlockContainer)localObject).setVisibility(0);
    }
    localObject = this.d;
    if ((localObject != null) && (((FSCommentPanelBlock)localObject).getItemCount() == 0))
    {
      this.l.a(FSConfig.i());
      localObject = this.c;
      if (localObject != null) {
        ((FSBlockContainer)localObject).setVisibility(8);
      }
    }
  }
  
  private void J()
  {
    L();
    this.q = new SoftKeyboardStateHelper(this.a);
    this.q.a(new FSCommentPanelPart.KeyboardStateListenerImpl(this));
  }
  
  private void K()
  {
    QLog.d("FSC-FSCommentPanelPart", 1, "[handleSoftKeyboardClosed] handle soft keyboard close.");
    b(0);
    L();
    FSSlidBottomView localFSSlidBottomView = this.b;
    if ((localFSSlidBottomView != null) && (localFSSlidBottomView.getVisibility() != 0)) {
      a(this.a, 8);
    }
  }
  
  private void L()
  {
    SoftKeyboardStateHelper localSoftKeyboardStateHelper = this.q;
    if (localSoftKeyboardStateHelper == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[recyclerKeyBoardListener] key board helper should not be null.");
      return;
    }
    localSoftKeyboardStateHelper.a();
    this.q = null;
  }
  
  private QQCircleFeedBase.StBusiInfoCommentListData M()
  {
    FSInitBean localFSInitBean = N();
    if ((localFSInitBean != null) && (localFSInitBean.getBusiInfoData() != null))
    {
      QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
      try
      {
        localStBusiInfoCommentListData.mergeFrom(localFSInitBean.getBusiInfoData());
        localStBusiInfoCommentListData.setHasFlag(true);
        return localStBusiInfoCommentListData;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        return localStBusiInfoCommentListData;
      }
    }
    return null;
  }
  
  private FSInitBean N()
  {
    if ((g() != null) && (((Activity)g()).getIntent() != null) && (((Activity)g()).getIntent().hasExtra("fs_key_bundle_common_init_bean"))) {
      return (FSInitBean)((Activity)g()).getIntent().getSerializableExtra("fs_key_bundle_common_init_bean");
    }
    return null;
  }
  
  private int a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (this.c == null) {
        return -1;
      }
      int i2 = 0;
      int i1;
      for (int i3 = -1; i2 < this.c.getRecyclerView().getChildCount(); i3 = i1)
      {
        Object localObject1 = this.c.getRecyclerView().getChildAt(i2);
        if (!(localObject1 instanceof FSCommentItemView))
        {
          i1 = i3;
        }
        else
        {
          localObject1 = (FSCommentItemView)localObject1;
          i1 = i3;
          if (((FSCommentItemView)localObject1).getComment() != null) {
            if (!((FSCommentItemView)localObject1).getComment().id.get().equals(paramString1))
            {
              i1 = i3;
            }
            else
            {
              localObject1 = ((FSCommentItemView)localObject1).getRvReplyList();
              if (localObject1 == null) {
                return i3;
              }
              int i4 = ((RecyclerView)localObject1).getHeight();
              if (TextUtils.isEmpty(paramString2)) {
                return i4;
              }
              i3 = 0;
              for (;;)
              {
                i1 = i4;
                if (i3 >= ((RecyclerView)localObject1).getChildCount()) {
                  break;
                }
                Object localObject2 = ((RecyclerView)localObject1).getChildAt(i3);
                if ((localObject2 instanceof FSReplyItemView))
                {
                  localObject2 = (FSReplyItemView)localObject2;
                  if ((((FSReplyItemView)localObject2).getReply() != null) && (((FSReplyItemView)localObject2).getReply().id.get().equals(paramString2)))
                  {
                    i1 = i4 - ((FSReplyItemView)localObject2).getBottom();
                    break;
                  }
                }
                i3 += 1;
              }
            }
          }
        }
        i2 += 1;
      }
      return i3;
    }
    return -1;
  }
  
  private FSPopupWindowHelper.MenuClickListener a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    return new FSCommentPanelPart.1(this, paramStFeed, paramStComment);
  }
  
  private FSPopupWindowHelper.MenuClickListener a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    return new FSCommentPanelPart.2(this, paramStFeed, paramStComment, paramStReply);
  }
  
  private String a(FeedCloudMeta.StComment paramStComment)
  {
    if (paramStComment == null) {
      return null;
    }
    return paramStComment.id.get();
  }
  
  private String a(FeedCloudMeta.StReply paramStReply)
  {
    if (paramStReply == null) {
      return null;
    }
    return paramStReply.id.get();
  }
  
  private void a(int paramInt)
  {
    TextView localTextView = this.j;
    if (localTextView == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[updateCommentNum] comment count should not be null.");
      return;
    }
    if (paramInt > 0)
    {
      localTextView.setText(FSCommonUtil.a(paramInt));
      this.j.setVisibility(0);
      return;
    }
    localTextView.setText("");
    this.j.setVisibility(8);
  }
  
  private void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    if (paramStFeed != null)
    {
      if (paramStComment == null) {
        return;
      }
      if (paramInt == FSPopupWindowHelper.MenuType.c)
      {
        paramStFeed = (ClipboardManager)g().getSystemService("clipboard");
        if (paramStFeed != null)
        {
          paramStComment = ClipData.newPlainText("", paramStComment.content.get());
          ClipboardMonitor.setPrimaryClip(paramStFeed, paramStComment);
          paramStFeed.setPrimaryClip(paramStComment);
        }
      }
      else
      {
        if (paramInt == FSPopupWindowHelper.MenuType.e)
        {
          String str = g().getResources().getString(2131889507);
          FSCustomDialog.a(g(), str, null, 2131887648, 2131887629, new FSCommentPanelPart.3(this, paramStFeed, paramStComment), new FSCommentPanelPart.4(this)).show();
          return;
        }
        if (paramInt == FSPopupWindowHelper.MenuType.d)
        {
          SimpleEventBus.getInstance().dispatchEvent(new FSOpenH5Event(true));
          paramStFeed = new FSEvilReportInfo.ContentIdBuilder().b(A().id.get()).c(paramStComment.id.get()).a(A().poster.id.get()).d(String.valueOf(paramStComment.createTime.get())).a();
          FSEvilReportUtils.a(new FSEvilReportInfo.Builder().a("ks_comment").d(paramStFeed).c(paramStComment.postUser.id.get()).b("25089").a());
          FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(A(), l()).a(143).b(2).q(A().id.get()).r(paramStComment.id.get()).a(A().poster.id.get()));
        }
      }
    }
  }
  
  private void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if ((paramStFeed != null) && (paramStComment != null))
    {
      if (paramStReply == null) {
        return;
      }
      if (paramInt == FSPopupWindowHelper.MenuType.c)
      {
        paramStFeed = (ClipboardManager)g().getSystemService("clipboard");
        if (paramStFeed != null)
        {
          paramStComment = ClipData.newPlainText("", paramStComment.content.get());
          ClipboardMonitor.setPrimaryClip(paramStFeed, paramStComment);
          paramStFeed.setPrimaryClip(paramStComment);
        }
      }
      else
      {
        if (paramInt == FSPopupWindowHelper.MenuType.e)
        {
          String str = g().getResources().getString(2131889537);
          FSCustomDialog.a(g(), str, null, 2131887648, 2131887629, new FSCommentPanelPart.5(this, paramStFeed, paramStComment, paramStReply), new FSCommentPanelPart.6(this)).show();
          return;
        }
        if (paramInt == FSPopupWindowHelper.MenuType.d)
        {
          SimpleEventBus.getInstance().dispatchEvent(new FSOpenH5Event(true));
          paramStFeed = new FSEvilReportInfo.ContentIdBuilder().b(A().id.get()).c(paramStComment.id.get()).a(A().poster.id.get()).d(String.valueOf(paramStComment.createTime.get())).a();
          FSEvilReportUtils.a(new FSEvilReportInfo.Builder().a("ks_comment").d(paramStFeed).c(paramStComment.postUser.id.get()).b("25089").a());
          FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(A(), l()).a(143).b(2).q(A().id.get()).r(paramStComment.id.get()).a(A().poster.id.get()));
        }
      }
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[setPanelLoadingView] view should not be null.");
      return;
    }
    paramView.setVisibility(paramInt);
  }
  
  private void a(LoadInfo paramLoadInfo)
  {
    if (paramLoadInfo == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[onLoadData] load info not is null.");
      return;
    }
    QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[onLoadData] load info: ", paramLoadInfo.toString() });
    b(true);
  }
  
  private void a(@NonNull FSAddCommentEvent paramFSAddCommentEvent)
  {
    if ((!paramFSAddCommentEvent.isRequestSuccess) && (!TextUtils.isEmpty(paramFSAddCommentEvent.mErrMsg)))
    {
      QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[handleAddCommentEvent] handle error, msg: ", paramFSAddCommentEvent.mErrMsg });
      FSToastUtil.a(paramFSAddCommentEvent.mErrMsg, 0);
      return;
    }
    if (this.d == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[handleAddCommentEvent] block should not be null.");
      return;
    }
    FeedCloudMeta.StComment localStComment = paramFSAddCommentEvent.mComment;
    String str;
    if (paramFSAddCommentEvent.mFakeComment == null) {
      str = "";
    } else {
      str = paramFSAddCommentEvent.mFakeComment.id.get();
    }
    if (TextUtils.isEmpty(str))
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[handleAddCommentEvent] fake comment id should not be not.");
      return;
    }
    this.d.a(str, localStComment);
    a(paramFSAddCommentEvent.mFeed);
    paramFSAddCommentEvent = this.a;
    if ((paramFSAddCommentEvent != null) && (paramFSAddCommentEvent.getVisibility() != 0)) {
      FSToastUtil.a(FSToastUtil.d, FSHardCodeUtil.a(2131889504), 0);
    }
  }
  
  private void a(@NonNull FSAddReplyCommentEvent paramFSAddReplyCommentEvent)
  {
    if ((!paramFSAddReplyCommentEvent.isRequestSuccess) && (!TextUtils.isEmpty(paramFSAddReplyCommentEvent.mErrMsg)))
    {
      if (paramFSAddReplyCommentEvent.mComment == null) {
        localObject = null;
      } else {
        localObject = paramFSAddReplyCommentEvent.mComment.id.get();
      }
      QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[handleAddReplyCommentEvent] handle error, commentId: ", localObject, " | msg: ", paramFSAddReplyCommentEvent.mErrMsg });
      FSToastUtil.a(paramFSAddReplyCommentEvent.mErrMsg, 0);
      return;
    }
    if (this.d == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[handleAddReplyCommentEvent] block should not be null.");
      return;
    }
    Object localObject = paramFSAddReplyCommentEvent.mComment;
    FeedCloudMeta.StReply localStReply1 = paramFSAddReplyCommentEvent.mReply;
    FeedCloudMeta.StReply localStReply2 = paramFSAddReplyCommentEvent.mFakeReply;
    if ((localObject != null) && (localStReply1 != null) && (localStReply2 != null))
    {
      if (TextUtils.isEmpty(localStReply2.id.get()))
      {
        QLog.d("FSC-FSCommentPanelPart", 1, "[handleAddReplyCommentEvent] fake reply id should not be null.");
        return;
      }
      this.d.a(((FeedCloudMeta.StComment)localObject).id.get(), localStReply2.id.get(), localStReply1);
      a(paramFSAddReplyCommentEvent.mFeed);
      return;
    }
    QLog.d("FSC-FSCommentPanelPart", 1, "[handleAddReplyCommentEvent] param value should not be null.");
  }
  
  private void a(@NonNull FSCommentPraiseUpdateEvent paramFSCommentPraiseUpdateEvent)
  {
    String str1 = paramFSCommentPraiseUpdateEvent.mFeedId;
    String str2 = paramFSCommentPraiseUpdateEvent.mCommentId;
    String str3 = paramFSCommentPraiseUpdateEvent.mReplyId;
    int i1 = paramFSCommentPraiseUpdateEvent.mPraisedNum;
    int i2 = paramFSCommentPraiseUpdateEvent.mPraisedStatus;
    FSCommentManager.a().a(str1, str2, str3, i1, i2);
  }
  
  private void a(@NonNull FSDeleteCommentEvent paramFSDeleteCommentEvent)
  {
    if ((!paramFSDeleteCommentEvent.isRequestSuccess) && (!TextUtils.isEmpty(paramFSDeleteCommentEvent.mErrMsg)))
    {
      QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[handleDeleteCommentEvent] handle error, msg: ", paramFSDeleteCommentEvent.mErrMsg });
      FSToastUtil.a(paramFSDeleteCommentEvent.mErrMsg, 0);
      return;
    }
    if (paramFSDeleteCommentEvent.mComment == null) {
      localObject = null;
    } else {
      localObject = paramFSDeleteCommentEvent.mComment.id.get();
    }
    if (this.d == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[handleDeleteCommentEvent] block should not be null, comment id: ", localObject });
      return;
    }
    QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[handleDeleteCommentEvent] delete reply comment success, commentId: ", localObject });
    this.d.a((String)localObject);
    Object localObject = this.d.getDataList();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      I();
    }
    a(paramFSDeleteCommentEvent.mFeed);
  }
  
  private void a(@NonNull FSDeleteReplyCommentEvent paramFSDeleteReplyCommentEvent)
  {
    boolean bool = paramFSDeleteReplyCommentEvent.isRequestSuccess;
    String str2 = null;
    String str1 = null;
    if ((!bool) && (!TextUtils.isEmpty(paramFSDeleteReplyCommentEvent.mErrMsg)))
    {
      if (paramFSDeleteReplyCommentEvent.mComment != null) {
        str1 = paramFSDeleteReplyCommentEvent.mComment.id.get();
      }
      QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[handleDeleteReplyCommentEvent] handle error, commentId: ", str1, " | msg: ", paramFSDeleteReplyCommentEvent.mErrMsg });
      FSToastUtil.a(paramFSDeleteReplyCommentEvent.mErrMsg, 0);
      return;
    }
    if (this.d == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[handleDeleteReplyCommentEvent] block should not be null.");
      return;
    }
    if (paramFSDeleteReplyCommentEvent.mComment == null) {
      str1 = null;
    } else {
      str1 = paramFSDeleteReplyCommentEvent.mComment.id.get();
    }
    if (paramFSDeleteReplyCommentEvent.mReply != null) {
      str2 = paramFSDeleteReplyCommentEvent.mReply.id.get();
    }
    QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[handleDeleteReplyCommentEvent] delete reply comment success, commentId: ", str1, " | replyId: ", str2 });
    this.d.a(str1, str2);
    a(paramFSDeleteReplyCommentEvent.mFeed);
  }
  
  private void a(@NonNull FSGetCommentEvent paramFSGetCommentEvent)
  {
    if (this.d == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[handleGetCommentEvent] block should not be null.");
      return;
    }
    c(false);
    B();
    boolean bool = FSCommentManager.a().a(paramFSGetCommentEvent.getFeedId());
    this.d.notifyLoadingComplete(true, bool);
    e();
  }
  
  private void a(@NonNull FSUpdateCommentTotalEvent paramFSUpdateCommentTotalEvent)
  {
    String str = b(A());
    if ((TextUtils.isEmpty(paramFSUpdateCommentTotalEvent.mFeedId)) && (!TextUtils.equals(paramFSUpdateCommentTotalEvent.mFeedId, str))) {
      return;
    }
    a(paramFSUpdateCommentTotalEvent.mFeedId, paramFSUpdateCommentTotalEvent.mTotal);
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      paramStFeed = null;
    } else {
      paramStFeed = paramStFeed.id.get();
    }
    int i1 = FSCommentManager.a().c(paramStFeed);
    a(i1);
    a(paramStFeed, i1);
  }
  
  private void a(Object paramObject)
  {
    QLog.d("FSC-FSCommentPanelPart", 1, "[handleCommentCancelParise] current comment cancel praise click.");
  }
  
  private void a(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof Object[]))
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[handleCommentLessReplyClick] current args not is array.");
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    if (arrayOfObject.length < 2)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[handleCommentLessReplyClick] current args length < ", Integer.valueOf(2) });
      return;
    }
    if ((arrayOfObject[0] instanceof FeedCloudMeta.StComment)) {
      paramObject = (FeedCloudMeta.StComment)arrayOfObject[0];
    } else {
      paramObject = null;
    }
    int i1;
    if ((arrayOfObject[1] instanceof Integer)) {
      i1 = ((Integer)arrayOfObject[1]).intValue();
    } else {
      i1 = -1;
    }
    QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[handleCommentLessReplyClick] feedId: ", b(A()), " | commentId: ", a(paramObject) });
    this.d.b(paramInt, i1);
    this.c.getRecyclerView().scrollToPosition(paramInt);
  }
  
  private void a(String paramString, int paramInt)
  {
    MutableLiveData localMutableLiveData = FSDataCenter.a().a(FeedCloudMeta.StFeed.class, paramString);
    if (localMutableLiveData == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[notifyFeedCommentNumChange] live data should not be null.");
      return;
    }
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)localMutableLiveData.getValue();
    if (localStFeed == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[notifyFeedCommentNumChange] state data should not be null.");
      return;
    }
    QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[notifyFeedCommentNumChange] feed id: ", paramString, " | total num: ", Integer.valueOf(paramInt) });
    localStFeed.commentCount.set(paramInt);
    localMutableLiveData.postValue(localStFeed);
  }
  
  private void a(@NonNull List<FeedCloudMeta.StComment> paramList)
  {
    FSCommentPanelBlock localFSCommentPanelBlock = this.d;
    if (localFSCommentPanelBlock == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[showFeedCommentData] block should not be null.");
      return;
    }
    localFSCommentPanelBlock.a(A(), paramList);
  }
  
  private boolean a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, int paramInt, boolean paramBoolean)
  {
    FSFeedCommentInfo localFSFeedCommentInfo = new FSFeedCommentInfo(A(), paramStComment, paramStReply);
    this.r = new FSCommentPanelPart.9(this, paramStComment, paramStReply);
    localFSFeedCommentInfo.a(l());
    FSCommentHelper.a().a(c(), localFSFeedCommentInfo, this.r, false, paramBoolean);
    return true;
  }
  
  private boolean a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, boolean paramBoolean)
  {
    return a(paramStComment, paramStReply, 100, paramBoolean);
  }
  
  private String b(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return null;
    }
    return paramStFeed.id.get();
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (((FSBlockContainer)localObject).getRecyclerView().getChildCount() <= 0) {
        return;
      }
      localObject = this.c.getRecyclerView().getChildAt(this.c.getRecyclerView().getChildCount() - 1);
      if (localObject == null) {
        return;
      }
      if (!(this.c.getRecyclerView().findContainingViewHolder((View)localObject) instanceof PullLoadMoreAdapter.LoadMoreViewHolder)) {
        return;
      }
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), ((View)localObject).getPaddingTop(), ((View)localObject).getPaddingRight(), paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeMarginToFooterHolder  paddingTop: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("FSC-FSCommentPanelPart", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void b(View paramView, Object paramObject)
  {
    if (!(paramObject instanceof Object[]))
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[handleCommentReplyItemLongClick] current args not is array.");
      return;
    }
    Object localObject = (Object[])paramObject;
    if (localObject.length < 2)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[handleCommentReplyItemLongClick] current args length < ", Integer.valueOf(2) });
      return;
    }
    boolean bool = localObject[0] instanceof FeedCloudMeta.StComment;
    FeedCloudMeta.StReply localStReply = null;
    if (bool) {
      paramObject = (FeedCloudMeta.StComment)localObject[0];
    } else {
      paramObject = null;
    }
    if ((localObject[1] instanceof FeedCloudMeta.StReply)) {
      localStReply = (FeedCloudMeta.StReply)localObject[1];
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handleCommentReplyItemLongClick] feedId: ");
    ((StringBuilder)localObject).append(b(A()));
    ((StringBuilder)localObject).append(" commentId: ");
    ((StringBuilder)localObject).append(a(paramObject));
    QLog.d("FSC-FSCommentPanelPart", 1, ((StringBuilder)localObject).toString());
    paramObject = a(A(), paramObject, localStReply);
    FSPopupWindowHelper.a().a(paramView, A(), localStReply, paramObject, null);
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    if (!FSCommonUtil.a((FeedCloudMeta.StUser)paramStComment.postUser.get()))
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[requestDeleteCommentOperation] is not comment owner , refuse delete comment operation");
      return;
    }
    FSDeleteFeedCommentBean localFSDeleteFeedCommentBean = FSDeleteFeedCommentBean.a();
    localFSDeleteFeedCommentBean.a(paramStComment);
    localFSDeleteFeedCommentBean.a(paramStFeed);
    localFSDeleteFeedCommentBean.a(true);
    localFSDeleteFeedCommentBean.a(g().hashCode());
    FSCommentManager.a().a(localFSDeleteFeedCommentBean);
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (!FSCommonUtil.a((FeedCloudMeta.StUser)paramStReply.postUser.get()))
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[requestDeleteReplyOperation] is not reply owner , refuse delete reply operation");
      return;
    }
    FSDeleteCommentReplyBean localFSDeleteCommentReplyBean = FSDeleteCommentReplyBean.a();
    localFSDeleteCommentReplyBean.a(paramStComment);
    localFSDeleteCommentReplyBean.a(paramStReply);
    localFSDeleteCommentReplyBean.a(paramStFeed);
    localFSDeleteCommentReplyBean.a(true);
    localFSDeleteCommentReplyBean.a(g().hashCode());
    FSCommentManager.a().a(localFSDeleteCommentReplyBean);
  }
  
  private void b(Object paramObject)
  {
    QLog.d("FSC-FSCommentPanelPart", 1, "[handleCommentPraiseClick] current comment praise click.");
  }
  
  private void b(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof Object[]))
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[handleCommentMoreReply] current args not is array.");
      return;
    }
    Object localObject = (Object[])paramObject;
    if (localObject.length < 2)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[handleCommentReplyItemClick] current args length < ", Integer.valueOf(2) });
      return;
    }
    if ((localObject[0] instanceof FeedCloudMeta.StComment)) {
      paramObject = (FeedCloudMeta.StComment)localObject[0];
    } else {
      paramObject = null;
    }
    int i1;
    if ((localObject[1] instanceof Integer)) {
      i1 = ((Integer)localObject[1]).intValue();
    } else {
      i1 = -1;
    }
    if ((paramInt != -1) && (paramObject != null))
    {
      paramObject = (FeedCloudMeta.StComment)localObject[0];
      this.d.a(paramInt, i1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick more reply, feedId: ");
      ((StringBuilder)localObject).append(A().id.get());
      ((StringBuilder)localObject).append(" commentId: ");
      ((StringBuilder)localObject).append(paramObject.id.get());
      QLog.d("FSC-FSCommentPanelPart", 1, ((StringBuilder)localObject).toString());
      return;
    }
    QLog.d("FSC-FSCommentPanelPart", 1, "[handleCommentMoreReply] comment param illegality.");
  }
  
  private void b(List<FeedCloudMeta.StComment> paramList)
  {
    int i1;
    if (paramList == null) {
      i1 = 0;
    } else {
      i1 = paramList.size();
    }
    paramList = b(A());
    int i2 = FSCommentManager.a().c(paramList);
    paramList = new StringBuilder();
    paramList.append("[refreshPanelView] current comment size: ");
    paramList.append(i1);
    QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { paramList.toString(), " | total count: ", Integer.valueOf(i2) });
    a(i2);
  }
  
  private void b(boolean paramBoolean)
  {
    FSLoadCommentListBean localFSLoadCommentListBean = FSLoadCommentListBean.a();
    localFSLoadCommentListBean.a(paramBoolean);
    localFSLoadCommentListBean.a(A());
    if ((!paramBoolean) && (M() != null)) {
      localFSLoadCommentListBean.a(M());
    }
    FSCommentManager.a().a(localFSLoadCommentListBean);
    QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[requestCommentList] bean: ", localFSLoadCommentListBean.toString() });
  }
  
  private void c(int paramInt)
  {
    QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[handlerSoftKeyboardOpened] keyboard height:", Integer.valueOf(paramInt) });
  }
  
  private void c(View paramView, Object paramObject)
  {
    if (!(paramObject instanceof FeedCloudMeta.StComment))
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[handleCommentItemLongClick] args type no is StComment, handler fail.");
      return;
    }
    paramObject = (FeedCloudMeta.StComment)paramObject;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handleCommentItemLongClick] feedId: ");
    ((StringBuilder)localObject).append(b(A()));
    ((StringBuilder)localObject).append(" commentId: ");
    ((StringBuilder)localObject).append(a(paramObject));
    QLog.d("FSC-FSCommentPanelPart", 1, ((StringBuilder)localObject).toString());
    localObject = a(A(), paramObject);
    FSPopupWindowHelper.a().a(paramView, A(), paramObject, (FSPopupWindowHelper.MenuClickListener)localObject, null);
  }
  
  private void c(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[setFeedData] feed should not be null.");
      return;
    }
    String str = b(paramStFeed);
    int i1 = paramStFeed.commentCount.get();
    FSCommentManager.a().a(str, i1);
  }
  
  private void c(Object paramObject) {}
  
  private void c(boolean paramBoolean)
  {
    FSPanelLoadingView localFSPanelLoadingView = this.e;
    if (localFSPanelLoadingView == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[setPanelLoadingView] panel loading view should not be null.");
      return;
    }
    if (paramBoolean)
    {
      localFSPanelLoadingView.a(this.b.getPanelHeight());
      a(this.c, 8);
      a(this.k, 8);
      a(this.l, 8);
      return;
    }
    localFSPanelLoadingView.b();
    a(this.c, 0);
    a(this.k, 0);
  }
  
  private void d()
  {
    boolean bool = FSGlobalInfoHelper.b();
    QLog.d("DM-FSC-FSCommentPanelPart", 1, new Object[] { "[switchBarrage]  before operation | isBarrageOpenBefore: ", Boolean.valueOf(bool) });
    FSGlobalInfoHelper.a(bool ^ true);
    m();
    Object localObject;
    if (bool)
    {
      localObject = FSCloseBarrageEvent.build().setFeedId(A().id.get());
      FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(A(), l()).a(132).b(2).a(A().poster.id.get()));
    }
    else
    {
      localObject = FSOpenBarrageEvent.build().setFeedId(A().id.get());
      FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(A(), l()).a(131).b(2).a(A().poster.id.get()));
    }
    SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)localObject);
  }
  
  private void d(View paramView)
  {
    this.c.setLayoutManagerType(1, 1);
    this.c.getBlockMerger().b(1);
    this.c.setEnableLoadMore(true);
    this.c.setEnableRefresh(false);
    this.c.setParentFragment(j());
    this.c.getRecyclerView().setNestedScrollingEnabled(true);
    this.c.getRecyclerView().setPadding(0, 0, 0, 0);
    paramView = new ArrayList();
    this.d = new FSCommentPanelBlock(null);
    this.d.a(10);
    paramView.add(this.d);
    this.d.setOnLoadDataDelegate(new FSCommentPanelPart.OnLoadDataDelegateImpl(this));
    this.d.a(this);
    this.c.getRecyclerView().setItemAnimator(new DefaultItemAnimator());
    ((SimpleItemAnimator)this.c.getRecyclerView().getItemAnimator()).setSupportsChangeAnimations(false);
    this.c.a(paramView);
    this.c.g();
  }
  
  private void d(View paramView, Object paramObject)
  {
    if (!(paramObject instanceof Object[]))
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[handleCommentReplyItemClick] current args not is array.");
      return;
    }
    Object localObject = (Object[])paramObject;
    if (localObject.length < 2)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[handleCommentReplyItemClick] current args length < ", Integer.valueOf(2) });
      return;
    }
    boolean bool = localObject[0] instanceof FeedCloudMeta.StComment;
    FeedCloudMeta.StReply localStReply = null;
    if (bool) {
      paramObject = (FeedCloudMeta.StComment)localObject[0];
    } else {
      paramObject = null;
    }
    if ((localObject[1] instanceof FeedCloudMeta.StReply)) {
      localStReply = (FeedCloudMeta.StReply)localObject[1];
    }
    if ((paramObject != null) && (localStReply != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleCommentReplyItemClick] feedId: ");
      ((StringBuilder)localObject).append(b(A()));
      ((StringBuilder)localObject).append(" commentId: ");
      ((StringBuilder)localObject).append(a(paramObject));
      ((StringBuilder)localObject).append(" replyId: ");
      ((StringBuilder)localObject).append(a(localStReply));
      QLog.d("FSC-FSCommentPanelPart", 1, ((StringBuilder)localObject).toString());
      if (a(paramObject, localStReply, false)) {
        e(paramView);
      }
      return;
    }
    QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[handleCommentReplyItemClick] comment: ", paramObject, " | reply: ", localStReply });
  }
  
  private void d(Object paramObject) {}
  
  private void e()
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[updateBlockMoreFinishState] block should not be null.");
      return;
    }
    localObject = ((FSCommentPanelBlock)localObject).getLoadInfo();
    boolean bool;
    if (localObject != null)
    {
      String str = b(A());
      bool = FSCommentManager.a().a(str);
      ((LoadInfo)localObject).a(bool);
    }
    else
    {
      bool = false;
    }
    QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[handleGetCommentEvent] isLoadFinish: ", Boolean.valueOf(bool), " | feed id: ", b(A()) });
  }
  
  private void e(View paramView)
  {
    FSSlidBottomView localFSSlidBottomView = this.b;
    if ((localFSSlidBottomView != null) && (localFSSlidBottomView.b()))
    {
      this.b.d();
      RFThreadManager.getUIHandler().postDelayed(new FSCommentPanelPart.10(this, paramView), 1500L);
      return;
    }
    g(paramView);
  }
  
  private void e(View paramView, Object paramObject)
  {
    if (!(paramObject instanceof FeedCloudMeta.StComment))
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[handleCommentReplayClick] args type no is StComment, handler fail.");
      return;
    }
    paramObject = (FeedCloudMeta.StComment)paramObject;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[handleCommentReplayClick] feedId: ");
    localStringBuilder.append(b(A()));
    localStringBuilder.append(" commentId: ");
    localStringBuilder.append(a(paramObject));
    QLog.d("FSC-FSCommentPanelPart", 1, localStringBuilder.toString());
    if (a(paramObject, null, false)) {
      e(paramView);
    }
  }
  
  private void e(Object paramObject)
  {
    RelativeLayout localRelativeLayout = this.a;
    if (localRelativeLayout == null) {
      return;
    }
    if (!(paramObject instanceof FSCommentInfo))
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[againBindTagReportBean] current args not is FSCommentInfo type, handle fail.");
      return;
    }
    a(localRelativeLayout, ((FSCommentInfo)paramObject).d);
  }
  
  private void e(String paramString, Object paramObject)
  {
    if (!(paramObject instanceof FSCommentInfo))
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[handleComment] current args not is FSCommentInfo type, handle fail.");
      return;
    }
    this.h = ((FSCommentInfo)paramObject);
    f();
    J();
    c(this.h.a);
    if (TextUtils.equals(paramString, "comment_input_window_show"))
    {
      a(this.h.b, this.h.c, this.h.e, false);
      return;
    }
    if (TextUtils.equals(paramString, "comment_panel_show")) {
      q();
    }
  }
  
  private void f()
  {
    if (this.s != null) {
      return;
    }
    View localView = F();
    if (localView == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[initializedPart] root view should not be null.");
      return;
    }
    b(localView);
    e(this.h);
    n();
    o();
    p();
    d(localView);
    m();
  }
  
  private void f(View paramView)
  {
    if (paramView == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    arrayOfInt[1] += paramView.getHeight();
    int i1 = FSCommentHelper.a().b();
    if (arrayOfInt[1] > i1)
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        ((FSBlockContainer)localObject).getRecyclerView().scrollBy(0, arrayOfInt[1] - i1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("scrollItemToVisble  scrollBy: ");
        ((StringBuilder)localObject).append(arrayOfInt[1] - i1);
        QLog.i("FSC-FSCommentPanelPart", 1, ((StringBuilder)localObject).toString());
        b(arrayOfInt[1] - i1);
        RFThreadManager.getUIHandler().postDelayed(new FSCommentPanelPart.11(this, paramView, arrayOfInt, i1), 1L);
      }
    }
  }
  
  private void f(View paramView, Object paramObject)
  {
    if (!(paramObject instanceof FeedCloudMeta.StComment))
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[handleAvatarClick] args type no is StComment, handler fail.");
      return;
    }
    paramObject = (FeedCloudMeta.StComment)paramObject;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[handleCommentItemClick] feedId: ");
    localStringBuilder.append(b(A()));
    localStringBuilder.append(" commentId: ");
    localStringBuilder.append(a(paramObject));
    QLog.d("FSC-FSCommentPanelPart", 1, localStringBuilder.toString());
    if (a(paramObject, null, false)) {
      e(paramView);
    }
  }
  
  private void g(View paramView)
  {
    J();
    f(paramView);
  }
  
  private void m()
  {
    if (FSConfig.a("qqflash", "qqflash_show_barrage_enabled", Integer.valueOf(1)).intValue() != 1) {
      return;
    }
    if (FSGlobalInfoHelper.b())
    {
      this.t.setImageResource(2130840376);
      return;
    }
    this.t.setImageResource(2130840375);
  }
  
  private void n()
  {
    this.i.setOnClickListener(this);
    this.t.setOnClickListener(this);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private void o()
  {
    FSCommentPanelPart.7 local7 = new FSCommentPanelPart.7(this);
    this.b.setOnClickListener(local7);
    this.b.setStatusListener(new FSCommentPanelPart.8(this));
    if ((l() != null) && (!l().getPageId().equals("pg_ks_layer_page"))) {
      this.b.a(FSFolderFragmentManager.a().i());
    }
    this.g.setOnClickListener(local7);
  }
  
  private void p()
  {
    Object localObject = this.i;
    if (localObject == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[updateInputViewText] text input view should not be null.");
      return;
    }
    localObject = ((TextView)localObject).getResources().getString(2131889509);
    this.i.setPadding(ViewUtils.dip2px(20.0F), 0, 0, 0);
    TextView localTextView = this.i;
    localTextView.setHintTextColor(localTextView.getResources().getColor(2131166097));
    this.i.setText((CharSequence)localObject);
  }
  
  private void q()
  {
    m();
    if (t())
    {
      r();
      return;
    }
    w();
    s();
    b(false);
    B();
    r();
    this.n = A();
    if (HostNetworkUtils.isNetworkAvailable()) {
      c(true);
    }
  }
  
  private void r()
  {
    a(this.a, 0);
    FSSlidBottomView localFSSlidBottomView = this.b;
    if (localFSSlidBottomView != null)
    {
      FrameLayout localFrameLayout = this.f;
      if (localFrameLayout != null) {
        localFSSlidBottomView.a(localFrameLayout);
      }
    }
  }
  
  private void s()
  {
    u();
    v();
  }
  
  private boolean t()
  {
    String str = b(this.n);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return TextUtils.equals(b(A()), str);
  }
  
  private void u()
  {
    FSCommentPanelBlock localFSCommentPanelBlock = this.d;
    if (localFSCommentPanelBlock == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[clearLastCommentData] current block should not be null.");
      return;
    }
    if (localFSCommentPanelBlock.getItemCount() <= 0) {
      return;
    }
    this.d.clearData();
  }
  
  private void v()
  {
    RecyclerView localRecyclerView = y();
    if (localRecyclerView == null) {
      return;
    }
    localRecyclerView.scrollToPosition(0);
  }
  
  private void w()
  {
    BlockMerger localBlockMerger = x();
    if (localBlockMerger == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[resetLoadMoreCount] merger should not be null.");
      return;
    }
    localBlockMerger.l();
  }
  
  private BlockMerger x()
  {
    FSBlockContainer localFSBlockContainer = this.c;
    if (localFSBlockContainer == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[obtainCurrentBlockMerger] block container should not be null.");
      return null;
    }
    return localFSBlockContainer.getBlockMerger();
  }
  
  private RecyclerView y()
  {
    FSBlockContainer localFSBlockContainer = this.c;
    if (localFSBlockContainer == null)
    {
      QLog.d("FSC-FSCommentPanelPart", 1, "[obtainCurrentRecyclerView] block container should not be null.");
      return null;
    }
    return localFSBlockContainer.getRecyclerView();
  }
  
  private void z()
  {
    RelativeLayout localRelativeLayout = this.a;
    if ((localRelativeLayout != null) && (this.b != null) && (localRelativeLayout.getVisibility() == 0)) {
      this.b.e();
    }
  }
  
  public Object D()
  {
    if (this.a == null) {
      return null;
    }
    return RFWViewUtils.a(BasePartFragment.E, this.a);
  }
  
  public String a()
  {
    return "FSC-FSCommentPanelPart";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (256 == paramInt1) {
      SimpleEventBus.getInstance().dispatchEvent(new FSAtUpdateEvent(g(), paramIntent));
    }
  }
  
  public void a(View paramView)
  {
    a(j(), paramView, E());
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramInt1 == 2)
    {
      d(paramObject);
      return;
    }
    if (paramInt1 == 1)
    {
      c(paramObject);
      return;
    }
    if (paramInt1 == 4)
    {
      f(paramView, paramObject);
      return;
    }
    if (paramInt1 == 13)
    {
      e(paramView, paramObject);
      return;
    }
    if (paramInt1 == 7)
    {
      d(paramView, paramObject);
      return;
    }
    if (paramInt1 == 10)
    {
      b(paramObject, paramInt2);
      return;
    }
    if (paramInt1 == 11)
    {
      a(paramObject, paramInt2);
      return;
    }
    if (paramInt1 == 14)
    {
      b(paramObject);
      return;
    }
    if (paramInt1 == 15) {
      a(paramObject);
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    QLog.d("FSC-FSCommentPanelPart", 1, new Object[] { "[handleBroadcastMessage] action: ", paramString });
    e(paramObject);
    if (TextUtils.equals(paramString, "comment_input_window_show"))
    {
      e(paramString, paramObject);
      return;
    }
    if (TextUtils.equals(paramString, "comment_panel_show"))
    {
      e(paramString, paramObject);
      return;
    }
    if (TextUtils.equals(paramString, "comment_panel_dismiss")) {
      z();
    }
  }
  
  public boolean ah_()
  {
    RelativeLayout localRelativeLayout = this.a;
    if ((localRelativeLayout != null) && (localRelativeLayout.getVisibility() == 0))
    {
      this.b.e();
      return true;
    }
    return super.ah_();
  }
  
  protected void b(View paramView)
  {
    this.s = ((ViewStub)paramView.findViewById(2131433345));
    this.a = ((RelativeLayout)this.s.inflate().findViewById(2131431108));
    this.b = ((FSSlidBottomView)this.a.findViewById(2131433347));
    this.c = ((FSBlockContainer)this.a.findViewById(2131433346));
    this.g = ((ImageView)this.a.findViewById(2131433349));
    this.f = ((FrameLayout)this.a.findViewById(2131433339));
    this.j = ((TextView)this.a.findViewById(2131433342));
    this.i = ((TextView)this.a.findViewById(2131433392));
    this.l = ((FSCommentPanelHintView)this.a.findViewById(2131433340));
    this.e = ((FSPanelLoadingView)this.a.findViewById(2131433344));
    this.k = ((RelativeLayout)this.a.findViewById(2131433348));
    this.t = ((ImageView)this.a.findViewById(2131433338));
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramInt1 == 5)
    {
      c(paramView, paramObject);
      return;
    }
    if (paramInt1 == 8) {
      b(paramView, paramObject);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSGetCommentEvent.class);
    localArrayList.add(FSAddCommentEvent.class);
    localArrayList.add(FSAddReplyCommentEvent.class);
    localArrayList.add(FSDeleteCommentEvent.class);
    localArrayList.add(FSDeleteReplyCommentEvent.class);
    localArrayList.add(FSCommentPraiseUpdateEvent.class);
    localArrayList.add(FSUpdateCommentTotalEvent.class);
    return localArrayList;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    L();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131433392)
    {
      a(this.o, this.p, true);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick text_input, feedId: ");
      localStringBuilder.append(A().id.get());
      QLog.d("FSC-FSCommentPanelPart", 1, localStringBuilder.toString());
    }
    else if (i1 == 2131433338)
    {
      d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof FSGetCommentEvent))
    {
      a((FSGetCommentEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof FSAddCommentEvent))
    {
      a((FSAddCommentEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof FSAddReplyCommentEvent))
    {
      a((FSAddReplyCommentEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof FSDeleteCommentEvent))
    {
      a((FSDeleteCommentEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof FSDeleteReplyCommentEvent))
    {
      a((FSDeleteReplyCommentEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof FSCommentPraiseUpdateEvent))
    {
      a((FSCommentPraiseUpdateEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof FSUpdateCommentTotalEvent)) {
      a((FSUpdateCommentTotalEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSCommentPanelPart
 * JD-Core Version:    0.7.0.1
 */