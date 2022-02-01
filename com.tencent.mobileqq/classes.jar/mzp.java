import com.tencent.mobileqq.app.BusinessObserver;
import java.util.List;

public class mzp
  implements BusinessObserver
{
  private void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      if (paramObject != null)
      {
        paramObject = (Object[])paramObject;
        a(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
        return;
      }
      a(0, null);
      return;
    }
    paramObject = (Object[])paramObject;
    a((String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), (List)paramObject[4]);
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, List<bfmo> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mzp
 * JD-Core Version:    0.7.0.1
 */