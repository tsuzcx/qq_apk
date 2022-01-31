import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;

public class lpl
  implements Runnable
{
  public lpl(ArticleInfoModule paramArticleInfoModule) {}
  
  public void run()
  {
    SosoInterface.a(ArticleInfoModule.a(), "PublicAccountManager");
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 2, "0x68b lbs info start location");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lpl
 * JD-Core Version:    0.7.0.1
 */