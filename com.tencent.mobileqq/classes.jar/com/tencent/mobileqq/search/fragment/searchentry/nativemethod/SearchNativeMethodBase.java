package com.tencent.mobileqq.search.fragment.searchentry.nativemethod;

import android.content.Context;
import com.tencent.hippy.qq.module.tkd.TKDJsCallBack;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class SearchNativeMethodBase
  implements TKDJsCallBack
{
  protected final QQAppInterface app;
  protected final Context context;
  protected final INativeMethodHandler methodHandler;
  
  public SearchNativeMethodBase(Context paramContext, QQAppInterface paramQQAppInterface, INativeMethodHandler paramINativeMethodHandler)
  {
    this.context = paramContext;
    this.app = paramQQAppInterface;
    this.methodHandler = paramINativeMethodHandler;
  }
  
  public abstract String getFuncName();
  
  public String getModuleName()
  {
    return "search";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.nativemethod.SearchNativeMethodBase
 * JD-Core Version:    0.7.0.1
 */