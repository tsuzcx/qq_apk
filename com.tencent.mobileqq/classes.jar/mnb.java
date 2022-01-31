import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsAdapter.AdapterEventListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsAdapter.BaseItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsAdapter.ImageItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsAdapter.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsListView.ListViewEventListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class mnb
  implements FastWebVideoFeedsListView.ListViewEventListener
{
  public mnb(FastWebVideoFeedsAdapter paramFastWebVideoFeedsAdapter) {}
  
  public void a() {}
  
  public void a(Object paramObject)
  {
    Object localObject1;
    Object localObject2;
    boolean bool;
    if ((paramObject instanceof FastWebVideoFeedsAdapter.VideoItemHolder))
    {
      localObject1 = FastWebVideoFeedsAdapter.a(this.a);
      if (localObject1 != null)
      {
        ((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        ((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
        ((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).g.setVisibility(8);
      }
      if ((localObject1 != null) && (((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam != null) && (((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.a != null) && (((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.a.a(FastWebVideoFeedsAdapter.a(this.a), FastWebVideoFeedsAdapter.a(this.a))))
      {
        ((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).jdField_n_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        ((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).l.setVisibility(8);
      }
      localObject1 = (FastWebVideoFeedsAdapter.VideoItemHolder)paramObject;
      FastWebVideoFeedsAdapter.a(this.a, (FastWebVideoFeedsAdapter.VideoItemHolder)localObject1);
      localObject2 = this.a;
      if (FastWebVideoFeedsAdapter.a(this.a) - ((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).jdField_a_of_type_Int < 0)
      {
        bool = true;
        FastWebVideoFeedsAdapter.a((FastWebVideoFeedsAdapter)localObject2, bool);
        FastWebVideoFeedsAdapter.a(this.a, ((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).jdField_a_of_type_Int);
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsAdapter", 2, "onCenterViewChanged() videoInfo = " + FastWebVideoFeedsAdapter.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.a.a());
        }
        if (FastWebVideoFeedsAdapter.c(this.a)) {
          break label641;
        }
        FastWebVideoFeedsAdapter.a(this.a).jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        if (!FastWebVideoFeedsAdapter.d(this.a)) {
          FastWebVideoFeedsAdapter.a(this.a).g.setVisibility(8);
        }
        FastWebVideoFeedsAdapter.b(this.a, true);
        label273:
        if ((FastWebVideoFeedsAdapter.a(this.a) != null) && (FastWebVideoFeedsAdapter.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam != null) && (FastWebVideoFeedsAdapter.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.a.a(FastWebVideoFeedsAdapter.a(this.a), FastWebVideoFeedsAdapter.a(this.a))))
        {
          FastWebVideoFeedsAdapter.a(this.a).jdField_n_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          FastWebVideoFeedsAdapter.a(this.a).l.setVisibility(8);
          FastWebVideoFeedsAdapter.a(this.a).p.setVisibility(8);
        }
        FastWebVideoFeedsAdapter.a(this.a, (FastWebVideoFeedsAdapter.VideoItemHolder)localObject1);
        if ((((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).jdField_a_of_type_Int >= this.a.getCount() - 5) && (FastWebVideoFeedsAdapter.a(this.a) != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.FastWebVideoFeedsAdapter", 2, "onCenterViewChanged() holder.position = " + ((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).jdField_a_of_type_Int + ", getCount() = " + this.a.getCount() + ", 推荐视频列表提前预拉取");
          }
          FastWebVideoFeedsAdapter.a(this.a).a();
        }
        FastWebVideoFeedsAdapter.a(this.a, System.currentTimeMillis());
        FastWebVideoFeedsAdapter.a(this.a).removeMessages(0);
        FastWebVideoFeedsAdapter.a(this.a).sendEmptyMessageDelayed(0, 5000L);
        if ((((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam != null) && (((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.a != null) && (((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_Boolean) && (((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
        {
          localObject2 = ((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h;
          if (!FastWebVideoFeedsAdapter.a(this.a).contains(localObject2))
          {
            FastWebVideoFeedsAdapter.a(this.a).add(localObject2);
            VideoReporter.a(FastWebVideoFeedsAdapter.a(this.a), 1, ((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, null);
          }
        }
      }
    }
    for (;;)
    {
      FastWebVideoFeedsAdapter.a(this.a, (FastWebVideoFeedsAdapter.BaseItemHolder)paramObject);
      return;
      bool = false;
      break;
      label641:
      FastWebVideoFeedsAdapter.a(this.a).jdField_h_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      FastWebVideoFeedsAdapter.a(this.a).jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      FastWebVideoFeedsAdapter.a(this.a).jdField_a_of_type_AndroidViewView.setVisibility(8);
      if ((FastWebVideoFeedsAdapter.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam != null) && (!FastWebVideoFeedsAdapter.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoFeedsPlayManager$VideoPlayParam.a.a(FastWebVideoFeedsAdapter.a(this.a), FastWebVideoFeedsAdapter.a(this.a)))) {
        FastWebVideoFeedsAdapter.a(this.a).b.setVisibility(0);
      }
      VideoFeedsHelper.a(((FastWebVideoFeedsAdapter.VideoItemHolder)localObject1).g, 0, 800);
      break label273;
      if ((paramObject instanceof FastWebVideoFeedsAdapter.ImageItemHolder))
      {
        FastWebVideoFeedsAdapter.a(this.a);
        if (NetworkUtil.a(FastWebVideoFeedsAdapter.a(this.a))) {
          FastWebVideoFeedsAdapter.a(this.a).sendEmptyMessageDelayed(2, 5000L);
        }
        localObject1 = (FastWebVideoFeedsAdapter.ImageItemHolder)paramObject;
        if ((((FastWebVideoFeedsAdapter.ImageItemHolder)localObject1).a != null) && (((FastWebVideoFeedsAdapter.ImageItemHolder)localObject1).a.jdField_a_of_type_Boolean) && (((FastWebVideoFeedsAdapter.ImageItemHolder)localObject1).a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
        {
          localObject2 = ((FastWebVideoFeedsAdapter.ImageItemHolder)localObject1).a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h;
          if (!FastWebVideoFeedsAdapter.a(this.a).contains(localObject2))
          {
            FastWebVideoFeedsAdapter.a(this.a).add(localObject2);
            VideoReporter.a(FastWebVideoFeedsAdapter.a(this.a), 1, ((FastWebVideoFeedsAdapter.ImageItemHolder)localObject1).a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, null);
          }
        }
      }
    }
  }
  
  public void a(Object paramObject, boolean paramBoolean)
  {
    FastWebVideoFeedsAdapter.c(this.a, paramBoolean);
    if ((paramObject instanceof FastWebVideoFeedsAdapter.VideoItemHolder))
    {
      paramObject = (FastWebVideoFeedsAdapter.VideoItemHolder)paramObject;
      if (paramBoolean)
      {
        paramObject.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramObject.e.setVisibility(8);
        paramObject.i.setVisibility(8);
        paramObject.c.setVisibility(8);
        paramObject.jdField_n_of_type_AndroidWidgetImageView.setBackgroundDrawable(FastWebVideoFeedsAdapter.a(this.a, 2130839757));
      }
    }
    while (!(paramObject instanceof FastWebVideoFeedsAdapter.ImageItemHolder))
    {
      return;
      paramObject.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramObject.e.setVisibility(0);
      paramObject.i.setVisibility(0);
      paramObject.c.setVisibility(0);
      paramObject.jdField_n_of_type_AndroidWidgetImageView.setBackgroundDrawable(FastWebVideoFeedsAdapter.a(this.a, 2130839758));
      return;
    }
    paramObject = (FastWebVideoFeedsAdapter.ImageItemHolder)paramObject;
    if (paramBoolean)
    {
      paramObject.b.setVisibility(0);
      paramObject.c.setVisibility(8);
      return;
    }
    paramObject.b.setVisibility(8);
    paramObject.c.setVisibility(0);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mnb
 * JD-Core Version:    0.7.0.1
 */