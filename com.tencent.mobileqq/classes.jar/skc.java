import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;

public class skc
  extends ampa<skb>
{
  public int a()
  {
    return 447;
  }
  
  public Class<skb> a()
  {
    return skb.class;
  }
  
  @NonNull
  public skb a(int paramInt)
  {
    return new skb();
  }
  
  @Nullable
  public skb a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      snb.d("WeSeeConfigProcessor", "onParsed:" + paramArrayOfamph[0].a);
      skb localskb = new skb();
      localskb.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WeSeeConfigProcessor", 0, "onParsed " + paramArrayOfamph[0].a);
      }
      return localskb;
    }
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(skb paramskb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeSeeConfigProcessor", 0, "onUpdate " + paramskb);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     skc
 * JD-Core Version:    0.7.0.1
 */