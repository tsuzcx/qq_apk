import SummaryCard.RespSearch;
import SummaryCard.SearchInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade.ISearchListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class rmp
  implements ContactSearchFacade.ISearchListener
{
  public rmp(AddFriendActivity paramAddFriendActivity) {}
  
  public void a(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, String paramString)
  {
    AddFriendActivity.a(this.a);
    if ((!paramBoolean) || (paramInt2 != 0) || (paramInt1 != 87) || (!(paramObject instanceof RespSearch))) {
      if (!TextUtils.isEmpty(paramString)) {
        this.a.a(paramString);
      }
    }
    do
    {
      return;
      this.a.a(2131434465);
      return;
      try
      {
        paramString = (RespSearch)paramObject;
        if ((paramString.vRecords != null) && (!paramString.vRecords.isEmpty())) {
          break;
        }
        this.a.a(2131434767);
        return;
      }
      catch (Exception paramString)
      {
        this.a.a(2131434465);
      }
    } while (!QLog.isColorLevel());
    QLog.d("AddFriendActivity", 2, "onSearchResult | searchType = " + paramInt1 + " | isSuccess = " + paramBoolean + " | rsCode = " + paramInt2 + " | data = " + paramObject, paramString);
    return;
    if (paramString.vRecords.size() == 1)
    {
      AddFriendActivity.a(this.a, (SearchInfo)paramString.vRecords.get(0), this.a.app.getCurrentAccountUin(), paramString.vSecureSig, false, 0);
      return;
    }
    this.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rmp
 * JD-Core Version:    0.7.0.1
 */