package com.tencent.mobileqq.ocr.ui;

public class SearchViewBuilderFactory
{
  SearchResultBaseBuilder[] a = new SearchResultBaseBuilder[3];
  
  public SearchResultBaseBuilder a(int paramInt)
  {
    Object localObject = this.a[paramInt];
    if (localObject != null) {
      return localObject;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a[paramInt] = localObject;
      return localObject;
      localObject = new SearchSougouResultItemBuilder();
      continue;
      localObject = new SearchResultLineItemBuilder();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchViewBuilderFactory
 * JD-Core Version:    0.7.0.1
 */