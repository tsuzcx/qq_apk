import com.tencent.biz.pubaccount.subscript.ReadInJoyArticle;
import java.util.ArrayList;
import java.util.List;

public class stx
  implements alpg
{
  protected void a(boolean paramBoolean, ArrayList<ReadInJoyArticle> paramArrayList) {}
  
  protected void a(boolean paramBoolean, List<suc> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if (paramObject != null) {
        try
        {
          a(paramBoolean, (ArrayList)paramObject);
          return;
        }
        catch (Exception paramObject)
        {
          return;
        }
      }
      a(false, new ArrayList(0));
      return;
    }
    if (paramObject != null) {
      try
      {
        a(paramBoolean, (ArrayList)paramObject);
        return;
      }
      catch (Exception paramObject)
      {
        return;
      }
    }
    a(false, new ArrayList(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     stx
 * JD-Core Version:    0.7.0.1
 */