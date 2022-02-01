package com.tencent.rmonitor.base.reporter.batch;

import android.content.Context;
import android.os.Handler;
import com.tencent.rmonitor.base.config.PluginCombination;
import com.tencent.rmonitor.base.config.PluginCombination.Companion;
import com.tencent.rmonitor.base.db.BaseTable;
import com.tencent.rmonitor.base.db.DBHandler;
import com.tencent.rmonitor.base.db.DBHelper;
import com.tencent.rmonitor.base.db.table.DropFrameTable;
import com.tencent.rmonitor.base.db.table.ReportDataTable;
import com.tencent.rmonitor.base.db.table.ReportDataTable.Companion;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.reporter.IReporter;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.network.NetworkWatcher;
import com.tencent.rmonitor.common.util.AppInfo;
import com.tencent.rmonitor.common.util.AppInfo.Companion;
import com.tencent.rmonitor.common.util.AsyncSPEditor;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/batch/CollectRecordDataRunnable;", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "reporter", "Lcom/tencent/rmonitor/base/reporter/IReporter;", "(Landroid/os/Handler;Lcom/tencent/rmonitor/base/reporter/IReporter;)V", "fileQueue", "Ljava/util/Queue;", "", "hasScanFile", "", "listIndex", "", "reportDataList", "Ljava/util/ArrayList;", "Lcom/tencent/rmonitor/base/reporter/data/ReportData;", "Lkotlin/collections/ArrayList;", "searchFileList", "Ljava/io/File;", "getSearchFileList", "()Ljava/util/ArrayList;", "searchFileList$delegate", "Lkotlin/Lazy;", "collectDbDataAndDeleteFile", "", "deleteFile", "getDropFrameData", "reportDbData", "objects", "", "run", "scanFile", "file", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class CollectRecordDataRunnable
  implements Runnable
{
  public static final CollectRecordDataRunnable.Companion b = new CollectRecordDataRunnable.Companion(null);
  private ArrayList<ReportData> c;
  private Queue<String> d;
  private boolean e;
  private int f;
  private final Lazy g;
  private final Handler h;
  private final IReporter i;
  
  public CollectRecordDataRunnable(@Nullable Handler paramHandler, @NotNull IReporter paramIReporter)
  {
    this.h = paramHandler;
    this.i = paramIReporter;
    this.d = ((Queue)new ConcurrentLinkedQueue());
    this.g = LazyKt.lazy((Function0)CollectRecordDataRunnable.searchFileList.2.INSTANCE);
  }
  
  private final void a(File paramFile)
  {
    paramFile = paramFile.listFiles();
    if (paramFile != null)
    {
      Object localObject1 = (Collection)new ArrayList();
      int n = paramFile.length;
      int j = 0;
      Object localObject2;
      Object localObject3;
      for (;;)
      {
        int m = 1;
        if (j >= n) {
          break;
        }
        localObject2 = paramFile[j];
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
        localObject3 = ((File)localObject2).getPath();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "it.path");
        int k = m;
        if (!StringsKt.contains$default((CharSequence)localObject3, (CharSequence)".txt", false, 2, null))
        {
          localObject3 = ((File)localObject2).getPath();
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "it.path");
          if (StringsKt.contains$default((CharSequence)localObject3, (CharSequence)".zip", false, 2, null)) {
            k = m;
          } else {
            k = 0;
          }
        }
        if (k != 0) {
          ((Collection)localObject1).add(localObject2);
        }
        j += 1;
      }
      paramFile = ((Iterable)localObject1).iterator();
      while (paramFile.hasNext())
      {
        localObject1 = (File)paramFile.next();
        try
        {
          localObject2 = this.d;
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "it");
          ((Queue)localObject2).add(((File)localObject1).getPath());
        }
        catch (Exception localException)
        {
          localObject3 = Logger.b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localException);
          localStringBuilder.append(": add file path: ");
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "it");
          localStringBuilder.append(((File)localObject1).getPath());
          localStringBuilder.append(" error. ");
          ((Logger)localObject3).e(new String[] { "RMonitor_base_CollectRecordDataRunnable", localStringBuilder.toString() });
        }
      }
    }
  }
  
  private final void a(List<ReportData> paramList)
  {
    this.f += 1;
    if (this.f <= paramList.size())
    {
      paramList = (ReportData)paramList.get(this.f - 1);
      int j = paramList.getPlugin();
      if (j != 105)
      {
        if (j == 106) {
          paramList.setEventName("IO single");
        }
      }
      else {
        paramList.setEventName("DB single");
      }
      this.i.a(paramList, null);
      paramList = this.h;
      if (paramList != null) {
        paramList.postDelayed((Runnable)this, 500L);
      }
    }
    else
    {
      Object localObject = BaseInfo.dbHelper;
      if (localObject != null)
      {
        localObject = ((DBHelper)localObject).a();
        if (localObject != null) {
          ((DBHandler)localObject).a(ReportDataTable.b.a(), true);
        }
      }
      paramList.clear();
      this.f = 0;
      PluginCombination.a.a((Function1)CollectRecordDataRunnable.reportDbData.1.INSTANCE);
      BaseInfo.editor.b();
      paramList = this.h;
      if (paramList != null) {
        paramList.postDelayed((Runnable)this, 7200000L);
      }
    }
  }
  
  private final ArrayList<File> b()
  {
    Lazy localLazy = this.g;
    KProperty localKProperty = a[0];
    return (ArrayList)localLazy.getValue();
  }
  
  private final void c()
  {
    Iterator localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      File localFile = (File)localIterator.next();
      if (localFile.exists())
      {
        Intrinsics.checkExpressionValueIsNotNull(localFile, "file");
        if (localFile.isDirectory()) {
          a(localFile);
        }
      }
    }
    this.e = true;
  }
  
  private final void d()
  {
    Object localObject2 = (Iterable)this.d;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (new File((String)localObject3).isFile()) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      try
      {
        new File((String)localObject2).delete();
      }
      catch (Exception localException)
      {
        Logger localLogger = Logger.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localException);
        localStringBuilder.append(": delete file: ");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(" error.");
        localLogger.e(new String[] { "RMonitor_base_CollectRecordDataRunnable", localStringBuilder.toString() });
      }
    }
    this.d.clear();
  }
  
  private final void e()
  {
    Object localObject1 = new ReportDataTable(BaseInfo.userMeta.appId, AppInfo.a.a((Context)BaseInfo.app), BaseInfo.userMeta.version);
    Object localObject2 = BaseInfo.dbHelper;
    Object localObject3 = null;
    if (localObject2 != null)
    {
      localObject2 = ((DBHelper)localObject2).a();
      if (localObject2 != null)
      {
        localObject1 = ((DBHandler)localObject2).b((BaseTable)localObject1, (Function0)CollectRecordDataRunnable.collectDbDataAndDeleteFile.1.INSTANCE);
        break label71;
      }
    }
    localObject1 = null;
    label71:
    localObject2 = localObject1;
    if (!(localObject1 instanceof ArrayList)) {
      localObject2 = null;
    }
    this.c = ((ArrayList)localObject2);
    localObject1 = a();
    if (localObject1 != null)
    {
      localObject2 = this.c;
      if (localObject2 != null) {
        ((ArrayList)localObject2).add(localObject1);
      }
    }
    localObject2 = this.c;
    localObject1 = localObject3;
    if (localObject2 != null) {
      if (((ArrayList)localObject2).isEmpty())
      {
        localObject1 = localObject3;
      }
      else
      {
        localObject1 = this.h;
        if (localObject1 != null) {
          ((Handler)localObject1).postDelayed((Runnable)this, 500L);
        }
        localObject1 = Boolean.valueOf(true);
      }
    }
    if (localObject1 == null)
    {
      d();
      localObject1 = this.h;
      if (localObject1 != null) {
        ((Handler)localObject1).postDelayed((Runnable)this, 7200000L);
      }
    }
  }
  
  @Nullable
  public final ReportData a()
  {
    JSONObject localJSONObject = null;
    ReportData localReportData = (ReportData)null;
    DropFrameTable localDropFrameTable = new DropFrameTable(BaseInfo.userMeta.appId, AppInfo.a.a((Context)BaseInfo.app), BaseInfo.userMeta.version, 0L, 0L, 24, null);
    Object localObject = BaseInfo.dbHelper;
    if (localObject != null)
    {
      localObject = ((DBHelper)localObject).a();
      if (localObject != null)
      {
        localObject = ((DBHandler)localObject).b((BaseTable)localDropFrameTable, (Function0)CollectRecordDataRunnable.getDropFrameData.dropFrameMap.1.INSTANCE);
        break label83;
      }
    }
    localObject = null;
    label83:
    if (!(localObject instanceof HashMap)) {
      localObject = localJSONObject;
    }
    localObject = (HashMap)localObject;
    if ((localObject != null) && (((HashMap)localObject).size() > 0))
    {
      localObject = localDropFrameTable.a((HashMap)localObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("dropFrame", localObject);
      localJSONObject.put("plugin", 101);
      return new ReportData(0, "Dropframe target", true, 1L, 1L, localJSONObject, false, true, BaseInfo.userMeta.uin);
    }
    return localReportData;
  }
  
  public void run()
  {
    Logger.b.d(new String[] { "RMonitor_base_CollectRecordDataRunnable", "run" });
    if (!this.e) {
      c();
    }
    boolean bool = PluginController.b.f();
    Object localObject = null;
    if (bool)
    {
      localObject = BaseInfo.dbHelper;
      if (localObject != null)
      {
        localObject = ((DBHelper)localObject).a();
        if (localObject != null) {
          ((DBHandler)localObject).a(ReportDataTable.b.a(), null, null);
        }
      }
      BaseInfo.editor.a("count_today_austerity_reported", PluginController.b.b()).b();
      return;
    }
    if (!NetworkWatcher.a.b())
    {
      localObject = this.h;
      if (localObject != null) {
        ((Handler)localObject).postDelayed((Runnable)this, 7200000L);
      }
    }
    else
    {
      ArrayList localArrayList = this.c;
      if (localArrayList != null)
      {
        if ((true ^ ((Collection)localArrayList).isEmpty()))
        {
          a((List)localArrayList);
          localObject = Unit.INSTANCE;
        }
        if (localObject != null) {
          return;
        }
      }
      e();
      localObject = Unit.INSTANCE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.batch.CollectRecordDataRunnable
 * JD-Core Version:    0.7.0.1
 */