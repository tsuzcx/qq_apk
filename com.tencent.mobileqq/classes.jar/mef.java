import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.BaseVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

public class mef
  extends MqqHandler
{
  public mef(VideoFeedsAdapter paramVideoFeedsAdapter) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      QQToast.a(VideoFeedsAdapter.a(this.a), 2131437381, 0).a();
      return;
      String str = VideoFeedsAdapter.a(this.a).getString(2131437382);
      paramMessage = (String)paramMessage.obj;
      QQToast.a(VideoFeedsAdapter.a(this.a), 2, str + paramMessage, 0).a();
      ImageUtil.a(VideoFeedsAdapter.a(this.a), paramMessage);
      return;
    } while (VideoFeedsAdapter.a(this.a).a.a.jdField_a_of_type_Int != 0);
    paramMessage = ShortVideoUtils.a(VideoFeedsAdapter.a(this.a).a.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    DialogUtil.b(VideoFeedsAdapter.a(this.a), 232, VideoFeedsAdapter.a(this.a).getResources().getString(2131437409), VideoFeedsAdapter.a(this.a).getResources().getString(2131437410), 2131437411, 2131434603, new meg(this, paramMessage), new meh(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mef
 * JD-Core Version:    0.7.0.1
 */