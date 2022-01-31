import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountArticleHandler;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoPlayCountHandler;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppJumpManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsInterruptedAdManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView.ListViewEventListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.util.VideoPlayDianZanHandler;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class mgm
  implements VideoFeedsListView.ListViewEventListener
{
  public mgm(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      ReadInJoyUtils.a("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "ListViewEventListener doOnLoadMoreData() 触发拉取推荐视频列表");
    }
    VideoFeedsPlayActivity.c(this.a);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof VideoFeedsAdapter.VideoItemHolder))
    {
      VideoFeedsPlayActivity.a(this.a, (VideoFeedsAdapter.VideoItemHolder)paramObject);
      if (VideoFeedsPlayActivity.a(this.a) != null) {
        VideoFeedsPlayActivity.a(this.a).a(VideoFeedsPlayActivity.a(this.a), VideoFeedsPlayActivity.h(this.a));
      }
      if ((VideoFeedsPlayActivity.a(this.a).a == null) || (VideoFeedsPlayActivity.a(this.a).a.a == null)) {
        break label526;
      }
    }
    label526:
    for (paramObject = VideoFeedsPlayActivity.a(this.a).a.a;; paramObject = null)
    {
      int i;
      JSONObject localJSONObject;
      if ((VideoFeedsPlayActivity.g(this.a)) && (paramObject != null) && (paramObject.b()))
      {
        VideoFeedsPlayActivity.a(this.a).setVisibility(0);
        if ((paramObject != null) && (paramObject.f))
        {
          VideoFeedsPlayActivity.a(this.a).setVisibility(0);
          VideoFeedsPlayActivity.a(this.a).setVisibility(8);
          i = this.a.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
          localJSONObject = new JSONObject();
        }
      }
      else
      {
        try
        {
          if (paramObject.q == null) {
            break label281;
          }
          paramObject = paramObject.q;
          label197:
          localJSONObject.put("video_report_info", paramObject);
        }
        catch (JSONException paramObject)
        {
          for (;;)
          {
            label240:
            paramObject.printStackTrace();
            continue;
            PublicAccountReportUtils.b(null, "", "0X800924D", "0X800924D", 0, 0, String.valueOf(i), "", "", VideoReporter.a(localJSONObject), false);
          }
        }
        if (VideoFeedsPlayActivity.d(this.a))
        {
          PublicAccountReportUtils.b(null, "", "0X800930D", "0X800930D", 0, 0, String.valueOf(i), "", "", VideoReporter.a(localJSONObject), false);
          if (VideoFeedsPlayActivity.a(this.a).b < VideoFeedsPlayActivity.a(this.a).size() - 1) {
            break label338;
          }
        }
      }
      label281:
      label338:
      do
      {
        return;
        VideoFeedsPlayActivity.a(this.a).setVisibility(8);
        break;
        paramObject = "";
        break label197;
        if (paramObject == null) {
          break label240;
        }
        VideoFeedsPlayActivity.a(this.a, paramObject);
        break label240;
        paramObject = (VideoInfo)VideoFeedsPlayActivity.a(this.a).get(VideoFeedsPlayActivity.a(this.a).b + 1);
        if (paramObject.jdField_a_of_type_Int != 0)
        {
          if ((!TextUtils.isEmpty(paramObject.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramObject.g))) {
            VideoFeedsPlayActivity.a(this.a).a(paramObject.jdField_a_of_type_JavaLangString, paramObject.g);
          }
          if (!TextUtils.isEmpty(paramObject.j)) {
            VideoFeedsPlayActivity.b(this.a, paramObject);
          }
        }
        if (!TextUtils.isEmpty(paramObject.g)) {
          VideoFeedsPlayActivity.a(this.a).a(paramObject.g);
        }
        if ((!VideoFeedsHelper.a(paramObject)) && (!TextUtils.isEmpty(paramObject.a())))
        {
          VideoFeedsPlayActivity.a(this.a).e(paramObject.a());
          VideoFeedsPlayActivity.a(this.a).c(paramObject.a());
        }
      } while (VideoFeedsPlayActivity.a(this.a).b < 0);
      VideoFeedsPlayActivity.f(this.a, false);
      VideoFeedsPlayActivity.b(this.a);
      return;
    }
  }
  
  public void a(Object paramObject, boolean paramBoolean)
  {
    VideoFeedsPlayActivity.e(this.a, paramBoolean);
    VideoInfo localVideoInfo;
    JSONObject localJSONObject;
    if (paramBoolean)
    {
      this.a.a.setVisibility(8);
      VideoFeedsPlayActivity.b(this.a);
      localVideoInfo = VideoFeedsPlayActivity.a(this.a).a();
      if (localVideoInfo != null)
      {
        if ((localVideoInfo.jdField_a_of_type_Int != 0) || (localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
          break label235;
        }
        paramObject = localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        localJSONObject = new JSONObject();
      }
    }
    label235:
    do
    {
      try
      {
        localJSONObject.put("channel_id", -1);
        String str3 = localVideoInfo.j;
        if (!TextUtils.isEmpty(localVideoInfo.g))
        {
          String str1 = localVideoInfo.g;
          PublicAccountReportUtils.a(null, str3, "0X8007411", "0X8007411", 0, 0, "0", "", str1, VideoReporter.a(paramObject, localVideoInfo.j, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g, VideoFeedsPlayActivity.a(this.a).a(), localVideoInfo.a() * 1000L, localJSONObject), false);
          if ((VideoFeedsPlayActivity.g(this.a)) && (localVideoInfo != null) && (localVideoInfo.b())) {
            VideoFeedsPlayActivity.a(this.a).setVisibility(8);
          }
          if (VideoFeedsPlayActivity.a(this.a) != null) {
            VideoFeedsPlayActivity.a(this.a).a(2);
          }
          return;
          paramObject = null;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          continue;
          String str2 = "0";
        }
      }
      paramObject = VideoFeedsPlayActivity.a(this.a).a();
      this.a.a.setVisibility(0);
      if ((VideoFeedsPlayActivity.g(this.a)) && (paramObject != null) && (paramObject.b())) {
        VideoFeedsPlayActivity.a(this.a).setVisibility(0);
      }
    } while (VideoFeedsPlayActivity.a(this.a) == null);
    VideoFeedsPlayActivity.a(this.a).a(3);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      VideoFeedsPlayActivity.a(this.a).setVisibility(8);
      VideoFeedsPlayActivity.a(this.a).setVisibility(8);
      VideoFeedsPlayActivity.b(this.a).setVisibility(8);
      if (VideoFeedsPlayActivity.a(this.a) != null)
      {
        VideoFeedsPlayActivity.a(this.a).e.setVisibility(8);
        VideoFeedsPlayActivity.a(this.a).j.setVisibility(8);
      }
      VideoFeedsPlayActivity.b(this.a);
      return;
    }
    if ((VideoFeedsPlayActivity.a(this.a) != null) && (VideoFeedsPlayActivity.a(this.a).a != null) && (VideoFeedsPlayActivity.a(this.a).a.a != null))
    {
      if (!VideoFeedsPlayActivity.a(this.a).a.a.f) {
        break label209;
      }
      VideoFeedsPlayActivity.a(this.a).setVisibility(0);
    }
    for (;;)
    {
      VideoFeedsPlayActivity.b(this.a).setVisibility(0);
      if (VideoFeedsPlayActivity.a(this.a) == null) {
        break;
      }
      VideoFeedsPlayActivity.a(this.a).e.setVisibility(0);
      VideoFeedsPlayActivity.a(this.a).j.setVisibility(0);
      break;
      label209:
      VideoFeedsPlayActivity.a(this.a, VideoFeedsPlayActivity.a(this.a).a.a);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "onFinishActivity()");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mgm
 * JD-Core Version:    0.7.0.1
 */