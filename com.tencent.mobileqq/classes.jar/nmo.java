import android.content.Context;
import com.tencent.avgame.app.AVGameAppInterface;
import java.util.List;

public abstract class nmo
{
  protected Context a;
  protected AVGameAppInterface a;
  protected int b;
  
  public nmo(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
  }
  
  public static nmo a(int paramInt, Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new nmn(paramContext, paramAVGameAppInterface);
    }
    return new nmp(paramContext, paramAVGameAppInterface);
  }
  
  public void a(nmr[] paramArrayOfnmr1, nmr[] paramArrayOfnmr2, int paramInt1, int paramInt2, List<niq> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nmo
 * JD-Core Version:    0.7.0.1
 */