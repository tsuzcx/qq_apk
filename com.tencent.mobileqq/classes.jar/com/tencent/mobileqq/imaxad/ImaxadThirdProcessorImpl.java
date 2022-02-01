package com.tencent.mobileqq.imaxad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.imaxad.inject.IImaxadThirdProcessor;
import com.tencent.mobileqq.nearby.now.share.IShortVideoShareUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;

public class ImaxadThirdProcessorImpl
  implements IImaxadThirdProcessor
{
  private void a(AdvertisementItem paramAdvertisementItem, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shareToWeChatFirend target = ");
    localStringBuilder.append(paramInt);
    QLog.i("ImaxAdvertisement", 1, localStringBuilder.toString());
    if (paramInt == 1001)
    {
      WXShareHelper.a().b(paramString1, paramString2, paramBitmap, paramString3, paramString4);
      ReportController.b(null, "dc00898", "", paramAdvertisementItem.g.a, "0X80092A3", "0X80092A3", 0, 0, paramAdvertisementItem.g.c, "", "", paramAdvertisementItem.g.b);
      return;
    }
    if (paramInt == 1002)
    {
      WXShareHelper.a().a(paramString1, paramString2, paramBitmap, paramString3, paramString4);
      ReportController.b(null, "dc00898", "", paramAdvertisementItem.g.a, "0X80092A5", "0X80092A5", 0, 0, paramAdvertisementItem.g.c, "", "", paramAdvertisementItem.g.b);
    }
  }
  
  private boolean a(Context paramContext, int paramInt)
  {
    if (!WXShareHelper.a().b())
    {
      QQToast.makeText(paramContext, 2131891948, 0).show();
      return false;
    }
    if (!WXShareHelper.a().c())
    {
      QQToast.makeText(paramContext, 2131918155, 0).show();
      return false;
    }
    if ((paramInt == 1002) && (!WXShareHelper.a().d()))
    {
      QQToast.makeText(paramContext, 2131918155, 0).show();
      return false;
    }
    if (!NetworkUtil.isNetworkAvailable(paramContext))
    {
      QQToast.makeText(paramContext, 1, 2131892104, 1).show();
      return false;
    }
    return true;
  }
  
  public long a()
  {
    return BaseApplicationImpl.sToolShowTime;
  }
  
  public URLDrawable a(String paramString)
  {
    return URLDrawableHelper.getDrawable(paramString);
  }
  
  public void a(AdvertisementItem paramAdvertisementItem, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString4 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(127).b(12345).e(paramString4);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131903711));
    ((StringBuilder)localObject).append(paramString3);
    paramString4 = paramString4.a(((StringBuilder)localObject).toString()).a();
    localObject = paramAdvertisementItem.g.L;
    String str = paramAdvertisementItem.g.M;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramString4.mSourceName = paramAdvertisementItem.g.L;
      if (!TextUtils.isEmpty(str)) {
        paramString4.mSourceIcon = paramAdvertisementItem.g.M;
      }
    }
    paramString4.mContentLayout = 2;
    localObject = StructMsgElementFactory.a(2);
    ((AbsStructMsgItem)localObject).a(paramString1, paramString2, paramString3);
    paramString4.addItem((AbsStructMsgElement)localObject);
    paramString1 = new Intent();
    paramString1.putExtra("forward_type", -3);
    paramString1.putExtra("stuctmsg_bytes", paramString4.getBytes());
    paramString1.putExtra("structmsg_service_id", paramString4.mMsgServiceID);
    paramString1.putExtra("emoInputType", 2);
    paramString1.putExtra("forwardDirect", true);
    ForwardBaseOption.a((Activity)paramContext, paramString1, 1000);
    ReportController.b(null, "dc00898", "", paramAdvertisementItem.g.a, "0X80092A2", "0X80092A2", 0, 0, paramAdvertisementItem.g.c, "", "", paramAdvertisementItem.g.b);
  }
  
  public void a(AdvertisementItem paramAdvertisementItem, URLDrawable paramURLDrawable, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (a(paramContext, paramInt))
    {
      paramContext = String.valueOf(System.currentTimeMillis());
      if (paramURLDrawable != null) {
        paramURLDrawable.cancelDownload();
      }
      paramURLDrawable = URLDrawable.getDrawable(paramString4, URLDrawable.URLDrawableOptions.obtain());
      if (paramURLDrawable.getStatus() == 1)
      {
        a(paramAdvertisementItem, paramContext, paramString1, paramString2, ((IShortVideoShareUtil)QRoute.api(IShortVideoShareUtil.class)).drawableToBitmap(paramURLDrawable), paramString3, paramInt);
        return;
      }
      if (paramURLDrawable.getStatus() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdvertisement", 2, "s_forShare Bitmap FAILED, downloadImediatly ...");
        }
        paramURLDrawable.startDownload();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "start load URLDrawable. ...");
      }
      paramURLDrawable.setURLDrawableListener(new ImaxadThirdProcessorImpl.1(this, paramAdvertisementItem, paramContext, paramString1, paramString2, paramString3, paramInt));
      paramURLDrawable.startDownload();
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt, AdvertisementItem paramAdvertisementItem)
  {
    AdvertisementRecentUserManager.a().a(paramAppInterface, paramInt, paramAdvertisementItem);
  }
  
  public void b(AdvertisementItem paramAdvertisementItem, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QZoneShareData localQZoneShareData = new QZoneShareData();
    localQZoneShareData.mTitle = paramString1;
    localQZoneShareData.mSummary = paramString2;
    localQZoneShareData.mImageUrls = new ArrayList();
    localQZoneShareData.mImageUrls.add(paramString4);
    localQZoneShareData.targetUrl = paramString3;
    QZoneShareManager.shareToQzone(paramContext, String.valueOf(CommonDataAdapter.a().c()), localQZoneShareData, null, 1003);
    ReportController.b(null, "dc00898", "", paramAdvertisementItem.g.a, "0X80092A4", "0X80092A4", 0, 0, paramAdvertisementItem.g.c, "", "", paramAdvertisementItem.g.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxadThirdProcessorImpl
 * JD-Core Version:    0.7.0.1
 */