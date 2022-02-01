import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class som
  extends twx
{
  som(snh paramsnh) {}
  
  public void a(twy paramtwy)
  {
    if (paramtwy != null)
    {
      int j = this.a.a.getHeaderViewsCount();
      new ArrayList();
      int i = paramtwy.jdField_a_of_type_Int;
      while (i <= paramtwy.b)
      {
        int k = i - j;
        if (k >= 0)
        {
          BaseArticleInfo localBaseArticleInfo = this.a.b(k);
          if (localBaseArticleInfo != null)
          {
            QLog.d("FeedExposureHelper", 2, "onExposure : " + localBaseArticleInfo + " proteusItemsData : " + localBaseArticleInfo.proteusItemsData);
            ube.a(localBaseArticleInfo, paramtwy.jdField_a_of_type_Long);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     som
 * JD-Core Version:    0.7.0.1
 */