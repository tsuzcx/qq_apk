package com.tencent.mobileqq.search.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.app.UnifySearchObserver;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
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
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.recommend.RecommendTroopListWrapper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tencent.im.oidb.search.DynamicTabSearch.SubHotWord;

public class ActiveEntitySearchFragment
  extends BaseFragment
  implements View.OnClickListener, SearchFragmentInfoInterface, AbsListView.OnScrollListener
{
  public static String a;
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -1L;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  protected View a;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected QQAppInterface a;
  protected UnifySearchHandler a;
  protected UnifySearchObserver a;
  protected UniteSearchHandler a;
  protected UniteSearchObserver a;
  protected IFaceDecoder a;
  protected SubBusinessSearchAdapter a;
  RecommendTroopListWrapper jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper;
  protected XListView a;
  public List<IModel> a;
  public boolean a;
  public byte[] a;
  public long[] a;
  int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  XListView jdField_b_of_type_ComTencentWidgetXListView;
  public String b;
  public List<Long> b;
  public boolean b;
  private int jdField_c_of_type_Int;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  private List<DynamicTabSearch.SubHotWord> jdField_c_of_type_JavaUtilList;
  public boolean c;
  private int jdField_d_of_type_Int;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString = "";
  protected boolean d;
  private int jdField_e_of_type_Int;
  View jdField_e_of_type_AndroidViewView;
  public String e;
  boolean jdField_e_of_type_Boolean = false;
  View jdField_f_of_type_AndroidViewView;
  private String jdField_f_of_type_JavaLangString;
  boolean jdField_f_of_type_Boolean = false;
  View jdField_g_of_type_AndroidViewView;
  private boolean jdField_g_of_type_Boolean = true;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.uniteSearch.");
    localStringBuilder.append(ActiveEntitySearchFragment.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public ActiveEntitySearchFragment()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver = new ActiveEntitySearchFragment.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver = new ActiveEntitySearchFragment.2(this);
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
    if ((paramArrayOfLong1 != null) && (paramArrayOfLong2 != null))
    {
      if (paramArrayOfLong1.length != paramArrayOfLong2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfLong1.length)
      {
        if (paramArrayOfLong1[i] != paramArrayOfLong2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  int a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  protected SubBusinessSearchAdapter a()
  {
    return new SubBusinessSearchAdapter(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this, 0);
  }
  
  public List<Long> a()
  {
    List localList1 = new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_Int).a(new SearchRequest(this.jdField_b_of_type_JavaLangString));
    if ((localList1 != null) && (localList1.size() != 0))
    {
      List localList2 = ((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).getPublicAccountList();
      ArrayList localArrayList = new ArrayList();
      int i;
      if ((localList2 != null) && (!localList2.isEmpty())) {
        i = 0;
      }
      while (i < localList1.size())
      {
        PublicAccountSearchResultModel localPublicAccountSearchResultModel = (PublicAccountSearchResultModel)localList1.get(i);
        int j = 0;
        while (j < localList2.size())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localList2.get(j);
          if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(localPublicAccountSearchResultModel.a.uin))) {
            localArrayList.add(Long.valueOf(localPublicAccountInfo.uin));
          }
          j += 1;
        }
        i += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "all publicAccountInfoList is null or empty");
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  protected void a()
  {
    if (this.jdField_d_of_type_Int == 10)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver);
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_ArrayOfByte;
        if (localObject1 != null) {
          return;
        }
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("hash = ");
          ((StringBuilder)localObject2).append(hashCode());
          ((StringBuilder)localObject2).append("   startSearchTAB isEnd = true mask;");
          ((StringBuilder)localObject2).append(Arrays.toString(this.jdField_a_of_type_ArrayOfLong));
          ((StringBuilder)localObject2).append(" key=");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append("  name=");
          ((StringBuilder)localObject2).append(this.jdField_e_of_type_JavaLangString);
          ((StringBuilder)localObject2).append(" isViewCreated");
          ((StringBuilder)localObject2).append(this.jdField_c_of_type_Boolean);
          QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_Int = 0;
        this.jdField_b_of_type_JavaLangString = paramString;
        if (this.jdField_c_of_type_Boolean)
        {
          if (!(getBaseActivity() instanceof LocationInterface)) {
            break label375;
          }
          d1 = ((LocationInterface)getBaseActivity()).a();
          d2 = ((LocationInterface)getBaseActivity()).b();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(System.currentTimeMillis());
          ((StringBuilder)localObject1).append("");
          this.jdField_d_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
          this.jdField_e_of_type_Boolean = true;
          localObject1 = new Bundle();
          if ((getBaseActivity() instanceof ActiveEntitySearchActivity))
          {
            localObject2 = (ActiveEntitySearchActivity)getBaseActivity();
            ((Bundle)localObject1).putInt("fromTypeForReport", ((ActiveEntitySearchActivity)localObject2).jdField_a_of_type_Int);
            ((Bundle)localObject1).putInt("searchAvatarFrom", ((ActiveEntitySearchActivity)localObject2).jdField_b_of_type_Int);
          }
          ((Bundle)localObject1).putBoolean("isLoadMore", false);
          ((Bundle)localObject1).putInt("fromType", this.jdField_d_of_type_Int);
          a(paramString, a(), null, d1, d2, (Bundle)localObject1);
          b(false);
        }
        else
        {
          this.jdField_b_of_type_Boolean = true;
          this.jdField_c_of_type_JavaLangString = paramString;
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "startSearch 触发延迟逻辑");
          }
        }
        return;
      }
      finally {}
      label375:
      double d2 = 0.0D;
      double d1 = d2;
    }
  }
  
  protected void a(String paramString, List<Long> paramList, byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler;
    if (localObject != null)
    {
      ((UniteSearchHandler)localObject).a(paramString, this.jdField_d_of_type_JavaLangString, 20, SearchUtil.a(this.jdField_a_of_type_ArrayOfLong), paramList, paramArrayOfByte, this.jdField_c_of_type_Int, paramDouble1, paramDouble2, paramBundle);
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler;
    if (localObject != null)
    {
      ((UnifySearchHandler)localObject).a(paramString, this.jdField_d_of_type_JavaLangString, 20, SearchUtil.a(this.jdField_a_of_type_ArrayOfLong), paramList, paramArrayOfByte, this.jdField_c_of_type_Int, paramDouble1, paramDouble2, paramBundle);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "handler null in frag");
  }
  
  public void a(List<IModel> paramList)
  {
    Object localObject = getBaseActivity();
    int j = 0;
    if (localObject != null)
    {
      localObject = getBaseActivity().getIntent();
      if (localObject != null)
      {
        i = ((Intent)localObject).getIntExtra("from_type_for_report", 0);
        break label42;
      }
    }
    int i = 0;
    label42:
    if (i == 9) {
      i = 5;
    } else if (i == 3) {
      i = 4;
    } else {
      i = 0;
    }
    if (i > 0) {
      while (j < paramList.size())
      {
        if ((paramList.get(j) instanceof GroupSearchModeTitle))
        {
          localObject = (GroupSearchModeTitle)paramList.get(j);
          if ((localObject != null) && ((((GroupSearchModeTitle)localObject).a() instanceof GroupBaseNetSearchModel)))
          {
            localObject = (GroupBaseNetSearchModel)((GroupSearchModeTitle)localObject).a();
            if ((localObject != null) && (((GroupBaseNetSearchModel)localObject).jdField_a_of_type_Long == 1002L)) {
              ((GroupBaseNetSearchModel)localObject).b(i);
            }
          }
        }
        j += 1;
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
      this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler = ((UniteSearchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER));
      this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler = ((UnifySearchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver);
  }
  
  public void b(String paramString)
  {
    for (;;)
    {
      try
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        if (this.jdField_a_of_type_ArrayOfByte != null) {
          SearchUtils.a("all_result", "load_tab", new String[] { paramString, SearchUtils.a(this.jdField_b_of_type_JavaUtilList), "", SearchUtils.a("UnifySearch.Unite", this.jdField_a_of_type_ArrayOfLong) });
        }
        if ((getBaseActivity() instanceof LocationInterface))
        {
          d1 = ((LocationInterface)getBaseActivity()).a();
          d2 = ((LocationInterface)getBaseActivity()).b();
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(System.currentTimeMillis());
          ((StringBuilder)localObject).append("");
          this.jdField_d_of_type_JavaLangString = ((StringBuilder)localObject).toString();
          if (QLog.isColorLevel())
          {
            localObject = jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("startNewSearchTAB isEnd = true mask;");
            localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfLong));
            localStringBuilder.append(" key=");
            localStringBuilder.append(paramString);
            localStringBuilder.append("  name=");
            localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
            localStringBuilder.append(" reqTime=");
            localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
            QLog.w((String)localObject, 2, localStringBuilder.toString());
          }
          this.jdField_e_of_type_Boolean = true;
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("isLoadMore", true);
          ((Bundle)localObject).putInt("fromType", this.jdField_d_of_type_Int);
          a(paramString, a(), this.jdField_a_of_type_ArrayOfByte, d1, d2, (Bundle)localObject);
          b(true);
          return;
        }
      }
      finally {}
      double d1 = 0.0D;
      double d2 = d1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramBoolean)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public boolean b()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public void c()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter != null))
    {
      localList.clear();
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
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag(2131368292);
    if ((localObject1 instanceof DynamicTabSearch.SubHotWord))
    {
      localObject1 = (DynamicTabSearch.SubHotWord)localObject1;
      this.jdField_c_of_type_Int = ((DynamicTabSearch.SubHotWord)localObject1).word_id.get();
      Object localObject2 = getBaseActivity();
      if ((localObject2 instanceof ActiveEntitySearchActivity))
      {
        localObject2 = (ActiveEntitySearchActivity)localObject2;
        SearchUtils.a("sub_result", "clk_relate", new String[] { this.jdField_b_of_type_JavaLangString, ((DynamicTabSearch.SubHotWord)localObject1).search_word.get().toStringUtf8(), "", "" });
        ((ActiveEntitySearchActivity)localObject2).a((DynamicTabSearch.SubHotWord)localObject1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    Object localObject = getBaseActivity();
    if ((localObject instanceof UniteSearchActivity)) {
      this.jdField_f_of_type_Boolean = true;
    }
    if ((localObject instanceof BaseActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((BaseActivity)localObject).app;
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localBundle != null)
      {
        this.jdField_d_of_type_Int = localBundle.getInt("fromType", -1);
        this.jdField_a_of_type_ArrayOfLong = localBundle.getLongArray("group_mask_long_array");
        localObject = this.jdField_a_of_type_ArrayOfLong;
        if (localObject != null)
        {
          if ((localObject.length == 1) && (localObject[0] == 0L)) {
            if (this.jdField_d_of_type_Int == 10) {
              this.jdField_a_of_type_ArrayOfLong = UniteSearchHandler.c;
            } else {
              this.jdField_a_of_type_ArrayOfLong = UnifySearchHandler.c;
            }
          }
          this.jdField_e_of_type_JavaLangString = localBundle.getString("group_name_string");
          this.jdField_b_of_type_JavaLangString = localBundle.getString("keyword");
        }
        else
        {
          throw new RuntimeException("mask array can not be null in ActiveEntitySearchFragment.");
        }
      }
      b();
      super.onCreate(paramBundle);
      return;
    }
    throw new IllegalStateException("Activity must be instance of BaseActivity");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView1;
    View localView2;
    double d1;
    try
    {
      super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      paramBundle = paramLayoutInflater.inflate(2131561572, paramViewGroup, false);
      this.jdField_e_of_type_AndroidViewView = paramBundle.findViewById(2131370396);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView = paramBundle.findViewById(2131366306);
      this.jdField_g_of_type_AndroidViewView = paramBundle.findViewById(2131366460);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131366462));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramBundle.findViewById(2131366461));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramBundle.findViewById(2131374737));
      this.jdField_c_of_type_AndroidViewView = ((RelativeLayout)paramBundle.findViewById(2131376483));
      this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)paramBundle.findViewById(2131370517));
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      localView1 = paramLayoutInflater.inflate(2131560450, null, false);
      this.jdField_d_of_type_AndroidViewView = localView1.findViewById(2131373662);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131368293));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView1.findViewById(2131368296));
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130839385);
      } else {
        this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130839384);
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      localView2 = paramLayoutInflater.inflate(2131560451, null, false);
      this.jdField_b_of_type_AndroidViewView = localView2.findViewById(2131367119);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      try
      {
        paramViewGroup = paramLayoutInflater.inflate(2131561171, null, false);
      }
      catch (Exception paramViewGroup)
      {
        if (!QLog.isColorLevel()) {
          break label1032;
        }
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, QLog.getStackTraceString(paramViewGroup));
    }
    finally {}
    if (paramViewGroup != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131367119));
      this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131699993));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(16.0F);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getBaseActivity().getResources().getColor(2131167144));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView = paramBundle;
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)paramBundle.findViewById(2131370110));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new ActiveEntitySearchFragment.3(this));
      this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(paramViewGroup);
    }
    try
    {
      paramLayoutInflater = paramLayoutInflater.inflate(2131561171, null, false);
    }
    catch (Exception localException)
    {
      paramLayoutInflater = paramViewGroup;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, QLog.getStackTraceString(localException));
        paramLayoutInflater = paramViewGroup;
      }
    }
    if (paramLayoutInflater != null)
    {
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131367119));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700000));
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(16.0F);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(getBaseActivity().getResources().getColor(2131167144));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(paramLayoutInflater);
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter = a();
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter.a(false);
    if (this.jdField_a_of_type_ArrayOfLong.length == 1) {
      this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter.a(true);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView1);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(localView2);
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel())
    {
      paramLayoutInflater = jdField_a_of_type_JavaLangString;
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("hash = ");
      paramViewGroup.append(hashCode());
      paramViewGroup.append("  onCreateView shouldRequestDataOnCreate=");
      paramViewGroup.append(this.jdField_b_of_type_Boolean);
      paramViewGroup.append("  name=");
      paramViewGroup.append(this.jdField_e_of_type_JavaLangString);
      paramViewGroup.append(" mask=");
      paramViewGroup.append(Arrays.toString(this.jdField_a_of_type_ArrayOfLong));
      QLog.w(paramLayoutInflater, 2, paramViewGroup.toString());
    }
    double d2;
    if (this.jdField_b_of_type_Boolean)
    {
      if (!(getBaseActivity() instanceof LocationInterface)) {
        break label1037;
      }
      d1 = ((LocationInterface)getBaseActivity()).a();
      d2 = ((LocationInterface)getBaseActivity()).b();
    }
    for (;;)
    {
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append(System.currentTimeMillis());
      paramLayoutInflater.append("");
      this.jdField_d_of_type_JavaLangString = paramLayoutInflater.toString();
      this.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      this.jdField_e_of_type_Boolean = true;
      paramLayoutInflater = new Bundle();
      if ((getBaseActivity() instanceof ActiveEntitySearchActivity))
      {
        paramViewGroup = (ActiveEntitySearchActivity)getBaseActivity();
        paramLayoutInflater.putInt("fromTypeForReport", paramViewGroup.jdField_a_of_type_Int);
        paramLayoutInflater.putInt("searchAvatarFrom", paramViewGroup.jdField_b_of_type_Int);
      }
      paramLayoutInflater.putBoolean("isLoadMore", false);
      paramLayoutInflater.putInt("fromType", this.jdField_d_of_type_Int);
      paramViewGroup = a();
      a(this.jdField_b_of_type_JavaLangString, paramViewGroup, this.jdField_a_of_type_ArrayOfByte, d1, d2, paramLayoutInflater);
      b(false);
      this.jdField_b_of_type_Boolean = false;
      break label1010;
      this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        if (this.jdField_d_of_type_Boolean) {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
      else if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_g_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700003));
      }
      label1010:
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
      AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramBundle);
      return paramBundle;
      label1032:
      paramViewGroup = null;
      break;
      label1037:
      d1 = 0.0D;
      d2 = d1;
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ActiveEntitySearchActivity.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a();
    this.jdField_e_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopRecommendRecommendTroopListWrapper;
    if (localObject != null) {
      ((RecommendTroopListWrapper)localObject).c();
    }
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hash = ");
      localStringBuilder.append(hashCode());
      localStringBuilder.append("   onDestroyView mask;");
      localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfLong));
      localStringBuilder.append(" key=");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("  name=");
      localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter.notifyDataSetChanged();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter;
    if ((paramAbsListView != null) && (paramAbsListView.getCount() != 0))
    {
      if (this.jdField_e_of_type_Int == 0) {
        return;
      }
      if ((paramInt3 - paramInt1 - paramInt2 < 10) && (!this.jdField_e_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
        b(this.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    paramAbsListView = new StringBuilder();
    paramAbsListView.append(jdField_a_of_type_JavaLangString);
    paramAbsListView.append(" arend ");
    paramAbsListView = paramAbsListView.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" onScrollStateChanged");
    localStringBuilder.append(paramInt);
    QLog.d(paramAbsListView, 4, localStringBuilder.toString());
    this.jdField_e_of_type_Int = paramInt;
    paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter;
    if (paramAbsListView != null)
    {
      if (paramAbsListView.getCount() == 0) {
        return;
      }
      paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter;
      if ((paramAbsListView != null) && (paramAbsListView.getCount() != 0))
      {
        paramInt = this.jdField_e_of_type_Int;
        if (paramInt == 0) {
          return;
        }
        if ((paramInt != 0) && (this.jdField_c_of_type_Boolean) && (!this.jdField_e_of_type_Boolean) && (!this.jdField_d_of_type_Boolean) && (a() < 20)) {
          b(this.jdField_b_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new ActiveEntitySearchFragment.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment
 * JD-Core Version:    0.7.0.1
 */