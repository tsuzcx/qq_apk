package com.tencent.qapmsdk.base.reporter.uploaddata.runnable;

import android.content.Context;
import com.tencent.qapmsdk.base.dbpersist.BaseTable;
import com.tencent.qapmsdk.base.dbpersist.DBHandler;
import com.tencent.qapmsdk.base.dbpersist.DBHelper;
import com.tencent.qapmsdk.base.dbpersist.table.ResultObjectsTable;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.AppInfo.Companion;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/uploaddata/runnable/StoreRecordDataRunnable;", "Ljava/lang/Runnable;", "resultObject", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;", "(Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;)V", "run", "", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class StoreRecordDataRunnable
  implements Runnable
{
  public static final StoreRecordDataRunnable.Companion Companion = new StoreRecordDataRunnable.Companion(null);
  private static final String TAG = "QAPM_base_StoreRecordDataRunnable";
  private final ResultObject resultObject;
  
  public StoreRecordDataRunnable(@NotNull ResultObject paramResultObject)
  {
    this.resultObject = paramResultObject;
  }
  
  public void run()
  {
    long l = 0L;
    if (0L == 0L) {
      l = System.currentTimeMillis();
    }
    Object localObject = BaseInfo.dbHelper;
    if (localObject != null)
    {
      localObject = ((DBHelper)localObject).getDbHandler();
      if (localObject != null)
      {
        int i = BaseInfo.userMeta.appId;
        String str1 = AppInfo.Companion.obtainProcessName((Context)BaseInfo.app);
        String str2 = BaseInfo.userMeta.version;
        String str3 = this.resultObject.getUin();
        String str4 = this.resultObject.getParams().toString();
        Intrinsics.checkExpressionValueIsNotNull(str4, "resultObject.params.toString()");
        ((DBHandler)localObject).insert((BaseTable)new ResultObjectsTable(i, str1, str2, str3, str4, this.resultObject.isRealTime(), l), (Function0)StoreRecordDataRunnable.run.1.INSTANCE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.runnable.StoreRecordDataRunnable
 * JD-Core Version:    0.7.0.1
 */