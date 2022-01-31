import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import cooperation.qzone.util.NetworkState;
import org.json.JSONObject;

public class oty
  implements owa
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return otb.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, opw paramopw, int paramInt2)
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
      obj.a(false, localViewBase, null);
      if (paramopw != null)
      {
        localObject = paramopw.a();
        if ((localObject != null) && (((BaseArticleInfo)localObject).isAccountShown)) {
          oxx.a(paramContainer, paramopw);
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
      localObject = ajjy.a(2131635308);
      if (bati.a() == 1)
      {
        localObject = ajjy.a(2131635309);
        label170:
        localNativeText.setText((CharSequence)localObject);
      }
    }
    else
    {
      if (paramopw == null) {
        break label251;
      }
    }
    label251:
    for (localObject = paramopw.a();; localObject = null)
    {
      obj.a(localViewBase, (BaseArticleInfo)localObject);
      break;
      if (paramopw.a().mXGFileSize <= 0L) {
        break label170;
      }
      localObject = qcn.b(paramopw.a().mXGFileSize) + ajjy.a(2131635307);
      break label170;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, opw paramopw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oty
 * JD-Core Version:    0.7.0.1
 */