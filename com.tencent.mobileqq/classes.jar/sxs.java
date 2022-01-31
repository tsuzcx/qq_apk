import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.campuscircle.CampusCircleHelper;
import com.tencent.mobileqq.data.Card;

public class sxs
  implements syj
{
  public sxs(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    String str;
    do
    {
      return;
      str = FriendProfileMoreInfoActivity.b(this.a).getText().toString();
    } while ((paramString == null) || (paramString.equals(str)));
    this.a.k = true;
    this.a.e(paramString);
    if (CampusCircleHelper.b(this.a.a.lCampusSchoolID) == 4)
    {
      this.a.a("0X80081EA", 0);
      return;
    }
    this.a.a("0X80081EC", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sxs
 * JD-Core Version:    0.7.0.1
 */