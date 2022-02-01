import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.qzone.util.NetworkState;
import org.json.JSONObject;

public class qms
  implements qqa
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return qlw.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2)
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
      pjr.a(false, localViewBase, null);
      if (paramqfw != null)
      {
        localObject1 = paramqfw.a();
        if ((localObject1 != null) && (((BaseArticleInfo)localObject1).isAccountShown)) {
          qsd.a(paramContainer, paramqfw);
        }
      }
      paramContainer = localObject2;
      if (paramqfw != null) {
        paramContainer = paramqfw.a();
      }
      ssn.a(paramContainer, BaseActivity.sTopActivity);
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
      str = anvx.a(2131700601);
      if (bhyk.a() == 1)
      {
        localObject1 = anvx.a(2131700602);
        label210:
        localNativeText.setText((CharSequence)localObject1);
      }
    }
    else
    {
      if (paramqfw == null) {
        break label303;
      }
    }
    label303:
    for (localObject1 = paramqfw.a();; localObject1 = null)
    {
      pjr.a(localViewBase, (BaseArticleInfo)localObject1);
      break;
      localObject1 = str;
      if (paramqfw == null) {
        break label210;
      }
      localObject1 = str;
      if (paramqfw.a().mXGFileSize <= 0L) {
        break label210;
      }
      localObject1 = six.b(paramqfw.a().mXGFileSize) + anvx.a(2131700600);
      break label210;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, qfw paramqfw, ViewBase paramViewBase)
  {
    paramContainer = paramqfw.a();
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return false;
    }
    paramViewBase.setOnClickListener(new qmt(this, paramContainer, paramqfw, paramViewBase));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qms
 * JD-Core Version:    0.7.0.1
 */