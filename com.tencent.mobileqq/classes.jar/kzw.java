import android.content.Context;
import android.util.Pair;
import java.util.List;
import org.apache.http.Header;

abstract class kzw
  extends kzt
{
  public static void a(Context paramContext, Header[] paramArrayOfHeader, List<Pair<String, String>> paramList, kzi paramkzi)
  {
    a().a(paramContext, "https://www.googleapis.com/language/translate/v2", paramArrayOfHeader, paramList, paramkzi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kzw
 * JD-Core Version:    0.7.0.1
 */