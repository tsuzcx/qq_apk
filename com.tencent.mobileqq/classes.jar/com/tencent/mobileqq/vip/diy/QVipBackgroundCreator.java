package com.tencent.mobileqq.vip.diy;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.biz.qqstory.utils.AssertUtils;
import cooperation.vip.jsoninflate.model.ViewModel;
import cooperation.vip.jsoninflate.util.JsonInflaterFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class QVipBackgroundCreator
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private List<ViewModel> jdField_a_of_type_JavaUtilList;
  
  private QVipBackgroundCreator(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static QVipBackgroundCreator a(@NonNull Activity paramActivity)
  {
    return new QVipBackgroundCreator(paramActivity);
  }
  
  private ViewModel a(@NonNull JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("type");
    Object localObject = new JsonInflaterFactory();
    View localView = ((JsonInflaterFactory)localObject).a(this.jdField_a_of_type_AndroidAppActivity, str);
    if (localView == null)
    {
      AssertUtils.a("type=" + str + " is illegal json=" + paramJSONObject, new Object[0]);
      return null;
    }
    localObject = ((JsonInflaterFactory)localObject).a(str, localView);
    if (localObject == null)
    {
      AssertUtils.a("type=" + str + " create null view model json=" + paramJSONObject, new Object[0]);
      return null;
    }
    ((ViewModel)localObject).a(paramJSONObject);
    return localObject;
  }
  
  public QVipBackgroundCreator a(@NonNull ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    return this;
  }
  
  public QVipBackgroundCreator a(@NonNull JSONArray paramJSONArray)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    }
    a();
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = a((JSONObject)localObject);
        if (localObject != null)
        {
          ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
          this.jdField_a_of_type_AndroidViewViewGroup.addView(((ViewModel)localObject).a(), localLayoutParams);
          this.jdField_a_of_type_JavaUtilList.add(localObject);
        }
      }
    }
    return this;
  }
  
  public QVipBackgroundCreator a(@NonNull JSONObject paramJSONObject)
  {
    paramJSONObject = a(paramJSONObject);
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    }
    a();
    if (paramJSONObject == null) {
      return this;
    }
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramJSONObject.a(), localLayoutParams);
    this.jdField_a_of_type_JavaUtilList.add(paramJSONObject);
    return this;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ViewModel)localIterator.next()).c();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.QVipBackgroundCreator
 * JD-Core Version:    0.7.0.1
 */