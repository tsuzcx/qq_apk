package com.tencent.mobileqq.troop.homework.recite.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.entry.ui.api.AbsHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.utils.HWReciteUtils;
import com.tencent.mobileqq.troop.homework.recite.utils.TroopReciteCgiHandler;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class SelectReciteParagraphFragment
  extends AbsHomeWorkFragment
  implements HttpWebCgiAsyncTask.Callback
{
  protected static final String a;
  protected static final String b = HardCodeUtil.a(2131713718);
  protected Button a;
  protected ArticleInfo a;
  protected SelectReciteParagraphFragment.ParagraphListAdapter a;
  protected TroopReciteCgiHandler a;
  protected HttpWebCgiAsyncTask2 a;
  protected XListView a;
  protected Set<Integer> a;
  protected boolean a;
  protected String c;
  protected String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713717);
  }
  
  public SelectReciteParagraphFragment()
  {
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Boolean = false;
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
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSelectReciteParagraphFragment$ParagraphListAdapter = new SelectReciteParagraphFragment.ParagraphListAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs, this.jdField_a_of_type_JavaUtilSet);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSelectReciteParagraphFragment$ParagraphListAdapter);
    e();
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)a(2131372733));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131364104));
  }
  
  protected void c()
  {
    setTitle(HardCodeUtil.a(2131713713));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new SelectReciteParagraphFragment.1(this));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new SelectReciteParagraphFragment.2(this));
    e();
  }
  
  protected void d()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsTroopReciteCgiHandler.a(localQQAppInterface, this, this.d, null, 10003);
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_JavaUtilSet.isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131713715));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSelectReciteParagraphFragment$ParagraphListAdapter == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSelectReciteParagraphFragment$ParagraphListAdapter.a(j).content_html;
      if (str == null) {
        break label199;
      }
      i = str.length() + i;
    }
    label199:
    for (;;)
    {
      break;
      if (this.jdField_a_of_type_JavaUtilSet.size() == this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiSelectReciteParagraphFragment$ParagraphListAdapter.getCount())
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(HardCodeUtil.a(2131713716), new Object[] { Integer.valueOf(i) }));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(String.format(jdField_a_of_type_JavaLangString, new Object[] { HWReciteUtils.a(new ArrayList(this.jdField_a_of_type_JavaUtilSet)), Integer.valueOf(i) }));
      return;
    }
  }
  
  protected void f()
  {
    QQToast.a(getActivity(), HardCodeUtil.a(2131713714), 0).a();
  }
  
  public int getContentLayoutId()
  {
    return 2131560784;
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
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsTroopReciteCgiHandler = new TroopReciteCgiHandler();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask2.cancel(true);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment
 * JD-Core Version:    0.7.0.1
 */