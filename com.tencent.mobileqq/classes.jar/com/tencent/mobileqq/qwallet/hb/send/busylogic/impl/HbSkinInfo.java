package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import Wallet.SkinInfo;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfoBase;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HbSkinInfo
{
  public static boolean a = false;
  public static int c;
  public int a;
  public SkinInfo a;
  public RedPacketInfoBase a;
  public String a;
  public int b;
  public String b;
  
  public HbSkinInfo(SkinInfo paramSkinInfo)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_WalletSkinInfo = new SkinInfo();
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfoBase = new RedPacketInfoBase();
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramSkinInfo.skin_name;
    this.jdField_a_of_type_WalletSkinInfo = paramSkinInfo;
  }
  
  public HbSkinInfo(String paramString)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_WalletSkinInfo = new SkinInfo();
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfoBase = new RedPacketInfoBase();
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static int a(List<HbSkinInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      HbSkinInfo localHbSkinInfo = (HbSkinInfo)paramList.next();
      if (c == localHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_id) {
        return localHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_id;
      }
    }
    return -1;
  }
  
  public static void a(List<HbSkinInfo> paramList)
  {
    Collections.sort(paramList, new HbSkinInfo.1());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof HbSkinInfo)) {
      return this.jdField_a_of_type_WalletSkinInfo.skin_id == ((HbSkinInfo)paramObject).jdField_a_of_type_WalletSkinInfo.skin_id;
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("background : ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfoBase.background);
    localStringBuilder.append(" | ");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("icon : ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQwalletHbAioElemRedPacketInfoBase.icon);
    localStringBuilder.append(" | ");
    localStringBuffer.append(localStringBuilder.toString());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbSkinInfo
 * JD-Core Version:    0.7.0.1
 */