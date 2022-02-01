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
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;

public class qur
  extends BaseAdapter
{
  private List<RecommendFollowInfo> jdField_a_of_type_JavaUtilList;
  
  private qur(quh paramquh) {}
  
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
    int j = 8;
    Object localObject1;
    RecommendFollowInfo localRecommendFollowInfo;
    Object localObject2;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560306, paramViewGroup, false);
      localObject1 = new qus(this.jdField_a_of_type_Quh, null);
      ((qus)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368086));
      ((qus)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368095));
      ((qus)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380661));
      ((qus)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377987));
      ((qus)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371989));
      ((qus)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378490));
      ((qus)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367107));
      ((qus)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367098));
      paramView.setTag(localObject1);
      paramView.setBackgroundResource(2130843021);
      paramView.setOnClickListener((View.OnClickListener)localObject1);
      ((qus)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((View.OnClickListener)localObject1);
      ((qus)localObject1).jdField_a_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject1);
      ((qus)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener((View.OnClickListener)localObject1);
      localRecommendFollowInfo = (RecommendFollowInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      ((qus)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo = localRecommendFollowInfo;
      quh.a(this.jdField_a_of_type_Quh).mRecommendFollowInfos.a.put(Long.valueOf(localRecommendFollowInfo.uin), localRecommendFollowInfo);
      if (TextUtils.isEmpty(localRecommendFollowInfo.headUrl)) {
        break label548;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = bheg.b();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
      localObject2 = URLDrawable.getDrawable(localRecommendFollowInfo.headUrl, (URLDrawable.URLDrawableOptions)localObject2);
      ((URLDrawable)localObject2).setDecodeHandler(bgxc.a);
      ((URLDrawable)localObject2).setFadeInImage(true);
      ((qus)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      label317:
      ((qus)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.nickName);
      ((qus)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.recommendReason);
      if (!localRecommendFollowInfo.isFollowed) {
        break label562;
      }
      ((qus)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(anvx.a(2131712449));
      ((qus)localObject1).jdField_c_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      ((qus)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849451);
      label384:
      localObject2 = ((qus)localObject1).jdField_b_of_type_AndroidWidgetImageView;
      if (!localRecommendFollowInfo.isVip) {
        break label599;
      }
    }
    label548:
    label562:
    label599:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject2).setVisibility(i);
      localObject1 = ((qus)localObject1).jdField_c_of_type_AndroidWidgetImageView;
      i = j;
      if (localRecommendFollowInfo.isStar) {
        i = 0;
      }
      ((ImageView)localObject1).setVisibility(i);
      if (!localRecommendFollowInfo.hasReport)
      {
        localRecommendFollowInfo.hasReport = true;
        olh.a(null, pkh.a() + "", "0X8009848", "0X8009848", 0, 0, "1", localRecommendFollowInfo.uin + "", "", "", false);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = (qus)paramView.getTag();
      break;
      ((qus)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bheg.b());
      break label317;
      ((qus)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(anvx.a(2131712451));
      ((qus)localObject1).jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      ((qus)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849408);
      break label384;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qur
 * JD-Core Version:    0.7.0.1
 */