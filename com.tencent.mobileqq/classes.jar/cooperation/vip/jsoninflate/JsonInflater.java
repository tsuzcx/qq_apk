package cooperation.vip.jsoninflate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import cooperation.vip.jsoninflate.model.ViewModel;
import cooperation.vip.jsoninflate.util.JsonInflaterFactory;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonInflater
{
  private JsonInflaterFactory jdField_a_of_type_CooperationVipJsoninflateUtilJsonInflaterFactory;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  private JsonInflater(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
  }
  
  private ViewGroup.LayoutParams a(View paramView, ViewModel paramViewModel, JSONObject paramJSONObject)
  {
    if ((paramView != null) && (paramJSONObject != null) && (paramJSONObject.length() != 0) && (paramViewModel != null)) {
      return this.jdField_a_of_type_CooperationVipJsoninflateUtilJsonInflaterFactory.a(paramView).a(paramJSONObject, paramViewModel);
    }
    return null;
  }
  
  public static JsonInflater a(@NonNull Context paramContext)
  {
    return new JsonInflater(paramContext);
  }
  
  private final ViewModel a(String paramString, Context paramContext, JSONObject paramJSONObject)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("createViewModel：");
          localStringBuilder.append(paramString);
          QLog.i("JsonInflater", 0, localStringBuilder.toString());
        }
        paramContext = this.jdField_a_of_type_CooperationVipJsoninflateUtilJsonInflaterFactory.a(paramContext, paramString);
        if (paramContext == null) {
          return null;
        }
        paramContext = this.jdField_a_of_type_CooperationVipJsoninflateUtilJsonInflaterFactory.a(paramString, paramContext);
        a(paramContext, paramJSONObject);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        paramContext = new StringBuilder();
        paramContext.append("Error inflating type : ");
        paramContext.append(paramString);
        QLog.e("JsonInflater", 1, paramContext.toString());
        if (QLog.isColorLevel()) {
          QLog.i("JsonInflater", 0, "createViewModel fail finish");
        }
      }
    }
    return null;
  }
  
  private ViewModel a(JSONObject paramJSONObject, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramJSONObject == null) {
      return null;
    }
    ViewModel localViewModel;
    for (;;)
    {
      try
      {
        boolean bool2 = QLog.isColorLevel();
        boolean bool1 = false;
        if (bool2) {
          QLog.i("JsonInflater", 0, "inflate: ");
        }
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
        {
          localObject1 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localObject1 == null) {
            return null;
          }
          Object localObject2 = paramJSONObject.optString("type");
          if (QLog.isColorLevel()) {
            QLog.i("JsonInflater", 0, "Creating root view:");
          }
          localViewModel = a((String)localObject2, (Context)localObject1, paramJSONObject);
          if (localViewModel == null)
          {
            QLog.e("JsonInflater", 1, "inflate: createViewModel error null return");
            return null;
          }
          View localView = localViewModel.a();
          if (localView == null)
          {
            QLog.e("JsonInflater", 1, "inflate: tempView error null return");
            return null;
          }
          if (paramViewGroup != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("JsonInflater", 0, "generateLayoutParams");
            }
            localObject2 = a(paramViewGroup, localViewModel, paramJSONObject);
            localObject1 = localObject2;
            if (!paramBoolean)
            {
              localObject1 = localObject2;
              if (localObject2 != null)
              {
                localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                localObject1 = localObject2;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("JsonInflater", 0, "-----> start inflating children");
            }
            a(localViewModel, localView.getContext(), paramJSONObject);
            if (QLog.isColorLevel()) {
              QLog.i("JsonInflater", 0, "-----> done inflating children");
            }
            if ((paramViewGroup == null) || (!paramBoolean)) {
              break;
            }
            paramViewGroup.addView(localView, (ViewGroup.LayoutParams)localObject1);
            localViewModel.a();
            break;
          }
        }
        else
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("inflate: weakContext == null ： ");
          paramBoolean = bool1;
          if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
            paramBoolean = true;
          }
          paramJSONObject.append(paramBoolean);
          paramJSONObject.append(" || weakContext.get() == null ");
          QLog.e("JsonInflater", 1, paramJSONObject.toString());
          return null;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        QLog.e("JsonInflater", 1, "inflate: exception");
        return null;
      }
      Object localObject1 = null;
    }
    return localViewModel;
  }
  
  public ViewModel a(String paramString, ViewGroup paramViewGroup, boolean paramBoolean, JsonInflaterFactory paramJsonInflaterFactory)
  {
    JSONObject localJSONObject2;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localJSONObject2 = null;
    }
    if (localJSONObject2 != null) {
      return a(localJSONObject2, paramViewGroup, paramBoolean, paramJsonInflaterFactory);
    }
    try
    {
      paramString = new JSONArray(paramString);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    if (paramString != null) {
      return a(paramString, paramViewGroup, paramBoolean, paramJsonInflaterFactory);
    }
    return null;
  }
  
  public ViewModel a(String paramString, JsonInflaterFactory paramJsonInflaterFactory)
  {
    return a(paramString, null, true, paramJsonInflaterFactory);
  }
  
  public ViewModel a(@NonNull JSONArray paramJSONArray, ViewGroup paramViewGroup, boolean paramBoolean, JsonInflaterFactory paramJsonInflaterFactory)
  {
    this.jdField_a_of_type_CooperationVipJsoninflateUtilJsonInflaterFactory = paramJsonInflaterFactory;
    paramViewGroup = this.jdField_a_of_type_JavaLangRefWeakReference;
    paramBoolean = false;
    if ((paramViewGroup != null) && (paramViewGroup.get() != null))
    {
      paramViewGroup = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramViewGroup == null) {
        return null;
      }
      paramViewGroup = new RelativeLayout(paramViewGroup);
      paramJsonInflaterFactory = this.jdField_a_of_type_CooperationVipJsoninflateUtilJsonInflaterFactory.a(paramViewGroup);
      int i = 0;
      while (i < paramJSONArray.length())
      {
        ViewModel localViewModel = a(paramJSONArray.optJSONObject(i), paramViewGroup, false);
        if (localViewModel != null)
        {
          paramViewGroup.addView(localViewModel.a());
          localViewModel.a();
          paramJsonInflaterFactory.a(localViewModel);
        }
        i += 1;
      }
      return paramJsonInflaterFactory;
    }
    paramJSONArray = new StringBuilder();
    paramJSONArray.append("inflate: weakContext == null ： ");
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      paramBoolean = true;
    }
    paramJSONArray.append(paramBoolean);
    paramJSONArray.append(" || weakContext.get() == null ");
    QLog.e("JsonInflater", 1, paramJSONArray.toString());
    return null;
  }
  
  public ViewModel a(@NonNull JSONObject paramJSONObject, ViewGroup paramViewGroup, boolean paramBoolean, JsonInflaterFactory paramJsonInflaterFactory)
  {
    AssertUtils.mainThreadCheck();
    this.jdField_a_of_type_CooperationVipJsoninflateUtilJsonInflaterFactory = paramJsonInflaterFactory;
    return a(paramJSONObject, paramViewGroup, paramBoolean);
  }
  
  void a(ViewModel paramViewModel, Context paramContext, JSONObject paramJSONObject)
  {
    if ((paramViewModel != null) && (paramContext != null) && (paramJSONObject != null))
    {
      if (paramJSONObject.length() == 0) {
        return;
      }
      paramJSONObject = paramJSONObject.optJSONArray("child");
      if (paramJSONObject == null) {
        return;
      }
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        if (localJSONObject != null)
        {
          ViewModel localViewModel = a(localJSONObject.optString("type"), paramContext, localJSONObject);
          ViewGroup localViewGroup = (ViewGroup)paramViewModel.a();
          ViewGroup.LayoutParams localLayoutParams = a(localViewGroup, localViewModel, localJSONObject);
          a(localViewModel, paramContext, localJSONObject);
          if ((localViewModel != null) && (localViewModel.a() != null))
          {
            localViewGroup.addView(localViewModel.a(), localLayoutParams);
            localViewModel.a();
            paramViewModel.a(localViewModel);
          }
        }
        else
        {
          QLog.e("JsonInflater", 1, "rInflateChildren error: object = null");
        }
        i += 1;
      }
    }
  }
  
  protected void a(ViewModel paramViewModel, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramJSONObject.length() == 0) {
        return;
      }
      if (paramViewModel != null) {
        paramViewModel.a(paramJSONObject);
      }
      this.jdField_a_of_type_CooperationVipJsoninflateUtilJsonInflaterFactory.a(paramViewModel, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.jsoninflate.JsonInflater
 * JD-Core Version:    0.7.0.1
 */