package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unite.search.DynamicSearch.ResultItem;

public class NetSearchTemplateUniversalItem
  extends NetSearchTemplateBaseItem
{
  public NetSearchTemplateUniversalItem.ActionInfo a;
  public NetSearchTemplateUniversalItem.HeadIconInfo a;
  public ArrayList a;
  public boolean b;
  
  public NetSearchTemplateUniversalItem(String paramString, long paramLong, List paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      i = 1;
    }
    return i;
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("needRightCenter") != 1) {
          break label481;
        }
        bool = true;
        this.b = bool;
        JSONObject localJSONObject = paramString.optJSONObject("imageInfo");
        if (localJSONObject != null) {
          a(localJSONObject);
        }
        localJSONObject = paramString.optJSONObject("actionInfo");
        if (localJSONObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$ActionInfo = new NetSearchTemplateUniversalItem.ActionInfo(this);
          this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_Int = localJSONObject.optInt("type");
          this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_JavaLangCharSequence = localJSONObject.optString("word");
          this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$ActionInfo.jdField_a_of_type_JavaLangString = localJSONObject.optString("jumpUrl");
        }
        localJSONObject = paramString.optJSONObject("headIconInfo");
        if (localJSONObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo = new NetSearchTemplateUniversalItem.HeadIconInfo(this);
          this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_Int = localJSONObject.optInt("type");
          this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangString = localJSONObject.optString("iconUrl");
          this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.jdField_a_of_type_JavaLangCharSequence = localJSONObject.optString("tagText");
          this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem$HeadIconInfo.b = localJSONObject.optString("tagBgColor");
        }
        paramString = paramString.optJSONArray("lineList");
        if ((paramString != null) && (paramString.length() > 0))
        {
          i = 0;
          if (i < paramString.length())
          {
            localJSONObject = paramString.getJSONObject(i);
            NetSearchTemplateUniversalItem.NormalWord localNormalWord;
            if (!TextUtils.isEmpty(localJSONObject.optString("word")))
            {
              if (this.jdField_a_of_type_JavaUtilArrayList == null) {
                this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
              }
              localNormalWord = new NetSearchTemplateUniversalItem.NormalWord(this);
              localNormalWord.jdField_a_of_type_JavaLangCharSequence = localJSONObject.optString("word");
              localNormalWord.jdField_a_of_type_JavaLangString = localJSONObject.optString("fontType", "A");
              localNormalWord.jdField_a_of_type_Int = localJSONObject.optInt("maxLines");
              if (localJSONObject.optInt("needHighlight") != 1) {
                break label486;
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
              if (localJSONObject.optInt("needHighlight") == 1)
              {
                bool = true;
                localNormalWord.jdField_a_of_type_Boolean = bool;
                this.jdField_a_of_type_JavaUtilArrayList.add(localNormalWord);
              }
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d(c, 0, paramString.toString());
        }
      }
      return;
      boolean bool = false;
      continue;
      i += 1;
      continue;
      label481:
      bool = false;
      continue;
      label486:
      bool = false;
    }
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem
 * JD-Core Version:    0.7.0.1
 */