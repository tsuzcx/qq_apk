import com.tencent.superplayer.seamless.SPSeamlessHelper.SeamlessCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$jumpToColumnPlay$1$1", "Lcom/tencent/superplayer/seamless/SPSeamlessHelper$SeamlessCallback;", "onSeamlessExitEnd", "", "enterToken", "", "exitToken", "map", "", "", "onSeamlessJump", "s", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sgn
  implements SPSeamlessHelper.SeamlessCallback
{
  public sgn(spn paramspn) {}
  
  public void onSeamlessExitEnd(@NotNull String paramString1, @NotNull String paramString2, @NotNull Map<String, ? extends Object> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "enterToken");
    Intrinsics.checkParameterIsNotNull(paramString2, "exitToken");
    Intrinsics.checkParameterIsNotNull(paramMap, "map");
    paramString2 = this.a;
    if (paramString2 != null) {
      paramString2.a(paramString1);
    }
  }
  
  public void onSeamlessJump(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "s");
    paramString = this.a;
    if (paramString != null) {
      paramString.o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgn
 * JD-Core Version:    0.7.0.1
 */