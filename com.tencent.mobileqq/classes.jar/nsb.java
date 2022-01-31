import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.data.ArkAppMessage;
import mqq.app.AppRuntime;

public class nsb
{
  private View a;
  
  public nsb(ArkAppMessage paramArkAppMessage, BaseArticleInfo paramBaseArticleInfo)
  {
    if (obz.a() != null)
    {
      paramArkAppMessage = obz.a().getApplication();
      if (paramArkAppMessage != null) {}
    }
    else
    {
      return;
    }
    this.a = new View(paramArkAppMessage);
    this.a.setVisibility(8);
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a() {}
  
  public void a(ArkAppMessage paramArkAppMessage, BaseArticleInfo paramBaseArticleInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsb
 * JD-Core Version:    0.7.0.1
 */