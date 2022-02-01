package com.tencent.mobileqq.search.fragment;

import ajdc;
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
import aoan;
import aogg;
import aogh;
import aogi;
import aogk;
import bbze;
import bbzi;
import bbzq;
import bcbj;
import bcbk;
import bcbo;
import bcbt;
import bceg;
import bceq;
import bcfh;
import bcgn;
import bcmk;
import bcnc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDecoder;
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
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pb.unite.search.DynamicTabSearch.SubHotWord;

public class ActiveEntitySearchFragment
  extends ReportV4Fragment
  implements View.OnClickListener, bbzi, AbsListView.OnScrollListener
{
  public static String a;
  public int a;
  private long a;
  public ajdc a;
  public Bitmap a;
  protected View a;
  public Button a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  protected aogg a;
  protected aogh a;
  protected aogi a;
  protected aogk a;
  public bcbj a;
  public QQAppInterface a;
  protected FaceDecoder a;
  public XListView a;
  public List<bcfh> a;
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
    this.jdField_a_of_type_Aogh = new bcbk(this);
    this.jdField_a_of_type_Aogk = new bcbo(this);
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
  
  protected bcbj a()
  {
    return new bcbj(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, this, 0);
  }
  
  public List<Long> a()
  {
    List localList = new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_Int).a(new bcmk(this.jdField_b_of_type_JavaLangString));
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList1 = ((aoan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a();
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
        bcgn localbcgn = (bcgn)localList.get(i);
        int j = 0;
        while (j < localArrayList1.size())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localArrayList1.get(j);
          if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(localbcgn.a.uin))) {
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aogk);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aogh);
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
          if (!(getActivity() instanceof bbze)) {
            break label327;
          }
          d1 = ((bbze)getActivity()).a();
          d2 = ((bbze)getActivity()).b();
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
        label327:
        d1 = 0.0D;
      }
    }
  }
  
  protected void a(String paramString, List<Long> paramList, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aogi != null)
    {
      this.jdField_a_of_type_Aogi.a(paramString, this.jdField_d_of_type_JavaLangString, 20, bbzq.a(this.jdField_a_of_type_ArrayOfLong), paramList, paramArrayOfByte, this.jdField_c_of_type_Int, paramDouble1, paramDouble2, paramBundle);
      return;
    }
    if (this.jdField_a_of_type_Aogg != null)
    {
      this.jdField_a_of_type_Aogg.a(paramString, this.jdField_d_of_type_JavaLangString, 20, bbzq.a(this.jdField_a_of_type_ArrayOfLong), paramList, paramArrayOfByte, this.jdField_c_of_type_Int, paramDouble1, paramDouble2, paramBundle);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "handler null in frag");
  }
  
  public void a(List<bcfh> paramList)
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
              if ((paramList.get(j) instanceof bceq))
              {
                localObject = (bceq)paramList.get(j);
                if ((localObject != null) && ((((bceq)localObject).a() instanceof bceg)))
                {
                  localObject = (bceg)((bceq)localObject).a();
                  if ((localObject != null) && (((bceg)localObject).jdField_a_of_type_Long == 1002L)) {
                    ((bceg)localObject).a(i);
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
      this.jdField_a_of_type_Aogi = ((aogi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER));
      this.jdField_a_of_type_Aogg = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aogk);
      return;
    }
    this.jdField_a_of_type_Aogg = ((aogg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER));
    this.jdField_a_of_type_Aogi = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aogh);
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
          bcnc.a("all_result", "load_tab", new String[] { paramString, bcnc.a(this.jdField_b_of_type_JavaUtilList), "", bcnc.a("UnifySearch.Unite", this.jdField_a_of_type_ArrayOfLong) });
        }
        if ((getActivity() instanceof bbze))
        {
          d1 = ((bbze)getActivity()).a();
          d2 = ((bbze)getActivity()).b();
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
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Bcbj != null))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      a(false);
      this.jdField_a_of_type_Bcbj.a(this.jdField_a_of_type_JavaUtilList);
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
    Object localObject1 = paramView.getTag(2131368331);
    if ((localObject1 instanceof DynamicTabSearch.SubHotWord))
    {
      localObject1 = (DynamicTabSearch.SubHotWord)localObject1;
      this.jdField_c_of_type_Int = ((DynamicTabSearch.SubHotWord)localObject1).word_id.get();
      Object localObject2 = getActivity();
      if ((localObject2 instanceof ActiveEntitySearchActivity))
      {
        localObject2 = (ActiveEntitySearchActivity)localObject2;
        bcnc.a("sub_result", "clk_relate", new String[] { this.jdField_b_of_type_JavaLangString, ((DynamicTabSearch.SubHotWord)localObject1).search_word.get().toStringUtf8(), "", "" });
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
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    for (this.jdField_a_of_type_ArrayOfLong = aogi.c;; this.jdField_a_of_type_ArrayOfLong = aogg.c)
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
    //   9: invokespecial 566	android/support/v4/app/Fragment:onCreateView	(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    //   12: pop
    //   13: aload_1
    //   14: ldc_w 567
    //   17: aload_2
    //   18: iconst_0
    //   19: invokevirtual 573	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   22: astore_3
    //   23: aload_0
    //   24: aload_3
    //   25: ldc_w 574
    //   28: invokevirtual 578	android/view/View:findViewById	(I)Landroid/view/View;
    //   31: putfield 447	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   34: aload_0
    //   35: getfield 447	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   38: iconst_0
    //   39: invokevirtual 420	android/view/View:setVisibility	(I)V
    //   42: aload_0
    //   43: aload_3
    //   44: ldc_w 579
    //   47: invokevirtual 578	android/view/View:findViewById	(I)Landroid/view/View;
    //   50: putfield 458	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   53: aload_0
    //   54: aload_3
    //   55: ldc_w 580
    //   58: invokevirtual 578	android/view/View:findViewById	(I)Landroid/view/View;
    //   61: putfield 443	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   64: aload_0
    //   65: aload_3
    //   66: ldc_w 581
    //   69: invokevirtual 578	android/view/View:findViewById	(I)Landroid/view/View;
    //   72: checkcast 412	android/widget/TextView
    //   75: putfield 583	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   78: aload_0
    //   79: aload_3
    //   80: ldc_w 584
    //   83: invokevirtual 578	android/view/View:findViewById	(I)Landroid/view/View;
    //   86: checkcast 586	android/widget/ImageView
    //   89: putfield 588	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   92: aload_0
    //   93: aload_3
    //   94: ldc_w 589
    //   97: invokevirtual 578	android/view/View:findViewById	(I)Landroid/view/View;
    //   100: checkcast 591	android/widget/Button
    //   103: putfield 593	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   106: aload_0
    //   107: aload_3
    //   108: ldc_w 594
    //   111: invokevirtual 578	android/view/View:findViewById	(I)Landroid/view/View;
    //   114: checkcast 596	android/widget/RelativeLayout
    //   117: putfield 598	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidViewView	Landroid/view/View;
    //   120: aload_0
    //   121: aload_3
    //   122: ldc_w 599
    //   125: invokevirtual 578	android/view/View:findViewById	(I)Landroid/view/View;
    //   128: checkcast 601	com/tencent/widget/XListView
    //   131: putfield 603	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   134: aload_0
    //   135: getfield 443	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   138: bipush 8
    //   140: invokevirtual 420	android/view/View:setVisibility	(I)V
    //   143: aload_0
    //   144: getfield 458	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   147: bipush 8
    //   149: invokevirtual 420	android/view/View:setVisibility	(I)V
    //   152: aload_1
    //   153: ldc_w 604
    //   156: aconst_null
    //   157: iconst_0
    //   158: invokevirtual 573	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   161: astore 9
    //   163: aload_0
    //   164: aload 9
    //   166: ldc_w 605
    //   169: invokevirtual 578	android/view/View:findViewById	(I)Landroid/view/View;
    //   172: putfield 460	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   175: aload_0
    //   176: aload 9
    //   178: ldc_w 606
    //   181: invokevirtual 578	android/view/View:findViewById	(I)Landroid/view/View;
    //   184: checkcast 412	android/widget/TextView
    //   187: putfield 608	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   190: aload_0
    //   191: aload 9
    //   193: ldc_w 609
    //   196: invokevirtual 578	android/view/View:findViewById	(I)Landroid/view/View;
    //   199: checkcast 464	android/widget/LinearLayout
    //   202: putfield 462	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   205: invokestatic 615	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   208: invokevirtual 619	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   211: invokestatic 625	com/tencent/mobileqq/theme/ThemeUtil:isInNightMode	(Lmqq/app/AppRuntime;)Z
    //   214: ifeq +621 -> 835
    //   217: aload_0
    //   218: getfield 460	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   221: ldc_w 626
    //   224: invokevirtual 629	android/view/View:setBackgroundResource	(I)V
    //   227: aload_0
    //   228: getfield 460	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   231: bipush 8
    //   233: invokevirtual 420	android/view/View:setVisibility	(I)V
    //   236: aload_0
    //   237: getfield 462	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   240: invokevirtual 467	android/widget/LinearLayout:removeAllViews	()V
    //   243: aload_1
    //   244: ldc_w 630
    //   247: aconst_null
    //   248: iconst_0
    //   249: invokevirtual 573	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   252: astore 10
    //   254: aload_0
    //   255: aload 10
    //   257: ldc_w 631
    //   260: invokevirtual 578	android/view/View:findViewById	(I)Landroid/view/View;
    //   263: putfield 417	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   266: aload_0
    //   267: getfield 417	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidViewView	Landroid/view/View;
    //   270: bipush 8
    //   272: invokevirtual 420	android/view/View:setVisibility	(I)V
    //   275: aload_1
    //   276: ldc_w 632
    //   279: aconst_null
    //   280: iconst_0
    //   281: invokevirtual 573	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   284: astore_2
    //   285: aload_2
    //   286: ifnull +111 -> 397
    //   289: aload_0
    //   290: aload_2
    //   291: ldc_w 631
    //   294: invokevirtual 578	android/view/View:findViewById	(I)Landroid/view/View;
    //   297: checkcast 412	android/widget/TextView
    //   300: putfield 445	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   303: aload_0
    //   304: getfield 445	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   307: ldc_w 633
    //   310: invokestatic 638	anvx:a	(I)Ljava/lang/String;
    //   313: invokevirtual 642	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   316: aload_0
    //   317: getfield 445	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   320: ldc_w 643
    //   323: invokevirtual 647	android/widget/TextView:setTextSize	(F)V
    //   326: aload_0
    //   327: getfield 445	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   330: aload_0
    //   331: invokevirtual 295	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   334: invokevirtual 651	android/support/v4/app/FragmentActivity:getResources	()Landroid/content/res/Resources;
    //   337: ldc_w 652
    //   340: invokevirtual 658	android/content/res/Resources:getColor	(I)I
    //   343: invokevirtual 661	android/widget/TextView:setTextColor	(I)V
    //   346: aload_0
    //   347: getfield 445	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   350: bipush 8
    //   352: invokevirtual 415	android/widget/TextView:setVisibility	(I)V
    //   355: aload_0
    //   356: aload_3
    //   357: putfield 663	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   360: aload_0
    //   361: aload_3
    //   362: ldc_w 664
    //   365: invokevirtual 578	android/view/View:findViewById	(I)Landroid/view/View;
    //   368: checkcast 601	com/tencent/widget/XListView
    //   371: putfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   374: aload_0
    //   375: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   378: new 666	bcbs
    //   381: dup
    //   382: aload_0
    //   383: invokespecial 667	bcbs:<init>	(Lcom/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment;)V
    //   386: invokevirtual 671	com/tencent/widget/XListView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   389: aload_0
    //   390: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   393: aload_2
    //   394: invokevirtual 674	com/tencent/widget/XListView:addFooterView	(Landroid/view/View;)V
    //   397: aload_1
    //   398: ldc_w 632
    //   401: aconst_null
    //   402: iconst_0
    //   403: invokevirtual 573	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   406: astore_1
    //   407: aload_1
    //   408: ifnull +77 -> 485
    //   411: aload_0
    //   412: aload_1
    //   413: ldc_w 631
    //   416: invokevirtual 578	android/view/View:findViewById	(I)Landroid/view/View;
    //   419: checkcast 412	android/widget/TextView
    //   422: putfield 410	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   425: aload_0
    //   426: getfield 410	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   429: ldc_w 675
    //   432: invokestatic 638	anvx:a	(I)Ljava/lang/String;
    //   435: invokevirtual 642	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   438: aload_0
    //   439: getfield 410	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   442: ldc_w 643
    //   445: invokevirtual 647	android/widget/TextView:setTextSize	(F)V
    //   448: aload_0
    //   449: getfield 410	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   452: aload_0
    //   453: invokevirtual 295	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   456: invokevirtual 651	android/support/v4/app/FragmentActivity:getResources	()Landroid/content/res/Resources;
    //   459: ldc_w 652
    //   462: invokevirtual 658	android/content/res/Resources:getColor	(I)I
    //   465: invokevirtual 661	android/widget/TextView:setTextColor	(I)V
    //   468: aload_0
    //   469: getfield 410	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   472: bipush 8
    //   474: invokevirtual 415	android/widget/TextView:setVisibility	(I)V
    //   477: aload_0
    //   478: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   481: aload_1
    //   482: invokevirtual 674	com/tencent/widget/XListView:addFooterView	(Landroid/view/View;)V
    //   485: aload_0
    //   486: aload_0
    //   487: invokevirtual 677	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	()Lbcbj;
    //   490: putfield 449	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Bcbj	Lbcbj;
    //   493: aload_0
    //   494: getfield 449	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Bcbj	Lbcbj;
    //   497: iconst_0
    //   498: invokevirtual 678	bcbj:a	(Z)V
    //   501: aload_0
    //   502: getfield 270	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   505: arraylength
    //   506: iconst_1
    //   507: if_icmpne +11 -> 518
    //   510: aload_0
    //   511: getfield 449	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Bcbj	Lbcbj;
    //   514: iconst_1
    //   515: invokevirtual 678	bcbj:a	(Z)V
    //   518: aload_0
    //   519: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   522: aload 9
    //   524: invokevirtual 681	com/tencent/widget/XListView:addHeaderView	(Landroid/view/View;)V
    //   527: aload_0
    //   528: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   531: aload_0
    //   532: getfield 449	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Bcbj	Lbcbj;
    //   535: invokevirtual 685	com/tencent/widget/XListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   538: aload_0
    //   539: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   542: aload 10
    //   544: invokevirtual 674	com/tencent/widget/XListView:addFooterView	(Landroid/view/View;)V
    //   547: aload_0
    //   548: iconst_1
    //   549: putfield 285	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_Boolean	Z
    //   552: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   555: ifeq +75 -> 630
    //   558: getstatic 66	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   561: iconst_2
    //   562: new 46	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   569: ldc_w 260
    //   572: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload_0
    //   576: invokevirtual 263	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:hashCode	()I
    //   579: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   582: ldc_w 687
    //   585: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload_0
    //   589: getfield 335	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Boolean	Z
    //   592: invokevirtual 288	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   595: ldc_w 279
    //   598: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: aload_0
    //   602: getfield 281	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   605: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: ldc_w 689
    //   611: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: aload_0
    //   615: getfield 270	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfLong	[J
    //   618: invokestatic 275	java/util/Arrays:toString	([J)Ljava/lang/String;
    //   621: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 291	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: aload_0
    //   631: getfield 335	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Boolean	Z
    //   634: ifeq +275 -> 909
    //   637: dconst_0
    //   638: dstore 4
    //   640: dconst_0
    //   641: dstore 6
    //   643: aload_0
    //   644: invokevirtual 295	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   647: instanceof 297
    //   650: ifeq +31 -> 681
    //   653: aload_0
    //   654: invokevirtual 295	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   657: checkcast 297	bbze
    //   660: invokeinterface 300 1 0
    //   665: dstore 4
    //   667: aload_0
    //   668: invokevirtual 295	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   671: checkcast 297	bbze
    //   674: invokeinterface 302 1 0
    //   679: dstore 6
    //   681: aload_0
    //   682: new 46	java/lang/StringBuilder
    //   685: dup
    //   686: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   689: invokestatic 308	java/lang/System:currentTimeMillis	()J
    //   692: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   695: ldc 72
    //   697: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: putfield 76	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   706: aload_0
    //   707: aload_0
    //   708: getfield 74	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   711: putfield 179	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   714: aload_0
    //   715: iconst_1
    //   716: putfield 78	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_Boolean	Z
    //   719: new 113	android/os/Bundle
    //   722: dup
    //   723: invokespecial 114	android/os/Bundle:<init>	()V
    //   726: astore_1
    //   727: aload_0
    //   728: invokevirtual 295	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   731: instanceof 313
    //   734: ifeq +33 -> 767
    //   737: aload_0
    //   738: invokevirtual 295	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   741: checkcast 313	com/tencent/mobileqq/search/activity/ActiveEntitySearchActivity
    //   744: astore_2
    //   745: aload_1
    //   746: ldc_w 315
    //   749: aload_2
    //   750: getfield 316	com/tencent/mobileqq/search/activity/ActiveEntitySearchActivity:jdField_a_of_type_Int	I
    //   753: invokevirtual 120	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   756: aload_1
    //   757: ldc_w 318
    //   760: aload_2
    //   761: getfield 319	com/tencent/mobileqq/search/activity/ActiveEntitySearchActivity:jdField_b_of_type_Int	I
    //   764: invokevirtual 120	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   767: aload_1
    //   768: ldc_w 321
    //   771: iconst_0
    //   772: invokevirtual 325	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   775: aload_1
    //   776: ldc 116
    //   778: aload_0
    //   779: getfield 172	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_Int	I
    //   782: invokevirtual 120	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   785: aload_0
    //   786: invokevirtual 327	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	()Ljava/util/List;
    //   789: astore_2
    //   790: aload_0
    //   791: aload_0
    //   792: getfield 179	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   795: aload_2
    //   796: aload_0
    //   797: getfield 258	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ArrayOfByte	[B
    //   800: dload 4
    //   802: dload 6
    //   804: aload_1
    //   805: invokevirtual 330	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:a	(Ljava/lang/String;Ljava/util/List;[BDDLandroid/os/Bundle;)V
    //   808: aload_0
    //   809: iconst_0
    //   810: invokevirtual 333	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:b	(Z)V
    //   813: aload_0
    //   814: iconst_0
    //   815: putfield 335	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_Boolean	Z
    //   818: aload_0
    //   819: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   822: aload_0
    //   823: invokevirtual 693	com/tencent/widget/XListView:setOnScrollListener	(Lcom/tencent/widget/AbsListView$OnScrollListener;)V
    //   826: aload_0
    //   827: aload_3
    //   828: invokestatic 699	com/tencent/qqlive/module/videoreport/inject/fragment/V4FragmentCollector:onV4FragmentViewCreated	(Landroid/support/v4/app/Fragment;Landroid/view/View;)V
    //   831: aload_0
    //   832: monitorexit
    //   833: aload_3
    //   834: areturn
    //   835: aload_0
    //   836: getfield 460	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_AndroidViewView	Landroid/view/View;
    //   839: ldc_w 700
    //   842: invokevirtual 629	android/view/View:setBackgroundResource	(I)V
    //   845: goto -618 -> 227
    //   848: astore_1
    //   849: aload_0
    //   850: monitorexit
    //   851: aload_1
    //   852: athrow
    //   853: astore 11
    //   855: aload 8
    //   857: astore_2
    //   858: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   861: ifeq -576 -> 285
    //   864: getstatic 66	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   867: iconst_2
    //   868: aload 11
    //   870: invokestatic 704	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   873: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   876: aload 8
    //   878: astore_2
    //   879: goto -594 -> 285
    //   882: astore 8
    //   884: aload_2
    //   885: astore_1
    //   886: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   889: ifeq -482 -> 407
    //   892: getstatic 66	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   895: iconst_2
    //   896: aload 8
    //   898: invokestatic 704	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   901: invokestatic 215	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   904: aload_2
    //   905: astore_1
    //   906: goto -499 -> 407
    //   909: aload_0
    //   910: getfield 449	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_Bcbj	Lbcbj;
    //   913: aload_0
    //   914: getfield 150	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   917: invokevirtual 456	bcbj:a	(Ljava/util/List;)V
    //   920: aload_0
    //   921: getfield 447	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_e_of_type_AndroidViewView	Landroid/view/View;
    //   924: bipush 8
    //   926: invokevirtual 420	android/view/View:setVisibility	(I)V
    //   929: aload_0
    //   930: getfield 458	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   933: bipush 8
    //   935: invokevirtual 420	android/view/View:setVisibility	(I)V
    //   938: aload_0
    //   939: getfield 160	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_ComTencentWidgetXListView	Lcom/tencent/widget/XListView;
    //   942: iconst_0
    //   943: invokevirtual 705	com/tencent/widget/XListView:setVisibility	(I)V
    //   946: aload_0
    //   947: getfield 150	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   950: ifnull +15 -> 965
    //   953: aload_0
    //   954: getfield 150	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   957: invokeinterface 205 1 0
    //   962: ifeq +34 -> 996
    //   965: aload_0
    //   966: getfield 707	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_Boolean	Z
    //   969: ifeq -151 -> 818
    //   972: aload_0
    //   973: getfield 443	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_g_of_type_AndroidViewView	Landroid/view/View;
    //   976: iconst_0
    //   977: invokevirtual 420	android/view/View:setVisibility	(I)V
    //   980: aload_0
    //   981: getfield 583	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   984: ldc_w 708
    //   987: invokestatic 638	anvx:a	(I)Ljava/lang/String;
    //   990: invokevirtual 642	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   993: goto -175 -> 818
    //   996: aload_0
    //   997: getfield 707	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_d_of_type_Boolean	Z
    //   1000: ifeq -182 -> 818
    //   1003: aload_0
    //   1004: getfield 445	com/tencent/mobileqq/search/fragment/ActiveEntitySearchFragment:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   1007: iconst_0
    //   1008: invokevirtual 415	android/widget/TextView:setVisibility	(I)V
    //   1011: goto -193 -> 818
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1014	0	this	ActiveEntitySearchFragment
    //   0	1014	1	paramLayoutInflater	android.view.LayoutInflater
    //   0	1014	2	paramViewGroup	android.view.ViewGroup
    //   0	1014	3	paramBundle	Bundle
    //   638	163	4	d1	double
    //   641	162	6	d2	double
    //   1	876	8	localObject	Object
    //   882	15	8	localException1	java.lang.Exception
    //   161	362	9	localView1	View
    //   252	291	10	localView2	View
    //   853	16	11	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   5	227	848	finally
    //   227	275	848	finally
    //   275	285	848	finally
    //   289	397	848	finally
    //   397	407	848	finally
    //   411	485	848	finally
    //   485	518	848	finally
    //   518	630	848	finally
    //   630	637	848	finally
    //   643	681	848	finally
    //   681	767	848	finally
    //   767	818	848	finally
    //   818	831	848	finally
    //   835	845	848	finally
    //   858	876	848	finally
    //   886	904	848	finally
    //   909	965	848	finally
    //   965	993	848	finally
    //   996	1011	848	finally
    //   275	285	853	java/lang/Exception
    //   397	407	882	java/lang/Exception
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ActiveEntitySearchActivity.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a();
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    if (this.jdField_a_of_type_Ajdc != null) {
      this.jdField_a_of_type_Ajdc.c();
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "hash = " + hashCode() + "   onDestroyView mask;" + Arrays.toString(this.jdField_a_of_type_ArrayOfLong) + " key=" + this.jdField_b_of_type_JavaLangString + "  name=" + this.jdField_e_of_type_JavaLangString);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Bcbj.notifyDataSetChanged();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Bcbj == null) || (this.jdField_a_of_type_Bcbj.getCount() == 0) || (this.jdField_e_of_type_Int == 0)) {}
    while ((paramInt3 - paramInt1 - paramInt2 >= 10) || (this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {
      return;
    }
    b(this.jdField_b_of_type_JavaLangString);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString + " arend ", 4, " onScrollStateChanged" + paramInt);
    this.jdField_e_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_Bcbj == null) || (this.jdField_a_of_type_Bcbj.getCount() == 0)) {}
    while ((this.jdField_a_of_type_Bcbj == null) || (this.jdField_a_of_type_Bcbj.getCount() == 0) || (this.jdField_e_of_type_Int == 0) || (this.jdField_e_of_type_Int == 0) || (!this.jdField_c_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (a() >= 20)) {
      return;
    }
    b(this.jdField_b_of_type_JavaLangString);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new bcbt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment
 * JD-Core Version:    0.7.0.1
 */