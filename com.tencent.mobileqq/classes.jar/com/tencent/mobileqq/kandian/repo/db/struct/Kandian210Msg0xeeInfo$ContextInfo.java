package com.tencent.mobileqq.kandian.repo.db.struct;

import java.io.Serializable;
import java.util.ArrayList;

public class Kandian210Msg0xeeInfo$ContextInfo
  implements Serializable
{
  public String contextBrief;
  public long contextId;
  public String contextTitle;
  public int contextType;
  public String orangeWord;
  public String pictureJumpURL;
  public ArrayList<String> picturesURLList;
  public String videoBrief;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", contextId=");
    localStringBuilder.append(this.contextId);
    localStringBuilder.append(", contextBrief='");
    localStringBuilder.append(this.contextBrief);
    localStringBuilder.append('\'');
    localStringBuilder.append(", contextTitle='");
    localStringBuilder.append(this.contextTitle);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pictureJumpURL='");
    localStringBuilder.append(this.pictureJumpURL);
    localStringBuilder.append('\'');
    localStringBuilder.append(", orangeWord='");
    localStringBuilder.append(this.orangeWord);
    localStringBuilder.append('\'');
    localStringBuilder.append(", contextType=");
    localStringBuilder.append(this.contextType);
    localStringBuilder.append(", videoBrief='");
    localStringBuilder.append(this.videoBrief);
    localStringBuilder.append('\'');
    localStringBuilder.append(", picturesURLList='");
    Object localObject = this.picturesURLList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      localObject = (String)this.picturesURLList.get(0);
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('\'');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.Kandian210Msg0xeeInfo.ContextInfo
 * JD-Core Version:    0.7.0.1
 */