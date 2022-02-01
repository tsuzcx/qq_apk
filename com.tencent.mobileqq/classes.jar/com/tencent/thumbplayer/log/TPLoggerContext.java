package com.tencent.thumbplayer.log;

import android.text.TextUtils;
import androidx.annotation.NonNull;

public class TPLoggerContext
{
  public static final String DEFAULT_TAG = "TPLogger";
  public static final String PREFIX_THUMB_PLAYER = "ThumbPlayer";
  private String classId = "";
  private String model = "";
  private String prefix = "";
  private String tag = "TPLogger";
  private String taskId = "";
  
  public TPLoggerContext(TPLoggerContext paramTPLoggerContext)
  {
    this(paramTPLoggerContext.prefix, paramTPLoggerContext.classId, paramTPLoggerContext.taskId, paramTPLoggerContext.model);
  }
  
  public TPLoggerContext(TPLoggerContext paramTPLoggerContext, @NonNull String paramString)
  {
    update(paramTPLoggerContext, paramString);
  }
  
  public TPLoggerContext(@NonNull String paramString)
  {
    this(paramString, "", "", "");
  }
  
  public TPLoggerContext(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4)
  {
    this.prefix = paramString1;
    this.classId = paramString2;
    this.taskId = paramString3;
    this.model = paramString4;
    buildTag();
  }
  
  private void buildTag()
  {
    this.tag = this.prefix;
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(this.classId))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.tag);
      localStringBuilder.append("_C");
      localStringBuilder.append(this.classId);
      this.tag = localStringBuilder.toString();
    }
    if (!TextUtils.isEmpty(this.taskId))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.tag);
      localStringBuilder.append("_T");
      localStringBuilder.append(this.taskId);
      this.tag = localStringBuilder.toString();
    }
    if (!TextUtils.isEmpty(this.model))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.tag);
      localStringBuilder.append("_");
      localStringBuilder.append(this.model);
      this.tag = localStringBuilder.toString();
    }
  }
  
  public String getClassId()
  {
    return this.classId;
  }
  
  public String getModel()
  {
    return this.model;
  }
  
  public String getPrefix()
  {
    return this.prefix;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public String getTaskId()
  {
    return this.taskId;
  }
  
  public void setTaskId(String paramString)
  {
    this.taskId = paramString;
    buildTag();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TPLoggerContext{prefix='");
    localStringBuilder.append(this.prefix);
    localStringBuilder.append('\'');
    localStringBuilder.append(", classId='");
    localStringBuilder.append(this.classId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", taskId='");
    localStringBuilder.append(this.taskId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", model='");
    localStringBuilder.append(this.model);
    localStringBuilder.append('\'');
    localStringBuilder.append(", tag='");
    localStringBuilder.append(this.tag);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void update(TPLoggerContext paramTPLoggerContext, @NonNull String paramString)
  {
    if (paramTPLoggerContext != null)
    {
      this.prefix = paramTPLoggerContext.prefix;
      this.classId = paramTPLoggerContext.classId;
      this.taskId = paramTPLoggerContext.taskId;
    }
    else
    {
      this.prefix = "";
      this.classId = "";
      this.taskId = "";
    }
    this.model = paramString;
    buildTag();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.log.TPLoggerContext
 * JD-Core Version:    0.7.0.1
 */