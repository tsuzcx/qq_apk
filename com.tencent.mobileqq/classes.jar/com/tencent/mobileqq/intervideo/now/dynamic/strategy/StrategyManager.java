package com.tencent.mobileqq.intervideo.now.dynamic.strategy;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.lite_now_biz.config.NowBizConfigManager;

public class StrategyManager
{
  private NowBizConfigManager jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizConfigNowBizConfigManager;
  private IEnterRoomStrategy jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy;
  private KanDianStrategy jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyKanDianStrategy;
  private NowDefaultStrategy jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyNowDefaultStrategy;
  private NowLiteStrategy jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyNowLiteStrategy;
  
  private IEnterRoomStrategy a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyNowDefaultStrategy == null) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyNowDefaultStrategy = new NowDefaultStrategy();
    }
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyNowDefaultStrategy;
  }
  
  private IEnterRoomStrategy a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyKanDianStrategy == null) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyKanDianStrategy = new KanDianStrategy(paramQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyKanDianStrategy;
  }
  
  public static StrategyManager a()
  {
    return StrategyManager.HOLDER.a();
  }
  
  private boolean a(Bundle paramBundle)
  {
    if ("1014".equals(paramBundle.getString("appid"))) {
      return true;
    }
    paramBundle = paramBundle.getString("fromid");
    if (TextUtils.isEmpty(paramBundle)) {
      return false;
    }
    String str = paramBundle.toLowerCase();
    paramBundle = str;
    if (str.startsWith("share_msg_")) {
      paramBundle = str.substring(10);
    }
    if (!paramBundle.startsWith("kandian_")) {
      return (paramBundle.compareTo("3000") >= 0) && (paramBundle.compareTo("5999") <= 0);
    }
    return true;
  }
  
  private IEnterRoomStrategy b(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyNowLiteStrategy == null) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyNowLiteStrategy = new NowLiteStrategy(paramQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyNowLiteStrategy;
  }
  
  private boolean b(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizConfigNowBizConfigManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizConfigNowBizConfigManager = NowBizConfigManager.a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizConfigNowBizConfigManager.a(paramBundle);
  }
  
  public IEnterRoomStrategy a(Bundle paramBundle, QQAppInterface paramQQAppInterface)
  {
    if (a(paramBundle)) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy = a(paramQQAppInterface);
    } else if (b(paramBundle)) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy = b(paramQQAppInterface);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy = a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyKanDianStrategy = null;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyNowLiteStrategy = null;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyNowDefaultStrategy = null;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizConfigNowBizConfigManager = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.strategy.StrategyManager
 * JD-Core Version:    0.7.0.1
 */