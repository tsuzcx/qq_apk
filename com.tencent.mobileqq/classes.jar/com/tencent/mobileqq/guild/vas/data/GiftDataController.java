package com.tencent.mobileqq.guild.vas.data;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.guild.vas.IGiftPanelAction;
import com.tencent.mobileqq.guild.vas.IGuildGiftPresenter;
import com.tencent.mobileqq.guild.vas.pbrequest.GetBalanceFromAdminRequestHandler;
import com.tencent.mobileqq.guild.vas.pbrequest.GetGiftListRequestHandler;
import com.tencent.mobileqq.guild.vas.pbrequest.SendChannelGiftRequestHandler;
import com.tencent.mobileqq.guild.vas.util.SharedPreferencesHelper;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GetGiftListRsp;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GroupGiftItem;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.SendGiftRsp;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.UniBalanceFromAdminRsp;
import java.util.Iterator;
import java.util.List;

public class GiftDataController
  implements IGiftDataController
{
  private GiftListData a = new GiftListData();
  private final IGuildGiftPresenter b;
  
  public GiftDataController(IGuildGiftPresenter paramIGuildGiftPresenter)
  {
    this.b = paramIGuildGiftPresenter;
  }
  
  private void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long paramLong4, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("GiftDataController", 1, "sendGift fail authKey is empty!");
      return;
    }
    SendChannelGiftRequestHandler.a().a(paramLong1, paramLong2, paramInt1, paramInt2, paramLong3, paramLong4, paramString, new GiftDataController.3(this));
  }
  
  private void a(giftList.GetGiftListRsp paramGetGiftListRsp)
  {
    if (paramGetGiftListRsp.GiftList.has())
    {
      paramGetGiftListRsp = paramGetGiftListRsp.GiftList.get().iterator();
      while (paramGetGiftListRsp.hasNext())
      {
        giftList.GroupGiftItem localGroupGiftItem = (giftList.GroupGiftItem)paramGetGiftListRsp.next();
        if (localGroupGiftItem.Thumbnail.has()) {
          URLDrawable.getDrawable(localGroupGiftItem.Thumbnail.get(), null);
        }
        if (localGroupGiftItem.BackgroundImage.has()) {
          URLDrawable.getDrawable(localGroupGiftItem.BackgroundImage.get(), null);
        }
      }
    }
  }
  
  private void a(String paramString, SharedPreferencesHelper paramSharedPreferencesHelper)
  {
    GetGiftListRequestHandler.a().a(paramString, this.a.c(), new GiftDataController.1(this, paramSharedPreferencesHelper, paramString));
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    giftList.UniBalanceFromAdminRsp localUniBalanceFromAdminRsp = new giftList.UniBalanceFromAdminRsp();
    try
    {
      localUniBalanceFromAdminRsp.mergeFrom(paramArrayOfByte);
      this.b.a(localUniBalanceFromAdminRsp.balance.get(), localUniBalanceFromAdminRsp.RechargeUrl.get());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  private void a(byte[] paramArrayOfByte, SharedPreferencesHelper paramSharedPreferencesHelper, String paramString)
  {
    giftList.GetGiftListRsp localGetGiftListRsp = new giftList.GetGiftListRsp();
    try
    {
      localGetGiftListRsp.mergeFrom(paramArrayOfByte);
      if ((!localGetGiftListRsp.AttachInfo.equals(this.a.c())) && (!TextUtils.isEmpty(this.a.c())))
      {
        if (this.a.a().size() == localGetGiftListRsp.Total.get()) {
          return;
        }
        this.a.a().addAll(localGetGiftListRsp.GiftList.get());
        localGetGiftListRsp.GiftList.set(this.a.a());
      }
      paramSharedPreferencesHelper.a(paramString, localGetGiftListRsp);
      this.a.a(localGetGiftListRsp);
      a(localGetGiftListRsp);
      c();
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    giftList.SendGiftRsp localSendGiftRsp = new giftList.SendGiftRsp();
    try
    {
      localSendGiftRsp.mergeFrom(paramArrayOfByte);
      int i = localSendGiftRsp.Ret.get();
      if (i != -9992)
      {
        if (i != 0)
        {
          this.b.c();
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("handleSendGiftError:");
          paramArrayOfByte.append(localSendGiftRsp.Ret.get());
          Log.e("GiftDataController", paramArrayOfByte.toString());
          return;
        }
        this.b.b();
        return;
      }
      this.b.f();
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  private void c()
  {
    this.b.a(this.a.a());
  }
  
  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("GiftDataController", 1, "getCoins fail authKey is empty!");
      return;
    }
    GetBalanceFromAdminRequestHandler.a().a(paramString, new GiftDataController.2(this));
  }
  
  public long a()
  {
    return this.a.d();
  }
  
  public List<giftList.GroupGiftItem> a(String paramString)
  {
    if (this.a.a().size() != 0) {
      return this.a.a();
    }
    giftList.GetGiftListRsp localGetGiftListRsp = SharedPreferencesHelper.a().b(paramString);
    this.a.a(localGetGiftListRsp);
    if (this.a.a().size() > 0) {
      return this.a.a();
    }
    c(paramString);
    return null;
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.b.d() != null)
    {
      IGiftPanelAction localIGiftPanelAction = this.b.d();
      a(localIGiftPanelAction.e(), paramLong, paramInt1, paramInt2, localIGiftPanelAction.b(), localIGiftPanelAction.f(), localIGiftPanelAction.a());
    }
  }
  
  public void b()
  {
    if (this.b.d() != null) {
      d(this.b.d().a());
    }
  }
  
  public void b(String paramString)
  {
    if ((this.a.a().size() != 0) && (!this.a.b())) {
      return;
    }
    a(paramString, SharedPreferencesHelper.a());
  }
  
  public void c(String paramString)
  {
    SharedPreferencesHelper localSharedPreferencesHelper = SharedPreferencesHelper.a();
    if (localSharedPreferencesHelper.a(paramString))
    {
      this.a.a("");
      a(paramString, localSharedPreferencesHelper);
      return;
    }
    paramString = localSharedPreferencesHelper.b(paramString);
    this.a.a(paramString);
    a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.data.GiftDataController
 * JD-Core Version:    0.7.0.1
 */