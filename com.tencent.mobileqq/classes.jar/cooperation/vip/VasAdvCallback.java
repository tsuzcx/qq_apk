package cooperation.vip;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/VasAdvCallback;", "", "onError", "", "errMsg", "", "e", "", "onRsp", "rspBytes", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface VasAdvCallback
{
  public abstract void a(@NotNull String paramString, @Nullable Throwable paramThrowable);
  
  public abstract void a(@NotNull byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.VasAdvCallback
 * JD-Core Version:    0.7.0.1
 */