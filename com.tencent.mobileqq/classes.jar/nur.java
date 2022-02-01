import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;

public class nur
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, BmqqUserSimpleInfo paramBmqqUserSimpleInfo) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramBoolean, (BmqqUserSimpleInfo)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nur
 * JD-Core Version:    0.7.0.1
 */