package com.tencent.mobileqq.vas.ui;

import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResManager;
import dov.com.qq.im.ae.download.AEResManager.AEDownloadCallBack;
import dov.com.qq.im.ae.download.AEResUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/VasPagView$MyLoader;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$Loader;", "()V", "PAG_SO_NAME", "", "isLoad", "", "isLoading", "loaderListener", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$LoaderCallback;", "Lkotlin/collections/ArrayList;", "needLoad", "doLoad", "", "block", "Lkotlin/Function0;", "doLoad$AQQLiteApp_release", "initPagSo", "isLoaded", "notifyListener", "onDownloadFinished", "syncLoad", "callback", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasPagView$MyLoader
  implements AbsAsyncLoadProxy.Loader
{
  private final String jdField_a_of_type_JavaLangString = "liblibpag.so";
  private final ArrayList<AbsAsyncLoadProxy.LoaderCallback> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  private final void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    Iterator localIterator = ((Iterable)this.jdField_a_of_type_JavaUtilArrayList).iterator();
    while (localIterator.hasNext()) {
      ((AbsAsyncLoadProxy.LoaderCallback)localIterator.next()).a();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private final boolean b()
  {
    switch (VasSoUtils.a(AEResUtil.b(), this.jdField_a_of_type_JavaLangString))
    {
    }
    for (;;)
    {
      return false;
      QLog.e(VasPagView.b(), 1, "初始化Pag_so库,完成");
      return true;
      QLog.e(VasPagView.b(), 1, "初始化Pag_so库,加载异常");
      continue;
      QLog.e(VasPagView.b(), 1, "初始化Pag_so库,不存在");
    }
  }
  
  public void a(@NotNull AbsAsyncLoadProxy.LoaderCallback paramLoaderCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramLoaderCallback, "callback");
    this.c = true;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        paramLoaderCallback.a();
        a();
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramLoaderCallback);
      if (this.b)
      {
        paramLoaderCallback = Unit.INSTANCE;
        return;
      }
      this.b = true;
      a((Function0)new VasPagView.MyLoader.syncLoad..inlined.synchronized.lambda.1(this, paramLoaderCallback));
    }
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    try
    {
      paramFunction0 = (Function0)new VasPagView.MyLoader.doLoad.loader.1(this, paramFunction0);
      if (AEResUtil.b(AEResInfo.c))
      {
        paramFunction0.invoke();
        return;
      }
      AEResManager.a().a(AEResInfo.c, (AEResManager.AEDownloadCallBack)new VasPagView.MyLoader.doLoad.1(this, paramFunction0), false);
      return;
    }
    catch (Throwable paramFunction0)
    {
      QLog.e(VasPagView.b(), 1, paramFunction0, new Object[0]);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.VasPagView.MyLoader
 * JD-Core Version:    0.7.0.1
 */