import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyJumpActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyJumpActivity.2.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class olz
  extends pfh
{
  public olz(ReadinjoyJumpActivity paramReadinjoyJumpActivity) {}
  
  public void a(String paramString)
  {
    super.a(paramString);
    QLog.d("ReadinjoyJumpActivity", 1, "webCallback : " + paramString);
    ThreadManager.getUIHandler().post(new ReadinjoyJumpActivity.2.1(this));
  }
  
  public void a(boolean paramBoolean, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    QLog.d("ReadinjoyJumpActivity", 1, "68b resp, succ : " + paramBoolean + ", ids : " + paramList + ", articles : " + paramList1);
    if ((paramList == null) || (!paramList.contains(Long.valueOf(ReadinjoyJumpActivity.a(this.a))))) {}
    do
    {
      return;
      ThreadManager.getUIHandler().removeCallbacks(ReadinjoyJumpActivity.a(this.a));
    } while ((ReadinjoyJumpActivity.a(this.a)) || (ReadinjoyJumpActivity.b(this.a)));
    if ((paramBoolean) && (paramList1 != null) && (!paramList1.isEmpty()))
    {
      int i = 0;
      while (i < paramList1.size())
      {
        paramList = (ArticleInfo)paramList1.get(i);
        if (paramList.mArticleID == ReadinjoyJumpActivity.a(this.a))
        {
          ReadinjoyJumpActivity.a(this.a, paramList);
          if ((pac.a(ReadinjoyJumpActivity.a(this.a)) == 0) && (ozs.a(ReadinjoyJumpActivity.a(this.a).mArticleContentUrl, 0L, ReadinjoyJumpActivity.a(this.a))))
          {
            paramList = pfa.a().a();
            if (paramList != null)
            {
              paramList.a(ReadinjoyJumpActivity.a(this.a).mArticleContentUrl, ReadinjoyJumpActivity.a(this.a).innerUniqueID, ReadinjoyJumpActivity.a(this.a).publishUin + "", 1, this.a);
              return;
            }
          }
          ReadinjoyJumpActivity.b(this.a);
          return;
        }
        i += 1;
      }
    }
    ReadinjoyJumpActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     olz
 * JD-Core Version:    0.7.0.1
 */