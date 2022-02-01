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
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        localObject = new SearchResultLineItemBuilder();
      }
    }
    else {
      localObject = new SearchSougouResultItemBuilder();
    }
    this.a[paramInt] = localObject;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.SearchViewBuilderFactory
 * JD-Core Version:    0.7.0.1
 */