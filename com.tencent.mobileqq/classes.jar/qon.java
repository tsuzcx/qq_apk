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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class qon
  extends BaseAdapter
{
  public qon(ComponentContentRecommend paramComponentContentRecommend) {}
  
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
    qou localqou;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131562794, null, false);
      localqou = new qou(this.a);
      localqou.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131367925));
      localqou.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView = ((RingAvatarView)paramView.findViewById(2131376085));
      localqou.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367979));
      localqou.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131379040));
      localqou.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365411));
      localqou.b = ((TextView)paramView.findViewById(2131363812));
      localqou.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365632);
      paramView.setTag(localqou);
    }
    for (;;)
    {
      if (localqou != null) {}
      try
      {
        localqou.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImage(new URL(localRecommendFollowInfo.headUrl));
        qoo localqoo = new qoo(this, localRecommendFollowInfo);
        localqou.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(localqoo);
        localqou.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(localqoo);
        localqou.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(localqoo);
        if (localRecommendFollowInfo.isStar)
        {
          localqou.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView.showStarRing();
          if (!localRecommendFollowInfo.isVip) {
            break label470;
          }
          localqou.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localqou.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(localRecommendFollowInfo.nickName);
          localqou.jdField_a_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.recommendReason);
          if (!localRecommendFollowInfo.isFollowed) {
            break label483;
          }
          localqou.b.setText(anzj.a(2131701261));
          localqou.b.setTextColor(Color.parseColor("#777777"));
          localqou.b.setBackgroundResource(2130849447);
          localqou.b.setOnClickListener(new qop(this, localRecommendFollowInfo));
          localqou.jdField_a_of_type_AndroidViewView.setVisibility(8);
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          localqou = (qou)paramView.getTag();
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.e(ComponentContentRecommend.a, 2, "getView, followItem.headUrl = " + localRecommendFollowInfo.headUrl + ", e = " + QLog.getStackTraceString(localMalformedURLException));
          localMalformedURLException.printStackTrace();
          continue;
          localqou.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView.showNormal();
          continue;
          label470:
          localqou.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
          label483:
          localqou.b.setText(anzj.a(2131701212));
          localqou.b.setTextColor(-1);
          localqou.b.setBackgroundResource(2130849404);
          localqou.b.setCompoundDrawablePadding(agej.a(3.0F, this.a.getResources()));
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
 * Qualified Name:     qon
 * JD-Core Version:    0.7.0.1
 */