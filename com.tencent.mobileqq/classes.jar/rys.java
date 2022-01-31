import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import common.config.service.QzoneConfig;

public class rys
  implements Handler.Callback
{
  private static final bgdp<rys, Void> jdField_a_of_type_Bgdp = new ryt();
  private static String jdField_a_of_type_JavaLangString;
  public Handler a;
  
  public static rys a()
  {
    return (rys)jdField_a_of_type_Bgdp.b(null);
  }
  
  private static void c(ryz paramryz)
  {
    if ((paramryz == null) || (paramryz.jdField_a_of_type_Ryw == null) || (TextUtils.isEmpty(paramryz.jdField_a_of_type_Ryw.c()))) {}
    for (;;)
    {
      return;
      try
      {
        if (jdField_a_of_type_JavaLangString == null) {
          jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "LinkReportCmds", "getVisitorNotify,getWidget,getActiveFeeds,getFeedAlert,getMainPage,getHostHBInfo,getProfileFeeds,applist.shuoshuo,applist.photo,detail.shuoshuo,detail.photo,getPassiveFeeds,getPhotoListEx,like,addComment,forward,Operation.shareOutsite");
        }
        String str = paramryz.jdField_a_of_type_Ryw.c();
        if ((jdField_a_of_type_JavaLangString.contains(str)) && (paramryz.b != 0))
        {
          sai.d("WeishiBusinessLooper", "cmd error report! cmd=" + str + " retCode=" + paramryz.b + " msg=" + paramryz.jdField_a_of_type_JavaLangString + " duration=" + (System.currentTimeMillis() - paramryz.jdField_a_of_type_Long));
          return;
        }
      }
      catch (Exception paramryz)
      {
        sai.d("weishi-BusinessLooper", "reportRequest Exception:" + paramryz.getLocalizedMessage());
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
  
  public void a(ryz paramryz)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = paramryz;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public void b(ryz paramryz)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramryz;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      sai.d("weishi-BusinessLooper", "WeishiBusinessLooper handleMessage, msg is null");
      return true;
    }
    switch (paramMessage.what)
    {
    }
    ryz localryz;
    do
    {
      do
      {
        return false;
        localryz = (ryz)paramMessage.obj;
      } while (localryz == null);
      localStringBuilder = new StringBuilder().append("runTask cmd=");
      if (localryz.jdField_a_of_type_Ryw != null) {}
      for (paramMessage = localryz.jdField_a_of_type_Ryw.getCmdString();; paramMessage = "mRequest is null")
      {
        sai.c("weishi-BusinessLooper", paramMessage);
        localryz.a();
        break;
      }
      localryz = (ryz)paramMessage.obj;
    } while (localryz == null);
    StringBuilder localStringBuilder = new StringBuilder().append("completeTask resultCode:").append(localryz.b).append(", cmd=");
    if (localryz.jdField_a_of_type_Ryw != null) {}
    for (paramMessage = localryz.jdField_a_of_type_Ryw.getCmdString();; paramMessage = "mRequest is null")
    {
      for (;;)
      {
        sai.d("weishi-BusinessLooper", paramMessage);
        if (localryz.jdField_a_of_type_Ryo == null) {
          break;
        }
        try
        {
          c(localryz);
          localryz.jdField_a_of_type_Ryo.a(localryz);
        }
        catch (Exception paramMessage)
        {
          sai.d("weishi-BusinessLooper", "handleMessage MSG_COMPLETE_TASK:" + paramMessage.getLocalizedMessage());
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rys
 * JD-Core Version:    0.7.0.1
 */