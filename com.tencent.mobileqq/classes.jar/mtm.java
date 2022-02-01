import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class mtm
{
  public static String a = "ShareUtils";
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("image_url", localArrayList);
    localBundle.putString("title", paramString2);
    localBundle.putString("desc", paramString3);
    localBundle.putLong("req_share_id", 0L);
    localBundle.putString("detail_url", paramString4);
    bltb.a(paramAppInterface, paramContext, localBundle, null);
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "shareToQzone. title:" + paramString2 + " desc:" + paramString3 + " shareLink:" + paramString4 + " icon:" + paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mtm
 * JD-Core Version:    0.7.0.1
 */