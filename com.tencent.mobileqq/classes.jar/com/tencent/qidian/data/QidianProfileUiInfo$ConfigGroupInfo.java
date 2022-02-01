package com.tencent.qidian.data;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qidian.proto.mobileqq_qidian.ConfigGroupInfo;
import com.tencent.qidian.proto.mobileqq_qidian.ConfigInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QidianProfileUiInfo$ConfigGroupInfo
{
  public List<QidianProfileUiInfo.ConfigInfo> a = null;
  
  public QidianProfileUiInfo$ConfigGroupInfo() {}
  
  public QidianProfileUiInfo$ConfigGroupInfo(mobileqq_qidian.ConfigGroupInfo paramConfigGroupInfo)
  {
    if (paramConfigGroupInfo.rpt_msg_config_info.has())
    {
      paramConfigGroupInfo = paramConfigGroupInfo.rpt_msg_config_info.get();
      this.a = new ArrayList(paramConfigGroupInfo.size());
      paramConfigGroupInfo = paramConfigGroupInfo.iterator();
      while (paramConfigGroupInfo.hasNext())
      {
        mobileqq_qidian.ConfigInfo localConfigInfo = (mobileqq_qidian.ConfigInfo)paramConfigGroupInfo.next();
        this.a.add(new QidianProfileUiInfo.ConfigInfo(localConfigInfo));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.data.QidianProfileUiInfo.ConfigGroupInfo
 * JD-Core Version:    0.7.0.1
 */