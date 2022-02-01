package com.tencent.mobileqq.search.fragment.searchentry.nativemethod;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchNativeMethodController
{
  private final QQAppInterface app;
  private final Context context;
  private final Object lock = new Object();
  @NonNull
  private final INativeMethodHandler methodHandler;
  private final List<SearchNativeMethodBase> nativeMethodList = new ArrayList();
  
  public SearchNativeMethodController(Context paramContext, QQAppInterface paramQQAppInterface, @NonNull INativeMethodHandler paramINativeMethodHandler)
  {
    this.context = paramContext;
    this.app = paramQQAppInterface;
    this.methodHandler = paramINativeMethodHandler;
  }
  
  private void initMethodList()
  {
    this.nativeMethodList.clear();
    this.nativeMethodList.add(new RequestHistoryDataMethod(this.context, this.app, this.methodHandler));
    this.nativeMethodList.add(new RemoveHistoryMethod(this.context, this.app, this.methodHandler));
    this.nativeMethodList.add(new ClearHistoryMethod(this.context, this.app, this.methodHandler));
    this.nativeMethodList.add(new OpenUrlMethod(this.context, this.app, this.methodHandler));
    this.nativeMethodList.add(new OpenHistoryMethod(this.context, this.app, this.methodHandler));
    this.nativeMethodList.add(new FillInKeywordMethod(this.context, this.app, this.methodHandler));
    this.nativeMethodList.add(new HideInputMethod(this.context, this.app, this.methodHandler));
    this.nativeMethodList.add(new RequestHotwordMethod(this.context, this.app, this.methodHandler));
    this.nativeMethodList.add(new ShowHotwordMethod(this.context, this.app, this.methodHandler));
    this.nativeMethodList.add(new OnHotwordClickMethod(this.context, this.app, this.methodHandler));
    this.nativeMethodList.add(new GetCommonDataMethod(this.context, this.app, this.methodHandler));
  }
  
  public void registerNativeMethod(@NonNull HippyQQEngine paramHippyQQEngine)
  {
    synchronized (this.lock)
    {
      initMethodList();
      Iterator localIterator = this.nativeMethodList.iterator();
      if (localIterator.hasNext())
      {
        SearchNativeMethodBase localSearchNativeMethodBase = (SearchNativeMethodBase)localIterator.next();
        paramHippyQQEngine.registerNativeMethod(localSearchNativeMethodBase.getModuleName(), localSearchNativeMethodBase.getFuncName(), localSearchNativeMethodBase);
      }
    }
  }
  
  public void unRegisterNativeMethod(@NonNull HippyQQEngine paramHippyQQEngine)
  {
    synchronized (this.lock)
    {
      Iterator localIterator = this.nativeMethodList.iterator();
      if (localIterator.hasNext())
      {
        SearchNativeMethodBase localSearchNativeMethodBase = (SearchNativeMethodBase)localIterator.next();
        paramHippyQQEngine.unRegisterNativeMethod(localSearchNativeMethodBase.getModuleName(), localSearchNativeMethodBase.getFuncName());
      }
    }
    this.nativeMethodList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.nativemethod.SearchNativeMethodController
 * JD-Core Version:    0.7.0.1
 */