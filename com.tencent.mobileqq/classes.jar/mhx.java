import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.qphone.base.util.QLog;

public class mhx
{
  public static int a(VideoAppInterface paramVideoAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt1 == 19) && (!TextUtils.isEmpty(paramString))) {
      return paramVideoAppInterface.a(paramString);
    }
    return VideoController.a(paramInt1, false, paramInt2);
  }
  
  public static Intent a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = ksn.a().b(paramString);
    } while (paramString == null);
    try
    {
      paramContext = new Intent(paramContext, GaInviteLockActivity.class);
      paramContext.addFlags(268435456);
      a(paramContext, paramString);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QLog.i("QAVNotificationUtil", 1, "getGroupInviteIntent error", paramContext);
        paramContext = null;
      }
    }
  }
  
  public static String a(ktl paramktl)
  {
    long l = paramktl.jdField_d_of_type_Long;
    switch (paramktl.e)
    {
    default: 
      return String.valueOf(l);
    }
    return paramktl.jdField_b_of_type_JavaLangString + paramktl.a;
  }
  
  public static void a(Intent paramIntent, kvq paramkvq)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramkvq.r);
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    paramIntent.putExtra("uinType", paramkvq.i);
    paramIntent.putExtra("peerUin", paramkvq.r);
    paramIntent.putExtra("friendUin", l1);
    paramIntent.putExtra("relationType", paramkvq.C);
    paramIntent.putExtra("MultiAVType", paramkvq.A);
    paramIntent.putExtra("discussId", paramkvq.g);
    paramIntent.putExtra("memberList", paramkvq.a);
  }
  
  public static void a(String paramString1, String paramString2, VideoAppInterface paramVideoAppInterface, ktl paramktl)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CompatModeTag", 2, "showInviteNotification videoPacket[" + paramktl + "], session[" + paramString2 + "], from[" + paramString1 + "]");
    }
    paramString1 = String.valueOf(paramktl.c);
    int i = a(paramVideoAppInterface, paramktl.e, paramString1, 0);
    String str = a(paramktl);
    boolean bool;
    int j;
    if (paramktl.jdField_d_of_type_Int == 1)
    {
      bool = true;
      j = paramktl.jdField_b_of_type_Int;
    }
    for (;;)
    {
      try
      {
        if (paramVideoAppInterface.a().a(i, paramString1, str, null, bool, null, 0, j)) {
          break label145;
        }
        QLog.w("CompatModeTag", 1, "showNotification() return ! isRequestVideo = false");
        return;
      }
      catch (Exception paramString1)
      {
        QLog.w("CompatModeTag", 1, "showNotification() return ! Exception = ", paramString1);
        return;
      }
      bool = false;
      break;
      label145:
      Object localObject = mht.a(paramVideoAppInterface);
      Bitmap localBitmap = paramVideoAppInterface.a(i, paramString1, str, true, true);
      paramVideoAppInterface = paramVideoAppInterface.getDisplayName(i, paramString1, str);
      if (mfs.a()) {
        if (bool) {
          ((mht)localObject).a(true, paramString2, paramVideoAppInterface, localBitmap, null, 45, i, 1, null);
        }
      }
      while (QLog.isColorLevel())
      {
        localObject = new StringBuilder(200);
        ((StringBuilder)localObject).append("showNotification, isAudioMode=").append(bool).append(", sessionId=").append(paramString2).append(", uinType=").append(i).append(", peerUin=").append(paramString1).append(", extraUin=").append(str).append(", face=").append(localBitmap).append(", peerName=").append(paramVideoAppInterface).append(", videoPacket=").append(paramktl);
        QLog.i("CompatModeTag", 2, ((StringBuilder)localObject).toString());
        return;
        ((mht)localObject).a(true, paramString2, paramVideoAppInterface, localBitmap, null, 40, i, 2, null);
        continue;
        if (bool) {
          ((mht)localObject).a(false, paramString2, paramVideoAppInterface, localBitmap, null, 45, i, 1);
        } else {
          ((mht)localObject).a(false, paramString2, paramVideoAppInterface, localBitmap, null, 40, i, 2);
        }
      }
    }
  }
  
  public static boolean a(Intent paramIntent)
  {
    boolean bool2 = false;
    String str = null;
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("Fromwhere");
    }
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (str.compareTo("AVNotification") == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static Intent b(Context paramContext, String paramString)
  {
    paramContext = new Intent(paramContext, MultiIncomingCallsActivity.class);
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramContext;
      paramString = ksn.a().b(paramString);
    } while (paramString == null);
    paramContext.putExtra("sessionType", paramString.jdField_d_of_type_Int);
    if (mfs.b(paramString.i))
    {
      a(paramContext, paramString);
      return paramContext;
    }
    b(paramContext, paramString);
    return paramContext;
  }
  
  public static void b(Intent paramIntent, kvq paramkvq)
  {
    paramIntent.putExtra("uinType", paramkvq.i);
    paramIntent.putExtra("relationType", mjg.b(paramkvq.i));
    paramIntent.putExtra("peerUin", paramkvq.jdField_d_of_type_JavaLangString);
    paramIntent.putExtra("extraUin", paramkvq.f);
    paramIntent.putExtra("isAudioMode", paramkvq.Q);
    paramIntent.putExtra("isDoubleVideoMeeting", paramkvq.I);
    paramIntent.putExtra("bindType", paramkvq.x);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mhx
 * JD-Core Version:    0.7.0.1
 */