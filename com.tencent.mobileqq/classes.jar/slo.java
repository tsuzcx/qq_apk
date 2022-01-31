import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import common.config.service.QzoneConfig;

public class slo
  implements Handler.Callback
{
  private static final bhmc<slo, Void> jdField_a_of_type_Bhmc = new slp();
  private static String jdField_a_of_type_JavaLangString;
  public Handler a;
  
  public static slo a()
  {
    return (slo)jdField_a_of_type_Bhmc.b(null);
  }
  
  private static void c(slv paramslv)
  {
    if ((paramslv == null) || (paramslv.jdField_a_of_type_Sls == null) || (TextUtils.isEmpty(paramslv.jdField_a_of_type_Sls.c()))) {}
    for (;;)
    {
      return;
      try
      {
        if (jdField_a_of_type_JavaLangString == null) {
          jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "LinkReportCmds", "getVisitorNotify,getWidget,getActiveFeeds,getFeedAlert,getMainPage,getHostHBInfo,getProfileFeeds,applist.shuoshuo,applist.photo,detail.shuoshuo,detail.photo,getPassiveFeeds,getPhotoListEx,like,addComment,forward,Operation.shareOutsite");
        }
        String str = paramslv.jdField_a_of_type_Sls.c();
        if ((jdField_a_of_type_JavaLangString.contains(str)) && (paramslv.b != 0))
        {
          sne.d("WeishiBusinessLooper", "cmd error report! cmd=" + str + " retCode=" + paramslv.b + " msg=" + paramslv.jdField_a_of_type_JavaLangString + " duration=" + (System.currentTimeMillis() - paramslv.jdField_a_of_type_Long));
          return;
        }
      }
      catch (Exception paramslv)
      {
        sne.d("weishi-BusinessLooper", "reportRequest Exception:" + paramslv.getLocalizedMessage());
      }
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public void a(slv paramslv)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = paramslv;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public void b(slv paramslv)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramslv;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      sne.d("weishi-BusinessLooper", "WeishiBusinessLooper handleMessage, msg is null");
      return true;
    }
    switch (paramMessage.what)
    {
    }
    slv localslv;
    do
    {
      do
      {
        return false;
        localslv = (slv)paramMessage.obj;
      } while (localslv == null);
      localStringBuilder = new StringBuilder().append("runTask cmd=");
      if (localslv.jdField_a_of_type_Sls != null) {}
      for (paramMessage = localslv.jdField_a_of_type_Sls.getCmdString();; paramMessage = "mRequest is null")
      {
        sne.c("weishi-BusinessLooper", paramMessage);
        localslv.a();
        break;
      }
      localslv = (slv)paramMessage.obj;
    } while (localslv == null);
    StringBuilder localStringBuilder = new StringBuilder().append("completeTask resultCode:").append(localslv.b).append(", cmd=");
    if (localslv.jdField_a_of_type_Sls != null) {}
    for (paramMessage = localslv.jdField_a_of_type_Sls.getCmdString();; paramMessage = "mRequest is null")
    {
      for (;;)
      {
        sne.d("weishi-BusinessLooper", paramMessage);
        if (localslv.jdField_a_of_type_Slk == null) {
          break;
        }
        try
        {
          c(localslv);
          localslv.jdField_a_of_type_Slk.a(localslv);
        }
        catch (Exception paramMessage)
        {
          sne.d("weishi-BusinessLooper", "handleMessage MSG_COMPLETE_TASK:" + paramMessage.getLocalizedMessage());
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     slo
 * JD-Core Version:    0.7.0.1
 */