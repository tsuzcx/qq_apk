package com.tencent.mobileqq.statistics;

public class PhotoReportUtils
{
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    String[] arrayOfString = new String[14];
    arrayOfString[0] = "/weibo";
    arrayOfString[1] = "/sina/news/save/";
    arrayOfString[2] = "/faceq/";
    arrayOfString[3] = "/newsreader/";
    arrayOfString[4] = "/tieba";
    arrayOfString[5] = "/baidu";
    arrayOfString[6] = "/UCDownloads";
    arrayOfString[7] = "/taobao";
    arrayOfString[8] = "/news_article/";
    arrayOfString[9] = "/sohunewsdown/";
    arrayOfString[10] = "/pitu/";
    arrayOfString[11] = "/pins/";
    arrayOfString[12] = "/tumblr/";
    arrayOfString[13] = "/download";
    int i = 0;
    while (i < arrayOfString.length)
    {
      if (paramString.contains(arrayOfString[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.PhotoReportUtils
 * JD-Core Version:    0.7.0.1
 */