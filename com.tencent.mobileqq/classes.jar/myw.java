import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class myw
  implements myz
{
  private List<myu> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  @Nullable
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return ((myu)this.a.get(paramInt)).a();
    }
    return null;
  }
  
  @Nullable
  public myu a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (myu)this.a.get(paramInt);
    }
    return null;
  }
  
  @Nullable
  public <T extends myy> T a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (myy)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    a(new myv());
    a(new myx("https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_match_random.png", 2131690335, 2130838732, 0, "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_ufo5.png", null, 1));
    a(new myx("https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_match_create_room.png", 2131690334, 2130838731, 0, "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_house5.png", null, 2));
    a(new myx("https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_match_search_room.png", 2131690337, 2130838733, 0, "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_door5.png", null, 3));
  }
  
  public void a(myu parammyu)
  {
    this.a.add(parammyu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     myw
 * JD-Core Version:    0.7.0.1
 */