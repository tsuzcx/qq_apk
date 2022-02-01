package com.tencent.qapmsdk.base.reporter.uploaddata.runnable;

import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.common.util.FileUtil.Companion;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/util/ArrayList;", "Ljava/io/File;", "Lkotlin/collections/ArrayList;", "invoke"}, k=3, mv={1, 1, 15})
final class CollectRecordDataRunnable$searchFileList$2
  extends Lambda
  implements Function0<ArrayList<File>>
{
  public static final 2 INSTANCE = new 2();
  
  CollectRecordDataRunnable$searchFileList$2()
  {
    super(0);
  }
  
  @NotNull
  public final ArrayList<File> invoke()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new File(FileUtil.Companion.getRootPath(), "Log"));
    localArrayList.add(new File(FileUtil.Companion.getRootPath(), "dumpfile"));
    localArrayList.add(new File(FileUtil.Companion.getRootPath(), "battery"));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.runnable.CollectRecordDataRunnable.searchFileList.2
 * JD-Core Version:    0.7.0.1
 */