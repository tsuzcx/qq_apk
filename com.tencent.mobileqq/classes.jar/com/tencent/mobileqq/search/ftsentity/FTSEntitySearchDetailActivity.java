package com.tencent.mobileqq.search.ftsentity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class FTSEntitySearchDetailActivity
  extends IphoneTitleBarActivity
{
  private static List<FTSEntity> a;
  public int a;
  private List<FTSEntity> b;
  
  public static void a(Context paramContext, String paramString1, String paramString2, CharSequence paramCharSequence, List<? extends FTSEntity> paramList, int paramInt1, String paramString3, int paramInt2)
  {
    jdField_a_of_type_JavaUtilList = paramList;
    paramList = new Intent(paramContext, FTSEntitySearchDetailActivity.class);
    paramList.putExtra("original_keyword", paramString1);
    paramList.putExtra("segment_keyword", paramString2);
    paramList.putExtra("title", paramCharSequence);
    paramList.putExtra("extra_key_fts_type", paramInt1);
    paramList.putExtra("uin", paramString3);
    paramList.putExtra("uinType", paramInt2);
    paramContext.startActivity(paramList);
  }
  
  void a(String paramString1, String paramString2, TextView paramTextView)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "genDiscussTitle, name == null");
      }
      return;
    }
    int i = ((DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString2);
    if (i <= 0)
    {
      paramTextView.setText(paramString1);
      return;
    }
    int j = getResources().getDisplayMetrics().widthPixels;
    paramString2 = (RelativeLayout.LayoutParams)((View)paramTextView.getParent()).getLayoutParams();
    int k = AIOUtils.b(207.0F, getResources());
    TextPaint localTextPaint = paramTextView.getPaint();
    float f1 = j - k - localTextPaint.measureText(String.format("(%d人)", new Object[] { Integer.valueOf(i) })) - getResources().getDisplayMetrics().density * 4.0F;
    String str = paramString1;
    if (f1 > 0.0F)
    {
      float f2 = localTextPaint.measureText(paramString1);
      str = paramString1;
      if (f2 > f1)
      {
        float f3 = f1 - localTextPaint.measureText("…");
        paramString2 = paramString1;
        while ((f3 > 0.0F) && (f2 > f3) && (paramString2.length() > 0))
        {
          str = paramString2.substring(0, paramString2.length() - 1);
          f2 = localTextPaint.measureText(str);
          f1 = f2;
          if (f2 == 0.0F)
          {
            f1 = f2;
            if (str.length() > 0) {
              f1 = 1.0F + f3;
            }
          }
          f2 = f1;
          paramString2 = str;
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("genDiscussTitle : name widht = ");
            paramString2.append(f1);
            QLog.d("IphoneTitleBarActivity", 2, paramString2.toString());
            f2 = f1;
            paramString2 = str;
          }
        }
        str = paramString1;
        if (f3 > 0.0F)
        {
          str = paramString1;
          if (paramString2.length() > 0)
          {
            paramString1 = new StringBuilder();
            paramString1.append(paramString2);
            paramString1.append("…");
            str = paramString1.toString();
          }
        }
      }
    }
    paramTextView.setText(String.format("%s(%d人)", new Object[] { str, Integer.valueOf(i) }));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.b = jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_Int = getIntent().getIntExtra("extra_key_fts_type", 0);
    setContentView(2131558898);
    paramBundle = getIntent().getStringExtra("uin");
    int i = getIntent().getIntExtra("uinType", -1);
    if (i == 3000) {
      a(ContactUtils.a(this.app, paramBundle, i), paramBundle, this.centerView);
    } else {
      super.setTitle(ContactUtils.a(this.app, paramBundle, i));
    }
    Object localObject = super.getSupportFragmentManager();
    paramBundle = FTSEntitySearchDetailFragment.a(getIntent().getStringExtra("original_keyword"), getIntent().getStringExtra("segment_keyword"), this.b);
    localObject = ((FragmentManager)localObject).beginTransaction();
    ((FragmentTransaction)localObject).replace(2131365183, paramBundle);
    ((FragmentTransaction)localObject).commit();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_a_of_type_JavaUtilList = null;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity
 * JD-Core Version:    0.7.0.1
 */