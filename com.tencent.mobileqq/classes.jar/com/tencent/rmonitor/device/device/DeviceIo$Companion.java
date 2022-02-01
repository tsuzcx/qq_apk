package com.tencent.rmonitor.device.device;

import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.common.util.FileUtil.Companion;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/device/device/DeviceIo$Companion;", "", "()V", "getAvailableIOScheduler", "", "getReadAhead", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DeviceIo$Companion
{
  @NotNull
  public final String a()
  {
    Object localObject = "";
    int i = 0;
    while (i <= 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/sys/block/mmcblk");
      localStringBuilder.append(i);
      if (new File(localStringBuilder.toString()).exists())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("/sys/block/mmcblk");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("/queue/read_ahead_kb");
        localObject = new File(((StringBuilder)localObject).toString());
        localObject = FileUtil.a.b(((File)localObject).getAbsolutePath());
      }
      i += 1;
    }
    return localObject;
  }
  
  @NotNull
  public final String b()
  {
    Object localObject2 = ((Iterable)CollectionsKt.listOf(new String[] { "/sys/block/mmcblk0/queue/scheduler", "/sys/block/mmcblk1/queue/scheduler", "/sys/block/mtdblock0/queue/scheduler" })).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (new File((String)localObject1).exists()) {
        break label72;
      }
    }
    Object localObject1 = null;
    label72:
    localObject1 = (String)localObject1;
    if (localObject1 == null) {
      localObject1 = "";
    }
    localObject2 = (String)null;
    localObject1 = (CharSequence)FileUtil.a.b((String)localObject1);
    localObject1 = new Regex(" ").split((CharSequence)localObject1, 0);
    Object localObject3;
    int i;
    if (!((List)localObject1).isEmpty())
    {
      localObject3 = ((List)localObject1).listIterator(((List)localObject1).size());
      while (((ListIterator)localObject3).hasPrevious())
      {
        if (((CharSequence)((ListIterator)localObject3).previous()).length() == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0)
        {
          localObject1 = CollectionsKt.take((Iterable)localObject1, ((ListIterator)localObject3).nextIndex() + 1);
          break label208;
        }
      }
    }
    localObject1 = CollectionsKt.emptyList();
    label208:
    localObject1 = (Collection)localObject1;
    if (localObject1 != null)
    {
      localObject1 = ((Collection)localObject1).toArray(new String[0]);
      if (localObject1 != null)
      {
        localObject3 = (String[])localObject1;
        int j = localObject3.length;
        localObject1 = localObject2;
        i = 0;
        while (i < j)
        {
          localObject2 = localObject3[i];
          if (StringsKt.contains$default((CharSequence)localObject2, (CharSequence)"[", false, 2, null)) {
            localObject1 = localObject2;
          }
          i += 1;
        }
        if (localObject1 != null)
        {
          i = ((String)localObject1).length();
          if (localObject1 != null)
          {
            localObject1 = ((String)localObject1).substring(1, i - 1);
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (localObject1 != null) {
              return localObject1;
            }
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
          }
        }
        return "";
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    localObject1 = new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.device.device.DeviceIo.Companion
 * JD-Core Version:    0.7.0.1
 */