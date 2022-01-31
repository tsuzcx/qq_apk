import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

class pnv
  extends BroadcastReceiver
{
  pnv(pnh parampnh, VideoView paramVideoView, ViewBean paramViewBean, ViewBase paramViewBase) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool;
    if (((AudioManager)paramContext.getSystemService("audio")).getStreamVolume(3) <= 0)
    {
      bool = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView.setMute(bool);
      paramIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanViewBean;
      if (!bool) {
        break label62;
      }
    }
    label62:
    for (paramContext = "video_audio_mute";; paramContext = "video_audio_speak")
    {
      paramIntent.putMapValue("pgc_video_content_audio_icon", paramContext);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.bindDynamicValue(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanViewBean);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pnv
 * JD-Core Version:    0.7.0.1
 */