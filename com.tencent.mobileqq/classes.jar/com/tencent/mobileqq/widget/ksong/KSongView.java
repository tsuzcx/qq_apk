package com.tencent.mobileqq.widget.ksong;

import ahiw;
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
import asbb;
import asbc;
import asbe;
import asbk;
import bcte;
import bctg;
import bcth;
import bcti;
import bctj;
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
  private bcte jdField_a_of_type_Bcte = new bcte();
  private bctg jdField_a_of_type_Bctg;
  private bcti jdField_a_of_type_Bcti;
  private KSongProsBar jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongProsBar;
  private KSongTextView jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView;
  private QwAdapter jdField_a_of_type_CooperationQwalletPluginQwAdapter;
  private List<asbe> jdField_a_of_type_JavaUtilList;
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
    Object localObject = (asbe)this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.getItem(paramInt);
    if ((localObject == null) || (((asbe)localObject).jdField_b_of_type_JavaUtilArrayList.size() <= 0))
    {
      QLog.i("KSongView", 2, "error, sentence = " + localObject);
      return 0.0F;
    }
    if (paramLong >= ((asbe)localObject).jdField_a_of_type_Long + ((asbe)localObject).jdField_b_of_type_Long)
    {
      QLog.i("KSongView", 2, "over the sentence...");
      return 1.0F;
    }
    asbb localasbb = null;
    paramInt = 0;
    for (;;)
    {
      if (paramInt < ((asbe)localObject).jdField_b_of_type_JavaUtilArrayList.size())
      {
        localasbb = (asbb)((asbe)localObject).jdField_b_of_type_JavaUtilArrayList.get(paramInt);
        if (paramLong >= localasbb.jdField_a_of_type_Long + localasbb.jdField_b_of_type_Long) {}
      }
      else
      {
        if (localasbb != null) {
          break;
        }
        QLog.i("KSongView", 2, "error, charaxter is null...");
        return 0.0F;
      }
      paramInt += 1;
    }
    localObject = (asbb)((asbe)localObject).jdField_b_of_type_JavaUtilArrayList.get(((asbe)localObject).jdField_b_of_type_JavaUtilArrayList.size() - 1);
    float f = (float)(paramLong - localasbb.jdField_a_of_type_Long) / (float)localasbb.jdField_b_of_type_Long;
    return (localasbb.jdField_a_of_type_Int + f) / ((asbb)localObject).jdField_b_of_type_Int;
  }
  
  private bcte a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.i("KSongView", 2, "error! config path wrong...");
    }
    bcte localbcte;
    do
    {
      return null;
      try
      {
        paramString = ahiw.b(paramString);
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
      localbcte = new bcte();
      localbcte.jdField_a_of_type_JavaLangString = paramString.optString("name");
      localbcte.jdField_a_of_type_JavaLangString = paramString.optString("singer");
      localbcte.jdField_a_of_type_Long = paramString.optLong("time");
      localbcte.jdField_b_of_type_JavaLangString = paramString.optString("ksongId");
      paramString = paramString.optJSONObject("qrcConfig");
    } while (paramString == null);
    localbcte.jdField_b_of_type_Long = paramString.optLong("start", 0L);
    localbcte.c = paramString.optLong("end", 0L);
    localbcte.d = paramString.optLong("pretime", 0L);
    localbcte.e = paramString.optLong("total", 0L);
    if ((0L < localbcte.jdField_b_of_type_Long) && (0L < localbcte.c) && (0L < localbcte.d) && (0L < localbcte.e))
    {
      paramString = localbcte;
      if (localbcte.jdField_b_of_type_Long < localbcte.c) {}
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
    ((LinearLayout)localObject1).setBackgroundResource(2130842859);
    ((LinearLayout)localObject1).setClickable(true);
    addView((View)localObject1, paramAttributeSet);
    paramAttributeSet = this.jdField_a_of_type_AndroidWidgetListView;
    localObject1 = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = ((List)localObject1);
    paramContext = new QwAdapter(paramContext, (List)localObject1, 2131560222, new bctj(this));
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
    paramLong = this.jdField_a_of_type_Bcte.jdField_b_of_type_Long + paramLong - this.jdField_a_of_type_Bcte.d;
    if (this.jdField_a_of_type_Bctg != null) {
      this.jdField_a_of_type_Bctg.a(paramLong);
    }
    Object localObject = (asbe)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int);
    long l = ((asbe)localObject).jdField_a_of_type_Long + ((asbe)localObject).jdField_b_of_type_Long;
    b(paramLong);
    if (paramLong > l)
    {
      if (l >= this.jdField_a_of_type_Bcte.c)
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
    Object localObject = ahiw.b(paramString);
    paramString = asbk.a((String)localObject, true);
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
        localObject = (asbe)paramString.a.get(i);
        if ((((asbe)localObject).jdField_a_of_type_Long >= this.jdField_a_of_type_Bcte.jdField_b_of_type_Long) && (((asbe)localObject).jdField_a_of_type_Long + ((asbe)localObject).jdField_b_of_type_Long <= this.jdField_a_of_type_Bcte.c)) {
          this.jdField_a_of_type_JavaUtilList.add(localObject);
        }
        if (((asbe)localObject).jdField_a_of_type_Long >= this.jdField_a_of_type_Bcte.c) {
          j = k;
        }
      }
      else
      {
        while (j < 5)
        {
          this.jdField_a_of_type_JavaUtilList.add(new asbe());
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView = ((KSongTextView)localView.findViewById(2131373428));
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
  
  public bcte a()
  {
    return this.jdField_a_of_type_Bcte;
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
    this.jdField_a_of_type_Bcti.removeMessages(0);
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
  
  public void a(String paramString1, String paramString2, KSongProsBar paramKSongProsBar, bctg parambctg)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.i("KSongView", 2, "error! need thinds is null...");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongProsBar = paramKSongProsBar;
    setKListener(parambctg);
    this.jdField_a_of_type_Bcti = new bcti(this);
    new bcth(this).execute(new String[] { paramString1, paramString2 });
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
      this.jdField_a_of_type_Bcti.sendEmptyMessage(0);
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
      this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongTextView.a(this.jdField_a_of_type_Bcte.d, null);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Bcti.sendEmptyMessage(0);
      return;
      i = getResources().getColor(2131166021);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_Bcti.removeMessages(0);
      this.c = System.currentTimeMillis();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bcti != null) {
      this.jdField_a_of_type_Bcti.removeMessages(0);
    }
    if (this.jdField_a_of_type_Int > 0) {
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void setKListener(bctg parambctg)
  {
    this.jdField_a_of_type_Bctg = parambctg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ksong.KSongView
 * JD-Core Version:    0.7.0.1
 */