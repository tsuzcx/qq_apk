package com.tencent.mobileqq.flashshow.widgets.comment.helper;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.mobileqq.flashshow.bean.FSFeedCommentInfo;
import com.tencent.mobileqq.flashshow.events.FSAtUpdateEvent;
import com.tencent.mobileqq.flashshow.events.FSCommentUpdateEvent;
import com.tencent.mobileqq.flashshow.utils.FSHardCodeUtil;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.mobileqq.flashshow.widgets.comment.FSCommentInputPopupWindow;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FSCommentHelper
  implements SimpleEventReceiver
{
  private static FSCommentHelper a;
  private Map<String, String> b = new HashMap();
  private Map<String, List<FSFeedCommentInfo>> c = new HashMap();
  private WeakReference<FSCommentInputPopupWindow> d;
  private FeedCloudMeta.StFeed e;
  private FeedCloudMeta.StComment f;
  private FeedCloudMeta.StReply g;
  private WeakReference<FSCommentHelper.CommentInputListener> h;
  private Map<String, WeakReference<FSCommentHelper.FSCommentUpdateListener>> i = new ConcurrentHashMap();
  
  private FSCommentHelper()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public static FSCommentHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FSCommentHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  private String a(FeedCloudMeta.StComment paramStComment)
  {
    if (paramStComment == null) {
      return "";
    }
    return paramStComment.postUser.id.get();
  }
  
  private String a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return "";
    }
    return paramStFeed.poster.id.get();
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append(paramString1);
    } else {
      localStringBuilder.append("0");
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder.append("&&");
      localStringBuilder.append(paramString2);
    }
    else
    {
      localStringBuilder.append("&&");
      localStringBuilder.append("0");
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      localStringBuilder.append("&&");
      localStringBuilder.append(paramString3);
    }
    else
    {
      localStringBuilder.append("&&");
      localStringBuilder.append("0");
    }
    return localStringBuilder.toString();
  }
  
  private void a(FSCommentUpdateEvent paramFSCommentUpdateEvent)
  {
    String str = paramFSCommentUpdateEvent.comment.id.get();
    Iterator localIterator1 = this.c.keySet().iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        return;
      }
      Object localObject2 = (String)localIterator1.next();
      if (((String)localObject2).startsWith(str))
      {
        Object localObject1 = (List)this.c.get(localObject2);
        if (localObject1 != null)
        {
          Iterator localIterator2 = ((List)localObject1).iterator();
          if (localIterator2.hasNext())
          {
            FSFeedCommentInfo localFSFeedCommentInfo = (FSFeedCommentInfo)localIterator2.next();
            if (!localFSFeedCommentInfo.c.id.get().equals(paramFSCommentUpdateEvent.reply.id.get())) {
              break;
            }
            ((List)localObject1).remove(localFSFeedCommentInfo);
            localObject2 = (WeakReference)this.i.get(localObject2);
            if (localObject2 != null)
            {
              localObject2 = (FSCommentHelper.FSCommentUpdateListener)((WeakReference)localObject2).get();
              if (localObject2 != null) {
                ((FSCommentHelper.FSCommentUpdateListener)localObject2).a((List)localObject1);
              }
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("removeTargetReply");
            ((StringBuilder)localObject1).append(localFSFeedCommentInfo.c.id.get());
            QLog.d("FSC-FSCommentHelper", 1, ((StringBuilder)localObject1).toString());
          }
        }
      }
    }
  }
  
  private void a(FSCommentInputPopupWindow paramFSCommentInputPopupWindow, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, FSCommentHelper.CommentInputListener paramCommentInputListener, int paramInt)
  {
    if (paramFSCommentInputPopupWindow == null) {
      return;
    }
    paramFSCommentInputPopupWindow.setOnShowListener(new FSCommentHelper.3(this, paramStFeed, paramStComment, paramStReply, paramFSCommentInputPopupWindow));
    paramFSCommentInputPopupWindow.a(new FSCommentHelper.4(this, paramFSCommentInputPopupWindow, paramStFeed, paramStComment, paramStReply, paramCommentInputListener, paramInt));
  }
  
  private void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("storeComment storeKey: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" comment: ");
    localStringBuilder.append(paramString2);
    QLog.d("FSC-FSCommentHelper", 1, localStringBuilder.toString());
    this.b.put(paramString1, paramString2);
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  private void b(FSCommentUpdateEvent paramFSCommentUpdateEvent)
  {
    String str = paramFSCommentUpdateEvent.comment.id.get();
    Iterator localIterator = this.c.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Object localObject1 = (String)localIterator.next();
      if (((String)localObject1).startsWith(str))
      {
        localObject1 = (List)this.c.get(localObject1);
        if (localObject1 != null)
        {
          Object localObject2 = ((List)localObject1).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = (FSFeedCommentInfo)((Iterator)localObject2).next();
            if (!((FSFeedCommentInfo)localObject1).c.id.get().equals(paramFSCommentUpdateEvent.fakeReplyId)) {
              break;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("replaceFakeReply PreFakeReplyId:");
            ((StringBuilder)localObject2).append(paramFSCommentUpdateEvent.fakeReplyId);
            ((StringBuilder)localObject2).append(" replaceId:");
            ((StringBuilder)localObject2).append(paramFSCommentUpdateEvent.reply.id.get());
            QLog.d("FSC-FSCommentHelper", 1, ((StringBuilder)localObject2).toString());
            ((FSFeedCommentInfo)localObject1).c.set(paramFSCommentUpdateEvent.reply);
          }
        }
      }
    }
  }
  
  private String c(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    String str = "";
    if (paramStFeed != null) {
      paramStFeed = paramStFeed.id.get();
    } else {
      paramStFeed = "";
    }
    if (paramStComment != null) {
      paramStComment = paramStComment.id.get();
    } else {
      paramStComment = "";
    }
    if (paramStReply != null) {
      str = paramStReply.id.get();
    }
    return a(paramStFeed, paramStComment, str);
  }
  
  public String a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (paramStReply != null)
    {
      if (paramStReply.postUser != null)
      {
        paramStReply = String.format(FSHardCodeUtil.a(2131889511), new Object[] { paramStReply.postUser.nick.get() });
        paramStComment = paramStReply;
        if (paramStReply.length() > 10)
        {
          paramStComment = paramStReply.substring(0, 10);
          paramStReply = new StringBuilder();
          paramStReply.append(paramStComment);
          paramStReply.append("...");
          paramStComment = paramStReply.toString();
        }
        return paramStComment;
      }
    }
    else if ((paramStComment != null) && (paramStComment.postUser != null))
    {
      paramStReply = String.format(FSHardCodeUtil.a(2131889511), new Object[] { paramStComment.postUser.nick.get() });
      paramStComment = paramStReply;
      if (paramStReply.length() > 10)
      {
        paramStComment = paramStReply.substring(0, 10);
        paramStReply = new StringBuilder();
        paramStReply.append(paramStComment);
        paramStReply.append("...");
        paramStComment = paramStReply.toString();
      }
      return paramStComment;
    }
    return FSTransUtils.f().getResources().getString(2131889508);
  }
  
  public String a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    paramStFeed = c(paramStFeed, paramStComment, paramStReply);
    if (this.b.containsKey(paramStFeed))
    {
      paramStComment = new StringBuilder();
      paramStComment.append("getComment storeKey: ");
      paramStComment.append(paramStFeed);
      paramStComment.append(" preCommentText: ");
      paramStComment.append((String)this.b.get(paramStFeed));
      QLog.d("FSC-FSCommentHelper", 1, paramStComment.toString());
      return (String)this.b.get(paramStFeed);
    }
    paramStComment = new StringBuilder();
    paramStComment.append("getComment storeKey: ");
    paramStComment.append(paramStFeed);
    paramStComment.append(" preCommentText doesn't exit");
    QLog.d("FSC-FSCommentHelper", 1, paramStComment.toString());
    return "";
  }
  
  public List<FSFeedCommentInfo> a(String paramString)
  {
    return (List)this.c.get(paramString);
  }
  
  public List<FSFeedCommentInfo> a(String paramString, FSFeedCommentInfo paramFSFeedCommentInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramFSFeedCommentInfo != null))
    {
      if (this.c == null) {
        this.c = new HashMap();
      }
      List localList = (List)this.c.get(paramString);
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      ((List)localObject).add(paramFSFeedCommentInfo);
      this.c.put(paramString, localObject);
      return localObject;
    }
    QLog.d("FSC-FSCommentHelper", 1, "addFakeReply param error");
    return null;
  }
  
  public void a(Activity paramActivity, FSFeedCommentInfo paramFSFeedCommentInfo, FSCommentHelper.CommentInputListener paramCommentInputListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    FSCommentHelper.InputPopupWindowParam localInputPopupWindowParam = new FSCommentHelper.InputPopupWindowParam(null);
    localInputPopupWindowParam.a(paramActivity);
    localInputPopupWindowParam.a(paramFSFeedCommentInfo);
    localInputPopupWindowParam.a(paramCommentInputListener);
    localInputPopupWindowParam.a(paramBoolean1);
    localInputPopupWindowParam.b(paramBoolean2);
    a(localInputPopupWindowParam);
  }
  
  public void a(@NonNull FSCommentHelper.InputPopupWindowParam paramInputPopupWindowParam)
  {
    Activity localActivity = paramInputPopupWindowParam.a();
    FSFeedCommentInfo localFSFeedCommentInfo = paramInputPopupWindowParam.b();
    FSCommentHelper.CommentInputListener localCommentInputListener = paramInputPopupWindowParam.c();
    boolean bool1 = paramInputPopupWindowParam.d();
    int j = paramInputPopupWindowParam.e();
    boolean bool2 = paramInputPopupWindowParam.f();
    if ((localActivity != null) && (localFSFeedCommentInfo != null))
    {
      paramInputPopupWindowParam = localFSFeedCommentInfo.a;
      FeedCloudMeta.StComment localStComment = localFSFeedCommentInfo.b;
      FeedCloudMeta.StReply localStReply = localFSFeedCommentInfo.c;
      FSReportBean localFSReportBean = localFSFeedCommentInfo.d;
      b(this.e, this.f, this.g);
      this.h = new WeakReference(localCommentInputListener);
      FSCommentInputPopupWindow localFSCommentInputPopupWindow = new FSCommentInputPopupWindow(localActivity);
      this.d = new WeakReference(localFSCommentInputPopupWindow);
      localFSCommentInputPopupWindow.b(a(localStComment, localStReply));
      localFSCommentInputPopupWindow.a(new FSCommentHelper.1(this, localActivity, localFSCommentInputPopupWindow, paramInputPopupWindowParam, localStComment, localStReply, bool1, localFSReportBean, j, bool2));
      if (j > 100) {
        localFSCommentInputPopupWindow.a(new FSCommentHelper.2(this, localFSFeedCommentInfo));
      }
      a(localFSCommentInputPopupWindow, paramInputPopupWindowParam, localStComment, localStReply, localCommentInputListener, j);
      localFSCommentInputPopupWindow.a(false);
      return;
    }
    QLog.e("FSC-FSCommentHelper", 1, "showInputPopupWindow param error");
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, String paramString)
  {
    a(c(paramStFeed, paramStComment, paramStReply), paramString);
  }
  
  public void a(String paramString, FSCommentHelper.FSCommentUpdateListener paramFSCommentUpdateListener)
  {
    if (paramFSCommentUpdateListener != null)
    {
      paramFSCommentUpdateListener = new WeakReference(paramFSCommentUpdateListener);
      this.i.put(paramString, paramFSCommentUpdateListener);
    }
  }
  
  public int b()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = (FSCommentInputPopupWindow)((WeakReference)localObject).get();
      if (localObject != null) {
        return ((FSCommentInputPopupWindow)localObject).i();
      }
    }
    return 0;
  }
  
  public void b(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    this.e = paramStFeed;
    this.f = paramStComment;
    this.g = paramStReply;
  }
  
  public void c()
  {
    this.c.clear();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSCommentUpdateEvent.class);
    localArrayList.add(FSAtUpdateEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof FSCommentUpdateEvent))
    {
      paramSimpleBaseEvent = (FSCommentUpdateEvent)paramSimpleBaseEvent;
      if ((paramSimpleBaseEvent.eventStatus != 6) && (paramSimpleBaseEvent.eventStatus != 10))
      {
        if (paramSimpleBaseEvent.eventStatus == 5) {
          b(paramSimpleBaseEvent);
        }
      }
      else {
        a(paramSimpleBaseEvent);
      }
    }
    else if ((paramSimpleBaseEvent instanceof FSAtUpdateEvent))
    {
      Object localObject = this.d;
      if (localObject != null)
      {
        localObject = (FSCommentInputPopupWindow)((WeakReference)localObject).get();
        if (localObject != null)
        {
          if (paramSimpleBaseEvent.mHashCode != ((FSCommentInputPopupWindow)localObject).n()) {
            return;
          }
          ((FSCommentInputPopupWindow)localObject).a((FSAtUpdateEvent)paramSimpleBaseEvent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.helper.FSCommentHelper
 * JD-Core Version:    0.7.0.1
 */