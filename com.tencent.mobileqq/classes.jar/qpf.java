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

public class qpf
  extends BaseAdapter
{
  private List<RecommendFollowInfo> jdField_a_of_type_JavaUtilList;
  
  private qpf(ComponentContentRecommendFollowList paramComponentContentRecommendFollowList) {}
  
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
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560253, paramViewGroup, false);
      localObject1 = new qpg(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowList, null);
      ((qpg)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367917));
      ((qpg)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367926));
      ((qpg)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380601));
      ((qpg)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377938));
      ((qpg)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371833));
      ((qpg)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378435));
      ((qpg)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366971));
      ((qpg)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366962));
      paramView.setTag(localObject1);
      paramView.setOnClickListener((View.OnClickListener)localObject1);
      ((qpg)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject1);
      ((qpg)localObject1).jdField_a_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject1);
      ((qpg)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener((View.OnClickListener)localObject1);
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      ((qpg)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo = localRecommendFollowInfo;
      ComponentContentRecommendFollowList.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowList).mRecommendFollowInfos.a.put(Long.valueOf(localRecommendFollowInfo.uin), localRecommendFollowInfo);
      if (TextUtils.isEmpty(localRecommendFollowInfo.headUrl)) {
        break label456;
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = bhmq.b();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
      localObject2 = URLDrawable.getDrawable(localRecommendFollowInfo.headUrl, (URLDrawable.URLDrawableOptions)localObject2);
      ((URLDrawable)localObject2).setDecodeHandler(bhez.a);
      ((URLDrawable)localObject2).setFadeInImage(true);
      ((qpg)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      label310:
      ((qpg)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.nickName);
      ((qpg)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.recommendReason);
      if (!localRecommendFollowInfo.isFollowed) {
        break label470;
      }
      ((qpg)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131701252));
      ((qpg)localObject1).jdField_c_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      ((qpg)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849447);
      label377:
      localObject2 = ((qpg)localObject1).jdField_b_of_type_AndroidWidgetImageView;
      if (!localRecommendFollowInfo.isVip) {
        break label507;
      }
      i = 0;
      label395:
      ((ImageView)localObject2).setVisibility(i);
      localObject1 = ((qpg)localObject1).jdField_c_of_type_AndroidWidgetImageView;
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
      localObject1 = (qpg)paramView.getTag();
      break;
      label456:
      ((qpg)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bhmq.b());
      break label310;
      label470:
      ((qpg)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131701242));
      ((qpg)localObject1).jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      ((qpg)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849404);
      break label377;
      label507:
      i = 8;
      break label395;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpf
 * JD-Core Version:    0.7.0.1
 */