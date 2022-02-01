package com.tencent.mobileqq.kandian.biz.gifvideo.utils;

import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController.Companion;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyVideoView;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeVideoView;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VideoPlayControlUtils
{
  private static VideoPlayControlUtils.VideoCheckHandler a = new VideoPlayControlUtils.VideoCheckHandler(Looper.getMainLooper());
  
  public static void a(View paramView)
  {
    if ((paramView instanceof IPlayableView)) {
      ((IPlayableView)paramView).a();
    }
  }
  
  public static void a(Container paramContainer)
  {
    if (VideoPlayController.a.f())
    {
      paramContainer = paramContainer.getViewIdMapping().entrySet().iterator();
      while (paramContainer.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramContainer.next();
        if ((localEntry.getValue() instanceof ReadInJoyVideoView)) {
          ((ReadInJoyVideoView)localEntry.getValue()).a().startPlay();
        }
      }
    }
  }
  
  public static void a(AbsListView paramAbsListView)
  {
    a(paramAbsListView, null);
  }
  
  public static void a(AbsListView paramAbsListView, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    a(paramAbsListView, paramAbsBaseArticleInfo, false);
  }
  
  public static void a(AbsListView paramAbsListView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendMessage: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("gifvideo.VideoPlayControlUtils", 1, ((StringBuilder)localObject).toString());
    a.removeMessages(1001);
    a.removeMessages(paramInt);
    localObject = Message.obtain();
    ((Message)localObject).what = paramInt;
    ((Message)localObject).obj = new Object[] { paramAbsListView, paramAbsBaseArticleInfo };
    a.sendMessageDelayed((Message)localObject, paramLong);
  }
  
  public static void a(AbsListView paramAbsListView, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    a(paramAbsListView, paramAbsBaseArticleInfo, 1001, 100L);
  }
  
  public static void b(Container paramContainer)
  {
    paramContainer = paramContainer.getViewIdMapping().entrySet().iterator();
    while (paramContainer.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramContainer.next();
      if ((localEntry.getValue() instanceof ReadInJoyVideoView)) {
        ((ReadInJoyVideoView)localEntry.getValue()).a().stop();
      }
    }
  }
  
  public static void b(AbsListView paramAbsListView)
  {
    if (paramAbsListView == null) {
      return;
    }
    a.removeMessages(1001);
    g(paramAbsListView);
  }
  
  public static void c(AbsListView paramAbsListView)
  {
    if (RIJAppSetting.a(paramAbsListView.getContext()))
    {
      if (paramAbsListView.getChildCount() <= 0) {
        return;
      }
      int i = 0;
      while (i < paramAbsListView.getChildCount())
      {
        View localView = paramAbsListView.getChildAt(i);
        if ((localView instanceof IPlayableView)) {
          ((IPlayableView)localView).a();
        }
        i += 1;
      }
    }
  }
  
  private static void c(AbsListView paramAbsListView, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int j = 0;
    int i = 0;
    Object localObject;
    while (i < paramAbsListView.getChildCount())
    {
      localObject = paramAbsListView.getChildAt(i);
      if ((localObject instanceof IPlayableView))
      {
        float f = ReadInJoyDisplayUtils.a((View)localObject);
        if (paramAbsBaseArticleInfo != null)
        {
          if (paramAbsBaseArticleInfo.equals(((IPlayableView)localObject).getArticleInfo()))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("find article: ");
            ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.innerUniqueID);
            QLog.d("gifvideo.VideoPlayControlUtils", 2, ((StringBuilder)localObject).toString());
            break label136;
          }
        }
        else if ((((IPlayableView)localObject).c()) && (f >= 80.0F))
        {
          QLog.d("gifvideo.VideoPlayControlUtils", 2, ">= 80f");
          break label136;
        }
      }
      i += 1;
    }
    i = -1;
    label136:
    if (i != -1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("item to play: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("gifvideo.VideoPlayControlUtils", 2, ((StringBuilder)localObject).toString());
      while (j < paramAbsListView.getChildCount())
      {
        localObject = paramAbsListView.getChildAt(j);
        if ((localObject instanceof IPlayableView))
        {
          localObject = (IPlayableView)localObject;
          if ((((IPlayableView)localObject).c()) && (j != i)) {
            ((IPlayableView)localObject).a();
          }
        }
        j += 1;
      }
      paramAbsListView = paramAbsListView.getChildAt(i);
      if ((paramAbsListView instanceof IPlayableView))
      {
        if (paramAbsBaseArticleInfo != null)
        {
          ((IPlayableView)paramAbsListView).a(8);
          return;
        }
        ((IPlayableView)paramAbsListView).a(3);
      }
    }
  }
  
  public static void d(AbsListView paramAbsListView)
  {
    a.removeMessages(1001);
    c(paramAbsListView);
  }
  
  public static void e(AbsListView paramAbsListView)
  {
    if (paramAbsListView == null) {
      return;
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(paramAbsListView);
  }
  
  public static void f(AbsListView paramAbsListView)
  {
    a.removeMessages(1001);
    e(paramAbsListView);
  }
  
  private static void g(AbsListView paramAbsListView)
  {
    if (paramAbsListView.getChildCount() <= 0) {
      return;
    }
    int i = 0;
    while (i < paramAbsListView.getChildCount())
    {
      View localView = paramAbsListView.getChildAt(i);
      if ((localView instanceof IPlayableView)) {
        ((IPlayableView)localView).b();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoPlayControlUtils
 * JD-Core Version:    0.7.0.1
 */