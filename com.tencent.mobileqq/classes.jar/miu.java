import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.XListView.DrawFinishedListener;
import mqq.os.MqqHandler;

public class miu
  implements XListView.DrawFinishedListener
{
  public miu(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void a()
  {
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.b))
    {
      this.a.jdField_a_of_type_Boolean = true;
      this.a.b = false;
      switch (this.a.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      PublicTracker.a("KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW", null);
      PublicTracker.a("KANDIAN_FEEDS_STAGE_2_COST", null);
      PublicTracker.a("KANDIAN_FEEDS_COST", null);
      if (this.a.jdField_a_of_type_Int == 56) {
        PublicTracker.a("video_tab_cost", null);
      }
      if (ReadInJoyListViewGroup.b(this.a))
      {
        ReadInJoyListViewGroup.a(this.a);
        ThreadManager.getUIHandler().postDelayed(new miv(this), 100L);
      }
      if (ReadInJoyListViewGroup.c(this.a)) {
        ReadInJoyListViewGroup.c(this.a);
      }
      return;
      PublicTracker.jdField_a_of_type_Int = 1;
      continue;
      PublicTracker.jdField_a_of_type_Int = 2;
      continue;
      PublicTracker.jdField_a_of_type_Int = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     miu
 * JD-Core Version:    0.7.0.1
 */