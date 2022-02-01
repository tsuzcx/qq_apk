package com.tencent.mobileqq.imaxad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.List;

public class ImaxShareActionSheet
  implements AdapterView.OnItemClickListener
{
  private static URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private Context jdField_a_of_type_AndroidContentContext;
  private AdvertisementItem jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem;
  protected ShareActionSheetBuilder a;
  
  public ImaxShareActionSheet(Context paramContext, AdvertisementItem paramAdvertisementItem)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem = paramAdvertisementItem;
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QZoneShareData localQZoneShareData = new QZoneShareData();
    localQZoneShareData.mTitle = paramString1;
    localQZoneShareData.mSummary = paramString2;
    localQZoneShareData.mImageUrls = new ArrayList();
    localQZoneShareData.mImageUrls.add(paramString4);
    localQZoneShareData.targetUrl = paramString3;
    QZoneShareManager.shareToQzone(paramContext, String.valueOf(CommonDataAdapter.a().a()), localQZoneShareData, null, 1003);
    ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.a, "0X80092A4", "0X80092A4", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.c, "", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.b);
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (a(paramContext, paramInt))
    {
      paramContext = String.valueOf(System.currentTimeMillis());
      if (jdField_a_of_type_ComTencentImageURLDrawable != null) {
        jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload();
      }
      jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString4, URLDrawable.URLDrawableOptions.obtain());
      if (jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) {
        a(paramContext, paramString1, paramString2, ShortVideoShareUtil.a(jdField_a_of_type_ComTencentImageURLDrawable), paramString3, paramInt);
      }
    }
    else
    {
      return;
    }
    if (jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "s_forShare Bitmap FAILED, downloadImediatly ...");
      }
      jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "start load URLDrawable. ...");
    }
    jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new ImaxShareActionSheet.1(this, paramContext, paramString1, paramString2, paramString3, paramInt));
    jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, String paramString4, int paramInt)
  {
    QLog.i("ImaxAdvertisement", 1, "shareToWeChatFirend target = " + paramInt);
    if (paramInt == 1001)
    {
      WXShareHelper.a().b(paramString1, paramString2, paramBitmap, paramString3, paramString4);
      ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.a, "0X80092A3", "0X80092A3", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.c, "", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.b);
    }
    while (paramInt != 1002) {
      return;
    }
    WXShareHelper.a().a(paramString1, paramString2, paramBitmap, paramString3, paramString4);
    ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.a, "0X80092A5", "0X80092A5", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.c, "", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.b);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString4 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(127).b(12345).e(paramString4).a(HardCodeUtil.a(2131705765) + paramString3).a();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.v;
    String str = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.w;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramString4.mSourceName = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.v;
      if (!TextUtils.isEmpty(str)) {
        paramString4.mSourceIcon = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.w;
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
    ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramString1, 1000);
    ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.a, "0X80092A2", "0X80092A2", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.c, "", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.b);
  }
  
  private boolean a(Context paramContext, int paramInt)
  {
    if (!WXShareHelper.a().a())
    {
      QQToast.a(paramContext, 2131694345, 0).a();
      return false;
    }
    if (!WXShareHelper.a().b())
    {
      QQToast.a(paramContext, 2131720754, 0).a();
      return false;
    }
    if ((paramInt == 1002) && (!WXShareHelper.a().c()))
    {
      QQToast.a(paramContext, 2131720754, 0).a();
      return false;
    }
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694459, 1).a();
      return false;
    }
    return true;
  }
  
  private boolean a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "shareImaxAd Failed title==null");
      }
      bool = false;
    }
    for (;;)
    {
      if (!bool) {
        QQToast.a(paramContext, 2131717787, 0).a();
      }
      return bool;
      if (TextUtils.isEmpty(paramString2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdvertisement", 2, "shareImaxAd Failed bitmapUrl==null");
        }
        bool = false;
      }
      else if (TextUtils.isEmpty(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdvertisement", 2, "shareImaxAd Failed jumpUrl==null");
        }
        bool = false;
      }
    }
  }
  
  public ShareActionSheetBuilder.ActionSheetItem a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, String paramString)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_AndroidContentContext.getString(paramInt1);
    localActionSheetItem.icon = paramInt2;
    localActionSheetItem.iconNeedBg = paramBoolean;
    localActionSheetItem.action = paramInt3;
    localActionSheetItem.argus = paramString;
    return localActionSheetItem;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131719311));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=", localException);
    }
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(2131696380, 2130839214, true, 2, ""));
    localArrayList.add(a(2131696394, 2130839215, true, 3, ""));
    localArrayList.add(a(2131696401, 2130839218, true, 9, ""));
    localArrayList.add(a(2131696383, 2130839212, true, 10, ""));
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = null;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1;
    Object localObject4;
    if (QLog.isColorLevel())
    {
      if ("onshare_ItemClick mAdItem " + this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem == null)
      {
        localObject1 = " null";
        QLog.d("ImaxAdvertisement", 2, (String)localObject1);
      }
    }
    else
    {
      localObject4 = paramView.getTag();
      if ((localObject4 != null) && (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem != null)) {
        break label87;
      }
    }
    label87:
    String str2;
    Object localObject2;
    Object localObject3;
    do
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.toString();
      break;
      str2 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.x;
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.t;
      localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.s;
      String str1 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.u;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.e;
      }
      localObject2 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.d;
      }
      localObject3 = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.f;
      }
    } while (!a(this.jdField_a_of_type_AndroidContentContext, (String)localObject2, (String)localObject1, str2));
    switch (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject4).a.action)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      break;
      a((String)localObject1, (String)localObject2, (String)localObject3, str2);
      continue;
      a(this.jdField_a_of_type_AndroidContentContext, (String)localObject2, (String)localObject3, str2, (String)localObject1);
      continue;
      a(this.jdField_a_of_type_AndroidContentContext, (String)localObject2, (String)localObject3, str2, (String)localObject1, 1001);
      continue;
      a(this.jdField_a_of_type_AndroidContentContext, (String)localObject2, (String)localObject3, str2, (String)localObject1, 1002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxShareActionSheet
 * JD-Core Version:    0.7.0.1
 */