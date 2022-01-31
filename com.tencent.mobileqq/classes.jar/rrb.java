import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class rrb
  extends svj
{
  rrb(rqj paramrqj) {}
  
  public void a(svk paramsvk)
  {
    if (paramsvk != null)
    {
      int j = this.a.a.getHeaderViewsCount();
      new ArrayList();
      int i = paramsvk.jdField_a_of_type_Int;
      while (i <= paramsvk.b)
      {
        int k = i - j;
        if (k >= 0)
        {
          BaseArticleInfo localBaseArticleInfo = this.a.b(k);
          if (localBaseArticleInfo != null)
          {
            QLog.d("FeedExposureHelper", 2, "onExposure : " + localBaseArticleInfo + " proteusItemsData : " + localBaseArticleInfo.proteusItemsData);
            szp.a(localBaseArticleInfo, paramsvk.jdField_a_of_type_Long);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rrb
 * JD-Core Version:    0.7.0.1
 */