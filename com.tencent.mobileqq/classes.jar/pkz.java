import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import cooperation.qzone.util.NetworkState;
import org.json.JSONObject;

public class pkz
  implements poa
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return pkc.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2)
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
      orc.a(false, localViewBase, null);
      if (parampgd != null)
      {
        localObject = parampgd.a();
        if ((localObject != null) && (((BaseArticleInfo)localObject).isAccountShown)) {
          ppx.a(paramContainer, parampgd);
        }
      }
      ppy.a(parampgd.a(), paramContainer, parampgd);
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
    String str;
    if (localNativeText != null)
    {
      str = alud.a(2131701484);
      if (beaa.a() == 1)
      {
        localObject = alud.a(2131701485);
        label181:
        localNativeText.setText((CharSequence)localObject);
      }
    }
    else
    {
      if (parampgd == null) {
        break label274;
      }
    }
    label274:
    for (localObject = parampgd.a();; localObject = null)
    {
      orc.a(localViewBase, (BaseArticleInfo)localObject);
      break;
      localObject = str;
      if (parampgd == null) {
        break label181;
      }
      localObject = str;
      if (parampgd.a().mXGFileSize <= 0L) {
        break label181;
      }
      localObject = rdm.b(parampgd.a().mXGFileSize) + alud.a(2131701483);
      break label181;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pgd parampgd, ViewBase paramViewBase)
  {
    paramContainer = parampgd.a();
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return false;
    }
    paramViewBase.setOnClickListener(new pla(this, paramContainer, parampgd, paramViewBase));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pkz
 * JD-Core Version:    0.7.0.1
 */