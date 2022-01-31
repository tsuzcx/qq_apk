import android.graphics.Rect;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;

public class mgw
  implements Runnable
{
  public mgw(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public void run()
  {
    if (this.a.h)
    {
      ReadInJoyLogicEngine.a().f(this.a.c);
      this.a.h = false;
      return;
    }
    int i = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition();
    if (i < 1) {
      i = 1;
    }
    for (;;)
    {
      int m = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition();
      int k = i;
      label64:
      BaseArticleInfo localBaseArticleInfo;
      int j;
      if (k <= m)
      {
        localBaseArticleInfo = this.a.b(k - 1);
        if ((localBaseArticleInfo != null) && ((localBaseArticleInfo instanceof AdvertisementInfo)))
        {
          if ((k <= i) || (k >= m)) {
            break label228;
          }
          j = 1;
        }
      }
      for (;;)
      {
        label108:
        if (j == 1)
        {
          if ((localBaseArticleInfo.mChannelID == 56L) && (ReadInJoyLogicEngine.a().a((AdvertisementInfo)localBaseArticleInfo))) {
            NativeAdUtils.a(null, this.a.jdField_a_of_type_AndroidAppActivity, NativeAdUtils.b, NativeAdUtils.l, (AdvertisementInfo)localBaseArticleInfo, null, 0L);
          }
          if ((localBaseArticleInfo.mChannelID == 0L) && (ReadInJoyLogicEngine.a().a((AdvertisementInfo)localBaseArticleInfo))) {
            if (!ReadInJoyUtils.a(localBaseArticleInfo)) {
              break label282;
            }
          }
        }
        label282:
        for (j = NativeAdUtils.o;; j = NativeAdUtils.k)
        {
          NativeAdUtils.a(null, this.a.jdField_a_of_type_AndroidAppActivity, NativeAdUtils.b, j, (AdvertisementInfo)localBaseArticleInfo, null, 0L);
          k += 1;
          break label64;
          break;
          label228:
          View localView = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(k - i);
          j = localView.getHeight();
          Rect localRect = new Rect();
          localView.getGlobalVisibleRect(localRect);
          if (localRect.height() < j / 2) {
            break label289;
          }
          j = 1;
          break label108;
        }
        label289:
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mgw
 * JD-Core Version:    0.7.0.1
 */