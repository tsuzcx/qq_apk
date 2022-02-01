package com.tencent.mobileqq.vip.lianghao.data;

import android.content.Intent;

public class LiangHaoPayFailData
{
  public LiangHaoUinData a;
  
  public LiangHaoPayFailData(Intent paramIntent)
  {
    this.a = new LiangHaoUinData(paramIntent.getStringExtra("lh_uin"), paramIntent.getStringExtra("lh_light"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.data.LiangHaoPayFailData
 * JD-Core Version:    0.7.0.1
 */