package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;
import unite.DynamicSearch.ResultItem;

public class NetSearchTemplateHorSlidingContainerItem
  extends NetSearchTemplateBaseItem
{
  public static final String a = "NetSearchTemplateHorSlidingContainerItem";
  public int a;
  public CharSequence a;
  public ArrayList<NetSearchTemplateHorizontalBaseItem> a;
  public int b;
  protected final String b;
  protected final String j = "Type";
  protected final String k = "moreText";
  protected final String l = "moreUrl";
  public String m;
  
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
  
  public void a(View paramView) {}
  
  public void a(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_a_of_type_Int = paramString.optInt("Type");
        this.jdField_a_of_type_JavaLangCharSequence = paramString.optString("moreText");
        this.m = paramString.optString("moreUrl");
        localObject1 = paramString.optJSONArray("itemList");
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        } else {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
        }
      }
      catch (JSONException paramString)
      {
        int n;
        if (!QLog.isColorLevel()) {
          break label359;
        }
        Object localObject1 = jdField_a_of_type_JavaLangString;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("layout 13 parse layout error :");
        ((StringBuilder)localObject2).append(paramString.toString());
        QLog.e((String)localObject1, 0, ((StringBuilder)localObject2).toString());
      }
      if (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        paramString = null;
        n = ((JSONObject)localObject2).optInt("type");
        if (n == 0)
        {
          n = 1;
          if ((a() instanceof DynamicSearch.ResultItem)) {
            paramString = new NetSearchTemplateHorizontalOneItem(this.g, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaUtilList, this.c, (JSONObject)localObject2, n, (DynamicSearch.ResultItem)a(), i + 1);
          } else if ((a() instanceof UnifySearchCommon.ResultItem)) {
            paramString = new NetSearchTemplateHorizontalOneItem(this.g, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaUtilList, this.c, (JSONObject)localObject2, n, (UnifySearchCommon.ResultItem)a(), i + 1);
          }
          if (paramString == null) {
            break label368;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
          break label368;
        }
      }
      else
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && ((this.jdField_a_of_type_JavaUtilArrayList.get(0) instanceof NetSearchTemplateHorizontalOneItem)) && (!TextUtils.isEmpty(((NetSearchTemplateHorizontalOneItem)this.jdField_a_of_type_JavaUtilArrayList.get(0)).n)) && (((NetSearchTemplateHorizontalOneItem)this.jdField_a_of_type_JavaUtilArrayList.get(0)).n.contains("qcircle")))
        {
          UniteSearchReportController.a(null, 0, this.c, "0X800BA22", 0, 0, null, null);
          return;
        }
        label359:
        return;
        i = 0;
        continue;
      }
      continue;
      label368:
      i += 1;
    }
  }
  
  public int b()
  {
    return 2;
  }
  
  public int f_()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem
 * JD-Core Version:    0.7.0.1
 */