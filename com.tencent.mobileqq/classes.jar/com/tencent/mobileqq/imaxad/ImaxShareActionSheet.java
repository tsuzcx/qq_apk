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
  public static URLDrawable c;
  protected ShareActionSheetBuilder a;
  public ImaxadThirdProcessorProxy b = new ImaxadThirdProcessorProxy();
  private Context d;
  private AdvertisementItem e;
  
  public ImaxShareActionSheet(Context paramContext, AdvertisementItem paramAdvertisementItem)
  {
    this.d = paramContext;
    this.e = paramAdvertisementItem;
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
      QQToast.makeText(paramContext, 2131916544, 0).show();
    }
    return bool;
  }
  
  public ShareActionSheetBuilder.ActionSheetItem a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, String paramString)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.d.getString(paramInt1);
    localActionSheetItem.icon = paramInt2;
    localActionSheetItem.iconNeedBg = paramBoolean;
    localActionSheetItem.action = paramInt3;
    localActionSheetItem.argus = paramString;
    return localActionSheetItem;
  }
  
  public void a()
  {
    if (this.a == null)
    {
      this.a = new ShareActionSheetBuilder(this.d);
      this.a.setActionSheetTitle(this.d.getString(2131916565));
      this.a.setActionSheetItems(b());
      this.a.setItemClickListener(this);
    }
    try
    {
      this.a.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareActionSheet", 2, "actionSheet.show exception=", localException);
      }
    }
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(2131916570, 2130839221, true, 2, ""));
    localArrayList.add(a(2131916572, 2130839222, true, 3, ""));
    localArrayList.add(a(2131916577, 2130839225, true, 9, ""));
    localArrayList.add(a(2131916568, 2130839219, true, 10, ""));
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void c()
  {
    this.d = null;
    this.a = null;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onshare_ItemClick mAdItem ");
      ((StringBuilder)localObject1).append(this.e);
      if (((StringBuilder)localObject1).toString() == null) {
        localObject1 = " null";
      } else {
        localObject1 = this.e.toString();
      }
      QLog.d("ImaxAdvertisement", 2, (String)localObject1);
    }
    Object localObject3 = paramView.getTag();
    if (localObject3 != null)
    {
      localObject1 = this.e;
      if (localObject1 != null)
      {
        String str3 = ((AdvertisementItem)localObject1).g.N;
        Object localObject2 = this.e.g.J;
        String str2 = this.e.g.I;
        String str1 = this.e.g.K;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.e.i;
        }
        localObject2 = str2;
        if (TextUtils.isEmpty(str2)) {
          localObject2 = this.e.h;
        }
        if (TextUtils.isEmpty(str1)) {
          str1 = this.e.j;
        }
        if (a(this.d, (String)localObject2, (String)localObject1, str3))
        {
          int i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject3).c.action;
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 9)
              {
                if (i == 10) {
                  this.b.a(this.e, c, this.d, (String)localObject2, str1, str3, (String)localObject1, 1002);
                }
              }
              else {
                this.b.a(this.e, c, this.d, (String)localObject2, str1, str3, (String)localObject1, 1001);
              }
            }
            else {
              this.b.b(this.e, this.d, (String)localObject2, str1, str3, (String)localObject1);
            }
          }
          else {
            this.b.a(this.e, this.d, (String)localObject1, (String)localObject2, str1, str3);
          }
          this.a.dismiss();
        }
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxShareActionSheet
 * JD-Core Version:    0.7.0.1
 */