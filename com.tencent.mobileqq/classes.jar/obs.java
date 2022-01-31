import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.List;

class obs
  extends oxe
{
  obs(obq paramobq) {}
  
  public void a(Object paramObject, int paramInt, boolean paramBoolean, String... paramVarArgs)
  {
    if (paramInt == 101) {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    }
    Object localObject1;
    int j;
    int i;
    int k;
    label80:
    Object localObject3;
    Object localObject2;
    int m;
    while (paramInt != 110) {
      for (;;)
      {
        return;
        paramObject = (ReadInJoyXListView)this.a.a().a();
        localObject1 = this.a.a().a();
        if ((paramObject != null) && (localObject1 != null))
        {
          paramVarArgs = paramVarArgs[0];
          try
          {
            j = paramObject.getHeaderViewsCount();
            i = paramObject.getFirstVisiblePosition();
            k = paramObject.getLastVisiblePosition();
            paramInt = i;
            if (paramInt <= k)
            {
              if ((paramInt < j) || (paramInt - j >= ((List)localObject1).size())) {
                break label717;
              }
              localObject3 = (BaseArticleInfo)((List)localObject1).get(paramInt - j);
              localObject2 = paramObject.getChildAt(paramInt - i);
              if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject3)) {
                break label717;
              }
              localObject3 = (AdvertisementInfo)localObject3;
              m = oee.a((AdvertisementInfo)localObject3);
              String str = oee.b((AdvertisementInfo)localObject3);
              if ((m != 1) || (!paramVarArgs.equals(str)) || (!(localObject2 instanceof ProteusItemView))) {
                break label717;
              }
              localObject2 = ((ProteusItemView)localObject2).a().getVirtualView().findViewBaseByName("id_view_AdDownloadView");
              if ((localObject2 == null) || (!(localObject2 instanceof oft))) {
                break label717;
              }
              ((oft)localObject2).a(true, (AdvertisementInfo)localObject3, paramVarArgs);
            }
          }
          catch (Exception paramObject)
          {
            return;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramObject = (ReadInJoyXListView)this.a.a().a();
        paramVarArgs = this.a.a().a();
        k = paramObject.getHeaderViewsCount();
        j = paramObject.getFirstVisiblePosition();
        m = paramObject.getLastVisiblePosition();
        paramInt = j;
        if (paramInt > m) {
          break;
        }
        if ((paramInt < k) || (paramInt - k >= paramVarArgs.size())) {
          break label724;
        }
        localObject1 = (BaseArticleInfo)paramVarArgs.get(paramInt - k);
        localObject2 = paramObject.getChildAt(paramInt - j);
        if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject1)) {
          break label724;
        }
        localObject3 = (AdvertisementInfo)localObject1;
        if (!((AdvertisementInfo)localObject3).isHideForAnimate) {
          break label724;
        }
        if (paramBoolean) {
          break label640;
        }
        i = 4;
        localObject2 = ((ProteusItemView)localObject2).a().getVirtualView();
        if (((AdvertisementInfo)localObject3).mImaxShowAdType != 1001) {
          break label679;
        }
        localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_article_large_imge");
        if (localObject3 != null) {
          ((ViewBase)localObject3).getNativeView().setVisibility(i);
        }
        localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_large_video_icon");
        if (localObject3 != null) {
          ((ViewBase)localObject3).getNativeView().setVisibility(4);
        }
        if ((!NetworkState.isWifiConn()) || (i != 0)) {
          break label652;
        }
        if (localObject3 != null) {
          ((ViewBase)localObject3).getNativeView().setVisibility(i);
        }
        localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_view_Ad_CompleteGudie");
        if (localObject3 != null) {
          ((ViewBase)localObject3).getNativeView().setVisibility(4);
        }
        localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_large_video_activity_img");
        if (localObject3 != null) {
          ((ViewBase)localObject3).getNativeView().setVisibility(4);
        }
        localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_large_video_cover");
        if (localObject3 != null) {
          ((ViewBase)localObject3).getNativeView().setVisibility(i);
        }
        localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_large_video_duration");
        if (localObject3 != null) {
          ((ViewBase)localObject3).getNativeView().setVisibility(i);
        }
        if (!((AdvertisementInfo)localObject1).isIMaxAndNewStyle) {
          break label724;
        }
        localObject1 = ((ViewBase)localObject2).findViewBaseByName("id_artilce_title");
        if (localObject1 == null) {
          break label724;
        }
        ((ViewBase)localObject1).getNativeView().setVisibility(i);
      }
      catch (Exception paramObject) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInjoyIMAXAdFragment", 2, "error  =>" + paramObject.getMessage());
      return;
      label640:
      ((AdvertisementInfo)localObject3).isHideForAnimate = false;
      i = 0;
      continue;
      label652:
      localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_video_bg");
      if (localObject3 != null)
      {
        ((ViewBase)localObject3).getNativeView().setVisibility(i);
        continue;
        label679:
        if (((AdvertisementInfo)localObject3).mImaxShowAdType == 1002)
        {
          localObject1 = ((ViewBase)localObject2).findViewBaseByName("id_article_double_image");
          if (localObject1 != null)
          {
            ((ViewBase)localObject1).getNativeView().setVisibility(i);
            break label724;
            label717:
            paramInt += 1;
            break label80;
          }
        }
        label724:
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     obs
 * JD-Core Version:    0.7.0.1
 */