import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/config/handlers/BarrageConfigHandler;", "Lcom/tencent/aladdin/config/handlers/AladdinConfigHandler;", "()V", "onReceiveConfig", "", "id", "", "version", "content", "", "onWipeConfig", "", "p0", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ple
  implements AladdinConfigHandler
{
  public static final plf a = new plf(null);
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    try
    {
      paramString = pku.a(paramString);
      paramString = new GsonBuilder().create().toJson(paramString);
      if (paramString != null) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BarrageConfigHandler", 2, "onReceiveConfig configJson:" + paramString);
        }
        bmhv.n(paramString);
        break;
        paramString = "";
      }
      return true;
    }
    catch (UnsupportedEncodingException paramString)
    {
      QLog.e("BarrageConfigHandler", 2, "[PersonalHomePageConfigHandler]: onReceiveConfig Error in:" + paramString);
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    bmhv.n("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ple
 * JD-Core Version:    0.7.0.1
 */