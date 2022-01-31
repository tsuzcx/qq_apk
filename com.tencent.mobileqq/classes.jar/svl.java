import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.OnGetPhotoWallListener;
import com.tencent.widget.ListView.OnScrollChangeListener;

public class svl
  implements ListView.OnScrollChangeListener
{
  public svl(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 + paramInt2 != paramInt3) || (paramInt3 <= 0) || (this.a.c()) || (!NetworkUtil.d(this.a))) {}
    while ((this.a.a == null) || (!this.a.a.a())) {
      return;
    }
    this.a.a.a();
    this.a.d(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     svl
 * JD-Core Version:    0.7.0.1
 */