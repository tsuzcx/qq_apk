package com.tencent.mobileqq.richstatus;

import android.os.Bundle;
import android.text.TextUtils;
import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class StatusManager$3$1
  implements Runnable
{
  StatusManager$3$1(StatusManager.3 param3, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject3 = (FriendsManager)StatusManager.b(this.c.a).getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1;
    int i;
    Object localObject4;
    if (localObject3 != null)
    {
      localObject2 = ((FriendsManager)localObject3).x(StatusManager.b(this.c.a).getAccount());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = StatusManager.b(this.c.a).getAccount();
      }
      if (this.a)
      {
        i = this.b.getInt("k_source", 0);
        localObject2 = this.b.getByteArray("k_rspbody");
        if (localObject2 != null)
        {
          localObject2 = ByteBuffer.wrap((byte[])localObject2);
          ((ByteBuffer)localObject2).get();
          j = ((ByteBuffer)localObject2).getInt();
          localObject4 = new byte[((ByteBuffer)localObject2).getShort()];
          ((ByteBuffer)localObject2).get((byte[])localObject4);
          long l1 = ((ExtensionInfo)localObject1).timestamp;
          long l2 = j;
          if (l1 != l2)
          {
            ExtensionRichStatus.a((ExtensionInfo)localObject1, (byte[])localObject4, l2);
            localObject2 = ExtensionRichStatus.c((ExtensionInfo)localObject1);
            if ((i == 1) && (this.b.getInt("ret", 0) == 65535))
            {
              ((RichStatus)localObject2).fontId = 0;
              ((RichStatus)localObject2).fontType = 0;
            }
            else if (StatusManager.n(this.c.a) != null)
            {
              ((RichStatus)localObject2).fontId = StatusManager.n(this.c.a).fontId;
              ((RichStatus)localObject2).fontType = StatusManager.n(this.c.a).fontType;
              if ((StatusManager.n(this.c.a).mStickerInfos != null) && (StatusManager.n(this.c.a).mStickerInfos.size() > 0)) {
                ((RichStatus)localObject2).mStickerInfos = new ArrayList(StatusManager.n(this.c.a).mStickerInfos);
              }
            }
            ((FriendsManager)localObject3).a((ExtensionInfo)localObject1);
          }
        }
      }
      localObject2 = ExtensionRichStatus.c((ExtensionInfo)localObject1);
      localObject1 = localObject2;
      if (this.a)
      {
        if (((RichStatus)localObject2).tplId == 0) {
          localObject1 = "1";
        } else {
          localObject1 = "0";
        }
        ReportController.b(null, "CliOper", "", "", "signiture", "set_clk_save_succ", 0, 0, (String)localObject1, "", "", "");
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = new TipsInfo();
    localObject3 = this.b;
    if ((localObject3 != null) && (((Bundle)localObject3).getInt("k_source", 0) == 1)) {
      ((TipsInfo)localObject2).errorDesc = this.b.getString("errorDesc");
    }
    if (!this.a)
    {
      localObject3 = this.b;
      if (localObject3 != null)
      {
        i = ((Bundle)localObject3).getInt("k_auth_code", -1);
        j = this.b.getInt("cRet", 0);
        if (j == 2) {
          i = 103;
        } else if (j != 0) {
          i = j;
        }
        if ((TextUtils.isEmpty(((TipsInfo)localObject2).errorDesc)) && (this.b.containsKey("errorDesc"))) {
          ((TipsInfo)localObject2).errorDesc = this.b.getString("errorDesc");
        }
        boolean bool = this.b.getBoolean("valid");
        ((TipsInfo)localObject2).authAppid = this.b.getInt("authAppid");
        j = i;
        if (!bool) {
          break label874;
        }
        j = this.b.getInt("type", -1);
        localObject3 = this.b.getString("titleWording");
        localObject4 = this.b.getString("wording");
        String str1 = this.b.getString("rightBtnWording");
        String str2 = this.b.getString("leftBtnWording");
        String str3 = this.b.getString("vipType");
        int k = this.b.getInt("vipMonth");
        String str4 = this.b.getString("url");
        ((TipsInfo)localObject2).ret = this.b.getInt("ret");
        ((TipsInfo)localObject2).type = j;
        ((TipsInfo)localObject2).titleWording = ((String)localObject3);
        ((TipsInfo)localObject2).wording = ((String)localObject4);
        ((TipsInfo)localObject2).rightBtnWording = str1;
        ((TipsInfo)localObject2).leftBtnWording = str2;
        ((TipsInfo)localObject2).vipType = str3;
        ((TipsInfo)localObject2).vipMonth = k;
        ((TipsInfo)localObject2).url = str4;
        if (j != 1)
        {
          if (j != 2)
          {
            j = i;
            break label874;
          }
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            ((TipsInfo)localObject2).titleWording = HardCodeUtil.a(2131911697);
          }
          if (TextUtils.isEmpty(str2)) {
            ((TipsInfo)localObject2).leftBtnWording = HardCodeUtil.a(2131898212);
          }
          j = i;
          if (!TextUtils.isEmpty(str1)) {
            break label874;
          }
          ((TipsInfo)localObject2).rightBtnWording = HardCodeUtil.a(2131911700);
          j = i;
          break label874;
        }
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          ((TipsInfo)localObject2).titleWording = HardCodeUtil.a(2131911698);
        }
        if (TextUtils.isEmpty(str2)) {
          ((TipsInfo)localObject2).leftBtnWording = HardCodeUtil.a(2131898212);
        }
        j = i;
        if (!TextUtils.isEmpty(str1)) {
          break label874;
        }
        ((TipsInfo)localObject2).rightBtnWording = HardCodeUtil.a(2131911699);
        j = i;
        break label874;
      }
    }
    int j = 100;
    label874:
    StatusManager.a(this.c.a, null);
    ThreadManager.getUIHandler().post(new StatusManager.3.1.1(this, j, (RichStatus)localObject1, (TipsInfo)localObject2));
    VasFontIPCModule.a().a(j, (RichStatus)localObject1, (TipsInfo)localObject2, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3.1
 * JD-Core Version:    0.7.0.1
 */