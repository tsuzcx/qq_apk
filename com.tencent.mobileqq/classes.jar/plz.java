import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/config/handlers/PersonalHomePageConfigHandler;", "Lcom/tencent/aladdin/config/handlers/AladdinConfigHandler;", "()V", "onReceiveConfig", "", "id", "", "version", "content", "", "onWipeConfig", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class plz
  implements AladdinConfigHandler
{
  public static final pma a = new pma(null);
  
  public plz()
  {
    bmhv.e();
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    try
    {
      paramString = pku.a(paramString);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "configs");
      paramString = paramString.entrySet().iterator();
      while (paramString.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramString.next();
        if ("personal_page_url".equals(localEntry.getKey()))
        {
          bmhv.g(URLDecoder.decode((String)localEntry.getValue(), "UTF-8"));
          bmhv.e();
        }
      }
      return true;
    }
    catch (UnsupportedEncodingException paramString)
    {
      QLog.e("PersonalHomePageConfigHandler", 2, "[PersonalHomePageConfigHandler]: URLDecoder Error in:" + paramString);
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    bmhv.g("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     plz
 * JD-Core Version:    0.7.0.1
 */