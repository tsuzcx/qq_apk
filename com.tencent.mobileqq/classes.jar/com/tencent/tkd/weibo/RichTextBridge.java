package com.tencent.tkd.weibo;

import com.tencent.tkd.weibo.framework.IEmoJiBridge;
import com.tencent.tkd.weibo.framework.ILogger;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/RichTextBridge;", "", "()V", "emoJiBridge", "Lcom/tencent/tkd/weibo/framework/IEmoJiBridge;", "getEmoJiBridge", "()Lcom/tencent/tkd/weibo/framework/IEmoJiBridge;", "emoJiBridgeImpl", "hasInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "logger", "Lcom/tencent/tkd/weibo/framework/ILogger;", "getLogger", "()Lcom/tencent/tkd/weibo/framework/ILogger;", "loggerImpl", "initial", "", "Companion", "tkd-weibo-richtext_release"}, k=1, mv={1, 1, 16})
public final class RichTextBridge
{
  public static final RichTextBridge.Companion a;
  private static final RichTextBridge jdField_a_of_type_ComTencentTkdWeiboRichTextBridge = new RichTextBridge();
  private IEmoJiBridge jdField_a_of_type_ComTencentTkdWeiboFrameworkIEmoJiBridge;
  private ILogger jdField_a_of_type_ComTencentTkdWeiboFrameworkILogger;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_ComTencentTkdWeiboRichTextBridge$Companion = new RichTextBridge.Companion(null);
  }
  
  @Nullable
  public final IEmoJiBridge a()
  {
    return this.jdField_a_of_type_ComTencentTkdWeiboFrameworkIEmoJiBridge;
  }
  
  @NotNull
  public final ILogger a()
  {
    ILogger localILogger = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkILogger;
    if (localILogger == null) {
      Intrinsics.throwUninitializedPropertyAccessException("loggerImpl");
    }
    return localILogger;
  }
  
  public final void a(@Nullable IEmoJiBridge paramIEmoJiBridge, @NotNull ILogger paramILogger)
  {
    Intrinsics.checkParameterIsNotNull(paramILogger, "logger");
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      System.out.println("UiSDK::initial 不允许重复调用");
      return;
    }
    this.jdField_a_of_type_ComTencentTkdWeiboFrameworkIEmoJiBridge = paramIEmoJiBridge;
    this.jdField_a_of_type_ComTencentTkdWeiboFrameworkILogger = paramILogger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.RichTextBridge
 * JD-Core Version:    0.7.0.1
 */