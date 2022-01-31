package com.tencent.mobileqq.search.fragment;

import ahem;
import ahep;
import aheq;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.LocationInterface;
import com.tencent.mobileqq.search.SearchFragmentInfoInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.adapter.SubBusinessSearchAdapter;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pb.unite.search.DynamicTabSearch.SubHotWord;

public class ActiveEntitySearchFragment
  extends Fragment
  implements View.OnClickListener, SearchFragmentInfoInterface, AbsListView.OnScrollListener
{
  public static String a;
  public int a;
  private long a;
  public Bitmap a;
  protected View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  protected QQAppInterface a;
  protected UniteSearchHandler a;
  protected UniteSearchObserver a;
  public SubBusinessSearchAdapter a;
  protected FaceDecoder a;
  public XListView a;
  public List a;
  public boolean a;
  public byte[] a;
  public long[] a;
  public int b;
  public View b;
  public TextView b;
  public String b;
  public List b;
  public boolean b;
  private int jdField_c_of_type_Int;
  View jdField_c_of_type_AndroidViewView;
  public TextView c;
  public String c;
  private List jdField_c_of_type_JavaUtilList;
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
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver = new ahem(this);
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
  
  protected SubBusinessSearchAdapter a()
  {
    return new SubBusinessSearchAdapter(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this, 0);
  }
  
  public List a()
  {
    List localList = new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_Int).a(new SearchRequest(this.jdField_b_of_type_JavaLangString));
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList1 = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).a();
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
        PublicAccountSearchResultModel localPublicAccountSearchResultModel = (PublicAccountSearchResultModel)localList.get(i);
        int j = 0;
        while (j < localArrayList1.size())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localArrayList1.get(j);
          if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(localPublicAccountSearchResultModel.a.uin))) {
            localArrayList2.add(Long.valueOf(localPublicAccountInfo.uin));
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter != null))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      a(false);
      this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter.a(this.jdField_a_of_type_JavaUtilList);
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
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString + " arend ", 4, " onScrollStateChanged" + paramInt);
    this.jdField_e_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter.getCount() == 0)) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter.getCount() == 0) || (this.jdField_e_of_type_Int == 0) || (this.jdField_e_of_type_Int == 0) || (!this.jdField_c_of_type_Boolean) || (this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (a() >= 20)) {
      return;
    }
    b(this.jdField_b_of_type_JavaLangString);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter.getCount() == 0) || (this.jdField_e_of_type_Int == 0)) {}
    while ((paramInt3 - paramInt1 - paramInt2 >= 10) || (this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {
      return;
    }
    b(this.jdField_b_of_type_JavaLangString);
  }
  
  public void a(String paramString)
  {
    double d2 = 0.0D;
    for (;;)
    {
      double d1;
      try
      {
        Object localObject1 = this.jdField_a_of_type_ArrayOfByte;
        if (localObject1 != null) {
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
          if (!(getActivity() instanceof LocationInterface)) {
            break label351;
          }
          d1 = ((LocationInterface)getActivity()).a();
          d2 = ((LocationInterface)getActivity()).b();
          this.jdField_d_of_type_JavaLangString = (System.currentTimeMillis() + "");
          this.jdField_e_of_type_Boolean = true;
          localObject1 = new Bundle();
          if ((getActivity() instanceof ActiveEntitySearchActivity))
          {
            localObject2 = (ActiveEntitySearchActivity)getActivity();
            ((Bundle)localObject1).putInt("fromTypeForReport", ((ActiveEntitySearchActivity)localObject2).jdField_a_of_type_Int);
            ((Bundle)localObject1).putInt("searchAvatarFrom", ((ActiveEntitySearchActivity)localObject2).jdField_b_of_type_Int);
          }
          ((Bundle)localObject1).putBoolean("isLoadMore", false);
          ((Bundle)localObject1).putInt("fromType", this.jdField_d_of_type_Int);
          Object localObject2 = a();
          this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.a(paramString, this.jdField_d_of_type_JavaLangString, 20, SearchUtil.a(this.jdField_a_of_type_ArrayOfLong), (List)localObject2, null, this.jdField_c_of_type_Int, d1, d2, (Bundle)localObject1);
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
        label351:
        d1 = 0.0D;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public void b(String paramString)
  {
    double d2 = 0.0D;
    for (;;)
    {
      try
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        if (this.jdField_a_of_type_ArrayOfByte != null) {
          SearchUtils.a("all_result", "load_tab", new String[] { paramString, SearchUtils.a(this.jdField_b_of_type_JavaUtilList), "", SearchUtils.a("dynamic_unite_search.1", this.jdField_a_of_type_ArrayOfLong) });
        }
        if ((getActivity() instanceof LocationInterface))
        {
          d1 = ((LocationInterface)getActivity()).a();
          d2 = ((LocationInterface)getActivity()).b();
          this.jdField_d_of_type_JavaLangString = (System.currentTimeMillis() + "");
          if (QLog.isColorLevel()) {
            QLog.w(jdField_a_of_type_JavaLangString, 2, "startNewSearchTAB isEnd = true mask;" + Arrays.toString(this.jdField_a_of_type_ArrayOfLong) + " key=" + paramString + "  name=" + this.jdField_e_of_type_JavaLangString + " reqTime=" + this.jdField_d_of_type_JavaLangString);
          }
          this.jdField_e_of_type_Boolean = true;
          Bundle localBundle = new Bundle();
          localBundle.putBoolean("isLoadMore", true);
          localBundle.putInt("fromType", this.jdField_d_of_type_Int);
          List localList = a();
          this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.a(paramString, this.jdField_d_of_type_JavaLangString, 20, SearchUtil.a(this.jdField_a_of_type_ArrayOfLong), localList, this.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_Int, d1, d2, localBundle);
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
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag(2131367520);
    if ((paramView instanceof DynamicTabSearch.SubHotWord))
    {
      paramView = (DynamicTabSearch.SubHotWord)paramView;
      this.jdField_c_of_type_Int = paramView.word_id.get();
      Object localObject = getActivity();
      if ((localObject instanceof ActiveEntitySearchActivity))
      {
        localObject = (ActiveEntitySearchActivity)localObject;
        SearchUtils.a("sub_result", "clk_relate", new String[] { this.jdField_b_of_type_JavaLangString, paramView.search_word.get().toStringUtf8(), "", "" });
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
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler = ((UniteSearchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(111));
      if (localBundle == null) {
        break label176;
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
      this.jdField_a_of_type_ArrayOfLong = UniteSearchHandler.c;
    }
    this.jdField_e_of_type_JavaLangString = localBundle.getString("group_name_string");
    this.jdField_b_of_type_JavaLangString = localBundle.getString("keyword");
    label176:
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
        paramViewGroup = paramLayoutInflater.inflate(2130970629, paramViewGroup, false);
        this.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131362933);
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_f_of_type_AndroidViewView = paramViewGroup.findViewById(2131366877);
        this.jdField_g_of_type_AndroidViewView = paramViewGroup.findViewById(2131364647);
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131371439));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131371438));
        this.jdField_c_of_type_AndroidViewView = ((RelativeLayout)paramViewGroup.findViewById(2131363900));
        this.jdField_g_of_type_AndroidViewView.setVisibility(8);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        paramBundle = paramLayoutInflater.inflate(2130969703, null, false);
        this.jdField_d_of_type_AndroidViewView = paramBundle.findViewById(2131367517);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131367518));
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramBundle.findViewById(2131367519));
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
        {
          this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130838576);
          this.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#051020"));
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
          View localView1 = paramLayoutInflater.inflate(2130969704, null, false);
          this.jdField_b_of_type_AndroidViewView = localView1.findViewById(2131364963);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setPadding(0, AIOUtils.a(42.0F, getResources()), 0, AIOUtils.a(42.0F, getResources()));
          View localView2 = paramLayoutInflater.inflate(2130970374, null, false);
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView2.findViewById(2131364963));
          this.jdField_c_of_type_AndroidWidgetTextView.setText("没有更多搜索结果");
          this.jdField_c_of_type_AndroidWidgetTextView.setPadding(0, AIOUtils.a(42.0F, getResources()), 0, AIOUtils.a(42.0F, getResources()));
          this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(16.0F);
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getActivity().getResources().getColor(2131494262));
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidViewView = paramViewGroup;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
          this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramViewGroup.findViewById(2131364021));
          this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new ahep(this));
          this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(localView2);
          paramLayoutInflater = paramLayoutInflater.inflate(2130970374, null, false);
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131364963));
          this.jdField_d_of_type_AndroidWidgetTextView.setText("网络错误，请重试");
          this.jdField_d_of_type_AndroidWidgetTextView.setPadding(0, AIOUtils.a(42.0F, getResources()), 0, AIOUtils.a(42.0F, getResources()));
          this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(16.0F);
          this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(getActivity().getResources().getColor(2131494262));
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(paramLayoutInflater);
          this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter = a();
          this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter.a(false);
          if (this.jdField_a_of_type_ArrayOfLong.length == 1) {
            this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter.a(true);
          }
          this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(paramBundle);
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter);
          this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(localView1);
          this.jdField_c_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.w(jdField_a_of_type_JavaLangString, 2, "hash = " + hashCode() + "  onCreateView shouldRequestDataOnCreate=" + this.jdField_b_of_type_Boolean + "  name=" + this.jdField_e_of_type_JavaLangString + " mask=" + Arrays.toString(this.jdField_a_of_type_ArrayOfLong));
          }
          if (this.jdField_b_of_type_Boolean)
          {
            double d1 = 0.0D;
            double d2 = 0.0D;
            if ((getActivity() instanceof LocationInterface))
            {
              d1 = ((LocationInterface)getActivity()).a();
              d2 = ((LocationInterface)getActivity()).b();
            }
            this.jdField_d_of_type_JavaLangString = (System.currentTimeMillis() + "");
            this.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
            this.jdField_e_of_type_Boolean = true;
            paramLayoutInflater = new Bundle();
            if ((getActivity() instanceof ActiveEntitySearchActivity))
            {
              paramBundle = (ActiveEntitySearchActivity)getActivity();
              paramLayoutInflater.putInt("fromTypeForReport", paramBundle.jdField_a_of_type_Int);
              paramLayoutInflater.putInt("searchAvatarFrom", paramBundle.jdField_b_of_type_Int);
            }
            paramLayoutInflater.putBoolean("isLoadMore", false);
            paramLayoutInflater.putInt("fromType", this.jdField_d_of_type_Int);
            paramBundle = a();
            this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.a(this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, 20, SearchUtil.a(this.jdField_a_of_type_ArrayOfLong), paramBundle, this.jdField_a_of_type_ArrayOfByte, d1, d2, paramLayoutInflater);
            b(false);
            this.jdField_b_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
            return paramViewGroup;
          }
        }
        else
        {
          this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130838575);
          this.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#f2f2f2"));
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter.a(this.jdField_a_of_type_JavaUtilList);
      }
      finally {}
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_g_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText("没有更多搜索结果");
        }
      }
      else if (this.jdField_d_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "hash = " + hashCode() + "   onDestroyView mask;" + Arrays.toString(this.jdField_a_of_type_ArrayOfLong) + " key=" + this.jdField_b_of_type_JavaLangString + "  name=" + this.jdField_e_of_type_JavaLangString);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter.notifyDataSetChanged();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new aheq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment
 * JD-Core Version:    0.7.0.1
 */