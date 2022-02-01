import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class pjz
  extends amsu
{
  public pjz(KandianMergeManager paramKandianMergeManager) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.equals(KandianMergeManager.b(this.a), paramString)) && (!TextUtils.equals(paramString, AppConstants.KANDIAN_MERGE_UIN))) {
      KandianMergeManager.a(this.a).getBusinessHandler(1).notifyUI(4, true, new Object[] { AppConstants.KANDIAN_MERGE_UIN });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pjz
 * JD-Core Version:    0.7.0.1
 */