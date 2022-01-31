package com.tencent.qapmsdk.memory.leakdetect;

import android.os.Handler;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.listener.IInspectorListener;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.InspectUUID;
import com.tencent.qapmsdk.common.util.RecyclablePool;
import com.tencent.qapmsdk.memory.DumpMemInfoHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

class LeakInspector$InspectorRunner
  implements Runnable
{
  private long occurTime = System.currentTimeMillis();
  private int retryCount = 0;
  private InspectUUID uuid;
  
  LeakInspector$InspectorRunner(LeakInspector paramLeakInspector, InspectUUID paramInspectUUID, int paramInt)
  {
    this.retryCount = paramInt;
    this.uuid = paramInspectUUID;
  }
  
  public void run()
  {
    if (this.uuid == null) {
      Logger.INSTANCE.w(new String[] { "QAPM_memory_LeakInspector", "uuid is null" });
    }
    for (;;)
    {
      return;
      String str = this.uuid.toString();
      int i;
      try
      {
        Logger.INSTANCE.d(new String[] { "QAPM_memory_LeakInspector", "Inspecting ", str, " Time=", String.valueOf(System.currentTimeMillis()), " count=", String.valueOf(this.retryCount) });
        if (this.uuid.weakObj.get() == null) {
          break label685;
        }
        i = this.retryCount + 1;
        this.retryCount = i;
        if (i < LeakInspector.LOOP_MAX_COUNT)
        {
          LeakInspector.access$000();
          LeakInspector.access$100(this.this$0).onCheckingLeaked((this.retryCount - 1) * 5000 / 1000, str);
          LeakInspector.access$200(this.this$0).postDelayed(this, 5000L);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_memory_LeakInspector", "error, ", str, " Time=", String.valueOf(System.currentTimeMillis()), " count=", String.valueOf(this.retryCount), " Throwable: ", Logger.INSTANCE.getThrowableMessage(localThrowable) });
        LeakInspector.access$300().recycle(this.uuid);
        return;
      }
      if (!LeakInspector.access$100(this.this$0).onLeaked(this.uuid))
      {
        LeakInspector.access$300().recycle(this.uuid);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = LeakInspector.access$100(this.this$0).onPrepareDump(str);
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        localArrayList.addAll((Collection)localObject1);
      }
      localObject1 = this.uuid.className + "_leak";
      Object localObject2;
      if (LeakInspector.access$400())
      {
        localObject2 = DumpMemInfoHandler.generateHprof(str);
        if (((Boolean)localObject2[0]).booleanValue()) {
          localArrayList.add((String)localObject2[1]);
        }
      }
      else
      {
        LeakInspector.access$500(this.this$0, localArrayList);
        localObject2 = DumpMemInfoHandler.zipFiles(localArrayList, (String)localObject1);
        localObject1 = (Boolean)localObject2[0];
        localObject2 = (String)localObject2[1];
        Logger.INSTANCE.d(new String[] { "QAPM_memory_LeakInspector", "leakFlag=true", ",ZipFile=", String.valueOf(localObject1), ",leakName=", str, ",dumpPath=", localObject2 });
        LeakInspector.access$100(this.this$0).onFinishDump(((Boolean)localObject1).booleanValue(), str, (String)localObject2);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("processname", AppInfo.obtainProcessName(BaseInfo.app));
        ((JSONObject)localObject1).put("event_time", this.occurTime);
        ((JSONObject)localObject1).put("fileObj", localObject2);
        ((JSONObject)localObject1).put("plugin", PluginCombination.leakPlugin.plugin);
        localObject1 = new ResultObject(0, "MemoryLeak single", true, 1L, 1L, (JSONObject)localObject1, true, true, BaseInfo.userMeta.uin);
        ReporterMachine.INSTANCE.addResultObj((ResultObject)localObject1);
        i = 0;
      }
      while (i < localArrayList.size())
      {
        localObject1 = new File((String)localArrayList.get(i));
        if ((localObject1 != null) && (((File)localObject1).isFile()) && (((File)localObject1).exists()))
        {
          ((File)localObject1).delete();
          break label727;
          Logger.INSTANCE.e(new String[] { "QAPM_memory_LeakInspector", "generateHprof error ", str });
          return;
          label685:
          Logger.INSTANCE.d(new String[] { "QAPM_memory_LeakInspector", "inspect ", str, " finished no leak" });
          LeakInspector.access$300().recycle(this.uuid);
          return;
        }
        label727:
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.leakdetect.LeakInspector.InspectorRunner
 * JD-Core Version:    0.7.0.1
 */