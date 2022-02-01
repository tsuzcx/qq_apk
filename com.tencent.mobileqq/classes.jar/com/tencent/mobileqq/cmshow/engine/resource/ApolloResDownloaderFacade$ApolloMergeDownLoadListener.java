package com.tencent.mobileqq.cmshow.engine.resource;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/resource/ApolloResDownloaderFacade$ApolloMergeDownLoadListener;", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader$OnApolloDownLoadListener;", "mAllCallBackCount", "", "mInnerListener", "(ILcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader$OnApolloDownLoadListener;)V", "getMAllCallBackCount", "()I", "mDoneCallBackCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "mErrorCallbackCount", "getMInnerListener", "()Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader$OnApolloDownLoadListener;", "setMInnerListener", "(Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResDownloader$OnApolloDownLoadListener;)V", "onDownLoadFinish", "", "success", "", "uin", "", "roleId", "dressIds", "", "actionId", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloResDownloaderFacade$ApolloMergeDownLoadListener
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  private final AtomicInteger a;
  private final AtomicInteger b;
  private final int c;
  @Nullable
  private IApolloResDownloader.OnApolloDownLoadListener d;
  
  public ApolloResDownloaderFacade$ApolloMergeDownLoadListener(int paramInt, @Nullable IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener)
  {
    this.c = paramInt;
    this.d = paramOnApolloDownLoadListener;
    this.a = new AtomicInteger(0);
    this.b = new AtomicInteger(0);
  }
  
  public void a(boolean paramBoolean, @Nullable String paramString, int paramInt1, @Nullable int[] paramArrayOfInt, int paramInt2)
  {
    if (!paramBoolean) {
      this.b.incrementAndGet();
    }
    if (this.a.incrementAndGet() == this.c)
    {
      IApolloResDownloader.OnApolloDownLoadListener localOnApolloDownLoadListener = this.d;
      if (localOnApolloDownLoadListener != null)
      {
        if (localOnApolloDownLoadListener == null) {
          Intrinsics.throwNpe();
        }
        if (this.b.get() == 0) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        localOnApolloDownLoadListener.a(paramBoolean, paramString, paramInt1, paramArrayOfInt, paramInt2);
        if (QLog.isColorLevel())
        {
          paramArrayOfInt = new StringBuilder();
          paramArrayOfInt.append("[ApolloMergeDownLoadListener] onDownLoadFinish, all done. uin = ");
          paramArrayOfInt.append(paramString);
          paramArrayOfInt.append(", mErrorCallbackCount = ");
          paramArrayOfInt.append(this.b.get());
          QLog.d("[cmshow]ApolloResDownloaderFacade", 2, paramArrayOfInt.toString());
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramArrayOfInt = new StringBuilder();
      paramArrayOfInt.append("[ApolloMergeDownLoadListener] onDownLoadFinish. uin = ");
      paramArrayOfInt.append(paramString);
      paramArrayOfInt.append(", mDoneCallBackCount = ");
      paramArrayOfInt.append(this.a.get());
      QLog.d("[cmshow]ApolloResDownloaderFacade", 2, paramArrayOfInt.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.ApolloResDownloaderFacade.ApolloMergeDownLoadListener
 * JD-Core Version:    0.7.0.1
 */