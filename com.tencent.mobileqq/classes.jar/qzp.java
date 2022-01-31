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

public class qzp
  implements rjj
{
  private int jdField_a_of_type_Int = -1;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ReadInJoyXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  private ConcurrentHashMap<Integer, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private rjg jdField_a_of_type_Rjg;
  private rjk jdField_a_of_type_Rjk;
  private rqj jdField_a_of_type_Rqj;
  public boolean a;
  
  public qzp(Activity paramActivity, rqj paramrqj, rjg paramrjg, ReadInJoyXListView paramReadInJoyXListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager Constructor");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rqj = paramrqj;
    this.jdField_a_of_type_Rjg = paramrjg;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = paramReadInJoyXListView;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new qzq(this, Looper.getMainLooper());
  }
  
  public rjk a(AdvertisementInfo paramAdvertisementInfo, View paramView, pgq parampgq)
  {
    if ((paramAdvertisementInfo == null) || (paramView == null) || (parampgq == null)) {}
    while ((parampgq.a() != 6) && (parampgq.a() != 66) && (parampgq.a() != 115)) {
      return null;
    }
    paramView = (ProteusItemView)paramView;
    Object localObject = this.jdField_a_of_type_Rqj;
    localObject = rqj.a(paramAdvertisementInfo);
    paramView = paramView.a().getVirtualView().findViewBaseByName("id_article_large_imge");
    if (paramView != null)
    {
      ((rjk)localObject).jdField_a_of_type_AndroidViewView = paramView.getNativeView();
      if (paramView.getNativeView() != null) {
        ((rjk)localObject).l = paramView.getNativeView().getWidth();
      }
    }
    ((rjk)localObject).jdField_a_of_type_Int = parampgq.b;
    ((rjk)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramAdvertisementInfo;
    ((rjk)localObject).b = true;
    ((rjk)localObject).n = 1;
    return localObject;
  }
  
  public rjk a(boolean paramBoolean)
  {
    int i = 0;
    pgq localpgq;
    Object localObject2;
    if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
      if ((localObject1 != null) && ((localObject1 instanceof ProteusItemView)))
      {
        localpgq = (pgq)((View)localObject1).getTag(2131379913);
        localObject2 = localpgq.a();
        if (((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpgq.a() == 6)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpgq.a() == 66)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (localpgq.a() == 115)))
        {
          localObject2 = (AdvertisementInfo)localObject2;
          if ((paramBoolean) && (!oed.a((AdvertisementInfo)localObject2, null, this.jdField_a_of_type_Rqj.a(), 1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("RecommendADVideoFeedsManager", 2, "isADVideoAutoPlayFlag false, AdvertisementInfo = " + ((AdvertisementInfo)localObject2).toSString());
            }
            return null;
          }
        }
      }
    }
    for (Object localObject1 = a((AdvertisementInfo)localObject2, (View)localObject1, localpgq);; localObject1 = null)
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
  
  public void a(rjg paramrjg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onAttached");
    }
    this.jdField_a_of_type_Rjg = paramrjg;
    this.jdField_a_of_type_Rjg.a(this);
  }
  
  public void a(rjk paramrjk1, rjk paramrjk2)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramrjk2.jdField_a_of_type_Int), Integer.valueOf(0));
    this.jdField_a_of_type_Rjk = paramrjk2;
    rlb.a().b();
    this.jdField_a_of_type_Rjg.b(2);
    this.jdField_a_of_type_Rqj.jdField_a_of_type_Rjk = paramrjk2;
    this.jdField_a_of_type_Rjg.a(paramrjk2);
    if ((paramrjk2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (AdvertisementInfo.isAdvertisementInfo(paramrjk2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)))
    {
      ((AdvertisementInfo)paramrjk2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adbt = ((int)paramrjk2.d);
      ((AdvertisementInfo)paramrjk2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpa = 1;
      ((AdvertisementInfo)paramrjk2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpb = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "playVideoForADVideo  vid: " + paramrjk2.c + " playParams = " + paramrjk2.toString());
    }
  }
  
  public void a(rjk paramrjk, rjn paramrjn, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onStateChange: videoPlayParam " + paramrjk + " videoPlayerWrapper = " + paramrjn + " oldState" + paramInt1 + " newState = " + paramInt2);
    }
    if (paramInt2 == 7)
    {
      View localView;
      ReadInJoyAdVideoGuide localReadInJoyAdVideoGuide;
      AdvertisementInfo localAdvertisementInfo;
      String str3;
      String str4;
      if (paramrjk != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramrjk.jdField_a_of_type_Int), Integer.valueOf(7));
        if (QLog.isColorLevel()) {
          QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager mListPositionPlayStateMap " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.toString());
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
        {
          paramInt1 = 0;
          if (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
          {
            localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
            paramrjn = localView.getTag(2131379913);
            if ((!(paramrjn instanceof pgq)) || (((pgq)paramrjn).a() != paramrjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(paramrjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo))) {
              break label778;
            }
            paramrjn = (AdvertisementInfo)paramrjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
            if ((!(localView instanceof ProteusItemView)) || (!paramrjn.mShowAdButton)) {
              break label744;
            }
            paramrjn = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
            if ((paramrjn != null) && ((paramrjn instanceof pqt)) && (paramrjn.getNativeView() != null))
            {
              localReadInJoyAdVideoGuide = (ReadInJoyAdVideoGuide)((pqt)paramrjn).getNativeView();
              localAdvertisementInfo = (AdvertisementInfo)paramrjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
              paramrjn = "";
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
        paramrjn = str2;
        if (!TextUtils.isEmpty(localAdvertisementInfo.mJsonVideoList))
        {
          paramObject = str3;
          paramrjn = str2;
          JSONArray localJSONArray = new JSONObject(localAdvertisementInfo.mJsonVideoList).getJSONArray("videos");
          localObject = str4;
          str1 = str3;
          if (localJSONArray != null)
          {
            localObject = str4;
            str1 = str3;
            paramObject = str3;
            paramrjn = str2;
            if (localJSONArray.length() > 0)
            {
              paramObject = str3;
              paramrjn = str2;
              localObject = localJSONArray.getJSONObject(0);
              paramObject = str3;
              paramrjn = str2;
              str1 = ((JSONObject)localObject).optString("thirdIcon");
              paramObject = str1;
              paramrjn = str2;
              localObject = ((JSONObject)localObject).optString("thirdName");
            }
          }
        }
        paramrjn = str2;
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
      localReadInJoyAdVideoGuide.setAppInfo(localAdvertisementInfo.mAdProductType, paramObject, (String)localObject, paramrjn, oee.e(localAdvertisementInfo));
      localReadInJoyAdVideoGuide.setAdGuideClickListener(new qzr(this, localAdvertisementInfo, paramrjk));
      localReadInJoyAdVideoGuide.setVisibility(0);
      paramrjn = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_large_video_icon");
      if ((paramrjn != null) && (paramrjn.getNativeView() != null)) {
        paramrjn.getNativeView().setVisibility(8);
      }
      paramrjn = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_large_video_duration");
      if ((paramrjn != null) && (paramrjn.getNativeView() != null)) {
        paramrjn.getNativeView().setVisibility(8);
      }
      localAdvertisementInfo.isShowingGuide = true;
      label603:
      break label733;
      label604:
      this.jdField_a_of_type_Rqj.notifyDataSetChanged();
      label611:
      if ((paramInt2 == 0) && (paramrjk != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)) {
        paramInt1 = 0;
      }
    }
    for (;;)
    {
      boolean bool;
      if (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        paramrjn = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
        paramObject = paramrjn.getTag(2131379913);
        if ((!(paramObject instanceof pgq)) || (((pgq)paramObject).a() != paramrjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) || (!(paramrjn instanceof ProteusItemView))) {
          break label980;
        }
        paramObject = ((ProteusItemView)paramrjn).a().getVirtualView().findViewBaseByName("id_large_video_icon");
        bool = NetworkState.isWifiConn();
        if ((!(paramrjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo)) || (!((AdvertisementInfo)paramrjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).isHideForAnimate)) {}
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
        if ((paramrjk == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null)) {
          break label611;
        }
        paramInt1 = 0;
        for (;;)
        {
          if (paramInt1 >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount()) {
            break label914;
          }
          paramrjn = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
          paramObject = paramrjn.getTag(2131379913);
          if (((paramObject instanceof pgq)) && (((pgq)paramObject).a() == paramrjk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) && ((paramrjn instanceof ProteusItemView)))
          {
            paramrjn = ((ProteusItemView)paramrjn).a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
            if ((paramrjn == null) || (!(paramrjn instanceof pqt)) || (paramrjn.getNativeView() == null)) {
              break;
            }
            ((ReadInJoyAdVideoGuide)((pqt)paramrjn).getNativeView()).setVisibility(8);
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
      paramrjk = ((ProteusItemView)paramrjn).a().getVirtualView().findViewBaseByName("id_large_video_duration");
      if ((paramrjk == null) || (paramrjk.getNativeView() == null)) {
        break label603;
      }
      paramrjk.getNativeView().setVisibility(0);
      return;
      label980:
      paramInt1 += 1;
    }
  }
  
  public boolean a(rjk paramrjk)
  {
    if ((paramrjk == null) || (this.jdField_a_of_type_Boolean)) {}
    double d;
    do
    {
      do
      {
        return false;
        paramrjk = paramrjk.jdField_a_of_type_AndroidViewView;
      } while (paramrjk == null);
      int i = paramrjk.getHeight();
      Rect localRect = new Rect();
      paramrjk.getLocalVisibleRect(localRect);
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
    this.jdField_a_of_type_Rjg.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qzp
 * JD-Core Version:    0.7.0.1
 */