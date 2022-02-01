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
  protected final String b = "itemList";
  protected final String c = "Type";
  protected final String d = "moreText";
  protected final String e = "moreUrl";
  public int f;
  public CharSequence t;
  public String u;
  public ArrayList<NetSearchTemplateHorizontalBaseItem> v;
  public int w = 0;
  
  public NetSearchTemplateHorSlidingContainerItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public NetSearchTemplateHorSlidingContainerItem(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void a(View paramView) {}
  
  public int ck_()
  {
    return 2;
  }
  
  public int cl_()
  {
    return 1;
  }
  
  public void o_(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        this.f = paramString.optInt("Type");
        this.t = paramString.optString("moreText");
        this.u = paramString.optString("moreUrl");
        localObject1 = paramString.optJSONArray("itemList");
        if (this.v == null) {
          this.v = new ArrayList();
        } else {
          this.v.clear();
        }
      }
      catch (JSONException paramString)
      {
        int j;
        if (!QLog.isColorLevel()) {
          break label359;
        }
        Object localObject1 = a;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("layout 13 parse layout error :");
        ((StringBuilder)localObject2).append(paramString.toString());
        QLog.e((String)localObject1, 0, ((StringBuilder)localObject2).toString());
      }
      if (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        paramString = null;
        j = ((JSONObject)localObject2).optInt("type");
        if (j == 0)
        {
          j = 1;
          if ((j() instanceof DynamicSearch.ResultItem)) {
            paramString = new NetSearchTemplateHorizontalOneItem(this.m, this.i, this.k, this.p, (JSONObject)localObject2, j, (DynamicSearch.ResultItem)j(), i + 1);
          } else if ((j() instanceof UnifySearchCommon.ResultItem)) {
            paramString = new NetSearchTemplateHorizontalOneItem(this.m, this.i, this.k, this.p, (JSONObject)localObject2, j, (UnifySearchCommon.ResultItem)j(), i + 1);
          }
          if (paramString == null) {
            break label368;
          }
          this.v.add(paramString);
          break label368;
        }
      }
      else
      {
        if ((this.v.size() > 0) && ((this.v.get(0) instanceof NetSearchTemplateHorizontalOneItem)) && (!TextUtils.isEmpty(((NetSearchTemplateHorizontalOneItem)this.v.get(0)).w)) && (((NetSearchTemplateHorizontalOneItem)this.v.get(0)).w.contains("qcircle")))
        {
          UniteSearchReportController.a(null, 0, this.p, "0X800BA22", 0, 0, null, null);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem
 * JD-Core Version:    0.7.0.1
 */