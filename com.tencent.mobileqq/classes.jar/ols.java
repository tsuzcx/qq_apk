import android.view.View;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;

public class ols
{
  public View a;
  public View b;
  
  public ols(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.b = paramView.findViewById(2131362707);
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo)
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new olt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ols
 * JD-Core Version:    0.7.0.1
 */