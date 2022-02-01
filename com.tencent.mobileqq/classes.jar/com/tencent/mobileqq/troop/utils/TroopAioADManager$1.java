package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.inner.cmdGroupAdGetAdInfo.GetTroopAioTopAD.AdInfo;
import tencent.im.oidb.inner.cmdGroupAdGetAdInfo.GetTroopAioTopAD.ExtAdInfo;
import tencent.im.oidb.inner.cmdGroupAdGetAdInfo.GetTroopAioTopAD.RspBody;

class TroopAioADManager$1
  extends ProtoUtils.TroopProtocolObserver
{
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("GroupAd.GetAdInfo | oidb_sso errorCode ");
      paramBundle.append(paramInt);
      QLog.d("TroopAioADManager", 2, paramBundle.toString());
    }
    int i;
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      i = -1;
      paramBundle = new GetTroopAioTopAD.RspBody();
      try
      {
        paramArrayOfByte = (GetTroopAioTopAD.RspBody)paramBundle.mergeFrom(paramArrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("GroupAd.GetAdInfo | oidb_sso parseFrom byte: ");
          localStringBuilder.append(paramArrayOfByte.toString());
          QLog.d("TroopAioADManager", 2, localStringBuilder.toString());
        }
        paramArrayOfByte = paramBundle;
      }
      paramInt = i;
      if (paramArrayOfByte != null) {
        paramInt = i;
      }
    }
    try
    {
      if (paramArrayOfByte.uint32_res.has())
      {
        i = paramArrayOfByte.uint32_res.get();
        paramInt = i;
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("GroupAd.GetAdInfo | RspBody.uint32_res ");
          paramBundle.append(i);
          QLog.d("TroopAioADManager", 2, paramBundle.toString());
          paramInt = i;
        }
      }
      if (paramInt != 0) {
        break label757;
      }
      if (paramArrayOfByte.uint32_time_interval.has())
      {
        long l2 = paramArrayOfByte.uint32_time_interval.get();
        long l1 = l2;
        if (l2 * 1000L > System.currentTimeMillis() + 86400000L) {
          l1 = System.currentTimeMillis() / 1000L + 86400L;
        }
        paramBundle = this.b.a.getApp();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("TROOP_AIO_AD_MANAGER_CONFIG");
        localStringBuilder.append(this.b.a.getAccount());
        paramBundle.getSharedPreferences(localStringBuilder.toString(), 0).edit().putLong(this.a, l1);
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("GroupAd.GetAdInfo | RspBody.uint32_time_interval ");
          paramBundle.append(l1);
          QLog.d("TroopAioADManager", 2, paramBundle.toString());
        }
      }
      if (!paramArrayOfByte.rpt_ad_info.has()) {
        break label757;
      }
      paramArrayOfByte = paramArrayOfByte.rpt_ad_info.get();
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
        break label757;
      }
      paramBundle = (GetTroopAioTopAD.AdInfo)paramArrayOfByte.get(0);
      paramArrayOfByte = new TroopAioTopADInfo();
      paramArrayOfByte.troopUin = this.a;
      paramArrayOfByte.adId = paramBundle.uint32_ad_id.get();
      paramArrayOfByte.backgroundUrl = paramBundle.str_background_url.get();
      paramArrayOfByte.moreUrl = paramBundle.str_more_url.get();
      paramArrayOfByte.picUrl = paramBundle.str_pic_url.get();
      paramArrayOfByte.validTime = paramBundle.uint32_valid_interval.get();
      paramArrayOfByte.showType = paramBundle.ad_show_type.get();
      if (paramBundle.msg_ext_adinfo.has())
      {
        paramArrayOfByte.strWord = paramBundle.msg_ext_adinfo.str_word.get();
        paramArrayOfByte.uiUrl = paramBundle.msg_ext_adinfo.str_ui_url.get();
        paramArrayOfByte.jumpUrl = paramBundle.msg_ext_adinfo.str_jmp_url.get();
        if ((!QQStoryManager.o()) && (!TextUtils.isEmpty(paramArrayOfByte.jumpUrl)) && (paramArrayOfByte.jumpUrl.contains("qstory")))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          paramBundle = new StringBuilder();
          paramBundle.append("GroupAd.GetAdInfo当前系统api：");
          paramBundle.append(Build.VERSION.SDK_INT);
          paramBundle.append(",低于14 | adInfo: ");
          paramBundle.append(paramArrayOfByte.toString());
          QLog.d("TroopAioADManager", 2, paramBundle.toString());
          return;
        }
      }
      if ((System.currentTimeMillis() < paramArrayOfByte.validTime * 1000L) && (HttpUtil.isValidUrl(paramArrayOfByte.uiUrl)))
      {
        this.b.c.put(this.a, paramArrayOfByte);
        this.b.b.persistOrReplace(paramArrayOfByte);
        this.b.a();
      }
      if (!QLog.isColorLevel()) {
        break label757;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("GroupAd.GetAdInfo | adInfo: ");
      paramBundle.append(paramArrayOfByte.toString());
      QLog.d("TroopAioADManager", 2, paramBundle.toString());
      return;
    }
    catch (Exception paramBundle)
    {
      label716:
      break label716;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("GroupAd.GetAdInfo | Exception: ");
      paramArrayOfByte.append(paramBundle.toString());
      QLog.d("TroopAioADManager", 2, paramArrayOfByte.toString());
    }
    label757:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAioADManager.1
 * JD-Core Version:    0.7.0.1
 */