package com.tencent.mobileqq.widget.share;

public class ShareActionSheetFactory
{
  public static ShareActionSheet create(ShareActionSheetV2.Param paramParam)
  {
    return new ShareActionSheetProxy(new ShareActionSheetImplV2(new ShareActionSheetV2(paramParam)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetFactory
 * JD-Core Version:    0.7.0.1
 */