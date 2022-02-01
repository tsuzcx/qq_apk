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
  private final Context jdField_a_of_type_AndroidContentContext;
  @NotNull
  private final BaseUploader jdField_a_of_type_ComTencentTkdTopicsdkInterfacesBaseUploader;
  @NotNull
  private final IAccount jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIAccount;
  @NotNull
  private final IBizConfig jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIBizConfig;
  @NotNull
  private final IDataReporter jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataReporter;
  @NotNull
  private final IDataTransfer jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer;
  @NotNull
  private final IEmoJiEmotion jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIEmoJiEmotion;
  @NotNull
  private final IFloatViewManager jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIFloatViewManager;
  @NotNull
  private final IImageLoader jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader;
  @NotNull
  private final ILogger jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger;
  @NotNull
  private final IPageOpener jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPageOpener;
  @NotNull
  private final IPermission jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPermission;
  @NotNull
  private final IPkgManager jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPkgManager;
  @NotNull
  private final IPublishManager jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPublishManager;
  @NotNull
  private final IStorageConfig jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIStorageConfig;
  @NotNull
  private final ITheme jdField_a_of_type_ComTencentTkdTopicsdkInterfacesITheme;
  @NotNull
  private final IThreadManager jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIThreadManager;
  @NotNull
  private final IToast jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIToast;
  @NotNull
  private final IUserActionHandler jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIUserActionHandler;
  @NotNull
  private final IVideoCompressor jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIVideoCompressor;
  @NotNull
  private final IViewPager jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIViewPager;
  @NotNull
  private final IWebViewOpener jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIWebViewOpener;
  @NotNull
  private final Class<? extends IDialogBuilder> jdField_a_of_type_JavaLangClass;
  private final boolean jdField_a_of_type_Boolean;
  
  public TopicSDKConfig(@NotNull Context paramContext, @NotNull IBizConfig paramIBizConfig, @NotNull IPageOpener paramIPageOpener, @NotNull ILogger paramILogger, @NotNull IAccount paramIAccount, @NotNull IDataReporter paramIDataReporter, @NotNull IDataTransfer paramIDataTransfer, @NotNull IUserActionHandler paramIUserActionHandler, @NotNull IThreadManager paramIThreadManager, @NotNull ITheme paramITheme, @NotNull IToast paramIToast, @NotNull IPermission paramIPermission, @NotNull IWebViewOpener paramIWebViewOpener, @NotNull IImageLoader paramIImageLoader, @NotNull BaseUploader paramBaseUploader, @NotNull IViewPager paramIViewPager, @NotNull IFloatViewManager paramIFloatViewManager, @NotNull IStorageConfig paramIStorageConfig, @NotNull IEmoJiEmotion paramIEmoJiEmotion, boolean paramBoolean, @NotNull IVideoCompressor paramIVideoCompressor, @NotNull IPkgManager paramIPkgManager, @NotNull Class<? extends IDialogBuilder> paramClass, @NotNull IPublishManager paramIPublishManager)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIBizConfig = paramIBizConfig;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPageOpener = paramIPageOpener;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger = paramILogger;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIAccount = paramIAccount;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataReporter = paramIDataReporter;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer = paramIDataTransfer;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIUserActionHandler = paramIUserActionHandler;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIThreadManager = paramIThreadManager;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesITheme = paramITheme;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIToast = paramIToast;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPermission = paramIPermission;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIWebViewOpener = paramIWebViewOpener;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader = paramIImageLoader;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesBaseUploader = paramBaseUploader;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIViewPager = paramIViewPager;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIFloatViewManager = paramIFloatViewManager;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIStorageConfig = paramIStorageConfig;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIEmoJiEmotion = paramIEmoJiEmotion;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIVideoCompressor = paramIVideoCompressor;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPkgManager = paramIPkgManager;
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPublishManager = paramIPublishManager;
  }
  
  @NotNull
  public final Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  @NotNull
  public final BaseUploader a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesBaseUploader;
  }
  
  @NotNull
  public final IAccount a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIAccount;
  }
  
  @NotNull
  public final IBizConfig a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIBizConfig;
  }
  
  @NotNull
  public final IDataTransfer a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer;
  }
  
  @NotNull
  public final IEmoJiEmotion a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIEmoJiEmotion;
  }
  
  @NotNull
  public final IImageLoader a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader;
  }
  
  @NotNull
  public final ILogger a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger;
  }
  
  @NotNull
  public final IPageOpener a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPageOpener;
  }
  
  @NotNull
  public final IPermission a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPermission;
  }
  
  @NotNull
  public final IPublishManager a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPublishManager;
  }
  
  @NotNull
  public final IStorageConfig a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIStorageConfig;
  }
  
  @NotNull
  public final ITheme a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesITheme;
  }
  
  @NotNull
  public final IThreadManager a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIThreadManager;
  }
  
  @NotNull
  public final IToast a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIToast;
  }
  
  @NotNull
  public final IUserActionHandler a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIUserActionHandler;
  }
  
  @NotNull
  public final IVideoCompressor a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIVideoCompressor;
  }
  
  @NotNull
  public final IViewPager a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIViewPager;
  }
  
  @NotNull
  public final IWebViewOpener a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIWebViewOpener;
  }
  
  public final void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIUserActionHandler.a();
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer.a();
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIViewPager.a();
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TopicSDKConfig))
      {
        paramObject = (TopicSDKConfig)paramObject;
        if ((Intrinsics.areEqual(this.jdField_a_of_type_AndroidContentContext, paramObject.jdField_a_of_type_AndroidContentContext)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIBizConfig, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIBizConfig)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPageOpener, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPageOpener)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIAccount, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIAccount)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataReporter, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataReporter)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIUserActionHandler, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIUserActionHandler)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIThreadManager, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIThreadManager)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesITheme, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesITheme)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIToast, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIToast)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPermission, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPermission)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIWebViewOpener, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIWebViewOpener)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesBaseUploader, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesBaseUploader)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIViewPager, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIViewPager)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIFloatViewManager, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIFloatViewManager)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIStorageConfig, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIStorageConfig)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIEmoJiEmotion, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIEmoJiEmotion)) && (this.jdField_a_of_type_Boolean == paramObject.jdField_a_of_type_Boolean) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIVideoCompressor, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIVideoCompressor)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPkgManager, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPkgManager)) && (Intrinsics.areEqual(this.jdField_a_of_type_JavaLangClass, paramObject.jdField_a_of_type_JavaLangClass)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPublishManager, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPublishManager))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TopicSDKConfig(context=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext);
    localStringBuilder.append(", bizConfig=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIBizConfig);
    localStringBuilder.append(", pageOpener=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPageOpener);
    localStringBuilder.append(", logger=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger);
    localStringBuilder.append(", account=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIAccount);
    localStringBuilder.append(", dataReporter=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataReporter);
    localStringBuilder.append(", dataTransfer=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIDataTransfer);
    localStringBuilder.append(", userActionHandler=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIUserActionHandler);
    localStringBuilder.append(", threadManager=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIThreadManager);
    localStringBuilder.append(", theme=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesITheme);
    localStringBuilder.append(", toast=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIToast);
    localStringBuilder.append(", permission=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPermission);
    localStringBuilder.append(", webViewOpener=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIWebViewOpener);
    localStringBuilder.append(", imageLoader=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader);
    localStringBuilder.append(", uploader=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesBaseUploader);
    localStringBuilder.append(", viewPage=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIViewPager);
    localStringBuilder.append(", floatViewManager=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIFloatViewManager);
    localStringBuilder.append(", storageConfig=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIStorageConfig);
    localStringBuilder.append(", emoJiEmotion=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIEmoJiEmotion);
    localStringBuilder.append(", isDebug=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", videoCompressor=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIVideoCompressor);
    localStringBuilder.append(", pkgManager=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPkgManager);
    localStringBuilder.append(", dialogBuilder=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangClass);
    localStringBuilder.append(", publishManager=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPublishManager);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.TopicSDKConfig
 * JD-Core Version:    0.7.0.1
 */