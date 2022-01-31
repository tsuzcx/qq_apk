package com.tencent.mobileqq.widget.ksong;

import ahiy;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import asaz;
import asba;
import asbc;
import asbi;
import bcsp;
import bcsr;
import bcss;
import bcst;
import bcsu;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class KSongView
  extends FrameLayout
{
  private int jdField_a_of_type_Int = -1;
  public long a;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private bcsp jdField_a_of_type_Bcsp = new bcsp();
  private bcsr jdField_a_of_type_Bcsr;
  private bcst jdField_a_of_type_Bcst;
  private KSongProsBar jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongProsBar;
  private KSongTextView jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView;
  private QwAdapter jdField_a_of_type_CooperationQwalletPluginQwAdapter;
  private List<asbc> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private KSongTextView jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongTextView;
  private long c;
  
  public KSongView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public KSongView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @SuppressLint({"NewApi"})
  public KSongView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private float a(int paramInt, long paramLong)
  {
    Object localObject = (asbc)this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.getItem(paramInt);
    if ((localObject == null) || (((asbc)localObject).jdField_b_of_type_JavaUtilArrayList.size() <= 0))
    {
      QLog.i("KSongView", 2, "error, sentence = " + localObject);
      return 0.0F;
    }
    if (paramLong >= ((asbc)localObject).jdField_a_of_type_Long + ((asbc)localObject).jdField_b_of_type_Long)
    {
      QLog.i("KSongView", 2, "over the sentence...");
      return 1.0F;
    }
    asaz localasaz = null;
    paramInt = 0;
    for (;;)
    {
      if (paramInt < ((asbc)localObject).jdField_b_of_type_JavaUtilArrayList.size())
      {
        localasaz = (asaz)((asbc)localObject).jdField_b_of_type_JavaUtilArrayList.get(paramInt);
        if (paramLong >= localasaz.jdField_a_of_type_Long + localasaz.jdField_b_of_type_Long) {}
      }
      else
      {
        if (localasaz != null) {
          break;
        }
        QLog.i("KSongView", 2, "error, charaxter is null...");
        return 0.0F;
      }
      paramInt += 1;
    }
    localObject = (asaz)((asbc)localObject).jdField_b_of_type_JavaUtilArrayList.get(((asbc)localObject).jdField_b_of_type_JavaUtilArrayList.size() - 1);
    float f = (float)(paramLong - localasaz.jdField_a_of_type_Long) / (float)localasaz.jdField_b_of_type_Long;
    return (localasaz.jdField_a_of_type_Int + f) / ((asaz)localObject).jdField_b_of_type_Int;
  }
  
  private bcsp a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.i("KSongView", 2, "error! config path wrong...");
    }
    bcsp localbcsp;
    do
    {
      return null;
      try
      {
        paramString = ahiy.b(paramString);
        QLog.i("KSongView", 2, "config_content = " + paramString);
        if (TextUtils.isEmpty(paramString))
        {
          QLog.i("KSongView", 2, "error! config content wrong...");
          return null;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      paramString = new JSONObject(paramString);
      localbcsp = new bcsp();
      localbcsp.jdField_a_of_type_JavaLangString = paramString.optString("name");
      localbcsp.jdField_a_of_type_JavaLangString = paramString.optString("singer");
      localbcsp.jdField_a_of_type_Long = paramString.optLong("time");
      localbcsp.jdField_b_of_type_JavaLangString = paramString.optString("ksongId");
      paramString = paramString.optJSONObject("qrcConfig");
    } while (paramString == null);
    localbcsp.jdField_b_of_type_Long = paramString.optLong("start", 0L);
    localbcsp.c = paramString.optLong("end", 0L);
    localbcsp.d = paramString.optLong("pretime", 0L);
    localbcsp.e = paramString.optLong("total", 0L);
    if ((0L < localbcsp.jdField_b_of_type_Long) && (0L < localbcsp.c) && (0L < localbcsp.d) && (0L < localbcsp.e))
    {
      paramString = localbcsp;
      if (localbcsp.jdField_b_of_type_Long < localbcsp.c) {}
    }
    else
    {
      QLog.i("KSongView", 2, "error! config is wrong...");
      paramString = null;
    }
    return paramString;
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -1);
    Object localObject1 = new LinearLayout.LayoutParams(-1, -1);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongTextView = new KSongTextView(paramContext);
    this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongTextView.setText("● ● ● ● ●");
    this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongTextView.setTextSize(2, 15.0F);
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).gravity = 1;
    this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongTextView.setVisibility(4);
    localLinearLayout.addView(this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongTextView, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ListView(paramContext);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)localObject2);
    localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetListView.setVerticalScrollBarEnabled(false);
    addView(localLinearLayout, paramAttributeSet);
    localObject1 = new LinearLayout(paramContext);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setBackgroundResource(2130842858);
    ((LinearLayout)localObject1).setClickable(true);
    addView((View)localObject1, paramAttributeSet);
    paramAttributeSet = this.jdField_a_of_type_AndroidWidgetListView;
    localObject1 = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = ((List)localObject1);
    paramContext = new QwAdapter(paramContext, (List)localObject1, 2131560222, new bcsu(this));
    this.jdField_a_of_type_CooperationQwalletPluginQwAdapter = paramContext;
    paramAttributeSet.setAdapter(paramContext);
  }
  
  private boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Int != 1) {
      return false;
    }
    if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())
    {
      QLog.i("KSongView", 2, "error, out of scrop...");
      return false;
    }
    paramLong = this.jdField_a_of_type_Bcsp.jdField_b_of_type_Long + paramLong - this.jdField_a_of_type_Bcsp.d;
    if (this.jdField_a_of_type_Bcsr != null) {
      this.jdField_a_of_type_Bcsr.a(paramLong);
    }
    Object localObject = (asbc)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int);
    long l = ((asbc)localObject).jdField_a_of_type_Long + ((asbc)localObject).jdField_b_of_type_Long;
    b(paramLong);
    if (paramLong > l)
    {
      if (l >= this.jdField_a_of_type_Bcsp.c)
      {
        QLog.i("KSongView", 2, "play over, no scroll...");
        return false;
      }
      QLog.i("KSongView", 2, "scroll to next line = " + this.jdField_b_of_type_Int + " duration = " + paramLong);
      localObject = this.jdField_a_of_type_AndroidWidgetListView;
      int i = this.jdField_b_of_type_Int + 1;
      this.jdField_b_of_type_Int = i;
      ((ListView)localObject).smoothScrollToPositionFromTop(i, -1, 50);
    }
    return true;
  }
  
  private boolean a(String paramString)
  {
    int k = 0;
    Object localObject = ahiy.b(paramString);
    paramString = asbi.a((String)localObject, true);
    if ((paramString == null) || (paramString.a == null))
    {
      QLog.i("KSongView", 2, "error, parse Qrc fail, qrc = " + (String)localObject);
      return false;
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < paramString.a.size())
      {
        localObject = (asbc)paramString.a.get(i);
        if ((((asbc)localObject).jdField_a_of_type_Long >= this.jdField_a_of_type_Bcsp.jdField_b_of_type_Long) && (((asbc)localObject).jdField_a_of_type_Long + ((asbc)localObject).jdField_b_of_type_Long <= this.jdField_a_of_type_Bcsp.c)) {
          this.jdField_a_of_type_JavaUtilList.add(localObject);
        }
        if (((asbc)localObject).jdField_a_of_type_Long >= this.jdField_a_of_type_Bcsp.c) {
          j = k;
        }
      }
      else
      {
        while (j < 5)
        {
          this.jdField_a_of_type_JavaUtilList.add(new asbc());
          j += 1;
        }
      }
      i += 1;
    }
    QLog.i("KSongView", 2, "list size = " + this.jdField_a_of_type_JavaUtilList.size());
    return true;
  }
  
  private void b(long paramLong)
  {
    View localView = this.jdField_a_of_type_AndroidWidgetListView.getChildAt(0);
    if (localView == null) {
      QLog.i("KSongView", 2, "update sentence v is null...");
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView = ((KSongTextView)localView.findViewById(2131373426));
      QLog.i("KSongView", 2, "index line = " + this.jdField_b_of_type_Int);
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView == null);
    float f = a(this.jdField_b_of_type_Int, paramLong);
    QLog.i("KSongView", 2, "show text color rate = " + f);
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView.a(f, 15, -1);
  }
  
  public int a()
  {
    try
    {
      int i = this.jdField_a_of_type_Int;
      return i;
    }
    finally {}
  }
  
  public bcsp a()
  {
    return this.jdField_a_of_type_Bcsp;
  }
  
  public void a()
  {
    QLog.i("KSongView", 2, "start reset...");
    this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.notifyDataSetChanged();
    ListView localListView = this.jdField_a_of_type_AndroidWidgetListView;
    this.jdField_b_of_type_Int = 0;
    localListView.setSelection(0);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongProsBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongProsBar.a(0L);
    }
    this.jdField_a_of_type_Bcst.removeMessages(0);
    if (this.jdField_a_of_type_Int > 0) {
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongProsBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongProsBar.a(paramLong);
    }
  }
  
  public void a(String paramString1, String paramString2, KSongProsBar paramKSongProsBar, bcsr parambcsr)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.i("KSongView", 2, "error! need thinds is null...");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongProsBar = paramKSongProsBar;
    setKListener(parambcsr);
    this.jdField_a_of_type_Bcst = new bcst(this);
    new bcss(this).execute(new String[] { paramString1, paramString2 });
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    try
    {
      if (this.jdField_a_of_type_Int < 0) {
        throw new RuntimeException("error! lyric object not initialized...");
      }
    }
    finally {}
    if (this.jdField_a_of_type_Int == 1)
    {
      QLog.i("KSongView", 2, "error, the playing is going...");
      return;
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Bcst.sendEmptyMessage(0);
      this.jdField_b_of_type_Long += System.currentTimeMillis() - this.c;
      return;
    }
    QLog.i("KSongView", 2, "start playing...");
    if (this.jdField_a_of_type_Int == 3) {
      a();
    }
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Long = 0L;
    KSongTextView localKSongTextView = this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongTextView;
    if (paramBoolean) {}
    for (;;)
    {
      localKSongTextView.a(i, 0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongTextView.a(this.jdField_a_of_type_Bcsp.d, null);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Bcst.sendEmptyMessage(0);
      return;
      i = getResources().getColor(2131166021);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_Bcst.removeMessages(0);
      this.c = System.currentTimeMillis();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bcst != null) {
      this.jdField_a_of_type_Bcst.removeMessages(0);
    }
    if (this.jdField_a_of_type_Int > 0) {
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void setKListener(bcsr parambcsr)
  {
    this.jdField_a_of_type_Bcsr = parambcsr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ksong.KSongView
 * JD-Core Version:    0.7.0.1
 */