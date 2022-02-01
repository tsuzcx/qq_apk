package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import org.json.JSONArray;

class ChannelCoverInfoModule$12
  implements Runnable
{
  ChannelCoverInfoModule$12(ChannelCoverInfoModule paramChannelCoverInfoModule, JSONArray paramJSONArray) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getDir("readinjoy", 0).getAbsolutePath());
    localStringBuilder.append("/channel_section_data");
    FileUtils.writeFile(localStringBuilder.toString(), this.a.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule.12
 * JD-Core Version:    0.7.0.1
 */