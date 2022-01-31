import com.tencent.mobileqq.activity.C2CCallToGroupCall;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class rzg
  extends Thread
{
  public rzg(C2CCallToGroupCall paramC2CCallToGroupCall) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    localObject3 = ContactUtils.j(this.a.a, this.a.a.getCurrentAccountUin());
    Object localObject1 = localObject3;
    for (;;)
    {
      try
      {
        if (((String)localObject3).getBytes("utf-8").length > 48)
        {
          int j = ((String)localObject3).length();
          i = 1;
          localObject1 = localObject3;
          if (i <= j)
          {
            if (((String)localObject3).substring(0, i).getBytes("utf-8").length <= 48) {
              continue;
            }
            localObject1 = ((String)localObject3).substring(0, i - 1);
          }
        }
      }
      catch (Exception localException)
      {
        int i;
        localException.printStackTrace();
        Object localObject2 = localObject3;
        continue;
      }
      localObject3 = (DiscussionHandler)this.a.a.a(6);
      if (QLog.isColorLevel()) {
        QLog.d("C2CCallToGroupCall", 2, "create discussion: " + (String)localObject1 + " member count: " + localArrayList.size());
      }
      ((DiscussionHandler)localObject3).a((String)localObject1, localArrayList, 1003);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rzg
 * JD-Core Version:    0.7.0.1
 */