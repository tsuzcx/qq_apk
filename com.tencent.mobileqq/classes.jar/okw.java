import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.biz.qqstory.takevideo.EditVideoPlayerExport;
import com.tencent.biz.qqstory.takevideo.music.BlessVoiceChangeManager;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog;
import com.tencent.biz.qqstory.takevideo.music.MusicGridAdapter;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class okw
  extends Handler
{
  public okw(EditVideoMusicDialog paramEditVideoMusicDialog) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    case 4: 
    case 5: 
    default: 
    case 1: 
    case 2: 
    case 11: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                this.a.b();
                paramMessage = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
                if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter != null)
                {
                  this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList);
                  this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(paramMessage);
                  this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.notifyDataSetChanged();
                }
              } while (paramMessage == null);
              if (paramMessage.jdField_b_of_type_Int == 0)
              {
                this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
                return;
              }
              if ((paramMessage.jdField_b_of_type_Int == 1) && (!this.a.jdField_a_of_type_Boolean))
              {
                this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
                return;
              }
              if (!TextUtils.isEmpty(paramMessage.g))
              {
                this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
                return;
              }
            } while (!this.a.c);
            this.a.c = false;
            this.a.a(paramMessage.jdField_d_of_type_JavaLangString);
            return;
            this.a.b();
            paramMessage = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
            if (paramMessage != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("zivonchen", 2, "MSG_PLAY_MUSIC music is NULL!!!!!");
          return;
          paramMessage.f = ((int)ShortVideoUtils.a(paramMessage.g));
          if (paramMessage.jdField_d_of_type_Int < 0) {
            paramMessage.jdField_d_of_type_Int = 0;
          }
          if (paramMessage.jdField_d_of_type_Int + this.a.jdField_a_of_type_Int > paramMessage.f) {
            paramMessage.jdField_d_of_type_Int = 0;
          }
          paramMessage.e = (paramMessage.jdField_d_of_type_Int + this.a.jdField_a_of_type_Int);
          this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(3);
          this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage.jdField_b_of_type_JavaLangString);
          this.a.a();
          this.a.a(true);
          if ((paramMessage.jdField_b_of_type_Int == 2) || (paramMessage.jdField_b_of_type_Int == 3))
          {
            localEditVideoPlayerExport = (EditVideoPlayerExport)this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
            if (localEditVideoPlayerExport != null) {
              localEditVideoPlayerExport.a(true);
            }
          }
          MusicHorizontalSeekView.a((this.a.a() + 500) / 1000, this.a.getContext().getResources().getDisplayMetrics().widthPixels);
          this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setDurations((this.a.a() + 500) / 1000, (Math.max(paramMessage.f, this.a.jdField_a_of_type_Int) + 500) / 1000);
          this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.a(paramMessage.jdField_d_of_type_Int);
          this.a.b(paramMessage.jdField_d_of_type_Int, paramMessage.e);
        } while ((!this.a.jdField_b_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic == null) || (!this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_Boolean));
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.b();
        this.a.jdField_b_of_type_Boolean = false;
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_Boolean = false;
        return;
        this.a.b();
        paramMessage = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
        paramMessage.f = ((int)ShortVideoUtils.a(paramMessage.g));
        if (paramMessage.jdField_d_of_type_Int < 0) {
          paramMessage.jdField_d_of_type_Int = 0;
        }
        if (paramMessage.jdField_d_of_type_Int + this.a.jdField_a_of_type_Int > paramMessage.f) {
          paramMessage.jdField_d_of_type_Int = 0;
        }
        paramMessage.e = (paramMessage.jdField_d_of_type_Int + this.a.jdField_a_of_type_Int);
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramMessage);
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(3);
        this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage.jdField_b_of_type_JavaLangString);
        this.a.a();
        this.a.a(true);
        if ((paramMessage.jdField_b_of_type_Int == 2) || (paramMessage.jdField_b_of_type_Int == 3))
        {
          localEditVideoPlayerExport = (EditVideoPlayerExport)this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
          if (localEditVideoPlayerExport != null) {
            localEditVideoPlayerExport.a(true);
          }
        }
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setDurations((this.a.a() + 500) / 1000, (Math.max(paramMessage.f, this.a.jdField_a_of_type_Int) + 500) / 1000);
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.a(paramMessage.jdField_d_of_type_Int);
        this.a.b(paramMessage.jdField_d_of_type_Int, paramMessage.e);
      } while ((!this.a.jdField_b_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic == null) || (!this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_Boolean));
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.b();
      this.a.jdField_b_of_type_Boolean = false;
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_Boolean = false;
      return;
    case 3: 
      this.a.b();
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(QQStoryMusicInfo.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
      paramMessage = (EditVideoPlayerExport)this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
      if (paramMessage != null) {
        paramMessage.a(true);
      }
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(0);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText("当前无任何音效");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 6: 
      paramMessage = (EditVideoPlayerExport)this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
      this.a.b();
      if ((this.a.d) && (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicBlessVoiceChangeManager != null))
      {
        if (paramMessage != null) {
          paramMessage.a(true);
        }
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicBlessVoiceChangeManager.b();
      }
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(QQStoryMusicInfo.jdField_b_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
      if (paramMessage != null) {
        paramMessage.a(false);
      }
      this.a.a(true);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(1);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText("当前为视频原声");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 7: 
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.a.getContext(), paramMessage, 0).a();
      return;
    case 8: 
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setPlayedPosition(this.a.jdField_b_of_type_Int);
      return;
    case 9: 
      if (this.a.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0)
      {
        this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramMessage.arg1);
      return;
    }
    this.a.b();
    paramMessage = (QQStoryMusicInfo)paramMessage.obj;
    paramMessage.jdField_b_of_type_Int = 4;
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramMessage);
    EditVideoPlayerExport localEditVideoPlayerExport = (EditVideoPlayerExport)this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
    if (localEditVideoPlayerExport != null) {
      localEditVideoPlayerExport.a(false);
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(4);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.a.jdField_b_of_type_AndroidWidgetTextView.setText("当前变声为" + paramMessage.jdField_b_of_type_JavaLangString);
    this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     okw
 * JD-Core Version:    0.7.0.1
 */