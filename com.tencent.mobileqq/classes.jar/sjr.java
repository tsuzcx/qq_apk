import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troop.widget.FollowImageTextView.OnTextLineChangeListener;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class sjr
  implements FollowImageTextView.OnTextLineChangeListener
{
  public sjr(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(int paramInt)
  {
    if (this.a.f) {}
    do
    {
      do
      {
        return;
      } while ((paramInt <= 0) || (ChatSettingForTroop.b(this.a) == paramInt));
      ChatSettingForTroop.a(this.a, paramInt);
    } while (this.a.a.hasSetNewTroopHead);
    ChatSettingForTroop.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sjr
 * JD-Core Version:    0.7.0.1
 */