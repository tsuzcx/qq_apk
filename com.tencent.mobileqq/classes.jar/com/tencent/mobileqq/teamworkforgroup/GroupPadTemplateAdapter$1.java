package com.tencent.mobileqq.teamworkforgroup;

import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

class GroupPadTemplateAdapter$1
  implements URLDrawable.DownloadListener
{
  GroupPadTemplateAdapter$1(GroupPadTemplateAdapter paramGroupPadTemplateAdapter, String paramString) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (!GroupPadTemplateAdapter.a(this.b).contains(this.a))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onFileDownloadFailed url: ");
        localStringBuilder.append(this.a);
        QLog.d("GroupPadTemplateAdapter", 2, localStringBuilder.toString());
      }
      GroupPadTemplateAdapter.a(this.b).add(this.a);
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupPadTemplateAdapter.1
 * JD-Core Version:    0.7.0.1
 */