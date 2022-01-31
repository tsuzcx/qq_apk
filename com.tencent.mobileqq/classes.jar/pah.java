import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.HashMap;
import java.util.List;

public class pah
  extends BaseAdapter
{
  private List<RecommendFollowInfo> jdField_a_of_type_JavaUtilList;
  
  private pah(ozx paramozx) {}
  
  public void a(List<RecommendFollowInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 8;
    RecommendFollowInfo localRecommendFollowInfo;
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494434, paramViewGroup, false);
      paramViewGroup = new pai(this.jdField_a_of_type_Ozx, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301789));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131301798));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131312976));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131310629));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305165));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311068));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300928));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131300919));
      paramView.setTag(paramViewGroup);
      paramView.setBackgroundResource(2130842330);
      paramView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      localRecommendFollowInfo = (RecommendFollowInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo = localRecommendFollowInfo;
      ozx.a(this.jdField_a_of_type_Ozx).mRecommendFollowInfos.a.put(Long.valueOf(localRecommendFollowInfo.uin), localRecommendFollowInfo);
      if (TextUtils.isEmpty(localRecommendFollowInfo.headUrl)) {
        break label500;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = bacm.b();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
      localObject = URLDrawable.getDrawable(localRecommendFollowInfo.headUrl, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(azue.a);
      ((URLDrawable)localObject).setFadeInImage(true);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      label298:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.nickName);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.recommendReason);
      if (!localRecommendFollowInfo.isFollowed) {
        break label513;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131647199));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130848207);
      label360:
      localObject = paramViewGroup.jdField_b_of_type_AndroidWidgetImageView;
      if (!localRecommendFollowInfo.isVip) {
        break label547;
      }
    }
    label513:
    label547:
    for (paramInt = 0;; paramInt = 8)
    {
      ((ImageView)localObject).setVisibility(paramInt);
      paramViewGroup = paramViewGroup.jdField_c_of_type_AndroidWidgetImageView;
      paramInt = i;
      if (localRecommendFollowInfo.isStar) {
        paramInt = 0;
      }
      paramViewGroup.setVisibility(paramInt);
      if (!localRecommendFollowInfo.hasReport)
      {
        localRecommendFollowInfo.hasReport = true;
        ndn.a(null, obz.a() + "", "0X8009848", "0X8009848", 0, 0, "1", localRecommendFollowInfo.uin + "", "", "", false);
      }
      return paramView;
      paramViewGroup = (pai)paramView.getTag();
      break;
      label500:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bacm.b());
      break label298;
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131647201));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130848174);
      break label360;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pah
 * JD-Core Version:    0.7.0.1
 */