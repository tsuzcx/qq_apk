package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class RichTemplateOneSearchResultView$RichTemplateSearchResultHelper
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private final View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
  private final TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[3];
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = new String[3];
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private final String[] jdField_b_of_type_ArrayOfJavaLangString = new String[3];
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  private String f;
  private String g;
  
  public RichTemplateOneSearchResultView$RichTemplateSearchResultHelper(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(String paramString, ImageView paramImageView)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setImageUrl ");
        localStringBuilder.append(paramString);
        QLog.e("RichTemplateOneSearchResultView", 2, localStringBuilder.toString());
      }
      paramImageView.setImageDrawable(URLDrawable.getDrawable(new URL(paramString), 0, 0, new ColorDrawable(-1315339), new ColorDrawable(-1315339), true));
      return;
    }
    catch (MalformedURLException paramString)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setImageUrl error ");
        localStringBuilder.append(paramString.toString());
        QLog.e("RichTemplateOneSearchResultView", 2, localStringBuilder.toString());
      }
      paramImageView.setImageDrawable(new ColorDrawable(-1315339));
    }
  }
  
  private void b(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", true);
    localIntent.putExtra("url", paramString);
    WebAccelerator.a(this.jdField_a_of_type_AndroidContentContext, localIntent, paramString);
  }
  
  void a()
  {
    int i = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.e = null;
    this.f = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.g = null;
    while (i < 3)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = null;
      this.jdField_b_of_type_ArrayOfJavaLangString[i] = null;
      i += 1;
    }
  }
  
  void a(View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368346));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363498));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371702));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365544));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370625));
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)paramView.findViewById(2131364150));
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)paramView.findViewById(2131364151));
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)paramView.findViewById(2131364152));
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363499);
      this.jdField_a_of_type_ArrayOfAndroidViewView[0] = paramView.findViewById(2131363692);
      this.jdField_a_of_type_ArrayOfAndroidViewView[1] = paramView.findViewById(2131363694);
      this.jdField_a_of_type_ArrayOfAndroidViewView[2] = paramView.findViewById(2131363693);
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131364157);
      ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if ((localImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localImageView).setMaskShape(ThemeImageWrapper.MODE_OTHER);
      }
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if ((localImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localImageView).setMaskShape(ThemeImageWrapper.MODE_OTHER);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnGlobalLayoutListener(new RichTemplateOneSearchResultView.RichTemplateSearchResultHelper.1(this));
      paramView.setOnClickListener(new RichTemplateOneSearchResultView.RichTemplateSearchResultHelper.2(this));
    }
  }
  
  void a(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        localObject = new JSONObject(paramString).optJSONObject("data");
        if (localObject != null)
        {
          paramString = ((JSONObject)localObject).get("serverdata");
          if (paramString != null)
          {
            if ((paramString instanceof String)) {
              paramString = new JSONObject((String)paramString);
            } else if ((paramString instanceof JSONObject)) {
              paramString = (JSONObject)paramString;
            } else {
              paramString = new JSONObject();
            }
            this.jdField_b_of_type_Int = paramString.optInt("appid");
            this.jdField_a_of_type_JavaLangString = paramString.optString("thumbnail");
            this.jdField_b_of_type_JavaLangString = paramString.optString("title");
            this.jdField_c_of_type_JavaLangString = paramString.optString("sub_title");
            this.jdField_d_of_type_JavaLangString = paramString.optString("bg_pic_url");
            this.e = paramString.optString("bg_main_btn_text");
            this.f = paramString.optString("bg_main_btn_url");
            paramString = paramString.optJSONArray("bottom_btn_list");
            if (paramString != null)
            {
              int j = paramString.length();
              i = 0;
              if (i < j)
              {
                JSONObject localJSONObject = paramString.optJSONObject(i);
                if ((localJSONObject == null) || (i >= 3)) {
                  break label324;
                }
                this.jdField_a_of_type_ArrayOfJavaLangString[i] = localJSONObject.optString("bottom_btn_text");
                this.jdField_b_of_type_ArrayOfJavaLangString[i] = localJSONObject.optString("bottom_btn_url");
                break label324;
              }
            }
          }
          paramString = ((JSONObject)localObject).getJSONObject("extradata");
          if (paramString != null)
          {
            this.jdField_c_of_type_Int = paramString.getInt("entry");
            this.jdField_d_of_type_Int = paramString.getInt("match");
            this.g = paramString.getString("keyword");
            this.jdField_a_of_type_Int = paramString.optInt("nightmode", 0);
            return;
          }
        }
      }
      catch (JSONException paramString)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initData error ");
          ((StringBuilder)localObject).append(paramString.toString());
          QLog.e("RichTemplateOneSearchResultView", 2, ((StringBuilder)localObject).toString());
        }
      }
      return;
      label324:
      i += 1;
    }
  }
  
  void b()
  {
    String str2 = this.jdField_b_of_type_JavaLangString;
    String str1 = "";
    if (str2 != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
    str2 = this.jdField_c_of_type_JavaLangString;
    if (str2 != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str2);
    } else {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidWidgetImageView);
    } else {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      View localView = this.jdField_a_of_type_AndroidViewView;
      str2 = this.e;
      if (str2 != null) {
        str1 = str2;
      }
      localView.setContentDescription(str1);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_AndroidWidgetImageView);
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    if (!TextUtils.isEmpty(this.e))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.e);
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    int i = 0;
    while (i < 3)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ArrayOfJavaLangString[i]))
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(0);
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setText(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setOnClickListener(this);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i].setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(8);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i].setVisibility(8);
      }
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i].setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166985));
      } else {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i].setBackgroundColor(-1315339);
      }
      i += 1;
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new RichTemplateOneSearchResultView.RichTemplateSearchResultHelper.3(this));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    String str;
    if (i != 2131363499)
    {
      switch (i)
      {
      default: 
        str = null;
        i = 0;
        break;
      case 2131364152: 
        str = this.jdField_b_of_type_ArrayOfJavaLangString[2];
        i = 3;
        break;
      case 2131364151: 
        str = this.jdField_b_of_type_ArrayOfJavaLangString[1];
        i = 2;
        break;
      case 2131364150: 
        str = this.jdField_b_of_type_ArrayOfJavaLangString[0];
        i = 1;
        break;
      }
    }
    else
    {
      str = this.f;
      i = 4;
    }
    if (this.jdField_d_of_type_Int == 1) {
      UniteSearchReportController.a(null, this.jdField_c_of_type_Int, 0, "0X8009D2D", this.jdField_b_of_type_Int, i, this.g);
    } else {
      UniteSearchReportController.a(null, this.jdField_c_of_type_Int, 0, "0X8009D41", this.jdField_b_of_type_Int, i, this.g);
    }
    if (str != null)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onClick ");
        ((StringBuilder)localObject).append(str);
        QLog.e("RichTemplateOneSearchResultView", 2, ((StringBuilder)localObject).toString());
      }
      if (str.startsWith("http"))
      {
        b(str);
      }
      else
      {
        localObject = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_AndroidContentContext, str);
        if (localObject != null)
        {
          ((JumpAction)localObject).a();
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("wrong url ");
            ((StringBuilder)localObject).append(str);
            QLog.e("RichTemplateOneSearchResultView", 2, ((StringBuilder)localObject).toString());
          }
          b(str);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.RichTemplateOneSearchResultView.RichTemplateSearchResultHelper
 * JD-Core Version:    0.7.0.1
 */