package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.SVIPHandlerProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

class RecommendEmotionAdapter$2
  implements QueryCallback<EmoticonPackage>
{
  RecommendEmotionAdapter$2(RecommendEmotionAdapter paramRecommendEmotionAdapter, int paramInt1, String paramString, int paramInt2, PromotionEmoticonPkg paramPromotionEmoticonPkg, boolean paramBoolean, ProgressButton paramProgressButton, int paramInt3) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    int i = ((SVIPHandlerProxy)this.this$0.app.getBusinessHandler(((ISVIPHandlerProxy)QRoute.api(ISVIPHandlerProxy.class)).getImplClassName())).getCurrentUserVipType();
    int j = this.val$promotionType;
    if (j == 4)
    {
      paramEmoticonPackage = new StringBuilder();
      paramEmoticonPackage.append("mvip.g.a.bq_");
      paramEmoticonPackage.append(this.val$epId);
      paramEmoticonPackage = paramEmoticonPackage.toString();
    }
    else if (j == 0)
    {
      paramEmoticonPackage = new StringBuilder();
      paramEmoticonPackage.append("mvip.g.a.bq_");
      paramEmoticonPackage.append(this.val$epId);
      paramEmoticonPackage = paramEmoticonPackage.toString();
    }
    else if ((j != 3) && (j != 5))
    {
      paramEmoticonPackage = "";
    }
    else
    {
      paramEmoticonPackage = new StringBuilder();
      paramEmoticonPackage.append("mvip.g.a.bq_mg_");
      paramEmoticonPackage.append(this.val$epId);
      paramEmoticonPackage = paramEmoticonPackage.toString();
    }
    j = this.val$feeType;
    Object localObject2 = "!vip";
    if (j == 4)
    {
      localObject1 = localObject2;
      if (i == 1) {
        break label228;
      }
      localObject1 = localObject2;
      if (i == 3)
      {
        localObject1 = localObject2;
        break label228;
      }
    }
    else
    {
      if (j != 5) {
        break label224;
      }
      if (i == 3)
      {
        localObject1 = "!svip";
        break label228;
      }
      localObject1 = "!svip";
    }
    boolean bool = false;
    break label231;
    label224:
    Object localObject1 = "vip";
    label228:
    bool = true;
    label231:
    localObject2 = new EmoticonPackage();
    ((EmoticonPackage)localObject2).jobType = this.val$pkg.type;
    ((EmoticonPackage)localObject2).epId = this.val$pkg.id;
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("canDownload:");
      ((StringBuilder)localObject3).append(bool);
      ((StringBuilder)localObject3).append(",vipType:");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append(",isPayBack:");
      ((StringBuilder)localObject3).append(this.val$isPayBack);
      QLog.d("RecommendEmotionAdapter", 2, ((StringBuilder)localObject3).toString());
    }
    if (RecommendEmotionAdapter.access$000(this.this$0, this.val$pkg))
    {
      ((EmojiManagerServiceProxy)this.this$0.app.getRuntimeService(IEmojiManagerService.class)).stopEmoticonPackageDownload(((EmoticonPackage)localObject2).epId);
      this.val$clickBtn.setText(this.val$pkg.btnDesc);
      this.val$clickBtn.setProgress(0);
      if (this.val$isPayBack)
      {
        ReportController.b(this.this$0.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800581D", 0, 0, this.val$pkg.id, "", "", "");
        return;
      }
      ReportController.b(this.this$0.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8005817", 0, 0, this.val$pkg.id, "", "", "");
      return;
    }
    if (bool)
    {
      if (this.val$businessType == 1) {
        ((EmoticonHandlerProxy)this.this$0.app.getBusinessHandler(EmoticonHandler.a)).reportAddEmoticonPkg(((EmoticonPackage)localObject2).epId, this.val$businessType);
      } else if (((EmoticonPackage)localObject2).type != 4) {
        ((EmoticonHandlerProxy)this.this$0.app.getBusinessHandler(EmoticonHandler.a)).reportAddEmoticonPkg(((EmoticonPackage)localObject2).epId, this.val$businessType);
      }
      ((EmojiManagerServiceProxy)this.this$0.app.getRuntimeService(IEmojiManagerService.class)).pullEmoticonPackage((EmoticonPackage)localObject2, true, this.val$businessType);
      this.val$clickBtn.setText(this.this$0.mContext.getString(2131897752));
      paramEmoticonPackage = this.val$clickBtn;
      paramEmoticonPackage.setProgressDrawable(paramEmoticonPackage.a(-16745986));
      if (!this.val$isPayBack) {
        ReportController.b(this.this$0.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8005814", 0, 0, this.val$pkg.id, "", "", "");
      }
      localObject1 = this.this$0.app.getQQAppInterface();
      localObject2 = this.val$pkg.id;
      if (this.this$0.isRedWhenClickRecommend) {
        paramEmoticonPackage = "1";
      } else {
        paramEmoticonPackage = "";
      }
      ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "ep_mall", "0X8006139", 0, 0, (String)localObject2, paramEmoticonPackage, "", "");
      i = this.this$0.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
      j = this.this$0.data.indexOf(this.val$pkg);
      localObject1 = this.this$0.app.getCurrentUin();
      localObject2 = this.val$pkg.id;
      paramEmoticonPackage = new StringBuilder();
      paramEmoticonPackage.append(j + 1);
      paramEmoticonPackage.append("");
      localObject3 = paramEmoticonPackage.toString();
      if (this.this$0.isRedWhenClickRecommend) {
        paramEmoticonPackage = "1";
      } else {
        paramEmoticonPackage = "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      VasWebviewUtil.a((String)localObject1, "ep_mall", "0X8005814", "", 0, 0, 0, "", (String)localObject2, (String)localObject3, paramEmoticonPackage, "", localStringBuilder.toString(), "", 0, 0, 0, 0);
      return;
    }
    if (this.val$isPayBack) {
      return;
    }
    this.this$0.clickPayBtn = this.val$clickBtn;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("https://mc.vip.qq.com/qqwallet/index?aid=");
    ((StringBuilder)localObject2).append(paramEmoticonPackage);
    ((StringBuilder)localObject2).append("&type=");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk&debug=1");
    paramEmoticonPackage = ((StringBuilder)localObject2).toString();
    if ((this.this$0.mContext instanceof Activity))
    {
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("url", paramEmoticonPackage);
      RouteUtils.a((Activity)this.this$0.mContext, (Intent)localObject1, "/base/browser", 4779);
      if (QLog.isColorLevel())
      {
        paramEmoticonPackage = new StringBuilder();
        paramEmoticonPackage.append("func downloadOrPay. mCurPageIndex: epid = ");
        paramEmoticonPackage.append(this.val$pkg.id);
        QLog.d("RecommendEmotionAdapter", 2, paramEmoticonPackage.toString());
      }
      ReportController.b(this.this$0.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8005815", 0, 0, this.val$pkg.id, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter.2
 * JD-Core Version:    0.7.0.1
 */