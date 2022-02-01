package com.tencent.weiyun.data;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class NoteItem$HtmlText
  extends CNativeObject
{
  public FileItem[] fileList;
  public String htmlContent;
  public String[] picUrlList;
  
  private NoteItem$HtmlText()
  {
    super(0L);
  }
  
  private NoteItem$HtmlText(long paramLong)
  {
    super(paramLong);
  }
  
  public static HtmlText newInstance(long paramLong)
  {
    if (paramLong == 0L) {
      return null;
    }
    HtmlText localHtmlText = new HtmlText(paramLong);
    localHtmlText.htmlContent = CBundleReader.getString(paramLong, "html_content");
    long[] arrayOfLong = CBundleReader.getLongArray(paramLong, "pic_url_list");
    int j = 0;
    ArrayList localArrayList;
    int k;
    int i;
    Object localObject;
    if (arrayOfLong != null)
    {
      localArrayList = new ArrayList(arrayOfLong.length);
      k = arrayOfLong.length;
      i = 0;
      while (i < k)
      {
        long l = arrayOfLong[i];
        if (l != 0L)
        {
          localObject = CBundleReader.getString(l, "url");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localArrayList.add(localObject);
          }
        }
        i += 1;
      }
      if (!localArrayList.isEmpty()) {
        localHtmlText.picUrlList = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
      }
    }
    arrayOfLong = CBundleReader.getLongArray(paramLong, "file_list");
    if (arrayOfLong != null)
    {
      localArrayList = new ArrayList(arrayOfLong.length);
      k = arrayOfLong.length;
      i = j;
      while (i < k)
      {
        paramLong = arrayOfLong[i];
        if (paramLong != 0L)
        {
          localObject = FileItem.newInstance(paramLong);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
        i += 1;
      }
      if (!localArrayList.isEmpty()) {
        localHtmlText.fileList = ((FileItem[])localArrayList.toArray(new FileItem[localArrayList.size()]));
      }
    }
    localHtmlText.releaseNative();
    return localHtmlText;
  }
  
  public void releaseNative()
  {
    if (isNative())
    {
      FileItem[] arrayOfFileItem = this.fileList;
      if (arrayOfFileItem != null)
      {
        int j = arrayOfFileItem.length;
        int i = 0;
        while (i < j)
        {
          FileItem localFileItem = arrayOfFileItem[i];
          if (localFileItem != null) {
            localFileItem.releaseNative();
          }
          i += 1;
        }
      }
    }
    super.releaseNative();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.data.NoteItem.HtmlText
 * JD-Core Version:    0.7.0.1
 */