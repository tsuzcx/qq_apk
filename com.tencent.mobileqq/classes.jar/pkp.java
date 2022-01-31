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

public class pkp
  implements poa
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return pjs.a(paramInt, paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    if ((parampgd != null) && ((parampgd.a() instanceof AdvertisementInfo)) && (((AdvertisementInfo)parampgd.a()).isHideForAnimate)) {}
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
        orc.a(false, localViewBase, null);
        if ((parampgd == null) || (!(parampgd.a() instanceof AdvertisementInfo)) || (!((AdvertisementInfo)parampgd.a()).isShowingGuide)) {
          break label572;
        }
        localObject1 = (AdvertisementInfo)parampgd.a();
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
        paramContainer = ((View)paramContainer.getParent()).findViewById(2131362002);
        if ((paramContainer instanceof ReadInJoyAdVideoGuide)) {
          paramContainer.setVisibility(0);
        }
      }
      try
      {
        localObject2 = new JSONObject(((AdvertisementInfo)localObject1).mAdExt).optString("pkg_name");
        ((ReadInJoyAdVideoGuide)paramContainer).setAppInfo(((AdvertisementInfo)localObject1).mAdProductType, ((AdvertisementInfo)localObject1).mAdCorporateLogo, ((AdvertisementInfo)localObject1).mAdCorporationName, (String)localObject2, oee.e((AdvertisementInfo)localObject1));
        while ((parampgd != null) && (parampgd.a() != null) && (AdvertisementInfo.isAdvertisementInfo(parampgd.a())))
        {
          paramContainer = localViewBase.findViewBaseByName("id_view_AdDownloadView");
          if ((paramContainer != null) && ((paramContainer instanceof oft)))
          {
            paramContainer = (oft)paramContainer;
            paramContainer.a(paramInt1);
            paramContainer.a(parampgd, true);
          }
          paramContainer = localViewBase.findViewBaseByName("id_view_Ad_CompleteGudie");
          if ((paramContainer == null) || (!(paramContainer instanceof pqt))) {
            break;
          }
          parampgd = (AdvertisementInfo)parampgd.a();
          if ((!parampgd.isShowingGuide) || (!parampgd.mShowAdButton)) {
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
            localObject1 = alpo.a(2131700188);
            if (bdvr.a() == 1)
            {
              localObject1 = alpo.a(2131700187);
              label469:
              ((NativeText)localObject2).setText((CharSequence)localObject1);
            }
          }
          else
          {
            if (parampgd == null) {
              break label566;
            }
          }
          label566:
          for (localObject1 = parampgd.a();; localObject1 = null)
          {
            orc.a(localViewBase, (BaseArticleInfo)localObject1);
            break;
            if (parampgd == null) {
              break label636;
            }
            ArticleInfo localArticleInfo = parampgd.a();
            if (!(localArticleInfo instanceof AdvertisementInfo)) {
              break label636;
            }
            long l = ((AdvertisementInfo)localArticleInfo).mAdVideoFileSize;
            if (l <= 0L) {
              break label636;
            }
            localObject1 = rdm.b(l) + alpo.a(2131700189);
            break label469;
          }
          label572:
          paramContainer = ((View)paramContainer.getParent()).findViewById(2131362002);
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
  
  public boolean a(int paramInt, Container paramContainer, pgd parampgd, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pkp
 * JD-Core Version:    0.7.0.1
 */