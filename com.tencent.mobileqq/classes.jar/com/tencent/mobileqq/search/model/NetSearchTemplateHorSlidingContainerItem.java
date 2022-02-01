package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class NetSearchTemplateHorSlidingContainerItem
  extends NetSearchTemplateBaseItem
{
  public static final String a;
  public int a;
  public CharSequence a;
  public ArrayList<NetSearchTemplateHorizontalBaseItem> a;
  public int b;
  protected final String b;
  protected final String j = "Type";
  protected final String k = "moreText";
  protected final String l = "moreUrl";
  public String m;
  
  static
  {
    jdField_a_of_type_JavaLangString = NetSearchTemplateHorSlidingContainerItem.class.getSimpleName();
  }
  
  public NetSearchTemplateHorSlidingContainerItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
    this.jdField_b_of_type_JavaLangString = "itemList";
    this.jdField_b_of_type_Int = 0;
  }
  
  public NetSearchTemplateHorSlidingContainerItem(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
    this.jdField_b_of_type_JavaLangString = "itemList";
    this.jdField_b_of_type_Int = 0;
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a(View paramView) {}
  
  public void a(String paramString)
  {
    for (;;)
    {
      int i;
      int n;
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_a_of_type_Int = paramString.optInt("Type");
        this.jdField_a_of_type_JavaLangCharSequence = paramString.optString("moreText");
        this.m = paramString.optString("moreUrl");
        JSONArray localJSONArray = paramString.optJSONArray("itemList");
        if (this.jdField_a_of_type_JavaUtilArrayList == null)
        {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          break label347;
          if (i >= localJSONArray.length()) {
            break label260;
          }
          paramString = localJSONArray.optJSONObject(i);
          int i1 = paramString.optInt("type");
          n = i1;
          if (i1 == 0) {
            n = 1;
          }
          if ((a() instanceof DynamicSearch.ResultItem))
          {
            paramString = new NetSearchTemplateHorizontalOneItem(this.g, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaUtilList, this.c, paramString, n, (DynamicSearch.ResultItem)a(), i + 1);
            if (paramString == null) {
              break label352;
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
            break label352;
          }
        }
        else
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 0, "layout 13 parse layout error :" + paramString.toString());
        }
        return;
      }
      if ((a() instanceof UnifySearchCommon.ResultItem))
      {
        paramString = new NetSearchTemplateHorizontalOneItem(this.g, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaUtilList, this.c, paramString, n, (UnifySearchCommon.ResultItem)a(), i + 1);
        continue;
        label260:
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && ((this.jdField_a_of_type_JavaUtilArrayList.get(0) instanceof NetSearchTemplateHorizontalOneItem)) && (!TextUtils.isEmpty(((NetSearchTemplateHorizontalOneItem)this.jdField_a_of_type_JavaUtilArrayList.get(0)).n)) && (((NetSearchTemplateHorizontalOneItem)this.jdField_a_of_type_JavaUtilArrayList.get(0)).n.contains("qcircle"))) {
          UniteSearchReportController.a(null, 0, this.c, "0X800BA22", 0, 0, null, null);
        }
      }
      else
      {
        paramString = null;
        continue;
        label347:
        i = 0;
        continue;
        label352:
        i += 1;
      }
    }
  }
  
  public int b()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem
 * JD-Core Version:    0.7.0.1
 */