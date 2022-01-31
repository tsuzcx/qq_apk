package com.tencent.mobileqq.search.model;

import NearbyGroup.Color;
import NearbyGroup.GroupLabel;
import SummaryCard.SearchInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.SearchFragmentInfoInterface;
import com.tencent.mobileqq.search.SearchInfoInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.SearchUtil.ObjectItemInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.DateUtil;
import com.tencent.mobileqq.search.util.HighlightModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unite.search.DynamicSearch.SubItem;
import pb.unite.search.DynamicSearch.SubItemText;

public class GroupBaseNetSearchModelItem
  extends ISearchResultPositionModel
{
  public int a;
  protected long a;
  Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  protected CharSequence a;
  protected String a;
  StringBuffer jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
  public ArrayList a;
  public List a;
  protected boolean a;
  public int[] a;
  public int b;
  public long b;
  protected CharSequence b;
  public String b;
  public List b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public List c;
  public boolean c;
  public int d;
  protected String d;
  public boolean d;
  public int e;
  protected String e;
  private boolean e;
  public int f;
  protected String f;
  private boolean f;
  public int g;
  protected String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  private int l;
  public String l;
  private int m;
  
  public GroupBaseNetSearchModelItem()
  {
    this.jdField_c_of_type_Int = 2131494258;
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfInt = new int[3];
  }
  
  public GroupBaseNetSearchModelItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, List paramList, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramLong, paramList, null, paramInt);
  }
  
  public GroupBaseNetSearchModelItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, List paramList1, List paramList2)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramLong, paramList1, paramList2, -1);
  }
  
  public GroupBaseNetSearchModelItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, List paramList1, List paramList2, int paramInt)
  {
    this.jdField_c_of_type_Int = 2131494258;
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_e_of_type_JavaLangString = paramString5;
    this.jdField_f_of_type_JavaLangString = paramString6;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.jdField_b_of_type_JavaUtilList = paramList2;
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "extension info:" + this.jdField_f_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject(this.jdField_f_of_type_JavaLangString);
        String str = localJSONObject1.optString("thirdLineText");
        if (a(this.jdField_a_of_type_Long, localJSONObject1))
        {
          if (!QLog.isColorLevel()) {
            break label1154;
          }
          QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "child class has already parsed json data. groupMask=" + this.jdField_a_of_type_Long);
          return;
        }
        switch ((int)this.jdField_a_of_type_Long)
        {
        case 1001: 
          if (TextUtils.isEmpty(str)) {
            break label1154;
          }
          this.jdField_b_of_type_JavaLangCharSequence = str;
          return;
        }
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        return;
      }
      this.jdField_g_of_type_JavaLangString = ("(" + this.jdField_b_of_type_JavaLangString + ")");
      this.jdField_d_of_type_Int = localJSONException1.optInt("gender");
      this.jdField_e_of_type_Int = localJSONException1.optInt("age");
      this.jdField_a_of_type_JavaLangCharSequence = localJSONException1.optString("location");
      this.jdField_i_of_type_JavaLangString = localJSONException1.optString("authIcon");
      Object localObject2;
      Object localObject3;
      try
      {
        this.h = localJSONException1.optInt("cspecialflag");
        localObject2 = localJSONException1.optString("qdmasteruin");
        localObject3 = localJSONException1.optString("qdemailuin");
        this.jdField_l_of_type_JavaLangString = localJSONException1.optString("kfaccount");
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        QidianManager.a(localQQAppInterface, this.h, this.jdField_b_of_type_JavaLangString);
        QidianManager.a(localQQAppInterface, this.jdField_b_of_type_JavaLangString, (String)localObject2);
        if ((!QidianManager.b(this.h)) && (!QidianManager.c(this.h))) {
          continue;
        }
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          this.jdField_g_of_type_JavaLangString = "";
          QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "Parse search qidian json qdemailuin is empty ");
        }
        if (!TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
          continue;
        }
        QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "Parse search qidian json kfaccount is empty ");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "Parse search qidian json fail: " + this.jdField_b_of_type_JavaLangString + " | " + localException.getMessage());
        continue;
        this.jdField_b_of_type_Long = localException.optLong("flag_ext");
        this.jdField_g_of_type_JavaLangString = ("(" + this.jdField_b_of_type_JavaLangString + ")");
        localObject2 = localException.optJSONArray("label");
        if (localObject2 != null)
        {
          localObject3 = new ArrayList();
          int n = 0;
          for (;;)
          {
            int i1 = ((JSONArray)localObject2).length();
            if (n < i1) {
              try
              {
                JSONObject localJSONObject2 = ((JSONArray)localObject2).getJSONObject(n);
                GroupLabel localGroupLabel = new GroupLabel();
                Color localColor = new Color();
                JSONObject localJSONObject3 = localJSONObject2.optJSONObject("edging_color");
                localColor.R = localJSONObject3.optLong("r");
                localColor.G = localJSONObject3.optLong("g");
                localColor.B = localJSONObject3.optLong("b");
                localGroupLabel.edging_color = localColor;
                localColor = new Color();
                localJSONObject3 = localJSONObject2.optJSONObject("text_color");
                localColor.R = localJSONObject3.optLong("r");
                localColor.G = localJSONObject3.optLong("g");
                localColor.B = localJSONObject3.optLong("b");
                localGroupLabel.text_color = localColor;
                localGroupLabel.strWording = localJSONObject2.optString("name");
                localGroupLabel.type = localJSONObject2.optLong("attr");
                ((ArrayList)localObject3).add(localGroupLabel);
                n += 1;
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
          this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject3);
        }
        localObject2 = localException.optString("memo");
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131430411);
        }
        this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
        continue;
        this.jdField_b_of_type_Int = ((JSONObject)localObject1).optInt("video_or_music");
        localObject2 = ((JSONObject)localObject1).optString("busi_mask");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (Integer.parseInt((String)localObject2) == 2049) {
            this.jdField_a_of_type_JavaLangCharSequence = ((JSONObject)localObject1).optString("brief");
          }
          for (;;)
          {
            localObject2 = ((JSONObject)localObject1).optString("from");
            localObject1 = DateUtil.a(Long.parseLong(((JSONObject)localObject1).optString("create_time")));
            this.jdField_b_of_type_JavaLangCharSequence = ((String)localObject2 + (String)localObject1);
            this.jdField_a_of_type_Boolean = true;
            break;
            if (Integer.parseInt((String)localObject2) == 64) {
              this.jdField_a_of_type_JavaLangCharSequence = ((JSONObject)localObject1).optString("content");
            } else if (Integer.parseInt((String)localObject2) == 4096) {
              this.jdField_a_of_type_JavaLangCharSequence = ((JSONObject)localObject1).optString("description");
            }
          }
          this.jdField_b_of_type_JavaLangCharSequence = ((JSONObject)localObject1).optString("srcWording");
          this.jdField_a_of_type_JavaLangCharSequence = ((JSONObject)localObject1).optString("abstracts");
          this.jdField_j_of_type_JavaLangString = ((JSONObject)localObject1).optString("ambiUrl");
          this.jdField_k_of_type_JavaLangString = ((JSONObject)localObject1).optString("ambiWording");
          this.jdField_c_of_type_Long = ((JSONObject)localObject1).optLong("lemmaId");
          if ((!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaUtilList == null))
          {
            this.jdField_b_of_type_JavaUtilList = new ArrayList();
            localObject1 = new DynamicSearch.SubItem();
            ((DynamicSearch.SubItem)localObject1).layout_id.set(-2);
            ((DynamicSearch.SubItem)localObject1).jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_e_of_type_JavaLangString));
            ((DynamicSearch.SubItem)localObject1).show_arrow.set(1, true);
            localObject2 = new DynamicSearch.SubItemText();
            ((DynamicSearch.SubItemText)localObject2).text.set(ByteStringMicro.copyFromUtf8(this.jdField_k_of_type_JavaLangString));
            ((DynamicSearch.SubItem)localObject1).title.set(0, (MessageMicro)localObject2);
            this.jdField_b_of_type_JavaUtilList.add(localObject1);
            continue;
            this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).optString("title");
            this.jdField_c_of_type_JavaUtilList = SearchUtils.a(((JSONObject)localObject1).optJSONArray("itemList"));
            continue;
            label1154:
            return;
          }
        }
      }
    }
  }
  
  public int a()
  {
    if (b() == 1001) {
      return 1;
    }
    if (b() == 1002) {
      return 4;
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    int n = -1;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "getPosition(). type=" + paramInt + "  position=" + n);
      }
      return n;
      n = this.jdField_i_of_type_Int;
      continue;
      n = this.jdField_j_of_type_Int;
      continue;
      n = this.jdField_k_of_type_Int;
    }
  }
  
  public CharSequence a()
  {
    boolean bool = true;
    if (b() == 268435456) {
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
    HighlightModel localHighlightModel = new HighlightModel(this.jdField_a_of_type_JavaUtilList, b());
    this.jdField_c_of_type_JavaLangString = SearchUtils.a(this.jdField_c_of_type_JavaLangString);
    SpannableString localSpannableString = localHighlightModel.a(this.jdField_c_of_type_JavaLangString, true);
    if (localHighlightModel.jdField_a_of_type_Int > 0) {}
    for (;;)
    {
      this.jdField_e_of_type_Boolean = bool;
      if (localSpannableString != null) {
        break;
      }
      return "";
      bool = false;
    }
    return localSpannableString;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      this.jdField_i_of_type_Int = paramInt2;
      return;
    case 2: 
      this.jdField_j_of_type_Int = paramInt2;
      return;
    }
    this.jdField_k_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(2, paramInt1);
    a(1, paramInt2);
    a(3, paramInt3);
  }
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupBaseNetSearchModelItem", 2, "onAction(). jumpUrl = " + this.jdField_e_of_type_JavaLangString + "  id=" + this.jdField_b_of_type_JavaLangString);
    }
    Object localObject2;
    Object localObject3;
    switch (b())
    {
    default: 
      localObject2 = paramView.getContext();
      if ((localObject2 instanceof SearchInfoInterface))
      {
        localObject3 = (SearchInfoInterface)localObject2;
        if (((SearchInfoInterface)localObject3).b()) {}
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject1 = ((SearchInfoInterface)localObject3).a();
        if (!(localObject1 instanceof SearchFragmentInfoInterface)) {
          break label2025;
        }
      }
      break;
    }
    label184:
    label1727:
    label2025:
    for (Object localObject1 = (SearchFragmentInfoInterface)localObject1;; localObject1 = null)
    {
      Object localObject4;
      switch (((SearchInfoInterface)localObject3).a())
      {
      default: 
        if (b() == 268435456)
        {
          SearchUtils.a("all_result", "clk_function", new String[] { "" + this.jdField_a_of_type_JavaLangString, "" + this.jdField_b_of_type_JavaLangString, "" + (this.jdField_g_of_type_Int + 1) });
          if (((paramView.getContext() instanceof UniteSearchActivity)) && (SearchUtil.c.containsKey(this)))
          {
            localObject1 = (SearchUtil.ObjectItemInfo)SearchUtil.c.get(this);
            localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            localObject4 = new JSONObject();
          }
        }
        break;
      }
      do
      {
        try
        {
          for (;;)
          {
            ((JSONObject)localObject4).put("project", UniteSearchReportController.a());
            ((JSONObject)localObject4).put("event_src", "client");
            ((JSONObject)localObject4).put("obj_lct", ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Int);
            ((JSONObject)localObject4).put("get_src", "native");
            UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Long + "").obj2(((SearchUtil.ObjectItemInfo)localObject1).jdField_b_of_type_JavaLangString).ver1(((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_JavaLangString).ver2(UniteSearchReportController.a(UniteSearchActivity.jdField_d_of_type_Int)).ver7(((JSONObject)localObject4).toString()).session_id(((QQAppInterface)localObject3).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
            if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
              break label1821;
            }
            if ((!this.jdField_e_of_type_JavaLangString.startsWith("http")) && (!this.jdField_e_of_type_JavaLangString.startsWith("https"))) {
              break label1727;
            }
            paramView = new Intent((Context)localObject2, QQBrowserActivity.class);
            paramView.putExtra("url", this.jdField_e_of_type_JavaLangString);
            ((Context)localObject2).startActivity(paramView);
            return;
            SearchUtils.a(this.jdField_a_of_type_JavaLangString, 70, 0, this.jdField_g_of_type_Int, paramView);
            break;
            SearchUtils.a(this.jdField_a_of_type_JavaLangString, 80, 0, this.jdField_g_of_type_Int, paramView);
            break;
            SearchUtils.a(this.jdField_a_of_type_JavaLangString, 120, 0, this.jdField_g_of_type_Int, paramView);
            break;
            QQAppInterface localQQAppInterface;
            JSONObject localJSONObject;
            if ((SearchUtil.c.containsKey(this)) && (b() != 268435456))
            {
              localObject4 = (SearchUtil.ObjectItemInfo)SearchUtil.c.get(this);
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
                    n = 2;
                    SearchUtils.a("all_result", "clk_object", n, 0, new String[] { this.jdField_a_of_type_JavaLangString, "" + this.jdField_a_of_type_Long, ((SearchUtil.ObjectItemInfo)localObject4).jdField_b_of_type_JavaLangString + "", ((SearchUtil.ObjectItemInfo)localObject4).jdField_a_of_type_Int + "" });
                  }
                }
                else
                {
                  if ((localObject1 == null) || (!((SearchFragmentInfoInterface)localObject1).a())) {
                    break label184;
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
                n = 1;
              }
              if (SearchUtil.jdField_b_of_type_Boolean) {}
              for (int n = 2;; n = 1)
              {
                SearchUtils.a("all_result", "clk_content", n, 0, new String[] { ((SearchInfoInterface)localObject3).a(), "" + this.jdField_a_of_type_Long, "", SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).a()) });
                if ((localObject1 == null) || (!((SearchFragmentInfoInterface)localObject1).a())) {
                  break;
                }
                ((SearchFragmentInfoInterface)localObject1).a(true);
                SearchUtils.a("all_result", "clk_first_result", new String[] { ((SearchInfoInterface)localObject3).a(), "" + this.jdField_a_of_type_Long, "" + a(2), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).a()) });
                break;
              }
            }
          }
          if ((localObject1 != null) && (((SearchFragmentInfoInterface)localObject1).a()))
          {
            ((SearchFragmentInfoInterface)localObject1).a(true);
            SearchUtils.a("all_result", "clk_tab_first_result", new String[] { ((SearchInfoInterface)localObject3).a(), "" + this.jdField_a_of_type_Long, "" + a(2), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).a()) });
          }
          SearchUtils.a("all_result", "clk_tab_result", new String[] { ((SearchInfoInterface)localObject3).a(), "" + this.jdField_a_of_type_Long, "", SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).a()) });
          break label184;
          if ((localObject1 != null) && (((SearchFragmentInfoInterface)localObject1).a()))
          {
            ((SearchFragmentInfoInterface)localObject1).a(true);
            SearchUtils.a("sub_result", "clk_sub_first_result", new String[] { ((SearchInfoInterface)localObject3).a(), "" + this.jdField_a_of_type_Long, "" + a(2), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).a()) });
          }
          SearchUtils.a("sub_result", "clk_result", new String[] { ((SearchInfoInterface)localObject3).a(), "" + this.jdField_a_of_type_Long, "" + a(2), SearchUtils.a("dynamic_tab_search.1", ((SearchInfoInterface)localObject3).a()) });
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
              paramView.b();
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
        if (this.jdField_a_of_type_Long == 1001L)
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localObject2 = new SearchInfo();
          ((SearchInfo)localObject2).lUIN = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
          try
          {
            if ((QidianManager.b(this.h)) || (QidianManager.c(this.h))) {
              ((SearchInfo)localObject2).lUIN = Long.valueOf(this.jdField_l_of_type_JavaLangString).longValue();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.i("Q.uniteSearch.GroupBaseNetSearchModelItem", 1, "qidian corp jump error");
            }
          }
          ((SearchInfo)localObject2).strNick = this.jdField_c_of_type_JavaLangString;
          AddFriendActivity.a((Activity)paramView.getContext(), (SearchInfo)localObject2, ((QQAppInterface)localObject1).getCurrentAccountUin(), null, true, 1);
          return;
        }
      } while (this.jdField_a_of_type_Long != 1002L);
      localObject1 = TroopInfoActivity.a(this.jdField_b_of_type_JavaLangString, 2);
      ((Bundle)localObject1).putInt("exposureSource", 3);
      ((Bundle)localObject1).putInt("t_s_f", 1000);
      ChatSettingForTroop.a(paramView.getContext(), (Bundle)localObject1, 2);
      return;
    }
  }
  
  public void a(List paramList)
  {
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      int n = 0;
      while (n < this.jdField_b_of_type_JavaUtilList.size())
      {
        DynamicSearch.SubItem localSubItem = (DynamicSearch.SubItem)this.jdField_b_of_type_JavaUtilList.get(n);
        if (SearchUtils.a(localSubItem))
        {
          paramList.add(new SearchResultModelForEntrance(localSubItem, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString));
          StringBuilder localStringBuilder = new StringBuilder();
          int i1 = 0;
          while (i1 < localSubItem.title.size())
          {
            localStringBuilder.append(((DynamicSearch.SubItemText)localSubItem.title.get(i1)).text.get().toStringUtf8());
            localStringBuilder.append(":");
            i1 += 1;
          }
        }
        n += 1;
      }
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
    return (int)this.jdField_a_of_type_Long;
  }
  
  public CharSequence b()
  {
    Object localObject = new HighlightModel(this.jdField_a_of_type_JavaUtilList, b());
    this.jdField_g_of_type_JavaLangString = SearchUtils.a(this.jdField_g_of_type_JavaLangString);
    SpannableString localSpannableString = ((HighlightModel)localObject).a(this.jdField_g_of_type_JavaLangString);
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
    this.jdField_l_of_type_Int = paramInt1;
    this.m = paramInt2;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Long != 1007L) || ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() != 0));
  }
  
  public int c()
  {
    return this.jdField_l_of_type_Int;
  }
  
  public CharSequence c()
  {
    HighlightModel localHighlightModel = new HighlightModel(this.jdField_a_of_type_JavaUtilList, b());
    this.jdField_a_of_type_JavaLangCharSequence = SearchUtils.a(this.jdField_a_of_type_JavaLangCharSequence);
    SpannableString localSpannableString = localHighlightModel.a(this.jdField_a_of_type_JavaLangCharSequence);
    if (localHighlightModel.jdField_a_of_type_Int > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_f_of_type_Boolean = bool;
      if (localSpannableString != null) {
        break;
      }
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
    return this.m;
  }
  
  public CharSequence d()
  {
    Object localObject;
    if ((this.jdField_e_of_type_Boolean) || (this.jdField_f_of_type_Boolean)) {
      localObject = this.jdField_b_of_type_JavaLangCharSequence;
    }
    SpannableString localSpannableString;
    do
    {
      return localObject;
      localSpannableString = new HighlightModel(this.jdField_a_of_type_JavaUtilList, b()).a(this.jdField_b_of_type_JavaLangCharSequence, false, this.jdField_a_of_type_Boolean);
      localObject = localSpannableString;
    } while (localSpannableString != null);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem
 * JD-Core Version:    0.7.0.1
 */