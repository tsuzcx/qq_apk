import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class ors
  extends ajxj
{
  public ors(KandianMergeManager paramKandianMergeManager) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.equals(KandianMergeManager.b(this.a), paramString)) && (!TextUtils.equals(paramString, ajsd.aA))) {
      KandianMergeManager.a(this.a).a(1).notifyUI(4, true, new Object[] { ajsd.aA });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ors
 * JD-Core Version:    0.7.0.1
 */