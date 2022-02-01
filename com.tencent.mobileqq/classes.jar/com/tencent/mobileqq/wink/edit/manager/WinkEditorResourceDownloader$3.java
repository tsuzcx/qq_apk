package com.tencent.mobileqq.wink.edit.manager;

import com.tencent.mobileqq.wink.edit.bean.AEEditorDownloadResBean;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import java.util.Map;

class WinkEditorResourceDownloader$3
  implements Runnable
{
  WinkEditorResourceDownloader$3(WinkEditorResourceDownloader paramWinkEditorResourceDownloader, String paramString, WinkEditorResourceDownloader.ResDownLoadListener paramResDownLoadListener) {}
  
  public void run()
  {
    Object localObject = this.this$0.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downLoadResource--by user--BEGIN id: ");
    localStringBuilder.append(this.a);
    WinkQLog.b((String)localObject, localStringBuilder.toString());
    this.this$0.a();
    localObject = (AEEditorDownloadResBean)this.this$0.e.get(this.a);
    if (localObject != null)
    {
      this.this$0.a((AEEditorDownloadResBean)localObject, this.b);
      return;
    }
    localObject = this.this$0.d;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("downLoadResource--by user--FAIL, no download config for id: ");
    localStringBuilder.append(this.a);
    WinkQLog.d((String)localObject, localStringBuilder.toString());
    localObject = this.b;
    if (localObject != null) {
      ((WinkEditorResourceDownloader.ResDownLoadListener)localObject).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.3
 * JD-Core Version:    0.7.0.1
 */