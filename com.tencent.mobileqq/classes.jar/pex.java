import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import cooperation.qzone.util.NetworkState;
import org.json.JSONObject;

public class pex
  implements php
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return pea.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pau parampau, int paramInt2)
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
      omr.a(false, localViewBase, null);
      if (parampau != null)
      {
        localObject = parampau.a();
        if ((localObject != null) && (((BaseArticleInfo)localObject).isAccountShown)) {
          pjm.a(paramContainer, parampau);
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
      localObject = ajya.a(2131701103);
      if (bbwq.a() == 1)
      {
        localObject = ajya.a(2131701104);
        label170:
        localNativeText.setText((CharSequence)localObject);
      }
    }
    else
    {
      if (parampau == null) {
        break label251;
      }
    }
    label251:
    for (localObject = parampau.a();; localObject = null)
    {
      omr.a(localViewBase, (BaseArticleInfo)localObject);
      break;
      if (parampau.a().mXGFileSize <= 0L) {
        break label170;
      }
      localObject = qoi.b(parampau.a().mXGFileSize) + ajya.a(2131701102);
      break label170;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pau parampau, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pex
 * JD-Core Version:    0.7.0.1
 */