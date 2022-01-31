package dov.com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import atmp;
import bhfc;
import bizt;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.common.app.AppInterface;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import sow;
import vhg;
import vni;

public class SaveVideoActivity
  extends FlowActivity
{
  private static vni jdField_a_of_type_Vni;
  private static boolean jdField_b_of_type_Boolean;
  private bizt jdField_a_of_type_Bizt;
  private int jdField_b_of_type_Int;
  private boolean c;
  
  public static Intent a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = new Intent(paramContext, SaveVideoActivity.class);
    paramContext.putExtra("fakeId", paramString);
    paramContext.putExtra("sv_total_frame_count", paramInt2);
    paramContext.putExtra("sv_total_record_time", paramInt1);
    paramContext.putExtra("save_video_businessid", paramInt3);
    return paramContext;
  }
  
  private static PublishVideoEntry b(AppInterface paramAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramAppInterface = paramAppInterface.getCurrentAccountUin();
      if (paramAppInterface == null) {
        throw new IllegalStateException("Can not create a entity factory, the account is null.");
      }
      paramAppInterface = new sow(paramAppInterface);
      paramAppInterface.verifyAuthentication();
      paramAppInterface = ShortVideoRealItemBuilder.a(paramAppInterface.createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), "fakeVid=?", new String[] { paramString });
    } while ((paramAppInterface == null) || (paramAppInterface.size() <= 0));
    return (PublishVideoEntry)paramAppInterface.get(0);
  }
  
  private static void b(AppInterface paramAppInterface, PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramPublishVideoEntry == null) {
      return;
    }
    paramAppInterface = paramAppInterface.getCurrentAccountUin();
    if (paramAppInterface == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    paramAppInterface = new sow(paramAppInterface);
    paramAppInterface.verifyAuthentication();
    paramAppInterface.createEntityManager().b(paramPublishVideoEntry);
  }
  
  protected void a(ViewGroup paramViewGroup) {}
  
  public void onBackPressed()
  {
    if (this.c) {
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.ac = false;
    this.ad = false;
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      finish();
      return;
    }
    awje.z = paramBundle.getIntExtra("sv_total_frame_count", 0);
    awje.y = paramBundle.getIntExtra("sv_total_record_time", 0);
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("requestCode", -1);
    this.jdField_a_of_type_Bizt = new bizt(this, bhfc.a());
    bizt.a(this.jdField_a_of_type_Bizt, paramBundle.getBooleanExtra("mediacodec_encode_enable", false));
    bizt.b(this.jdField_a_of_type_Bizt, paramBundle.getBooleanExtra("video_edit_flag", false));
    bizt.a(this.jdField_a_of_type_Bizt, paramBundle.getIntExtra("save_video_businessid", -1));
    Utils.executeAsyncTaskOnSerialExcuter(this.jdField_a_of_type_Bizt, new Void[] { (Void)null });
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.c = true;
      if ((this.jdField_a_of_type_Bizt != null) && (!isFinishing()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SaveVideoActivity", 2, "cancel save video");
        }
        if (vhg.a().b() == 22)
        {
          if (this.jdField_b_of_type_Int != 111) {
            break label123;
          }
          LpReportInfo_pf00064.allReport(680, 12, 2);
        }
      }
    }
    for (;;)
    {
      bizt.a(this.jdField_a_of_type_Bizt).set(true);
      setResult(0, getIntent());
      if (getIntent() != null) {
        ThreadManager.postImmediately(new SaveVideoActivity.1(this, getIntent().getStringExtra("fakeId")), null, true);
      }
      return super.onKeyDown(paramInt, paramKeyEvent);
      label123:
      if (this.jdField_b_of_type_Int == 222) {
        LpReportInfo_pf00064.allReport(680, 13, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity
 * JD-Core Version:    0.7.0.1
 */