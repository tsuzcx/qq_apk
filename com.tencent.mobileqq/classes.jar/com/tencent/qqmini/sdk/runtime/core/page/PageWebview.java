package com.tencent.qqmini.sdk.runtime.core.page;

import begz;
import bejw;
import besl;
import bfbo;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class PageWebview
  extends BasePageWebview
{
  private begz a;
  public ArrayList<bfbo> a;
  public int c;
  
  public PageWebview(begz parambegz, AppBrandPageContainer paramAppBrandPageContainer)
  {
    super(parambegz.a(), paramAppBrandPageContainer);
    this.jdField_a_of_type_Begz = parambegz;
    a();
  }
  
  public void a()
  {
    setScrollBarStyle(0);
    if (getX5WebViewExtension() != null) {
      getX5WebViewExtension().setVerticalTrackDrawable(null);
    }
  }
  
  public void a(bfbo parambfbo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(parambfbo))) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambfbo);
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bfbo)localIterator.next()).a(paramInt2);
      }
    }
    this.c = paramInt2;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject2.put("windowWidth", paramInt1);
      localJSONObject2.put("windowHeight", paramInt2);
      localJSONObject1.put("size", localJSONObject2);
      this.jdField_a_of_type_Begz.a(bejw.a("onViewDidResize", localJSONObject1.toString(), b()));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        besl.d("PageWebview", "onSizeChanged, JSONException!", localJSONException);
      }
    }
  }
  
  public void setOnWebviewScrollListener(bfbo parambfbo)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parambfbo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.PageWebview
 * JD-Core Version:    0.7.0.1
 */