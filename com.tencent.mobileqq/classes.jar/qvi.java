import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;

public class qvi
  extends BaseAdapter
{
  private List<RecommendFollowInfo> jdField_a_of_type_JavaUtilList;
  
  private qvi(ComponentContentRecommendFollowList paramComponentContentRecommendFollowList) {}
  
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
    int j = 0;
    Object localObject1;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560260, paramViewGroup, false);
      localObject1 = new qvj(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowList, null);
      ((qvj)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367950));
      ((qvj)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367959));
      ((qvj)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380325));
      ((qvj)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377707));
      ((qvj)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371799));
      ((qvj)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378202));
      ((qvj)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366989));
      ((qvj)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366980));
      paramView.setTag(localObject1);
      paramView.setOnClickListener((View.OnClickListener)localObject1);
      ((qvj)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject1);
      ((qvj)localObject1).jdField_a_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject1);
      ((qvj)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener((View.OnClickListener)localObject1);
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      ((qvj)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo = localRecommendFollowInfo;
      ComponentContentRecommendFollowList.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowList).mRecommendFollowInfos.a.put(Long.valueOf(localRecommendFollowInfo.uin), localRecommendFollowInfo);
      if (TextUtils.isEmpty(localRecommendFollowInfo.headUrl)) {
        break label456;
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = bfvo.b();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
      localObject2 = URLDrawable.getDrawable(localRecommendFollowInfo.headUrl, (URLDrawable.URLDrawableOptions)localObject2);
      ((URLDrawable)localObject2).setDecodeHandler(bfol.a);
      ((URLDrawable)localObject2).setFadeInImage(true);
      ((qvj)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      label310:
      ((qvj)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.nickName);
      ((qvj)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.recommendReason);
      if (!localRecommendFollowInfo.isFollowed) {
        break label470;
      }
      ((qvj)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(amtj.a(2131701487));
      ((qvj)localObject1).jdField_c_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      ((qvj)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849359);
      label377:
      localObject2 = ((qvj)localObject1).jdField_b_of_type_AndroidWidgetImageView;
      if (!localRecommendFollowInfo.isVip) {
        break label507;
      }
      i = 0;
      label395:
      ((ImageView)localObject2).setVisibility(i);
      localObject1 = ((qvj)localObject1).jdField_c_of_type_AndroidWidgetImageView;
      if (!localRecommendFollowInfo.isStar) {
        break label514;
      }
    }
    label514:
    for (int i = j;; i = 8)
    {
      ((ImageView)localObject1).setVisibility(i);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = (qvj)paramView.getTag();
      break;
      label456:
      ((qvj)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bfvo.b());
      break label310;
      label470:
      ((qvj)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(amtj.a(2131701477));
      ((qvj)localObject1).jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      ((qvj)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849316);
      break label377;
      label507:
      i = 8;
      break label395;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qvi
 * JD-Core Version:    0.7.0.1
 */