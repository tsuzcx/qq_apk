package com.tencent.mobileqq.onlinestatus.olympic.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class OlympicShareActionSheetHelper
{
  Context a;
  AppInterface b;
  Activity c;
  Bitmap d;
  
  public OlympicShareActionSheetHelper(Context paramContext, AppInterface paramAppInterface, Activity paramActivity, Bitmap paramBitmap)
  {
    this.a = paramContext;
    this.b = paramAppInterface;
    this.c = paramActivity;
    this.d = paramBitmap;
  }
  
  private void a(int paramInt, OlympicShareHelper.IShareFinishCallback paramIShareFinishCallback)
  {
    ThreadManager.postImmediately(new OlympicShareActionSheetHelper.7(this, paramInt, paramIShareFinishCallback), null, true);
  }
  
  private void a(int paramInt, String paramString, OlympicShareHelper.IShareFinishCallback paramIShareFinishCallback)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("temp_olympic_rank_share_");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".png");
      ThreadManager.post(new OlympicShareActionSheetHelper.5(this, localStringBuilder.toString(), paramInt, paramString), 8, null, true);
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      label55:
      break label55;
    }
    QQToast.makeText(this.c, 1, HardCodeUtil.a(2131896393), 1).show();
    if (paramIShareFinishCallback != null) {
      paramIShareFinishCallback.a();
    }
  }
  
  private void a(String paramString, OlympicShareHelper.IShareFinishCallback paramIShareFinishCallback)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("temp_olympic_rank_share_");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".png");
      ThreadManager.post(new OlympicShareActionSheetHelper.6(this, localStringBuilder.toString()), 8, null, true);
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      label48:
      break label48;
    }
    QQToast.makeText(this.c, 1, HardCodeUtil.a(2131896393), 1).show();
    if (paramIShareFinishCallback != null) {
      paramIShareFinishCallback.a();
    }
  }
  
  public void a(OlympicShareHelper.IShareFinishCallback paramIShareFinishCallback)
  {
    Object localObject1 = new ShareActionSheetV2.Param();
    this.c.getIntent().putExtra("big_brother_source_key", "biz_src_jc_gxl_ctcshare");
    ((ShareActionSheetV2.Param)localObject1).canceledOnTouchOutside = true;
    ((ShareActionSheetV2.Param)localObject1).context = this.c;
    ((ShareActionSheetV2.Param)localObject1).fullScreen = true;
    ((ShareActionSheetV2.Param)localObject1).lp = new ViewGroup.LayoutParams(-1, -2);
    localObject1 = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject1);
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("forward_type", 27);
    ((ShareActionSheet)localObject1).setIntentForStartForwardRecentActivity((Intent)localObject2);
    ((ShareActionSheet)localObject1).setRowVisibility(0, 0, 0);
    localObject2 = new ArrayList();
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    boolean bool1 = WXShareHelper.a().b();
    boolean bool2 = WXShareHelper.a().c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" showMyQrCodeActionSheet() isWxInstalled = ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(" isWxSupportApi =");
      localStringBuilder.append(bool2);
      QLog.d("OlympicShareActionSheetHelper", 2, localStringBuilder.toString());
    }
    if ((bool1) && (bool2))
    {
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      ((List)localObject2).add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    }
    ((ShareActionSheet)localObject1).setActionSheetItems((List)localObject2, new ArrayList());
    ((ShareActionSheet)localObject1).setItemClickListenerV2(new OlympicShareActionSheetHelper.1(this, paramIShareFinishCallback));
    ((ShareActionSheet)localObject1).setCancelListener(new OlympicShareActionSheetHelper.2(this, paramIShareFinishCallback));
    ((ShareActionSheet)localObject1).setOnDismissListener(new OlympicShareActionSheetHelper.3(this, paramIShareFinishCallback));
    ((ShareActionSheet)localObject1).show();
  }
  
  protected void b(OlympicShareHelper.IShareFinishCallback paramIShareFinishCallback)
  {
    ThreadManager.executeOnFileThread(new OlympicShareActionSheetHelper.4(this, paramIShareFinishCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareActionSheetHelper
 * JD-Core Version:    0.7.0.1
 */