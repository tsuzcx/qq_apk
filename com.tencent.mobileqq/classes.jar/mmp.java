import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.FastWebContentGetCallback;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class mmp
  implements FastWebModule.FastWebContentGetCallback
{
  mmp(mmo parammmo) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramBoolean1) && (paramFastWebArticleInfo != null))
    {
      this.a.a.b = paramFastWebArticleInfo.b;
      if (paramFastWebArticleInfo.jdField_a_of_type_Long > this.a.a.jdField_a_of_type_Long) {
        this.a.a.jdField_a_of_type_Long = paramFastWebArticleInfo.jdField_a_of_type_Long;
      }
      this.a.a.jdField_a_of_type_Boolean = false;
      QLog.d("Q.readinjoy.fast_web", 2, "update fastweb info, rowkey : " + paramFastWebArticleInfo.j + ",  commentCnt : " + paramFastWebArticleInfo.b + ", readCnt :" + paramFastWebArticleInfo.jdField_a_of_type_Long);
    }
    ThreadManager.getUIHandler().post(new mmq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mmp
 * JD-Core Version:    0.7.0.1
 */