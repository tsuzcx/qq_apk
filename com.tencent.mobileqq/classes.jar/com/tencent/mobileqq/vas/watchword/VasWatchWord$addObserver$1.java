package com.tencent.mobileqq.vas.watchword;

import com.tencent.biz.pubaccount.readinjoy.share.watchword.RIJWatchWordShareManager.OnWatchWordCheck;
import com.tencent.mobileqq.vas.ipc.RemoteProxy;
import com.tencent.mobileqq.vas.remote.IWatchWordProtocol;
import com.tencent.mobileqq.vas.remote.WatchWordProtocol;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/watchword/VasWatchWord$addObserver$1", "Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/RIJWatchWordShareManager$OnWatchWordCheck;", "checkWatchWord", "", "text", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasWatchWord$addObserver$1
  implements RIJWatchWordShareManager.OnWatchWordCheck
{
  public boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Object localObject = RemoteProxy.getProxy(WatchWordProtocol.class);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.vas.remote.IWatchWordProtocol");
    }
    ((IWatchWordProtocol)localObject).a(paramString, null, -1, (EIPCResultCallback)VasWatchWord.addObserver.1.checkWatchWord.1.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.watchword.VasWatchWord.addObserver.1
 * JD-Core Version:    0.7.0.1
 */