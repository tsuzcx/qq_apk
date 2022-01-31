import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.compat.AVCallCompactHelper.1;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.BaseActivity;

public class lmy
{
  private static final String jdField_a_of_type_JavaLangString = VideoInviteActivity.class.getName();
  private static final String b = GaInviteLockActivity.class.getName();
  private static final String c = MultiIncomingCallsActivity.class.getName();
  private final ConcurrentHashMap<String, Intent> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(3);
  
  private Intent a(String paramString)
  {
    Iterator localIterator = null;
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localIterator;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
        {
          localObject2 = localIterator;
          localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
          localObject2 = localObject1;
          localObject3 = localObject1;
          if (localIterator.hasNext())
          {
            localObject2 = localObject1;
            localObject3 = (String)localIterator.next();
            localObject2 = localObject1;
            if (lfb.a().c((String)localObject3) == null)
            {
              localObject2 = localObject1;
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject3);
              localObject2 = localObject1;
            }
            else
            {
              localObject2 = localObject1;
              localObject3 = (Intent)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject3);
              if (localObject3 != null)
              {
                localObject2 = localObject1;
                if (((Intent)localObject3).getComponent() != null)
                {
                  localObject2 = localObject1;
                  boolean bool = ((Intent)localObject3).getComponent().getClassName().equals(paramString);
                  localObject2 = localObject3;
                  if (bool) {
                    break label184;
                  }
                }
              }
              localObject2 = localObject1;
            }
          }
        }
      }
      catch (Throwable paramString)
      {
        QLog.i("CompatModeTag", 1, "getIntentByComponentClassName", paramString);
        localObject3 = localObject2;
      }
      return localObject3;
      label184:
      localObject1 = localObject2;
    }
  }
  
  public static String a(String paramString, Intent paramIntent)
  {
    int i = 100;
    Object localObject1 = null;
    StringBuilder localStringBuilder = null;
    Object localObject2 = localStringBuilder;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramIntent == null) {
        localObject2 = localStringBuilder;
      }
    }
    else {
      return localObject2;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(200);
      localStringBuilder.append("getSessionIdFromIntent").append(", class[").append(paramString).append("]").append(", intent[").append(paramIntent).append("]");
    }
    for (;;)
    {
      long l;
      if (c.equals(paramString))
      {
        localObject1 = paramIntent.getStringExtra("peerUin");
        bool = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
        int j = paramIntent.getIntExtra("uinType", 0);
        if ((j == 1) || (j == 3000))
        {
          l = paramIntent.getLongExtra("discussId", 0L);
          i = paramIntent.getIntExtra("relationType", 3);
          paramString = String.valueOf(l);
          label155:
          paramIntent = lfb.a(i, paramString, new int[0]);
          if (localStringBuilder != null) {
            localStringBuilder.append(", uinType[").append(j).append("]").append(", relationType[").append(i).append("]").append(", relationId[").append(paramString).append("]").append(", isDoubleVideoMeeting[").append(bool).append("]").append(", peerUin[").append((String)localObject1).append("]").append(", session[").append(paramIntent).append("]");
          }
          localObject1 = paramIntent;
        }
      }
      label416:
      do
      {
        for (;;)
        {
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break;
          }
          localObject2 = localObject1;
          if (localStringBuilder == null) {
            break;
          }
          QLog.i("CompatModeTag", 2, localStringBuilder.toString());
          return localObject1;
          if (bool)
          {
            i = 100;
            paramString = (String)localObject1;
            break label155;
          }
          i = 3;
          paramString = (String)localObject1;
          break label155;
          if (!b.equals(paramString)) {
            break label416;
          }
          l = paramIntent.getLongExtra("discussId", 0L);
          i = paramIntent.getIntExtra("relationType", 0);
          paramString = lfb.a(i, String.valueOf(l), new int[0]);
          localObject1 = paramString;
          if (localStringBuilder != null)
          {
            localStringBuilder.append(", relationType[").append(i).append("]").append(", groupId[").append(l).append("]").append(", session[").append(paramString).append("]");
            localObject1 = paramString;
          }
        }
      } while (!jdField_a_of_type_JavaLangString.equals(paramString));
      localObject2 = paramIntent.getStringExtra("peerUin");
      boolean bool = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
      if (bool) {}
      for (;;)
      {
        paramString = lfb.a(i, (String)localObject2, new int[0]);
        localObject1 = paramString;
        if (localStringBuilder == null) {
          break;
        }
        localStringBuilder.append(", peerUin[").append((String)localObject2).append("]").append(", isDoubleVideoMeeting[").append(bool).append("]").append(", relationType[").append(i).append("]").append(", session[").append(paramString).append("]");
        localObject1 = paramString;
        break;
        i = 3;
      }
      localStringBuilder = null;
    }
  }
  
  private void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("CompatModeTag", 1, "clearIntents", localThrowable);
    }
  }
  
  private Intent b(String paramString)
  {
    try
    {
      paramString = (Intent)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.i("CompatModeTag", 1, "getIntentByKey", paramString);
    }
    return null;
  }
  
  private void b(String paramString, Intent paramIntent)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramIntent);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.i("CompatModeTag", 1, "addIntent", paramString);
    }
  }
  
  private Intent c(String paramString)
  {
    try
    {
      paramString = (Intent)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.i("CompatModeTag", 1, "removeIntent", paramString);
    }
    return null;
  }
  
  public Runnable a(BaseActivity paramBaseActivity, VideoAppInterface paramVideoAppInterface)
  {
    Object localObject2 = null;
    Object localObject1 = lfb.a().a();
    if (localObject1 != null) {
      c(((lid)localObject1).c);
    }
    Intent localIntent = a(c);
    localObject1 = localObject2;
    if (localIntent != null)
    {
      localObject1 = localObject2;
      if (paramBaseActivity != null)
      {
        localObject1 = localObject2;
        if (paramVideoAppInterface != null)
        {
          localObject1 = new AVCallCompactHelper.1(this, paramBaseActivity);
          paramVideoAppInterface.a().postDelayed((Runnable)localObject1, 1000L);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("CompatModeTag", 2, "checkThirdCallIntent , activity[" + paramBaseActivity + "], app[" + paramVideoAppInterface + "], multiCallIntent[" + localIntent + "]");
    }
    return localObject1;
  }
  
  public void a(Intent paramIntent)
  {
    String str2 = null;
    String str1 = str2;
    if (paramIntent != null)
    {
      str1 = str2;
      if (paramIntent.getComponent() != null) {
        str1 = paramIntent.getComponent().getClassName();
      }
    }
    if ((jdField_a_of_type_JavaLangString.equals(str1)) || (b.equals(str1))) {
      a();
    }
    str2 = a(str1, paramIntent);
    if (!TextUtils.isEmpty(str2)) {
      b(str2, paramIntent);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CompatModeTag", 2, "saveCallIntent , class[" + str1 + "], session[" + str2 + "], intent[" + paramIntent + "]");
    }
  }
  
  public void a(Runnable paramRunnable, VideoAppInterface paramVideoAppInterface)
  {
    if ((paramRunnable != null) && (paramVideoAppInterface != null)) {
      paramVideoAppInterface.a().removeCallbacks(paramRunnable);
    }
    if (QLog.isColorLevel()) {
      QLog.i("CompatModeTag", 2, "clearCallIntent");
    }
  }
  
  public void a(String paramString, Intent paramIntent)
  {
    Object localObject = null;
    String str2 = a(paramString, paramIntent);
    String str1;
    if (!TextUtils.isEmpty(str2))
    {
      paramIntent = c(str2);
      str1 = str2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CompatModeTag", 2, "clearCallIntent , class[" + paramString + "], session[" + str1 + ", intent[" + paramIntent + "]");
      }
      return;
      str1 = str2;
      paramIntent = localObject;
      if (jdField_a_of_type_JavaLangString.equals(paramString))
      {
        lid locallid = lfb.a().a();
        str1 = str2;
        paramIntent = localObject;
        if (locallid != null)
        {
          str1 = locallid.c;
          paramIntent = c(str1);
        }
      }
    }
  }
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    boolean bool2;
    if (paramBaseActivity == null)
    {
      bool2 = false;
      return bool2;
    }
    lid locallid = lfb.a().a();
    if (locallid != null) {}
    for (Object localObject1 = locallid.c;; localObject1 = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (Intent localIntent = b(locallid.c);; localIntent = null)
      {
        label74:
        boolean bool1;
        if (localIntent != null)
        {
          localObject1 = localIntent.getComponent();
          if (localObject1 == null)
          {
            localObject1 = localObject3;
            if ((!jdField_a_of_type_JavaLangString.equals(localObject1)) && (!b.equals(localObject1))) {
              break label185;
            }
            bool1 = true;
          }
        }
        for (;;)
        {
          if (bool1)
          {
            paramBaseActivity.startActivity(localIntent);
            paramBaseActivity.finish();
          }
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("CompatModeTag", 2, "checkMainCallIntent, hasMainCallIntent[" + bool1 + "], mainCallIntent[" + localIntent + "], class[" + (String)localObject1 + "]");
          return bool1;
          localObject1 = ((ComponentName)localObject1).getClassName();
          break label74;
          label185:
          localObject2 = localObject1;
          if (c.equals(localObject1))
          {
            c(locallid.c);
            localObject2 = localObject1;
          }
          bool1 = false;
          localObject1 = localObject2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lmy
 * JD-Core Version:    0.7.0.1
 */