package com.tencent.qqmini.sdk.runtime;

import java.util.Comparator;

class RuntimeLoaderConfiguration$1
  implements Comparator<RuntimeLoaderConfiguration.RuntimeLoaderInfo>
{
  RuntimeLoaderConfiguration$1(RuntimeLoaderConfiguration paramRuntimeLoaderConfiguration) {}
  
  public int compare(RuntimeLoaderConfiguration.RuntimeLoaderInfo paramRuntimeLoaderInfo1, RuntimeLoaderConfiguration.RuntimeLoaderInfo paramRuntimeLoaderInfo2)
  {
    if ((paramRuntimeLoaderInfo1 != null) && (paramRuntimeLoaderInfo2 != null)) {
      return paramRuntimeLoaderInfo1.type - paramRuntimeLoaderInfo2.type;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.RuntimeLoaderConfiguration.1
 * JD-Core Version:    0.7.0.1
 */