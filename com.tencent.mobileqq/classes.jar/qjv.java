import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeGridImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class qjv
{
  private List<sqw> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<URL> b = new ArrayList();
  
  public qjv(NativeGridImageView paramNativeGridImageView, ArticleInfo paramArticleInfo)
  {
    int i;
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.a != null) && (paramArticleInfo.mSocialFeedInfo.a.a != null) && (paramArticleInfo.mSocialFeedInfo.a.a.size() > 0))
    {
      paramArticleInfo = paramArticleInfo.mSocialFeedInfo.a.a;
      i = 0;
    }
    for (;;)
    {
      if (i < paramArticleInfo.size()) {}
      try
      {
        int j = this.jdField_a_of_type_JavaUtilList.size();
        if (j >= 9)
        {
          if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
            ((sqw)this.jdField_a_of_type_JavaUtilList.get(0)).a(true);
          }
          return;
        }
        if ((((rff)paramArticleInfo.get(i)).jdField_b_of_type_JavaLangString != null) || (((rff)paramArticleInfo.get(i)).jdField_c_of_type_JavaLangString != null))
        {
          Object localObject;
          label255:
          int k;
          if (((rff)paramArticleInfo.get(i)).jdField_b_of_type_JavaLangString != null)
          {
            paramNativeGridImageView = ((rff)paramArticleInfo.get(i)).jdField_b_of_type_JavaLangString;
            localObject = new URL(paramNativeGridImageView);
            if (((rff)paramArticleInfo.get(i)).jdField_c_of_type_JavaLangString == null) {
              break label374;
            }
            paramNativeGridImageView = ((rff)paramArticleInfo.get(i)).jdField_c_of_type_JavaLangString;
            paramNativeGridImageView = new URL(paramNativeGridImageView);
            this.b.add(localObject);
            localObject = this.jdField_a_of_type_JavaUtilList;
            j = ((rff)paramArticleInfo.get(i)).a;
            k = ((rff)paramArticleInfo.get(i)).jdField_b_of_type_Int;
            if (((rff)paramArticleInfo.get(i)).jdField_c_of_type_Int != 1) {
              break label391;
            }
          }
          label391:
          for (boolean bool = true;; bool = false)
          {
            ((List)localObject).add(new sqw(j, k, paramNativeGridImageView, bool));
            break label410;
            paramNativeGridImageView = ((rff)paramArticleInfo.get(i)).jdField_c_of_type_JavaLangString;
            break;
            label374:
            paramNativeGridImageView = ((rff)paramArticleInfo.get(i)).jdField_b_of_type_JavaLangString;
            break label255;
          }
        }
      }
      catch (Exception paramNativeGridImageView)
      {
        paramNativeGridImageView.printStackTrace();
        QLog.d("Proteus.NativeGridImageView", 1, "GridImageModel exception.");
        label410:
        i += 1;
      }
    }
  }
  
  public List<sqw> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<URL> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qjv
 * JD-Core Version:    0.7.0.1
 */