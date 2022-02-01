package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.emoticon.IEmoticonPackage;
import com.tencent.mobileqq.emoticon.IFindEmotionPackageListener;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class RecommendEmotionAdapter$2
  implements IFindEmotionPackageListener
{
  RecommendEmotionAdapter$2(RecommendEmotionAdapter paramRecommendEmotionAdapter, PromotionEmoticonPkg paramPromotionEmoticonPkg, boolean paramBoolean, ProgressButton paramProgressButton, int paramInt) {}
  
  public void callBack(IEmoticonPackage paramIEmoticonPackage, boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new EmoticonPackage();
    ((EmoticonPackage)localObject).jobType = this.val$pkg.type;
    ((EmoticonPackage)localObject).epId = this.val$pkg.id;
    if ((paramIEmoticonPackage instanceof EmoticonPackage)) {}
    for (paramIEmoticonPackage = (EmoticonPackage)paramIEmoticonPackage;; paramIEmoticonPackage = (IEmoticonPackage)localObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "canDownload:" + paramBoolean + ",vipType:" + paramInt + ",isPayBack:" + this.val$isPayBack);
      }
      if (RecommendEmotionAdapter.access$000(this.this$0, this.val$pkg))
      {
        ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).stopEmoticonPackageDownload(this.this$0.app, paramIEmoticonPackage.epId);
        this.val$clickBtn.setText(this.val$pkg.btnDesc);
        this.val$clickBtn.setProgress(0);
        if (this.val$isPayBack) {
          ReportController.b(this.this$0.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800581D", 0, 0, this.val$pkg.id, "", "", "");
        }
      }
      label442:
      do
      {
        do
        {
          return;
          ReportController.b(this.this$0.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8005817", 0, 0, this.val$pkg.id, "", "", "");
          return;
          if (paramBoolean)
          {
            String str;
            if (((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).isKanDianBusiness(this.val$businessType))
            {
              ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).reportAddEmoticonPkg(this.this$0.app, paramIEmoticonPackage.epId, this.val$businessType);
              ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).pullEmoticonPackage(this.this$0.app, paramIEmoticonPackage, true, this.val$businessType);
              this.val$clickBtn.setText(this.this$0.mContext.getString(2131699611));
              this.val$clickBtn.setProgressDrawable(this.val$clickBtn.a(-16745986));
              if (!this.val$isPayBack) {
                ReportController.b(this.this$0.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8005814", 0, 0, this.val$pkg.id, "", "", "");
              }
              paramString1 = this.this$0.app.getQQAppInterface();
              paramString2 = this.val$pkg.id;
              if (!this.this$0.isRedWhenClickRecommend) {
                break label672;
              }
              paramIEmoticonPackage = "1";
              ReportController.b(paramString1, "CliOper", "", "", "ep_mall", "0X8006139", 0, 0, paramString2, paramIEmoticonPackage, "", "");
              paramInt = this.this$0.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
              int i = this.this$0.data.indexOf(this.val$pkg);
              paramString1 = (IBigEmotionService)QRoute.api(IBigEmotionService.class);
              paramString2 = this.this$0.app.getCurrentUin();
              localObject = this.val$pkg.id;
              str = i + 1 + "";
              if (!this.this$0.isRedWhenClickRecommend) {
                break label678;
              }
            }
            for (paramIEmoticonPackage = "1";; paramIEmoticonPackage = "")
            {
              paramString1.reportCommercialDrainage(paramString2, "ep_mall", "0X8005814", "", 0, 0, 0, "", (String)localObject, str, paramIEmoticonPackage, "", paramInt + "", "", 0, 0, 0, 0);
              return;
              if (paramIEmoticonPackage.type == 4) {
                break;
              }
              ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).reportAddEmoticonPkg(this.this$0.app, paramIEmoticonPackage.epId, this.val$businessType);
              break;
              paramIEmoticonPackage = "";
              break label442;
            }
          }
        } while (this.val$isPayBack);
        this.this$0.clickPayBtn = this.val$clickBtn;
        paramIEmoticonPackage = "https://mc.vip.qq.com/qqwallet/index?aid=" + paramString2 + "&type=" + paramString1 + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk&debug=1";
      } while (!(this.this$0.mContext instanceof Activity));
      label672:
      label678:
      ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).startActivityForResult((Activity)this.this$0.mContext, paramIEmoticonPackage, 4779);
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "func downloadOrPay. mCurPageIndex: epid = " + this.val$pkg.id);
      }
      ReportController.b(this.this$0.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8005815", 0, 0, this.val$pkg.id, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter.2
 * JD-Core Version:    0.7.0.1
 */