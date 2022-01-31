import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import cooperation.qzone.util.NetworkState;
import org.json.JSONObject;

public class pfa
  implements phs
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return ped.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pax parampax, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    if (NetworkState.isWifiConn())
    {
      localObject = localViewBase.findViewBaseByName("id_large_video_icon");
      if (localObject != null) {
        ((ViewBase)localObject).setVisibility(0);
      }
      localObject = localViewBase.findViewBaseByName("id_video_bg");
      if (localObject != null) {
        ((ViewBase)localObject).setVisibility(8);
      }
      omu.a(false, localViewBase, null);
      if (parampax != null)
      {
        localObject = parampax.a();
        if ((localObject != null) && (((BaseArticleInfo)localObject).isAccountShown)) {
          pjp.a(paramContainer, parampax);
        }
      }
      return;
    }
    Object localObject = localViewBase.findViewBaseByName("id_large_video_icon");
    if (localObject != null) {
      ((ViewBase)localObject).setVisibility(8);
    }
    localObject = localViewBase.findViewBaseByName("id_video_bg");
    if (localObject != null) {
      ((ViewBase)localObject).setVisibility(0);
    }
    NativeText localNativeText = (NativeText)localViewBase.findViewBaseByName("id_video_paly_text");
    if (localNativeText != null)
    {
      localObject = ajyc.a(2131701092);
      if (bbwc.a() == 1)
      {
        localObject = ajyc.a(2131701093);
        label170:
        localNativeText.setText((CharSequence)localObject);
      }
    }
    else
    {
      if (parampax == null) {
        break label251;
      }
    }
    label251:
    for (localObject = parampax.a();; localObject = null)
    {
      omu.a(localViewBase, (BaseArticleInfo)localObject);
      break;
      if (parampax.a().mXGFileSize <= 0L) {
        break label170;
      }
      localObject = qol.b(parampax.a().mXGFileSize) + ajyc.a(2131701091);
      break label170;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pax parampax, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pfa
 * JD-Core Version:    0.7.0.1
 */