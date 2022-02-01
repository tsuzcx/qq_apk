package cooperation.comic.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.comic.jsp.QQComicJsPlugin;
import java.util.List;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class QQComicTabBarView$MyOnClickListener
  implements View.OnClickListener
{
  final int jdField_a_of_type_Int;
  final List<WebViewTabBarData> jdField_a_of_type_JavaUtilList;
  final WeakReference<QQComicTabBarView> jdField_a_of_type_MqqUtilWeakReference;
  final boolean jdField_a_of_type_Boolean;
  
  QQComicTabBarView$MyOnClickListener(QQComicTabBarView paramQQComicTabBarView, int paramInt, boolean paramBoolean, List<WebViewTabBarData> paramList)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQComicTabBarView);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  void a(QQComicTabBarView paramQQComicTabBarView)
  {
    Object localObject;
    JSONObject localJSONObject;
    if ((paramQQComicTabBarView.getContext() instanceof QQBrowserActivity))
    {
      localObject = ((QQBrowserActivity)paramQQComicTabBarView.getContext()).getWebViewProvider();
      if ((localObject instanceof QQComicFragment))
      {
        localObject = ((QQComicFragment)localObject).a();
        if (localObject != null) {
          localJSONObject = new JSONObject();
        }
      }
    }
    try
    {
      localJSONObject.put("source", "comic");
      ((QQComicJsPlugin)localObject).dispatchJsEvent("qbrowserTabClick", null, localJSONObject);
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int))
      {
        localObject = ((WebViewTabBarData)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).tag;
        QQComicTabBarView.a(paramQQComicTabBarView.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject, true);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("WebViewTabBarView", 1, localJSONException, new Object[0]);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    QQComicTabBarView localQQComicTabBarView = (QQComicTabBarView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localQQComicTabBarView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Int == localQQComicTabBarView.i)
      {
        a(localQQComicTabBarView);
      }
      else
      {
        long l = System.currentTimeMillis();
        if (l - localQQComicTabBarView.jdField_a_of_type_Long >= 500L)
        {
          localQQComicTabBarView.jdField_a_of_type_Long = l;
          localQQComicTabBarView.setSelectedTab(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTabBarView.MyOnClickListener
 * JD-Core Version:    0.7.0.1
 */