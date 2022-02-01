package com.tencent.qapmsdk.common.device;

import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.common.util.FileUtil.Companion;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/device/DeviceIo$Companion;", "", "()V", "getAvailableIOScheduler", "", "getReadAhead", "common_release"}, k=1, mv={1, 1, 15})
public final class DeviceIo$Companion
{
  @NotNull
  public final String getAvailableIOScheduler()
  {
    Object localObject2 = ((Iterable)CollectionsKt.listOf(new String[] { "/sys/block/mmcblk0/queue/scheduler", "/sys/block/mmcblk1/queue/scheduler", "/sys/block/mtdblock0/queue/scheduler" })).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (new File((String)localObject1).exists())
      {
        localObject1 = (String)localObject1;
        if (localObject1 == null) {
          break label209;
        }
        label76:
        localObject2 = (String)null;
        localObject1 = (CharSequence)FileUtil.Companion.readOutputFromFile((String)localObject1);
        localObject1 = new Regex(" ").split((CharSequence)localObject1, 0);
        if (((List)localObject1).isEmpty()) {
          break label220;
        }
        localObject3 = ((List)localObject1).listIterator(((List)localObject1).size());
        label131:
        if (!((ListIterator)localObject3).hasPrevious()) {
          break label220;
        }
        if (((CharSequence)((ListIterator)localObject3).previous()).length() != 0) {
          break label215;
        }
        i = 1;
        label164:
        if (i != 0) {
          break label218;
        }
      }
    }
    label209:
    label215:
    label218:
    label220:
    for (Object localObject1 = CollectionsKt.take((Iterable)localObject1, ((ListIterator)localObject3).nextIndex() + 1);; localObject1 = CollectionsKt.emptyList())
    {
      localObject1 = (Collection)localObject1;
      if (localObject1 != null) {
        break label227;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
      localObject1 = null;
      break;
      localObject1 = "";
      break label76;
      i = 0;
      break label164;
      break label131;
    }
    label227:
    localObject1 = ((Collection)localObject1).toArray(new String[0]);
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    Object localObject3 = (String[])localObject1;
    int j = localObject3.length;
    int i = 0;
    localObject1 = localObject2;
    if (i < j)
    {
      localObject2 = localObject3[i];
      if (!StringsKt.contains$default((CharSequence)localObject2, (CharSequence)"[", false, 2, null)) {
        break label354;
      }
      localObject1 = localObject2;
    }
    label354:
    for (;;)
    {
      i += 1;
      break;
      if (localObject1 != null)
      {
        i = ((String)localObject1).length();
        if (localObject1 == null) {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        localObject1 = ((String)localObject1).substring(1, i - 1);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (localObject1 != null) {
          return localObject1;
        }
      }
      return "";
    }
  }
  
  @NotNull
  public final String getReadAhead()
  {
    Object localObject = "";
    int i = 0;
    while (i <= 1)
    {
      if (new File("/sys/block/mmcblk" + i).exists())
      {
        localObject = new File("/sys/block/mmcblk" + i + "/queue/read_ahead_kb");
        localObject = FileUtil.Companion.readOutputFromFile(((File)localObject).getAbsolutePath());
      }
      i += 1;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.device.DeviceIo.Companion
 * JD-Core Version:    0.7.0.1
 */