package cooperation.ilive.group;

import android.os.Handler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import cooperation.ilive.group.entity.IliveGroupTipsEntity;

public class IliveGroupObserver
  implements BusinessObserver
{
  public void a() {}
  
  public void a(String paramString, IliveGroupTipsEntity paramIliveGroupTipsEntity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject2 = null;
    switch (paramInt)
    {
    }
    Object[] arrayOfObject;
    do
    {
      return;
      arrayOfObject = (Object[])paramObject;
    } while (arrayOfObject == null);
    if ((arrayOfObject.length > 1) && (arrayOfObject[0] != null) && ((arrayOfObject[0] instanceof String))) {}
    for (paramObject = (String)arrayOfObject[0];; paramObject = null)
    {
      Object localObject1 = localObject2;
      if (arrayOfObject.length == 2)
      {
        localObject1 = localObject2;
        if (arrayOfObject[1] != null)
        {
          localObject1 = localObject2;
          if ((arrayOfObject[1] instanceof IliveGroupTipsEntity)) {
            localObject1 = (IliveGroupTipsEntity)arrayOfObject[1];
          }
        }
      }
      ThreadManagerV2.getUIHandlerV2().post(new IliveGroupObserver.1(this, paramObject, (IliveGroupTipsEntity)localObject1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.group.IliveGroupObserver
 * JD-Core Version:    0.7.0.1
 */