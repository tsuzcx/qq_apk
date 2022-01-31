package com.tencent.mobileqq.richstatus;

import ajjj;
import ajjy;
import android.os.Bundle;
import android.text.TextUtils;
import avev;
import avey;
import awqx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import gf;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class StatusManager$3$1
  implements Runnable
{
  public StatusManager$3$1(avey paramavey, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject3 = (ajjj)avev.a(this.jdField_a_of_type_Avey.a).getManager(51);
    Object localObject2;
    int i;
    int j;
    Object localObject4;
    if (localObject3 != null)
    {
      localObject2 = ((ajjj)localObject3).a(avev.a(this.jdField_a_of_type_Avey.a).getAccount());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = avev.a(this.jdField_a_of_type_Avey.a).getAccount();
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
            ((ExtensionInfo)localObject1).setRichBuffer((byte[])localObject4, j);
            localObject2 = ((ExtensionInfo)localObject1).getRichStatus();
            if ((i != 1) || (this.jdField_a_of_type_AndroidOsBundle.getInt("ret", 0) != 65535)) {
              break label659;
            }
            ((RichStatus)localObject2).fontId = 0;
            ((RichStatus)localObject2).fontType = 0;
            ((ajjj)localObject3).a((ExtensionInfo)localObject1);
          }
        }
      }
      localObject2 = ((ExtensionInfo)localObject1).getRichStatus();
      if (this.jdField_a_of_type_Boolean)
      {
        if (((RichStatus)localObject2).tplId != 0) {
          break label771;
        }
        localObject1 = "1";
        label243:
        awqx.b(null, "CliOper", "", "", "signiture", "set_clk_save_succ", 0, 0, (String)localObject1, "", "", "");
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
      label366:
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
            break label778;
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
        avev.a(this.jdField_a_of_type_Avey.a, null);
        ThreadManager.getUIHandler().post(new StatusManager.3.1.1(this, j, (RichStatus)localObject1, (TipsInfo)localObject2));
        gf.a().a(j, (RichStatus)localObject1, (TipsInfo)localObject2, 0);
        return;
        label659:
        if (avev.a(this.jdField_a_of_type_Avey.a) == null) {
          break;
        }
        ((RichStatus)localObject2).fontId = avev.a(this.jdField_a_of_type_Avey.a).fontId;
        ((RichStatus)localObject2).fontType = avev.a(this.jdField_a_of_type_Avey.a).fontType;
        if ((avev.a(this.jdField_a_of_type_Avey.a).mStickerInfos == null) || (avev.a(this.jdField_a_of_type_Avey.a).mStickerInfos.size() <= 0)) {
          break;
        }
        ((RichStatus)localObject2).mStickerInfos = new ArrayList(avev.a(this.jdField_a_of_type_Avey.a).mStickerInfos);
        break;
        label771:
        localObject1 = "0";
        break label243;
        label778:
        i = k;
        if (k != 0) {
          break label366;
        }
        i = j;
        break label366;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          ((TipsInfo)localObject2).titleWording = ajjy.a(2131648573);
        }
        if (TextUtils.isEmpty(str2)) {
          ((TipsInfo)localObject2).leftBtnWording = ajjy.a(2131648571);
        }
        j = i;
        if (TextUtils.isEmpty(str1))
        {
          ((TipsInfo)localObject2).rightBtnWording = ajjy.a(2131648575);
          j = i;
          continue;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            ((TipsInfo)localObject2).titleWording = ajjy.a(2131648572);
          }
          if (TextUtils.isEmpty(str2)) {
            ((TipsInfo)localObject2).leftBtnWording = ajjy.a(2131648574);
          }
          j = i;
          if (TextUtils.isEmpty(str1))
          {
            ((TipsInfo)localObject2).rightBtnWording = ajjy.a(2131648576);
            j = i;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3.1
 * JD-Core Version:    0.7.0.1
 */