import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class lly
  extends FriendListObserver
{
  public lly(KandianMergeManager paramKandianMergeManager) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.equals(KandianMergeManager.a(this.a), paramString)) && (!TextUtils.equals(paramString, AppConstants.as))) {
      KandianMergeManager.a(this.a).a(1).a(4, true, new Object[] { AppConstants.as });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lly
 * JD-Core Version:    0.7.0.1
 */