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
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
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
  public String A;
  public String B;
  public int C;
  public String D;
  public String E;
  public String F;
  public boolean G;
  public int[] H = new int[3];
  public boolean I;
  StringBuffer J = new StringBuffer();
  Context K = BaseApplicationImpl.getContext();
  public int L;
  public int M = 0;
  public boolean N = false;
  public int O;
  public String P;
  public boolean Q;
  public int R;
  public long S;
  public String T;
  public String U = "";
  public List<RecommendLabel> V;
  public String W = null;
  public int X;
  public int Y = -1;
  public int Z = -1;
  protected String a;
  public int aa;
  public String ab;
  public int ac;
  public int ad;
  public int ae;
  private int ai;
  private int aj;
  private boolean ak = false;
  private boolean al = false;
  private int am = 0;
  private String an;
  public String b;
  public String c;
  protected String d;
  public String e;
  protected String f;
  protected long g;
  protected CharSequence h;
  protected CharSequence i;
  protected String j;
  protected boolean k = false;
  public List<String> l;
  public int m;
  public String n;
  public boolean o = false;
  public int p;
  public int q = 2131168119;
  public int r;
  public int s;
  public int t;
  public int u = -1;
  public long v;
  public String w;
  public String x;
  public int y = -1;
  public ArrayList<GroupLabel> z;
  
  public GroupBaseNetSearchModelItem() {}
  
  public GroupBaseNetSearchModelItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, List<String> paramList, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramLong;
    this.l = paramList;
    this.m = paramInt;
    this.Q = false;
    this.R = 1;
    this.S = 0L;
    s();
    r();
  }
  
  public GroupBaseNetSearchModelItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, List<String> paramList, int paramInt1, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, String paramString11)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramLong;
    this.l = paramList;
    this.m = paramInt1;
    this.A = paramString7;
    this.B = paramString8;
    this.C = paramInt2;
    this.D = paramString9;
    this.E = paramString10;
    this.F = paramString11;
    this.Q = false;
    this.R = 1;
    this.S = 0L;
    s();
    r();
  }
  
  private void s()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("extension info:");
      ((StringBuilder)localObject1).append(this.f);
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, ((StringBuilder)localObject1).toString());
    }
    if (!TextUtils.isEmpty(this.f)) {}
    for (;;)
    {
      try
      {
        Object localObject3 = new JSONObject(this.f);
        String str = ((JSONObject)localObject3).optString("thirdLineText");
        if (a(this.g, (JSONObject)localObject3))
        {
          if (!QLog.isColorLevel()) {
            break label1430;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("child class has already parsed json data. groupMask=");
          ((StringBuilder)localObject1).append(this.g);
          QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, ((StringBuilder)localObject1).toString());
          return;
        }
        long l1 = this.g;
        i1 = (int)l1;
        Object localObject2;
        if (i1 != 1001)
        {
          localObject1 = "Q.uniteSearch.GroupBaseNetSearchModelItem";
          if (i1 != 1002)
          {
            if (i1 != 1107)
            {
              if (i1 == 1073745984)
              {
                this.p = ((JSONObject)localObject3).optInt("video_or_music");
                localObject1 = ((JSONObject)localObject3).optString("busi_mask");
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  if (Integer.parseInt((String)localObject1) == 2049) {
                    this.h = ((JSONObject)localObject3).optString("brief");
                  } else if (Integer.parseInt((String)localObject1) == 64) {
                    this.h = ((JSONObject)localObject3).optString("content");
                  } else if (Integer.parseInt((String)localObject1) == 4096) {
                    this.h = ((JSONObject)localObject3).optString("description");
                  }
                  localObject1 = ((JSONObject)localObject3).optString("from");
                  localObject2 = DateUtil.a(Long.parseLong(((JSONObject)localObject3).optString("create_time")));
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append((String)localObject1);
                  ((StringBuilder)localObject3).append((String)localObject2);
                  this.i = ((StringBuilder)localObject3).toString();
                  this.k = true;
                }
              }
            }
            else
            {
              if (((JSONObject)localObject3).optLong("join_flag", -1L) <= 0L) {
                break label1431;
              }
              i1 = 0;
              this.R = i1;
              this.T = ((JSONObject)localObject3).optString("join_guild_sig");
              this.d = ((JSONObject)localObject3).optString("avatar", this.d);
              this.ab = ((JSONObject)localObject3).optString("guild_code");
              this.o = true;
            }
          }
          else
          {
            this.v = ((JSONObject)localObject3).optLong("flag_ext");
            this.j = "";
            localObject2 = ((JSONObject)localObject3).optJSONArray("label");
            if (localObject2 != null)
            {
              ArrayList localArrayList = new ArrayList();
              i1 = 0;
              int i2 = ((JSONArray)localObject2).length();
              if (i1 < i2)
              {
                try
                {
                  JSONObject localJSONObject1 = ((JSONArray)localObject2).getJSONObject(i1);
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
                  localArrayList.add(localObject4);
                }
                catch (JSONException localJSONException2)
                {
                  if (!QLog.isColorLevel()) {
                    break label1436;
                  }
                }
                Object localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("parse extension JSONException:");
                ((StringBuilder)localObject4).append(localJSONException2.toString());
                QLog.e((String)localObject1, 2, ((StringBuilder)localObject4).toString());
                break label1436;
              }
              this.z = localArrayList;
            }
            localObject2 = ((JSONObject)localObject3).optString("memo");
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = this.K.getString(2131893911);
            }
            this.h = ((CharSequence)localObject1);
            l1 = ((JSONObject)localObject3).optLong("active", 0L);
            long l2 = ((JSONObject)localObject3).optLong("join_group_flag", -1L);
            long l3 = ((JSONObject)localObject3).optLong("privilege_flag", 0L);
            this.U = ((JSONObject)localObject3).optString("arithmetic");
            if (((JSONObject)localObject3).optInt("exact_search") != 1) {
              break label1443;
            }
            bool = true;
            this.I = bool;
            this.S = l1;
            if (l2 <= -1L) {
              break label1449;
            }
            i1 = 0;
            this.R = i1;
            if ((0x200 & l3) == 0L) {
              break label1454;
            }
            bool = true;
            this.Q = bool;
            this.T = ((JSONObject)localObject3).optString("join_group_auth");
            this.Z = ((JSONObject)localObject3).optInt("allow", -1);
            this.aa = ((JSONObject)localObject3).optInt("invite_only", 0);
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("(");
          ((StringBuilder)localObject1).append(this.b);
          ((StringBuilder)localObject1).append(")");
          this.j = ((StringBuilder)localObject1).toString();
          this.r = ((JSONObject)localObject3).optInt("gender");
          this.s = ((JSONObject)localObject3).optInt("age");
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
          this.h = ((JSONObject)localObject3).optString("location");
          this.x = ((JSONObject)localObject3).optString("authIcon");
          this.W = ((JSONObject)localObject3).optString("longnick");
          this.Z = ((JSONObject)localObject3).optInt("allow", -1);
          this.t = ((JSONObject)localObject3).optInt("liangrichflag", 0);
          this.u = ((JSONObject)localObject3).optInt("liangnumblevel", -1);
          try
          {
            this.O = ((JSONObject)localObject3).optInt("cspecialflag");
            localObject2 = ((JSONObject)localObject3).optString("qdmasteruin");
            localObject1 = ((JSONObject)localObject3).optString("qdemailuin");
            this.P = ((JSONObject)localObject3).optString("kfaccount");
            localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            QidianManager.a((QQAppInterface)localObject3, this.O, this.b);
            QidianManager.a((QQAppInterface)localObject3, this.b, (String)localObject2);
            if ((QidianManager.b(this.O)) || (QidianManager.c(this.O)))
            {
              if (TextUtils.isEmpty((CharSequence)localObject1))
              {
                this.j = "";
                QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "Parse search qidian json qdemailuin is empty ");
              }
              else
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("(");
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append(")");
                this.j = ((StringBuilder)localObject2).toString();
              }
              if (TextUtils.isEmpty(this.P)) {
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
              ((StringBuilder)localObject2).append(this.b);
              ((StringBuilder)localObject2).append(" | ");
              ((StringBuilder)localObject2).append(localException.getMessage());
              QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
        if (!TextUtils.isEmpty(str))
        {
          this.i = str;
          return;
        }
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
      return;
      label1430:
      return;
      label1431:
      int i1 = 1;
      continue;
      label1436:
      i1 += 1;
      continue;
      label1443:
      boolean bool = false;
      continue;
      label1449:
      i1 = 1;
      continue;
      label1454:
      bool = false;
    }
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
          i1 = this.ae;
        }
      }
      else {
        i1 = this.ad;
      }
    }
    else {
      i1 = this.ac;
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
    Object localObject1 = new HighlightModel(this.l, g());
    this.h = SearchUtils.b(this.h);
    Object localObject2 = this.h;
    boolean bool = false;
    localObject2 = ((HighlightModel)localObject1).a((CharSequence)localObject2, false, false, false);
    if (((HighlightModel)localObject1).b > 0) {
      bool = true;
    }
    this.al = bool;
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
      paramString = BaseApplicationImpl.getApplication().getResources().getString(2131897519);
      i1 = this.R;
      if (i1 != 0)
      {
        if (i1 != 1) {
          if (i1 == 2) {}
        }
        for (;;)
        {
          bool1 = true;
          break;
          paramString = BaseApplicationImpl.getApplication().getResources().getString(2131897520);
          break;
          paramString = BaseApplicationImpl.getApplication().getResources().getString(2131897519);
        }
      }
      paramString = BaseApplicationImpl.getApplication().getResources().getString(2131897521);
      return new Pair(paramString, Boolean.valueOf(bool1));
    }
    if ("ActiveEntitySearchResultPresenter_pay_troop".equals(paramString)) {
      return Boolean.valueOf(this.Q);
    }
    if ("ActiveEntitySearchResultPresenter_hot_troop".equals(paramString))
    {
      int i2 = (int)this.S;
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
  
  public void a(int paramInt1, int paramInt2)
  {
    this.ai = paramInt1;
    this.aj = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b(2, paramInt1);
    b(1, paramInt2);
    b(3, paramInt3);
  }
  
  public void a(View paramView)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onAction(). jumpUrl = ");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append("  id=");
      ((StringBuilder)localObject1).append(this.b);
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, ((StringBuilder)localObject1).toString());
    }
    int i1 = j();
    if (i1 != 1001)
    {
      if (i1 != 1002)
      {
        if (i1 == 268435456)
        {
          SearchUtils.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.a, this.an, o(), p());
          SearchUtils.a(this.a, 120, 0, this.L, paramView);
          localObject1 = this.an;
          if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
            UniteSearchReportController.a(null, 0, this.m, "0X8009D31", 4, 0, this.b, null);
          } else if (q()) {
            UniteSearchReportController.a(null, 0, this.m, "0X8009D35", 0, 0, this.b, null);
          } else {
            UniteSearchReportController.a(null, 0, this.m, "0X8009D49", 0, 0, this.b, null);
          }
        }
      }
      else {
        SearchUtils.a(this.a, 80, 0, this.L, paramView);
      }
    }
    else
    {
      SearchUtils.a(this.a, 70, 0, this.L, paramView);
      if (this.Y == 1)
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
    if (this.g == 1002L) {
      ReportUtil.a(this);
    }
    Object localObject2 = paramView.getContext();
    Object localObject3;
    Object localObject4;
    Object localObject6;
    if ((localObject2 instanceof SearchInfoInterface))
    {
      localObject3 = (SearchInfoInterface)localObject2;
      ((SearchInfoInterface)localObject3).m();
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = ((SearchInfoInterface)localObject3).n();
      if ((localObject1 instanceof SearchFragmentInfoInterface)) {
        localObject1 = (SearchFragmentInfoInterface)localObject1;
      } else {
        localObject1 = null;
      }
      i1 = ((SearchInfoInterface)localObject3).i();
      Object localObject5;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label1843;
          }
          if ((localObject1 != null) && (((SearchFragmentInfoInterface)localObject1).dm_()))
          {
            ((SearchFragmentInfoInterface)localObject1).a(true);
            localObject1 = ((SearchInfoInterface)localObject3).h();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("");
            ((StringBuilder)localObject4).append(this.g);
            localObject4 = ((StringBuilder)localObject4).toString();
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("");
            ((StringBuilder)localObject5).append(a(2));
            SearchUtils.a("sub_result", "clk_sub_first_result", new String[] { localObject1, localObject4, ((StringBuilder)localObject5).toString(), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).j()) });
          }
          localObject1 = ((SearchInfoInterface)localObject3).h();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("");
          ((StringBuilder)localObject4).append(this.g);
          localObject4 = ((StringBuilder)localObject4).toString();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("");
          ((StringBuilder)localObject5).append(a(2));
          SearchUtils.a("sub_result", "clk_result", new String[] { localObject1, localObject4, ((StringBuilder)localObject5).toString(), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).j()) });
        }
        else
        {
          if ((localObject1 != null) && (((SearchFragmentInfoInterface)localObject1).dm_()))
          {
            ((SearchFragmentInfoInterface)localObject1).a(true);
            localObject1 = ((SearchInfoInterface)localObject3).h();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("");
            ((StringBuilder)localObject4).append(this.g);
            localObject4 = ((StringBuilder)localObject4).toString();
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("");
            ((StringBuilder)localObject5).append(a(2));
            SearchUtils.a("all_result", "clk_tab_first_result", new String[] { localObject1, localObject4, ((StringBuilder)localObject5).toString(), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).j()) });
          }
          localObject1 = ((SearchInfoInterface)localObject3).h();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("");
          ((StringBuilder)localObject4).append(this.g);
          SearchUtils.a("all_result", "clk_tab_result", new String[] { localObject1, ((StringBuilder)localObject4).toString(), "", SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).j()) });
        }
      }
      else
      {
        StringBuilder localStringBuilder;
        Object localObject7;
        if ((SearchUtils.l.containsKey(this)) && (j() != 268435456))
        {
          localObject5 = (SearchUtils.ObjectItemInfo)SearchUtils.l.get(this);
          localObject4 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localObject6 = new JSONObject();
          try
          {
            ((JSONObject)localObject6).put("project", UniteSearchReportController.a());
            ((JSONObject)localObject6).put("event_src", "client");
            ((JSONObject)localObject6).put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject5).c);
            ((JSONObject)localObject6).put("get_src", "web");
          }
          catch (JSONException localJSONException2)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("e = ");
            localStringBuilder.append(localJSONException2);
            QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, localStringBuilder.toString());
          }
          localObject7 = new ReportModelDC02528().module("all_result").action("clk_item");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.g);
          localStringBuilder.append("");
          localObject5 = ((ReportModelDC02528)localObject7).obj1(localStringBuilder.toString()).obj2(((SearchUtils.ObjectItemInfo)localObject5).e).ver1(this.a).ver2(UniteSearchReportController.a(this.m)).ver7(((JSONObject)localObject6).toString());
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append(((QQAppInterface)localObject4).getCurrentAccountUin());
          ((StringBuilder)localObject6).append(SearchUtils.j);
          UniteSearchReportController.a(null, ((ReportModelDC02528)localObject5).session_id(((StringBuilder)localObject6).toString()));
        }
        if (SearchUtils.a(this.g))
        {
          if (SearchUtils.k.containsKey(this))
          {
            localObject4 = (SearchUtils.ObjectItemInfo)SearchUtils.k.get(this);
            if (((SearchUtils.ObjectItemInfo)localObject4).f) {
              i1 = 2;
            } else {
              i1 = 1;
            }
            localObject5 = this.a;
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("");
            ((StringBuilder)localObject6).append(this.g);
            localObject6 = ((StringBuilder)localObject6).toString();
            localObject7 = new StringBuilder();
            ((StringBuilder)localObject7).append(((SearchUtils.ObjectItemInfo)localObject4).e);
            ((StringBuilder)localObject7).append("");
            localObject7 = ((StringBuilder)localObject7).toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(((SearchUtils.ObjectItemInfo)localObject4).c);
            localStringBuilder.append("");
            SearchUtils.a("all_result", "clk_object", i1, 0, new String[] { localObject5, localObject6, localObject7, localStringBuilder.toString() });
          }
          if ((localObject1 != null) && (((SearchFragmentInfoInterface)localObject1).dm_()))
          {
            ((SearchFragmentInfoInterface)localObject1).a(true);
            localObject1 = ((SearchInfoInterface)localObject3).h();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("");
            ((StringBuilder)localObject4).append(this.g);
            localObject4 = ((StringBuilder)localObject4).toString();
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("");
            ((StringBuilder)localObject5).append(a(3));
            SearchUtils.a("all_result", "clk_first_result", new String[] { localObject1, localObject4, ((StringBuilder)localObject5).toString(), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).j()) });
          }
        }
        else
        {
          if (SearchUtil.b) {
            i1 = 2;
          } else {
            i1 = 1;
          }
          localObject4 = ((SearchInfoInterface)localObject3).h();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("");
          ((StringBuilder)localObject5).append(this.g);
          SearchUtils.a("all_result", "clk_content", i1, 0, new String[] { localObject4, ((StringBuilder)localObject5).toString(), "", SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).j()) });
          if ((localObject1 != null) && (((SearchFragmentInfoInterface)localObject1).dm_()))
          {
            ((SearchFragmentInfoInterface)localObject1).a(true);
            localObject1 = ((SearchInfoInterface)localObject3).h();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("");
            ((StringBuilder)localObject4).append(this.g);
            localObject4 = ((StringBuilder)localObject4).toString();
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("");
            ((StringBuilder)localObject5).append(a(2));
            SearchUtils.a("all_result", "clk_first_result", new String[] { localObject1, localObject4, ((StringBuilder)localObject5).toString(), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).j()) });
          }
        }
      }
    }
    label1843:
    i1 = 4;
    if (j() == 268435456)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(this.a);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.b);
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(this.L + 1);
      SearchUtils.a("all_result", "clk_function", new String[] { localObject1, localObject3, ((StringBuilder)localObject4).toString() });
      if ("63".equals(c()))
      {
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).startNewWeatherWebPageActivity(paramView.getContext(), (AppInterface)localObject1)) {
          return;
        }
      }
      if (((paramView.getContext() instanceof UniteSearchActivity)) && (SearchUtils.l.containsKey(this)))
      {
        localObject3 = (SearchUtils.ObjectItemInfo)SearchUtils.l.get(this);
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject4 = new JSONObject();
        try
        {
          ((JSONObject)localObject4).put("project", UniteSearchReportController.a());
          ((JSONObject)localObject4).put("event_src", "client");
          ((JSONObject)localObject4).put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject3).c);
          ((JSONObject)localObject4).put("get_src", "native");
        }
        catch (JSONException localJSONException1)
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("e = ");
          ((StringBuilder)localObject6).append(localJSONException1);
          QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, ((StringBuilder)localObject6).toString());
        }
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("clk_item");
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append(((SearchUtils.ObjectItemInfo)localObject3).b);
        ((StringBuilder)localObject6).append("");
        localObject3 = localReportModelDC02528.obj1(((StringBuilder)localObject6).toString()).obj2(((SearchUtils.ObjectItemInfo)localObject3).e).ver1(((SearchUtils.ObjectItemInfo)localObject3).a).ver2(UniteSearchReportController.a(UniteSearchActivity.f)).ver7(((JSONObject)localObject4).toString());
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((QQAppInterface)localObject1).getCurrentAccountUin());
        ((StringBuilder)localObject4).append(SearchUtils.j);
        UniteSearchReportController.a(null, ((ReportModelDC02528)localObject3).session_id(((StringBuilder)localObject4).toString()));
      }
    }
    int i2;
    if (this.g == 1107L)
    {
      i1 = 246614;
      if (this.m == 99)
      {
        i1 = 246613;
        i2 = 2;
      }
      else
      {
        i2 = 1;
      }
      if (this.R == 0)
      {
        paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuild(paramView, (Context)localObject2, false, null, this.b);
      }
      else
      {
        ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).addGuildByAuthSig((Context)localObject2, this.b, this.T, i1);
      }
      SearchUtils.a("Sgrp", "search_result", "clk", i2, 0, new String[] { this.b });
      return;
    }
    if (!TextUtils.isEmpty(this.e))
    {
      localObject1 = this.e;
      if ("3".equals(this.b)) {
        localObject1 = VasWebviewUtil.b(this.e, 55);
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
    long l1 = this.g;
    if (l1 == 268435456L)
    {
      SearchUtils.a(paramView.getContext(), Integer.valueOf(this.b).intValue(), this.m);
      return;
    }
    boolean bool;
    if (l1 == 1001L)
    {
      bool = m();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onAction mobileNumberResult = ");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append(",id = ");
        ((StringBuilder)localObject1).append(this.b);
        QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject2 = new SearchResultItem();
      ((SearchResultItem)localObject2).a = Long.valueOf(this.b).longValue();
    }
    try
    {
      if ((!QidianManager.b(this.O)) && (!QidianManager.c(this.O))) {
        break label2820;
      }
      ((SearchResultItem)localObject2).a = Long.valueOf(this.P).longValue();
    }
    catch (Exception localException)
    {
      label2811:
      int i3;
      break label2811;
    }
    QLog.i("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "qidian corp jump error");
    label2820:
    ((SearchResultItem)localObject2).c = this.c;
    if (RobotUtils.a((QQAppInterface)localObject1, this.b))
    {
      RobotUtils.a(paramView.getContext(), null, this.b);
      return;
    }
    if (this.m != 99) {
      i1 = 3;
    }
    if (bool)
    {
      ((SearchResultItem)localObject2).a = 0L;
      ((SearchResultItem)localObject2).d = this.b;
    }
    AddFriendActivity.startProfileCardActivity((Activity)paramView.getContext(), (SearchResultItem)localObject2, (QQAppInterface)localObject1, true, i1);
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
          break label2960;
        }
      }
      i3 = 0;
      label2960:
      i2 = 103;
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
          if (this.I) {
            i1 = 30018;
          } else {
            i1 = 30020;
          }
        }
      }
      else if (this.I) {
        i1 = 30014;
      } else {
        i1 = 30016;
      }
      localObject1 = TroopInfoUIUtil.a(this.b, i1);
      ((Bundle)localObject1).putInt("exposureSource", 3);
      ((Bundle)localObject1).putString("keyword", g());
      ((Bundle)localObject1).putBoolean("isFromNative", true);
      ((Bundle)localObject1).putInt("t_s_f", 1000);
      ((Bundle)localObject1).putString("authSig", this.T);
      TroopUtils.a(paramView.getContext(), (Bundle)localObject1, 2);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      if (this.V == null) {
        this.V = new ArrayList();
      }
      if (paramInt == 3)
      {
        if (this.V.size() > 2)
        {
          int i1 = this.r;
          if ((i1 == 1) || (i1 == 2)) {}
        }
        else
        {
          if (this.V.size() <= 3) {
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
      this.V.add(localMayKnowRecommendLabel);
    }
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
    if (j() == 1001) {
      return 1;
    }
    if (j() == 1002) {
      return 4;
    }
    return 0;
  }
  
  public void b(int paramInt)
  {
    this.am = paramInt;
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
        this.ae = paramInt2;
        return;
      }
      this.ad = paramInt2;
      return;
    }
    this.ac = paramInt2;
  }
  
  public void b(String paramString)
  {
    this.an = paramString;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public int ck_()
  {
    return this.ai;
  }
  
  public int cl_()
  {
    return this.aj;
  }
  
  public CharSequence d()
  {
    int i1 = j();
    boolean bool = false;
    if (i1 == 268435456) {
      try
      {
        CharSequence localCharSequence = SearchUtils.a(this.c, g(), true);
        return localCharSequence;
      }
      catch (Exception localException)
      {
        QLog.e("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, localException, new Object[0]);
        return this.c;
      }
    }
    Object localObject = new HighlightModel(this.l, g());
    if (j() == 1002)
    {
      this.c = SearchUtils.b(this.c);
      localSpannableString = ((HighlightModel)localObject).a(this.c, true);
      localObject = localSpannableString;
      if (localSpannableString == null) {
        localObject = "";
      }
      return localObject;
    }
    this.c = SearchUtils.b(this.c);
    SpannableString localSpannableString = ((HighlightModel)localObject).a(this.c, true);
    if (((HighlightModel)localObject).b > 0) {
      bool = true;
    }
    this.ak = bool;
    localObject = localSpannableString;
    if (localSpannableString == null) {
      localObject = "";
    }
    return localObject;
  }
  
  public CharSequence e()
  {
    HighlightModel localHighlightModel = new HighlightModel(this.l, g());
    boolean bool = TextUtils.isEmpty(this.n);
    Object localObject1 = null;
    Object localObject2 = null;
    if (!bool)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append(this.n);
      ((StringBuilder)localObject2).append(")");
      localObject2 = SearchUtils.b(((StringBuilder)localObject2).toString());
    }
    else if (this.t == 1)
    {
      this.j = SearchUtils.b(this.j);
      LhLogoResources localLhLogoResources = PrettyAccountUtil.a(this.u);
      localObject1 = localObject2;
      if (localLhLogoResources != null) {
        localObject1 = localLhLogoResources.lightColor;
      }
      localObject2 = PrettyAccountUtil.a(this.t, this.u, this.j, this.b);
    }
    else
    {
      localObject2 = SearchUtils.b(this.j);
    }
    localObject2 = localHighlightModel.a((CharSequence)localObject2, (String)localObject1, false, false, true);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    return localObject1;
  }
  
  public CharSequence f()
  {
    if ((!this.ak) && (!this.al))
    {
      SpannableString localSpannableString = new HighlightModel(this.l, g()).a(this.i, false, this.k);
      Object localObject = localSpannableString;
      if (localSpannableString == null) {
        localObject = "";
      }
      return localObject;
    }
    return this.i;
  }
  
  public String g()
  {
    return this.a;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public String i()
  {
    return this.d;
  }
  
  public int j()
  {
    return (int)this.g;
  }
  
  public boolean m()
  {
    boolean bool3 = TextUtils.isEmpty(this.f);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3) {
      try
      {
        int i1 = new JSONObject(this.f).optInt("is_mobile_no", 0);
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
  
  public String n()
  {
    String str = this.U;
    if (str != null) {
      return str;
    }
    return "";
  }
  
  public String o()
  {
    return this.b;
  }
  
  public int p()
  {
    return this.am;
  }
  
  public boolean q()
  {
    return (!TextUtils.isEmpty(this.c)) && (this.c.equals(this.a));
  }
  
  protected void r()
  {
    if (this.g == 268435456L)
    {
      f(11);
      if (q()) {
        f(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem
 * JD-Core Version:    0.7.0.1
 */