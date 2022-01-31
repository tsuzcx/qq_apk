package dov.com.tencent.biz.qqstory.takevideo;

import ajxy;
import alpo;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import axlc;
import azcx;
import barn;
import barp;
import bdcs;
import bdje;
import bhoe;
import bmkn;
import bmko;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EditWebVideoActivity
  extends EditVideoActivity
  implements Handler.Callback, barp
{
  private int jdField_a_of_type_Int;
  private ajxy jdField_a_of_type_Ajxy = new bmkn(this);
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private bhoe jdField_a_of_type_Bhoe;
  private String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String f;
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditWebVideoActivity", 2, "jumpToH5Activity, uid:" + this.d + ", md5:" + this.jdField_c_of_type_JavaLangString + ", callback:" + this.f);
    }
    Intent localIntent = new Intent("tencent.video.q2v.startUploadPTV");
    localIntent.putExtra("broadcastType", 1);
    localIntent.putExtra("recordType", 2);
    sendBroadcast(localIntent);
    f();
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
    QQToast.a(this, alpo.a(2131704345), 0).a();
    finish();
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "onShareClick " + this.jdField_b_of_type_JavaLangString + " mthumbPath" + this.jdField_a_of_type_JavaLangString);
    }
    if ((bdje.a(this.jdField_b_of_type_JavaLangString)) || (bdje.a(this.jdField_a_of_type_JavaLangString)))
    {
      finish();
      return;
    }
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString == null))
    {
      QQToast.a(this, 2131692635, 0).a();
      f();
      return;
    }
    File localFile1 = new File(this.jdField_a_of_type_JavaLangString);
    File localFile2 = new File(this.jdField_b_of_type_JavaLangString);
    if ((!localFile1.exists()) || (!localFile2.exists()))
    {
      QQToast.a(this, 2131692635, 0).a();
      f();
      return;
    }
    if ((!localFile1.isFile()) || (!localFile2.isFile()))
    {
      QQToast.a(this, 2131692637, 0).a();
      f();
      return;
    }
    if (new barn(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Int).a())
    {
      this.jdField_a_of_type_Bhoe.sendEmptyMessageDelayed(1003, 60000L);
      return;
    }
    f();
    QQToast.a(this, 1, 2131720020, 0).a();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditWebVideoActivity", 2, "OnUploadVideoListener onUploadFail!");
    }
    if (this.jdField_a_of_type_Bhoe.hasMessages(1003)) {
      this.jdField_a_of_type_Bhoe.removeMessages(1003);
    }
    this.jdField_a_of_type_Bhoe.sendEmptyMessage(1003);
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
    if (QLog.isColorLevel()) {
      QLog.i("EditWebVideoActivity", 2, "OnUploadVideoListener onUploadSuccess! " + this.d);
    }
    if (this.jdField_a_of_type_Bhoe.hasMessages(1003)) {
      this.jdField_a_of_type_Bhoe.removeMessages(1003);
    }
    this.jdField_a_of_type_Bhoe.sendEmptyMessage(1001);
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Bmix == null) {
      this.jdField_a_of_type_Bmix = new bmko();
    }
    ((bmko)this.jdField_a_of_type_Bmix).a(this.jdField_a_of_type_Ajxy);
  }
  
  public void d(String paramString)
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
        f();
        localTextView = (TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131371874);
        if (!bdje.a(paramString)) {
          continue;
        }
        localTextView.setText(2131717570);
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
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131755801);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559438);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Bhoe = new bhoe(this);
    this.f = getIntent().getStringExtra("edit_video_call_back");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      bdcs.d(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  void f()
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
      f();
      QQToast.a(this, 1, 2131720019, 0).a();
      finish();
      return true;
    case 1001: 
      axlc.b(azcx.a().jdField_a_of_type_Int, "");
      g();
      return true;
    }
    f();
    d(alpo.a(2131704354));
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity
 * JD-Core Version:    0.7.0.1
 */