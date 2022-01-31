import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class rbe
  extends sdq
{
  rbe(ram paramram) {}
  
  public void a(sdr paramsdr)
  {
    if (paramsdr != null)
    {
      int j = this.a.a.getHeaderViewsCount();
      new ArrayList();
      int i = paramsdr.jdField_a_of_type_Int;
      while (i <= paramsdr.b)
      {
        int k = i - j;
        if (k >= 0)
        {
          BaseArticleInfo localBaseArticleInfo = this.a.b(k);
          if (localBaseArticleInfo != null)
          {
            QLog.d("FeedExposureHelper", 2, "onExposure : " + localBaseArticleInfo + " proteusItemsData : " + localBaseArticleInfo.proteusItemsData);
            shu.a(localBaseArticleInfo, paramsdr.jdField_a_of_type_Long);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rbe
 * JD-Core Version:    0.7.0.1
 */