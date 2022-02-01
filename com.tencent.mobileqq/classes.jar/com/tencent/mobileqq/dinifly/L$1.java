package com.tencent.mobileqq.dinifly;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.dinifly.network.LottieNetworkCacheProvider;
import java.io.File;

final class L$1
  implements LottieNetworkCacheProvider
{
  L$1(Context paramContext) {}
  
  @NonNull
  public File getCacheDir()
  {
    return new File(this.val$context.getCacheDir(), "lottie_network_cache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.L.1
 * JD-Core Version:    0.7.0.1
 */