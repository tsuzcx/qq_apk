package com.tencent.mobileqq.search.business.net.model;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
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
  public NetSearchTemplateUniversalItem.HeadIconInfo b;
  public ArrayList<NetSearchTemplateUniversalItem.NormalWord> c;
  public boolean d;
  protected boolean e = false;
  
  public NetSearchTemplateUniversalItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public NetSearchTemplateUniversalItem(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
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
    if (this.i == 1003L)
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
      if (c() != null) {
        paramView = c();
      } else {
        paramView = "";
      }
      ReportController.b(localAppRuntime, "dc00898", "", paramView, "auth_search", "clk_content", 0, 0, "", "", "", "");
      if (q()) {
        UniteSearchReportController.a(null, 0, this.p, "0X800AC12", 0, 0, "", "");
      }
      UniteSearchReportController.a(null, 0, this.p, "0X8009D51", 0, 0, null, null);
      return;
    }
    if (r()) {
      UniteSearchReportController.a(null, 0, this.p, "0X800BDC3", 0, 0, null, null);
    }
  }
  
  public CharSequence d()
  {
    if (this.i == 1003L)
    {
      ArrayList localArrayList = this.c;
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        return ((NetSearchTemplateUniversalItem.NormalWord)this.c.get(0)).a;
      }
    }
    return super.d();
  }
  
  public boolean i()
  {
    return true;
  }
  
  public void o_(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("needRightCenter") == 1)
        {
          bool = true;
          this.d = bool;
          JSONObject localJSONObject = paramString.optJSONObject("imageInfo");
          if (localJSONObject != null) {
            a(localJSONObject);
          }
          localJSONObject = paramString.optJSONObject("actionInfo");
          if (localJSONObject != null)
          {
            this.a = new NetSearchTemplateUniversalItem.ActionInfo(this);
            this.a.a = localJSONObject.optInt("type");
            this.a.b = localJSONObject.optString("word");
            this.a.c = localJSONObject.optString("jumpUrl");
          }
          localJSONObject = paramString.optJSONObject("headIconInfo");
          if (localJSONObject != null)
          {
            this.b = new NetSearchTemplateUniversalItem.HeadIconInfo(this);
            this.b.a = localJSONObject.optInt("type");
            this.b.b = localJSONObject.optString("iconUrl");
            this.b.c = localJSONObject.optInt("iconWidth");
            this.b.d = localJSONObject.optInt("iconHeight");
            this.b.e = localJSONObject.optString("tagText");
            this.b.f = localJSONObject.optString("tagBgColor");
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
                if (this.c == null) {
                  this.c = new ArrayList();
                }
                localNormalWord = new NetSearchTemplateUniversalItem.NormalWord(this);
                localNormalWord.a = localJSONObject.optString("word");
                localNormalWord.b = localJSONObject.optString("fontType", "A");
                localNormalWord.c = localJSONObject.optInt("maxLines");
                if (localJSONObject.optInt("needHighlight") != 1) {
                  break label517;
                }
                bool = true;
                localNormalWord.d = bool;
                this.c.add(localNormalWord);
              }
              else if (localJSONObject.optJSONArray("words") != null)
              {
                if (this.c == null) {
                  this.c = new ArrayList();
                }
                localNormalWord = new NetSearchTemplateUniversalItem.NormalWord(this);
                localNormalWord.a = SearchUtils.a(localJSONObject.optJSONArray("words"));
                localNormalWord.b = localJSONObject.optString("fontType", "A");
                localNormalWord.c = localJSONObject.optInt("maxLines");
                if (localJSONObject.optInt("needHighlight") != 1) {
                  break label522;
                }
                bool = true;
                localNormalWord.d = bool;
                this.c.add(localNormalWord);
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
          QLog.d(g, 2, paramString.toString());
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
  
  public void p()
  {
    super.p();
    if (r())
    {
      UniteSearchReportController.a(null, 0, this.p, "0X800BDC2", 0, 0, null, null);
      return;
    }
    if (this.i == 1003L) {
      UniteSearchReportController.a(null, 0, this.p, "0X8009D50", 0, 0, null, null);
    }
  }
  
  public boolean r()
  {
    return ("自杀".equals(this.m)) && (this.i == 1000000L);
  }
  
  public boolean s()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUniversalItem
 * JD-Core Version:    0.7.0.1
 */