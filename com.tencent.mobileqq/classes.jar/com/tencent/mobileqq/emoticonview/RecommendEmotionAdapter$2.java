package com.tencent.mobileqq.emoticonview;

import amrg;
import amtj;
import anaj;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import areb;
import avtb;
import bcef;
import bgcz;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

class RecommendEmotionAdapter$2
  implements avtb<EmoticonPackage>
{
  RecommendEmotionAdapter$2(RecommendEmotionAdapter paramRecommendEmotionAdapter, bgcz parambgcz, boolean paramBoolean, areb paramareb, ProgressButton paramProgressButton, int paramInt) {}
  
  public void postQuery(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool = false;
    int i = ((anaj)this.this$0.app.getBusinessHandler(13)).g();
    Object localObject2 = "vip";
    Object localObject1 = "";
    Object localObject3;
    if (this.val$pkg.n == 4)
    {
      localObject1 = "mvip.g.a.bq_" + this.val$pkg.a;
      if (this.val$pkg.o != 4) {
        break label376;
      }
      localObject3 = "!vip";
      if (i != 1)
      {
        localObject2 = localObject3;
        if (i != 3) {}
      }
      else
      {
        bool = true;
        localObject2 = localObject3;
      }
      label104:
      localObject3 = new EmoticonPackage();
      ((EmoticonPackage)localObject3).jobType = this.val$pkg.n;
      ((EmoticonPackage)localObject3).epId = this.val$pkg.a;
      if (paramEmoticonPackage == null) {
        break label1004;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "canDownload:" + bool + ",vipType:" + i + ",isPayBack:" + this.val$isPayBack);
      }
      if (RecommendEmotionAdapter.access$000(this.this$0, this.val$pkg))
      {
        this.val$pcm.a(paramEmoticonPackage.epId);
        this.val$clickBtn.setText(this.val$pkg.d);
        this.val$clickBtn.setProgress(0);
        if (this.val$isPayBack) {
          bcef.b(this.this$0.app, "CliOper", "", "", "ep_mall", "0X800581D", 0, 0, this.val$pkg.a, "", "", "");
        }
      }
      label376:
      do
      {
        do
        {
          return;
          if (this.val$pkg.n == 0)
          {
            localObject1 = "mvip.g.a.bq_" + this.val$pkg.a;
            break;
          }
          if ((this.val$pkg.n != 3) && (this.val$pkg.n != 5)) {
            break;
          }
          localObject1 = "mvip.g.a.bq_mg_" + this.val$pkg.a;
          break;
          if (this.val$pkg.o == 5)
          {
            localObject3 = "!svip";
            localObject2 = localObject3;
            if (i != 3) {
              break label104;
            }
            bool = true;
            localObject2 = localObject3;
            break label104;
          }
          bool = true;
          break label104;
          bcef.b(this.this$0.app, "CliOper", "", "", "ep_mall", "0X8005817", 0, 0, this.val$pkg.a, "", "", "");
          return;
          if (bool)
          {
            localObject1 = (amrg)this.this$0.app.getBusinessHandler(12);
            if (this.val$businessType == 1)
            {
              ((amrg)localObject1).a(paramEmoticonPackage.epId, this.val$businessType);
              this.val$pcm.a(paramEmoticonPackage, true, this.val$businessType);
              this.val$clickBtn.setText(amtj.a(2131712376));
              this.val$clickBtn.setProgressDrawable(this.val$clickBtn.a(-16745986));
              if (!this.val$isPayBack) {
                bcef.b(this.this$0.app, "CliOper", "", "", "ep_mall", "0X8005814", 0, 0, this.val$pkg.a, "", "", "");
              }
              localObject1 = this.this$0.app;
              localObject2 = this.val$pkg.a;
              if (!this.this$0.isRedWhenClickRecommend) {
                break label805;
              }
              paramEmoticonPackage = "1";
              bcef.b((QQAppInterface)localObject1, "CliOper", "", "", "ep_mall", "0X8006139", 0, 0, (String)localObject2, paramEmoticonPackage, "", "");
              i = this.this$0.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
              int j = this.this$0.data.indexOf(this.val$pkg);
              localObject1 = this.this$0.app.getCurrentUin();
              localObject2 = this.val$pkg.a;
              localObject3 = j + 1 + "";
              if (!this.this$0.isRedWhenClickRecommend) {
                break label811;
              }
            }
            for (paramEmoticonPackage = "1";; paramEmoticonPackage = "")
            {
              VasWebviewUtil.reportCommercialDrainage((String)localObject1, "ep_mall", "0X8005814", "", 0, 0, 0, "", (String)localObject2, (String)localObject3, paramEmoticonPackage, "", i + "", "", 0, 0, 0, 0);
              return;
              if (paramEmoticonPackage.type == 4) {
                break;
              }
              ((amrg)localObject1).a(paramEmoticonPackage.epId, this.val$businessType);
              break;
              paramEmoticonPackage = "";
              break label609;
            }
          }
        } while (this.val$isPayBack);
        this.this$0.clickPayBtn = this.val$clickBtn;
        paramEmoticonPackage = "https://mc.vip.qq.com/qqwallet/index?aid=" + (String)localObject1 + "&type=" + (String)localObject2 + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk&debug=1";
        localObject1 = new Intent(this.this$0.mContext, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramEmoticonPackage);
      } while (!(this.this$0.mContext instanceof Activity));
      label609:
      ((Activity)this.this$0.mContext).startActivityForResult((Intent)localObject1, 4779);
      label805:
      label811:
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "func downloadOrPay. mCurPageIndex: epid = " + this.val$pkg.a);
      }
      bcef.b(this.this$0.app, "CliOper", "", "", "ep_mall", "0X8005815", 0, 0, this.val$pkg.a, "", "", "");
      return;
      label1004:
      paramEmoticonPackage = (EmoticonPackage)localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter.2
 * JD-Core Version:    0.7.0.1
 */