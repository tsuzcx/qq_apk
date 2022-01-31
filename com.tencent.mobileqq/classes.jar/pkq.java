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
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.HashMap;
import java.util.List;

public class pkq
  extends BaseAdapter
{
  private List<ppi> jdField_a_of_type_JavaUtilList;
  
  private pkq(ComponentContentRecommendFollowGroup paramComponentContentRecommendFollowGroup) {}
  
  public void a(List<ppi> paramList)
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
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 0;
    Object localObject1;
    label318:
    Object localObject2;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494432, paramViewGroup, false);
      paramViewGroup = new pkr(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131301618));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300928));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131300919));
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131301593));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[3];
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[3];
      paramViewGroup.jdField_b_of_type_ArrayOfAndroidWidgetImageView = new ImageView[3];
      paramViewGroup.c = new ImageView[3];
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[3];
      i = 0;
      while (i < paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        localObject1 = (RelativeLayout)paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i] = ((RelativeLayout)((RelativeLayout)localObject1).findViewById(2131301798));
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131301789));
        paramViewGroup.jdField_b_of_type_ArrayOfAndroidWidgetImageView[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131312976));
        paramViewGroup.c[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131310629));
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i] = ((TextView)((RelativeLayout)localObject1).findViewById(2131305165));
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i].setOnClickListener(paramViewGroup);
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setOnClickListener(paramViewGroup);
        i += 1;
      }
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_Ppi = ((ppi)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.jdField_a_of_type_Ppi.jdField_a_of_type_JavaLangString);
      paramInt = 0;
      if (paramInt >= paramViewGroup.jdField_a_of_type_Ppi.jdField_a_of_type_JavaUtilList.size()) {
        break label586;
      }
      localObject1 = (RecommendFollowInfo)paramViewGroup.jdField_a_of_type_Ppi.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setText(((RecommendFollowInfo)localObject1).nickName);
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setTag(localObject1);
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[paramInt].setTag(localObject1);
      if (TextUtils.isEmpty(((RecommendFollowInfo)localObject1).headUrl)) {
        break label557;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = bacm.b();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
      localObject2 = URLDrawable.getDrawable(((RecommendFollowInfo)localObject1).headUrl, (URLDrawable.URLDrawableOptions)localObject2);
      ((URLDrawable)localObject2).setDecodeHandler(azue.a);
      ((URLDrawable)localObject2).setFadeInImage(true);
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt].setImageDrawable((Drawable)localObject2);
      label460:
      localObject2 = paramViewGroup.jdField_b_of_type_ArrayOfAndroidWidgetImageView[paramInt];
      if (!((RecommendFollowInfo)localObject1).isVip) {
        break label572;
      }
      i = 0;
      label479:
      ((ImageView)localObject2).setVisibility(i);
      localObject2 = paramViewGroup.c[paramInt];
      if (!((RecommendFollowInfo)localObject1).isStar) {
        break label579;
      }
    }
    label557:
    label572:
    label579:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject2).setVisibility(i);
      ComponentContentRecommendFollowGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup).mRecommendFollowInfos.a.put(Long.valueOf(((RecommendFollowInfo)localObject1).uin), localObject1);
      paramInt += 1;
      break label318;
      paramViewGroup = (pkr)paramView.getTag();
      break;
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt].setImageDrawable(bacm.b());
      break label460;
      i = 8;
      break label479;
    }
    label586:
    paramInt = 0;
    if (paramInt < paramViewGroup.jdField_a_of_type_Ppi.jdField_a_of_type_JavaUtilList.size()) {
      if (((RecommendFollowInfo)paramViewGroup.jdField_a_of_type_Ppi.jdField_a_of_type_JavaUtilList.get(paramInt)).isFollowed) {}
    }
    for (paramInt = j;; paramInt = 1)
    {
      if (paramInt != 0)
      {
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(ajjy.a(2131636462));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-8947849);
        paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130848207);
        return paramView;
        paramInt += 1;
        break;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(ajjy.a(2131636497));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130848174);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pkq
 * JD-Core Version:    0.7.0.1
 */