package com.tencent.mobileqq.soload.config;

class SoConfigManager$2
  implements SoLoaderConfProcessor.OnGetConfigListener
{
  SoConfigManager$2(SoConfigManager paramSoConfigManager, SoConfigManager.OnGetSoInfoListener paramOnGetSoInfoListener, String paramString) {}
  
  public void a(int paramInt)
  {
    SoConfigManager.OnGetSoInfoListener localOnGetSoInfoListener = this.a;
    if (localOnGetSoInfoListener != null) {
      localOnGetSoInfoListener.a(paramInt, SoConfigManager.a(this.c, this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.config.SoConfigManager.2
 * JD-Core Version:    0.7.0.1
 */