package com.tencent.mobileqq.troop.homework.recite.ui;

import alud;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import bcdb;
import bcdc;
import bcdd;
import bcde;
import bcdo;
import bckx;
import bcky;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.entry.ui.api.AbsHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class SelectReciteParagraphFragment
  extends AbsHomeWorkFragment
  implements bckx
{
  protected static final String a;
  public static final String b = alud.a(2131714162);
  protected Button a;
  public bcdd a;
  protected bcdo a;
  protected bcky a;
  public ArticleInfo a;
  protected XListView a;
  public Set<Integer> a;
  protected boolean a;
  public String c;
  protected String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = alud.a(2131714161);
  }
  
  public SelectReciteParagraphFragment()
  {
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    a(paramContext, paramString1, paramString2, new ArrayList(0), paramInt);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, ArrayList<Integer> paramArrayList, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("kid", paramString2);
    localIntent.putExtra("troop_uin", paramString1);
    if (paramArrayList != null) {
      localIntent.putExtra("selected_list", paramArrayList);
    }
    AbsHomeWorkFragment.a((Activity)paramContext, SelectReciteParagraphFragment.class, localIntent, paramInt, "");
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    b();
    c();
    d();
  }
  
  public void a(@Nullable String paramString) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo = ArticleInfo.onHandleGetArticleDetail(paramBundle, paramJSONObject);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo == null)
    {
      f();
      return;
    }
    this.jdField_a_of_type_Bcdd = new bcdd(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_JavaUtilSet);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bcdd);
    e();
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)a(2131371578));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131363679));
  }
  
  protected void c()
  {
    setTitle(alud.a(2131714157));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new bcdb(this));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bcdc(this));
    e();
  }
  
  protected void d()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      this.jdField_a_of_type_Bcky = this.jdField_a_of_type_Bcdo.a(localQQAppInterface, this, this.d, null, 10003);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilSet.isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(alud.a(2131714159));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    while (this.jdField_a_of_type_Bcdd == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      String str = this.jdField_a_of_type_Bcdd.a(j).content_html;
      if (str == null) {
        break label199;
      }
      i = str.length() + i;
    }
    label199:
    for (;;)
    {
      break;
      if (this.jdField_a_of_type_JavaUtilSet.size() == this.jdField_a_of_type_Bcdd.getCount())
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(alud.a(2131714160), new Object[] { Integer.valueOf(i) }));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(jdField_a_of_type_JavaLangString, new Object[] { bcde.a(new ArrayList(this.jdField_a_of_type_JavaUtilSet)), Integer.valueOf(i) }));
      return;
    }
  }
  
  protected void f()
  {
    QQToast.a(getActivity(), alud.a(2131714158), 0).a();
  }
  
  public int getContentLayoutId()
  {
    return 2131560461;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    this.c = paramBundle.getString("troop_uin", "");
    this.d = paramBundle.getString("kid", "");
    paramBundle = paramBundle.getIntegerArrayList("selected_list");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.jdField_a_of_type_JavaUtilSet.addAll(paramBundle);
    }
    this.jdField_a_of_type_Bcdo = new bcdo();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bcky != null) {
      this.jdField_a_of_type_Bcky.cancel(true);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment
 * JD-Core Version:    0.7.0.1
 */