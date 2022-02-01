import android.content.Context;
import com.tencent.avgame.app.AVGameAppInterface;
import java.util.List;

public abstract class nep
{
  protected Context a;
  protected AVGameAppInterface a;
  protected int b;
  
  public nep(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
  }
  
  public static nep a(int paramInt, Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new neo(paramContext, paramAVGameAppInterface);
    }
    return new neq(paramContext, paramAVGameAppInterface);
  }
  
  public void a(nes[] paramArrayOfnes1, nes[] paramArrayOfnes2, int paramInt1, int paramInt2, List<nbr> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nep
 * JD-Core Version:    0.7.0.1
 */