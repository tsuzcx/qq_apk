import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class pvx
  extends BaseAdapter
{
  public pvx(ComponentContentRecommend paramComponentContentRecommend) {}
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public int getCount()
  {
    return ComponentContentRecommend.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return ComponentContentRecommend.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)ComponentContentRecommend.a(this.a).get(paramInt);
    ComponentContentRecommend.a(this.a).mRecommendFollowInfos.a.put(Long.valueOf(localRecommendFollowInfo.uin), localRecommendFollowInfo);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131562306, null, false);
      paramViewGroup = new pwe(this.a);
      paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131367407));
      paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView = ((RingAvatarView)paramView.findViewById(2131374706));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367463));
      paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131377442));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365040));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131363544));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365268);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      if (paramViewGroup != null) {}
      try
      {
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.a(new URL(localRecommendFollowInfo.headUrl));
        pvy localpvy = new pvy(this, localRecommendFollowInfo);
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(localpvy);
        paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(localpvy);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(localpvy);
        if (localRecommendFollowInfo.isStar)
        {
          paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView.a();
          if (!localRecommendFollowInfo.isVip) {
            break label431;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(localRecommendFollowInfo.nickName);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.recommendReason);
          if (!localRecommendFollowInfo.isFollowed) {
            break label443;
          }
          paramViewGroup.b.setText(ajya.a(2131702350));
          paramViewGroup.b.setTextColor(Color.parseColor("#777777"));
          paramViewGroup.b.setBackgroundResource(2130848443);
          paramViewGroup.b.setOnClickListener(new pvz(this, localRecommendFollowInfo));
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
          return paramView;
          paramViewGroup = (pwe)paramView.getTag();
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.e(ComponentContentRecommend.a, 2, "getView, followItem.headUrl = " + localRecommendFollowInfo.headUrl + ", e = " + QLog.getStackTraceString(localMalformedURLException));
          localMalformedURLException.printStackTrace();
          continue;
          paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView.b();
          continue;
          label431:
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
          label443:
          paramViewGroup.b.setText(ajya.a(2131702301));
          paramViewGroup.b.setTextColor(-1);
          paramViewGroup.b.setBackgroundResource(2130848412);
          paramViewGroup.b.setCompoundDrawablePadding(actj.a(3.0F, this.a.getResources()));
        }
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pvx
 * JD-Core Version:    0.7.0.1
 */