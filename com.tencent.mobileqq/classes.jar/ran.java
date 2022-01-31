import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebVideoItemUtils.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public final class ran
  implements ocf
{
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString2)) && (TextUtils.equals(paramString1, paramString1))) {
      ThreadManager.getUIHandler().post(new FastWebVideoItemUtils.1.1(this, paramString2, paramInt1, paramInt2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ran
 * JD-Core Version:    0.7.0.1
 */