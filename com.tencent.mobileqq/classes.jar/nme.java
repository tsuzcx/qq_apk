import com.tencent.avgame.gameroom.video.AVGameControlUIImpl;
import com.tencent.avgame.qav.SecurityPolicyChecker;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class nme
  implements noe
{
  public nme(AVGameControlUIImpl paramAVGameControlUIImpl) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.a.a()) {}
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = nnm.b();
        } while (localObject1 == null);
        localObject1 = ((nnm)localObject1).a();
      } while (localObject1 == null);
      AVGameControlUIImpl.a(this.a, "CheckDisableSmallPicTask");
    } while ((this.a.a == null) || (!paramBoolean));
    boolean bool2 = SecurityPolicyChecker.a().b();
    Object localObject2 = new ArrayList();
    ((nof)localObject1).b((List)localObject2);
    boolean bool1;
    if (((List)localObject2).size() > 0)
    {
      localObject1 = ((List)localObject2).iterator();
      paramBoolean = false;
      do
      {
        do
        {
          bool1 = paramBoolean;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (AVGameUserInfo)((Iterator)localObject1).next();
        } while (localObject2 == null);
        if (!((AVGameUserInfo)localObject2).hasVideo()) {
          break label242;
        }
      } while (((AVGameUserInfo)localObject2).mIsSelf);
    }
    label242:
    for (;;)
    {
      if (((AVGameUserInfo)localObject2).mBigVideo)
      {
        paramBoolean = true;
      }
      else if (!bool2)
      {
        paramBoolean = true;
        continue;
        bool1 = false;
        if (bool1) {
          this.a.c();
        }
        while (QLog.isDevelopLevel())
        {
          QLog.i("AVGameControlUIImpl", 4, "checkDisableSmallPic, [" + bool2 + "], needRequest[" + bool1 + "]");
          return;
          this.a.e();
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nme
 * JD-Core Version:    0.7.0.1
 */