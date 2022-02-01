import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class pmg
{
  public static boolean a(int paramInt)
  {
    Object localObject = (QQAppInterface)ozs.a();
    if (localObject != null)
    {
      localObject = (pfg)((QQAppInterface)localObject).getManager(163);
      if ((localObject != null) && (((pfg)localObject).a() != null))
      {
        localObject = ((pfg)localObject).a().b();
        if ((localObject == null) || (((List)localObject).isEmpty()))
        {
          QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[isInMyChannelList] res = false, myChannelList is empty.");
          return false;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramInt == ((TabChannelCoverInfo)((Iterator)localObject).next()).mChannelCoverId)
          {
            QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[isInMyChannelList] res = true, channelID = " + paramInt);
            return true;
          }
        }
      }
    }
    QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[isInMyChannelList] res = false, channelID = " + paramInt);
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, true);
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.d("ReadInJoyChannelGuidingJumpUtils", 1, "context or scheme is null");
      return false;
    }
    QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[jumpToChannel], scheme = " + paramString);
    Object localObject = Uri.parse(paramString);
    String str1 = ((Uri)localObject).getQueryParameter("target");
    String str2 = ((Uri)localObject).getQueryParameter("channelid");
    String str3 = ((Uri)localObject).getQueryParameter("ispush");
    QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[jumpToChannel], target = " + str1 + ", channelID = " + str2 + ", isPush = " + str3 + ",doDynamicOrder = " + paramBoolean);
    int i = -1;
    try
    {
      int j = Integer.parseInt(str2);
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("ReadInJoyChannelGuidingJumpUtils", 1, "[jumpToChannel], e = " + localNumberFormatException);
      }
      if (!paramBoolean) {
        break label301;
      }
      paramBoolean = bnrf.B();
      if ((!paramBoolean) || (!b(i))) {
        break label362;
      }
      if (c(i)) {
        break label318;
      }
      QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[jumpToChannel] channelID = " + str2 + " not my channel");
      pfa.a().c(i, 1);
      if (!a(str3, i)) {
        break label400;
      }
      ozs.a(paramContext, paramString, null);
      for (;;)
      {
        return true;
        QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[jumpToChannel] channelID = " + str2 + " is my channel");
        pfa.a().a(i, 1, false, true);
        break;
        QLog.d("ReadInJoyChannelGuidingJumpUtils", 1, "[jumpToChannel] isDynamicOrderSwitchOn = " + paramBoolean + ", channelID = " + str2);
        break;
        paramContext.startActivity(oix.b(paramContext, 0, i));
      }
      QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[jumpToChannel] failed, target = " + str1 + ", scheme = " + paramString);
    }
    localObject = ((Uri)localObject).getQueryParameter("v_url_base64");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ReadInJoyViolaChannelFragment.a(i, (String)localObject);
    }
    if (("2".equals(str1)) && (!TextUtils.isEmpty(str2))) {
      if (pmj.a(paramContext, paramString))
      {
        QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[jumpToChannel], jump to recommend channel, using floating window.");
        return true;
      }
    }
    label301:
    label318:
    label362:
    return false;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    boolean bool1 = TextUtils.equals(paramString, "1");
    boolean bool2 = bnrf.h();
    boolean bool3 = a(paramInt);
    QLog.i("ReadInJoyChannelGuidingJumpUtils", 1, "[shouldPushNewPage, isPushBoolean = " + bool1 + ", KDTab = " + bool2 + ", isInMyChannel = " + bool3 + ", channelID = " + paramInt);
    return (bool1) || (!bool2) || (!bool3);
  }
  
  private static boolean b(int paramInt)
  {
    boolean bool2 = false;
    List localList = pfa.a().a();
    boolean bool1 = bool2;
    int i;
    if (localList != null)
    {
      bool1 = bool2;
      if (localList.size() > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      qvr localqvr;
      int j;
      if (i < localList.size())
      {
        localqvr = (qvr)localList.get(i);
        j = 0;
      }
      while (j < localqvr.a.size())
      {
        if (paramInt == ((TabChannelCoverInfo)localqvr.a.get(j)).mChannelCoverId)
        {
          bool1 = true;
          return bool1;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  private static boolean c(int paramInt)
  {
    boolean bool2 = false;
    Object localObject = pfa.a().a();
    boolean bool1 = bool2;
    int i;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((List)localObject).size() > 0)
      {
        localObject = (qvr)((List)localObject).get(0);
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < ((qvr)localObject).a.size())
      {
        if (paramInt == ((TabChannelCoverInfo)((qvr)localObject).a.get(i)).mChannelCoverId) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pmg
 * JD-Core Version:    0.7.0.1
 */