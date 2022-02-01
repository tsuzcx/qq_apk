import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class lfr
  extends lfq
{
  static long b;
  
  public lfr(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    int i;
    long l1;
    if (((lhz)paramVideoAppInterface.a(5)).a(0, "750") == 1)
    {
      i = 1;
      l1 = AudioHelper.a();
      if (i == 0) {
        break label214;
      }
      i = 12;
      localObject = (lfq)paramVideoAppInterface.a(1);
    }
    for (Object localObject = paramString2 + "|" + ((lfq)localObject).a() + "|" + paramLong + "|" + l1;; localObject = paramString2)
    {
      long l2 = b;
      b = l1;
      QLog.w("AudioTransClientInfoHandler", 1, "sendZimuCmd, id[" + paramString2 + "], cmdInfo[" + (String)localObject + "], autoDetect[" + true + "], from[" + paramString1 + "], seq[" + paramLong + "], sendTime[" + l1 + "], sendInterval[" + (l1 - l2) + "]");
      paramVideoAppInterface.a().a(i, (String)localObject);
      return;
      i = 0;
      break;
      label214:
      i = 7;
    }
  }
  
  int a()
  {
    int i = 100;
    if (AppNetConnInfo.isWifiConn()) {
      i = 2;
    }
    while (!AppNetConnInfo.isMobileConn()) {
      return i;
    }
    switch (AppNetConnInfo.getMobileInfo())
    {
    default: 
      return 100;
    case 1: 
      return 4;
    case 2: 
      return 3;
    }
    return 5;
  }
  
  void a(long paramLong1, long paramLong2)
  {
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)this.mApp;
    ZimuItem localZimuItem = (ZimuItem)((lip)localVideoAppInterface.a(0)).a();
    if ((localZimuItem != null) && (!TextUtils.isEmpty(localZimuItem.getId()))) {
      a(localVideoAppInterface, "sendToPeer", paramLong1, localZimuItem.getId(), true);
    }
  }
  
  int b()
  {
    return mue.b();
  }
  
  String b()
  {
    VideoController localVideoController = ((VideoAppInterface)this.mApp).a();
    if ((localVideoController != null) && (localVideoController.a() != null)) {
      return localVideoController.a().d;
    }
    return "";
  }
  
  boolean b()
  {
    return ((lip)((VideoAppInterface)this.mApp).a(0)).b();
  }
  
  boolean c()
  {
    return ((lft)this.mApp.getBusinessHandler(0)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfr
 * JD-Core Version:    0.7.0.1
 */