package com.tencent.mobileqq.richmedia.capture.adapter;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

class PtvTemplateAdapter$2
  implements PtvTemplateManager.IPtvTemplateDownloadListener
{
  PtvTemplateAdapter$2(PtvTemplateAdapter paramPtvTemplateAdapter) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.runOnUiThread(new PtvTemplateAdapter.2.2(this, paramPtvTemplateInfo, paramInt));
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    if (this.a.a != null) {
      this.a.a.runOnUiThread(new PtvTemplateAdapter.2.1(this, paramPtvTemplateInfo, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateAdapter.2
 * JD-Core Version:    0.7.0.1
 */