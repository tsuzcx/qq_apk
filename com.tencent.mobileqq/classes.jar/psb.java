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

public class psb
  extends BaseAdapter
{
  private List<RecommendFollowInfo> jdField_a_of_type_JavaUtilList;
  
  private psb(prr paramprr) {}
  
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
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560099, paramViewGroup, false);
      paramViewGroup = new psc(this.jdField_a_of_type_Prr, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367528));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367537));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379427));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376925));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371148));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377394));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366645));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366636));
      paramView.setTag(paramViewGroup);
      paramView.setBackgroundResource(2130842577);
      paramView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      localRecommendFollowInfo = (RecommendFollowInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo = localRecommendFollowInfo;
      prr.a(this.jdField_a_of_type_Prr).mRecommendFollowInfos.a.put(Long.valueOf(localRecommendFollowInfo.uin), localRecommendFollowInfo);
      if (TextUtils.isEmpty(localRecommendFollowInfo.headUrl)) {
        break label500;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = bdda.b();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
      localObject = URLDrawable.getDrawable(localRecommendFollowInfo.headUrl, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(bcuq.a);
      ((URLDrawable)localObject).setFadeInImage(true);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      label298:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.nickName);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.recommendReason);
      if (!localRecommendFollowInfo.isFollowed) {
        break label513;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(alpo.a(2131713370));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130848856);
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
        nrt.a(null, ors.a() + "", "0X8009848", "0X8009848", 0, 0, "1", localRecommendFollowInfo.uin + "", "", "", false);
      }
      return paramView;
      paramViewGroup = (psc)paramView.getTag();
      break;
      label500:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bdda.b());
      break label298;
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(alpo.a(2131713372));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130848825);
      break label360;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     psb
 * JD-Core Version:    0.7.0.1
 */