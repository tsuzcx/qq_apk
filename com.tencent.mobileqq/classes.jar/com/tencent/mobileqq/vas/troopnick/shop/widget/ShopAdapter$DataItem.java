package com.tencent.mobileqq.vas.troopnick.shop.widget;

import QC.ItemDisDetail;
import org.jetbrains.annotations.NotNull;

final class ShopAdapter$DataItem
{
  public final int a;
  public final String a;
  public final boolean a;
  public final int b;
  public final String b;
  public final int c;
  public final String c;
  public final int d;
  public final String d;
  public final String e;
  
  public ShopAdapter$DataItem(ShopAdapter paramShopAdapter, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.e = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public ShopAdapter$DataItem(ShopAdapter paramShopAdapter, int paramInt, String paramString1, String paramString2, @NotNull ItemDisDetail paramItemDisDetail)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramItemDisDetail.itemId;
    this.jdField_c_of_type_Int = paramItemDisDetail.appId;
    this.jdField_d_of_type_Int = paramItemDisDetail.feeType;
    this.jdField_c_of_type_JavaLangString = paramItemDisDetail.image;
    this.jdField_d_of_type_JavaLangString = paramItemDisDetail.itemBgColor;
    this.e = paramItemDisDetail.name;
    if (paramItemDisDetail.isSetup != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.widget.ShopAdapter.DataItem
 * JD-Core Version:    0.7.0.1
 */