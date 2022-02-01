package com.tencent.mobileqq.kandian.biz.message.activity;

import android.text.TextUtils;
import java.util.Comparator;

class ReadinjoySubscriptManagerActivity$1
  implements Comparator<ReadinjoySubscriptManagerActivity.SubscribeFeedData>
{
  ReadinjoySubscriptManagerActivity$1(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  public int a(ReadinjoySubscriptManagerActivity.SubscribeFeedData paramSubscribeFeedData1, ReadinjoySubscriptManagerActivity.SubscribeFeedData paramSubscribeFeedData2)
  {
    boolean bool = TextUtils.isEmpty(ReadinjoySubscriptManagerActivity.SubscribeFeedData.a(paramSubscribeFeedData1));
    int j = 2147483647;
    int i;
    if (bool) {
      i = 2147483647;
    } else {
      i = ReadinjoySubscriptManagerActivity.SubscribeFeedData.a(paramSubscribeFeedData1).codePointAt(0);
    }
    if (!TextUtils.isEmpty(ReadinjoySubscriptManagerActivity.SubscribeFeedData.a(paramSubscribeFeedData2))) {
      j = ReadinjoySubscriptManagerActivity.SubscribeFeedData.a(paramSubscribeFeedData2).codePointAt(0);
    }
    return i - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.activity.ReadinjoySubscriptManagerActivity.1
 * JD-Core Version:    0.7.0.1
 */