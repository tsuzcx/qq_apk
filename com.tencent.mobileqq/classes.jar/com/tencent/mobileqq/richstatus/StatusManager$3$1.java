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
    Object localObject1;
    int i;
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
          long l1 = ((ExtensionInfo)localObject1).timestamp;
          long l2 = j;
          if (l1 != l2)
          {
            ExtensionRichStatus.a((ExtensionInfo)localObject1, (byte[])localObject4, l2);
            localObject2 = ExtensionRichStatus.a((ExtensionInfo)localObject1);
            if ((i == 1) && (this.jdField_a_of_type_AndroidOsBundle.getInt("ret", 0) == 65535))
            {
              ((RichStatus)localObject2).fontId = 0;
              ((RichStatus)localObject2).fontType = 0;
            }
            else if (StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a) != null)
            {
              ((RichStatus)localObject2).fontId = StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a).fontId;
              ((RichStatus)localObject2).fontType = StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a).fontType;
              if ((StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a).mStickerInfos != null) && (StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a).mStickerInfos.size() > 0)) {
                ((RichStatus)localObject2).mStickerInfos = new ArrayList(StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a).mStickerInfos);
              }
            }
            ((FriendsManager)localObject3).a((ExtensionInfo)localObject1);
          }
        }
      }
      localObject2 = ExtensionRichStatus.a((ExtensionInfo)localObject1);
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Boolean)
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
    localObject3 = this.jdField_a_of_type_AndroidOsBundle;
    if ((localObject3 != null) && (((Bundle)localObject3).getInt("k_source", 0) == 1)) {
      ((TipsInfo)localObject2).errorDesc = this.jdField_a_of_type_AndroidOsBundle.getString("errorDesc");
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject3 = this.jdField_a_of_type_AndroidOsBundle;
      if (localObject3 != null)
      {
        i = ((Bundle)localObject3).getInt("k_auth_code", -1);
        j = this.jdField_a_of_type_AndroidOsBundle.getInt("cRet", 0);
        if (j == 2) {
          i = 103;
        } else if (j != 0) {
          i = j;
        }
        if ((TextUtils.isEmpty(((TipsInfo)localObject2).errorDesc)) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("errorDesc"))) {
          ((TipsInfo)localObject2).errorDesc = this.jdField_a_of_type_AndroidOsBundle.getString("errorDesc");
        }
        boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("valid");
        ((TipsInfo)localObject2).authAppid = this.jdField_a_of_type_AndroidOsBundle.getInt("authAppid");
        j = i;
        if (!bool) {
          break label874;
        }
        j = this.jdField_a_of_type_AndroidOsBundle.getInt("type", -1);
        localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("titleWording");
        localObject4 = this.jdField_a_of_type_AndroidOsBundle.getString("wording");
        String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("rightBtnWording");
        String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("leftBtnWording");
        String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("vipType");
        int k = this.jdField_a_of_type_AndroidOsBundle.getInt("vipMonth");
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
        if (j != 1)
        {
          if (j != 2)
          {
            j = i;
            break label874;
          }
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            ((TipsInfo)localObject2).titleWording = HardCodeUtil.a(2131714170);
          }
          if (TextUtils.isEmpty(str2)) {
            ((TipsInfo)localObject2).leftBtnWording = HardCodeUtil.a(2131714172);
          }
          j = i;
          if (!TextUtils.isEmpty(str1)) {
            break label874;
          }
          ((TipsInfo)localObject2).rightBtnWording = HardCodeUtil.a(2131714174);
          j = i;
          break label874;
        }
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          ((TipsInfo)localObject2).titleWording = HardCodeUtil.a(2131714171);
        }
        if (TextUtils.isEmpty(str2)) {
          ((TipsInfo)localObject2).leftBtnWording = HardCodeUtil.a(2131714169);
        }
        j = i;
        if (!TextUtils.isEmpty(str1)) {
          break label874;
        }
        ((TipsInfo)localObject2).rightBtnWording = HardCodeUtil.a(2131714173);
        j = i;
        break label874;
      }
    }
    int j = 100;
    label874:
    StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a, null);
    ThreadManager.getUIHandler().post(new StatusManager.3.1.1(this, j, (RichStatus)localObject1, (TipsInfo)localObject2));
    VasFontIPCModule.a().a(j, (RichStatus)localObject1, (TipsInfo)localObject2, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3.1
 * JD-Core Version:    0.7.0.1
 */