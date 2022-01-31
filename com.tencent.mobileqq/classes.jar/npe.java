import android.app.AlertDialog.Builder;
import android.content.Context;
import android.widget.MediaController;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.wrapper.IMediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;

public class npe
  implements IMediaPlayer.OnErrorListener
{
  public npe(TextureVideoView paramTextureVideoView) {}
  
  public boolean a(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "Error: " + paramInt1 + "," + paramInt2);
    }
    this.a.jdField_a_of_type_Int = -1;
    this.a.b = -1;
    if (this.a.jdField_a_of_type_AndroidWidgetMediaController != null) {
      this.a.jdField_a_of_type_AndroidWidgetMediaController.hide();
    }
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerWrapperIMediaPlayer$OnErrorListener.a(paramIMediaPlayer, paramInt1, paramInt2))) {}
    while (this.a.getWindowToken() == null) {
      return true;
    }
    this.a.getContext().getResources();
    if (paramInt1 == 200) {}
    for (paramInt1 = 17039381;; paramInt1 = 17039377)
    {
      new AlertDialog.Builder(this.a.getContext()).setMessage(paramInt1).setPositiveButton(17039376, new npf(this)).setCancelable(false).show();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npe
 * JD-Core Version:    0.7.0.1
 */