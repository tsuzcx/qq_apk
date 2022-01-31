import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.NetAddr;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class liz
  extends liy
{
  public liz(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  protected int a()
  {
    Object localObject = (VideoAppInterface)this.mApp;
    if (((VideoAppInterface)localObject).a(0))
    {
      localObject = (lls)((VideoAppInterface)localObject).a(0);
      if (localObject != null) {
        return ((lls)localObject).b();
      }
    }
    return 4;
  }
  
  protected void a(long paramLong1, boolean paramBoolean, List<NetAddr> paramList, long paramLong2)
  {
    VideoController localVideoController = ((VideoAppInterface)this.mApp).a();
    lid locallid = localVideoController.a();
    StringBuilder localStringBuilder = new StringBuilder().append("requestRecordingAudio, isStart[").append(paramBoolean).append("], sessionid[").append(paramLong2).append("], seq[").append(paramLong1).append("], iplist[");
    if (paramList == null)
    {
      localObject = "null";
      localStringBuilder = localStringBuilder.append(localObject).append("], peerUin[");
      if (locallid != null) {
        break label159;
      }
    }
    label159:
    for (Object localObject = "null";; localObject = locallid.d)
    {
      QLog.w("AudioTransClientInterfaceHandlerExtend.runhw", 1, (String)localObject + "]");
      if ((localVideoController != null) && (locallid != null)) {
        localVideoController.a(lfx.a(locallid.d), paramBoolean, paramList, paramLong2);
      }
      return;
      localObject = Integer.valueOf(paramList.size());
      break;
    }
  }
  
  protected void a(Integer paramInteger, Object paramObject)
  {
    lek.c("AudioTransClientInterfaceHandlerExtend.runhw", "notifyEvent :" + paramInteger + "|" + paramObject);
    ((VideoAppInterface)this.mApp).a(new Object[] { paramInteger, paramObject });
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    a(Integer.valueOf(6008), new ljf(paramString1, paramString2, paramString3, paramInt));
  }
  
  protected boolean a()
  {
    boolean bool2 = false;
    Object localObject = (VideoAppInterface)this.mApp;
    boolean bool1 = bool2;
    if (((VideoAppInterface)localObject).a(0))
    {
      localObject = (lls)((VideoAppInterface)localObject).a(0);
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = (ZimuItem)((lls)localObject).a();
        bool1 = bool2;
        if (localObject != null)
        {
          localObject = ((ZimuItem)localObject).getId();
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equalsIgnoreCase("film"))) {
            break label74;
          }
        }
      }
    }
    label74:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     liz
 * JD-Core Version:    0.7.0.1
 */