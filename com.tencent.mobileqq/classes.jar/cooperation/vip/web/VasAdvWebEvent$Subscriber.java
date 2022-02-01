package cooperation.vip.web;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/web/VasAdvWebEvent$Subscriber;", "", "onVasEvent", "", "eventKey", "", "callback", "Lcooperation/vip/web/VasAdvWebEvent$Callback;", "data", "", "(Ljava/lang/String;Lcooperation/vip/web/VasAdvWebEvent$Callback;[Ljava/lang/Object;)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface VasAdvWebEvent$Subscriber
{
  public abstract void a(@NotNull String paramString, @Nullable VasAdvWebEvent.Callback paramCallback, @NotNull Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.web.VasAdvWebEvent.Subscriber
 * JD-Core Version:    0.7.0.1
 */