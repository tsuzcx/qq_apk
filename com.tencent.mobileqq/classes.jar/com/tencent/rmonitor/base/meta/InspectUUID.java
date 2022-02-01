package com.tencent.rmonitor.base.meta;

import android.text.TextUtils;
import com.tencent.rmonitor.common.util.RecyclablePool.Recyclable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/meta/InspectUUID;", "Lcom/tencent/rmonitor/common/util/RecyclablePool$Recyclable;", "()V", "cache", "", "className", "digest", "uuid", "", "weakObj", "Ljava/lang/ref/WeakReference;", "", "reset", "", "toString", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class InspectUUID
  extends RecyclablePool.Recyclable
{
  @JvmField
  @NotNull
  public String cache = "";
  @JvmField
  @NotNull
  public String className = "";
  @JvmField
  @NotNull
  public String digest = "";
  @JvmField
  @Nullable
  public char[] uuid;
  @JvmField
  @Nullable
  public WeakReference<Object> weakObj;
  
  public void reset()
  {
    this.weakObj = ((WeakReference)null);
    this.digest = "";
    this.uuid = ((char[])null);
    this.className = "";
    this.cache = "";
  }
  
  @NotNull
  public String toString()
  {
    int i;
    if (((CharSequence)this.cache).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      Object localObject = new StringBuilder(64);
      ((StringBuilder)localObject).append(this.className);
      ((StringBuilder)localObject).append("@");
      char[] arrayOfChar = this.uuid;
      if (arrayOfChar != null) {
        ((StringBuilder)localObject).append(arrayOfChar);
      }
      if (!TextUtils.isEmpty((CharSequence)this.digest))
      {
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(this.digest);
      }
      localObject = ((StringBuilder)localObject).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "StringBuilder(64).apply …\n            }.toString()");
      this.cache = ((String)localObject);
    }
    return this.cache;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.meta.InspectUUID
 * JD-Core Version:    0.7.0.1
 */