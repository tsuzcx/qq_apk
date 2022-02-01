package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x6ff.subcmd0x533.HttpMapItem;

public class OCRTextSearchInfo
{
  public static OCRTextSearchInfo.SougouSearchInfo a(List<subcmd0x533.HttpMapItem> paramList)
  {
    OCRTextSearchInfo.SougouSearchInfo localSougouSearchInfo = new OCRTextSearchInfo.SougouSearchInfo();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      subcmd0x533.HttpMapItem localHttpMapItem = (subcmd0x533.HttpMapItem)paramList.next();
      String str1 = localHttpMapItem.string_key.get();
      String str2 = localHttpMapItem.string_value.get();
      if (str1.equalsIgnoreCase("title"))
      {
        localSougouSearchInfo.title = str2;
        localSougouSearchInfo.titleKeyWords = localHttpMapItem.rpt_string_key_list.get();
      }
      else if (str1.equalsIgnoreCase("summary"))
      {
        localSougouSearchInfo.abstractStr = str2;
        localSougouSearchInfo.abstractStrKeyWords = localHttpMapItem.rpt_string_key_list.get();
      }
      else if (str1.equalsIgnoreCase("url"))
      {
        localSougouSearchInfo.jumpURL = str2;
      }
      else if (str1.equalsIgnoreCase("key"))
      {
        localSougouSearchInfo.keyWord = str2;
      }
      else if (str1.equalsIgnoreCase("category"))
      {
        localSougouSearchInfo.sourceFrom = str2;
      }
      else if (str1.equalsIgnoreCase("stype"))
      {
        localSougouSearchInfo.stype = str2;
      }
      else if (str1.equalsIgnoreCase("summaryPic"))
      {
        localSougouSearchInfo.summaryPic = str2;
      }
    }
    return localSougouSearchInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRTextSearchInfo
 * JD-Core Version:    0.7.0.1
 */