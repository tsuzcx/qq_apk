package com.tencent.qqmini.sdk.runtime.core.page;

import behq;
import bekn;
import betc;
import bfcf;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class PageWebview
  extends BasePageWebview
{
  private behq a;
  public ArrayList<bfcf> a;
  public int c;
  
  public PageWebview(behq parambehq, AppBrandPageContainer paramAppBrandPageContainer)
  {
    super(parambehq.a(), paramAppBrandPageContainer);
    this.jdField_a_of_type_Behq = parambehq;
    a();
  }
  
  public void a()
  {
    setScrollBarStyle(0);
    if (getX5WebViewExtension() != null) {
      getX5WebViewExtension().setVerticalTrackDrawable(null);
    }
  }
  
  public void a(bfcf parambfcf)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.contains(parambfcf))) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(parambfcf);
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((bfcf)localIterator.next()).a(paramInt2);
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
      this.jdField_a_of_type_Behq.a(bekn.a("onViewDidResize", localJSONObject1.toString(), b()));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        betc.d("PageWebview", "onSizeChanged, JSONException!", localJSONException);
      }
    }
  }
  
  public void setOnWebviewScrollListener(bfcf parambfcf)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parambfcf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.PageWebview
 * JD-Core Version:    0.7.0.1
 */