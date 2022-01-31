import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;
import com.tencent.biz.qqstory.troop.memories.TroopStoryMemoriesListAdapter;
import com.tencent.biz.qqstory.utils.DateUtils;
import java.util.ArrayList;

public class onk
{
  public View a;
  public TextView a;
  public View b;
  public TextView b;
  public View c;
  public TextView c;
  public View d;
  public TextView d;
  
  public onk(TroopStoryMemoriesListAdapter paramTroopStoryMemoriesListAdapter, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372057));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364202));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364201));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372059));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131372055);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131372054);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131372052);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131372053);
  }
  
  public void a(TroopStoryItemInfo paramTroopStoryItemInfo, int paramInt)
  {
    Object localObject = DateUtils.a(paramTroopStoryItemInfo.publishTime);
    if (TextUtils.isEmpty(localObject[0]))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localObject[1]);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      if ((paramInt > 0) && (((TroopStoryItemInfo)this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a.get(paramInt - 1)).itemType == 0))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      while (paramTroopStoryItemInfo.publishCount == 0)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText("暂无小视频");
        return;
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localObject[1]);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(localObject[0]);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if ((paramInt > 0) && (((TroopStoryItemInfo)this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryMemoriesListAdapter.a.get(paramInt - 1)).itemType == 0))
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break;
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramTroopStoryItemInfo.publishCount).append("个小视频");
    if (paramTroopStoryItemInfo.dayCommentCount > 0)
    {
      ((StringBuilder)localObject).append(" 评论").append(paramTroopStoryItemInfo.dayCommentCount);
      if (paramTroopStoryItemInfo.dayLikeCount > 0) {
        ((StringBuilder)localObject).append("·");
      }
    }
    if (paramTroopStoryItemInfo.dayLikeCount > 0)
    {
      if (paramTroopStoryItemInfo.dayCommentCount <= 0) {
        ((StringBuilder)localObject).append(" ");
      }
      ((StringBuilder)localObject).append("赞").append(paramTroopStoryItemInfo.dayLikeCount);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     onk
 * JD-Core Version:    0.7.0.1
 */