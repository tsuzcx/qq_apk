package dov.com.tencent.biz.qqstory.takevideo;

import anby;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import dov.com.qq.im.capture.view.PressScaleAnimDelegate;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;

public class EditSyncQzonePart
  extends EditVideoPart
  implements Handler.Callback, View.OnClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  
  public EditSyncQzonePart(EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130843625);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130843624);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)a(2131364420));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131364421));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131364422));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    boolean bool = this.jdField_a_of_type_Boolean;
    SLog.d("Q.qqstory.publish.edit.EditSyncQzonePart", "story_sync_qzone : %s", new Object[] { Boolean.valueOf(bool) });
    paramGenerateContext.a.putExtra("story_sync_qzone", Boolean.valueOf(bool));
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while ((!this.b) || (paramMessage.arg1 != 2));
    this.b = false;
    if (StoryConfigManager.e())
    {
      this.jdField_a_of_type_Boolean = StoryConfigManager.f();
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      if (this.jdField_a_of_type_Boolean)
      {
        paramMessage = "1";
        StoryReportor.a("video_edit", "exp_qzone", 0, 0, new String[] { paramMessage });
        if (StoryConfigManager.g())
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 5000L);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          StoryConfigManager.e();
          StoryReportor.a("video_edit", "exp_qztip", 0, 0, new String[0]);
        }
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Boolean);
      return false;
      paramMessage = "2";
      break;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
  
  public void h()
  {
    super.h();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131364421: 
    default: 
      return;
    case 2131364420: 
      PressScaleAnimDelegate.a(paramView, 200L, new anby(this));
      if (this.jdField_a_of_type_Boolean) {}
      for (paramView = "1";; paramView = "2")
      {
        StoryReportor.a("video_edit", "clk_qzone", 0, 0, new String[] { paramView });
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        return;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    StoryReportor.a("video_edit", "clk_qztip", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditSyncQzonePart
 * JD-Core Version:    0.7.0.1
 */