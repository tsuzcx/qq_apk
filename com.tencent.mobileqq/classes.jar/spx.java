import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.campuscircle.CampusCircleHelper;
import com.tencent.mobileqq.data.Card;

public class spx
  implements sqp
{
  public spx(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    String str;
    do
    {
      return;
      str = FriendProfileMoreInfoActivity.a(this.a).getText().toString();
    } while ((paramString == null) || (paramString.equals(str)));
    this.a.k = true;
    this.a.d(paramString);
    if (CampusCircleHelper.b(this.a.a.lCampusSchoolID) == 4)
    {
      this.a.a("0X80081E9", 0);
      return;
    }
    this.a.a("0X80081EB", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     spx
 * JD-Core Version:    0.7.0.1
 */