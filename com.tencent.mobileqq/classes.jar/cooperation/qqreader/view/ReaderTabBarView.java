package cooperation.qqreader.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bhjm;
import bktr;
import bkul;
import bkum;
import bkvb;
import bkvd;
import bkvg;
import bkvh;
import bkvi;
import bkvk;
import bkvl;
import bkvm;
import bkvn;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchUI;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil.NetInfo;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReaderTabBarView
  extends LinearLayout
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e5e5e5"));
  private SparseArray<bkvk> jdField_a_of_type_AndroidUtilSparseArray;
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  public bhjm a;
  private bkum jdField_a_of_type_Bkum;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Integer, bkvm> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<WebViewTabBarData> jdField_a_of_type_JavaUtilList;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int = 1;
  private SparseArray<ArrayList<String>> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  private int jdField_c_of_type_Int;
  private String[] jdField_c_of_type_ArrayOfJavaLangString;
  private int d;
  private int e;
  private int f;
  private int g = -1;
  
  public ReaderTabBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReaderTabBarView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReaderTabBarView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(paramContext, 54.0F));
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.weight = 1.0F;
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.gravity = 17;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private void a(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return;
    case 1: 
      setRedIconShow(1, false);
      a("769.100900");
      return;
    case 0: 
      setRedIconShow(0, false);
      a("769.100920");
      return;
    case 3: 
      setRedIconShow(3, false);
      a("769.100916");
      return;
    case 2: 
      setRedIconShow(2, false);
      a("769.100970");
      return;
    case 6: 
      setRedIconShow(6, false);
      a("769.100980");
      return;
    }
    setRedIconShow(4, false);
    a("769.100990");
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    Object localObject = (bkvk)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    if ((localObject == null) || (((bkvk)localObject).jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt1)))) {
      return;
    }
    localObject = (RedTouchUI)new RedTouchUI(this.jdField_a_of_type_AndroidContentContext, ((bkvk)localObject).jdField_a_of_type_AndroidViewView).a(5).a();
    ((RedTouchUI)localObject).setRedpointImgResID(2130850321);
    ((RedTouchUI)localObject).setTextOrNumImgRedID(2130850325);
    paramString = new bkvm(this, paramInt2, paramString, paramBoolean, paramInt3, (RedTouchUI)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), paramString);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
    int i = 0;
    while (i < j)
    {
      bkvk localbkvk = (bkvk)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localbkvk != null)
      {
        localbkvk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localbkvk.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        localbkvk.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.d);
        if (paramInt2 == localbkvk.jdField_a_of_type_Int)
        {
          localbkvk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localbkvk.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
          localbkvk.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.e);
        }
      }
      i += 1;
    }
    if (paramBoolean) {
      b(paramInt1, paramInt2);
    }
    bkvd.e("ReaderTabBarView", "mSelectedTab =" + paramInt1 + ",tabIndex=" + paramInt2 + ",isHumanClick=" + paramBoolean);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    a(paramInt1, 2, paramString, paramInt2, true);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, 1, "", 0, paramBoolean);
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_Bkum != null) {
      this.jdField_a_of_type_Bkum.a(paramString);
    }
  }
  
  private void a(Map<String, RedAppInfo> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    if (this.jdField_a_of_type_Bkum.a("769.100900")) {
      setRedIconShow(1, true);
    }
    if (this.jdField_a_of_type_Bkum.a("769.100920")) {
      setRedIconShow(0, true);
    }
    if (this.jdField_a_of_type_Bkum.a("769.100916")) {
      setRedIconShow(3, true);
    }
    if (this.jdField_a_of_type_Bkum.a("769.100970")) {
      setRedIconShow(2, true);
    }
    if (this.jdField_a_of_type_Bkum.a("769.100980")) {
      setRedIconShow(6, true);
    }
    if (this.jdField_a_of_type_Bkum.a("769.100990")) {
      setRedIconShow(4, true);
    }
    a(this.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int]);
  }
  
  private View[] a(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt > getChildCount())) {
      throw new IllegalArgumentException("position is not legal, please check!");
    }
    TabItemView localTabItemView = new TabItemView(getContext());
    localTabItemView.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    localTabItemView.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramString);
    localTabItemView.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    bkvn localbkvn = new bkvn(null);
    localbkvn.jdField_a_of_type_AndroidWidgetTextView = localTabItemView.jdField_a_of_type_AndroidWidgetTextView;
    localbkvn.jdField_a_of_type_AndroidWidgetImageView = localTabItemView.jdField_a_of_type_AndroidWidgetImageView;
    localTabItemView.setTag(-3, localbkvn);
    localTabItemView.setBackgroundDrawable(null);
    localTabItemView.setOnClickListener(new bkvl(this, paramInt, this.jdField_a_of_type_JavaUtilList));
    addView(localTabItemView, paramInt, this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
    if (AppSetting.c) {
      localTabItemView.setContentDescription(paramString);
    }
    return new View[] { localTabItemView, localTabItemView.jdField_a_of_type_AndroidWidgetImageView, localTabItemView.jdField_a_of_type_AndroidWidgetTextView };
  }
  
  private View[] a(String paramString)
  {
    return a(getChildCount(), paramString);
  }
  
  private void b(int paramInt)
  {
    a(paramInt);
    bkvh.a(this.jdField_a_of_type_AndroidContentContext, paramInt, false);
    a(bkvh.a(this.jdField_a_of_type_AndroidContentContext, paramInt), paramInt, a(paramInt), false, new Object[] { bkvh.a(this.jdField_a_of_type_AndroidContentContext, paramInt) });
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ArrayOfJavaLangString == null) || (this.jdField_b_of_type_ArrayOfJavaLangString == null)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("EVENT_REPORT_TAB_SWITCH_KEY_CUR_TAB_INDEX", paramInt1);
    localBundle.putInt("EVENT_REPORT_TAB_SWITCH_KEY_CLICK_TAB_INDEX", paramInt2);
    localBundle.putStringArray("EVENT_REPORT_TAB_SWITCH_KEY_PAGE_IDS", this.jdField_a_of_type_ArrayOfJavaLangString);
    localBundle.putStringArray("EVENT_REPORT_TAB_SWITCH_KEY_MODULE_IDS", this.jdField_b_of_type_ArrayOfJavaLangString);
    bkul.a().a("EVENT_REPORT_TAB_SWITCH", localBundle);
  }
  
  private void b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    bkvm localbkvm = (bkvm)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localbkvm == null)
    {
      a(paramInt1, paramBoolean);
      localbkvm = (bkvm)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    }
    for (;;)
    {
      if (localbkvm != null) {
        localbkvm.a(paramInt1, paramBoolean);
      }
      do
      {
        return;
      } while (paramInt2 < localbkvm.jdField_b_of_type_Int);
      localbkvm.jdField_b_of_type_Int = paramInt2;
      localbkvm.jdField_a_of_type_Int = 1;
    }
  }
  
  private void d()
  {
    int i = 0;
    while (i <= 3)
    {
      if (bkvh.a(this.jdField_a_of_type_AndroidContentContext, i))
      {
        setTextMsg(i, bkvh.a(this.jdField_a_of_type_AndroidContentContext, i), a(i) + 1, true);
        bkvg.a(b(), a(), "69", "335", "", "2", "", "", "");
      }
      i += 1;
    }
  }
  
  public int a(int paramInt)
  {
    bkvm localbkvm = (bkvm)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localbkvm == null) {
      return 0;
    }
    return localbkvm.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    return bkvi.a((Activity)this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a()
  {
    ((QQBrowserActivity)this.jdField_a_of_type_AndroidContentContext).a().getIntent().putExtra("key_current_tab_item_id", this.jdField_b_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, 3, String.valueOf(paramInt2), 0, false);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, Object... paramVarArgs)
  {
    if (paramInt1 == 1) {
      setRedIconShow(paramInt2, paramBoolean);
    }
    do
    {
      return;
      if (paramInt1 == 2)
      {
        setTextMsg(paramInt2, (String)paramVarArgs[0], paramInt3, paramBoolean);
        return;
      }
    } while (paramInt1 != 3);
    setUnReadMsg(paramInt2, Integer.parseInt((String)paramVarArgs[0]));
  }
  
  public void a(Intent paramIntent, @NonNull List<WebViewTabBarData> paramList, bhjm parambhjm)
  {
    this.jdField_a_of_type_Bhjm = parambhjm;
    parambhjm = null;
    if ((getContext() instanceof ReaderHomePageActivity)) {
      parambhjm = ((ReaderHomePageActivity)getContext()).a();
    }
    Object localObject = parambhjm;
    if (parambhjm == null)
    {
      bkvd.a("ReaderTabBarView", "[init] configDataHelper is null!");
      localObject = new bktr((Activity)getContext());
    }
    this.jdField_a_of_type_ArrayOfInt = ((bktr)localObject).a();
    this.jdField_a_of_type_ArrayOfJavaLangString = ((bktr)localObject).b();
    this.jdField_b_of_type_ArrayOfJavaLangString = ((bktr)localObject).c();
    this.jdField_c_of_type_ArrayOfJavaLangString = ((bktr)localObject).a();
    int j = bktr.jdField_a_of_type_Int;
    this.d = bktr.jdField_b_of_type_Int;
    this.e = bktr.jdField_c_of_type_Int;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("key_tab_main_tab_pos", 0);
      bkvd.d("ReaderTabBarView", " targetTabPos=" + i);
      paramIntent.removeExtra("key_tab_main_tab_pos");
      j = paramIntent.getIntExtra("key_tab_color", bktr.jdField_a_of_type_Int);
      paramIntent.removeExtra("key_tab_color");
      this.d = paramIntent.getIntExtra("key_tab_name_color", bktr.jdField_b_of_type_Int);
      paramIntent.removeExtra("key_tab_name_color");
      this.e = paramIntent.getIntExtra("key_name_selected_color", bktr.jdField_c_of_type_Int);
      paramIntent.removeExtra("key_tab_name_color");
      setBackgroundDrawable(new ColorDrawable(j));
      this.jdField_a_of_type_JavaUtilList = paramList;
      int m = paramList.size();
      bkvd.e("ReaderTabBarView", "[init] dataList size = " + m);
      j = 0;
      label277:
      if (j >= m) {
        break label495;
      }
      paramIntent = new bkvk();
      paramIntent.jdField_a_of_type_Int = this.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_ArrayOfInt != null) {
        break label481;
      }
    }
    label481:
    for (int k = bktr.a(Integer.parseInt(((WebViewTabBarData)paramList.get(j)).tag));; k = this.jdField_a_of_type_ArrayOfInt[this.jdField_c_of_type_Int])
    {
      paramIntent.jdField_b_of_type_Int = k;
      paramIntent.jdField_a_of_type_JavaLangString = ((WebViewTabBarData)paramList.get(j)).tabName;
      parambhjm = a(((WebViewTabBarData)paramList.get(j)).tabName);
      paramIntent.jdField_a_of_type_AndroidViewView = parambhjm[0];
      paramIntent.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)parambhjm[1]);
      paramIntent.jdField_a_of_type_AndroidWidgetTextView = ((TextView)parambhjm[2]);
      paramIntent.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bkvi.a(((WebViewTabBarData)paramList.get(j)).tabIcon);
      paramIntent.jdField_b_of_type_AndroidGraphicsDrawableDrawable = bkvi.a(this.jdField_c_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramIntent.jdField_b_of_type_Int, paramIntent);
      this.jdField_c_of_type_Int += 1;
      j += 1;
      break label277;
      bkvd.a("ReaderTabBarView", "[init] intent is null!");
      i = 0;
      break;
    }
    label495:
    this.f = i;
    a(this.g, this.f, true);
    this.jdField_a_of_type_Int = this.f;
    this.g = this.jdField_a_of_type_Int;
    int i = bkvb.c(this.jdField_a_of_type_AndroidContentContext);
    if (i > 0)
    {
      a(0, i);
      bkvg.a(b(), a(), "69", "335", "", "2", "", "", "");
    }
    d();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == -1) {}
    while (this.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int] != 0) {
      return false;
    }
    return true;
  }
  
  public boolean a(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      return false;
    }
    return ((bkvm)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return DeviceInfoUtil.getNetInfo(this.jdField_a_of_type_AndroidContentContext).networkType;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList.add("769.100900");
    this.jdField_a_of_type_JavaUtilArrayList.add("769.100920");
    this.jdField_a_of_type_JavaUtilArrayList.add("769.100916");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("769.100900.100901");
    localArrayList.add("769.100900.100902");
    localArrayList.add("769.100900.100903");
    localArrayList.add("769.100900.100904");
    localArrayList.add("769.100900.100905");
    localArrayList.add("769.100900.100906");
    localArrayList.add("769.100900.100907");
    localArrayList.add("769.100900.100908");
    localArrayList.add("769.100900.100909");
    localArrayList.add("769.100900.100910");
    localArrayList.add("769.100900.100911");
    this.jdField_b_of_type_AndroidUtilSparseArray.put(1, localArrayList);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add("769.100920.100921");
    this.jdField_b_of_type_AndroidUtilSparseArray.put(0, localArrayList);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add("769.100970");
    this.jdField_b_of_type_AndroidUtilSparseArray.put(2, localArrayList);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add("769.100980");
    this.jdField_b_of_type_AndroidUtilSparseArray.put(6, localArrayList);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add("769.100990");
    this.jdField_b_of_type_AndroidUtilSparseArray.put(4, localArrayList);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
  }
  
  public boolean b()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Int == -1) {
      return false;
    }
    if (this.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int] == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void c()
  {
    ThreadManager.postImmediately(new ReaderTabBarView.1(this), null, false);
  }
  
  public void setCurrentItemId(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setRedIconShow(int paramInt, boolean paramBoolean)
  {
    b(paramInt, 0, paramBoolean);
  }
  
  public void setSelectedTab(int paramInt)
  {
    setSelectedTab(paramInt, true);
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    int j = getChildCount();
    paramInt = i;
    if (i >= j) {
      paramInt = j - 1;
    }
    if (this.jdField_a_of_type_Int != paramInt)
    {
      if (this.jdField_a_of_type_Bhjm != null) {
        this.jdField_a_of_type_Bhjm.onTabSelected(this.jdField_a_of_type_Int, paramInt);
      }
      a(this.jdField_a_of_type_Int, paramInt, paramBoolean);
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void setTextMsg(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    bkvm localbkvm = (bkvm)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localbkvm == null) {
      a(paramInt1, paramString, paramInt2);
    }
    for (paramString = (bkvm)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));; paramString = localbkvm)
    {
      if (paramString != null) {
        paramString.a(paramInt1, paramBoolean);
      }
      do
      {
        return;
      } while (paramInt2 < localbkvm.jdField_b_of_type_Int);
      localbkvm.jdField_b_of_type_Int = paramInt2;
      localbkvm.jdField_a_of_type_Int = 2;
      localbkvm.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public void setUnReadMsg(int paramInt1, int paramInt2)
  {
    setUnReadMsg(paramInt1, paramInt2, 0);
  }
  
  public void setUnReadMsg(int paramInt1, int paramInt2, int paramInt3)
  {
    bkvm localbkvm = (bkvm)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (localbkvm == null)
    {
      a(paramInt1, paramInt2);
      localbkvm = (bkvm)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    }
    for (;;)
    {
      if (localbkvm != null) {
        localbkvm.a(paramInt1, true);
      }
      do
      {
        return;
      } while (paramInt3 < localbkvm.jdField_b_of_type_Int);
      localbkvm.jdField_b_of_type_Int = paramInt3;
      localbkvm.jdField_a_of_type_Int = 3;
      localbkvm.jdField_a_of_type_JavaLangString = String.valueOf(paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.view.ReaderTabBarView
 * JD-Core Version:    0.7.0.1
 */