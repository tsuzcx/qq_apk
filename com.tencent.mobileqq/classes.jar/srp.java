import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;

public class srp
  extends SyncListener
{
  public srp(FavEmosmManageActivity paramFavEmosmManageActivity) {}
  
  public void a(int paramInt)
  {
    this.a.c();
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 28) || (paramInt2 % 28 == 0)) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     srp
 * JD-Core Version:    0.7.0.1
 */