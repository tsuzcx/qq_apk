import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;
import com.tencent.biz.qqstory.view.widget.StorySwipeTextViewMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;

public class osa
  extends StorySwipeTextViewMenuBuilder
{
  public View a(Context paramContext, View paramView, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, int paramInt)
  {
    paramSwipItemBaseHolder.a = new SwipRightMenuBuilder.SwipRightMenuItem[this.b];
    paramInt = 0;
    while (paramInt < this.b)
    {
      paramSwipItemBaseHolder.a[paramInt] = new SwipRightMenuBuilder.SwipRightMenuItem();
      paramSwipItemBaseHolder.a[paramInt].jdField_a_of_type_Int = -1;
      paramSwipItemBaseHolder.a[paramInt].c = 0;
      paramSwipItemBaseHolder.a[paramInt].jdField_a_of_type_AndroidViewView = null;
      paramInt += 1;
    }
    paramSwipItemBaseHolder.f = paramView.findViewById(2131363420);
    return paramView;
  }
  
  public void a(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    paramArrayOfSwipRightMenuItem[0].jdField_a_of_type_Int = 0;
    paramArrayOfSwipRightMenuItem[0].b = 0;
    paramArrayOfSwipRightMenuItem[1].jdField_a_of_type_Int = -1;
    paramArrayOfSwipRightMenuItem[1].b = -1;
    String str = QQStoryContext.a().a();
    if ((this.a.a) || (((TroopStoryItemInfo)paramObject).uin.equals(str)))
    {
      paramArrayOfSwipRightMenuItem[1].jdField_a_of_type_Int = 1;
      paramArrayOfSwipRightMenuItem[1].b = 1;
    }
  }
  
  protected void a(ViewGroup paramViewGroup, View paramView, SwipRightMenuBuilder.SwipRightMenuItem paramSwipRightMenuItem, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null) {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(paramSwipRightMenuItem.c, paramSwipRightMenuItem.d));
    }
    for (;;)
    {
      paramViewGroup.addView(paramView, paramInt);
      return;
      localLayoutParams.width = paramSwipRightMenuItem.c;
      localLayoutParams.height = paramSwipRightMenuItem.d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osa
 * JD-Core Version:    0.7.0.1
 */