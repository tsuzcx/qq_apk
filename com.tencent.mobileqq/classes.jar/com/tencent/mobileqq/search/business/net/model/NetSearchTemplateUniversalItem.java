package com.tencent.mobileqq.search.business.net.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;
import unite.DynamicSearch.ResultItem;

public class NetSearchTemplateUniversalItem
  extends NetSearchTemplateBaseItem
{
  public NetSearchTemplateUniversalItem.ActionInfo a;
  public NetSearchTemplateUniversalItem.HeadIconInfo a;
  public ArrayList<NetSearchTemplateUniversalItem.NormalWord> a;
  public boolean b;
  public boolean c;
  
  public NetSearchTemplateUniversalItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
    this.jdField_c_of_type_Boolean = false;
  }
  
  public NetSearchTemplateUniversalItem(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
    this.jdField_c_of_type_Boolean = false;
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    if (paramInt != 128)
    {
      i = paramInt;
      switch (paramInt)
      {
      default: 
        i = 1;
      }
    }
    return i;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (this.jdField_a_of_type_Long == 1003L)
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
      if (a() != null) {
        paramView = a();
      } else {
        paramView = "";
      }
      ReportController.b(localAppRuntime, "dc00898", "", paramView, "auth_search", "clk_content", 0, 0, "", "", "", "");
      if (this.jdField_c_of_type_Boolean) {
        ReportController.b(null, "dc00898", "", "", "0X800AC12", "0X800AC12", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("needRightCenter") == 1)
        {
          bool = true;
          this.b = bool;
          JSONObject localJSONObject = paramString.optJSONObject("imageInfo");
          if (localJSONObject != null) {
            a(localJSONObject);
          }
          localJSONObject = paramString.optJSONObject("actionInfo");
          if (localJSONObject != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$ActionInfo = new NetSearchTemplateUniversalItem.ActionInfo(this);
            this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_Int = localJSONObject.optInt("type");
            this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_JavaLangCharSequence = localJSONObject.optString("word");
            this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_JavaLangString = localJSONObject.optString("jumpUrl");
          }
          localJSONObject = paramString.optJSONObject("headIconInfo");
          if (localJSONObject != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo = new NetSearchTemplateUniversalItem.HeadIconInfo(this);
            this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_Int = localJSONObject.optInt("type");
            this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangString = localJSONObject.optString("iconUrl");
            this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_b_of_type_Int = localJSONObject.optInt("iconWidth");
            this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.c = localJSONObject.optInt("iconHeight");
            this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangCharSequence = localJSONObject.optString("tagText");
            this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_b_of_type_JavaLangString = localJSONObject.optString("tagBgColor");
          }
          paramString = paramString.optJSONArray("lineList");
          if ((paramString != null) && (paramString.length() > 0))
          {
            int i = 0;
            if (i < paramString.length())
            {
              localJSONObject = paramString.getJSONObject(i);
              bool = TextUtils.isEmpty(localJSONObject.optString("word"));
              NetSearchTemplateUniversalItem.NormalWord localNormalWord;
              if (!bool)
              {
                if (this.jdField_a_of_type_JavaUtilArrayList == null) {
                  this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
                }
                localNormalWord = new NetSearchTemplateUniversalItem.NormalWord(this);
                localNormalWord.jdField_a_of_type_JavaLangCharSequence = localJSONObject.optString("word");
                localNormalWord.jdField_a_of_type_JavaLangString = localJSONObject.optString("fontType", "A");
                localNormalWord.jdField_a_of_type_Int = localJSONObject.optInt("maxLines");
                if (localJSONObject.optInt("needHighlight") != 1) {
                  break label517;
                }
                bool = true;
                localNormalWord.jdField_a_of_type_Boolean = bool;
                this.jdField_a_of_type_JavaUtilArrayList.add(localNormalWord);
              }
              else if (localJSONObject.optJSONArray("words") != null)
              {
                if (this.jdField_a_of_type_JavaUtilArrayList == null) {
                  this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
                }
                localNormalWord = new NetSearchTemplateUniversalItem.NormalWord(this);
                localNormalWord.jdField_a_of_type_JavaLangCharSequence = SearchUtils.a(localJSONObject.optJSONArray("words"));
                localNormalWord.jdField_a_of_type_JavaLangString = localJSONObject.optString("fontType", "A");
                localNormalWord.jdField_a_of_type_Int = localJSONObject.optInt("maxLines");
                if (localJSONObject.optInt("needHighlight") != 1) {
                  break label522;
                }
                bool = true;
                localNormalWord.jdField_a_of_type_Boolean = bool;
                this.jdField_a_of_type_JavaUtilArrayList.add(localNormalWord);
              }
              i += 1;
              continue;
            }
          }
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString, 2, paramString.toString());
        }
      }
      boolean bool = false;
      continue;
      label517:
      bool = false;
      continue;
      label522:
      bool = false;
    }
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUniversalItem
 * JD-Core Version:    0.7.0.1
 */