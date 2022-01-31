import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class orv
  extends ajxl
{
  public orv(KandianMergeManager paramKandianMergeManager) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.equals(KandianMergeManager.b(this.a), paramString)) && (!TextUtils.equals(paramString, ajsf.aA))) {
      KandianMergeManager.a(this.a).a(1).notifyUI(4, true, new Object[] { ajsf.aA });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orv
 * JD-Core Version:    0.7.0.1
 */