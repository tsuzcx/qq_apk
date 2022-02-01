import com.tencent.avgame.ipc.UserInfo;
import java.util.HashMap;

public class mwv
  implements anil
{
  public void a(int paramInt1, String paramString, int paramInt2) {}
  
  public void a(int paramInt, String paramString, UserInfo paramUserInfo) {}
  
  public void a(boolean paramBoolean, int paramInt, HashMap<String, String> paramHashMap) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], (UserInfo)paramObject[2]);
      return;
    case 1: 
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], ((Integer)paramObject[2]).intValue());
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, ((Integer)paramObject[0]).intValue(), (HashMap)paramObject[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mwv
 * JD-Core Version:    0.7.0.1
 */