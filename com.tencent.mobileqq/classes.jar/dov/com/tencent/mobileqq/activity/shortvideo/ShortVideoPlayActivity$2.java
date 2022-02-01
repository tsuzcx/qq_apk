package dov.com.tencent.mobileqq.activity.shortvideo;

import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import mqq.os.MqqHandler;

class ShortVideoPlayActivity$2
  extends MqqHandler
{
  ShortVideoPlayActivity$2(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          QQToast.a(this.a, 2131719357, 0).a();
          return;
          String str = this.a.getString(2131719358);
          paramMessage = (String)paramMessage.obj;
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 2, str + paramMessage, 0).a();
          ImageUtil.a(this.a, paramMessage);
          return;
          paramMessage = DialogUtil.a(this.a.jdField_a_of_type_AndroidContentContext, 232, this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719389), this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719388), 2131719372, 2131718540, new ShortVideoPlayActivity.2.1(this), new ShortVideoPlayActivity.2.2(this));
          ShortVideoPlayActivity.a(this.a, paramMessage);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "...mobile/none => wifi...");
          }
        } while (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null);
        this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setDownloadNetworkChange(1);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "...wifi/none => mobile...");
        }
        if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
          this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setDownloadNetworkChange(2);
        }
        if ((this.a.b != 1) && (this.a.b != 2)) {
          break;
        }
      } while (!this.a.b());
      this.a.j();
      this.a.r();
      return;
    } while (this.a.b != 0);
    ShortVideoPlayActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.2
 * JD-Core Version:    0.7.0.1
 */