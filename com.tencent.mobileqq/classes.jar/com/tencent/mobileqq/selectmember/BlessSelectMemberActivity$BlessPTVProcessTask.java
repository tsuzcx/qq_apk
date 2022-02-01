package com.tencent.mobileqq.selectmember;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.bless.api.IBlessApi;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.api.IShortVideoFactory;
import com.tencent.mobileqq.shortvideo.api.IShortVideoOperator;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class BlessSelectMemberActivity$BlessPTVProcessTask
  extends AsyncTask<Void, Void, Integer>
{
  int jdField_a_of_type_Int;
  Intent jdField_a_of_type_AndroidContentIntent;
  MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  String jdField_a_of_type_JavaLangString;
  WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  int jdField_b_of_type_Int;
  WeakReference<QBaseActivity> jdField_b_of_type_JavaLangRefWeakReference;
  int c;
  
  public BlessSelectMemberActivity$BlessPTVProcessTask(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQBaseActivity);
    this.jdField_a_of_type_AndroidContentIntent = paramQBaseActivity.getIntent();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("param_entrance", 0);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("thumbfile_send_path");
    this.jdField_b_of_type_Int = ((IBlessApi)QRoute.api(IBlessApi.class)).getSVBusiUtil_BUSI_TYPE_SHORTVIDEO_PTV_Value();
    this.c = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
    if (QLog.isColorLevel()) {
      QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: create");
    }
  }
  
  protected Integer a(Void... arg1)
  {
    boolean bool = QLog.isColorLevel();
    Object localObject1 = Integer.valueOf(2);
    if (bool) {
      QLog.e("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: doInBackground start");
    }
    long l = SystemClock.elapsedRealtime();
    ??? = (QBaseActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (??? == null) {
      return Integer.valueOf(5);
    }
    if (!TextUtils.isEmpty(BlessSelectMemberActivity.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: currVideoPath is not null");
      }
      return Integer.valueOf(1);
    }
    ((IBlessApi)QRoute.api(IBlessApi.class)).getEncodeQualityParamForSendTask(this.jdField_a_of_type_AndroidContentIntent);
    int i = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("sv_total_frame_count", 0);
    int j = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("sv_total_record_time", 0);
    ((IBlessApi)QRoute.api(IBlessApi.class)).setCodecParam(i, j);
    if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_JavaLangString)) {
      return localObject1;
    }
    Object localObject3 = URLDrawable.URLDrawableOptions.obtain();
    localObject3 = URLDrawable.getDrawable(new File(this.jdField_a_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject3);
    ((URLDrawable)localObject3).downloadImediatly();
    if (((URLDrawable)localObject3).getStatus() == 1)
    {
      localObject1 = new ShortVideoReq();
      ((ShortVideoReq)localObject1).jdField_a_of_type_Int = 0;
      ((ShortVideoReq)localObject1).jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      localObject3 = (ShortVideoUploadInfo)((IBlessApi)QRoute.api(IBlessApi.class)).createShortVideoUploadInfo(this.jdField_a_of_type_AndroidContentIntent, localObject1);
      if (localObject3 == null) {
        return Integer.valueOf(5);
      }
      ((ShortVideoUploadInfo)localObject3).e = true;
      ((ShortVideoUploadInfo)localObject3).b = false;
      if ((((ShortVideoUploadInfo)localObject3).r != null) && (((ShortVideoUploadInfo)localObject3).r.length() == 39)) {
        ((ShortVideoUploadInfo)localObject3).r = ((ShortVideoUploadInfo)localObject3).r.substring(0, 28);
      }
      ((ShortVideoReq)localObject1).a((ShortVideoUploadInfo)localObject3);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)((IShortVideoFactory)QRoute.api(IShortVideoFactory.class)).getAioShortVideoSendOperator((BaseQQAppInterface)???.getAppRuntime()).a((ShortVideoUploadInfo)localObject3));
      ??? = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      if ((??? instanceof MessageForBlessPTV)) {
        ((MessageForBlessPTV)???).videoFileName = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("bless_ptv_mp4_path");
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("BlessPTVProcessTask: generate req and mr success, cost:");
        ???.append(SystemClock.elapsedRealtime() - l);
        QLog.d("BlessSelectMemberActivity", 2, ???.toString());
      }
      l = SystemClock.elapsedRealtime();
      ((IBlessApi)QRoute.api(IBlessApi.class)).setPtvMessage((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      if (BlessSelectMemberActivity.a() != null) {
        BlessSelectMemberActivity.a().sendEmptyMessage(3);
      } else {
        QLog.e("BlessSelectMemberActivity", 1, "mUIHandler is null!");
      }
      try
      {
        synchronized (BlessSelectMemberActivity.a())
        {
          BlessSelectMemberActivity.a().wait(BlessSelectMemberActivity.a());
          BlessSelectMemberActivity.b(SystemClock.elapsedRealtime() - l);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("BlessPTVProcessTask: encodeVideo cost = ");
            ((StringBuilder)localObject1).append(SystemClock.elapsedRealtime() - l);
            QLog.d("BlessSelectMemberActivity", 2, ((StringBuilder)localObject1).toString());
          }
          if (BlessSelectMemberActivity.b() >= BlessSelectMemberActivity.a()) {
            return Integer.valueOf(9);
          }
          return Integer.valueOf(BlessSelectMemberActivity.a());
        }
        StringBuilder localStringBuilder;
        return localStringBuilder;
      }
      catch (InterruptedException ???)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("BlessPTVProcessTask: wait exception = ");
          localStringBuilder.append(???.getMessage());
          QLog.d("BlessSelectMemberActivity", 2, localStringBuilder.toString());
        }
        return Integer.valueOf(5);
      }
    }
  }
  
  protected void a(Integer arg1)
  {
    super.onPostExecute(???);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BlessPTVProcessTask: onPostExecute result=");
      localStringBuilder.append(???);
      QLog.i("BlessSelectMemberActivity", 1, localStringBuilder.toString());
    }
    BlessSelectMemberActivity.b(???.intValue());
    synchronized (BlessSelectMemberActivity.b())
    {
      BlessSelectMemberActivity.b().set(true);
      BlessSelectMemberActivity.b().notifyAll();
      return;
    }
  }
  
  public boolean a()
  {
    if (((IBlessApi)QRoute.api(IBlessApi.class)).isVideoSoLibLoaded()) {
      return true;
    }
    ((IBlessApi)QRoute.api(IBlessApi.class)).loadShortVideoSo((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    return ((IBlessApi)QRoute.api(IBlessApi.class)).isVideoSoLibLoaded();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    BlessSelectMemberActivity.b(1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Is video useable:");
    localStringBuilder.append(a());
    localStringBuilder.append(", mEntrance:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.d("BlessSelectMemberActivity", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.BlessSelectMemberActivity.BlessPTVProcessTask
 * JD-Core Version:    0.7.0.1
 */