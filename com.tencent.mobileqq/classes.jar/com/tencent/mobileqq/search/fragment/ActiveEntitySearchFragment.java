package com.tencent.mobileqq.search.fragment;

import ajnu;
import android.content.Intent;
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
import aody;
import aoke;
import aokf;
import aokg;
import aoki;
import aoof;
import bbzl;
import bbzp;
import bbzx;
import bcbr;
import bcbs;
import bcbw;
import bccb;
import bceo;
import bcey;
import bcfp;
import bcgv;
import bcmq;
import bcni;
import blih;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pb.unite.search.DynamicTabSearch.SubHotWord;

public class ActiveEntitySearchFragment
  extends ReportV4Fragment
  implements View.OnClickListener, bbzp, blih
{
  public static String a;
  public int a;
  private long a;
  public ajnu a;
  public Bitmap a;
  protected View a;
  public Button a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  protected aoke a;
  protected aokf a;
  protected aokg a;
  protected aoki a;
  protected aoof a;
  public bcbr a;
  public QQAppInterface a;
  public XListView a;
  public List<bcfp> a;
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
    this.jdField_a_of_type_Aokf = new bcbs(this);
    this.jdField_a_of_type_Aoki = new bcbw(this);
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
  
  protected bcbr a()
  {
    return new bcbr(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_Aoof, this, 0);
  }
  
  public List<Long> a()
  {
    List localList = new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_Int).a(new bcmq(this.jdField_b_of_type_JavaLangString));
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList1 = ((aody)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a();
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
        bcgv localbcgv = (bcgv)localList.get(i);
        int j = 0;
        while (j < localArrayList1.size())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localArrayList1.get(j);
          if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(localbcgv.a.uin))) {
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aoki);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aokf);
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
          if (!(getActivity() instanceof bbzl)) {
            break label326;
          }
          d1 = ((bbzl)getActivity()).a();
          d2 = ((bbzl)getActivity()).b();
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
    if (this.jdField_a_of_type_Aokg != null)
    {
      this.jdField_a_of_type_Aokg.a(paramString, this.jdField_d_of_type_JavaLangString, 20, bbzx.a(this.jdField_a_of_type_ArrayOfLong), paramList, paramArrayOfByte, this.jdField_c_of_type_Int, paramDouble1, paramDouble2, paramBundle);
      return;
    }
    if (this.jdField_a_of_type_Aoke != null)
    {
      this.jdField_a_of_type_Aoke.a(paramString, this.jdField_d_of_type_JavaLangString, 20, bbzx.a(this.jdField_a_of_type_ArrayOfLong), paramList, paramArrayOfByte, this.jdField_c_of_type_Int, paramDouble1, paramDouble2, paramBundle);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "handler null in frag");
  }
  
  public void a(List<bcfp> paramList)
  {
    Object localObject;
    if (getActivity() != null)
    {
      localObject = getActivity().getIntent();
      if (localObject == null) {}
    }
    for (int i = ((Intent)localObject).getIntExtra("from_type_for_report", 0);; i = 0)
    {
      if (i == 9) {
        i = 5;
      }
      for (;;)
      {
        if (i > 0)
        {
          int j = 0;
          for (;;)
          {
            if (j < paramList.size())
            {
              if ((paramList.get(j) instanceof bcey))
              {
                localObject = (bcey)paramList.get(j);
                if ((localObject != null) && ((((bcey)localObject).a() instanceof bceo)))
                {
                  localObject = (bceo)((bcey)localObject).a();
                  if ((localObject != null) && (((bceo)localObject).jdField_a_of_type_Long == 1002L)) {
                    ((bceo)localObject).a(i);
                  }
                }
              }
              j += 1;
              continue;
              if (i != 3) {
                break label147;
              }
              i = 4;
              break;
            }
          }
        }
        return;
        label147:
        i = 0;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  protected void b()
  {
    if (this.jdField_d_of_type_Int == 10)
    {
      this.jdField_a_of_type_Aokg = ((aokg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(111));
      this.jdField_a_of_type_Aoke = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aoki);
      return;
    }
    this.jdField_a_of_type_Aoke = ((aoke)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(152));
    this.jdField_a_of_type_Aokg = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aokf);
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
          bcni.a("all_result", "load_tab", new String[] { paramString, bcni.a(this.jdField_b_of_type_JavaUtilList), "", bcni.a("UnifySearch.Unite", this.jdField_a_of_type_ArrayOfLong) });
        }
        if ((getActivity() instanceof bbzl))
        {
          d1 = ((bbzl)getActivity()).a();
          d2 = ((bbzl)getActivity()).b();
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
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Bcbr != null))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      a(false);
      this.jdField_a_of_type_Bcbr.a(this.jdField_a_of_type_JavaUtilList);
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
    Object localObject1 = paramView.getTag(2131368158);
    if ((localObject1 instanceof DynamicTabSearch.SubHotWord))
    {
      localObject1 = (DynamicTabSearch.SubHotWord)localObject1;
      this.jdField_c_of_type_Int = ((DynamicTabSearch.SubHotWord)localObject1).word_id.get();
      Object localObject2 = getActivity();
      if ((localObject2 instanceof ActiveEntitySearchActivity))
      {
        localObject2 = (ActiveEntitySearchActivity)localObject2;
        bcni.a("sub_result", "clk_relate", new String[] { this.jdField_b_of_type_JavaLangString, ((DynamicTabSearch.SubHotWord)localObject1).search_word.get().toStringUtf8(), "", "" });
        ((ActiveEntitySearchActivity)localObject2).a((DynamicTabSearch.SubHotWord)localObject1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
      this.jdField_a_of_type_Aoof = new aoof(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    for (this.jdField_a_of_type_ArrayOfLong = aokg.c;; this.jdField_a_of_type_ArrayOfLong = aoke.c)
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
    //   9: invokespecial 552	android/support/v4/app/Fragment:onCreateView	(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    //   12: pop
    //   13: aload_1
    //   14: ldc_w 553
    //   17: aload_2
    //   18: iconst_0
    //   19: invokevirtual 559	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   22: astore_3
    //   23: aload_0
    //   24: aload_3
    //   25: ldc_w 560
    //   28: invokevirtual 564	android/view/View:findViewById	(I)Landroid/view/View;
    //   31: putfield 433	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   34: aload_0
    //   35: getfield 433	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   38: iconst_0
    //   39: invokevirtual 406	android/view/View:setVisibility	(I)V
    //   42: aload_0
    //   43: aload_3
    //   44: ldc_w 565
    //   47: invokevirtual 564	android/view/View:findViewById	(I)Landroid/view/View;
    //   50: putfield 444	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   53: aload_0
    //   54: aload_3
    //   55: ldc_w 566
    //   58: invokevirtual 564	android/view/View:findViewById	(I)Landroid/view/View;
    //   61: putfield 429	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   64: aload_0
    //   65: aload_3
    //   66: ldc_w 567
    //   69: invokevirtual 564	android/view/View:findViewById	(I)Landroid/view/View;
    //   72: checkcast 398	android/widget/TextView
    //   75: putfield 569	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   78: aload_0
    //   79: aload_3
    //   80: ldc_w 570
    //   83: invokevirtual 564	android/view/View:findViewById	(I)Landroid/view/View;
    //   86: checkcast 572	android/widget/ImageView
    //   89: putfield 574	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   92: aload_0
    //   93: aload_3
    //   94: ldc_w 575
    //   97: invokevirtual 564	android/view/View:findViewById	(I)Landroid/view/View;
    //   100: checkcast 577	android/widget/Button
    //   103: putfield 579	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   106: aload_0
    //   107: aload_3
    //   108: ldc_w 580
    //   111: invokevirtual 564	android/view/View:findViewById	(I)Landroid/view/View;
    //   114: checkcast 582	android/widget/RelativeLayout
    //   117: putfield 584	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   120: aload_0
    //   121: aload_3
    //   122: ldc_w 585
    //   125: invokevirtual 564	android/view/View:findViewById	(I)Landroid/view/View;
    //   128: checkcast 587	com/tencent/widget/XListView
    //   131: putfield 589	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   134: aload_0
    //   135: getfield 429	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   138: bipush 8
    //   140: invokevirtual 406	android/view/View:setVisibility	(I)V
    //   143: aload_0
    //   144: getfield 444	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   147: bipush 8
    //   149: invokevirtual 406	android/view/View:setVisibility	(I)V
    //   152: aload_1
    //   153: ldc_w 590
    //   156: aconst_null
    //   157: iconst_0
    //   158: invokevirtual 559	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   161: astore 9
    //   163: aload_0
    //   164: aload 9
    //   166: ldc_w 591
    //   169: invokevirtual 564	android/view/View:findViewById	(I)Landroid/view/View;
    //   172: putfield 446	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   175: aload_0
    //   176: aload 9
    //   178: ldc_w 592
    //   181: invokevirtual 564	android/view/View:findViewById	(I)Landroid/view/View;
    //   184: checkcast 398	android/widget/TextView
    //   187: putfield 594	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   190: aload_0
    //   191: aload 9
    //   193: ldc_w 595
    //   196: invokevirtual 564	android/view/View:findViewById	(I)Landroid/view/View;
    //   199: checkcast 450	android/widget/LinearLayout
    //   202: putfield 448	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   205: invokestatic 601	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   208: invokevirtual 605	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   211: invokestatic 611	com/tencent/mobileqq/theme/ThemeUtil:isInNightMode	(Lmqq/app/AppRuntime;)Z
    //   214: ifeq +620 -> 834
    //   217: aload_0
    //   218: getfield 446	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   221: ldc_w 612
    //   224: invokevirtual 615	android/view/View:setBackgroundResource	(I)V
    //   227: aload_0
    //   228: getfield 446	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   231: bipush 8
    //   233: invokevirtual 406	android/view/View:setVisibility	(I)V
    //   236: aload_0
    //   237: getfield 448	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   240: invokevirtual 453	android/widget/LinearLayout:removeAllViews	()V
    //   243: aload_1
    //   244: ldc_w 616
    //   247: aconst_null
    //   248: iconst_0
    //   249: invokevirtual 559	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   252: astore 10
    //   254: aload_0
    //   255: aload 10
    //   257: ldc_w 617
    //   260: invokevirtual 564	android/view/View:findViewById	(I)Landroid/view/View;
    //   263: putfield 403	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   266: aload_0
    //   267: getfield 403	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   270: bipush 8
    //   272: invokevirtual 406	android/view/View:setVisibility	(I)V
    //   275: aload_1
    //   276: ldc_w 618
    //   279: aconst_null
    //   280: iconst_0
    //   281: invokevirtual 559	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   284: astore_2
    //   285: aload_2
    //   286: ifnull +111 -> 397
    //   289: aload_0
    //   290: aload_2
    //   291: ldc_w 617
    //   294: invokevirtual 564	android/view/View:findViewById	(I)Landroid/view/View;
    //   297: checkcast 398	android/widget/TextView
    //   300: putfield 431	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   303: aload_0
    //   304: getfield 431	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   307: ldc_w 619
    //   310: invokestatic 624	anzj:a	(I)Ljava/lang/String;
    //   313: invokevirtual 628	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   316: aload_0
    //   317: getfield 431	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   320: ldc_w 629
    //   323: invokevirtual 633	android/widget/TextView:setTextSize	(F)V
    //   326: aload_0
    //   327: getfield 431	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   330: aload_0
    //   331: invokevirtual 290	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   334: invokevirtual 637	android/support/v4/app/FragmentActivity:getResources	()Landroid/content/res/Resources;
    //   337: ldc_w 638
    //   340: invokevirtual 644	android/content/res/Resources:getColor	(I)I
    //   343: invokevirtual 647	android/widget/TextView:setTextColor	(I)V
    //   346: aload_0
    //   347: getfield 431	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   350: bipush 8
    //   352: invokevirtual 401	android/widget/TextView:setVisibility	(I)V
    //   355: aload_0
    //   356: aload_3
    //   357: putfield 649	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   360: aload_0
    //   361: aload_3
    //   362: ldc_w 650
    //   365: invokevirtual 564	android/view/View:findViewById	(I)Landroid/view/View;
    //   368: checkcast 587	com/tencent/widget/XListView
    //   371: putfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   374: aload_0
    //   375: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   378: new 652	bcca
    //   381: dup
    //   382: aload_0
    //   383: invokespecial 653	bcca:<init>	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)V
    //   386: invokevirtual 657	com/tencent/widget/XListView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   389: aload_0
    //   390: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   393: aload_2
    //   394: invokevirtual 660	com/tencent/widget/XListView:addFooterView	(Landroid/view/View;)V
    //   397: aload_1
    //   398: ldc_w 618
    //   401: aconst_null
    //   402: iconst_0
    //   403: invokevirtual 559	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   406: astore_1
    //   407: aload_1
    //   408: ifnull +77 -> 485
    //   411: aload_0
    //   412: aload_1
    //   413: ldc_w 617
    //   416: invokevirtual 564	android/view/View:findViewById	(I)Landroid/view/View;
    //   419: checkcast 398	android/widget/TextView
    //   422: putfield 396	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   425: aload_0
    //   426: getfield 396	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   429: ldc_w 661
    //   432: invokestatic 624	anzj:a	(I)Ljava/lang/String;
    //   435: invokevirtual 628	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   438: aload_0
    //   439: getfield 396	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   442: ldc_w 629
    //   445: invokevirtual 633	android/widget/TextView:setTextSize	(F)V
    //   448: aload_0
    //   449: getfield 396	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   452: aload_0
    //   453: invokevirtual 290	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   456: invokevirtual 637	android/support/v4/app/FragmentActivity:getResources	()Landroid/content/res/Resources;
    //   459: ldc_w 638
    //   462: invokevirtual 644	android/content/res/Resources:getColor	(I)I
    //   465: invokevirtual 647	android/widget/TextView:setTextColor	(I)V
    //   468: aload_0
    //   469: getfield 396	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   472: bipush 8
    //   474: invokevirtual 401	android/widget/TextView:setVisibility	(I)V
    //   477: aload_0
    //   478: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   481: aload_1
    //   482: invokevirtual 660	com/tencent/widget/XListView:addFooterView	(Landroid/view/View;)V
    //   485: aload_0
    //   486: aload_0
    //   487: invokevirtual 663	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	()Lbcbr;
    //   490: putfield 435	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Bcbr	Lbcbr;
    //   493: aload_0
    //   494: getfield 435	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Bcbr	Lbcbr;
    //   497: iconst_0
    //   498: invokevirtual 664	bcbr:a	(Z)V
    //   501: aload_0
    //   502: getfield 265	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   505: arraylength
    //   506: iconst_1
    //   507: if_icmpne +11 -> 518
    //   510: aload_0
    //   511: getfield 435	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Bcbr	Lbcbr;
    //   514: iconst_1
    //   515: invokevirtual 664	bcbr:a	(Z)V
    //   518: aload_0
    //   519: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   522: aload 9
    //   524: invokevirtual 667	com/tencent/widget/XListView:addHeaderView	(Landroid/view/View;)V
    //   527: aload_0
    //   528: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   531: aload_0
    //   532: getfield 435	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Bcbr	Lbcbr;
    //   535: invokevirtual 671	com/tencent/widget/XListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   538: aload_0
    //   539: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   542: aload 10
    //   544: invokevirtual 660	com/tencent/widget/XListView:addFooterView	(Landroid/view/View;)V
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
    //   581: ldc_w 673
    //   584: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload_0
    //   588: getfield 330	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Boolean	Z
    //   591: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   594: ldc_w 274
    //   597: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aload_0
    //   601: getfield 276	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   604: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: ldc_w 675
    //   610: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: aload_0
    //   614: getfield 265	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   617: invokestatic 270	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   620: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokestatic 286	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   629: aload_0
    //   630: getfield 330	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Boolean	Z
    //   633: ifeq +275 -> 908
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
    //   656: checkcast 292	bbzl
    //   659: invokeinterface 295 1 0
    //   664: dstore 4
    //   666: aload_0
    //   667: invokevirtual 290	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   670: checkcast 292	bbzl
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
    //   822: invokevirtual 679	com/tencent/widget/XListView:setOnScrollListener	(Lblih;)V
    //   825: aload_0
    //   826: aload_3
    //   827: invokestatic 685	com/tencent/qqlive/module/videoreport/inject/fragment/V4FragmentCollector:onV4FragmentViewCreated	(Landroid/support/v4/app/Fragment;Landroid/view/View;)V
    //   830: aload_0
    //   831: monitorexit
    //   832: aload_3
    //   833: areturn
    //   834: aload_0
    //   835: getfield 446	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   838: ldc_w 686
    //   841: invokevirtual 615	android/view/View:setBackgroundResource	(I)V
    //   844: goto -617 -> 227
    //   847: astore_1
    //   848: aload_0
    //   849: monitorexit
    //   850: aload_1
    //   851: athrow
    //   852: astore 11
    //   854: aload 8
    //   856: astore_2
    //   857: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   860: ifeq -575 -> 285
    //   863: getstatic 66	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   866: iconst_2
    //   867: aload 11
    //   869: invokestatic 690	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   872: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   875: aload 8
    //   877: astore_2
    //   878: goto -593 -> 285
    //   881: astore 8
    //   883: aload_2
    //   884: astore_1
    //   885: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   888: ifeq -481 -> 407
    //   891: getstatic 66	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   894: iconst_2
    //   895: aload 8
    //   897: invokestatic 690	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   900: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   903: aload_2
    //   904: astore_1
    //   905: goto -498 -> 407
    //   908: aload_0
    //   909: getfield 435	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Bcbr	Lbcbr;
    //   912: aload_0
    //   913: getfield 150	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   916: invokevirtual 442	bcbr:a	(Ljava/util/List;)V
    //   919: aload_0
    //   920: getfield 433	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   923: bipush 8
    //   925: invokevirtual 406	android/view/View:setVisibility	(I)V
    //   928: aload_0
    //   929: getfield 444	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   932: bipush 8
    //   934: invokevirtual 406	android/view/View:setVisibility	(I)V
    //   937: aload_0
    //   938: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   941: iconst_0
    //   942: invokevirtual 691	com/tencent/widget/XListView:setVisibility	(I)V
    //   945: aload_0
    //   946: getfield 150	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   949: ifnull +15 -> 964
    //   952: aload_0
    //   953: getfield 150	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   956: invokeinterface 200 1 0
    //   961: ifeq +34 -> 995
    //   964: aload_0
    //   965: getfield 693	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_Boolean	Z
    //   968: ifeq -151 -> 817
    //   971: aload_0
    //   972: getfield 429	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   975: iconst_0
    //   976: invokevirtual 406	android/view/View:setVisibility	(I)V
    //   979: aload_0
    //   980: getfield 569	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   983: ldc_w 694
    //   986: invokestatic 624	anzj:a	(I)Ljava/lang/String;
    //   989: invokevirtual 628	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   992: goto -175 -> 817
    //   995: aload_0
    //   996: getfield 693	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_Boolean	Z
    //   999: ifeq -182 -> 817
    //   1002: aload_0
    //   1003: getfield 431	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1006: iconst_0
    //   1007: invokevirtual 401	android/widget/TextView:setVisibility	(I)V
    //   1010: goto -193 -> 817
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1013	0	this	ActiveEntitySearchFragment
    //   0	1013	1	paramLayoutInflater	android.view.LayoutInflater
    //   0	1013	2	paramViewGroup	android.view.ViewGroup
    //   0	1013	3	paramBundle	Bundle
    //   637	163	4	d1	double
    //   640	162	6	d2	double
    //   1	875	8	localObject	Object
    //   881	15	8	localException1	java.lang.Exception
    //   161	362	9	localView1	View
    //   252	291	10	localView2	View
    //   852	16	11	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   5	227	847	finally
    //   227	275	847	finally
    //   275	285	847	finally
    //   289	397	847	finally
    //   397	407	847	finally
    //   411	485	847	finally
    //   485	518	847	finally
    //   518	629	847	finally
    //   629	636	847	finally
    //   642	680	847	finally
    //   680	766	847	finally
    //   766	817	847	finally
    //   817	830	847	finally
    //   834	844	847	finally
    //   857	875	847	finally
    //   885	903	847	finally
    //   908	964	847	finally
    //   964	992	847	finally
    //   995	1010	847	finally
    //   275	285	852	java/lang/Exception
    //   397	407	881	java/lang/Exception
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ActiveEntitySearchActivity.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a();
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.d();
    }
    if (this.jdField_a_of_type_Ajnu != null) {
      this.jdField_a_of_type_Ajnu.c();
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "hash = " + hashCode() + "   onDestroyView mask;" + Arrays.toString(this.jdField_a_of_type_ArrayOfLong) + " key=" + this.jdField_b_of_type_JavaLangString + "  name=" + this.jdField_e_of_type_JavaLangString);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Bcbr.notifyDataSetChanged();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Bcbr == null) || (this.jdField_a_of_type_Bcbr.getCount() == 0) || (this.jdField_e_of_type_Int == 0)) {}
    while ((paramInt3 - paramInt1 - paramInt2 >= 10) || (this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {
      return;
    }
    b(this.jdField_b_of_type_JavaLangString);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString + " arend ", 4, " onScrollStateChanged" + paramInt);
    this.jdField_e_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_Bcbr == null) || (this.jdField_a_of_type_Bcbr.getCount() == 0)) {}
    while ((this.jdField_a_of_type_Bcbr == null) || (this.jdField_a_of_type_Bcbr.getCount() == 0) || (this.jdField_e_of_type_Int == 0) || (this.jdField_e_of_type_Int == 0) || (!this.jdField_c_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (a() >= 20)) {
      return;
    }
    b(this.jdField_b_of_type_JavaLangString);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new bccb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment
 * JD-Core Version:    0.7.0.1
 */