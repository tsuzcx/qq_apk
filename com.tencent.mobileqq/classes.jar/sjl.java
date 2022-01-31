import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.statistics.ReportController;

public class sjl
  implements View.OnClickListener
{
  public sjl(EmosmActivity paramEmosmActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.b)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131436056);
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(true);
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a(true);
      this.a.b = true;
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
      this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      ReportController.b(this.a.app, "CliOper", "", "", "EmosSetting", "EpsEdit", 0, 0, "", "", "", "");
    }
    while ((this.a.jdField_a_of_type_Int != 2) && (this.a.jdField_a_of_type_Int != 1)) {
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131436053);
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a(false);
    this.a.e();
    this.a.b = false;
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a();
    this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sjl
 * JD-Core Version:    0.7.0.1
 */