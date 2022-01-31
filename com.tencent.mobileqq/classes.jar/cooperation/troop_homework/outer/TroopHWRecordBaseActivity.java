package cooperation.troop_homework.outer;

import amqb;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;

public class TroopHWRecordBaseActivity
  extends BaseActivity
{
  private View.OnClickListener a;
  protected View a;
  protected RelativeLayout a;
  public CommonRecordSoundPanel a;
  public AudioInfo a;
  public boolean a;
  
  public TroopHWRecordBaseActivity()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new amqb(this);
  }
  
  private void a(Resources paramResources, View paramView)
  {
    paramResources = paramResources.getDrawable(2130845819);
    if ((paramResources instanceof BitmapDrawable)) {
      paramResources = ((BitmapDrawable)paramResources).getBitmap();
    }
    for (;;)
    {
      paramResources = new BitmapDrawable(paramResources);
      paramResources.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      paramResources.setDither(true);
      paramView.setBackgroundDrawable(paramResources);
      return;
      if ((paramResources instanceof SkinnableBitmapDrawable)) {
        paramResources = ((SkinnableBitmapDrawable)paramResources).getBitmap();
      } else {
        paramResources = null;
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366582);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(1291845632);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368394));
    a(getResources(), this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    a();
  }
  
  protected void a() {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    setContentView(2130969901);
    b();
    return true;
  }
  
  public void finish()
  {
    super.finish();
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130846313);
  }
  
  public boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHomeworkRecordActivity", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a();
    return false;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("TroopHomeworkRecordActivity", 2, "RecordPanel.onDestroy() is called,isRecording is:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.e();
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("TroopHomeworkRecordActivity", 2, "RecordPanel.onPause() is called,isRecording is:" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.d();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.troop_homework.outer.TroopHWRecordBaseActivity
 * JD-Core Version:    0.7.0.1
 */