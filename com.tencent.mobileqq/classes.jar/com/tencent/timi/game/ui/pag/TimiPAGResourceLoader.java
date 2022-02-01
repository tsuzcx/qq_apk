package com.tencent.timi.game.ui.pag;

import com.tencent.timi.game.initer.api.IniterService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.sp.TGSharedPreferenceUtil;
import com.tencent.timi.game.utils.Logger;
import com.yolo.esports.download.IDownloadService;
import com.yolo.esports.download.cb.DownloadTaskListener;
import com.yolo.esports.download.common.DownloadInfo;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/pag/TimiPAGResourceLoader;", "", "()V", "ABS_SP_PREFIX", "", "PAGResourceLoadListenerList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/timi/game/ui/pag/TimiPAGResourceLoader$IPAGResourceLoadListener;", "TAG", "absFilePathMap", "", "downloadService", "Lcom/yolo/esports/download/IDownloadService;", "downloadTaskListener", "com/tencent/timi/game/ui/pag/TimiPAGResourceLoader$downloadTaskListener$1", "Lcom/tencent/timi/game/ui/pag/TimiPAGResourceLoader$downloadTaskListener$1;", "initerService", "Lcom/tencent/timi/game/initer/api/IniterService;", "kotlin.jvm.PlatformType", "getIniterService", "()Lcom/tencent/timi/game/initer/api/IniterService;", "addPAGResourceLoadListener", "", "listener", "destroy", "getPAGFile", "Lorg/libpag/PAGFile;", "PAGUrl", "PAGSaveFileName", "getSaveFileName", "getSaveUrl", "handleDownloadSuccess", "taskInfo", "Lcom/yolo/esports/download/common/DownloadInfo;", "init", "notifyListeners", "tag", "pagFile", "removePAGResourceLoadListener", "triggerResourceDownload", "IPAGResourceLoadListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiPAGResourceLoader
{
  public static final TimiPAGResourceLoader a = new TimiPAGResourceLoader();
  private static final Map<String, String> b = (Map)new LinkedHashMap();
  private static final TimiPAGResourceLoader.downloadTaskListener.1 c = new TimiPAGResourceLoader.downloadTaskListener.1();
  private static final CopyOnWriteArrayList<TimiPAGResourceLoader.IPAGResourceLoadListener> d = new CopyOnWriteArrayList();
  private static IDownloadService e;
  
  private final String a(String paramString)
  {
    Object localObject = paramString;
    if (!StringsKt.startsWith$default(paramString, "http://", false, 2, null))
    {
      if (StringsKt.startsWith$default(paramString, "https://", false, 2, null)) {
        return paramString;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private final void a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      if (paramDownloadInfo.c() != true) {
        return;
      }
      Object localObject1 = paramDownloadInfo.e;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("PAG file download success # ");
      ((StringBuilder)localObject2).append((String)localObject1);
      Logger.c("TimiPAGResourceLoader_", ((StringBuilder)localObject2).toString());
      localObject2 = b;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("TG_PAG_");
      ((StringBuilder)localObject3).append(paramDownloadInfo.b);
      localObject3 = ((StringBuilder)localObject3).toString();
      String str = paramDownloadInfo.e;
      Intrinsics.checkExpressionValueIsNotNull(str, "taskInfo.fileAbsPath");
      ((Map)localObject2).put(localObject3, str);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("TG_PAG_");
      ((StringBuilder)localObject2).append(paramDownloadInfo.b);
      TGSharedPreferenceUtil.a(((StringBuilder)localObject2).toString(), (String)localObject1);
      localObject1 = b();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "initerService");
      if (((IniterService)localObject1).c())
      {
        localObject1 = paramDownloadInfo.r;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "taskInfo.extraInfo");
        paramDownloadInfo = PAGFile.Load(paramDownloadInfo.e);
        Intrinsics.checkExpressionValueIsNotNull(paramDownloadInfo, "PAGFile.Load(taskInfo.fileAbsPath)");
        a((String)localObject1, paramDownloadInfo);
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Download URL: ");
      ((StringBuilder)localObject1).append(paramDownloadInfo.r);
      ((StringBuilder)localObject1).append(" PAG Library not ready");
      Logger.c("TimiPAGResourceLoader_", ((StringBuilder)localObject1).toString());
    }
  }
  
  private final void a(String paramString1, String paramString2, String paramString3)
  {
    DownloadInfo localDownloadInfo2 = ((IDownloadService)ServiceCenter.a(IDownloadService.class)).a(paramString2);
    DownloadInfo localDownloadInfo1 = localDownloadInfo2;
    if (localDownloadInfo2 == null)
    {
      localDownloadInfo1 = new DownloadInfo();
      localDownloadInfo1.c = paramString3;
      localDownloadInfo1.b = paramString2;
      localDownloadInfo1.r = paramString1;
    }
    if (((IDownloadService)ServiceCenter.a(IDownloadService.class)).a(localDownloadInfo1) == -102) {
      a(localDownloadInfo1);
    }
  }
  
  private final void a(String paramString, PAGFile paramPAGFile)
  {
    Iterator localIterator = ((Iterable)d).iterator();
    while (localIterator.hasNext()) {
      ((TimiPAGResourceLoader.IPAGResourceLoadListener)localIterator.next()).a(paramString, paramPAGFile);
    }
  }
  
  private final IniterService b()
  {
    return (IniterService)ServiceCenter.a(IniterService.class);
  }
  
  private final String b(String paramString)
  {
    paramString = (CharSequence)paramString;
    int j = 1;
    paramString = StringsKt.split$default(paramString, new String[] { "/" }, false, 0, 6, null);
    Collection localCollection = (Collection)paramString;
    int i = j;
    if (localCollection != null) {
      if (localCollection.isEmpty()) {
        i = j;
      } else {
        i = 0;
      }
    }
    if (i != 0) {
      return null;
    }
    return (String)CollectionsKt.last(paramString);
  }
  
  @Nullable
  public final PAGFile a(@NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "PAGUrl");
    String str = a(paramString1);
    Object localObject1 = b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("TG_PAG_");
    ((StringBuilder)localObject2).append(str);
    localObject1 = (String)((Map)localObject1).get(((StringBuilder)localObject2).toString());
    localObject2 = (CharSequence)localObject1;
    int j = 0;
    int i;
    if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TG_PAG_");
      ((StringBuilder)localObject1).append(str);
      localObject1 = TGSharedPreferenceUtil.b(((StringBuilder)localObject1).toString(), "");
    }
    if (paramString2 == null) {
      paramString2 = b(str);
    }
    localObject2 = (CharSequence)localObject1;
    if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      localObject1 = (CharSequence)paramString2;
      if (localObject1 != null)
      {
        i = j;
        if (((CharSequence)localObject1).length() != 0) {}
      }
      else
      {
        i = 1;
      }
      if (i != 0)
      {
        Logger.c("TimiPAGResourceLoader_", "error save name");
        return null;
      }
      a(paramString1, str, paramString2);
      return null;
    }
    localObject1 = new File((String)localObject1);
    if (((File)localObject1).exists())
    {
      localObject2 = b();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "initerService");
      if (((IniterService)localObject2).c()) {
        return PAGFile.Load(((File)localObject1).getAbsolutePath());
      }
    }
    if (paramString2 == null)
    {
      Logger.c("TimiPAGResourceLoader_", "error save name");
      return null;
    }
    a(paramString1, str, paramString2);
    return null;
  }
  
  public final void a()
  {
    b.clear();
    IDownloadService localIDownloadService = e;
    if (localIDownloadService != null) {
      localIDownloadService.b((DownloadTaskListener)c);
    }
    e = (IDownloadService)null;
  }
  
  public final void a(@NotNull TimiPAGResourceLoader.IPAGResourceLoadListener paramIPAGResourceLoadListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIPAGResourceLoadListener, "listener");
    d.remove(paramIPAGResourceLoadListener);
    d.add(paramIPAGResourceLoadListener);
  }
  
  public final void a(@NotNull IDownloadService paramIDownloadService)
  {
    Intrinsics.checkParameterIsNotNull(paramIDownloadService, "downloadService");
    e = paramIDownloadService;
    paramIDownloadService.a((DownloadTaskListener)c);
  }
  
  public final void b(@NotNull TimiPAGResourceLoader.IPAGResourceLoadListener paramIPAGResourceLoadListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIPAGResourceLoadListener, "listener");
    d.remove(paramIPAGResourceLoadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.pag.TimiPAGResourceLoader
 * JD-Core Version:    0.7.0.1
 */