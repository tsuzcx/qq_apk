import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import java.util.List;

public class qdd
  implements View.OnClickListener
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  qkx jdField_a_of_type_Qkx;
  ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  RelativeLayout[] jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout;
  TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView[] jdField_b_of_type_ArrayOfAndroidWidgetImageView;
  ImageView[] c;
  
  private qdd(ComponentContentRecommendFollowGroup paramComponentContentRecommendFollowGroup) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131366642: 
      i = 0;
      if (i < this.jdField_a_of_type_Qkx.a.size()) {
        if (((RecommendFollowInfo)this.jdField_a_of_type_Qkx.a.get(i)).isFollowed) {
          break;
        }
      }
      break;
    }
    for (int i = 0;; i = 1)
    {
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup;
      List localList = this.jdField_a_of_type_Qkx.a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qdd
 * JD-Core Version:    0.7.0.1
 */