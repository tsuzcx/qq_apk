package com.tencent.mobileqq.widget.share;

import beyu;
import beyv;

public class ShareActionSheetFactory
{
  public static ShareActionSheet create(ShareActionSheetV2.Param paramParam)
  {
    return new beyv(new beyu(new ShareActionSheetV2(paramParam)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetFactory
 * JD-Core Version:    0.7.0.1
 */