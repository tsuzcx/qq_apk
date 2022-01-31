import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.qphone.base.util.QLog;

public class oky
  extends BroadcastReceiver
{
  public oky(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("data");
      paramIntent = paramIntent.getStringExtra("event");
      if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("kTribeSelectMusic"))) {}
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "onReceive:" + paramContext);
        }
      } while (TextUtils.isEmpty(paramContext));
      paramContext = new QQStoryMusicInfo(paramContext);
      this.a.b();
      if (!TextUtils.isEmpty(paramContext.d))
      {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext.b);
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramContext);
      this.a.a(paramContext.d);
      VideoEditReport.a("0X80076D6");
      return;
      if ("action_music_start".equals(paramContext))
      {
        this.a.f();
        this.a.d();
        return;
      }
    } while (!"action_music_refresh_list".equals(paramContext));
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oky
 * JD-Core Version:    0.7.0.1
 */