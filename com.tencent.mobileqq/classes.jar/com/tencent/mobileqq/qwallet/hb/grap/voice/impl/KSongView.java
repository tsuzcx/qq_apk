package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

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
import com.tencent.mobileqq.lyric.data.Character;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.data.Sentence;
import com.tencent.mobileqq.lyric.util.LyricParseHelper;
import com.tencent.mobileqq.qqpay.ui.R.color;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
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
  private KSHelper.Config jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$Config = new KSHelper.Config();
  private KSHelper.KListener jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$KListener;
  private KSongProsBar jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongProsBar;
  private KSongTextView jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongTextView = null;
  private KSongView.KHandler jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView$KHandler;
  private QwAdapter jdField_a_of_type_CooperationQwalletPluginQwAdapter;
  private List<Sentence> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  private KSongTextView jdField_b_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongTextView;
  private long c = 0L;
  
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
    Object localObject2 = (Sentence)this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.getItem(paramInt);
    if ((localObject2 != null) && (((Sentence)localObject2).jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      if (paramLong >= ((Sentence)localObject2).jdField_a_of_type_Long + ((Sentence)localObject2).jdField_b_of_type_Long)
      {
        QLog.i("KSongView", 2, "over the sentence...");
        return 1.0F;
      }
      localObject1 = null;
      paramInt = 0;
      while (paramInt < ((Sentence)localObject2).jdField_b_of_type_JavaUtilArrayList.size())
      {
        localObject1 = (Character)((Sentence)localObject2).jdField_b_of_type_JavaUtilArrayList.get(paramInt);
        if (paramLong < ((Character)localObject1).jdField_a_of_type_Long + ((Character)localObject1).jdField_b_of_type_Long) {
          break;
        }
        paramInt += 1;
      }
      if (localObject1 == null)
      {
        QLog.i("KSongView", 2, "error, charaxter is null...");
        return 0.0F;
      }
      localObject2 = (Character)((Sentence)localObject2).jdField_b_of_type_JavaUtilArrayList.get(((Sentence)localObject2).jdField_b_of_type_JavaUtilArrayList.size() - 1);
      float f = (float)(paramLong - ((Character)localObject1).jdField_a_of_type_Long) / (float)((Character)localObject1).jdField_b_of_type_Long;
      return (((Character)localObject1).jdField_a_of_type_Int + f) / ((Character)localObject2).jdField_b_of_type_Int;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("error, sentence = ");
    ((StringBuilder)localObject1).append(localObject2);
    QLog.i("KSongView", 2, ((StringBuilder)localObject1).toString());
    return 0.0F;
  }
  
  private KSHelper.Config a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("KSongView", 2, "error! config path wrong...");
      return null;
    }
    try
    {
      paramString = QWalletTools.b(paramString);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("config_content = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("KSongView", 2, ((StringBuilder)localObject).toString());
      if (TextUtils.isEmpty(paramString))
      {
        QLog.i("KSongView", 2, "error! config content wrong...");
        return null;
      }
      paramString = new JSONObject(paramString);
      localObject = new KSHelper.Config();
      ((KSHelper.Config)localObject).jdField_a_of_type_JavaLangString = paramString.optString("name");
      ((KSHelper.Config)localObject).jdField_a_of_type_JavaLangString = paramString.optString("singer");
      ((KSHelper.Config)localObject).jdField_a_of_type_Long = paramString.optLong("time");
      ((KSHelper.Config)localObject).jdField_b_of_type_JavaLangString = paramString.optString("ksongId");
      paramString = paramString.optJSONObject("qrcConfig");
      if (paramString == null) {
        return null;
      }
      ((KSHelper.Config)localObject).jdField_b_of_type_Long = paramString.optLong("start", 0L);
      ((KSHelper.Config)localObject).c = paramString.optLong("end", 0L);
      ((KSHelper.Config)localObject).d = paramString.optLong("pretime", 0L);
      ((KSHelper.Config)localObject).e = paramString.optLong("total", 0L);
      if ((0L < ((KSHelper.Config)localObject).jdField_b_of_type_Long) && (0L < ((KSHelper.Config)localObject).c) && (0L < ((KSHelper.Config)localObject).d) && (0L < ((KSHelper.Config)localObject).e))
      {
        paramString = (String)localObject;
        if (((KSHelper.Config)localObject).jdField_b_of_type_Long < ((KSHelper.Config)localObject).c) {}
      }
      else
      {
        QLog.i("KSongView", 2, "error! config is wrong...");
        paramString = null;
      }
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -1);
    Object localObject1 = new LinearLayout.LayoutParams(-1, -1);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    this.jdField_b_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongTextView = new KSongTextView(paramContext);
    this.jdField_b_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongTextView.setText("● ● ● ● ●");
    this.jdField_b_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongTextView.setTextSize(2, 15.0F);
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).gravity = 1;
    this.jdField_b_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongTextView.setVisibility(4);
    localLinearLayout.addView(this.jdField_b_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongTextView, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ListView(paramContext);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)localObject2);
    localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetListView.setVerticalScrollBarEnabled(false);
    addView(localLinearLayout, paramAttributeSet);
    localObject1 = new LinearLayout(paramContext);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setBackgroundResource(R.drawable.r);
    ((LinearLayout)localObject1).setClickable(true);
    addView((View)localObject1, paramAttributeSet);
    paramAttributeSet = this.jdField_a_of_type_AndroidWidgetListView;
    localObject1 = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = ((List)localObject1);
    paramContext = new QwAdapter(paramContext, (List)localObject1, R.layout.e, new KSongView.LrcHolder(this));
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
    paramLong = paramLong + this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$Config.jdField_b_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$Config.d;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$KListener;
    if (localObject != null) {
      ((KSHelper.KListener)localObject).a(paramLong);
    }
    localObject = (Sentence)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int);
    long l = ((Sentence)localObject).jdField_a_of_type_Long + ((Sentence)localObject).jdField_b_of_type_Long;
    b(paramLong);
    if (paramLong > l)
    {
      if (l >= this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$Config.c)
      {
        QLog.i("KSongView", 2, "play over, no scroll...");
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scroll to next line = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(" duration = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("KSongView", 2, ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_AndroidWidgetListView;
      int i = this.jdField_b_of_type_Int + 1;
      this.jdField_b_of_type_Int = i;
      ((ListView)localObject).smoothScrollToPositionFromTop(i, -1, 50);
    }
    return true;
  }
  
  private boolean a(String paramString)
  {
    paramString = QWalletTools.b(paramString);
    Object localObject = LyricParseHelper.a(paramString, true);
    int k = 0;
    if ((localObject != null) && (((Lyric)localObject).a != null))
    {
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= ((Lyric)localObject).a.size()) {
          break;
        }
        paramString = (Sentence)((Lyric)localObject).a.get(i);
        if ((paramString.jdField_a_of_type_Long >= this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$Config.jdField_b_of_type_Long) && (paramString.jdField_a_of_type_Long + paramString.jdField_b_of_type_Long <= this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$Config.c)) {
          this.jdField_a_of_type_JavaUtilList.add(paramString);
        }
        if (paramString.jdField_a_of_type_Long >= this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$Config.c)
        {
          j = k;
          break;
        }
        i += 1;
      }
      while (j < 5)
      {
        this.jdField_a_of_type_JavaUtilList.add(new Sentence());
        j += 1;
      }
      paramString = new StringBuilder();
      paramString.append("list size = ");
      paramString.append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.i("KSongView", 2, paramString.toString());
      return true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("error, parse Qrc fail, qrc = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("KSongView", 2, ((StringBuilder)localObject).toString());
    return false;
  }
  
  private void b(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetListView.getChildAt(0);
    if (localObject == null)
    {
      QLog.i("KSongView", 2, "update sentence v is null...");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongTextView = ((KSongTextView)((View)localObject).findViewById(R.id.br));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("index line = ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    QLog.i("KSongView", 2, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongTextView != null)
    {
      float f = a(this.jdField_b_of_type_Int, paramLong);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("show text color rate = ");
      ((StringBuilder)localObject).append(f);
      QLog.i("KSongView", 2, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongTextView.a(f, 15, -1);
    }
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
  
  public KSHelper.Config a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$Config;
  }
  
  public void a()
  {
    QLog.i("KSongView", 2, "start reset...");
    this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.notifyDataSetChanged();
    Object localObject = this.jdField_a_of_type_AndroidWidgetListView;
    this.jdField_b_of_type_Int = 0;
    ((ListView)localObject).setSelection(0);
    localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongProsBar;
    if (localObject != null) {
      ((KSongProsBar)localObject).a(0L);
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView$KHandler.removeMessages(0);
    if (this.jdField_a_of_type_Int > 0) {
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void a(long paramLong)
  {
    KSongProsBar localKSongProsBar = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongProsBar;
    if (localKSongProsBar != null) {
      localKSongProsBar.a(paramLong);
    }
  }
  
  public void a(String paramString1, String paramString2, KSongProsBar paramKSongProsBar, KSHelper.KListener paramKListener)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongProsBar = paramKSongProsBar;
      setKListener(paramKListener);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView$KHandler = new KSongView.KHandler(this);
      new KSongView.InitTask(this).execute(new String[] { paramString1, paramString2 });
      return;
    }
    QLog.i("KSongView", 2, "error! need thinds is null...");
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_Int >= 0)
      {
        if (this.jdField_a_of_type_Int == 1)
        {
          QLog.i("KSongView", 2, "error, the playing is going...");
          return;
        }
        if (this.jdField_a_of_type_Int == 2)
        {
          this.jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView$KHandler.sendEmptyMessage(0);
          this.jdField_b_of_type_Long += System.currentTimeMillis() - this.c;
          return;
        }
        QLog.i("KSongView", 2, "start playing...");
        if (this.jdField_a_of_type_Int == 3) {
          a();
        }
        this.jdField_a_of_type_Int = 1;
        this.jdField_b_of_type_Long = 0L;
        KSongTextView localKSongTextView = this.jdField_b_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongTextView;
        int i;
        if (paramBoolean) {
          i = 0;
        } else {
          i = getResources().getColor(R.color.c);
        }
        localKSongTextView.a(i, 0);
        this.jdField_b_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongTextView.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$Config.d, null);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView$KHandler.sendEmptyMessage(0);
        return;
      }
      throw new RuntimeException("error! lyric object not initialized...");
    }
    finally {}
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView$KHandler.removeMessages(0);
      this.c = System.currentTimeMillis();
    }
  }
  
  public void c()
  {
    KSongView.KHandler localKHandler = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSongView$KHandler;
    if (localKHandler != null) {
      localKHandler.removeMessages(0);
    }
    if (this.jdField_a_of_type_Int > 0) {
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void setKListener(KSHelper.KListener paramKListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$KListener = paramKListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongView
 * JD-Core Version:    0.7.0.1
 */