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
  WeakReference<AppInterface> a;
  WeakReference<QBaseActivity> b;
  Intent c;
  String d;
  int e;
  int f;
  int g;
  MessageForShortVideo h;
  
  public BlessSelectMemberActivity$BlessPTVProcessTask(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity)
  {
    this.a = new WeakReference(paramAppInterface);
    this.b = new WeakReference(paramQBaseActivity);
    this.c = paramQBaseActivity.getIntent();
    this.e = this.c.getIntExtra("param_entrance", 0);
    this.d = this.c.getStringExtra("thumbfile_send_path");
    this.f = ((IBlessApi)QRoute.api(IBlessApi.class)).getSVBusiUtil_BUSI_TYPE_SHORTVIDEO_PTV_Value();
    this.g = this.c.getIntExtra("uintype", -1);
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
    ??? = (QBaseActivity)this.b.get();
    if (??? == null) {
      return Integer.valueOf(5);
    }
    if (!TextUtils.isEmpty(BlessSelectMemberActivity.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "BlessPTVProcessTask: currVideoPath is not null");
      }
      return Integer.valueOf(1);
    }
    ((IBlessApi)QRoute.api(IBlessApi.class)).getEncodeQualityParamForSendTask(this.c);
    int i = this.c.getIntExtra("sv_total_frame_count", 0);
    int j = this.c.getIntExtra("sv_total_record_time", 0);
    ((IBlessApi)QRoute.api(IBlessApi.class)).setCodecParam(i, j);
    if (!FileUtils.fileExistsAndNotEmpty(this.d)) {
      return localObject1;
    }
    Object localObject3 = URLDrawable.URLDrawableOptions.obtain();
    localObject3 = URLDrawable.getDrawable(new File(this.d), (URLDrawable.URLDrawableOptions)localObject3);
    ((URLDrawable)localObject3).downloadImediatly();
    if (((URLDrawable)localObject3).getStatus() == 1)
    {
      localObject1 = new ShortVideoReq();
      ((ShortVideoReq)localObject1).a = 0;
      ((ShortVideoReq)localObject1).b = this.f;
      localObject3 = (ShortVideoUploadInfo)((IBlessApi)QRoute.api(IBlessApi.class)).createShortVideoUploadInfo(this.c, localObject1);
      if (localObject3 == null) {
        return Integer.valueOf(5);
      }
      ((ShortVideoUploadInfo)localObject3).B = true;
      ((ShortVideoUploadInfo)localObject3).w = false;
      if ((((ShortVideoUploadInfo)localObject3).O != null) && (((ShortVideoUploadInfo)localObject3).O.length() == 39)) {
        ((ShortVideoUploadInfo)localObject3).O = ((ShortVideoUploadInfo)localObject3).O.substring(0, 28);
      }
      ((ShortVideoReq)localObject1).a((ShortVideoUploadInfo)localObject3);
      this.h = ((MessageForShortVideo)((IShortVideoFactory)QRoute.api(IShortVideoFactory.class)).getAioShortVideoSendOperator((BaseQQAppInterface)???.getAppRuntime()).a((ShortVideoUploadInfo)localObject3));
      ??? = this.h;
      if ((??? instanceof MessageForBlessPTV)) {
        ((MessageForBlessPTV)???).videoFileName = this.c.getStringExtra("bless_ptv_mp4_path");
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("BlessPTVProcessTask: generate req and mr success, cost:");
        ???.append(SystemClock.elapsedRealtime() - l);
        QLog.d("BlessSelectMemberActivity", 2, ???.toString());
      }
      l = SystemClock.elapsedRealtime();
      ((IBlessApi)QRoute.api(IBlessApi.class)).setPtvMessage((AppInterface)this.a.get(), this.h);
      if (BlessSelectMemberActivity.g() != null) {
        BlessSelectMemberActivity.g().sendEmptyMessage(3);
      } else {
        QLog.e("BlessSelectMemberActivity", 1, "mUIHandler is null!");
      }
      try
      {
        synchronized (BlessSelectMemberActivity.h())
        {
          BlessSelectMemberActivity.h().wait(BlessSelectMemberActivity.i());
          BlessSelectMemberActivity.c(SystemClock.elapsedRealtime() - l);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("BlessPTVProcessTask: encodeVideo cost = ");
            ((StringBuilder)localObject1).append(SystemClock.elapsedRealtime() - l);
            QLog.d("BlessSelectMemberActivity", 2, ((StringBuilder)localObject1).toString());
          }
          if (BlessSelectMemberActivity.j() >= BlessSelectMemberActivity.i()) {
            return Integer.valueOf(9);
          }
          return Integer.valueOf(BlessSelectMemberActivity.k());
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
    synchronized (BlessSelectMemberActivity.l())
    {
      BlessSelectMemberActivity.l().set(true);
      BlessSelectMemberActivity.l().notifyAll();
      return;
    }
  }
  
  public boolean a()
  {
    if (((IBlessApi)QRoute.api(IBlessApi.class)).isVideoSoLibLoaded()) {
      return true;
    }
    ((IBlessApi)QRoute.api(IBlessApi.class)).loadShortVideoSo((AppInterface)this.a.get());
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
    localStringBuilder.append(this.e);
    QLog.d("BlessSelectMemberActivity", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.BlessSelectMemberActivity.BlessPTVProcessTask
 * JD-Core Version:    0.7.0.1
 */