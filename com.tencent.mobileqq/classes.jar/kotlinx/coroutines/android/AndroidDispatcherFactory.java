package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/android/AndroidDispatcherFactory;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "()V", "loadPriority", "", "getLoadPriority", "()I", "createDispatcher", "Lkotlinx/coroutines/android/HandlerContext;", "allFactories", "", "hintOnError", "", "kotlinx-coroutines-android"}, k=1, mv={1, 1, 16})
public final class AndroidDispatcherFactory
  implements MainDispatcherFactory
{
  @NotNull
  public HandlerContext createDispatcher(@NotNull List<? extends MainDispatcherFactory> paramList)
  {
    return new HandlerContext(HandlerDispatcherKt.asHandler(Looper.getMainLooper(), true), "Main");
  }
  
  public int getLoadPriority()
  {
    return 1073741823;
  }
  
  @Nullable
  public String hintOnError()
  {
    return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.android.AndroidDispatcherFactory
 * JD-Core Version:    0.7.0.1
 */