import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class qkl
  implements qtx
{
  private int jdField_a_of_type_Int = -1;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ReadInJoyXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  private ConcurrentHashMap<Integer, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private qtu jdField_a_of_type_Qtu;
  private qty jdField_a_of_type_Qty;
  private rap jdField_a_of_type_Rap;
  public boolean a;
  
  public qkl(Activity paramActivity, rap paramrap, qtu paramqtu, ReadInJoyXListView paramReadInJoyXListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager Constructor");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rap = paramrap;
    this.jdField_a_of_type_Qtu = paramqtu;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = paramReadInJoyXListView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new qkm(this, Looper.getMainLooper());
  }
  
  public qty a(AdvertisementInfo paramAdvertisementInfo, View paramView, pbi parampbi)
  {
    if ((paramAdvertisementInfo == null) || (paramView == null) || (parampbi == null)) {}
    while ((parampbi.a() != 6) && (parampbi.a() != 66) && (parampbi.a() != 115)) {
      return null;
    }
    paramView = (ProteusItemView)paramView;
    Object localObject = this.jdField_a_of_type_Rap;
    localObject = rap.a(paramAdvertisementInfo);
    paramView = paramView.a().getVirtualView().findViewBaseByName("id_article_large_imge");
    if (paramView != null)
    {
      ((qty)localObject).jdField_a_of_type_AndroidViewView = paramView.getNativeView();
      if (paramView.getNativeView() != null) {
        ((qty)localObject).l = paramView.getNativeView().getWidth();
      }
    }
    ((qty)localObject).jdField_a_of_type_Int = parampbi.b;
    ((qty)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramAdvertisementInfo;
    ((qty)localObject).b = true;
    ((qty)localObject).n = 1;
    return localObject;
  }
  
  public qty a(boolean paramBoolean)
  {
    int i = 0;
    pbi localpbi;
    Object localObject2;
    if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
      if ((localObject1 != null) && ((localObject1 instanceof ProteusItemView)))
      {
        localpbi = (pbi)((View)localObject1).getTag(2131379208);
        localObject2 = localpbi.a();
        if (((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpbi.a() == 6)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpbi.a() == 66)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpbi.a() == 115)))
        {
          localObject2 = (AdvertisementInfo)localObject2;
          if ((paramBoolean) && (!oat.a((AdvertisementInfo)localObject2, null, this.jdField_a_of_type_Rap.a(), 1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("RecommendADVideoFeedsManager", 2, "isADVideoAutoPlayFlag false, AdvertisementInfo = " + ((AdvertisementInfo)localObject2).toSString());
            }
            return null;
          }
        }
      }
    }
    for (Object localObject1 = a((AdvertisementInfo)localObject2, (View)localObject1, localpbi);; localObject1 = null)
    {
      return localObject1;
      i += 1;
      break;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager doOnResume");
    }
  }
  
  public void a(qtu paramqtu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onAttached");
    }
    this.jdField_a_of_type_Qtu = paramqtu;
    this.jdField_a_of_type_Qtu.a(this);
  }
  
  public void a(qty paramqty1, qty paramqty2)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramqty2.jdField_a_of_type_Int), Integer.valueOf(0));
    this.jdField_a_of_type_Qty = paramqty2;
    qvn.a().b();
    this.jdField_a_of_type_Qtu.b(2);
    this.jdField_a_of_type_Rap.jdField_a_of_type_Qty = paramqty2;
    this.jdField_a_of_type_Qtu.a(paramqty2);
    if ((paramqty2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (AdvertisementInfo.isAdvertisementInfo(paramqty2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)))
    {
      ((AdvertisementInfo)paramqty2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adbt = ((int)paramqty2.d);
      ((AdvertisementInfo)paramqty2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpa = 1;
      ((AdvertisementInfo)paramqty2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpb = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "playVideoForADVideo  vid: " + paramqty2.c + " playParams = " + paramqty2.toString());
    }
  }
  
  public void a(qty paramqty, qub paramqub, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onStateChange: videoPlayParam " + paramqty + " videoPlayerWrapper = " + paramqub + " oldState" + paramInt1 + " newState = " + paramInt2);
    }
    if (paramInt2 == 7)
    {
      View localView;
      ReadInJoyAdVideoGuide localReadInJoyAdVideoGuide;
      AdvertisementInfo localAdvertisementInfo;
      String str3;
      String str4;
      if (paramqty != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramqty.jdField_a_of_type_Int), Integer.valueOf(7));
        if (QLog.isColorLevel()) {
          QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager mListPositionPlayStateMap " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.toString());
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
        {
          paramInt1 = 0;
          if (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
          {
            localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
            paramqub = localView.getTag(2131379208);
            if ((!(paramqub instanceof pbi)) || (((pbi)paramqub).a() != paramqty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(paramqty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo))) {
              break label778;
            }
            paramqub = (AdvertisementInfo)paramqty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
            if ((!(localView instanceof ProteusItemView)) || (!paramqub.mShowAdButton)) {
              break label744;
            }
            paramqub = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
            if ((paramqub != null) && ((paramqub instanceof pko)) && (paramqub.getNativeView() != null))
            {
              localReadInJoyAdVideoGuide = (ReadInJoyAdVideoGuide)((pko)paramqub).getNativeView();
              localAdvertisementInfo = (AdvertisementInfo)paramqty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
              paramqub = "";
              str3 = "";
              str4 = "";
              paramObject = str3;
            }
          }
        }
      }
      try
      {
        String str2 = new JSONObject(localAdvertisementInfo.mAdExt).optString("pkg_name");
        localObject = str4;
        String str1 = str3;
        paramObject = str3;
        paramqub = str2;
        if (!TextUtils.isEmpty(localAdvertisementInfo.mJsonVideoList))
        {
          paramObject = str3;
          paramqub = str2;
          JSONArray localJSONArray = new JSONObject(localAdvertisementInfo.mJsonVideoList).getJSONArray("videos");
          localObject = str4;
          str1 = str3;
          if (localJSONArray != null)
          {
            localObject = str4;
            str1 = str3;
            paramObject = str3;
            paramqub = str2;
            if (localJSONArray.length() > 0)
            {
              paramObject = str3;
              paramqub = str2;
              localObject = localJSONArray.getJSONObject(0);
              paramObject = str3;
              paramqub = str2;
              str1 = ((JSONObject)localObject).optString("thirdIcon");
              paramObject = str1;
              paramqub = str2;
              localObject = ((JSONObject)localObject).optString("thirdName");
            }
          }
        }
        paramqub = str2;
        paramObject = str1;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Object localObject = "";
        }
      }
      if (localAdvertisementInfo.mImaxShowAdType == 1001) {
        localReadInJoyAdVideoGuide.setBtnInfo(localAdvertisementInfo.mAdBtnTxt);
      }
      localReadInJoyAdVideoGuide.setAppInfo(localAdvertisementInfo.mAdProductType, paramObject, (String)localObject, paramqub, oau.e(localAdvertisementInfo));
      localReadInJoyAdVideoGuide.setAdGuideClickListener(new qkn(this, localAdvertisementInfo, paramqty));
      localReadInJoyAdVideoGuide.setVisibility(0);
      paramqub = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_large_video_icon");
      if ((paramqub != null) && (paramqub.getNativeView() != null)) {
        paramqub.getNativeView().setVisibility(8);
      }
      paramqub = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_large_video_duration");
      if ((paramqub != null) && (paramqub.getNativeView() != null)) {
        paramqub.getNativeView().setVisibility(8);
      }
      localAdvertisementInfo.isShowingGuide = true;
      label603:
      break label733;
      label604:
      this.jdField_a_of_type_Rap.notifyDataSetChanged();
      label611:
      if ((paramInt2 == 0) && (paramqty != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)) {
        paramInt1 = 0;
      }
    }
    for (;;)
    {
      boolean bool;
      if (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        paramqub = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
        paramObject = paramqub.getTag(2131379208);
        if ((!(paramObject instanceof pbi)) || (((pbi)paramObject).a() != paramqty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(paramqub instanceof ProteusItemView))) {
          break label980;
        }
        paramObject = ((ProteusItemView)paramqub).a().getVirtualView().findViewBaseByName("id_large_video_icon");
        bool = NetworkState.isWifiConn();
        if ((!(paramqty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo)) || (!((AdvertisementInfo)paramqty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).isHideForAnimate)) {}
      }
      else
      {
        label733:
        return;
        label744:
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          break label604;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(3001);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3001, 250L);
        break label604;
        label778:
        paramInt1 += 1;
        break;
        if ((paramqty == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null)) {
          break label611;
        }
        paramInt1 = 0;
        for (;;)
        {
          if (paramInt1 >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount()) {
            break label914;
          }
          paramqub = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
          paramObject = paramqub.getTag(2131379208);
          if (((paramObject instanceof pbi)) && (((pbi)paramObject).a() == paramqty.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) && ((paramqub instanceof ProteusItemView)))
          {
            paramqub = ((ProteusItemView)paramqub).a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
            if ((paramqub == null) || (!(paramqub instanceof pko)) || (paramqub.getNativeView() == null)) {
              break;
            }
            ((ReadInJoyAdVideoGuide)((pko)paramqub).getNativeView()).setVisibility(8);
            break;
          }
          paramInt1 += 1;
        }
        label914:
        break label611;
      }
      if ((paramObject != null) && (paramObject.getNativeView() != null) && (bool)) {
        paramObject.getNativeView().setVisibility(0);
      }
      paramqty = ((ProteusItemView)paramqub).a().getVirtualView().findViewBaseByName("id_large_video_duration");
      if ((paramqty == null) || (paramqty.getNativeView() == null)) {
        break label603;
      }
      paramqty.getNativeView().setVisibility(0);
      return;
      label980:
      paramInt1 += 1;
    }
  }
  
  public boolean a(qty paramqty)
  {
    if ((paramqty == null) || (this.jdField_a_of_type_Boolean)) {}
    double d;
    do
    {
      do
      {
        return false;
        paramqty = paramqty.jdField_a_of_type_AndroidViewView;
      } while (paramqty == null);
      int i = paramqty.getHeight();
      Rect localRect = new Rect();
      paramqty.getLocalVisibleRect(localRect);
      d = localRect.height() * 1.0F / i;
    } while ((d < 0.5D) && (d <= 0.800000011920929D));
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager doOnPause");
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager Destroy");
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3001);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    this.jdField_a_of_type_Qtu.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qkl
 * JD-Core Version:    0.7.0.1
 */