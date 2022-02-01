import android.content.Context;
import com.tencent.avgame.app.AVGameAppInterface;
import java.util.List;

public abstract class ncx
{
  protected Context a;
  protected AVGameAppInterface a;
  protected int b;
  
  public ncx(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
  }
  
  public static ncx a(int paramInt, Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new ncw(paramContext, paramAVGameAppInterface);
    }
    return new ncy(paramContext, paramAVGameAppInterface);
  }
  
  public void a(nda[] paramArrayOfnda1, nda[] paramArrayOfnda2, int paramInt1, int paramInt2, List<nan> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ncx
 * JD-Core Version:    0.7.0.1
 */