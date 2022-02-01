package com.tencent.xweb.extension.video;

public class d
{
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("window.addEventListener('DOMContentLoaded', function() {");
    localStringBuilder.append(paramString);
    localStringBuilder.append("});this.xwebReturn = function (){return \"1\";};this.xwebReturn()");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d
 * JD-Core Version:    0.7.0.1
 */