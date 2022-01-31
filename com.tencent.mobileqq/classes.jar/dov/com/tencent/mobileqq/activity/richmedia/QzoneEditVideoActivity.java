package dov.com.tencent.mobileqq.activity.richmedia;

import ajpz;
import ajqj;
import ajqk;
import alud;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import blqr;
import blrx;
import bmor;
import bnfs;
import bngi;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.io.File;
import java.util.ArrayList;
import xmn;
import xna;

public class QzoneEditVideoActivity
  extends EditVideoActivity
{
  private static final String jdField_a_of_type_JavaLangString = QzoneEditVideoActivity.class.getSimpleName();
  private bnfs jdField_a_of_type_Bnfs;
  private QzoneVerticalVideoTopicInfo jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
  private boolean b;
  
  private void a()
  {
    this.jdField_a_of_type_Bnfs.n = a();
    this.jdField_a_of_type_Bnfs.jdField_f_of_type_Boolean = getIntent().getBooleanExtra("mIsQzoneVip", false);
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, ajpz paramajpz, String paramString5, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt4, int paramInt5, String paramString6, int paramInt6, String paramString7, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    String str = new File(paramString2).getParent();
    if (!TextUtils.isEmpty(paramString4)) {
      PtvFilterUtils.a(str, paramString4);
    }
    ajqk localajqk = new ajqk();
    localajqk.jdField_a_of_type_AndroidAppActivity = this;
    localajqk.jdField_a_of_type_JavaLangString = str;
    localajqk.jdField_b_of_type_JavaLangString = paramString1;
    localajqk.jdField_a_of_type_Int = paramInt1;
    localajqk.jdField_c_of_type_JavaLangString = paramString2;
    localajqk.jdField_f_of_type_JavaLangString = paramString3;
    localajqk.jdField_c_of_type_Int = 0;
    localajqk.jdField_d_of_type_Int = 0;
    localajqk.jdField_k_of_type_JavaLangString = paramString4;
    localajqk.j = paramInt2;
    localajqk.jdField_a_of_type_Ajpz = paramajpz;
    localajqk.jdField_g_of_type_JavaLangString = paramString5;
    localajqk.jdField_e_of_type_Int = paramInt3;
    localajqk.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    localajqk.jdField_b_of_type_Boolean = paramBoolean1;
    localajqk.jdField_f_of_type_Int = paramInt4;
    localajqk.jdField_g_of_type_Int = paramInt5;
    localajqk.jdField_h_of_type_JavaLangString = paramString6;
    localajqk.jdField_h_of_type_Int = paramInt6;
    localajqk.i = paramString7;
    localajqk.jdField_e_of_type_Boolean = paramBoolean2;
    localajqk.jdField_f_of_type_Boolean = paramBoolean3;
    localajqk.jdField_g_of_type_Boolean = paramBoolean4;
    localajqk.jdField_h_of_type_Boolean = paramBoolean5;
    localajqk.jdField_k_of_type_Int = 3;
    localajqk.jdField_d_of_type_JavaLangString = "";
    localajqk.jdField_b_of_type_Int = 0;
    localajqk.jdField_e_of_type_JavaLangString = "";
    new ajqj(localajqk).execute(new Void[0]);
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
    if ((paramIntent != null) && (this.jdField_a_of_type_Bnfs != null))
    {
      paramIntent.putExtra("key_content", this.jdField_a_of_type_Bnfs.jdField_c_of_type_JavaLangString);
      paramIntent.putExtra("key_topic_sync_qzone", this.jdField_a_of_type_Bnfs.jdField_g_of_type_Boolean);
      paramIntent.putExtra("key_priv", this.jdField_a_of_type_Bnfs.jdField_c_of_type_Int);
      paramIntent.putExtra("key_priv_uin_list", this.jdField_a_of_type_Bnfs.jdField_a_of_type_JavaUtilArrayList);
      paramIntent.putExtra("key_font_id", this.jdField_a_of_type_Bnfs.jdField_d_of_type_Int);
      paramIntent.putExtra("key_font_format_type", this.jdField_a_of_type_Bnfs.jdField_e_of_type_Int);
      paramIntent.putExtra("key_font_url", this.jdField_a_of_type_Bnfs.jdField_d_of_type_JavaLangString);
      paramIntent.putExtra("key_super_font_id", this.jdField_a_of_type_Bnfs.jdField_f_of_type_Int);
      paramIntent.putExtra("key_super_font_info", this.jdField_a_of_type_Bnfs.jdField_e_of_type_JavaLangString);
      paramIntent.putExtra("key_generate_gif", this.jdField_a_of_type_Bnfs.jdField_d_of_type_Boolean);
      paramIntent.putExtra("key_timer_delete", this.jdField_a_of_type_Bnfs.q);
      paramIntent.putExtra("key_sync_to_qqstory", this.jdField_a_of_type_Bnfs.o);
      paramIntent.putExtra("param.isUploadOrigin", this.jdField_a_of_type_Bnfs.p);
      if ((xmn.a().a() == 14) || (xmn.a().a() == 19)) {
        a(paramIntent);
      }
      QLog.i(jdField_a_of_type_JavaLangString, 2, "QzoneEditVideoActivity " + paramIntent.getExtras());
    }
  }
  
  private void f()
  {
    boolean bool = getIntent().getBooleanExtra("enable_input_text", true);
    this.jdField_a_of_type_Bnfs.i = bool;
    this.jdField_a_of_type_Bnfs.j = getIntent().getBooleanExtra("enable_sync_qzone", false);
    this.jdField_a_of_type_Bnfs.k = getIntent().getBooleanExtra("enable_priv_list", true);
    if (!TextUtils.isEmpty(getIntent().getStringExtra("topic_id"))) {
      this.jdField_a_of_type_Bnfs.jdField_h_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Bnfs.jdField_d_of_type_Int = getIntent().getIntExtra("key_font_id", -1);
    this.jdField_a_of_type_Bnfs.jdField_f_of_type_Int = getIntent().getIntExtra("key_super_font_id", -1);
    this.jdField_a_of_type_Bnfs.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("key_super_font_info");
  }
  
  private void g()
  {
    this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = ((QzoneVerticalVideoTopicInfo)getIntent().getParcelableExtra("key_qzone_topic"));
    this.jdField_a_of_type_Bnfs.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bnfs.s)
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
      QQToast.a(this, alud.a(2131712124) + (String)localObject, 0).a();
      finish();
      return;
    }
    doOnPause();
    doOnStop();
    doOnDestroy();
    setIntent(paramIntent);
    doOnCreate(null);
    doOnResume();
    this.jdField_a_of_type_Bnfs.jdField_a_of_type_Bmor.b();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bnfs = new bnfs(this);
    this.jdField_a_of_type_Bmnj = this.jdField_a_of_type_Bnfs;
    f();
    a();
    g();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 666) && (paramIntent != null) && (paramIntent.getBooleanExtra("key_is_qzone_slide_show_edited", false)))
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("qzone_slide_show_matters");
      xmn.a().b(paramIntent);
      xmn.a().a(paramIntent);
      getIntent().putExtra("from_qzone_slideshow", true);
      getIntent().putExtra("edit_video_type", 10001);
      getIntent().putExtra("qq_sub_business_id", 3);
      getIntent().putExtra("qzone_slide_enable_mask", 3848427020667L);
      this.jdField_a_of_type_Bnfs.jdField_a_of_type_Bmor.a(alud.a(2131712120), false, 500L);
      this.jdField_a_of_type_Bnfs.b();
      this.jdField_b_of_type_Boolean = true;
      ((blrx)blqr.a(5)).a(this);
      xmn.a().a(this, new bngi(this), 2);
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_a_of_type_Bnfs != null) {
      this.jdField_a_of_type_Bnfs.s = true;
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    findViewById(2131373313).setVisibility(8);
    return bool;
  }
  
  public void doOnDestroy()
  {
    if ((!this.jdField_b_of_type_Boolean) && (xmn.a().b() == 22))
    {
      if (xmn.a().a() != 19) {
        break label54;
      }
      xmn.a().b(14);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_b_of_type_Boolean = false;
      }
      super.doOnDestroy();
      return;
      label54:
      if (xmn.a().a() == 14)
      {
        xmn.a().c(20);
        xmn.a().b(99);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditVideoActivity
 * JD-Core Version:    0.7.0.1
 */