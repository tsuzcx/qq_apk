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

public class qki
  implements qtu
{
  private int jdField_a_of_type_Int = -1;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ReadInJoyXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  private ConcurrentHashMap<Integer, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private qtr jdField_a_of_type_Qtr;
  private qtv jdField_a_of_type_Qtv;
  private ram jdField_a_of_type_Ram;
  public boolean a;
  
  public qki(Activity paramActivity, ram paramram, qtr paramqtr, ReadInJoyXListView paramReadInJoyXListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager Constructor");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Ram = paramram;
    this.jdField_a_of_type_Qtr = paramqtr;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = paramReadInJoyXListView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new qkj(this, Looper.getMainLooper());
  }
  
  public qtv a(AdvertisementInfo paramAdvertisementInfo, View paramView, pbf parampbf)
  {
    if ((paramAdvertisementInfo == null) || (paramView == null) || (parampbf == null)) {}
    while ((parampbf.a() != 6) && (parampbf.a() != 66) && (parampbf.a() != 115)) {
      return null;
    }
    paramView = (ProteusItemView)paramView;
    Object localObject = this.jdField_a_of_type_Ram;
    localObject = ram.a(paramAdvertisementInfo);
    paramView = paramView.a().getVirtualView().findViewBaseByName("id_article_large_imge");
    if (paramView != null)
    {
      ((qtv)localObject).jdField_a_of_type_AndroidViewView = paramView.getNativeView();
      if (paramView.getNativeView() != null) {
        ((qtv)localObject).l = paramView.getNativeView().getWidth();
      }
    }
    ((qtv)localObject).jdField_a_of_type_Int = parampbf.b;
    ((qtv)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramAdvertisementInfo;
    ((qtv)localObject).b = true;
    ((qtv)localObject).n = 1;
    return localObject;
  }
  
  public qtv a(boolean paramBoolean)
  {
    int i = 0;
    pbf localpbf;
    Object localObject2;
    if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
      if ((localObject1 != null) && ((localObject1 instanceof ProteusItemView)))
      {
        localpbf = (pbf)((View)localObject1).getTag(2131379213);
        localObject2 = localpbf.a();
        if (((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpbf.a() == 6)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpbf.a() == 66)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpbf.a() == 115)))
        {
          localObject2 = (AdvertisementInfo)localObject2;
          if ((paramBoolean) && (!oaq.a((AdvertisementInfo)localObject2, null, this.jdField_a_of_type_Ram.a(), 1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("RecommendADVideoFeedsManager", 2, "isADVideoAutoPlayFlag false, AdvertisementInfo = " + ((AdvertisementInfo)localObject2).toSString());
            }
            return null;
          }
        }
      }
    }
    for (Object localObject1 = a((AdvertisementInfo)localObject2, (View)localObject1, localpbf);; localObject1 = null)
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
  
  public void a(qtr paramqtr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onAttached");
    }
    this.jdField_a_of_type_Qtr = paramqtr;
    this.jdField_a_of_type_Qtr.a(this);
  }
  
  public void a(qtv paramqtv1, qtv paramqtv2)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramqtv2.jdField_a_of_type_Int), Integer.valueOf(0));
    this.jdField_a_of_type_Qtv = paramqtv2;
    qvk.a().b();
    this.jdField_a_of_type_Qtr.b(2);
    this.jdField_a_of_type_Ram.jdField_a_of_type_Qtv = paramqtv2;
    this.jdField_a_of_type_Qtr.a(paramqtv2);
    if ((paramqtv2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (AdvertisementInfo.isAdvertisementInfo(paramqtv2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)))
    {
      ((AdvertisementInfo)paramqtv2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adbt = ((int)paramqtv2.d);
      ((AdvertisementInfo)paramqtv2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpa = 1;
      ((AdvertisementInfo)paramqtv2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpb = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "playVideoForADVideo  vid: " + paramqtv2.c + " playParams = " + paramqtv2.toString());
    }
  }
  
  public void a(qtv paramqtv, qty paramqty, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onStateChange: videoPlayParam " + paramqtv + " videoPlayerWrapper = " + paramqty + " oldState" + paramInt1 + " newState = " + paramInt2);
    }
    if (paramInt2 == 7)
    {
      View localView;
      ReadInJoyAdVideoGuide localReadInJoyAdVideoGuide;
      AdvertisementInfo localAdvertisementInfo;
      String str3;
      String str4;
      if (paramqtv != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramqtv.jdField_a_of_type_Int), Integer.valueOf(7));
        if (QLog.isColorLevel()) {
          QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager mListPositionPlayStateMap " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.toString());
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
        {
          paramInt1 = 0;
          if (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
          {
            localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
            paramqty = localView.getTag(2131379213);
            if ((!(paramqty instanceof pbf)) || (((pbf)paramqty).a() != paramqtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(paramqtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo))) {
              break label778;
            }
            paramqty = (AdvertisementInfo)paramqtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
            if ((!(localView instanceof ProteusItemView)) || (!paramqty.mShowAdButton)) {
              break label744;
            }
            paramqty = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
            if ((paramqty != null) && ((paramqty instanceof pkl)) && (paramqty.getNativeView() != null))
            {
              localReadInJoyAdVideoGuide = (ReadInJoyAdVideoGuide)((pkl)paramqty).getNativeView();
              localAdvertisementInfo = (AdvertisementInfo)paramqtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
              paramqty = "";
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
        paramqty = str2;
        if (!TextUtils.isEmpty(localAdvertisementInfo.mJsonVideoList))
        {
          paramObject = str3;
          paramqty = str2;
          JSONArray localJSONArray = new JSONObject(localAdvertisementInfo.mJsonVideoList).getJSONArray("videos");
          localObject = str4;
          str1 = str3;
          if (localJSONArray != null)
          {
            localObject = str4;
            str1 = str3;
            paramObject = str3;
            paramqty = str2;
            if (localJSONArray.length() > 0)
            {
              paramObject = str3;
              paramqty = str2;
              localObject = localJSONArray.getJSONObject(0);
              paramObject = str3;
              paramqty = str2;
              str1 = ((JSONObject)localObject).optString("thirdIcon");
              paramObject = str1;
              paramqty = str2;
              localObject = ((JSONObject)localObject).optString("thirdName");
            }
          }
        }
        paramqty = str2;
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
      localReadInJoyAdVideoGuide.setAppInfo(localAdvertisementInfo.mAdProductType, paramObject, (String)localObject, paramqty, oar.e(localAdvertisementInfo));
      localReadInJoyAdVideoGuide.setAdGuideClickListener(new qkk(this, localAdvertisementInfo, paramqtv));
      localReadInJoyAdVideoGuide.setVisibility(0);
      paramqty = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_large_video_icon");
      if ((paramqty != null) && (paramqty.getNativeView() != null)) {
        paramqty.getNativeView().setVisibility(8);
      }
      paramqty = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_large_video_duration");
      if ((paramqty != null) && (paramqty.getNativeView() != null)) {
        paramqty.getNativeView().setVisibility(8);
      }
      localAdvertisementInfo.isShowingGuide = true;
      label603:
      break label733;
      label604:
      this.jdField_a_of_type_Ram.notifyDataSetChanged();
      label611:
      if ((paramInt2 == 0) && (paramqtv != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)) {
        paramInt1 = 0;
      }
    }
    for (;;)
    {
      boolean bool;
      if (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        paramqty = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
        paramObject = paramqty.getTag(2131379213);
        if ((!(paramObject instanceof pbf)) || (((pbf)paramObject).a() != paramqtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(paramqty instanceof ProteusItemView))) {
          break label980;
        }
        paramObject = ((ProteusItemView)paramqty).a().getVirtualView().findViewBaseByName("id_large_video_icon");
        bool = NetworkState.isWifiConn();
        if ((!(paramqtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo)) || (!((AdvertisementInfo)paramqtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).isHideForAnimate)) {}
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
        if ((paramqtv == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null)) {
          break label611;
        }
        paramInt1 = 0;
        for (;;)
        {
          if (paramInt1 >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount()) {
            break label914;
          }
          paramqty = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
          paramObject = paramqty.getTag(2131379213);
          if (((paramObject instanceof pbf)) && (((pbf)paramObject).a() == paramqtv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) && ((paramqty instanceof ProteusItemView)))
          {
            paramqty = ((ProteusItemView)paramqty).a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
            if ((paramqty == null) || (!(paramqty instanceof pkl)) || (paramqty.getNativeView() == null)) {
              break;
            }
            ((ReadInJoyAdVideoGuide)((pkl)paramqty).getNativeView()).setVisibility(8);
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
      paramqtv = ((ProteusItemView)paramqty).a().getVirtualView().findViewBaseByName("id_large_video_duration");
      if ((paramqtv == null) || (paramqtv.getNativeView() == null)) {
        break label603;
      }
      paramqtv.getNativeView().setVisibility(0);
      return;
      label980:
      paramInt1 += 1;
    }
  }
  
  public boolean a(qtv paramqtv)
  {
    if ((paramqtv == null) || (this.jdField_a_of_type_Boolean)) {}
    double d;
    do
    {
      do
      {
        return false;
        paramqtv = paramqtv.jdField_a_of_type_AndroidViewView;
      } while (paramqtv == null);
      int i = paramqtv.getHeight();
      Rect localRect = new Rect();
      paramqtv.getLocalVisibleRect(localRect);
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
    this.jdField_a_of_type_Qtr.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qki
 * JD-Core Version:    0.7.0.1
 */