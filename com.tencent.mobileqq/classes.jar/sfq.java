import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class sfq
  extends twz
{
  sfq(sel paramsel) {}
  
  public void a(txa paramtxa)
  {
    if (paramtxa != null)
    {
      int j = this.a.a.getHeaderViewsCount();
      new ArrayList();
      int i = paramtxa.jdField_a_of_type_Int;
      while (i <= paramtxa.b)
      {
        int k = i - j;
        if (k >= 0)
        {
          BaseArticleInfo localBaseArticleInfo = this.a.b(k);
          if (localBaseArticleInfo != null)
          {
            QLog.d("FeedExposureHelper", 2, "onExposure : " + localBaseArticleInfo + " proteusItemsData : " + localBaseArticleInfo.proteusItemsData);
            ubg.a(localBaseArticleInfo, paramtxa.jdField_a_of_type_Long);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfq
 * JD-Core Version:    0.7.0.1
 */