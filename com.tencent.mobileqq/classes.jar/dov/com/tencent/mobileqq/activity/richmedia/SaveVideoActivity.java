package dov.com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.common.app.AppInterface;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.CaptureContext;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SaveVideoActivity
  extends FlowActivity
{
  private static FFmpeg jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg;
  private SaveVideoActivity.SaveVideoTask jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$SaveVideoTask;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
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
      paramAppInterface = new QQStoryEntityManagerFactory(paramAppInterface);
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
    paramAppInterface = new QQStoryEntityManagerFactory(paramAppInterface);
    paramAppInterface.verifyAuthentication();
    paramAppInterface.createEntityManager().remove(paramPublishVideoEntry);
  }
  
  protected void a(ViewGroup paramViewGroup) {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void onBackPressed()
  {
    if (this.jdField_b_of_type_Boolean) {
      super.onBackPressed();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      finish();
      return;
    }
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mRecordFrames = paramBundle.getIntExtra("sv_total_frame_count", 0);
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mRecordTime = paramBundle.getIntExtra("sv_total_record_time", 0);
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("requestCode", -1);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$SaveVideoTask = new SaveVideoActivity.SaveVideoTask(this, CaptureContext.a());
    SaveVideoActivity.SaveVideoTask.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$SaveVideoTask, paramBundle.getBooleanExtra("mediacodec_encode_enable", false));
    SaveVideoActivity.SaveVideoTask.b(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$SaveVideoTask, paramBundle.getBooleanExtra("video_edit_flag", false));
    SaveVideoActivity.SaveVideoTask.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$SaveVideoTask, paramBundle.getIntExtra("save_video_businessid", -1));
    Utils.executeAsyncTaskOnSerialExcuter(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$SaveVideoTask, new Void[] { (Void)null });
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.jdField_b_of_type_Boolean = true;
      if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$SaveVideoTask != null) && (!isFinishing()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SaveVideoActivity", 2, "cancel save video");
        }
        if (SlideShowPhotoListManager.a().b() == 22)
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
      SaveVideoActivity.SaveVideoTask.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaSaveVideoActivity$SaveVideoTask).set(true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity
 * JD-Core Version:    0.7.0.1
 */