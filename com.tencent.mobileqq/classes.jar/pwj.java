import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import java.util.List;

public class pwj
  implements View.OnClickListener
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  qbb jdField_a_of_type_Qbb;
  ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  RelativeLayout[] jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout;
  TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView[] jdField_b_of_type_ArrayOfAndroidWidgetImageView;
  ImageView[] c;
  
  private pwj(ComponentContentRecommendFollowGroup paramComponentContentRecommendFollowGroup) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131366528: 
      i = 0;
      if (i < this.jdField_a_of_type_Qbb.a.size()) {
        if (((RecommendFollowInfo)this.jdField_a_of_type_Qbb.a.get(i)).isFollowed) {
          break;
        }
      }
      break;
    }
    for (int i = 0;; i = 1)
    {
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup;
      List localList = this.jdField_a_of_type_Qbb.a;
      if (i == 0) {}
      for (;;)
      {
        paramView.a(localList, bool);
        return;
        i += 1;
        break;
        bool = false;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup.a((RecommendFollowInfo)paramView.getTag());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pwj
 * JD-Core Version:    0.7.0.1
 */