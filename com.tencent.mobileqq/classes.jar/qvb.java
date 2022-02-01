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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;

public class qvb
  extends BaseAdapter
{
  private List<rda> jdField_a_of_type_JavaUtilList;
  
  private qvb(ComponentContentRecommendFollowGroup paramComponentContentRecommendFollowGroup) {}
  
  public void a(List<rda> paramList)
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
    int k = 0;
    View localView;
    Object localObject1;
    label325:
    Object localObject2;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560258, paramViewGroup, false);
      paramView = new qvc(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup, null);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367778));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131366989));
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131366980));
      paramView.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131367752));
      paramView.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[3];
      paramView.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[3];
      paramView.jdField_b_of_type_ArrayOfAndroidWidgetImageView = new ImageView[3];
      paramView.c = new ImageView[3];
      paramView.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[3];
      i = 0;
      while (i < paramView.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        localObject1 = (RelativeLayout)paramView.jdField_b_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        paramView.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i] = ((RelativeLayout)((RelativeLayout)localObject1).findViewById(2131367959));
        paramView.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131367950));
        paramView.jdField_b_of_type_ArrayOfAndroidWidgetImageView[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131380325));
        paramView.c[i] = ((ImageView)((RelativeLayout)localObject1).findViewById(2131377707));
        paramView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i] = ((TextView)((RelativeLayout)localObject1).findViewById(2131371799));
        paramView.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i].setOnClickListener(paramView);
        paramView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setOnClickListener(paramView);
        i += 1;
      }
      localView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramView);
      paramView.jdField_a_of_type_Rda = ((rda)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.jdField_a_of_type_Rda.jdField_a_of_type_JavaLangString);
      i = 0;
      if (i >= paramView.jdField_a_of_type_Rda.jdField_a_of_type_JavaUtilList.size()) {
        break label611;
      }
      localObject1 = (RecommendFollowInfo)paramView.jdField_a_of_type_Rda.jdField_a_of_type_JavaUtilList.get(i);
      paramView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setText(((RecommendFollowInfo)localObject1).nickName);
      paramView.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setTag(localObject1);
      paramView.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i].setTag(localObject1);
      if (TextUtils.isEmpty(((RecommendFollowInfo)localObject1).headUrl)) {
        break label581;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = bfvo.b();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
      localObject2 = URLDrawable.getDrawable(((RecommendFollowInfo)localObject1).headUrl, (URLDrawable.URLDrawableOptions)localObject2);
      ((URLDrawable)localObject2).setDecodeHandler(bfol.a);
      ((URLDrawable)localObject2).setFadeInImage(true);
      paramView.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setImageDrawable((Drawable)localObject2);
      label473:
      localObject2 = paramView.jdField_b_of_type_ArrayOfAndroidWidgetImageView[i];
      if (!((RecommendFollowInfo)localObject1).isVip) {
        break label597;
      }
      j = 0;
      label493:
      ((ImageView)localObject2).setVisibility(j);
      localObject2 = paramView.c[i];
      if (!((RecommendFollowInfo)localObject1).isStar) {
        break label604;
      }
    }
    label581:
    label597:
    label604:
    for (int j = 0;; j = 8)
    {
      ((ImageView)localObject2).setVisibility(j);
      ComponentContentRecommendFollowGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup).mRecommendFollowInfos.a.put(Long.valueOf(((RecommendFollowInfo)localObject1).uin), localObject1);
      i += 1;
      break label325;
      localObject1 = (qvc)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
      break;
      paramView.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setImageDrawable(bfvo.b());
      break label473;
      j = 8;
      break label493;
    }
    label611:
    int i = 0;
    if (i < paramView.jdField_a_of_type_Rda.jdField_a_of_type_JavaUtilList.size()) {
      if (((RecommendFollowInfo)paramView.jdField_a_of_type_Rda.jdField_a_of_type_JavaUtilList.get(i)).isFollowed) {}
    }
    for (i = k;; i = 1)
    {
      if (i != 0)
      {
        paramView.jdField_b_of_type_AndroidWidgetTextView.setText(amtj.a(2131701403));
        paramView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-8947849);
        paramView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849359);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        i += 1;
        break;
        paramView.jdField_b_of_type_AndroidWidgetTextView.setText(amtj.a(2131701438));
        paramView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130849316);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qvb
 * JD-Core Version:    0.7.0.1
 */