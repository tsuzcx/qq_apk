import android.content.Context;
import android.util.Pair;
import java.util.List;
import org.apache.http.Header;

abstract class kzu
  extends kzr
{
  public static void a(Context paramContext, Header[] paramArrayOfHeader, List<Pair<String, String>> paramList, kzg paramkzg)
  {
    a().a(paramContext, "https://www.googleapis.com/language/translate/v2", paramArrayOfHeader, paramList, paramkzg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kzu
 * JD-Core Version:    0.7.0.1
 */