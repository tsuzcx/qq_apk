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

public class qdc
  extends BaseAdapter
{
  private List<qkx> jdField_a_of_type_JavaUtilList;
  
  private qdc(ComponentContentRecommendFollowGroup paramComponentContentRecommendFollowGroup) {}
  
  public void a(List<qkx> paramList)
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
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560097, paramViewGroup, false);
      paramViewGroup = new qdd(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367360));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366645));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366636));
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367335));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[3];
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[3];
      paramViewGroup.jdField_b_of_type_ArrayOfAndroidWidgetImageView = new ImageView[3];
      paramViewGroup.c = new ImageView[3];
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[3];
      i = 0;
      while (i < paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        localObject1 = (RelativeLayout)paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i] = ((RelativeLayout)((RelativeLayout)localObject1).findViewById(2131367537));
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131367528));
        paramViewGroup.jdField_b_of_type_ArrayOfAndroidWidgetImageView[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131379427));
        paramViewGroup.c[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131376925));
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i] = ((TextView)((RelativeLayout)localObject1).findViewById(2131371148));
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i].setOnClickListener(paramViewGroup);
        paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setOnClickListener(paramViewGroup);
        i += 1;
      }
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramViewGroup);
      paramViewGroup.jdField_a_of_type_Qkx = ((qkx)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.jdField_a_of_type_Qkx.jdField_a_of_type_JavaLangString);
      paramInt = 0;
      if (paramInt >= paramViewGroup.jdField_a_of_type_Qkx.jdField_a_of_type_JavaUtilList.size()) {
        break label586;
      }
      localObject1 = (RecommendFollowInfo)paramViewGroup.jdField_a_of_type_Qkx.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setText(((RecommendFollowInfo)localObject1).nickName);
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setTag(localObject1);
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[paramInt].setTag(localObject1);
      if (TextUtils.isEmpty(((RecommendFollowInfo)localObject1).headUrl)) {
        break label557;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = bdda.b();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
      localObject2 = URLDrawable.getDrawable(((RecommendFollowInfo)localObject1).headUrl, (URLDrawable.URLDrawableOptions)localObject2);
      ((URLDrawable)localObject2).setDecodeHandler(bcuq.a);
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
      paramViewGroup = (qdd)paramView.getTag();
      break;
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[paramInt].setImageDrawable(bdda.b());
      break label460;
      i = 8;
      break label479;
    }
    label586:
    paramInt = 0;
    if (paramInt < paramViewGroup.jdField_a_of_type_Qkx.jdField_a_of_type_JavaUtilList.size()) {
      if (((RecommendFollowInfo)paramViewGroup.jdField_a_of_type_Qkx.jdField_a_of_type_JavaUtilList.get(paramInt)).isFollowed) {}
    }
    for (paramInt = j;; paramInt = 1)
    {
      if (paramInt != 0)
      {
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131702629));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-8947849);
        paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130848856);
        return paramView;
        paramInt += 1;
        break;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131702664));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130848825);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qdc
 * JD-Core Version:    0.7.0.1
 */