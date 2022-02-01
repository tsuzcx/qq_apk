package com.tencent.tkd.topicsdk;

import android.content.Context;
import com.tencent.tkd.topicsdk.interfaces.BaseUploader;
import com.tencent.tkd.topicsdk.interfaces.IAccount;
import com.tencent.tkd.topicsdk.interfaces.IBizConfig;
import com.tencent.tkd.topicsdk.interfaces.IDataReporter;
import com.tencent.tkd.topicsdk.interfaces.IDataTransfer;
import com.tencent.tkd.topicsdk.interfaces.IDialogBuilder;
import com.tencent.tkd.topicsdk.interfaces.IEmoJiEmotion;
import com.tencent.tkd.topicsdk.interfaces.IFloatViewManager;
import com.tencent.tkd.topicsdk.interfaces.IImageLoader;
import com.tencent.tkd.topicsdk.interfaces.ILogger;
import com.tencent.tkd.topicsdk.interfaces.IPageOpener;
import com.tencent.tkd.topicsdk.interfaces.IPermission;
import com.tencent.tkd.topicsdk.interfaces.IPkgManager;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager;
import com.tencent.tkd.topicsdk.interfaces.IStorageConfig;
import com.tencent.tkd.topicsdk.interfaces.ITheme;
import com.tencent.tkd.topicsdk.interfaces.IThreadManager;
import com.tencent.tkd.topicsdk.interfaces.IToast;
import com.tencent.tkd.topicsdk.interfaces.IUserActionHandler;
import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor;
import com.tencent.tkd.topicsdk.interfaces.IViewPager;
import com.tencent.tkd.topicsdk.interfaces.IWebViewOpener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/TopicSDKConfig;", "", "context", "Landroid/content/Context;", "bizConfig", "Lcom/tencent/tkd/topicsdk/interfaces/IBizConfig;", "pageOpener", "Lcom/tencent/tkd/topicsdk/interfaces/IPageOpener;", "logger", "Lcom/tencent/tkd/topicsdk/interfaces/ILogger;", "account", "Lcom/tencent/tkd/topicsdk/interfaces/IAccount;", "dataReporter", "Lcom/tencent/tkd/topicsdk/interfaces/IDataReporter;", "dataTransfer", "Lcom/tencent/tkd/topicsdk/interfaces/IDataTransfer;", "userActionHandler", "Lcom/tencent/tkd/topicsdk/interfaces/IUserActionHandler;", "threadManager", "Lcom/tencent/tkd/topicsdk/interfaces/IThreadManager;", "theme", "Lcom/tencent/tkd/topicsdk/interfaces/ITheme;", "toast", "Lcom/tencent/tkd/topicsdk/interfaces/IToast;", "permission", "Lcom/tencent/tkd/topicsdk/interfaces/IPermission;", "webViewOpener", "Lcom/tencent/tkd/topicsdk/interfaces/IWebViewOpener;", "imageLoader", "Lcom/tencent/tkd/topicsdk/interfaces/IImageLoader;", "uploader", "Lcom/tencent/tkd/topicsdk/interfaces/BaseUploader;", "viewPage", "Lcom/tencent/tkd/topicsdk/interfaces/IViewPager;", "floatViewManager", "Lcom/tencent/tkd/topicsdk/interfaces/IFloatViewManager;", "storageConfig", "Lcom/tencent/tkd/topicsdk/interfaces/IStorageConfig;", "emoJiEmotion", "Lcom/tencent/tkd/topicsdk/interfaces/IEmoJiEmotion;", "isDebug", "", "videoCompressor", "Lcom/tencent/tkd/topicsdk/interfaces/IVideoCompressor;", "pkgManager", "Lcom/tencent/tkd/topicsdk/interfaces/IPkgManager;", "dialogBuilder", "Ljava/lang/Class;", "Lcom/tencent/tkd/topicsdk/interfaces/IDialogBuilder;", "publishManager", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager;", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/interfaces/IBizConfig;Lcom/tencent/tkd/topicsdk/interfaces/IPageOpener;Lcom/tencent/tkd/topicsdk/interfaces/ILogger;Lcom/tencent/tkd/topicsdk/interfaces/IAccount;Lcom/tencent/tkd/topicsdk/interfaces/IDataReporter;Lcom/tencent/tkd/topicsdk/interfaces/IDataTransfer;Lcom/tencent/tkd/topicsdk/interfaces/IUserActionHandler;Lcom/tencent/tkd/topicsdk/interfaces/IThreadManager;Lcom/tencent/tkd/topicsdk/interfaces/ITheme;Lcom/tencent/tkd/topicsdk/interfaces/IToast;Lcom/tencent/tkd/topicsdk/interfaces/IPermission;Lcom/tencent/tkd/topicsdk/interfaces/IWebViewOpener;Lcom/tencent/tkd/topicsdk/interfaces/IImageLoader;Lcom/tencent/tkd/topicsdk/interfaces/BaseUploader;Lcom/tencent/tkd/topicsdk/interfaces/IViewPager;Lcom/tencent/tkd/topicsdk/interfaces/IFloatViewManager;Lcom/tencent/tkd/topicsdk/interfaces/IStorageConfig;Lcom/tencent/tkd/topicsdk/interfaces/IEmoJiEmotion;ZLcom/tencent/tkd/topicsdk/interfaces/IVideoCompressor;Lcom/tencent/tkd/topicsdk/interfaces/IPkgManager;Ljava/lang/Class;Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager;)V", "getAccount", "()Lcom/tencent/tkd/topicsdk/interfaces/IAccount;", "getBizConfig", "()Lcom/tencent/tkd/topicsdk/interfaces/IBizConfig;", "getContext", "()Landroid/content/Context;", "getDataReporter", "()Lcom/tencent/tkd/topicsdk/interfaces/IDataReporter;", "getDataTransfer", "()Lcom/tencent/tkd/topicsdk/interfaces/IDataTransfer;", "getDialogBuilder", "()Ljava/lang/Class;", "getEmoJiEmotion", "()Lcom/tencent/tkd/topicsdk/interfaces/IEmoJiEmotion;", "getFloatViewManager", "()Lcom/tencent/tkd/topicsdk/interfaces/IFloatViewManager;", "getImageLoader", "()Lcom/tencent/tkd/topicsdk/interfaces/IImageLoader;", "()Z", "getLogger", "()Lcom/tencent/tkd/topicsdk/interfaces/ILogger;", "getPageOpener", "()Lcom/tencent/tkd/topicsdk/interfaces/IPageOpener;", "getPermission", "()Lcom/tencent/tkd/topicsdk/interfaces/IPermission;", "getPkgManager", "()Lcom/tencent/tkd/topicsdk/interfaces/IPkgManager;", "getPublishManager", "()Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager;", "getStorageConfig", "()Lcom/tencent/tkd/topicsdk/interfaces/IStorageConfig;", "getTheme", "()Lcom/tencent/tkd/topicsdk/interfaces/ITheme;", "getThreadManager", "()Lcom/tencent/tkd/topicsdk/interfaces/IThreadManager;", "getToast", "()Lcom/tencent/tkd/topicsdk/interfaces/IToast;", "getUploader", "()Lcom/tencent/tkd/topicsdk/interfaces/BaseUploader;", "getUserActionHandler", "()Lcom/tencent/tkd/topicsdk/interfaces/IUserActionHandler;", "getVideoCompressor", "()Lcom/tencent/tkd/topicsdk/interfaces/IVideoCompressor;", "getViewPage", "()Lcom/tencent/tkd/topicsdk/interfaces/IViewPager;", "getWebViewOpener", "()Lcom/tencent/tkd/topicsdk/interfaces/IWebViewOpener;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "release", "", "toString", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class TopicSDKConfig
{
  @NotNull
  private final Context a;
  @NotNull
  private final IBizConfig b;
  @NotNull
  private final IPageOpener c;
  @NotNull
  private final ILogger d;
  @NotNull
  private final IAccount e;
  @NotNull
  private final IDataReporter f;
  @NotNull
  private final IDataTransfer g;
  @NotNull
  private final IUserActionHandler h;
  @NotNull
  private final IThreadManager i;
  @NotNull
  private final ITheme j;
  @NotNull
  private final IToast k;
  @NotNull
  private final IPermission l;
  @NotNull
  private final IWebViewOpener m;
  @NotNull
  private final IImageLoader n;
  @NotNull
  private final BaseUploader o;
  @NotNull
  private final IViewPager p;
  @NotNull
  private final IFloatViewManager q;
  @NotNull
  private final IStorageConfig r;
  @NotNull
  private final IEmoJiEmotion s;
  private final boolean t;
  @NotNull
  private final IVideoCompressor u;
  @NotNull
  private final IPkgManager v;
  @NotNull
  private final Class<? extends IDialogBuilder> w;
  @NotNull
  private final IPublishManager x;
  
  public TopicSDKConfig(@NotNull Context paramContext, @NotNull IBizConfig paramIBizConfig, @NotNull IPageOpener paramIPageOpener, @NotNull ILogger paramILogger, @NotNull IAccount paramIAccount, @NotNull IDataReporter paramIDataReporter, @NotNull IDataTransfer paramIDataTransfer, @NotNull IUserActionHandler paramIUserActionHandler, @NotNull IThreadManager paramIThreadManager, @NotNull ITheme paramITheme, @NotNull IToast paramIToast, @NotNull IPermission paramIPermission, @NotNull IWebViewOpener paramIWebViewOpener, @NotNull IImageLoader paramIImageLoader, @NotNull BaseUploader paramBaseUploader, @NotNull IViewPager paramIViewPager, @NotNull IFloatViewManager paramIFloatViewManager, @NotNull IStorageConfig paramIStorageConfig, @NotNull IEmoJiEmotion paramIEmoJiEmotion, boolean paramBoolean, @NotNull IVideoCompressor paramIVideoCompressor, @NotNull IPkgManager paramIPkgManager, @NotNull Class<? extends IDialogBuilder> paramClass, @NotNull IPublishManager paramIPublishManager)
  {
    this.a = paramContext;
    this.b = paramIBizConfig;
    this.c = paramIPageOpener;
    this.d = paramILogger;
    this.e = paramIAccount;
    this.f = paramIDataReporter;
    this.g = paramIDataTransfer;
    this.h = paramIUserActionHandler;
    this.i = paramIThreadManager;
    this.j = paramITheme;
    this.k = paramIToast;
    this.l = paramIPermission;
    this.m = paramIWebViewOpener;
    this.n = paramIImageLoader;
    this.o = paramBaseUploader;
    this.p = paramIViewPager;
    this.q = paramIFloatViewManager;
    this.r = paramIStorageConfig;
    this.s = paramIEmoJiEmotion;
    this.t = paramBoolean;
    this.u = paramIVideoCompressor;
    this.v = paramIPkgManager;
    this.w = paramClass;
    this.x = paramIPublishManager;
  }
  
  public final void a()
  {
    this.h.a();
    this.g.a();
    this.p.a();
  }
  
  @NotNull
  public final Context b()
  {
    return this.a;
  }
  
  @NotNull
  public final IBizConfig c()
  {
    return this.b;
  }
  
  @NotNull
  public final IPageOpener d()
  {
    return this.c;
  }
  
  @NotNull
  public final ILogger e()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TopicSDKConfig))
      {
        paramObject = (TopicSDKConfig)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (Intrinsics.areEqual(this.e, paramObject.e)) && (Intrinsics.areEqual(this.f, paramObject.f)) && (Intrinsics.areEqual(this.g, paramObject.g)) && (Intrinsics.areEqual(this.h, paramObject.h)) && (Intrinsics.areEqual(this.i, paramObject.i)) && (Intrinsics.areEqual(this.j, paramObject.j)) && (Intrinsics.areEqual(this.k, paramObject.k)) && (Intrinsics.areEqual(this.l, paramObject.l)) && (Intrinsics.areEqual(this.m, paramObject.m)) && (Intrinsics.areEqual(this.n, paramObject.n)) && (Intrinsics.areEqual(this.o, paramObject.o)) && (Intrinsics.areEqual(this.p, paramObject.p)) && (Intrinsics.areEqual(this.q, paramObject.q)) && (Intrinsics.areEqual(this.r, paramObject.r)) && (Intrinsics.areEqual(this.s, paramObject.s)) && (this.t == paramObject.t) && (Intrinsics.areEqual(this.u, paramObject.u)) && (Intrinsics.areEqual(this.v, paramObject.v)) && (Intrinsics.areEqual(this.w, paramObject.w)) && (Intrinsics.areEqual(this.x, paramObject.x))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final IAccount f()
  {
    return this.e;
  }
  
  @NotNull
  public final IDataTransfer g()
  {
    return this.g;
  }
  
  @NotNull
  public final IUserActionHandler h()
  {
    return this.h;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public final IThreadManager i()
  {
    return this.i;
  }
  
  @NotNull
  public final ITheme j()
  {
    return this.j;
  }
  
  @NotNull
  public final IToast k()
  {
    return this.k;
  }
  
  @NotNull
  public final IPermission l()
  {
    return this.l;
  }
  
  @NotNull
  public final IWebViewOpener m()
  {
    return this.m;
  }
  
  @NotNull
  public final IImageLoader n()
  {
    return this.n;
  }
  
  @NotNull
  public final BaseUploader o()
  {
    return this.o;
  }
  
  @NotNull
  public final IViewPager p()
  {
    return this.p;
  }
  
  @NotNull
  public final IStorageConfig q()
  {
    return this.r;
  }
  
  @NotNull
  public final IEmoJiEmotion r()
  {
    return this.s;
  }
  
  public final boolean s()
  {
    return this.t;
  }
  
  @NotNull
  public final IVideoCompressor t()
  {
    return this.u;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TopicSDKConfig(context=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", bizConfig=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", pageOpener=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", logger=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", account=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", dataReporter=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", dataTransfer=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", userActionHandler=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", threadManager=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", theme=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", toast=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", permission=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", webViewOpener=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", imageLoader=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", uploader=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", viewPage=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", floatViewManager=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", storageConfig=");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", emoJiEmotion=");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", isDebug=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", videoCompressor=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", pkgManager=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(", dialogBuilder=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", publishManager=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  @NotNull
  public final IPublishManager u()
  {
    return this.x;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.TopicSDKConfig
 * JD-Core Version:    0.7.0.1
 */