import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ItemDatasListUtils;
import com.tencent.qphone.base.util.QLog;

class mpo
  implements Runnable
{
  mpo(mpm parammpm, FastWebArticleInfo paramFastWebArticleInfo, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (FastWebActivity.a(this.jdField_a_of_type_Mpm.a) == null) || (!FastWebActivity.a(this.jdField_a_of_type_Mpm.a).innerUniqueID.equals(this.jdField_a_of_type_JavaLangString)))
    {
      QLog.d(FastWebActivity.a(this.jdField_a_of_type_Mpm.a), 2, "get article topic info fail, msg not match !");
      return;
    }
    ItemDatasListUtils.a(this.jdField_a_of_type_Boolean, FastWebActivity.a(this.jdField_a_of_type_Mpm.a), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, FastWebActivity.a(this.jdField_a_of_type_Mpm.a));
    FastWebActivity.a(this.jdField_a_of_type_Mpm.a).notifyDataSetChanged();
    this.jdField_a_of_type_Mpm.a.a(FastWebActivity.a(this.jdField_a_of_type_Mpm.a));
    QLog.d(FastWebActivity.a(this.jdField_a_of_type_Mpm.a), 2, "get article topic info success! notify ui bindData");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mpo
 * JD-Core Version:    0.7.0.1
 */