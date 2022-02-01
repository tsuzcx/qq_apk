package com.tencent.mobileqq.kandian.glue.video;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class VideoPreDownloadMgr$PreDownloadSerialTask
  implements Runnable
{
  private List<VideoPreDownloadMgr.VideoPreDownloadParam> a;
  
  public VideoPreDownloadMgr$PreDownloadSerialTask(List<VideoPreDownloadMgr.VideoPreDownloadParam> paramList)
  {
    Object localObject;
    this.a = localObject;
  }
  
  public void run()
  {
    if (VideoPreDownloadMgr.e(this.this$0) != null)
    {
      Object localObject1 = this.a;
      if ((localObject1 != null) && (((List)localObject1).size() != 0))
      {
        if (VideoPreDownloadMgr.d(this.this$0) == null) {
          return;
        }
        int j;
        for (int i = 0; i < this.a.size(); i = j + 1)
        {
          localObject1 = (VideoPreDownloadMgr.VideoPreDownloadParam)this.a.get(i);
          j = i;
          if (VideoPreDownloadMgr.d(this.this$0).contains(((VideoPreDownloadMgr.VideoPreDownloadParam)localObject1).a))
          {
            this.a.remove(i);
            j = i - 1;
          }
        }
        if ((VideoPreDownloadMgr.f(this.this$0) != null) && (!VideoPreDownloadMgr.f(this.this$0).a())) {
          for (i = 0; i < this.a.size(); i = j + 1)
          {
            j = i;
            if (!((VideoPreDownloadMgr.VideoPreDownloadParam)this.a.get(i)).e)
            {
              this.a.remove(i);
              j = i - 1;
            }
          }
        }
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = this.a.iterator();
          StringBuilder localStringBuilder;
          for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = localStringBuilder.toString())
          {
            localObject3 = (VideoPreDownloadMgr.VideoPreDownloadParam)((Iterator)localObject2).next();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(((VideoPreDownloadMgr.VideoPreDownloadParam)localObject3).a);
            localStringBuilder.append(" | ");
          }
          localObject2 = VideoPreDownloadMgr.e();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("当前预下载列表: ");
          ((StringBuilder)localObject3).append((String)localObject1);
          QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
        if (this.a.size() != 0)
        {
          localObject1 = (VideoPreDownloadMgr.VideoPreDownloadParam)this.a.get(0);
          localObject2 = VideoPreDownloadMgr.b(this.this$0);
          if (localObject2 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.i(VideoPreDownloadMgr.e(), 2, "当前没有做预下载，启动预下载");
            }
            VideoPreDownloadMgr.a(this.this$0, this.a);
            VideoPreDownloadMgr.c(this.this$0);
            return;
          }
          if (((String)localObject2).equals(((VideoPreDownloadMgr.VideoPreDownloadParam)localObject1).a))
          {
            if (QLog.isColorLevel()) {
              QLog.i(VideoPreDownloadMgr.e(), 2, "当前预下载与list第一项一致");
            }
            this.a.remove(0);
            VideoPreDownloadMgr.a(this.this$0, this.a);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.i(VideoPreDownloadMgr.e(), 2, "当前预下载与list第一项不一致，暂停预下载任务，重新启动预下载");
          }
          VideoPreDownloadMgr.a(this.this$0, this.a);
          this.this$0.d();
          VideoPreDownloadMgr.c(this.this$0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr.PreDownloadSerialTask
 * JD-Core Version:    0.7.0.1
 */