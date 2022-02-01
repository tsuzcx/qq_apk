package com.tencent.timi.game.liveroom.impl.share.timishare;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.timi.game.liveroom.impl.report.TGReportUtil;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class TimiGameShareUtil
{
  public static void a(Context paramContext, TgShareParam paramTgShareParam, ShareActionSheet.OnItemClickListener paramOnItemClickListener, DialogInterface.OnShowListener paramOnShowListener, DialogInterface.OnCancelListener paramOnCancelListener, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (paramContext == null)
    {
      CustomToastView.a(true, "参数异常");
      return;
    }
    Object localObject = new ShareActionSheetV2.Param();
    ((ShareActionSheetV2.Param)localObject).context = paramContext;
    localObject = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject);
    ((ShareActionSheet)localObject).setActionSheetTitle(paramContext.getString(2131916565));
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    if (paramTgShareParam.i) {
      localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
    }
    ((ShareActionSheet)localObject).setActionSheetItems(localArrayList1, localArrayList2);
    ((ShareActionSheet)localObject).setRowVisibility(0, 0, 0);
    ((ShareActionSheet)localObject).setItemClickListenerV2(new TimiGameShareUtil.1(paramContext, paramTgShareParam, paramOnItemClickListener));
    paramTgShareParam = new Intent();
    if ((paramContext instanceof Activity)) {
      paramTgShareParam = ((Activity)paramContext).getIntent();
    }
    paramTgShareParam.putExtra("big_brother_source_key", "biz_src_jc_qqlive");
    paramTgShareParam.putExtra("forward_type", 1001);
    paramTgShareParam.putExtra("pluginName", "web_share");
    ((ShareActionSheet)localObject).setIntentForStartForwardRecentActivity(new Intent(paramTgShareParam));
    ((ShareActionSheet)localObject).setOnShowListener(new TimiGameShareUtil.2(paramOnShowListener));
    ((ShareActionSheet)localObject).setCancelListener(new TimiGameShareUtil.3(paramOnCancelListener));
    ((ShareActionSheet)localObject).setOnDismissListener(new TimiGameShareUtil.4(paramOnDismissListener));
    ((ShareActionSheet)localObject).show();
  }
  
  public static void a(Context paramContext, TgShareParam paramTgShareParam, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Object localObject = (Activity)paramContext;
    paramContext = (Context)localObject;
    if ((localObject instanceof BasePluginActivity)) {
      paramContext = ((BasePluginActivity)localObject).getOutActivity();
    }
    localObject = new Intent();
    if (!TextUtils.isEmpty(paramString4))
    {
      ((Intent)localObject).putExtra("pluginName", "web_share");
      ((Intent)localObject).putExtra("req_type", 13);
      ((Intent)localObject).putExtra("req_share_id", 0);
      Intent localIntent = paramTgShareParam.a();
      if (localIntent != null) {
        ((Intent)localObject).putExtras(localIntent);
      }
      ((Intent)localObject).putExtra("app_name", paramTgShareParam.h);
      ((Intent)localObject).putExtra("title", paramString1);
      ((Intent)localObject).putExtra("desc", paramString2);
      ((Intent)localObject).putExtra("image_url_remote", paramString3);
      ((Intent)localObject).putExtra("detail_url", paramString4);
      boolean bool = TextUtils.isEmpty(paramString5) ^ true;
      if (bool)
      {
        paramTgShareParam = new Bundle();
        paramTgShareParam.putInt("key_req", 1);
        paramTgShareParam.putInt("key_direct_show_uin_type", paramInt);
        paramTgShareParam.putString("key_direct_show_uin", paramString5);
        ((Intent)localObject).putExtras(paramTgShareParam);
      }
      if (bool) {
        paramTgShareParam = "/base/forwardRecentTrans";
      } else {
        paramTgShareParam = "/base/forwardRecent";
      }
      RouteUtils.a(paramContext, (Intent)localObject, paramTgShareParam, 1);
    }
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (!WXShareHelper.a().b()) {
      CustomToastView.a(2131918154);
    } else if (!WXShareHelper.a().c()) {
      CustomToastView.a(2131918155);
    }
    long l = System.currentTimeMillis();
    ThreadManager.getSubThreadHandler().post(new TimiGameShareUtil.5(paramString3, String.valueOf(l), paramString1, paramString2, paramString4, paramInt));
    WXShareHelper.a().a(new TimiGameShareUtil.6());
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Object localObject = (Activity)paramContext;
    paramContext = (Context)localObject;
    if ((localObject instanceof BasePluginActivity)) {
      paramContext = ((BasePluginActivity)localObject).getOutActivity();
    }
    localObject = new QZoneShareData();
    ((QZoneShareData)localObject).mTitle = paramString1;
    ((QZoneShareData)localObject).mSummary = paramString2;
    ((QZoneShareData)localObject).mImageUrls = new ArrayList();
    ((QZoneShareData)localObject).mImageUrls.add(paramString3);
    ((QZoneShareData)localObject).from = 0;
    ((QZoneShareData)localObject).targetUrl = paramString4;
    ((QZoneShareData)localObject).shareUin = paramString5;
    QZoneShareManager.shareToQzone(paramContext, paramString5, (QZoneShareData)localObject, null, paramInt);
  }
  
  private static void b(Context paramContext, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, TgShareParam paramTgShareParam)
  {
    int i = paramActionSheetItem.action;
    int j = paramActionSheetItem.uinType;
    paramActionSheetItem = paramActionSheetItem.uin;
    if (paramTgShareParam == null) {
      return;
    }
    if (i != 2) {
      if (i != 3)
      {
        if (i != 26)
        {
          if (i != 72)
          {
            if (i == 73) {
              break label309;
            }
            switch (i)
            {
            default: 
              return;
            case 11: 
              paramActionSheetItem = paramTgShareParam.a(1);
              if (paramActionSheetItem == null)
              {
                CustomToastView.a("已收到你的举报，我们会及时处理");
                return;
              }
              paramTgShareParam = ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).b();
              TGReportUtil.a.a(paramContext, paramActionSheetItem.d, paramTgShareParam);
              return;
            case 10: 
              paramActionSheetItem = paramTgShareParam.a(2);
              if (paramActionSheetItem == null) {
                return;
              }
              a(paramContext, paramActionSheetItem.a, paramActionSheetItem.b, paramActionSheetItem.c, paramActionSheetItem.d, 1);
              return;
            }
            paramActionSheetItem = paramTgShareParam.a(3);
            if (paramActionSheetItem == null) {
              return;
            }
            a(paramContext, paramActionSheetItem.a, paramActionSheetItem.b, paramActionSheetItem.c, paramActionSheetItem.d, 0);
            return;
          }
        }
        else {
          paramActionSheetItem = "3636666661";
        }
        TgShareParam.ShareBody localShareBody = paramTgShareParam.a(1);
        if (localShareBody == null) {
          return;
        }
        a(paramContext, paramTgShareParam, localShareBody.a, localShareBody.b, localShareBody.c, localShareBody.d, paramActionSheetItem, j);
      }
      else
      {
        paramTgShareParam = paramTgShareParam.a(0);
        if (paramTgShareParam == null) {
          return;
        }
        try
        {
          a(paramContext, paramTgShareParam.a, paramTgShareParam.b, paramTgShareParam.c, paramTgShareParam.d, paramActionSheetItem, 0);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          paramActionSheetItem = new StringBuilder();
          paramActionSheetItem.append("shareToQzone error:");
          paramActionSheetItem.append(paramContext);
          Logger.c("TgLiveShareUtil", paramActionSheetItem.toString());
          return;
        }
      }
    }
    label309:
    paramActionSheetItem = paramTgShareParam.a(1);
    if (paramActionSheetItem == null) {
      return;
    }
    a(paramContext, paramTgShareParam, paramActionSheetItem.a, paramActionSheetItem.b, paramActionSheetItem.c, paramActionSheetItem.d, null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.share.timishare.TimiGameShareUtil
 * JD-Core Version:    0.7.0.1
 */