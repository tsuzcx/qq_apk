package dov.com.tencent.mobileqq.activity.richmedia;

import Override;
import aluh;
import alur;
import alus;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import anzj;
import bplq;
import bpmw;
import bqhs;
import bqyq;
import bqzg;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.io.File;
import java.util.ArrayList;
import zjt;
import zkg;

public class QzoneEditVideoActivity
  extends EditVideoActivity
{
  private static final String jdField_a_of_type_JavaLangString = QzoneEditVideoActivity.class.getSimpleName();
  private bqyq jdField_a_of_type_Bqyq;
  private QzoneVerticalVideoTopicInfo jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
  private boolean b;
  
  private void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, aluh paramaluh, String paramString5, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt4, int paramInt5, String paramString6, int paramInt6, String paramString7, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    String str = new File(paramString2).getParent();
    if (!TextUtils.isEmpty(paramString4)) {
      PtvFilterUtils.a(str, paramString4);
    }
    alus localalus = new alus();
    localalus.jdField_a_of_type_AndroidAppActivity = this;
    localalus.jdField_a_of_type_JavaLangString = str;
    localalus.jdField_b_of_type_JavaLangString = paramString1;
    localalus.jdField_a_of_type_Int = paramInt1;
    localalus.jdField_c_of_type_JavaLangString = paramString2;
    localalus.jdField_f_of_type_JavaLangString = paramString3;
    localalus.jdField_c_of_type_Int = 0;
    localalus.jdField_d_of_type_Int = 0;
    localalus.jdField_k_of_type_JavaLangString = paramString4;
    localalus.j = paramInt2;
    localalus.jdField_a_of_type_Aluh = paramaluh;
    localalus.jdField_g_of_type_JavaLangString = paramString5;
    localalus.jdField_e_of_type_Int = paramInt3;
    localalus.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    localalus.jdField_b_of_type_Boolean = paramBoolean1;
    localalus.jdField_f_of_type_Int = paramInt4;
    localalus.jdField_g_of_type_Int = paramInt5;
    localalus.jdField_h_of_type_JavaLangString = paramString6;
    localalus.jdField_h_of_type_Int = paramInt6;
    localalus.i = paramString7;
    localalus.jdField_e_of_type_Boolean = paramBoolean2;
    localalus.jdField_f_of_type_Boolean = paramBoolean3;
    localalus.jdField_g_of_type_Boolean = paramBoolean4;
    localalus.jdField_h_of_type_Boolean = paramBoolean5;
    localalus.jdField_k_of_type_Int = 3;
    localalus.jdField_d_of_type_JavaLangString = "";
    localalus.jdField_b_of_type_Int = 0;
    localalus.jdField_e_of_type_JavaLangString = "";
    new alur(localalus).execute(new Void[0]);
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    int i = getIntent().getIntExtra("entry_source", 0);
    boolean bool1 = bool2;
    if (i != 3)
    {
      bool1 = bool2;
      if (i != 5) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(Intent paramIntent)
  {
    Object localObject2;
    Object localObject1;
    int j;
    if (paramIntent != null)
    {
      localObject2 = paramIntent.getStringExtra("key_content");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      j = paramIntent.getIntExtra("key_priv", 1);
      localObject2 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
      if (localObject2 != null) {
        break label257;
      }
      localObject2 = new ArrayList();
    }
    label257:
    for (;;)
    {
      if (a().getIntent() != null) {
        a().getIntent().putExtra("from_qzone_slideshow", true);
      }
      int k = paramIntent.getIntExtra("key_font_id", -1);
      int m = paramIntent.getIntExtra("key_font_format_type", 0);
      String str1 = paramIntent.getStringExtra("key_font_url");
      int n = paramIntent.getIntExtra("key_super_font_id", -1);
      String str2 = paramIntent.getStringExtra("key_super_font_info");
      boolean bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
      boolean bool3 = paramIntent.getBooleanExtra("key_sync_to_qqstory", false);
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      if (localPublishParam.jdField_f_of_type_Int <= 5) {}
      for (int i = localPublishParam.jdField_f_of_type_Int;; i = 0)
      {
        int i1 = (int)localPublishParam.jdField_a_of_type_Long;
        boolean bool4 = paramIntent.getBooleanExtra("param.isUploadOrigin", false);
        a(localPublishParam.jdField_k_of_type_JavaLangString, i, localPublishParam.j, localPublishParam.jdField_c_of_type_JavaLangString, localPublishParam.jdField_b_of_type_JavaLangString, i1, null, (String)localObject1, j, (ArrayList)localObject2, false, k, m, str1, n, str2, bool1, bool2, bool3, bool4);
        return true;
      }
      return false;
    }
  }
  
  private void b(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    b(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "QzoneEditVideoActivity finish --- resultCode : " + paramInt1);
    }
    super.a(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
  }
  
  private void b(@Nullable Intent paramIntent)
  {
    if ((paramIntent != null) && (this.jdField_a_of_type_Bqyq != null))
    {
      paramIntent.putExtra("key_content", this.jdField_a_of_type_Bqyq.jdField_c_of_type_JavaLangString);
      paramIntent.putExtra("key_topic_sync_qzone", this.jdField_a_of_type_Bqyq.jdField_g_of_type_Boolean);
      paramIntent.putExtra("key_priv", this.jdField_a_of_type_Bqyq.jdField_c_of_type_Int);
      paramIntent.putExtra("key_priv_uin_list", this.jdField_a_of_type_Bqyq.jdField_a_of_type_JavaUtilArrayList);
      paramIntent.putExtra("key_font_id", this.jdField_a_of_type_Bqyq.jdField_d_of_type_Int);
      paramIntent.putExtra("key_font_format_type", this.jdField_a_of_type_Bqyq.jdField_e_of_type_Int);
      paramIntent.putExtra("key_font_url", this.jdField_a_of_type_Bqyq.jdField_d_of_type_JavaLangString);
      paramIntent.putExtra("key_super_font_id", this.jdField_a_of_type_Bqyq.jdField_f_of_type_Int);
      paramIntent.putExtra("key_super_font_info", this.jdField_a_of_type_Bqyq.jdField_e_of_type_JavaLangString);
      paramIntent.putExtra("key_generate_gif", this.jdField_a_of_type_Bqyq.jdField_d_of_type_Boolean);
      paramIntent.putExtra("key_timer_delete", this.jdField_a_of_type_Bqyq.q);
      paramIntent.putExtra("key_sync_to_qqstory", this.jdField_a_of_type_Bqyq.o);
      paramIntent.putExtra("param.isUploadOrigin", this.jdField_a_of_type_Bqyq.p);
      if ((zjt.a().a() == 14) || (zjt.a().a() == 19)) {
        a(paramIntent);
      }
      QLog.i(jdField_a_of_type_JavaLangString, 2, "QzoneEditVideoActivity " + paramIntent.getExtras());
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bqyq.n = a();
    this.jdField_a_of_type_Bqyq.jdField_f_of_type_Boolean = getIntent().getBooleanExtra("mIsQzoneVip", false);
  }
  
  private void f()
  {
    boolean bool = getIntent().getBooleanExtra("enable_input_text", true);
    this.jdField_a_of_type_Bqyq.i = bool;
    this.jdField_a_of_type_Bqyq.j = getIntent().getBooleanExtra("enable_sync_qzone", false);
    this.jdField_a_of_type_Bqyq.k = getIntent().getBooleanExtra("enable_priv_list", true);
    if (!TextUtils.isEmpty(getIntent().getStringExtra("topic_id"))) {
      this.jdField_a_of_type_Bqyq.jdField_h_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Bqyq.jdField_d_of_type_Int = getIntent().getIntExtra("key_font_id", -1);
    this.jdField_a_of_type_Bqyq.jdField_f_of_type_Int = getIntent().getIntExtra("key_super_font_id", -1);
    this.jdField_a_of_type_Bqyq.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("key_super_font_info");
  }
  
  private void g()
  {
    this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = ((QzoneVerticalVideoTopicInfo)getIntent().getParcelableExtra("key_qzone_topic"));
    this.jdField_a_of_type_Bqyq.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bqyq = new bqyq(this);
    this.jdField_a_of_type_Bqgk = this.jdField_a_of_type_Bqyq;
    f();
    e();
    g();
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bqyq.s)
    {
      b(paramInt1, paramIntent, paramInt2, paramInt3, false);
      return;
    }
    b(paramInt1, paramIntent, paramInt2, paramInt3, true);
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    b(paramInt1, paramIntent, paramInt2, paramInt3, paramBoolean);
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      localObject = paramIntent.getExtras();
      if (localObject != null)
      {
        localObject = (EditVideoParams)((Bundle)localObject).getParcelable(EditVideoParams.class.getName());
        if (localObject == null) {
          break label80;
        }
      }
    }
    label80:
    for (Object localObject = ((EditVideoParams)localObject).a(); !TextUtils.isEmpty((CharSequence)localObject); localObject = "can not find EditVideoParams")
    {
      QQToast.a(this, anzj.a(2131710612) + (String)localObject, 0).a();
      finish();
      return;
    }
    doOnPause();
    doOnStop();
    doOnDestroy();
    setIntent(paramIntent);
    doOnCreate(null);
    doOnResume();
    this.jdField_a_of_type_Bqyq.jdField_a_of_type_Bqhs.b();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 666) && (paramIntent != null) && (paramIntent.getBooleanExtra("key_is_qzone_slide_show_edited", false)))
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("qzone_slide_show_matters");
      zjt.a().b(paramIntent);
      zjt.a().a(paramIntent);
      getIntent().putExtra("from_qzone_slideshow", true);
      getIntent().putExtra("edit_video_type", 10001);
      getIntent().putExtra("qq_sub_business_id", 3);
      getIntent().putExtra("qzone_slide_enable_mask", 3848427020667L);
      this.jdField_a_of_type_Bqyq.jdField_a_of_type_Bqhs.a(anzj.a(2131710608), false, 500L);
      this.jdField_a_of_type_Bqyq.b();
      this.jdField_b_of_type_Boolean = true;
      ((bpmw)bplq.a(5)).a(this);
      zjt.a().a(this, new bqzg(this), 2);
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_a_of_type_Bqyq != null) {
      this.jdField_a_of_type_Bqyq.s = true;
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    findViewById(2131374152).setVisibility(8);
    return bool;
  }
  
  public void doOnDestroy()
  {
    if ((!this.jdField_b_of_type_Boolean) && (zjt.a().b() == 22))
    {
      if (zjt.a().a() != 19) {
        break label54;
      }
      zjt.a().b(14);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_b_of_type_Boolean = false;
      }
      super.doOnDestroy();
      return;
      label54:
      if (zjt.a().a() == 14)
      {
        zjt.a().c(20);
        zjt.a().b(99);
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditVideoActivity
 * JD-Core Version:    0.7.0.1
 */