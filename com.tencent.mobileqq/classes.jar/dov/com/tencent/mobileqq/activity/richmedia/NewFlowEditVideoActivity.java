package dov.com.tencent.mobileqq.activity.richmedia;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;

public class NewFlowEditVideoActivity
  extends EditVideoActivity
{
  RelativeLayout a;
  
  private void a(Intent paramIntent)
  {
    boolean bool = true;
    if (paramIntent != null)
    {
      bool = paramIntent.getBooleanExtra("enable_input_text", true);
      ((QzEditVideoPartManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager).h = bool;
      ((QzEditVideoPartManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager).i = paramIntent.getBooleanExtra("enable_sync_qzone", false);
      ((QzEditVideoPartManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager).j = paramIntent.getBooleanExtra("enable_priv_list", true);
      if (!TextUtils.isEmpty(paramIntent.getStringExtra("topic_id"))) {
        ((QzEditVideoPartManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager).g = true;
      }
      ((QzEditVideoPartManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_d_of_type_Int = paramIntent.getIntExtra("key_font_id", -1);
    }
    paramIntent = (RelativeLayout)findViewById(2131364430);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)getLayoutInflater().inflate(2130971189, paramIntent, false));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)AIOUtils.a(2, 90, getResources()));
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (bool) {}
    for (int i = 0;; i = 8)
    {
      ((RelativeLayout)localObject).setVisibility(i);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = AIOUtils.a(81.0F, getResources());
      localObject = new View(this);
      ((View)localObject).setBackgroundColor(Color.argb(128, 0, 0, 0));
      ((View)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      ((View)localObject).setVisibility(8);
      paramIntent.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
      paramIntent.addView((View)localObject);
      ((QzEditVideoPartManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_a_of_type_AndroidViewView = ((View)localObject);
      return;
    }
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    if ((paramIntent != null) && ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager instanceof QzEditVideoPartManager)))
    {
      paramIntent.putExtra("key_content", ((QzEditVideoPartManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager).c);
      paramIntent.putExtra("key_topic_sync_qzone", ((QzEditVideoPartManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager).f);
      paramIntent.putExtra("key_priv", ((QzEditVideoPartManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_a_of_type_Int);
      paramIntent.putExtra("key_priv_uin_list", ((QzEditVideoPartManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_a_of_type_JavaUtilArrayList);
      paramIntent.putExtra("key_font_id", ((QzEditVideoPartManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_d_of_type_Int);
      paramIntent.putExtra("key_font_format_type", ((QzEditVideoPartManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager).e);
      paramIntent.putExtra("key_font_url", ((QzEditVideoPartManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_d_of_type_JavaLangString);
      paramIntent.putExtra("key_generate_gif", ((QzEditVideoPartManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager).jdField_d_of_type_Boolean);
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewFlowEditVideoActivity", 2, "NewFlowEditVideoActivity finish --- resultCode : " + paramInt1);
    }
    super.a(paramInt1, paramIntent, paramInt2, paramInt3);
  }
  
  protected void a(Bundle paramBundle)
  {
    a(getIntent());
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager == null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager = new QzEditVideoPartManager();
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.NewFlowEditVideoActivity
 * JD-Core Version:    0.7.0.1
 */