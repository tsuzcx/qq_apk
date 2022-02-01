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

public class quq
  extends BaseAdapter
{
  public quq(ComponentContentRecommend paramComponentContentRecommend) {}
  
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
    qux localqux;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131562672, null, false);
      localqux = new qux(this.a);
      localqux.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131367958));
      localqux.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView = ((RingAvatarView)paramView.findViewById(2131375852));
      localqux.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368012));
      localqux.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131378809));
      localqux.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365443));
      localqux.b = ((TextView)paramView.findViewById(2131363841));
      localqux.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365665);
      paramView.setTag(localqux);
    }
    for (;;)
    {
      if (localqux != null) {}
      try
      {
        localqux.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImage(new URL(localRecommendFollowInfo.headUrl));
        qur localqur = new qur(this, localRecommendFollowInfo);
        localqux.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(localqur);
        localqux.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(localqur);
        localqux.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(localqur);
        if (localRecommendFollowInfo.isStar)
        {
          localqux.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView.showStarRing();
          if (!localRecommendFollowInfo.isVip) {
            break label470;
          }
          localqux.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localqux.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(localRecommendFollowInfo.nickName);
          localqux.jdField_a_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.recommendReason);
          if (!localRecommendFollowInfo.isFollowed) {
            break label483;
          }
          localqux.b.setText(amtj.a(2131701496));
          localqux.b.setTextColor(Color.parseColor("#777777"));
          localqux.b.setBackgroundResource(2130849359);
          localqux.b.setOnClickListener(new qus(this, localRecommendFollowInfo));
          localqux.jdField_a_of_type_AndroidViewView.setVisibility(8);
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          localqux = (qux)paramView.getTag();
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.e(ComponentContentRecommend.a, 2, "getView, followItem.headUrl = " + localRecommendFollowInfo.headUrl + ", e = " + QLog.getStackTraceString(localMalformedURLException));
          localMalformedURLException.printStackTrace();
          continue;
          localqux.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView.showNormal();
          continue;
          label470:
          localqux.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
          label483:
          localqux.b.setText(amtj.a(2131701447));
          localqux.b.setTextColor(-1);
          localqux.b.setBackgroundResource(2130849316);
          localqux.b.setCompoundDrawablePadding(AIOUtils.dp2px(3.0F, this.a.getResources()));
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
 * Qualified Name:     quq
 * JD-Core Version:    0.7.0.1
 */