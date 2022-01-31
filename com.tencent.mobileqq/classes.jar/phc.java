import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.Map;

class phc
  implements ViewBase.OnClickListener
{
  phc(pgw parampgw, ViewBase paramViewBase, pau parampau) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = (ply)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getParent().findViewBaseByName("id_pgc_short_content_video_view");
    ViewBean localViewBean = this.jdField_a_of_type_Pau.a().mProteusTemplateBean.getViewBean().findViewFromChild("id_pgc_short_content_video_audio_icon");
    ViewBase localViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getParent().findViewBaseByName("id_pgc_short_content_video_audio_icon");
    if ((localViewBase == null) || (paramViewBase == null) || (localViewBean == null)) {
      return;
    }
    boolean bool;
    if (!"video_audio_mute".equals(localViewBean.valueBean.dynamicValue.get("loadImageWithPath:")))
    {
      bool = true;
      paramViewBase.a().setMute(bool);
      if (!bool) {
        break label123;
      }
    }
    label123:
    for (paramViewBase = "video_audio_mute";; paramViewBase = "video_audio_speak")
    {
      localViewBean.putMapValue("pgc_video_content_audio_icon", paramViewBase);
      localViewBase.bindDynamicValue(localViewBean);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phc
 * JD-Core Version:    0.7.0.1
 */