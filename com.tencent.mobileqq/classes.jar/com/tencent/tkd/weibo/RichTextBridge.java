package com.tencent.tkd.weibo;

import com.tencent.tkd.topicsdk.interfaces.ILogger;
import com.tencent.tkd.weibo.framework.IEmoJiBridge;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/RichTextBridge;", "", "()V", "emoJiBridge", "Lcom/tencent/tkd/weibo/framework/IEmoJiBridge;", "getEmoJiBridge", "()Lcom/tencent/tkd/weibo/framework/IEmoJiBridge;", "emoJiBridgeImpl", "hasInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "logger", "Lcom/tencent/tkd/topicsdk/interfaces/ILogger;", "getLogger", "()Lcom/tencent/tkd/topicsdk/interfaces/ILogger;", "loggerImpl", "initial", "", "Companion", "tkd-weibo-richtext_release"}, k=1, mv={1, 1, 16})
public final class RichTextBridge
{
  public static final RichTextBridge.Companion a = new RichTextBridge.Companion(null);
  private static final RichTextBridge e = new RichTextBridge();
  private final AtomicBoolean b = new AtomicBoolean(false);
  private IEmoJiBridge c;
  private ILogger d;
  
  @Nullable
  public final IEmoJiBridge a()
  {
    return this.c;
  }
  
  public final void a(@Nullable IEmoJiBridge paramIEmoJiBridge, @NotNull ILogger paramILogger)
  {
    Intrinsics.checkParameterIsNotNull(paramILogger, "logger");
    if (this.b.getAndSet(true))
    {
      System.out.println("UiSDK::initial 不允许重复调用");
      return;
    }
    this.c = paramIEmoJiBridge;
    this.d = paramILogger;
  }
  
  @NotNull
  public final ILogger b()
  {
    ILogger localILogger = this.d;
    if (localILogger == null) {
      Intrinsics.throwUninitializedPropertyAccessException("loggerImpl");
    }
    return localILogger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.RichTextBridge
 * JD-Core Version:    0.7.0.1
 */