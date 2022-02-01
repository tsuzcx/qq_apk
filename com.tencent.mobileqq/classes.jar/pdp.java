import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/config/handlers/ViolaVideoFeedsConfigHandler;", "Lcom/tencent/aladdin/config/handlers/AladdinConfigHandler;", "()V", "onReceiveConfig", "", "id", "", "version", "content", "", "onWipeConfig", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pdp
  implements AladdinConfigHandler
{
  public static final pdq a = new pdq(null);
  
  @JvmStatic
  public static final boolean a(int paramInt)
  {
    return a.a(paramInt);
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    try
    {
      paramString = pbt.a(paramString);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "configs");
      paramString = paramString.entrySet().iterator();
      while (paramString.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramString.next();
        if ("from_source".equals(localEntry.getKey())) {
          bkwm.a("viola_video_feeds_config", localEntry.getValue());
        }
      }
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("ViolaVideoFeedsConfigHandler", 1, "[ViolaVideoFeedsConfigHandler]: " + paramString.getMessage());
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    bkwm.a("viola_video_feeds_config", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pdp
 * JD-Core Version:    0.7.0.1
 */