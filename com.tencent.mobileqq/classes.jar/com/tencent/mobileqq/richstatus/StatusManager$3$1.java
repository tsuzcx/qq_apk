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
    Object localObject3 = (FriendsManager)StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a).getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2;
    int i;
    int j;
    Object localObject4;
    if (localObject3 != null)
    {
      localObject2 = ((FriendsManager)localObject3).a(StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a).getAccount());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a).getAccount();
      }
      if (this.jdField_a_of_type_Boolean)
      {
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("k_source", 0);
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getByteArray("k_rspbody");
        if (localObject2 != null)
        {
          localObject2 = ByteBuffer.wrap((byte[])localObject2);
          ((ByteBuffer)localObject2).get();
          j = ((ByteBuffer)localObject2).getInt();
          localObject4 = new byte[((ByteBuffer)localObject2).getShort()];
          ((ByteBuffer)localObject2).get((byte[])localObject4);
          if (((ExtensionInfo)localObject1).timestamp != j)
          {
            ExtensionRichStatus.a((ExtensionInfo)localObject1, (byte[])localObject4, j);
            localObject2 = ExtensionRichStatus.a((ExtensionInfo)localObject1);
            if ((i != 1) || (this.jdField_a_of_type_AndroidOsBundle.getInt("ret", 0) != 65535)) {
              break label663;
            }
            ((RichStatus)localObject2).fontId = 0;
            ((RichStatus)localObject2).fontType = 0;
            ((FriendsManager)localObject3).a((ExtensionInfo)localObject1);
          }
        }
      }
      localObject2 = ExtensionRichStatus.a((ExtensionInfo)localObject1);
      if (this.jdField_a_of_type_Boolean)
      {
        if (((RichStatus)localObject2).tplId != 0) {
          break label775;
        }
        localObject1 = "1";
        label244:
        ReportController.b(null, "CliOper", "", "", "signiture", "set_clk_save_succ", 0, 0, (String)localObject1, "", "", "");
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      i = 100;
      localObject2 = new TipsInfo();
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.getInt("k_source", 0) == 1)) {
        ((TipsInfo)localObject2).errorDesc = this.jdField_a_of_type_AndroidOsBundle.getString("errorDesc");
      }
      j = i;
      int k;
      label367:
      String str1;
      String str2;
      if (!this.jdField_a_of_type_Boolean)
      {
        j = i;
        if (this.jdField_a_of_type_AndroidOsBundle != null)
        {
          j = this.jdField_a_of_type_AndroidOsBundle.getInt("k_auth_code", -1);
          k = this.jdField_a_of_type_AndroidOsBundle.getInt("cRet", 0);
          if (k != 2) {
            break label782;
          }
          i = 103;
          if ((TextUtils.isEmpty(((TipsInfo)localObject2).errorDesc)) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("errorDesc"))) {
            ((TipsInfo)localObject2).errorDesc = this.jdField_a_of_type_AndroidOsBundle.getString("errorDesc");
          }
          boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("valid");
          ((TipsInfo)localObject2).authAppid = this.jdField_a_of_type_AndroidOsBundle.getInt("authAppid");
          j = i;
          if (bool)
          {
            j = this.jdField_a_of_type_AndroidOsBundle.getInt("type", -1);
            localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("titleWording");
            localObject4 = this.jdField_a_of_type_AndroidOsBundle.getString("wording");
            str1 = this.jdField_a_of_type_AndroidOsBundle.getString("rightBtnWording");
            str2 = this.jdField_a_of_type_AndroidOsBundle.getString("leftBtnWording");
            String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("vipType");
            k = this.jdField_a_of_type_AndroidOsBundle.getInt("vipMonth");
            String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("url");
            ((TipsInfo)localObject2).ret = this.jdField_a_of_type_AndroidOsBundle.getInt("ret");
            ((TipsInfo)localObject2).type = j;
            ((TipsInfo)localObject2).titleWording = ((String)localObject3);
            ((TipsInfo)localObject2).wording = ((String)localObject4);
            ((TipsInfo)localObject2).rightBtnWording = str1;
            ((TipsInfo)localObject2).leftBtnWording = str2;
            ((TipsInfo)localObject2).vipType = str3;
            ((TipsInfo)localObject2).vipMonth = k;
            ((TipsInfo)localObject2).url = str4;
            switch (j)
            {
            default: 
              j = i;
            }
          }
        }
      }
      for (;;)
      {
        StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a, null);
        ThreadManager.getUIHandler().post(new StatusManager.3.1.1(this, j, (RichStatus)localObject1, (TipsInfo)localObject2));
        VasFontIPCModule.a().a(j, (RichStatus)localObject1, (TipsInfo)localObject2, 0);
        return;
        label663:
        if (StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a) == null) {
          break;
        }
        ((RichStatus)localObject2).fontId = StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a).fontId;
        ((RichStatus)localObject2).fontType = StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a).fontType;
        if ((StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a).mStickerInfos == null) || (StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a).mStickerInfos.size() <= 0)) {
          break;
        }
        ((RichStatus)localObject2).mStickerInfos = new ArrayList(StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a).mStickerInfos);
        break;
        label775:
        localObject1 = "0";
        break label244;
        label782:
        i = k;
        if (k != 0) {
          break label367;
        }
        i = j;
        break label367;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          ((TipsInfo)localObject2).titleWording = HardCodeUtil.a(2131714242);
        }
        if (TextUtils.isEmpty(str2)) {
          ((TipsInfo)localObject2).leftBtnWording = HardCodeUtil.a(2131714240);
        }
        j = i;
        if (TextUtils.isEmpty(str1))
        {
          ((TipsInfo)localObject2).rightBtnWording = HardCodeUtil.a(2131714244);
          j = i;
          continue;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            ((TipsInfo)localObject2).titleWording = HardCodeUtil.a(2131714241);
          }
          if (TextUtils.isEmpty(str2)) {
            ((TipsInfo)localObject2).leftBtnWording = HardCodeUtil.a(2131714243);
          }
          j = i;
          if (TextUtils.isEmpty(str1))
          {
            ((TipsInfo)localObject2).rightBtnWording = HardCodeUtil.a(2131714245);
            j = i;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3.1
 * JD-Core Version:    0.7.0.1
 */