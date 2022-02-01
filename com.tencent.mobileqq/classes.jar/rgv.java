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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class rgv
  extends BaseAdapter
{
  public rgv(ComponentContentRecommend paramComponentContentRecommend) {}
  
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
    rhc localrhc;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131562743, null, false);
      localrhc = new rhc(this.a);
      localrhc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131368094));
      localrhc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView = ((RingAvatarView)paramView.findViewById(2131376099));
      localrhc.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368147));
      localrhc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131379102));
      localrhc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365536));
      localrhc.b = ((TextView)paramView.findViewById(2131363913));
      localrhc.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365759);
      paramView.setTag(localrhc);
    }
    for (;;)
    {
      if (localrhc != null) {}
      try
      {
        localrhc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImage(new URL(localRecommendFollowInfo.headUrl));
        rgw localrgw = new rgw(this, localRecommendFollowInfo);
        localrhc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(localrgw);
        localrhc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(localrgw);
        localrhc.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(localrgw);
        if (localRecommendFollowInfo.isStar)
        {
          localrhc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView.showStarRing();
          if (!localRecommendFollowInfo.isVip) {
            break label470;
          }
          localrhc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localrhc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(localRecommendFollowInfo.nickName);
          localrhc.jdField_a_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.recommendReason);
          if (!localRecommendFollowInfo.isFollowed) {
            break label483;
          }
          localrhc.b.setText(anvx.a(2131701847));
          localrhc.b.setTextColor(Color.parseColor("#777777"));
          localrhc.b.setBackgroundResource(2130849451);
          localrhc.b.setOnClickListener(new rgx(this, localRecommendFollowInfo));
          localrhc.jdField_a_of_type_AndroidViewView.setVisibility(8);
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          localrhc = (rhc)paramView.getTag();
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.e(ComponentContentRecommend.a, 2, "getView, followItem.headUrl = " + localRecommendFollowInfo.headUrl + ", e = " + QLog.getStackTraceString(localMalformedURLException));
          localMalformedURLException.printStackTrace();
          continue;
          localrhc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView.showNormal();
          continue;
          label470:
          localrhc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
          label483:
          localrhc.b.setText(anvx.a(2131701798));
          localrhc.b.setTextColor(-1);
          localrhc.b.setBackgroundResource(2130849408);
          localrhc.b.setCompoundDrawablePadding(AIOUtils.dp2px(3.0F, this.a.getResources()));
        }
      }
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rgv
 * JD-Core Version:    0.7.0.1
 */