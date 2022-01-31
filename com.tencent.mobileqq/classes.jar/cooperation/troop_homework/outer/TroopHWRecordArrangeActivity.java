package cooperation.troop_homework.outer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import bkdt;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;

public class TroopHWRecordArrangeActivity
  extends TroopHWRecordBaseActivity
{
  private int jdField_a_of_type_Int = 20;
  private Handler jdField_a_of_type_AndroidOsHandler = new bkdt(this);
  private String jdField_a_of_type_JavaLangString;
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)LayoutInflater.from(this).inflate(2131559713, null));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.app, this, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(360000);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    if (getIntent() != null) {
      this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("webid");
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.troop_homework.outer.TroopHWRecordArrangeActivity
 * JD-Core Version:    0.7.0.1
 */