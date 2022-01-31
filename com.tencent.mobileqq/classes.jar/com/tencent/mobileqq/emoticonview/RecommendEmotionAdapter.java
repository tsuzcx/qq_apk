package com.tencent.mobileqq.emoticonview;

import acor;
import acos;
import acot;
import acou;
import acov;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.TaskStatus;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.ClubContentJsonTask.PromotionEmoticonPkg;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class RecommendEmotionAdapter
  extends EmotionNeedDownloadAdapter
  implements Handler.Callback, View.OnClickListener
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private EmoticonManager jdField_a_of_type_ComTencentMobileqqModelEmoticonManager;
  public VasQuickUpdateManager.CallBacker a;
  public ProgressButton a;
  public Object a;
  public ArrayList a;
  public AtomicBoolean a;
  public MqqHandler a;
  public boolean a;
  public ArrayList b;
  protected List b;
  boolean b;
  protected List c;
  private boolean c;
  private List d;
  private List e;
  protected int f;
  private final int g = 2;
  private int i;
  
  public RecommendEmotionAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback, int paramInt4, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new acou(this);
    this.i = paramInt4;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.e = new ArrayList();
    this.f = (this.jdField_d_of_type_Int / paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)paramQQAppInterface.getManager(13));
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
    this.jdField_c_of_type_Boolean = paramQQAppInterface.getBoolean("recommemd_red_effect", false);
    this.jdField_a_of_type_Boolean = paramQQAppInterface.getBoolean("is_red_when_click_recommend", false);
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  private ImageView a(ClubContentJsonTask.PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    if ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() < 1) || (paramPromotionEmoticonPkg == null) || (TextUtils.isEmpty(paramPromotionEmoticonPkg.a)))
    {
      QLog.e("RecommendEmotionAdapter", 1, "getRedPointViewByEp view or ep error");
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "getRedPointViewByEp");
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ImageView localImageView = (ImageView)localIterator.next();
      ClubContentJsonTask.PromotionEmoticonPkg localPromotionEmoticonPkg = a(localImageView);
      if ((localPromotionEmoticonPkg != null) && (paramPromotionEmoticonPkg.a.equals(localPromotionEmoticonPkg.a))) {
        return localImageView;
      }
    }
    return null;
  }
  
  private LinearLayout a()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new LinearLayout.LayoutParams(this.f, (int)(148.0F * this.jdField_a_of_type_Float));
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(85.0F * this.jdField_a_of_type_Float), (int)(85.0F * this.jdField_a_of_type_Float));
    localLayoutParams.gravity = 1;
    ((RelativeLayout)localObject1).setId(2131362228);
    Object localObject2 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((URLImageView)localObject2).setId(2131372322);
    ((URLImageView)localObject2).setAdjustViewBounds(true);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    localObject2 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((URLImageView)localObject2).setId(2131372323);
    ((URLImageView)localObject2).setAdjustViewBounds(true);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject2).setId(2131362229);
    localLayoutParams1.addRule(10, -1);
    localLayoutParams1.addRule(11, -1);
    ((ImageView)localObject2).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846133));
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject1).setId(2131372324);
    localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(18.0F * this.jdField_a_of_type_Float));
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = ((int)(this.jdField_a_of_type_Float * 10.0F));
    ((TextView)localObject1).setTextSize(15.0F);
    ((TextView)localObject1).setTextColor(-16777216);
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setMaxLines(1);
    ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    localObject1 = new ProgressButton(this.jdField_a_of_type_AndroidContentContext);
    ((ProgressButton)localObject1).setId(2131372325);
    localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(25.0F * this.jdField_a_of_type_Float));
    localLayoutParams.topMargin = ((int)(this.jdField_a_of_type_Float * 10.0F));
    localLayoutParams.gravity = 1;
    ((ProgressButton)localObject1).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838526));
    ((ProgressButton)localObject1).setTextColor(-14894864);
    ((ProgressButton)localObject1).setPadding((int)(this.jdField_a_of_type_Float * 15.0F), 0, (int)(this.jdField_a_of_type_Float * 15.0F), 0);
    ((ProgressButton)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    ((ProgressButton)localObject1).setTextSize(13.0F);
    ((ProgressButton)localObject1).setGravity(17);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    return localLinearLayout;
  }
  
  private ClubContentJsonTask.PromotionEmoticonPkg a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      paramView = paramView.getTag();
    } while (paramView == null);
    if ((paramView instanceof ClubContentJsonTask.PromotionEmoticonPkg)) {}
    for (paramView = (ClubContentJsonTask.PromotionEmoticonPkg)paramView;; paramView = null) {
      return paramView;
    }
  }
  
  private ProgressButton a(EmoticonPackage paramEmoticonPackage)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() < 1) || (paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId)))
    {
      QLog.e("RecommendEmotionAdapter", 1, "getProgressButton view or ep error");
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ProgressButton localProgressButton = (ProgressButton)localIterator.next();
      ClubContentJsonTask.PromotionEmoticonPkg localPromotionEmoticonPkg = a(localProgressButton);
      if ((localPromotionEmoticonPkg != null) && (paramEmoticonPackage.epId.equals(localPromotionEmoticonPkg.a))) {
        return localProgressButton;
      }
    }
    return null;
  }
  
  private void a(View paramView, ClubContentJsonTask.PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    if ((paramView == null) || (paramPromotionEmoticonPkg == null)) {
      return;
    }
    int j;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager != null)
    {
      if (!a()) {
        break label750;
      }
      if (!this.e.contains(paramPromotionEmoticonPkg))
      {
        this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(paramPromotionEmoticonPkg);
        j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
        int k = this.jdField_a_of_type_JavaUtilList.indexOf(paramPromotionEmoticonPkg);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
        localObject3 = paramPromotionEmoticonPkg.a;
        String str = k + 1 + "";
        if (!this.jdField_a_of_type_Boolean) {
          break label742;
        }
        localObject1 = "1";
        VasWebviewUtil.reportCommercialDrainage((String)localObject2, "ep_mall", "aioshow", "", 0, 0, 0, "", (String)localObject3, str, (String)localObject1, "", j + "", "", 0, 0, 0, 0);
        this.e.add(paramPromotionEmoticonPkg);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "updateUI epid = " + paramPromotionEmoticonPkg.a + "expose num = " + paramPromotionEmoticonPkg.s);
      }
      paramView.setVisibility(0);
      try
      {
        localObject1 = (URLImageView)paramView.findViewById(2131372322);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844025);
        localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844026);
        ((URLImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(paramPromotionEmoticonPkg.b, (Drawable)localObject2, (Drawable)localObject3));
        ((URLImageView)localObject1).setTag(paramPromotionEmoticonPkg);
        ((URLImageView)localObject1).setOnClickListener(this);
        ((TextView)paramView.findViewById(2131372324)).setText(paramPromotionEmoticonPkg.c);
        ((URLImageView)localObject1).setContentDescription(paramPromotionEmoticonPkg.c);
        localObject1 = (ProgressButton)paramView.findViewById(2131372325);
        ((ProgressButton)localObject1).setText(paramPromotionEmoticonPkg.d);
        ((ProgressButton)localObject1).setTag(paramPromotionEmoticonPkg);
        ((ProgressButton)localObject1).setContentDescription(paramPromotionEmoticonPkg.d);
        ((ProgressButton)localObject1).setOnClickListener(this);
        ((ProgressButton)localObject1).setProgressColor(-16745986);
        if ((this.jdField_b_of_type_JavaUtilList != null) && (!this.jdField_b_of_type_JavaUtilList.contains(localObject1))) {
          this.jdField_b_of_type_JavaUtilList.add(localObject1);
        }
        localObject2 = (URLImageView)paramView.findViewById(2131372323);
        ((URLImageView)localObject2).setImageDrawable(null);
        ((URLImageView)localObject2).setVisibility(8);
        localObject2 = (ImageView)paramView.findViewById(2131362229);
        ((ImageView)localObject2).setVisibility(8);
        ((ImageView)localObject2).setTag(paramPromotionEmoticonPkg);
        if (paramPromotionEmoticonPkg.r == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect mNeedShowRedEffect:" + this.jdField_c_of_type_Boolean + ", id:" + paramPromotionEmoticonPkg.a);
          }
          j = this.jdField_a_of_type_JavaUtilList.indexOf(paramPromotionEmoticonPkg);
          if ((this.jdField_c_of_type_Boolean) && (j < 2) && ((this.jdField_a_of_type_JavaUtilArrayList == null) || ((this.jdField_a_of_type_JavaUtilArrayList.size() < 2) && (this.jdField_a_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(j)) < 0))))
          {
            localObject3 = new acov(this);
            ((acov)localObject3).jdField_a_of_type_AndroidViewView = paramView;
            ((acov)localObject3).jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PromotionEmoticonPkg = paramPromotionEmoticonPkg;
            ((acov)localObject3).jdField_a_of_type_Int = j;
            ThreadManager.post(new acor(this, (acov)localObject3), 8, null, true);
          }
        }
        if ((this.jdField_c_of_type_JavaUtilList != null) && (!this.jdField_c_of_type_JavaUtilList.contains(localObject2))) {
          this.jdField_c_of_type_JavaUtilList.add(localObject2);
        }
        float f1 = ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(paramPromotionEmoticonPkg.a);
        if (f1 < 0.0F) {
          break label777;
        }
        ((ProgressButton)localObject1).setProgress((int)f1);
        ((ProgressButton)localObject1).setText("取消");
        return;
      }
      catch (OutOfMemoryError paramView)
      {
        QLog.e("RecommendEmotionAdapter", 1, "updateUI oom e = " + paramView);
        return;
      }
      label742:
      localObject1 = "";
      break;
      label750:
      if (!this.jdField_d_of_type_JavaUtilList.contains(paramPromotionEmoticonPkg)) {
        this.jdField_d_of_type_JavaUtilList.add(paramPromotionEmoticonPkg);
      }
    }
    label777:
    ((ProgressButton)localObject1).setText(paramPromotionEmoticonPkg.d);
    ((ProgressButton)localObject1).setProgress(0);
  }
  
  private void a(ClubContentJsonTask.PromotionEmoticonPkg paramPromotionEmoticonPkg, int paramInt)
  {
    boolean bool = true;
    Intent localIntent1 = null;
    if (paramPromotionEmoticonPkg.n == 4)
    {
      localIntent1 = new Intent();
      localIntent1.putExtra("EXTRA_KEY_IS_SMALL_EMOTICON", true);
    }
    Intent localIntent2;
    if (paramInt == 1)
    {
      localIntent2 = localIntent1;
      if (localIntent1 == null) {
        localIntent2 = new Intent();
      }
      localIntent2.putExtra("EXTRA_KEY_IS_KANDIAN_EMOTICON", true);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        if (paramPromotionEmoticonPkg.n == 4) {}
        for (;;)
        {
          EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, paramPromotionEmoticonPkg.a, false, localIntent2, bool);
          return;
          bool = false;
        }
      }
      QLog.e("RecommendEmotionAdapter", 1, "openEmoticonDetailPage error : context not activity");
      return;
      localIntent2 = localIntent1;
    }
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (EmotionPanelConstans.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo) == this.jdField_c_of_type_Int) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(ClubContentJsonTask.PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    return ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(paramPromotionEmoticonPkg.a) >= 0.0F;
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
    ((SharedPreferences)localObject).edit().putBoolean("isClickRecommendRedpoint", true).commit();
    int j = ((SharedPreferences)localObject).getInt("recommendRuleId", -1);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    if (this.jdField_a_of_type_Boolean) {}
    for (localObject = "1";; localObject = "")
    {
      VasWebviewUtil.reportCommercialDrainage(str, "ep_mall", "PageView", "", 0, 0, 0, "", "", "", (String)localObject, "", j + "", "", 0, 0, 0, 0);
      EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.i);
      return;
    }
  }
  
  public View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    System.currentTimeMillis();
    paramViewGroup = (RecommendEmotionAdapter.RecommendEmotionViewHolder)paramViewHolder;
    paramViewHolder = paramView;
    int j;
    if (paramView == null)
    {
      paramView = EmotionPanelViewPool.a().a(this.jdField_c_of_type_Int);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecommendEmotionAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        j = 0;
      }
    }
    for (;;)
    {
      paramViewHolder = paramView;
      if (j < this.jdField_a_of_type_Int)
      {
        try
        {
          paramViewHolder = a();
          paramViewHolder.setVisibility(8);
          localObject = new LinearLayout.LayoutParams(this.f, -1);
          if (paramInt == 0) {}
          for (((LinearLayout.LayoutParams)localObject).topMargin = ((int)(22.0F * this.jdField_a_of_type_Float));; ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(20.0F * this.jdField_a_of_type_Float)))
          {
            paramView.addView(paramViewHolder, (ViewGroup.LayoutParams)localObject);
            break;
          }
          paramViewHolder = paramView;
        }
        catch (Exception paramViewHolder)
        {
          QLog.e("RecommendEmotionAdapter", 1, "getEmotionView ; position = " + paramInt + "; has exception ,e = " + paramViewHolder.getMessage());
          paramView = null;
          return paramView;
        }
        catch (OutOfMemoryError paramViewHolder)
        {
          QLog.e("RecommendEmotionAdapter", 1, "getEmotionView oom");
        }
        if (QLog.isColorLevel())
        {
          QLog.d("RecommendEmotionAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
          paramViewHolder = paramView;
        }
      }
      a(this.jdField_c_of_type_Int, paramViewHolder);
      paramView = (ViewGroup)paramViewHolder;
      paramViewGroup.a = new LinearLayout[this.jdField_a_of_type_Int];
      j = 0;
      while (j < this.jdField_a_of_type_Int)
      {
        paramViewGroup.a[j] = ((LinearLayout)paramView.getChildAt(j));
        j += 1;
      }
      paramViewHolder.setTag(paramViewGroup);
      j = 0;
      int k;
      for (;;)
      {
        paramView = paramViewHolder;
        if (j >= this.jdField_a_of_type_Int) {
          break;
        }
        k = this.jdField_a_of_type_Int * paramInt + j;
        if (k <= this.jdField_a_of_type_JavaUtilList.size() - 1) {
          break label427;
        }
        paramViewGroup.a[j].setTag(null);
        paramViewGroup.a[j].setVisibility(8);
        j += 1;
      }
      label427:
      Object localObject = paramViewGroup.a[j];
      paramView = (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(k);
      if ((paramView instanceof ClubContentJsonTask.PromotionEmoticonPkg)) {}
      for (paramView = (ClubContentJsonTask.PromotionEmoticonPkg)paramView;; paramView = null)
      {
        a((View)localObject, paramView);
        if (paramView == null) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, paramView.a, paramInt + "", "", paramView.r + "");
        break;
      }
      j += 1;
    }
  }
  
  public BaseEmotionAdapter.ViewHolder a()
  {
    return new RecommendEmotionAdapter.RecommendEmotionViewHolder();
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList = null;
    }
    if (this.jdField_c_of_type_JavaUtilList != null)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_c_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(183)).b(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 17)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "paback");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton == null) {
        QLog.e("RecommendEmotionAdapter", 1, "payBack view is null");
      }
    }
    else
    {
      return;
    }
    ClubContentJsonTask.PromotionEmoticonPkg localPromotionEmoticonPkg = a(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton);
    if (localPromotionEmoticonPkg == null)
    {
      QLog.e("RecommendEmotionAdapter", 1, "payBack pkg is null");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800613B", 0, 0, localPromotionEmoticonPkg.a, "", "", "0");
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton, localPromotionEmoticonPkg, true, this.i);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramInt != 0) || (paramEmoticonPackage == null)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = paramEmoticonPackage;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 100;
    localMessage.obj = paramEmoticonPackage;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(ProgressButton paramProgressButton, ClubContentJsonTask.PromotionEmoticonPkg paramPromotionEmoticonPkg, boolean paramBoolean, int paramInt)
  {
    if ((paramProgressButton == null) || (paramPromotionEmoticonPkg == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "downloadOrPay epid = " + paramPromotionEmoticonPkg.a);
    }
    if ((paramPromotionEmoticonPkg.o == 2) || (paramPromotionEmoticonPkg.o == 6))
    {
      a(paramPromotionEmoticonPkg, paramInt);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800613D", 0, 0, paramPromotionEmoticonPkg.a, "", "", paramPromotionEmoticonPkg.r + "");
      paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
      int j = this.jdField_a_of_type_JavaUtilList.indexOf(paramPromotionEmoticonPkg);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      paramPromotionEmoticonPkg = paramPromotionEmoticonPkg.a;
      String str = j + 1 + "";
      if (this.jdField_a_of_type_Boolean) {}
      for (paramProgressButton = "1";; paramProgressButton = "")
      {
        VasWebviewUtil.reportCommercialDrainage((String)localObject, "ep_mall", "0X800613D", "", 0, 0, 0, "", paramPromotionEmoticonPkg, str, paramProgressButton, "", paramInt + "", "", 0, 0, 0, 0);
        return;
      }
    }
    Object localObject = (EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
    ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramPromotionEmoticonPkg.a, -1, new acos(this, paramPromotionEmoticonPkg, paramBoolean, (EmojiManager)localObject, paramProgressButton, paramInt));
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "refreshPanelData");
    }
    EmotionPanelDataBuilder.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Int, null, -1, 0, false, new acot(this));
  }
  
  public void c()
  {
    Object localObject;
    if (this.i == 0)
    {
      d();
      if (this.jdField_d_of_type_JavaUtilList.size() <= 0) {
        break label126;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "onAdapterSelected invisiableExposeList size > 0");
      }
      localObject = this.jdField_d_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ClubContentJsonTask.PromotionEmoticonPkg localPromotionEmoticonPkg = (ClubContentJsonTask.PromotionEmoticonPkg)((Iterator)localObject).next();
        if (!this.e.contains(localPromotionEmoticonPkg))
        {
          this.e.add(localPromotionEmoticonPkg);
          if (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager != null) {
            this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(localPromotionEmoticonPkg);
          }
        }
      }
      this.jdField_d_of_type_JavaUtilList.clear();
    }
    label387:
    label390:
    for (;;)
    {
      return;
      label126:
      localObject = a();
      if (localObject != null)
      {
        int j = ((ListView)localObject).getFirstVisiblePosition();
        int k = ((ListView)localObject).getLastVisiblePosition();
        if (QLog.isColorLevel()) {
          QLog.d("RecommendEmotionAdapter", 2, "onAdapterSelected firstShowPosition = " + j + ";lastShowPosition = " + k);
        }
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          this.e.clear();
          j = this.jdField_a_of_type_Int * j;
          int n = this.jdField_a_of_type_Int * (k + 1) - 1;
          if (QLog.isColorLevel()) {
            QLog.d("RecommendEmotionAdapter", 2, "onAdapterSelected firstDataPosition = " + j + ";lastDataPosition = " + n);
          }
          if (j <= n)
          {
            k = 1;
            label277:
            if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
              break label387;
            }
          }
          for (int m = 1;; m = 0)
          {
            if ((k & m) == 0) {
              break label390;
            }
            localObject = (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(j);
            if ((localObject != null) && ((localObject instanceof ClubContentJsonTask.PromotionEmoticonPkg)))
            {
              localObject = (ClubContentJsonTask.PromotionEmoticonPkg)localObject;
              if (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager != null) {
                this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a((ClubContentJsonTask.PromotionEmoticonPkg)localObject);
              }
              if (!this.e.contains(localObject)) {
                this.e.add(localObject);
              }
            }
            j += 1;
            break;
            k = 0;
            break label277;
          }
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = (EmoticonPackage)paramMessage.obj;
      if (paramMessage == null) {
        return true;
      }
      Object localObject1 = a(paramMessage);
      if (localObject1 == null) {
        return true;
      }
      Object localObject2 = EmojiManager.a(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime(), paramMessage.epId);
      if (localObject2 == null) {
        return true;
      }
      int j = (int)((TaskStatus)localObject2).a();
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "handleMessage refreashProgress epid = " + paramMessage.epId + ";progress = " + j);
      }
      if (j == 100) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X800581C", 0, 0, paramMessage.epId, "", "", "");
      }
      ((ProgressButton)localObject1).setProgress(j);
      ((ProgressButton)localObject1).setProgressColor(-16745986);
      continue;
      paramMessage = (EmoticonPackage)paramMessage.obj;
      if (paramMessage == null) {
        return true;
      }
      paramMessage = a(paramMessage);
      if (paramMessage == null) {
        return true;
      }
      localObject1 = a(paramMessage);
      if (localObject1 == null) {
        return true;
      }
      paramMessage.setProgress(0);
      paramMessage.setText(((ClubContentJsonTask.PromotionEmoticonPkg)localObject1).d);
      b();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005816", 0, 1, ((ClubContentJsonTask.PromotionEmoticonPkg)localObject1).a, "", "", "");
      continue;
      if ((paramMessage.obj instanceof acov))
      {
        paramMessage = (acov)paramMessage.obj;
        if ((paramMessage == null) || (paramMessage.jdField_a_of_type_Boolean)) {
          return true;
        }
        paramMessage.jdField_a_of_type_Boolean = true;
        if ((paramMessage.jdField_a_of_type_AndroidViewView == null) || (paramMessage.jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PromotionEmoticonPkg == null) || (paramMessage.jdField_a_of_type_JavaIoFile == null) || (paramMessage.jdField_a_of_type_AndroidViewView.getVisibility() != 0)) {
          return true;
        }
        if (((URLImageView)paramMessage.jdField_a_of_type_AndroidViewView.findViewById(2131372322)).getTag() != paramMessage.jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$PromotionEmoticonPkg) {
          return true;
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && ((this.jdField_a_of_type_JavaUtilArrayList.size() >= 2) || (this.jdField_a_of_type_JavaUtilArrayList.indexOf(Integer.valueOf(paramMessage.jdField_a_of_type_Int)) >= 0))) {
          return true;
        }
        localObject1 = paramMessage.jdField_a_of_type_JavaIoFile.getAbsolutePath();
        try
        {
          localObject1 = new URL("vasapngdownloader", (String)localObject1, "local_recommendEffect");
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
          {
            localObject2 = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject2);
          }
          localObject2 = (URLImageView)paramMessage.jdField_a_of_type_AndroidViewView.findViewById(2131372323);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mUseApngImage = true;
          j = (int)(85.0F * this.jdField_a_of_type_Float);
          localURLDrawableOptions.mRequestHeight = j;
          localURLDrawableOptions.mRequestWidth = j;
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_loop", 1);
          localBundle.putBoolean("key_once_clear", true);
          localBundle.putLong("bundle_key_bid", 1003L);
          localBundle.putString("bundle_key_scid", "emotionRecommendEffect");
          localURLDrawableOptions.mExtraInfo = localBundle;
          localObject1 = URLDrawable.getDrawable((URL)localObject1, localURLDrawableOptions);
          ((URLImageView)localObject2).setVisibility(0);
          ((URLImageView)localObject2).setImageDrawable((Drawable)localObject1);
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramMessage.jdField_a_of_type_Int));
          if (this.jdField_c_of_type_Boolean)
          {
            this.jdField_c_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("recommemd_red_effect", false).commit();
          }
        }
        catch (Exception paramMessage)
        {
          QLog.e("RecommendEmotionAdapter", 1, "MSG_SHOW_RECOMMEND_EFFECT err:" + paramMessage.toString());
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    ClubContentJsonTask.PromotionEmoticonPkg localPromotionEmoticonPkg = a(paramView);
    if (localPromotionEmoticonPkg == null) {}
    ImageView localImageView;
    do
    {
      do
      {
        return;
        localImageView = a(localPromotionEmoticonPkg);
        if ((paramView instanceof URLImageView))
        {
          int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
          int k = this.jdField_a_of_type_JavaUtilList.indexOf(localPromotionEmoticonPkg);
          String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
          String str2 = localPromotionEmoticonPkg.a;
          String str3 = k + 1 + "";
          if (this.jdField_a_of_type_Boolean) {}
          for (paramView = "1";; paramView = "")
          {
            VasWebviewUtil.reportCommercialDrainage(str1, "ep_mall", "0X80065DD", "", 0, 0, 0, "", str2, str3, paramView, "", j + "", "", 0, 0, 0, 0);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80065DD", 0, 0, localPromotionEmoticonPkg.a, "", "", localPromotionEmoticonPkg.r + "");
            a(localPromotionEmoticonPkg, this.i);
            if ((localImageView == null) || (localImageView.getVisibility() != 0)) {
              break;
            }
            localImageView.setVisibility(8);
            localPromotionEmoticonPkg.r = 0;
            this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.d(localPromotionEmoticonPkg.a, this.i);
            return;
          }
        }
      } while (!(paramView instanceof ProgressButton));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005814", 0, 0, localPromotionEmoticonPkg.a, "", "", localPromotionEmoticonPkg.r + "");
      a((ProgressButton)paramView, localPromotionEmoticonPkg, false, this.i);
    } while ((localImageView == null) || (localImageView.getVisibility() != 0));
    localImageView.setVisibility(8);
    localPromotionEmoticonPkg.r = 0;
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.d(localPromotionEmoticonPkg.a, this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */