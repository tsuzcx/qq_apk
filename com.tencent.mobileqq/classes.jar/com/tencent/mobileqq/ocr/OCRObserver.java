package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.List;

public class OCRObserver
  implements BusinessObserver
{
  public void a(int paramInt, String paramString, OCRTextSearchInfo.SearchResult paramSearchResult) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, List paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length == 2))
      {
        a(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
        return;
      }
      a(false, "", null);
      return;
    case 2: 
      if ((paramObject != null) && ((paramObject instanceof String)))
      {
        a(true, (String)paramObject);
        return;
      }
      a(false, null);
      return;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject != null) && (paramObject.length == 3))
    {
      a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], (OCRTextSearchInfo.SearchResult)paramObject[2]);
      return;
    }
    a(-1, "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRObserver
 * JD-Core Version:    0.7.0.1
 */