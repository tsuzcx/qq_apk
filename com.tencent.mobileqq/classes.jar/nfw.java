import android.content.Context;
import com.tencent.avgame.app.AVGameAppInterface;
import java.util.List;

public abstract class nfw
{
  protected Context a;
  protected AVGameAppInterface a;
  protected int b;
  
  public nfw(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
  }
  
  public static nfw a(int paramInt, Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new nfv(paramContext, paramAVGameAppInterface);
    }
    return new nfx(paramContext, paramAVGameAppInterface);
  }
  
  public void a(nfz[] paramArrayOfnfz1, nfz[] paramArrayOfnfz2, int paramInt1, int paramInt2, List<ncs> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfw
 * JD-Core Version:    0.7.0.1
 */