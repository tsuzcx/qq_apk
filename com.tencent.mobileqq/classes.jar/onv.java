import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;
import com.tencent.biz.qqstory.utils.DateUtils;

public class onv
{
  public TextView a;
  public TextView b;
  
  public onv(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364203));
    this.b = ((TextView)paramView.findViewById(2131372059));
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(DateUtils.b(paramTroopStoryItemInfo.publishTime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     onv
 * JD-Core Version:    0.7.0.1
 */