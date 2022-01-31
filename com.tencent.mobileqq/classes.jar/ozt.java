import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule.3;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule.4;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class ozt
  extends pbe
{
  private HashMap<Long, ArticleReadInfo> jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public ozt(AppInterface paramAppInterface, aukp paramaukp, ExecutorService paramExecutorService, por parampor, Handler paramHandler)
  {
    super(paramAppInterface, paramaukp, paramExecutorService, parampor, paramHandler);
  }
  
  private void a(List<ArticleReadInfo> paramList)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleReadInfoModule.2(this, paramList));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      QLog.d("ArticleReadInfoModule", 1, "article read info has loaded");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleReadInfoModule.1(this));
  }
  
  public void a(long paramLong)
  {
    ArticleReadInfo localArticleReadInfo = (ArticleReadInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localArticleReadInfo != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleReadInfoModule.4(this, localArticleReadInfo));
    }
    QLog.d("ArticleInfo", 2, "DeleteArticle ReadInfo , articleID : " + paramLong);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ArticleReadInfo localArticleReadInfo = (ArticleReadInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localArticleReadInfo == null)
    {
      localArticleReadInfo = new ArticleReadInfo();
      localArticleReadInfo.mArticleID = paramLong1;
      localArticleReadInfo.mLastReadTime = paramLong2;
    }
    for (localArticleReadInfo.mIsRead = true;; localArticleReadInfo.mIsRead = true)
    {
      a(localArticleReadInfo);
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ArticleReadInfoModule.3(this, localArticleReadInfo));
      return;
      localArticleReadInfo.mLastReadTime = paramLong2;
    }
  }
  
  public void a(ArticleReadInfo paramArticleReadInfo)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramArticleReadInfo.mArticleID), paramArticleReadInfo);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)) != null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozt
 * JD-Core Version:    0.7.0.1
 */