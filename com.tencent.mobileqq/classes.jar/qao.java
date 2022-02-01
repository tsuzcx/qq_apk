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

public class qao
  implements qdy
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return pzr.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pvc parampvc, int paramInt2)
  {
    Object localObject2 = null;
    ViewBase localViewBase = paramContainer.getVirtualView();
    if ((NetworkState.isWifiConn()) || (Aladdin.getConfig(299).getIntegerFromString("rij_main_feeds_tips_off", 0) == 1))
    {
      localObject1 = localViewBase.findViewBaseByName("id_large_video_icon");
      if (localObject1 != null) {
        ((ViewBase)localObject1).setVisibility(0);
      }
      localObject1 = localViewBase.findViewBaseByName("id_video_bg");
      if (localObject1 != null) {
        ((ViewBase)localObject1).setVisibility(8);
      }
      pai.a(false, localViewBase, null);
      if (parampvc != null)
      {
        localObject1 = parampvc.a();
        if ((localObject1 != null) && (((BaseArticleInfo)localObject1).isAccountShown)) {
          qga.a(paramContainer, parampvc);
        }
      }
      localObject1 = localObject2;
      if (parampvc != null) {
        localObject1 = parampvc.a();
      }
      sgi.a((BaseArticleInfo)localObject1, paramContainer.getContext());
      return;
    }
    Object localObject1 = localViewBase.findViewBaseByName("id_large_video_icon");
    if (localObject1 != null) {
      ((ViewBase)localObject1).setVisibility(8);
    }
    localObject1 = localViewBase.findViewBaseByName("id_video_bg");
    if (localObject1 != null) {
      ((ViewBase)localObject1).setVisibility(0);
    }
    NativeText localNativeText = (NativeText)localViewBase.findViewBaseByName("id_video_paly_text");
    String str;
    if (localNativeText != null)
    {
      str = amtj.a(2131700250);
      if (bgoa.a() == 1)
      {
        localObject1 = amtj.a(2131700251);
        label214:
        localNativeText.setText((CharSequence)localObject1);
      }
    }
    else
    {
      if (parampvc == null) {
        break label307;
      }
    }
    label307:
    for (localObject1 = parampvc.a();; localObject1 = null)
    {
      pai.a(localViewBase, (BaseArticleInfo)localObject1);
      break;
      localObject1 = str;
      if (parampvc == null) {
        break label214;
      }
      localObject1 = str;
      if (parampvc.a().mXGFileSize <= 0L) {
        break label214;
      }
      localObject1 = rwv.b(parampvc.a().mXGFileSize) + amtj.a(2131700249);
      break label214;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pvc parampvc, ViewBase paramViewBase)
  {
    paramContainer = parampvc.a();
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return false;
    }
    paramViewBase.setOnClickListener(new qap(this, paramContainer, parampvc, paramViewBase));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qao
 * JD-Core Version:    0.7.0.1
 */