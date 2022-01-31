import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.statistics.ReportController;

public class sha
  extends ConfigObserver
{
  public sha(Conversation paramConversation) {}
  
  protected void a(Boolean paramBoolean1, Boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if ((!paramBoolean1.booleanValue()) && (paramBoolean2.booleanValue()) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      ReportController.b(this.a.a, "dc00898", "", "", "0X8008272", "0X8008272", 0, 0, "", "", "", "");
      this.a.a(new shb(this, paramString3, paramString1, paramString2));
    }
  }
  
  protected void a(boolean paramBoolean, AppShareID paramAppShareID)
  {
    if (paramBoolean) {
      this.a.a(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sha
 * JD-Core Version:    0.7.0.1
 */