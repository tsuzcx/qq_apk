import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import cooperation.qzone.util.NetworkState;
import org.json.JSONObject;

public class qcj
  implements qft
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return qbm.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pxk parampxk, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    if ((NetworkState.isWifiConn()) || (Aladdin.getConfig(299).getIntegerFromString("rij_main_feeds_tips_off", 0) == 1))
    {
      localObject = localViewBase.findViewBaseByName("id_large_video_icon");
      if (localObject != null) {
        ((ViewBase)localObject).setVisibility(0);
      }
      localObject = localViewBase.findViewBaseByName("id_video_bg");
      if (localObject != null) {
        ((ViewBase)localObject).setVisibility(8);
      }
      pgk.a(false, localViewBase, null);
      if (parampxk != null)
      {
        localObject = parampxk.a();
        if ((localObject != null) && (((BaseArticleInfo)localObject).isAccountShown)) {
          qhv.a(paramContainer, parampxk);
        }
      }
      sia.a(parampxk.a(), paramContainer.getContext());
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
      str = anni.a(2131699908);
      if (bhhb.a() == 1)
      {
        localObject = anni.a(2131699909);
        label199:
        localNativeText.setText((CharSequence)localObject);
      }
    }
    else
    {
      if (parampxk == null) {
        break label292;
      }
    }
    label292:
    for (localObject = parampxk.a();; localObject = null)
    {
      pgk.a(localViewBase, (BaseArticleInfo)localObject);
      break;
      localObject = str;
      if (parampxk == null) {
        break label199;
      }
      localObject = str;
      if (parampxk.a().mXGFileSize <= 0L) {
        break label199;
      }
      localObject = ryx.b(parampxk.a().mXGFileSize) + anni.a(2131699907);
      break label199;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pxk parampxk, ViewBase paramViewBase)
  {
    paramContainer = parampxk.a();
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return false;
    }
    paramViewBase.setOnClickListener(new qck(this, paramContainer, parampxk, paramViewBase));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qcj
 * JD-Core Version:    0.7.0.1
 */