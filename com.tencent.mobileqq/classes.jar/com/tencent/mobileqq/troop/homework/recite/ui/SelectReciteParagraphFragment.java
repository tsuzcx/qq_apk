package com.tencent.mobileqq.troop.homework.recite.ui;

import alpo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import bbys;
import bbyt;
import bbyu;
import bbyv;
import bbzf;
import bcgo;
import bcgp;
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
  implements bcgo
{
  protected static final String a;
  public static final String b = alpo.a(2131714150);
  protected Button a;
  public bbyu a;
  protected bbzf a;
  protected bcgp a;
  public ArticleInfo a;
  protected XListView a;
  public Set<Integer> a;
  protected boolean a;
  public String c;
  protected String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = alpo.a(2131714149);
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
    this.jdField_a_of_type_Bbyu = new bbyu(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_JavaUtilSet);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bbyu);
    e();
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)a(2131371559));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131363677));
  }
  
  protected void c()
  {
    setTitle(alpo.a(2131714145));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new bbys(this));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bbyt(this));
    e();
  }
  
  protected void d()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      this.jdField_a_of_type_Bcgp = this.jdField_a_of_type_Bbzf.a(localQQAppInterface, this, this.d, null, 10003);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilSet.isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(alpo.a(2131714147));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    while (this.jdField_a_of_type_Bbyu == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      String str = this.jdField_a_of_type_Bbyu.a(j).content_html;
      if (str == null) {
        break label199;
      }
      i = str.length() + i;
    }
    label199:
    for (;;)
    {
      break;
      if (this.jdField_a_of_type_JavaUtilSet.size() == this.jdField_a_of_type_Bbyu.getCount())
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(alpo.a(2131714148), new Object[] { Integer.valueOf(i) }));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(jdField_a_of_type_JavaLangString, new Object[] { bbyv.a(new ArrayList(this.jdField_a_of_type_JavaUtilSet)), Integer.valueOf(i) }));
      return;
    }
  }
  
  protected void f()
  {
    QQToast.a(getActivity(), alpo.a(2131714146), 0).a();
  }
  
  public int getContentLayoutId()
  {
    return 2131560462;
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
    this.jdField_a_of_type_Bbzf = new bbzf();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bcgp != null) {
      this.jdField_a_of_type_Bcgp.cancel(true);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment
 * JD-Core Version:    0.7.0.1
 */