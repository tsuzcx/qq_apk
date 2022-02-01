package com.tencent.mobileqq.flutter.channel.relation;

import com.tencent.mobileqq.flutter.channel.model.CardCoverData;
import io.flutter.plugin.common.MethodChannel.Result;

class ZanRankingChannel$2
  implements Runnable
{
  ZanRankingChannel$2(ZanRankingChannel paramZanRankingChannel, MethodChannel.Result paramResult, CardCoverData paramCardCoverData) {}
  
  public void run()
  {
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel$Result.success(CardCoverData.toMap(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelModelCardCoverData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.relation.ZanRankingChannel.2
 * JD-Core Version:    0.7.0.1
 */