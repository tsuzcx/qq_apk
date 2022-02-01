package com.tencent.mobileqq.troop.homework.recite.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import anvx;
import bftu;
import bftv;
import bftw;
import bftx;
import bfuh;
import bghi;
import bghj;
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
  implements bghi
{
  protected static final String a;
  public static final String b = anvx.a(2131713222);
  protected Button a;
  public bftw a;
  protected bfuh a;
  protected bghj a;
  public ArticleInfo a;
  protected XListView a;
  public Set<Integer> a;
  protected boolean a;
  public String c;
  protected String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = anvx.a(2131713221);
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
    this.jdField_a_of_type_Bftw = new bftw(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_JavaUtilSet);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bftw);
    e();
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)a(2131372423));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131364006));
  }
  
  protected void c()
  {
    setTitle(anvx.a(2131713217));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new bftu(this));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bftv(this));
    e();
  }
  
  protected void d()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      this.jdField_a_of_type_Bghj = this.jdField_a_of_type_Bfuh.a(localQQAppInterface, this, this.d, null, 10003);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilSet.isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(anvx.a(2131713219));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    while (this.jdField_a_of_type_Bftw == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      String str = this.jdField_a_of_type_Bftw.a(j).content_html;
      if (str == null) {
        break label199;
      }
      i = str.length() + i;
    }
    label199:
    for (;;)
    {
      break;
      if (this.jdField_a_of_type_JavaUtilSet.size() == this.jdField_a_of_type_Bftw.getCount())
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(anvx.a(2131713220), new Object[] { Integer.valueOf(i) }));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(jdField_a_of_type_JavaLangString, new Object[] { bftx.a(new ArrayList(this.jdField_a_of_type_JavaUtilSet)), Integer.valueOf(i) }));
      return;
    }
  }
  
  protected void f()
  {
    QQToast.a(getActivity(), anvx.a(2131713218), 0).a();
  }
  
  public int getContentLayoutId()
  {
    return 2131560694;
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
    this.jdField_a_of_type_Bfuh = new bfuh();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bghj != null) {
      this.jdField_a_of_type_Bghj.cancel(true);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment
 * JD-Core Version:    0.7.0.1
 */