package com.tencent.rmonitor.base.reporter.batch;

import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.common.util.FileUtil.Companion;
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
    localArrayList.add(new File(FileUtil.a.b(), "Log"));
    localArrayList.add(new File(FileUtil.a.b(), "dumpfile"));
    localArrayList.add(new File(FileUtil.a.b(), "battery"));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.batch.CollectRecordDataRunnable.searchFileList.2
 * JD-Core Version:    0.7.0.1
 */