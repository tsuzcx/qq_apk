import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo.2;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo.2.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class tav
  implements pwx
{
  public tav(FastWebArticleInfo.2 param2) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramBoolean1) && (paramFastWebArticleInfo != null))
    {
      this.a.this$0.jdField_b_of_type_Long = paramFastWebArticleInfo.jdField_b_of_type_Long;
      if (paramFastWebArticleInfo.a > this.a.this$0.a) {
        this.a.this$0.a = paramFastWebArticleInfo.a;
      }
      this.a.this$0.jdField_b_of_type_Boolean = false;
      QLog.d("Q.readinjoy.fast_web", 2, "update fastweb info, rowkey : " + paramFastWebArticleInfo.j + ",  commentCnt : " + paramFastWebArticleInfo.jdField_b_of_type_Long + ", readCnt :" + paramFastWebArticleInfo.a);
    }
    ThreadManager.getUIHandler().post(new FastWebArticleInfo.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tav
 * JD-Core Version:    0.7.0.1
 */