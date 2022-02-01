package com.tencent.mobileqq.search.model;

import MQQ.LhLogoResources;
import NearbyGroup.GroupLabel;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;
import com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend.MayKnowRecommendLabel;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.search.SearchFragmentInfoInterface;
import com.tencent.mobileqq.search.SearchInfoInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.SearchUtil.ObjectItemInfo;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.DateUtil;
import com.tencent.mobileqq.search.util.HighlightModel;
import com.tencent.mobileqq.search.util.ReportUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.PrettyAccountUtil;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupBaseNetSearchModelItem
  extends ISearchResultPositionModel
{
  public int a;
  protected long a;
  Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  protected CharSequence a;
  protected String a;
  StringBuffer jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
  public ArrayList<GroupLabel> a;
  public List<String> a;
  protected boolean a;
  public int[] a;
  public int b;
  public long b;
  protected CharSequence b;
  public String b;
  public List<RecommendLabel> b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  protected String d;
  public boolean d;
  public int e;
  protected String e;
  public boolean e;
  public int f;
  protected String f;
  public boolean f;
  public int g;
  protected String g;
  public int h;
  public String h;
  private boolean h;
  public int i;
  public String i;
  private boolean i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public String m;
  public int n;
  public String n;
  public int o;
  public String o;
  public int p;
  public String p;
  public int q;
  public String q;
  public int r;
  public String r;
  public int s;
  public String s;
  public int t;
  private String t;
  private int w;
  private int x;
  private int y = 0;
  
  public GroupBaseNetSearchModelItem()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 2131167114;
    this.jdField_g_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    this.jdField_k_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_r_of_type_JavaLangString = "";
    this.jdField_s_of_type_JavaLangString = null;
    this.jdField_o_of_type_Int = -1;
    this.jdField_p_of_type_Int = -1;
  }
  
  public GroupBaseNetSearchModelItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, List<String> paramList, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 2131167114;
    this.jdField_g_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    this.jdField_k_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_r_of_type_JavaLangString = "";
    this.jdField_s_of_type_JavaLangString = null;
    this.jdField_o_of_type_Int = -1;
    this.jdField_p_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_e_of_type_JavaLangString = paramString5;
    this.jdField_f_of_type_JavaLangString = paramString6;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_m_of_type_Int = 1;
    this.jdField_c_of_type_Long = 0L;
    a();
  }
  
  public GroupBaseNetSearchModelItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, List<String> paramList, int paramInt1, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, String paramString11)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 2131167114;
    this.jdField_g_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    this.jdField_k_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_r_of_type_JavaLangString = "";
    this.jdField_s_of_type_JavaLangString = null;
    this.jdField_o_of_type_Int = -1;
    this.jdField_p_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_e_of_type_JavaLangString = paramString5;
    this.jdField_f_of_type_JavaLangString = paramString6;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_k_of_type_JavaLangString = paramString7;
    this.jdField_l_of_type_JavaLangString = paramString8;
    this.jdField_i_of_type_Int = paramInt2;
    this.jdField_m_of_type_JavaLangString = paramString9;
    this.n = paramString10;
    this.jdField_o_of_type_JavaLangString = paramString11;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_m_of_type_Int = 1;
    this.jdField_c_of_type_Long = 0L;
    a();
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "extension info:" + this.jdField_f_of_type_JavaLangString);
    }
    Object localObject3;
    label272:
    Object localObject2;
    label580:
    Object localObject1;
    int i1;
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      try
      {
        localObject3 = new JSONObject(this.jdField_f_of_type_JavaLangString);
        String str2 = ((JSONObject)localObject3).optString("thirdLineText");
        if (a(this.jdField_a_of_type_Long, (JSONObject)localObject3))
        {
          if (!QLog.isColorLevel()) {
            break label1252;
          }
          QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "child class has already parsed json data. groupMask=" + this.jdField_a_of_type_Long);
          return;
        }
        switch ((int)this.jdField_a_of_type_Long)
        {
        case 1001: 
          if (TextUtils.isEmpty(str2)) {
            break label1252;
          }
          this.jdField_b_of_type_JavaLangCharSequence = str2;
          return;
        }
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        return;
      }
      this.jdField_g_of_type_JavaLangString = ("(" + this.jdField_b_of_type_JavaLangString + ")");
      this.jdField_d_of_type_Int = ((JSONObject)localObject3).optInt("gender");
      this.jdField_e_of_type_Int = ((JSONObject)localObject3).optInt("age");
      a(((JSONObject)localObject3).optString("college"), 1);
      if (((JSONObject)localObject3).optString("location").equals(((JSONObject)localObject3).optString("hometown")))
      {
        a(((JSONObject)localObject3).optString("location"), 4);
        a(((JSONObject)localObject3).optString("constellation"), 2);
        this.jdField_a_of_type_JavaLangCharSequence = ((JSONObject)localObject3).optString("location");
        this.jdField_j_of_type_JavaLangString = ((JSONObject)localObject3).optString("authIcon");
        this.jdField_s_of_type_JavaLangString = ((JSONObject)localObject3).optString("longnick");
        this.jdField_p_of_type_Int = ((JSONObject)localObject3).optInt("allow", -1);
        this.jdField_f_of_type_Int = ((JSONObject)localObject3).optInt("liangrichflag", 0);
        this.jdField_g_of_type_Int = ((JSONObject)localObject3).optInt("liangnumblevel", -1);
      }
      for (;;)
      {
        try
        {
          this.jdField_l_of_type_Int = ((JSONObject)localObject3).optInt("cspecialflag");
          String str1 = ((JSONObject)localObject3).optString("qdmasteruin");
          localObject2 = ((JSONObject)localObject3).optString("qdemailuin");
          this.jdField_p_of_type_JavaLangString = ((JSONObject)localObject3).optString("kfaccount");
          localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          QidianManager.a((QQAppInterface)localObject3, this.jdField_l_of_type_Int, this.jdField_b_of_type_JavaLangString);
          QidianManager.a((QQAppInterface)localObject3, this.jdField_b_of_type_JavaLangString, str1);
          if ((!QidianManager.b(this.jdField_l_of_type_Int)) && (!QidianManager.c(this.jdField_l_of_type_Int))) {
            break;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label580;
          }
          this.jdField_g_of_type_JavaLangString = "";
          QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "Parse search qidian json qdemailuin is empty ");
          if (!TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString)) {
            break;
          }
          QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "Parse search qidian json kfaccount is empty ");
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "Parse search qidian json fail: " + this.jdField_b_of_type_JavaLangString + " | " + localException.getMessage());
        break;
        a(((JSONObject)localObject3).optString("location"), 4);
        a(((JSONObject)localObject3).optString("hometown"), 4);
        break label272;
        this.jdField_g_of_type_JavaLangString = ("(" + (String)localObject2 + ")");
      }
      this.jdField_b_of_type_Long = ((JSONObject)localObject3).optLong("flag_ext");
      this.jdField_g_of_type_JavaLangString = "";
      localObject1 = ((JSONObject)localObject3).optJSONArray("label");
      if (localObject1 != null)
      {
        localObject2 = new ArrayList();
        i1 = 0;
        for (;;)
        {
          int i2 = ((JSONArray)localObject1).length();
          if (i1 < i2) {
            try
            {
              JSONObject localJSONObject1 = ((JSONArray)localObject1).getJSONObject(i1);
              GroupLabel localGroupLabel = new GroupLabel();
              NearbyGroup.Color localColor = new NearbyGroup.Color();
              JSONObject localJSONObject2 = localJSONObject1.optJSONObject("edging_color");
              localColor.R = localJSONObject2.optLong("r");
              localColor.G = localJSONObject2.optLong("g");
              localColor.B = localJSONObject2.optLong("b");
              localGroupLabel.edging_color = localColor;
              localColor = new NearbyGroup.Color();
              localJSONObject2 = localJSONObject1.optJSONObject("text_color");
              localColor.R = localJSONObject2.optLong("r");
              localColor.G = localJSONObject2.optLong("g");
              localColor.B = localJSONObject2.optLong("b");
              localGroupLabel.text_color = localColor;
              localGroupLabel.strWording = localJSONObject1.optString("name");
              localGroupLabel.type = localJSONObject1.optLong("attr");
              ((ArrayList)localObject2).add(localGroupLabel);
              i1 += 1;
            }
            catch (JSONException localJSONException2)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "parse extension JSONException:" + localJSONException2.toString());
                }
              }
            }
          }
        }
        this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
      }
      localObject2 = ((JSONObject)localObject3).optString("memo");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131696129);
      }
      this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
      long l1 = ((JSONObject)localObject3).optLong("active", 0L);
      long l2 = ((JSONObject)localObject3).optLong("join_group_flag", -1L);
      long l3 = ((JSONObject)localObject3).optLong("privilege_flag", 0L);
      this.jdField_r_of_type_JavaLangString = ((JSONObject)localObject3).optString("arithmetic");
      if (((JSONObject)localObject3).optInt("exact_search") != 1) {
        break label1256;
      }
      bool = true;
      label1003:
      this.jdField_d_of_type_Boolean = bool;
      this.jdField_c_of_type_Long = l1;
      if (l2 <= -1L) {
        break label1262;
      }
      i1 = 0;
      label1025:
      this.jdField_m_of_type_Int = i1;
      if ((0x200 & l3) == 0L) {
        break label1267;
      }
    }
    label1252:
    label1256:
    label1262:
    label1267:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_f_of_type_Boolean = bool;
      this.jdField_q_of_type_JavaLangString = ((JSONObject)localObject3).optString("join_group_auth");
      this.jdField_p_of_type_Int = ((JSONObject)localObject3).optInt("allow", -1);
      this.jdField_q_of_type_Int = ((JSONObject)localObject3).optInt("invite_only", 0);
      break;
      this.jdField_b_of_type_Int = ((JSONObject)localObject3).optInt("video_or_music");
      localObject1 = ((JSONObject)localObject3).optString("busi_mask");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      if (Integer.parseInt((String)localObject1) == 2049) {
        this.jdField_a_of_type_JavaLangCharSequence = ((JSONObject)localObject3).optString("brief");
      }
      for (;;)
      {
        localObject1 = ((JSONObject)localObject3).optString("from");
        localObject2 = DateUtil.a(Long.parseLong(((JSONObject)localObject3).optString("create_time")));
        this.jdField_b_of_type_JavaLangCharSequence = ((String)localObject1 + (String)localObject2);
        this.jdField_a_of_type_Boolean = true;
        break;
        if (Integer.parseInt((String)localObject1) == 64) {
          this.jdField_a_of_type_JavaLangCharSequence = ((JSONObject)localObject3).optString("content");
        } else if (Integer.parseInt((String)localObject1) == 4096) {
          this.jdField_a_of_type_JavaLangCharSequence = ((JSONObject)localObject3).optString("description");
        }
      }
      return;
      break;
      bool = false;
      break label1003;
      i1 = 1;
      break label1025;
    }
  }
  
  public int a()
  {
    return this.w;
  }
  
  public int a(int paramInt)
  {
    int i1 = -1;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "getPosition(). type=" + paramInt + "  position=" + i1);
      }
      return i1;
      i1 = this.jdField_r_of_type_Int;
      continue;
      i1 = this.jdField_s_of_type_Int;
      continue;
      i1 = this.jdField_t_of_type_Int;
    }
  }
  
  public CharSequence a()
  {
    boolean bool = true;
    if (d() == 268435456) {}
    Object localObject;
    do
    {
      try
      {
        CharSequence localCharSequence = SearchUtils.a(this.jdField_c_of_type_JavaLangString, a(), true);
        return localCharSequence;
      }
      catch (Exception localException)
      {
        QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, localException, new Object[0]);
        return this.jdField_c_of_type_JavaLangString;
      }
      localObject = new HighlightModel(this.jdField_a_of_type_JavaUtilList, a());
      if (d() != 1002) {
        break;
      }
      this.jdField_c_of_type_JavaLangString = SearchUtils.a(this.jdField_c_of_type_JavaLangString);
      localSpannableString = ((HighlightModel)localObject).a(this.jdField_c_of_type_JavaLangString, true);
      localObject = localSpannableString;
    } while (localSpannableString != null);
    return "";
    this.jdField_c_of_type_JavaLangString = SearchUtils.a(this.jdField_c_of_type_JavaLangString);
    SpannableString localSpannableString = ((HighlightModel)localObject).a(this.jdField_c_of_type_JavaLangString, true);
    if (((HighlightModel)localObject).jdField_a_of_type_Int > 0) {}
    for (;;)
    {
      this.jdField_h_of_type_Boolean = bool;
      if (localSpannableString != null) {
        break;
      }
      return "";
      bool = false;
    }
    return localSpannableString;
  }
  
  public Object a(String paramString)
  {
    int i2 = 0;
    boolean bool = false;
    if ("ActiveEntitySearchResultPresenter_add_troop".equals(paramString))
    {
      paramString = BaseApplicationImpl.getApplication().getResources().getString(2131699383);
      switch (this.jdField_m_of_type_Int)
      {
      default: 
        bool = true;
      }
      for (;;)
      {
        return new Pair(paramString, Boolean.valueOf(bool));
        paramString = BaseApplicationImpl.getApplication().getResources().getString(2131699385);
        continue;
        paramString = BaseApplicationImpl.getApplication().getResources().getString(2131699383);
        bool = true;
        continue;
        paramString = BaseApplicationImpl.getApplication().getResources().getString(2131699384);
      }
    }
    if ("ActiveEntitySearchResultPresenter_pay_troop".equals(paramString)) {
      return Boolean.valueOf(this.jdField_f_of_type_Boolean);
    }
    int i1;
    if ("ActiveEntitySearchResultPresenter_hot_troop".equals(paramString))
    {
      i1 = (int)this.jdField_c_of_type_Long;
      if (i1 >= 0) {
        break label190;
      }
      i1 = i2;
    }
    label190:
    for (;;)
    {
      i2 = i1;
      if (i1 > 10) {
        i2 = 10;
      }
      return Integer.valueOf(i2);
      return super.a(paramString);
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.w = paramInt1;
    this.x = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b(2, paramInt1);
    b(1, paramInt2);
    b(3, paramInt3);
  }
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "onAction(). jumpUrl = " + this.jdField_e_of_type_JavaLangString + "  id=" + this.jdField_b_of_type_JavaLangString);
    }
    Object localObject2;
    Object localObject3;
    switch (d())
    {
    default: 
      if (this.jdField_a_of_type_Long == 1002L) {
        ReportUtil.a(this);
      }
      localObject2 = paramView.getContext();
      if ((localObject2 instanceof SearchInfoInterface))
      {
        localObject3 = (SearchInfoInterface)localObject2;
        if (((SearchInfoInterface)localObject3).b()) {}
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject1 = ((SearchInfoInterface)localObject3).a();
        if (!(localObject1 instanceof SearchFragmentInfoInterface)) {
          break label2723;
        }
      }
      break;
    }
    label2718:
    label2723:
    for (Object localObject1 = (SearchFragmentInfoInterface)localObject1;; localObject1 = null)
    {
      switch (((SearchInfoInterface)localObject3).a())
      {
      }
      Object localObject4;
      for (;;)
      {
        if (d() == 268435456)
        {
          SearchUtils.a("all_result", "clk_function", new String[] { "" + this.jdField_a_of_type_JavaLangString, "" + this.jdField_b_of_type_JavaLangString, "" + (this.jdField_j_of_type_Int + 1) });
          if ("63".equals(b()))
          {
            localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            if (WeatherWebPageHelperKt.a(paramView.getContext(), (QQAppInterface)localObject1))
            {
              return;
              SearchUtils.a(this.jdField_a_of_type_JavaLangString, 70, 0, this.jdField_j_of_type_Int, paramView);
              if (this.jdField_o_of_type_Int == 1)
              {
                ReportController.b(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 0, 0, "", "", "", "");
                ReportController.b(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 2, 0, "", "", "", "");
                break;
              }
              ReportController.b(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 0, 0, "", "", "", "");
              ReportController.b(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 1, 0, "", "", "", "");
              break;
              SearchUtils.a(this.jdField_a_of_type_JavaLangString, 80, 0, this.jdField_j_of_type_Int, paramView);
              break;
              SearchUtils.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_JavaLangString, this.jdField_t_of_type_JavaLangString, e(), e());
              SearchUtils.a(this.jdField_a_of_type_JavaLangString, 120, 0, this.jdField_j_of_type_Int, paramView);
              if ((this.jdField_t_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_t_of_type_JavaLangString)))
              {
                UniteSearchReportController.a(null, 0, this.jdField_a_of_type_Int, "0X8009D31", 4, 0, this.jdField_b_of_type_JavaLangString, null);
                break;
              }
              if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)))
              {
                UniteSearchReportController.a(null, 0, this.jdField_a_of_type_Int, "0X8009D35", 0, 0, this.jdField_b_of_type_JavaLangString, null);
                break;
              }
              UniteSearchReportController.a(null, 0, this.jdField_a_of_type_Int, "0X8009D49", 0, 0, this.jdField_b_of_type_JavaLangString, null);
              break;
              QQAppInterface localQQAppInterface;
              JSONObject localJSONObject;
              if ((SearchUtil.jdField_b_of_type_JavaUtilHashMap.containsKey(this)) && (d() != 268435456))
              {
                localObject4 = (SearchUtil.ObjectItemInfo)SearchUtil.jdField_b_of_type_JavaUtilHashMap.get(this);
                localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                localJSONObject = new JSONObject();
              }
              try
              {
                localJSONObject.put("project", UniteSearchReportController.a());
                localJSONObject.put("event_src", "client");
                localJSONObject.put("obj_lct", ((SearchUtil.ObjectItemInfo)localObject4).jdField_a_of_type_Int);
                localJSONObject.put("get_src", "web");
                UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(this.jdField_a_of_type_Long + "").obj2(((SearchUtil.ObjectItemInfo)localObject4).jdField_b_of_type_JavaLangString).ver1(this.jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.jdField_a_of_type_Int)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
                if (SearchUtils.a(this.jdField_a_of_type_Long)) {
                  if (SearchUtil.jdField_a_of_type_JavaUtilHashMap.containsKey(this))
                  {
                    localObject4 = (SearchUtil.ObjectItemInfo)SearchUtil.jdField_a_of_type_JavaUtilHashMap.get(this);
                    if (((SearchUtil.ObjectItemInfo)localObject4).jdField_b_of_type_Boolean)
                    {
                      i1 = 2;
                      SearchUtils.a("all_result", "clk_object", i1, 0, new String[] { this.jdField_a_of_type_JavaLangString, "" + this.jdField_a_of_type_Long, ((SearchUtil.ObjectItemInfo)localObject4).jdField_b_of_type_JavaLangString + "", ((SearchUtil.ObjectItemInfo)localObject4).jdField_a_of_type_Int + "" });
                    }
                  }
                  else
                  {
                    if ((localObject1 == null) || (!((SearchFragmentInfoInterface)localObject1).b())) {
                      continue;
                    }
                    ((SearchFragmentInfoInterface)localObject1).a(true);
                    SearchUtils.a("all_result", "clk_first_result", new String[] { ((SearchInfoInterface)localObject3).a(), "" + this.jdField_a_of_type_Long, "" + a(3), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).a()) });
                  }
                }
              }
              catch (JSONException localJSONException2)
              {
                for (;;)
                {
                  QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "e = " + localJSONException2);
                  continue;
                  i1 = 1;
                }
                if (SearchUtil.jdField_b_of_type_Boolean) {}
                for (i1 = 2;; i1 = 1)
                {
                  SearchUtils.a("all_result", "clk_content", i1, 0, new String[] { ((SearchInfoInterface)localObject3).a(), "" + this.jdField_a_of_type_Long, "", SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).a()) });
                  if ((localObject1 == null) || (!((SearchFragmentInfoInterface)localObject1).b())) {
                    break;
                  }
                  ((SearchFragmentInfoInterface)localObject1).a(true);
                  SearchUtils.a("all_result", "clk_first_result", new String[] { ((SearchInfoInterface)localObject3).a(), "" + this.jdField_a_of_type_Long, "" + a(2), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).a()) });
                  break;
                }
              }
              if ((localObject1 != null) && (((SearchFragmentInfoInterface)localObject1).b()))
              {
                ((SearchFragmentInfoInterface)localObject1).a(true);
                SearchUtils.a("all_result", "clk_tab_first_result", new String[] { ((SearchInfoInterface)localObject3).a(), "" + this.jdField_a_of_type_Long, "" + a(2), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).a()) });
              }
              SearchUtils.a("all_result", "clk_tab_result", new String[] { ((SearchInfoInterface)localObject3).a(), "" + this.jdField_a_of_type_Long, "", SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).a()) });
              continue;
              if ((localObject1 != null) && (((SearchFragmentInfoInterface)localObject1).b()))
              {
                ((SearchFragmentInfoInterface)localObject1).a(true);
                SearchUtils.a("sub_result", "clk_sub_first_result", new String[] { ((SearchInfoInterface)localObject3).a(), "" + this.jdField_a_of_type_Long, "" + a(2), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).a()) });
              }
              SearchUtils.a("sub_result", "clk_result", new String[] { ((SearchInfoInterface)localObject3).a(), "" + this.jdField_a_of_type_Long, "" + a(2), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).a()) });
              continue;
            }
          }
          if (((paramView.getContext() instanceof UniteSearchActivity)) && (SearchUtil.jdField_b_of_type_JavaUtilHashMap.containsKey(this)))
          {
            localObject1 = (SearchUtil.ObjectItemInfo)SearchUtil.jdField_b_of_type_JavaUtilHashMap.get(this);
            localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            localObject4 = new JSONObject();
          }
        }
      }
      try
      {
        ((JSONObject)localObject4).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject4).put("event_src", "client");
        ((JSONObject)localObject4).put("obj_lct", ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Int);
        ((JSONObject)localObject4).put("get_src", "native");
        UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Long + "").obj2(((SearchUtil.ObjectItemInfo)localObject1).jdField_b_of_type_JavaLangString).ver1(((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(UniteSearchActivity.jdField_d_of_type_Int)).ver7(((JSONObject)localObject4).toString()).session_id(((QQAppInterface)localObject3).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
        if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
          if ((this.jdField_e_of_type_JavaLangString.startsWith("http")) || (this.jdField_e_of_type_JavaLangString.startsWith("https")))
          {
            paramView = new Intent((Context)localObject2, QQBrowserActivity.class);
            paramView.putExtra("url", this.jdField_e_of_type_JavaLangString);
            ((Context)localObject2).startActivity(paramView);
            return;
          }
        }
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "e = " + localJSONException1);
        }
        if ((localObject2 instanceof BaseActivity))
        {
          paramView = JumpParser.a(((BaseActivity)paramView.getContext()).app, (Context)localObject2, this.jdField_e_of_type_JavaLangString);
          if (paramView != null)
          {
            paramView.a();
            return;
          }
          ((Context)localObject2).startActivity(new Intent((Context)localObject2, JumpActivity.class).setData(Uri.parse(this.jdField_e_of_type_JavaLangString)));
          return;
        }
        ((Context)localObject2).startActivity(new Intent((Context)localObject2, JumpActivity.class).setData(Uri.parse(this.jdField_e_of_type_JavaLangString)));
        return;
      }
      if (this.jdField_a_of_type_Long == 268435456L)
      {
        SearchUtils.a(paramView.getContext(), Integer.valueOf(this.jdField_b_of_type_JavaLangString).intValue(), this.jdField_a_of_type_Int);
        return;
      }
      boolean bool;
      if (this.jdField_a_of_type_Long == 1001L)
      {
        bool = b();
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "onAction mobileNumberResult = " + bool + ",id = " + this.jdField_b_of_type_JavaLangString);
        }
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject2 = new SearchResultItem();
        ((SearchResultItem)localObject2).jdField_a_of_type_Long = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
        try
        {
          if ((QidianManager.b(this.jdField_l_of_type_Int)) || (QidianManager.c(this.jdField_l_of_type_Int))) {
            ((SearchResultItem)localObject2).jdField_a_of_type_Long = Long.valueOf(this.jdField_p_of_type_JavaLangString).longValue();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.i("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "qidian corp jump error");
          }
        }
        ((SearchResultItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if (RobotUtils.b((QQAppInterface)localObject1, this.jdField_b_of_type_JavaLangString))
        {
          RobotUtils.a(paramView.getContext(), null, this.jdField_b_of_type_JavaLangString);
          return;
        }
        if (this.jdField_a_of_type_Int != 99) {
          break label2718;
        }
      }
      for (int i1 = 4;; i1 = 3)
      {
        if (bool)
        {
          ((SearchResultItem)localObject2).jdField_a_of_type_Long = 0L;
          ((SearchResultItem)localObject2).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        }
        AddFriendActivity.a((Activity)paramView.getContext(), (SearchResultItem)localObject2, (QQAppInterface)localObject1, true, i1);
        return;
        if (this.jdField_a_of_type_Long != 1002L) {
          break;
        }
        i1 = 0;
        localObject1 = paramView.getContext();
        int i3 = i1;
        if ((localObject1 instanceof Activity))
        {
          Intent localIntent = ((Activity)localObject1).getIntent();
          i3 = i1;
          if (localIntent != null) {
            i3 = localIntent.getIntExtra("from_type_for_report", 0);
          }
        }
        int i2 = 103;
        if (i3 == 9) {
          i2 = 112;
        }
        i1 = i2;
        if (localObject1 != null)
        {
          i1 = i2;
          if ((localObject2 instanceof ActiveEntitySearchActivity))
          {
            localObject1 = ((Activity)localObject1).getIntent().getLongArrayExtra("group_mask_long_array");
            i1 = i2;
            if (localObject1 != null)
            {
              i1 = i2;
              if (localObject1.length == 1)
              {
                i1 = i2;
                if (localObject1[0] == 1002L)
                {
                  if (i3 != 9) {
                    break label2670;
                  }
                  i1 = 113;
                }
              }
            }
          }
        }
        switch (i1)
        {
        }
        for (;;)
        {
          localObject1 = TroopInfoActivity.a(this.jdField_b_of_type_JavaLangString, i1);
          ((Bundle)localObject1).putInt("exposureSource", 3);
          ((Bundle)localObject1).putString("keyword", a());
          ((Bundle)localObject1).putBoolean("isFromNative", true);
          ((Bundle)localObject1).putInt("t_s_f", 1000);
          ((Bundle)localObject1).putString("authSig", this.jdField_q_of_type_JavaLangString);
          TroopUtils.a(paramView.getContext(), (Bundle)localObject1, 2);
          return;
          label2670:
          i1 = 104;
          break;
          if (this.jdField_d_of_type_Boolean)
          {
            i1 = 30014;
          }
          else
          {
            i1 = 30016;
            continue;
            if (this.jdField_d_of_type_Boolean) {
              i1 = 30018;
            } else {
              i1 = 30020;
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_t_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      if ((paramInt != 3) || (((this.jdField_b_of_type_JavaUtilList.size() <= 2) || ((this.jdField_d_of_type_Int != 1) && (this.jdField_d_of_type_Int != 2))) && (this.jdField_b_of_type_JavaUtilList.size() <= 3))) {}
    }
    else
    {
      return;
    }
    MayKnowRecommend.MayKnowRecommendLabel localMayKnowRecommendLabel = new MayKnowRecommend.MayKnowRecommendLabel();
    localMayKnowRecommendLabel.text_color = -1;
    localMayKnowRecommendLabel.bytes_name = paramString;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilList.add(localMayKnowRecommendLabel);
      return;
      localMayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#FF8A2D");
      continue;
      localMayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#7373FF");
      continue;
      localMayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#C573FF");
      continue;
      localMayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#FFC619");
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(long paramLong, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "JSONObject info:" + paramJSONObject);
    }
    if (paramJSONObject == null) {}
    return false;
  }
  
  public int b()
  {
    return this.x;
  }
  
  public CharSequence b()
  {
    HighlightModel localHighlightModel = new HighlightModel(this.jdField_a_of_type_JavaUtilList, a());
    Object localObject1 = null;
    Object localObject2;
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
    {
      localObject1 = SearchUtils.a("(" + this.jdField_h_of_type_JavaLangString + ")");
      localObject2 = null;
    }
    for (;;)
    {
      localObject2 = localHighlightModel.a((CharSequence)localObject1, (String)localObject2, false, false, true);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      return localObject1;
      if (this.jdField_f_of_type_Int == 1)
      {
        this.jdField_g_of_type_JavaLangString = SearchUtils.a(this.jdField_g_of_type_JavaLangString);
        localObject2 = PrettyAccountUtil.a(this.jdField_g_of_type_Int);
        if (localObject2 != null) {
          localObject1 = ((LhLogoResources)localObject2).lightColor;
        }
        CharSequence localCharSequence = PrettyAccountUtil.a(this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, this.jdField_g_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        localObject2 = localObject1;
        localObject1 = localCharSequence;
      }
      else
      {
        localObject1 = SearchUtils.a(this.jdField_g_of_type_JavaLangString);
        localObject2 = null;
      }
    }
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      this.jdField_r_of_type_Int = paramInt2;
      return;
    case 2: 
      this.jdField_s_of_type_Int = paramInt2;
      return;
    }
    this.jdField_t_of_type_Int = paramInt2;
  }
  
  public boolean b()
  {
    bool2 = false;
    boolean bool3 = true;
    bool1 = bool2;
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {}
    try
    {
      int i1 = new JSONObject(this.jdField_f_of_type_JavaLangString).optInt("is_mobile_no", 0);
      if (i1 != 1) {
        break label96;
      }
      bool1 = bool3;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "isMobileNumberSearchResult JSONException", localJSONException);
        bool1 = bool2;
        continue;
        bool1 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "isMobileNumberSearchResult result = " + bool1);
    }
    return bool1;
  }
  
  public int c()
  {
    if (d() == 1001) {
      return 1;
    }
    if (d() == 1002) {
      return 4;
    }
    return 0;
  }
  
  public CharSequence c()
  {
    boolean bool = false;
    HighlightModel localHighlightModel = new HighlightModel(this.jdField_a_of_type_JavaUtilList, a());
    this.jdField_a_of_type_JavaLangCharSequence = SearchUtils.a(this.jdField_a_of_type_JavaLangCharSequence);
    SpannableString localSpannableString = localHighlightModel.a(this.jdField_a_of_type_JavaLangCharSequence, false, false, false);
    if (localHighlightModel.jdField_a_of_type_Int > 0) {
      bool = true;
    }
    this.jdField_i_of_type_Boolean = bool;
    if (localSpannableString == null) {
      return "";
    }
    return localSpannableString;
  }
  
  public String c()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public int d()
  {
    return (int)this.jdField_a_of_type_Long;
  }
  
  public CharSequence d()
  {
    Object localObject;
    if ((this.jdField_h_of_type_Boolean) || (this.jdField_i_of_type_Boolean)) {
      localObject = this.jdField_b_of_type_JavaLangCharSequence;
    }
    SpannableString localSpannableString;
    do
    {
      return localObject;
      localSpannableString = new HighlightModel(this.jdField_a_of_type_JavaUtilList, a()).a(this.jdField_b_of_type_JavaLangCharSequence, false, this.jdField_a_of_type_Boolean);
      localObject = localSpannableString;
    } while (localSpannableString != null);
    return "";
  }
  
  public String d()
  {
    if (this.jdField_r_of_type_JavaLangString != null) {
      return this.jdField_r_of_type_JavaLangString;
    }
    return "";
  }
  
  public int e()
  {
    return this.y;
  }
  
  public String e()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem
 * JD-Core Version:    0.7.0.1
 */