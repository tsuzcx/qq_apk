package com.tencent.mobileqq.imaxad;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.imaxad.inject.ImaxadThirdProcessorProxy;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ImaxShareActionSheet
  implements AdapterView.OnItemClickListener
{
  public static URLDrawable a;
  private Context jdField_a_of_type_AndroidContentContext;
  private AdvertisementItem jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem;
  public ImaxadThirdProcessorProxy a;
  protected ShareActionSheetBuilder a;
  
  public ImaxShareActionSheet(Context paramContext, AdvertisementItem paramAdvertisementItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqImaxadInjectImaxadThirdProcessorProxy = new ImaxadThirdProcessorProxy();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem = paramAdvertisementItem;
  }
  
  private boolean a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "shareImaxAd Failed title==null");
      }
    }
    for (;;)
    {
      bool = false;
      break label79;
      if (TextUtils.isEmpty(paramString2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdvertisement", 2, "shareImaxAd Failed bitmapUrl==null");
        }
      }
      else
      {
        if (!TextUtils.isEmpty(paramString3)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdvertisement", 2, "shareImaxAd Failed jumpUrl==null");
        }
      }
    }
    boolean bool = true;
    label79:
    if (!bool) {
      QQToast.a(paramContext, 2131719009, 0).a();
    }
    return bool;
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
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131719029));
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
      if (QLog.isColorLevel()) {
        QLog.d("ShareActionSheet", 2, "actionSheet.show exception=", localException);
      }
    }
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(2131719034, 2130839067, true, 2, ""));
    localArrayList.add(a(2131719036, 2130839068, true, 3, ""));
    localArrayList.add(a(2131719041, 2130839071, true, 9, ""));
    localArrayList.add(a(2131719032, 2130839065, true, 10, ""));
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onshare_ItemClick mAdItem ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem);
      if (((StringBuilder)localObject1).toString() == null) {
        localObject1 = " null";
      } else {
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.toString();
      }
      QLog.d("ImaxAdvertisement", 2, (String)localObject1);
    }
    Object localObject3 = paramView.getTag();
    if (localObject3 != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem;
      if (localObject1 != null)
      {
        String str3 = ((AdvertisementItem)localObject1).a.x;
        Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.t;
        String str2 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.s;
        String str1 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.u;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.e;
        }
        localObject2 = str2;
        if (TextUtils.isEmpty(str2)) {
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.d;
        }
        if (TextUtils.isEmpty(str1)) {
          str1 = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.f;
        }
        if (a(this.jdField_a_of_type_AndroidContentContext, (String)localObject2, (String)localObject1, str3))
        {
          int i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject3).a.action;
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 9)
              {
                if (i == 10) {
                  this.jdField_a_of_type_ComTencentMobileqqImaxadInjectImaxadThirdProcessorProxy.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem, jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_AndroidContentContext, (String)localObject2, str1, str3, (String)localObject1, 1002);
                }
              }
              else {
                this.jdField_a_of_type_ComTencentMobileqqImaxadInjectImaxadThirdProcessorProxy.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem, jdField_a_of_type_ComTencentImageURLDrawable, this.jdField_a_of_type_AndroidContentContext, (String)localObject2, str1, str3, (String)localObject1, 1001);
              }
            }
            else {
              this.jdField_a_of_type_ComTencentMobileqqImaxadInjectImaxadThirdProcessorProxy.b(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem, this.jdField_a_of_type_AndroidContentContext, (String)localObject2, str1, str3, (String)localObject1);
            }
          }
          else {
            this.jdField_a_of_type_ComTencentMobileqqImaxadInjectImaxadThirdProcessorProxy.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem, this.jdField_a_of_type_AndroidContentContext, (String)localObject1, (String)localObject2, str1, str3);
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
        }
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxShareActionSheet
 * JD-Core Version:    0.7.0.1
 */