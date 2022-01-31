import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class nwy
  implements pez
{
  nwy(nww paramnww, pew parampew) {}
  
  private long a(List<ArticleInfo> paramList)
  {
    paramList = paramList.iterator();
    long l = 0L;
    if (paramList.hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)paramList.next();
      if (l >= localArticleInfo.mRecommendSeq) {
        break label50;
      }
      l = localArticleInfo.mRecommendSeq;
    }
    label50:
    for (;;)
    {
      break;
      return l;
    }
  }
  
  public List<ArticleInfo> a(int paramInt, List<ArticleInfo> paramList1, List<ArticleInfo> paramList2)
  {
    if ((!otf.c(paramInt)) || (paramList2 == null) || (paramList1 == null) || (paramList2.isEmpty())) {
      return null;
    }
    long l = a(paramList2);
    if (l < 1000L)
    {
      QLog.d("ReadInJoyDailyViewController", 1, "onPreDeal : " + l);
      return null;
    }
    paramList2 = new ArrayList();
    if (!nww.a())
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)paramList1.next();
        if ((localArticleInfo.mRecommendSeq > 0L) && (localArticleInfo.mRecommendSeq < 1000L))
        {
          localArticleInfo.mRecommendSeq += l;
          paramList2.add(localArticleInfo);
          QLog.d("ReadInJoyDailyViewController", 1, "onPreDeal : " + l + "  seq: " + localArticleInfo.mRecommendSeq);
        }
      }
    }
    bkbq.a(nww.a(), Boolean.valueOf(true));
    nww.a(true);
    this.jdField_a_of_type_Pew.a(null);
    return paramList2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nwy
 * JD-Core Version:    0.7.0.1
 */