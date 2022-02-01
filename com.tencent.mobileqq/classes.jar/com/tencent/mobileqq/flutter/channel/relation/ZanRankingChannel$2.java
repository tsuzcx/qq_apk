package com.tencent.mobileqq.flutter.channel.relation;

import aunf;
import com.tencent.mobileqq.flutter.channel.model.CardCoverData;
import io.flutter.plugin.common.MethodChannel.Result;

public class ZanRankingChannel$2
  implements Runnable
{
  public ZanRankingChannel$2(aunf paramaunf, MethodChannel.Result paramResult, CardCoverData paramCardCoverData) {}
  
  public void run()
  {
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel$Result.success(CardCoverData.toMap(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelModelCardCoverData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.relation.ZanRankingChannel.2
 * JD-Core Version:    0.7.0.1
 */