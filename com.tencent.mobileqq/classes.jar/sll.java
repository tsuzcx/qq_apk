import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import common.config.service.QzoneConfig;

public class sll
  implements Handler.Callback
{
  private static final bhmt<sll, Void> jdField_a_of_type_Bhmt = new slm();
  private static String jdField_a_of_type_JavaLangString;
  public Handler a;
  
  public static sll a()
  {
    return (sll)jdField_a_of_type_Bhmt.b(null);
  }
  
  private static void c(sls paramsls)
  {
    if ((paramsls == null) || (paramsls.jdField_a_of_type_Slp == null) || (TextUtils.isEmpty(paramsls.jdField_a_of_type_Slp.c()))) {}
    for (;;)
    {
      return;
      try
      {
        if (jdField_a_of_type_JavaLangString == null) {
          jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "LinkReportCmds", "getVisitorNotify,getWidget,getActiveFeeds,getFeedAlert,getMainPage,getHostHBInfo,getProfileFeeds,applist.shuoshuo,applist.photo,detail.shuoshuo,detail.photo,getPassiveFeeds,getPhotoListEx,like,addComment,forward,Operation.shareOutsite");
        }
        String str = paramsls.jdField_a_of_type_Slp.c();
        if ((jdField_a_of_type_JavaLangString.contains(str)) && (paramsls.b != 0))
        {
          snb.d("WeishiBusinessLooper", "cmd error report! cmd=" + str + " retCode=" + paramsls.b + " msg=" + paramsls.jdField_a_of_type_JavaLangString + " duration=" + (System.currentTimeMillis() - paramsls.jdField_a_of_type_Long));
          return;
        }
      }
      catch (Exception paramsls)
      {
        snb.d("weishi-BusinessLooper", "reportRequest Exception:" + paramsls.getLocalizedMessage());
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
  
  public void a(sls paramsls)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = paramsls;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public void b(sls paramsls)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramsls;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      snb.d("weishi-BusinessLooper", "WeishiBusinessLooper handleMessage, msg is null");
      return true;
    }
    switch (paramMessage.what)
    {
    }
    sls localsls;
    do
    {
      do
      {
        return false;
        localsls = (sls)paramMessage.obj;
      } while (localsls == null);
      localStringBuilder = new StringBuilder().append("runTask cmd=");
      if (localsls.jdField_a_of_type_Slp != null) {}
      for (paramMessage = localsls.jdField_a_of_type_Slp.getCmdString();; paramMessage = "mRequest is null")
      {
        snb.c("weishi-BusinessLooper", paramMessage);
        localsls.a();
        break;
      }
      localsls = (sls)paramMessage.obj;
    } while (localsls == null);
    StringBuilder localStringBuilder = new StringBuilder().append("completeTask resultCode:").append(localsls.b).append(", cmd=");
    if (localsls.jdField_a_of_type_Slp != null) {}
    for (paramMessage = localsls.jdField_a_of_type_Slp.getCmdString();; paramMessage = "mRequest is null")
    {
      for (;;)
      {
        snb.d("weishi-BusinessLooper", paramMessage);
        if (localsls.jdField_a_of_type_Slh == null) {
          break;
        }
        try
        {
          c(localsls);
          localsls.jdField_a_of_type_Slh.a(localsls);
        }
        catch (Exception paramMessage)
        {
          snb.d("weishi-BusinessLooper", "handleMessage MSG_COMPLETE_TASK:" + paramMessage.getLocalizedMessage());
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sll
 * JD-Core Version:    0.7.0.1
 */