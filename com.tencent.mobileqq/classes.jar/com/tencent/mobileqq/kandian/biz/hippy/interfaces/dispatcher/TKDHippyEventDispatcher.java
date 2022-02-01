package com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher;

import com.tencent.mobileqq.kandian.biz.hippy.api.ParamsFetcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.ITKDHippyEventReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common.ITKDHippy2NativeEventReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common.ITKDNative2HippyEventReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.tuwen.ITKDHippy2TuWenEventReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.tuwen.ITKDTuWen2HippyEventReceiver;
import com.tencent.mtt.hippy.common.HippyMap;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class TKDHippyEventDispatcher
  implements ITKDHippyEventDispatcher
{
  private static final Collection<WeakReference<TKDHippyEventDispatcher>> weakDisptachers = new LinkedList();
  private final List<ITKDHippyEventReceiver> receivers = new LinkedList();
  
  public TKDHippyEventDispatcher()
  {
    weakDisptachers.add(new WeakReference(this));
  }
  
  public static void changeFontScale(double paramDouble)
  {
    Iterator localIterator = weakDisptachers.iterator();
    while (localIterator.hasNext())
    {
      TKDHippyEventDispatcher localTKDHippyEventDispatcher = (TKDHippyEventDispatcher)((WeakReference)localIterator.next()).get();
      if (localTKDHippyEventDispatcher == null) {
        localIterator.remove();
      } else {
        localTKDHippyEventDispatcher.onFontScaleChange(paramDouble);
      }
    }
  }
  
  public void biuComment(ParamsFetcher paramParamsFetcher)
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDHippy2NativeEventReceiver)) {
        ((ITKDHippy2NativeEventReceiver)localITKDHippyEventReceiver).biuComment(paramParamsFetcher);
      }
    }
  }
  
  public void clear()
  {
    this.receivers.clear();
  }
  
  public void closeComment()
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDHippy2NativeEventReceiver)) {
        ((ITKDHippy2NativeEventReceiver)localITKDHippyEventReceiver).closeComment();
      }
    }
  }
  
  public void forbidScroll(boolean paramBoolean)
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDHippy2TuWenEventReceiver)) {
        ((ITKDHippy2TuWenEventReceiver)localITKDHippyEventReceiver).forbidScroll(paramBoolean);
      }
    }
  }
  
  @NotNull
  public List<ITKDHippyEventReceiver> getAllReceivers()
  {
    return this.receivers;
  }
  
  public void jsCloseComment()
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDNative2HippyEventReceiver)) {
        ((ITKDNative2HippyEventReceiver)localITKDHippyEventReceiver).jsCloseComment();
      }
    }
  }
  
  public void merge(ITKDHippyEventDispatcher paramITKDHippyEventDispatcher)
  {
    if (paramITKDHippyEventDispatcher == null) {
      return;
    }
    paramITKDHippyEventDispatcher = paramITKDHippyEventDispatcher.getAllReceivers().iterator();
    while (paramITKDHippyEventDispatcher.hasNext()) {
      register((ITKDHippyEventReceiver)paramITKDHippyEventDispatcher.next());
    }
  }
  
  public void onClickLike(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDHippy2NativeEventReceiver)) {
        ((ITKDHippy2NativeEventReceiver)localITKDHippyEventReceiver).onClickLike(paramString1, paramString2, paramString3, paramString4);
      }
    }
  }
  
  public void onCommentNumChanged(long paramLong)
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDHippy2TuWenEventReceiver)) {
        ((ITKDHippy2TuWenEventReceiver)localITKDHippyEventReceiver).onCommentNumChanged(paramLong);
      }
    }
  }
  
  public void onCommentViewLayout()
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDHippy2NativeEventReceiver)) {
        ((ITKDHippy2NativeEventReceiver)localITKDHippyEventReceiver).onCommentViewLayout();
      }
    }
  }
  
  public void onCreateComment(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDHippy2NativeEventReceiver)) {
        ((ITKDHippy2NativeEventReceiver)localITKDHippyEventReceiver).onCreateComment(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
      }
    }
  }
  
  public void onDeleteComment(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDHippy2NativeEventReceiver)) {
        ((ITKDHippy2NativeEventReceiver)localITKDHippyEventReceiver).onDeleteComment(paramString1, paramString2, paramString3, paramString4);
      }
    }
  }
  
  public void onDeleteMainComment(String paramString)
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDTuWen2HippyEventReceiver)) {
        ((ITKDTuWen2HippyEventReceiver)localITKDHippyEventReceiver).onDeleteMainComment(paramString);
      }
    }
  }
  
  public void onDeleteSubComment(String paramString1, String paramString2)
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDTuWen2HippyEventReceiver)) {
        ((ITKDTuWen2HippyEventReceiver)localITKDHippyEventReceiver).onDeleteSubComment(paramString1, paramString2);
      }
    }
  }
  
  public void onFontScaleChange(double paramDouble)
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDNative2HippyEventReceiver)) {
        ((ITKDNative2HippyEventReceiver)localITKDHippyEventReceiver).onFontScaleChange(paramDouble);
      }
    }
  }
  
  public void onHippyForbiddenChanged(int paramInt)
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDHippy2TuWenEventReceiver)) {
        ((ITKDHippy2TuWenEventReceiver)localITKDHippyEventReceiver).onHippyForbiddenChanged(paramInt);
      }
    }
  }
  
  public void onHippyLoadStatusChanged(int paramInt)
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDHippy2TuWenEventReceiver)) {
        ((ITKDHippy2TuWenEventReceiver)localITKDHippyEventReceiver).onHippyLoadStatusChanged(paramInt);
      }
    }
  }
  
  public void onInsertSubComment(String paramString1, String paramString2, String paramString3)
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDTuWen2HippyEventReceiver)) {
        ((ITKDTuWen2HippyEventReceiver)localITKDHippyEventReceiver).onInsertSubComment(paramString1, paramString2, paramString3);
      }
    }
  }
  
  public void onLikeMainCommentChanged(String paramString, boolean paramBoolean)
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDTuWen2HippyEventReceiver)) {
        ((ITKDTuWen2HippyEventReceiver)localITKDHippyEventReceiver).onLikeMainCommentChanged(paramString, paramBoolean);
      }
    }
  }
  
  public void onOpenCommentPublisher()
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDTuWen2HippyEventReceiver)) {
        ((ITKDTuWen2HippyEventReceiver)localITKDHippyEventReceiver).onOpenCommentPublisher();
      }
    }
  }
  
  public void onSubCommentClose()
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDHippy2NativeEventReceiver)) {
        ((ITKDHippy2NativeEventReceiver)localITKDHippyEventReceiver).onSubCommentClose();
      }
    }
  }
  
  public void onSubCommentOpen()
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDHippy2NativeEventReceiver)) {
        ((ITKDHippy2NativeEventReceiver)localITKDHippyEventReceiver).onSubCommentOpen();
      }
    }
  }
  
  public void openComment()
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDHippy2NativeEventReceiver)) {
        ((ITKDHippy2NativeEventReceiver)localITKDHippyEventReceiver).openComment();
      }
    }
  }
  
  public void openSubCommentPage(String paramString1, String paramString2)
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDHippy2TuWenEventReceiver)) {
        ((ITKDHippy2TuWenEventReceiver)localITKDHippyEventReceiver).openSubCommentPage(paramString1, paramString2);
      }
    }
  }
  
  public void refreshNewAndHotData(HippyMap paramHippyMap)
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDNative2HippyEventReceiver)) {
        ((ITKDNative2HippyEventReceiver)localITKDHippyEventReceiver).refreshNewAndHotData(paramHippyMap);
      }
    }
  }
  
  public void register(ITKDHippyEventReceiver paramITKDHippyEventReceiver)
  {
    if ((paramITKDHippyEventReceiver != null) && (!this.receivers.contains(paramITKDHippyEventReceiver))) {
      this.receivers.add(paramITKDHippyEventReceiver);
    }
  }
  
  public void scrollToNew()
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDHippy2TuWenEventReceiver)) {
        ((ITKDHippy2TuWenEventReceiver)localITKDHippyEventReceiver).scrollToNew();
      }
    }
  }
  
  public void sendCommentReadTime(long paramLong)
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDTuWen2HippyEventReceiver)) {
        ((ITKDTuWen2HippyEventReceiver)localITKDHippyEventReceiver).sendCommentReadTime(paramLong);
      }
    }
  }
  
  public void unregister(ITKDHippyEventReceiver paramITKDHippyEventReceiver)
  {
    if (paramITKDHippyEventReceiver != null) {
      this.receivers.remove(paramITKDHippyEventReceiver);
    }
  }
  
  public void updateFollowUI()
  {
    Iterator localIterator = this.receivers.iterator();
    while (localIterator.hasNext())
    {
      ITKDHippyEventReceiver localITKDHippyEventReceiver = (ITKDHippyEventReceiver)localIterator.next();
      if ((localITKDHippyEventReceiver instanceof ITKDTuWen2HippyEventReceiver)) {
        ((ITKDTuWen2HippyEventReceiver)localITKDHippyEventReceiver).updateFollowUI();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.TKDHippyEventDispatcher
 * JD-Core Version:    0.7.0.1
 */