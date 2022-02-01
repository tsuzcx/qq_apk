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

public class qvz
  extends BaseAdapter
{
  public qvz(ComponentContentRecommend paramComponentContentRecommend) {}
  
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
    qwg localqwg;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131562753, null, false);
      localqwg = new qwg(this.a);
      localqwg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)paramView.findViewById(2131367857));
      localqwg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView = ((RingAvatarView)paramView.findViewById(2131375945));
      localqwg.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367909));
      localqwg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)paramView.findViewById(2131378877));
      localqwg.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365367));
      localqwg.b = ((TextView)paramView.findViewById(2131363788));
      localqwg.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365590);
      paramView.setTag(localqwg);
    }
    for (;;)
    {
      if (localqwg != null) {}
      try
      {
        localqwg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImage(new URL(localRecommendFollowInfo.headUrl));
        qwa localqwa = new qwa(this, localRecommendFollowInfo);
        localqwg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(localqwa);
        localqwg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setOnClickListener(localqwa);
        localqwg.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(localqwa);
        if (localRecommendFollowInfo.isStar)
        {
          localqwg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView.showStarRing();
          if (!localRecommendFollowInfo.isVip) {
            break label470;
          }
          localqwg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localqwg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setText(localRecommendFollowInfo.nickName);
          localqwg.jdField_a_of_type_AndroidWidgetTextView.setText(localRecommendFollowInfo.recommendReason);
          if (!localRecommendFollowInfo.isFollowed) {
            break label483;
          }
          localqwg.b.setText(anni.a(2131701154));
          localqwg.b.setTextColor(Color.parseColor("#777777"));
          localqwg.b.setBackgroundResource(2130849428);
          localqwg.b.setOnClickListener(new qwb(this, localRecommendFollowInfo));
          localqwg.jdField_a_of_type_AndroidViewView.setVisibility(8);
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          localqwg = (qwg)paramView.getTag();
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          QLog.e(ComponentContentRecommend.a, 2, "getView, followItem.headUrl = " + localRecommendFollowInfo.headUrl + ", e = " + QLog.getStackTraceString(localMalformedURLException));
          localMalformedURLException.printStackTrace();
          continue;
          localqwg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRingAvatarView.showNormal();
          continue;
          label470:
          localqwg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          continue;
          label483:
          localqwg.b.setText(anni.a(2131701105));
          localqwg.b.setTextColor(-1);
          localqwg.b.setBackgroundResource(2130849385);
          localqwg.b.setCompoundDrawablePadding(afur.a(3.0F, this.a.getResources()));
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
 * Qualified Name:     qvz
 * JD-Core Version:    0.7.0.1
 */