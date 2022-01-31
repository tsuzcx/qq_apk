import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.util.FeedExposureHelper;
import com.tencent.biz.pubaccount.util.FeedExposureHelper.Range;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class mlf
  extends FeedExposureHelper
{
  public mlf(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public void a(FeedExposureHelper.Range paramRange)
  {
    if (paramRange != null)
    {
      int j = this.a.a.getHeaderViewsCount();
      new ArrayList();
      int i = paramRange.jdField_a_of_type_Int;
      while ((i <= paramRange.b) && (i < this.a.getCount()))
      {
        int k = i - j;
        if (k >= 0)
        {
          BaseArticleInfo localBaseArticleInfo = this.a.b(k);
          QLog.d("FeedExposureHelper", 2, "onExposure : " + localBaseArticleInfo);
          if (localBaseArticleInfo != null) {
            ReadinjoyReportUtils.a(localBaseArticleInfo, paramRange.jdField_a_of_type_Long);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mlf
 * JD-Core Version:    0.7.0.1
 */