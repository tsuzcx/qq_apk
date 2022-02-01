package com.tencent.mobileqq.vas.troopnick.shop.widget;

import QC.ItemDisDetail;
import org.jetbrains.annotations.NotNull;

final class ShopAdapter$DataItem
{
  public final String a;
  public final int b;
  public final String c;
  public final boolean d;
  public final int e;
  public final int f;
  public final int g;
  public final String h;
  public final String i;
  public final String j;
  
  public ShopAdapter$DataItem(ShopAdapter paramShopAdapter, int paramInt, String paramString1, String paramString2)
  {
    this.b = paramInt;
    this.a = paramString1;
    this.c = paramString2;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = "";
    this.i = "";
    this.j = "";
    this.d = false;
  }
  
  public ShopAdapter$DataItem(ShopAdapter paramShopAdapter, int paramInt, String paramString1, String paramString2, @NotNull ItemDisDetail paramItemDisDetail)
  {
    this.b = paramInt;
    this.a = paramString1;
    this.c = paramString2;
    this.e = paramItemDisDetail.itemId;
    this.f = paramItemDisDetail.appId;
    this.g = paramItemDisDetail.feeType;
    this.h = paramItemDisDetail.image;
    this.i = paramItemDisDetail.itemBgColor;
    this.j = paramItemDisDetail.name;
    boolean bool;
    if (paramItemDisDetail.isSetup != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.d = bool;
  }
  
  public boolean a()
  {
    return this.b == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.widget.ShopAdapter.DataItem
 * JD-Core Version:    0.7.0.1
 */