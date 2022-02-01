package com.tencent.mobileqq.search.fragment;

import amtj;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import baum;
import bavm;
import bavn;
import baxm;
import bayp;
import bayt;
import bbbg;
import bbdz;
import bbee;
import bbfe;
import bbfm;
import bbfo;
import bbft;
import bbfu;
import bbfw;
import bbgc;
import bbgk;
import bezm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ContactSearchFragment
  extends BaseSearchFragment
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private bbbg jdField_a_of_type_Bbbg;
  private String jdField_a_of_type_JavaLangString;
  private List<PhoneContact> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private int jdField_c_of_type_Int;
  private Set<String> jdField_c_of_type_JavaUtilSet = new HashSet();
  private boolean f;
  private boolean g;
  
  public static ContactSearchFragment a(int paramInt1, int paramInt2, String paramString, List<String> paramList, bbbg parambbbg)
  {
    return a(paramInt1, paramInt2, paramString, paramList, parambbbg, false, 0, -1L);
  }
  
  public static ContactSearchFragment a(int paramInt1, int paramInt2, String paramString, List<String> paramList, bbbg parambbbg, boolean paramBoolean, int paramInt3, long paramLong)
  {
    ContactSearchFragment localContactSearchFragment = new ContactSearchFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt1);
    localBundle.putInt("contactSearchSource", paramInt2);
    localBundle.putString("specifiedTroopUin", paramString);
    localBundle.putBoolean("isApproximate", paramBoolean);
    localBundle.putInt("ContactCombineType", paramInt3);
    if (paramList != null) {
      localBundle.putStringArray("hiddenUinSet", (String[])paramList.toArray(new String[paramList.size()]));
    }
    if (parambbbg != null) {
      localBundle.putLong("contactSearchOnActionListener", bbgc.a().a(parambbbg));
    }
    if (paramLong > 0L) {
      localBundle.putLong("contactSearchResultFilterType", paramLong);
    }
    localContactSearchFragment.setArguments(localBundle);
    return localContactSearchFragment;
  }
  
  public static ContactSearchFragment a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    return a(paramInt1, paramInt2, null, null, null, paramBoolean, paramInt3, -1L);
  }
  
  protected int a()
  {
    return 20;
  }
  
  protected baum a()
  {
    return new bavn(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
  }
  
  protected bbfe a()
  {
    if (this.jdField_a_of_type_Int == 524288)
    {
      if (this.jdField_b_of_type_Int == 19) {
        return new bbfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
      }
      return new bbfm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
    }
    if (this.jdField_a_of_type_Boolean) {
      return new bbdz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
    }
    if (this.jdField_a_of_type_Int == 1048576)
    {
      if (this.jdField_b_of_type_Int == 23) {
        return new bbfw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
      }
      return new bbfu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
    }
    return new bbee(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilSet);
  }
  
  protected String a()
  {
    if (this.jdField_c_of_type_Int == 2) {
      return amtj.a(2131701673);
    }
    return amtj.a(2131701676);
  }
  
  protected void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    if (((!bbgk.a(this.jdField_b_of_type_Int)) || (this.jdField_b_of_type_Int == -1)) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label71;
      }
      this.f = false;
      if (this.jdField_b_of_type_Int == -1) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131167276);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165451);
    return;
    label71:
    this.f = true;
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838891);
  }
  
  public void a(List paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSearchFragment", 2, new Object[] { "onFinish with status:", Integer.valueOf(paramInt) });
    }
    Object localObject1 = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder(2048);
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        Object localObject3;
        if ((QLog.isColorLevel()) && ((localObject2 instanceof bayp)))
        {
          localObject3 = (bayp)localObject2;
          localStringBuilder.append("model name:").append(((bayp)localObject3).c()).append(" clss:").append(localObject3.getClass().getSimpleName()).append(" degree:").append(((bayp)localObject3).b()).append(" second:").append(((bayp)localObject3).a()).append("\n");
        }
        if ((localObject2 instanceof bayt))
        {
          localObject2 = (bayt)localObject2;
          if ((!this.g) || (!(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface instanceof QQAppInterface)) || (!bezm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((bayt)localObject2).b())))
          {
            if ((this.jdField_a_of_type_Long > 0L) && ((this.jdField_a_of_type_Long & 1L) != 0L) && ((localObject2 instanceof baxm)))
            {
              localObject3 = (baxm)localObject2;
              if ((((baxm)localObject3).d() == 1000) || (((baxm)localObject3).d() == 1004) || (((baxm)localObject3).d() == 1003) || (((baxm)localObject3).d() == 1006) || (((baxm)localObject3).d() == 2016))
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("ContactSearchFragment", 2, "onFinish filter a result ,uintype = " + ((baxm)localObject3).d());
                continue;
              }
            }
            if ((this.jdField_c_of_type_Int == 2) && (bbgk.a((bayt)localObject2))) {
              ((List)localObject1).add(localObject2);
            } else if ((this.jdField_c_of_type_Int == 1) && (!bbgk.a((bayt)localObject2))) {
              ((List)localObject1).add(localObject2);
            } else if (this.jdField_c_of_type_Int == 0) {
              ((List)localObject1).add(localObject2);
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactSearchFragment", 2, localStringBuilder.toString());
    }
    super.a((List)localObject1, paramInt);
    if ((bbgk.a(this.jdField_b_of_type_Int)) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      localObject1 = "" + this.jdField_c_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("");
      if (paramList != null) {
        break label588;
      }
    }
    label588:
    for (paramInt = 0;; paramInt = paramList.size())
    {
      bbgk.a("contact", "exp_page", new String[] { localObject1, paramInt });
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        this.d = false;
        this.jdField_a_of_type_Bbfe = a();
        this.jdField_a_of_type_Bbfe.a();
        this.d = true;
      }
      return;
    }
  }
  
  public void a(List paramList, bbft parambbft)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSearchFragment", 2, new Object[] { "onFinish with respData:", parambbft.toString() });
    }
    if (parambbft.a(this.jdField_c_of_type_JavaLangString)) {
      a(paramList, parambbft.jdField_a_of_type_Int);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ContactSearchFragment", 2, new Object[] { "onFinish not match keyword1:", parambbft.jdField_a_of_type_JavaLangString, " keyword2:", this.jdField_c_of_type_JavaLangString });
  }
  
  public void a(List<String> paramList1, List<String> paramList2)
  {
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_c_of_type_JavaUtilSet.clear();
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        this.jdField_b_of_type_JavaUtilSet.add(str);
      }
    }
    if ((paramList2 != null) && (paramList2.size() > 0))
    {
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        this.jdField_c_of_type_JavaUtilSet.add(paramList2);
      }
    }
  }
  
  protected boolean a()
  {
    return bbgk.a(this.jdField_b_of_type_Int);
  }
  
  protected void c(List paramList)
  {
    super.c(paramList);
    if ((bbgk.a(this.jdField_b_of_type_Int)) && (paramList != null) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      bbgk.a("contact", "exp_page", new String[] { "" + this.jdField_c_of_type_JavaLangString, "" + paramList.size() });
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void e(List<PhoneContact> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.jdField_a_of_type_Int = localBundle.getInt("contactSearchSource", 197437);
      this.jdField_b_of_type_Int = localBundle.getInt("fromType", -1);
      this.jdField_a_of_type_Long = localBundle.getLong("contactSearchResultFilterType", -1L);
      if (QLog.isColorLevel()) {
        QLog.d("ContactSearchFragment", 2, "onCreate searchSource = " + this.jdField_a_of_type_Int + ",fromType = " + this.jdField_b_of_type_Int + ",filterType = " + this.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_Boolean = localBundle.getBoolean("isApproximate", false);
      this.jdField_c_of_type_Int = localBundle.getInt("ContactCombineType", 0);
      this.jdField_a_of_type_JavaLangString = localBundle.getString("specifiedTroopUin");
      String[] arrayOfString = localBundle.getStringArray("hiddenUinSet");
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        this.jdField_a_of_type_JavaUtilSet = new HashSet();
        int j = arrayOfString.length;
        while (i < j)
        {
          String str = arrayOfString[i];
          this.jdField_a_of_type_JavaUtilSet.add(str);
          i += 1;
        }
      }
      long l = localBundle.getLong("contactSearchOnActionListener", -1L);
      if (l != -1L) {
        this.jdField_a_of_type_Bbbg = ((bbbg)bbgc.a().a(l));
      }
    }
    super.onCreate(paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (!bbgk.a(this.jdField_b_of_type_Int))
    {
      if (this.jdField_b_of_type_Int != -1) {
        break label54;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131167276);
    }
    for (;;)
    {
      this.f = false;
      this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new bavm(this));
      return;
      label54:
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165451);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.ContactSearchFragment
 * JD-Core Version:    0.7.0.1
 */