package com.tencent.mobileqq.wink.api.impl;

import com.tencent.mobileqq.wink.api.IWinkExport;
import com.tencent.mobileqq.wink.editor.export.WinkExportManager;

public class WinkExportImpl
  implements IWinkExport
{
  public void requestGenerateVideo(String paramString)
  {
    WinkExportManager.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.api.impl.WinkExportImpl
 * JD-Core Version:    0.7.0.1
 */