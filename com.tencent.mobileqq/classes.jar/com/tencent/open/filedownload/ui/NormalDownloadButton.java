package com.tencent.open.filedownload.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.app.HardCodeUtil;

public class NormalDownloadButton
  extends ApkFileDownloadButton
{
  public NormalDownloadButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public NormalDownloadButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NormalDownloadButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected String a(int paramInt)
  {
    return HardCodeUtil.a(2131905421);
  }
  
  protected String b(int paramInt)
  {
    if (paramInt == 4) {
      return HardCodeUtil.a(2131905422);
    }
    return HardCodeUtil.a(2131905420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.filedownload.ui.NormalDownloadButton
 * JD-Core Version:    0.7.0.1
 */