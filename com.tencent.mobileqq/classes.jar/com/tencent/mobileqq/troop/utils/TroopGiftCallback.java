package com.tencent.mobileqq.troop.utils;

import android.util.SparseArray;
import com.tencent.biz.troopgift.TroopGiftAioPanelData.EmptyPackagePage;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import java.util.List;
import tencent.im.oidb.cmd0x962.oidb_0x962.RspBody;

public abstract class TroopGiftCallback
{
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, List<TroopGiftManager.GiveGift> paramList) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, oidb_0x962.RspBody paramRspBody) {}
  
  public void a(long paramLong) {}
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(SparseArray<TroopGiftManager.ShowPicPrice> paramSparseArray) {}
  
  public void a(TroopGiftBagInfo paramTroopGiftBagInfo) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString1, int paramInt, String paramString2) {}
  
  public void a(List<TroopGiftManager.PackGift> paramList, TroopGiftAioPanelData.EmptyPackagePage paramEmptyPackagePage) {}
  
  public void a(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3) {}
  
  public void b(int paramInt) {}
  
  public void b(int paramInt, String paramString) {}
  
  public void c(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGiftCallback
 * JD-Core Version:    0.7.0.1
 */