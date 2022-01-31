import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

public class oto
  implements owa
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return osr.a(paramInt, paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, opw paramopw, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    if ((paramopw != null) && ((paramopw.a() instanceof AdvertisementInfo)) && (((AdvertisementInfo)paramopw.a()).isHideForAnimate)) {}
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      if (NetworkState.isWifiConn())
      {
        localObject1 = localViewBase.findViewBaseByName("id_large_video_icon");
        if (localObject1 != null) {
          ((ViewBase)localObject1).setVisibility(0);
        }
        localObject1 = localViewBase.findViewBaseByName("id_video_bg");
        if (localObject1 != null) {
          ((ViewBase)localObject1).setVisibility(8);
        }
        obj.a(false, localViewBase, null);
        if ((paramopw == null) || (!(paramopw.a() instanceof AdvertisementInfo)) || (!((AdvertisementInfo)paramopw.a()).isShowingGuide)) {
          break label572;
        }
        localObject1 = (AdvertisementInfo)paramopw.a();
        localObject2 = localViewBase.findViewBaseByName("id_large_video_icon");
        if (localObject2 != null) {
          ((ViewBase)localObject2).setVisibility(8);
        }
        localObject2 = localViewBase.findViewBaseByName("id_video_bg");
        if (localObject2 != null) {
          ((ViewBase)localObject2).setVisibility(8);
        }
        localObject2 = localViewBase.findViewBaseByName("id_large_video_duration");
        if ((localObject2 != null) && (((ViewBase)localObject2).getNativeView() != null)) {
          ((ViewBase)localObject2).getNativeView().setVisibility(8);
        }
        paramContainer = ((View)paramContainer.getParent()).findViewById(2131296459);
        if ((paramContainer instanceof ReadInJoyAdVideoGuide)) {
          paramContainer.setVisibility(0);
        }
      }
      try
      {
        localObject2 = new JSONObject(((AdvertisementInfo)localObject1).mAdExt).optString("pkg_name");
        ((ReadInJoyAdVideoGuide)paramContainer).setAppInfo(((AdvertisementInfo)localObject1).mAdProductType, ((AdvertisementInfo)localObject1).mAdCorporateLogo, ((AdvertisementInfo)localObject1).mAdCorporationName, (String)localObject2, npj.e((AdvertisementInfo)localObject1));
        while ((paramopw != null) && (paramopw.a() != null) && (AdvertisementInfo.isAdvertisementInfo(paramopw.a())))
        {
          paramContainer = localViewBase.findViewBaseByName("id_view_AdDownloadView");
          if ((paramContainer != null) && ((paramContainer instanceof nqv)))
          {
            paramContainer = (nqv)paramContainer;
            paramContainer.a(paramInt1);
            paramContainer.a(paramopw, true);
          }
          paramContainer = localViewBase.findViewBaseByName("id_view_Ad_CompleteGudie");
          if ((paramContainer == null) || (!(paramContainer instanceof oyw))) {
            break;
          }
          paramopw = (AdvertisementInfo)paramopw.a();
          if ((!paramopw.isShowingGuide) || (!paramopw.mShowAdButton)) {
            break label625;
          }
          paramContainer.setVisibility(0);
          return;
          localObject1 = localViewBase.findViewBaseByName("id_large_video_icon");
          if (localObject1 != null) {
            ((ViewBase)localObject1).setVisibility(8);
          }
          localObject1 = localViewBase.findViewBaseByName("id_video_bg");
          if (localObject1 != null) {
            ((ViewBase)localObject1).setVisibility(0);
          }
          localObject2 = (NativeText)localViewBase.findViewBaseByName("id_video_paly_text");
          if (localObject2 != null)
          {
            localObject1 = ajjy.a(2131634020);
            if (bati.a() == 1)
            {
              localObject1 = ajjy.a(2131634019);
              label469:
              ((NativeText)localObject2).setText((CharSequence)localObject1);
            }
          }
          else
          {
            if (paramopw == null) {
              break label566;
            }
          }
          label566:
          for (localObject1 = paramopw.a();; localObject1 = null)
          {
            obj.a(localViewBase, (BaseArticleInfo)localObject1);
            break;
            if (paramopw == null) {
              break label636;
            }
            ArticleInfo localArticleInfo = paramopw.a();
            if (!(localArticleInfo instanceof AdvertisementInfo)) {
              break label636;
            }
            long l = ((AdvertisementInfo)localArticleInfo).mAdVideoFileSize;
            if (l <= 0L) {
              break label636;
            }
            localObject1 = qcn.b(l) + ajjy.a(2131634021);
            break label469;
          }
          label572:
          paramContainer = ((View)paramContainer.getParent()).findViewById(2131296459);
          if (paramContainer != null) {
            paramContainer.setVisibility(8);
          }
          paramContainer = localViewBase.findViewBaseByName("id_large_video_duration");
          if ((paramContainer != null) && (paramContainer.getNativeView() != null)) {
            paramContainer.getNativeView().setVisibility(0);
          }
        }
        label625:
        paramContainer.setVisibility(8);
        return;
      }
      catch (JSONException paramContainer)
      {
        label636:
        for (;;) {}
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, opw paramopw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oto
 * JD-Core Version:    0.7.0.1
 */