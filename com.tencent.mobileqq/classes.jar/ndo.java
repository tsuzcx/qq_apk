import com.tencent.mobileqq.app.BusinessObserver;

public class ndo
  implements BusinessObserver
{
  public void a(int paramInt, boolean paramBoolean, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (((paramObject instanceof String)) || (paramObject == null)) {
      a(paramInt, paramBoolean, (String)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ndo
 * JD-Core Version:    0.7.0.1
 */