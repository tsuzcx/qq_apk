import android.graphics.Rect;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;

public class mfr
  implements Runnable
{
  public mfr(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public void run()
  {
    if (this.a.i)
    {
      ReadInJoyLogicEngine.a().f(this.a.c);
      this.a.i = false;
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
            break label182;
          }
          j = 1;
        }
      }
      for (;;)
      {
        if (j == 1)
        {
          if ((localBaseArticleInfo.mChannelID == 56L) && (ReadInJoyLogicEngine.a().a((AdvertisementInfo)localBaseArticleInfo))) {
            NativeAdUtils.a(null, this.a.jdField_a_of_type_AndroidAppActivity, NativeAdUtils.b, NativeAdUtils.j, (AdvertisementInfo)localBaseArticleInfo, null, 0);
          }
          ReadInJoyLogicEngine.a().a(1, (AdvertisementInfo)localBaseArticleInfo);
        }
        k += 1;
        break label64;
        break;
        label182:
        View localView = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(k - i);
        j = localView.getHeight();
        Rect localRect = new Rect();
        localView.getGlobalVisibleRect(localRect);
        if (localRect.height() >= j / 2) {
          j = 1;
        } else {
          j = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfr
 * JD-Core Version:    0.7.0.1
 */