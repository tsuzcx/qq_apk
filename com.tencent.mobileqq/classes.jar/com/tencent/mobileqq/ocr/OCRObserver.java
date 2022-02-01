package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import java.util.List;

public class OCRObserver
  implements BusinessObserver
{
  public void a(int paramInt, String paramString, OCRTextSearchInfo.SearchResult paramSearchResult) {}
  
  public void a(boolean paramBoolean, int paramInt, TranslateResult paramTranslateResult) {}
  
  public void a(boolean paramBoolean, String paramString, List<OCRTextSearchInfo.SougouSearchInfo> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        paramObject = (Object[])paramObject;
        if ((paramObject != null) && (paramObject.length == 3))
        {
          a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], (OCRTextSearchInfo.SearchResult)paramObject[2]);
          return;
        }
        a(-1, "", null);
        return;
      }
      Object localObject = (Object[])paramObject;
      if ((paramObject != null) && (localObject.length == 2))
      {
        paramObject = (Integer)localObject[0];
        localObject = (TranslateResult)localObject[1];
        if (localObject != null)
        {
          a(paramBoolean, paramObject.intValue(), (TranslateResult)localObject);
          return;
        }
        a(false, paramObject.intValue(), null);
        return;
      }
      a(false, -1, null);
      return;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject != null) && (paramObject.length == 2))
    {
      a(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
      return;
    }
    a(false, "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRObserver
 * JD-Core Version:    0.7.0.1
 */