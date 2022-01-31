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

public class pyl
  implements qhs
{
  private int jdField_a_of_type_Int = -1;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ReadInJoyXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  private ConcurrentHashMap<Integer, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private qhp jdField_a_of_type_Qhp;
  private qht jdField_a_of_type_Qht;
  private qoe jdField_a_of_type_Qoe;
  public boolean a;
  
  public pyl(Activity paramActivity, qoe paramqoe, qhp paramqhp, ReadInJoyXListView paramReadInJoyXListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager Constructor");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Qoe = paramqoe;
    this.jdField_a_of_type_Qhp = paramqhp;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = paramReadInJoyXListView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new pym(this, Looper.getMainLooper());
  }
  
  public qht a(AdvertisementInfo paramAdvertisementInfo, View paramView, oqh paramoqh)
  {
    if ((paramAdvertisementInfo == null) || (paramView == null) || (paramoqh == null)) {}
    while ((paramoqh.a() != 6) && (paramoqh.a() != 66) && (paramoqh.a() != 115)) {
      return null;
    }
    paramView = (ProteusItemView)paramView;
    Object localObject = this.jdField_a_of_type_Qoe;
    localObject = qoe.a(paramAdvertisementInfo);
    paramView = paramView.a().getVirtualView().findViewBaseByName("id_article_large_imge");
    if (paramView != null)
    {
      ((qht)localObject).jdField_a_of_type_AndroidViewView = paramView.getNativeView();
      if (paramView.getNativeView() != null) {
        ((qht)localObject).l = paramView.getNativeView().getWidth();
      }
    }
    ((qht)localObject).jdField_a_of_type_Int = paramoqh.b;
    ((qht)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramAdvertisementInfo;
    ((qht)localObject).b = true;
    ((qht)localObject).n = 1;
    return localObject;
  }
  
  public qht a(boolean paramBoolean)
  {
    int i = 0;
    oqh localoqh;
    Object localObject2;
    if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
      if ((localObject1 != null) && ((localObject1 instanceof ProteusItemView)))
      {
        localoqh = (oqh)((View)localObject1).getTag(2131313373);
        localObject2 = localoqh.a();
        if (((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localoqh.a() == 6)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localoqh.a() == 66)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localoqh.a() == 115)))
        {
          localObject2 = (AdvertisementInfo)localObject2;
          if ((paramBoolean) && (!npi.a((AdvertisementInfo)localObject2, null, this.jdField_a_of_type_Qoe.a(), 1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("RecommendADVideoFeedsManager", 2, "isADVideoAutoPlayFlag false, AdvertisementInfo = " + ((AdvertisementInfo)localObject2).toSString());
            }
            return null;
          }
        }
      }
    }
    for (Object localObject1 = a((AdvertisementInfo)localObject2, (View)localObject1, localoqh);; localObject1 = null)
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
  
  public void a(qhp paramqhp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onAttached");
    }
    this.jdField_a_of_type_Qhp = paramqhp;
    this.jdField_a_of_type_Qhp.a(this);
  }
  
  public void a(qht paramqht1, qht paramqht2)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramqht2.jdField_a_of_type_Int), Integer.valueOf(0));
    this.jdField_a_of_type_Qht = paramqht2;
    qji.a().b();
    this.jdField_a_of_type_Qhp.b(2);
    this.jdField_a_of_type_Qoe.jdField_a_of_type_Qht = paramqht2;
    this.jdField_a_of_type_Qhp.a(paramqht2);
    if ((paramqht2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (AdvertisementInfo.isAdvertisementInfo(paramqht2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)))
    {
      ((AdvertisementInfo)paramqht2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adbt = ((int)paramqht2.d);
      ((AdvertisementInfo)paramqht2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpa = 1;
      ((AdvertisementInfo)paramqht2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpb = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "playVideoForADVideo  vid: " + paramqht2.c + " playParams = " + paramqht2.toString());
    }
  }
  
  public void a(qht paramqht, qhw paramqhw, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onStateChange: videoPlayParam " + paramqht + " videoPlayerWrapper = " + paramqhw + " oldState" + paramInt1 + " newState = " + paramInt2);
    }
    if (paramInt2 == 7)
    {
      View localView;
      ReadInJoyAdVideoGuide localReadInJoyAdVideoGuide;
      AdvertisementInfo localAdvertisementInfo;
      String str3;
      String str4;
      if (paramqht != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramqht.jdField_a_of_type_Int), Integer.valueOf(7));
        if (QLog.isColorLevel()) {
          QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager mListPositionPlayStateMap " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.toString());
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
        {
          paramInt1 = 0;
          if (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
          {
            localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
            paramqhw = localView.getTag(2131313373);
            if ((!(paramqhw instanceof oqh)) || (((oqh)paramqhw).a() != paramqht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(paramqht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo))) {
              break label778;
            }
            paramqhw = (AdvertisementInfo)paramqht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
            if ((!(localView instanceof ProteusItemView)) || (!paramqhw.mShowAdButton)) {
              break label744;
            }
            paramqhw = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
            if ((paramqhw != null) && ((paramqhw instanceof oyw)) && (paramqhw.getNativeView() != null))
            {
              localReadInJoyAdVideoGuide = (ReadInJoyAdVideoGuide)((oyw)paramqhw).getNativeView();
              localAdvertisementInfo = (AdvertisementInfo)paramqht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
              paramqhw = "";
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
        paramqhw = str2;
        if (!TextUtils.isEmpty(localAdvertisementInfo.mJsonVideoList))
        {
          paramObject = str3;
          paramqhw = str2;
          JSONArray localJSONArray = new JSONObject(localAdvertisementInfo.mJsonVideoList).getJSONArray("videos");
          localObject = str4;
          str1 = str3;
          if (localJSONArray != null)
          {
            localObject = str4;
            str1 = str3;
            paramObject = str3;
            paramqhw = str2;
            if (localJSONArray.length() > 0)
            {
              paramObject = str3;
              paramqhw = str2;
              localObject = localJSONArray.getJSONObject(0);
              paramObject = str3;
              paramqhw = str2;
              str1 = ((JSONObject)localObject).optString("thirdIcon");
              paramObject = str1;
              paramqhw = str2;
              localObject = ((JSONObject)localObject).optString("thirdName");
            }
          }
        }
        paramqhw = str2;
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
      localReadInJoyAdVideoGuide.setAppInfo(localAdvertisementInfo.mAdProductType, paramObject, (String)localObject, paramqhw, npj.e(localAdvertisementInfo));
      localReadInJoyAdVideoGuide.setAdGuideClickListener(new pyn(this, localAdvertisementInfo, paramqht));
      localReadInJoyAdVideoGuide.setVisibility(0);
      paramqhw = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_large_video_icon");
      if ((paramqhw != null) && (paramqhw.getNativeView() != null)) {
        paramqhw.getNativeView().setVisibility(8);
      }
      paramqhw = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_large_video_duration");
      if ((paramqhw != null) && (paramqhw.getNativeView() != null)) {
        paramqhw.getNativeView().setVisibility(8);
      }
      localAdvertisementInfo.isShowingGuide = true;
      label603:
      break label733;
      label604:
      this.jdField_a_of_type_Qoe.notifyDataSetChanged();
      label611:
      if ((paramInt2 == 0) && (paramqht != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)) {
        paramInt1 = 0;
      }
    }
    for (;;)
    {
      boolean bool;
      if (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        paramqhw = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
        paramObject = paramqhw.getTag(2131313373);
        if ((!(paramObject instanceof oqh)) || (((oqh)paramObject).a() != paramqht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(paramqhw instanceof ProteusItemView))) {
          break label980;
        }
        paramObject = ((ProteusItemView)paramqhw).a().getVirtualView().findViewBaseByName("id_large_video_icon");
        bool = NetworkState.isWifiConn();
        if ((!(paramqht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo)) || (!((AdvertisementInfo)paramqht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).isHideForAnimate)) {}
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
        if ((paramqht == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null)) {
          break label611;
        }
        paramInt1 = 0;
        for (;;)
        {
          if (paramInt1 >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount()) {
            break label914;
          }
          paramqhw = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
          paramObject = paramqhw.getTag(2131313373);
          if (((paramObject instanceof oqh)) && (((oqh)paramObject).a() == paramqht.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) && ((paramqhw instanceof ProteusItemView)))
          {
            paramqhw = ((ProteusItemView)paramqhw).a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
            if ((paramqhw == null) || (!(paramqhw instanceof oyw)) || (paramqhw.getNativeView() == null)) {
              break;
            }
            ((ReadInJoyAdVideoGuide)((oyw)paramqhw).getNativeView()).setVisibility(8);
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
      paramqht = ((ProteusItemView)paramqhw).a().getVirtualView().findViewBaseByName("id_large_video_duration");
      if ((paramqht == null) || (paramqht.getNativeView() == null)) {
        break label603;
      }
      paramqht.getNativeView().setVisibility(0);
      return;
      label980:
      paramInt1 += 1;
    }
  }
  
  public boolean a(qht paramqht)
  {
    if ((paramqht == null) || (this.jdField_a_of_type_Boolean)) {}
    double d;
    do
    {
      do
      {
        return false;
        paramqht = paramqht.jdField_a_of_type_AndroidViewView;
      } while (paramqht == null);
      int i = paramqht.getHeight();
      Rect localRect = new Rect();
      paramqht.getLocalVisibleRect(localRect);
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
    this.jdField_a_of_type_Qhp.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pyl
 * JD-Core Version:    0.7.0.1
 */