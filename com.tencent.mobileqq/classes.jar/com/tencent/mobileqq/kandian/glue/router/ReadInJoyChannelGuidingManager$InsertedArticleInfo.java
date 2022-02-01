package com.tencent.mobileqq.kandian.glue.router;

import android.text.TextUtils;

class ReadInJoyChannelGuidingManager$InsertedArticleInfo
{
  public String a;
  public String b;
  
  ReadInJoyChannelGuidingManager$InsertedArticleInfo(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[insertArticleInfo] algorithmID = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", rowKey = ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.ReadInJoyChannelGuidingManager.InsertedArticleInfo
 * JD-Core Version:    0.7.0.1
 */