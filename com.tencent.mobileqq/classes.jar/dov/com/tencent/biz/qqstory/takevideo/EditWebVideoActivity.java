package dov.com.tencent.biz.qqstory.takevideo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import anfg;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.transfile.PtvGuideUploader;
import com.tencent.mobileqq.transfile.PtvGuideUploader.IPtvGuidUpCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import dov.com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import java.io.File;

public class EditWebVideoActivity
  extends EditVideoActivity
  implements Handler.Callback, PtvGuideUploader.IPtvGuidUpCallback
{
  private int jdField_a_of_type_Int;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private EncodeVideoTask.ResultListener jdField_a_of_type_DovComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener = new anfg(this);
  private String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String f;
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditWebVideoActivity", 2, "jumpToH5Activity, uid:" + this.d + ", md5:" + this.jdField_c_of_type_JavaLangString + ", callback:" + this.f);
    }
    Intent localIntent = new Intent("tencent.video.q2v.startUploadPTV");
    localIntent.putExtra("broadcastType", 1);
    sendBroadcast(localIntent);
    c();
    if (!TextUtils.isEmpty(this.f))
    {
      localIntent = new Intent();
      localIntent.setAction("com.tencent.mobileqq.shortVideoJsApiPulgin");
      localIntent.putExtra("uuid", this.d);
      localIntent.putExtra("md5", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("callback", this.f);
      localIntent.putExtra("mediaType", "video");
      finish();
      sendBroadcast(localIntent);
      return;
    }
    QQToast.a(this, "对不起，视频处理异常...", 0).a();
    finish();
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "onShareClick " + this.jdField_b_of_type_JavaLangString + " mthumbPath" + this.jdField_a_of_type_JavaLangString);
    }
    if ((StringUtil.a(this.jdField_b_of_type_JavaLangString)) || (StringUtil.a(this.jdField_a_of_type_JavaLangString)))
    {
      finish();
      return;
    }
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString == null))
    {
      QQToast.a(this, 2131435607, 0).a();
      c();
      return;
    }
    File localFile1 = new File(this.jdField_a_of_type_JavaLangString);
    File localFile2 = new File(this.jdField_b_of_type_JavaLangString);
    if ((!localFile1.exists()) || (!localFile2.exists()))
    {
      QQToast.a(this, 2131435607, 0).a();
      c();
      return;
    }
    if ((!localFile1.isFile()) || (!localFile2.isFile()))
    {
      QQToast.a(this, 2131435608, 0).a();
      c();
      return;
    }
    if (new PtvGuideUploader(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Int).a())
    {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1003, 60000L);
      return;
    }
    c();
    QQToast.a(this, 1, 2131435289, 0).a();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditWebVideoActivity", 2, "OnUploadVideoListener onUploadFail!");
    }
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(1003)) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1003);
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1003);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager == null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager = new EditWebVideoPartManager();
    }
    ((EditWebVideoPartManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager).a(this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "cancelProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
    if (QLog.isColorLevel()) {
      QLog.i("EditWebVideoActivity", 2, "OnUploadVideoListener onUploadSuccess! " + this.d);
    }
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(1003)) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1003);
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1001);
  }
  
  void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "showProgressDialog " + paramString);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppProgressDialog == null) {
          continue;
        }
        c();
        localTextView = (TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363381);
        if (!StringUtil.a(paramString)) {
          continue;
        }
        localTextView.setText(2131434297);
      }
      catch (Throwable paramString)
      {
        TextView localTextView;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("EditWebVideoActivity", 2, "showProgressDialog", paramString);
        return;
        localTextView.setText(paramString);
        continue;
      }
      if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
        return;
      }
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      return;
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131624515);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969181);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    this.f = getIntent().getStringExtra("edit_video_call_back");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      FileUtils.d(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditWebVideoActivity", 2, "handleMessage,msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1003: 
      c();
      QQToast.a(this, 1, 2131435286, 0).a();
      finish();
      return true;
    case 1001: 
      CaptureReportUtil.b(CameraControl.a().jdField_a_of_type_Int, "");
      d();
      return true;
    }
    c();
    d("上传视频中...");
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity
 * JD-Core Version:    0.7.0.1
 */