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
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend.MayKnowRecommendLabel;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchFragmentInfoInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.base.api.SearchInfoInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.DateUtil;
import com.tencent.mobileqq.search.util.HighlightModel;
import com.tencent.mobileqq.search.util.ReportUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
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
    this.jdField_c_of_type_Int = 2131167139;
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
    this.jdField_c_of_type_Int = 2131167139;
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
    this.jdField_c_of_type_Int = 2131167139;
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
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("extension info:");
      ((StringBuilder)localObject1).append(this.jdField_f_of_type_JavaLangString);
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, ((StringBuilder)localObject1).toString());
    }
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {}
    for (;;)
    {
      try
      {
        Object localObject3 = new JSONObject(this.jdField_f_of_type_JavaLangString);
        String str = ((JSONObject)localObject3).optString("thirdLineText");
        if (a(this.jdField_a_of_type_Long, (JSONObject)localObject3))
        {
          if (!QLog.isColorLevel()) {
            break label1343;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("child class has already parsed json data. groupMask=");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
          QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, ((StringBuilder)localObject1).toString());
          return;
        }
        long l1 = this.jdField_a_of_type_Long;
        i1 = (int)l1;
        Object localObject2;
        if (i1 != 1001)
        {
          if (i1 != 1002)
          {
            if (i1 == 1073745984)
            {
              this.jdField_b_of_type_Int = ((JSONObject)localObject3).optInt("video_or_music");
              localObject1 = ((JSONObject)localObject3).optString("busi_mask");
              if (!TextUtils.isEmpty((CharSequence)localObject1))
              {
                if (Integer.parseInt((String)localObject1) == 2049) {
                  this.jdField_a_of_type_JavaLangCharSequence = ((JSONObject)localObject3).optString("brief");
                } else if (Integer.parseInt((String)localObject1) == 64) {
                  this.jdField_a_of_type_JavaLangCharSequence = ((JSONObject)localObject3).optString("content");
                } else if (Integer.parseInt((String)localObject1) == 4096) {
                  this.jdField_a_of_type_JavaLangCharSequence = ((JSONObject)localObject3).optString("description");
                }
                localObject1 = ((JSONObject)localObject3).optString("from");
                localObject2 = DateUtil.a(Long.parseLong(((JSONObject)localObject3).optString("create_time")));
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append((String)localObject1);
                ((StringBuilder)localObject3).append((String)localObject2);
                this.jdField_b_of_type_JavaLangCharSequence = ((StringBuilder)localObject3).toString();
                this.jdField_a_of_type_Boolean = true;
              }
            }
          }
          else
          {
            this.jdField_b_of_type_Long = ((JSONObject)localObject3).optLong("flag_ext");
            this.jdField_g_of_type_JavaLangString = "";
            localObject1 = ((JSONObject)localObject3).optJSONArray("label");
            if (localObject1 != null)
            {
              localObject2 = new ArrayList();
              i1 = 0;
              int i2 = ((JSONArray)localObject1).length();
              if (i1 < i2)
              {
                try
                {
                  JSONObject localJSONObject1 = ((JSONArray)localObject1).getJSONObject(i1);
                  localObject4 = new GroupLabel();
                  NearbyGroup.Color localColor = new NearbyGroup.Color();
                  JSONObject localJSONObject2 = localJSONObject1.optJSONObject("edging_color");
                  localColor.R = localJSONObject2.optLong("r");
                  localColor.G = localJSONObject2.optLong("g");
                  localColor.B = localJSONObject2.optLong("b");
                  ((GroupLabel)localObject4).edging_color = localColor;
                  localColor = new NearbyGroup.Color();
                  localJSONObject2 = localJSONObject1.optJSONObject("text_color");
                  localColor.R = localJSONObject2.optLong("r");
                  localColor.G = localJSONObject2.optLong("g");
                  localColor.B = localJSONObject2.optLong("b");
                  ((GroupLabel)localObject4).text_color = localColor;
                  ((GroupLabel)localObject4).strWording = localJSONObject1.optString("name");
                  ((GroupLabel)localObject4).type = localJSONObject1.optLong("attr");
                  ((ArrayList)localObject2).add(localObject4);
                }
                catch (JSONException localJSONException2)
                {
                  if (!QLog.isColorLevel()) {
                    break label1344;
                  }
                }
                Object localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("parse extension JSONException:");
                ((StringBuilder)localObject4).append(localJSONException2.toString());
                QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, ((StringBuilder)localObject4).toString());
                break label1344;
              }
              this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
            }
            localObject2 = ((JSONObject)localObject3).optString("memo");
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131696146);
            }
            this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
            l1 = ((JSONObject)localObject3).optLong("active", 0L);
            long l2 = ((JSONObject)localObject3).optLong("join_group_flag", -1L);
            long l3 = ((JSONObject)localObject3).optLong("privilege_flag", 0L);
            this.jdField_r_of_type_JavaLangString = ((JSONObject)localObject3).optString("arithmetic");
            if (((JSONObject)localObject3).optInt("exact_search") != 1) {
              break label1351;
            }
            bool = true;
            this.jdField_d_of_type_Boolean = bool;
            this.jdField_c_of_type_Long = l1;
            if (l2 <= -1L) {
              break label1357;
            }
            i1 = 0;
            this.jdField_m_of_type_Int = i1;
            if ((0x200 & l3) == 0L) {
              break label1362;
            }
            bool = true;
            this.jdField_f_of_type_Boolean = bool;
            this.jdField_q_of_type_JavaLangString = ((JSONObject)localObject3).optString("join_group_auth");
            this.jdField_p_of_type_Int = ((JSONObject)localObject3).optInt("allow", -1);
            this.jdField_q_of_type_Int = ((JSONObject)localObject3).optInt("invite_only", 0);
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("(");
          ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(")");
          this.jdField_g_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
          this.jdField_d_of_type_Int = ((JSONObject)localObject3).optInt("gender");
          this.jdField_e_of_type_Int = ((JSONObject)localObject3).optInt("age");
          a(((JSONObject)localObject3).optString("college"), 1);
          if (((JSONObject)localObject3).optString("location").equals(((JSONObject)localObject3).optString("hometown")))
          {
            a(((JSONObject)localObject3).optString("location"), 4);
          }
          else
          {
            a(((JSONObject)localObject3).optString("location"), 4);
            a(((JSONObject)localObject3).optString("hometown"), 4);
          }
          a(((JSONObject)localObject3).optString("constellation"), 2);
          this.jdField_a_of_type_JavaLangCharSequence = ((JSONObject)localObject3).optString("location");
          this.jdField_j_of_type_JavaLangString = ((JSONObject)localObject3).optString("authIcon");
          this.jdField_s_of_type_JavaLangString = ((JSONObject)localObject3).optString("longnick");
          this.jdField_p_of_type_Int = ((JSONObject)localObject3).optInt("allow", -1);
          this.jdField_f_of_type_Int = ((JSONObject)localObject3).optInt("liangrichflag", 0);
          this.jdField_g_of_type_Int = ((JSONObject)localObject3).optInt("liangnumblevel", -1);
          try
          {
            this.jdField_l_of_type_Int = ((JSONObject)localObject3).optInt("cspecialflag");
            localObject2 = ((JSONObject)localObject3).optString("qdmasteruin");
            localObject1 = ((JSONObject)localObject3).optString("qdemailuin");
            this.jdField_p_of_type_JavaLangString = ((JSONObject)localObject3).optString("kfaccount");
            localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            QidianManager.a((QQAppInterface)localObject3, this.jdField_l_of_type_Int, this.jdField_b_of_type_JavaLangString);
            QidianManager.a((QQAppInterface)localObject3, this.jdField_b_of_type_JavaLangString, (String)localObject2);
            if ((QidianManager.b(this.jdField_l_of_type_Int)) || (QidianManager.c(this.jdField_l_of_type_Int)))
            {
              if (TextUtils.isEmpty((CharSequence)localObject1))
              {
                this.jdField_g_of_type_JavaLangString = "";
                QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "Parse search qidian json qdemailuin is empty ");
              }
              else
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("(");
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append(")");
                this.jdField_g_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
              }
              if (TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString)) {
                QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "Parse search qidian json kfaccount is empty ");
              }
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Parse search qidian json fail: ");
              ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
              ((StringBuilder)localObject2).append(" | ");
              ((StringBuilder)localObject2).append(localException.getMessage());
              QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
        if (!TextUtils.isEmpty(str))
        {
          this.jdField_b_of_type_JavaLangCharSequence = str;
          return;
        }
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
      return;
      label1343:
      return;
      label1344:
      i1 += 1;
      continue;
      label1351:
      boolean bool = false;
      continue;
      label1357:
      int i1 = 1;
      continue;
      label1362:
      bool = false;
    }
  }
  
  public int a()
  {
    if (d() == 1001) {
      return 1;
    }
    if (d() == 1002) {
      return 4;
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    int i1;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          i1 = -1;
        } else {
          i1 = this.jdField_t_of_type_Int;
        }
      }
      else {
        i1 = this.jdField_s_of_type_Int;
      }
    }
    else {
      i1 = this.jdField_r_of_type_Int;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPosition(). type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("  position=");
      localStringBuilder.append(i1);
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, localStringBuilder.toString());
    }
    return i1;
  }
  
  public CharSequence a()
  {
    Object localObject1 = new HighlightModel(this.jdField_a_of_type_JavaUtilList, b());
    this.jdField_a_of_type_JavaLangCharSequence = SearchUtils.a(this.jdField_a_of_type_JavaLangCharSequence);
    Object localObject2 = this.jdField_a_of_type_JavaLangCharSequence;
    boolean bool = false;
    localObject2 = ((HighlightModel)localObject1).a((CharSequence)localObject2, false, false, false);
    if (((HighlightModel)localObject1).jdField_a_of_type_Int > 0) {
      bool = true;
    }
    this.jdField_i_of_type_Boolean = bool;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    return localObject1;
  }
  
  public Object a(String paramString)
  {
    boolean bool2 = "ActiveEntitySearchResultPresenter_add_troop".equals(paramString);
    boolean bool1 = false;
    int i1;
    if (bool2)
    {
      paramString = BaseApplicationImpl.getApplication().getResources().getString(2131699488);
      i1 = this.jdField_m_of_type_Int;
      if (i1 != 0)
      {
        if (i1 != 1) {
          if (i1 == 2) {}
        }
        for (;;)
        {
          bool1 = true;
          break;
          paramString = BaseApplicationImpl.getApplication().getResources().getString(2131699489);
          break;
          paramString = BaseApplicationImpl.getApplication().getResources().getString(2131699488);
        }
      }
      paramString = BaseApplicationImpl.getApplication().getResources().getString(2131699490);
      return new Pair(paramString, Boolean.valueOf(bool1));
    }
    if ("ActiveEntitySearchResultPresenter_pay_troop".equals(paramString)) {
      return Boolean.valueOf(this.jdField_f_of_type_Boolean);
    }
    if ("ActiveEntitySearchResultPresenter_hot_troop".equals(paramString))
    {
      int i2 = (int)this.jdField_c_of_type_Long;
      i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
      i2 = i1;
      if (i1 > 10) {
        i2 = 10;
      }
      return Integer.valueOf(i2);
    }
    return super.a(paramString);
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onAction(). jumpUrl = ");
      ((StringBuilder)localObject1).append(this.jdField_e_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("  id=");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, ((StringBuilder)localObject1).toString());
    }
    int i1 = d();
    if (i1 != 1001)
    {
      if (i1 != 1002)
      {
        if (i1 == 268435456)
        {
          SearchUtils.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_JavaLangString, this.jdField_t_of_type_JavaLangString, e(), e());
          SearchUtils.a(this.jdField_a_of_type_JavaLangString, 120, 0, this.jdField_j_of_type_Int, paramView);
          localObject1 = this.jdField_t_of_type_JavaLangString;
          if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
            UniteSearchReportController.a(null, 0, this.jdField_a_of_type_Int, "0X8009D31", 4, 0, this.jdField_b_of_type_JavaLangString, null);
          } else if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))) {
            UniteSearchReportController.a(null, 0, this.jdField_a_of_type_Int, "0X8009D35", 0, 0, this.jdField_b_of_type_JavaLangString, null);
          } else {
            UniteSearchReportController.a(null, 0, this.jdField_a_of_type_Int, "0X8009D49", 0, 0, this.jdField_b_of_type_JavaLangString, null);
          }
        }
      }
      else {
        SearchUtils.a(this.jdField_a_of_type_JavaLangString, 80, 0, this.jdField_j_of_type_Int, paramView);
      }
    }
    else
    {
      SearchUtils.a(this.jdField_a_of_type_JavaLangString, 70, 0, this.jdField_j_of_type_Int, paramView);
      if (this.jdField_o_of_type_Int == 1)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 2, 0, "", "", "", "");
      }
      else
      {
        ReportController.b(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 0, 0, "", "", "", "");
        ReportController.b(null, "dc00898", "", "", "0X800A33A", "0X800A33A", 1, 0, "", "", "", "");
      }
    }
    if (this.jdField_a_of_type_Long == 1002L) {
      ReportUtil.a(this);
    }
    Object localObject2 = paramView.getContext();
    Object localObject4;
    Object localObject3;
    Object localObject5;
    Object localObject7;
    if ((localObject2 instanceof SearchInfoInterface))
    {
      localObject4 = (SearchInfoInterface)localObject2;
      ((SearchInfoInterface)localObject4).b();
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = ((SearchInfoInterface)localObject4).a();
      if ((localObject1 instanceof SearchFragmentInfoInterface)) {
        localObject1 = (SearchFragmentInfoInterface)localObject1;
      } else {
        localObject1 = null;
      }
      i1 = ((SearchInfoInterface)localObject4).a();
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 == 3)
          {
            if ((localObject1 != null) && (((SearchFragmentInfoInterface)localObject1).b()))
            {
              ((SearchFragmentInfoInterface)localObject1).a(true);
              localObject1 = ((SearchInfoInterface)localObject4).a();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("");
              ((StringBuilder)localObject3).append(this.jdField_a_of_type_Long);
              localObject3 = ((StringBuilder)localObject3).toString();
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("");
              ((StringBuilder)localObject5).append(a(2));
              SearchUtils.a("sub_result", "clk_sub_first_result", new String[] { localObject1, localObject3, ((StringBuilder)localObject5).toString(), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject4).a()) });
            }
            localObject1 = ((SearchInfoInterface)localObject4).a();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(this.jdField_a_of_type_Long);
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("");
            ((StringBuilder)localObject5).append(a(2));
            SearchUtils.a("sub_result", "clk_result", new String[] { localObject1, localObject3, ((StringBuilder)localObject5).toString(), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject4).a()) });
            localObject1 = "all_result";
            break label1877;
          }
        }
        else
        {
          if ((localObject1 != null) && (((SearchFragmentInfoInterface)localObject1).b()))
          {
            ((SearchFragmentInfoInterface)localObject1).a(true);
            localObject1 = ((SearchInfoInterface)localObject4).a();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(this.jdField_a_of_type_Long);
            localObject3 = ((StringBuilder)localObject3).toString();
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("");
            ((StringBuilder)localObject5).append(a(2));
            SearchUtils.a("all_result", "clk_tab_first_result", new String[] { localObject1, localObject3, ((StringBuilder)localObject5).toString(), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject4).a()) });
          }
          localObject1 = ((SearchInfoInterface)localObject4).a();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("");
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_Long);
          SearchUtils.a("all_result", "clk_tab_result", new String[] { localObject1, ((StringBuilder)localObject3).toString(), "", SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject4).a()) });
        }
      }
      else
      {
        localObject3 = "all_result";
        Object localObject6;
        StringBuilder localStringBuilder2;
        Object localObject8;
        if ((SearchUtils.b.containsKey(this)) && (d() != 268435456))
        {
          localObject6 = (SearchUtils.ObjectItemInfo)SearchUtils.b.get(this);
          localObject5 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localObject7 = new JSONObject();
          try
          {
            ((JSONObject)localObject7).put("project", UniteSearchReportController.a());
            ((JSONObject)localObject7).put("event_src", "client");
            ((JSONObject)localObject7).put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject6).jdField_a_of_type_Int);
            ((JSONObject)localObject7).put("get_src", "web");
          }
          catch (JSONException localJSONException2)
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("e = ");
            localStringBuilder2.append(localJSONException2);
            QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, localStringBuilder2.toString());
          }
          localObject8 = new ReportModelDC02528().module((String)localObject3).action("clk_item");
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(this.jdField_a_of_type_Long);
          localStringBuilder2.append("");
          localObject6 = ((ReportModelDC02528)localObject8).obj1(localStringBuilder2.toString()).obj2(((SearchUtils.ObjectItemInfo)localObject6).jdField_b_of_type_JavaLangString).ver1(this.jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(this.jdField_a_of_type_Int)).ver7(((JSONObject)localObject7).toString());
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append(((QQAppInterface)localObject5).getCurrentAccountUin());
          ((StringBuilder)localObject7).append(SearchUtils.d);
          UniteSearchReportController.a(null, ((ReportModelDC02528)localObject6).session_id(((StringBuilder)localObject7).toString()));
        }
        if (SearchUtils.a(this.jdField_a_of_type_Long))
        {
          if (SearchUtils.a.containsKey(this))
          {
            localObject5 = (SearchUtils.ObjectItemInfo)SearchUtils.a.get(this);
            if (((SearchUtils.ObjectItemInfo)localObject5).jdField_b_of_type_Boolean) {
              i1 = 2;
            } else {
              i1 = 1;
            }
            localObject6 = this.jdField_a_of_type_JavaLangString;
            localObject7 = new StringBuilder();
            ((StringBuilder)localObject7).append("");
            ((StringBuilder)localObject7).append(this.jdField_a_of_type_Long);
            localObject7 = ((StringBuilder)localObject7).toString();
            localObject8 = new StringBuilder();
            ((StringBuilder)localObject8).append(((SearchUtils.ObjectItemInfo)localObject5).jdField_b_of_type_JavaLangString);
            ((StringBuilder)localObject8).append("");
            localObject8 = ((StringBuilder)localObject8).toString();
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append(((SearchUtils.ObjectItemInfo)localObject5).jdField_a_of_type_Int);
            localStringBuilder2.append("");
            SearchUtils.a((String)localObject3, "clk_object", i1, 0, new String[] { localObject6, localObject7, localObject8, localStringBuilder2.toString() });
          }
          if ((localObject1 != null) && (((SearchFragmentInfoInterface)localObject1).b()))
          {
            ((SearchFragmentInfoInterface)localObject1).a(true);
            localObject1 = ((SearchInfoInterface)localObject4).a();
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("");
            ((StringBuilder)localObject5).append(this.jdField_a_of_type_Long);
            localObject5 = ((StringBuilder)localObject5).toString();
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("");
            ((StringBuilder)localObject6).append(a(3));
            SearchUtils.a((String)localObject3, "clk_first_result", new String[] { localObject1, localObject5, ((StringBuilder)localObject6).toString(), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject4).a()) });
          }
        }
        else
        {
          if (SearchUtil.jdField_b_of_type_Boolean) {
            i1 = 2;
          } else {
            i1 = 1;
          }
          localObject5 = ((SearchInfoInterface)localObject4).a();
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("");
          ((StringBuilder)localObject6).append(this.jdField_a_of_type_Long);
          SearchUtils.a((String)localObject3, "clk_content", i1, 0, new String[] { localObject5, ((StringBuilder)localObject6).toString(), "", SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject4).a()) });
          if ((localObject1 != null) && (((SearchFragmentInfoInterface)localObject1).b()))
          {
            ((SearchFragmentInfoInterface)localObject1).a(true);
            localObject1 = ((SearchInfoInterface)localObject4).a();
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("");
            ((StringBuilder)localObject5).append(this.jdField_a_of_type_Long);
            localObject5 = ((StringBuilder)localObject5).toString();
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("");
            ((StringBuilder)localObject6).append(a(2));
            SearchUtils.a((String)localObject3, "clk_first_result", new String[] { localObject1, localObject5, ((StringBuilder)localObject6).toString(), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject4).a()) });
            localObject1 = localObject3;
            break label1877;
          }
        }
      }
    }
    Object localObject1 = "all_result";
    label1877:
    i1 = 4;
    if (d() == 268435456)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(this.jdField_b_of_type_JavaLangString);
      localObject4 = ((StringBuilder)localObject4).toString();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("");
      ((StringBuilder)localObject5).append(this.jdField_j_of_type_Int + 1);
      SearchUtils.a((String)localObject1, "clk_function", new String[] { localObject3, localObject4, ((StringBuilder)localObject5).toString() });
      if ("63".equals(a()))
      {
        localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).startNewWeatherWebPageActivity(paramView.getContext(), (AppInterface)localObject3)) {
          return;
        }
      }
      if (((paramView.getContext() instanceof UniteSearchActivity)) && (SearchUtils.b.containsKey(this)))
      {
        localObject4 = (SearchUtils.ObjectItemInfo)SearchUtils.b.get(this);
        localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject5 = new JSONObject();
        try
        {
          ((JSONObject)localObject5).put("project", UniteSearchReportController.a());
          ((JSONObject)localObject5).put("event_src", "client");
          ((JSONObject)localObject5).put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject4).jdField_a_of_type_Int);
          ((JSONObject)localObject5).put("get_src", "native");
        }
        catch (JSONException localJSONException1)
        {
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append("e = ");
          ((StringBuilder)localObject7).append(localJSONException1);
          QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, ((StringBuilder)localObject7).toString());
        }
        localObject1 = new ReportModelDC02528().module((String)localObject1).action("clk_item");
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(((SearchUtils.ObjectItemInfo)localObject4).jdField_a_of_type_Long);
        localStringBuilder1.append("");
        localObject1 = ((ReportModelDC02528)localObject1).obj1(localStringBuilder1.toString()).obj2(((SearchUtils.ObjectItemInfo)localObject4).jdField_b_of_type_JavaLangString).ver1(((SearchUtils.ObjectItemInfo)localObject4).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(UniteSearchActivity.jdField_d_of_type_Int)).ver7(((JSONObject)localObject5).toString());
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((QQAppInterface)localObject3).getCurrentAccountUin());
        ((StringBuilder)localObject4).append(SearchUtils.d);
        UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).session_id(((StringBuilder)localObject4).toString()));
      }
    }
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      localObject1 = this.jdField_e_of_type_JavaLangString;
      if ("3".equals(this.jdField_b_of_type_JavaLangString)) {
        localObject1 = VasWebviewUtil.a(this.jdField_e_of_type_JavaLangString, 55);
      }
      if ((!((String)localObject1).startsWith("http")) && (!((String)localObject1).startsWith("https")))
      {
        if ((localObject2 instanceof BaseActivity))
        {
          paramView = JumpParser.a(((BaseActivity)paramView.getContext()).app, (Context)localObject2, (String)localObject1);
          if (paramView != null)
          {
            paramView.a();
            return;
          }
          ((Context)localObject2).startActivity(new Intent((Context)localObject2, JumpActivity.class).setData(Uri.parse((String)localObject1)));
          return;
        }
        ((Context)localObject2).startActivity(new Intent((Context)localObject2, JumpActivity.class).setData(Uri.parse((String)localObject1)));
        return;
      }
      paramView = new Intent((Context)localObject2, QQBrowserActivity.class);
      paramView.putExtra("url", (String)localObject1);
      ((Context)localObject2).startActivity(paramView);
      return;
    }
    long l1 = this.jdField_a_of_type_Long;
    if (l1 == 268435456L)
    {
      SearchUtils.a(paramView.getContext(), Integer.valueOf(this.jdField_b_of_type_JavaLangString).intValue(), this.jdField_a_of_type_Int);
      return;
    }
    boolean bool;
    if (l1 == 1001L)
    {
      bool = b();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onAction mobileNumberResult = ");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append(",id = ");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
        QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject2 = new SearchResultItem();
      ((SearchResultItem)localObject2).jdField_a_of_type_Long = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
    }
    try
    {
      if ((!QidianManager.b(this.jdField_l_of_type_Int)) && (!QidianManager.c(this.jdField_l_of_type_Int))) {
        break label2723;
      }
      ((SearchResultItem)localObject2).jdField_a_of_type_Long = Long.valueOf(this.jdField_p_of_type_JavaLangString).longValue();
    }
    catch (Exception localException)
    {
      label2714:
      int i3;
      int i2;
      break label2714;
    }
    QLog.i("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "qidian corp jump error");
    label2723:
    ((SearchResultItem)localObject2).jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    if (RobotUtils.a((QQAppInterface)localObject1, this.jdField_b_of_type_JavaLangString))
    {
      RobotUtils.a(paramView.getContext(), null, this.jdField_b_of_type_JavaLangString);
      return;
    }
    if (this.jdField_a_of_type_Int != 99) {
      i1 = 3;
    }
    if (bool)
    {
      ((SearchResultItem)localObject2).jdField_a_of_type_Long = 0L;
      ((SearchResultItem)localObject2).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    }
    AddFriendActivity.a((Activity)paramView.getContext(), (SearchResultItem)localObject2, (QQAppInterface)localObject1, true, i1);
    return;
    if (l1 == 1002L)
    {
      localObject1 = paramView.getContext();
      if ((localObject1 instanceof Activity))
      {
        localObject3 = ((Activity)localObject1).getIntent();
        if (localObject3 != null)
        {
          i3 = ((Intent)localObject3).getIntExtra("from_type_for_report", 0);
          break label2863;
        }
      }
      i3 = 0;
      label2863:
      if (i3 == 9) {
        i2 = 112;
      } else {
        i2 = 103;
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
              if (localObject1[0] == 1002L) {
                if (i3 == 9) {
                  i1 = 113;
                } else {
                  i1 = 104;
                }
              }
            }
          }
        }
      }
      if ((i1 != 103) && (i1 != 104))
      {
        if ((i1 == 112) || (i1 == 113)) {
          if (this.jdField_d_of_type_Boolean) {
            i1 = 30018;
          } else {
            i1 = 30020;
          }
        }
      }
      else if (this.jdField_d_of_type_Boolean) {
        i1 = 30014;
      } else {
        i1 = 30016;
      }
      localObject1 = TroopInfoUIUtil.a(this.jdField_b_of_type_JavaLangString, i1);
      ((Bundle)localObject1).putInt("exposureSource", 3);
      ((Bundle)localObject1).putString("keyword", b());
      ((Bundle)localObject1).putBoolean("isFromNative", true);
      ((Bundle)localObject1).putInt("t_s_f", 1000);
      ((Bundle)localObject1).putString("authSig", this.jdField_q_of_type_JavaLangString);
      TroopUtils.a(paramView.getContext(), (Bundle)localObject1, 2);
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
      if (paramInt == 3)
      {
        if (this.jdField_b_of_type_JavaUtilList.size() > 2)
        {
          int i1 = this.jdField_d_of_type_Int;
          if ((i1 == 1) || (i1 == 2)) {}
        }
        else
        {
          if (this.jdField_b_of_type_JavaUtilList.size() <= 3) {
            break label78;
          }
        }
        return;
      }
      label78:
      MayKnowRecommend.MayKnowRecommendLabel localMayKnowRecommendLabel = new MayKnowRecommend.MayKnowRecommendLabel();
      localMayKnowRecommendLabel.text_color = -1;
      localMayKnowRecommendLabel.bytes_name = paramString;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 4) {
              localMayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#C573FF");
            }
          }
          else {
            localMayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#FF8A2D");
          }
        }
        else {
          localMayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#FFC619");
        }
      }
      else {
        localMayKnowRecommendLabel.edging_color = android.graphics.Color.parseColor("#7373FF");
      }
      this.jdField_b_of_type_JavaUtilList.add(localMayKnowRecommendLabel);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(long paramLong, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("JSONObject info:");
      localStringBuilder.append(paramJSONObject);
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, localStringBuilder.toString());
    }
    if (paramJSONObject == null) {}
    return false;
  }
  
  public int b()
  {
    return this.w;
  }
  
  public CharSequence b()
  {
    int i1 = d();
    boolean bool = false;
    if (i1 == 268435456) {
      try
      {
        CharSequence localCharSequence = SearchUtils.a(this.jdField_c_of_type_JavaLangString, b(), true);
        return localCharSequence;
      }
      catch (Exception localException)
      {
        QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, localException, new Object[0]);
        return this.jdField_c_of_type_JavaLangString;
      }
    }
    Object localObject = new HighlightModel(this.jdField_a_of_type_JavaUtilList, b());
    if (d() == 1002)
    {
      this.jdField_c_of_type_JavaLangString = SearchUtils.a(this.jdField_c_of_type_JavaLangString);
      localSpannableString = ((HighlightModel)localObject).a(this.jdField_c_of_type_JavaLangString, true);
      localObject = localSpannableString;
      if (localSpannableString == null) {
        localObject = "";
      }
      return localObject;
    }
    this.jdField_c_of_type_JavaLangString = SearchUtils.a(this.jdField_c_of_type_JavaLangString);
    SpannableString localSpannableString = ((HighlightModel)localObject).a(this.jdField_c_of_type_JavaLangString, true);
    if (((HighlightModel)localObject).jdField_a_of_type_Int > 0) {
      bool = true;
    }
    this.jdField_h_of_type_Boolean = bool;
    localObject = localSpannableString;
    if (localSpannableString == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return;
        }
        this.jdField_t_of_type_Int = paramInt2;
        return;
      }
      this.jdField_s_of_type_Int = paramInt2;
      return;
    }
    this.jdField_r_of_type_Int = paramInt2;
  }
  
  public boolean b()
  {
    boolean bool3 = TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3) {
      try
      {
        int i1 = new JSONObject(this.jdField_f_of_type_JavaLangString).optInt("is_mobile_no", 0);
        bool1 = bool2;
        if (i1 == 1) {
          bool1 = true;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "isMobileNumberSearchResult JSONException", localJSONException);
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isMobileNumberSearchResult result = ");
      localStringBuilder.append(bool1);
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public CharSequence c()
  {
    HighlightModel localHighlightModel = new HighlightModel(this.jdField_a_of_type_JavaUtilList, b());
    boolean bool = TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString);
    Object localObject1 = null;
    Object localObject2 = null;
    if (!bool)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append(this.jdField_h_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(")");
      localObject2 = SearchUtils.a(((StringBuilder)localObject2).toString());
    }
    else if (this.jdField_f_of_type_Int == 1)
    {
      this.jdField_g_of_type_JavaLangString = SearchUtils.a(this.jdField_g_of_type_JavaLangString);
      LhLogoResources localLhLogoResources = PrettyAccountUtil.a(this.jdField_g_of_type_Int);
      localObject1 = localObject2;
      if (localLhLogoResources != null) {
        localObject1 = localLhLogoResources.lightColor;
      }
      localObject2 = PrettyAccountUtil.a(this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, this.jdField_g_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
    else
    {
      localObject2 = SearchUtils.a(this.jdField_g_of_type_JavaLangString);
    }
    localObject2 = localHighlightModel.a((CharSequence)localObject2, (String)localObject1, false, false, true);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    return localObject1;
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
    if ((!this.jdField_h_of_type_Boolean) && (!this.jdField_i_of_type_Boolean))
    {
      SpannableString localSpannableString = new HighlightModel(this.jdField_a_of_type_JavaUtilList, b()).a(this.jdField_b_of_type_JavaLangCharSequence, false, this.jdField_a_of_type_Boolean);
      Object localObject = localSpannableString;
      if (localSpannableString == null) {
        localObject = "";
      }
      return localObject;
    }
    return this.jdField_b_of_type_JavaLangCharSequence;
  }
  
  public String d()
  {
    String str = this.jdField_r_of_type_JavaLangString;
    if (str != null) {
      return str;
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
  
  public int f_()
  {
    return this.x;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem
 * JD-Core Version:    0.7.0.1
 */