package com.tencent.qapmsdk.base.reporter.uploaddata.runnable;

import android.content.Context;
import android.os.Handler;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.config.PluginCombination.Companion;
import com.tencent.qapmsdk.base.config.SDKConfig;
import com.tencent.qapmsdk.base.config.SDKConfig.Companion;
import com.tencent.qapmsdk.base.dbpersist.BaseTable;
import com.tencent.qapmsdk.base.dbpersist.DBHandler;
import com.tencent.qapmsdk.base.dbpersist.DBHelper;
import com.tencent.qapmsdk.base.dbpersist.table.DropFrameTable;
import com.tencent.qapmsdk.base.dbpersist.table.ResultObjectsTable;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.AppInfo.Companion;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/uploaddata/runnable/CollectRecordDataRunnable;", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "reporterMachine", "Lcom/tencent/qapmsdk/base/reporter/ReporterMachine;", "(Landroid/os/Handler;Lcom/tencent/qapmsdk/base/reporter/ReporterMachine;)V", "fileQueue", "Ljava/util/Queue;", "", "hasScanFile", "", "listIndex", "", "resultObjects", "Ljava/util/ArrayList;", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;", "Lkotlin/collections/ArrayList;", "searchFileList", "Ljava/io/File;", "getSearchFileList", "()Ljava/util/ArrayList;", "searchFileList$delegate", "Lkotlin/Lazy;", "collectDbDataAndDeleteFile", "", "deleteFile", "reportDbData", "objects", "", "run", "scanFile", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class CollectRecordDataRunnable
  implements Runnable
{
  public static final CollectRecordDataRunnable.Companion Companion = new CollectRecordDataRunnable.Companion(null);
  private static final long DELAY_NEXT_ITEM = 500L;
  private static final long DELAY_NEXT_TRY = 7200000L;
  private static final String TAG = "QAPM_base_CollectRecordDataRunnable";
  private Queue<String> fileQueue;
  private final Handler handler;
  private boolean hasScanFile;
  private int listIndex;
  private final ReporterMachine reporterMachine;
  private ArrayList<ResultObject> resultObjects;
  private final Lazy searchFileList$delegate;
  
  public CollectRecordDataRunnable(@Nullable Handler paramHandler, @NotNull ReporterMachine paramReporterMachine)
  {
    this.handler = paramHandler;
    this.reporterMachine = paramReporterMachine;
    this.fileQueue = ((Queue)new ConcurrentLinkedQueue());
    this.searchFileList$delegate = LazyKt.lazy((Function0)CollectRecordDataRunnable.searchFileList.2.INSTANCE);
  }
  
  private final void collectDbDataAndDeleteFile()
  {
    Object localObject1 = new ResultObjectsTable(BaseInfo.userMeta.appId, AppInfo.Companion.obtainProcessName((Context)BaseInfo.app), BaseInfo.userMeta.version);
    Object localObject2 = BaseInfo.dbHelper;
    if (localObject2 != null)
    {
      localObject2 = ((DBHelper)localObject2).getDbHandler();
      if (localObject2 != null)
      {
        localObject1 = ((DBHandler)localObject2).search((BaseTable)localObject1, (Function0)CollectRecordDataRunnable.collectDbDataAndDeleteFile.1.INSTANCE);
        localObject2 = localObject1;
        if (!(localObject1 instanceof ArrayList)) {
          localObject2 = null;
        }
        this.resultObjects = ((ArrayList)localObject2);
        DropFrameTable localDropFrameTable = new DropFrameTable(BaseInfo.userMeta.appId, AppInfo.Companion.obtainProcessName((Context)BaseInfo.app), BaseInfo.userMeta.version, 0L, 0L, 24, null);
        localObject1 = BaseInfo.dbHelper;
        if (localObject1 == null) {
          break label303;
        }
        localObject1 = ((DBHelper)localObject1).getDbHandler();
        if (localObject1 == null) {
          break label303;
        }
        localObject1 = ((DBHandler)localObject1).search((BaseTable)localDropFrameTable, (Function0)CollectRecordDataRunnable.collectDbDataAndDeleteFile.dropFrameMap.1.INSTANCE);
        label152:
        localObject2 = localObject1;
        if (!(localObject1 instanceof HashMap)) {
          localObject2 = null;
        }
        localObject1 = (HashMap)localObject2;
        if ((localObject1 != null) && (((HashMap)localObject1).size() > 0))
        {
          localObject2 = localDropFrameTable.buildDropFrameJson((HashMap)localObject1);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("dropFrame", localObject2);
          ((JSONObject)localObject1).put("plugin", PluginCombination.dropFramePlugin.plugin);
          localObject2 = this.resultObjects;
          if (localObject2 != null) {
            ((ArrayList)localObject2).add(new ResultObject(0, "Dropframe target", true, 1L, 1L, (JSONObject)localObject1, false, true, BaseInfo.userMeta.uin));
          }
        }
        localObject1 = this.resultObjects;
        if (localObject1 == null) {
          break label337;
        }
        if (!((ArrayList)localObject1).isEmpty()) {
          break label308;
        }
        localObject1 = null;
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        deleteFile();
        localObject1 = this.handler;
        if (localObject1 != null) {
          ((Handler)localObject1).postDelayed((Runnable)this, 7200000L);
        }
      }
      return;
      localObject1 = null;
      break;
      label303:
      localObject1 = null;
      break label152;
      label308:
      localObject1 = this.handler;
      if (localObject1 != null) {
        ((Handler)localObject1).postDelayed((Runnable)this, 500L);
      }
      localObject1 = Boolean.valueOf(true);
      continue;
      label337:
      localObject1 = null;
    }
  }
  
  private final void deleteFile()
  {
    Object localObject2 = (Iterable)this.fileQueue;
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
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        try
        {
          new File((String)localObject2).delete();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Logger.INSTANCE.e(new String[] { "QAPM_base_CollectRecordDataRunnable", localException + ": delete file: " + (String)localObject2 + " error." });
          }
        }
      }
    }
    this.fileQueue.clear();
  }
  
  private final ArrayList<File> getSearchFileList()
  {
    Lazy localLazy = this.searchFileList$delegate;
    KProperty localKProperty = $$delegatedProperties[0];
    return (ArrayList)localLazy.getValue();
  }
  
  private final void reportDbData(List<ResultObject> paramList)
  {
    this.listIndex += 1;
    if (this.listIndex <= paramList.size())
    {
      paramList = (ResultObject)paramList.get(this.listIndex - 1);
      switch (paramList.getParams().getInt("plugin"))
      {
      default: 
        this.reporterMachine.reportOnce(paramList, null);
        paramList = this.handler;
        if (paramList != null) {
          paramList.postDelayed((Runnable)this, 500L);
        }
        break;
      }
    }
    do
    {
      return;
      paramList.setEventName("DB single");
      break;
      paramList.setEventName("IO single");
      break;
      Object localObject = BaseInfo.dbHelper;
      if (localObject != null)
      {
        localObject = ((DBHelper)localObject).getDbHandler();
        if (localObject != null) {
          ((DBHandler)localObject).deleteAllSentOrOverTime("result_objects", true);
        }
      }
      paramList.clear();
      this.listIndex = 0;
      PluginCombination.Companion.each((Function1)CollectRecordDataRunnable.reportDbData.1.INSTANCE);
      BaseInfo.editor.apply();
      paramList = this.handler;
    } while (paramList == null);
    paramList.postDelayed((Runnable)this, 7200000L);
  }
  
  private final void scanFile()
  {
    Iterator localIterator = getSearchFileList().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject1 = (File)localIterator.next();
        if (((File)localObject1).exists())
        {
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "file");
          if (((File)localObject1).isDirectory())
          {
            localObject1 = ((File)localObject1).listFiles();
            if (localObject1 != null)
            {
              Object localObject2 = (Collection)new ArrayList();
              int k = localObject1.length;
              int i = 0;
              Object localObject3;
              if (i < k)
              {
                localObject3 = localObject1[i];
                Intrinsics.checkExpressionValueIsNotNull(localObject3, "it");
                String str = ((File)localObject3).getPath();
                Intrinsics.checkExpressionValueIsNotNull(str, "it.path");
                if (!StringsKt.contains$default((CharSequence)str, (CharSequence)".txt", false, 2, null))
                {
                  str = ((File)localObject3).getPath();
                  Intrinsics.checkExpressionValueIsNotNull(str, "it.path");
                  if (!StringsKt.contains$default((CharSequence)str, (CharSequence)".zip", false, 2, null)) {
                    break label197;
                  }
                }
                label197:
                for (int j = 1;; j = 0)
                {
                  if (j != 0) {
                    ((Collection)localObject2).add(localObject3);
                  }
                  i += 1;
                  break;
                }
              }
              localObject1 = ((Iterable)localObject2).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (File)((Iterator)localObject1).next();
                try
                {
                  localObject3 = this.fileQueue;
                  Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
                  ((Queue)localObject3).add(((File)localObject2).getPath());
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    localObject3 = Logger.INSTANCE;
                    StringBuilder localStringBuilder = new StringBuilder().append(localException).append(": add file path: ");
                    Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
                    ((Logger)localObject3).e(new String[] { "QAPM_base_CollectRecordDataRunnable", ((File)localObject2).getPath() + " error. " });
                  }
                }
              }
            }
          }
        }
      }
    }
    this.hasScanFile = true;
  }
  
  public void run()
  {
    if (!this.hasScanFile) {
      scanFile();
    }
    Object localObject;
    if (PluginController.INSTANCE.getAusterityReportNum() > SDKConfig.Companion.getMAX_AUSTERITY_REPORT_NUM())
    {
      localObject = BaseInfo.dbHelper;
      if (localObject != null)
      {
        localObject = ((DBHelper)localObject).getDbHandler();
        if (localObject != null) {
          ((DBHandler)localObject).delete("result_objects", null, null);
        }
      }
      BaseInfo.editor.putInt("count_today_austerity_reported", PluginController.INSTANCE.getAusterityReportNum()).apply();
    }
    label155:
    label160:
    label163:
    for (;;)
    {
      return;
      if (!NetworkWatcher.INSTANCE.isWifiAvailable())
      {
        localObject = this.handler;
        if (localObject != null) {
          ((Handler)localObject).postDelayed((Runnable)this, 7200000L);
        }
      }
      else
      {
        localObject = this.resultObjects;
        int i;
        if (localObject != null)
        {
          if (((Collection)localObject).isEmpty()) {
            break label155;
          }
          i = 1;
          if (i == 0) {
            break label160;
          }
          reportDbData((List)localObject);
        }
        for (localObject = Unit.INSTANCE;; localObject = null)
        {
          if (localObject != null) {
            break label163;
          }
          collectDbDataAndDeleteFile();
          localObject = Unit.INSTANCE;
          return;
          i = 0;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.runnable.CollectRecordDataRunnable
 * JD-Core Version:    0.7.0.1
 */