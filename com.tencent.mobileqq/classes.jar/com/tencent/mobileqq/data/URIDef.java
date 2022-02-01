package com.tencent.mobileqq.data;

import android.net.Uri;

abstract interface URIDef
{
  public static final Uri a = Uri.parse("content://qqlite");
  public static final Uri b = Uri.parse("content://qqlite/external/friendlist");
  public static final Uri c = Uri.parse("content://qqlite/external/historylist");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.URIDef
 * JD-Core Version:    0.7.0.1
 */