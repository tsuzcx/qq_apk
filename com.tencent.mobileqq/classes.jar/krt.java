import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import org.json.JSONObject;

public class krt
  implements HttpWebCgiAsyncTask.Callback
{
  public krt(AccountDetailGroupListContainer paramAccountDetailGroupListContainer) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    AccountDetailGroupListContainer.a(this.a, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     krt
 * JD-Core Version:    0.7.0.1
 */