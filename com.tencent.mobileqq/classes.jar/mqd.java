import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ItemDatasListUtils;
import java.util.List;

class mqd
  implements Runnable
{
  mqd(mqc parammqc, boolean paramBoolean, String paramString, List paramList1, List paramList2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (FastWebActivity.a(this.jdField_a_of_type_Mqc.a) != null) && (FastWebActivity.a(this.jdField_a_of_type_Mqc.a).l.equals(this.jdField_a_of_type_JavaLangString)))
    {
      ItemDatasListUtils.a(FastWebActivity.a(this.jdField_a_of_type_Mqc.a), this.jdField_a_of_type_JavaUtilList, this.b, FastWebActivity.a(this.jdField_a_of_type_Mqc.a), FastWebActivity.a(this.jdField_a_of_type_Mqc.a));
      FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().a();
      if (localFastWebModule != null) {
        localFastWebModule.a(FastWebActivity.a(this.jdField_a_of_type_Mqc.a).j, FastWebActivity.a(this.jdField_a_of_type_Mqc.a));
      }
      FastWebActivity.g(this.jdField_a_of_type_Mqc.a);
      ItemDatasListUtils.a(FastWebActivity.a(this.jdField_a_of_type_Mqc.a));
      FastWebActivity.a(this.jdField_a_of_type_Mqc.a).notifyDataSetChanged();
      this.jdField_a_of_type_Mqc.a.a(FastWebActivity.a(this.jdField_a_of_type_Mqc.a));
      FastWebActivity.a(this.jdField_a_of_type_Mqc.a).a(FastWebActivity.a(this.jdField_a_of_type_Mqc.a), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqd
 * JD-Core Version:    0.7.0.1
 */