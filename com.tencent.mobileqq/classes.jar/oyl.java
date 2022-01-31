import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;

public class oyl
  extends BaseAdapter
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int;
  private int b;
  
  private oyl(MoveFileActivity paramMoveFileActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      QLog.e("IphoneTitleBarActivity", 4, "onScrollStateChanged=SCROLL_STATE_IDLE");
      if (this.jdField_a_of_type_Int == this.b - 2)
      {
        if (!MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity)) {
          break label44;
        }
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a(true);
      }
    }
    label44:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a(false);
    } while (TroopFileUtils.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.app, this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity, this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a) == 0);
    this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.a();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt3;
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public int getCount()
  {
    return MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).size();
  }
  
  public Object getItem(int paramInt)
  {
    return MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getLayoutInflater().inflate(2130969894, MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity), false);
      paramView = new oym(null);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131368389));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368388));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131368390));
      paramViewGroup.setTag(paramView);
    }
    paramView = (oym)paramViewGroup.getTag();
    TroopFileInfo localTroopFileInfo = (TroopFileInfo)MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity).get(paramInt);
    if (localTroopFileInfo != null)
    {
      if (!MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity, paramInt)) {
        break label162;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopFileInfo.c);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841323);
    }
    while (paramInt == MoveFileActivity.a(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity))
    {
      paramView.b.setVisibility(0);
      return paramViewGroup;
      label162:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText("移出文件夹");
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841325);
    }
    paramView.b.setVisibility(4);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyl
 * JD-Core Version:    0.7.0.1
 */