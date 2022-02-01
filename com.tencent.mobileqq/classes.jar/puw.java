import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

public class puw
  extends anvi
{
  public puw(KandianMergeManager paramKandianMergeManager) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.equals(KandianMergeManager.b(this.a), paramString)) && (!TextUtils.equals(paramString, AppConstants.KANDIAN_MERGE_UIN))) {
      KandianMergeManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(4, true, new Object[] { AppConstants.KANDIAN_MERGE_UIN });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     puw
 * JD-Core Version:    0.7.0.1
 */