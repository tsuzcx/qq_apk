package com.tencent.mobileqq.search.fragment;

import afdd;
import akdh;
import akix;
import akiy;
import akiz;
import akjb;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import awik;
import awio;
import awiw;
import awkl;
import awkm;
import awkq;
import awkv;
import awog;
import awpm;
import awvi;
import awwa;
import baxy;
import bfos;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pb.unite.search.DynamicTabSearch.SubHotWord;

public class ActiveEntitySearchFragment
  extends Fragment
  implements View.OnClickListener, awio, bfos
{
  public static String a;
  public int a;
  private long a;
  public afdd a;
  protected akix a;
  protected akiy a;
  protected akiz a;
  protected akjb a;
  public Bitmap a;
  protected View a;
  public Button a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public awkl a;
  protected baxy a;
  public QQAppInterface a;
  public XListView a;
  public List<awog> a;
  public boolean a;
  public byte[] a;
  public long[] a;
  public int b;
  public View b;
  public TextView b;
  public XListView b;
  public String b;
  public List<Long> b;
  public boolean b;
  private int jdField_c_of_type_Int;
  View jdField_c_of_type_AndroidViewView;
  public TextView c;
  public String c;
  private List<DynamicTabSearch.SubHotWord> jdField_c_of_type_JavaUtilList;
  public boolean c;
  private int d;
  public View d;
  public TextView d;
  public String d;
  public boolean d;
  private int e;
  public View e;
  public String e;
  public boolean e;
  public View f;
  private String f;
  public boolean f;
  public View g;
  private boolean g;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.uniteSearch." + ActiveEntitySearchFragment.class.getSimpleName();
  }
  
  public ActiveEntitySearchFragment()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Akiy = new awkm(this);
    this.jdField_a_of_type_Akjb = new awkq(this);
  }
  
  public static ActiveEntitySearchFragment a(int paramInt, long[] paramArrayOfLong, String paramString1, String paramString2)
  {
    ActiveEntitySearchFragment localActiveEntitySearchFragment = new ActiveEntitySearchFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt);
    localBundle.putLongArray("group_mask_long_array", paramArrayOfLong);
    localBundle.putString("group_name_string", paramString1);
    localBundle.putString("keyword", paramString2);
    localActiveEntitySearchFragment.setArguments(localBundle);
    return localActiveEntitySearchFragment;
  }
  
  public static boolean a(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if ((paramArrayOfLong1 == null) || (paramArrayOfLong2 == null) || (paramArrayOfLong1.length != paramArrayOfLong2.length)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfLong1.length) {
        break label42;
      }
      if (paramArrayOfLong1[i] != paramArrayOfLong2[i]) {
        break;
      }
      i += 1;
    }
    label42:
    return true;
  }
  
  int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  protected awkl a()
  {
    return new awkl(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_Baxy, this, 0);
  }
  
  public List<Long> a()
  {
    List localList = new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_Int).a(new awvi(this.jdField_b_of_type_JavaLangString));
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList1 = ((akdh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a();
    ArrayList localArrayList2 = new ArrayList();
    if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "all publicAccountInfoList is null or empty");
      }
    }
    for (;;)
    {
      return localArrayList2;
      int i = 0;
      while (i < localList.size())
      {
        awpm localawpm = (awpm)localList.get(i);
        int j = 0;
        while (j < localArrayList1.size())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localArrayList1.get(j);
          if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(localawpm.a.uin))) {
            localArrayList2.add(Long.valueOf(localPublicAccountInfo.uin));
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  protected void a()
  {
    if (this.jdField_d_of_type_Int == 10)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akjb);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akiy);
  }
  
  public void a(String paramString)
  {
    double d2 = 0.0D;
    for (;;)
    {
      double d1;
      try
      {
        Object localObject = this.jdField_a_of_type_ArrayOfByte;
        if (localObject != null) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "hash = " + hashCode() + "   startSearchTAB isEnd = true mask;" + Arrays.toString(this.jdField_a_of_type_ArrayOfLong) + " key=" + paramString + "  name=" + this.jdField_e_of_type_JavaLangString + " isViewCreated" + this.jdField_c_of_type_Boolean);
        }
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Int = 0;
        this.jdField_b_of_type_JavaLangString = paramString;
        if (this.jdField_c_of_type_Boolean)
        {
          if (!(getActivity() instanceof awik)) {
            break label326;
          }
          d1 = ((awik)getActivity()).a();
          d2 = ((awik)getActivity()).b();
          this.jdField_d_of_type_JavaLangString = (System.currentTimeMillis() + "");
          this.jdField_e_of_type_Boolean = true;
          localObject = new Bundle();
          if ((getActivity() instanceof ActiveEntitySearchActivity))
          {
            ActiveEntitySearchActivity localActiveEntitySearchActivity = (ActiveEntitySearchActivity)getActivity();
            ((Bundle)localObject).putInt("fromTypeForReport", localActiveEntitySearchActivity.jdField_a_of_type_Int);
            ((Bundle)localObject).putInt("searchAvatarFrom", localActiveEntitySearchActivity.jdField_b_of_type_Int);
          }
          ((Bundle)localObject).putBoolean("isLoadMore", false);
          ((Bundle)localObject).putInt("fromType", this.jdField_d_of_type_Int);
          a(paramString, a(), null, d1, d2, (Bundle)localObject);
          b(false);
          continue;
        }
        this.jdField_b_of_type_Boolean = true;
      }
      finally {}
      this.jdField_c_of_type_JavaLangString = paramString;
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "startSearch 触发延迟逻辑");
        continue;
        label326:
        d1 = 0.0D;
      }
    }
  }
  
  protected void a(String paramString, List<Long> paramList, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Akiz != null)
    {
      this.jdField_a_of_type_Akiz.a(paramString, this.jdField_d_of_type_JavaLangString, 20, awiw.a(this.jdField_a_of_type_ArrayOfLong), paramList, paramArrayOfByte, this.jdField_c_of_type_Int, paramDouble1, paramDouble2, paramBundle);
      return;
    }
    if (this.jdField_a_of_type_Akix != null)
    {
      this.jdField_a_of_type_Akix.a(paramString, this.jdField_d_of_type_JavaLangString, 20, awiw.a(this.jdField_a_of_type_ArrayOfLong), paramList, paramArrayOfByte, this.jdField_c_of_type_Int, paramDouble1, paramDouble2, paramBundle);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "handler null in frag");
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  protected void b()
  {
    if (this.jdField_d_of_type_Int == 10)
    {
      this.jdField_a_of_type_Akiz = ((akiz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(111));
      this.jdField_a_of_type_Akix = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akjb);
      return;
    }
    this.jdField_a_of_type_Akix = ((akix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(152));
    this.jdField_a_of_type_Akiz = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akiy);
  }
  
  public void b(String paramString)
  {
    double d2 = 0.0D;
    for (;;)
    {
      try
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_a_of_type_ArrayOfByte != null) {
          awwa.a("all_result", "load_tab", new String[] { paramString, awwa.a(this.jdField_b_of_type_JavaUtilList), "", awwa.a("UnifySearch.Unite", this.jdField_a_of_type_ArrayOfLong) });
        }
        if ((getActivity() instanceof awik))
        {
          d1 = ((awik)getActivity()).a();
          d2 = ((awik)getActivity()).b();
          this.jdField_d_of_type_JavaLangString = (System.currentTimeMillis() + "");
          if (QLog.isColorLevel()) {
            QLog.w(jdField_a_of_type_JavaLangString, 2, "startNewSearchTAB isEnd = true mask;" + Arrays.toString(this.jdField_a_of_type_ArrayOfLong) + " key=" + paramString + "  name=" + this.jdField_e_of_type_JavaLangString + " reqTime=" + this.jdField_d_of_type_JavaLangString);
          }
          this.jdField_e_of_type_Boolean = true;
          Bundle localBundle = new Bundle();
          localBundle.putBoolean("isLoadMore", true);
          localBundle.putInt("fromType", this.jdField_d_of_type_Int);
          a(paramString, a(), this.jdField_a_of_type_ArrayOfByte, d1, d2, localBundle);
          b(true);
          return;
        }
      }
      finally {}
      double d1 = 0.0D;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramBoolean) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
  }
  
  public boolean b()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Awkl != null))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      a(false);
      this.jdField_a_of_type_Awkl.a(this.jdField_a_of_type_JavaUtilList);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag(2131367633);
    if ((paramView instanceof DynamicTabSearch.SubHotWord))
    {
      paramView = (DynamicTabSearch.SubHotWord)paramView;
      this.jdField_c_of_type_Int = paramView.word_id.get();
      Object localObject = getActivity();
      if ((localObject instanceof ActiveEntitySearchActivity))
      {
        localObject = (ActiveEntitySearchActivity)localObject;
        awwa.a("sub_result", "clk_relate", new String[] { this.jdField_b_of_type_JavaLangString, paramView.search_word.get().toStringUtf8(), "", "" });
        ((ActiveEntitySearchActivity)localObject).a(paramView);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof UniteSearchActivity)) {
      this.jdField_f_of_type_Boolean = true;
    }
    if ((localFragmentActivity instanceof BaseActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((BaseActivity)localFragmentActivity).app;
      this.jdField_a_of_type_Baxy = new baxy(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localBundle == null) {
        break label169;
      }
      this.jdField_d_of_type_Int = localBundle.getInt("fromType", -1);
      this.jdField_a_of_type_ArrayOfLong = localBundle.getLongArray("group_mask_long_array");
      if (this.jdField_a_of_type_ArrayOfLong == null) {
        throw new RuntimeException("mask array can not be null in ActiveEntitySearchFragment.");
      }
    }
    else
    {
      throw new IllegalStateException("Activity must be instance of BaseActivity");
    }
    if ((this.jdField_a_of_type_ArrayOfLong.length == 1) && (this.jdField_a_of_type_ArrayOfLong[0] == 0L)) {
      if (this.jdField_d_of_type_Int != 10) {
        break label179;
      }
    }
    label169:
    label179:
    for (this.jdField_a_of_type_ArrayOfLong = akiz.c;; this.jdField_a_of_type_ArrayOfLong = akix.c)
    {
      this.jdField_e_of_type_JavaLangString = localBundle.getString("group_name_string");
      this.jdField_b_of_type_JavaLangString = localBundle.getString("keyword");
      b();
      super.onCreate(paramBundle);
      return;
    }
  }
  
  /* Error */
  public View onCreateView(android.view.LayoutInflater paramLayoutInflater, android.view.ViewGroup paramViewGroup, Bundle paramBundle)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: aload_3
    //   9: invokespecial 515	android/support/v4/app/Fragment:onCreateView	(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    //   12: pop
    //   13: aload_1
    //   14: ldc_w 516
    //   17: aload_2
    //   18: iconst_0
    //   19: invokevirtual 522	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   22: astore_3
    //   23: aload_0
    //   24: aload_3
    //   25: ldc_w 523
    //   28: invokevirtual 527	android/view/View:findViewById	(I)Landroid/view/View;
    //   31: putfield 405	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   34: aload_0
    //   35: getfield 405	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   38: iconst_0
    //   39: invokevirtual 378	android/view/View:setVisibility	(I)V
    //   42: aload_0
    //   43: aload_3
    //   44: ldc_w 528
    //   47: invokevirtual 527	android/view/View:findViewById	(I)Landroid/view/View;
    //   50: putfield 417	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   53: aload_0
    //   54: aload_3
    //   55: ldc_w 529
    //   58: invokevirtual 527	android/view/View:findViewById	(I)Landroid/view/View;
    //   61: putfield 401	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   64: aload_0
    //   65: aload_3
    //   66: ldc_w 530
    //   69: invokevirtual 527	android/view/View:findViewById	(I)Landroid/view/View;
    //   72: checkcast 369	android/widget/TextView
    //   75: putfield 532	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   78: aload_0
    //   79: aload_3
    //   80: ldc_w 533
    //   83: invokevirtual 527	android/view/View:findViewById	(I)Landroid/view/View;
    //   86: checkcast 535	android/widget/ImageView
    //   89: putfield 537	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   92: aload_0
    //   93: aload_3
    //   94: ldc_w 538
    //   97: invokevirtual 527	android/view/View:findViewById	(I)Landroid/view/View;
    //   100: checkcast 540	android/widget/Button
    //   103: putfield 542	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   106: aload_0
    //   107: aload_3
    //   108: ldc_w 543
    //   111: invokevirtual 527	android/view/View:findViewById	(I)Landroid/view/View;
    //   114: checkcast 545	android/widget/RelativeLayout
    //   117: putfield 547	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   120: aload_0
    //   121: aload_3
    //   122: ldc_w 548
    //   125: invokevirtual 527	android/view/View:findViewById	(I)Landroid/view/View;
    //   128: checkcast 550	com/tencent/widget/XListView
    //   131: putfield 552	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   134: aload_0
    //   135: getfield 401	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   138: bipush 8
    //   140: invokevirtual 378	android/view/View:setVisibility	(I)V
    //   143: aload_0
    //   144: getfield 417	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   147: bipush 8
    //   149: invokevirtual 378	android/view/View:setVisibility	(I)V
    //   152: aload_1
    //   153: ldc_w 553
    //   156: aconst_null
    //   157: iconst_0
    //   158: invokevirtual 522	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   161: astore 9
    //   163: aload_0
    //   164: aload 9
    //   166: ldc_w 554
    //   169: invokevirtual 527	android/view/View:findViewById	(I)Landroid/view/View;
    //   172: putfield 419	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   175: aload_0
    //   176: aload 9
    //   178: ldc_w 555
    //   181: invokevirtual 527	android/view/View:findViewById	(I)Landroid/view/View;
    //   184: checkcast 369	android/widget/TextView
    //   187: putfield 557	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   190: aload_0
    //   191: aload 9
    //   193: ldc_w 558
    //   196: invokevirtual 527	android/view/View:findViewById	(I)Landroid/view/View;
    //   199: checkcast 423	android/widget/LinearLayout
    //   202: putfield 421	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   205: invokestatic 564	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   208: invokevirtual 568	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   211: invokestatic 574	com/tencent/mobileqq/theme/ThemeUtil:isInNightMode	(Lmqq/app/AppRuntime;)Z
    //   214: ifeq +615 -> 829
    //   217: aload_0
    //   218: getfield 419	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   221: ldc_w 575
    //   224: invokevirtual 578	android/view/View:setBackgroundResource	(I)V
    //   227: aload_0
    //   228: getfield 419	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   231: bipush 8
    //   233: invokevirtual 378	android/view/View:setVisibility	(I)V
    //   236: aload_0
    //   237: getfield 421	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   240: invokevirtual 426	android/widget/LinearLayout:removeAllViews	()V
    //   243: aload_1
    //   244: ldc_w 579
    //   247: aconst_null
    //   248: iconst_0
    //   249: invokevirtual 522	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   252: astore 10
    //   254: aload_0
    //   255: aload 10
    //   257: ldc_w 580
    //   260: invokevirtual 527	android/view/View:findViewById	(I)Landroid/view/View;
    //   263: putfield 375	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   266: aload_0
    //   267: getfield 375	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   270: bipush 8
    //   272: invokevirtual 378	android/view/View:setVisibility	(I)V
    //   275: aload_1
    //   276: ldc_w 581
    //   279: aconst_null
    //   280: iconst_0
    //   281: invokevirtual 522	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   284: astore_2
    //   285: aload_2
    //   286: ifnull +111 -> 397
    //   289: aload_0
    //   290: aload_2
    //   291: ldc_w 580
    //   294: invokevirtual 527	android/view/View:findViewById	(I)Landroid/view/View;
    //   297: checkcast 369	android/widget/TextView
    //   300: putfield 403	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   303: aload_0
    //   304: getfield 403	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   307: ldc_w 582
    //   310: invokestatic 587	ajya:a	(I)Ljava/lang/String;
    //   313: invokevirtual 591	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   316: aload_0
    //   317: getfield 403	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   320: ldc_w 592
    //   323: invokevirtual 596	android/widget/TextView:setTextSize	(F)V
    //   326: aload_0
    //   327: getfield 403	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   330: aload_0
    //   331: invokevirtual 290	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   334: invokevirtual 602	android/support/v4/app/FragmentActivity:getResources	()Landroid/content/res/Resources;
    //   337: ldc_w 603
    //   340: invokevirtual 609	android/content/res/Resources:getColor	(I)I
    //   343: invokevirtual 612	android/widget/TextView:setTextColor	(I)V
    //   346: aload_0
    //   347: getfield 403	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   350: bipush 8
    //   352: invokevirtual 373	android/widget/TextView:setVisibility	(I)V
    //   355: aload_0
    //   356: aload_3
    //   357: putfield 614	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   360: aload_0
    //   361: aload_3
    //   362: ldc_w 615
    //   365: invokevirtual 527	android/view/View:findViewById	(I)Landroid/view/View;
    //   368: checkcast 550	com/tencent/widget/XListView
    //   371: putfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   374: aload_0
    //   375: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   378: new 617	awku
    //   381: dup
    //   382: aload_0
    //   383: invokespecial 618	awku:<init>	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)V
    //   386: invokevirtual 622	com/tencent/widget/XListView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   389: aload_0
    //   390: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   393: aload_2
    //   394: invokevirtual 625	com/tencent/widget/XListView:addFooterView	(Landroid/view/View;)V
    //   397: aload_1
    //   398: ldc_w 581
    //   401: aconst_null
    //   402: iconst_0
    //   403: invokevirtual 522	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   406: astore_1
    //   407: aload_1
    //   408: ifnull +77 -> 485
    //   411: aload_0
    //   412: aload_1
    //   413: ldc_w 580
    //   416: invokevirtual 527	android/view/View:findViewById	(I)Landroid/view/View;
    //   419: checkcast 369	android/widget/TextView
    //   422: putfield 367	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   425: aload_0
    //   426: getfield 367	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   429: ldc_w 626
    //   432: invokestatic 587	ajya:a	(I)Ljava/lang/String;
    //   435: invokevirtual 591	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   438: aload_0
    //   439: getfield 367	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   442: ldc_w 592
    //   445: invokevirtual 596	android/widget/TextView:setTextSize	(F)V
    //   448: aload_0
    //   449: getfield 367	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   452: aload_0
    //   453: invokevirtual 290	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   456: invokevirtual 602	android/support/v4/app/FragmentActivity:getResources	()Landroid/content/res/Resources;
    //   459: ldc_w 603
    //   462: invokevirtual 609	android/content/res/Resources:getColor	(I)I
    //   465: invokevirtual 612	android/widget/TextView:setTextColor	(I)V
    //   468: aload_0
    //   469: getfield 367	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   472: bipush 8
    //   474: invokevirtual 373	android/widget/TextView:setVisibility	(I)V
    //   477: aload_0
    //   478: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   481: aload_1
    //   482: invokevirtual 625	com/tencent/widget/XListView:addFooterView	(Landroid/view/View;)V
    //   485: aload_0
    //   486: aload_0
    //   487: invokevirtual 628	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	()Lawkl;
    //   490: putfield 407	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Awkl	Lawkl;
    //   493: aload_0
    //   494: getfield 407	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Awkl	Lawkl;
    //   497: iconst_0
    //   498: invokevirtual 629	awkl:a	(Z)V
    //   501: aload_0
    //   502: getfield 265	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   505: arraylength
    //   506: iconst_1
    //   507: if_icmpne +11 -> 518
    //   510: aload_0
    //   511: getfield 407	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Awkl	Lawkl;
    //   514: iconst_1
    //   515: invokevirtual 629	awkl:a	(Z)V
    //   518: aload_0
    //   519: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   522: aload 9
    //   524: invokevirtual 632	com/tencent/widget/XListView:addHeaderView	(Landroid/view/View;)V
    //   527: aload_0
    //   528: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   531: aload_0
    //   532: getfield 407	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Awkl	Lawkl;
    //   535: invokevirtual 636	com/tencent/widget/XListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   538: aload_0
    //   539: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   542: aload 10
    //   544: invokevirtual 625	com/tencent/widget/XListView:addFooterView	(Landroid/view/View;)V
    //   547: aload_0
    //   548: iconst_1
    //   549: putfield 280	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_Boolean	Z
    //   552: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   555: ifeq +74 -> 629
    //   558: getstatic 66	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   561: iconst_2
    //   562: new 46	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   569: ldc 255
    //   571: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload_0
    //   575: invokevirtual 258	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:hashCode	()I
    //   578: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   581: ldc_w 638
    //   584: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload_0
    //   588: getfield 330	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Boolean	Z
    //   591: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   594: ldc_w 274
    //   597: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aload_0
    //   601: getfield 276	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   604: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: ldc_w 640
    //   610: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: aload_0
    //   614: getfield 265	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   617: invokestatic 270	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   620: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokestatic 286	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   629: aload_0
    //   630: getfield 330	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Boolean	Z
    //   633: ifeq +270 -> 903
    //   636: dconst_0
    //   637: dstore 4
    //   639: dconst_0
    //   640: dstore 6
    //   642: aload_0
    //   643: invokevirtual 290	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   646: instanceof 292
    //   649: ifeq +31 -> 680
    //   652: aload_0
    //   653: invokevirtual 290	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   656: checkcast 292	awik
    //   659: invokeinterface 295 1 0
    //   664: dstore 4
    //   666: aload_0
    //   667: invokevirtual 290	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   670: checkcast 292	awik
    //   673: invokeinterface 297 1 0
    //   678: dstore 6
    //   680: aload_0
    //   681: new 46	java/lang/StringBuilder
    //   684: dup
    //   685: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   688: invokestatic 303	java/lang/System:currentTimeMillis	()J
    //   691: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   694: ldc 72
    //   696: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: putfield 76	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   705: aload_0
    //   706: aload_0
    //   707: getfield 74	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   710: putfield 179	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   713: aload_0
    //   714: iconst_1
    //   715: putfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_Boolean	Z
    //   718: new 113	android/os/Bundle
    //   721: dup
    //   722: invokespecial 114	android/os/Bundle:<init>	()V
    //   725: astore_1
    //   726: aload_0
    //   727: invokevirtual 290	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   730: instanceof 308
    //   733: ifeq +33 -> 766
    //   736: aload_0
    //   737: invokevirtual 290	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   740: checkcast 308	com/tencent/mobileqq/search/activity/ActiveEntitySearchActivity
    //   743: astore_2
    //   744: aload_1
    //   745: ldc_w 310
    //   748: aload_2
    //   749: getfield 311	com/tencent/mobileqq/search/activity/ActiveEntitySearchActivity:jdField_a_of_type_Int	I
    //   752: invokevirtual 120	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   755: aload_1
    //   756: ldc_w 313
    //   759: aload_2
    //   760: getfield 314	com/tencent/mobileqq/search/activity/ActiveEntitySearchActivity:jdField_b_of_type_Int	I
    //   763: invokevirtual 120	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   766: aload_1
    //   767: ldc_w 316
    //   770: iconst_0
    //   771: invokevirtual 320	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   774: aload_1
    //   775: ldc 116
    //   777: aload_0
    //   778: getfield 172	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_Int	I
    //   781: invokevirtual 120	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   784: aload_0
    //   785: invokevirtual 322	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	()Ljava/util/List;
    //   788: astore_2
    //   789: aload_0
    //   790: aload_0
    //   791: getfield 179	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   794: aload_2
    //   795: aload_0
    //   796: getfield 253	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfByte	[B
    //   799: dload 4
    //   801: dload 6
    //   803: aload_1
    //   804: invokevirtual 325	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Ljava/lang/String;Ljava/util/List;[BDDLandroid/os/Bundle;)V
    //   807: aload_0
    //   808: iconst_0
    //   809: invokevirtual 328	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	(Z)V
    //   812: aload_0
    //   813: iconst_0
    //   814: putfield 330	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Boolean	Z
    //   817: aload_0
    //   818: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   821: aload_0
    //   822: invokevirtual 644	com/tencent/widget/XListView:setOnScrollListener	(Lbfos;)V
    //   825: aload_0
    //   826: monitorexit
    //   827: aload_3
    //   828: areturn
    //   829: aload_0
    //   830: getfield 419	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   833: ldc_w 645
    //   836: invokevirtual 578	android/view/View:setBackgroundResource	(I)V
    //   839: goto -612 -> 227
    //   842: astore_1
    //   843: aload_0
    //   844: monitorexit
    //   845: aload_1
    //   846: athrow
    //   847: astore 11
    //   849: aload 8
    //   851: astore_2
    //   852: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   855: ifeq -570 -> 285
    //   858: getstatic 66	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   861: iconst_2
    //   862: aload 11
    //   864: invokestatic 649	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   867: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   870: aload 8
    //   872: astore_2
    //   873: goto -588 -> 285
    //   876: astore 8
    //   878: aload_2
    //   879: astore_1
    //   880: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   883: ifeq -476 -> 407
    //   886: getstatic 66	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   889: iconst_2
    //   890: aload 8
    //   892: invokestatic 649	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   895: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   898: aload_2
    //   899: astore_1
    //   900: goto -493 -> 407
    //   903: aload_0
    //   904: getfield 407	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Awkl	Lawkl;
    //   907: aload_0
    //   908: getfield 150	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   911: invokevirtual 415	awkl:a	(Ljava/util/List;)V
    //   914: aload_0
    //   915: getfield 405	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   918: bipush 8
    //   920: invokevirtual 378	android/view/View:setVisibility	(I)V
    //   923: aload_0
    //   924: getfield 417	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   927: bipush 8
    //   929: invokevirtual 378	android/view/View:setVisibility	(I)V
    //   932: aload_0
    //   933: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   936: iconst_0
    //   937: invokevirtual 650	com/tencent/widget/XListView:setVisibility	(I)V
    //   940: aload_0
    //   941: getfield 150	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   944: ifnull +15 -> 959
    //   947: aload_0
    //   948: getfield 150	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   951: invokeinterface 200 1 0
    //   956: ifeq +34 -> 990
    //   959: aload_0
    //   960: getfield 652	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_Boolean	Z
    //   963: ifeq -146 -> 817
    //   966: aload_0
    //   967: getfield 401	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   970: iconst_0
    //   971: invokevirtual 378	android/view/View:setVisibility	(I)V
    //   974: aload_0
    //   975: getfield 532	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   978: ldc_w 653
    //   981: invokestatic 587	ajya:a	(I)Ljava/lang/String;
    //   984: invokevirtual 591	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   987: goto -170 -> 817
    //   990: aload_0
    //   991: getfield 652	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_Boolean	Z
    //   994: ifeq -177 -> 817
    //   997: aload_0
    //   998: getfield 403	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1001: iconst_0
    //   1002: invokevirtual 373	android/widget/TextView:setVisibility	(I)V
    //   1005: goto -188 -> 817
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1008	0	this	ActiveEntitySearchFragment
    //   0	1008	1	paramLayoutInflater	android.view.LayoutInflater
    //   0	1008	2	paramViewGroup	android.view.ViewGroup
    //   0	1008	3	paramBundle	Bundle
    //   637	163	4	d1	double
    //   640	162	6	d2	double
    //   1	870	8	localObject	Object
    //   876	15	8	localException1	java.lang.Exception
    //   161	362	9	localView1	View
    //   252	291	10	localView2	View
    //   847	16	11	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   5	227	842	finally
    //   227	275	842	finally
    //   275	285	842	finally
    //   289	397	842	finally
    //   397	407	842	finally
    //   411	485	842	finally
    //   485	518	842	finally
    //   518	629	842	finally
    //   629	636	842	finally
    //   642	680	842	finally
    //   680	766	842	finally
    //   766	817	842	finally
    //   817	825	842	finally
    //   829	839	842	finally
    //   852	870	842	finally
    //   880	898	842	finally
    //   903	959	842	finally
    //   959	987	842	finally
    //   990	1005	842	finally
    //   275	285	847	java/lang/Exception
    //   397	407	876	java/lang/Exception
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ActiveEntitySearchActivity.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a();
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_Baxy != null) {
      this.jdField_a_of_type_Baxy.d();
    }
    if (this.jdField_a_of_type_Afdd != null) {
      this.jdField_a_of_type_Afdd.e();
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "hash = " + hashCode() + "   onDestroyView mask;" + Arrays.toString(this.jdField_a_of_type_ArrayOfLong) + " key=" + this.jdField_b_of_type_JavaLangString + "  name=" + this.jdField_e_of_type_JavaLangString);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Awkl.notifyDataSetChanged();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Awkl == null) || (this.jdField_a_of_type_Awkl.getCount() == 0) || (this.jdField_e_of_type_Int == 0)) {}
    while ((paramInt3 - paramInt1 - paramInt2 >= 10) || (this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {
      return;
    }
    b(this.jdField_b_of_type_JavaLangString);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString + " arend ", 4, " onScrollStateChanged" + paramInt);
    this.jdField_e_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_Awkl == null) || (this.jdField_a_of_type_Awkl.getCount() == 0)) {}
    while ((this.jdField_a_of_type_Awkl == null) || (this.jdField_a_of_type_Awkl.getCount() == 0) || (this.jdField_e_of_type_Int == 0) || (this.jdField_e_of_type_Int == 0) || (!this.jdField_c_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (a() >= 20)) {
      return;
    }
    b(this.jdField_b_of_type_JavaLangString);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new awkv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment
 * JD-Core Version:    0.7.0.1
 */