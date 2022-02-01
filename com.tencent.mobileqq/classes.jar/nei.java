import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class nei
  implements nem
{
  private List<neg> a = new ArrayList();
  
  private boolean a(List<? extends neg> paramList)
  {
    if ((paramList.size() <= 0) || (!(paramList.get(0) instanceof nek))) {
      return false;
    }
    paramList = this.a.iterator();
    while (paramList.hasNext()) {
      if (((neg)paramList.next() instanceof nek)) {
        return true;
      }
    }
    return false;
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  @Nullable
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return ((neg)this.a.get(paramInt)).a();
    }
    return null;
  }
  
  @Nullable
  public neg a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (neg)this.a.get(paramInt);
    }
    return null;
  }
  
  @Nullable
  public <T extends nel> T a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (nel)this.a.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    a(new neh());
    a(new nej("https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_match_random.png", 2131690374, 2130838748, 0, "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_ufo5.png", null, 1));
    a(new nej("https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_match_create_room.png", 2131690373, 2130838747, 0, "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_house5.png", null, 2));
    a(new nej("https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_match_search_room.png", 2131690376, 2130838749, 0, "https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_door5.png", null, 3));
  }
  
  public void a(List<? extends neg> paramList, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size()) && (!a(paramList))) {
      this.a.addAll(paramInt, paramList);
    }
  }
  
  public void a(neg paramneg)
  {
    this.a.add(paramneg);
  }
  
  public void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      neg localneg = (neg)localIterator.next();
      switch (localneg.a())
      {
      default: 
        break;
      case 4: 
        ((nek)localneg).d("https://static-res.qq.com/static-res/avgames/survival/avgame_room_survival_order.png");
        ((nek)localneg).e("https://static-res.qq.com/static-res/avgames/survival/avgame_room_survival_no_order.png");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nei
 * JD-Core Version:    0.7.0.1
 */