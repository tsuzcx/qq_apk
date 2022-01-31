import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.BaseVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class lzo
  implements ActionSheet.OnButtonClickListener
{
  public lzo(VideoFeedsAdapter paramVideoFeedsAdapter, ActionSheet paramActionSheet, String paramString1, MessageForShortVideo paramMessageForShortVideo, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
    if (paramView != null)
    {
      if (!paramView.equals(this.jdField_a_of_type_JavaLangString)) {
        break label157;
      }
      if ((VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter) != null) && (VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).a != null)) {
        VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter, VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).a.a);
      }
      paramView = new JSONObject();
    }
    label157:
    do
    {
      try
      {
        paramView.put("channel_id", -1);
        PublicAccountReportUtils.a(null, "0", "0X800740F", "0X800740F", 0, 0, "0", "0", "0", VideoReporter.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", "0", "0", VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).a(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime * 1000L, paramView), false);
        return;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          localJSONException1.printStackTrace();
        }
      }
      if (paramView.equals(this.b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "click menu to share to qzone, finalVideoExists=" + this.jdField_a_of_type_Boolean);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = QZoneHelper.UserInfo.a();
          QZoneHelper.b(VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter), paramView, this.c, 10001);
          VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).a(VideoFeedsAdapter.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter));
        }
        for (;;)
        {
          paramView = new JSONObject();
          try
          {
            paramView.put("channel_id", -1);
            PublicAccountReportUtils.a(null, "0", "0X800740F", "0X800740F", 0, 0, "0", "1", "0", VideoReporter.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", "0", "0", VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).a(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime * 1000L, paramView), false);
            return;
            QQToast.a(VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter), 0, 2131437375, 0).b(VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getResources().getDimensionPixelSize(2131558448));
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              localJSONException2.printStackTrace();
            }
          }
        }
      }
      if (paramView.equals(this.d))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          QQToast.a(VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter), 0, 2131437375, 0).b(VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getResources().getDimensionPixelSize(2131558448));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.c, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + ".mp4", false));
        return;
      }
    } while (!paramView.equals(this.e));
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter), 0, 2131437375, 0).b(VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).getResources().getDimensionPixelSize(2131558448));
      return;
    }
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setDataAndType(Uri.parse("file://" + this.c), "video/*");
    VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).startActivity(paramView);
    VideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter).a(VideoFeedsAdapter.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lzo
 * JD-Core Version:    0.7.0.1
 */