import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter.OnUIClickListener;

public class onh
  implements View.OnLongClickListener
{
  public onh(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, int paramInt) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a != null) {
      return this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a.a(paramView, this.jdField_a_of_type_Int);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     onh
 * JD-Core Version:    0.7.0.1
 */